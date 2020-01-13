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
/* loaded from: classes2.dex */
public class d extends a {
    private final int egL;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b egM;
    private com.baidu.tieba.ala.alasquare.live.b.c egN;
    private Runnable egO;
    private boolean mIsBackground;
    private CustomMessageListener ym;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.egL = 1000;
        this.mIsBackground = false;
        this.ym = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.egO = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bbf();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.egM = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.ym);
        this.egM.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void O(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c("c12909", d.this.eoQ.ena, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void P(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c("c12910", d.this.eoQ.ena, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bbe() {
        super.bbe();
        if (this.egM != null) {
            this.egM.aZV();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.egM.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bbg();
        if (this.egM != null) {
            this.egM.a(this.egN);
        }
        if (this.egN != null && this.egN.Np != null) {
            com.baidu.tieba.ala.alasquare.c.a.baG().c("c12908", this.eoQ.ena, 1, this.egN.Np.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbf() {
        if (this.egN != null && this.egN.Np != null && this.egN.Np.aAq() != null && this.egM != null) {
            this.egM.startPlay(this.egN.Np.aAq().hls_url);
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
            if (af.mC(1)) {
                com.baidu.adp.lib.f.e.gx().removeCallbacks(this.egO);
                com.baidu.adp.lib.f.e.gx().postDelayed(this.egO, 1000L);
            } else if (this.egM != null) {
                this.egM.aZW();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.egM != null) {
            this.egM.aZW();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.egO);
    }

    private void bbg() {
        this.egN = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.egN.Np = this.eoQ.dOX.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hK(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.emZ || v.isEmpty(aVar.dOX) || aVar.dOX.get(0) == null || aVar.dOX.get(0).aAq() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.egM.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ym);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.egO);
        if (this.egM != null) {
            this.egM.onDestroy();
        }
    }
}
