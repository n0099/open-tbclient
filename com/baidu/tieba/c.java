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
    private static volatile c fzm;
    private long fzj;
    private final int fzh = 2;
    private final int fzi = 3;
    private int aIW = -1;
    private CustomMessageListener fzn = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.duF().duA() != null) {
                r.duF().duA().dut();
            }
        }
    };
    private CustomMessageListener fzo = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bDg();
            }
        }
    };
    private CustomMessageListener fzp = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fzj != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bDh()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bDh()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fzq = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fzk = currentTimeMillis - c.this.fzj <= 1;
                    }
                }
            }
        }
    };
    private boolean fzk = false;
    private boolean fzl = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bDf() {
        if (fzm == null) {
            synchronized (c.class) {
                if (fzm == null) {
                    fzm = new c();
                }
            }
        }
        return fzm;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fzo);
        MessageManager.getInstance().registerListener(this.fzp);
        MessageManager.getInstance().registerListener(this.fzn);
        MessageManager.getInstance().registerListener(this.fzq);
        if (r.duF().duA() != null) {
            r.duF().duA().dus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDg() {
        this.fzl = true;
        this.fzj = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDh() {
        bDi();
        this.fzl = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fzk) {
            this.fzk = false;
            return false;
        } else if (currentTimeMillis - this.fzj <= 2 || currentTimeMillis - this.fzj <= this.aIW) {
            return false;
        } else {
            l duA = r.duF().duA();
            return (duA != null ? duA.duu() : 3) < 3;
        }
    }

    private void bDi() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aIW = adAdSense.bqb();
            if (this.aIW <= 0) {
                this.aIW = 86400;
                return;
            }
            return;
        }
        this.aIW = 300;
    }
}
