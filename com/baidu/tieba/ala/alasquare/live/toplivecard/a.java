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
    private b gzR;
    private c gzS;
    private final int gzQ = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bRi();
        }
    };
    private Runnable gzT = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eUY = null;
        this.eUY = tbPageContext;
        this.gzR = new b(this.eUY);
        MessageManager.getInstance().registerListener(this.UG);
    }

    public View getView() {
        return this.gzR.getView();
    }

    public void onChangeSkinType() {
        this.gzR.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akU != null) {
            this.gzS = cVar;
            if (this.gzR != null) {
                this.gzR.a(this.gzS);
                ar arVar = new ar("c12644");
                if (cVar.gzj == 0) {
                    arVar.ap("obj_type", 1);
                } else if (cVar.gzj == 1) {
                    arVar.ap("obj_type", 2);
                }
                arVar.dR("tid", cVar.akU.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bRi() {
        if (!this.mIsBackground) {
            if (ak.rG(1)) {
                e.mA().removeCallbacks(this.gzT);
                e.mA().postDelayed(this.gzT, 1000L);
            } else if (this.gzR != null) {
                this.gzR.bRl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gzS != null && this.gzS.akU != null && this.gzS.akU.boj() != null && this.gzR != null) {
            this.gzR.FW(this.gzS.akU.boj().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gzR != null) {
            this.gzR.bRl();
        }
        e.mA().removeCallbacks(this.gzT);
    }

    public void mu(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UG);
        e.mA().removeCallbacks(this.gzT);
        if (this.gzR != null) {
            this.gzR.onDestroy();
        }
    }

    public c bRj() {
        return this.gzS;
    }
}
