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
    private final int egB;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b egC;
    private com.baidu.tieba.ala.alasquare.live.b.c egD;
    private Runnable egE;
    private boolean mIsBackground;
    private CustomMessageListener yi;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.egB = 1000;
        this.mIsBackground = false;
        this.yi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.egE = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.baK();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.egC = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.yi);
        this.egC.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void N(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c("c12909", d.this.enC.emd, 1, bjVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void O(bj bjVar) {
                if (bjVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c("c12910", d.this.enC.emd, 1, bjVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void baJ() {
        super.baJ();
        if (this.egC != null) {
            this.egC.aZA();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.egC.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        baL();
        if (this.egC != null) {
            this.egC.a(this.egD);
        }
        if (this.egD != null && this.egD.Nl != null) {
            com.baidu.tieba.ala.alasquare.c.a.bal().c("c12908", this.enC.emd, 1, this.egD.Nl.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baK() {
        if (this.egD != null && this.egD.Nl != null && this.egD.Nl.azX() != null && this.egC != null) {
            this.egC.startPlay(this.egD.Nl.azX().hls_url);
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
                com.baidu.adp.lib.f.e.gy().removeCallbacks(this.egE);
                com.baidu.adp.lib.f.e.gy().postDelayed(this.egE, 1000L);
            } else if (this.egC != null) {
                this.egC.aZB();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.egC != null) {
            this.egC.aZB();
        }
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.egE);
    }

    private void baL() {
        this.egD = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.egD.Nl = this.enC.dOP.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hF(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.emc || v.isEmpty(aVar.dOP) || aVar.dOP.get(0) == null || aVar.dOP.get(0).azX() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.egC.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yi);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.egE);
        if (this.egC != null) {
            this.egC.onDestroy();
        }
    }
}
