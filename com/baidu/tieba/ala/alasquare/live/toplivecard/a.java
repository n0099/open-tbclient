package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<?> dVN;
    private b fsl;
    private c fsm;
    private final int fsk = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener Sx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bwK();
        }
    };
    private Runnable fsn = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.dVN = null;
        this.dVN = tbPageContext;
        this.fsl = new b(this.dVN);
        MessageManager.getInstance().registerListener(this.Sx);
    }

    public View getView() {
        return this.fsl.getView();
    }

    public void onChangeSkinType() {
        this.fsl.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.aii != null) {
            this.fsm = cVar;
            if (this.fsl != null) {
                this.fsl.a(this.fsm);
                ap apVar = new ap("c12644");
                if (cVar.frD == 0) {
                    apVar.ah("obj_type", 1);
                } else if (cVar.frD == 1) {
                    apVar.ah("obj_type", 2);
                }
                apVar.dn("tid", cVar.aii.getTid());
                TiebaStatic.log(apVar);
            }
        }
    }

    public void bwK() {
        if (!this.mIsBackground) {
            if (ag.oz(1)) {
                e.lt().removeCallbacks(this.fsn);
                e.lt().postDelayed(this.fsn, 1000L);
            } else if (this.fsl != null) {
                this.fsl.bwN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fsm != null && this.fsm.aii != null && this.fsm.aii.aWF() != null && this.fsl != null) {
            this.fsl.Cg(this.fsm.aii.aWF().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fsl != null) {
            this.fsl.bwN();
        }
        e.lt().removeCallbacks(this.fsn);
    }

    public void ka(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Sx);
        e.lt().removeCallbacks(this.fsn);
        if (this.fsl != null) {
            this.fsl.onDestroy();
        }
    }

    public c bwL() {
        return this.fsm;
    }
}
