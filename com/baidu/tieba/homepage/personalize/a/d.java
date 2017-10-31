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
    /* renamed from: asb */
    public T aax() {
        return (T) this.bVZ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.bVZ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bVZ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.bVZ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bVZ).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.bVZ != 0) {
            ((com.baidu.tieba.card.j) this.bVZ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bVZ != 0) {
            ((com.baidu.tieba.card.j) this.bVZ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bVZ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bVZ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bVZ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bVZ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bVZ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bVZ).getCurrentPosition();
    }
}
