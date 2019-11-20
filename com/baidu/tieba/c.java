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
    private static volatile c daB;
    private long dax;
    private final int dav = 2;
    private final int daw = 3;
    private int Tv = -1;
    private CustomMessageListener daC = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cfJ().cfE() != null) {
                r.cfJ().cfE().cfw();
            }
        }
    };
    private CustomMessageListener daD = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aAR();
            }
        }
    };
    private CustomMessageListener daE = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dax != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aAS()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aAS()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener daF = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.daz = currentTimeMillis - c.this.dax <= 1;
                    }
                }
            }
        }
    };
    private boolean daz = false;
    private boolean daA = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aAQ() {
        if (daB == null) {
            synchronized (c.class) {
                if (daB == null) {
                    daB = new c();
                }
            }
        }
        return daB;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.daD);
        MessageManager.getInstance().registerListener(this.daE);
        MessageManager.getInstance().registerListener(this.daC);
        MessageManager.getInstance().registerListener(this.daF);
        if (r.cfJ().cfE() != null) {
            r.cfJ().cfE().cfv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAR() {
        this.daA = true;
        this.dax = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAS() {
        aAT();
        this.daA = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.daz) {
            this.daz = false;
            return false;
        } else if (currentTimeMillis - this.dax <= 2 || currentTimeMillis - this.dax <= this.Tv) {
            return false;
        } else {
            l cfE = r.cfJ().cfE();
            return (cfE != null ? cfE.cfx() : 3) < 3;
        }
    }

    private void aAT() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.Tv = adAdSense.aoX();
            if (this.Tv <= 0) {
                this.Tv = 86400;
                return;
            }
            return;
        }
        this.Tv = 300;
    }
}
