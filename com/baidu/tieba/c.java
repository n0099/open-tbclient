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
    private static volatile c dSK;
    private long dSH;
    private final int dSF = 2;
    private final int dSG = 3;
    private int acx = -1;
    private CustomMessageListener dSL = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cCt().cCo() != null) {
                r.cCt().cCo().cCh();
            }
        }
    };
    private CustomMessageListener dSM = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aVq();
            }
        }
    };
    private CustomMessageListener dSN = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dSH != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aVr()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aVr()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dSO = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dSI = currentTimeMillis - c.this.dSH <= 1;
                    }
                }
            }
        }
    };
    private boolean dSI = false;
    private boolean dSJ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aVp() {
        if (dSK == null) {
            synchronized (c.class) {
                if (dSK == null) {
                    dSK = new c();
                }
            }
        }
        return dSK;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dSM);
        MessageManager.getInstance().registerListener(this.dSN);
        MessageManager.getInstance().registerListener(this.dSL);
        MessageManager.getInstance().registerListener(this.dSO);
        if (r.cCt().cCo() != null) {
            r.cCt().cCo().cCg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVq() {
        this.dSJ = true;
        this.dSH = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVr() {
        aVs();
        this.dSJ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dSI) {
            this.dSI = false;
            return false;
        } else if (currentTimeMillis - this.dSH <= 2 || currentTimeMillis - this.dSH <= this.acx) {
            return false;
        } else {
            l cCo = r.cCt().cCo();
            return (cCo != null ? cCo.cCi() : 3) < 3;
        }
    }

    private void aVs() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.acx = adAdSense.aJg();
            if (this.acx <= 0) {
                this.acx = 86400;
                return;
            }
            return;
        }
        this.acx = 300;
    }
}
