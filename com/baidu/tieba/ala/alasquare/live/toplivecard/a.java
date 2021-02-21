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
/* loaded from: classes10.dex */
public class a {
    private TbPageContext<?> eUY;
    private b gAf;
    private c gAg;
    private final int gAe = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bRp();
        }
    };
    private Runnable gAh = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eUY = null;
        this.eUY = tbPageContext;
        this.gAf = new b(this.eUY);
        MessageManager.getInstance().registerListener(this.UG);
    }

    public View getView() {
        return this.gAf.getView();
    }

    public void onChangeSkinType() {
        this.gAf.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akU != null) {
            this.gAg = cVar;
            if (this.gAf != null) {
                this.gAf.a(this.gAg);
                ar arVar = new ar("c12644");
                if (cVar.gzx == 0) {
                    arVar.ap("obj_type", 1);
                } else if (cVar.gzx == 1) {
                    arVar.ap("obj_type", 2);
                }
                arVar.dR("tid", cVar.akU.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bRp() {
        if (!this.mIsBackground) {
            if (ak.rG(1)) {
                e.mA().removeCallbacks(this.gAh);
                e.mA().postDelayed(this.gAh, 1000L);
            } else if (this.gAf != null) {
                this.gAf.bRs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gAg != null && this.gAg.akU != null && this.gAg.akU.boj() != null && this.gAf != null) {
            this.gAf.FX(this.gAg.akU.boj().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gAf != null) {
            this.gAf.bRs();
        }
        e.mA().removeCallbacks(this.gAh);
    }

    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UG);
        e.mA().removeCallbacks(this.gAh);
        if (this.gAf != null) {
            this.gAf.onDestroy();
        }
    }

    public c bRq() {
        return this.gAg;
    }
}
