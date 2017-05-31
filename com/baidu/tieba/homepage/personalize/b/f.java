package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.y;
/* loaded from: classes.dex */
public class f<T extends com.baidu.tieba.card.y> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public f(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: ajb */
    public T UY() {
        return (T) this.bEs;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bEs == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.y) this.bEs).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bEs == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.y) this.bEs).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bEs != 0) {
            ((com.baidu.tieba.card.y) this.bEs).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bEs != 0) {
            ((com.baidu.tieba.card.y) this.bEs).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bEs == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.y) this.bEs).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bEs == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.y) this.bEs).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bEs == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.y) this.bEs).getCurrentPosition();
    }
}
