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
    private static volatile c fHH;
    private long fHE;
    private final int fHC = 2;
    private final int fHD = 3;
    private int aJy = -1;
    private CustomMessageListener fHI = new CustomMessageListener(CmdConfigCustom.CMD_HOT_SPLASH_SHOW) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.dxM().dxH() != null) {
                r.dxM().dxH().dxA();
            }
        }
    };
    private CustomMessageListener fHJ = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.bEZ();
            }
        }
    };
    private CustomMessageListener fHK = new CustomMessageListener(CmdConfigCustom.CMD_APP_ENTER_FOREGROUND) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.fHE != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.bFa()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.bFa()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener fHL = new CustomMessageListener(CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.fHF = currentTimeMillis - c.this.fHE <= 1;
                    }
                }
            }
        }
    };
    private boolean fHF = false;
    private boolean fHG = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c bEY() {
        if (fHH == null) {
            synchronized (c.class) {
                if (fHH == null) {
                    fHH = new c();
                }
            }
        }
        return fHH;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.fHJ);
        MessageManager.getInstance().registerListener(this.fHK);
        MessageManager.getInstance().registerListener(this.fHI);
        MessageManager.getInstance().registerListener(this.fHL);
        if (r.dxM().dxH() != null) {
            r.dxM().dxH().dxz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEZ() {
        this.fHG = true;
        this.fHE = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFa() {
        bFb();
        this.fHG = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.fHF) {
            this.fHF = false;
            return false;
        } else if (currentTimeMillis - this.fHE <= 2 || currentTimeMillis - this.fHE <= this.aJy) {
            return false;
        } else {
            l dxH = r.dxM().dxH();
            return (dxH != null ? dxH.dxB() : 3) < 3;
        }
    }

    private void bFb() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aJy = adAdSense.brU();
            if (this.aJy <= 0) {
                this.aJy = 86400;
                return;
            }
            return;
        }
        this.aJy = 300;
    }
}
