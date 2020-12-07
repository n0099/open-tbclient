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
    private final int gqM;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gqN;
    private com.baidu.tieba.ala.alasquare.live.b.c gqO;
    private Runnable gqP;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gqM = 1000;
        this.mIsBackground = false;
        this.UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gqP = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bTd();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gqN = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UJ);
        this.gqN.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(by byVar) {
                if (byVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12909", d.this.gzj.gxx, 1, byVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(by byVar) {
                if (byVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12910", d.this.gzj.gxx, 1, byVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTc() {
        super.bTc();
        if (this.gqN != null) {
            this.gqN.bRU();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gqN.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bTe();
        if (this.gqN != null) {
            this.gqN.a(this.gqO);
        }
        if (this.gqO != null && this.gqO.alu != null) {
            com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12908", this.gzj.gxx, 1, this.gqO.alu.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTd() {
        if (this.gqO != null && this.gqO.alu != null && this.gqO.alu.bpj() != null && this.gqN != null) {
            this.gqN.GM(this.gqO.alu.bpj().hls_url);
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
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqP);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.gqP, 1000L);
            } else if (this.gqN != null) {
                this.gqN.bRV();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gqN != null) {
            this.gqN.bRV();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqP);
    }

    private void bTe() {
        this.gqO = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gqO.alu = this.gzj.fVe.get(0);
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
        return (1 != aVar.gxw || y.isEmpty(aVar.fVe) || aVar.fVe.get(0) == null || aVar.fVe.get(0).bpj() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gqN.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.gqP);
        if (this.gqN != null) {
            this.gqN.onDestroy();
        }
    }
}
