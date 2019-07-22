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
    private static volatile b cQY;
    private long cQV;
    private final int cQT = 2;
    private final int cQU = 3;
    private int interval = -1;
    private CustomMessageListener cQZ = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.chD().chy() != null) {
                r.chD().chy().chq();
            }
        }
    };
    private CustomMessageListener cRa = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.aAt();
            }
        }
    };
    private CustomMessageListener cRb = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.cQV != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (!data.getClass().getSimpleName().equals("LoginActivity") && b.this.aAu()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.aAu()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener cRc = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.cQW = currentTimeMillis - b.this.cQV <= 1;
                    }
                }
            }
        }
    };
    private boolean cQW = false;
    private boolean cQX = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b aAs() {
        if (cQY == null) {
            synchronized (b.class) {
                if (cQY == null) {
                    cQY = new b();
                }
            }
        }
        return cQY;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.cRa);
        MessageManager.getInstance().registerListener(this.cRb);
        MessageManager.getInstance().registerListener(this.cQZ);
        MessageManager.getInstance().registerListener(this.cRc);
        if (r.chD().chy() != null) {
            r.chD().chy().chp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAt() {
        this.cQX = true;
        this.cQV = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAu() {
        aAv();
        this.cQX = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.cQW) {
            this.cQW = false;
            return false;
        } else if (currentTimeMillis - this.cQV <= 2 || currentTimeMillis - this.cQV <= this.interval) {
            return false;
        } else {
            l chy = r.chD().chy();
            return (chy != null ? chy.chr() : 3) < 3;
        }
    }

    private void aAv() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.amg();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
