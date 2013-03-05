package com.baidu.tieba.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.f b = null;
    private Boolean c = false;
    private Boolean d = true;
    private Boolean e = false;
    private Boolean f;
    private String g;
    private View.OnClickListener h;
    private View.OnLongClickListener i;
    private View.OnClickListener j;
    private View.OnClickListener k;
    private ArrayList l;
    private int m;

    public f(Context context, com.baidu.tieba.b.f fVar) {
        this.f = false;
        this.m = 10;
        this.a = context;
        a(fVar);
        this.g = this.a.getText(R.string.grade).toString();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = com.baidu.tieba.c.ai.a(this.a, 10.0f);
        this.l = new ArrayList();
        this.f = Boolean.valueOf(TiebaApplication.b().p() != null);
    }

    public void a() {
        if (this.l != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.l.size()) {
                    try {
                        ((ProgressBar) this.l.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.l.clear();
                    return;
                }
            }
        }
    }

    public void a(com.baidu.tieba.b.f fVar) {
        this.b = fVar;
        if (fVar != null && fVar.c() != null && fVar.c().size() > 8) {
            this.e = true;
        } else {
            this.e = false;
        }
        if (fVar != null) {
            if (fVar.d() == null || fVar.d().size() == 0) {
                this.f = true;
            }
        }
    }

    public void a(Boolean bool) {
        this.c = bool;
        this.d = false;
    }

    public void b() {
        this.f = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 2;
        if (this.b == null) {
            return 1;
        }
        if (this.c.booleanValue() && this.b.c() != null && this.b.c().size() > 0) {
            int size = this.b.c().size();
            if (size > 8) {
                if (this.f.booleanValue()) {
                    i = (size % 2) + 1 + (size / 2);
                } else {
                    i = 6;
                }
            } else {
                i = (size % 2) + 1 + (size / 2);
            }
        }
        if (this.b.d() != null && this.b.d().size() > 0) {
            return i + this.b.d().size() + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 3) {
            int c = i - c();
            if (this.b != null && this.b.d() != null && c >= 0 && this.b.d().size() > c) {
                return this.b.d().get(c);
            }
        }
        return Integer.valueOf(itemViewType);
    }

    public int c() {
        if (this.b != null && this.b.d() != null) {
            if (this.b.d().size() == 0) {
                return (getCount() - this.b.d().size()) - 1;
            }
            return getCount() - this.b.d().size();
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x05fb: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:121:0x05fa */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int ag;
        int itemViewType;
        Resources resources;
        View view3;
        j jVar;
        View view4;
        m mVar;
        try {
            ag = TiebaApplication.b().ag();
            itemViewType = getItemViewType(i);
            resources = this.a.getResources();
            try {
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.ag.b(getClass().getName(), "getView", exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (itemViewType == 0) {
            if (view == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_enter, (ViewGroup) null);
                h hVar = new h(this, null);
                hVar.a = (RelativeLayout) inflate.findViewById(R.id.container);
                hVar.b = (LinearLayout) inflate.findViewById(R.id.home_search_bg_layout);
                hVar.c = inflate.findViewById(R.id.lv_seperator);
                hVar.d = (ImageView) inflate.findViewById(R.id.lottery_image);
                ViewGroup.LayoutParams layoutParams = hVar.d.getLayoutParams();
                layoutParams.width = com.baidu.tieba.c.ai.a(this.a);
                layoutParams.height = (layoutParams.width * 176) / 320;
                hVar.d.setLayoutParams(layoutParams);
                hVar.d.setOnClickListener(new g(this));
                inflate.setTag(hVar);
                view = inflate;
            }
            h hVar2 = (h) view.getTag();
            if (ag == 1) {
                hVar2.a.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                com.baidu.tieba.c.ae.i(hVar2.b, R.drawable.home_search_bg_1);
                hVar2.c.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
            } else {
                hVar2.a.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
                com.baidu.tieba.c.ae.i(hVar2.b, R.drawable.home_search_bg);
                hVar2.c.setBackgroundColor(-2960686);
            }
            if (TiebaApplication.b().aA() != null && TiebaApplication.b().aA().a() == 1) {
                if (hVar2.d.getVisibility() != 0) {
                    hVar2.d.setVisibility(0);
                    hVar2.d.setImageResource(R.drawable.banner_image);
                    return view;
                }
                return view;
            } else if (hVar2.d.getVisibility() != 8) {
                hVar2.d.setVisibility(8);
                hVar2.d.setImageResource(0);
                return view;
            } else {
                return view;
            }
        } else if (itemViewType == 1) {
            if (view == null) {
                View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_login, (ViewGroup) null);
                k kVar = new k(this, null);
                kVar.a = (LinearLayout) inflate2.findViewById(R.id.container);
                kVar.b = (TextView) inflate2.findViewById(R.id.tip);
                kVar.c = (Button) inflate2.findViewById(R.id.want_login);
                kVar.c.setOnClickListener(this.j);
                inflate2.setTag(kVar);
                view = inflate2;
            }
            k kVar2 = (k) view.getTag();
            if (ag == 1) {
                kVar2.a.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                kVar2.b.setTextColor(resources.getColor(R.color.skin_1_common_color));
                kVar2.c.setTextColor(resources.getColor(R.color.skin_1_common_button_color));
            } else {
                kVar2.a.setBackgroundColor(-328966);
                kVar2.b.setTextColor(-13421773);
                kVar2.c.setTextColor(resources.getColor(R.color.white));
            }
            if (this.d.booleanValue()) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            return view;
        } else if (itemViewType == 2) {
            if (view == null) {
                View inflate3 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_recommend_tip, (ViewGroup) null);
                l lVar = new l(this, null);
                lVar.a = (LinearLayout) inflate3.findViewById(R.id.container);
                lVar.c = inflate3.findViewById(R.id.seperator1);
                lVar.d = inflate3.findViewById(R.id.seperator2);
                lVar.b = (TextView) inflate3.findViewById(R.id.tip_text);
                inflate3.setTag(lVar);
                view = inflate3;
            }
            l lVar2 = (l) view.getTag();
            if (ag == 1) {
                lVar2.a.setBackgroundColor(-14540254);
                lVar2.c.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
                lVar2.d.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
                lVar2.b.setTextColor(-7237231);
                return view;
            }
            lVar2.a.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
            lVar2.c.setBackgroundColor(-2960686);
            lVar2.d.setBackgroundColor(-2960686);
            lVar2.b.setTextColor(-13421773);
            return view;
        } else if (itemViewType == 4) {
            if (view == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
            }
            return view;
        } else if (itemViewType == 6) {
            if (view == null) {
                View inflate4 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                i iVar = new i(this, null);
                iVar.a = (LinearLayout) inflate4.findViewById(R.id.container);
                iVar.b = inflate4.findViewById(R.id.like_more);
                inflate4.setTag(iVar);
                view = inflate4;
            }
            i iVar2 = (i) view.getTag();
            if (ag == 1) {
                iVar2.a.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                iVar2.b.setBackgroundResource(R.drawable.button_like_more_1);
                return view;
            }
            iVar2.a.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
            iVar2.b.setBackgroundResource(R.drawable.button_like_more);
            return view;
        } else {
            if (itemViewType == 3) {
                if (view == null) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_recommand_item, (ViewGroup) null);
                    m mVar2 = new m(this, null);
                    mVar2.a = (RelativeLayout) view4;
                    mVar2.b = (TextView) view4.findViewById(R.id.recommend_forum_name);
                    mVar2.c = (TextView) view4.findViewById(R.id.member_count);
                    mVar2.d = (TextView) view4.findViewById(R.id.forum_abstract);
                    mVar2.e = (ImageView) view4.findViewById(R.id.recommend_like);
                    mVar2.f = view4.findViewById(R.id.lv_seperator);
                    mVar2.e.setOnClickListener(this.k);
                    view4.setTag(mVar2);
                } else {
                    view4 = view;
                }
                m mVar3 = (m) view4.getTag();
                if (ag == 1) {
                    mVar3.b.setTextColor(resources.getColor(R.color.skin_1_common_color));
                    mVar3.c.setTextColor(-10855846);
                    mVar3.c.setTextColor(-7697782);
                    mVar3.f.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
                    mVar3.e.setImageResource(R.drawable.add_like_1);
                    jVar = null;
                    mVar = mVar3;
                } else {
                    mVar3.b.setTextColor(-13421773);
                    mVar3.c.setTextColor(-10066330);
                    mVar3.c.setTextColor(-10066330);
                    mVar3.f.setBackgroundColor(-2960686);
                    mVar3.e.setImageResource(R.drawable.add_like);
                    jVar = null;
                    mVar = mVar3;
                }
            } else if (itemViewType != 5) {
                jVar = null;
                view4 = view;
                mVar = null;
            } else {
                if (view == null) {
                    View inflate5 = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
                    j jVar2 = new j(this, null);
                    jVar2.a = (LinearLayout) inflate5;
                    jVar2.b = (LinearLayout) inflate5.findViewById(R.id.first);
                    jVar2.b.setOnClickListener(this.h);
                    jVar2.b.setOnLongClickListener(this.i);
                    jVar2.c = (TextView) inflate5.findViewById(R.id.home_lv_like_forum1);
                    jVar2.d = (ImageView) inflate5.findViewById(R.id.home_lv_like_gimg1);
                    jVar2.e = (TextView) inflate5.findViewById(R.id.forum_lv_like_grade1);
                    jVar2.f = new j(this, null);
                    jVar2.f.b = (LinearLayout) inflate5.findViewById(R.id.second);
                    jVar2.f.b.setOnClickListener(this.h);
                    jVar2.f.b.setOnLongClickListener(this.i);
                    jVar2.f.c = (TextView) inflate5.findViewById(R.id.home_lv_like_forum2);
                    jVar2.f.d = (ImageView) inflate5.findViewById(R.id.home_lv_like_gimg2);
                    jVar2.f.e = (TextView) inflate5.findViewById(R.id.forum_lv_like_grade2);
                    inflate5.setTag(jVar2);
                    view = inflate5;
                }
                j jVar3 = (j) view.getTag();
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
                if (ag == 1) {
                    linearLayout.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                    com.baidu.tieba.c.ae.i(jVar3.b, R.drawable.home_like_item_bg_1);
                    jVar3.c.setTextColor(resources.getColor(R.color.skin_1_common_color));
                    jVar3.e.setTextColor(resources.getColor(R.color.skin_1_second_common_color));
                    com.baidu.tieba.c.ae.i(jVar3.f.b, R.drawable.home_like_item_bg_1);
                    jVar3.f.c.setTextColor(resources.getColor(R.color.skin_1_common_color));
                    jVar3.f.e.setTextColor(resources.getColor(R.color.skin_1_second_common_color));
                    mVar = null;
                    jVar = jVar3;
                    view4 = view;
                } else {
                    linearLayout.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
                    com.baidu.tieba.c.ae.i(jVar3.b, R.drawable.home_like_item_bg);
                    jVar3.c.setTextColor(-12895429);
                    jVar3.e.setTextColor(-8947332);
                    com.baidu.tieba.c.ae.i(jVar3.f.b, R.drawable.home_like_item_bg);
                    jVar3.f.c.setTextColor(-12895429);
                    jVar3.f.e.setTextColor(-8947332);
                    mVar = null;
                    jVar = jVar3;
                    view4 = view;
                }
            }
            if (itemViewType == 3 && mVar != null && this.b.d() != null) {
                Object item = getItem(i);
                com.baidu.tieba.a.y yVar = null;
                if (item != null && (item instanceof com.baidu.tieba.a.y)) {
                    yVar = (com.baidu.tieba.a.y) item;
                }
                if (yVar != null) {
                    mVar.b.setText(String.valueOf(yVar.b()) + resources.getString(R.string.forum));
                    mVar.c.setText(MessageFormat.format(resources.getString(R.string.forum_like_memeber), Integer.valueOf(yVar.c())));
                    mVar.d.setText(yVar.h());
                    mVar.e.setVisibility(this.c.booleanValue() ? 0 : 4);
                    mVar.a.setVisibility(0);
                    mVar.e.setTag(yVar);
                } else {
                    mVar.a.setVisibility(4);
                }
            }
            if (itemViewType == 5 && jVar != null && this.b.c() != null) {
                if (i == 1) {
                    jVar.a.setPadding(0, this.m, 0, this.m);
                } else {
                    jVar.a.setPadding(0, 0, 0, this.m);
                }
                if (i >= 1) {
                    if ((i - 1) * 2 < this.b.c().size()) {
                        a((com.baidu.tieba.a.y) this.b.c().get((i - 1) * 2), jVar);
                    }
                    if (((i - 1) * 2) + 1 < this.b.c().size()) {
                        jVar.f.b.setVisibility(0);
                        a((com.baidu.tieba.a.y) this.b.c().get(((i - 1) * 2) + 1), jVar.f);
                        view2 = view4;
                    } else {
                        jVar.f.b.setVisibility(4);
                        view2 = view4;
                    }
                    return view2;
                }
            }
            view2 = view4;
            return view2;
        }
    }

    private void a(com.baidu.tieba.a.y yVar, j jVar) {
        if (yVar != null && jVar != null) {
            int f = yVar.f();
            jVar.b.setTag(yVar);
            jVar.c.setText(yVar.b());
            if (f == 0 || yVar.d() == 0) {
                jVar.d.setVisibility(8);
                jVar.e.setVisibility(8);
                return;
            }
            jVar.d.setVisibility(0);
            jVar.e.setVisibility(0);
            if (1 <= f && f <= 3) {
                jVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_1));
            } else if (4 <= f && f <= 9) {
                jVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_2));
            } else if (10 <= f && f <= 15) {
                jVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_3));
            } else {
                jVar.d.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.home_grade_4));
            }
            jVar.e.setText(String.valueOf(yVar.f()).concat(this.g));
        }
    }

    private int a(int i) {
        if (!this.c.booleanValue()) {
            return 1;
        }
        if (this.b == null || this.b.c() == null || this.b.c().size() == 0) {
            return 4;
        }
        return (i == 5 && this.e.booleanValue() && !this.f.booleanValue()) ? 6 : 5;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int c = c();
        if (i == 0) {
            return 0;
        }
        if (this.b != null && this.b.d() != null && this.b.d().size() > 0) {
            if (i == c - 1) {
                return 2;
            }
            if (i >= c) {
                return 3;
            }
        }
        return a(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) == 3 || getItemViewType(i) == 6 || getItemViewType(i) == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 7;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.i = onLongClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }
}
