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
    /* renamed from: aoG */
    public T Xc() {
        return (T) this.bKG;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bKG == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bKG).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bKG == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bKG).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bKG != 0) {
            ((com.baidu.tieba.card.j) this.bKG).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bKG != 0) {
            ((com.baidu.tieba.card.j) this.bKG).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bKG == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bKG).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bKG == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bKG).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bKG == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bKG).getCurrentPosition();
    }
}
