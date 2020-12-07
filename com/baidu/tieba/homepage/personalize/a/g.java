package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes22.dex */
public class g<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cQe */
    public T csM() {
        return (T) this.iot;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iot == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.iot).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iot == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.iot).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iot != 0) {
            ((com.baidu.tieba.card.m) this.iot).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iot != 0) {
            ((com.baidu.tieba.card.m) this.iot).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iot == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.iot).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iot == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.iot).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iot == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.iot).getCurrentPosition();
    }
}
