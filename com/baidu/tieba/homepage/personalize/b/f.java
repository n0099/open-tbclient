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
    /* renamed from: ajz */
    public T Tz() {
        return (T) this.bwf;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bwf == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bwf).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bwf == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.x) this.bwf).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bwf != 0) {
            ((com.baidu.tieba.card.x) this.bwf).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bwf != 0) {
            ((com.baidu.tieba.card.x) this.bwf).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bwf == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bwf).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bwf == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.x) this.bwf).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bwf == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.x) this.bwf).getCurrentPosition();
    }
}
