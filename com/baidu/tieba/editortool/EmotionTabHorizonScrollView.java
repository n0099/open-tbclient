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
    private l a;
    private int b;
    private ArrayList<WritableEmotionGroup> c;
    private z d;
    private int e;
    private int f;
    private int g;
    private LinearLayout h;
    private ImageView i;
    private TextView j;
    private LinearLayout.LayoutParams k;
    private int l;
    private boolean m;
    private View n;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.m = true;
        b();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.m = true;
        b();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.b = -1;
        this.m = true;
        b();
    }

    private void b() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.a = new l(getContext());
        this.a.setOrientation(0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setBaselineAligned(false);
        addView(this.a);
        this.e = getResources().getDimensionPixelSize(R.dimen.face_tab_widget_tb_padding);
        this.f = getResources().getDimensionPixelSize(R.dimen.face_tab_widget_lr_padding);
        this.k = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.face_tab_widget_width), -1);
        this.a.setPadding(0, getResources().getDimensionPixelSize(R.dimen.default_gap_6), 0, 0);
        c();
    }

    public void setFrom(int i) {
        this.l = i;
    }

    public void setDatas(ArrayList<WritableEmotionGroup> arrayList) {
        this.c = arrayList;
    }

    private void c() {
        this.i = new ImageView(getContext());
        this.i.setImageResource(this.g == 1 ? R.drawable.icon_store_1 : R.drawable.icon_store);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setPadding(this.f, this.e, this.f, this.e);
        this.h = new LinearLayout(getContext());
        this.h.addView(this.i, new LinearLayout.LayoutParams(-1, -1));
        this.h.setBackgroundResource(this.g == 1 ? R.drawable.bg_expression_bar_1 : R.drawable.bg_expression_bar);
        this.j = new TextView(getContext());
        this.j.setGravity(17);
        this.j.setTextSize(10.0f);
        this.j.setText("N");
        this.j.setTextColor(this.g == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        this.j.setBackgroundResource(this.g == 1 ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.a.addView(this.h, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.face_tab_widget_width), -1));
        this.a.setNewView(this.j);
        if (TiebaApplication.g().bb()) {
            this.a.setNewViewVisible(true);
        } else {
            this.a.setNewViewVisible(false);
        }
        this.h.setOnClickListener(new t(this));
        this.n = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.n.setLayoutParams(layoutParams);
        this.n.setBackgroundResource(this.g == 1 ? R.drawable.bg_expression_bar_n_1 : R.drawable.bg_expression_bar_n);
        this.a.addView(this.n);
    }

    public final void a(WritableEmotionGroup writableEmotionGroup) {
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
        this.a.addView(linearLayout, this.a.getChildCount() - 1, this.k);
        WritableEmotionGroup.EmotionGroupType c = writableEmotionGroup.c();
        if (c == WritableEmotionGroup.EmotionGroupType.LOCAL) {
            if (writableEmotionGroup.i() != null) {
                writableEmotionGroup.i().a(bDImageView);
            }
            linearLayout.setOnClickListener(new v(this, this.a.getChildCount() - 3, (byte) 0));
        } else if (c == WritableEmotionGroup.EmotionGroupType.PROMOTION) {
            if (writableEmotionGroup.a() != null) {
                writableEmotionGroup.a().a(bDImageView);
            }
            linearLayout.setOnClickListener(new w(this, writableEmotionGroup.e(), (byte) 0));
        } else if (c == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            if (this.m) {
                if (writableEmotionGroup.i() != null) {
                    writableEmotionGroup.i().a(bDImageView);
                }
                linearLayout.setOnClickListener(new v(this, this.a.getChildCount() - 3, (byte) 0));
                return;
            }
            if (writableEmotionGroup.a() != null) {
                writableEmotionGroup.a().a(bDImageView);
            }
            linearLayout.setOnClickListener(new s(this));
        }
    }

    public final void a(int i, boolean z) {
        this.m = z;
        int i2 = i + 1;
        int childCount = this.a.getChildCount();
        WritableEmotionGroup writableEmotionGroup = this.c.get(i2 - 1);
        if (i2 < childCount && writableEmotionGroup.c() == WritableEmotionGroup.EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(i2);
            BDImageView bDImageView = (BDImageView) linearLayout.getChildAt(0);
            if (!this.m) {
                linearLayout.setOnClickListener(new u(this));
                if (writableEmotionGroup.a() != null) {
                    writableEmotionGroup.a().a(bDImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new v(this, i2 - 1, (byte) 0));
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

    public final void a() {
        this.b = -1;
        this.a.removeAllViews();
        c();
    }

    public final void a(int i) {
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

    public void setOnTabSelectedListener(z zVar) {
        this.d = zVar;
    }
}
