package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f<T extends com.baidu.tieba.card.x> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public f(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: akA */
    public T UB() {
        return (T) this.byw;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.byw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.byw).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.byw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.byw).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.byw != 0) {
            ((com.baidu.tieba.card.x) this.byw).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.byw != 0) {
            ((com.baidu.tieba.card.x) this.byw).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.byw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.byw).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.byw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.byw).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.byw == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.x) this.byw).getCurrentPosition();
    }
}
