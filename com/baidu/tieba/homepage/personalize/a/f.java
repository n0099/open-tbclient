package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.k;
/* loaded from: classes9.dex */
public class f<T extends com.baidu.tieba.card.k> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bZK */
    public T bFA() {
        return (T) this.gtR;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gtR == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.gtR).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gtR == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.gtR).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gtR != 0) {
            ((com.baidu.tieba.card.k) this.gtR).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gtR != 0) {
            ((com.baidu.tieba.card.k) this.gtR).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gtR == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.gtR).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gtR == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.gtR).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gtR == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.k) this.gtR).getCurrentPosition();
    }
}
