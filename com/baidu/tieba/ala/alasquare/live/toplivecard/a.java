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
    private TbPageContext<?> cVh;
    private b ekR;
    private c ekS;
    private final int ekQ = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bcl();
        }
    };
    private Runnable ekT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cVh = null;
        this.cVh = tbPageContext;
        this.ekR = new b(this.cVh);
        MessageManager.getInstance().registerListener(this.yE);
    }

    public View getView() {
        return this.ekR.getView();
    }

    public void onChangeSkinType() {
        this.ekR.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null) {
            this.ekS = cVar;
            if (this.ekR != null) {
                this.ekR.a(this.ekS);
                an anVar = new an("c12644");
                if (cVar.ekj == 0) {
                    anVar.X("obj_type", 1);
                } else if (cVar.ekj == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", cVar.NQ.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bcl() {
        if (!this.mIsBackground) {
            if (af.mT(1)) {
                e.gx().removeCallbacks(this.ekT);
                e.gx().postDelayed(this.ekT, 1000L);
            } else if (this.ekR != null) {
                this.ekR.bco();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.ekS != null && this.ekS.NQ != null && this.ekS.NQ.aCH() != null && this.ekR != null) {
            this.ekR.startPlay(this.ekS.NQ.aCH().hls_url);
        }
    }

    public void stopPlay() {
        if (this.ekR != null) {
            this.ekR.bco();
        }
        e.gx().removeCallbacks(this.ekT);
    }

    public void hR(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        e.gx().removeCallbacks(this.ekT);
        if (this.ekR != null) {
            this.ekR.onDestroy();
        }
    }

    public c bcm() {
        return this.ekS;
    }
}
