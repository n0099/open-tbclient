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
    private static volatile c fmY;
    private long fmV;
    private final int fmT = 2;
    private final int fmU = 3;
    private int aFS = -1;
    private CustomMessageListener fmZ = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dqU().dqP() != null) {
                r.dqU().dqP().dqI();
            }
        }
    };
    private CustomMessageListener fna = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bAu();
            }
        }
    };
    private CustomMessageListener fnb = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fmV != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bAv()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bAv()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fnc = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fmW = currentTimeMillis - c.this.fmV <= 1;
                    }
                }
            }
        }
    };
    private boolean fmW = false;
    private boolean fmX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bAt() {
        if (fmY == null) {
            synchronized (c.class) {
                if (fmY == null) {
                    fmY = new c();
                }
            }
        }
        return fmY;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fna);
        MessageManager.getInstance().registerListener(this.fnb);
        MessageManager.getInstance().registerListener(this.fmZ);
        MessageManager.getInstance().registerListener(this.fnc);
        if (r.dqU().dqP() != null) {
            r.dqU().dqP().dqH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        this.fmX = true;
        this.fmV = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAv() {
        bAw();
        this.fmX = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fmW) {
            this.fmW = false;
            return false;
        } else if (currentTimeMillis - this.fmV <= 2 || currentTimeMillis - this.fmV <= this.aFS) {
            return false;
        } else {
            l dqP = r.dqU().dqP();
            return (dqP != null ? dqP.dqJ() : 3) < 3;
        }
    }

    private void bAw() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aFS = adAdSense.bnr();
            if (this.aFS <= 0) {
                this.aFS = 86400;
                return;
            }
            return;
        }
        this.aFS = 300;
    }
}
