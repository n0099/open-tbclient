package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes6.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aEx */
    public T aqT() {
        return (T) this.dbU;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbU == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbU == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbU != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbU != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbU == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbU == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbU == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dbU).getCurrentPosition();
    }
}
