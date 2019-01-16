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
    /* renamed from: aEU */
    public T arr() {
        return (T) this.dcH;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dcH == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dcH == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dcH != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dcH != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dcH == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dcH == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dcH == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.dcH).getCurrentPosition();
    }
}
