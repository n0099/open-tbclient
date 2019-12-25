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
    private static volatile c dOw;
    private long dOt;
    private final int dOr = 2;
    private final int dOs = 3;
    private int aam = -1;
    private CustomMessageListener dOx = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.czO().czJ() != null) {
                r.czO().czJ().czC();
            }
        }
    };
    private CustomMessageListener dOy = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aSF();
            }
        }
    };
    private CustomMessageListener dOz = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dOt != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aSG()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aSG()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dOA = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dOu = currentTimeMillis - c.this.dOt <= 1;
                    }
                }
            }
        }
    };
    private boolean dOu = false;
    private boolean dOv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aSE() {
        if (dOw == null) {
            synchronized (c.class) {
                if (dOw == null) {
                    dOw = new c();
                }
            }
        }
        return dOw;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dOy);
        MessageManager.getInstance().registerListener(this.dOz);
        MessageManager.getInstance().registerListener(this.dOx);
        MessageManager.getInstance().registerListener(this.dOA);
        if (r.czO().czJ() != null) {
            r.czO().czJ().czB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSF() {
        this.dOv = true;
        this.dOt = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSG() {
        aSH();
        this.dOv = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dOu) {
            this.dOu = false;
            return false;
        } else if (currentTimeMillis - this.dOt <= 2 || currentTimeMillis - this.dOt <= this.aam) {
            return false;
        } else {
            l czJ = r.czO().czJ();
            return (czJ != null ? czJ.czD() : 3) < 3;
        }
    }

    private void aSH() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aam = adAdSense.aGz();
            if (this.aam <= 0) {
                this.aam = 86400;
                return;
            }
            return;
        }
        this.aam = 300;
    }
}
