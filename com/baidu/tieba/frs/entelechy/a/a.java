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
    /* renamed from: aft */
    public T Wp() {
        return (T) this.bFk;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        if (this.bFk == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        if (this.bFk == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).isPlaying();
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
        if (this.bFk != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bFk != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bFk == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bFk == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bFk == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bFk).getCurrentPosition();
    }
}
