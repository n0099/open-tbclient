package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a glK;
    private int glL = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.glL = -1;
            this.glK = new b(this.mTbPageContext);
        } else if (z) {
            this.glL = aVar.gjT;
            switch (aVar.gjT) {
                case 1:
                    this.glK = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.glK = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.glK = new c(this.mTbPageContext);
                    break;
                default:
                    this.glK = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.glK.b(aVar)) {
            if (z) {
                this.glK.init();
            }
            this.glK.a(aVar);
            return;
        }
        this.glL = -1;
        this.glK = new b(this.mTbPageContext);
        if (z) {
            this.glK.init();
        }
        this.glK.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.glL != aVar.gjT;
    }

    public void pause() {
        if (this.glK != null) {
            this.glK.pause();
        }
    }

    public void resume() {
        if (this.glK != null) {
            this.glK.resume();
        }
    }

    public void ls(boolean z) {
        if (this.glK != null) {
            this.glK.ls(z);
        }
    }

    public void ab(ViewGroup viewGroup) {
        if (this.glK != null) {
            this.glK.ab(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.glK != null) {
            this.glK.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.glK != null) {
            this.glK.startPlay();
        }
    }

    public void stopPlay() {
        if (this.glK != null) {
            this.glK.stopPlay();
        }
    }

    public void bNy() {
        if (this.glK != null) {
            this.glK.bNy();
        }
    }

    public void onDestroy() {
        if (this.glK != null) {
            this.glK.onDestroy();
        }
    }
}
