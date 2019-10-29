package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class e {
    public a dDx;
    private int dDy = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.dDy = -1;
            this.dDx = new b(this.mTbPageContext);
        } else if (z) {
            this.dDy = aVar.dBV;
            switch (aVar.dBV) {
                case 1:
                    this.dDx = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.dDx = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.dDx = new c(this.mTbPageContext);
                    break;
                default:
                    this.dDx = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.dDx.b(aVar)) {
            if (z) {
                this.dDx.init();
            }
            this.dDx.a(aVar);
            return;
        }
        this.dDy = -1;
        this.dDx = new b(this.mTbPageContext);
        if (z) {
            this.dDx.init();
        }
        this.dDx.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.dDy != aVar.dBV;
    }

    public void pause() {
        if (this.dDx != null) {
            this.dDx.pause();
        }
    }

    public void resume() {
        if (this.dDx != null) {
            this.dDx.resume();
        }
    }

    public void gA(boolean z) {
        if (this.dDx != null) {
            this.dDx.gA(z);
        }
    }

    public void J(ViewGroup viewGroup) {
        if (this.dDx != null) {
            this.dDx.J(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dDx != null) {
            this.dDx.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.dDx != null) {
            this.dDx.startPlay();
        }
    }

    public void stopPlay() {
        if (this.dDx != null) {
            this.dDx.stopPlay();
        }
    }

    public void aKm() {
        if (this.dDx != null) {
            this.dDx.aKm();
        }
    }

    public void onDestroy() {
        if (this.dDx != null) {
            this.dDx.onDestroy();
        }
    }
}
