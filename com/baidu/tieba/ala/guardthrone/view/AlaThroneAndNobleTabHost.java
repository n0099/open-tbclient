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
    private FrameLayout aED;
    private LinearLayout aEE;
    private CustomViewPager aEF;
    private float aEH;
    private float aEI;
    private int aEJ;
    private float aEK;
    private int aEL;
    private int aEO;
    private int aEP;
    private int aEQ;
    private List<com.baidu.live.j.c> aES;
    private View.OnClickListener aEW;
    private a hcY;
    private b hcZ;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, com.baidu.live.j.c cVar);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aEW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aEE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aEF != null) {
                        AlaThroneAndNobleTabHost.this.aEF.setCurrentItem(indexOfChild);
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
        this.aEW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aEE.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aEF != null) {
                        AlaThroneAndNobleTabHost.this.aEF.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aR(Context context) {
        this.aEH = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aEI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aEJ = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aEK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aEO = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aEH = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aEI = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aEJ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aEK = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aEL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aEO = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aEP = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aEQ = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aED = new FrameLayout(getContext());
        this.aED.setClickable(true);
        addView(this.aED, new LinearLayout.LayoutParams(-1, (int) this.aEH));
        this.aEE = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aED.addView(this.aEE, layoutParams);
        this.aEF = new CustomViewPager(getContext());
        this.aEF.setOnPageChangeListener(this);
        addView(this.aEF);
    }

    private void x(List<com.baidu.live.j.c> list) {
        for (com.baidu.live.j.c cVar : list) {
            c cVar2 = new c(getContext(), cVar.getTitle());
            cVar2.setOnClickListener(this.aEW);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aEO != -1) {
                layoutParams.gravity = this.aEO;
            }
            a(cVar2.Ao(), false);
            a((TextView) cVar2.Ao(), false);
            this.aEE.addView(cVar2, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aEJ, this.aEJ);
            } else if (this.aEP != 0 || this.aEQ != 0) {
                gradientTextView.setGradientTextColor(this.aEP, this.aEQ);
            } else {
                gradientTextView.setGradientTextColor(this.aEL, this.aEL);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aEI);
            } else {
                textView.setTextSize(0, this.aEK);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aEE.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aEE.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ao(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).Ao(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEE.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.hcY != null) {
                this.hcY.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aES, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.hcY != null) {
                this.hcY.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aES, this.mCurrentTabIndex));
            }
        }
        if (this.hcZ != null) {
            this.hcZ.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aEE.getChildCount() != 0 && this.aEF != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.hcY = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.hcZ = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aEF.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aES = alaThroneAndNobleControllerAdapter.getDataList();
            x(this.aES);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aEF.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c extends FrameLayout {
        private GradientTextView aEY;

        public c(@NonNull Context context, String str) {
            super(context);
            fn(str);
        }

        private void fn(String str) {
            this.aEY = new GradientTextView(getContext());
            this.aEY.setCheckStrEquals(false);
            this.aEY.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aEY.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aEY, layoutParams);
        }

        public GradientTextView Ao() {
            return this.aEY;
        }
    }
}
