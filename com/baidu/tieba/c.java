package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.n;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class c {
    private static volatile c gca;
    private long gbX;
    private final int gbV = 2;
    private final int gbW = 3;
    private int interval = -1;
    private CustomMessageListener gcb = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dDm().dDh() != null) {
                r.dDm().dDh().dDa();
            }
        }
    };
    private CustomMessageListener gcc = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bJm();
            }
        }
    };
    private CustomMessageListener gcd = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.gbX != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity")) {
                        if (c.this.bJn()) {
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
                    if (c.this.bJn()) {
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
    private CustomMessageListener gce = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.gbY = currentTimeMillis - c.this.gbX <= 1;
                    }
                }
            }
        }
    };
    private boolean gbY = false;
    private boolean gbZ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bJl() {
        if (gca == null) {
            synchronized (c.class) {
                if (gca == null) {
                    gca = new c();
                }
            }
        }
        return gca;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.gcc);
        MessageManager.getInstance().registerListener(this.gcd);
        MessageManager.getInstance().registerListener(this.gcb);
        MessageManager.getInstance().registerListener(this.gce);
        if (r.dDm().dDh() != null) {
            r.dDm().dDh().dCZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        this.gbZ = true;
        this.gbX = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJn() {
        bJo();
        this.gbZ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.gbY) {
            this.gbY = false;
            return false;
        } else if (currentTimeMillis - this.gbX <= 2 || currentTimeMillis - this.gbX <= this.interval) {
            return false;
        } else {
            n dDh = r.dDm().dDh();
            return (dDh != null ? dDh.dDb() : 3) < 3;
        }
    }

    private void bJo() {
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
