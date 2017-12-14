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
    private static volatile b aXh;
    private long aXe;
    private final int aXc = 2;
    private final int aXd = 3;
    private int aXi = -1;
    private CustomMessageListener aXj = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.blR().blM() != null) {
                q.blR().blM().blE();
            }
        }
    };
    private CustomMessageListener aXk = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Kq();
            }
        }
    };
    private CustomMessageListener aXl = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aXe != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Kr()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Kr()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aXm = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aXf = currentTimeMillis - b.this.aXe <= 1;
                    }
                }
            }
        }
    };
    private boolean aXf = false;
    private boolean aXg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Kp() {
        if (aXh == null) {
            synchronized (b.class) {
                if (aXh == null) {
                    aXh = new b();
                }
            }
        }
        return aXh;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aXk);
        MessageManager.getInstance().registerListener(this.aXl);
        MessageManager.getInstance().registerListener(this.aXj);
        MessageManager.getInstance().registerListener(this.aXm);
        if (q.blR().blM() != null) {
            q.blR().blM().blD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        this.aXg = true;
        this.aXe = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kr() {
        Ks();
        this.aXg = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aXf) {
            this.aXf = false;
            return false;
        } else if (currentTimeMillis - this.aXe <= 2 || currentTimeMillis - this.aXe <= this.aXi) {
            return false;
        } else {
            m blM = q.blR().blM();
            return (blM != null ? blM.blF() : 3) < 3;
        }
    }

    private void Ks() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aXi = adAdSense.xM();
            if (this.aXi <= 0) {
                this.aXi = 86400;
                return;
            }
            return;
        }
        this.aXi = 300;
    }
}
