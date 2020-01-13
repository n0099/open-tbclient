package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes7.dex */
public class c<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: bFu */
    public T bue() {
        return (T) this.fLL;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fLL == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fLL == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fLL != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fLL != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fLL == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.fLL == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fLL == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.fLL).getCurrentPosition();
    }
}
