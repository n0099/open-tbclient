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
    private TbPageContext<?> eIc;
    private b giX;
    private c giY;
    private final int giW = 1000;
    private boolean mIsBackground = false;
    private CustomMessageListener TP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bOO();
        }
    };
    private Runnable giZ = new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.startPlay();
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.eIc = null;
        this.eIc = tbPageContext;
        this.giX = new b(this.eIc);
        MessageManager.getInstance().registerListener(this.TP);
    }

    public View getView() {
        return this.giX.getView();
    }

    public void onChangeSkinType() {
        this.giX.onChangeSkinType();
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akq != null) {
            this.giY = cVar;
            if (this.giX != null) {
                this.giX.a(this.giY);
                aq aqVar = new aq("c12644");
                if (cVar.gip == 0) {
                    aqVar.al("obj_type", 1);
                } else if (cVar.gip == 1) {
                    aqVar.al("obj_type", 2);
                }
                aqVar.dR("tid", cVar.akq.getTid());
                TiebaStatic.log(aqVar);
            }
        }
    }

    public void bOO() {
        if (!this.mIsBackground) {
            if (ai.rV(1)) {
                e.mY().removeCallbacks(this.giZ);
                e.mY().postDelayed(this.giZ, 1000L);
            } else if (this.giX != null) {
                this.giX.bOR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay() {
        if (this.giY != null && this.giY.akq != null && this.giY.akq.bmU() != null && this.giX != null) {
            this.giX.Gx(this.giY.akq.bmU().hls_url);
        }
    }

    public void stopPlay() {
        if (this.giX != null) {
            this.giX.bOR();
        }
        e.mY().removeCallbacks(this.giZ);
    }

    public void lB(boolean z) {
        this.mIsBackground = z;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.TP);
        e.mY().removeCallbacks(this.giZ);
        if (this.giX != null) {
            this.giX.onDestroy();
        }
    }

    public c bOP() {
        return this.giY;
    }
}
