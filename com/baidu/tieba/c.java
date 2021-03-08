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
    private static volatile c gdG;
    private long gdD;
    private final int gdB = 2;
    private final int gdC = 3;
    private int interval = -1;
    private CustomMessageListener gdH = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && s.dDB().dDw() != null) {
                s.dDB().dDw().dDp();
            }
        }
    };
    private CustomMessageListener gdI = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bJv();
            }
        }
    };
    private CustomMessageListener gdJ = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.gdD != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity")) {
                        if (c.this.bJw()) {
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
                    if (c.this.bJw()) {
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
    private CustomMessageListener gdK = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.gdE = currentTimeMillis - c.this.gdD <= 1;
                    }
                }
            }
        }
    };
    private boolean gdE = false;
    private boolean gdF = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bJu() {
        if (gdG == null) {
            synchronized (c.class) {
                if (gdG == null) {
                    gdG = new c();
                }
            }
        }
        return gdG;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.gdI);
        MessageManager.getInstance().registerListener(this.gdJ);
        MessageManager.getInstance().registerListener(this.gdH);
        MessageManager.getInstance().registerListener(this.gdK);
        if (s.dDB().dDw() != null) {
            s.dDB().dDw().dDo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJv() {
        this.gdF = true;
        this.gdD = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJw() {
        bJx();
        this.gdF = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.gdE) {
            this.gdE = false;
            return false;
        } else if (currentTimeMillis - this.gdD <= 2 || currentTimeMillis - this.gdD <= this.interval) {
            return false;
        } else {
            o dDw = s.dDB().dDw();
            return (dDw != null ? dDw.dDq() : 3) < 3;
        }
    }

    private void bJx() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.bwg();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
