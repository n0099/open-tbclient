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
    private TbPageContext<?> cVi;
    private b ele;
    private c elf;
    private final int eld = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener yE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bcm();
        }
    };
    private Runnable elg = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cVi = null;
        this.cVi = tbPageContext;
        this.ele = new b(this.cVi);
        MessageManager.getInstance().registerListener(this.yE);
    }

    public View getView() {
        return this.ele.getView();
    }

    public void onChangeSkinType() {
        this.ele.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null) {
            this.elf = cVar;
            if (this.ele != null) {
                this.ele.a(this.elf);
                an anVar = new an("c12644");
                if (cVar.ekw == 0) {
                    anVar.X("obj_type", 1);
                } else if (cVar.ekw == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", cVar.NQ.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void bcm() {
        if (!this.mIsBackground) {
            if (af.mT(1)) {
                e.gx().removeCallbacks(this.elg);
                e.gx().postDelayed(this.elg, 1000L);
            } else if (this.ele != null) {
                this.ele.bcp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.elf != null && this.elf.NQ != null && this.elf.NQ.aCH() != null && this.ele != null) {
            this.ele.startPlay(this.elf.NQ.aCH().hls_url);
        }
    }

    public void stopPlay() {
        if (this.ele != null) {
            this.ele.bcp();
        }
        e.gx().removeCallbacks(this.elg);
    }

    public void hR(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yE);
        e.gx().removeCallbacks(this.elg);
        if (this.ele != null) {
            this.ele.onDestroy();
        }
    }

    public c bcn() {
        return this.elf;
    }
}
