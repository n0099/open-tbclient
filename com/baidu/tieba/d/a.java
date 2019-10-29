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
import com.baidu.tbadk.t.q;
import com.baidu.tieba.r.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements a.InterfaceC0503a {
    private boolean eWC = false;
    private boolean eWD = false;
    private boolean eWE = false;
    private CustomMessageListener dhb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.bcv();
            }
        }
    };
    private CustomMessageListener bRR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                q.isOn();
            }
        }
    };
    private CustomMessageListener ri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                a.this.bcw();
            }
        }
    };

    @Override // com.baidu.tieba.r.a.InterfaceC0503a
    public void g(Application application) {
        MessageManager.getInstance().registerListener(this.bRR);
        MessageManager.getInstance().registerListener(this.dhb);
        MessageManager.getInstance().registerListener(this.ri);
        if (!this.eWC) {
            h(application);
        }
    }

    private boolean h(Application application) {
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
            this.eWC = true;
            bcv();
            m(null);
            bcw();
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
                if (bcq()) {
                    CrabSDK.disableBlockCatch();
                } else if (bcs()) {
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
            CrabSDK.setOnAnrCrashListener(new OnAnrCrashListener() { // from class: com.baidu.tieba.d.a.5
                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onAnrStarted(Map map) {
                    a.this.bcv();
                    a.this.m(null);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onCrashStarted(Thread thread, Throwable th) {
                    a.this.bcv();
                    a.this.m(th);
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onNativeCrashStarted(Error error, String str, int i) {
                    a.this.bcv();
                    a.this.m(error);
                }
            });
            bct();
            bcu();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.eWC = false;
            return false;
        }
    }

    private boolean bcq() {
        return TbConfig.getVersionType() == 2;
    }

    private boolean bcr() {
        return TbConfig.getVersionType() == 1;
    }

    private boolean bcs() {
        return TbConfig.getVersionType() == 3;
    }

    private void bct() {
        if (this.eWC && this.eWD) {
            CrabSDK.disableBlockCatch();
        }
    }

    private void bcu() {
        if (this.eWC && this.eWE) {
            CrabSDK.closeAnrHandler();
        }
    }

    public void bcv() {
        cy(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void cy(String str, String str2) {
        if (this.eWC) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void bcw() {
        if (this.eWC) {
            if (j.isWifiNet()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Throwable th) {
        if (this.eWC) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", bcx());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            hashMap.put("plugin_info", n(th));
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
        if (r9.getMessage().contains("java.lang.NoClassDefFoundError") != false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String n(Throwable th) {
        boolean z;
        String str;
        if (th == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                while (it.hasNext()) {
                    Plugin next = it.next();
                    if (next != null) {
                        PluginSetting aN = PluginPackageManager.iL().aN(next.getPackageName());
                        sb.append(next.getPackageName());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(next.getCurrentPluginMode());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (aN != null) {
                            sb.append(new File(aN.apkPath).exists());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(next.getVersionCode());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb.append(aN.tempVersionCode);
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (aN.enable) {
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
        boolean z2 = false;
        StringBuilder sb2 = new StringBuilder();
        if (th.getMessage() != null) {
            if (!th.getMessage().contains("java.lang.ClassNotFoundException")) {
            }
            try {
                PluginSettings jm = c.jp().jm();
                if (jm != null) {
                    sb2.append(jm.getContainerVersion());
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(jm.getForbiddenFeatures());
                    sb2.append("#");
                    for (PluginSetting pluginSetting : jm.getPlugins().values()) {
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
                str = b.iy().toString();
                z = true;
            } catch (Exception e2) {
                z2 = true;
                z = z2;
                str = "";
                String str2 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.em().en();
                if (z) {
                }
            }
            String str22 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.em().en();
            return z ? str22 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str : str22;
        }
        z = false;
        str = "";
        String str222 = th.getMessage() + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + com.baidu.adp.base.a.em().en();
        if (z) {
        }
    }

    private String bcx() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            return "DebugBuild";
        }
        if (bcs()) {
            return "ReleasedBuild";
        }
        if (bcq()) {
            return "GrayBuild";
        }
        if (!bcr()) {
            return "DefaultBuild";
        }
        return "DailyBuild";
    }

    @Override // com.baidu.tieba.r.a.InterfaceC0503a
    public void onPause(Activity activity) {
        if (this.eWC && activity != null) {
            CrabSDK.onPause(activity);
        }
    }

    @Override // com.baidu.tieba.r.a.InterfaceC0503a
    public void onResume(Activity activity) {
        if (this.eWC && activity != null) {
            CrabSDK.onResume(activity);
        }
    }

    @Override // com.baidu.tieba.r.a.InterfaceC0503a
    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.eWC && activity != null && motionEvent != null) {
            CrabSDK.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
