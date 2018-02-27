package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.i;
/* loaded from: classes2.dex */
public class d<T extends com.baidu.tieba.card.i> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aCZ */
    public T alX() {
        return (T) this.dbd;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbd == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.i) this.dbd).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbd == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.i) this.dbd).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbd != 0) {
            ((com.baidu.tieba.card.i) this.dbd).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbd != 0) {
            ((com.baidu.tieba.card.i) this.dbd).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbd == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.i) this.dbd).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbd == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.i) this.dbd).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbd == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.i) this.dbd).getCurrentPosition();
    }
}
