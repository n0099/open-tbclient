package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a ett;
    private int etu = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.etu = -1;
            this.ett = new b(this.mTbPageContext);
        } else if (z) {
            this.etu = aVar.erB;
            switch (aVar.erB) {
                case 1:
                    this.ett = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.ett = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.ett = new c(this.mTbPageContext);
                    break;
                default:
                    this.ett = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.ett.b(aVar)) {
            if (z) {
                this.ett.init();
            }
            this.ett.a(aVar);
            return;
        }
        this.etu = -1;
        this.ett = new b(this.mTbPageContext);
        if (z) {
            this.ett.init();
        }
        this.ett.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.etu != aVar.erB;
    }

    public void pause() {
        if (this.ett != null) {
            this.ett.pause();
        }
    }

    public void resume() {
        if (this.ett != null) {
            this.ett.resume();
        }
    }

    public void hR(boolean z) {
        if (this.ett != null) {
            this.ett.hR(z);
        }
    }

    public void N(ViewGroup viewGroup) {
        if (this.ett != null) {
            this.ett.N(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ett != null) {
            this.ett.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.ett != null) {
            this.ett.startPlay();
        }
    }

    public void stopPlay() {
        if (this.ett != null) {
            this.ett.stopPlay();
        }
    }

    public void bdw() {
        if (this.ett != null) {
            this.ett.bdw();
        }
    }

    public void onDestroy() {
        if (this.ett != null) {
            this.ett.onDestroy();
        }
    }
}
