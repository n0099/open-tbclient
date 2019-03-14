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
    private static volatile b cHp;
    private long cHm;
    private final int cHk = 2;
    private final int cHl = 3;
    private int interval = -1;
    private CustomMessageListener cHq = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bWJ().bWE() != null) {
                r.bWJ().bWE().bWw();
            }
        }
    };
    private CustomMessageListener cHr = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.auc();
            }
        }
    };
    private CustomMessageListener cHs = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cHm != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.aud()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.aud()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cHt = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cHn = currentTimeMillis - b.this.cHm <= 1;
                    }
                }
            }
        }
    };
    private boolean cHn = false;
    private boolean cHo = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aub() {
        if (cHp == null) {
            synchronized (b.class) {
                if (cHp == null) {
                    cHp = new b();
                }
            }
        }
        return cHp;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cHr);
        MessageManager.getInstance().registerListener(this.cHs);
        MessageManager.getInstance().registerListener(this.cHq);
        MessageManager.getInstance().registerListener(this.cHt);
        if (r.bWJ().bWE() != null) {
            r.bWJ().bWE().bWv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auc() {
        this.cHo = true;
        this.cHm = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aud() {
        aue();
        this.cHo = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cHn) {
            this.cHn = false;
            return false;
        } else if (currentTimeMillis - this.cHm <= 2 || currentTimeMillis - this.cHm <= this.interval) {
            return false;
        } else {
            l bWE = r.bWJ().bWE();
            return (bWE != null ? bWE.bWx() : 3) < 3;
        }
    }

    private void aue() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.agf();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
