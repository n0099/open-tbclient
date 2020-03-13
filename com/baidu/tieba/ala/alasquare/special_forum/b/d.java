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
    private final int eld;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b ele;
    private com.baidu.tieba.ala.alasquare.live.b.c elf;
    private Runnable elg;
    private boolean mIsBackground;
    private CustomMessageListener yE;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eld = 1000;
        this.mIsBackground = false;
        this.yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.elg = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bdx();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.ele = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.yE);
        this.ele.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12909", d.this.etp.erC, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12910", d.this.etp.erC, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdw() {
        super.bdw();
        if (this.ele != null) {
            this.ele.bco();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.ele.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bdy();
        if (this.ele != null) {
            this.ele.a(this.elf);
        }
        if (this.elf != null && this.elf.NQ != null) {
            com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12908", this.etp.erC, 1, this.elf.NQ.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        if (this.elf != null && this.elf.NQ != null && this.elf.NQ.aCH() != null && this.ele != null) {
            this.ele.startPlay(this.elf.NQ.aCH().hls_url);
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
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elg);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.elg, 1000L);
            } else if (this.ele != null) {
                this.ele.bcp();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.ele != null) {
            this.ele.bcp();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elg);
    }

    private void bdy() {
        this.elf = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.elf.NQ = this.etp.dTr.get(0);
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
        return (1 != aVar.erB || v.isEmpty(aVar.dTr) || aVar.dTr.get(0) == null || aVar.dTr.get(0).aCH() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.ele.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.elg);
        if (this.ele != null) {
            this.ele.onDestroy();
        }
    }
}
