package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class c {
    private static volatile c gcf;
    private long gcc;
    private final int gca = 2;
    private final int gcb = 3;
    private int interval = -1;
    private CustomMessageListener gcg = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && s.dDt().dDo() != null) {
                s.dDt().dDo().dDh();
            }
        }
    };
    private CustomMessageListener gch = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bJr();
            }
        }
    };
    private CustomMessageListener gci = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.gcc != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity")) {
                        if (c.this.bJs()) {
                            BaseActivity baseActivity = (BaseActivity) data;
                            Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                            intent.putExtra("splash", true);
                            intent.setFlags(65536);
                            baseActivity.startActivity(intent);
                            TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                            return;
                        }
                        TbadkCoreApplication.getInst().setCanShowHotSplash(1);
                    }
                } else if (data instanceof BaseFragmentActivity) {
                    if (c.this.bJs()) {
                        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                        Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                        intent2.putExtra("splash", true);
                        intent2.setFlags(65536);
                        baseFragmentActivity.getActivity().startActivity(intent2);
                        TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                        return;
                    }
                    TbadkCoreApplication.getInst().setCanShowHotSplash(1);
                }
            }
        }
    };
    private CustomMessageListener gcj = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.gcd = currentTimeMillis - c.this.gcc <= 1;
                    }
                }
            }
        }
    };
    private boolean gcd = false;
    private boolean gce = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bJq() {
        if (gcf == null) {
            synchronized (c.class) {
                if (gcf == null) {
                    gcf = new c();
                }
            }
        }
        return gcf;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.gch);
        MessageManager.getInstance().registerListener(this.gci);
        MessageManager.getInstance().registerListener(this.gcg);
        MessageManager.getInstance().registerListener(this.gcj);
        if (s.dDt().dDo() != null) {
            s.dDt().dDo().dDg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        this.gce = true;
        this.gcc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJs() {
        bJt();
        this.gce = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.gcd) {
            this.gcd = false;
            return false;
        } else if (currentTimeMillis - this.gcc <= 2 || currentTimeMillis - this.gcc <= this.interval) {
            return false;
        } else {
            o dDo = s.dDt().dDo();
            return (dDo != null ? dDo.dDi() : 3) < 3;
        }
    }

    private void bJt() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.bwd();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
