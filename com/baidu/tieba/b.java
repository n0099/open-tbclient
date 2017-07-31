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
    private static volatile b aTw;
    private long aTt;
    private final int aTr = 2;
    private final int aTs = 3;
    private int aTx = -1;
    private CustomMessageListener aTy = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bhF().bhC() != null) {
                r.bhF().bhC().bhu();
            }
        }
    };
    private CustomMessageListener aTz = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Jm();
            }
        }
    };
    private CustomMessageListener aTA = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTt != 0) {
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
    private CustomMessageListener aTB = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTu = currentTimeMillis - b.this.aTt <= 1;
                    }
                }
            }
        }
    };
    private boolean aTu = false;
    private boolean aTv = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jl() {
        if (aTw == null) {
            synchronized (b.class) {
                if (aTw == null) {
                    aTw = new b();
                }
            }
        }
        return aTw;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTz);
        MessageManager.getInstance().registerListener(this.aTA);
        MessageManager.getInstance().registerListener(this.aTy);
        MessageManager.getInstance().registerListener(this.aTB);
        if (r.bhF().bhC() != null) {
            r.bhF().bhC().bht();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm() {
        this.aTv = true;
        this.aTt = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jn() {
        Jo();
        this.aTv = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTu) {
            this.aTu = false;
            return false;
        } else if (currentTimeMillis - this.aTt <= 2 || currentTimeMillis - this.aTt <= this.aTx) {
            return false;
        } else {
            m bhC = r.bhF().bhC();
            return (bhC != null ? bhC.bhv() : 3) < 3;
        }
    }

    private void Jo() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTx = adAdSense.yb();
            if (this.aTx <= 0) {
                this.aTx = 86400;
                return;
            }
            return;
        }
        this.aTx = 300;
    }
}
