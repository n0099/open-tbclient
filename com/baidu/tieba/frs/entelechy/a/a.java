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
    /* renamed from: axk */
    public T alY() {
        return (T) this.dbg;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbg == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbg == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbg != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbg != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbg == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbg == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbg == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbg).getCurrentPosition();
    }
}
