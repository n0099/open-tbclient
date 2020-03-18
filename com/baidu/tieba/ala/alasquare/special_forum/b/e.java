package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a etP;
    private int etQ = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.etQ = -1;
            this.etP = new b(this.mTbPageContext);
        } else if (z) {
            this.etQ = aVar.erX;
            switch (aVar.erX) {
                case 1:
                    this.etP = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.etP = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.etP = new c(this.mTbPageContext);
                    break;
                default:
                    this.etP = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.etP.b(aVar)) {
            if (z) {
                this.etP.init();
            }
            this.etP.a(aVar);
            return;
        }
        this.etQ = -1;
        this.etP = new b(this.mTbPageContext);
        if (z) {
            this.etP.init();
        }
        this.etP.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.etQ != aVar.erX;
    }

    public void pause() {
        if (this.etP != null) {
            this.etP.pause();
        }
    }

    public void resume() {
        if (this.etP != null) {
            this.etP.resume();
        }
    }

    public void hS(boolean z) {
        if (this.etP != null) {
            this.etP.hS(z);
        }
    }

    public void N(ViewGroup viewGroup) {
        if (this.etP != null) {
            this.etP.N(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.etP != null) {
            this.etP.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.etP != null) {
            this.etP.startPlay();
        }
    }

    public void stopPlay() {
        if (this.etP != null) {
            this.etP.stopPlay();
        }
    }

    public void bdB() {
        if (this.etP != null) {
            this.etP.bdB();
        }
    }

    public void onDestroy() {
        if (this.etP != null) {
            this.etP.onDestroy();
        }
    }
}
