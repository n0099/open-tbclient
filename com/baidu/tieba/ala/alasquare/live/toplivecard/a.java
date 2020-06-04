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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<?> dIF;
    private b fbR;
    private c fbS;
    private final int fbQ = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener RZ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bqD();
        }
    };
    private Runnable fbT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.dIF = null;
        this.dIF = tbPageContext;
        this.fbR = new b(this.dIF);
        MessageManager.getInstance().registerListener(this.RZ);
    }

    public View getView() {
        return this.fbR.getView();
    }

    public void onChangeSkinType() {
        this.fbR.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ahg != null) {
            this.fbS = cVar;
            if (this.fbR != null) {
                this.fbR.a(this.fbS);
                an anVar = new an("c12644");
                if (cVar.fbj == 0) {
                    anVar.ag("obj_type", 1);
                } else if (cVar.fbj == 1) {
                    anVar.ag("obj_type", 2);
                }
                anVar.dh("tid", cVar.ahg.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bqD() {
        if (!this.mIsBackground) {
            if (ag.nK(1)) {
                e.ld().removeCallbacks(this.fbT);
                e.ld().postDelayed(this.fbT, 1000L);
            } else if (this.fbR != null) {
                this.fbR.bqG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fbS != null && this.fbS.ahg != null && this.fbS.ahg.aQS() != null && this.fbR != null) {
            this.fbR.AW(this.fbS.ahg.aQS().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fbR != null) {
            this.fbR.bqG();
        }
        e.ld().removeCallbacks(this.fbT);
    }

    public void jj(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RZ);
        e.ld().removeCallbacks(this.fbT);
        if (this.fbR != null) {
            this.fbR.onDestroy();
        }
    }

    public c bqE() {
        return this.fbS;
    }
}
