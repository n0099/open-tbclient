package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import d.b.i0.i2.e;
/* loaded from: classes4.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public FrsCardVideoViewHolder f16254e;

    @Override // d.b.i0.i2.e
    public boolean D() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.D();
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return 0;
        }
        return frsCardVideoViewHolder.getCurrentPosition();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        return frsCardVideoViewHolder == null ? "" : frsCardVideoViewHolder.getPlayUrl();
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return null;
        }
        return frsCardVideoViewHolder.getVideoContainer();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.isPlayStarted();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return false;
        }
        return frsCardVideoViewHolder.isPlaying();
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return;
        }
        frsCardVideoViewHolder.startPlay();
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        FrsCardVideoViewHolder frsCardVideoViewHolder = this.f16254e;
        if (frsCardVideoViewHolder == null) {
            return;
        }
        frsCardVideoViewHolder.stopPlay();
    }
}
