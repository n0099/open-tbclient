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
    /* renamed from: anz */
    public T acB() {
        return (T) this.cfb;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cfb == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cfb == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cfb != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cfb != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cfb == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cfb == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cfb == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cfb).getCurrentPosition();
    }
}
