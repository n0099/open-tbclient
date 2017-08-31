package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.e {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aqR */
    public T Yy() {
        return (T) this.bOj;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bOj == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bOj).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bOj == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bOj).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bOj != 0) {
            ((com.baidu.tieba.card.j) this.bOj).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bOj != 0) {
            ((com.baidu.tieba.card.j) this.bOj).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bOj == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bOj).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bOj == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bOj).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bOj == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bOj).getCurrentPosition();
    }
}
