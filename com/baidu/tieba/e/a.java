package com.baidu.tieba.e;

import android.app.Activity;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.b.b;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnAnrCrashListener;
import com.baidu.crabsdk.OnCrashExceedListener;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.CrabSdkSwitch;
import com.baidu.tbadk.switchs.NativeCrashHandler;
import com.baidu.tieba.u.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes21.dex */
public class a implements a.InterfaceC0876a {
    private String iqr;
    private String iqs;
    private String iqt;
    private boolean iqo = false;
    private boolean iqp = false;
    private boolean iqq = false;
    private CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.e.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.ctz();
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.e.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                CrabSdkSwitch.isOn();
            }
        }
    };
    private CustomMessageListener PN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.e.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                a.this.ctA();
            }
        }
    };

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void initSdk(Application application) {
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
        MessageManager.getInstance().registerListener(this.PN);
        if (!this.iqo) {
            h(application);
        }
    }

    private boolean h(Application application) {
        try {
            CrabSDK.setConstantSameCrashExceedLimit(3);
            CrabSDK.setOnCrashExceedListener(new OnCrashExceedListener() { // from class: com.baidu.tieba.e.a.4
                @Override // com.baidu.crabsdk.OnCrashExceedListener
                public void onCrashExceedCallback() {
                }
            });
            boolean isDebugMode = BdBaseApplication.getInst().isDebugMode();
            String version = TbConfig.getVersion();
            if (!TextUtils.isEmpty(version)) {
                CrabSDK.setAppVersionName(version);
            }
            if (isDebugMode) {
                CrabSDK.init(application, "ef986e35b4f9ccc5");
            } else {
                CrabSDK.init(application, "b14ed41a92769403");
            }
            this.iqo = true;
            ctz();
            p(null);
            ctA();
            CrabSDK.setChannel(TbConfig.getCurrentFrom());
            CrabSDK.setEnableLog(isDebugMode);
            if (isDebugMode) {
                CrabSDK.enableBlockCatch(-1);
                CrabSDK.setBlockThreshold(2000);
                CrabSDK.setUploadCrashOnlyWifi(false);
                CrabSDK.setSendPrivacyInformation(true);
                CrabSDK.setUploadLimitOfSameCrashInOneday(-1);
                CrabSDK.setUploadLimitOfCrashInOneday(-1);
                CrabSDK.setUploadLimitOfAnrInOneday(-1);
                CrabSDK.setUrlRecordLimit(10);
            } else {
                if (ctu()) {
                    CrabSDK.disableBlockCatch();
                } else if (ctw()) {
                    CrabSDK.disableBlockCatch();
                } else {
                    CrabSDK.disableBlockCatch();
                }
                CrabSDK.setUploadCrashOnlyWifi(false);
                CrabSDK.setSendPrivacyInformation(true);
                CrabSDK.setUploadLimitOfSameCrashInOneday(10);
                CrabSDK.setUploadLimitOfCrashInOneday(30);
                CrabSDK.setUploadLimitOfAnrInOneday(10);
                CrabSDK.setBehaviorRecordLimit(5);
            }
            if (NativeCrashHandler.isOn()) {
                CrabSDK.openNativeCrashHandlerWithSysCatched();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add("libflutter.so");
                arrayList.add("libapp.so");
                CrabSDK.openNativeCrashHandler(arrayList);
            }
            CrabSDK.setOnAnrCrashListener(new OnAnrCrashListener() { // from class: com.baidu.tieba.e.a.5
                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onAnrStarted(Map map) {
                    a.this.ctz();
                    a.this.p(null);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onCrashStarted(Thread thread, Throwable th) {
                    a.this.ctz();
                    a.this.p(th);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onNativeCrashStarted(String str) {
                    a.this.ctz();
                    a.this.p(null);
                }
            });
            ctx();
            cty();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.iqo = false;
            return false;
        }
    }

    private boolean ctu() {
        return TbConfig.getVersionType() == 2;
    }

    private boolean ctv() {
        return TbConfig.getVersionType() == 1;
    }

    private boolean ctw() {
        return TbConfig.getVersionType() == 3;
    }

    private void ctx() {
        if (this.iqo && this.iqp) {
            CrabSDK.disableBlockCatch();
        }
    }

    private void cty() {
        if (this.iqo && this.iqq) {
            CrabSDK.closeAnrHandler();
        }
    }

    public void ctz() {
        eK(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void eK(String str, String str2) {
        if (this.iqo) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void ctA() {
        if (this.iqo) {
            if (j.isWifiNet()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Throwable th) {
        if (this.iqo) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", ctB());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            hashMap.put("plugin_info", q(th));
            hashMap.put("lastFlutterPage", this.iqr);
            hashMap.put("openFlutterPage", this.iqs);
            hashMap.put("flutterPath", this.iqt);
            hashMap.put("customTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put("isBackground", String.valueOf(TbadkCoreApplication.getInst().isInBackground()));
            hashMap.put("pid", String.valueOf(Process.myPid()));
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void setLastFlutterPage(String str) {
        this.iqr = str;
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void setOpenFlutterPage(String str) {
        this.iqs = str;
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void setFlutterPath(String str) {
        this.iqt = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
        if (r9.getMessage().contains("java.lang.NoClassDefFoundError") != false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String q(Throwable th) {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                while (it.hasNext()) {
                    Plugin next = it.next();
                    if (next != null) {
                        PluginSetting cD = PluginPackageManager.pV().cD(next.getPackageName());
                        sb.append(next.getPackageName());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(next.getCurrentPluginMode());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (cD != null) {
                            sb.append(new File(cD.apkPath).exists());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(next.getVersionCode());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(cD.tempVersionCode);
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (cD.enable) {
                                sb.append("true");
                            } else {
                                sb.append("false");
                            }
                        } else {
                            sb.append("null");
                        }
                        sb.append(",");
                    }
                }
            }
        } catch (Exception e) {
        }
        if (th == null) {
            return "--pluginInfo-" + sb.toString();
        }
        boolean z2 = false;
        StringBuilder sb2 = new StringBuilder();
        if (th.getMessage() != null) {
            if (!th.getMessage().contains("java.lang.ClassNotFoundException")) {
            }
            try {
                PluginSettings qu = c.qx().qu();
                if (qu != null) {
                    sb2.append(qu.getContainerVersion());
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(qu.getForbiddenFeatures());
                    sb2.append("#");
                    for (PluginSetting pluginSetting : qu.getPlugins().values()) {
                        if (pluginSetting != null) {
                            sb2.append(pluginSetting.packageName);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(pluginSetting.versionCode);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(pluginSetting.tempVersionCode);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(pluginSetting.enable);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(pluginSetting.forbidden);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(pluginSetting.installStatus);
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb2.append(new File(pluginSetting.apkPath).exists());
                            sb2.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                } else {
                    sb2.append("pluginSettings_is_null");
                }
                str = b.pI().toString();
                z = true;
            } catch (Exception e2) {
                z2 = true;
                z = z2;
                str = "";
                String str2 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.lg().lh();
                if (z) {
                }
            }
            String str22 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.lg().lh();
            return z ? str22 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str : str22;
        }
        z = false;
        str = "";
        String str222 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.lg().lh();
        if (z) {
        }
    }

    private String ctB() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            return "DebugBuild";
        }
        if (ctw()) {
            return "ReleasedBuild";
        }
        if (ctu()) {
            return "GrayBuild";
        }
        if (!ctv()) {
            return "DefaultBuild";
        }
        return "DailyBuild";
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void onPause(Activity activity) {
        if (this.iqo && activity != null) {
            CrabSDK.onPause(activity);
        }
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void onResume(Activity activity) {
        if (this.iqo && activity != null) {
            CrabSDK.onResume(activity);
        }
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.iqo && activity != null && motionEvent != null) {
            CrabSDK.behaviorRecordEvent(motionEvent, activity);
        }
    }

    @Override // com.baidu.tieba.u.a.InterfaceC0876a
    public void uploadException(Exception exc) {
        if (this.iqo && exc != null) {
            CrabSDK.uploadException(exc);
        }
    }
}
