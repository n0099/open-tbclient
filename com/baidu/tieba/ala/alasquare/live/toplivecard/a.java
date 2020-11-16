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
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<?> eGu;
    private b giE;
    private c giF;
    private final int giD = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener TQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bOh();
        }
    };
    private Runnable giG = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eGu = null;
        this.eGu = tbPageContext;
        this.giE = new b(this.eGu);
        MessageManager.getInstance().registerListener(this.TQ);
    }

    public View getView() {
        return this.giE.getView();
    }

    public void onChangeSkinType() {
        this.giE.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akt != null) {
            this.giF = cVar;
            if (this.giE != null) {
                this.giE.a(this.giF);
                ar arVar = new ar("c12644");
                if (cVar.ghV == 0) {
                    arVar.ak("obj_type", 1);
                } else if (cVar.ghV == 1) {
                    arVar.ak("obj_type", 2);
                }
                arVar.dR("tid", cVar.akt.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bOh() {
        if (!this.mIsBackground) {
            if (ah.st(1)) {
                e.mY().removeCallbacks(this.giG);
                e.mY().postDelayed(this.giG, 1000L);
            } else if (this.giE != null) {
                this.giE.bOk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.giF != null && this.giF.akt != null && this.giF.akt.blW() != null && this.giE != null) {
            this.giE.FY(this.giF.akt.blW().hls_url);
        }
    }

    public void stopPlay() {
        if (this.giE != null) {
            this.giE.bOk();
        }
        e.mY().removeCallbacks(this.giG);
    }

    public void lC(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TQ);
        e.mY().removeCallbacks(this.giG);
        if (this.giE != null) {
            this.giE.onDestroy();
        }
    }

    public c bOi() {
        return this.giF;
    }
}
