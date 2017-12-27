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
    private static volatile b bLa;
    private long bKX;
    private final int bKV = 2;
    private final int bKW = 3;
    private int bLb = -1;
    private CustomMessageListener bLc = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.bty().btt() != null) {
                q.bty().btt().btl();
            }
        }
    };
    private CustomMessageListener bLd = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.RP();
            }
        }
    };
    private CustomMessageListener bLe = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bKX != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.RQ()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.RQ()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bLf = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bKY = currentTimeMillis - b.this.bKX <= 1;
                    }
                }
            }
        }
    };
    private boolean bKY = false;
    private boolean bKZ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b RO() {
        if (bLa == null) {
            synchronized (b.class) {
                if (bLa == null) {
                    bLa = new b();
                }
            }
        }
        return bLa;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bLd);
        MessageManager.getInstance().registerListener(this.bLe);
        MessageManager.getInstance().registerListener(this.bLc);
        MessageManager.getInstance().registerListener(this.bLf);
        if (q.bty().btt() != null) {
            q.bty().btt().btk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RP() {
        this.bKZ = true;
        this.bKX = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RQ() {
        RR();
        this.bKZ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bKY) {
            this.bKY = false;
            return false;
        } else if (currentTimeMillis - this.bKX <= 2 || currentTimeMillis - this.bKX <= this.bLb) {
            return false;
        } else {
            m btt = q.bty().btt();
            return (btt != null ? btt.btm() : 3) < 3;
        }
    }

    private void RR() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bLb = adAdSense.Fl();
            if (this.bLb <= 0) {
                this.bLb = 86400;
                return;
            }
            return;
        }
        this.bLb = 300;
    }
}
