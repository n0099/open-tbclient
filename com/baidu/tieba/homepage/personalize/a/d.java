package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes2.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aBw */
    public T akh() {
        return (T) this.cTF;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cTF == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cTF).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cTF == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cTF).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cTF != 0) {
            ((com.baidu.tieba.card.j) this.cTF).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cTF != 0) {
            ((com.baidu.tieba.card.j) this.cTF).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cTF == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cTF).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cTF == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cTF).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cTF == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.cTF).getCurrentPosition();
    }
}
