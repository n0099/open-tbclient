package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes3.dex */
public class d extends a {
    private CustomMessageListener SB;
    private final int fna;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b fnb;
    private com.baidu.tieba.ala.alasquare.live.b.c fnc;
    private Runnable fnd;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fna = 1000;
        this.mIsBackground = false;
        this.SB = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.fnd = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.buO();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fnb = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.SB);
        this.fnb.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void S(bu buVar) {
                if (buVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bup().c("c12909", d.this.fvt.ftH, 1, buVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void T(bu buVar) {
                if (buVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bup().c("c12910", d.this.fvt.ftH, 1, buVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void buN() {
        super.buN();
        if (this.fnb != null) {
            this.fnb.btD();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fnb.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        buP();
        if (this.fnb != null) {
            this.fnb.a(this.fnc);
        }
        if (this.fnc != null && this.fnc.aiq != null) {
            com.baidu.tieba.ala.alasquare.c.a.bup().c("c12908", this.fvt.ftH, 1, this.fnc.aiq.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.fnc != null && this.fnc.aiq != null && this.fnc.aiq.aSJ() != null && this.fnb != null) {
            this.fnb.Bv(this.fnc.aiq.aSJ().hls_url);
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
            if (ag.og(1)) {
                com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fnd);
                com.baidu.adp.lib.f.e.lt().postDelayed(this.fnd, 1000L);
            } else if (this.fnb != null) {
                this.fnb.btE();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.fnb != null) {
            this.fnb.btE();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fnd);
    }

    private void buP() {
        this.fnc = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.fnc.aiq = this.fvt.eSH.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jw(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.ftG || w.isEmpty(aVar.eSH) || aVar.eSH.get(0) == null || aVar.eSH.get(0).aSJ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.fnb.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.SB);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.fnd);
        if (this.fnb != null) {
            this.fnb.onDestroy();
        }
    }
}
