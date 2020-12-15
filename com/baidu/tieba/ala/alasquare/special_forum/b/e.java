package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class e {
    public a gzp;
    private int gzq = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gzq = -1;
            this.gzp = new b(this.mTbPageContext);
        } else if (z) {
            this.gzq = aVar.gxy;
            switch (aVar.gxy) {
                case 1:
                    this.gzp = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gzp = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gzp = new c(this.mTbPageContext);
                    break;
                default:
                    this.gzp = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gzp.b(aVar)) {
            if (z) {
                this.gzp.init();
            }
            this.gzp.a(aVar);
            return;
        }
        this.gzq = -1;
        this.gzp = new b(this.mTbPageContext);
        if (z) {
            this.gzp.init();
        }
        this.gzp.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gzq != aVar.gxy;
    }

    public void pause() {
        if (this.gzp != null) {
            this.gzp.pause();
        }
    }

    public void resume() {
        if (this.gzp != null) {
            this.gzp.resume();
        }
    }

    public void lX(boolean z) {
        if (this.gzp != null) {
            this.gzp.lX(z);
        }
    }

    public void Z(ViewGroup viewGroup) {
        if (this.gzp != null) {
            this.gzp.Z(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gzp != null) {
            this.gzp.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gzp != null) {
            this.gzp.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gzp != null) {
            this.gzp.stopPlay();
        }
    }

    public void bTd() {
        if (this.gzp != null) {
            this.gzp.bTd();
        }
    }

    public void onDestroy() {
        if (this.gzp != null) {
            this.gzp.onDestroy();
        }
    }
}
