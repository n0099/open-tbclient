package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import d.a.k0.j2.e;
/* loaded from: classes4.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public FrsCardVideoViewHolder f15430e;

    @Override // d.a.k0.j2.e
    public boolean C() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.C();
    }

    @Override // d.a.k0.j2.e
    public int getCurrentPosition() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return 0;
        }
        return frsCardVideoViewHolder.getCurrentPosition();
    }

    @Override // d.a.k0.j2.e
    public String getPlayUrl() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        return frsCardVideoViewHolder == null ? "" : frsCardVideoViewHolder.getPlayUrl();
    }

    @Override // d.a.k0.j2.e
    public View getVideoContainer() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return null;
        }
        return frsCardVideoViewHolder.getVideoContainer();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlayStarted() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.isPlayStarted();
    }

    @Override // d.a.k0.j2.e
    public boolean isPlaying() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.isPlaying();
    }

    @Override // d.a.k0.j2.e
    public void startPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return;
        }
        frsCardVideoViewHolder.startPlay();
    }

    @Override // d.a.k0.j2.e
    public void stopPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f15430e;
        if (frsCardVideoViewHolder == null) {
            return;
        }
        frsCardVideoViewHolder.stopPlay();
    }
}
