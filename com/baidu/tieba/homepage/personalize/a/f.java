package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.l;
/* loaded from: classes9.dex */
public class f<T extends com.baidu.tieba.card.l> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cgf */
    public T bLU() {
        return (T) this.gIC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gIC == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gIC).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gIC == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gIC).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gIC != 0) {
            ((com.baidu.tieba.card.l) this.gIC).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gIC != 0) {
            ((com.baidu.tieba.card.l) this.gIC).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gIC == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gIC).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gIC == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gIC).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gIC == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.gIC).getCurrentPosition();
    }
}
