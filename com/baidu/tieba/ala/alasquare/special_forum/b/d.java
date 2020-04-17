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
    private CustomMessageListener RJ;
    private final int eOT;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b eOU;
    private com.baidu.tieba.ala.alasquare.live.b.c eOV;
    private Runnable eOW;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eOT = 1000;
        this.mIsBackground = false;
        this.RJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.eOW = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bmt();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eOU = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.RJ);
        this.eOU.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().c("c12909", d.this.eXg.eVu, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().c("c12910", d.this.eXg.eVu, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bms() {
        super.bms();
        if (this.eOU != null) {
            this.eOU.blj();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eOU.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bmu();
        if (this.eOU != null) {
            this.eOU.a(this.eOV);
        }
        if (this.eOV != null && this.eOV.agz != null) {
            com.baidu.tieba.ala.alasquare.c.a.blU().c("c12908", this.eXg.eVu, 1, this.eOV.agz.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmt() {
        if (this.eOV != null && this.eOV.agz != null && this.eOV.agz.aKX() != null && this.eOU != null) {
            this.eOU.zn(this.eOV.agz.aKX().hls_url);
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
                com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eOW);
                com.baidu.adp.lib.f.e.lb().postDelayed(this.eOW, 1000L);
            } else if (this.eOU != null) {
                this.eOU.blk();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.eOU != null) {
            this.eOU.blk();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eOW);
    }

    private void bmu() {
        this.eOV = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.eOV.agz = this.eXg.etG.get(0);
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
        return (1 != aVar.eVt || v.isEmpty(aVar.etG) || aVar.etG.get(0) == null || aVar.etG.get(0).aKX() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.eOU.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RJ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eOW);
        if (this.eOU != null) {
            this.eOU.onDestroy();
        }
    }
}
