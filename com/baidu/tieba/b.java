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
    private static volatile b bnd;
    private long bna;
    private final int bmY = 2;
    private final int bmZ = 3;
    private int interval = -1;
    private CustomMessageListener bne = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bpV().bpQ() != null) {
                r.bpV().bpQ().bpI();
            }
        }
    };
    private CustomMessageListener bnf = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Qw();
            }
        }
    };
    private CustomMessageListener bng = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bna != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Qx()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Qx()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bnh = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bnb = currentTimeMillis - b.this.bna <= 1;
                    }
                }
            }
        }
    };
    private boolean bnb = false;
    private boolean bnc = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Qv() {
        if (bnd == null) {
            synchronized (b.class) {
                if (bnd == null) {
                    bnd = new b();
                }
            }
        }
        return bnd;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bnf);
        MessageManager.getInstance().registerListener(this.bng);
        MessageManager.getInstance().registerListener(this.bne);
        MessageManager.getInstance().registerListener(this.bnh);
        if (r.bpV().bpQ() != null) {
            r.bpV().bpQ().bpH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qw() {
        this.bnc = true;
        this.bna = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qx() {
        Qy();
        this.bnc = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bnb) {
            this.bnb = false;
            return false;
        } else if (currentTimeMillis - this.bna <= 2 || currentTimeMillis - this.bna <= this.interval) {
            return false;
        } else {
            l bpQ = r.bpV().bpQ();
            return (bpQ != null ? bpQ.bpJ() : 3) < 3;
        }
    }

    private void Qy() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.Df();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
