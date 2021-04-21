package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.j2.e;
import d.b.j0.x.l;
/* loaded from: classes4.dex */
public class HomePageCardVideoViewHolder<T extends l> extends CardViewHolder<T> implements e {
    @Override // d.b.j0.j2.e
    public boolean D() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.holder.CardViewHolder
    /* renamed from: c */
    public T b() {
        return (T) this.f14954e;
    }

    @Override // d.b.j0.j2.e
    public int getCurrentPosition() {
        T t = this.f14954e;
        if (t == 0) {
            return 0;
        }
        return ((l) t).getCurrentPosition();
    }

    @Override // d.b.j0.j2.e
    public String getPlayUrl() {
        T t = this.f14954e;
        if (t == 0) {
            return null;
        }
        return ((l) t).R();
    }

    @Override // d.b.j0.j2.e
    public View getVideoContainer() {
        T t = this.f14954e;
        if (t == 0) {
            return null;
        }
        return ((l) t).S();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlayStarted() {
        T t = this.f14954e;
        if (t == 0) {
            return false;
        }
        return ((l) t).g0();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlaying() {
        T t = this.f14954e;
        if (t == 0) {
            return false;
        }
        return ((l) t).isPlaying();
    }

    @Override // d.b.j0.j2.e
    public void startPlay() {
        T t = this.f14954e;
        if (t != 0) {
            ((l) t).startPlay();
        }
    }

    @Override // d.b.j0.j2.e
    public void stopPlay() {
        T t = this.f14954e;
        if (t != 0) {
            ((l) t).stopPlay();
        }
    }
}
