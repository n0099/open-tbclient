package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.d.a i;
    private int j;
    private ArrayList h = new ArrayList();
    private boolean g = false;

    private LinearLayout a(com.baidu.tieba.a.ag agVar, int i, int i2) {
        int i3;
        int i4;
        if (agVar.c() != null && (agVar.c().length() < 1 || agVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.p pVar = new com.baidu.tieba.view.p(this.a, agVar.a());
        LinearLayout linearLayout = new LinearLayout(this.a);
        pVar.setPicNum(i);
        int a = this.j - com.baidu.tieba.d.ag.a(this.a, 14.0f);
        int i5 = 100;
        if (i == 1) {
            i5 = (int) (a * 0.618d);
            i4 = 0;
            i3 = 0;
        } else if (i == 2) {
            a /= 2;
            i5 = (a * 2) / 3;
            if (i2 == 0) {
                int a2 = com.baidu.tieba.d.ag.a(this.a, 6.0f);
                a -= a2;
                i3 = a2;
                i4 = 0;
            } else {
                if (i2 == 1) {
                    i3 = com.baidu.tieba.d.ag.a(this.a, 6.0f);
                    i4 = com.baidu.tieba.d.ag.a(this.a, 7.0f);
                    a = (a - i3) - i4;
                }
                i4 = 0;
                i3 = 0;
            }
        } else if (i != 3) {
            a = 100;
            i3 = 0;
            i4 = 0;
        } else {
            a /= 3;
            i5 = (a * 3) / 4;
            if (i2 == 0) {
                int a3 = com.baidu.tieba.d.ag.a(this.a, 6.0f);
                a -= a3;
                i3 = a3;
                i4 = 0;
            } else if (i2 == 1) {
                int a4 = com.baidu.tieba.d.ag.a(this.a, 6.0f);
                a -= a4;
                i3 = a4;
                i4 = 0;
            } else {
                if (i2 == 2) {
                    i3 = com.baidu.tieba.d.ag.a(this.a, 6.0f);
                    i4 = com.baidu.tieba.d.ag.a(this.a, 7.0f);
                    a = (a - i3) - i4;
                }
                i4 = 0;
                i3 = 0;
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, i5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, -2);
        layoutParams2.leftMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        pVar.setTag(agVar.b());
        pVar.setClickable(true);
        pVar.setFocusable(false);
        pVar.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(pVar);
        if (agVar.a() == 5) {
            pVar.setOnClickListener(new ae(this, agVar));
        } else if (agVar.a() == 3) {
            pVar.setClickable(false);
        }
        return linearLayout;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public void a(boolean z) {
        this.g = z;
    }

    public ad(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.i = new com.baidu.tieba.d.a(this.a);
        this.i.a("_small");
        if (com.baidu.tieba.d.w.c(this.a) == com.baidu.tieba.d.z.WIFI) {
            this.i.a(1);
        } else {
            this.i.a(2);
        }
        this.j = i;
        i = i > com.baidu.tieba.a.i.g() ? com.baidu.tieba.a.i.g() : i;
        this.i.a(i, i / 2);
    }

    public com.baidu.tieba.d.a a() {
        return this.i;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void d() {
        if (this.h != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.h.size()) {
                    try {
                        ((ProgressBar) this.h.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.h.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.c) {
                size++;
            }
            if (this.d) {
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
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        af afVar;
        View view3;
        String str;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.frs_item, (ViewGroup) null);
                try {
                    af afVar2 = new af(this, null);
                    afVar2.i = (LinearLayout) view3.findViewById(R.id.frs_list_item);
                    afVar2.b = (LinearLayout) view3.findViewById(R.id.frs_list_item_top);
                    afVar2.c = (RelativeLayout) view3.findViewById(R.id.item_bottom_layout);
                    afVar2.j = (TextView) view3.findViewById(R.id.frs_lv_reply_num);
                    afVar2.n = (ImageView) view3.findViewById(R.id.frs_discuss_icon);
                    afVar2.o = (ImageView) view3.findViewById(R.id.author_icon);
                    afVar2.k = (TextView) view3.findViewById(R.id.frs_lv_reply_time);
                    afVar2.l = (TextView) view3.findViewById(R.id.frs_lv_title);
                    afVar2.m = (TextView) view3.findViewById(R.id.frs_lv_author);
                    afVar2.a = (LinearLayout) view3.findViewById(R.id.frs_lv_abstract);
                    afVar2.d = (TextView) view3.findViewById(R.id.abstract_text);
                    afVar2.e = (LinearLayout) view3.findViewById(R.id.abstract_img_layout);
                    afVar2.f = (RelativeLayout) view3.findViewById(R.id.frs_list_control);
                    afVar2.g = (TextView) view3.findViewById(R.id.frs_list_control_tv);
                    afVar2.h = (ProgressBar) view3.findViewById(R.id.frs_list_control_progress);
                    view3.setTag(afVar2);
                    this.h.add(afVar2.h);
                    afVar = afVar2;
                } catch (Exception e) {
                    e = e;
                    view2 = view3;
                    com.baidu.tieba.d.ae.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.a);
                        textView.setVisibility(8);
                        textView.setHeight(0);
                        return textView;
                    }
                    return view2;
                }
            } else {
                afVar = (af) view.getTag();
                view3 = view;
            }
            int ai = TiebaApplication.d().ai();
            long itemId = getItemId(i);
            if (itemId == -1) {
                afVar.i.setVisibility(8);
                afVar.f.setVisibility(0);
                if (this.f) {
                    afVar.g.setText(R.string.loading);
                    afVar.h.setVisibility(0);
                } else {
                    afVar.g.setText(R.string.frs_pre);
                    afVar.h.setVisibility(8);
                }
                if (ai == 1) {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.f.setBackgroundResource(R.drawable.btn_register);
                }
                com.baidu.tieba.d.ac.b(afVar.g, ai);
                return view3;
            } else if (itemId == -2) {
                afVar.i.setVisibility(8);
                afVar.f.setVisibility(0);
                if (this.e) {
                    afVar.g.setText(R.string.loading);
                    afVar.h.setVisibility(0);
                } else {
                    afVar.g.setText(R.string.frs_next);
                    afVar.h.setVisibility(8);
                }
                if (ai == 1) {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.f.setBackgroundResource(R.drawable.btn_register);
                }
                com.baidu.tieba.d.ac.b(afVar.g, ai);
                return view3;
            } else {
                afVar.i.setVisibility(0);
                afVar.f.setVisibility(8);
                afVar.h.setVisibility(8);
                com.baidu.tieba.a.bb bbVar = (com.baidu.tieba.a.bb) getItem(i);
                int c = bbVar.c();
                afVar.n.setVisibility(0);
                if (c <= 999999) {
                    if (c > 0) {
                        afVar.j.setText(String.valueOf(c));
                    } else {
                        afVar.j.setText((CharSequence) null);
                        afVar.n.setVisibility(4);
                    }
                } else {
                    afVar.j.setText("999999+");
                }
                Date date = new Date();
                date.setTime(bbVar.d() * 1000);
                afVar.k.setText(com.baidu.tieba.d.ad.d(date));
                afVar.l.setText(bbVar.n());
                com.baidu.tieba.d.ab ap = TiebaApplication.d().ap();
                if (ap != null && ap.b(bbVar.a())) {
                    afVar.l.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                } else if (ai == 1) {
                    afVar.l.setTextColor(-8682095);
                } else {
                    afVar.l.setTextColor(-16777216);
                }
                afVar.m.setText(bbVar.g().c());
                if (this.g && bbVar.e() != 1) {
                    afVar.a.setVisibility(0);
                    afVar.e.setVisibility(0);
                    afVar.e.removeAllViews();
                    afVar.d.setVisibility(0);
                    ArrayList m = bbVar.m();
                    if (bbVar.j() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + bbVar.j();
                    }
                    if (m != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < m.size(); i3++) {
                            if (((com.baidu.tieba.a.ag) m.get(i3)).c() != null && ((com.baidu.tieba.a.ag) m.get(i3)).c().endsWith("swf")) {
                                stringBuffer.append(((com.baidu.tieba.a.ag) m.get(i3)).c());
                            }
                        }
                        String str2 = String.valueOf(str) + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            afVar.d.setText(str2);
                        } else {
                            afVar.d.setVisibility(8);
                        }
                        if (m.size() > 0) {
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < m.size()) {
                                int i6 = (m.get(i5) == null || !(((com.baidu.tieba.a.ag) m.get(i5)).a() == 3 || ((com.baidu.tieba.a.ag) m.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < m.size() && i7 < i4) {
                                if (((com.baidu.tieba.a.ag) m.get(i8)).a() == 3 || ((com.baidu.tieba.a.ag) m.get(i8)).a() == 5) {
                                    LinearLayout a = a((com.baidu.tieba.a.ag) m.get(i8), i4, i7);
                                    if (a != null) {
                                        afVar.e.addView(a);
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
                            afVar.e.setVisibility(8);
                        }
                    }
                } else {
                    afVar.a.setVisibility(8);
                }
                if (ai == 1) {
                    afVar.b.setBackgroundResource(R.drawable.bg_list_top_1);
                    afVar.c.setBackgroundResource(R.drawable.bg_list_bottom_1);
                    afVar.d.setTextColor(-10523526);
                    afVar.g.setTextColor(-10523526);
                    afVar.j.setTextColor(-9207399);
                    afVar.m.setTextColor(-11446171);
                    afVar.k.setTextColor(-11446171);
                    afVar.n.setBackgroundResource(R.drawable.icon_little_comment_1);
                    afVar.o.setBackgroundResource(R.drawable.icon_little_people_1);
                    return view3;
                }
                afVar.b.setBackgroundResource(R.drawable.bg_list_top);
                afVar.c.setBackgroundResource(R.drawable.bg_list_bottom);
                afVar.d.setTextColor(-6710887);
                afVar.g.setTextColor(-6710887);
                afVar.j.setTextColor(-5066062);
                afVar.m.setTextColor(-5066062);
                afVar.k.setTextColor(-5066062);
                afVar.n.setBackgroundResource(R.drawable.icon_little_comment);
                afVar.o.setBackgroundResource(R.drawable.icon_little_people);
                return view3;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }
}
