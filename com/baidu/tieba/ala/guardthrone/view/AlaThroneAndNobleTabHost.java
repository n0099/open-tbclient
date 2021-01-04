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
/* loaded from: classes11.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private FrameLayout aHD;
    private LinearLayout aHE;
    private CustomViewPager aHF;
    private float aHH;
    private float aHI;
    private int aHJ;
    private float aHK;
    private int aHL;
    private int aHO;
    private int aHP;
    private int aHQ;
    private List<com.baidu.live.k.c> aHS;
    private View.OnClickListener aHW;
    private a heU;
    private b heV;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, com.baidu.live.k.c cVar);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aHW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aHE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aHF != null) {
                        AlaThroneAndNobleTabHost.this.aHF.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aS(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aHW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aHE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aHF != null) {
                        AlaThroneAndNobleTabHost.this.aHF.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aS(Context context) {
        this.aHH = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aHI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aHJ = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aHK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aHO = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aHH = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aHI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aHJ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aHK = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aHL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aHO = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aHP = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aHQ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aHD = new FrameLayout(getContext());
        this.aHD.setClickable(true);
        addView(this.aHD, new LinearLayout.LayoutParams(-1, (int) this.aHH));
        this.aHE = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aHD.addView(this.aHE, layoutParams);
        this.aHF = new CustomViewPager(getContext());
        this.aHF.setOnPageChangeListener(this);
        addView(this.aHF);
    }

    private void x(List<com.baidu.live.k.c> list) {
        for (com.baidu.live.k.c cVar : list) {
            c cVar2 = new c(getContext(), cVar.getTitle());
            cVar2.setOnClickListener(this.aHW);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aHO != -1) {
                layoutParams.gravity = this.aHO;
            }
            a(cVar2.Dz(), false);
            a((TextView) cVar2.Dz(), false);
            this.aHE.addView(cVar2, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aHJ, this.aHJ);
            } else if (this.aHP != 0 || this.aHQ != 0) {
                gradientTextView.setGradientTextColor(this.aHP, this.aHQ);
            } else {
                gradientTextView.setGradientTextColor(this.aHL, this.aHL);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aHI);
            } else {
                textView.setTextSize(0, this.aHK);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aHE.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aHE.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Dz(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).Dz(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aHE.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.heU != null) {
                this.heU.a(this.mCurrentTabIndex, (com.baidu.live.k.c) ListUtils.getItem(this.aHS, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.heU != null) {
                this.heU.a(this.mCurrentTabIndex, (com.baidu.live.k.c) ListUtils.getItem(this.aHS, this.mCurrentTabIndex));
            }
        }
        if (this.heV != null) {
            this.heV.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aHE.getChildCount() != 0 && this.aHF != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.heU = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.heV = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aHF.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aHS = alaThroneAndNobleControllerAdapter.getDataList();
            x(this.aHS);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aHF.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends FrameLayout {
        private GradientTextView aHY;

        public c(@NonNull Context context, String str) {
            super(context);
            gf(str);
        }

        private void gf(String str) {
            this.aHY = new GradientTextView(getContext());
            this.aHY.setCheckStrEquals(false);
            this.aHY.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aHY.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aHY, layoutParams);
        }

        public GradientTextView Dz() {
            return this.aHY;
        }
    }
}
