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
    public T acC() {
        return (T) this.ceX;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ceX == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ceX == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ceX != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ceX != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ceX == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ceX == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ceX == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceX).getCurrentPosition();
    }
}
