package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a fkk;
    private int fkl = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fkl = -1;
            this.fkk = new b(this.mTbPageContext);
        } else if (z) {
            this.fkl = aVar.fis;
            switch (aVar.fis) {
                case 1:
                    this.fkk = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fkk = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fkk = new c(this.mTbPageContext);
                    break;
                default:
                    this.fkk = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fkk.b(aVar)) {
            if (z) {
                this.fkk.init();
            }
            this.fkk.a(aVar);
            return;
        }
        this.fkl = -1;
        this.fkk = new b(this.mTbPageContext);
        if (z) {
            this.fkk.init();
        }
        this.fkk.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fkl != aVar.fis;
    }

    public void pause() {
        if (this.fkk != null) {
            this.fkk.pause();
        }
    }

    public void resume() {
        if (this.fkk != null) {
            this.fkk.resume();
        }
    }

    public void jj(boolean z) {
        if (this.fkk != null) {
            this.fkk.jj(z);
        }
    }

    public void T(ViewGroup viewGroup) {
        if (this.fkk != null) {
            this.fkk.T(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fkk != null) {
            this.fkk.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fkk != null) {
            this.fkk.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fkk != null) {
            this.fkk.stopPlay();
        }
    }

    public void brQ() {
        if (this.fkk != null) {
            this.fkk.brQ();
        }
    }

    public void onDestroy() {
        if (this.fkk != null) {
            this.fkk.onDestroy();
        }
    }
}
