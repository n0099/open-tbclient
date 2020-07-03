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
/* loaded from: classes3.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private CustomViewPager avA;
    private float avC;
    private float avD;
    private int avE;
    private float avF;
    private int avG;
    private int avJ;
    private int avK;
    private int avL;
    private List<com.baidu.live.h.b> avM;
    private View.OnClickListener avQ;
    private FrameLayout avy;
    private LinearLayout avz;
    private a fNB;
    private b fNC;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, com.baidu.live.h.b bVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.avQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.avz.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.avA != null) {
                        AlaThroneAndNobleTabHost.this.avA.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        ak(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.avQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.avz.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.avA != null) {
                        AlaThroneAndNobleTabHost.this.avA.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void ak(Context context) {
        this.avC = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avD = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.avE = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.avF = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.avJ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.avC = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.avD = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.avE = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.avF = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.avG = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.avJ = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.avK = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.avL = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.avy = new FrameLayout(getContext());
        this.avy.setClickable(true);
        addView(this.avy, new LinearLayout.LayoutParams(-1, (int) this.avC));
        this.avz = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.avy.addView(this.avz, layoutParams);
        this.avA = new CustomViewPager(getContext());
        this.avA.setOnPageChangeListener(this);
        addView(this.avA);
    }

    private void r(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.avQ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.avJ != -1) {
                layoutParams.gravity = this.avJ;
            }
            a(cVar.vE(), false);
            a((TextView) cVar.vE(), false);
            this.avz.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.avE, this.avE);
            } else if (this.avK != 0 || this.avL != 0) {
                gradientTextView.setGradientTextColor(this.avK, this.avL);
            } else {
                gradientTextView.setGradientTextColor(this.avG, this.avG);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.avD);
            } else {
                textView.setTextSize(0, this.avF);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.avz.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.avz.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).vE(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).vE(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.avz.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fNB != null) {
                this.fNB.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.avM, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fNB != null) {
                this.fNB.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.avM, this.mCurrentTabIndex));
            }
        }
        if (this.fNC != null) {
            this.fNC.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.avz.getChildCount() != 0 && this.avA != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.fNB = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.fNC = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.avA.setAdapter(alaThroneAndNobleControllerAdapter);
            this.avM = alaThroneAndNobleControllerAdapter.getDataList();
            r(this.avM);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.avA.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends FrameLayout {
        private GradientTextView avS;

        public c(@NonNull Context context, String str) {
            super(context);
            ep(str);
        }

        private void ep(String str) {
            this.avS = new GradientTextView(getContext());
            this.avS.setCheckStrEquals(false);
            this.avS.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.avS.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.avS, layoutParams);
        }

        public GradientTextView vE() {
            return this.avS;
        }
    }
}
