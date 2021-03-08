package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.l;
/* loaded from: classes2.dex */
public class HomePageCardVideoViewHolder<T extends com.baidu.tieba.card.l> extends CardViewHolder<T> implements com.baidu.tieba.play.e {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: cRH */
    public T cto() {
        return (T) this.iDP;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iDP == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iDP).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iDP == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.l) this.iDP).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iDP != 0) {
            ((com.baidu.tieba.card.l) this.iDP).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iDP != 0) {
            ((com.baidu.tieba.card.l) this.iDP).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iDP == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iDP).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iDP == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.l) this.iDP).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iDP == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.l) this.iDP).getCurrentPosition();
    }
}
