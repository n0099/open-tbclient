package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.n;
/* loaded from: classes2.dex */
public class c<T extends n> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aEw */
    public T ajz() {
        return (T) this.cDi;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cDi == 0) {
            return false;
        }
        return ((n) this.cDi).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cDi == 0) {
            return false;
        }
        return ((n) this.cDi).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cDi != 0) {
            ((n) this.cDi).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cDi != 0) {
            ((n) this.cDi).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cDi == 0) {
            return null;
        }
        return ((n) this.cDi).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cDi == 0) {
            return null;
        }
        return ((n) this.cDi).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cDi == 0) {
            return 0;
        }
        return ((n) this.cDi).getCurrentPosition();
    }
}
