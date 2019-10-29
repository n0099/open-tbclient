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
    private static volatile c dbs;
    private long dbp;
    private final int dbn = 2;
    private final int dbo = 3;
    private int TQ = -1;
    private CustomMessageListener dbt = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.cfL().cfG() != null) {
                r.cfL().cfG().cfy();
            }
        }
    };
    private CustomMessageListener dbu = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aAT();
            }
        }
    };
    private CustomMessageListener dbv = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.dbp != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aAU()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aAU()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener dbw = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.dbq = currentTimeMillis - c.this.dbp <= 1;
                    }
                }
            }
        }
    };
    private boolean dbq = false;
    private boolean dbr = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aAS() {
        if (dbs == null) {
            synchronized (c.class) {
                if (dbs == null) {
                    dbs = new c();
                }
            }
        }
        return dbs;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.dbu);
        MessageManager.getInstance().registerListener(this.dbv);
        MessageManager.getInstance().registerListener(this.dbt);
        MessageManager.getInstance().registerListener(this.dbw);
        if (r.cfL().cfG() != null) {
            r.cfL().cfG().cfx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAT() {
        this.dbr = true;
        this.dbp = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAU() {
        aAV();
        this.dbr = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.dbq) {
            this.dbq = false;
            return false;
        } else if (currentTimeMillis - this.dbp <= 2 || currentTimeMillis - this.dbp <= this.TQ) {
            return false;
        } else {
            l cfG = r.cfL().cfG();
            return (cfG != null ? cfG.cfz() : 3) < 3;
        }
    }

    private void aAV() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.TQ = adAdSense.aoZ();
            if (this.TQ <= 0) {
                this.TQ = 86400;
                return;
            }
            return;
        }
        this.TQ = 300;
    }
}
