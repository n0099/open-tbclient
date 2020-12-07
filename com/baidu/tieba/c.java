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
    private static volatile c fUL;
    private long fUI;
    private final int fUG = 2;
    private final int fUH = 3;
    private int aLG = -1;
    private CustomMessageListener fUM = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dFf().dFa() != null) {
                r.dFf().dFa().dET();
            }
        }
    };
    private CustomMessageListener fUN = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bKr();
            }
        }
    };
    private CustomMessageListener fUO = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fUI != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bKs()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bKs()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fUP = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fUJ = currentTimeMillis - c.this.fUI <= 1;
                    }
                }
            }
        }
    };
    private boolean fUJ = false;
    private boolean fUK = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bKq() {
        if (fUL == null) {
            synchronized (c.class) {
                if (fUL == null) {
                    fUL = new c();
                }
            }
        }
        return fUL;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fUN);
        MessageManager.getInstance().registerListener(this.fUO);
        MessageManager.getInstance().registerListener(this.fUM);
        MessageManager.getInstance().registerListener(this.fUP);
        if (r.dFf().dFa() != null) {
            r.dFf().dFa().dES();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        this.fUK = true;
        this.fUI = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKs() {
        bKt();
        this.fUK = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fUJ) {
            this.fUJ = false;
            return false;
        } else if (currentTimeMillis - this.fUI <= 2 || currentTimeMillis - this.fUI <= this.aLG) {
            return false;
        } else {
            n dFa = r.dFf().dFa();
            return (dFa != null ? dFa.dEU() : 3) < 3;
        }
    }

    private void bKt() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aLG = adAdSense.bxk();
            if (this.aLG <= 0) {
                this.aLG = 86400;
                return;
            }
            return;
        }
        this.aLG = 300;
    }
}
