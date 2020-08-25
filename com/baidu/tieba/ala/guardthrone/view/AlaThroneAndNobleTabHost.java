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
    private FrameLayout aBF;
    private LinearLayout aBG;
    private CustomViewPager aBH;
    private float aBJ;
    private float aBK;
    private int aBL;
    private float aBM;
    private int aBN;
    private int aBQ;
    private int aBR;
    private int aBS;
    private List<com.baidu.live.h.b> aBT;
    private View.OnClickListener aBX;
    private a geT;
    private b geU;
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
        this.aBX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aBG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aBH != null) {
                        AlaThroneAndNobleTabHost.this.aBH.setCurrentItem(indexOfChild);
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
        this.aBX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aBG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aBH != null) {
                        AlaThroneAndNobleTabHost.this.aBH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void an(Context context) {
        this.aBJ = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aBK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aBL = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.aBM = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.aBQ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aBJ = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.aBK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aBL = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.aBM = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.aBN = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.aBQ = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aBR = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aBS = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aBF = new FrameLayout(getContext());
        this.aBF.setClickable(true);
        addView(this.aBF, new LinearLayout.LayoutParams(-1, (int) this.aBJ));
        this.aBG = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.aBF.addView(this.aBG, layoutParams);
        this.aBH = new CustomViewPager(getContext());
        this.aBH.setOnPageChangeListener(this);
        addView(this.aBH);
    }

    private void u(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aBX);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aBQ != -1) {
                layoutParams.gravity = this.aBQ;
            }
            a(cVar.By(), false);
            a((TextView) cVar.By(), false);
            this.aBG.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aBL, this.aBL);
            } else if (this.aBR != 0 || this.aBS != 0) {
                gradientTextView.setGradientTextColor(this.aBR, this.aBS);
            } else {
                gradientTextView.setGradientTextColor(this.aBN, this.aBN);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aBK);
            } else {
                textView.setTextSize(0, this.aBM);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aBG.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aBG.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).By(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).By(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aBG.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.geT != null) {
                this.geT.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aBT, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.geT != null) {
                this.geT.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aBT, this.mCurrentTabIndex));
            }
        }
        if (this.geU != null) {
            this.geU.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aBG.getChildCount() != 0 && this.aBH != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.geT = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.geU = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aBH.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aBT = alaThroneAndNobleControllerAdapter.getDataList();
            u(this.aBT);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aBH.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c extends FrameLayout {
        private GradientTextView aBZ;

        public c(@NonNull Context context, String str) {
            super(context);
            fH(str);
        }

        private void fH(String str) {
            this.aBZ = new GradientTextView(getContext());
            this.aBZ.setCheckStrEquals(false);
            this.aBZ.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.aBZ.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aBZ, layoutParams);
        }

        public GradientTextView By() {
            return this.aBZ;
        }
    }
}
