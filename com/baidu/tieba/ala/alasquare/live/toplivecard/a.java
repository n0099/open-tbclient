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
    private b gqN;
    private c gqO;
    private final int gqM = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener UJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bRS();
        }
    };
    private Runnable gqP = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eNx = null;
        this.eNx = tbPageContext;
        this.gqN = new b(this.eNx);
        MessageManager.getInstance().registerListener(this.UJ);
    }

    public View getView() {
        return this.gqN.getView();
    }

    public void onChangeSkinType() {
        this.gqN.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alu != null) {
            this.gqO = cVar;
            if (this.gqN != null) {
                this.gqN.a(this.gqO);
                ar arVar = new ar("c12644");
                if (cVar.gqf == 0) {
                    arVar.al("obj_type", 1);
                } else if (cVar.gqf == 1) {
                    arVar.al("obj_type", 2);
                }
                arVar.dY("tid", cVar.alu.getTid());
                TiebaStatic.log(arVar);
            }
        }
    }

    public void bRS() {
        if (!this.mIsBackground) {
            if (ai.sW(1)) {
                e.mY().removeCallbacks(this.gqP);
                e.mY().postDelayed(this.gqP, 1000L);
            } else if (this.gqN != null) {
                this.gqN.bRV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gqO != null && this.gqO.alu != null && this.gqO.alu.bpj() != null && this.gqN != null) {
            this.gqN.GM(this.gqO.alu.bpj().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gqN != null) {
            this.gqN.bRV();
        }
        e.mY().removeCallbacks(this.gqP);
    }

    public void lX(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.UJ);
        e.mY().removeCallbacks(this.gqP);
        if (this.gqN != null) {
            this.gqN.onDestroy();
        }
    }

    public c bRT() {
        return this.gqO;
    }
}
