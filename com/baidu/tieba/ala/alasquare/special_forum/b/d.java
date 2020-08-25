package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes4.dex */
public class d extends a {
    private CustomMessageListener Te;
    private final int fDE;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fDF;
    private com.baidu.tieba.ala.alasquare.live.b.c fDG;
    private Runnable fDH;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fDE = 1000;
        this.mIsBackground = false;
        this.Te = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fDH = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bGW();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fDF = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.Te);
        this.fDF.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12909", d.this.fLS.fKg, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12910", d.this.fLS.fKg, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGV() {
        super.bGV();
        if (this.fDF != null) {
            this.fDF.bFL();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fDF.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bGX();
        if (this.fDF != null) {
            this.fDF.a(this.fDG);
        }
        if (this.fDG != null && this.fDG.ajx != null) {
            com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12908", this.fLS.fKg, 1, this.fDG.ajx.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGW() {
        if (this.fDG != null && this.fDG.ajx != null && this.fDG.ajx.beY() != null && this.fDF != null) {
            this.fDF.EA(this.fDG.ajx.beY().hls_url);
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
            if (ah.qL(1)) {
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDH);
                com.baidu.adp.lib.f.e.mS().postDelayed(this.fDH, 1000L);
            } else if (this.fDF != null) {
                this.fDF.bFM();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fDF != null) {
            this.fDF.bFM();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDH);
    }

    private void bGX() {
        this.fDG = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fDG.ajx = this.fLS.fku.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ky(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fKf || y.isEmpty(aVar.fku) || aVar.fku.get(0) == null || aVar.fku.get(0).beY() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fDF.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Te);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDH);
        if (this.fDF != null) {
            this.fDF.onDestroy();
        }
    }
}
