package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.view.tabhost.AlaViewPagerAdapter;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaStickerTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aGd;
    private LinearLayout aGe;
    private CustomViewPager aGf;
    private List<com.baidu.live.view.tabhost.a> aGs;
    private View.OnClickListener aGw;
    private final int bWP;
    private AlaViewPagerAdapter bWQ;
    private a gwT;
    private b gwU;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private boolean mIsClicked;
    private Paint mRectPaint;
    private int mSelectorColor;
    private int mSkinType;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, com.baidu.live.view.tabhost.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaStickerTabHost(Context context) {
        super(context);
        this.bWP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aGf != null) {
                        AlaStickerTabHost.this.aGf.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    public AlaStickerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aGf != null) {
                        AlaStickerTabHost.this.aGf.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aGd = new FrameLayout(getContext());
        this.aGd.setBackgroundResource(a.e.ala_sticker_panel_bg);
        this.aGd.setId(a.f.ala_master_sticker_tab_widget);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.aGd, layoutParams);
        this.aGe = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aGd.addView(this.aGe, layoutParams2);
        this.aGf = new CustomViewPager(getContext());
        this.aGf.setScrollable(true);
        this.aGf.setId(a.f.ala_master_sticker_view_pager);
        this.aGf.setOnPageChangeListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, a.f.ala_master_sticker_tab_widget);
        addView(this.aGf, layoutParams3);
        this.bWQ = new AlaViewPagerAdapter();
        this.aGf.setAdapter(this.bWQ);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aGs = list;
        x(list);
        this.bWQ.setData(list);
        this.aGf.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aGf != null) {
            this.aGf.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void x(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bWP, 0, this.bWP);
            textView.setGravity(17);
            textView.setOnClickListener(this.aGw);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aGe.addView(textView, layoutParams);
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
        int childCount = this.aGe.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGe.getChildAt(i);
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGe.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.gwT != null) {
                this.gwT.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gwT != null) {
                this.gwT.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
        if (this.gwU != null) {
            this.gwU.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGe.getChildCount() != 0 && this.aGf != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gwT = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gwU = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }
}
