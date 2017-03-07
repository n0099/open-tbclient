package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class f<T extends com.baidu.tieba.card.x> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public f(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: ajF */
    public T Tb() {
        return (T) this.bwm;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bwm == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bwm).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bwm == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bwm).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bwm != 0) {
            ((com.baidu.tieba.card.x) this.bwm).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bwm != 0) {
            ((com.baidu.tieba.card.x) this.bwm).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bwm == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bwm).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bwm == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bwm).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bwm == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.x) this.bwm).getCurrentPosition();
    }
}
