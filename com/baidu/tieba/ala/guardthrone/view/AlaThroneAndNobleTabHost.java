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
    private List<com.baidu.live.j.c> aHA;
    private View.OnClickListener aHE;
    private FrameLayout aHl;
    private LinearLayout aHm;
    private CustomViewPager aHn;
    private float aHp;
    private float aHq;
    private int aHr;
    private float aHs;
    private int aHt;
    private int aHw;
    private int aHx;
    private int aHy;
    private a gTh;
    private b gTi;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, com.baidu.live.j.c cVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aHE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aHm.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aHn != null) {
                        AlaThroneAndNobleTabHost.this.aHn.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aT(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aHE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aHm.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aHn != null) {
                        AlaThroneAndNobleTabHost.this.aHn.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aT(Context context) {
        this.aHp = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aHq = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aHr = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aHs = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aHw = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aHp = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aHq = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aHr = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aHs = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aHt = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aHw = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aHx = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aHy = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aHl = new FrameLayout(getContext());
        this.aHl.setClickable(true);
        addView(this.aHl, new LinearLayout.LayoutParams(-1, (int) this.aHp));
        this.aHm = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aHl.addView(this.aHm, layoutParams);
        this.aHn = new CustomViewPager(getContext());
        this.aHn.setOnPageChangeListener(this);
        addView(this.aHn);
    }

    private void x(List<com.baidu.live.j.c> list) {
        for (com.baidu.live.j.c cVar : list) {
            c cVar2 = new c(getContext(), cVar.getTitle());
            cVar2.setOnClickListener(this.aHE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aHw != -1) {
                layoutParams.gravity = this.aHw;
            }
            a(cVar2.Ek(), false);
            a((TextView) cVar2.Ek(), false);
            this.aHm.addView(cVar2, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aHr, this.aHr);
            } else if (this.aHx != 0 || this.aHy != 0) {
                gradientTextView.setGradientTextColor(this.aHx, this.aHy);
            } else {
                gradientTextView.setGradientTextColor(this.aHt, this.aHt);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aHq);
            } else {
                textView.setTextSize(0, this.aHs);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aHm.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aHm.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ek(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).Ek(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aHm.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gTh != null) {
                this.gTh.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aHA, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gTh != null) {
                this.gTh.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aHA, this.mCurrentTabIndex));
            }
        }
        if (this.gTi != null) {
            this.gTi.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aHm.getChildCount() != 0 && this.aHn != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gTh = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gTi = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aHn.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aHA = alaThroneAndNobleControllerAdapter.getDataList();
            x(this.aHA);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aHn.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aHG;

        public c(@NonNull Context context, String str) {
            super(context);
            gw(str);
        }

        private void gw(String str) {
            this.aHG = new GradientTextView(getContext());
            this.aHG.setCheckStrEquals(false);
            this.aHG.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aHG.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aHG, layoutParams);
        }

        public GradientTextView Ek() {
            return this.aHG;
        }
    }
}
