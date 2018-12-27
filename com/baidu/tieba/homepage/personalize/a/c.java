package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.n;
/* loaded from: classes6.dex */
public class c<T extends n> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aMd */
    public T aqT() {
        return (T) this.dbU;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dbU == 0) {
            return false;
        }
        return ((n) this.dbU).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dbU == 0) {
            return false;
        }
        return ((n) this.dbU).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dbU != 0) {
            ((n) this.dbU).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dbU != 0) {
            ((n) this.dbU).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dbU == 0) {
            return null;
        }
        return ((n) this.dbU).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dbU == 0) {
            return null;
        }
        return ((n) this.dbU).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dbU == 0) {
            return 0;
        }
        return ((n) this.dbU).getCurrentPosition();
    }
}
