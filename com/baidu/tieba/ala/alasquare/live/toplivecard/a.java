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
import com.baidu.tbadk.util.af;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<?> cVv;
    private b elu;
    private c elv;
    private final int elt = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bcq();
        }
    };
    private Runnable elw = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cVv = null;
        this.cVv = tbPageContext;
        this.elu = new b(this.cVv);
        MessageManager.getInstance().registerListener(this.yE);
    }

    public View getView() {
        return this.elu.getView();
    }

    public void onChangeSkinType() {
        this.elu.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NR != null) {
            this.elv = cVar;
            if (this.elu != null) {
                this.elu.a(this.elv);
                an anVar = new an("c12644");
                if (cVar.ekM == 0) {
                    anVar.X("obj_type", 1);
                } else if (cVar.ekM == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cx("tid", cVar.NR.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bcq() {
        if (!this.mIsBackground) {
            if (af.mV(1)) {
                e.gx().removeCallbacks(this.elw);
                e.gx().postDelayed(this.elw, 1000L);
            } else if (this.elu != null) {
                this.elu.bct();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.elv != null && this.elv.NR != null && this.elv.NR.aCK() != null && this.elu != null) {
            this.elu.startPlay(this.elv.NR.aCK().hls_url);
        }
    }

    public void stopPlay() {
        if (this.elu != null) {
            this.elu.bct();
        }
        e.gx().removeCallbacks(this.elw);
    }

    public void hS(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        e.gx().removeCallbacks(this.elw);
        if (this.elu != null) {
            this.elu.onDestroy();
        }
    }

    public c bcr() {
        return this.elv;
    }
}
