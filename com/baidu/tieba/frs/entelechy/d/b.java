package com.baidu.tieba.frs.entelechy.d;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.entelechy.view.g;
import com.baidu.tieba.play.f;
/* loaded from: classes3.dex */
public class b extends q.a implements f {
    private com.baidu.tieba.frs.entelechy.a.a dtf;
    private a dtg;
    private g dth;

    public b(g gVar) {
        super(gVar.awS());
        this.dtf = new com.baidu.tieba.frs.entelechy.a.a(gVar.awU());
        this.dtg = new a(gVar.awT());
        this.dth = gVar;
    }

    public g axa() {
        return this.dth;
    }

    public com.baidu.tieba.frs.entelechy.a.a axb() {
        return this.dtf;
    }

    public a axc() {
        return this.dtg;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dtf == null) {
            return false;
        }
        return this.dtf.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dtf == null) {
            return false;
        }
        return this.dtf.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dtf != null) {
            this.dtf.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dtf != null) {
            this.dtf.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dtf == null) {
            return null;
        }
        return this.dtf.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.dtf == null ? "" : this.dtf.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dtf == null) {
            return 0;
        }
        return this.dtf.getCurrentPosition();
    }
}
