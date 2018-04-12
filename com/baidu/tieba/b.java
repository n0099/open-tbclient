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
    private static volatile b aXi;
    private long aXf;
    private final int aXd = 2;
    private final int aXe = 3;
    private int aXj = -1;
    private CustomMessageListener aXk = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bjl().bjg() != null) {
                r.bjl().bjg().biY();
            }
        }
    };
    private CustomMessageListener aXl = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.KH();
            }
        }
    };
    private CustomMessageListener aXm = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aXf != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.KI()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.KI()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aXn = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aXg = currentTimeMillis - b.this.aXf <= 1;
                    }
                }
            }
        }
    };
    private boolean aXg = false;
    private boolean aXh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b KG() {
        if (aXi == null) {
            synchronized (b.class) {
                if (aXi == null) {
                    aXi = new b();
                }
            }
        }
        return aXi;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aXl);
        MessageManager.getInstance().registerListener(this.aXm);
        MessageManager.getInstance().registerListener(this.aXk);
        MessageManager.getInstance().registerListener(this.aXn);
        if (r.bjl().bjg() != null) {
            r.bjl().bjg().biX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        this.aXh = true;
        this.aXf = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KI() {
        KJ();
        this.aXh = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aXg) {
            this.aXg = false;
            return false;
        } else if (currentTimeMillis - this.aXf <= 2 || currentTimeMillis - this.aXf <= this.aXj) {
            return false;
        } else {
            l bjg = r.bjl().bjg();
            return (bjg != null ? bjg.biZ() : 3) < 3;
        }
    }

    private void KJ() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aXj = adAdSense.ym();
            if (this.aXj <= 0) {
                this.aXj = 86400;
                return;
            }
            return;
        }
        this.aXj = 300;
    }
}
