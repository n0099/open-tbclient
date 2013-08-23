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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class af extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1068a;
    private ArrayList b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.util.a i;
    private int j;
    private boolean l;
    private int k = 200;
    private float m = 0.4f;
    private ArrayList h = new ArrayList();
    private boolean g = false;

    private LinearLayout a(com.baidu.tieba.data.ai aiVar, int i, int i2) {
        int i3;
        int i4;
        if (aiVar.c() != null && (aiVar.c().length() < 1 || aiVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.z zVar = new com.baidu.tieba.view.z(this.f1068a, aiVar.a());
        LinearLayout linearLayout = new LinearLayout(this.f1068a);
        zVar.setPicNum(i);
        int a2 = this.j - UtilHelper.a(this.f1068a, 14.0f);
        int i5 = 100;
        if (i == 1) {
            if (this.l) {
                i5 = (int) (a2 * 0.5d);
                i3 = 0;
                i4 = 0;
            } else {
                int i6 = (int) (a2 * this.m);
                i5 = (int) (i6 * 0.5d);
                i4 = UtilHelper.a(this.f1068a, 6.0f);
                i3 = UtilHelper.a(this.f1068a, 7.0f);
                a2 = (i6 - i4) - i3;
            }
        } else if (i == 2) {
            a2 /= 2;
            i5 = (a2 * 2) / 3;
            if (i2 != 0) {
                if (i2 == 1) {
                    i4 = UtilHelper.a(this.f1068a, 6.0f);
                    i3 = UtilHelper.a(this.f1068a, 7.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            } else {
                int a3 = UtilHelper.a(this.f1068a, 6.0f);
                a2 -= a3;
                i4 = a3;
                i3 = 0;
            }
        } else if (i != 3) {
            a2 = 100;
            i3 = 0;
            i4 = 0;
        } else {
            a2 /= 3;
            i5 = (a2 * 3) / 4;
            if (i2 == 0) {
                int a4 = UtilHelper.a(this.f1068a, 6.0f);
                a2 -= a4;
                i4 = a4;
                i3 = 0;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    i4 = UtilHelper.a(this.f1068a, 6.0f);
                    i3 = UtilHelper.a(this.f1068a, 7.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = 0;
            } else {
                int a5 = UtilHelper.a(this.f1068a, 6.0f);
                a2 -= a5;
                i4 = a5;
                i3 = 0;
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, i5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i3;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        zVar.setTag(aiVar.b());
        zVar.setClickable(true);
        zVar.setFocusable(false);
        zVar.setLayoutParams(layoutParams);
        zVar.setIsWifi(this.l);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(zVar);
        if (aiVar.a() == 5) {
            zVar.setOnClickListener(new ag(this, aiVar));
        } else if (aiVar.a() == 3) {
            zVar.setClickable(false);
        }
        return linearLayout;
    }

    public void a(View.OnClickListener onClickListener) {
    }

    public void a(boolean z) {
        this.g = z;
    }

    public af(Context context, ArrayList arrayList, int i, boolean z) {
        this.j = 200;
        this.l = false;
        this.f1068a = context;
        this.b = arrayList;
        this.i = new com.baidu.tieba.util.a(this.f1068a);
        this.j = i;
        this.l = z;
        b(z);
    }

    public void b(boolean z) {
        if (this.l != z) {
            this.l = z;
            if (this.l) {
                UtilHelper.a(this.f1068a, this.f1068a.getResources().getString(R.string.close_flow_mode));
            } else {
                UtilHelper.a(this.f1068a, this.f1068a.getResources().getString(R.string.open_flow_mode));
            }
        }
        this.k = this.j;
        if (this.l) {
            if (this.k > 480) {
                this.k = 480;
            }
            if (this.k > UtilHelper.a(this.f1068a, 320.0f)) {
                this.k = UtilHelper.a(this.f1068a, 320.0f);
            }
            this.i.a(1);
            this.i.b("_small");
        } else {
            if (this.k > this.m * 480.0f) {
                this.k = (int) (this.m * 480.0f);
            }
            if (this.k > UtilHelper.a(this.f1068a, 320.0f) * this.m) {
                this.k = (int) (UtilHelper.a(this.f1068a, 320.0f) * this.m);
            }
            this.i.a(2);
            this.i.b("_mobile");
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
                        com.baidu.tieba.util.aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        ah ahVar;
        View view3;
        String str;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1068a).inflate(R.layout.frs_item, (ViewGroup) null);
                try {
                    ah ahVar2 = new ah(this, null);
                    ahVar2.i = (LinearLayout) view3.findViewById(R.id.frs_list_item);
                    ahVar2.b = (LinearLayout) view3.findViewById(R.id.frs_list_item_top);
                    ahVar2.c = (RelativeLayout) view3.findViewById(R.id.item_bottom_layout);
                    ahVar2.j = (TextView) view3.findViewById(R.id.frs_lv_reply_num);
                    ahVar2.n = (ImageView) view3.findViewById(R.id.frs_discuss_icon);
                    ahVar2.o = (ImageView) view3.findViewById(R.id.author_icon);
                    ahVar2.k = (TextView) view3.findViewById(R.id.frs_lv_reply_time);
                    ahVar2.l = (TextView) view3.findViewById(R.id.frs_lv_title);
                    ahVar2.m = (TextView) view3.findViewById(R.id.frs_lv_author);
                    ahVar2.f1070a = (LinearLayout) view3.findViewById(R.id.frs_lv_abstract);
                    ahVar2.d = (TextView) view3.findViewById(R.id.abstract_text);
                    ahVar2.e = (LinearLayout) view3.findViewById(R.id.abstract_img_layout);
                    ahVar2.f = (RelativeLayout) view3.findViewById(R.id.frs_list_control);
                    ahVar2.g = (TextView) view3.findViewById(R.id.frs_list_control_tv);
                    ahVar2.h = (ProgressBar) view3.findViewById(R.id.frs_list_control_progress);
                    view3.setTag(ahVar2);
                    this.h.add(ahVar2.h);
                    ahVar = ahVar2;
                } catch (Exception e) {
                    e = e;
                    view2 = view3;
                    com.baidu.tieba.util.aq.b(getClass().getName(), "", "FrsAdapter.getView error = " + e.getMessage());
                    if (view2 == null) {
                        TextView textView = new TextView(this.f1068a);
                        textView.setVisibility(8);
                        textView.setHeight(0);
                        return textView;
                    }
                    return view2;
                }
            } else {
                ahVar = (ah) view.getTag();
                view3 = view;
            }
            int an = TiebaApplication.g().an();
            long itemId = getItemId(i);
            if (itemId == -1) {
                ahVar.i.setVisibility(8);
                ahVar.f.setVisibility(0);
                if (this.f) {
                    ahVar.g.setText(R.string.loading);
                    ahVar.h.setVisibility(0);
                } else {
                    ahVar.g.setText(R.string.frs_pre);
                    ahVar.h.setVisibility(8);
                }
                if (an == 1) {
                    ahVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    ahVar.f.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.ao.b(ahVar.g, an);
                return view3;
            } else if (itemId == -2) {
                ahVar.i.setVisibility(8);
                ahVar.f.setVisibility(0);
                if (this.e) {
                    ahVar.g.setText(R.string.loading);
                    ahVar.h.setVisibility(0);
                } else {
                    ahVar.g.setText(R.string.frs_next);
                    ahVar.h.setVisibility(8);
                }
                if (an == 1) {
                    ahVar.f.setBackgroundResource(R.drawable.bg_list_all_1);
                } else {
                    ahVar.f.setBackgroundResource(R.drawable.bg_list_all);
                }
                com.baidu.tieba.util.ao.b(ahVar.g, an);
                return view3;
            } else {
                ahVar.i.setVisibility(0);
                ahVar.f.setVisibility(8);
                ahVar.h.setVisibility(8);
                com.baidu.tieba.data.bh bhVar = (com.baidu.tieba.data.bh) getItem(i);
                int c = bhVar.c();
                ahVar.n.setVisibility(0);
                if (c <= 999999) {
                    if (c > 0) {
                        ahVar.j.setText(String.valueOf(c));
                    } else {
                        ahVar.j.setText((CharSequence) null);
                        ahVar.n.setVisibility(4);
                    }
                } else {
                    ahVar.j.setText("999999+");
                }
                Date date = new Date();
                date.setTime(bhVar.d() * 1000);
                ahVar.k.setText(com.baidu.tieba.util.ap.g(date));
                ahVar.l.setText(bhVar.n());
                com.baidu.tieba.util.ag av = TiebaApplication.g().av();
                if (av != null && av.b(bhVar.a())) {
                    ahVar.l.setTextColor(this.f1068a.getResources().getColor(R.color.read_thread_color));
                } else if (an == 1) {
                    ahVar.l.setTextColor(-8682095);
                } else {
                    ahVar.l.setTextColor(-16777216);
                }
                ahVar.m.setText(bhVar.g().getName());
                if (this.g && bhVar.e() != 1) {
                    ahVar.f1070a.setVisibility(0);
                    ahVar.e.setVisibility(0);
                    ahVar.e.removeAllViews();
                    ahVar.d.setVisibility(0);
                    ArrayList m = bhVar.m();
                    if (bhVar.j() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + bhVar.j();
                    }
                    if (m != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < m.size(); i3++) {
                            if (((com.baidu.tieba.data.ai) m.get(i3)).c() != null && ((com.baidu.tieba.data.ai) m.get(i3)).c().endsWith("swf")) {
                                stringBuffer.append(((com.baidu.tieba.data.ai) m.get(i3)).c());
                            }
                        }
                        String str2 = String.valueOf(str) + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            ahVar.d.setText(str2);
                        } else {
                            ahVar.d.setVisibility(8);
                        }
                        if (m.size() > 0) {
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < m.size()) {
                                int i6 = (m.get(i5) == null || !(((com.baidu.tieba.data.ai) m.get(i5)).a() == 3 || ((com.baidu.tieba.data.ai) m.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < m.size() && i7 < i4) {
                                if (((com.baidu.tieba.data.ai) m.get(i8)).a() == 3 || ((com.baidu.tieba.data.ai) m.get(i8)).a() == 5) {
                                    LinearLayout a2 = a((com.baidu.tieba.data.ai) m.get(i8), i4, i7);
                                    if (a2 != null) {
                                        ahVar.e.addView(a2);
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
                            ahVar.e.setVisibility(8);
                        }
                    }
                } else {
                    ahVar.f1070a.setVisibility(8);
                }
                if (an == 1) {
                    ahVar.b.setBackgroundResource(R.drawable.bg_list_top_1);
                    ahVar.c.setBackgroundResource(R.drawable.bg_list_bottom_1);
                    ahVar.d.setTextColor(-10523526);
                    ahVar.g.setTextColor(-10523526);
                    ahVar.j.setTextColor(-9207399);
                    ahVar.m.setTextColor(-11446171);
                    ahVar.k.setTextColor(-11446171);
                    ahVar.n.setBackgroundResource(R.drawable.icon_little_comment_1);
                    ahVar.o.setBackgroundResource(R.drawable.icon_little_people_1);
                    return view3;
                }
                ahVar.b.setBackgroundResource(R.drawable.bg_list_top);
                ahVar.c.setBackgroundResource(R.drawable.bg_list_bottom);
                ahVar.d.setTextColor(-6710887);
                ahVar.g.setTextColor(-6710887);
                ahVar.j.setTextColor(-5066062);
                ahVar.m.setTextColor(-5066062);
                ahVar.k.setTextColor(-5066062);
                ahVar.n.setBackgroundResource(R.drawable.icon_little_comment);
                ahVar.o.setBackgroundResource(R.drawable.icon_little_people);
                return view3;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
    }
}
