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
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<?> ehG;
    private b fGV;
    private c fGW;
    private final int fGU = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener Tw = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bHa();
        }
    };
    private Runnable fGX = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.ehG = null;
        this.ehG = tbPageContext;
        this.fGV = new b(this.ehG);
        MessageManager.getInstance().registerListener(this.Tw);
    }

    public View getView() {
        return this.fGV.getView();
    }

    public void onChangeSkinType() {
        this.fGV.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajX != null) {
            this.fGW = cVar;
            if (this.fGV != null) {
                this.fGV.a(this.fGW);
                aq aqVar = new aq("c12644");
                if (cVar.fGn == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (cVar.fGn == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dF("tid", cVar.ajX.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bHa() {
        if (!this.mIsBackground) {
            if (ai.rc(1)) {
                e.mX().removeCallbacks(this.fGX);
                e.mX().postDelayed(this.fGX, 1000L);
            } else if (this.fGV != null) {
                this.fGV.bHd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fGW != null && this.fGW.ajX != null && this.fGW.ajX.bfS() != null && this.fGV != null) {
            this.fGV.EZ(this.fGW.ajX.bfS().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fGV != null) {
            this.fGV.bHd();
        }
        e.mX().removeCallbacks(this.fGX);
    }

    public void kC(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Tw);
        e.mX().removeCallbacks(this.fGX);
        if (this.fGV != null) {
            this.fGV.onDestroy();
        }
    }

    public c bHb() {
        return this.fGW;
    }
}
