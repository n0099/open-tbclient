package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dvQ;
    private a dvR;
    private g dvS;

    public b(g gVar) {
        super(gVar.axw());
        this.dvQ = new com.baidu.tieba.frs.entelechy.a.a(gVar.axy());
        this.dvR = new a(gVar.axx());
        this.dvS = gVar;
    }

    public g axD() {
        return this.dvS;
    }

    public com.baidu.tieba.frs.entelechy.a.a axE() {
        return this.dvQ;
    }

    public a axF() {
        return this.dvR;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dvQ == null) {
            return false;
        }
        return this.dvQ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dvQ == null) {
            return false;
        }
        return this.dvQ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dvQ != null) {
            this.dvQ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dvQ != null) {
            this.dvQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dvQ == null) {
            return null;
        }
        return this.dvQ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dvQ == null ? "" : this.dvQ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dvQ == null) {
            return 0;
        }
        return this.dvQ.getCurrentPosition();
    }
}
