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
/* loaded from: classes2.dex */
public class a implements a.InterfaceC0222a {
    private boolean cIM = false;
    private boolean cIN = false;
    private boolean cIO = false;
    private CustomMessageListener bmR = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.akZ();
            }
        }
    };
    private CustomMessageListener cIP = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                o.iq();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                a.this.ala();
            }
        }
    };

    @Override // com.baidu.tieba.q.a.InterfaceC0222a
    public void b(Application application) {
        MessageManager.getInstance().registerListener(this.cIP);
        MessageManager.getInstance().registerListener(this.bmR);
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        if (!this.cIM) {
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
            this.cIM = true;
            akZ();
            alb();
            ala();
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
                if (akU()) {
                    CrabSDK.disableBlockCatch();
                } else if (akW()) {
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
                    a.this.akZ();
                    a.this.alb();
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onCrashStarted(Thread thread, Throwable th) {
                    a.this.akZ();
                    a.this.alb();
                }

                @Override // com.baidu.crabsdk.OnAnrCrashListener
                public void onNativeCrashStarted(Error error, String str, int i) {
                    a.this.akZ();
                    a.this.alb();
                }
            });
            akX();
            akY();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.cIM = false;
            return false;
        }
    }

    private boolean akU() {
        return TbConfig.getVersionType() == 2;
    }

    private boolean akV() {
        return TbConfig.getVersionType() == 1;
    }

    private boolean akW() {
        return TbConfig.getVersionType() == 3;
    }

    private void akX() {
        if (this.cIM && this.cIN) {
            CrabSDK.disableBlockCatch();
        }
    }

    private void akY() {
        if (this.cIM && this.cIO) {
            CrabSDK.closeAnrHandler();
        }
    }

    public void akZ() {
        aP(TbadkCoreApplication.getInst().getCuidGalaxy2(), TbadkCoreApplication.getCurrentAccount());
    }

    public void aP(String str, String str2) {
        if (this.cIM) {
            CrabSDK.setUid(str);
            CrabSDK.setUserName(str2);
        }
    }

    public void ala() {
        if (this.cIM) {
            if (j.jF()) {
                CrabSDK.setCollectScreenshot(true);
            } else {
                CrabSDK.setCollectScreenshot(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (this.cIM) {
            HashMap hashMap = new HashMap();
            hashMap.put("version_type", alc());
            hashMap.put("version", TbConfig.getVersion());
            hashMap.put("sub_version", TbConfig.getSubVersion());
            CrabSDK.setUsersCustomKV(hashMap);
        }
    }

    private String alc() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            return "DebugBuild";
        }
        if (akW()) {
            return "ReleasedBuild";
        }
        if (akU()) {
            return "GrayBuild";
        }
        if (!akV()) {
            return "DefaultBuild";
        }
        return "DailyBuild";
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0222a
    public void y(Activity activity) {
        if (this.cIM && activity != null) {
            CrabSDK.onPause(activity);
        }
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0222a
    public void z(Activity activity) {
        if (this.cIM && activity != null) {
            CrabSDK.onResume(activity);
        }
    }

    @Override // com.baidu.tieba.q.a.InterfaceC0222a
    public void behaviorRecordEvent(MotionEvent motionEvent, Activity activity) {
        if (this.cIM && activity != null && motionEvent != null) {
            CrabSDK.behaviorRecordEvent(motionEvent, activity);
        }
    }
}
