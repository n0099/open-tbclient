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
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.OnAnrCrashListener;
import com.baidu.crabsdk.OnCrashExceedListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.p.o;
import com.baidu.tieba.q.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements a.InterfaceC0290a {
    private boolean cXX = false;
    private boolean cXY = false;
    private boolean cXZ = false;
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.apO();
            }
        }
    };
    private CustomMessageListener cYa = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                o.jJ();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                a.this.apP();
            }
        }
    };

    @Override // com.baidu.tieba.q.a.InterfaceC0290a
    public void b(Application application) {
        MessageManager.getInstance().registerListener(this.cYa);
        MessageManager.getInstance().registerListener(this.bxA);
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        if (!this.cXX) {
            c(application);
        }
    }

    private boolean c(Application application) {
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
            this.cXX = true;
            apO();
            apQ();
            apP();
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
                if (apJ()) {
                    CrabSDK.disableBlockCatch();
                } else if (apL()) {
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
                    a.this.apO();
                    a.this.apQ();
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onCrashStarted(Thread thread, Throwable th) {
                    a.this.apO();
                    a.this.apQ();
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onNativeCrashStarted(Error error, String str, int i) {
                    a.this.apO();
                    a.this.apQ();
                }
            });
            apM();
            apN();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.cXX = false;
            return false;
        }
    }

    private boolean apJ() {
        return TbConfig.getVersionType() == 2;
    }

    private boolean apK() {
        return TbConfig.getVersionType() == 1;
    }

    private boolean apL() {
        return TbConfig.getVersionType() == 3;
    }

    private void apM() {
        if (this.cXX && this.cXY) {
            CrabSDK.disableBlockCatch();
        }
    }

    private void apN() {
        if (this.cXX && this.cXZ) {
            CrabSDK.closeAnrHandler();
        }
    }

    public void apO() {
        bk(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void bk(String str, String str2) {
        if (this.cXX) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void apP() {
        if (this.cXX) {
            if (j.kW()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apQ() {
        if (this.cXX) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", apR());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }

    private String apR() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            return "DebugBuild";
        }
        if (apL()) {
            return "ReleasedBuild";
        }
        if (apJ()) {
            return "GrayBuild";
        }
        if (!apK()) {
            return "DefaultBuild";
        }
        return "DailyBuild";
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0290a
    public void onPause(Activity activity) {
        if (this.cXX && activity != null) {
            CrabSDK.onPause(activity);
        }
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0290a
    public void onResume(Activity activity) {
        if (this.cXX && activity != null) {
            CrabSDK.onResume(activity);
        }
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0290a
    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.cXX && activity != null && motionEvent != null) {
            CrabSDK.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
