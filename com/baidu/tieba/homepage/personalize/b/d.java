package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: arc */
    public T YJ() {
        return (T) this.bPa;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bPa == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bPa).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bPa == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bPa).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bPa != 0) {
            ((com.baidu.tieba.card.j) this.bPa).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bPa != 0) {
            ((com.baidu.tieba.card.j) this.bPa).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bPa == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bPa).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bPa == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bPa).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bPa == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bPa).getCurrentPosition();
    }
}
