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
    private final int fDI;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fDJ;
    private com.baidu.tieba.ala.alasquare.live.b.c fDK;
    private Runnable fDL;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fDI = 1000;
        this.mIsBackground = false;
        this.Te = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fDL = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bGX();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fDJ = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.Te);
        this.fDJ.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12909", d.this.fLW.fKk, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12910", d.this.fLW.fKk, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGW() {
        super.bGW();
        if (this.fDJ != null) {
            this.fDJ.bFM();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fDJ.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bGY();
        if (this.fDJ != null) {
            this.fDJ.a(this.fDK);
        }
        if (this.fDK != null && this.fDK.ajz != null) {
            com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12908", this.fLW.fKk, 1, this.fDK.ajz.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        if (this.fDK != null && this.fDK.ajz != null && this.fDK.ajz.beY() != null && this.fDJ != null) {
            this.fDJ.EB(this.fDK.ajz.beY().hls_url);
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
                com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDL);
                com.baidu.adp.lib.f.e.mS().postDelayed(this.fDL, 1000L);
            } else if (this.fDJ != null) {
                this.fDJ.bFN();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fDJ != null) {
            this.fDJ.bFN();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDL);
    }

    private void bGY() {
        this.fDK = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fDK.ajz = this.fLW.fky.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kA(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fKj || y.isEmpty(aVar.fky) || aVar.fky.get(0) == null || aVar.fky.get(0).beY() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fDJ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Te);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fDL);
        if (this.fDJ != null) {
            this.fDJ.onDestroy();
        }
    }
}
