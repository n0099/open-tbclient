package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes4.dex */
public class d extends a {
    private CustomMessageListener TQ;
    private final int giD;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b giE;
    private com.baidu.tieba.ala.alasquare.live.b.c giF;
    private Runnable giG;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.giD = 1000;
        this.mIsBackground = false;
        this.TQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.giG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bPs();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.giE = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.TQ);
        this.giE.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(bx bxVar) {
                if (bxVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12909", d.this.gra.gpo, 1, bxVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(bx bxVar) {
                if (bxVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12910", d.this.gra.gpo, 1, bxVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPr() {
        super.bPr();
        if (this.giE != null) {
            this.giE.bOj();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.giE.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bPt();
        if (this.giE != null) {
            this.giE.a(this.giF);
        }
        if (this.giF != null && this.giF.akt != null) {
            com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12908", this.gra.gpo, 1, this.giF.akt.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPs() {
        if (this.giF != null && this.giF.akt != null && this.giF.akt.blW() != null && this.giE != null) {
            this.giE.FY(this.giF.akt.blW().hls_url);
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
            if (ah.st(1)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giG);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.giG, 1000L);
            } else if (this.giE != null) {
                this.giE.bOk();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.giE != null) {
            this.giE.bOk();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giG);
    }

    private void bPt() {
        this.giF = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.giF.akt = this.gra.fNt.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lC(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gpn || y.isEmpty(aVar.fNt) || aVar.fNt.get(0) == null || aVar.fNt.get(0).blW() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.giE.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TQ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giG);
        if (this.giE != null) {
            this.giE.onDestroy();
        }
    }
}
