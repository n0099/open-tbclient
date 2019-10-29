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
    private final int dwq;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.b dwr;
    private com.baidu.tieba.ala.alasquare.live.b.c dws;
    private Runnable dwt;
    private boolean mIsBackground;
    private CustomMessageListener wh;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dwq = 1000;
        this.mIsBackground = false;
        this.wh = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.startPlay();
            }
        };
        this.dwt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.aKn();
            }
        };
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.dwr = new com.baidu.tieba.ala.alasquare.live.toplivecard.b(this.mTbPageContext, true);
        MessageManager.getInstance().registerListener(this.wh);
        this.dwr.a(new b.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.d.2
            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void J(bh bhVar) {
                if (bhVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12909", d.this.dDt.dBW, 1, bhVar.getId());
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.live.toplivecard.b.a
            public void K(bh bhVar) {
                if (bhVar != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12910", d.this.dDt.dBW, 1, bhVar.getId());
                }
            }
        });
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKm() {
        super.aKm();
        if (this.dwr != null) {
            this.dwr.aJe();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.dwr.getView();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        aKo();
        if (this.dwr != null) {
            this.dwr.a(this.dws);
        }
        if (this.dws != null && this.dws.cry != null) {
            com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12908", this.dDt.dBW, 1, this.dws.cry.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKn() {
        if (this.dws != null && this.dws.cry != null && this.dws.cry.aiZ() != null && this.dwr != null) {
            this.dwr.startPlay(this.dws.cry.aiZ().hls_url);
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
            if (ac.ko(1)) {
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dwt);
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.dwt, 1000L);
            } else if (this.dwr != null) {
                this.dwr.aJf();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
        if (this.dwr != null) {
            this.dwr.aJf();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dwt);
    }

    private void aKo() {
        this.dws = new com.baidu.tieba.ala.alasquare.live.b.c();
        this.dws.cry = this.dDt.dbM.get(0);
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
        return (1 != aVar.dBV || v.isEmpty(aVar.dbM) || aVar.dbM.get(0) == null || aVar.dbM.get(0).aiZ() == null) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        this.dwr.onChangeSkinType();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.wh);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dwt);
        if (this.dwr != null) {
            this.dwr.onDestroy();
        }
    }
}
