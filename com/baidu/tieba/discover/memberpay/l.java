package com.baidu.tieba.discover.memberpay;

import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    public ViewPager Ct;
    private View HS;
    private ArrayList<View> Il;
    private RadioGroup Oh;
    private NoNetworkView aoJ;
    private TextView aoK;
    private c aoL;
    private TableLayout aoM;
    public RadioButton aoN;
    public RadioButton aoO;
    public RadioButton aoP;
    private ImageView aoQ;
    private ImageView aoR;
    private TextView aoS;
    private TextView aoT;
    private TextView aoU;
    public CustomScrollView aoV;
    public g aoW;
    public e aoX;
    private String aoY;
    private String aoZ;
    private MemberPayActivity aor;
    private k aos;
    private f aot;
    public int apa;
    private long apb;
    private int apc;
    public boolean apd;
    private d mData;
    private NavigationBar mNavigationBar;

    public l(MemberPayActivity memberPayActivity, int i) {
        super(memberPayActivity);
        this.apa = 2;
        this.apd = false;
        this.aor = memberPayActivity;
        this.apc = i;
        initData();
        nu();
    }

    public void setMemberPayData(d dVar) {
        this.mData = dVar;
        initData();
    }

    public void initData() {
        if (this.mData != null) {
            this.aot = this.mData.aot;
            this.aos = this.mData.aos;
            if (this.aot != null && this.aos != null && this.aos.aoI != null) {
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                this.aoW = this.aot.aow;
                if (this.aoW != null) {
                    this.aoZ = this.aoW.mContent;
                    this.aoX = this.aot.aox;
                    if (this.aoX != null) {
                        this.aoY = this.aoX.mContent;
                    }
                }
            }
        }
    }

    private void nu() {
        this.aor.setContentView(w.member_pay_activity);
        this.aoV = (CustomScrollView) this.aor.findViewById(v.scroll_view);
        this.HS = (LinearLayout) this.aor.findViewById(v.root);
        this.mNavigationBar = (NavigationBar) this.aor.findViewById(v.navigationbar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoJ = (NoNetworkView) this.aor.findViewById(v.view_no_network);
        this.aoJ.a(new m(this));
        this.Oh = (RadioGroup) this.aor.findViewById(v.btns_price);
        this.Oh.setOnCheckedChangeListener(this.aor);
        this.aoN = (RadioButton) this.aor.findViewById(v.btn_price1);
        this.aoO = (RadioButton) this.aor.findViewById(v.btn_price2);
        this.aoP = (RadioButton) this.aor.findViewById(v.btn_price3);
        this.Ct = (ViewPager) this.aor.findViewById(v.viewpager);
        this.aoM = (TableLayout) this.aor.findViewById(v.tablelay);
        this.aoK = (TextView) this.aor.findViewById(v.buy_btn);
        this.aoK.setOnClickListener(this.aor);
        this.aoS = (TextView) this.aor.findViewById(v.dianquan);
    }

    public void AR() {
        if (this.mData != null) {
            this.aot = this.mData.aot;
            this.aos = this.mData.aos;
            if (this.aot != null && this.aos != null && this.aos.aoI != null) {
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                this.aoW = this.aot.aow;
                if (this.aoW != null) {
                    this.aoZ = this.aoW.mContent;
                    if (this.aoX != null) {
                        this.aoX = this.aot.aox;
                        this.aoY = this.aoX.mContent;
                        if (!this.apd) {
                            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aor, w.memberpay_headview_pagerone, null);
                            this.aoQ = (ImageView) inflate.findViewById(v.arrowadv);
                            this.aoQ.setOnClickListener(this.aor);
                            this.aoT = (TextView) inflate.findViewById(v.desc_adv);
                            if (TextUtils.isEmpty(this.aoY) || TextUtils.getTrimmedLength(this.aoY) == 0) {
                                this.aoY = this.aor.getString(y.vip_member);
                            }
                            this.aoT.setText(this.aoY);
                            View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.aor, w.memberpay_headview_pagertwo, null);
                            this.aoR = (ImageView) inflate2.findViewById(v.arrowcommon);
                            this.aoR.setOnClickListener(this.aor);
                            this.aoU = (TextView) inflate2.findViewById(v.desc_member);
                            if (TextUtils.isEmpty(this.aoZ) || TextUtils.getTrimmedLength(this.aoZ) == 0) {
                                this.aoZ = this.aor.getString(y.member);
                            }
                            this.aoU.setText(this.aoZ);
                            this.Il = new ArrayList<>();
                            this.Il.add(inflate);
                            this.Il.add(inflate2);
                            this.aoL = new c(this.aor, this.Il);
                            this.Ct.setAdapter(this.aoL);
                            this.Ct.setOnPageChangeListener(this.aor);
                        } else {
                            View inflate3 = com.baidu.adp.lib.g.b.ek().inflate(this.aor, w.memberpay_headview_pagerone, null);
                            this.aoQ = (ImageView) inflate3.findViewById(v.arrowadv);
                            this.aoQ.setVisibility(8);
                            this.aoT = (TextView) inflate3.findViewById(v.desc_adv);
                            this.aoT.setText(this.aoY);
                            this.Il = new ArrayList<>();
                            this.Il.add(inflate3);
                            this.aoL = new c(this.aor, this.Il);
                            this.Ct.setAdapter(this.aoL);
                            this.apa = 2;
                        }
                        this.aoL.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    }
                }
            }
        }
    }

    public void AS() {
        if (this.mData != null) {
            this.aos = this.mData.aos;
            if (this.aos != null && this.aos.aoI != null) {
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                if (this.apb == 2) {
                    this.aoK.setText(y.pay_now);
                } else if (this.apb == 0) {
                    this.aoK.setText(y.open_now);
                } else if (2 == this.apa) {
                    this.aoK.setText(y.open_now);
                } else {
                    this.aoK.setText(y.pay_now);
                }
            }
        }
    }

    public void AT() {
        List<h> list;
        int i;
        SpannableString i2;
        List<h> list2;
        int i3;
        int i4 = 0;
        if (this.mData != null) {
            this.aot = this.mData.aot;
            this.aos = this.mData.aos;
            if (this.aot != null && this.aos != null && this.aos.aoI != null) {
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                this.aoW = this.aot.aow;
                if (this.aoW != null && this.aoX != null) {
                    this.aoX = this.aot.aox;
                    if (2 == this.apa) {
                        if (this.aoX.aou != null && (list2 = this.aoX.aou) != null && list2.size() == 3) {
                            int checkedRadioButtonId = this.Oh.getCheckedRadioButtonId();
                            if (v.btn_price1 != checkedRadioButtonId) {
                                i4 = v.btn_price2 == checkedRadioButtonId ? 1 : 2;
                            }
                            h hVar = list2.get(i4);
                            if (hVar != null && (i3 = (int) (hVar.aoA / 100)) >= 0) {
                                i2 = i(i3, String.valueOf(i3 + 0.0d));
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.aoW.aou != null && (list = this.aoW.aou) != null && list.size() == 3) {
                        int checkedRadioButtonId2 = this.Oh.getCheckedRadioButtonId();
                        if (v.btn_price1 != checkedRadioButtonId2) {
                            i4 = v.btn_price2 == checkedRadioButtonId2 ? 1 : 2;
                        }
                        h hVar2 = list.get(i4);
                        if (hVar2 != null && (i = (int) (hVar2.aoA / 100)) >= 0) {
                            i2 = i(i, String.valueOf(i + 0.0d));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    this.aoS.setText(i2);
                }
            }
        }
    }

    private SpannableString i(int i, String str) {
        String string = this.aor.getString(y.need_dq_num, new Object[]{Integer.valueOf(i), str});
        int length = String.valueOf(i).length();
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length + 9, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_other_b)), length + 9, length + 10 + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), length + 10 + length2, length + length2 + 11, 33);
        return spannableString;
    }

    public void AU() {
        List<h> list;
        List<h> list2;
        if (this.mData != null) {
            this.aot = this.mData.aot;
            this.aos = this.mData.aos;
            if (this.aot != null && this.aos != null && this.aos.aoI != null) {
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                this.aoW = this.aot.aow;
                if (this.aoW != null) {
                    this.aoZ = this.aoW.mContent;
                    if (this.aoX != null) {
                        this.aoX = this.aot.aox;
                        this.aoY = this.aoX.mContent;
                        if (2 == this.apa) {
                            if (this.aoX.aou != null && (list2 = this.aoX.aou) != null && list2.size() == 3) {
                                for (int i = 0; i < 3; i++) {
                                    h hVar = list2.get(i);
                                    if (hVar != null && hVar.aoA >= 0) {
                                        String str = String.valueOf(hVar.mTitle) + "\n¥" + ((hVar.aoA / 100) + 0.0d);
                                        if (str.length() > 10) {
                                            str = String.valueOf(str.substring(0, 10)) + "...";
                                        }
                                        if (i == 0) {
                                            this.aoN.setText(str);
                                        } else if (i == 1) {
                                            this.aoO.setText(str);
                                        } else {
                                            this.aoP.setText(str);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else if (this.aoW.aou != null && (list = this.aoW.aou) != null && list.size() == 3) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                h hVar2 = list.get(i2);
                                if (hVar2 != null && hVar2.aoA >= 0) {
                                    String str2 = String.valueOf(hVar2.mTitle) + "\n¥" + ((hVar2.aoA / 100) + 0.0d);
                                    if (i2 == 0) {
                                        this.aoN.setText(str2);
                                    } else if (i2 == 1) {
                                        this.aoO.setText(str2);
                                    } else {
                                        this.aoP.setText(str2);
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

    public void AV() {
        List<j> list;
        List<j> list2;
        if (this.mData != null) {
            this.aot = this.mData.aot;
            this.aos = this.mData.aos;
            if (this.aot != null && this.aos != null && this.aos.aoI != null) {
                this.aoX = this.aot.aox;
                if (this.aoX == null || TextUtils.isEmpty(this.aoX.mContent) || TextUtils.getTrimmedLength(this.aoX.mContent) == 0) {
                    this.aoY = this.aor.getString(y.vip_member);
                } else {
                    this.aoY = this.aoX.mContent;
                }
                this.aoW = this.aot.aow;
                if (this.aoW == null || TextUtils.isEmpty(this.aoW.mContent) || TextUtils.getTrimmedLength(this.aoW.mContent) == 0) {
                    this.aoZ = this.aor.getString(y.member);
                } else {
                    this.aoZ = this.aoW.mContent;
                }
                this.apb = this.aos.aoI.aoD;
                this.apd = this.apb == 2 || this.apc == 2;
                this.aoW = this.aot.aow;
                if (this.aoW != null && this.aoX != null && this.aoM != null) {
                    aw.h(this.aoM, u.member_pay_rights_table_bg_shape);
                    this.aoM.removeAllViews();
                    this.aoM.setStretchAllColumns(true);
                    if (2 == this.apa) {
                        this.mNavigationBar.setTitleText(this.aor.getString(y.dredge, new Object[]{this.aoY}));
                        if (this.aoX.aov != null && (list2 = this.aoX.aov) != null && list2.size() > 0) {
                            if (list2.size() % 2 == 1) {
                                j jVar = new j();
                                jVar.mName = "\u3000";
                                jVar.aoF = -1L;
                                list2.add(jVar);
                            }
                            a(list2, this.aoM);
                        } else {
                            return;
                        }
                    } else {
                        this.mNavigationBar.setTitleText(this.aor.getString(y.dredge, new Object[]{this.aoZ}));
                        if (this.aoW.aov != null && (list = this.aoW.aov) != null && list.size() > 0) {
                            if (list.size() % 2 == 1) {
                                j jVar2 = new j();
                                jVar2.mName = "\u3000";
                                jVar2.aoF = -1L;
                                list.add(jVar2);
                            }
                            a(list, this.aoM);
                        } else {
                            return;
                        }
                    }
                    this.mNavigationBar.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                }
            }
        }
    }

    private void a(List<j> list, TableLayout tableLayout) {
        int size = list.size() / 2;
        for (int i = 0; i < size; i++) {
            TableRow tableRow = new TableRow(this.aor);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aor, w.member_pay_tablerow, null);
            TextView textView = (TextView) inflate.findViewById(v.text_left);
            TextView textView2 = (TextView) inflate.findViewById(v.text_right);
            if (size == 1) {
                aw.h((View) textView, u.member_pay_onetablerow_left_shape);
                aw.h((View) textView2, u.member_pay_onetablerow_right_shape);
            } else if (i == 0) {
                aw.h((View) textView, u.member_pay_rights_tablerow_topleft_shape);
                aw.h((View) textView2, u.member_pay_rights_tablerow_topright_shape);
            } else if (i == size - 1) {
                aw.h((View) textView, u.member_pay_rights_tablerow_bottomleft_shape);
                aw.h((View) textView2, u.member_pay_rights_tablerow_bottomright_shape);
            } else {
                aw.i((View) textView, s.cp_bg_line_d);
                aw.i((View) textView2, s.cp_bg_line_d);
            }
            for (int i2 = 0; i2 < 2; i2++) {
                String str = list.get((i * 2) + i2).mName;
                SpannableString c = c(str == null ? "\u3000" : str, list.get((i * 2) + i2).aoF);
                if (i2 == 0) {
                    textView.setText(c);
                } else {
                    textView2.setText(c);
                }
            }
            tableRow.addView(inflate, new TableRow.LayoutParams(-1, -2));
            tableLayout.addView(tableRow, new TableLayout.LayoutParams(-1, -2));
        }
    }

    public SpannableString c(String str, long j) {
        int length = str.length();
        if (length > 6) {
            str = String.valueOf(str.substring(0, 6)) + "...";
        }
        if (j >= 0) {
            String str2 = "x" + j;
            int length2 = str.length();
            int length3 = str2.length();
            SpannableString spannableString = new SpannableString(String.valueOf(str) + str2);
            spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length2 + 1, 33);
            spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_other_b)), length2 + 1, length2 + length3, 33);
            return spannableString;
        }
        SpannableString spannableString2 = new SpannableString(str);
        spannableString2.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length, 33);
        return spannableString2;
    }

    public int getShowType() {
        return this.apa;
    }

    public void onChangeSkinType(int i) {
        this.aor.getLayoutMode().L(i == 1);
        this.aor.getLayoutMode().h(this.HS);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoJ.onChangeSkinType(i);
    }
}
