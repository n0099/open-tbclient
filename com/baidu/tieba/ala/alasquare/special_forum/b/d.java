package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes6.dex */
public class d extends a {
    private CustomMessageListener UJ;
    private final int gqO;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gqP;
    private com.baidu.tieba.ala.alasquare.live.b.c gqQ;
    private Runnable gqR;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gqO = 1000;
        this.mIsBackground = false;
        this.UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gqR = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bTe();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gqP = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UJ);
        this.gqP.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(by byVar) {
                if (byVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12909", d.this.gzl.gxz, 1, byVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(by byVar) {
                if (byVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12910", d.this.gzl.gxz, 1, byVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTd() {
        super.bTd();
        if (this.gqP != null) {
            this.gqP.bRV();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gqP.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bTf();
        if (this.gqP != null) {
            this.gqP.a(this.gqQ);
        }
        if (this.gqQ != null && this.gqQ.alu != null) {
            com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12908", this.gzl.gxz, 1, this.gqQ.alu.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTe() {
        if (this.gqQ != null && this.gqQ.alu != null && this.gqQ.alu.bpj() != null && this.gqP != null) {
            this.gqP.GM(this.gqQ.alu.bpj().hls_url);
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
            if (ai.sW(1)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqR);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.gqR, 1000L);
            } else if (this.gqP != null) {
                this.gqP.bRW();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gqP != null) {
            this.gqP.bRW();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqR);
    }

    private void bTf() {
        this.gqQ = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gqQ.alu = this.gzl.fVe.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lX(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gxy || y.isEmpty(aVar.fVe) || aVar.fVe.get(0) == null || aVar.fVe.get(0).bpj() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gqP.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqR);
        if (this.gqP != null) {
            this.gqP.onDestroy();
        }
    }
}
