package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class e {
    public a gIK;
    private int gIL = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gIL = -1;
            this.gIK = new b(this.mTbPageContext);
        } else if (z) {
            this.gIL = aVar.gGT;
            switch (aVar.gGT) {
                case 1:
                    this.gIK = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gIK = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gIK = new c(this.mTbPageContext);
                    break;
                default:
                    this.gIK = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gIK.b(aVar)) {
            if (z) {
                this.gIK.init();
            }
            this.gIK.a(aVar);
            return;
        }
        this.gIL = -1;
        this.gIK = new b(this.mTbPageContext);
        if (z) {
            this.gIK.init();
        }
        this.gIK.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gIL != aVar.gGT;
    }

    public void pause() {
        if (this.gIK != null) {
            this.gIK.pause();
        }
    }

    public void resume() {
        if (this.gIK != null) {
            this.gIK.resume();
        }
    }

    public void mu(boolean z) {
        if (this.gIK != null) {
            this.gIK.mu(z);
        }
    }

    public void aj(ViewGroup viewGroup) {
        if (this.gIK != null) {
            this.gIK.aj(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIK != null) {
            this.gIK.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gIK != null) {
            this.gIK.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gIK != null) {
            this.gIK.stopPlay();
        }
    }

    public void bSA() {
        if (this.gIK != null) {
            this.gIK.bSA();
        }
    }

    public void onDestroy() {
        if (this.gIK != null) {
            this.gIK.onDestroy();
        }
    }
}
