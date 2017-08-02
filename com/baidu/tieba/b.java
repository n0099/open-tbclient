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
    private static volatile b aSk;
    private long aSh;
    private final int aSf = 2;
    private final int aSg = 3;
    private int aSl = -1;
    private CustomMessageListener aSm = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bhv().bhs() != null) {
                r.bhv().bhs().bhk();
            }
        }
    };
    private CustomMessageListener aSn = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Jf();
            }
        }
    };
    private CustomMessageListener aSo = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aSh != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Jg()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Jg()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aSp = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aSi = currentTimeMillis - b.this.aSh <= 1;
                    }
                }
            }
        }
    };
    private boolean aSi = false;
    private boolean aSj = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Je() {
        if (aSk == null) {
            synchronized (b.class) {
                if (aSk == null) {
                    aSk = new b();
                }
            }
        }
        return aSk;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aSn);
        MessageManager.getInstance().registerListener(this.aSo);
        MessageManager.getInstance().registerListener(this.aSm);
        MessageManager.getInstance().registerListener(this.aSp);
        if (r.bhv().bhs() != null) {
            r.bhv().bhs().bhj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jf() {
        this.aSj = true;
        this.aSh = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jg() {
        Jh();
        this.aSj = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aSi) {
            this.aSi = false;
            return false;
        } else if (currentTimeMillis - this.aSh <= 2 || currentTimeMillis - this.aSh <= this.aSl) {
            return false;
        } else {
            m bhs = r.bhv().bhs();
            return (bhs != null ? bhs.bhl() : 3) < 3;
        }
    }

    private void Jh() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aSl = adAdSense.xT();
            if (this.aSl <= 0) {
                this.aSl = 86400;
                return;
            }
            return;
        }
        this.aSl = 300;
    }
}
