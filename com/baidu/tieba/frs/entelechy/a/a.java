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
    /* renamed from: bpR */
    public T baX() {
        return (T) this.eIP;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.eIP == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.eIP == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.eIP != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.eIP != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eIP == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.eIP == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eIP == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.eIP).getCurrentPosition();
    }
}
