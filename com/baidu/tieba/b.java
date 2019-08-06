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
public class b {
    private static volatile b cRf;
    private long cRc;
    private final int cRa = 2;
    private final int cRb = 3;
    private int interval = -1;
    private CustomMessageListener cRg = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.chV().chQ() != null) {
                r.chV().chQ().chI();
            }
        }
    };
    private CustomMessageListener cRh = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.aAv();
            }
        }
    };
    private CustomMessageListener cRi = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cRc != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && b.this.aAw()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.aAw()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cRj = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cRd = currentTimeMillis - b.this.cRc <= 1;
                    }
                }
            }
        }
    };
    private boolean cRd = false;
    private boolean cRe = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aAu() {
        if (cRf == null) {
            synchronized (b.class) {
                if (cRf == null) {
                    cRf = new b();
                }
            }
        }
        return cRf;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cRh);
        MessageManager.getInstance().registerListener(this.cRi);
        MessageManager.getInstance().registerListener(this.cRg);
        MessageManager.getInstance().registerListener(this.cRj);
        if (r.chV().chQ() != null) {
            r.chV().chQ().chH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAv() {
        this.cRe = true;
        this.cRc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAw() {
        aAx();
        this.cRe = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cRd) {
            this.cRd = false;
            return false;
        } else if (currentTimeMillis - this.cRc <= 2 || currentTimeMillis - this.cRc <= this.interval) {
            return false;
        } else {
            l chQ = r.chV().chQ();
            return (chQ != null ? chQ.chJ() : 3) < 3;
        }
    }

    private void aAx() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.ami();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
