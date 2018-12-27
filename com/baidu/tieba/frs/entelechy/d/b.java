package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dUY;
    private a dUZ;
    private g dVa;

    public b(g gVar) {
        super(gVar.aEZ());
        this.dUY = new com.baidu.tieba.frs.entelechy.a.a(gVar.aFb());
        this.dUZ = new a(gVar.aFa());
        this.dVa = gVar;
    }

    public g aFh() {
        return this.dVa;
    }

    public com.baidu.tieba.frs.entelechy.a.a aFi() {
        return this.dUY;
    }

    public a aFj() {
        return this.dUZ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dUY == null) {
            return false;
        }
        return this.dUY.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dUY == null) {
            return false;
        }
        return this.dUY.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dUY != null) {
            this.dUY.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dUY != null) {
            this.dUY.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dUY == null) {
            return null;
        }
        return this.dUY.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dUY == null ? "" : this.dUY.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dUY == null) {
            return 0;
        }
        return this.dUY.getCurrentPosition();
    }
}
