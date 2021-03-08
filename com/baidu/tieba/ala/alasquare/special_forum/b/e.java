package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class e {
    public a gKt;
    private int gKu = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gKu = -1;
            this.gKt = new b(this.mTbPageContext);
        } else if (z) {
            this.gKu = aVar.gIC;
            switch (aVar.gIC) {
                case 1:
                    this.gKt = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gKt = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gKt = new c(this.mTbPageContext);
                    break;
                default:
                    this.gKt = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gKt.b(aVar)) {
            if (z) {
                this.gKt.init();
            }
            this.gKt.a(aVar);
            return;
        }
        this.gKu = -1;
        this.gKt = new b(this.mTbPageContext);
        if (z) {
            this.gKt.init();
        }
        this.gKt.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gKu != aVar.gIC;
    }

    public void pause() {
        if (this.gKt != null) {
            this.gKt.pause();
        }
    }

    public void resume() {
        if (this.gKt != null) {
            this.gKt.resume();
        }
    }

    public void mu(boolean z) {
        if (this.gKt != null) {
            this.gKt.mu(z);
        }
    }

    public void aj(ViewGroup viewGroup) {
        if (this.gKt != null) {
            this.gKt.aj(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gKt != null) {
            this.gKt.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gKt != null) {
            this.gKt.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gKt != null) {
            this.gKt.stopPlay();
        }
    }

    public void bSG() {
        if (this.gKt != null) {
            this.gKt.bSG();
        }
    }

    public void onDestroy() {
        if (this.gKt != null) {
            this.gKt.onDestroy();
        }
    }
}
