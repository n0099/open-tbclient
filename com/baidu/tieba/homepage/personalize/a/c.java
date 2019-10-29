package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: buX */
    public T baZ() {
        return (T) this.eRu;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.eRu == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.eRu).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.eRu == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.eRu).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.eRu != 0) {
            ((com.baidu.tieba.card.m) this.eRu).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.eRu != 0) {
            ((com.baidu.tieba.card.m) this.eRu).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eRu == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.eRu).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.eRu == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.eRu).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eRu == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.eRu).getCurrentPosition();
    }
}
