package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class e {
    public a gFM;
    private int gFN = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gFN = -1;
            this.gFM = new b(this.mTbPageContext);
        } else if (z) {
            this.gFN = aVar.gDV;
            switch (aVar.gDV) {
                case 1:
                    this.gFM = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gFM = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gFM = new c(this.mTbPageContext);
                    break;
                default:
                    this.gFM = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gFM.b(aVar)) {
            if (z) {
                this.gFM.init();
            }
            this.gFM.a(aVar);
            return;
        }
        this.gFN = -1;
        this.gFM = new b(this.mTbPageContext);
        if (z) {
            this.gFM.init();
        }
        this.gFM.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gFN != aVar.gDV;
    }

    public void pause() {
        if (this.gFM != null) {
            this.gFM.pause();
        }
    }

    public void resume() {
        if (this.gFM != null) {
            this.gFM.resume();
        }
    }

    public void mq(boolean z) {
        if (this.gFM != null) {
            this.gFM.mq(z);
        }
    }

    public void al(ViewGroup viewGroup) {
        if (this.gFM != null) {
            this.gFM.al(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gFM != null) {
            this.gFM.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gFM != null) {
            this.gFM.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gFM != null) {
            this.gFM.stopPlay();
        }
    }

    public void bRQ() {
        if (this.gFM != null) {
            this.gFM.bRQ();
        }
    }

    public void onDestroy() {
        if (this.gFM != null) {
            this.gFM.onDestroy();
        }
    }
}
