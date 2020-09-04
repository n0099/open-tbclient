package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<?> efr;
    private b fDJ;
    private c fDK;
    private final int fDI = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener Te = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bFK();
        }
    };
    private Runnable fDL = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.efr = null;
        this.efr = tbPageContext;
        this.fDJ = new b(this.efr);
        MessageManager.getInstance().registerListener(this.Te);
    }

    public View getView() {
        return this.fDJ.getView();
    }

    public void onChangeSkinType() {
        this.fDJ.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajz != null) {
            this.fDK = cVar;
            if (this.fDJ != null) {
                this.fDJ.a(this.fDK);
                aq aqVar = new aq("c12644");
                if (cVar.fDb == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (cVar.fDb == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dD("tid", cVar.ajz.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bFK() {
        if (!this.mIsBackground) {
            if (ah.qL(1)) {
                e.mS().removeCallbacks(this.fDL);
                e.mS().postDelayed(this.fDL, 1000L);
            } else if (this.fDJ != null) {
                this.fDJ.bFN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fDK != null && this.fDK.ajz != null && this.fDK.ajz.beY() != null && this.fDJ != null) {
            this.fDJ.EB(this.fDK.ajz.beY().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fDJ != null) {
            this.fDJ.bFN();
        }
        e.mS().removeCallbacks(this.fDL);
    }

    public void kA(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Te);
        e.mS().removeCallbacks(this.fDL);
        if (this.fDJ != null) {
            this.fDJ.onDestroy();
        }
    }

    public c bFL() {
        return this.fDK;
    }
}
