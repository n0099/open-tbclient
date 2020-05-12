package com.baidu.tieba.d;

import android.app.Activity;
import android.app.Application;
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
import com.baidu.tieba.t.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements a.InterfaceC0672a {
    private String gvM;
    private boolean gvJ = false;
    private boolean gvK = false;
    private boolean gvL = false;
    private CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.bGp();
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                CrabSdkSwitch.isOn();
            }
        }
    };
    private CustomMessageListener MO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                a.this.bGq();
            }
        }
    };

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void initSdk(Application application) {
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
        MessageManager.getInstance().registerListener(this.MO);
        if (!this.gvJ) {
            f(application);
        }
    }

    private boolean f(Application application) {
        try {
            CrabSDK.setConstantSameCrashExceedLimit(3);
            CrabSDK.setOnCrashExceedListener(new OnCrashExceedListener() { // from class: com.baidu.tieba.d.a.4
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
            this.gvJ = true;
            bGp();
            q(null);
            bGq();
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
                if (bGk()) {
                    CrabSDK.disableBlockCatch();
                } else if (bGm()) {
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
            CrabSDK.setOnAnrCrashListener(new OnAnrCrashListener() { // from class: com.baidu.tieba.d.a.5
                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onAnrStarted(Map map) {
                    a.this.bGp();
                    a.this.q(null);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onCrashStarted(Thread thread, Throwable th) {
                    a.this.bGp();
                    a.this.q(th);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onNativeCrashStarted(String str) {
                    a.this.bGp();
                    a.this.q(null);
                }
            });
            bGn();
            bGo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.gvJ = false;
            return false;
        }
    }

    private boolean bGk() {
        return TbConfig.getVersionType() == 2;
    }

    private boolean bGl() {
        return TbConfig.getVersionType() == 1;
    }

    private boolean bGm() {
        return TbConfig.getVersionType() == 3;
    }

    private void bGn() {
        if (this.gvJ && this.gvK) {
            CrabSDK.disableBlockCatch();
        }
    }

    private void bGo() {
        if (this.gvJ && this.gvL) {
            CrabSDK.closeAnrHandler();
        }
    }

    public void bGp() {
        dq(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void dq(String str, String str2) {
        if (this.gvJ) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void bGq() {
        if (this.gvJ) {
            if (j.isWifiNet()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Throwable th) {
        if (this.gvJ) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", bGr());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            hashMap.put("plugin_info", r(th));
            hashMap.put("lastFlutterPage", this.gvM);
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void setLastFlutterPage(String str) {
        this.gvM = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
        if (r9.getMessage().contains("java.lang.NoClassDefFoundError") != false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String r(Throwable th) {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                while (it.hasNext()) {
                    Plugin next = it.next();
                    if (next != null) {
                        PluginSetting cq = PluginPackageManager.nV().cq(next.getPackageName());
                        sb.append(next.getPackageName());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(next.getCurrentPluginMode());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (cq != null) {
                            sb.append(new File(cq.apkPath).exists());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(next.getVersionCode());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(cq.tempVersionCode);
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (cq.enable) {
                                sb.append("true");
                            } else {
                                sb.append("false");
                            }
                        } else {
                            sb.append("null");
                        }
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                PluginSettings ow = c.oz().ow();
                if (ow != null) {
                    sb2.append(ow.getContainerVersion());
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(ow.getForbiddenFeatures());
                    sb2.append("#");
                    for (PluginSetting pluginSetting : ow.getPlugins().values()) {
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
                str = b.nI().toString();
                z = true;
            } catch (Exception e2) {
                z2 = true;
                z = z2;
                str = "";
                String str2 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.jm().jn();
                if (z) {
                }
            }
            String str22 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.jm().jn();
            return z ? str22 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str : str22;
        }
        z = false;
        str = "";
        String str222 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.jm().jn();
        if (z) {
        }
    }

    private String bGr() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            return "DebugBuild";
        }
        if (bGm()) {
            return "ReleasedBuild";
        }
        if (bGk()) {
            return "GrayBuild";
        }
        if (!bGl()) {
            return "DefaultBuild";
        }
        return "DailyBuild";
    }

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void onPause(Activity activity) {
        if (this.gvJ && activity != null) {
            CrabSDK.onPause(activity);
        }
    }

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void onResume(Activity activity) {
        if (this.gvJ && activity != null) {
            CrabSDK.onResume(activity);
        }
    }

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.gvJ && activity != null && motionEvent != null) {
            CrabSDK.behaviorRecordEvent(motionEvent, activity);
        }
    }

    @Override // com.baidu.tieba.t.a.InterfaceC0672a
    public void uploadException(Exception exc) {
        if (this.gvJ && exc != null) {
            CrabSDK.uploadException(exc);
        }
    }
}
