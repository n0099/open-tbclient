package com.baidu.tbadk.widget.multiItemViewPager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MultiItemViewPager extends RelativeLayout {
    private Context mContext;
    private ViewPager mViewPager;

    public MultiItemViewPager(Context context) {
        super(context);
        aj(context);
    }

    public MultiItemViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aj(context);
    }

    public MultiItemViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aj(context);
    }

    private void aj(Context context) {
        this.mContext = context;
        View.inflate(context, n.g.widget_mul_item_viewpager_view, this);
        setClipChildren(false);
        setLayerType(1, null);
        this.mViewPager = (ViewPager) findViewById(n.f.container);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (pagerAdapter != null && this.mViewPager != null) {
            this.mViewPager.setAdapter(pagerAdapter);
            this.mViewPager.setOffscreenPageLimit(2);
            this.mViewPager.setPageMargin(this.mContext.getResources().getDimensionPixelSize(n.d.ds6));
            this.mViewPager.setCurrentItem(this.mViewPager.getCurrentItem() + 2, false);
            registerListener();
        }
    }

    private void registerListener() {
        if (this.mViewPager != null) {
            this.mViewPager.setOnPageChangeListener(new d(this));
            setOnTouchListener(new e(this));
        }
    }
}
