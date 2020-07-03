package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<?> dPv;
    private b fnb;
    private c fnc;
    private final int fna = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener SB = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.btA();
        }
    };
    private Runnable fnd = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.dPv = null;
        this.dPv = tbPageContext;
        this.fnb = new b(this.dPv);
        MessageManager.getInstance().registerListener(this.SB);
    }

    public View getView() {
        return this.fnb.getView();
    }

    public void onChangeSkinType() {
        this.fnb.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.aiq != null) {
            this.fnc = cVar;
            if (this.fnb != null) {
                this.fnb.a(this.fnc);
                ao aoVar = new ao("c12644");
                if (cVar.fmt == 0) {
                    aoVar.ag("obj_type", 1);
                } else if (cVar.fmt == 1) {
                    aoVar.ag("obj_type", 2);
                }
                aoVar.dk("tid", cVar.aiq.getTid());
                TiebaStatic.log(aoVar);
            }
        }
    }

    public void btA() {
        if (!this.mIsBackground) {
            if (ag.og(1)) {
                e.lt().removeCallbacks(this.fnd);
                e.lt().postDelayed(this.fnd, 1000L);
            } else if (this.fnb != null) {
                this.fnb.btD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.fnc != null && this.fnc.aiq != null && this.fnc.aiq.aSJ() != null && this.fnb != null) {
            this.fnb.Bv(this.fnc.aiq.aSJ().hls_url);
        }
    }

    public void stopPlay() {
        if (this.fnb != null) {
            this.fnb.btD();
        }
        e.lt().removeCallbacks(this.fnd);
    }

    public void jw(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.SB);
        e.lt().removeCallbacks(this.fnd);
        if (this.fnb != null) {
            this.fnb.onDestroy();
        }
    }

    public c btB() {
        return this.fnc;
    }
}
