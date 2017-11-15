package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: ass */
    public T aaJ() {
        return (T) this.bWm;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.bWm == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bWm).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.bWm == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bWm).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.bWm != 0) {
            ((com.baidu.tieba.card.j) this.bWm).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bWm != 0) {
            ((com.baidu.tieba.card.j) this.bWm).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bWm == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bWm).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bWm == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bWm).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bWm == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bWm).getCurrentPosition();
    }
}
