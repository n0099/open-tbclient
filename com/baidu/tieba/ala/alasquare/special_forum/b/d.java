package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.toplivecard.b;
/* loaded from: classes4.dex */
public class d extends a {
    private CustomMessageListener TP;
    private final int giW;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b giX;
    private com.baidu.tieba.ala.alasquare.live.b.c giY;
    private Runnable giZ;
    private boolean mIsBackground;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.giW = 1000;
        this.mIsBackground = false;
        this.TP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.giZ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.bPZ();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.giX = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.TP);
        this.giX.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void Q(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12909", d.this.grt.gpH, 1, bwVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void R(bw bwVar) {
                if (bwVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12910", d.this.grt.gpH, 1, bwVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPY() {
        super.bPY();
        if (this.giX != null) {
            this.giX.bOQ();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.giX.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        bQa();
        if (this.giX != null) {
            this.giX.a(this.giY);
        }
        if (this.giY != null && this.giY.akq != null) {
            com.baidu.tieba.ala.alasquare.c.a.bPC().c("c12908", this.grt.gpH, 1, this.giY.akq.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPZ() {
        if (this.giY != null && this.giY.akq != null && this.giY.akq.bmU() != null && this.giX != null) {
            this.giX.Gx(this.giY.akq.bmU().hls_url);
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
            if (ai.rV(1)) {
                com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giZ);
                com.baidu.adp.lib.f.e.mY().postDelayed(this.giZ, 1000L);
            } else if (this.giX != null) {
                this.giX.bOR();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.giX != null) {
            this.giX.bOR();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giZ);
    }

    private void bQa() {
        this.giY = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.giY.akq = this.grt.fNQ.get(0);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lB(boolean z) {
        this.mIsBackground = z;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (1 != aVar.gpG || y.isEmpty(aVar.fNQ) || aVar.fNQ.get(0) == null || aVar.fNQ.get(0).bmU() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.giX.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.giZ);
        if (this.giX != null) {
            this.giX.onDestroy();
        }
    }
}
