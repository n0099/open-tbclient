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
    private static volatile c fkf;
    private long fkc;
    private final int fka = 2;
    private final int fkb = 3;
    private int aEH = -1;
    private CustomMessageListener fkg = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dnk().dnf() != null) {
                r.dnk().dnf().dmY();
            }
        }
    };
    private CustomMessageListener fkh = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bzl();
            }
        }
    };
    private CustomMessageListener fki = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fkc != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bzm()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bzm()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fkj = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fkd = currentTimeMillis - c.this.fkc <= 1;
                    }
                }
            }
        }
    };
    private boolean fkd = false;
    private boolean fke = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bzk() {
        if (fkf == null) {
            synchronized (c.class) {
                if (fkf == null) {
                    fkf = new c();
                }
            }
        }
        return fkf;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fkh);
        MessageManager.getInstance().registerListener(this.fki);
        MessageManager.getInstance().registerListener(this.fkg);
        MessageManager.getInstance().registerListener(this.fkj);
        if (r.dnk().dnf() != null) {
            r.dnk().dnf().dmX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzl() {
        this.fke = true;
        this.fkc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzm() {
        bzn();
        this.fke = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fkd) {
            this.fkd = false;
            return false;
        } else if (currentTimeMillis - this.fkc <= 2 || currentTimeMillis - this.fkc <= this.aEH) {
            return false;
        } else {
            l dnf = r.dnk().dnf();
            return (dnf != null ? dnf.dmZ() : 3) < 3;
        }
    }

    private void bzn() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aEH = adAdSense.bmx();
            if (this.aEH <= 0) {
                this.aEH = 86400;
                return;
            }
            return;
        }
        this.aEH = 300;
    }
}
