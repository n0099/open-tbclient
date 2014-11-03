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
    public ViewPager Cu;
    private View HT;
    private ArrayList<View> Im;
    private RadioGroup Ol;
    private MemberPayActivity aoA;
    private k aoB;
    private f aoC;
    private NoNetworkView aoS;
    private TextView aoT;
    private c aoU;
    private TableLayout aoV;
    public RadioButton aoW;
    public RadioButton aoX;
    public RadioButton aoY;
    private ImageView aoZ;
    private ImageView apa;
    private TextView apb;
    private TextView apc;
    private TextView apd;
    public CustomScrollView ape;
    public g apf;
    public e apg;
    private String aph;
    private String api;
    public int apj;
    private long apk;
    private int apl;
    public boolean apm;
    private d mData;
    private NavigationBar mNavigationBar;

    public l(MemberPayActivity memberPayActivity, int i) {
        super(memberPayActivity);
        this.apj = 2;
        this.apm = false;
        this.aoA = memberPayActivity;
        this.apl = i;
        initData();
        nu();
    }

    public void setMemberPayData(d dVar) {
        this.mData = dVar;
        initData();
    }

    public void initData() {
        if (this.mData != null) {
            this.aoC = this.mData.aoC;
            this.aoB = this.mData.aoB;
            if (this.aoC != null && this.aoB != null && this.aoB.aoR != null) {
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                this.apf = this.aoC.aoF;
                if (this.apf != null) {
                    this.api = this.apf.mContent;
                    this.apg = this.aoC.aoG;
                    if (this.apg != null) {
                        this.aph = this.apg.mContent;
                    }
                }
            }
        }
    }

    private void nu() {
        this.aoA.setContentView(w.member_pay_activity);
        this.ape = (CustomScrollView) this.aoA.findViewById(v.scroll_view);
        this.HT = (LinearLayout) this.aoA.findViewById(v.root);
        this.mNavigationBar = (NavigationBar) this.aoA.findViewById(v.navigationbar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aoS = (NoNetworkView) this.aoA.findViewById(v.view_no_network);
        this.aoS.a(new m(this));
        this.Ol = (RadioGroup) this.aoA.findViewById(v.btns_price);
        this.Ol.setOnCheckedChangeListener(this.aoA);
        this.aoW = (RadioButton) this.aoA.findViewById(v.btn_price1);
        this.aoX = (RadioButton) this.aoA.findViewById(v.btn_price2);
        this.aoY = (RadioButton) this.aoA.findViewById(v.btn_price3);
        this.Cu = (ViewPager) this.aoA.findViewById(v.viewpager);
        this.aoV = (TableLayout) this.aoA.findViewById(v.tablelay);
        this.aoT = (TextView) this.aoA.findViewById(v.buy_btn);
        this.aoT.setOnClickListener(this.aoA);
        this.apb = (TextView) this.aoA.findViewById(v.dianquan);
    }

    public void AT() {
        if (this.mData != null) {
            this.aoC = this.mData.aoC;
            this.aoB = this.mData.aoB;
            if (this.aoC != null && this.aoB != null && this.aoB.aoR != null) {
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                this.apf = this.aoC.aoF;
                if (this.apf != null) {
                    this.api = this.apf.mContent;
                    if (this.apg != null) {
                        this.apg = this.aoC.aoG;
                        this.aph = this.apg.mContent;
                        if (!this.apm) {
                            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aoA, w.memberpay_headview_pagerone, null);
                            this.aoZ = (ImageView) inflate.findViewById(v.arrowadv);
                            this.aoZ.setOnClickListener(this.aoA);
                            this.apc = (TextView) inflate.findViewById(v.desc_adv);
                            if (TextUtils.isEmpty(this.aph) || TextUtils.getTrimmedLength(this.aph) == 0) {
                                this.aph = this.aoA.getString(y.vip_member);
                            }
                            this.apc.setText(this.aph);
                            View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.aoA, w.memberpay_headview_pagertwo, null);
                            this.apa = (ImageView) inflate2.findViewById(v.arrowcommon);
                            this.apa.setOnClickListener(this.aoA);
                            this.apd = (TextView) inflate2.findViewById(v.desc_member);
                            if (TextUtils.isEmpty(this.api) || TextUtils.getTrimmedLength(this.api) == 0) {
                                this.api = this.aoA.getString(y.member);
                            }
                            this.apd.setText(this.api);
                            this.Im = new ArrayList<>();
                            this.Im.add(inflate);
                            this.Im.add(inflate2);
                            this.aoU = new c(this.aoA, this.Im);
                            this.Cu.setAdapter(this.aoU);
                            this.Cu.setOnPageChangeListener(this.aoA);
                        } else {
                            View inflate3 = com.baidu.adp.lib.g.b.ek().inflate(this.aoA, w.memberpay_headview_pagerone, null);
                            this.aoZ = (ImageView) inflate3.findViewById(v.arrowadv);
                            this.aoZ.setVisibility(8);
                            this.apc = (TextView) inflate3.findViewById(v.desc_adv);
                            this.apc.setText(this.aph);
                            this.Im = new ArrayList<>();
                            this.Im.add(inflate3);
                            this.aoU = new c(this.aoA, this.Im);
                            this.Cu.setAdapter(this.aoU);
                            this.apj = 2;
                        }
                        this.aoU.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    }
                }
            }
        }
    }

    public void AU() {
        if (this.mData != null) {
            this.aoB = this.mData.aoB;
            if (this.aoB != null && this.aoB.aoR != null) {
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                if (this.apk == 2) {
                    this.aoT.setText(y.pay_now);
                } else if (this.apk == 0) {
                    this.aoT.setText(y.open_now);
                } else if (2 == this.apj) {
                    this.aoT.setText(y.open_now);
                } else {
                    this.aoT.setText(y.pay_now);
                }
            }
        }
    }

    public void AV() {
        List<h> list;
        int i;
        SpannableString i2;
        List<h> list2;
        int i3;
        int i4 = 0;
        if (this.mData != null) {
            this.aoC = this.mData.aoC;
            this.aoB = this.mData.aoB;
            if (this.aoC != null && this.aoB != null && this.aoB.aoR != null) {
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                this.apf = this.aoC.aoF;
                if (this.apf != null && this.apg != null) {
                    this.apg = this.aoC.aoG;
                    if (2 == this.apj) {
                        if (this.apg.aoD != null && (list2 = this.apg.aoD) != null && list2.size() == 3) {
                            int checkedRadioButtonId = this.Ol.getCheckedRadioButtonId();
                            if (v.btn_price1 != checkedRadioButtonId) {
                                i4 = v.btn_price2 == checkedRadioButtonId ? 1 : 2;
                            }
                            h hVar = list2.get(i4);
                            if (hVar != null && (i3 = (int) (hVar.aoJ / 100)) >= 0) {
                                i2 = i(i3, String.valueOf(i3 + 0.0d));
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.apf.aoD != null && (list = this.apf.aoD) != null && list.size() == 3) {
                        int checkedRadioButtonId2 = this.Ol.getCheckedRadioButtonId();
                        if (v.btn_price1 != checkedRadioButtonId2) {
                            i4 = v.btn_price2 == checkedRadioButtonId2 ? 1 : 2;
                        }
                        h hVar2 = list.get(i4);
                        if (hVar2 != null && (i = (int) (hVar2.aoJ / 100)) >= 0) {
                            i2 = i(i, String.valueOf(i + 0.0d));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    this.apb.setText(i2);
                }
            }
        }
    }

    private SpannableString i(int i, String str) {
        String string = this.aoA.getString(y.need_dq_num, new Object[]{Integer.valueOf(i), str});
        int length = String.valueOf(i).length();
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), 0, length + 9, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_other_b)), length + 9, length + 10 + length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(s.cp_cont_b)), length + 10 + length2, length + length2 + 11, 33);
        return spannableString;
    }

    public void AW() {
        List<h> list;
        List<h> list2;
        if (this.mData != null) {
            this.aoC = this.mData.aoC;
            this.aoB = this.mData.aoB;
            if (this.aoC != null && this.aoB != null && this.aoB.aoR != null) {
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                this.apf = this.aoC.aoF;
                if (this.apf != null) {
                    this.api = this.apf.mContent;
                    if (this.apg != null) {
                        this.apg = this.aoC.aoG;
                        this.aph = this.apg.mContent;
                        if (2 == this.apj) {
                            if (this.apg.aoD != null && (list2 = this.apg.aoD) != null && list2.size() == 3) {
                                for (int i = 0; i < 3; i++) {
                                    h hVar = list2.get(i);
                                    if (hVar != null && hVar.aoJ >= 0) {
                                        String str = String.valueOf(hVar.mTitle) + "\n¥" + ((hVar.aoJ / 100) + 0.0d);
                                        if (str.length() > 10) {
                                            str = String.valueOf(str.substring(0, 10)) + "...";
                                        }
                                        if (i == 0) {
                                            this.aoW.setText(str);
                                        } else if (i == 1) {
                                            this.aoX.setText(str);
                                        } else {
                                            this.aoY.setText(str);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else if (this.apf.aoD != null && (list = this.apf.aoD) != null && list.size() == 3) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                h hVar2 = list.get(i2);
                                if (hVar2 != null && hVar2.aoJ >= 0) {
                                    String str2 = String.valueOf(hVar2.mTitle) + "\n¥" + ((hVar2.aoJ / 100) + 0.0d);
                                    if (i2 == 0) {
                                        this.aoW.setText(str2);
                                    } else if (i2 == 1) {
                                        this.aoX.setText(str2);
                                    } else {
                                        this.aoY.setText(str2);
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

    public void AX() {
        List<j> list;
        List<j> list2;
        if (this.mData != null) {
            this.aoC = this.mData.aoC;
            this.aoB = this.mData.aoB;
            if (this.aoC != null && this.aoB != null && this.aoB.aoR != null) {
                this.apg = this.aoC.aoG;
                if (this.apg == null || TextUtils.isEmpty(this.apg.mContent) || TextUtils.getTrimmedLength(this.apg.mContent) == 0) {
                    this.aph = this.aoA.getString(y.vip_member);
                } else {
                    this.aph = this.apg.mContent;
                }
                this.apf = this.aoC.aoF;
                if (this.apf == null || TextUtils.isEmpty(this.apf.mContent) || TextUtils.getTrimmedLength(this.apf.mContent) == 0) {
                    this.api = this.aoA.getString(y.member);
                } else {
                    this.api = this.apf.mContent;
                }
                this.apk = this.aoB.aoR.aoM;
                this.apm = this.apk == 2 || this.apl == 2;
                this.apf = this.aoC.aoF;
                if (this.apf != null && this.apg != null && this.aoV != null) {
                    aw.h(this.aoV, u.member_pay_rights_table_bg_shape);
                    this.aoV.removeAllViews();
                    this.aoV.setStretchAllColumns(true);
                    if (2 == this.apj) {
                        this.mNavigationBar.setTitleText(this.aoA.getString(y.dredge, new Object[]{this.aph}));
                        if (this.apg.aoE != null && (list2 = this.apg.aoE) != null && list2.size() > 0) {
                            if (list2.size() % 2 == 1) {
                                j jVar = new j();
                                jVar.mName = "\u3000";
                                jVar.aoO = -1L;
                                list2.add(jVar);
                            }
                            a(list2, this.aoV);
                        } else {
                            return;
                        }
                    } else {
                        this.mNavigationBar.setTitleText(this.aoA.getString(y.dredge, new Object[]{this.api}));
                        if (this.apf.aoE != null && (list = this.apf.aoE) != null && list.size() > 0) {
                            if (list.size() % 2 == 1) {
                                j jVar2 = new j();
                                jVar2.mName = "\u3000";
                                jVar2.aoO = -1L;
                                list.add(jVar2);
                            }
                            a(list, this.aoV);
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
            TableRow tableRow = new TableRow(this.aoA);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aoA, w.member_pay_tablerow, null);
            TextView textView = (TextView) inflate.findViewById(v.text_left);
            TextView textView2 = (TextView) inflate.findViewById(v.text_right);
            if (size == 1) {
                aw.h((View) textView, u.bg_dredge_vip_borderl);
                aw.h((View) textView2, u.bg_dredge_vip_borderr);
            } else if (i == 0) {
                aw.h((View) textView, u.bg_dredge_vip_border1);
                aw.h((View) textView2, u.bg_dredge_vip_border2);
            } else if (i == size - 1) {
                aw.h((View) textView, u.bg_dredge_vip_border3);
                aw.h((View) textView2, u.bg_dredge_vip_border4);
            } else {
                aw.i((View) textView, s.cp_bg_line_d);
                aw.i((View) textView2, s.cp_bg_line_d);
            }
            for (int i2 = 0; i2 < 2; i2++) {
                String str = list.get((i * 2) + i2).mName;
                SpannableString c = c(str == null ? "\u3000" : str, list.get((i * 2) + i2).aoO);
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
        return this.apj;
    }

    public void onChangeSkinType(int i) {
        this.aoA.getLayoutMode().L(i == 1);
        this.aoA.getLayoutMode().h(this.HT);
        this.mNavigationBar.onChangeSkinType(i);
        this.aoS.onChangeSkinType(i);
    }
}
