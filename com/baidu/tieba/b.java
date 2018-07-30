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
    private static volatile b bhk;
    private long bhh;
    private final int bhf = 2;
    private final int bhg = 3;
    private int interval = -1;
    private CustomMessageListener bhl = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bnn().bni() != null) {
                r.bnn().bni().bna();
            }
        }
    };
    private CustomMessageListener bhm = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.OD();
            }
        }
    };
    private CustomMessageListener bhn = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bhh != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.OE()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.OE()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bho = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bhi = currentTimeMillis - b.this.bhh <= 1;
                    }
                }
            }
        }
    };
    private boolean bhi = false;
    private boolean bhj = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b OC() {
        if (bhk == null) {
            synchronized (b.class) {
                if (bhk == null) {
                    bhk = new b();
                }
            }
        }
        return bhk;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bhm);
        MessageManager.getInstance().registerListener(this.bhn);
        MessageManager.getInstance().registerListener(this.bhl);
        MessageManager.getInstance().registerListener(this.bho);
        if (r.bnn().bni() != null) {
            r.bnn().bni().bmZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        this.bhj = true;
        this.bhh = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OE() {
        OF();
        this.bhj = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bhi) {
            this.bhi = false;
            return false;
        } else if (currentTimeMillis - this.bhh <= 2 || currentTimeMillis - this.bhh <= this.interval) {
            return false;
        } else {
            l bni = r.bnn().bni();
            return (bni != null ? bni.bnb() : 3) < 3;
        }
    }

    private void OF() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.BU();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
