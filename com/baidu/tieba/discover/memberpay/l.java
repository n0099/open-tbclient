package com.baidu.tieba.discover.memberpay;

import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private String A;
    private String B;
    private long C;
    private int D;
    public ViewPager a;
    public RadioButton b;
    public RadioButton c;
    public RadioButton d;
    public ScrollView e;
    public g f;
    public e g;
    public int h;
    public boolean i;
    private MemberPayActivity j;
    private NavigationBar k;
    private NoNetworkView l;
    private View m;
    private TextView n;
    private ArrayList<View> o;
    private c p;
    private TableLayout q;
    private RadioGroup r;
    private ImageView s;
    private ImageView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private d x;
    private k y;
    private f z;

    public l(MemberPayActivity memberPayActivity, int i) {
        super(memberPayActivity);
        this.h = 2;
        this.i = false;
        this.j = memberPayActivity;
        this.D = i;
        a();
        g();
    }

    public void setMemberPayData(d dVar) {
        this.x = dVar;
        a();
    }

    public void a() {
        if (this.x != null) {
            this.z = this.x.b;
            this.y = this.x.a;
            if (this.z != null && this.y != null && this.y.g != null) {
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                this.f = this.z.a;
                if (this.f != null) {
                    this.B = this.f.c;
                    this.g = this.z.b;
                    if (this.g != null) {
                        this.A = this.g.c;
                    }
                }
            }
        }
    }

    private void g() {
        this.j.setContentView(v.member_pay_activity);
        this.e = (ScrollView) this.j.findViewById(u.scroll_view);
        this.m = (LinearLayout) this.j.findViewById(u.root);
        this.k = (NavigationBar) this.j.findViewById(u.navigationbar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l = (NoNetworkView) this.j.findViewById(u.view_no_network);
        this.l.a(new m(this));
        this.r = (RadioGroup) this.j.findViewById(u.btns_price);
        this.r.setOnCheckedChangeListener(this.j);
        this.b = (RadioButton) this.j.findViewById(u.btn_price1);
        this.c = (RadioButton) this.j.findViewById(u.btn_price2);
        this.d = (RadioButton) this.j.findViewById(u.btn_price3);
        this.a = (ViewPager) this.j.findViewById(u.viewpager);
        this.q = (TableLayout) this.j.findViewById(u.tablelay);
        this.n = (TextView) this.j.findViewById(u.buy_btn);
        this.n.setOnClickListener(this.j);
        this.u = (TextView) this.j.findViewById(u.dianquan);
    }

    public void b() {
        if (this.x != null) {
            this.z = this.x.b;
            this.y = this.x.a;
            if (this.z != null && this.y != null && this.y.g != null) {
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                this.f = this.z.a;
                if (this.f != null) {
                    this.B = this.f.c;
                    if (this.g != null) {
                        this.g = this.z.b;
                        this.A = this.g.c;
                        if (!this.i) {
                            View inflate = LayoutInflater.from(this.j).inflate(v.memberpay_headview_pagerone, (ViewGroup) null);
                            this.s = (ImageView) inflate.findViewById(u.arrowadv);
                            this.s.setOnClickListener(this.j);
                            this.v = (TextView) inflate.findViewById(u.desc_adv);
                            if (TextUtils.isEmpty(this.A) || TextUtils.getTrimmedLength(this.A) == 0) {
                                this.A = this.j.getString(x.vip_member);
                            }
                            this.v.setText(this.A);
                            View inflate2 = LayoutInflater.from(this.j).inflate(v.memberpay_headview_pagertwo, (ViewGroup) null);
                            this.t = (ImageView) inflate2.findViewById(u.arrowcommon);
                            this.t.setOnClickListener(this.j);
                            this.w = (TextView) inflate2.findViewById(u.desc_member);
                            if (TextUtils.isEmpty(this.B) || TextUtils.getTrimmedLength(this.B) == 0) {
                                this.B = this.j.getString(x.member);
                            }
                            this.w.setText(this.B);
                            this.o = new ArrayList<>();
                            this.o.add(inflate);
                            this.o.add(inflate2);
                            this.p = new c(this.j, this.o);
                            this.a.setAdapter(this.p);
                            this.a.setOnPageChangeListener(this.j);
                        } else {
                            View inflate3 = LayoutInflater.from(this.j).inflate(v.memberpay_headview_pagerone, (ViewGroup) null);
                            this.s = (ImageView) inflate3.findViewById(u.arrowadv);
                            this.s.setVisibility(8);
                            this.v = (TextView) inflate3.findViewById(u.desc_adv);
                            this.v.setText(this.A);
                            this.o = new ArrayList<>();
                            this.o.add(inflate3);
                            this.p = new c(this.j, this.o);
                            this.a.setAdapter(this.p);
                            this.h = 2;
                        }
                        this.p.a(TbadkApplication.m252getInst().getSkinType());
                    }
                }
            }
        }
    }

    public void c() {
        if (this.x != null) {
            this.y = this.x.a;
            if (this.y != null && this.y.g != null) {
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                if (this.C == 2) {
                    this.n.setText(x.pay_now);
                } else if (this.C == 0) {
                    this.n.setText(x.open_now);
                } else if (2 == this.h) {
                    this.n.setText(x.open_now);
                } else {
                    this.n.setText(x.pay_now);
                }
            }
        }
    }

    public void d() {
        List<h> list;
        int i;
        SpannableString a;
        List<h> list2;
        int i2;
        int i3 = 0;
        if (this.x != null) {
            this.z = this.x.b;
            this.y = this.x.a;
            if (this.z != null && this.y != null && this.y.g != null) {
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                this.f = this.z.a;
                if (this.f != null && this.g != null) {
                    this.g = this.z.b;
                    if (2 == this.h) {
                        if (this.g.a != null && (list2 = this.g.a) != null && list2.size() == 3) {
                            int checkedRadioButtonId = this.r.getCheckedRadioButtonId();
                            if (u.btn_price1 != checkedRadioButtonId) {
                                i3 = u.btn_price2 == checkedRadioButtonId ? 1 : 2;
                            }
                            h hVar = list2.get(i3);
                            if (hVar != null && (i2 = (int) (hVar.e / 100)) >= 0) {
                                a = a(i2, String.valueOf(i2 + 0.0d));
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.f.a != null && (list = this.f.a) != null && list.size() == 3) {
                        int checkedRadioButtonId2 = this.r.getCheckedRadioButtonId();
                        if (u.btn_price1 != checkedRadioButtonId2) {
                            i3 = u.btn_price2 == checkedRadioButtonId2 ? 1 : 2;
                        }
                        h hVar2 = list.get(i3);
                        if (hVar2 != null && (i = (int) (hVar2.e / 100)) >= 0) {
                            a = a(i, String.valueOf(i + 0.0d));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    this.u.setText(a);
                }
            }
        }
    }

    private SpannableString a(int i, String str) {
        String string = this.j.getString(x.need_dq_num, new Object[]{Integer.valueOf(i), str});
        int length = String.valueOf(i).length();
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(string);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b_1)), 0, length + 9, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_other_b_1)), length + 9, length + 10 + length2, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b_1)), length + 10 + length2, length + length2 + 11, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b)), 0, length + 9, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_other_b)), length + 9, length + 10 + length2, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b)), length + 10 + length2, length + length2 + 11, 33);
        }
        return spannableString;
    }

    public void e() {
        List<h> list;
        List<h> list2;
        if (this.x != null) {
            this.z = this.x.b;
            this.y = this.x.a;
            if (this.z != null && this.y != null && this.y.g != null) {
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                this.f = this.z.a;
                if (this.f != null) {
                    this.B = this.f.c;
                    if (this.g != null) {
                        this.g = this.z.b;
                        this.A = this.g.c;
                        if (2 == this.h) {
                            if (this.g.a != null && (list2 = this.g.a) != null && list2.size() == 3) {
                                for (int i = 0; i < 3; i++) {
                                    h hVar = list2.get(i);
                                    if (hVar != null && hVar.e >= 0) {
                                        String str = String.valueOf(hVar.b) + "\n¥" + ((hVar.e / 100) + 0.0d);
                                        if (str.length() > 10) {
                                            str = String.valueOf(str.substring(0, 10)) + "...";
                                        }
                                        if (i == 0) {
                                            this.b.setText(str);
                                        } else if (i == 1) {
                                            this.c.setText(str);
                                        } else {
                                            this.d.setText(str);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else if (this.f.a != null && (list = this.f.a) != null && list.size() == 3) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                h hVar2 = list.get(i2);
                                if (hVar2 != null && hVar2.e >= 0) {
                                    String str2 = String.valueOf(hVar2.b) + "\n¥" + ((hVar2.e / 100) + 0.0d);
                                    if (i2 == 0) {
                                        this.b.setText(str2);
                                    } else if (i2 == 1) {
                                        this.c.setText(str2);
                                    } else {
                                        this.d.setText(str2);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void f() {
        int i;
        List<j> list;
        List<j> list2;
        if (this.x != null) {
            this.z = this.x.b;
            this.y = this.x.a;
            if (this.z != null && this.y != null && this.y.g != null) {
                this.g = this.z.b;
                if (this.g == null || TextUtils.isEmpty(this.g.c) || TextUtils.getTrimmedLength(this.g.c) == 0) {
                    this.A = this.j.getString(x.vip_member);
                } else {
                    this.A = this.g.c;
                }
                this.f = this.z.a;
                if (this.f == null || TextUtils.isEmpty(this.f.c) || TextUtils.getTrimmedLength(this.f.c) == 0) {
                    this.B = this.j.getString(x.member);
                } else {
                    this.B = this.f.c;
                }
                this.C = this.y.g.a;
                this.i = this.C == 2 || this.D == 2;
                this.f = this.z.a;
                if (this.f != null && this.g != null) {
                    boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
                    if (this.q != null) {
                        TableLayout tableLayout = this.q;
                        if (z) {
                            i = t.member_pay_rights_table_bg_shape_1;
                        } else {
                            i = t.member_pay_rights_table_bg_shape;
                        }
                        tableLayout.setBackgroundResource(i);
                        this.q.removeAllViews();
                        this.q.setStretchAllColumns(true);
                        if (2 == this.h) {
                            this.k.a(this.j.getString(x.dredge, new Object[]{this.A}));
                            if (this.g.b != null && (list2 = this.g.b) != null && list2.size() > 0) {
                                if (list2.size() % 2 == 1) {
                                    j jVar = new j();
                                    jVar.a = "\u3000";
                                    jVar.b = -1L;
                                    list2.add(jVar);
                                }
                                a(list2, this.q);
                                return;
                            }
                            return;
                        }
                        this.k.a(this.j.getString(x.dredge, new Object[]{this.B}));
                        if (this.f.b != null && (list = this.f.b) != null && list.size() > 0) {
                            if (list.size() % 2 == 1) {
                                j jVar2 = new j();
                                jVar2.a = "\u3000";
                                jVar2.b = -1L;
                                list.add(jVar2);
                            }
                            a(list, this.q);
                        }
                    }
                }
            }
        }
    }

    private void a(List<j> list, TableLayout tableLayout) {
        int size = list.size() / 2;
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        for (int i = 0; i < size; i++) {
            TableRow tableRow = new TableRow(this.j);
            View inflate = LayoutInflater.from(this.j).inflate(v.member_pay_tablerow, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.text_left);
            TextView textView2 = (TextView) inflate.findViewById(u.text_right);
            if (size == 1) {
                textView.setBackgroundResource(z ? t.member_pay_onetablerow_left_shape_1 : t.member_pay_onetablerow_left_shape);
                textView2.setBackgroundResource(z ? t.member_pay_onetablerow_right_shape_1 : t.member_pay_onetablerow_right_shape_1);
            } else if (i == 0) {
                textView.setBackgroundResource(z ? t.member_pay_rights_tablerow_topleft_shape_1 : t.member_pay_rights_tablerow_topleft_shape);
                textView2.setBackgroundResource(z ? t.member_pay_rights_tablerow_topright_shape_1 : t.member_pay_rights_tablerow_topright_shape);
            } else if (i == size - 1) {
                textView.setBackgroundResource(z ? t.member_pay_rights_tablerow_bottomleft_shape_1 : t.member_pay_rights_tablerow_bottomleft_shape);
                textView2.setBackgroundResource(z ? t.member_pay_rights_tablerow_bottomright_shape_1 : t.member_pay_rights_tablerow_bottomright_shape);
            } else {
                textView.setBackgroundResource(z ? r.cp_bg_line_d_1 : r.cp_bg_line_d);
                textView2.setBackgroundResource(z ? r.cp_bg_line_d_1 : r.cp_bg_line_d);
            }
            for (int i2 = 0; i2 < 2; i2++) {
                String str = list.get((i * 2) + i2).a;
                SpannableString a = a(str == null ? "\u3000" : str, list.get((i * 2) + i2).b);
                if (i2 == 0) {
                    textView.setText(a);
                } else {
                    textView2.setText(a);
                }
            }
            tableRow.addView(inflate, new TableRow.LayoutParams(-1, -2));
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(-1, -2));
        }
    }

    public SpannableString a(String str, long j) {
        SpannableString spannableString;
        int length = str.length();
        if (length > 6) {
            str = String.valueOf(str.substring(0, 6)) + "...";
        }
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (j >= 0) {
            String str2 = "x" + j;
            int length2 = str.length();
            int length3 = str2.length();
            spannableString = new SpannableString(String.valueOf(str) + str2);
            if (z) {
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b_1)), 0, length2 + 1, 33);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_other_b_1)), length2 + 1, length2 + length3, 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b)), 0, length2 + 1, 33);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_other_b)), length2 + 1, length2 + length3, 33);
            }
        } else {
            spannableString = new SpannableString(str);
            if (z) {
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b_1)), 0, length, 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(r.cp_cont_b)), 0, length, 33);
            }
        }
        return spannableString;
    }

    public int getShowType() {
        return this.h;
    }

    public void a(int i) {
        this.j.getLayoutMode().a(i == 1);
        this.j.getLayoutMode().a(this.m);
        this.k.c(i);
        this.l.a(i);
    }
}
