package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a fLW;
    private int fLX = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fLX = -1;
            this.fLW = new b(this.mTbPageContext);
        } else if (z) {
            this.fLX = aVar.fKf;
            switch (aVar.fKf) {
                case 1:
                    this.fLW = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fLW = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fLW = new c(this.mTbPageContext);
                    break;
                default:
                    this.fLW = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fLW.b(aVar)) {
            if (z) {
                this.fLW.init();
            }
            this.fLW.a(aVar);
            return;
        }
        this.fLX = -1;
        this.fLW = new b(this.mTbPageContext);
        if (z) {
            this.fLW.init();
        }
        this.fLW.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fLX != aVar.fKf;
    }

    public void pause() {
        if (this.fLW != null) {
            this.fLW.pause();
        }
    }

    public void resume() {
        if (this.fLW != null) {
            this.fLW.resume();
        }
    }

    public void ky(boolean z) {
        if (this.fLW != null) {
            this.fLW.ky(z);
        }
    }

    public void X(ViewGroup viewGroup) {
        if (this.fLW != null) {
            this.fLW.X(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fLW != null) {
            this.fLW.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fLW != null) {
            this.fLW.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fLW != null) {
            this.fLW.stopPlay();
        }
    }

    public void bGV() {
        if (this.fLW != null) {
            this.fLW.bGV();
        }
    }

    public void onDestroy() {
        if (this.fLW != null) {
            this.fLW.onDestroy();
        }
    }
}
