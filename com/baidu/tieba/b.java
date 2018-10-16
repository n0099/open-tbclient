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
    private static volatile b brf;
    private long brc;
    private final int bra = 2;
    private final int brb = 3;
    private int interval = -1;
    private CustomMessageListener brg = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.btk().btf() != null) {
                r.btk().btf().bsX();
            }
        }
    };
    private CustomMessageListener brh = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Sq();
            }
        }
    };
    private CustomMessageListener bri = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.brc != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Sr()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Sr()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener brj = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.brd = currentTimeMillis - b.this.brc <= 1;
                    }
                }
            }
        }
    };
    private boolean brd = false;
    private boolean bre = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Sp() {
        if (brf == null) {
            synchronized (b.class) {
                if (brf == null) {
                    brf = new b();
                }
            }
        }
        return brf;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.brh);
        MessageManager.getInstance().registerListener(this.bri);
        MessageManager.getInstance().registerListener(this.brg);
        MessageManager.getInstance().registerListener(this.brj);
        if (r.btk().btf() != null) {
            r.btk().btf().bsW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sq() {
        this.bre = true;
        this.brc = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sr() {
        Ss();
        this.bre = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.brd) {
            this.brd = false;
            return false;
        } else if (currentTimeMillis - this.brc <= 2 || currentTimeMillis - this.brc <= this.interval) {
            return false;
        } else {
            l btf = r.btk().btf();
            return (btf != null ? btf.bsY() : 3) < 3;
        }
    }

    private void Ss() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.Fj();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
