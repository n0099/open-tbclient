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
    private TbPageContext<?> duK;
    private b eOZ;
    private c ePa;
    private final int eOY = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener RO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.blf();
        }
    };
    private Runnable ePb = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.duK = null;
        this.duK = tbPageContext;
        this.eOZ = new b(this.duK);
        MessageManager.getInstance().registerListener(this.RO);
    }

    public View getView() {
        return this.eOZ.getView();
    }

    public void onChangeSkinType() {
        this.eOZ.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.agC != null) {
            this.ePa = cVar;
            if (this.eOZ != null) {
                this.eOZ.a(this.ePa);
                an anVar = new an("c12644");
                if (cVar.eOr == 0) {
                    anVar.af("obj_type", 1);
                } else if (cVar.eOr == 1) {
                    anVar.af("obj_type", 2);
                }
                anVar.cI("tid", cVar.agC.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void blf() {
        if (!this.mIsBackground) {
            if (af.ng(1)) {
                e.lb().removeCallbacks(this.ePb);
                e.lb().postDelayed(this.ePb, 1000L);
            } else if (this.eOZ != null) {
                this.eOZ.bli();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.ePa != null && this.ePa.agC != null && this.ePa.agC.aKV() != null && this.eOZ != null) {
            this.eOZ.zq(this.ePa.agC.aKV().hls_url);
        }
    }

    public void stopPlay() {
        if (this.eOZ != null) {
            this.eOZ.bli();
        }
        e.lb().removeCallbacks(this.ePb);
    }

    public void iR(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RO);
        e.lb().removeCallbacks(this.ePb);
        if (this.eOZ != null) {
            this.eOZ.onDestroy();
        }
    }

    public c blg() {
        return this.ePa;
    }
}
