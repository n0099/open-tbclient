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
    private static volatile c ger;
    private long gen;
    private final int gel = 2;
    private final int gem = 3;
    private int aMk = -1;
    private CustomMessageListener ges = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dEV().dEQ() != null) {
                r.dEV().dEQ().dEJ();
            }
        }
    };
    private CustomMessageListener get = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bMJ();
            }
        }
    };
    private CustomMessageListener geu = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.gen != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity")) {
                        if (c.this.bMK()) {
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
                    if (c.this.bMK()) {
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
    private CustomMessageListener gev = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.gep = currentTimeMillis - c.this.gen <= 1;
                    }
                }
            }
        }
    };
    private boolean gep = false;
    private boolean geq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bMI() {
        if (ger == null) {
            synchronized (c.class) {
                if (ger == null) {
                    ger = new c();
                }
            }
        }
        return ger;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.get);
        MessageManager.getInstance().registerListener(this.geu);
        MessageManager.getInstance().registerListener(this.ges);
        MessageManager.getInstance().registerListener(this.gev);
        if (r.dEV().dEQ() != null) {
            r.dEV().dEQ().dEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMJ() {
        this.geq = true;
        this.gen = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMK() {
        bML();
        this.geq = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.gep) {
            this.gep = false;
            return false;
        } else if (currentTimeMillis - this.gen <= 2 || currentTimeMillis - this.gen <= this.aMk) {
            return false;
        } else {
            n dEQ = r.dEV().dEQ();
            return (dEQ != null ? dEQ.dEK() : 3) < 3;
        }
    }

    private void bML() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aMk = adAdSense.bzD();
            if (this.aMk <= 0) {
                this.aMk = 86400;
                return;
            }
            return;
        }
        this.aMk = 300;
    }
}
