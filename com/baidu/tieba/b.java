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
    private static volatile b aTR;
    private long aTO;
    private final int aTM = 2;
    private final int aTN = 3;
    private int aTS = -1;
    private CustomMessageListener aTT = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bfO().bfJ() != null) {
                r.bfO().bfJ().bfB();
            }
        }
    };
    private CustomMessageListener aTU = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Jx();
            }
        }
    };
    private CustomMessageListener aTV = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTO != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Jy()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Jy()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aTW = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTP = currentTimeMillis - b.this.aTO <= 1;
                    }
                }
            }
        }
    };
    private boolean aTP = false;
    private boolean aTQ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jw() {
        if (aTR == null) {
            synchronized (b.class) {
                if (aTR == null) {
                    aTR = new b();
                }
            }
        }
        return aTR;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTU);
        MessageManager.getInstance().registerListener(this.aTV);
        MessageManager.getInstance().registerListener(this.aTT);
        MessageManager.getInstance().registerListener(this.aTW);
        if (r.bfO().bfJ() != null) {
            r.bfO().bfJ().bfA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        this.aTQ = true;
        this.aTO = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jy() {
        Jz();
        this.aTQ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTP) {
            this.aTP = false;
            return false;
        } else if (currentTimeMillis - this.aTO <= 2 || currentTimeMillis - this.aTO <= this.aTS) {
            return false;
        } else {
            m bfJ = r.bfO().bfJ();
            return (bfJ != null ? bfJ.bfC() : 3) < 3;
        }
    }

    private void Jz() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTS = adAdSense.xv();
            if (this.aTS <= 0) {
                this.aTS = 86400;
                return;
            }
            return;
        }
        this.aTS = 300;
    }
}
