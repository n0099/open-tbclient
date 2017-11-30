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
    /* renamed from: anq */
    public T acs() {
        return (T) this.ceJ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ceJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ceJ == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ceJ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ceJ != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ceJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ceJ == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ceJ == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.ceJ).getCurrentPosition();
    }
}
