package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes2.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aBG */
    public T alp() {
        return (T) this.cYC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cYC == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cYC).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cYC == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cYC).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cYC != 0) {
            ((com.baidu.tieba.card.j) this.cYC).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cYC != 0) {
            ((com.baidu.tieba.card.j) this.cYC).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cYC == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cYC).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cYC == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cYC).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cYC == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.cYC).getCurrentPosition();
    }
}
