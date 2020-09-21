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
    private int aCA;
    private List<com.baidu.live.h.b> aCC;
    private View.OnClickListener aCG;
    private FrameLayout aCn;
    private LinearLayout aCo;
    private CustomViewPager aCp;
    private float aCr;
    private float aCs;
    private int aCt;
    private float aCu;
    private int aCv;
    private int aCy;
    private int aCz;
    private a gii;
    private b gij;
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
        this.aCG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aCo.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aCp != null) {
                        AlaThroneAndNobleTabHost.this.aCp.setCurrentItem(indexOfChild);
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
        this.aCG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.aCo.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aCp != null) {
                        AlaThroneAndNobleTabHost.this.aCp.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void an(Context context) {
        this.aCr = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aCs = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aCt = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.aCu = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.aCy = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.aCr = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.aCs = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.aCt = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.aCu = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.aCv = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.aCy = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.aCz = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.aCA = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.aCn = new FrameLayout(getContext());
        this.aCn.setClickable(true);
        addView(this.aCn, new LinearLayout.LayoutParams(-1, (int) this.aCr));
        this.aCo = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.aCn.addView(this.aCo, layoutParams);
        this.aCp = new CustomViewPager(getContext());
        this.aCp.setOnPageChangeListener(this);
        addView(this.aCp);
    }

    private void u(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.aCG);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.aCy != -1) {
                layoutParams.gravity = this.aCy;
            }
            a(cVar.BN(), false);
            a((TextView) cVar.BN(), false);
            this.aCo.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.aCt, this.aCt);
            } else if (this.aCz != 0 || this.aCA != 0) {
                gradientTextView.setGradientTextColor(this.aCz, this.aCA);
            } else {
                gradientTextView.setGradientTextColor(this.aCv, this.aCv);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.aCs);
            } else {
                textView.setTextSize(0, this.aCu);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.aCo.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.aCo.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).BN(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).BN(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCo.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gii != null) {
                this.gii.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aCC, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.gii != null) {
                this.gii.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.aCC, this.mCurrentTabIndex));
            }
        }
        if (this.gij != null) {
            this.gij.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aCo.getChildCount() != 0 && this.aCp != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.gii = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.gij = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aCp.setAdapter(alaThroneAndNobleControllerAdapter);
            this.aCC = alaThroneAndNobleControllerAdapter.getDataList();
            u(this.aCC);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aCp.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends FrameLayout {
        private GradientTextView aCI;

        public c(@NonNull Context context, String str) {
            super(context);
            fM(str);
        }

        private void fM(String str) {
            this.aCI = new GradientTextView(getContext());
            this.aCI.setCheckStrEquals(false);
            this.aCI.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.aCI.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.aCI, layoutParams);
        }

        public GradientTextView BN() {
            return this.aCI;
        }
    }
}
