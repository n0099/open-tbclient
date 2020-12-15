package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes22.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cFV */
    public T csN() {
        return (T) this.iov;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iov == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iov).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iov == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iov).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iov != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iov).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iov != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iov).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iov == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iov).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iov == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iov).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iov == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iov).getCurrentPosition();
    }
}
