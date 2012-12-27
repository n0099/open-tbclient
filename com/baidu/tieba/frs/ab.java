package com.baidu.tieba.frs;

import android.content.Context;
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
import com.baidu.tieba.a.as;
import com.baidu.tieba.view.CustomTimerView;
import com.baidu.tieba.view.FrsStarImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    Context a;
    ArrayList b;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private com.baidu.tieba.c.a m;
    private com.baidu.tieba.c.a n;
    private int o;
    com.baidu.tieba.a.r c = null;
    String d = null;
    as e = null;
    private boolean k = false;
    private View.OnClickListener p = null;
    private ArrayList l = new ArrayList();
    private boolean j = false;

    public ab(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.m = new com.baidu.tieba.c.a(this.a);
        this.m.a("_small");
        this.m.c(true);
        this.o = i;
        i = i > com.baidu.tieba.a.h.g() ? com.baidu.tieba.a.h.g() : i;
        this.m.a(i, (i - com.baidu.tieba.c.ag.a(this.a, 6.0f)) / 4);
        this.n = new com.baidu.tieba.c.a(this.a);
        this.n.a(com.baidu.tieba.c.ag.a(this.a), com.baidu.tieba.c.ag.a(this.a));
    }

    private LinearLayout a(com.baidu.tieba.a.af afVar, int i) {
        if (afVar.c() == null || (afVar.c().length() >= 1 && !afVar.c().endsWith("swf"))) {
            com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.a, afVar.a());
            LinearLayout linearLayout = new LinearLayout(this.a);
            if (i == 3) {
                qVar.setIsThree(true);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.o - com.baidu.tieba.c.ag.a(this.a, (i * 2) + 30)) / i, (this.o - com.baidu.tieba.c.ag.b(this.a, 30.0f)) / 4);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            int a = com.baidu.tieba.c.ag.a(this.a, 10.0f);
            layoutParams2.rightMargin = com.baidu.tieba.c.ag.a(this.a, 2.0f);
            layoutParams2.topMargin = a;
            layoutParams2.bottomMargin = 0;
            qVar.setTag(afVar.b());
            qVar.setClickable(true);
            qVar.setFocusable(false);
            qVar.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.addView(qVar);
            if (afVar.a() == 5) {
                qVar.setOnClickListener(new ac(this, afVar));
                return linearLayout;
            } else if (afVar.a() == 3) {
                qVar.setOnClickListener(this.p);
                return linearLayout;
            } else {
                return linearLayout;
            }
        }
        return null;
    }

    public com.baidu.tieba.c.a a() {
        return this.m;
    }

    public void a(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void a(com.baidu.tieba.a.r rVar, String str) {
        this.c = rVar;
        this.d = str;
        this.e = new as();
        com.baidu.tieba.a.af afVar = new com.baidu.tieba.a.af();
        afVar.a(3);
        afVar.a(rVar.b());
        this.e.n().add(afVar);
        com.baidu.tieba.a.af afVar2 = new com.baidu.tieba.a.af();
        afVar2.a(3);
        afVar2.a(rVar.c());
        this.e.n().add(afVar2);
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public com.baidu.tieba.c.a b() {
        return this.n;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean c() {
        return this.h;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public boolean d() {
        return this.i;
    }

    public as e() {
        return this.e;
    }

    public void e(boolean z) {
        this.g = z;
    }

    public void f() {
        if (this.l == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.size()) {
                this.l.clear();
                return;
            }
            try {
                ((ProgressBar) this.l.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void f(boolean z) {
        this.k = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.f) {
                size++;
            }
            if (this.g) {
                size++;
            }
            return this.k ? size + 1 : size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.k ? i - 1 : i;
        if (this.f) {
            i2--;
        }
        if (this.g && i == getCount() - 1) {
            i2 = -2;
        }
        if (this.k && i == 0) {
            i2 = -3;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -3 ? 1 : 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x022f: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:26:0x022f */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int itemViewType;
        View view3;
        ae aeVar;
        af afVar;
        View view4;
        int i2;
        try {
            itemViewType = getItemViewType(i);
        } catch (Exception e) {
            e = e;
            view2 = view;
        }
        try {
            if (view == null) {
                if (itemViewType == 0) {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
                    af afVar2 = new af(this, null);
                    afVar2.g = (LinearLayout) view4.findViewById(R.id.frs_list_item);
                    afVar2.h = (TextView) view4.findViewById(R.id.frs_lv_reply_num);
                    afVar2.i = (TextView) view4.findViewById(R.id.frs_lv_reply_time);
                    afVar2.j = (TextView) view4.findViewById(R.id.frs_lv_title);
                    afVar2.k = (TextView) view4.findViewById(R.id.frs_lv_author);
                    afVar2.a = (LinearLayout) view4.findViewById(R.id.frs_lv_abstract);
                    afVar2.b = (TextView) view4.findViewById(R.id.abstract_text);
                    afVar2.c = (LinearLayout) view4.findViewById(R.id.abstract_img_layout);
                    afVar2.l = (ImageView) view4.findViewById(R.id.frs_lv_autor_icon);
                    afVar2.d = (RelativeLayout) view4.findViewById(R.id.frs_list_control);
                    afVar2.e = (TextView) view4.findViewById(R.id.frs_list_control_tv);
                    afVar2.f = (ProgressBar) view4.findViewById(R.id.frs_list_control_progress);
                    view4.setTag(afVar2);
                    this.l.add(afVar2.f);
                    aeVar = null;
                    afVar = afVar2;
                } else {
                    view4 = LayoutInflater.from(this.a).inflate(R.layout.frs_star_title, (ViewGroup) null);
                    ae aeVar2 = new ae(this, null);
                    aeVar2.a = (FrsStarImageView) view4.findViewById(R.id.frs_star_top_pic);
                    aeVar2.c = (FrsStarImageView) view4.findViewById(R.id.frs_star_photo);
                    aeVar2.a.setImageType(0);
                    aeVar2.c.setImageType(1);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aeVar2.a.getLayoutParams();
                    layoutParams.width = com.baidu.tieba.c.ag.a(this.a);
                    if (this.c.d() == 0) {
                        layoutParams.height = 1;
                    } else {
                        layoutParams.height = (layoutParams.width * this.c.e()) / this.c.d();
                    }
                    aeVar2.a.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aeVar2.c.getLayoutParams();
                    layoutParams2.width = com.baidu.tieba.c.ag.a(this.a) / 4;
                    if (this.c.f() == 0) {
                        layoutParams2.height = layoutParams2.width;
                    } else {
                        layoutParams2.height = (layoutParams2.width * this.c.g()) / this.c.f();
                    }
                    aeVar2.c.setLayoutParams(layoutParams2);
                    aeVar2.a.setTag(this.c.b());
                    aeVar2.c.setTag(this.c.c());
                    aeVar2.b = (TextView) view4.findViewById(R.id.add_fan_tip);
                    aeVar2.d = (RelativeLayout) view4.findViewById(R.id.frs_star_text_layout);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aeVar2.d.getLayoutParams();
                    layoutParams3.leftMargin = layoutParams2.width + layoutParams2.leftMargin + com.baidu.tieba.c.ag.a(this.a, 13.0f);
                    aeVar2.d.setLayoutParams(layoutParams3);
                    aeVar2.e = (TextView) view4.findViewById(R.id.frs_star_text1);
                    aeVar2.f = (Button) view4.findViewById(R.id.add_fan);
                    aeVar2.f.setOnClickListener(new ad(this));
                    aeVar2.g = (TextView) view4.findViewById(R.id.fan_num);
                    aeVar2.h = (CustomTimerView) view4.findViewById(R.id.open_timer);
                    aeVar2.h.setTitle(R.string.star_timer_title);
                    aeVar2.h.setTitleSize(15);
                    aeVar2.h.setTitleColor(-8289919);
                    aeVar2.h.setTextSize(14);
                    aeVar2.h.setTextColor(-8289919);
                    aeVar2.h.setNumSize(14);
                    aeVar2.h.setNumColor(-16749848);
                    aeVar2.h.setTextMargin(12);
                    aeVar2.h.setNumMargin(6);
                    view4.setTag(aeVar2);
                    aeVar = aeVar2;
                    afVar = null;
                }
            } else if (itemViewType == 0) {
                afVar = (af) view.getTag();
                view4 = view;
                aeVar = null;
            } else {
                aeVar = (ae) view.getTag();
                afVar = null;
                view4 = view;
            }
            long itemId = getItemId(i);
            if (itemId == -1) {
                afVar.g.setVisibility(8);
                afVar.d.setVisibility(0);
                if (this.i) {
                    afVar.e.setText(R.string.loading);
                    afVar.f.setVisibility(0);
                    return view4;
                }
                afVar.e.setText(R.string.frs_pre);
                afVar.f.setVisibility(8);
                return view4;
            } else if (itemId == -2) {
                afVar.g.setVisibility(8);
                afVar.d.setVisibility(0);
                if (this.h) {
                    afVar.e.setText(R.string.loading);
                    afVar.f.setVisibility(0);
                    return view4;
                }
                afVar.e.setText(R.string.frs_next);
                afVar.f.setVisibility(8);
                return view4;
            } else if (itemId == -3) {
                if (this.c.h() == 0) {
                    aeVar.g.setVisibility(8);
                    aeVar.f.setVisibility(8);
                    aeVar.h.setVisibility(0);
                    aeVar.d.setVisibility(8);
                    aeVar.b.setVisibility(0);
                    return view4;
                }
                aeVar.d.setVisibility(0);
                aeVar.b.setVisibility(8);
                if (this.c.j() == 0) {
                    aeVar.g.setVisibility(8);
                    aeVar.h.setVisibility(8);
                    aeVar.f.setVisibility(0);
                    aeVar.e.setText(R.string.click_get);
                    return view4;
                }
                aeVar.f.setVisibility(8);
                aeVar.h.setVisibility(8);
                aeVar.g.setVisibility(0);
                aeVar.g.setText(String.valueOf(this.c.k()));
                aeVar.e.setText("我的" + this.d + "吧");
                return view4;
            } else {
                afVar.g.setVisibility(0);
                afVar.d.setVisibility(8);
                afVar.f.setVisibility(8);
                as asVar = (as) getItem(i);
                int d = asVar.d();
                if (d > 999) {
                    afVar.h.setText("999+");
                } else if (d > 0) {
                    afVar.l.setVisibility(0);
                    afVar.h.setText(String.valueOf(d));
                } else {
                    afVar.l.setVisibility(8);
                    afVar.h.setText((CharSequence) null);
                }
                Date date = new Date();
                date.setTime(asVar.e() * 1000);
                afVar.i.setText(com.baidu.tieba.c.ad.d(date));
                afVar.j.setText(asVar.o());
                afVar.j.setTextColor(-16777216);
                com.baidu.tieba.c.aa ai = TiebaApplication.a().ai();
                if (ai != null && ai.b(asVar.a())) {
                    afVar.j.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                }
                afVar.k.setText(asVar.h().b());
                if (!this.j || asVar.f() == 1) {
                    afVar.a.setVisibility(8);
                    return view4;
                }
                afVar.a.setVisibility(0);
                afVar.c.setVisibility(0);
                afVar.b.setVisibility(0);
                ArrayList n = asVar.n();
                String str = asVar.l() != null ? String.valueOf("") + asVar.l() : "";
                if (n != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i3 = 0; i3 < n.size(); i3++) {
                        if (((com.baidu.tieba.a.af) n.get(i3)).c() != null && ((com.baidu.tieba.a.af) n.get(i3)).c().endsWith("swf")) {
                            stringBuffer.append(((com.baidu.tieba.a.af) n.get(i3)).c());
                        }
                    }
                    String str2 = String.valueOf(str) + stringBuffer.toString();
                    if (str2 == null || str2.length() <= 1) {
                        afVar.b.setVisibility(8);
                    } else {
                        afVar.b.setText(str2);
                    }
                    if (n.size() <= 0) {
                        afVar.c.setVisibility(8);
                        return view4;
                    }
                    afVar.c.removeAllViews();
                    int i4 = 0;
                    int i5 = 0;
                    while (i5 < n.size()) {
                        int i6 = (n.get(i5) == null || !(((com.baidu.tieba.a.af) n.get(i5)).a() == 3 || ((com.baidu.tieba.a.af) n.get(i5)).a() == 5)) ? i4 : i4 + 1;
                        i5++;
                        i4 = i6;
                    }
                    if (i4 > 3) {
                        i4 = 3;
                    }
                    int i7 = 0;
                    int i8 = 0;
                    while (i8 < n.size()) {
                        if (i7 >= i4) {
                            return view4;
                        }
                        if (((com.baidu.tieba.a.af) n.get(i8)).a() == 3 || ((com.baidu.tieba.a.af) n.get(i8)).a() == 5) {
                            LinearLayout a = a((com.baidu.tieba.a.af) n.get(i8), i4);
                            if (a != null) {
                                afVar.c.addView(a);
                                i2 = i7 + 1;
                            } else {
                                i2 = i7;
                            }
                        } else {
                            i2 = i7;
                        }
                        i8++;
                        i7 = i2;
                    }
                }
                return view4;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view3;
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
            if (view2 == null) {
                TextView textView = new TextView(this.a);
                textView.setVisibility(8);
                textView.setHeight(0);
                return textView;
            }
            return view2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
