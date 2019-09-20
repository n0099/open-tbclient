package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bxT */
    public T baX() {
        return (T) this.eIP;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.eIP == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.eIP).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.eIP == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.eIP).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.eIP != 0) {
            ((com.baidu.tieba.card.m) this.eIP).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.eIP != 0) {
            ((com.baidu.tieba.card.m) this.eIP).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eIP == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.eIP).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.eIP == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.eIP).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eIP == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.eIP).getCurrentPosition();
    }
}
