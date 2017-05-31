package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.b.a<T> implements com.baidu.tieba.play.u {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b.a
    /* renamed from: abC */
    public T UY() {
        return (T) this.bEs;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bEs == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bEs == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bEs != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bEs != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bEs == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bEs == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bEs == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bEs).getCurrentPosition();
    }
}
