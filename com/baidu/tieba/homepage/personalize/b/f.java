package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class f<T extends com.baidu.tieba.card.u> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public f(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: ahM */
    public T TU() {
        return (T) this.byx;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.byx == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.u) this.byx).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.byx == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.u) this.byx).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.byx != 0) {
            ((com.baidu.tieba.card.u) this.byx).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.byx != 0) {
            ((com.baidu.tieba.card.u) this.byx).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.byx == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.u) this.byx).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.byx == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.u) this.byx).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.byx == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.u) this.byx).getCurrentPosition();
    }
}
