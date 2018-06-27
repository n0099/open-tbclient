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
    private static volatile b bgE;
    private long bgB;
    private final int bgz = 2;
    private final int bgA = 3;
    private int bgF = -1;
    private CustomMessageListener bgG = new CustomMessageListener(2016522) { // from class: com.baidu.tieba.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016522 && r.boJ().boE() != null) {
                r.boJ().boE().bow();
            }
        }
    };
    private CustomMessageListener bgH = new CustomMessageListener(2016521) { // from class: com.baidu.tieba.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                b.this.Ox();
            }
        }
    };
    private CustomMessageListener bgI = new CustomMessageListener(2016520) { // from class: com.baidu.tieba.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016520 && b.this.bgB != 0) {
                Object data = customResponsedMessage.getData();
                if (data instanceof BaseActivity) {
                    if (b.this.Oy()) {
                        BaseActivity baseActivity = (BaseActivity) data;
                        Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                        intent.putExtra("splash", true);
                        intent.setFlags(65536);
                        baseActivity.startActivity(intent);
                    }
                } else if ((data instanceof BaseFragmentActivity) && b.this.Oy()) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
            }
        }
    };
    private CustomMessageListener bgJ = new CustomMessageListener(2016523) { // from class: com.baidu.tieba.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        b.this.bgC = currentTimeMillis - b.this.bgB <= 1;
                    }
                }
            }
        }
    };
    private boolean bgC = false;
    private boolean bgD = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Ow() {
        if (bgE == null) {
            synchronized (b.class) {
                if (bgE == null) {
                    bgE = new b();
                }
            }
        }
        return bgE;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.bgH);
        MessageManager.getInstance().registerListener(this.bgI);
        MessageManager.getInstance().registerListener(this.bgG);
        MessageManager.getInstance().registerListener(this.bgJ);
        if (r.boJ().boE() != null) {
            r.boJ().boE().bov();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox() {
        this.bgD = true;
        this.bgB = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oy() {
        Oz();
        this.bgD = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.bgC) {
            this.bgC = false;
            return false;
        } else if (currentTimeMillis - this.bgB <= 2 || currentTimeMillis - this.bgB <= this.bgF) {
            return false;
        } else {
            l boE = r.boJ().boE();
            return (boE != null ? boE.box() : 3) < 3;
        }
    }

    private void Oz() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (adAdSense != null) {
            this.bgF = adAdSense.Cc();
            if (this.bgF <= 0) {
                this.bgF = 86400;
                return;
            }
            return;
        }
        this.bgF = 300;
    }
}
