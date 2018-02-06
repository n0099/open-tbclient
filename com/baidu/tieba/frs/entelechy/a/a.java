package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: axj */
    public T alY() {
        return (T) this.dbp;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbp == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbp == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbp != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbp != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbp == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbp == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbp == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbp).getCurrentPosition();
    }
}
