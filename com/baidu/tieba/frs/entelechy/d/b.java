package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dVF;
    private a dVG;
    private g dVH;

    public b(g gVar) {
        super(gVar.aFw());
        this.dVF = new com.baidu.tieba.frs.entelechy.a.a(gVar.aFy());
        this.dVG = new a(gVar.aFx());
        this.dVH = gVar;
    }

    public g aFE() {
        return this.dVH;
    }

    public com.baidu.tieba.frs.entelechy.a.a aFF() {
        return this.dVF;
    }

    public a aFG() {
        return this.dVG;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dVF == null) {
            return false;
        }
        return this.dVF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dVF == null) {
            return false;
        }
        return this.dVF.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dVF != null) {
            this.dVF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dVF != null) {
            this.dVF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dVF == null) {
            return null;
        }
        return this.dVF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dVF == null ? "" : this.dVF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dVF == null) {
            return 0;
        }
        return this.dVF.getCurrentPosition();
    }
}
