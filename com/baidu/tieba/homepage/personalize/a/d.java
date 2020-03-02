package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.k;
/* loaded from: classes9.dex */
public class d<T extends com.baidu.tieba.card.k> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bOV */
    public T bvK() {
        return (T) this.fOj;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fOj == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.fOj).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fOj == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.k) this.fOj).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fOj != 0) {
            ((com.baidu.tieba.card.k) this.fOj).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fOj != 0) {
            ((com.baidu.tieba.card.k) this.fOj).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fOj == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.fOj).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.fOj == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.k) this.fOj).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fOj == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.k) this.fOj).getCurrentPosition();
    }
}
