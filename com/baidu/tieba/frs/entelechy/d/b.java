package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dCA;
    private a dCB;
    private g dCC;

    public b(g gVar) {
        super(gVar.azK());
        this.dCA = new com.baidu.tieba.frs.entelechy.a.a(gVar.azM());
        this.dCB = new a(gVar.azL());
        this.dCC = gVar;
    }

    public g azS() {
        return this.dCC;
    }

    public com.baidu.tieba.frs.entelechy.a.a azT() {
        return this.dCA;
    }

    public a azU() {
        return this.dCB;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dCA == null) {
            return false;
        }
        return this.dCA.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dCA == null) {
            return false;
        }
        return this.dCA.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dCA != null) {
            this.dCA.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dCA != null) {
            this.dCA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dCA == null) {
            return null;
        }
        return this.dCA.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dCA == null ? "" : this.dCA.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dCA == null) {
            return 0;
        }
        return this.dCA.getCurrentPosition();
    }
}
