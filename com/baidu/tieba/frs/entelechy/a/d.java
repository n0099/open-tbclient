package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes9.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bHo */
    public T bvQ() {
        return (T) this.fPe;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fPe == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fPe == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fPe != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fPe != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fPe == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.fPe == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fPe == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fPe).getCurrentPosition();
    }
}
