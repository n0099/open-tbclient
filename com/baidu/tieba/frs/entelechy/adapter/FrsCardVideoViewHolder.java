package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.j2.e;
import d.a.k0.q0.n1.g.a;
/* loaded from: classes4.dex */
public class FrsCardVideoViewHolder<T extends a> extends CardViewHolder<T> implements e {
    public FrsCardVideoViewHolder(T t) {
        super(t);
    }

    @Override // d.a.k0.j2.e
    public boolean C() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: c */
    public T b() {
        return (T) this.f14382e;
    }

    @Override // d.a.k0.j2.e
    public int getCurrentPosition() {
        T t = this.f14382e;
        if (t == 0) {
            return 0;
        }
        return ((a) t).getCurrentPosition();
    }

    @Override // d.a.k0.j2.e
    public String getPlayUrl() {
        T t = this.f14382e;
        if (t == 0) {
            return null;
        }
        return ((a) t).L();
    }

    @Override // d.a.k0.j2.e
    public View getVideoContainer() {
        T t = this.f14382e;
        if (t == 0) {
            return null;
        }
        return ((a) t).M();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlayStarted() {
        T t = this.f14382e;
        if (t == 0) {
            return false;
        }
        return ((a) t).W();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlaying() {
        T t = this.f14382e;
        if (t == 0) {
            return false;
        }
        return ((a) t).isPlaying();
    }

    @Override // d.a.k0.j2.e
    public void startPlay() {
        T t = this.f14382e;
        if (t != 0) {
            ((a) t).startPlay();
        }
    }

    @Override // d.a.k0.j2.e
    public void stopPlay() {
        T t = this.f14382e;
        if (t != 0) {
            ((a) t).stopPlay();
        }
    }
}
