package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.k0.j2.e;
import d.a.k0.x.l;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
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
        return ((l) t).getCurrentPosition();
    }

    @Override // d.a.k0.j2.e
    public String getPlayUrl() {
        T t = this.f14382e;
        if (t == 0) {
            return null;
        }
        return ((l) t).O();
    }

    @Override // d.a.k0.j2.e
    public View getVideoContainer() {
        T t = this.f14382e;
        if (t == 0) {
            return null;
        }
        return ((l) t).P();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlayStarted() {
        T t = this.f14382e;
        if (t == 0) {
            return false;
        }
        return ((l) t).b0();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlaying() {
        T t = this.f14382e;
        if (t == 0) {
            return false;
        }
        return ((l) t).isPlaying();
    }

    @Override // d.a.k0.j2.e
    public void startPlay() {
        T t = this.f14382e;
        if (t != 0) {
            ((l) t).startPlay();
        }
    }

    @Override // d.a.k0.j2.e
    public void stopPlay() {
        T t = this.f14382e;
        if (t != 0) {
            ((l) t).stopPlay();
        }
    }
}
