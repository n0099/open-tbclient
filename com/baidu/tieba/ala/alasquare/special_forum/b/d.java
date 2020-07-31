package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes4.dex */
public class d extends a {
    private CustomMessageListener Sx;
    private final int fsk;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fsl;
    private com.baidu.tieba.ala.alasquare.live.b.c fsm;
    private Runnable fsn;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fsk = 1000;
        this.mIsBackground = false;
        this.Sx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fsn = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bxX();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fsl = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.Sx);
        this.fsl.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bv bvVar) {
                if (bvVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12909", d.this.fAA.fyO, 1, bvVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bv bvVar) {
                if (bvVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12910", d.this.fAA.fyO, 1, bvVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bxW() {
        super.bxW();
        if (this.fsl != null) {
            this.fsl.bwM();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fsl.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bxY();
        if (this.fsl != null) {
            this.fsl.a(this.fsm);
        }
        if (this.fsm != null && this.fsm.aii != null) {
            com.baidu.tieba.ala.alasquare.c.a.bxy().c("c12908", this.fAA.fyO, 1, this.fsm.aii.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxX() {
        if (this.fsm != null && this.fsm.aii != null && this.fsm.aii.aWF() != null && this.fsl != null) {
            this.fsl.Cg(this.fsm.aii.aWF().hls_url);
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
            if (ag.oz(1)) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fsn);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.fsn, 1000L);
            } else if (this.fsl != null) {
                this.fsl.bwN();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fsl != null) {
            this.fsl.bwN();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fsn);
    }

    private void bxY() {
        this.fsm = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fsm.aii = this.fAA.eZc.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ka(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fyN || x.isEmpty(aVar.eZc) || aVar.eZc.get(0) == null || aVar.eZc.get(0).aWF() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fsl.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Sx);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fsn);
        if (this.fsl != null) {
            this.fsl.onDestroy();
        }
    }
}
