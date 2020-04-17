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
    private static volatile c etn;
    private long etk;
    private final int eti = 2;
    private final int etj = 3;
    private int aqT = -1;
    private CustomMessageListener eto = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.cNo().cNj() != null) {
                q.cNo().cNj().cNc();
            }
        }
    };
    private CustomMessageListener etp = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bdH();
            }
        }
    };
    private CustomMessageListener etq = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.etk != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bdI()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bdI()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener etr = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.etl = currentTimeMillis - c.this.etk <= 1;
                    }
                }
            }
        }
    };
    private boolean etl = false;
    private boolean etm = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bdG() {
        if (etn == null) {
            synchronized (c.class) {
                if (etn == null) {
                    etn = new c();
                }
            }
        }
        return etn;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.etp);
        MessageManager.getInstance().registerListener(this.etq);
        MessageManager.getInstance().registerListener(this.eto);
        MessageManager.getInstance().registerListener(this.etr);
        if (q.cNo().cNj() != null) {
            q.cNo().cNj().cNb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdH() {
        this.etm = true;
        this.etk = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdI() {
        bdJ();
        this.etm = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.etl) {
            this.etl = false;
            return false;
        } else if (currentTimeMillis - this.etk <= 2 || currentTimeMillis - this.etk <= this.aqT) {
            return false;
        } else {
            k cNj = q.cNo().cNj();
            return (cNj != null ? cNj.cNd() : 3) < 3;
        }
    }

    private void bdJ() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aqT = adAdSense.aRK();
            if (this.aqT <= 0) {
                this.aqT = 86400;
                return;
            }
            return;
        }
        this.aqT = 300;
    }
}
