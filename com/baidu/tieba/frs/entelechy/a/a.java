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
    /* renamed from: awk */
    public T alp() {
        return (T) this.cYC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cYC == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cYC == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cYC != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cYC != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cYC == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cYC == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cYC == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYC).getCurrentPosition();
    }
}
