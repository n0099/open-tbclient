package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ak;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext<?> eWx;
    private b gBO;
    private c gBP;
    private final int gBN = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener Wc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bRv();
        }
    };
    private Runnable gBQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eWx = null;
        this.eWx = tbPageContext;
        this.gBO = new b(this.eWx);
        MessageManager.getInstance().registerListener(this.Wc);
    }

    public View getView() {
        return this.gBO.getView();
    }

    public void onChangeSkinType() {
        this.gBO.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.amn != null) {
            this.gBP = cVar;
            if (this.gBO != null) {
                this.gBO.a(this.gBP);
                ar arVar = new ar("c12644");
                if (cVar.gBg == 0) {
                    arVar.aq("obj_type", 1);
                } else if (cVar.gBg == 1) {
                    arVar.aq("obj_type", 2);
                }
                arVar.dR("tid", cVar.amn.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bRv() {
        if (!this.mIsBackground) {
            if (ak.rI(1)) {
                e.mA().removeCallbacks(this.gBQ);
                e.mA().postDelayed(this.gBQ, 1000L);
            } else if (this.gBO != null) {
                this.gBO.bRy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gBP != null && this.gBP.amn != null && this.gBP.amn.bol() != null && this.gBO != null) {
            this.gBO.Gg(this.gBP.amn.bol().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gBO != null) {
            this.gBO.bRy();
        }
        e.mA().removeCallbacks(this.gBQ);
    }

    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Wc);
        e.mA().removeCallbacks(this.gBQ);
        if (this.gBO != null) {
            this.gBO.onDestroy();
        }
    }

    public c bRw() {
        return this.gBP;
    }
}
