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
    private CustomMessageListener RO;
    private final int eOY;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b eOZ;
    private com.baidu.tieba.ala.alasquare.live.b.c ePa;
    private Runnable ePb;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eOY = 1000;
        this.mIsBackground = false;
        this.RO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.ePb = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bmr();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eOZ = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.RO);
        this.eOZ.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().c("c12909", d.this.eXl.eVz, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().c("c12910", d.this.eXl.eVz, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bmq() {
        super.bmq();
        if (this.eOZ != null) {
            this.eOZ.blh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eOZ.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bms();
        if (this.eOZ != null) {
            this.eOZ.a(this.ePa);
        }
        if (this.ePa != null && this.ePa.agC != null) {
            com.baidu.tieba.ala.alasquare.c.a.blS().c("c12908", this.eXl.eVz, 1, this.ePa.agC.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmr() {
        if (this.ePa != null && this.ePa.agC != null && this.ePa.agC.aKV() != null && this.eOZ != null) {
            this.eOZ.zq(this.ePa.agC.aKV().hls_url);
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
            if (af.ng(1)) {
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.ePb);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.ePb, 1000L);
            } else if (this.eOZ != null) {
                this.eOZ.bli();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.eOZ != null) {
            this.eOZ.bli();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.ePb);
    }

    private void bms() {
        this.ePa = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.ePa.agC = this.eXl.etL.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void iR(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.eVy || v.isEmpty(aVar.etL) || aVar.etL.get(0) == null || aVar.etL.get(0).aKV() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.eOZ.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RO);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.ePb);
        if (this.eOZ != null) {
            this.eOZ.onDestroy();
        }
    }
}
