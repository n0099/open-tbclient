package com.baidu.tieba.ala.liveroom.recommend.view;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import com.baidu.live.adp.widget.listview.BdTypeListView;
/* loaded from: classes3.dex */
public class AlaRecommendLiveListView extends BdTypeListView {
    public AlaRecommendLiveListView(Context context) {
        super(context);
        setDivider(null);
        setOverScrollMode(2);
        setSelector(17170445);
        setVerticalScrollBarEnabled(false);
        setFastScrollEnabled(false);
        setScrollbarFadingEnabled(false);
        setBackgroundColor(Color.parseColor("#FF161823"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
