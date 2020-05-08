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
    private static volatile c ets;
    private long etp;
    private final int etn = 2;
    private final int eto = 3;
    private int aqZ = -1;
    private CustomMessageListener ett = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.cNl().cNg() != null) {
                q.cNl().cNg().cMZ();
            }
        }
    };
    private CustomMessageListener etu = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bdF();
            }
        }
    };
    private CustomMessageListener etv = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.etp != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bdG()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bdG()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener etw = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.etq = currentTimeMillis - c.this.etp <= 1;
                    }
                }
            }
        }
    };
    private boolean etq = false;
    private boolean etr = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bdE() {
        if (ets == null) {
            synchronized (c.class) {
                if (ets == null) {
                    ets = new c();
                }
            }
        }
        return ets;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.etu);
        MessageManager.getInstance().registerListener(this.etv);
        MessageManager.getInstance().registerListener(this.ett);
        MessageManager.getInstance().registerListener(this.etw);
        if (q.cNl().cNg() != null) {
            q.cNl().cNg().cMY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdF() {
        this.etr = true;
        this.etp = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdG() {
        bdH();
        this.etr = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.etq) {
            this.etq = false;
            return false;
        } else if (currentTimeMillis - this.etp <= 2 || currentTimeMillis - this.etp <= this.aqZ) {
            return false;
        } else {
            k cNg = q.cNl().cNg();
            return (cNg != null ? cNg.cNa() : 3) < 3;
        }
    }

    private void bdH() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aqZ = adAdSense.aRH();
            if (this.aqZ <= 0) {
                this.aqZ = 86400;
                return;
            }
            return;
        }
        this.aqZ = 300;
    }
}
