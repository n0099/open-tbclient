package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class e {
    public a gzn;
    private int gzo = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gzo = -1;
            this.gzn = new b(this.mTbPageContext);
        } else if (z) {
            this.gzo = aVar.gxw;
            switch (aVar.gxw) {
                case 1:
                    this.gzn = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gzn = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gzn = new c(this.mTbPageContext);
                    break;
                default:
                    this.gzn = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gzn.b(aVar)) {
            if (z) {
                this.gzn.init();
            }
            this.gzn.a(aVar);
            return;
        }
        this.gzo = -1;
        this.gzn = new b(this.mTbPageContext);
        if (z) {
            this.gzn.init();
        }
        this.gzn.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gzo != aVar.gxw;
    }

    public void pause() {
        if (this.gzn != null) {
            this.gzn.pause();
        }
    }

    public void resume() {
        if (this.gzn != null) {
            this.gzn.resume();
        }
    }

    public void lX(boolean z) {
        if (this.gzn != null) {
            this.gzn.lX(z);
        }
    }

    public void Z(ViewGroup viewGroup) {
        if (this.gzn != null) {
            this.gzn.Z(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gzn != null) {
            this.gzn.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gzn != null) {
            this.gzn.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gzn != null) {
            this.gzn.stopPlay();
        }
    }

    public void bTc() {
        if (this.gzn != null) {
            this.gzn.bTc();
        }
    }

    public void onDestroy() {
        if (this.gzn != null) {
            this.gzn.onDestroy();
        }
    }
}
