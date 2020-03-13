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
    private static volatile c dSY;
    private long dSV;
    private final int dST = 2;
    private final int dSU = 3;
    private int acx = -1;
    private CustomMessageListener dSZ = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cCw().cCr() != null) {
                r.cCw().cCr().cCk();
            }
        }
    };
    private CustomMessageListener dTa = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aVt();
            }
        }
    };
    private CustomMessageListener dTb = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dSV != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aVu()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aVu()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dTc = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dSW = currentTimeMillis - c.this.dSV <= 1;
                    }
                }
            }
        }
    };
    private boolean dSW = false;
    private boolean dSX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aVs() {
        if (dSY == null) {
            synchronized (c.class) {
                if (dSY == null) {
                    dSY = new c();
                }
            }
        }
        return dSY;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dTa);
        MessageManager.getInstance().registerListener(this.dTb);
        MessageManager.getInstance().registerListener(this.dSZ);
        MessageManager.getInstance().registerListener(this.dTc);
        if (r.cCw().cCr() != null) {
            r.cCw().cCr().cCj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVt() {
        this.dSX = true;
        this.dSV = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVu() {
        aVv();
        this.dSX = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dSW) {
            this.dSW = false;
            return false;
        } else if (currentTimeMillis - this.dSV <= 2 || currentTimeMillis - this.dSV <= this.acx) {
            return false;
        } else {
            l cCr = r.cCw().cCr();
            return (cCr != null ? cCr.cCl() : 3) < 3;
        }
    }

    private void aVv() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.acx = adAdSense.aJj();
            if (this.acx <= 0) {
                this.acx = 86400;
                return;
            }
            return;
        }
        this.acx = 300;
    }
}
