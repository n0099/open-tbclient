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
    private static volatile c dSL;
    private long dSI;
    private final int dSG = 2;
    private final int dSH = 3;
    private int acx = -1;
    private CustomMessageListener dSM = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cCv().cCq() != null) {
                r.cCv().cCq().cCj();
            }
        }
    };
    private CustomMessageListener dSN = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aVs();
            }
        }
    };
    private CustomMessageListener dSO = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dSI != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aVt()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aVt()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dSP = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dSJ = currentTimeMillis - c.this.dSI <= 1;
                    }
                }
            }
        }
    };
    private boolean dSJ = false;
    private boolean dSK = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aVr() {
        if (dSL == null) {
            synchronized (c.class) {
                if (dSL == null) {
                    dSL = new c();
                }
            }
        }
        return dSL;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dSN);
        MessageManager.getInstance().registerListener(this.dSO);
        MessageManager.getInstance().registerListener(this.dSM);
        MessageManager.getInstance().registerListener(this.dSP);
        if (r.cCv().cCq() != null) {
            r.cCv().cCq().cCi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVs() {
        this.dSK = true;
        this.dSI = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVt() {
        aVu();
        this.dSK = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dSJ) {
            this.dSJ = false;
            return false;
        } else if (currentTimeMillis - this.dSI <= 2 || currentTimeMillis - this.dSI <= this.acx) {
            return false;
        } else {
            l cCq = r.cCv().cCq();
            return (cCq != null ? cCq.cCk() : 3) < 3;
        }
    }

    private void aVu() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.acx = adAdSense.aJi();
            if (this.acx <= 0) {
                this.acx = 86400;
                return;
            }
            return;
        }
        this.acx = 300;
    }
}
