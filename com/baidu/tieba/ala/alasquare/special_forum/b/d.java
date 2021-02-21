package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ak;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes10.dex */
public class d extends a {
    private CustomMessageListener UG;
    private final int gAe;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gAf;
    private com.baidu.tieba.ala.alasquare.live.b.c gAg;
    private Runnable gAh;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gAe = 1000;
        this.mIsBackground = false;
        this.UG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gAh = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bSB();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gAf = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UG);
        this.gAf.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void U(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12909", d.this.gIG.gGU, 1, cbVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void V(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12910", d.this.gIG.gGU, 1, cbVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSA() {
        super.bSA();
        if (this.gAf != null) {
            this.gAf.bRr();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gAf.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bSC();
        if (this.gAf != null) {
            this.gAf.a(this.gAg);
        }
        if (this.gAg != null && this.gAg.akU != null) {
            com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12908", this.gIG.gGU, 1, this.gAg.akU.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSB() {
        if (this.gAg != null && this.gAg.akU != null && this.gAg.akU.boj() != null && this.gAf != null) {
            this.gAf.FX(this.gAg.akU.boj().hls_url);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void pause() {
        stopPlay();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void resume() {
        startPlay();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
        if (!this.mIsBackground) {
            if (ak.rG(1)) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gAh);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gAh, 1000L);
            } else if (this.gAf != null) {
                this.gAf.bRs();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gAf != null) {
            this.gAf.bRs();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gAh);
    }

    private void bSC() {
        this.gAg = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gAg.akU = this.gIG.gcy.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gGT || y.isEmpty(aVar.gcy) || aVar.gcy.get(0) == null || aVar.gcy.get(0).boj() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gAf.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UG);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gAh);
        if (this.gAf != null) {
            this.gAf.onDestroy();
        }
    }
}
