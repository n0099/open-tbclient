package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dLE;
    private a dLF;
    private g dLG;

    public b(g gVar) {
        super(gVar.aCy());
        this.dLE = new com.baidu.tieba.frs.entelechy.a.a(gVar.aCA());
        this.dLF = new a(gVar.aCz());
        this.dLG = gVar;
    }

    public g aCG() {
        return this.dLG;
    }

    public com.baidu.tieba.frs.entelechy.a.a aCH() {
        return this.dLE;
    }

    public a aCI() {
        return this.dLF;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dLE == null) {
            return false;
        }
        return this.dLE.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dLE == null) {
            return false;
        }
        return this.dLE.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dLE != null) {
            this.dLE.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dLE != null) {
            this.dLE.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dLE == null) {
            return null;
        }
        return this.dLE.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dLE == null ? "" : this.dLE.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dLE == null) {
            return 0;
        }
        return this.dLE.getCurrentPosition();
    }
}
