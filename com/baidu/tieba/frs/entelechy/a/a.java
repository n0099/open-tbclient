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
        return (T) this.emr;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.emr == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emr).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.emr == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emr).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.emr != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emr).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.emr != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.emr).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.emr == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emr).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.emr == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emr).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.emr == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.emr).getCurrentPosition();
    }
}
