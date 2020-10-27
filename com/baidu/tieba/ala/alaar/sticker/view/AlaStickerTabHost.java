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
    private FrameLayout aFA;
    private LinearLayout aFB;
    private CustomViewPager aFC;
    private List<com.baidu.live.view.tabhost.a> aFP;
    private View.OnClickListener aFT;
    private final int bHC;
    private AlaViewPagerAdapter bHD;
    private a fYN;
    private b fYO;
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
        this.bHC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aFT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aFC != null) {
                        AlaStickerTabHost.this.aFC.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    public AlaStickerTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
        this.mSkinType = 0;
        this.mCurrentTabIndex = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mSelectorColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_b);
        this.mDividerColor = TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_bg_line_c);
        this.aFT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.AlaStickerTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaStickerTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaStickerTabHost.this.mIsClicked = true;
                    if (AlaStickerTabHost.this.aFC != null) {
                        AlaStickerTabHost.this.aFC.setCurrentItem(indexOfChild, false);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.aFA = new FrameLayout(getContext());
        this.aFA.setBackgroundResource(a.f.ala_sticker_panel_bg);
        this.aFA.setId(a.g.ala_master_sticker_tab_widget);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        addView(this.aFA, layoutParams);
        this.aFB = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds34), 0);
        this.aFA.addView(this.aFB, layoutParams2);
        this.aFC = new CustomViewPager(getContext());
        this.aFC.setScrollable(true);
        this.aFC.setId(a.g.ala_master_sticker_view_pager);
        this.aFC.setOnPageChangeListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, a.g.ala_master_sticker_tab_widget);
        addView(this.aFC, layoutParams3);
        this.bHD = new AlaViewPagerAdapter();
        this.aFC.setAdapter(this.bHD);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
    }

    public void setData(List<com.baidu.live.view.tabhost.a> list) {
        this.aFP = list;
        w(list);
        this.bHD.setData(list);
        this.aFC.setCurrentItem(0);
    }

    public void setCurrentIndex(int i) {
        if (this.aFC != null) {
            this.aFC.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void w(List<com.baidu.live.view.tabhost.a> list) {
        for (com.baidu.live.view.tabhost.a aVar : list) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            textView.setText(aVar.getTitle());
            textView.setPadding(0, this.bHC, 0, this.bHC);
            textView.setGravity(17);
            textView.setOnClickListener(this.aFT);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            a(textView, false, this.mSkinType);
            this.aFB.addView(textView, layoutParams);
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
        int childCount = this.aFB.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aFB.getChildAt(i);
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
        if (this.aFB.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            this.mCurrentPositionOffset = f;
            updateTabStyles();
            invalidate();
            if (this.fYN != null) {
                this.fYN.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fYN != null) {
                this.fYN.a(this.mCurrentTabIndex, (com.baidu.live.view.tabhost.a) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
        if (this.fYO != null) {
            this.fYO.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aFB.getChildCount() != 0 && this.aFC != null && i == 0) {
            this.mCurrentPositionOffset = 0.0f;
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.fYN = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.fYO = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }
}
