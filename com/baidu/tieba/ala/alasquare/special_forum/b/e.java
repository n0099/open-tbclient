package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a eXk;
    private int eXl = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.eXl = -1;
            this.eXk = new b(this.mTbPageContext);
        } else if (z) {
            this.eXl = aVar.eVt;
            switch (aVar.eVt) {
                case 1:
                    this.eXk = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.eXk = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.eXk = new c(this.mTbPageContext);
                    break;
                default:
                    this.eXk = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.eXk.b(aVar)) {
            if (z) {
                this.eXk.init();
            }
            this.eXk.a(aVar);
            return;
        }
        this.eXl = -1;
        this.eXk = new b(this.mTbPageContext);
        if (z) {
            this.eXk.init();
        }
        this.eXk.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.eXl != aVar.eVt;
    }

    public void pause() {
        if (this.eXk != null) {
            this.eXk.pause();
        }
    }

    public void resume() {
        if (this.eXk != null) {
            this.eXk.resume();
        }
    }

    public void iR(boolean z) {
        if (this.eXk != null) {
            this.eXk.iR(z);
        }
    }

    public void O(ViewGroup viewGroup) {
        if (this.eXk != null) {
            this.eXk.O(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXk != null) {
            this.eXk.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.eXk != null) {
            this.eXk.startPlay();
        }
    }

    public void stopPlay() {
        if (this.eXk != null) {
            this.eXk.stopPlay();
        }
    }

    public void bms() {
        if (this.eXk != null) {
            this.eXk.bms();
        }
    }

    public void onDestroy() {
        if (this.eXk != null) {
            this.eXk.onDestroy();
        }
    }
}
