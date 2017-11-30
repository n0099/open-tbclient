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
    /* renamed from: auk */
    public T acs() {
        return (T) this.ceJ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ceJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.ceJ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ceJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.ceJ).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ceJ != 0) {
            ((com.baidu.tieba.card.j) this.ceJ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ceJ != 0) {
            ((com.baidu.tieba.card.j) this.ceJ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ceJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.ceJ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ceJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.ceJ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ceJ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.ceJ).getCurrentPosition();
    }
}
