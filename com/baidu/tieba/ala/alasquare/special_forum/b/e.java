package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a fjZ;
    private int fka = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fka = -1;
            this.fjZ = new b(this.mTbPageContext);
        } else if (z) {
            this.fka = aVar.fih;
            switch (aVar.fih) {
                case 1:
                    this.fjZ = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fjZ = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fjZ = new c(this.mTbPageContext);
                    break;
                default:
                    this.fjZ = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fjZ.b(aVar)) {
            if (z) {
                this.fjZ.init();
            }
            this.fjZ.a(aVar);
            return;
        }
        this.fka = -1;
        this.fjZ = new b(this.mTbPageContext);
        if (z) {
            this.fjZ.init();
        }
        this.fjZ.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fka != aVar.fih;
    }

    public void pause() {
        if (this.fjZ != null) {
            this.fjZ.pause();
        }
    }

    public void resume() {
        if (this.fjZ != null) {
            this.fjZ.resume();
        }
    }

    public void jj(boolean z) {
        if (this.fjZ != null) {
            this.fjZ.jj(z);
        }
    }

    public void T(ViewGroup viewGroup) {
        if (this.fjZ != null) {
            this.fjZ.T(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fjZ != null) {
            this.fjZ.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fjZ != null) {
            this.fjZ.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fjZ != null) {
            this.fjZ.stopPlay();
        }
    }

    public void brO() {
        if (this.fjZ != null) {
            this.fjZ.brO();
        }
    }

    public void onDestroy() {
        if (this.fjZ != null) {
            this.fjZ.onDestroy();
        }
    }
}
