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
/* loaded from: classes10.dex */
public class d extends a {
    private CustomMessageListener UM;
    private final int gBN;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gBO;
    private com.baidu.tieba.ala.alasquare.live.b.c gBP;
    private Runnable gBQ;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gBN = 1000;
        this.mIsBackground = false;
        this.UM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gBQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bVI();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gBO = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UM);
        this.gBO.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(bz bzVar) {
                if (bzVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12909", d.this.gKo.gIC, 1, bzVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void U(bz bzVar) {
                if (bzVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12910", d.this.gKo.gIC, 1, bzVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bVH() {
        super.bVH();
        if (this.gBO != null) {
            this.gBO.bUx();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gBO.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bVJ();
        if (this.gBO != null) {
            this.gBO.a(this.gBP);
        }
        if (this.gBP != null && this.gBP.alW != null) {
            com.baidu.tieba.ala.alasquare.b.a.bVl().c("c12908", this.gKo.gIC, 1, this.gBP.alW.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        if (this.gBP != null && this.gBP.alW != null && this.gBP.alW.brJ() != null && this.gBO != null) {
            this.gBO.GK(this.gBP.alW.brJ().hls_url);
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
            if (ah.th(1)) {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gBQ);
                com.baidu.adp.lib.f.e.mB().postDelayed(this.gBQ, 1000L);
            } else if (this.gBO != null) {
                this.gBO.bUy();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gBO != null) {
            this.gBO.bUy();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gBQ);
    }

    private void bVJ() {
        this.gBP = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gBP.alW = this.gKo.geK.get(0);
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
        return (1 != aVar.gIB || x.isEmpty(aVar.geK) || aVar.geK.get(0) == null || aVar.geK.get(0).brJ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gBO.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UM);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gBQ);
        if (this.gBO != null) {
            this.gBO.onDestroy();
        }
    }
}
