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
    /* renamed from: axi */
    public T alX() {
        return (T) this.dbd;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbd == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbd == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbd != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbd != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbd == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbd == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbd == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbd).getCurrentPosition();
    }
}
