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
    private static volatile b brR;
    private long brO;
    private final int brM = 2;
    private final int brN = 3;
    private int interval = -1;
    private CustomMessageListener brS = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.bsG().bsB() != null) {
                r.bsG().bsB().bst();
            }
        }
    };
    private CustomMessageListener brT = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Sz();
            }
        }
    };
    private CustomMessageListener brU = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.brO != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.SA()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.SA()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener brV = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.brP = currentTimeMillis - b.this.brO <= 1;
                    }
                }
            }
        }
    };
    private boolean brP = false;
    private boolean brQ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Sy() {
        if (brR == null) {
            synchronized (b.class) {
                if (brR == null) {
                    brR = new b();
                }
            }
        }
        return brR;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.brT);
        MessageManager.getInstance().registerListener(this.brU);
        MessageManager.getInstance().registerListener(this.brS);
        MessageManager.getInstance().registerListener(this.brV);
        if (r.bsG().bsB() != null) {
            r.bsG().bsB().bss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sz() {
        this.brQ = true;
        this.brO = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SA() {
        SB();
        this.brQ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.brP) {
            this.brP = false;
            return false;
        } else if (currentTimeMillis - this.brO <= 2 || currentTimeMillis - this.brO <= this.interval) {
            return false;
        } else {
            l bsB = r.bsG().bsB();
            return (bsB != null ? bsB.bsu() : 3) < 3;
        }
    }

    private void SB() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.interval = adAdSense.Fu();
            if (this.interval <= 0) {
                this.interval = 86400;
                return;
            }
            return;
        }
        this.interval = 300;
    }
}
