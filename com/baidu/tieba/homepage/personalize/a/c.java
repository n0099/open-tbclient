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
    /* renamed from: aDw */
    public T aja() {
        return (T) this.cAD;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cAD == 0) {
            return false;
        }
        return ((n) this.cAD).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cAD == 0) {
            return false;
        }
        return ((n) this.cAD).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cAD != 0) {
            ((n) this.cAD).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cAD != 0) {
            ((n) this.cAD).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cAD == 0) {
            return null;
        }
        return ((n) this.cAD).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cAD == 0) {
            return null;
        }
        return ((n) this.cAD).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cAD == 0) {
            return 0;
        }
        return ((n) this.cAD).getCurrentPosition();
    }
}
