package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dgH;
    private a dgI;
    private g dgJ;

    public b(g gVar) {
        super(gVar.asj());
        this.dgH = new com.baidu.tieba.frs.entelechy.a.a(gVar.asl());
        this.dgI = new a(gVar.ask());
        this.dgJ = gVar;
    }

    public g asq() {
        return this.dgJ;
    }

    public com.baidu.tieba.frs.entelechy.a.a asr() {
        return this.dgH;
    }

    public a ass() {
        return this.dgI;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dgH == null) {
            return false;
        }
        return this.dgH.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dgH == null) {
            return false;
        }
        return this.dgH.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dgH != null) {
            this.dgH.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dgH != null) {
            this.dgH.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dgH == null) {
            return null;
        }
        return this.dgH.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dgH == null ? "" : this.dgH.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dgH == null) {
            return 0;
        }
        return this.dgH.getCurrentPosition();
    }
}
