package com.baidu.tieba.homepage.recommendfrs;

import android.widget.AbsListView;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AbsListView.OnScrollListener {
    final /* synthetic */ b cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.cwb = bVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        TagInfo tagInfo;
        tagInfo = this.cwb.cvT;
        if (tagInfo.tag_type.intValue() != 3) {
            return;
        }
        this.cwb.ctu = i;
    }
}
