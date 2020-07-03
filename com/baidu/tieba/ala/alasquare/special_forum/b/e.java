package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class e {
    public a fvx;
    private int fvy = -1;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar, boolean z) {
        if (aVar == null) {
            this.fvy = -1;
            this.fvx = new b(this.mTbPageContext);
        } else if (z) {
            this.fvy = aVar.ftG;
            switch (aVar.ftG) {
                case 1:
                    this.fvx = new d(this.mTbPageContext);
                    break;
                case 2:
                    this.fvx = new f(this.mTbPageContext);
                    break;
                case 3:
                    this.fvx = new c(this.mTbPageContext);
                    break;
                default:
                    this.fvx = new b(this.mTbPageContext);
                    break;
            }
        }
        if (this.fvx.b(aVar)) {
            if (z) {
                this.fvx.init();
            }
            this.fvx.a(aVar);
            return;
        }
        this.fvy = -1;
        this.fvx = new b(this.mTbPageContext);
        if (z) {
            this.fvx.init();
        }
        this.fvx.a(aVar);
    }

    public boolean c(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return aVar == null || this.fvy != aVar.ftG;
    }

    public void pause() {
        if (this.fvx != null) {
            this.fvx.pause();
        }
    }

    public void resume() {
        if (this.fvx != null) {
            this.fvx.resume();
        }
    }

    public void jw(boolean z) {
        if (this.fvx != null) {
            this.fvx.jw(z);
        }
    }

    public void V(ViewGroup viewGroup) {
        if (this.fvx != null) {
            this.fvx.V(viewGroup);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.fvx != null) {
            this.fvx.onChangeSkinType(i);
        }
    }

    public void startPlay() {
        if (this.fvx != null) {
            this.fvx.startPlay();
        }
    }

    public void stopPlay() {
        if (this.fvx != null) {
            this.fvx.stopPlay();
        }
    }

    public void buM() {
        if (this.fvx != null) {
            this.fvx.buM();
        }
    }

    public void onDestroy() {
        if (this.fvx != null) {
            this.fvx.onDestroy();
        }
    }
}
