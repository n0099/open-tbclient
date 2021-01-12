package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes9.dex */
public class d extends a {
    private CustomMessageListener UJ;
    private final int gxg;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gxh;
    private com.baidu.tieba.ala.alasquare.live.b.c gxi;
    private Runnable gxj;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gxg = 1000;
        this.mIsBackground = false;
        this.UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gxj = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bRR();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gxh = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UJ);
        this.gxh.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(bz bzVar) {
                if (bzVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12909", d.this.gFI.gDW, 1, bzVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void U(bz bzVar) {
                if (bzVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12910", d.this.gFI.gDW, 1, bzVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bRQ() {
        super.bRQ();
        if (this.gxh != null) {
            this.gxh.bQG();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gxh.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bRS();
        if (this.gxh != null) {
            this.gxh.a(this.gxi);
        }
        if (this.gxi != null && this.gxi.ale != null) {
            com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12908", this.gFI.gDW, 1, this.gxi.ale.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRR() {
        if (this.gxi != null && this.gxi.ale != null && this.gxi.ale.bnQ() != null && this.gxh != null) {
            this.gxh.Fy(this.gxi.ale.bnQ().hls_url);
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
            if (ah.rB(1)) {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gxj);
                com.baidu.adp.lib.f.e.mB().postDelayed(this.gxj, 1000L);
            } else if (this.gxh != null) {
                this.gxh.bQH();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gxh != null) {
            this.gxh.bQH();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gxj);
    }

    private void bRS() {
        this.gxi = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gxi.ale = this.gFI.gaa.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mq(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gDV || x.isEmpty(aVar.gaa) || aVar.gaa.get(0) == null || aVar.gaa.get(0).bnQ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gxh.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gxj);
        if (this.gxh != null) {
            this.gxh.onDestroy();
        }
    }
}
