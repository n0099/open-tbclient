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
    private static volatile b bLi;
    private long bLf;
    private final int bLd = 2;
    private final int bLe = 3;
    private int bLj = -1;
    private CustomMessageListener bLk = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.bmR().bmM() != null) {
                q.bmR().bmM().bmE();
            }
        }
    };
    private CustomMessageListener bLl = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.RD();
            }
        }
    };
    private CustomMessageListener bLm = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bLf != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.RE()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.RE()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bLn = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bLg = currentTimeMillis - b.this.bLf <= 1;
                    }
                }
            }
        }
    };
    private boolean bLg = false;
    private boolean bLh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b RC() {
        if (bLi == null) {
            synchronized (b.class) {
                if (bLi == null) {
                    bLi = new b();
                }
            }
        }
        return bLi;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bLl);
        MessageManager.getInstance().registerListener(this.bLm);
        MessageManager.getInstance().registerListener(this.bLk);
        MessageManager.getInstance().registerListener(this.bLn);
        if (q.bmR().bmM() != null) {
            q.bmR().bmM().bmD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD() {
        this.bLh = true;
        this.bLf = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RE() {
        RF();
        this.bLh = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bLg) {
            this.bLg = false;
            return false;
        } else if (currentTimeMillis - this.bLf <= 2 || currentTimeMillis - this.bLf <= this.bLj) {
            return false;
        } else {
            m bmM = q.bmR().bmM();
            return (bmM != null ? bmM.bmF() : 3) < 3;
        }
    }

    private void RF() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bLj = adAdSense.Fc();
            if (this.bLj <= 0) {
                this.bLj = 86400;
                return;
            }
            return;
        }
        this.bLj = 300;
    }
}
