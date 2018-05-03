package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.n;
/* loaded from: classes2.dex */
public class c<T extends n> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public c(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: axY */
    public T afY() {
        return (T) this.csV;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.csV == 0) {
            return false;
        }
        return ((n) this.csV).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.csV == 0) {
            return false;
        }
        return ((n) this.csV).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.csV != 0) {
            ((n) this.csV).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.csV != 0) {
            ((n) this.csV).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.csV == 0) {
            return null;
        }
        return ((n) this.csV).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.csV == 0) {
            return null;
        }
        return ((n) this.csV).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.csV == 0) {
            return 0;
        }
        return ((n) this.csV).getCurrentPosition();
    }
}
