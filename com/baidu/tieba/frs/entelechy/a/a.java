package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
import com.baidu.tieba.play.e;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements e {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aiW */
    public T YJ() {
        return (T) this.bPa;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bPa == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bPa == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bPa != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bPa != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bPa == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bPa == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bPa == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.bPa).getCurrentPosition();
    }
}
