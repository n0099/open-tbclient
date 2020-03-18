package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class c {
    private static volatile c dTo;
    private long dTl;
    private final int dTj = 2;
    private final int dTk = 3;
    private int acH = -1;
    private CustomMessageListener dTp = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cCQ().cCL() != null) {
                r.cCQ().cCL().cCE();
            }
        }
    };
    private CustomMessageListener dTq = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aVx();
            }
        }
    };
    private CustomMessageListener dTr = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dTl != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aVy()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aVy()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dTs = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dTm = currentTimeMillis - c.this.dTl <= 1;
                    }
                }
            }
        }
    };
    private boolean dTm = false;
    private boolean dTn = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aVw() {
        if (dTo == null) {
            synchronized (c.class) {
                if (dTo == null) {
                    dTo = new c();
                }
            }
        }
        return dTo;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dTq);
        MessageManager.getInstance().registerListener(this.dTr);
        MessageManager.getInstance().registerListener(this.dTp);
        MessageManager.getInstance().registerListener(this.dTs);
        if (r.cCQ().cCL() != null) {
            r.cCQ().cCL().cCD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVx() {
        this.dTn = true;
        this.dTl = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVy() {
        aVz();
        this.dTn = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dTm) {
            this.dTm = false;
            return false;
        } else if (currentTimeMillis - this.dTl <= 2 || currentTimeMillis - this.dTl <= this.acH) {
            return false;
        } else {
            l cCL = r.cCQ().cCL();
            return (cCL != null ? cCL.cCF() : 3) < 3;
        }
    }

    private void aVz() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.acH = adAdSense.aJn();
            if (this.acH <= 0) {
                this.acH = 86400;
                return;
            }
            return;
        }
        this.acH = 300;
    }
}
