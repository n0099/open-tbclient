package com.baidu.tieba.ala.guardthrone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.tieba.ala.guardthrone.adapter.AlaThroneAndNobleControllerAdapter;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private int aGB;
    private int aGC;
    private int aGD;
    private List<com.baidu.live.h.b> aGF;
    private View.OnClickListener aGJ;
    private FrameLayout aGq;
    private LinearLayout aGr;
    private CustomViewPager aGs;
    private float aGu;
    private float aGv;
    private int aGw;
    private float aGx;
    private int aGy;
    private a gKm;
    private b gKn;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, com.baidu.live.h.b bVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aGs != null) {
                        AlaThroneAndNobleTabHost.this.aGs.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aq(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aGJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aGr.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aGs != null) {
                        AlaThroneAndNobleTabHost.this.aGs.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aGu = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGv = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aGw = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aGx = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aGB = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aGu = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aGv = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aGw = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aGx = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aGy = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aGB = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aGC = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aGD = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aGq = new FrameLayout(getContext());
        this.aGq.setClickable(true);
        addView(this.aGq, new LinearLayout.LayoutParams(-1, (int) this.aGu));
        this.aGr = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aGq.addView(this.aGr, layoutParams);
        this.aGs = new CustomViewPager(getContext());
        this.aGs.setOnPageChangeListener(this);
        addView(this.aGs);
    }

    private void w(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aGJ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aGB != -1) {
                layoutParams.gravity = this.aGB;
            }
            a(cVar.Dj(), false);
            a((TextView) cVar.Dj(), false);
            this.aGr.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aGw, this.aGw);
            } else if (this.aGC != 0 || this.aGD != 0) {
                gradientTextView.setGradientTextColor(this.aGC, this.aGD);
            } else {
                gradientTextView.setGradientTextColor(this.aGy, this.aGy);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aGv);
            } else {
                textView.setTextSize(0, this.aGx);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aGr.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGr.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Dj(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).Dj(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGr.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gKm != null) {
                this.gKm.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gKm != null) {
                this.gKm.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aGF, this.mCurrentTabIndex));
            }
        }
        if (this.gKn != null) {
            this.gKn.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGr.getChildCount() != 0 && this.aGs != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gKm = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gKn = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aGs.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aGF = alaThroneAndNobleControllerAdapter.getDataList();
            w(this.aGF);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aGs.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aGL;

        public c(@NonNull Context context, String str) {
            super(context);
            gg(str);
        }

        private void gg(String str) {
            this.aGL = new GradientTextView(getContext());
            this.aGL.setCheckStrEquals(false);
            this.aGL.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aGL.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aGL, layoutParams);
        }

        public GradientTextView Dj() {
            return this.aGL;
        }
    }
}
