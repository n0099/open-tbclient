package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes3.dex */
public class d extends a {
    private final int ekQ;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b ekR;
    private com.baidu.tieba.ala.alasquare.live.b.c ekS;
    private Runnable ekT;
    private boolean mIsBackground;
    private CustomMessageListener yE;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ekQ = 1000;
        this.mIsBackground = false;
        this.yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.ekT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bdw();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.ekR = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.yE);
        this.ekR.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12909", d.this.etb.ero, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12910", d.this.etb.ero, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdv() {
        super.bdv();
        if (this.ekR != null) {
            this.ekR.bcn();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.ekR.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bdx();
        if (this.ekR != null) {
            this.ekR.a(this.ekS);
        }
        if (this.ekS != null && this.ekS.NQ != null) {
            com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12908", this.etb.ero, 1, this.ekS.NQ.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdw() {
        if (this.ekS != null && this.ekS.NQ != null && this.ekS.NQ.aCH() != null && this.ekR != null) {
            this.ekR.startPlay(this.ekS.NQ.aCH().hls_url);
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
            if (af.mT(1)) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekT);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.ekT, 1000L);
            } else if (this.ekR != null) {
                this.ekR.bco();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ekR != null) {
            this.ekR.bco();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekT);
    }

    private void bdx() {
        this.ekS = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.ekS.NQ = this.etb.dTe.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hR(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.ern || v.isEmpty(aVar.dTe) || aVar.dTe.get(0) == null || aVar.dTe.get(0).aCH() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.ekR.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ekT);
        if (this.ekR != null) {
            this.ekR.onDestroy();
        }
    }
}
