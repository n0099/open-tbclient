package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.l;
/* loaded from: classes2.dex */
public class HomePageCardVideoViewHolder<T extends com.baidu.tieba.card.l> extends CardViewHolder<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: cRA */
    public T cti() {
        return (T) this.iCg;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iCg == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iCg).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iCg == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iCg).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iCg != 0) {
            ((com.baidu.tieba.card.l) this.iCg).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iCg != 0) {
            ((com.baidu.tieba.card.l) this.iCg).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iCg == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iCg).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iCg == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iCg).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iCg == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.iCg).getCurrentPosition();
    }
}
