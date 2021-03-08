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
    private FrameLayout aGd;
    private LinearLayout aGe;
    private CustomViewPager aGf;
    private float aGh;
    private float aGi;
    private int aGj;
    private float aGk;
    private int aGl;
    private int aGo;
    private int aGp;
    private int aGq;
    private List<com.baidu.live.j.c> aGs;
    private View.OnClickListener aGw;
    private a heV;
    private b heW;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, com.baidu.live.j.c cVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aGw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aGf != null) {
                        AlaThroneAndNobleTabHost.this.aGf.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aQ(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.aGw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aGe.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aGf != null) {
                        AlaThroneAndNobleTabHost.this.aGf.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aQ(Context context) {
        this.aGh = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGi = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aGj = getResources().getColor(a.c.sdk_color_e6e6e6);
        this.aGk = getResources().getDimensionPixelOffset(a.d.sdk_fontsize40);
        this.aGo = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_AlaLiveRoomPanelTabHost);
        this.aGh = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.d.sdk_ds110));
        this.aGi = getResources().getDimensionPixelOffset(a.d.sdk_fontsize32);
        this.aGj = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.c.sdk_color_e6e6e6));
        this.aGk = obtainStyledAttributes.getDimension(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.d.sdk_fontsize40));
        this.aGl = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.c.ala_guard_throne_color_E5B372));
        this.aGo = obtainStyledAttributes.getInt(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aGp = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aGq = obtainStyledAttributes.getColor(a.j.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aGd = new FrameLayout(getContext());
        this.aGd.setClickable(true);
        addView(this.aGd, new LinearLayout.LayoutParams(-1, (int) this.aGh));
        this.aGe = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds78), 0);
        this.aGd.addView(this.aGe, layoutParams);
        this.aGf = new CustomViewPager(getContext());
        this.aGf.setOnPageChangeListener(this);
        addView(this.aGf);
    }

    private void x(List<com.baidu.live.j.c> list) {
        for (com.baidu.live.j.c cVar : list) {
            c cVar2 = new c(getContext(), cVar.getTitle());
            cVar2.setOnClickListener(this.aGw);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aGo != -1) {
                layoutParams.gravity = this.aGo;
            }
            a(cVar2.Ar(), false);
            a((TextView) cVar2.Ar(), false);
            this.aGe.addView(cVar2, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aGj, this.aGj);
            } else if (this.aGp != 0 || this.aGq != 0) {
                gradientTextView.setGradientTextColor(this.aGp, this.aGq);
            } else {
                gradientTextView.setGradientTextColor(this.aGl, this.aGl);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aGi);
            } else {
                textView.setTextSize(0, this.aGk);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aGe.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aGe.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).Ar(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).Ar(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aGe.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.heV != null) {
                this.heV.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.heV != null) {
                this.heV.a(this.mCurrentTabIndex, (com.baidu.live.j.c) ListUtils.getItem(this.aGs, this.mCurrentTabIndex));
            }
        }
        if (this.heW != null) {
            this.heW.onPageSelected(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aGe.getChildCount() != 0 && this.aGf != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.heV = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.heW = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aGf.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aGs = alaThroneAndNobleControllerAdapter.getDataList();
            x(this.aGs);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aGf.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c extends FrameLayout {
        private GradientTextView aGy;

        public c(@NonNull Context context, String str) {
            super(context);
            ft(str);
        }

        private void ft(String str) {
            this.aGy = new GradientTextView(getContext());
            this.aGy.setCheckStrEquals(false);
            this.aGy.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.d.sdk_fontsize32));
            this.aGy.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aGy, layoutParams);
        }

        public GradientTextView Ar() {
            return this.aGy;
        }
    }
}
