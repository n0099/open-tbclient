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
    /* renamed from: aKa */
    public T aoP() {
        return (T) this.cRp;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cRp == 0) {
            return false;
        }
        return ((n) this.cRp).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cRp == 0) {
            return false;
        }
        return ((n) this.cRp).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cRp != 0) {
            ((n) this.cRp).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cRp != 0) {
            ((n) this.cRp).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cRp == 0) {
            return null;
        }
        return ((n) this.cRp).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cRp == 0) {
            return null;
        }
        return ((n) this.cRp).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cRp == 0) {
            return 0;
        }
        return ((n) this.cRp).getCurrentPosition();
    }
}
