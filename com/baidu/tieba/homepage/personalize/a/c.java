package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.n;
/* loaded from: classes6.dex */
public class c<T extends n> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aJy */
    public T aor() {
        return (T) this.cSv;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cSv == 0) {
            return false;
        }
        return ((n) this.cSv).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cSv == 0) {
            return false;
        }
        return ((n) this.cSv).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cSv != 0) {
            ((n) this.cSv).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cSv != 0) {
            ((n) this.cSv).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cSv == 0) {
            return null;
        }
        return ((n) this.cSv).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cSv == 0) {
            return null;
        }
        return ((n) this.cSv).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cSv == 0) {
            return 0;
        }
        return ((n) this.cSv).getCurrentPosition();
    }
}
