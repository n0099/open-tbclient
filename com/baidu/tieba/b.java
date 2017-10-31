package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recapp.m;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class b {
    private static volatile b aTW;
    private long aTT;
    private final int aTR = 2;
    private final int aTS = 3;
    private int aTX = -1;
    private CustomMessageListener aTY = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bja().biV() != null) {
                r.bja().biV().biN();
            }
        }
    };
    private CustomMessageListener aTZ = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.JH();
            }
        }
    };
    private CustomMessageListener aUa = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTT != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.JI()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.JI()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aUb = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTU = currentTimeMillis - b.this.aTT <= 1;
                    }
                }
            }
        }
    };
    private boolean aTU = false;
    private boolean aTV = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b JG() {
        if (aTW == null) {
            synchronized (b.class) {
                if (aTW == null) {
                    aTW = new b();
                }
            }
        }
        return aTW;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTZ);
        MessageManager.getInstance().registerListener(this.aUa);
        MessageManager.getInstance().registerListener(this.aTY);
        MessageManager.getInstance().registerListener(this.aUb);
        if (r.bja().biV() != null) {
            r.bja().biV().biM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JH() {
        this.aTV = true;
        this.aTT = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JI() {
        JJ();
        this.aTV = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTU) {
            this.aTU = false;
            return false;
        } else if (currentTimeMillis - this.aTT <= 2 || currentTimeMillis - this.aTT <= this.aTX) {
            return false;
        } else {
            m biV = r.bja().biV();
            return (biV != null ? biV.biO() : 3) < 3;
        }
    }

    private void JJ() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTX = adAdSense.xC();
            if (this.aTX <= 0) {
                this.aTX = 86400;
                return;
            }
            return;
        }
        this.aTX = 300;
    }
}
