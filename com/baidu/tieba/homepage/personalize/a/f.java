package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.l;
/* loaded from: classes9.dex */
public class f<T extends com.baidu.tieba.card.l> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cjO */
    public T bPg() {
        return (T) this.gVN;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gVN == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gVN).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gVN == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.gVN).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gVN != 0) {
            ((com.baidu.tieba.card.l) this.gVN).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gVN != 0) {
            ((com.baidu.tieba.card.l) this.gVN).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gVN == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gVN).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gVN == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.gVN).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gVN == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.gVN).getCurrentPosition();
    }
}
