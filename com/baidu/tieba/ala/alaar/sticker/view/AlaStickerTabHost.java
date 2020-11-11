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
    private List<com.baidu.live.view.tabhost.a> aGF;
    private View.OnClickListener aGJ;
    private FrameLayout aGq;
    private LinearLayout aGr;
    private CustomViewPager aGs;
    private final int bNh;
    private AlaViewPagerAdapter bNi;
    private a geF;
    private b geG;
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
        this.bNh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aGs != null) {
                        AlaStickerTabHost.this.aGs.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    public AlaStickerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_bg_line_c);
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aGs != null) {
                        AlaStickerTabHost.this.aGs.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aGq = new FrameLayout(getContext());
        this.aGq.setBackgroundResource(a.e.ala_sticker_panel_bg);
        this.aGq.setId(a.f.ala_master_sticker_tab_widget);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.aGq, layoutParams);
        this.aGr = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds34), 0);
        this.aGq.addView(this.aGr, layoutParams2);
        this.aGs = new CustomViewPager(getContext());
        this.aGs.setScrollable(true);
        this.aGs.setId(a.f.ala_master_sticker_view_pager);
        this.aGs.setOnPageChangeListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, a.f.ala_master_sticker_tab_widget);
        addView(this.aGs, layoutParams3);
        this.bNi = new AlaViewPagerAdapter();
        this.aGs.setAdapter(this.bNi);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aGF = list;
        w(list);
        this.bNi.setData(list);
        this.aGs.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aGs != null) {
            this.aGs.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bNh, 0, this.bNh);
            textView.setGravity(17);
            textView.setOnClickListener(this.aGJ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aGr.addView(textView, layoutParams);
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
        int childCount = this.aGr.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGr.getChildAt(i);
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
        if (this.aGr.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.geF != null) {
                this.geF.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.geF != null) {
                this.geF.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
        if (this.geG != null) {
            this.geG.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGr.getChildCount() != 0 && this.aGs != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.geF = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.geG = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }
}
