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
    private static volatile b aTi;
    private long aTf;
    private final int aTd = 2;
    private final int aTe = 3;
    private int aTj = -1;
    private CustomMessageListener aTk = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bhd().bgY() != null) {
                r.bhd().bgY().bgQ();
            }
        }
    };
    private CustomMessageListener aTl = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Ju();
            }
        }
    };
    private CustomMessageListener aTm = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTf != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Jv()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Jv()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aTn = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTg = currentTimeMillis - b.this.aTf <= 1;
                    }
                }
            }
        }
    };
    private boolean aTg = false;
    private boolean aTh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jt() {
        if (aTi == null) {
            synchronized (b.class) {
                if (aTi == null) {
                    aTi = new b();
                }
            }
        }
        return aTi;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTl);
        MessageManager.getInstance().registerListener(this.aTm);
        MessageManager.getInstance().registerListener(this.aTk);
        MessageManager.getInstance().registerListener(this.aTn);
        if (r.bhd().bgY() != null) {
            r.bhd().bgY().bgP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        this.aTh = true;
        this.aTf = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jv() {
        Jw();
        this.aTh = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTg) {
            this.aTg = false;
            return false;
        } else if (currentTimeMillis - this.aTf <= 2 || currentTimeMillis - this.aTf <= this.aTj) {
            return false;
        } else {
            m bgY = r.bhd().bgY();
            return (bgY != null ? bgY.bgR() : 3) < 3;
        }
    }

    private void Jw() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTj = adAdSense.yd();
            if (this.aTj <= 0) {
                this.aTj = 86400;
                return;
            }
            return;
        }
        this.aTj = 300;
    }
}
