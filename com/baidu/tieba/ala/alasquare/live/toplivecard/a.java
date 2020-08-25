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
    private TbPageContext<?> efn;
    private b fDF;
    private c fDG;
    private final int fDE = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener Te = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bFJ();
        }
    };
    private Runnable fDH = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.efn = null;
        this.efn = tbPageContext;
        this.fDF = new b(this.efn);
        MessageManager.getInstance().registerListener(this.Te);
    }

    public View getView() {
        return this.fDF.getView();
    }

    public void onChangeSkinType() {
        this.fDF.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajx != null) {
            this.fDG = cVar;
            if (this.fDF != null) {
                this.fDF.a(this.fDG);
                aq aqVar = new aq("c12644");
                if (cVar.fCX == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (cVar.fCX == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dD("tid", cVar.ajx.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bFJ() {
        if (!this.mIsBackground) {
            if (ah.qL(1)) {
                e.mS().removeCallbacks(this.fDH);
                e.mS().postDelayed(this.fDH, 1000L);
            } else if (this.fDF != null) {
                this.fDF.bFM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fDG != null && this.fDG.ajx != null && this.fDG.ajx.beY() != null && this.fDF != null) {
            this.fDF.EA(this.fDG.ajx.beY().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fDF != null) {
            this.fDF.bFM();
        }
        e.mS().removeCallbacks(this.fDH);
    }

    public void ky(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Te);
        e.mS().removeCallbacks(this.fDH);
        if (this.fDF != null) {
            this.fDF.onDestroy();
        }
    }

    public c bFK() {
        return this.fDG;
    }
}
