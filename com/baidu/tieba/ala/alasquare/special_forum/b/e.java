package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a etf;
    private int etg = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.etg = -1;
            this.etf = new b(this.mTbPageContext);
        } else if (z) {
            this.etg = aVar.erm;
            switch (aVar.erm) {
                case 1:
                    this.etf = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.etf = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.etf = new c(this.mTbPageContext);
                    break;
                default:
                    this.etf = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.etf.b(aVar)) {
            if (z) {
                this.etf.init();
            }
            this.etf.a(aVar);
            return;
        }
        this.etg = -1;
        this.etf = new b(this.mTbPageContext);
        if (z) {
            this.etf.init();
        }
        this.etf.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.etg != aVar.erm;
    }

    public void pause() {
        if (this.etf != null) {
            this.etf.pause();
        }
    }

    public void resume() {
        if (this.etf != null) {
            this.etf.resume();
        }
    }

    public void hR(boolean z) {
        if (this.etf != null) {
            this.etf.hR(z);
        }
    }

    public void N(ViewGroup viewGroup) {
        if (this.etf != null) {
            this.etf.N(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.etf != null) {
            this.etf.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.etf != null) {
            this.etf.startPlay();
        }
    }

    public void stopPlay() {
        if (this.etf != null) {
            this.etf.stopPlay();
        }
    }

    public void bdt() {
        if (this.etf != null) {
            this.etf.bdt();
        }
    }

    public void onDestroy() {
        if (this.etf != null) {
            this.etf.onDestroy();
        }
    }
}
