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
    private b fbG;
    private c fbH;
    private final int fbF = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener RZ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bqB();
        }
    };
    private Runnable fbI = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.dIF = null;
        this.dIF = tbPageContext;
        this.fbG = new b(this.dIF);
        MessageManager.getInstance().registerListener(this.RZ);
    }

    public View getView() {
        return this.fbG.getView();
    }

    public void onChangeSkinType() {
        this.fbG.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ahg != null) {
            this.fbH = cVar;
            if (this.fbG != null) {
                this.fbG.a(this.fbH);
                an anVar = new an("c12644");
                if (cVar.faY == 0) {
                    anVar.ag("obj_type", 1);
                } else if (cVar.faY == 1) {
                    anVar.ag("obj_type", 2);
                }
                anVar.dh("tid", cVar.ahg.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bqB() {
        if (!this.mIsBackground) {
            if (ag.nI(1)) {
                e.ld().removeCallbacks(this.fbI);
                e.ld().postDelayed(this.fbI, 1000L);
            } else if (this.fbG != null) {
                this.fbG.bqE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fbH != null && this.fbH.ahg != null && this.fbH.ahg.aQS() != null && this.fbG != null) {
            this.fbG.AW(this.fbH.ahg.aQS().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fbG != null) {
            this.fbG.bqE();
        }
        e.ld().removeCallbacks(this.fbI);
    }

    public void jj(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.RZ);
        e.ld().removeCallbacks(this.fbI);
        if (this.fbG != null) {
            this.fbG.onDestroy();
        }
    }

    public c bqC() {
        return this.fbH;
    }
}
