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
    private static volatile c eYJ;
    private long eYG;
    private final int eYE = 2;
    private final int eYF = 3;
    private int azu = -1;
    private CustomMessageListener eYK = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dca().dbV() != null) {
                r.dca().dbV().dbO();
            }
        }
    };
    private CustomMessageListener eYL = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bqm();
            }
        }
    };
    private CustomMessageListener eYM = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.eYG != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bqn()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bqn()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener eYN = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.eYH = currentTimeMillis - c.this.eYG <= 1;
                    }
                }
            }
        }
    };
    private boolean eYH = false;
    private boolean eYI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bql() {
        if (eYJ == null) {
            synchronized (c.class) {
                if (eYJ == null) {
                    eYJ = new c();
                }
            }
        }
        return eYJ;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.eYL);
        MessageManager.getInstance().registerListener(this.eYM);
        MessageManager.getInstance().registerListener(this.eYK);
        MessageManager.getInstance().registerListener(this.eYN);
        if (r.dca().dbV() != null) {
            r.dca().dbV().dbN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqm() {
        this.eYI = true;
        this.eYG = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqn() {
        bqo();
        this.eYI = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.eYH) {
            this.eYH = false;
            return false;
        } else if (currentTimeMillis - this.eYG <= 2 || currentTimeMillis - this.eYG <= this.azu) {
            return false;
        } else {
            l dbV = r.dca().dbV();
            return (dbV != null ? dbV.dbP() : 3) < 3;
        }
    }

    private void bqo() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.azu = adAdSense.bdR();
            if (this.azu <= 0) {
                this.azu = 86400;
                return;
            }
            return;
        }
        this.azu = 300;
    }
}
