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
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes6.dex */
public class a {
    private TbPageContext<?> eNx;
    private b gqP;
    private c gqQ;
    private final int gqO = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bRT();
        }
    };
    private Runnable gqR = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eNx = null;
        this.eNx = tbPageContext;
        this.gqP = new b(this.eNx);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public View getView() {
        return this.gqP.getView();
    }

    public void onChangeSkinType() {
        this.gqP.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alu != null) {
            this.gqQ = cVar;
            if (this.gqP != null) {
                this.gqP.a(this.gqQ);
                ar arVar = new ar("c12644");
                if (cVar.gqh == 0) {
                    arVar.al("obj_type", 1);
                } else if (cVar.gqh == 1) {
                    arVar.al("obj_type", 2);
                }
                arVar.dY("tid", cVar.alu.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bRT() {
        if (!this.mIsBackground) {
            if (ai.sW(1)) {
                e.mY().removeCallbacks(this.gqR);
                e.mY().postDelayed(this.gqR, 1000L);
            } else if (this.gqP != null) {
                this.gqP.bRW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gqQ != null && this.gqQ.alu != null && this.gqQ.alu.bpj() != null && this.gqP != null) {
            this.gqP.GM(this.gqQ.alu.bpj().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gqP != null) {
            this.gqP.bRW();
        }
        e.mY().removeCallbacks(this.gqR);
    }

    public void lX(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        e.mY().removeCallbacks(this.gqR);
        if (this.gqP != null) {
            this.gqP.onDestroy();
        }
    }

    public c bRU() {
        return this.gqQ;
    }
}
