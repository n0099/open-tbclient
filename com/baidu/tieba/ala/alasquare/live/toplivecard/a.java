package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.ala.alasquare.live.b.c;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext<?> eCn;
    private b gdh;
    private c gdi;
    private final int gdg = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener TP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bMo();
        }
    };
    private Runnable gdj = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eCn = null;
        this.eCn = tbPageContext;
        this.gdh = new b(this.eCn);
        MessageManager.getInstance().registerListener(this.TP);
    }

    public View getView() {
        return this.gdh.getView();
    }

    public void onChangeSkinType() {
        this.gdh.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akq != null) {
            this.gdi = cVar;
            if (this.gdh != null) {
                this.gdh.a(this.gdi);
                aq aqVar = new aq("c12644");
                if (cVar.gcz == 0) {
                    aqVar.aj("obj_type", 1);
                } else if (cVar.gcz == 1) {
                    aqVar.aj("obj_type", 2);
                }
                aqVar.dR("tid", cVar.akq.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bMo() {
        if (!this.mIsBackground) {
            if (ai.rL(1)) {
                e.mY().removeCallbacks(this.gdj);
                e.mY().postDelayed(this.gdj, 1000L);
            } else if (this.gdh != null) {
                this.gdh.bMr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.gdi != null && this.gdi.akq != null && this.gdi.akq.bku() != null && this.gdh != null) {
            this.gdh.Gj(this.gdi.akq.bku().hls_url);
        }
    }

    public void stopPlay() {
        if (this.gdh != null) {
            this.gdh.bMr();
        }
        e.mY().removeCallbacks(this.gdj);
    }

    public void ls(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TP);
        e.mY().removeCallbacks(this.gdj);
        if (this.gdh != null) {
            this.gdh.onDestroy();
        }
    }

    public c bMp() {
        return this.gdi;
    }
}
