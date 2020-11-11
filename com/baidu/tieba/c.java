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
    private static volatile c fNx;
    private long fNu;
    private final int fNs = 2;
    private final int fNt = 3;
    private int aKy = -1;
    private CustomMessageListener fNy = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dAo().dAj() != null) {
                r.dAo().dAj().dAc();
            }
        }
    };
    private CustomMessageListener fNz = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bHy();
            }
        }
    };
    private CustomMessageListener fNA = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fNu != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bHz()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bHz()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fNB = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fNv = currentTimeMillis - c.this.fNu <= 1;
                    }
                }
            }
        }
    };
    private boolean fNv = false;
    private boolean fNw = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bHx() {
        if (fNx == null) {
            synchronized (c.class) {
                if (fNx == null) {
                    fNx = new c();
                }
            }
        }
        return fNx;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fNz);
        MessageManager.getInstance().registerListener(this.fNA);
        MessageManager.getInstance().registerListener(this.fNy);
        MessageManager.getInstance().registerListener(this.fNB);
        if (r.dAo().dAj() != null) {
            r.dAo().dAj().dAb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        this.fNw = true;
        this.fNu = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHz() {
        bHA();
        this.fNw = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fNv) {
            this.fNv = false;
            return false;
        } else if (currentTimeMillis - this.fNu <= 2 || currentTimeMillis - this.fNu <= this.aKy) {
            return false;
        } else {
            l dAj = r.dAo().dAj();
            return (dAj != null ? dAj.dAd() : 3) < 3;
        }
    }

    private void bHA() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aKy = adAdSense.buu();
            if (this.aKy <= 0) {
                this.aKy = 86400;
                return;
            }
            return;
        }
        this.aKy = 300;
    }
}
