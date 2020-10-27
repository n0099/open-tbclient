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
    private FrameLayout aFA;
    private LinearLayout aFB;
    private CustomViewPager aFC;
    private float aFE;
    private float aFF;
    private int aFG;
    private float aFH;
    private int aFI;
    private int aFL;
    private int aFM;
    private int aFN;
    private List<com.baidu.live.h.b> aFP;
    private View.OnClickListener aFT;
    private b gEA;
    private a gEz;
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
        this.aFT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aFC != null) {
                        AlaThroneAndNobleTabHost.this.aFC.setCurrentItem(indexOfChild);
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
        this.aFT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aFB.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aFC != null) {
                        AlaThroneAndNobleTabHost.this.aFC.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aFE = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aFF = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aFG = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.aFH = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.aFL = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aFE = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.aFF = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aFG = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.aFH = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.aFI = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.aFL = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aFM = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aFN = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aFA = new FrameLayout(getContext());
        this.aFA.setClickable(true);
        addView(this.aFA, new LinearLayout.LayoutParams(-1, (int) this.aFE));
        this.aFB = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.aFA.addView(this.aFB, layoutParams);
        this.aFC = new CustomViewPager(getContext());
        this.aFC.setOnPageChangeListener(this);
        addView(this.aFC);
    }

    private void w(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aFT);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aFL != -1) {
                layoutParams.gravity = this.aFL;
            }
            a(cVar.CQ(), false);
            a((TextView) cVar.CQ(), false);
            this.aFB.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aFG, this.aFG);
            } else if (this.aFM != 0 || this.aFN != 0) {
                gradientTextView.setGradientTextColor(this.aFM, this.aFN);
            } else {
                gradientTextView.setGradientTextColor(this.aFI, this.aFI);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aFF);
            } else {
                textView.setTextSize(0, this.aFH);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aFB.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aFB.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).CQ(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).CQ(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aFB.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gEz != null) {
                this.gEz.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gEz != null) {
                this.gEz.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aFP, this.mCurrentTabIndex));
            }
        }
        if (this.gEA != null) {
            this.gEA.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aFB.getChildCount() != 0 && this.aFC != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gEz = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gEA = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aFC.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aFP = alaThroneAndNobleControllerAdapter.getDataList();
            w(this.aFP);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aFC.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aFV;

        public c(@NonNull Context context, String str) {
            super(context);
            gb(str);
        }

        private void gb(String str) {
            this.aFV = new GradientTextView(getContext());
            this.aFV.setCheckStrEquals(false);
            this.aFV.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.aFV.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aFV, layoutParams);
        }

        public GradientTextView CQ() {
            return this.aFV;
        }
    }
}
