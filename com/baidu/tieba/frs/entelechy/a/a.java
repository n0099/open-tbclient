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
    /* renamed from: bfw */
    public T aRg() {
        return (T) this.emq;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.emq == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emq).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.emq == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emq).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.emq != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emq).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.emq != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emq).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.emq == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emq).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.emq == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emq).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.emq == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emq).getCurrentPosition();
    }
}
