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
    /* renamed from: axY */
    public T afY() {
        return (T) this.csY;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.csY == 0) {
            return false;
        }
        return ((n) this.csY).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.csY == 0) {
            return false;
        }
        return ((n) this.csY).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.csY != 0) {
            ((n) this.csY).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.csY != 0) {
            ((n) this.csY).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.csY == 0) {
            return null;
        }
        return ((n) this.csY).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.csY == 0) {
            return null;
        }
        return ((n) this.csY).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.csY == 0) {
            return 0;
        }
        return ((n) this.csY).getCurrentPosition();
    }
}
