package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes3.dex */
public class d extends a {
    private final int ekP;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b ekQ;
    private com.baidu.tieba.ala.alasquare.live.b.c ekR;
    private Runnable ekS;
    private boolean mIsBackground;
    private CustomMessageListener yE;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ekP = 1000;
        this.mIsBackground = false;
        this.yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.ekS = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bdu();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.ekQ = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.yE);
        this.ekQ.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12909", d.this.eta.ern, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12910", d.this.eta.ern, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdt() {
        super.bdt();
        if (this.ekQ != null) {
            this.ekQ.bcl();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.ekQ.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bdv();
        if (this.ekQ != null) {
            this.ekQ.a(this.ekR);
        }
        if (this.ekR != null && this.ekR.NQ != null) {
            com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12908", this.eta.ern, 1, this.ekR.NQ.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdu() {
        if (this.ekR != null && this.ekR.NQ != null && this.ekR.NQ.aCF() != null && this.ekQ != null) {
            this.ekQ.startPlay(this.ekR.NQ.aCF().hls_url);
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
            if (af.mT(1)) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekS);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.ekS, 1000L);
            } else if (this.ekQ != null) {
                this.ekQ.bcm();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ekQ != null) {
            this.ekQ.bcm();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekS);
    }

    private void bdv() {
        this.ekR = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.ekR.NQ = this.eta.dTd.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hR(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.erm || v.isEmpty(aVar.dTd) || aVar.dTd.get(0) == null || aVar.dTd.get(0).aCF() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.ekQ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekS);
        if (this.ekQ != null) {
            this.ekQ.onDestroy();
        }
    }
}
