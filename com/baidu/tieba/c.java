package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.q;
/* loaded from: classes.dex */
public class c {
    private static volatile c eHR;
    private long eHO;
    private final int eHM = 2;
    private final int eHN = 3;
    private int avZ = -1;
    private CustomMessageListener eHS = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.cUm().cUh() != null) {
                q.cUm().cUh().cUa();
            }
        }
    };
    private CustomMessageListener eHT = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bjQ();
            }
        }
    };
    private CustomMessageListener eHU = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.eHO != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bjR()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bjR()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener eHV = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.eHP = currentTimeMillis - c.this.eHO <= 1;
                    }
                }
            }
        }
    };
    private boolean eHP = false;
    private boolean eHQ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bjP() {
        if (eHR == null) {
            synchronized (c.class) {
                if (eHR == null) {
                    eHR = new c();
                }
            }
        }
        return eHR;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.eHT);
        MessageManager.getInstance().registerListener(this.eHU);
        MessageManager.getInstance().registerListener(this.eHS);
        MessageManager.getInstance().registerListener(this.eHV);
        if (q.cUm().cUh() != null) {
            q.cUm().cUh().cTZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        this.eHQ = true;
        this.eHO = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjR() {
        bjS();
        this.eHQ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.eHP) {
            this.eHP = false;
            return false;
        } else if (currentTimeMillis - this.eHO <= 2 || currentTimeMillis - this.eHO <= this.avZ) {
            return false;
        } else {
            k cUh = q.cUm().cUh();
            return (cUh != null ? cUh.cUb() : 3) < 3;
        }
    }

    private void bjS() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.avZ = adAdSense.aXO();
            if (this.avZ <= 0) {
                this.avZ = 86400;
                return;
            }
            return;
        }
        this.avZ = 300;
    }
}
