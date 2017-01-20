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
    /* renamed from: akt */
    public T Sd() {
        return (T) this.bpr;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bpr == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bpr).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bpr == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bpr).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bpr != 0) {
            ((com.baidu.tieba.card.x) this.bpr).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bpr != 0) {
            ((com.baidu.tieba.card.x) this.bpr).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bpr == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bpr).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bpr == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bpr).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bpr == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.x) this.bpr).getCurrentPosition();
    }
}
