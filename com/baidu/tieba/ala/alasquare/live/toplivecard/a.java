package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes6.dex */
public class a {
    private TbPageContext<?> ceu;
    private b dvA;
    private c dvB;
    private final int dvz = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener vG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aJa();
        }
    };
    private Runnable dvC = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.ceu = null;
        this.ceu = tbPageContext;
        this.dvA = new b(this.ceu);
        MessageManager.getInstance().registerListener(this.vG);
    }

    public View getView() {
        return this.dvA.getView();
    }

    public void onChangeSkinType() {
        this.dvA.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cqG != null) {
            this.dvB = cVar;
            if (this.dvA != null) {
                this.dvA.a(this.dvB);
                an anVar = new an("c12644");
                if (cVar.duS == 0) {
                    anVar.O("obj_type", 1);
                } else if (cVar.duS == 1) {
                    anVar.O("obj_type", 2);
                }
                anVar.bS("tid", cVar.cqG.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void aJa() {
        if (!this.mIsBackground) {
            if (ac.kn(1)) {
                e.fZ().removeCallbacks(this.dvC);
                e.fZ().postDelayed(this.dvC, 1000L);
            } else if (this.dvA != null) {
                this.dvA.aJd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.dvB != null && this.dvB.cqG != null && this.dvB.cqG.aiX() != null && this.dvA != null) {
            this.dvA.startPlay(this.dvB.cqG.aiX().hls_url);
        }
    }

    public void stopPlay() {
        if (this.dvA != null) {
            this.dvA.aJd();
        }
        e.fZ().removeCallbacks(this.dvC);
    }

    public void gA(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.vG);
        e.fZ().removeCallbacks(this.dvC);
        if (this.dvA != null) {
            this.dvA.onDestroy();
        }
    }

    public c aJb() {
        return this.dvB;
    }
}
