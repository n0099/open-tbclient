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
    private static volatile b aXf;
    private long aXc;
    private final int aXa = 2;
    private final int aXb = 3;
    private int aXg = -1;
    private CustomMessageListener aXh = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.bll().blg() != null) {
                q.bll().blg().bkY();
            }
        }
    };
    private CustomMessageListener aXi = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Kp();
            }
        }
    };
    private CustomMessageListener aXj = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aXc != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Kq()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Kq()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aXk = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aXd = currentTimeMillis - b.this.aXc <= 1;
                    }
                }
            }
        }
    };
    private boolean aXd = false;
    private boolean aXe = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Ko() {
        if (aXf == null) {
            synchronized (b.class) {
                if (aXf == null) {
                    aXf = new b();
                }
            }
        }
        return aXf;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aXi);
        MessageManager.getInstance().registerListener(this.aXj);
        MessageManager.getInstance().registerListener(this.aXh);
        MessageManager.getInstance().registerListener(this.aXk);
        if (q.bll().blg() != null) {
            q.bll().blg().bkX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp() {
        this.aXe = true;
        this.aXc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kq() {
        Kr();
        this.aXe = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aXd) {
            this.aXd = false;
            return false;
        } else if (currentTimeMillis - this.aXc <= 2 || currentTimeMillis - this.aXc <= this.aXg) {
            return false;
        } else {
            m blg = q.bll().blg();
            return (blg != null ? blg.bkZ() : 3) < 3;
        }
    }

    private void Kr() {
        com.baidu.tbadk.coreExtra.data.b adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aXg = adAdSense.xL();
            if (this.aXg <= 0) {
                this.aXg = 86400;
                return;
            }
            return;
        }
        this.aXg = 300;
    }
}
