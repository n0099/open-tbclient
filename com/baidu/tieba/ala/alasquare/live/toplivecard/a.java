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
/* loaded from: classes2.dex */
public class a {
    private TbPageContext<?> cRe;
    private b egM;
    private c egN;
    private final int egL = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener ym = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aZT();
        }
    };
    private Runnable egO = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cRe = null;
        this.cRe = tbPageContext;
        this.egM = new b(this.cRe);
        MessageManager.getInstance().registerListener(this.ym);
    }

    public View getView() {
        return this.egM.getView();
    }

    public void onChangeSkinType() {
        this.egM.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.Np != null) {
            this.egN = cVar;
            if (this.egM != null) {
                this.egM.a(this.egN);
                an anVar = new an("c12644");
                if (cVar.ege == 0) {
                    anVar.Z("obj_type", 1);
                } else if (cVar.ege == 1) {
                    anVar.Z("obj_type", 2);
                }
                anVar.cp("tid", cVar.Np.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void aZT() {
        if (!this.mIsBackground) {
            if (af.mC(1)) {
                e.gx().removeCallbacks(this.egO);
                e.gx().postDelayed(this.egO, 1000L);
            } else if (this.egM != null) {
                this.egM.aZW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.egN != null && this.egN.Np != null && this.egN.Np.aAq() != null && this.egM != null) {
            this.egM.startPlay(this.egN.Np.aAq().hls_url);
        }
    }

    public void stopPlay() {
        if (this.egM != null) {
            this.egM.aZW();
        }
        e.gx().removeCallbacks(this.egO);
    }

    public void hK(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ym);
        e.gx().removeCallbacks(this.egO);
        if (this.egM != null) {
            this.egM.onDestroy();
        }
    }

    public c aZU() {
        return this.egN;
    }
}
