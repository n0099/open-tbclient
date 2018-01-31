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
import com.baidu.tieba.recapp.q;
/* loaded from: classes.dex */
public class b {
    private static volatile b bLq;
    private long bLn;
    private final int bLl = 2;
    private final int bLm = 3;
    private int bLr = -1;
    private CustomMessageListener bLs = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.bmS().bmN() != null) {
                q.bmS().bmN().bmF();
            }
        }
    };
    private CustomMessageListener bLt = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.RF();
            }
        }
    };
    private CustomMessageListener bLu = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bLn != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.RG()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.RG()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bLv = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bLo = currentTimeMillis - b.this.bLn <= 1;
                    }
                }
            }
        }
    };
    private boolean bLo = false;
    private boolean bLp = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b RE() {
        if (bLq == null) {
            synchronized (b.class) {
                if (bLq == null) {
                    bLq = new b();
                }
            }
        }
        return bLq;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bLt);
        MessageManager.getInstance().registerListener(this.bLu);
        MessageManager.getInstance().registerListener(this.bLs);
        MessageManager.getInstance().registerListener(this.bLv);
        if (q.bmS().bmN() != null) {
            q.bmS().bmN().bmE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF() {
        this.bLp = true;
        this.bLn = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RG() {
        RH();
        this.bLp = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bLo) {
            this.bLo = false;
            return false;
        } else if (currentTimeMillis - this.bLn <= 2 || currentTimeMillis - this.bLn <= this.bLr) {
            return false;
        } else {
            m bmN = q.bmS().bmN();
            return (bmN != null ? bmN.bmG() : 3) < 3;
        }
    }

    private void RH() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bLr = adAdSense.Fe();
            if (this.bLr <= 0) {
                this.bLr = 86400;
                return;
            }
            return;
        }
        this.bLr = 300;
    }
}
