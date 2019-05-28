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
    private static volatile b cPB;
    private long cPy;
    private final int cPw = 2;
    private final int cPx = 3;
    private int interval = -1;
    private CustomMessageListener cPC = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.ceL().ceG() != null) {
                r.ceL().ceG().cey();
            }
        }
    };
    private CustomMessageListener cPD = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.azf();
            }
        }
    };
    private CustomMessageListener cPE = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cPy != 0) {
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
    private CustomMessageListener cPF = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cPz = currentTimeMillis - b.this.cPy <= 1;
                    }
                }
            }
        }
    };
    private boolean cPz = false;
    private boolean cPA = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aze() {
        if (cPB == null) {
            synchronized (b.class) {
                if (cPB == null) {
                    cPB = new b();
                }
            }
        }
        return cPB;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cPD);
        MessageManager.getInstance().registerListener(this.cPE);
        MessageManager.getInstance().registerListener(this.cPC);
        MessageManager.getInstance().registerListener(this.cPF);
        if (r.ceL().ceG() != null) {
            r.ceL().ceG().cex();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azf() {
        this.cPA = true;
        this.cPy = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azg() {
        azh();
        this.cPA = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cPz) {
            this.cPz = false;
            return false;
        } else if (currentTimeMillis - this.cPy <= 2 || currentTimeMillis - this.cPy <= this.interval) {
            return false;
        } else {
            l ceG = r.ceL().ceG();
            return (ceG != null ? ceG.cez() : 3) < 3;
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
