package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.i0.i2.e;
import d.b.i0.x.l;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
    @Override // d.b.i0.i2.e
    public boolean D() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: c */
    public T b() {
        return (T) this.f15282e;
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        T t = this.f15282e;
        if (t == 0) {
            return 0;
        }
        return ((l) t).getCurrentPosition();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        T t = this.f15282e;
        if (t == 0) {
            return null;
        }
        return ((l) t).R();
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        T t = this.f15282e;
        if (t == 0) {
            return null;
        }
        return ((l) t).S();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        T t = this.f15282e;
        if (t == 0) {
            return false;
        }
        return ((l) t).g0();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        T t = this.f15282e;
        if (t == 0) {
            return false;
        }
        return ((l) t).isPlaying();
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
        T t = this.f15282e;
        if (t != 0) {
            ((l) t).startPlay();
        }
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        T t = this.f15282e;
        if (t != 0) {
            ((l) t).stopPlay();
        }
    }
}
