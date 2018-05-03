package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dfA;
    private a dfB;
    private g dfC;

    public b(g gVar) {
        super(gVar.ask());
        this.dfA = new com.baidu.tieba.frs.entelechy.a.a(gVar.asm());
        this.dfB = new a(gVar.asl());
        this.dfC = gVar;
    }

    public g asr() {
        return this.dfC;
    }

    public com.baidu.tieba.frs.entelechy.a.a ass() {
        return this.dfA;
    }

    public a ast() {
        return this.dfB;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dfA == null) {
            return false;
        }
        return this.dfA.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dfA == null) {
            return false;
        }
        return this.dfA.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dfA != null) {
            this.dfA.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dfA != null) {
            this.dfA.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dfA == null) {
            return null;
        }
        return this.dfA.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dfA == null ? "" : this.dfA.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dfA == null) {
            return 0;
        }
        return this.dfA.getCurrentPosition();
    }
}
