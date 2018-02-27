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
    private static volatile b bNh;
    private long bNe;
    private final int bNc = 2;
    private final int bNd = 3;
    private int bNi = -1;
    private CustomMessageListener bNj = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.boe().bnZ() != null) {
                r.boe().bnZ().bnR();
            }
        }
    };
    private CustomMessageListener bNk = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Si();
            }
        }
    };
    private CustomMessageListener bNl = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bNe != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Sj()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Sj()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bNm = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bNf = currentTimeMillis - b.this.bNe <= 1;
                    }
                }
            }
        }
    };
    private boolean bNf = false;
    private boolean bNg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Sh() {
        if (bNh == null) {
            synchronized (b.class) {
                if (bNh == null) {
                    bNh = new b();
                }
            }
        }
        return bNh;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bNk);
        MessageManager.getInstance().registerListener(this.bNl);
        MessageManager.getInstance().registerListener(this.bNj);
        MessageManager.getInstance().registerListener(this.bNm);
        if (r.boe().bnZ() != null) {
            r.boe().bnZ().bnQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        this.bNg = true;
        this.bNe = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj() {
        Sk();
        this.bNg = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bNf) {
            this.bNf = false;
            return false;
        } else if (currentTimeMillis - this.bNe <= 2 || currentTimeMillis - this.bNe <= this.bNi) {
            return false;
        } else {
            l bnZ = r.boe().bnZ();
            return (bnZ != null ? bnZ.bnS() : 3) < 3;
        }
    }

    private void Sk() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bNi = adAdSense.Fy();
            if (this.bNi <= 0) {
                this.bNi = 86400;
                return;
            }
            return;
        }
        this.bNi = 300;
    }
}
