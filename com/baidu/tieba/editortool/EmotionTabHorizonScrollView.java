package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout a;
    private int b;
    private ArrayList<WritableEmotionGroup> c;
    private s d;
    private int e;
    private int f;
    private int g;
    private LinearLayout h;
    private ImageView i;
    private TextView j;
    private LinearLayout.LayoutParams k;
    private int l;
    private boolean m;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.m = true;
        c();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.m = true;
        c();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.b = -1;
        this.m = true;
        c();
    }

    private void c() {
        removeAllViews();
        setHorizontalScrollBarEnabled(false);
        this.a = new LinearLayout(getContext());
        this.a.setOrientation(0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.a.setBaselineAligned(false);
        addView(this.a);
        this.e = getResources().getDimensionPixelSize(R.dimen.face_tab_widget_tb_padding);
        this.f = getResources().getDimensionPixelSize(R.dimen.face_tab_widget_lr_padding);
        this.k = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.face_tab_widget_width), -1);
        this.k.topMargin = getResources().getDimensionPixelSize(R.dimen.default_gap_6);
        a();
    }

    public void setFrom(int i) {
        this.l = i;
    }

    public void setDatas(ArrayList<WritableEmotionGroup> arrayList) {
        this.c = arrayList;
    }

    private BDImageView b(WritableEmotionGroup writableEmotionGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        BDImageView bDImageView = new BDImageView(getContext());
        linearLayout.addView(bDImageView, new LinearLayout.LayoutParams(-1, -1));
        bDImageView.setPadding(this.f, this.e, this.f, this.e);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        if (this.g == 1) {
            linearLayout.setBackgroundResource(R.drawable.bg_expression_bar_1);
        } else {
            linearLayout.setBackgroundResource(R.drawable.bg_expression_bar);
        }
        this.a.addView(linearLayout, this.k);
        WritableEmotionGroup.EmotionGroupType c = writableEmotionGroup.c();
        if (c == WritableEmotionGroup.EmotionGroupType.LOCAL) {
            if (writableEmotionGroup.i() != null) {
                writableEmotionGroup.i().a(bDImageView);
            }
            linearLayout.setOnClickListener(new o(this, this.a.getChildCount() - 2, null));
        } else if (c == WritableEmotionGroup.EmotionGroupType.PROMOTION) {
            if (writableEmotionGroup.a() != null) {
                writableEmotionGroup.a().a(bDImageView);
            }
            linearLayout.setOnClickListener(new p(this, writableEmotionGroup.e(), null));
        } else if (c == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            if (this.m) {
                if (writableEmotionGroup.i() != null) {
                    writableEmotionGroup.i().a(bDImageView);
                }
                linearLayout.setOnClickListener(new o(this, this.a.getChildCount() - 2, null));
            } else {
                if (writableEmotionGroup.a() != null) {
                    writableEmotionGroup.a().a(bDImageView);
                }
                linearLayout.setOnClickListener(new l(this));
            }
        }
        return bDImageView;
    }

    public void a() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(0);
        this.i = new ImageView(getContext());
        this.i.setImageResource(this.g == 1 ? R.drawable.icon_store_1 : R.drawable.icon_store);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setPadding(this.f, this.e, this.f, this.e);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.h = new LinearLayout(getContext());
        this.h.addView(this.i, new LinearLayout.LayoutParams(-1, -1));
        this.h.setBackgroundResource(this.g == 1 ? R.drawable.bg_expression_bar_1 : R.drawable.bg_expression_bar);
        linearLayout.addView(this.h, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setPadding(0, getResources().getDimensionPixelSize(R.dimen.default_gap_6), 0, 0);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        this.j = new TextView(getContext());
        if (TiebaApplication.h().bm()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.j.setGravity(17);
        this.j.setTextSize(10.0f);
        this.j.setText("N");
        this.j.setTextColor(this.g == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        this.j.setBackgroundResource(this.g == 1 ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        frameLayout.addView(this.j, new FrameLayout.LayoutParams(-2, -2, 53));
        this.a.addView(frameLayout, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.face_tab_widget_width), -1));
        frameLayout.setOnClickListener(new m(this));
    }

    public void a(WritableEmotionGroup writableEmotionGroup) {
        b(writableEmotionGroup);
    }

    public void a(int i, boolean z) {
        this.m = z;
        int i2 = i + 1;
        int childCount = this.a.getChildCount();
        WritableEmotionGroup writableEmotionGroup = this.c.get(i2 - 1);
        if (i2 < childCount && writableEmotionGroup.c() == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(i2);
            BDImageView bDImageView = (BDImageView) linearLayout.getChildAt(0);
            if (!z) {
                linearLayout.setOnClickListener(new n(this));
                if (writableEmotionGroup.a() != null) {
                    writableEmotionGroup.a().a(bDImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new o(this, i2 - 1, null));
            if (writableEmotionGroup.i() != null) {
                writableEmotionGroup.i().a(bDImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i != this.b) {
            if (this.b != -1) {
                ((LinearLayout) this.a.getChildAt(this.b + 1)).setSelected(false);
            }
            this.b = i;
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(this.b + 1);
            linearLayout.setSelected(true);
            BDImageView bDImageView = (BDImageView) linearLayout.getChildAt(0);
            WritableEmotionGroup writableEmotionGroup = this.c.get(this.b);
            if (writableEmotionGroup.i() != null) {
                writableEmotionGroup.i().a(bDImageView);
            }
        }
    }

    public void b() {
        this.b = -1;
        this.a.removeAllViews();
        a();
    }

    public void a(int i) {
        this.g = i;
        if (this.i != null) {
            this.i.setImageResource(i == 1 ? R.drawable.icon_store_1 : R.drawable.icon_store);
        }
        if (this.h != null) {
            this.h.setBackgroundResource(i == 1 ? R.drawable.bg_expression_bar_1 : R.drawable.bg_expression_bar);
        }
        if (this.j != null) {
            this.j.setBackgroundResource(i == 1 ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
            this.j.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        if (i == 1) {
            int childCount = this.a.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(R.drawable.bg_expression_bar_1);
                }
            }
            return;
        }
        int childCount2 = this.a.getChildCount();
        for (int i3 = 1; i3 < childCount2; i3++) {
            View childAt2 = this.a.getChildAt(i3);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(R.drawable.bg_expression_bar);
            }
        }
    }

    public void setOnTabSelectedListener(s sVar) {
        this.d = sVar;
    }
}
