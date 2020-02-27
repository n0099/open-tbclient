package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<?> cVg;
    private b ekQ;
    private c ekR;
    private final int ekP = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bcj();
        }
    };
    private Runnable ekS = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cVg = null;
        this.cVg = tbPageContext;
        this.ekQ = new b(this.cVg);
        MessageManager.getInstance().registerListener(this.yE);
    }

    public View getView() {
        return this.ekQ.getView();
    }

    public void onChangeSkinType() {
        this.ekQ.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null) {
            this.ekR = cVar;
            if (this.ekQ != null) {
                this.ekQ.a(this.ekR);
                an anVar = new an("c12644");
                if (cVar.eki == 0) {
                    anVar.X("obj_type", 1);
                } else if (cVar.eki == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", cVar.NQ.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bcj() {
        if (!this.mIsBackground) {
            if (af.mT(1)) {
                e.gx().removeCallbacks(this.ekS);
                e.gx().postDelayed(this.ekS, 1000L);
            } else if (this.ekQ != null) {
                this.ekQ.bcm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.ekR != null && this.ekR.NQ != null && this.ekR.NQ.aCF() != null && this.ekQ != null) {
            this.ekQ.startPlay(this.ekR.NQ.aCF().hls_url);
        }
    }

    public void stopPlay() {
        if (this.ekQ != null) {
            this.ekQ.bcm();
        }
        e.gx().removeCallbacks(this.ekS);
    }

    public void hR(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        e.gx().removeCallbacks(this.ekS);
        if (this.ekQ != null) {
            this.ekQ.onDestroy();
        }
    }

    public c bck() {
        return this.ekR;
    }
}
