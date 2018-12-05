package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dSh;
    private a dSi;
    private g dSj;

    public b(g gVar) {
        super(gVar.aEk());
        this.dSh = new com.baidu.tieba.frs.entelechy.a.a(gVar.aEm());
        this.dSi = new a(gVar.aEl());
        this.dSj = gVar;
    }

    public g aEs() {
        return this.dSj;
    }

    public com.baidu.tieba.frs.entelechy.a.a aEt() {
        return this.dSh;
    }

    public a aEu() {
        return this.dSi;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dSh == null) {
            return false;
        }
        return this.dSh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dSh == null) {
            return false;
        }
        return this.dSh.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dSh != null) {
            this.dSh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dSh != null) {
            this.dSh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dSh == null) {
            return null;
        }
        return this.dSh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dSh == null ? "" : this.dSh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dSh == null) {
            return 0;
        }
        return this.dSh.getCurrentPosition();
    }
}
