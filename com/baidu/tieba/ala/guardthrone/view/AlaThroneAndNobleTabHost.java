package com.baidu.tieba.ala.guardthrone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.tieba.ala.guardthrone.adapter.AlaThroneAndNobleControllerAdapter;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aCQ;
    private LinearLayout aCR;
    private CustomViewPager aCS;
    private float aCU;
    private float aCV;
    private int aCW;
    private float aCX;
    private int aCY;
    private int aDb;
    private int aDc;
    private int aDd;
    private List<com.baidu.live.k.c> aDf;
    private View.OnClickListener aDj;
    private a hao;
    private b hap;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, com.baidu.live.k.c cVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aDj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aCS != null) {
                        AlaThroneAndNobleTabHost.this.aCS.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aR(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aDj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aCR.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aCS != null) {
                        AlaThroneAndNobleTabHost.this.aCS.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aR(Context context) {
        this.aCU = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aCV = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aCW = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aCX = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aDb = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aCU = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aCV = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aCW = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aCX = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aCY = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aDb = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aDc = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aDd = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aCQ = new FrameLayout(getContext());
        this.aCQ.setClickable(true);
        addView(this.aCQ, new LinearLayout.LayoutParams(-1, (int) this.aCU));
        this.aCR = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aCQ.addView(this.aCR, layoutParams);
        this.aCS = new CustomViewPager(getContext());
        this.aCS.setOnPageChangeListener(this);
        addView(this.aCS);
    }

    private void x(List<com.baidu.live.k.c> list) {
        for (com.baidu.live.k.c cVar : list) {
            c cVar2 = new c(getContext(), cVar.getTitle());
            cVar2.setOnClickListener(this.aDj);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aDb != -1) {
                layoutParams.gravity = this.aDb;
            }
            a(cVar2.zE(), false);
            a((TextView) cVar2.zE(), false);
            this.aCR.addView(cVar2, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aCW, this.aCW);
            } else if (this.aDc != 0 || this.aDd != 0) {
                gradientTextView.setGradientTextColor(this.aDc, this.aDd);
            } else {
                gradientTextView.setGradientTextColor(this.aCY, this.aCY);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aCV);
            } else {
                textView.setTextSize(0, this.aCX);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aCR.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aCR.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).zE(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).zE(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCR.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.hao != null) {
                this.hao.a(this.mCurrentTabIndex, (com.baidu.live.k.c) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.hao != null) {
                this.hao.a(this.mCurrentTabIndex, (com.baidu.live.k.c) ListUtils.getItem(this.aDf, this.mCurrentTabIndex));
            }
        }
        if (this.hap != null) {
            this.hap.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aCR.getChildCount() != 0 && this.aCS != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.hao = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.hap = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aCS.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aDf = alaThroneAndNobleControllerAdapter.getDataList();
            x(this.aDf);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aCS.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends FrameLayout {
        private GradientTextView aDl;

        public c(@NonNull Context context, String str) {
            super(context);
            eU(str);
        }

        private void eU(String str) {
            this.aDl = new GradientTextView(getContext());
            this.aDl.setCheckStrEquals(false);
            this.aDl.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aDl.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aDl, layoutParams);
        }

        public GradientTextView zE() {
            return this.aDl;
        }
    }
}
