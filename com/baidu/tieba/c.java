package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class c {
    private static volatile c fkb;
    private long fjY;
    private final int fjW = 2;
    private final int fjX = 3;
    private int aEF = -1;
    private CustomMessageListener fkc = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dnh().dnc() != null) {
                r.dnh().dnc().dmV();
            }
        }
    };
    private CustomMessageListener fkd = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bzk();
            }
        }
    };
    private CustomMessageListener fke = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fjY != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bzl()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bzl()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fkf = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fjZ = currentTimeMillis - c.this.fjY <= 1;
                    }
                }
            }
        }
    };
    private boolean fjZ = false;
    private boolean fka = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bzj() {
        if (fkb == null) {
            synchronized (c.class) {
                if (fkb == null) {
                    fkb = new c();
                }
            }
        }
        return fkb;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fkd);
        MessageManager.getInstance().registerListener(this.fke);
        MessageManager.getInstance().registerListener(this.fkc);
        MessageManager.getInstance().registerListener(this.fkf);
        if (r.dnh().dnc() != null) {
            r.dnh().dnc().dmU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        this.fka = true;
        this.fjY = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzl() {
        bzm();
        this.fka = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fjZ) {
            this.fjZ = false;
            return false;
        } else if (currentTimeMillis - this.fjY <= 2 || currentTimeMillis - this.fjY <= this.aEF) {
            return false;
        } else {
            l dnc = r.dnh().dnc();
            return (dnc != null ? dnc.dmW() : 3) < 3;
        }
    }

    private void bzm() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aEF = adAdSense.bmx();
            if (this.aEF <= 0) {
                this.aEF = 86400;
                return;
            }
            return;
        }
        this.aEF = 300;
    }
}
