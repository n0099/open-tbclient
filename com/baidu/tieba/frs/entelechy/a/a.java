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
    /* renamed from: alh */
    public T aax() {
        return (T) this.bVZ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.bVZ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.bVZ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.bVZ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bVZ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bVZ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bVZ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bVZ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bVZ).getCurrentPosition();
    }
}
