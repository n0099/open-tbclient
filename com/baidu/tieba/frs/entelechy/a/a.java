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
    /* renamed from: abm */
    public T Tz() {
        return (T) this.bwf;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bwf == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bwf == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bwf != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bwf != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bwf == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bwf == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bwf == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bwf).getCurrentPosition();
    }
}
