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
    /* renamed from: aph */
    public T Xv() {
        return (T) this.bLq;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bLq == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bLq).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bLq == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bLq).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bLq != 0) {
            ((com.baidu.tieba.card.j) this.bLq).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bLq != 0) {
            ((com.baidu.tieba.card.j) this.bLq).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bLq == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bLq).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bLq == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bLq).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bLq == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bLq).getCurrentPosition();
    }
}
