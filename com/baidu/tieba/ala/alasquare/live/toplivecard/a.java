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
    private TbPageContext<?> etO;
    private b fTe;
    private c fTf;
    private final int fTd = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener TO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bJM();
        }
    };
    private Runnable fTg = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.etO = null;
        this.etO = tbPageContext;
        this.fTe = new b(this.etO);
        MessageManager.getInstance().registerListener(this.TO);
    }

    public View getView() {
        return this.fTe.getView();
    }

    public void onChangeSkinType() {
        this.fTe.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akp != null) {
            this.fTf = cVar;
            if (this.fTe != null) {
                this.fTe.a(this.fTf);
                aq aqVar = new aq("c12644");
                if (cVar.fSw == 0) {
                    aqVar.aj("obj_type", 1);
                } else if (cVar.fSw == 1) {
                    aqVar.aj("obj_type", 2);
                }
                aqVar.dK("tid", cVar.akp.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bJM() {
        if (!this.mIsBackground) {
            if (ai.rA(1)) {
                e.mY().removeCallbacks(this.fTg);
                e.mY().postDelayed(this.fTg, 1000L);
            } else if (this.fTe != null) {
                this.fTe.bJP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fTf != null && this.fTf.akp != null && this.fTf.akp.biB() != null && this.fTe != null) {
            this.fTe.FK(this.fTf.akp.biB().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fTe != null) {
            this.fTe.bJP();
        }
        e.mY().removeCallbacks(this.fTg);
    }

    public void la(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TO);
        e.mY().removeCallbacks(this.fTg);
        if (this.fTe != null) {
            this.fTe.onDestroy();
        }
    }

    public c bJN() {
        return this.fTf;
    }
}
