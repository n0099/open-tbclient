package com.baidu.tieba.ala.c;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.live.data.bs;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private int aLb;
    private int aLc;
    private int aLe;
    private long aLi;
    private int aLj;
    private Activity activity;
    private int dhi;
    private long fTB;
    private String fTC;
    private String fTD;
    private boolean fTG;
    private boolean fTH;
    private int fTI;
    private int fTJ;
    private c fTK;
    private int fTL;
    private int fTM;
    private float fTN;
    private boolean fTO;
    private int fTQ;
    private boolean fTR;
    private View fTa;
    private View fTb;
    private TextView fTc;
    private EditText fTd;
    private EditText fTe;
    private TextView fTf;
    private TextView fTg;
    private LinearLayout fTh;
    private LinearLayout fTi;
    private LinearLayout fTj;
    private TextView fTk;
    private TextView fTl;
    private ImageView fTm;
    private ImageView fTn;
    private TextView fTo;
    private TextView fTp;
    private RelativeLayout fTq;
    private LinearLayout fTr;
    private LinearLayout fTs;
    private ScrollView fTt;
    private View fTu;
    private long fTw;
    private int fTx;
    private int fTy;
    private List<bs.a> fTz;
    private int screenWidth;
    private int fTv = 2000;
    private long fTA = 2000;
    private boolean fTE = true;
    private boolean fTF = true;
    private int fTP = 10;

    public d(final Activity activity, c cVar) {
        this.activity = activity;
        this.fTK = cVar;
        initView();
        initData();
        bIG();
        bIH();
        this.fTq.setVisibility(4);
        this.fTq.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                d.this.dhi = ScreenHelper.getScreenHeight(activity);
                if (d.this.screenWidth > d.this.dhi) {
                    int i = d.this.screenWidth;
                    d.this.screenWidth = d.this.dhi;
                    d.this.dhi = i;
                }
                d.this.fTL = d.this.screenWidth;
                d.this.fTJ = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                d.this.fTM = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = d.this.screenWidth - (d.this.fTJ * 2);
                d.this.fTN = (i2 * 1.0f) / d.this.fTq.getHeight();
                if (d.this.dhi > d.this.fTq.getHeight()) {
                    d.this.fTI = (d.this.dhi - d.this.fTq.getHeight()) / 2;
                }
                d.this.Fq();
                d.this.fTq.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.fTa = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fTb = this.fTa.findViewById(a.g.iv_send_red_q);
        this.fTc = (TextView) this.fTa.findViewById(a.g.tv_red_broad_hint);
        this.fTd = (EditText) this.fTa.findViewById(a.g.edt_t_num);
        this.fTe = (EditText) this.fTa.findViewById(a.g.edt_pkt_num);
        this.fTf = (TextView) this.fTa.findViewById(a.g.tv_send_t_num_hint);
        this.fTg = (TextView) this.fTa.findViewById(a.g.tv_send_pkt_num_hint);
        this.fTh = (LinearLayout) this.fTa.findViewById(a.g.layout_red_pkt_condition);
        this.fTi = (LinearLayout) this.fTa.findViewById(a.g.layout_condition_first);
        this.fTj = (LinearLayout) this.fTa.findViewById(a.g.layout_condition_second);
        this.fTq = (RelativeLayout) this.fTa.findViewById(a.g.layout_send_red_content);
        View findViewById = this.fTa.findViewById(a.g.layout_send_red);
        this.fTk = (TextView) this.fTa.findViewById(a.g.tv_condition_first);
        this.fTl = (TextView) this.fTa.findViewById(a.g.tv_condition_second);
        this.fTm = (ImageView) this.fTa.findViewById(a.g.iv_condition_first);
        this.fTn = (ImageView) this.fTa.findViewById(a.g.iv_condition_second);
        this.fTo = (TextView) this.fTa.findViewById(a.g.tv_send_pkt_submit);
        this.fTp = (TextView) this.fTa.findViewById(a.g.tv_send_pkt_time);
        this.fTr = (LinearLayout) this.fTa.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.fTa.findViewById(a.g.layout_red_send_rule_content);
        this.fTs = (LinearLayout) this.fTa.findViewById(a.g.layout_rule_desc);
        this.fTt = (ScrollView) this.fTa.findViewById(a.g.layout_input_scroll);
        this.fTu = this.fTa.findViewById(a.g.layout_send_red_close);
        this.fTa.setOnClickListener(this);
        this.fTi.setOnClickListener(this);
        this.fTj.setOnClickListener(this);
        this.fTo.setOnClickListener(this);
        this.fTb.setOnClickListener(this);
        this.fTr.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.fTu.setOnClickListener(this);
        ((ImageView) this.fTa.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        bs.a aVar;
        bs.a aVar2 = null;
        if (com.baidu.live.w.a.Nk() == null || com.baidu.live.w.a.Nk().bkd == null || com.baidu.live.w.a.Nk().bkd.aJA == null || com.baidu.live.w.a.Nk().bkd.aJA.aKy == null) {
            strArr = null;
            str = null;
        } else {
            bs bsVar = com.baidu.live.w.a.Nk().bkd.aJA.aKy;
            if (bsVar.aLg > 0) {
                this.fTA = bsVar.aLg;
            }
            if (bsVar.aLh > 0) {
                this.fTP = bsVar.aLh;
            }
            this.fTB = this.fTP;
            this.fTw = bsVar.aKZ;
            this.aLb = bsVar.aLb;
            this.aLc = bsVar.aLc;
            this.fTx = bsVar.aLd;
            this.fTQ = bsVar.aLa;
            this.aLe = bsVar.aLe;
            this.fTz = bsVar.aLf;
            this.aLi = bsVar.aLi;
            this.aLj = bsVar.aLj;
            str = bsVar.aLk;
            strArr = bsVar.aLl;
            if (bII()) {
                this.fTy = this.aLj;
            } else {
                this.fTy = this.fTQ;
            }
        }
        this.fTd.setText(String.valueOf(this.fTA));
        this.fTe.setText(String.valueOf(this.fTB));
        this.fTd.setSelection(this.fTd.getText().toString().length());
        this.fTe.setSelection(this.fTe.getText().toString().length());
        TextView textView = this.fTc;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fTx));
        }
        textView.setText(str);
        this.fTp.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aLe)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aLe)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fTQ))};
        }
        if (this.fTs != null) {
            this.fTs.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.fTs.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.fTs.addView(textView2, layoutParams);
            }
        }
        if (this.fTz != null && !this.fTz.isEmpty()) {
            if (this.fTz.size() == 1) {
                aVar = this.fTz.get(0);
            } else {
                aVar = this.fTz.get(0);
                aVar2 = this.fTz.get(1);
            }
            if (aVar == null) {
                this.fTi.setVisibility(8);
            } else {
                this.fTk.setText(aVar.aLm);
                this.fTi.setVisibility(0);
                this.fTC = aVar.aLn;
            }
            if (aVar2 == null) {
                this.fTj.setVisibility(8);
            } else {
                this.fTl.setText(aVar2.aLm);
                this.fTj.setVisibility(0);
                this.fTD = aVar2.aLn;
            }
            if (this.fTi.getVisibility() == 0 || this.fTj.getVisibility() == 0) {
                this.fTh.setVisibility(0);
                return;
            } else {
                this.fTh.setVisibility(8);
                return;
            }
        }
        this.fTh.setVisibility(8);
    }

    private void bIG() {
        this.fTd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!d.this.la(true)) {
                    d.this.lb(true);
                }
            }
        });
        this.fTe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = d.this.fTe.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (d.this.fTe.hasFocus()) {
                        d.this.fTR = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        d.this.fTe.setText(String.valueOf(parseLong));
                        return;
                    }
                    d.this.fTB = parseLong;
                    if (parseLong >= d.this.aLb && parseLong <= d.this.aLc) {
                        d.this.fTg.setVisibility(8);
                        d.this.fTF = true;
                    } else {
                        d.this.fTg.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aLb), Integer.valueOf(d.this.aLc)));
                        d.this.fTg.setVisibility(0);
                        d.this.fTF = false;
                    }
                } else {
                    d.this.fTg.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aLb), Integer.valueOf(d.this.aLc)));
                    d.this.fTg.setVisibility(0);
                    d.this.fTB = 0L;
                    d.this.fTF = false;
                }
                d.this.fTe.setSelection(d.this.fTe.getText().toString().length());
                TextView textView = d.this.fTo;
                if (!d.this.fTE || !d.this.fTF) {
                    z = false;
                }
                textView.setEnabled(z);
                d.this.la(false);
                d.this.lb(false);
            }
        });
    }

    private void bIH() {
        this.fTd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fTd.setText("");
                    d.this.fTd.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fTd.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.fTe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fTe.setText("");
                    d.this.fTe.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fTe.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean la(boolean z) {
        boolean z2 = true;
        this.fTy = this.fTQ;
        String obj = this.fTd.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.fTf.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fTv), Long.valueOf(this.fTw)));
            this.fTf.setVisibility(0);
            this.fTA = 0L;
            this.fTE = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fTd.setText(String.valueOf(parseLong));
                return true;
            } else if (this.fTA != parseLong && this.fTA > this.fTw && parseLong > this.fTw) {
                this.fTd.setText(String.valueOf(this.fTA));
                return true;
            } else {
                boolean z3 = bII() && parseLong < this.aLi;
                this.fTA = parseLong;
                if (bII()) {
                    this.fTy = this.aLj;
                }
                if (parseLong < this.fTv || parseLong > this.fTw) {
                    if (parseLong == 0) {
                        this.fTd.setText("0");
                    }
                    this.fTf.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fTv), Long.valueOf(this.fTw)));
                    this.fTf.setVisibility(0);
                    this.fTE = false;
                } else {
                    if (z && this.fTe != null && bIJ() && !this.fTe.hasFocus()) {
                        boolean z4 = !this.fTR;
                        if (!z4 && this.fTe.getText() != null) {
                            String obj2 = this.fTe.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bII()) {
                                long j = this.fTA / this.aLj;
                                if (this.aLc > 0 && j > this.aLc) {
                                    j = this.aLc;
                                }
                                this.fTe.setText(String.valueOf(j));
                            } else if (z3) {
                                this.fTe.setText(String.valueOf(this.fTP));
                            }
                        }
                    }
                    this.fTf.setVisibility(8);
                    this.fTE = true;
                }
            }
        }
        this.fTd.setSelection(this.fTd.getText().toString().length());
        TextView textView = this.fTo;
        if (!this.fTE || !this.fTF) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb(boolean z) {
        if (this.fTF && this.fTE && this.fTB != 0 && this.fTA / this.fTB < this.fTy) {
            this.fTf.setVisibility(0);
            if (z) {
                this.fTf.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fTB * this.fTy)));
            } else {
                this.fTf.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fTA / this.fTy)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fTr.getVisibility() == 0) {
            this.fTr.setVisibility(8);
            return;
        }
        if (view == this.fTu && !this.fTO) {
            this.activity.finish();
        } else if (view == this.fTa && !this.fTO) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fTb) {
            this.fTr.setVisibility(0);
        } else if (view == this.fTi) {
            this.fTG = this.fTG ? false : true;
            if (this.fTG) {
                this.fTm.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fTm.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fTj) {
            this.fTH = this.fTH ? false : true;
            if (this.fTH) {
                this.fTn.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fTn.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fTo) {
            if (this.fTG && this.fTH) {
                str = this.fTC + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fTD;
            } else if (this.fTG) {
                str = this.fTC;
            } else if (this.fTH) {
                str = this.fTD;
            } else {
                str = "";
            }
            p pVar = new p();
            pVar.dW(this.fTA);
            pVar.dX(this.fTB);
            pVar.Fg(str);
            if (this.fTK != null) {
                this.fTK.a(pVar);
            }
        }
        if (this.fTO && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void lc(boolean z) {
        if (this.fTo != null) {
            this.fTo.setEnabled(z);
        }
    }

    public View getView() {
        return this.fTa;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fTO = z;
        if (!z) {
            if (this.fTe != null) {
                this.fTe.clearFocus();
            }
            if (this.fTd != null) {
                this.fTd.clearFocus();
            }
        }
        if (this.fTq != null && this.fTq.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fTq.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fTI;
                }
            } else {
                layoutParams.topMargin = this.fTJ;
            }
            this.fTq.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fTu.setVisibility(0);
        } else {
            this.fTu.setVisibility(8);
        }
    }

    public void Fq() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.Y(this.fTa);
        } else {
            h.Z(this.fTa);
        }
        if (this.fTt != null && this.fTt.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fTt.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fTM;
            } else {
                layoutParams.height = -2;
            }
            this.fTt.setLayoutParams(layoutParams);
        }
        if (this.fTq != null && this.fTq.getLayoutParams() != null && this.fTL > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fTq.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fTq.setPivotX(this.fTL / 2);
            this.fTq.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fTq.setScaleX(this.fTN);
                this.fTq.setScaleY(this.fTN);
            } else {
                layoutParams2.width = -1;
                this.fTq.setScaleX(1.0f);
                this.fTq.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fTO);
        }
    }

    private boolean bII() {
        return bIJ() && this.fTA >= this.aLi && this.fTA <= this.fTw;
    }

    private boolean bIJ() {
        return this.aLi >= ((long) this.fTv) && this.aLj > 0;
    }
}
