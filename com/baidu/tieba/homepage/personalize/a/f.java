package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.l;
/* loaded from: classes9.dex */
public class f<T extends com.baidu.tieba.card.l> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cgo */
    public T bLW() {
        return (T) this.gIN;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gIN == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gIN).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gIN == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gIN).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gIN != 0) {
            ((com.baidu.tieba.card.l) this.gIN).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gIN != 0) {
            ((com.baidu.tieba.card.l) this.gIN).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gIN == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gIN).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gIN == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gIN).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gIN == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.gIN).getCurrentPosition();
    }
}
