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
    /* renamed from: acn */
    public T UB() {
        return (T) this.byw;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.byw == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byw).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.byw == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byw).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.byw != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.byw).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.byw != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.byw).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.byw == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byw).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.byw == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byw).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.byw == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.byw).getCurrentPosition();
    }
}
