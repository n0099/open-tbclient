package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.s {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: YP */
    public T Po() {
        return (T) this.bfy;
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlayStarted() {
        if (this.bfy == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.s
    public boolean isPlaying() {
        if (this.bfy == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).isPlaying();
    }

    @Override // com.baidu.tieba.play.s
    public void startPlay() {
        if (this.bfy != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.s
    public void stopPlay() {
        if (this.bfy != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.s
    public View getVideoContainer() {
        if (this.bfy == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.s
    public String getPlayUrl() {
        if (this.bfy == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.s
    public int getCurrentPosition() {
        if (this.bfy == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bfy).getCurrentPosition();
    }
}
