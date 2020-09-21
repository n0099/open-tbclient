package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes4.dex */
public class d extends a {
    private CustomMessageListener Tw;
    private final int fGU;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fGV;
    private com.baidu.tieba.ala.alasquare.live.b.c fGW;
    private Runnable fGX;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fGU = 1000;
        this.mIsBackground = false;
        this.Tw = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fGX = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bIn();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fGV = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.Tw);
        this.fGV.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12909", d.this.fPk.fNy, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12910", d.this.fPk.fNy, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bIm() {
        super.bIm();
        if (this.fGV != null) {
            this.fGV.bHc();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fGV.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bIo();
        if (this.fGV != null) {
            this.fGV.a(this.fGW);
        }
        if (this.fGW != null && this.fGW.ajX != null) {
            com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12908", this.fPk.fNy, 1, this.fGW.ajX.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.fGW != null && this.fGW.ajX != null && this.fGW.ajX.bfS() != null && this.fGV != null) {
            this.fGV.EZ(this.fGW.ajX.bfS().hls_url);
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
            if (ai.rc(1)) {
                com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fGX);
                com.baidu.adp.lib.f.e.mX().postDelayed(this.fGX, 1000L);
            } else if (this.fGV != null) {
                this.fGV.bHd();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fGV != null) {
            this.fGV.bHd();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fGX);
    }

    private void bIo() {
        this.fGW = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fGW.ajX = this.fPk.fnr.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kC(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fNx || y.isEmpty(aVar.fnr) || aVar.fnr.get(0) == null || aVar.fnr.get(0).bfS() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fGV.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Tw);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fGX);
        if (this.fGV != null) {
            this.fGV.onDestroy();
        }
    }
}
