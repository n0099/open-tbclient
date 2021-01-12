package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.l;
/* loaded from: classes2.dex */
public class HomePageCardVideoViewHolder<T extends com.baidu.tieba.card.l> extends CardViewHolder<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: cPu */
    public T crP() {
        return (T) this.iwi;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iwi == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iwi).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iwi == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iwi).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iwi != 0) {
            ((com.baidu.tieba.card.l) this.iwi).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iwi != 0) {
            ((com.baidu.tieba.card.l) this.iwi).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iwi == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iwi).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iwi == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iwi).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iwi == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.iwi).getCurrentPosition();
    }
}
