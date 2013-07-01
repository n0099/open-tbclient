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

    /* renamed from: a  reason: collision with root package name */
    private Context f830a;
    private ArrayList b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.util.a i;
    private int j;
    private int k = 200;
    private boolean l = false;
    private float m = 0.4f;
    private ArrayList h = new ArrayList();
    private boolean g = false;

    private LinearLayout a(com.baidu.tieba.data.ae aeVar, int i, int i2) {
        int i3;
        int i4;
        if (aeVar.c() != null && (aeVar.c().length() < 1 || aeVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.o oVar = new com.baidu.tieba.view.o(this.f830a, aeVar.a());
        LinearLayout linearLayout = new LinearLayout(this.f830a);
        oVar.setPicNum(i);
        int a2 = this.j - com.baidu.tieba.util.ab.a(this.f830a, 14.0f);
        int i5 = 100;
        if (i == 1) {
            if (this.l) {
                i5 = (int) (a2 * 0.5d);
                i3 = 0;
                i4 = 0;
            } else {
                int i6 = (int) (a2 * this.m);
                i5 = (int) (i6 * 0.5d);
                i4 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                i3 = com.baidu.tieba.util.ab.a(this.f830a, 7.0f);
                a2 = (i6 - i4) - i3;
            }
        } else if (i == 2) {
            a2 /= 2;
            i5 = (a2 * 2) / 3;
            if (i2 == 0) {
                int a3 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                a2 -= a3;
                i4 = a3;
                i3 = 0;
            } else {
                if (i2 == 1) {
                    i4 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                    i3 = com.baidu.tieba.util.ab.a(this.f830a, 7.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            }
        } else if (i != 3) {
            a2 = 100;
            i3 = 0;
            i4 = 0;
        } else {
            a2 /= 3;
            i5 = (a2 * 3) / 4;
            if (i2 == 0) {
                int a4 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                a2 -= a4;
                i4 = a4;
                i3 = 0;
            } else if (i2 == 1) {
                int a5 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                a2 -= a5;
                i4 = a5;
                i3 = 0;
            } else {
                if (i2 == 2) {
                    i4 = com.baidu.tieba.util.ab.a(this.f830a, 6.0f);
                    i3 = com.baidu.tieba.util.ab.a(this.f830a, 7.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, i5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i3;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        oVar.setTag(aeVar.b());
        oVar.setClickable(true);
        oVar.setFocusable(false);
        oVar.setLayoutParams(layoutParams);
        oVar.setIsWifi(this.l);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(oVar);
        if (aeVar.a() == 5) {
            oVar.setOnClickListener(new ae(this, aeVar));
        } else if (aeVar.a() == 3) {
            oVar.setClickable(false);
        }
        return linearLayout;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public void a(boolean z) {
        this.g = z;
    }

    public ad(Context context, ArrayList arrayList, int i, boolean z) {
        this.j = 200;
        this.f830a = context;
        this.b = arrayList;
        this.i = new com.baidu.tieba.util.a(this.f830a);
        this.j = i;
        b(z);
    }

    public void b(boolean z) {
        this.l = z;
        this.k = this.j;
        if (this.l) {
            if (this.k > 480) {
                this.k = 480;
            }
            if (this.k > com.baidu.tieba.util.ab.a(this.f830a, 320.0f)) {
                this.k = com.baidu.tieba.util.ab.a(this.f830a, 320.0f);
            }
            this.i.a(1);
            this.i.a("_small");
        } else {
            if (this.k > this.m * 480.0f) {
                this.k = (int) (this.m * 480.0f);
            }
            if (this.k > com.baidu.tieba.util.ab.a(this.f830a, 320.0f) * this.m) {
                this.k = (int) (com.baidu.tieba.util.ab.a(this.f830a, 320.0f) * this.m);
            }
            this.i.a(2);
            this.i.a("_mobile");
        }
        this.i.a(this.k, this.k);
    }

    public com.baidu.tieba.util.a a() {
        return this.i;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
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
                        com.baidu.tieba.util.z.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
                view3 = LayoutInflater.from(this.f830a).inflate(R.layout.frs_item, (ViewGroup) null);
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
                    afVar2.f832a = (LinearLayout) view3.findViewById(R.id.frs_lv_abstract);
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
                    com.baidu.tieba.util.z.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.f830a);
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
            int at = TiebaApplication.f().at();
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
                if (at == 1) {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.x.b(afVar.g, at);
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
                if (at == 1) {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    afVar.f.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.x.b(afVar.g, at);
                return view3;
            } else {
                afVar.i.setVisibility(0);
                afVar.f.setVisibility(8);
                afVar.h.setVisibility(8);
                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) getItem(i);
                int c = baVar.c();
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
                date.setTime(baVar.d() * 1000);
                afVar.k.setText(com.baidu.tieba.util.y.e(date));
                afVar.l.setText(baVar.n());
                com.baidu.tieba.util.w aA = TiebaApplication.f().aA();
                if (aA != null && aA.b(baVar.a())) {
                    afVar.l.setTextColor(this.f830a.getResources().getColor(R.color.read_thread_color));
                } else if (at == 1) {
                    afVar.l.setTextColor(-8682095);
                } else {
                    afVar.l.setTextColor(-16777216);
                }
                afVar.m.setText(baVar.g().getName());
                if (this.g && baVar.e() != 1) {
                    afVar.f832a.setVisibility(0);
                    afVar.e.setVisibility(0);
                    afVar.e.removeAllViews();
                    afVar.d.setVisibility(0);
                    ArrayList m = baVar.m();
                    if (baVar.j() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + baVar.j();
                    }
                    if (m != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < m.size(); i3++) {
                            if (((com.baidu.tieba.data.ae) m.get(i3)).c() != null && ((com.baidu.tieba.data.ae) m.get(i3)).c().endsWith("swf")) {
                                stringBuffer.append(((com.baidu.tieba.data.ae) m.get(i3)).c());
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
                                int i6 = (m.get(i5) == null || !(((com.baidu.tieba.data.ae) m.get(i5)).a() == 3 || ((com.baidu.tieba.data.ae) m.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < m.size() && i7 < i4) {
                                if (((com.baidu.tieba.data.ae) m.get(i8)).a() == 3 || ((com.baidu.tieba.data.ae) m.get(i8)).a() == 5) {
                                    LinearLayout a2 = a((com.baidu.tieba.data.ae) m.get(i8), i4, i7);
                                    if (a2 != null) {
                                        afVar.e.addView(a2);
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
                    afVar.f832a.setVisibility(8);
                }
                if (at == 1) {
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
