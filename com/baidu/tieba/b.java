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
    private static volatile b bwi;
    private long bwf;
    private final int bwd = 2;
    private final int bwe = 3;
    private int interval = -1;
    private CustomMessageListener bwj = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bvT().bvO() != null) {
                r.bvT().bvO().bvG();
            }
        }
    };
    private CustomMessageListener bwk = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Ud();
            }
        }
    };
    private CustomMessageListener bwl = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bwf != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Ue()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Ue()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bwm = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bwg = currentTimeMillis - b.this.bwf <= 1;
                    }
                }
            }
        }
    };
    private boolean bwg = false;
    private boolean bwh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Uc() {
        if (bwi == null) {
            synchronized (b.class) {
                if (bwi == null) {
                    bwi = new b();
                }
            }
        }
        return bwi;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bwk);
        MessageManager.getInstance().registerListener(this.bwl);
        MessageManager.getInstance().registerListener(this.bwj);
        MessageManager.getInstance().registerListener(this.bwm);
        if (r.bvT().bvO() != null) {
            r.bvT().bvO().bvF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ud() {
        this.bwh = true;
        this.bwf = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ue() {
        Uf();
        this.bwh = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bwg) {
            this.bwg = false;
            return false;
        } else if (currentTimeMillis - this.bwf <= 2 || currentTimeMillis - this.bwf <= this.interval) {
            return false;
        } else {
            l bvO = r.bvT().bvO();
            return (bvO != null ? bvO.bvH() : 3) < 3;
        }
    }

    private void Uf() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.GM();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
