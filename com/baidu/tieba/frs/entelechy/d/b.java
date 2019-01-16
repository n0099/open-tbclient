package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dVE;
    private a dVF;
    private g dVG;

    public b(g gVar) {
        super(gVar.aFw());
        this.dVE = new com.baidu.tieba.frs.entelechy.a.a(gVar.aFy());
        this.dVF = new a(gVar.aFx());
        this.dVG = gVar;
    }

    public g aFE() {
        return this.dVG;
    }

    public com.baidu.tieba.frs.entelechy.a.a aFF() {
        return this.dVE;
    }

    public a aFG() {
        return this.dVF;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dVE == null) {
            return false;
        }
        return this.dVE.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dVE == null) {
            return false;
        }
        return this.dVE.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dVE != null) {
            this.dVE.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dVE != null) {
            this.dVE.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dVE == null) {
            return null;
        }
        return this.dVE.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dVE == null ? "" : this.dVE.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dVE == null) {
            return 0;
        }
        return this.dVE.getCurrentPosition();
    }
}
