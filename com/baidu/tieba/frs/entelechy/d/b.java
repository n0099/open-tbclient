package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dpW;
    private a dpX;
    private g dpY;

    public b(g gVar) {
        super(gVar.awo());
        this.dpW = new com.baidu.tieba.frs.entelechy.a.a(gVar.awq());
        this.dpX = new a(gVar.awp());
        this.dpY = gVar;
    }

    public g aww() {
        return this.dpY;
    }

    public com.baidu.tieba.frs.entelechy.a.a awx() {
        return this.dpW;
    }

    public a awy() {
        return this.dpX;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dpW == null) {
            return false;
        }
        return this.dpW.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dpW == null) {
            return false;
        }
        return this.dpW.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dpW != null) {
            this.dpW.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dpW != null) {
            this.dpW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dpW == null) {
            return null;
        }
        return this.dpW.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dpW == null ? "" : this.dpW.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dpW == null) {
            return 0;
        }
        return this.dpW.getCurrentPosition();
    }
}
