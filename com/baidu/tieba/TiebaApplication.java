package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.baidu.account.AccountProxy;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.PvThread;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.service.SingleBaUtility;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.FaceHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.SDRamImage;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UExceptionHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TiebaApplication extends Application {
    private static final String ACCESS_TOKEN = "access_token";
    private static final long ACCESS_TOKEN_MAX_TIME = 2505600000L;
    private static final String ACCESS_TOKEN_MODIFY_TIME = "access_token_motify_time";
    public static final String ACTION_RESPONSE = "com.baidu.push.RESPONSE";
    public static final String API_KEY = "efbGYV7ELR2HpjgsnxwMDvCf";
    private static final String APPUSETIMES = "tdatabaseusetimes";
    public static final int APP_EVENT_LOGIN = 1;
    public static final int APP_PV_STAT = 4;
    public static final int APP_START_MSG_SERVICE = 2;
    public static final int APP_STOP_MSG_SERVICE = 3;
    public static final int BIND_FLAG = 0;
    private static final String BIND_STATE = "bind_state";
    private static final String CLIENT_ID = "client_id";
    private static final String DISPLAY_PHOTO = "display_photo";
    private static final String FROM_ID = "from_id";
    private static final String LAST_VERSION = "lase_version";
    private static final String PERMOTED_MESSAGE = "permoted_message";
    public static final String SECRET_KEY = "e2I50gtYExCFyFWbhaun813ETVAlrG5b";
    private static final String TDATABASECREATETIME = "tdatabasecreatetime";
    public static final int UNBIND_FLAG = 1;
    private static final String UPDATE_NOTIFY_TIME = "update_notify_time";
    public static TiebaApplication app;
    private static AccountData mAccount = null;
    private static String clientId = null;
    private static boolean is_baidu_account_manager = false;
    public static boolean IS_APP_RUNNING = false;
    private int updata_state = 0;
    private HashMap<String, SoftReference<Bitmap>> mFaces = null;
    private boolean mIsDisplayPhoto = true;
    private boolean mLikeChanged = false;
    private SDRamImage mSdramImage = null;
    private String mImei = null;
    private boolean mIsMainProcess = false;
    private int mResumeNum = 0;
    private long mStartTime = 0;
    private int mUploadImageQuality = 2;
    private int mViewImageQuality = 1;
    private boolean mIsShowImages = true;
    private int mFontSize = 3;
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.baidu.tieba.TiebaApplication.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    TiebaLog.e("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(msg.what));
                    if (TiebaApplication.isBaiduAccountManager()) {
                        TiebaApplication.setCurrentAccount(null);
                        MainTabActivity.startActivityOnUserChanged(TiebaApplication.this, null, true);
                        break;
                    } else {
                        Intent intent = new Intent(TiebaApplication.app, LoginActivity.class);
                        Bundle data = msg.getData();
                        String account = data.getString(LoginActivity.ACCOUNT);
                        if (account == null) {
                            account = "";
                        }
                        intent.putExtra(LoginActivity.ACCOUNT, account);
                        intent.putExtra(LoginActivity.HAS_EXIT_DIALOG, false);
                        intent.setFlags(268435456);
                        TiebaApplication.app.startActivity(intent);
                        break;
                    }
                case 2:
                    TiebaApplication.this.startMsgReceive();
                    break;
                case 3:
                    TiebaApplication.this.stopMsgReceive();
                    break;
                case 4:
                    long time = (((System.nanoTime() - TiebaApplication.this.mStartTime) / 1000000) - Config.USE_TIME_INTERVAL) / 1000;
                    if (time > 0) {
                        PvThread pv = new PvThread(Config.ST_TYPE_USE, String.valueOf(time));
                        pv.start();
                    }
                    TiebaApplication.this.mStartTime = 0L;
                    break;
            }
            return false;
        }
    });
    private int mMsgFrequency = 0;
    private boolean mMsgFansOn = Config.MSG_DEFAULT_FANS_SWITCH;
    private boolean mMsgAtmeOn = Config.MSG_DEFAULT_ATME_SWITCH;
    private boolean mMsgReplymeOn = Config.MSG_DEFAULT_REPLYME_SWITCH;
    private boolean mRemindToneOn = Config.MSG_DEFAULT_REMIND_TONE;
    private boolean mPromotedMessageOn = Config.PROMOTED_DEFAULT;
    private long mMsgReplyme = 0;
    private long mMsgAtme = 0;
    private long mMsgFans = 0;
    NotificationManager mNotificationManager = null;

    @Override // android.app.Application
    public void onCreate() {
        app = this;
        NetWorkCore.initNetWorkCore();
        InitVersion();
        InitFrom();
        initAccountManager();
        initSettings();
        clientId = readClientId(this);
        initImei();
        try {
            UExceptionHandler UEHandler = new UExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(UEHandler);
        } catch (SecurityException ex) {
            TiebaLog.e(getClass().getName(), "onCreate", ex.getMessage());
        }
        Uri uri = Uri.parse("content://telephony/carriers");
        getContentResolver().registerContentObserver(uri, true, new ContentObserver(new Handler()) { // from class: com.baidu.tieba.TiebaApplication.2
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                NetWorkCore.initPorxyUser();
            }
        });
        this.mIsMainProcess = isMainProcess();
        if (this.mIsMainProcess) {
            this.mFaces = new HashMap<>();
            mAccount = DatabaseService.getActiveAccountData();
            if (isBaiduAccountManager()) {
                BaiduAccountProxy.initAccount(this);
            }
            DatabaseService.getSettingData();
            this.mSdramImage = new SDRamImage();
            this.mNotificationManager = (NotificationManager) getSystemService("notification");
            PvThread pv = new PvThread(Config.ST_TYPE_OPEN);
            pv.start();
        }
        super.onCreate();
    }

    private void initMessager() {
        new Thread(new Runnable() { // from class: com.baidu.tieba.TiebaApplication.3
            @Override // java.lang.Runnable
            public void run() {
                if (TiebaApplication.app.mPromotedMessageOn) {
                    TiebaApplication.this.requestChangeBind(0);
                } else {
                    TiebaApplication.this.requestChangeBind(1);
                }
            }
        }).start();
    }

    private void initAccountManager() {
        if (Build.VERSION.SDK_INT >= 5) {
            AccountProxy proxy = new AccountProxy(this);
            is_baidu_account_manager = proxy.hasBaiduAccount();
            return;
        }
        is_baidu_account_manager = false;
    }

    public static boolean isBaiduAccountManager() {
        return is_baidu_account_manager;
    }

    private void initImei() {
        TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService("phone");
        if (mTelephonyMgr != null) {
            this.mImei = mTelephonyMgr.getDeviceId();
        }
    }

    public String getImei() {
        return this.mImei;
    }

    private boolean isMainProcess() {
        boolean ret = true;
        ActivityManager am = (ActivityManager) getSystemService("activity");
        if (am == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> list = am.getRunningAppProcesses();
        int pid = Process.myPid();
        if (list != null) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (list.get(i).pid != pid) {
                    i++;
                } else {
                    String name = list.get(i).processName;
                    if ((name != null && name.equalsIgnoreCase("com.baidu.tieba:pushservice_v1")) || name.equalsIgnoreCase("com.baidu.tieba:remote")) {
                        ret = false;
                    }
                }
            }
        }
        return ret;
    }

    private void initSettings() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        this.mUploadImageQuality = preference.getInt(Config.PREFS_IMAGE_QUALITY, 2);
        this.mViewImageQuality = preference.getInt(Config.PREFS_VIEW_IMAGE_QUALITY, 1);
        this.mIsShowImages = preference.getBoolean(Config.PREFS_SHOW_IMAGES, true);
        this.mFontSize = preference.getInt(Config.PREFS_FONT_SIZE, 3);
        this.mPromotedMessageOn = preference.getBoolean(PERMOTED_MESSAGE, true);
    }

    private void InitVersion() {
        try {
            PackageInfo pinfo = getPackageManager().getPackageInfo("com.baidu.tieba", 16384);
            Config.VERSION = pinfo.versionName;
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "InitVersion", e.getMessage());
            Config.VERSION = "";
        }
    }

    private void InitFrom() {
        try {
            String from = getFromByShare();
            if (from == null) {
                String from2 = getFromByFile();
                if (from2 != null && from2.length() > 0) {
                    Config.FROM = from2;
                    saveFromToShare(from2);
                } else {
                    InputStream inputStream = getResources().getAssets().open("channel");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
                    String from3 = reader.readLine();
                    if (from3 != null && from3.length() > 0) {
                        Config.FROM = from3;
                        saveFromToShare(from3);
                        saveFromToFile(from3);
                    }
                }
            } else {
                Config.FROM = from;
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "InitFrom", ex.getMessage());
        }
        TiebaLog.i(getClass().getName(), "InitFrom", "from = " + Config.FROM);
    }

    private String getFromByShare() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        return preference.getString(FROM_ID, null);
    }

    private void saveFromToShare(String from) {
        if (from != null && from.length() > 0) {
            SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
            SharedPreferences.Editor editor = preference.edit();
            editor.putString(FROM_ID, from);
            editor.commit();
        }
    }

    private String getFromByFile() {
        try {
            File file = FileHelper.GetFile(Config.FROM_FILE);
            if (file == null) {
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String from = reader.readLine();
            return from;
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "getFromByFile", ex.getMessage());
            return null;
        }
    }

    private void saveFromToFile(String from) {
        if (from != null && from.length() > 0) {
            try {
                File file = FileHelper.CreateFile(Config.FROM_FILE);
                if (file != null) {
                    FileWriter write = new FileWriter(file);
                    write.append((CharSequence) from);
                    write.flush();
                    write.close();
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "saveFromToFile", ex.getMessage());
            }
        }
    }

    public static String getFrom() {
        return Config.FROM;
    }

    public void onUserChanged() {
        refreshMsg(0L, 0L, 0L);
        DatabaseService.getSettingData();
    }

    public Bitmap getFace(String key) {
        SoftReference<Bitmap> sr = this.mFaces.get(key);
        if (sr != null && sr.get() != null) {
            return sr.get();
        }
        Bitmap bm = FaceHelper.getBitmap(app, key);
        if (bm != null) {
            this.mFaces.put(key, new SoftReference<>(bm));
            return bm;
        }
        return bm;
    }

    public boolean readDisplayPhoto() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        this.mIsDisplayPhoto = preference.getBoolean(DISPLAY_PHOTO, true);
        return this.mIsDisplayPhoto;
    }

    public void setDisplayPhoto(Boolean display) {
        this.mIsDisplayPhoto = display.booleanValue();
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(DISPLAY_PHOTO, display.booleanValue());
        editor.commit();
    }

    public boolean getDisplayPhoto() {
        return this.mIsDisplayPhoto;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public int getTDatabaseVersion() {
        DatabaseService database = new DatabaseService(DatabaseService.DatabaseLocation.SDCARD);
        return database.getVersion();
    }

    public static String getCurrentAccount() {
        if (mAccount != null) {
            return mAccount.getID();
        }
        return null;
    }

    public static void setCurrentAccount(AccountData account) {
        mAccount = account;
    }

    public static String getCurrentBduss() {
        if (mAccount != null) {
            return mAccount.getBDUSS();
        }
        return null;
    }

    public static void setCurrentBduss(String token) {
        if (mAccount != null) {
            mAccount.setBDUSS(token);
        }
    }

    public static void setCurrentAccountName(String account) {
        if (mAccount != null) {
            mAccount.setAccount(account);
        }
    }

    public static void delCurrentBduss() {
        if (mAccount != null) {
            mAccount.setBDUSS("");
        }
    }

    public static AccountData getCurrentAccountObj() {
        return mAccount;
    }

    public static String getCurrentAccountName() {
        if (mAccount != null) {
            return mAccount.getAccount();
        }
        return null;
    }

    public static void setCurrentAccountObj(AccountData data) {
        mAccount = data;
    }

    public int getAPPUseTimes() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        int times = preference.getInt(APPUSETIMES, 0);
        TiebaLog.i("TiebaApplication", "getAPPUseTimes", String.valueOf(times));
        return times;
    }

    public void setAPPUseTimes(int times) {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(APPUSETIMES, times);
        editor.commit();
    }

    public long getTDatabaseCreateTime() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        long time = preference.getLong(TDATABASECREATETIME, 0L);
        TiebaLog.i("TiebaApplication", "getTDatabaseCreateTime", StringHelper.getTimeString(time));
        return time;
    }

    public void setUpdateNotifyTime(long times) {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putLong(UPDATE_NOTIFY_TIME, times);
        editor.commit();
    }

    public long getUpdateNotifyTime() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        return preference.getLong(UPDATE_NOTIFY_TIME, 0L);
    }

    public void resetTDatabaseCreateTime() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        Date date = new Date();
        editor.putLong(TDATABASECREATETIME, date.getTime());
        editor.commit();
    }

    public boolean isInvalidTDatabase() {
        Date date = new Date();
        return getAPPUseTimes() > 50 && date.getTime() - getTDatabaseCreateTime() > Config.APP_DATE_UPDATA_SD_DATABASE;
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public void setTbs(String tbs) {
        if (tbs != null && tbs.length() > 0) {
            synchronized (this) {
                if (mAccount != null) {
                    mAccount.setTbs(tbs);
                }
            }
        }
    }

    public String getTbs() {
        if (mAccount != null) {
            return mAccount.getTbs();
        }
        return null;
    }

    public static String readClientId(Context context) {
        SharedPreferences preference = context.getSharedPreferences(Config.SETTINGFILE, 0);
        String id = preference.getString(CLIENT_ID, null);
        if (id != null) {
            int index = id.indexOf("\t");
            if (index != -1) {
                String version = id.substring(0, index);
                if (Config.VERSION.equals(version)) {
                    id = id.substring(index + 1);
                } else {
                    removeClientId(app);
                    id = null;
                }
            } else {
                removeClientId(app);
                id = null;
            }
        }
        TiebaLog.i("TiebaApplication", "readClientId", id);
        return id;
    }

    public static String getClientId() {
        return clientId;
    }

    public static void removeClientId(Context context) {
        SharedPreferences preference = context.getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(CLIENT_ID);
        editor.commit();
    }

    public static void saveClientId(Context context, String id) {
        if (id != null && id.length() > 0) {
            SharedPreferences preference = context.getSharedPreferences(Config.SETTINGFILE, 0);
            SharedPreferences.Editor editor = preference.edit();
            String _id = String.valueOf(Config.VERSION) + "\t" + id;
            editor.putString(CLIENT_ID, _id);
            editor.commit();
        }
    }

    public static void setClientId(String id) {
        clientId = id;
    }

    public void setLikeChanged(boolean likeChanged) {
        this.mLikeChanged = likeChanged;
    }

    public boolean getLikeChanged() {
        return this.mLikeChanged;
    }

    public void setUpdata_state(int updata_state) {
        this.updata_state = updata_state;
    }

    public int getUpdata_state() {
        return this.updata_state;
    }

    public int getMsgFrequency() {
        return this.mMsgFrequency;
    }

    public void initSetting() {
        setMsgFrequency(Config.MSG_DEFAULT_FREQUENCY);
        setMsgFansOn(true);
        setMsgReplymeOn(true);
        setMsgAtmeOn(true);
    }

    public void setPromotedMessage(boolean promotedTone) {
        this.mPromotedMessageOn = promotedTone;
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(PERMOTED_MESSAGE, promotedTone);
        editor.commit();
    }

    public boolean isPromotedMessageOn() {
        return this.mPromotedMessageOn;
    }

    public void setMsgTone(boolean msgTone) {
        if (this.mRemindToneOn != msgTone) {
            this.mRemindToneOn = msgTone;
        }
    }

    public boolean isMsgToneOn() {
        return this.mRemindToneOn;
    }

    public void setMsgFrequency(int msgFrequency) {
        this.mMsgFrequency = msgFrequency;
        if (msgFrequency == 0) {
            refreshMsg(0L, 0L, 0L);
            this.handler.sendMessage(this.handler.obtainMessage(3));
            return;
        }
        this.handler.sendMessage(this.handler.obtainMessage(2));
    }

    public boolean isMsgFansOn() {
        return this.mMsgFansOn;
    }

    public void setMsgFansOn(boolean mMsgFansOn) {
        this.mMsgFansOn = mMsgFansOn;
        if (!mMsgFansOn) {
            setMsgFans(0L);
        }
    }

    public boolean isMsgAtmeOn() {
        return this.mMsgAtmeOn;
    }

    public void setMsgAtmeOn(boolean msgAtmeOn) {
        this.mMsgAtmeOn = msgAtmeOn;
        if (!msgAtmeOn) {
            setMsgAtme(0L);
        }
    }

    public boolean isMsgReplymeOn() {
        return this.mMsgReplymeOn;
    }

    public void setMsgReplymeOn(boolean msgReplymeOn) {
        this.mMsgReplymeOn = msgReplymeOn;
        if (!msgReplymeOn) {
            setMsgReplyme(0L);
        }
    }

    public boolean isMsgRemindOn() {
        return this.mMsgFrequency > 0 && (this.mMsgReplymeOn || this.mMsgAtmeOn || this.mMsgFansOn);
    }

    public void startMsgReceive() {
        if (app.isMsgRemindOn()) {
            startService(new Intent("com.baidu.tieba.service.Message"));
        }
    }

    public void stopMsgReceive() {
        stopService(new Intent("com.baidu.tieba.service.Message"));
    }

    public long getMsgReplyme() {
        return this.mMsgReplyme;
    }

    public void setMsgReplyme(long l) {
        if (l >= 0) {
            refreshMsg(l, this.mMsgAtme, this.mMsgFans);
        }
    }

    public long getMsgAtme() {
        return this.mMsgAtme;
    }

    public void setMsgAtme(long l) {
        if (l >= 0) {
            refreshMsg(this.mMsgReplyme, l, this.mMsgFans);
        }
    }

    public long getMsgFans() {
        return this.mMsgFans;
    }

    public void setMsgFans(long l) {
        if (l >= 0) {
            refreshMsg(this.mMsgReplyme, this.mMsgAtme, l);
        }
    }

    public long getMsgTotal() {
        return this.mMsgReplyme + this.mMsgAtme + this.mMsgFans;
    }

    public void resetMsg() {
        this.mMsgReplyme = 0L;
        this.mMsgAtme = 0L;
        this.mMsgFans = 0L;
    }

    public int getUploadImageQuality() {
        return this.mUploadImageQuality;
    }

    public int getViewImageQuality() {
        return this.mViewImageQuality;
    }

    public void setUploadImageQuality(int quality) {
        if (this.mUploadImageQuality != quality) {
            this.mUploadImageQuality = quality;
            getSharedPreferences(Config.SETTINGFILE, 0).edit().putInt(Config.PREFS_IMAGE_QUALITY, quality).commit();
        }
    }

    public void setViewImageQuality(int quality) {
        if (this.mViewImageQuality != quality) {
            this.mViewImageQuality = quality;
            getSharedPreferences(Config.SETTINGFILE, 0).edit().putInt(Config.PREFS_VIEW_IMAGE_QUALITY, quality).commit();
        }
    }

    public boolean isShowImages() {
        return this.mIsShowImages;
    }

    public void setShowImages(boolean isShowImages) {
        if (this.mIsShowImages != isShowImages) {
            this.mIsShowImages = isShowImages;
            getSharedPreferences(Config.SETTINGFILE, 0).edit().putBoolean(Config.PREFS_SHOW_IMAGES, isShowImages).commit();
        }
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(int size) {
        if (this.mFontSize != size) {
            this.mFontSize = size;
            getSharedPreferences(Config.SETTINGFILE, 0).edit().putInt(Config.PREFS_FONT_SIZE, size).commit();
        }
    }

    public void refreshMsg(long r, long a, long f) {
        if (r != this.mMsgReplyme || a != this.mMsgAtme || f != this.mMsgFans) {
            int notifyFlag = 0;
            if (r > this.mMsgReplyme || a > this.mMsgAtme || f > this.mMsgFans) {
                notifyFlag = 1;
            } else if (r < this.mMsgReplyme || a < this.mMsgAtme || f < this.mMsgFans) {
                notifyFlag = 2;
            }
            this.mMsgReplyme = r;
            this.mMsgAtme = a;
            this.mMsgFans = f;
            broadcastMsg();
            showNotification(notifyFlag);
        }
    }

    private void showNotification(int flag) {
        if (this.mNotificationManager != null) {
            try {
                if (flag == 1) {
                    Notification notification = new Notification(R.drawable.icon, "您有新消息了", System.currentTimeMillis());
                    Intent intent = new Intent(this, MainTabActivity.class);
                    if (this.mMsgReplyme > 0 || this.mMsgAtme > 0) {
                        intent.putExtra(MainTabActivity.GOTO_TYPE, MainTabActivity.GOTO_SORT);
                    } else if (this.mMsgFans > 0) {
                        intent.putExtra(MainTabActivity.GOTO_TYPE, MainTabActivity.GOTO_PERSON);
                    }
                    intent.putExtra(MainTabActivity.KEY_CLOSE_DIALOG, true);
                    intent.setFlags(872415232);
                    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
                    notification.setLatestEventInfo(this, "百度贴吧", String.valueOf(String.valueOf(getMsgTotal())) + "条新消息，刷新看看", contentIntent);
                    notification.defaults = -1;
                    notification.defaults ^= 1;
                    notification.flags = 16;
                    if (this.mRemindToneOn) {
                        notification.sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.remind_tone);
                    }
                    this.mNotificationManager.notify(R.drawable.icon, notification);
                } else if (flag == 2) {
                    this.mNotificationManager.cancel(R.drawable.icon);
                }
            } catch (Exception e) {
                TiebaLog.e(getClass().toString(), "showNotification", e.getMessage());
            }
        }
    }

    public void cancelNotification() {
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(R.drawable.icon);
        }
    }

    private void broadcastMsg() {
        Intent intent = new Intent(Config.BROADCAST_NOTIFY);
        intent.putExtra(Config.BROADCAST_RELAY_ME_NUM, getMsgReplyme());
        intent.putExtra(Config.BROADCAST_AT_ME_NUM, getMsgAtme());
        intent.putExtra(Config.BROADCAST_FANS_NUM, getMsgFans());
        sendBroadcast(intent);
        TiebaLog.i(getClass().getName(), "broadcastMsg", "sendBroadcast: " + String.format("%d %d %d", Long.valueOf(getMsgReplyme()), Long.valueOf(getMsgAtme()), Long.valueOf(getMsgFans())));
    }

    public void setSdramImage(SDRamImage sdramImage) {
        this.mSdramImage = sdramImage;
    }

    public SDRamImage getSdramImage() {
        return this.mSdramImage;
    }

    public int getPostImageSize() {
        switch (this.mUploadImageQuality) {
            case 1:
                return Config.POST_IMAGE_BIG;
            case 2:
            default:
                return Config.POST_IMAGE_MIDDLE;
            case 3:
                return 300;
        }
    }

    public void AddResumeNum() {
        this.mResumeNum++;
        processResumeNum();
    }

    public void DelResumeNum() {
        this.mResumeNum--;
        processResumeNum();
    }

    private void processResumeNum() {
        if (this.mIsMainProcess) {
            if (this.mResumeNum < 0) {
                this.mResumeNum = 0;
            }
            if (this.mStartTime == 0 && this.mResumeNum > 0) {
                this.mStartTime = System.nanoTime();
            }
            TiebaLog.i(getClass().getName(), "mResumeNum = ", String.valueOf(this.mResumeNum));
            this.handler.removeMessages(4);
            if (this.mResumeNum == 0 && this.mStartTime > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(4), Config.USE_TIME_INTERVAL);
            }
        }
    }

    public boolean getIsFirstUse() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        String lastVersion = preference.getString(LAST_VERSION, "");
        return !lastVersion.equals(Config.VERSION);
    }

    public void setUsed() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(LAST_VERSION, Config.VERSION);
        editor.commit();
    }

    public void requestChangeBind(int flag) {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        String accessToken = preference.getString("access_token", "");
        if (flag == 0) {
            long accessTokenMotifyTime = preference.getLong(ACCESS_TOKEN_MODIFY_TIME, Long.MAX_VALUE);
            long gapTime = System.currentTimeMillis() - accessTokenMotifyTime;
            if (accessToken.length() > 0 && gapTime < ACCESS_TOKEN_MAX_TIME) {
                onBinds(accessToken);
                return;
            }
            NetWorkCore mNetWork = new NetWorkCore("http://c.tieba.baidu.com/c/s/igap");
            String aks = SingleBaUtility.EncryptCode(API_KEY, API_KEY.length());
            mNetWork.addPostData("ap", "tiebaapp");
            mNetWork.addPostData("os", "android");
            mNetWork.addPostData("ak", aks);
            String data = mNetWork.postNetData();
            if (mNetWork.isRequestSuccess()) {
                try {
                    JSONObject jo = new JSONObject(data);
                    String accessToken2 = jo.getString("access_token");
                    SharedPreferences.Editor editor = preference.edit();
                    editor.putString("access_token", accessToken2);
                    editor.putLong(ACCESS_TOKEN_MODIFY_TIME, System.currentTimeMillis());
                    editor.commit();
                    onBinds(accessToken2);
                } catch (JSONException e) {
                    TiebaLog.e(getClass().getName(), "bind", e.getMessage());
                }
            }
        } else if (accessToken != null && accessToken.length() > 0) {
            unBinds(accessToken);
        }
    }

    public void onBinds(String strToken) {
        if (!getBindState()) {
            Intent intent = createMethodIntent(strToken);
            intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
            intent.putExtra(PushConstants.EXTRA_BIND_NAME, Build.MODEL);
            intent.putExtra(PushConstants.EXTRA_BIND_STATUS, 0);
            sendBroadcast(intent);
        }
    }

    private void unBinds(String strToken) {
        if (getBindState()) {
            Intent intent = createMethodIntent(strToken);
            intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_UNBIND);
            sendBroadcast(intent);
            setBindState(false);
        }
    }

    private Intent createMethodIntent(String accessToken) {
        Intent intent = PushConstants.createMethodIntent(this);
        TiebaLog.d(getClass().getName(), "Original Token : ", accessToken);
        String rsaToken = PushConstants.rsaEncrypt(accessToken);
        TiebaLog.d(getClass().getName(), "RSA Token:", rsaToken);
        intent.putExtra("access_token", rsaToken);
        return intent;
    }

    public void setBindState(boolean src) {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(BIND_STATE, src);
        editor.commit();
    }

    public boolean getBindState() {
        SharedPreferences preference = getSharedPreferences(Config.SETTINGFILE, 0);
        return preference.getBoolean(BIND_STATE, false);
    }
}
