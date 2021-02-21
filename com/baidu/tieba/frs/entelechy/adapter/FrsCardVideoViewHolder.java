package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes2.dex */
public class FrsCardVideoViewHolder<T extends com.baidu.tieba.frs.entelechy.view.a> extends CardViewHolder<T> implements com.baidu.tieba.play.e {
    public FrsCardVideoViewHolder(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: cGx */
    public T cti() {
        return (T) this.iCg;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iCg == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iCg == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iCg != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iCg != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iCg == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iCg == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iCg == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iCg).getCurrentPosition();
    }
}
