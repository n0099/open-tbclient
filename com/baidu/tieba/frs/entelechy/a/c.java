package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes6.dex */
public class c<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bEs */
    public T btc() {
        return (T) this.fIB;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fIB == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fIB == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fIB != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fIB != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fIB == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.fIB == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fIB == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fIB).getCurrentPosition();
    }
}
