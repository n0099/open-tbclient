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
/* loaded from: classes9.dex */
public class a {
    private TbPageContext<?> eSJ;
    private b gxh;
    private c gxi;
    private final int gxg = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bQE();
        }
    };
    private Runnable gxj = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eSJ = null;
        this.eSJ = tbPageContext;
        this.gxh = new b(this.eSJ);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public View getView() {
        return this.gxh.getView();
    }

    public void onChangeSkinType() {
        this.gxh.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ale != null) {
            this.gxi = cVar;
            if (this.gxh != null) {
                this.gxh.a(this.gxi);
                aq aqVar = new aq("c12644");
                if (cVar.gwz == 0) {
                    aqVar.an("obj_type", 1);
                } else if (cVar.gwz == 1) {
                    aqVar.an("obj_type", 2);
                }
                aqVar.dW("tid", cVar.ale.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bQE() {
        if (!this.mIsBackground) {
            if (ah.rB(1)) {
                e.mB().removeCallbacks(this.gxj);
                e.mB().postDelayed(this.gxj, 1000L);
            } else if (this.gxh != null) {
                this.gxh.bQH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gxi != null && this.gxi.ale != null && this.gxi.ale.bnQ() != null && this.gxh != null) {
            this.gxh.Fy(this.gxi.ale.bnQ().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gxh != null) {
            this.gxh.bQH();
        }
        e.mB().removeCallbacks(this.gxj);
    }

    public void mq(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        e.mB().removeCallbacks(this.gxj);
        if (this.gxh != null) {
            this.gxh.onDestroy();
        }
    }

    public c bQF() {
        return this.gxi;
    }
}
