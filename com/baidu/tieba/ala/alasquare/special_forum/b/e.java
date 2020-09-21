package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a fPo;
    private int fPp = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fPp = -1;
            this.fPo = new b(this.mTbPageContext);
        } else if (z) {
            this.fPp = aVar.fNx;
            switch (aVar.fNx) {
                case 1:
                    this.fPo = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fPo = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fPo = new c(this.mTbPageContext);
                    break;
                default:
                    this.fPo = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fPo.b(aVar)) {
            if (z) {
                this.fPo.init();
            }
            this.fPo.a(aVar);
            return;
        }
        this.fPp = -1;
        this.fPo = new b(this.mTbPageContext);
        if (z) {
            this.fPo.init();
        }
        this.fPo.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fPp != aVar.fNx;
    }

    public void pause() {
        if (this.fPo != null) {
            this.fPo.pause();
        }
    }

    public void resume() {
        if (this.fPo != null) {
            this.fPo.resume();
        }
    }

    public void kC(boolean z) {
        if (this.fPo != null) {
            this.fPo.kC(z);
        }
    }

    public void Y(ViewGroup viewGroup) {
        if (this.fPo != null) {
            this.fPo.Y(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fPo != null) {
            this.fPo.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fPo != null) {
            this.fPo.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fPo != null) {
            this.fPo.stopPlay();
        }
    }

    public void bIm() {
        if (this.fPo != null) {
            this.fPo.bIm();
        }
    }

    public void onDestroy() {
        if (this.fPo != null) {
            this.fPo.onDestroy();
        }
    }
}
