package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes22.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: czx */
    public T cmx() {
        return (T) this.hWJ;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.hWJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.hWJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.hWJ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.hWJ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hWJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.hWJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hWJ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.hWJ).getCurrentPosition();
    }
}
