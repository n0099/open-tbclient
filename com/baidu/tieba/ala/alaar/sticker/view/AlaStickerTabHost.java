package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.view.tabhost.AlaViewPagerAdapter;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaStickerTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private List<com.baidu.live.view.tabhost.a> aHA;
    private View.OnClickListener aHE;
    private FrameLayout aHl;
    private LinearLayout aHm;
    private CustomViewPager aHn;
    private final int bQC;
    private AlaViewPagerAdapter bQD;
    private a gmw;
    private b gmx;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private boolean mIsClicked;
    private Paint mRectPaint;
    private int mSelectorColor;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, com.baidu.live.view.tabhost.a aVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaStickerTabHost(Context context) {
        super(context);
        this.bQC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aHE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aHm.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aHn != null) {
                        AlaStickerTabHost.this.aHn.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    public AlaStickerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aHE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aHm.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aHn != null) {
                        AlaStickerTabHost.this.aHn.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aHl = new FrameLayout(getContext());
        this.aHl.setBackgroundResource(a.e.ala_sticker_panel_bg);
        this.aHl.setId(a.f.ala_master_sticker_tab_widget);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.aHl, layoutParams);
        this.aHm = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aHl.addView(this.aHm, layoutParams2);
        this.aHn = new CustomViewPager(getContext());
        this.aHn.setScrollable(true);
        this.aHn.setId(a.f.ala_master_sticker_view_pager);
        this.aHn.setOnPageChangeListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, a.f.ala_master_sticker_tab_widget);
        addView(this.aHn, layoutParams3);
        this.bQD = new AlaViewPagerAdapter();
        this.aHn.setAdapter(this.bQD);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aHA = list;
        x(list);
        this.bQD.setData(list);
        this.aHn.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aHn != null) {
            this.aHn.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bQC, 0, this.bQC);
            textView.setGravity(17);
            textView.setOnClickListener(this.aHE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aHm.addView(textView, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                SkinManager.setViewTextColor(textView, a.c.sdk_cp_cont_i_alpha70, 1, i);
            } else {
                SkinManager.setViewTextColor(textView, a.c.sdk_qm_main_color, 1, i);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aHm.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aHm.getChildAt(i);
            if (childAt instanceof TextView) {
                a((TextView) childAt, i == this.mCurrentTabIndex, this.mSkinType);
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aHm.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.gmw != null) {
                this.gmw.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aHA, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gmw != null) {
                this.gmw.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aHA, this.mCurrentTabIndex));
            }
        }
        if (this.gmx != null) {
            this.gmx.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aHm.getChildCount() != 0 && this.aHn != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gmw = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gmx = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }
}
