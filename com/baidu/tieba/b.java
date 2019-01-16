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
    private static volatile b bwh;
    private long bwe;
    private final int bwc = 2;
    private final int bwd = 3;
    private int interval = -1;
    private CustomMessageListener bwi = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bvT().bvO() != null) {
                r.bvT().bvO().bvG();
            }
        }
    };
    private CustomMessageListener bwj = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Ud();
            }
        }
    };
    private CustomMessageListener bwk = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bwe != 0) {
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
    private CustomMessageListener bwl = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bwf = currentTimeMillis - b.this.bwe <= 1;
                    }
                }
            }
        }
    };
    private boolean bwf = false;
    private boolean bwg = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Uc() {
        if (bwh == null) {
            synchronized (b.class) {
                if (bwh == null) {
                    bwh = new b();
                }
            }
        }
        return bwh;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bwj);
        MessageManager.getInstance().registerListener(this.bwk);
        MessageManager.getInstance().registerListener(this.bwi);
        MessageManager.getInstance().registerListener(this.bwl);
        if (r.bvT().bvO() != null) {
            r.bvT().bvO().bvF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ud() {
        this.bwg = true;
        this.bwe = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ue() {
        Uf();
        this.bwg = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bwf) {
            this.bwf = false;
            return false;
        } else if (currentTimeMillis - this.bwe <= 2 || currentTimeMillis - this.bwe <= this.interval) {
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
