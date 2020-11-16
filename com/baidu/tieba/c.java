package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.q;
/* loaded from: classes.dex */
public class c {
    private static volatile c fNa;
    private long fMX;
    private final int fMV = 2;
    private final int fMW = 3;
    private int aIN = -1;
    private CustomMessageListener fNb = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.dzO().dzJ() != null) {
                q.dzO().dzJ().dzC();
            }
        }
    };
    private CustomMessageListener fNc = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bGR();
            }
        }
    };
    private CustomMessageListener fNd = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fMX != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bGS()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bGS()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fNe = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fMY = currentTimeMillis - c.this.fMX <= 1;
                    }
                }
            }
        }
    };
    private boolean fMY = false;
    private boolean fMZ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bGQ() {
        if (fNa == null) {
            synchronized (c.class) {
                if (fNa == null) {
                    fNa = new c();
                }
            }
        }
        return fNa;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fNc);
        MessageManager.getInstance().registerListener(this.fNd);
        MessageManager.getInstance().registerListener(this.fNb);
        MessageManager.getInstance().registerListener(this.fNe);
        if (q.dzO().dzJ() != null) {
            q.dzO().dzJ().dzB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        this.fMZ = true;
        this.fMX = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGS() {
        bGT();
        this.fMZ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fMY) {
            this.fMY = false;
            return false;
        } else if (currentTimeMillis - this.fMX <= 2 || currentTimeMillis - this.fMX <= this.aIN) {
            return false;
        } else {
            m dzJ = q.dzO().dzJ();
            return (dzJ != null ? dzJ.dzD() : 3) < 3;
        }
    }

    private void bGT() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aIN = adAdSense.btK();
            if (this.aIN <= 0) {
                this.aIN = 86400;
                return;
            }
            return;
        }
        this.aIN = 300;
    }
}
