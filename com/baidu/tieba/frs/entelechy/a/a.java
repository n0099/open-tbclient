package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aja */
    public T Yr() {
        return (T) this.bOG;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.bOG == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.bOG == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.bOG != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bOG != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bOG == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bOG == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bOG == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bOG).getCurrentPosition();
    }
}
