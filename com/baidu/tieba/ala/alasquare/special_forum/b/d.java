package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ak;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes9.dex */
public class d extends a {
    private CustomMessageListener Wc;
    private final int gBN;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gBO;
    private com.baidu.tieba.ala.alasquare.live.b.c gBP;
    private Runnable gBQ;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gBN = 1000;
        this.mIsBackground = false;
        this.Wc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gBQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bSH();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gBO = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.Wc);
        this.gBO.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void U(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12909", d.this.gKp.gID, 1, cbVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void V(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12910", d.this.gKp.gID, 1, cbVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSG() {
        super.bSG();
        if (this.gBO != null) {
            this.gBO.bRx();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gBO.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bSI();
        if (this.gBO != null) {
            this.gBO.a(this.gBP);
        }
        if (this.gBP != null && this.gBP.amn != null) {
            com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12908", this.gKp.gID, 1, this.gBP.amn.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSH() {
        if (this.gBP != null && this.gBP.amn != null && this.gBP.amn.bol() != null && this.gBO != null) {
            this.gBO.Gg(this.gBP.amn.bol().hls_url);
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
            if (ak.rI(1)) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gBQ);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gBQ, 1000L);
            } else if (this.gBO != null) {
                this.gBO.bRy();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gBO != null) {
            this.gBO.bRy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gBQ);
    }

    private void bSI() {
        this.gBP = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gBP.amn = this.gKp.gdY.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gIC || y.isEmpty(aVar.gdY) || aVar.gdY.get(0) == null || aVar.gdY.get(0).bol() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gBO.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Wc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gBQ);
        if (this.gBO != null) {
            this.gBO.onDestroy();
        }
    }
}
