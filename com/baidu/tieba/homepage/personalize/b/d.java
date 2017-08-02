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
    /* renamed from: aou */
    public T WX() {
        return (T) this.bJw;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.bJw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bJw).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.bJw == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.bJw).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.bJw != 0) {
            ((com.baidu.tieba.card.j) this.bJw).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bJw != 0) {
            ((com.baidu.tieba.card.j) this.bJw).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bJw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bJw).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bJw == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.bJw).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bJw == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.bJw).getCurrentPosition();
    }
}
