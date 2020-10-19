package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class e {
    public a gbG;
    private int gbH = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gbH = -1;
            this.gbG = new b(this.mTbPageContext);
        } else if (z) {
            this.gbH = aVar.fZO;
            switch (aVar.fZO) {
                case 1:
                    this.gbG = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gbG = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gbG = new c(this.mTbPageContext);
                    break;
                default:
                    this.gbG = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gbG.b(aVar)) {
            if (z) {
                this.gbG.init();
            }
            this.gbG.a(aVar);
            return;
        }
        this.gbH = -1;
        this.gbG = new b(this.mTbPageContext);
        if (z) {
            this.gbG.init();
        }
        this.gbG.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gbH != aVar.fZO;
    }

    public void pause() {
        if (this.gbG != null) {
            this.gbG.pause();
        }
    }

    public void resume() {
        if (this.gbG != null) {
            this.gbG.resume();
        }
    }

    public void la(boolean z) {
        if (this.gbG != null) {
            this.gbG.la(z);
        }
    }

    public void aa(ViewGroup viewGroup) {
        if (this.gbG != null) {
            this.gbG.aa(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gbG != null) {
            this.gbG.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gbG != null) {
            this.gbG.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gbG != null) {
            this.gbG.stopPlay();
        }
    }

    public void bKW() {
        if (this.gbG != null) {
            this.gbG.bKW();
        }
    }

    public void onDestroy() {
        if (this.gbG != null) {
            this.gbG.onDestroy();
        }
    }
}
