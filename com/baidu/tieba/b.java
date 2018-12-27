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
    private static volatile b bvt;
    private long bvq;
    private final int bvo = 2;
    private final int bvp = 3;
    private int interval = -1;
    private CustomMessageListener bvu = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bvk().bvf() != null) {
                r.bvk().bvf().buX();
            }
        }
    };
    private CustomMessageListener bvv = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.TH();
            }
        }
    };
    private CustomMessageListener bvw = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bvq != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.TI()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.TI()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bvx = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bvr = currentTimeMillis - b.this.bvq <= 1;
                    }
                }
            }
        }
    };
    private boolean bvr = false;
    private boolean bvs = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b TG() {
        if (bvt == null) {
            synchronized (b.class) {
                if (bvt == null) {
                    bvt = new b();
                }
            }
        }
        return bvt;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bvv);
        MessageManager.getInstance().registerListener(this.bvw);
        MessageManager.getInstance().registerListener(this.bvu);
        MessageManager.getInstance().registerListener(this.bvx);
        if (r.bvk().bvf() != null) {
            r.bvk().bvf().buW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TH() {
        this.bvs = true;
        this.bvq = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TI() {
        TJ();
        this.bvs = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bvr) {
            this.bvr = false;
            return false;
        } else if (currentTimeMillis - this.bvq <= 2 || currentTimeMillis - this.bvq <= this.interval) {
            return false;
        } else {
            l bvf = r.bvk().bvf();
            return (bvf != null ? bvf.buY() : 3) < 3;
        }
    }

    private void TJ() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.Gz();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
