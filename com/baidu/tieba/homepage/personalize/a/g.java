package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes22.dex */
public class g<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cII */
    public T cmx() {
        return (T) this.hWJ;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.hWJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.hWJ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.hWJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.hWJ).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.hWJ != 0) {
            ((com.baidu.tieba.card.m) this.hWJ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.hWJ != 0) {
            ((com.baidu.tieba.card.m) this.hWJ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hWJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.hWJ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.hWJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.hWJ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hWJ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.hWJ).getCurrentPosition();
    }
}
