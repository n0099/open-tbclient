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
    /* renamed from: alv */
    public T aaJ() {
        return (T) this.bWm;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.bWm == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.bWm == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.bWm != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bWm != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bWm == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bWm == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bWm == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bWm).getCurrentPosition();
    }
}
