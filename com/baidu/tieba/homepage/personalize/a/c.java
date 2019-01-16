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
    /* renamed from: aMD */
    public T arr() {
        return (T) this.dcH;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.dcH == 0) {
            return false;
        }
        return ((n) this.dcH).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.dcH == 0) {
            return false;
        }
        return ((n) this.dcH).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.dcH != 0) {
            ((n) this.dcH).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dcH != 0) {
            ((n) this.dcH).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dcH == 0) {
            return null;
        }
        return ((n) this.dcH).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.dcH == 0) {
            return null;
        }
        return ((n) this.dcH).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dcH == 0) {
            return 0;
        }
        return ((n) this.dcH).getCurrentPosition();
    }
}
