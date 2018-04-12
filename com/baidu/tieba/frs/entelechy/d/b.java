package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dfD;
    private a dfE;
    private g dfF;

    public b(g gVar) {
        super(gVar.ask());
        this.dfD = new com.baidu.tieba.frs.entelechy.a.a(gVar.asm());
        this.dfE = new a(gVar.asl());
        this.dfF = gVar;
    }

    public g asr() {
        return this.dfF;
    }

    public com.baidu.tieba.frs.entelechy.a.a ass() {
        return this.dfD;
    }

    public a ast() {
        return this.dfE;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dfD == null) {
            return false;
        }
        return this.dfD.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dfD == null) {
            return false;
        }
        return this.dfD.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dfD != null) {
            this.dfD.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dfD != null) {
            this.dfD.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dfD == null) {
            return null;
        }
        return this.dfD.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dfD == null ? "" : this.dfD.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dfD == null) {
            return 0;
        }
        return this.dfD.getCurrentPosition();
    }
}
