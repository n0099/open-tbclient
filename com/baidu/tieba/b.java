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
    private static volatile b bhl;
    private long bhi;
    private final int bhg = 2;
    private final int bhh = 3;
    private int interval = -1;
    private CustomMessageListener bhm = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bno().bnj() != null) {
                r.bno().bnj().bnb();
            }
        }
    };
    private CustomMessageListener bhn = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.OC();
            }
        }
    };
    private CustomMessageListener bho = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bhi != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.OD()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.OD()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bhp = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bhj = currentTimeMillis - b.this.bhi <= 1;
                    }
                }
            }
        }
    };
    private boolean bhj = false;
    private boolean bhk = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b OB() {
        if (bhl == null) {
            synchronized (b.class) {
                if (bhl == null) {
                    bhl = new b();
                }
            }
        }
        return bhl;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bhn);
        MessageManager.getInstance().registerListener(this.bho);
        MessageManager.getInstance().registerListener(this.bhm);
        MessageManager.getInstance().registerListener(this.bhp);
        if (r.bno().bnj() != null) {
            r.bno().bnj().bna();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        this.bhk = true;
        this.bhi = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OD() {
        OE();
        this.bhk = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bhj) {
            this.bhj = false;
            return false;
        } else if (currentTimeMillis - this.bhi <= 2 || currentTimeMillis - this.bhi <= this.interval) {
            return false;
        } else {
            l bnj = r.bno().bnj();
            return (bnj != null ? bnj.bnc() : 3) < 3;
        }
    }

    private void OE() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.BR();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
