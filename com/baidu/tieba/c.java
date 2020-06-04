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
    private static volatile c eIc;
    private long eHZ;
    private final int eHX = 2;
    private final int eHY = 3;
    private int avZ = -1;
    private CustomMessageListener eId = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.cUC().cUx() != null) {
                q.cUC().cUx().cUq();
            }
        }
    };
    private CustomMessageListener eIe = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bjS();
            }
        }
    };
    private CustomMessageListener eIf = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.eHZ != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bjT()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bjT()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener eIg = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.eIa = currentTimeMillis - c.this.eHZ <= 1;
                    }
                }
            }
        }
    };
    private boolean eIa = false;
    private boolean eIb = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bjR() {
        if (eIc == null) {
            synchronized (c.class) {
                if (eIc == null) {
                    eIc = new c();
                }
            }
        }
        return eIc;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.eIe);
        MessageManager.getInstance().registerListener(this.eIf);
        MessageManager.getInstance().registerListener(this.eId);
        MessageManager.getInstance().registerListener(this.eIg);
        if (q.cUC().cUx() != null) {
            q.cUC().cUx().cUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjS() {
        this.eIb = true;
        this.eHZ = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bjT() {
        bjU();
        this.eIb = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.eIa) {
            this.eIa = false;
            return false;
        } else if (currentTimeMillis - this.eHZ <= 2 || currentTimeMillis - this.eHZ <= this.avZ) {
            return false;
        } else {
            k cUx = q.cUC().cUx();
            return (cUx != null ? cUx.cUr() : 3) < 3;
        }
    }

    private void bjU() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.avZ = adAdSense.aXP();
            if (this.avZ <= 0) {
                this.avZ = 86400;
                return;
            }
            return;
        }
        this.avZ = 300;
    }
}
