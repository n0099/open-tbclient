package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes16.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cpF */
    public T ccE() {
        return (T) this.hoj;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.hoj == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.hoj == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.hoj != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.hoj != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hoj == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.hoj == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hoj == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hoj).getCurrentPosition();
    }
}
