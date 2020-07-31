package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a fAE;
    private int fAF = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fAF = -1;
            this.fAE = new b(this.mTbPageContext);
        } else if (z) {
            this.fAF = aVar.fyN;
            switch (aVar.fyN) {
                case 1:
                    this.fAE = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fAE = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fAE = new c(this.mTbPageContext);
                    break;
                default:
                    this.fAE = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fAE.b(aVar)) {
            if (z) {
                this.fAE.init();
            }
            this.fAE.a(aVar);
            return;
        }
        this.fAF = -1;
        this.fAE = new b(this.mTbPageContext);
        if (z) {
            this.fAE.init();
        }
        this.fAE.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fAF != aVar.fyN;
    }

    public void pause() {
        if (this.fAE != null) {
            this.fAE.pause();
        }
    }

    public void resume() {
        if (this.fAE != null) {
            this.fAE.resume();
        }
    }

    public void ka(boolean z) {
        if (this.fAE != null) {
            this.fAE.ka(z);
        }
    }

    public void W(ViewGroup viewGroup) {
        if (this.fAE != null) {
            this.fAE.W(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fAE != null) {
            this.fAE.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fAE != null) {
            this.fAE.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fAE != null) {
            this.fAE.stopPlay();
        }
    }

    public void bxW() {
        if (this.fAE != null) {
            this.fAE.bxW();
        }
    }

    public void onDestroy() {
        if (this.fAE != null) {
            this.fAE.onDestroy();
        }
    }
}
