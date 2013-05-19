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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.a.q b = null;
    private Boolean c = false;
    private Boolean d = true;
    private Boolean e = false;
    private Boolean f;
    private View.OnClickListener g;
    private View.OnLongClickListener h;
    private View.OnClickListener i;
    private View.OnClickListener j;
    private ArrayList k;
    private int l;

    public l(Context context, com.baidu.tieba.a.q qVar) {
        this.f = false;
        this.l = 10;
        this.a = context;
        a(qVar);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = com.baidu.tieba.d.ag.a(this.a, 4.0f);
        this.k = new ArrayList();
        this.f = Boolean.valueOf(TiebaApplication.d().t() != null);
    }

    public void a() {
        if (this.k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.k.size()) {
                    try {
                        ((ProgressBar) this.k.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.k.clear();
                    return;
                }
            }
        }
    }

    public void a(com.baidu.tieba.a.q qVar) {
        this.b = qVar;
        if (qVar != null && qVar.c() != null && qVar.c().size() > 8) {
            this.e = true;
        } else {
            this.e = false;
        }
        if (qVar != null) {
            if (qVar.d() == null || qVar.d().size() == 0) {
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

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x05b4: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:121:0x05b3 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int ai;
        int itemViewType;
        Resources resources;
        View view3;
        p pVar;
        View view4;
        s sVar;
        try {
            ai = TiebaApplication.d().ai();
            itemViewType = getItemViewType(i);
            resources = this.a.getResources();
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.tieba.d.ae.b(getClass().getName(), "getView", exc.getMessage());
            return view2;
        }
        if (itemViewType == 0) {
            if (view == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_enter, (ViewGroup) null);
                n nVar = new n(this, null);
                nVar.a = (RelativeLayout) inflate.findViewById(R.id.container);
                nVar.b = (LinearLayout) inflate.findViewById(R.id.home_search_bg_layout);
                nVar.c = inflate.findViewById(R.id.lv_seperator);
                nVar.d = (ImageView) inflate.findViewById(R.id.lottery_image);
                nVar.e = (TextView) inflate.findViewById(R.id.search_bar_text);
                ViewGroup.LayoutParams layoutParams = nVar.d.getLayoutParams();
                layoutParams.width = com.baidu.tieba.d.ag.a(this.a);
                layoutParams.height = (layoutParams.width * 176) / 320;
                nVar.d.setLayoutParams(layoutParams);
                nVar.d.setOnClickListener(new m(this));
                inflate.setTag(nVar);
                view = inflate;
            }
            n nVar2 = (n) view.getTag();
            if (ai == 1) {
                com.baidu.tieba.d.ac.h(nVar2.a, (int) R.drawable.inputbox_topbg_1);
                com.baidu.tieba.d.ac.h(nVar2.b, (int) R.drawable.inputbox_top_1);
                nVar2.c.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
                nVar2.e.setHintTextColor(-11446171);
            } else {
                com.baidu.tieba.d.ac.h(nVar2.a, (int) R.drawable.inputbox_topbg);
                com.baidu.tieba.d.ac.h(nVar2.b, (int) R.drawable.inputbox_top);
                nVar2.c.setBackgroundColor(-2960686);
                nVar2.e.setHintTextColor(-5921112);
            }
            if (TiebaApplication.d().aF() != null && TiebaApplication.d().aF().a() == 1) {
                if (nVar2.d.getVisibility() != 0) {
                    nVar2.d.setVisibility(0);
                    nVar2.d.setImageResource(R.drawable.banner_image);
                    return view;
                }
                return view;
            } else if (nVar2.d.getVisibility() != 8) {
                nVar2.d.setVisibility(8);
                nVar2.d.setImageResource(0);
                return view;
            } else {
                return view;
            }
        } else if (itemViewType == 1) {
            if (view == null) {
                View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_login, (ViewGroup) null);
                q qVar = new q(this, null);
                qVar.a = (LinearLayout) inflate2.findViewById(R.id.container);
                qVar.b = (TextView) inflate2.findViewById(R.id.tip);
                qVar.c = (Button) inflate2.findViewById(R.id.want_login);
                qVar.c.setOnClickListener(this.i);
                inflate2.setTag(qVar);
                view = inflate2;
            }
            q qVar2 = (q) view.getTag();
            if (ai == 1) {
                qVar2.a.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                qVar2.b.setTextColor(-8682095);
                qVar2.c.setTextColor(-5454368);
                qVar2.c.setBackgroundResource(R.drawable.want_login_1);
            } else {
                qVar2.a.setBackgroundColor(-328966);
                qVar2.b.setTextColor(-13421773);
                qVar2.c.setTextColor(resources.getColor(R.color.white));
                qVar2.c.setBackgroundResource(R.drawable.want_login);
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
                r rVar = new r(this, null);
                rVar.a = (LinearLayout) inflate3.findViewById(R.id.container);
                rVar.b = (TextView) inflate3.findViewById(R.id.tip_text);
                inflate3.setTag(rVar);
                view = inflate3;
            }
            r rVar2 = (r) view.getTag();
            if (ai == 1) {
                com.baidu.tieba.d.ac.h(rVar2.a, (int) R.drawable.bg_title_tj_1);
                rVar2.b.setTextColor(-11446171);
                return view;
            }
            com.baidu.tieba.d.ac.h(rVar2.a, (int) R.drawable.bg_title_tj);
            rVar2.b.setTextColor(-4078909);
            return view;
        } else if (itemViewType == 4) {
            if (view == null) {
                return LayoutInflater.from(this.a).inflate(R.layout.home_like_nodata_item, (ViewGroup) null);
            }
            return view;
        } else if (itemViewType == 6) {
            if (view == null) {
                View inflate4 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_goon_show_like, (ViewGroup) null);
                o oVar = new o(this, null);
                oVar.a = (LinearLayout) inflate4.findViewById(R.id.container);
                oVar.b = inflate4.findViewById(R.id.like_more);
                inflate4.setTag(oVar);
                view = inflate4;
            }
            o oVar2 = (o) view.getTag();
            if (ai == 1) {
                oVar2.a.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                oVar2.b.setBackgroundResource(R.drawable.button_like_more_1);
                return view;
            }
            oVar2.a.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
            oVar2.b.setBackgroundResource(R.drawable.button_like_more);
            return view;
        } else {
            if (itemViewType == 3) {
                if (view == null) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.enter_forum_recommand_item, (ViewGroup) null);
                    s sVar2 = new s(this, null);
                    sVar2.a = (RelativeLayout) view4;
                    sVar2.b = (ImageViewDrawer) view4.findViewById(R.id.forum_icon);
                    sVar2.c = (TextView) view4.findViewById(R.id.recommend_forum_name);
                    sVar2.d = (TextView) view4.findViewById(R.id.forum_abstract);
                    sVar2.e = (ImageView) view4.findViewById(R.id.recommend_like);
                    sVar2.f = view4.findViewById(R.id.lv_seperator);
                    sVar2.e.setOnClickListener(this.j);
                    view4.setTag(sVar2);
                } else {
                    view4 = view;
                }
                s sVar3 = (s) view4.getTag();
                if (ai == 1) {
                    sVar3.c.setTextColor(-8682095);
                    sVar3.d.setTextColor(-11446171);
                    sVar3.f.setBackgroundColor(resources.getColor(R.color.skin_1_lv_divider_bg));
                    sVar3.e.setImageResource(R.drawable.add_like_1);
                    pVar = null;
                    sVar = sVar3;
                } else {
                    sVar3.c.setTextColor(-14277082);
                    sVar3.d.setTextColor(-6842215);
                    sVar3.f.setBackgroundColor(-2828585);
                    sVar3.e.setImageResource(R.drawable.add_like);
                    pVar = null;
                    sVar = sVar3;
                }
            } else if (itemViewType != 5) {
                pVar = null;
                view4 = view;
                sVar = null;
            } else {
                if (view == null) {
                    View inflate5 = LayoutInflater.from(this.a).inflate(R.layout.home_like_item, (ViewGroup) null);
                    p pVar2 = new p(this, null);
                    pVar2.a = (LinearLayout) inflate5;
                    pVar2.b = (LinearLayout) inflate5.findViewById(R.id.first);
                    pVar2.b.setOnClickListener(this.g);
                    pVar2.b.setOnLongClickListener(this.h);
                    pVar2.c = (TextView) inflate5.findViewById(R.id.home_lv_like_forum1);
                    pVar2.d = (TextView) inflate5.findViewById(R.id.forum_lv_like_grade1);
                    pVar2.e = new p(this, null);
                    pVar2.e.b = (LinearLayout) inflate5.findViewById(R.id.second);
                    pVar2.e.b.setOnClickListener(this.g);
                    pVar2.e.b.setOnLongClickListener(this.h);
                    pVar2.e.c = (TextView) inflate5.findViewById(R.id.home_lv_like_forum2);
                    pVar2.e.d = (TextView) inflate5.findViewById(R.id.forum_lv_like_grade2);
                    inflate5.setTag(pVar2);
                    view = inflate5;
                }
                p pVar3 = (p) view.getTag();
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
                if (ai == 1) {
                    linearLayout.setBackgroundColor(resources.getColor(R.color.skin_1_common_bg));
                    com.baidu.tieba.d.ac.h(pVar3.b, (int) R.drawable.home_like_item_bg_1);
                    pVar3.c.setTextColor(-8682095);
                    pVar3.d.setTextColor(-2235207);
                    com.baidu.tieba.d.ac.h(pVar3.e.b, (int) R.drawable.home_like_item_bg_1);
                    pVar3.e.c.setTextColor(-8682095);
                    pVar3.e.d.setTextColor(-2235207);
                    sVar = null;
                    pVar = pVar3;
                    view4 = view;
                } else {
                    linearLayout.setBackgroundColor(resources.getColor(R.color.backgroundcolor));
                    com.baidu.tieba.d.ac.h(pVar3.b, (int) R.drawable.home_like_item_bg);
                    pVar3.c.setTextColor(-14277082);
                    pVar3.d.setTextColor(-1);
                    com.baidu.tieba.d.ac.h(pVar3.e.b, (int) R.drawable.home_like_item_bg);
                    pVar3.e.c.setTextColor(-14277082);
                    pVar3.e.d.setTextColor(-1);
                    sVar = null;
                    pVar = pVar3;
                    view4 = view;
                }
            }
            if (itemViewType == 3 && sVar != null && this.b.d() != null) {
                Object item = getItem(i);
                com.baidu.tieba.a.p pVar4 = null;
                if (item != null && (item instanceof com.baidu.tieba.a.p)) {
                    pVar4 = (com.baidu.tieba.a.p) item;
                }
                if (pVar4 != null) {
                    sVar.b.setDefaultId(R.drawable.pic_avatar_ba_80);
                    sVar.b.setNightDefaultId(R.drawable.pic_avatar_ba_80_1);
                    sVar.b.setImageSearchUrl(String.valueOf(pVar4.g()) + "forum_icon_mini");
                    sVar.b.setTag(pVar4.g());
                    sVar.b.invalidate();
                    sVar.c.setText(String.valueOf(pVar4.b()) + resources.getString(R.string.forum));
                    sVar.d.setText(pVar4.f());
                    sVar.e.setVisibility(this.c.booleanValue() ? 0 : 4);
                    sVar.a.setVisibility(0);
                    sVar.e.setTag(pVar4);
                } else {
                    sVar.a.setVisibility(4);
                }
            }
            if (itemViewType == 5 && pVar != null && this.b.c() != null) {
                if (i == 1) {
                    pVar.a.setPadding(0, this.l, 0, this.l);
                } else {
                    pVar.a.setPadding(0, 0, 0, this.l);
                }
                if (i >= 1) {
                    if ((i - 1) * 2 < this.b.c().size()) {
                        a((com.baidu.tieba.a.p) this.b.c().get((i - 1) * 2), pVar);
                    }
                    if (((i - 1) * 2) + 1 < this.b.c().size()) {
                        pVar.e.b.setVisibility(0);
                        a((com.baidu.tieba.a.p) this.b.c().get(((i - 1) * 2) + 1), pVar.e);
                        view2 = view4;
                    } else {
                        pVar.e.b.setVisibility(4);
                        view2 = view4;
                    }
                    return view2;
                }
            }
            view2 = view4;
            return view2;
        }
    }

    private void a(com.baidu.tieba.a.p pVar, p pVar2) {
        if (pVar != null && pVar2 != null) {
            int d = pVar.d();
            pVar2.b.setTag(pVar);
            pVar2.c.setText(pVar.b());
            if (d == 0 || pVar.c() == 0) {
                pVar2.d.setVisibility(8);
                return;
            }
            pVar2.d.setVisibility(0);
            if (1 <= d && d <= 3) {
                pVar2.d.setBackgroundResource(R.drawable.home_grade_1);
            } else if (4 <= d && d <= 9) {
                pVar2.d.setBackgroundResource(R.drawable.home_grade_2);
            } else if (10 <= d && d <= 15) {
                pVar2.d.setBackgroundResource(R.drawable.home_grade_3);
            } else {
                pVar2.d.setBackgroundResource(R.drawable.home_grade_4);
            }
            pVar2.d.setText(String.valueOf(pVar.d()));
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
        this.g = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.h = onLongClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
