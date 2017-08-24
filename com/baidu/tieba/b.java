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
    private static volatile b aTy;
    private long aTv;
    private final int aTt = 2;
    private final int aTu = 3;
    private int aTz = -1;
    private CustomMessageListener aTA = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.big().bid() != null) {
                r.big().bid().bhV();
            }
        }
    };
    private CustomMessageListener aTB = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Jm();
            }
        }
    };
    private CustomMessageListener aTC = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTv != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Jn()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Jn()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aTD = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTw = currentTimeMillis - b.this.aTv <= 1;
                    }
                }
            }
        }
    };
    private boolean aTw = false;
    private boolean aTx = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jl() {
        if (aTy == null) {
            synchronized (b.class) {
                if (aTy == null) {
                    aTy = new b();
                }
            }
        }
        return aTy;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTB);
        MessageManager.getInstance().registerListener(this.aTC);
        MessageManager.getInstance().registerListener(this.aTA);
        MessageManager.getInstance().registerListener(this.aTD);
        if (r.big().bid() != null) {
            r.big().bid().bhU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm() {
        this.aTx = true;
        this.aTv = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jn() {
        Jo();
        this.aTx = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTw) {
            this.aTw = false;
            return false;
        } else if (currentTimeMillis - this.aTv <= 2 || currentTimeMillis - this.aTv <= this.aTz) {
            return false;
        } else {
            m bid = r.big().bid();
            return (bid != null ? bid.bhW() : 3) < 3;
        }
    }

    private void Jo() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTz = adAdSense.yb();
            if (this.aTz <= 0) {
                this.aTz = 86400;
                return;
            }
            return;
        }
        this.aTz = 300;
    }
}
