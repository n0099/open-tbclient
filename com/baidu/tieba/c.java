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
    private static volatile c dOE;
    private long dOB;
    private final int dOz = 2;
    private final int dOA = 3;
    private int aaz = -1;
    private CustomMessageListener dOF = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cAV().cAQ() != null) {
                r.cAV().cAQ().cAJ();
            }
        }
    };
    private CustomMessageListener dOG = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aSZ();
            }
        }
    };
    private CustomMessageListener dOH = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dOB != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aTa()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aTa()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dOI = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dOC = currentTimeMillis - c.this.dOB <= 1;
                    }
                }
            }
        }
    };
    private boolean dOC = false;
    private boolean dOD = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aSY() {
        if (dOE == null) {
            synchronized (c.class) {
                if (dOE == null) {
                    dOE = new c();
                }
            }
        }
        return dOE;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dOG);
        MessageManager.getInstance().registerListener(this.dOH);
        MessageManager.getInstance().registerListener(this.dOF);
        MessageManager.getInstance().registerListener(this.dOI);
        if (r.cAV().cAQ() != null) {
            r.cAV().cAQ().cAI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSZ() {
        this.dOD = true;
        this.dOB = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTa() {
        aTb();
        this.dOD = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dOC) {
            this.dOC = false;
            return false;
        } else if (currentTimeMillis - this.dOB <= 2 || currentTimeMillis - this.dOB <= this.aaz) {
            return false;
        } else {
            l cAQ = r.cAV().cAQ();
            return (cAQ != null ? cAQ.cAK() : 3) < 3;
        }
    }

    private void aTb() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aaz = adAdSense.aGS();
            if (this.aaz <= 0) {
                this.aaz = 86400;
                return;
            }
            return;
        }
        this.aaz = 300;
    }
}
