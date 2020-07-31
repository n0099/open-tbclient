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
    private FrameLayout awD;
    private LinearLayout awE;
    private CustomViewPager awF;
    private float awH;
    private float awI;
    private int awJ;
    private float awK;
    private int awL;
    private int awO;
    private int awP;
    private int awQ;
    private List<com.baidu.live.h.b> awR;
    private View.OnClickListener awV;
    private a fSU;
    private b fSV;
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
        this.awV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.awE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.awF != null) {
                        AlaThroneAndNobleTabHost.this.awF.setCurrentItem(indexOfChild);
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
        this.awV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.awE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.awF != null) {
                        AlaThroneAndNobleTabHost.this.awF.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void ak(Context context) {
        this.awH = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.awI = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.awJ = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.awK = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.awO = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.awH = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.awI = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.awJ = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.awK = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.awL = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.awO = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.awP = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.awQ = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.awD = new FrameLayout(getContext());
        this.awD.setClickable(true);
        addView(this.awD, new LinearLayout.LayoutParams(-1, (int) this.awH));
        this.awE = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.awD.addView(this.awE, layoutParams);
        this.awF = new CustomViewPager(getContext());
        this.awF.setOnPageChangeListener(this);
        addView(this.awF);
    }

    private void t(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.awV);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.awO != -1) {
                layoutParams.gravity = this.awO;
            }
            a(cVar.wa(), false);
            a((TextView) cVar.wa(), false);
            this.awE.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.awJ, this.awJ);
            } else if (this.awP != 0 || this.awQ != 0) {
                gradientTextView.setGradientTextColor(this.awP, this.awQ);
            } else {
                gradientTextView.setGradientTextColor(this.awL, this.awL);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.awI);
            } else {
                textView.setTextSize(0, this.awK);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.awE.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.awE.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).wa(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).wa(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.awE.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fSU != null) {
                this.fSU.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.awR, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fSU != null) {
                this.fSU.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.awR, this.mCurrentTabIndex));
            }
        }
        if (this.fSV != null) {
            this.fSV.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.awE.getChildCount() != 0 && this.awF != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.fSU = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.fSV = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.awF.setAdapter(alaThroneAndNobleControllerAdapter);
            this.awR = alaThroneAndNobleControllerAdapter.getDataList();
            t(this.awR);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.awF.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView awX;

        public c(@NonNull Context context, String str) {
            super(context);
            ep(str);
        }

        private void ep(String str) {
            this.awX = new GradientTextView(getContext());
            this.awX.setCheckStrEquals(false);
            this.awX.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.awX.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.awX, layoutParams);
        }

        public GradientTextView wa() {
            return this.awX;
        }
    }
}
