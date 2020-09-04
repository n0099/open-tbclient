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
/* loaded from: classes7.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aBH;
    private LinearLayout aBI;
    private CustomViewPager aBJ;
    private float aBL;
    private float aBM;
    private int aBN;
    private float aBO;
    private int aBP;
    private int aBS;
    private int aBT;
    private int aBU;
    private List<com.baidu.live.h.b> aBV;
    private View.OnClickListener aBZ;
    private a geX;
    private b geY;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, com.baidu.live.h.b bVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aBZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aBI.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aBJ != null) {
                        AlaThroneAndNobleTabHost.this.aBJ.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        an(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aBZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aBI.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aBJ != null) {
                        AlaThroneAndNobleTabHost.this.aBJ.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void an(Context context) {
        this.aBL = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aBM = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aBN = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.aBO = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.aBS = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aBL = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.aBM = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aBN = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.aBO = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.aBP = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.aBS = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aBT = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aBU = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aBH = new FrameLayout(getContext());
        this.aBH.setClickable(true);
        addView(this.aBH, new LinearLayout.LayoutParams(-1, (int) this.aBL));
        this.aBI = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.aBH.addView(this.aBI, layoutParams);
        this.aBJ = new CustomViewPager(getContext());
        this.aBJ.setOnPageChangeListener(this);
        addView(this.aBJ);
    }

    private void u(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aBZ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aBS != -1) {
                layoutParams.gravity = this.aBS;
            }
            a(cVar.By(), false);
            a((TextView) cVar.By(), false);
            this.aBI.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aBN, this.aBN);
            } else if (this.aBT != 0 || this.aBU != 0) {
                gradientTextView.setGradientTextColor(this.aBT, this.aBU);
            } else {
                gradientTextView.setGradientTextColor(this.aBP, this.aBP);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aBM);
            } else {
                textView.setTextSize(0, this.aBO);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aBI.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aBI.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).By(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).By(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aBI.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.geX != null) {
                this.geX.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aBV, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.geX != null) {
                this.geX.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aBV, this.mCurrentTabIndex));
            }
        }
        if (this.geY != null) {
            this.geY.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aBI.getChildCount() != 0 && this.aBJ != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.geX = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.geY = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aBJ.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aBV = alaThroneAndNobleControllerAdapter.getDataList();
            u(this.aBV);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aBJ.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends FrameLayout {
        private GradientTextView aCb;

        public c(@NonNull Context context, String str) {
            super(context);
            fI(str);
        }

        private void fI(String str) {
            this.aCb = new GradientTextView(getContext());
            this.aCb.setCheckStrEquals(false);
            this.aCb.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.aCb.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aCb, layoutParams);
        }

        public GradientTextView By() {
            return this.aCb;
        }
    }
}
