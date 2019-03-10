package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bmL */
    public T aRj() {
        return (T) this.emI;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.emI == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.emI).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.emI == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.emI).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.emI != 0) {
            ((com.baidu.tieba.card.m) this.emI).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.emI != 0) {
            ((com.baidu.tieba.card.m) this.emI).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.emI == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.emI).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.emI == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.emI).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.emI == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.emI).getCurrentPosition();
    }
}
