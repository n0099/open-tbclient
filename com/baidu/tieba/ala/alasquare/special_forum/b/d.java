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
    private final int fbQ;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fbR;
    private com.baidu.tieba.ala.alasquare.live.b.c fbS;
    private Runnable fbT;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fbQ = 1000;
        this.mIsBackground = false;
        this.RZ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fbT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.brR();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fbR = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.RZ);
        this.fbR.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bk bkVar) {
                if (bkVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().c("c12909", d.this.fkg.fit, 1, bkVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(bk bkVar) {
                if (bkVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().c("c12910", d.this.fkg.fit, 1, bkVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brQ() {
        super.brQ();
        if (this.fbR != null) {
            this.fbR.bqF();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fbR.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        brS();
        if (this.fbR != null) {
            this.fbR.a(this.fbS);
        }
        if (this.fbS != null && this.fbS.ahg != null) {
            com.baidu.tieba.ala.alasquare.c.a.brs().c("c12908", this.fkg.fit, 1, this.fbS.ahg.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brR() {
        if (this.fbS != null && this.fbS.ahg != null && this.fbS.ahg.aQS() != null && this.fbR != null) {
            this.fbR.AW(this.fbS.ahg.aQS().hls_url);
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
            if (ag.nK(1)) {
                com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbT);
                com.baidu.adp.lib.f.e.ld().postDelayed(this.fbT, 1000L);
            } else if (this.fbR != null) {
                this.fbR.bqG();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fbR != null) {
            this.fbR.bqG();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbT);
    }

    private void brS() {
        this.fbS = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fbS.ahg = this.fkg.eIv.get(0);
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
        return (1 != aVar.fis || v.isEmpty(aVar.eIv) || aVar.eIv.get(0) == null || aVar.eIv.get(0).aQS() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fbR.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RZ);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.fbT);
        if (this.fbR != null) {
            this.fbR.onDestroy();
        }
    }
}
