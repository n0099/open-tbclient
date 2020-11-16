package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes21.dex */
public class g<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cKP */
    public T coz() {
        return (T) this.idz;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.idz == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.idz).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.idz == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.idz).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.idz != 0) {
            ((com.baidu.tieba.card.m) this.idz).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.idz != 0) {
            ((com.baidu.tieba.card.m) this.idz).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.idz == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.idz).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.idz == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.idz).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.idz == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.idz).getCurrentPosition();
    }
}
