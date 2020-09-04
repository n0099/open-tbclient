package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a fMa;
    private int fMb = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fMb = -1;
            this.fMa = new b(this.mTbPageContext);
        } else if (z) {
            this.fMb = aVar.fKj;
            switch (aVar.fKj) {
                case 1:
                    this.fMa = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fMa = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fMa = new c(this.mTbPageContext);
                    break;
                default:
                    this.fMa = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fMa.b(aVar)) {
            if (z) {
                this.fMa.init();
            }
            this.fMa.a(aVar);
            return;
        }
        this.fMb = -1;
        this.fMa = new b(this.mTbPageContext);
        if (z) {
            this.fMa.init();
        }
        this.fMa.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fMb != aVar.fKj;
    }

    public void pause() {
        if (this.fMa != null) {
            this.fMa.pause();
        }
    }

    public void resume() {
        if (this.fMa != null) {
            this.fMa.resume();
        }
    }

    public void kA(boolean z) {
        if (this.fMa != null) {
            this.fMa.kA(z);
        }
    }

    public void X(ViewGroup viewGroup) {
        if (this.fMa != null) {
            this.fMa.X(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fMa != null) {
            this.fMa.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fMa != null) {
            this.fMa.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fMa != null) {
            this.fMa.stopPlay();
        }
    }

    public void bGW() {
        if (this.fMa != null) {
            this.fMa.bGW();
        }
    }

    public void onDestroy() {
        if (this.fMa != null) {
            this.fMa.onDestroy();
        }
    }
}
