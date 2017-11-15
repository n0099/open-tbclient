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
    private static volatile b aUe;
    private long aUb;
    private final int aTZ = 2;
    private final int aUa = 3;
    private int aUf = -1;
    private CustomMessageListener aUg = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bjl().bjg() != null) {
                r.bjl().bjg().biY();
            }
        }
    };
    private CustomMessageListener aUh = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.JS();
            }
        }
    };
    private CustomMessageListener aUi = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aUb != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.JT()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.JT()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aUj = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aUc = currentTimeMillis - b.this.aUb <= 1;
                    }
                }
            }
        }
    };
    private boolean aUc = false;
    private boolean aUd = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b JR() {
        if (aUe == null) {
            synchronized (b.class) {
                if (aUe == null) {
                    aUe = new b();
                }
            }
        }
        return aUe;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aUh);
        MessageManager.getInstance().registerListener(this.aUi);
        MessageManager.getInstance().registerListener(this.aUg);
        MessageManager.getInstance().registerListener(this.aUj);
        if (r.bjl().bjg() != null) {
            r.bjl().bjg().biX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JS() {
        this.aUd = true;
        this.aUb = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JT() {
        JU();
        this.aUd = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aUc) {
            this.aUc = false;
            return false;
        } else if (currentTimeMillis - this.aUb <= 2 || currentTimeMillis - this.aUb <= this.aUf) {
            return false;
        } else {
            m bjg = r.bjl().bjg();
            return (bjg != null ? bjg.biZ() : 3) < 3;
        }
    }

    private void JU() {
        com.baidu.tbadk.coreExtra.data.b adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aUf = adAdSense.xK();
            if (this.aUf <= 0) {
                this.aUf = 86400;
                return;
            }
            return;
        }
        this.aUf = 300;
    }
}
