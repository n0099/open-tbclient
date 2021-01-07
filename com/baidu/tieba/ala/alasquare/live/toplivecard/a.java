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
/* loaded from: classes10.dex */
public class a {
    private TbPageContext<?> eXu;
    private b gBO;
    private c gBP;
    private final int gBN = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bUw();
        }
    };
    private Runnable gBQ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eXu = null;
        this.eXu = tbPageContext;
        this.gBO = new b(this.eXu);
        MessageManager.getInstance().registerListener(this.UM);
    }

    public View getView() {
        return this.gBO.getView();
    }

    public void onChangeSkinType() {
        this.gBO.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alW != null) {
            this.gBP = cVar;
            if (this.gBO != null) {
                this.gBO.a(this.gBP);
                aq aqVar = new aq("c12644");
                if (cVar.gBg == 0) {
                    aqVar.an("obj_type", 1);
                } else if (cVar.gBg == 1) {
                    aqVar.an("obj_type", 2);
                }
                aqVar.dX("tid", cVar.alW.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bUw() {
        if (!this.mIsBackground) {
            if (ah.th(1)) {
                e.mB().removeCallbacks(this.gBQ);
                e.mB().postDelayed(this.gBQ, 1000L);
            } else if (this.gBO != null) {
                this.gBO.bUz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gBP != null && this.gBP.alW != null && this.gBP.alW.brK() != null && this.gBO != null) {
            this.gBO.GJ(this.gBP.alW.brK().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gBO != null) {
            this.gBO.bUz();
        }
        e.mB().removeCallbacks(this.gBQ);
    }

    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UM);
        e.mB().removeCallbacks(this.gBQ);
        if (this.gBO != null) {
            this.gBO.onDestroy();
        }
    }

    public c bUx() {
        return this.gBP;
    }
}
