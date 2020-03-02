package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a etg;
    private int eth = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.eth = -1;
            this.etg = new b(this.mTbPageContext);
        } else if (z) {
            this.eth = aVar.ern;
            switch (aVar.ern) {
                case 1:
                    this.etg = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.etg = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.etg = new c(this.mTbPageContext);
                    break;
                default:
                    this.etg = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.etg.b(aVar)) {
            if (z) {
                this.etg.init();
            }
            this.etg.a(aVar);
            return;
        }
        this.eth = -1;
        this.etg = new b(this.mTbPageContext);
        if (z) {
            this.etg.init();
        }
        this.etg.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.eth != aVar.ern;
    }

    public void pause() {
        if (this.etg != null) {
            this.etg.pause();
        }
    }

    public void resume() {
        if (this.etg != null) {
            this.etg.resume();
        }
    }

    public void hR(boolean z) {
        if (this.etg != null) {
            this.etg.hR(z);
        }
    }

    public void N(ViewGroup viewGroup) {
        if (this.etg != null) {
            this.etg.N(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.etg != null) {
            this.etg.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.etg != null) {
            this.etg.startPlay();
        }
    }

    public void stopPlay() {
        if (this.etg != null) {
            this.etg.stopPlay();
        }
    }

    public void bdv() {
        if (this.etg != null) {
            this.etg.bdv();
        }
    }

    public void onDestroy() {
        if (this.etg != null) {
            this.etg.onDestroy();
        }
    }
}
