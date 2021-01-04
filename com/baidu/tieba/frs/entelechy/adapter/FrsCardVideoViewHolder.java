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
    /* renamed from: cIU */
    public T cvG() {
        return (T) this.iAP;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.iAP == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.iAP == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.iAP != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.iAP != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.iAP == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.iAP == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.iAP == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.iAP).getCurrentPosition();
    }
}
