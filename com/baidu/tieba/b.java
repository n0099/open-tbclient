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
    private static volatile b bvq;
    private long bvn;
    private final int bvl = 2;
    private final int bvm = 3;
    private int interval = -1;
    private CustomMessageListener bvr = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.buy().but() != null) {
                r.buy().but().bul();
            }
        }
    };
    private CustomMessageListener bvs = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.TF();
            }
        }
    };
    private CustomMessageListener bvt = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bvn != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.TG()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.TG()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bvu = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bvo = currentTimeMillis - b.this.bvn <= 1;
                    }
                }
            }
        }
    };
    private boolean bvo = false;
    private boolean bvp = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b TE() {
        if (bvq == null) {
            synchronized (b.class) {
                if (bvq == null) {
                    bvq = new b();
                }
            }
        }
        return bvq;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bvs);
        MessageManager.getInstance().registerListener(this.bvt);
        MessageManager.getInstance().registerListener(this.bvr);
        MessageManager.getInstance().registerListener(this.bvu);
        if (r.buy().but() != null) {
            r.buy().but().buk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TF() {
        this.bvp = true;
        this.bvn = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TG() {
        TH();
        this.bvp = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bvo) {
            this.bvo = false;
            return false;
        } else if (currentTimeMillis - this.bvn <= 2 || currentTimeMillis - this.bvn <= this.interval) {
            return false;
        } else {
            l but = r.buy().but();
            return (but != null ? but.bum() : 3) < 3;
        }
    }

    private void TH() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.Gy();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
