package com.baidu.tieba.ala.liveroom.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends TbListCommonPullView {
    private ProgressBar progressBar;

    public a(Context context) {
        super(context);
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public View createView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.pull_to_refresh_view, (ViewGroup) null);
        this.progressBar = (ProgressBar) inflate.findViewById(a.g.refresh_progress);
        return inflate;
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public void releaseToRefresh() {
        if (this.progressBar != null) {
            this.progressBar.setVisibility(0);
        }
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public void refreshing() {
        if (this.progressBar != null) {
            this.progressBar.setVisibility(0);
        }
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public void done(boolean z) {
        if (this.progressBar != null) {
            this.progressBar.setVisibility(4);
        }
    }
}
