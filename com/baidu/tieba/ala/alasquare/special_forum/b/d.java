package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ak;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes10.dex */
public class d extends a {
    private CustomMessageListener UG;
    private final int gzQ;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b gzR;
    private com.baidu.tieba.ala.alasquare.live.b.c gzS;
    private Runnable gzT;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzQ = 1000;
        this.mIsBackground = false;
        this.UG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.gzT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bSu();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gzR = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.UG);
        this.gzR.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void U(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12909", d.this.gIs.gGG, 1, cbVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void V(cb cbVar) {
                if (cbVar != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12910", d.this.gIs.gGG, 1, cbVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSt() {
        super.bSt();
        if (this.gzR != null) {
            this.gzR.bRk();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gzR.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bSv();
        if (this.gzR != null) {
            this.gzR.a(this.gzS);
        }
        if (this.gzS != null && this.gzS.akU != null) {
            com.baidu.tieba.ala.alasquare.b.a.bRX().c("c12908", this.gIs.gGG, 1, this.gzS.akU.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSu() {
        if (this.gzS != null && this.gzS.akU != null && this.gzS.akU.boj() != null && this.gzR != null) {
            this.gzR.FW(this.gzS.akU.boj().hls_url);
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
            if (ak.rG(1)) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gzT);
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gzT, 1000L);
            } else if (this.gzR != null) {
                this.gzR.bRl();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.gzR != null) {
            this.gzR.bRl();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gzT);
    }

    private void bSv() {
        this.gzS = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.gzS.akU = this.gIs.gcs.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gGF || y.isEmpty(aVar.gcs) || aVar.gcs.get(0) == null || aVar.gcs.get(0).boj() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.gzR.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UG);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gzT);
        if (this.gzR != null) {
            this.gzR.onDestroy();
        }
    }
}
