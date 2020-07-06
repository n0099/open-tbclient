package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes9.dex */
public class d<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cbD */
    public T bPh() {
        return (T) this.gVN;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gVN == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gVN == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gVN != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gVN != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gVN == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.gVN == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gVN == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.gVN).getCurrentPosition();
    }
}
