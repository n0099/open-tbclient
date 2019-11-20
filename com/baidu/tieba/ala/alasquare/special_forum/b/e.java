package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class e {
    public a dCG;
    private int dCH = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.dCH = -1;
            this.dCG = new b(this.mTbPageContext);
        } else if (z) {
            this.dCH = aVar.dBe;
            switch (aVar.dBe) {
                case 1:
                    this.dCG = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.dCG = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.dCG = new c(this.mTbPageContext);
                    break;
                default:
                    this.dCG = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.dCG.b(aVar)) {
            if (z) {
                this.dCG.init();
            }
            this.dCG.a(aVar);
            return;
        }
        this.dCH = -1;
        this.dCG = new b(this.mTbPageContext);
        if (z) {
            this.dCG.init();
        }
        this.dCG.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.dCH != aVar.dBe;
    }

    public void pause() {
        if (this.dCG != null) {
            this.dCG.pause();
        }
    }

    public void resume() {
        if (this.dCG != null) {
            this.dCG.resume();
        }
    }

    public void gA(boolean z) {
        if (this.dCG != null) {
            this.dCG.gA(z);
        }
    }

    public void J(ViewGroup viewGroup) {
        if (this.dCG != null) {
            this.dCG.J(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dCG != null) {
            this.dCG.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.dCG != null) {
            this.dCG.startPlay();
        }
    }

    public void stopPlay() {
        if (this.dCG != null) {
            this.dCG.stopPlay();
        }
    }

    public void aKk() {
        if (this.dCG != null) {
            this.dCG.aKk();
        }
    }

    public void onDestroy() {
        if (this.dCG != null) {
            this.dCG.onDestroy();
        }
    }
}
