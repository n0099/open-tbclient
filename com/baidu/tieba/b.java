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
    private static volatile b aXl;
    private long aXi;
    private final int aXg = 2;
    private final int aXh = 3;
    private int aXm = -1;
    private CustomMessageListener aXn = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && q.blR().blM() != null) {
                q.blR().blM().blE();
            }
        }
    };
    private CustomMessageListener aXo = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Kq();
            }
        }
    };
    private CustomMessageListener aXp = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aXi != 0) {
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
    private CustomMessageListener aXq = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aXj = currentTimeMillis - b.this.aXi <= 1;
                    }
                }
            }
        }
    };
    private boolean aXj = false;
    private boolean aXk = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Kp() {
        if (aXl == null) {
            synchronized (b.class) {
                if (aXl == null) {
                    aXl = new b();
                }
            }
        }
        return aXl;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aXo);
        MessageManager.getInstance().registerListener(this.aXp);
        MessageManager.getInstance().registerListener(this.aXn);
        MessageManager.getInstance().registerListener(this.aXq);
        if (q.blR().blM() != null) {
            q.blR().blM().blD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        this.aXk = true;
        this.aXi = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Kr() {
        Ks();
        this.aXk = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aXj) {
            this.aXj = false;
            return false;
        } else if (currentTimeMillis - this.aXi <= 2 || currentTimeMillis - this.aXi <= this.aXm) {
            return false;
        } else {
            m blM = q.blR().blM();
            return (blM != null ? blM.blF() : 3) < 3;
        }
    }

    private void Ks() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aXm = adAdSense.xM();
            if (this.aXm <= 0) {
                this.aXm = 86400;
                return;
            }
            return;
        }
        this.aXm = 300;
    }
}
