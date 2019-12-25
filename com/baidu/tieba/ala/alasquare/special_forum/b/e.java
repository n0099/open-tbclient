package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class e {
    public a enG;
    private int enH = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.enH = -1;
            this.enG = new b(this.mTbPageContext);
        } else if (z) {
            this.enH = aVar.emc;
            switch (aVar.emc) {
                case 1:
                    this.enG = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.enG = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.enG = new c(this.mTbPageContext);
                    break;
                default:
                    this.enG = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.enG.b(aVar)) {
            if (z) {
                this.enG.init();
            }
            this.enG.a(aVar);
            return;
        }
        this.enH = -1;
        this.enG = new b(this.mTbPageContext);
        if (z) {
            this.enG.init();
        }
        this.enG.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.enH != aVar.emc;
    }

    public void pause() {
        if (this.enG != null) {
            this.enG.pause();
        }
    }

    public void resume() {
        if (this.enG != null) {
            this.enG.resume();
        }
    }

    public void hF(boolean z) {
        if (this.enG != null) {
            this.enG.hF(z);
        }
    }

    public void I(ViewGroup viewGroup) {
        if (this.enG != null) {
            this.enG.I(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.enG != null) {
            this.enG.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.enG != null) {
            this.enG.startPlay();
        }
    }

    public void stopPlay() {
        if (this.enG != null) {
            this.enG.stopPlay();
        }
    }

    public void baJ() {
        if (this.enG != null) {
            this.enG.baJ();
        }
    }

    public void onDestroy() {
        if (this.enG != null) {
            this.enG.onDestroy();
        }
    }
}
