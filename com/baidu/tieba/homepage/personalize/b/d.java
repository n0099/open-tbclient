package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: apn */
    public T Xy() {
        return (T) this.bLp;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bLp == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bLp).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bLp == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bLp).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bLp != 0) {
            ((com.baidu.tieba.card.j) this.bLp).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bLp != 0) {
            ((com.baidu.tieba.card.j) this.bLp).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bLp == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bLp).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bLp == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bLp).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bLp == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bLp).getCurrentPosition();
    }
}
