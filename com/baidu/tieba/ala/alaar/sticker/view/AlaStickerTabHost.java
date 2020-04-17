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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.u.a;
import com.baidu.live.view.tabhost.AlaViewPagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaStickerTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private List<com.baidu.live.view.tabhost.a> aoK;
    private View.OnClickListener aoO;
    private FrameLayout aow;
    private LinearLayout aox;
    private CustomViewPager aoy;
    private final int bbS;
    private AlaViewPagerAdapter bbT;
    private a eLS;
    private b eLT;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private boolean mIsClicked;
    private Paint mRectPaint;
    private int mSelectorColor;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, com.baidu.live.view.tabhost.a aVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaStickerTabHost(Context context) {
        super(context);
        this.bbS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aox.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aoy != null) {
                        AlaStickerTabHost.this.aoy.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    public AlaStickerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aox.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aoy != null) {
                        AlaStickerTabHost.this.aoy.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aow = new FrameLayout(getContext());
        this.aow.setBackgroundResource(a.f.ala_sticker_panel_bg);
        this.aow.setId(a.g.ala_master_sticker_tab_widget);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.aow, layoutParams);
        this.aox = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aow.addView(this.aox, layoutParams2);
        this.aoy = new CustomViewPager(getContext());
        this.aoy.setScrollable(true);
        this.aoy.setId(a.g.ala_master_sticker_view_pager);
        this.aoy.setOnPageChangeListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, a.g.ala_master_sticker_tab_widget);
        addView(this.aoy, layoutParams3);
        this.bbT = new AlaViewPagerAdapter();
        this.aoy.setAdapter(this.bbT);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aoK = list;
        o(list);
        this.bbT.setData(list);
        this.aoy.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aoy != null) {
            this.aoy.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void o(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bbS, 0, this.bbS);
            textView.setGravity(17);
            textView.setOnClickListener(this.aoO);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aox.addView(textView, layoutParams);
        }
    }

    private void a(TextView textView, boolean z, int i) {
        if (textView != null) {
            if (!z) {
                SkinManager.setViewTextColor(textView, a.d.sdk_cp_cont_i_alpha70, 1, i);
            } else {
                SkinManager.setViewTextColor(textView, a.d.sdk_qm_main_color, 1, i);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aox.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aox.getChildAt(i);
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
        if (this.aox.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.eLS != null) {
                this.eLS.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aoK, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.eLS != null) {
                this.eLS.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aoK, this.mCurrentTabIndex));
            }
        }
        if (this.eLT != null) {
            this.eLT.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aox.getChildCount() != 0 && this.aoy != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.eLS = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.eLT = bVar;
    }
}
