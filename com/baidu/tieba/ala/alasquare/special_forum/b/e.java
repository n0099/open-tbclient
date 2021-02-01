package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class e {
    public a gIw;
    private int gIx = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gIx = -1;
            this.gIw = new b(this.mTbPageContext);
        } else if (z) {
            this.gIx = aVar.gGF;
            switch (aVar.gGF) {
                case 1:
                    this.gIw = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gIw = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gIw = new c(this.mTbPageContext);
                    break;
                default:
                    this.gIw = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gIw.b(aVar)) {
            if (z) {
                this.gIw.init();
            }
            this.gIw.a(aVar);
            return;
        }
        this.gIx = -1;
        this.gIw = new b(this.mTbPageContext);
        if (z) {
            this.gIw.init();
        }
        this.gIw.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gIx != aVar.gGF;
    }

    public void pause() {
        if (this.gIw != null) {
            this.gIw.pause();
        }
    }

    public void resume() {
        if (this.gIw != null) {
            this.gIw.resume();
        }
    }

    public void mu(boolean z) {
        if (this.gIw != null) {
            this.gIw.mu(z);
        }
    }

    public void aj(ViewGroup viewGroup) {
        if (this.gIw != null) {
            this.gIw.aj(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gIw != null) {
            this.gIw.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gIw != null) {
            this.gIw.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gIw != null) {
            this.gIw.stopPlay();
        }
    }

    public void bSt() {
        if (this.gIw != null) {
            this.gIw.bSt();
        }
    }

    public void onDestroy() {
        if (this.gIw != null) {
            this.gIw.onDestroy();
        }
    }
}
