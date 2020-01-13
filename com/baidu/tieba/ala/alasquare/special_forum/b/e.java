package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class e {
    public a eoU;
    private int eoV = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.eoV = -1;
            this.eoU = new b(this.mTbPageContext);
        } else if (z) {
            this.eoV = aVar.emZ;
            switch (aVar.emZ) {
                case 1:
                    this.eoU = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.eoU = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.eoU = new c(this.mTbPageContext);
                    break;
                default:
                    this.eoU = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.eoU.b(aVar)) {
            if (z) {
                this.eoU.init();
            }
            this.eoU.a(aVar);
            return;
        }
        this.eoV = -1;
        this.eoU = new b(this.mTbPageContext);
        if (z) {
            this.eoU.init();
        }
        this.eoU.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.eoV != aVar.emZ;
    }

    public void pause() {
        if (this.eoU != null) {
            this.eoU.pause();
        }
    }

    public void resume() {
        if (this.eoU != null) {
            this.eoU.resume();
        }
    }

    public void hK(boolean z) {
        if (this.eoU != null) {
            this.eoU.hK(z);
        }
    }

    public void M(ViewGroup viewGroup) {
        if (this.eoU != null) {
            this.eoU.M(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eoU != null) {
            this.eoU.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.eoU != null) {
            this.eoU.startPlay();
        }
    }

    public void stopPlay() {
        if (this.eoU != null) {
            this.eoU.stopPlay();
        }
    }

    public void bbe() {
        if (this.eoU != null) {
            this.eoU.bbe();
        }
    }

    public void onDestroy() {
        if (this.eoU != null) {
            this.eoU.onDestroy();
        }
    }
}
