package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dvT;
    private a dvU;
    private g dvV;

    public b(g gVar) {
        super(gVar.axx());
        this.dvT = new com.baidu.tieba.frs.entelechy.a.a(gVar.axz());
        this.dvU = new a(gVar.axy());
        this.dvV = gVar;
    }

    public g axF() {
        return this.dvV;
    }

    public com.baidu.tieba.frs.entelechy.a.a axG() {
        return this.dvT;
    }

    public a axH() {
        return this.dvU;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dvT == null) {
            return false;
        }
        return this.dvT.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dvT == null) {
            return false;
        }
        return this.dvT.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dvT != null) {
            this.dvT.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dvT != null) {
            this.dvT.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dvT == null) {
            return null;
        }
        return this.dvT.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dvT == null ? "" : this.dvT.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dvT == null) {
            return 0;
        }
        return this.dvT.getCurrentPosition();
    }
}
