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
    private final int elt;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b elu;
    private com.baidu.tieba.ala.alasquare.live.b.c elv;
    private Runnable elw;
    private boolean mIsBackground;
    private CustomMessageListener yE;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.elt = 1000;
        this.mIsBackground = false;
        this.yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.elw = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bdC();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.elu = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.yE);
        this.elu.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12909", d.this.etL.erY, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12910", d.this.etL.erY, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdB() {
        super.bdB();
        if (this.elu != null) {
            this.elu.bcs();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.elu.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bdD();
        if (this.elu != null) {
            this.elu.a(this.elv);
        }
        if (this.elv != null && this.elv.NR != null) {
            com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12908", this.etL.erY, 1, this.elv.NR.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdC() {
        if (this.elv != null && this.elv.NR != null && this.elv.NR.aCK() != null && this.elu != null) {
            this.elu.startPlay(this.elv.NR.aCK().hls_url);
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
            if (af.mV(1)) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elw);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.elw, 1000L);
            } else if (this.elu != null) {
                this.elu.bct();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.elu != null) {
            this.elu.bct();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elw);
    }

    private void bdD() {
        this.elv = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.elv.NR = this.etL.dTH.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hS(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.erX || v.isEmpty(aVar.dTH) || aVar.dTH.get(0) == null || aVar.dTH.get(0).aCK() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.elu.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elw);
        if (this.elu != null) {
            this.elu.onDestroy();
        }
    }
}
