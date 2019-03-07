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
    private static volatile b cHs;
    private long cHp;
    private final int cHn = 2;
    private final int cHo = 3;
    private int interval = -1;
    private CustomMessageListener cHt = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bWG().bWB() != null) {
                r.bWG().bWB().bWt();
            }
        }
    };
    private CustomMessageListener cHu = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.auc();
            }
        }
    };
    private CustomMessageListener cHv = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cHp != 0) {
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
    private CustomMessageListener cHw = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cHq = currentTimeMillis - b.this.cHp <= 1;
                    }
                }
            }
        }
    };
    private boolean cHq = false;
    private boolean cHr = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aub() {
        if (cHs == null) {
            synchronized (b.class) {
                if (cHs == null) {
                    cHs = new b();
                }
            }
        }
        return cHs;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cHu);
        MessageManager.getInstance().registerListener(this.cHv);
        MessageManager.getInstance().registerListener(this.cHt);
        MessageManager.getInstance().registerListener(this.cHw);
        if (r.bWG().bWB() != null) {
            r.bWG().bWB().bWs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auc() {
        this.cHr = true;
        this.cHp = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aud() {
        aue();
        this.cHr = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cHq) {
            this.cHq = false;
            return false;
        } else if (currentTimeMillis - this.cHp <= 2 || currentTimeMillis - this.cHp <= this.interval) {
            return false;
        } else {
            l bWB = r.bWG().bWB();
            return (bWB != null ? bWB.bWu() : 3) < 3;
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
