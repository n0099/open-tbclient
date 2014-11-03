package com.baidu.tieba.game;

import android.graphics.Rect;
import android.widget.AbsListView;
import com.baidu.tieba.square.CarouselRecommendView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements AbsListView.OnScrollListener {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(av avVar) {
        this.aJj = avVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        CarouselRecommendView carouselRecommendView;
        CarouselRecommendView carouselRecommendView2;
        CarouselRecommendView carouselRecommendView3;
        CarouselRecommendView carouselRecommendView4;
        carouselRecommendView = this.aJj.aIR;
        if (carouselRecommendView != null) {
            Rect rect = new Rect();
            carouselRecommendView2 = this.aJj.aIR;
            carouselRecommendView2.getGlobalVisibleRect(rect);
            if (rect.top > 0) {
                carouselRecommendView4 = this.aJj.aIR;
                carouselRecommendView4.startMarqueen();
                return;
            }
            carouselRecommendView3 = this.aJj.aIR;
            carouselRecommendView3.stopMarqueen();
        }
    }
}
