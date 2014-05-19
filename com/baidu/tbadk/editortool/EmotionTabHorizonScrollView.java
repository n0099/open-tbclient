package com.baidu.tbadk.editortool;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalScrollView {
    private g a;
    private int b;
    private ArrayList<ag> c;
    private u d;
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
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.a = new g(getContext());
        this.a.setOrientation(0);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setBaselineAligned(false);
        addView(this.a);
        this.e = getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_widget_tb_padding);
        this.f = getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_widget_lr_padding);
        this.k = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_widget_width), -1);
        this.a.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.p.default_gap_6), 0, 0);
        a();
    }

    public void setFrom(int i) {
        this.l = i;
    }

    public void setDatas(ArrayList<ag> arrayList) {
        this.c = arrayList;
    }

    private TbImageView b(ag agVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        tbImageView.setPadding(this.f, this.e, this.f, this.e);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        if (this.g == 1) {
            linearLayout.setBackgroundResource(com.baidu.tieba.q.bg_expression_bar_1);
        } else {
            linearLayout.setBackgroundResource(com.baidu.tieba.q.bg_expression_bar);
        }
        this.a.addView(linearLayout, this.a.getChildCount() - 1, this.k);
        EmotionGroupType c = agVar.c();
        if (c == EmotionGroupType.LOCAL) {
            if (agVar.i() != null) {
                agVar.i().a(tbImageView);
            }
            linearLayout.setOnClickListener(new q(this, this.a.getChildCount() - 3, null));
        } else if (c == EmotionGroupType.PROMOTION) {
            if (agVar.a() != null) {
                agVar.a().a(tbImageView);
            }
            linearLayout.setOnClickListener(new r(this, agVar.e(), null));
        } else if (c == EmotionGroupType.BIG_EMOTION) {
            if (this.m) {
                if (agVar.i() != null) {
                    agVar.i().a(tbImageView);
                }
                linearLayout.setOnClickListener(new q(this, this.a.getChildCount() - 3, null));
            } else {
                if (agVar.a() != null) {
                    agVar.a().a(tbImageView);
                }
                linearLayout.setOnClickListener(new n(this));
            }
        }
        return tbImageView;
    }

    public void a() {
        this.i = new ImageView(getContext());
        this.i.setImageResource(this.g == 1 ? com.baidu.tieba.q.icon_store_1 : com.baidu.tieba.q.icon_store);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setPadding(this.f, this.e, this.f, this.e);
        this.h = new LinearLayout(getContext());
        this.h.addView(this.i, new LinearLayout.LayoutParams(-1, -1));
        this.h.setBackgroundResource(this.g == 1 ? com.baidu.tieba.q.bg_expression_bar_1 : com.baidu.tieba.q.bg_expression_bar);
        this.j = new TextView(getContext());
        this.j.setGravity(17);
        this.j.setTextSize(10.0f);
        this.j.setText("N");
        this.j.setTextColor(this.g == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        this.j.setBackgroundResource(this.g == 1 ? com.baidu.tieba.q.icon_news_head_prompt_one_1 : com.baidu.tieba.q.icon_news_head_prompt_one);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.a.addView(this.h, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.p.face_tab_widget_width), -1));
        this.a.setNewView(this.j);
        if (TbadkApplication.m252getInst().isFaceShopNew()) {
            this.a.setNewViewVisible(true);
        } else {
            this.a.setNewViewVisible(false);
        }
        this.h.setOnClickListener(new o(this));
        this.n = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.n.setLayoutParams(layoutParams);
        this.n.setBackgroundResource(this.g == 1 ? com.baidu.tieba.q.bg_expression_bar_n_1 : com.baidu.tieba.q.bg_expression_bar_n);
        this.a.addView(this.n);
    }

    public void a(ag agVar) {
        b(agVar);
    }

    public void a(int i, boolean z) {
        this.m = z;
        int i2 = i + 1;
        int childCount = this.a.getChildCount();
        ag agVar = this.c.get(i2 - 1);
        if (i2 < childCount && agVar.c() == EmotionGroupType.BIG_EMOTION) {
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(i2);
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            if (!this.m) {
                linearLayout.setOnClickListener(new p(this));
                if (agVar.a() != null) {
                    agVar.a().a(tbImageView);
                    return;
                }
                return;
            }
            linearLayout.setOnClickListener(new q(this, i2 - 1, null));
            if (agVar.i() != null) {
                agVar.i().a(tbImageView);
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
            TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
            ag agVar = this.c.get(this.b);
            if (agVar.i() != null) {
                agVar.i().a(tbImageView);
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
            this.i.setImageResource(i == 1 ? com.baidu.tieba.q.icon_store_1 : com.baidu.tieba.q.icon_store);
        }
        if (this.h != null) {
            this.h.setBackgroundResource(i == 1 ? com.baidu.tieba.q.bg_expression_bar_1 : com.baidu.tieba.q.bg_expression_bar);
        }
        if (this.j != null) {
            this.j.setBackgroundResource(i == 1 ? com.baidu.tieba.q.icon_news_head_prompt_one_1 : com.baidu.tieba.q.icon_news_head_prompt_one);
            this.j.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        if (i == 1) {
            int childCount = this.a.getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(com.baidu.tieba.q.bg_expression_bar_1);
                }
            }
            return;
        }
        int childCount2 = this.a.getChildCount();
        for (int i3 = 1; i3 < childCount2; i3++) {
            View childAt2 = this.a.getChildAt(i3);
            if (childAt2 != null) {
                childAt2.setBackgroundResource(com.baidu.tieba.q.bg_expression_bar);
            }
        }
    }

    public void setOnTabSelectedListener(u uVar) {
        this.d = uVar;
    }
}
