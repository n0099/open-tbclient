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
    private CustomMessageListener TO;
    private final int fTd;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fTe;
    private com.baidu.tieba.ala.alasquare.live.b.c fTf;
    private Runnable fTg;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fTd = 1000;
        this.mIsBackground = false;
        this.TO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fTg = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bKX();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fTe = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.TO);
        this.fTe.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12909", d.this.gbC.fZP, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12910", d.this.gbC.fZP, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bKW() {
        super.bKW();
        if (this.fTe != null) {
            this.fTe.bJO();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fTe.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bKY();
        if (this.fTe != null) {
            this.fTe.a(this.fTf);
        }
        if (this.fTf != null && this.fTf.akp != null) {
            com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12908", this.gbC.fZP, 1, this.fTf.akp.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKX() {
        if (this.fTf != null && this.fTf.akp != null && this.fTf.akp.biB() != null && this.fTe != null) {
            this.fTe.FK(this.fTf.akp.biB().hls_url);
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
            if (ai.rA(1)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fTg);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fTg, 1000L);
            } else if (this.fTe != null) {
                this.fTe.bJP();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fTe != null) {
            this.fTe.bJP();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fTg);
    }

    private void bKY() {
        this.fTf = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fTf.akp = this.gbC.fzF.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void la(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fZO || y.isEmpty(aVar.fzF) || aVar.fzF.get(0) == null || aVar.fzF.get(0).biB() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fTe.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TO);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fTg);
        if (this.fTe != null) {
            this.fTe.onDestroy();
        }
    }
}
