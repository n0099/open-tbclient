package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.o0.k2.e;
import d.a.o0.z.l;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
    @Override // d.a.o0.k2.e
    public boolean C() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: c */
    public T b() {
        return (T) this.f14424e;
    }

    @Override // d.a.o0.k2.e
    public int getCurrentPosition() {
        T t = this.f14424e;
        if (t == 0) {
            return 0;
        }
        return ((l) t).getCurrentPosition();
    }

    @Override // d.a.o0.k2.e
    public String getPlayUrl() {
        T t = this.f14424e;
        if (t == 0) {
            return null;
        }
        return ((l) t).P();
    }

    @Override // d.a.o0.k2.e
    public View getVideoContainer() {
        T t = this.f14424e;
        if (t == 0) {
            return null;
        }
        return ((l) t).Q();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlayStarted() {
        T t = this.f14424e;
        if (t == 0) {
            return false;
        }
        return ((l) t).c0();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlaying() {
        T t = this.f14424e;
        if (t == 0) {
            return false;
        }
        return ((l) t).isPlaying();
    }

    @Override // d.a.o0.k2.e
    public void startPlay() {
        T t = this.f14424e;
        if (t != 0) {
            ((l) t).startPlay();
        }
    }

    @Override // d.a.o0.k2.e
    public void stopPlay() {
        T t = this.f14424e;
        if (t != 0) {
            ((l) t).stopPlay();
        }
    }
}
