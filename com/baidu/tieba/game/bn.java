package com.baidu.tieba.game;

import android.graphics.Rect;
import android.widget.AbsListView;
import com.baidu.tieba.square.CarouselRecommendView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements AbsListView.OnScrollListener {
    final /* synthetic */ bj aJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bj bjVar) {
        this.aJs = bjVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        bo boVar;
        boVar = this.aJs.aJl;
        CarouselRecommendView advCarouselView = boVar.getAdvCarouselView();
        if (advCarouselView != null) {
            Rect rect = new Rect();
            advCarouselView.getGlobalVisibleRect(rect);
            if (rect.top > 0) {
                advCarouselView.startMarqueen();
            } else {
                advCarouselView.stopMarqueen();
            }
        }
    }
}
