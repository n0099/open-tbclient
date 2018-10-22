package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dKA;
    private a dKB;
    private g dKC;

    public b(g gVar) {
        super(gVar.aDe());
        this.dKA = new com.baidu.tieba.frs.entelechy.a.a(gVar.aDg());
        this.dKB = new a(gVar.aDf());
        this.dKC = gVar;
    }

    public g aDm() {
        return this.dKC;
    }

    public com.baidu.tieba.frs.entelechy.a.a aDn() {
        return this.dKA;
    }

    public a aDo() {
        return this.dKB;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dKA == null) {
            return false;
        }
        return this.dKA.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dKA == null) {
            return false;
        }
        return this.dKA.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dKA != null) {
            this.dKA.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dKA != null) {
            this.dKA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dKA == null) {
            return null;
        }
        return this.dKA.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dKA == null ? "" : this.dKA.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dKA == null) {
            return 0;
        }
        return this.dKA.getCurrentPosition();
    }
}
