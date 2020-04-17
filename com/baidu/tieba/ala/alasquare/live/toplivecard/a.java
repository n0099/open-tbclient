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
    private TbPageContext<?> duG;
    private b eOU;
    private c eOV;
    private final int eOT = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener RJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.blh();
        }
    };
    private Runnable eOW = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.duG = null;
        this.duG = tbPageContext;
        this.eOU = new b(this.duG);
        MessageManager.getInstance().registerListener(this.RJ);
    }

    public View getView() {
        return this.eOU.getView();
    }

    public void onChangeSkinType() {
        this.eOU.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.agz != null) {
            this.eOV = cVar;
            if (this.eOU != null) {
                this.eOU.a(this.eOV);
                an anVar = new an("c12644");
                if (cVar.eOm == 0) {
                    anVar.af("obj_type", 1);
                } else if (cVar.eOm == 1) {
                    anVar.af("obj_type", 2);
                }
                anVar.cI("tid", cVar.agz.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void blh() {
        if (!this.mIsBackground) {
            if (af.ng(1)) {
                e.lb().removeCallbacks(this.eOW);
                e.lb().postDelayed(this.eOW, 1000L);
            } else if (this.eOU != null) {
                this.eOU.blk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.eOV != null && this.eOV.agz != null && this.eOV.agz.aKX() != null && this.eOU != null) {
            this.eOU.zn(this.eOV.agz.aKX().hls_url);
        }
    }

    public void stopPlay() {
        if (this.eOU != null) {
            this.eOU.blk();
        }
        e.lb().removeCallbacks(this.eOW);
    }

    public void iR(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RJ);
        e.lb().removeCallbacks(this.eOW);
        if (this.eOU != null) {
            this.eOU.onDestroy();
        }
    }

    public c bli() {
        return this.eOV;
    }
}
