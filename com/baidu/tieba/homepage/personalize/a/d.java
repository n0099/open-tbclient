package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.k;
/* loaded from: classes9.dex */
public class d<T extends com.baidu.tieba.card.k> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bOW */
    public T bvL() {
        return (T) this.fOw;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fOw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.fOw).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fOw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.fOw).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fOw != 0) {
            ((com.baidu.tieba.card.k) this.fOw).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fOw != 0) {
            ((com.baidu.tieba.card.k) this.fOw).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fOw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.fOw).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.fOw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.fOw).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fOw == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.k) this.fOw).getCurrentPosition();
    }
}
