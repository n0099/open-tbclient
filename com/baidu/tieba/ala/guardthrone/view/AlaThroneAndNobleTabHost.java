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
    private FrameLayout aEF;
    private LinearLayout aEG;
    private CustomViewPager aEH;
    private float aEJ;
    private float aEK;
    private int aEL;
    private float aEM;
    private int aEN;
    private int aEQ;
    private int aER;
    private int aES;
    private List<com.baidu.live.h.b> aEU;
    private View.OnClickListener aEY;
    private a gJT;
    private b gJU;
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
        this.aEY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aEH != null) {
                        AlaThroneAndNobleTabHost.this.aEH.setCurrentItem(indexOfChild);
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
        this.aEY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aEG.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aEH != null) {
                        AlaThroneAndNobleTabHost.this.aEH.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aq(Context context) {
        this.aEJ = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aEK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aEL = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aEM = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aEQ = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aEJ = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aEK = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aEL = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aEM = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aEN = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aEQ = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aER = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aES = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aEF = new FrameLayout(getContext());
        this.aEF.setClickable(true);
        addView(this.aEF, new LinearLayout.LayoutParams(-1, (int) this.aEJ));
        this.aEG = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aEF.addView(this.aEG, layoutParams);
        this.aEH = new CustomViewPager(getContext());
        this.aEH.setOnPageChangeListener(this);
        addView(this.aEH);
    }

    private void w(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aEY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aEQ != -1) {
                layoutParams.gravity = this.aEQ;
            }
            a(cVar.CA(), false);
            a((TextView) cVar.CA(), false);
            this.aEG.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aEL, this.aEL);
            } else if (this.aER != 0 || this.aES != 0) {
                gradientTextView.setGradientTextColor(this.aER, this.aES);
            } else {
                gradientTextView.setGradientTextColor(this.aEN, this.aEN);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aEK);
            } else {
                textView.setTextSize(0, this.aEM);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aEG.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aEG.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).CA(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).CA(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aEG.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gJT != null) {
                this.gJT.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gJT != null) {
                this.gJT.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aEU, this.mCurrentTabIndex));
            }
        }
        if (this.gJU != null) {
            this.gJU.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aEG.getChildCount() != 0 && this.aEH != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gJT = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gJU = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aEH.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aEU = alaThroneAndNobleControllerAdapter.getDataList();
            w(this.aEU);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aEH.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aFa;

        public c(@NonNull Context context, String str) {
            super(context);
            ga(str);
        }

        private void ga(String str) {
            this.aFa = new GradientTextView(getContext());
            this.aFa.setCheckStrEquals(false);
            this.aFa.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aFa.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aFa, layoutParams);
        }

        public GradientTextView CA() {
            return this.aFa;
        }
    }
}
