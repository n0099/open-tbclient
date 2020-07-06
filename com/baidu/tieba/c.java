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
    private static volatile c eSo;
    private long eSl;
    private final int eSj = 2;
    private final int eSk = 3;
    private int ayh = -1;
    private CustomMessageListener eSp = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.cYT().cYO() != null) {
                q.cYT().cYO().cYH();
            }
        }
    };
    private CustomMessageListener eSq = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bms();
            }
        }
    };
    private CustomMessageListener eSr = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.eSl != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bmt()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bmt()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener eSs = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.eSm = currentTimeMillis - c.this.eSl <= 1;
                    }
                }
            }
        }
    };
    private boolean eSm = false;
    private boolean eSn = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bmr() {
        if (eSo == null) {
            synchronized (c.class) {
                if (eSo == null) {
                    eSo = new c();
                }
            }
        }
        return eSo;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.eSq);
        MessageManager.getInstance().registerListener(this.eSr);
        MessageManager.getInstance().registerListener(this.eSp);
        MessageManager.getInstance().registerListener(this.eSs);
        if (q.cYT().cYO() != null) {
            q.cYT().cYO().cYG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bms() {
        this.eSn = true;
        this.eSl = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmt() {
        bmu();
        this.eSn = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.eSm) {
            this.eSm = false;
            return false;
        } else if (currentTimeMillis - this.eSl <= 2 || currentTimeMillis - this.eSl <= this.ayh) {
            return false;
        } else {
            k cYO = q.cYT().cYO();
            return (cYO != null ? cYO.cYI() : 3) < 3;
        }
    }

    private void bmu() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.ayh = adAdSense.aZU();
            if (this.ayh <= 0) {
                this.ayh = 86400;
                return;
            }
            return;
        }
        this.ayh = 300;
    }
}
