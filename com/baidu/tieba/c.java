package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class c {
    private static volatile c fZH;
    private long fZE;
    private final int fZC = 2;
    private final int fZD = 3;
    private int aHx = -1;
    private CustomMessageListener fZI = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dBe().dAZ() != null) {
                r.dBe().dAZ().dAS();
            }
        }
    };
    private CustomMessageListener fZJ = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bIS();
            }
        }
    };
    private CustomMessageListener fZK = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fZE != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity")) {
                        if (c.this.bIT()) {
                            BaseActivity baseActivity = (BaseActivity) data;
                            Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                            intent.putExtra("splash", true);
                            intent.setFlags(65536);
                            baseActivity.startActivity(intent);
                            TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                            return;
                        }
                        TbadkCoreApplication.getInst().setCanShowHotSplash(1);
                    }
                } else if (data instanceof BaseFragmentActivity) {
                    if (c.this.bIT()) {
                        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                        Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                        intent2.putExtra("splash", true);
                        intent2.setFlags(65536);
                        baseFragmentActivity.getActivity().startActivity(intent2);
                        TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                        return;
                    }
                    TbadkCoreApplication.getInst().setCanShowHotSplash(1);
                }
            }
        }
    };
    private CustomMessageListener fZL = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fZF = currentTimeMillis - c.this.fZE <= 1;
                    }
                }
            }
        }
    };
    private boolean fZF = false;
    private boolean fZG = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bIR() {
        if (fZH == null) {
            synchronized (c.class) {
                if (fZH == null) {
                    fZH = new c();
                }
            }
        }
        return fZH;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fZJ);
        MessageManager.getInstance().registerListener(this.fZK);
        MessageManager.getInstance().registerListener(this.fZI);
        MessageManager.getInstance().registerListener(this.fZL);
        if (r.dBe().dAZ() != null) {
            r.dBe().dAZ().dAR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIS() {
        this.fZG = true;
        this.fZE = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIT() {
        bIU();
        this.fZG = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fZF) {
            this.fZF = false;
            return false;
        } else if (currentTimeMillis - this.fZE <= 2 || currentTimeMillis - this.fZE <= this.aHx) {
            return false;
        } else {
            n dAZ = r.dBe().dAZ();
            return (dAZ != null ? dAZ.dAT() : 3) < 3;
        }
    }

    private void bIU() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aHx = adAdSense.bvK();
            if (this.aHx <= 0) {
                this.aHx = 86400;
                return;
            }
            return;
        }
        this.aHx = 300;
    }
}
