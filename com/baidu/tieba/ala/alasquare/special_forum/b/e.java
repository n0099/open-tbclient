package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class e {
    public a gKs;
    private int gKt = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.gKt = -1;
            this.gKs = new b(this.mTbPageContext);
        } else if (z) {
            this.gKt = aVar.gIB;
            switch (aVar.gIB) {
                case 1:
                    this.gKs = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.gKs = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.gKs = new c(this.mTbPageContext);
                    break;
                default:
                    this.gKs = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.gKs.b(aVar)) {
            if (z) {
                this.gKs.init();
            }
            this.gKs.a(aVar);
            return;
        }
        this.gKt = -1;
        this.gKs = new b(this.mTbPageContext);
        if (z) {
            this.gKs.init();
        }
        this.gKs.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.gKt != aVar.gIB;
    }

    public void pause() {
        if (this.gKs != null) {
            this.gKs.pause();
        }
    }

    public void resume() {
        if (this.gKs != null) {
            this.gKs.resume();
        }
    }

    public void mu(boolean z) {
        if (this.gKs != null) {
            this.gKs.mu(z);
        }
    }

    public void al(ViewGroup viewGroup) {
        if (this.gKs != null) {
            this.gKs.al(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.gKs != null) {
            this.gKs.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.gKs != null) {
            this.gKs.startPlay();
        }
    }

    public void stopPlay() {
        if (this.gKs != null) {
            this.gKs.stopPlay();
        }
    }

    public void bVI() {
        if (this.gKs != null) {
            this.gKs.bVI();
        }
    }

    public void onDestroy() {
        if (this.gKs != null) {
            this.gKs.onDestroy();
        }
    }
}
