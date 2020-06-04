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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CustomViewPager;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardthrone.adapter.AlaThroneAndNobleControllerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaThroneAndNobleTabHost extends LinearLayout implements ViewPager.OnPageChangeListener {
    private float atA;
    private float atB;
    private int atC;
    private float atD;
    private int atE;
    private int atH;
    private int atI;
    private int atJ;
    private List<com.baidu.live.h.b> atK;
    private View.OnClickListener atO;
    private FrameLayout atw;
    private LinearLayout atx;
    private CustomViewPager aty;
    private a fCs;
    private b fCt;
    private int mCurrentTabIndex;
    private boolean mIsClicked;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, com.baidu.live.h.b bVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onPageSelected(int i);
    }

    public AlaThroneAndNobleTabHost(Context context) {
        super(context);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.atO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.atx.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aty != null) {
                        AlaThroneAndNobleTabHost.this.aty.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        aj(context);
        init();
    }

    public AlaThroneAndNobleTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentTabIndex = 0;
        this.mIsClicked = false;
        this.atO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = AlaThroneAndNobleTabHost.this.atx.indexOfChild(view);
                if (indexOfChild >= 0) {
                    AlaThroneAndNobleTabHost.this.mIsClicked = true;
                    if (AlaThroneAndNobleTabHost.this.aty != null) {
                        AlaThroneAndNobleTabHost.this.aty.setCurrentItem(indexOfChild);
                    }
                }
            }
        };
        b(context, attributeSet);
        init();
    }

    private void aj(Context context) {
        this.atA = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.atB = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.atC = getResources().getColor(a.d.sdk_color_e6e6e6);
        this.atD = getResources().getDimensionPixelOffset(a.e.sdk_fontsize40);
        this.atH = -1;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_AlaLiveRoomPanelTabHost);
        this.atA = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_height, getResources().getDimensionPixelOffset(a.e.sdk_ds110));
        this.atB = getResources().getDimensionPixelOffset(a.e.sdk_fontsize32);
        this.atC = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textDefColor, getResources().getColor(a.d.sdk_color_e6e6e6));
        this.atD = obtainStyledAttributes.getDimension(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelSize, getResources().getDimensionPixelOffset(a.e.sdk_fontsize40));
        this.atE = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelColor, getResources().getColor(a.d.ala_guard_throne_color_E5B372));
        this.atH = obtainStyledAttributes.getInt(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_tabItemViewGravity, -1);
        this.atI = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelStartColor, 0);
        this.atJ = obtainStyledAttributes.getColor(a.k.sdk_AlaLiveRoomPanelTabHost_sdk_textSelEndColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void init() {
        setOrientation(1);
        this.atw = new FrameLayout(getContext());
        this.atw.setClickable(true);
        addView(this.atw, new LinearLayout.LayoutParams(-1, (int) this.atA));
        this.atx = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds78), 0);
        this.atw.addView(this.atx, layoutParams);
        this.aty = new CustomViewPager(getContext());
        this.aty.setOnPageChangeListener(this);
        addView(this.aty);
    }

    private void o(List<com.baidu.live.h.b> list) {
        for (com.baidu.live.h.b bVar : list) {
            c cVar = new c(getContext(), bVar.getTitle());
            cVar.setOnClickListener(this.atO);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            if (this.atH != -1) {
                layoutParams.gravity = this.atH;
            }
            a(cVar.vj(), false);
            a((TextView) cVar.vj(), false);
            this.atx.addView(cVar, layoutParams);
        }
    }

    private void a(GradientTextView gradientTextView, boolean z) {
        if (gradientTextView != null) {
            if (!z) {
                gradientTextView.setGradientTextColor(this.atC, this.atC);
            } else if (this.atI != 0 || this.atJ != 0) {
                gradientTextView.setGradientTextColor(this.atI, this.atJ);
            } else {
                gradientTextView.setGradientTextColor(this.atE, this.atE);
            }
        }
    }

    private void a(TextView textView, boolean z) {
        if (textView != null) {
            if (!z) {
                textView.setTextSize(0, this.atB);
            } else {
                textView.setTextSize(0, this.atD);
            }
        }
    }

    private void updateTabStyles() {
        int childCount = this.atx.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = this.atx.getChildAt(i);
            if (childAt instanceof c) {
                a(((c) childAt).vj(), i == this.mCurrentTabIndex);
                a((TextView) ((c) childAt).vj(), i == this.mCurrentTabIndex);
            }
            i++;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.atx.getChildCount() != 0 && !this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fCs != null) {
                this.fCs.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.atK, this.mCurrentTabIndex));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mIsClicked) {
            this.mCurrentTabIndex = i;
            updateTabStyles();
            invalidate();
            if (this.fCs != null) {
                this.fCs.a(this.mCurrentTabIndex, (com.baidu.live.h.b) ListUtils.getItem(this.atK, this.mCurrentTabIndex));
            }
        }
        if (this.fCt != null) {
            this.fCt.onPageSelected(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.atx.getChildCount() != 0 && this.aty != null && i == 0) {
            this.mIsClicked = false;
        }
    }

    public void setOnPageChangeListener(a aVar) {
        this.fCs = aVar;
    }

    public void setPageSelectedListener(b bVar) {
        this.fCt = bVar;
    }

    public void setAdapter(AlaThroneAndNobleControllerAdapter alaThroneAndNobleControllerAdapter) {
        if (alaThroneAndNobleControllerAdapter != null && !ListUtils.isEmpty(alaThroneAndNobleControllerAdapter.getDataList())) {
            this.aty.setAdapter(alaThroneAndNobleControllerAdapter);
            this.atK = alaThroneAndNobleControllerAdapter.getDataList();
            o(this.atK);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardthrone.view.AlaThroneAndNobleTabHost.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AlaThroneAndNobleTabHost.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AlaThroneAndNobleTabHost.this.mCurrentTabIndex = AlaThroneAndNobleTabHost.this.aty.getCurrentItem();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends FrameLayout {
        private GradientTextView atQ;

        public c(@NonNull Context context, String str) {
            super(context);
            em(str);
        }

        private void em(String str) {
            this.atQ = new GradientTextView(getContext());
            this.atQ.setCheckStrEquals(false);
            this.atQ.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_fontsize32));
            this.atQ.setText(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.atQ, layoutParams);
        }

        public GradientTextView vj() {
            return this.atQ;
        }
    }
}
