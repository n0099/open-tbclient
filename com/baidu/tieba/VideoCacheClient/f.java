package com.baidu.tieba.VideoCacheClient;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoCache.VideoCacheService;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f {
    private static final String TAG = f.class.getSimpleName();
    private static f aON;
    private Context mContext;
    private Handler mHandler;
    private long mLastCheckTime = 0;
    private Handler.Callback aLz = new g(this);

    private f(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        HandlerThread handlerThread = new HandlerThread("video_cache_client_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aLz);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public static f aw(Context context) {
        if (aON == null) {
            synchronized (f.class) {
                if (aON == null) {
                    aON = new f(context);
                }
            }
        }
        return aON;
    }

    public void hj(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hk(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void au(String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://127.0.0.1:" + c.Ky().getPort() + "/video_cache?origin_url=" + URLEncoder.encode(String.valueOf(str) + str2)).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            inputStream.read();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQ(String str) {
        au(str, "?file_access=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gW(String str) {
        au(str, "?stop_cache=1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB() {
        ActivityManager activityManager;
        boolean z;
        if (this.mContext != null && (activityManager = (ActivityManager) this.mContext.getSystemService("activity")) != null) {
            Iterator<ActivityManager.RunningServiceInfo> it = activityManager.getRunningServices(Integer.MAX_VALUE).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if ("com.baidu.tieba.VideoCache.VideoCacheService".equals(it.next().service.getClassName())) {
                    z = true;
                    e.log(TAG, "service is alive");
                    break;
                }
            }
            if (!z) {
                File file = new File(d.aOw);
                if (file.exists()) {
                    file.delete();
                }
                c.Ky().KA();
                this.mContext.startService(new Intent(this.mContext, VideoCacheService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCheckTime >= 86400000) {
            au("", "delete_expired_files");
            this.mLastCheckTime = currentTimeMillis;
        }
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        au("", "clear_cache");
    }
}
