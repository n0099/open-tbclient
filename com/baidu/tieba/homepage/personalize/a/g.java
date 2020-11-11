package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.m;
/* loaded from: classes22.dex */
public class g<T extends com.baidu.tieba.card.m> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cLj */
    public T coY() {
        return (T) this.icG;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.icG == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.icG).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.icG == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.m) this.icG).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.icG != 0) {
            ((com.baidu.tieba.card.m) this.icG).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.icG != 0) {
            ((com.baidu.tieba.card.m) this.icG).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.icG == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.icG).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.icG == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.m) this.icG).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.icG == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.m) this.icG).getCurrentPosition();
    }
}
