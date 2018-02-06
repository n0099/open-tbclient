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
    /* renamed from: aDa */
    public T alY() {
        return (T) this.dbp;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbp == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.i) this.dbp).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbp == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.i) this.dbp).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbp != 0) {
            ((com.baidu.tieba.card.i) this.dbp).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbp != 0) {
            ((com.baidu.tieba.card.i) this.dbp).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbp == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.i) this.dbp).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbp == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.i) this.dbp).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbp == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.i) this.dbp).getCurrentPosition();
    }
}
