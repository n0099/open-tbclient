package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: aaz */
    public T TU() {
        return (T) this.byx;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.byx == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byx).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.byx == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byx).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.byx != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.byx).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.byx != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.byx).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.byx == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byx).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.byx == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byx).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.byx == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byx).getCurrentPosition();
    }
}
