package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes3.dex */
public class d extends a {
    private CustomMessageListener RZ;
    private final int fbF;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fbG;
    private com.baidu.tieba.ala.alasquare.live.b.c fbH;
    private Runnable fbI;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fbF = 1000;
        this.mIsBackground = false;
        this.RZ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fbI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.brP();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fbG = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.RZ);
        this.fbG.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bk bkVar) {
                if (bkVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().c("c12909", d.this.fjV.fii, 1, bkVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(bk bkVar) {
                if (bkVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().c("c12910", d.this.fjV.fii, 1, bkVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brO() {
        super.brO();
        if (this.fbG != null) {
            this.fbG.bqD();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fbG.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        brQ();
        if (this.fbG != null) {
            this.fbG.a(this.fbH);
        }
        if (this.fbH != null && this.fbH.ahg != null) {
            com.baidu.tieba.ala.alasquare.c.a.brq().c("c12908", this.fjV.fii, 1, this.fbH.ahg.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brP() {
        if (this.fbH != null && this.fbH.ahg != null && this.fbH.ahg.aQS() != null && this.fbG != null) {
            this.fbG.AW(this.fbH.ahg.aQS().hls_url);
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
            if (ag.nI(1)) {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbI);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.fbI, 1000L);
            } else if (this.fbG != null) {
                this.fbG.bqE();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fbG != null) {
            this.fbG.bqE();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbI);
    }

    private void brQ() {
        this.fbH = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fbH.ahg = this.fjV.eIk.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jj(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.fih || v.isEmpty(aVar.eIk) || aVar.eIk.get(0) == null || aVar.eIk.get(0).aQS() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fbG.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RZ);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbI);
        if (this.fbG != null) {
            this.fbG.onDestroy();
        }
    }
}
