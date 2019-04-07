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
    private static volatile b cHr;
    private long cHo;
    private final int cHm = 2;
    private final int cHn = 3;
    private int interval = -1;
    private CustomMessageListener cHs = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bWF().bWA() != null) {
                r.bWF().bWA().bWs();
            }
        }
    };
    private CustomMessageListener cHt = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.atZ();
            }
        }
    };
    private CustomMessageListener cHu = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cHo != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.aua()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.aua()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cHv = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cHp = currentTimeMillis - b.this.cHo <= 1;
                    }
                }
            }
        }
    };
    private boolean cHp = false;
    private boolean cHq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b atY() {
        if (cHr == null) {
            synchronized (b.class) {
                if (cHr == null) {
                    cHr = new b();
                }
            }
        }
        return cHr;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cHt);
        MessageManager.getInstance().registerListener(this.cHu);
        MessageManager.getInstance().registerListener(this.cHs);
        MessageManager.getInstance().registerListener(this.cHv);
        if (r.bWF().bWA() != null) {
            r.bWF().bWA().bWr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atZ() {
        this.cHq = true;
        this.cHo = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aua() {
        aub();
        this.cHq = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cHp) {
            this.cHp = false;
            return false;
        } else if (currentTimeMillis - this.cHo <= 2 || currentTimeMillis - this.cHo <= this.interval) {
            return false;
        } else {
            l bWA = r.bWF().bWA();
            return (bWA != null ? bWA.bWt() : 3) < 3;
        }
    }

    private void aub() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.agc();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
