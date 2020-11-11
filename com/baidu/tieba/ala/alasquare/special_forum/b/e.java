package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a grx;
    private int gry = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gry = -1;
            this.grx = new b(this.mTbPageContext);
        } else if (z) {
            this.gry = aVar.gpG;
            switch (aVar.gpG) {
                case 1:
                    this.grx = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.grx = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.grx = new c(this.mTbPageContext);
                    break;
                default:
                    this.grx = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.grx.b(aVar)) {
            if (z) {
                this.grx.init();
            }
            this.grx.a(aVar);
            return;
        }
        this.gry = -1;
        this.grx = new b(this.mTbPageContext);
        if (z) {
            this.grx.init();
        }
        this.grx.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gry != aVar.gpG;
    }

    public void pause() {
        if (this.grx != null) {
            this.grx.pause();
        }
    }

    public void resume() {
        if (this.grx != null) {
            this.grx.resume();
        }
    }

    public void lB(boolean z) {
        if (this.grx != null) {
            this.grx.lB(z);
        }
    }

    public void ad(ViewGroup viewGroup) {
        if (this.grx != null) {
            this.grx.ad(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.grx != null) {
            this.grx.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.grx != null) {
            this.grx.startPlay();
        }
    }

    public void stopPlay() {
        if (this.grx != null) {
            this.grx.stopPlay();
        }
    }

    public void bPY() {
        if (this.grx != null) {
            this.grx.bPY();
        }
    }

    public void onDestroy() {
        if (this.grx != null) {
            this.grx.onDestroy();
        }
    }
}
