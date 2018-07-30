package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: awV */
    public T ajz() {
        return (T) this.cDi;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cDi == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cDi == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cDi != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cDi != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cDi == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cDi == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cDi == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cDi).getCurrentPosition();
    }
}
