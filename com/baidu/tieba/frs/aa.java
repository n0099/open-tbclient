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
import com.baidu.tieba.a.at;
import com.baidu.tieba.view.CustomTimerView;
import com.baidu.tieba.view.FrsStarImageView;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {
    Context a;
    ArrayList b;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private com.baidu.tieba.c.a m;
    private com.baidu.tieba.c.a n;
    private int o;
    com.baidu.tieba.a.s c = null;
    String d = null;
    at e = null;
    private boolean k = false;
    private View.OnClickListener p = null;
    private ArrayList l = new ArrayList();
    private boolean j = false;

    private LinearLayout a(com.baidu.tieba.a.ad adVar, int i) {
        if (adVar.c() != null && (adVar.c().length() < 1 || adVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.a, adVar.a());
        LinearLayout linearLayout = new LinearLayout(this.a);
        if (i == 3) {
            qVar.setIsThree(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.o - com.baidu.tieba.c.ai.a(this.a, (i * 2) + 30)) / i, (this.o - com.baidu.tieba.c.ai.b(this.a, 30.0f)) / 4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        int a = com.baidu.tieba.c.ai.a(this.a, 10.0f);
        layoutParams2.rightMargin = com.baidu.tieba.c.ai.a(this.a, 2.0f);
        layoutParams2.topMargin = a;
        layoutParams2.bottomMargin = 0;
        qVar.setTag(adVar.b());
        qVar.setClickable(true);
        qVar.setFocusable(false);
        qVar.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(qVar);
        if (adVar.a() == 5) {
            qVar.setOnClickListener(new ab(this, adVar));
            return linearLayout;
        } else if (adVar.a() == 3) {
            qVar.setOnClickListener(this.p);
            return linearLayout;
        } else {
            return linearLayout;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public aa(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.m = new com.baidu.tieba.c.a(this.a);
        this.m.a("_small");
        this.m.c(true);
        this.o = i;
        i = i > com.baidu.tieba.a.i.g() ? com.baidu.tieba.a.i.g() : i;
        this.m.a(i, (i - com.baidu.tieba.c.ai.a(this.a, 6.0f)) / 4);
        this.n = new com.baidu.tieba.c.a(this.a);
        this.n.a(com.baidu.tieba.c.ai.a(this.a), com.baidu.tieba.c.ai.a(this.a));
    }

    public com.baidu.tieba.c.a a() {
        return this.m;
    }

    public com.baidu.tieba.c.a b() {
        return this.n;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean c() {
        return this.h;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean d() {
        return this.i;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public void e(boolean z) {
        this.g = z;
    }

    public void f(boolean z) {
        this.k = z;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void a(com.baidu.tieba.a.s sVar, String str) {
        this.c = sVar;
        this.d = str;
        this.e = new at();
        com.baidu.tieba.a.ad adVar = new com.baidu.tieba.a.ad();
        adVar.a(3);
        adVar.a(sVar.b());
        this.e.n().add(adVar);
        com.baidu.tieba.a.ad adVar2 = new com.baidu.tieba.a.ad();
        adVar2.a(3);
        adVar2.a(sVar.c());
        this.e.n().add(adVar2);
    }

    public at e() {
        return this.e;
    }

    public void f() {
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
            if (this.k) {
                return size + 1;
            }
            return size;
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x023c: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:27:0x023c */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        ad adVar;
        ae aeVar;
        View view4;
        String str;
        int i2;
        try {
            int itemViewType = getItemViewType(i);
            try {
                if (view == null) {
                    if (itemViewType == 0) {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
                        ae aeVar2 = new ae(this, null);
                        aeVar2.g = (LinearLayout) view4.findViewById(R.id.frs_list_item);
                        aeVar2.h = (TextView) view4.findViewById(R.id.frs_lv_reply_num);
                        aeVar2.i = (TextView) view4.findViewById(R.id.frs_lv_reply_time);
                        aeVar2.j = (TextView) view4.findViewById(R.id.frs_lv_title);
                        aeVar2.k = (TextView) view4.findViewById(R.id.frs_lv_author);
                        aeVar2.a = (LinearLayout) view4.findViewById(R.id.frs_lv_abstract);
                        aeVar2.b = (TextView) view4.findViewById(R.id.abstract_text);
                        aeVar2.c = (LinearLayout) view4.findViewById(R.id.abstract_img_layout);
                        aeVar2.l = (ImageView) view4.findViewById(R.id.frs_lv_autor_icon);
                        aeVar2.d = (RelativeLayout) view4.findViewById(R.id.frs_list_control);
                        aeVar2.e = (TextView) view4.findViewById(R.id.frs_list_control_tv);
                        aeVar2.f = (ProgressBar) view4.findViewById(R.id.frs_list_control_progress);
                        view4.setTag(aeVar2);
                        this.l.add(aeVar2.f);
                        adVar = null;
                        aeVar = aeVar2;
                    } else {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.frs_star_title, (ViewGroup) null);
                        ad adVar2 = new ad(this, null);
                        adVar2.a = (FrsStarImageView) view4.findViewById(R.id.frs_star_top_pic);
                        adVar2.c = (FrsStarImageView) view4.findViewById(R.id.frs_star_photo);
                        adVar2.a.setImageType(0);
                        adVar2.c.setImageType(1);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adVar2.a.getLayoutParams();
                        layoutParams.width = com.baidu.tieba.c.ai.a(this.a);
                        if (this.c.d() == 0) {
                            layoutParams.height = 1;
                        } else {
                            layoutParams.height = (layoutParams.width * this.c.e()) / this.c.d();
                        }
                        adVar2.a.setLayoutParams(layoutParams);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adVar2.c.getLayoutParams();
                        layoutParams2.width = com.baidu.tieba.c.ai.a(this.a) / 4;
                        if (this.c.f() == 0) {
                            layoutParams2.height = layoutParams2.width;
                        } else {
                            layoutParams2.height = (layoutParams2.width * this.c.g()) / this.c.f();
                        }
                        adVar2.c.setLayoutParams(layoutParams2);
                        adVar2.a.setTag(this.c.b());
                        adVar2.c.setTag(this.c.c());
                        adVar2.b = (TextView) view4.findViewById(R.id.add_fan_tip);
                        adVar2.d = (RelativeLayout) view4.findViewById(R.id.frs_star_text_layout);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) adVar2.d.getLayoutParams();
                        layoutParams3.leftMargin = layoutParams2.width + layoutParams2.leftMargin + com.baidu.tieba.c.ai.a(this.a, 13.0f);
                        adVar2.d.setLayoutParams(layoutParams3);
                        adVar2.e = (TextView) view4.findViewById(R.id.frs_star_text1);
                        adVar2.f = (Button) view4.findViewById(R.id.add_fan);
                        adVar2.f.setOnClickListener(new ac(this));
                        adVar2.g = (TextView) view4.findViewById(R.id.fan_num);
                        adVar2.h = (CustomTimerView) view4.findViewById(R.id.open_timer);
                        adVar2.h.setTitle(R.string.star_timer_title);
                        adVar2.h.setTitleSize(15);
                        adVar2.h.setTitleColor(-8289919);
                        adVar2.h.setTextSize(14);
                        adVar2.h.setTextColor(-8289919);
                        adVar2.h.setNumSize(14);
                        adVar2.h.setNumColor(-16749848);
                        adVar2.h.setTextMargin(12);
                        adVar2.h.setNumMargin(6);
                        view4.setTag(adVar2);
                        adVar = adVar2;
                        aeVar = null;
                    }
                } else if (itemViewType == 0) {
                    aeVar = (ae) view.getTag();
                    view4 = view;
                    adVar = null;
                } else {
                    adVar = (ad) view.getTag();
                    aeVar = null;
                    view4 = view;
                }
                int ag = TiebaApplication.b().ag();
                long itemId = getItemId(i);
                if (itemId == -1) {
                    aeVar.g.setVisibility(8);
                    aeVar.d.setVisibility(0);
                    if (this.i) {
                        aeVar.e.setText(R.string.loading);
                        aeVar.f.setVisibility(0);
                    } else {
                        aeVar.e.setText(R.string.frs_pre);
                        aeVar.f.setVisibility(8);
                    }
                    com.baidu.tieba.c.ae.b(aeVar.e, ag);
                    return view4;
                } else if (itemId == -2) {
                    aeVar.g.setVisibility(8);
                    aeVar.d.setVisibility(0);
                    if (this.h) {
                        aeVar.e.setText(R.string.loading);
                        aeVar.f.setVisibility(0);
                    } else {
                        aeVar.e.setText(R.string.frs_next);
                        aeVar.f.setVisibility(8);
                    }
                    com.baidu.tieba.c.ae.b(aeVar.e, ag);
                    return view4;
                } else if (itemId == -3) {
                    if (this.c.h() == 0) {
                        adVar.g.setVisibility(8);
                        adVar.f.setVisibility(8);
                        adVar.h.setVisibility(0);
                        adVar.d.setVisibility(8);
                        adVar.b.setVisibility(0);
                        return view4;
                    }
                    adVar.d.setVisibility(0);
                    adVar.b.setVisibility(8);
                    if (this.c.j() == 0) {
                        adVar.g.setVisibility(8);
                        adVar.h.setVisibility(8);
                        adVar.f.setVisibility(0);
                        adVar.e.setText(R.string.click_get);
                        return view4;
                    }
                    adVar.f.setVisibility(8);
                    adVar.h.setVisibility(8);
                    adVar.g.setVisibility(0);
                    adVar.g.setText(String.valueOf(this.c.k()));
                    adVar.e.setText("我的" + this.d + "吧");
                    return view4;
                } else {
                    aeVar.g.setVisibility(0);
                    aeVar.d.setVisibility(8);
                    aeVar.f.setVisibility(8);
                    at atVar = (at) getItem(i);
                    int d = atVar.d();
                    if (d <= 999) {
                        if (d > 0) {
                            aeVar.l.setVisibility(0);
                            aeVar.h.setText(String.valueOf(d));
                        } else {
                            aeVar.l.setVisibility(8);
                            aeVar.h.setText((CharSequence) null);
                        }
                    } else {
                        aeVar.h.setText("999+");
                    }
                    Date date = new Date();
                    date.setTime(atVar.e() * 1000);
                    aeVar.i.setText(com.baidu.tieba.c.af.e(date));
                    aeVar.j.setText(atVar.o());
                    com.baidu.tieba.c.ab am = TiebaApplication.b().am();
                    if (am != null && am.b(atVar.a())) {
                        aeVar.j.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                    } else {
                        com.baidu.tieba.c.ae.b(aeVar.j, ag);
                    }
                    aeVar.k.setText(atVar.h().b());
                    if (this.j && atVar.f() != 1) {
                        aeVar.a.setVisibility(0);
                        aeVar.c.setVisibility(0);
                        aeVar.c.removeAllViews();
                        aeVar.b.setVisibility(0);
                        ArrayList n = atVar.n();
                        if (atVar.l() == null) {
                            str = "";
                        } else {
                            str = String.valueOf("") + atVar.l();
                        }
                        if (n != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i3 = 0; i3 < n.size(); i3++) {
                                if (((com.baidu.tieba.a.ad) n.get(i3)).c() != null && ((com.baidu.tieba.a.ad) n.get(i3)).c().endsWith("swf")) {
                                    stringBuffer.append(((com.baidu.tieba.a.ad) n.get(i3)).c());
                                }
                            }
                            String str2 = String.valueOf(str) + stringBuffer.toString();
                            if (str2 != null && str2.length() > 1) {
                                aeVar.b.setText(str2);
                            } else {
                                aeVar.b.setVisibility(8);
                            }
                            if (n.size() > 0) {
                                int i4 = 0;
                                int i5 = 0;
                                while (i5 < n.size()) {
                                    int i6 = (n.get(i5) == null || !(((com.baidu.tieba.a.ad) n.get(i5)).a() == 3 || ((com.baidu.tieba.a.ad) n.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                    i5++;
                                    i4 = i6;
                                }
                                if (i4 > 3) {
                                    i4 = 3;
                                }
                                int i7 = 0;
                                int i8 = 0;
                                while (i8 < n.size() && i7 < i4) {
                                    if (((com.baidu.tieba.a.ad) n.get(i8)).a() == 3 || ((com.baidu.tieba.a.ad) n.get(i8)).a() == 5) {
                                        LinearLayout a = a((com.baidu.tieba.a.ad) n.get(i8), i4);
                                        if (a != null) {
                                            aeVar.c.addView(a);
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
                            } else {
                                aeVar.c.setVisibility(8);
                            }
                        }
                    } else {
                        aeVar.a.setVisibility(8);
                    }
                    if (ag == 1) {
                        aeVar.b.setTextColor(this.a.getResources().getColor(R.color.skin_1_second_common_color));
                        aeVar.k.setTextColor(this.a.getResources().getColor(R.color.skin_1_third_common_color));
                        aeVar.i.setTextColor(this.a.getResources().getColor(R.color.skin_1_third_common_color));
                        return view4;
                    }
                    aeVar.b.setTextColor(-6710887);
                    aeVar.k.setTextColor(-5066062);
                    aeVar.i.setTextColor(-5066062);
                    return view4;
                }
            } catch (Exception e) {
                e = e;
                view2 = view3;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                if (view2 == null) {
                    TextView textView = new TextView(this.a);
                    textView.setVisibility(8);
                    textView.setHeight(0);
                    return textView;
                }
                return view2;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }
}
