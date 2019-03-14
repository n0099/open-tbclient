package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes4.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bfy */
    public T aRi() {
        return (T) this.emE;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.emE == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emE).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.emE == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emE).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.emE != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emE).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.emE != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emE).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.emE == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emE).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.emE == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emE).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.emE == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emE).getCurrentPosition();
    }
}
