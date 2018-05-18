package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: arH */
    public T afY() {
        return (T) this.cuf;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cuf == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cuf == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cuf != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cuf != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cuf == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cuf == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cuf == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cuf).getCurrentPosition();
    }
}
