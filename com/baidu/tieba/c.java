package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.r;
/* loaded from: classes.dex */
public class c {
    private static volatile c cRY;
    private long cRV;
    private final int cRT = 2;
    private final int cRU = 3;
    private int interval = -1;
    private CustomMessageListener cRZ = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.ciJ().ciE() != null) {
                r.ciJ().ciE().ciw();
            }
        }
    };
    private CustomMessageListener cSa = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                c.this.aAJ();
            }
        }
    };
    private CustomMessageListener cSb = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && c.this.cRV != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && c.this.aAK()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && c.this.aAK()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cSc = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c.this.cRW = currentTimeMillis - c.this.cRV <= 1;
                    }
                }
            }
        }
    };
    private boolean cRW = false;
    private boolean cRX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c aAI() {
        if (cRY == null) {
            synchronized (c.class) {
                if (cRY == null) {
                    cRY = new c();
                }
            }
        }
        return cRY;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.cSa);
        MessageManager.getInstance().registerListener(this.cSb);
        MessageManager.getInstance().registerListener(this.cRZ);
        MessageManager.getInstance().registerListener(this.cSc);
        if (r.ciJ().ciE() != null) {
            r.ciJ().ciE().civ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAJ() {
        this.cRX = true;
        this.cRV = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAK() {
        aAL();
        this.cRX = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cRW) {
            this.cRW = false;
            return false;
        } else if (currentTimeMillis - this.cRV <= 2 || currentTimeMillis - this.cRV <= this.interval) {
            return false;
        } else {
            l ciE = r.ciJ().ciE();
            return (ciE != null ? ciE.cix() : 3) < 3;
        }
    }

    private void aAL() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.amu();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
