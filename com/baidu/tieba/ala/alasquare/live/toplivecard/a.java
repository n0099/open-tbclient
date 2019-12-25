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
    private TbPageContext<?> cQU;
    private b egC;
    private c egD;
    private final int egB = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener yi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.aZy();
        }
    };
    private Runnable egE = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.cQU = null;
        this.cQU = tbPageContext;
        this.egC = new b(this.cQU);
        MessageManager.getInstance().registerListener(this.yi);
    }

    public View getView() {
        return this.egC.getView();
    }

    public void onChangeSkinType() {
        this.egC.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.Nl != null) {
            this.egD = cVar;
            if (this.egC != null) {
                this.egC.a(this.egD);
                an anVar = new an("c12644");
                if (cVar.efU == 0) {
                    anVar.Z("obj_type", 1);
                } else if (cVar.efU == 1) {
                    anVar.Z("obj_type", 2);
                }
                anVar.cp("tid", cVar.Nl.getTid());
                TiebaStatic.log(anVar);
            }
        }
    }

    public void aZy() {
        if (!this.mIsBackground) {
            if (af.mC(1)) {
                e.gy().removeCallbacks(this.egE);
                e.gy().postDelayed(this.egE, 1000L);
            } else if (this.egC != null) {
                this.egC.aZB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.egD != null && this.egD.Nl != null && this.egD.Nl.azX() != null && this.egC != null) {
            this.egC.startPlay(this.egD.Nl.azX().hls_url);
        }
    }

    public void stopPlay() {
        if (this.egC != null) {
            this.egC.aZB();
        }
        e.gy().removeCallbacks(this.egE);
    }

    public void hF(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.yi);
        e.gy().removeCallbacks(this.egE);
        if (this.egC != null) {
            this.egC.onDestroy();
        }
    }

    public c aZz() {
        return this.egD;
    }
}
