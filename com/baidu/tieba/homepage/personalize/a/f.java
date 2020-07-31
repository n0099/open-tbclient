package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.l;
/* loaded from: classes16.dex */
public class f<T extends com.baidu.tieba.card.l> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: cnq */
    public T bSs() {
        return (T) this.hbs;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.hbs == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.hbs).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.hbs == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.hbs).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.hbs != 0) {
            ((com.baidu.tieba.card.l) this.hbs).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.hbs != 0) {
            ((com.baidu.tieba.card.l) this.hbs).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hbs == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.hbs).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.hbs == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.hbs).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hbs == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.hbs).getCurrentPosition();
    }
}
