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
    private static volatile b aTf;
    private long aTc;
    private final int aTa = 2;
    private final int aTb = 3;
    private int aTg = -1;
    private CustomMessageListener aTh = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bho().bhj() != null) {
                r.bho().bhj().bhb();
            }
        }
    };
    private CustomMessageListener aTi = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Ju();
            }
        }
    };
    private CustomMessageListener aTj = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aTc != 0) {
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
    private CustomMessageListener aTk = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aTd = currentTimeMillis - b.this.aTc <= 1;
                    }
                }
            }
        }
    };
    private boolean aTd = false;
    private boolean aTe = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jt() {
        if (aTf == null) {
            synchronized (b.class) {
                if (aTf == null) {
                    aTf = new b();
                }
            }
        }
        return aTf;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aTi);
        MessageManager.getInstance().registerListener(this.aTj);
        MessageManager.getInstance().registerListener(this.aTh);
        MessageManager.getInstance().registerListener(this.aTk);
        if (r.bho().bhj() != null) {
            r.bho().bhj().bha();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        this.aTe = true;
        this.aTc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jv() {
        Jw();
        this.aTe = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aTd) {
            this.aTd = false;
            return false;
        } else if (currentTimeMillis - this.aTc <= 2 || currentTimeMillis - this.aTc <= this.aTg) {
            return false;
        } else {
            m bhj = r.bho().bhj();
            return (bhj != null ? bhj.bhc() : 3) < 3;
        }
    }

    private void Jw() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aTg = adAdSense.yd();
            if (this.aTg <= 0) {
                this.aTg = 86400;
                return;
            }
            return;
        }
        this.aTg = 300;
    }
}
