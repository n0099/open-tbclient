package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a eXp;
    private int eXq = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.eXq = -1;
            this.eXp = new b(this.mTbPageContext);
        } else if (z) {
            this.eXq = aVar.eVy;
            switch (aVar.eVy) {
                case 1:
                    this.eXp = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.eXp = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.eXp = new c(this.mTbPageContext);
                    break;
                default:
                    this.eXp = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.eXp.b(aVar)) {
            if (z) {
                this.eXp.init();
            }
            this.eXp.a(aVar);
            return;
        }
        this.eXq = -1;
        this.eXp = new b(this.mTbPageContext);
        if (z) {
            this.eXp.init();
        }
        this.eXp.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.eXq != aVar.eVy;
    }

    public void pause() {
        if (this.eXp != null) {
            this.eXp.pause();
        }
    }

    public void resume() {
        if (this.eXp != null) {
            this.eXp.resume();
        }
    }

    public void iR(boolean z) {
        if (this.eXp != null) {
            this.eXp.iR(z);
        }
    }

    public void O(ViewGroup viewGroup) {
        if (this.eXp != null) {
            this.eXp.O(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eXp != null) {
            this.eXp.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.eXp != null) {
            this.eXp.startPlay();
        }
    }

    public void stopPlay() {
        if (this.eXp != null) {
            this.eXp.stopPlay();
        }
    }

    public void bmq() {
        if (this.eXp != null) {
            this.eXp.bmq();
        }
    }

    public void onDestroy() {
        if (this.eXp != null) {
            this.eXp.onDestroy();
        }
    }
}
