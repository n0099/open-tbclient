package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes21.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: csT */
    public T cfU() {
        return (T) this.hvr;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.hvr == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.hvr == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.hvr != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.hvr != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hvr == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.hvr == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hvr == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hvr).getCurrentPosition();
    }
}
