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
    private static volatile b bNu;
    private long bNr;
    private final int bNp = 2;
    private final int bNq = 3;
    private int bNv = -1;
    private CustomMessageListener bNw = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bof().boa() != null) {
                r.bof().boa().bnS();
            }
        }
    };
    private CustomMessageListener bNx = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Sj();
            }
        }
    };
    private CustomMessageListener bNy = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bNr != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Sk()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Sk()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bNz = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bNs = currentTimeMillis - b.this.bNr <= 1;
                    }
                }
            }
        }
    };
    private boolean bNs = false;
    private boolean bNt = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Si() {
        if (bNu == null) {
            synchronized (b.class) {
                if (bNu == null) {
                    bNu = new b();
                }
            }
        }
        return bNu;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bNx);
        MessageManager.getInstance().registerListener(this.bNy);
        MessageManager.getInstance().registerListener(this.bNw);
        MessageManager.getInstance().registerListener(this.bNz);
        if (r.bof().boa() != null) {
            r.bof().boa().bnR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj() {
        this.bNt = true;
        this.bNr = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sk() {
        Sl();
        this.bNt = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bNs) {
            this.bNs = false;
            return false;
        } else if (currentTimeMillis - this.bNr <= 2 || currentTimeMillis - this.bNr <= this.bNv) {
            return false;
        } else {
            l boa = r.bof().boa();
            return (boa != null ? boa.bnT() : 3) < 3;
        }
    }

    private void Sl() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bNv = adAdSense.Fz();
            if (this.bNv <= 0) {
                this.bNv = 86400;
                return;
            }
            return;
        }
        this.bNv = 300;
    }
}
