package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes6.dex */
public class d extends a {
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b dvA;
    private com.baidu.tieba.ala.alasquare.live.b.c dvB;
    private Runnable dvC;
    private final int dvz;
    private boolean mIsBackground;
    private CustomMessageListener vG;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dvz = 1000;
        this.mIsBackground = false;
        this.vG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.dvC = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.aKl();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.dvA = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.vG);
        this.dvA.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void J(bh bhVar) {
                if (bhVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12909", d.this.dCC.dBf, 1, bhVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void K(bh bhVar) {
                if (bhVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12910", d.this.dCC.dBf, 1, bhVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKk() {
        super.aKk();
        if (this.dvA != null) {
            this.dvA.aJc();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.dvA.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        aKm();
        if (this.dvA != null) {
            this.dvA.a(this.dvB);
        }
        if (this.dvB != null && this.dvB.cqG != null) {
            com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12908", this.dCC.dBf, 1, this.dvB.cqG.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKl() {
        if (this.dvB != null && this.dvB.cqG != null && this.dvB.cqG.aiX() != null && this.dvA != null) {
            this.dvA.startPlay(this.dvB.cqG.aiX().hls_url);
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
            if (ac.kn(1)) {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dvC);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.dvC, 1000L);
            } else if (this.dvA != null) {
                this.dvA.aJd();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.dvA != null) {
            this.dvA.aJd();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dvC);
    }

    private void aKm() {
        this.dvB = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.dvB.cqG = this.dCC.daV.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void gA(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.dBe || v.isEmpty(aVar.daV) || aVar.daV.get(0) == null || aVar.daV.get(0).aiX() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.dvA.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.vG);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dvC);
        if (this.dvA != null) {
            this.dvA.onDestroy();
        }
    }
}
