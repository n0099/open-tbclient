package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.t;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tieba.card.t> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.s {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: ajm */
    public T Po() {
        return (T) this.bfy;
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlayStarted() {
        if (this.bfy == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.t) this.bfy).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlaying() {
        if (this.bfy == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.t) this.bfy).isPlaying();
    }

    @Override // com.baidu.tieba.play.s
    public void startPlay() {
        if (this.bfy != 0) {
            ((com.baidu.tieba.card.t) this.bfy).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.s
    public void stopPlay() {
        if (this.bfy != 0) {
            ((com.baidu.tieba.card.t) this.bfy).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.s
    public View getVideoContainer() {
        if (this.bfy == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.t) this.bfy).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.s
    public String getPlayUrl() {
        if (this.bfy == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.t) this.bfy).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.s
    public int getCurrentPosition() {
        if (this.bfy == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.t) this.bfy).getCurrentPosition();
    }
}
