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
    /* renamed from: aut */
    public T acB() {
        return (T) this.cfb;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cfb == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cfb).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cfb == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cfb).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cfb != 0) {
            ((com.baidu.tieba.card.j) this.cfb).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cfb != 0) {
            ((com.baidu.tieba.card.j) this.cfb).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cfb == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cfb).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cfb == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cfb).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cfb == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.cfb).getCurrentPosition();
    }
}
