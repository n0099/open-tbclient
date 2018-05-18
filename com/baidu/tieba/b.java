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
    private static volatile b aXj;
    private long aXg;
    private final int aXe = 2;
    private final int aXf = 3;
    private int aXk = -1;
    private CustomMessageListener aXl = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bjk().bjf() != null) {
                r.bjk().bjf().biX();
            }
        }
    };
    private CustomMessageListener aXm = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.KF();
            }
        }
    };
    private CustomMessageListener aXn = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.aXg != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.KG()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.KG()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener aXo = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.aXh = currentTimeMillis - b.this.aXg <= 1;
                    }
                }
            }
        }
    };
    private boolean aXh = false;
    private boolean aXi = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b KE() {
        if (aXj == null) {
            synchronized (b.class) {
                if (aXj == null) {
                    aXj = new b();
                }
            }
        }
        return aXj;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aXm);
        MessageManager.getInstance().registerListener(this.aXn);
        MessageManager.getInstance().registerListener(this.aXl);
        MessageManager.getInstance().registerListener(this.aXo);
        if (r.bjk().bjf() != null) {
            r.bjk().bjf().biW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KF() {
        this.aXi = true;
        this.aXg = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KG() {
        KH();
        this.aXi = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aXh) {
            this.aXh = false;
            return false;
        } else if (currentTimeMillis - this.aXg <= 2 || currentTimeMillis - this.aXg <= this.aXk) {
            return false;
        } else {
            l bjf = r.bjk().bjf();
            return (bjf != null ? bjf.biY() : 3) < 3;
        }
    }

    private void KH() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aXk = adAdSense.yl();
            if (this.aXk <= 0) {
                this.aXk = 86400;
                return;
            }
            return;
        }
        this.aXk = 300;
    }
}
