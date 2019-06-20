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
    private static volatile b cPC;
    private long cPz;
    private final int cPx = 2;
    private final int cPy = 3;
    private int interval = -1;
    private CustomMessageListener cPD = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.ceM().ceH() != null) {
                r.ceM().ceH().cez();
            }
        }
    };
    private CustomMessageListener cPE = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.azf();
            }
        }
    };
    private CustomMessageListener cPF = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cPz != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && b.this.azg()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.azg()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cPG = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cPA = currentTimeMillis - b.this.cPz <= 1;
                    }
                }
            }
        }
    };
    private boolean cPA = false;
    private boolean cPB = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aze() {
        if (cPC == null) {
            synchronized (b.class) {
                if (cPC == null) {
                    cPC = new b();
                }
            }
        }
        return cPC;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cPE);
        MessageManager.getInstance().registerListener(this.cPF);
        MessageManager.getInstance().registerListener(this.cPD);
        MessageManager.getInstance().registerListener(this.cPG);
        if (r.ceM().ceH() != null) {
            r.ceM().ceH().cey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        this.cPB = true;
        this.cPz = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azg() {
        azh();
        this.cPB = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cPA) {
            this.cPA = false;
            return false;
        } else if (currentTimeMillis - this.cPz <= 2 || currentTimeMillis - this.cPz <= this.interval) {
            return false;
        } else {
            l ceH = r.ceM().ceH();
            return (ceH != null ? ceH.ceA() : 3) < 3;
        }
    }

    private void azh() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.alb();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
