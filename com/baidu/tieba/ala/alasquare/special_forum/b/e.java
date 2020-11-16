package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a gre;
    private int grf = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.grf = -1;
            this.gre = new b(this.mTbPageContext);
        } else if (z) {
            this.grf = aVar.gpn;
            switch (aVar.gpn) {
                case 1:
                    this.gre = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gre = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gre = new c(this.mTbPageContext);
                    break;
                default:
                    this.gre = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gre.b(aVar)) {
            if (z) {
                this.gre.init();
            }
            this.gre.a(aVar);
            return;
        }
        this.grf = -1;
        this.gre = new b(this.mTbPageContext);
        if (z) {
            this.gre.init();
        }
        this.gre.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.grf != aVar.gpn;
    }

    public void pause() {
        if (this.gre != null) {
            this.gre.pause();
        }
    }

    public void resume() {
        if (this.gre != null) {
            this.gre.resume();
        }
    }

    public void lC(boolean z) {
        if (this.gre != null) {
            this.gre.lC(z);
        }
    }

    public void Z(ViewGroup viewGroup) {
        if (this.gre != null) {
            this.gre.Z(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gre != null) {
            this.gre.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gre != null) {
            this.gre.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gre != null) {
            this.gre.stopPlay();
        }
    }

    public void bPr() {
        if (this.gre != null) {
            this.gre.bPr();
        }
    }

    public void onDestroy() {
        if (this.gre != null) {
            this.gre.onDestroy();
        }
    }
}
