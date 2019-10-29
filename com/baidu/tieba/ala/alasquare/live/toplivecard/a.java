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
    private TbPageContext<?> cfl;
    private b dwr;
    private c dws;
    private final int dwq = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener wh = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aJc();
        }
    };
    private Runnable dwt = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cfl = null;
        this.cfl = tbPageContext;
        this.dwr = new b(this.cfl);
        MessageManager.getInstance().registerListener(this.wh);
    }

    public View getView() {
        return this.dwr.getView();
    }

    public void onChangeSkinType() {
        this.dwr.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cry != null) {
            this.dws = cVar;
            if (this.dwr != null) {
                this.dwr.a(this.dws);
                an anVar = new an("c12644");
                if (cVar.dvJ == 0) {
                    anVar.O("obj_type", 1);
                } else if (cVar.dvJ == 1) {
                    anVar.O("obj_type", 2);
                }
                anVar.bS("tid", cVar.cry.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void aJc() {
        if (!this.mIsBackground) {
            if (ac.ko(1)) {
                e.fZ().removeCallbacks(this.dwt);
                e.fZ().postDelayed(this.dwt, 1000L);
            } else if (this.dwr != null) {
                this.dwr.aJf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.dws != null && this.dws.cry != null && this.dws.cry.aiZ() != null && this.dwr != null) {
            this.dwr.startPlay(this.dws.cry.aiZ().hls_url);
        }
    }

    public void stopPlay() {
        if (this.dwr != null) {
            this.dwr.aJf();
        }
        e.fZ().removeCallbacks(this.dwt);
    }

    public void gA(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.wh);
        e.fZ().removeCallbacks(this.dwt);
        if (this.dwr != null) {
            this.dwr.onDestroy();
        }
    }

    public c aJd() {
        return this.dws;
    }
}
