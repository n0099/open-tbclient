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
    private CustomMessageListener TP;
    private final int gdg;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gdh;
    private com.baidu.tieba.ala.alasquare.live.b.c gdi;
    private Runnable gdj;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gdg = 1000;
        this.mIsBackground = false;
        this.TP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gdj = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bNz();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gdh = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.TP);
        this.gdh.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12909", d.this.glG.gjU, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12910", d.this.glG.gjU, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bNy() {
        super.bNy();
        if (this.gdh != null) {
            this.gdh.bMq();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gdh.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bNA();
        if (this.gdh != null) {
            this.gdh.a(this.gdi);
        }
        if (this.gdi != null && this.gdi.akq != null) {
            com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12908", this.glG.gjU, 1, this.gdi.akq.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNz() {
        if (this.gdi != null && this.gdi.akq != null && this.gdi.akq.bku() != null && this.gdh != null) {
            this.gdh.Gj(this.gdi.akq.bku().hls_url);
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
            if (ai.rL(1)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gdj);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.gdj, 1000L);
            } else if (this.gdh != null) {
                this.gdh.bMr();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gdh != null) {
            this.gdh.bMr();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gdj);
    }

    private void bNA() {
        this.gdi = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gdi.akq = this.glG.fIa.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ls(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gjT || y.isEmpty(aVar.fIa) || aVar.fIa.get(0) == null || aVar.fIa.get(0).bku() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gdh.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gdj);
        if (this.gdh != null) {
            this.gdh.onDestroy();
        }
    }
}
