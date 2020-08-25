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
    private int aKZ;
    private int aLa;
    private int aLc;
    private long aLg;
    private int aLh;
    private Activity activity;
    private int dhe;
    private View fSW;
    private View fSX;
    private TextView fSY;
    private EditText fSZ;
    private boolean fTC;
    private boolean fTD;
    private int fTE;
    private int fTF;
    private c fTG;
    private int fTH;
    private int fTI;
    private float fTJ;
    private boolean fTK;
    private int fTM;
    private boolean fTN;
    private EditText fTa;
    private TextView fTb;
    private TextView fTc;
    private LinearLayout fTd;
    private LinearLayout fTe;
    private LinearLayout fTf;
    private TextView fTg;
    private TextView fTh;
    private ImageView fTi;
    private ImageView fTj;
    private TextView fTk;
    private TextView fTl;
    private RelativeLayout fTm;
    private LinearLayout fTn;
    private LinearLayout fTo;
    private ScrollView fTp;
    private View fTq;
    private long fTs;
    private int fTt;
    private int fTu;
    private List<bs.a> fTv;
    private long fTx;
    private String fTy;
    private String fTz;
    private int screenWidth;
    private int fTr = 2000;
    private long fTw = 2000;
    private boolean fTA = true;
    private boolean fTB = true;
    private int fTL = 10;

    public d(final Activity activity, c cVar) {
        this.activity = activity;
        this.fTG = cVar;
        initView();
        initData();
        bIF();
        bIG();
        this.fTm.setVisibility(4);
        this.fTm.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                d.this.dhe = ScreenHelper.getScreenHeight(activity);
                if (d.this.screenWidth > d.this.dhe) {
                    int i = d.this.screenWidth;
                    d.this.screenWidth = d.this.dhe;
                    d.this.dhe = i;
                }
                d.this.fTH = d.this.screenWidth;
                d.this.fTF = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                d.this.fTI = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = d.this.screenWidth - (d.this.fTF * 2);
                d.this.fTJ = (i2 * 1.0f) / d.this.fTm.getHeight();
                if (d.this.dhe > d.this.fTm.getHeight()) {
                    d.this.fTE = (d.this.dhe - d.this.fTm.getHeight()) / 2;
                }
                d.this.Fq();
                d.this.fTm.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.fSW = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fSX = this.fSW.findViewById(a.g.iv_send_red_q);
        this.fSY = (TextView) this.fSW.findViewById(a.g.tv_red_broad_hint);
        this.fSZ = (EditText) this.fSW.findViewById(a.g.edt_t_num);
        this.fTa = (EditText) this.fSW.findViewById(a.g.edt_pkt_num);
        this.fTb = (TextView) this.fSW.findViewById(a.g.tv_send_t_num_hint);
        this.fTc = (TextView) this.fSW.findViewById(a.g.tv_send_pkt_num_hint);
        this.fTd = (LinearLayout) this.fSW.findViewById(a.g.layout_red_pkt_condition);
        this.fTe = (LinearLayout) this.fSW.findViewById(a.g.layout_condition_first);
        this.fTf = (LinearLayout) this.fSW.findViewById(a.g.layout_condition_second);
        this.fTm = (RelativeLayout) this.fSW.findViewById(a.g.layout_send_red_content);
        View findViewById = this.fSW.findViewById(a.g.layout_send_red);
        this.fTg = (TextView) this.fSW.findViewById(a.g.tv_condition_first);
        this.fTh = (TextView) this.fSW.findViewById(a.g.tv_condition_second);
        this.fTi = (ImageView) this.fSW.findViewById(a.g.iv_condition_first);
        this.fTj = (ImageView) this.fSW.findViewById(a.g.iv_condition_second);
        this.fTk = (TextView) this.fSW.findViewById(a.g.tv_send_pkt_submit);
        this.fTl = (TextView) this.fSW.findViewById(a.g.tv_send_pkt_time);
        this.fTn = (LinearLayout) this.fSW.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.fSW.findViewById(a.g.layout_red_send_rule_content);
        this.fTo = (LinearLayout) this.fSW.findViewById(a.g.layout_rule_desc);
        this.fTp = (ScrollView) this.fSW.findViewById(a.g.layout_input_scroll);
        this.fTq = this.fSW.findViewById(a.g.layout_send_red_close);
        this.fSW.setOnClickListener(this);
        this.fTe.setOnClickListener(this);
        this.fTf.setOnClickListener(this);
        this.fTk.setOnClickListener(this);
        this.fSX.setOnClickListener(this);
        this.fTn.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.fTq.setOnClickListener(this);
        ((ImageView) this.fSW.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        bs.a aVar;
        bs.a aVar2 = null;
        if (com.baidu.live.w.a.Nk() == null || com.baidu.live.w.a.Nk().bka == null || com.baidu.live.w.a.Nk().bka.aJy == null || com.baidu.live.w.a.Nk().bka.aJy.aKw == null) {
            strArr = null;
            str = null;
        } else {
            bs bsVar = com.baidu.live.w.a.Nk().bka.aJy.aKw;
            if (bsVar.aLe > 0) {
                this.fTw = bsVar.aLe;
            }
            if (bsVar.aLf > 0) {
                this.fTL = bsVar.aLf;
            }
            this.fTx = this.fTL;
            this.fTs = bsVar.aKX;
            this.aKZ = bsVar.aKZ;
            this.aLa = bsVar.aLa;
            this.fTt = bsVar.aLb;
            this.fTM = bsVar.aKY;
            this.aLc = bsVar.aLc;
            this.fTv = bsVar.aLd;
            this.aLg = bsVar.aLg;
            this.aLh = bsVar.aLh;
            str = bsVar.aLi;
            strArr = bsVar.aLj;
            if (bIH()) {
                this.fTu = this.aLh;
            } else {
                this.fTu = this.fTM;
            }
        }
        this.fSZ.setText(String.valueOf(this.fTw));
        this.fTa.setText(String.valueOf(this.fTx));
        this.fSZ.setSelection(this.fSZ.getText().toString().length());
        this.fTa.setSelection(this.fTa.getText().toString().length());
        TextView textView = this.fSY;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fTt));
        }
        textView.setText(str);
        this.fTl.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aLc)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aLc)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fTM))};
        }
        if (this.fTo != null) {
            this.fTo.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.fTo.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.fTo.addView(textView2, layoutParams);
            }
        }
        if (this.fTv != null && !this.fTv.isEmpty()) {
            if (this.fTv.size() == 1) {
                aVar = this.fTv.get(0);
            } else {
                aVar = this.fTv.get(0);
                aVar2 = this.fTv.get(1);
            }
            if (aVar == null) {
                this.fTe.setVisibility(8);
            } else {
                this.fTg.setText(aVar.aLk);
                this.fTe.setVisibility(0);
                this.fTy = aVar.aLl;
            }
            if (aVar2 == null) {
                this.fTf.setVisibility(8);
            } else {
                this.fTh.setText(aVar2.aLk);
                this.fTf.setVisibility(0);
                this.fTz = aVar2.aLl;
            }
            if (this.fTe.getVisibility() == 0 || this.fTf.getVisibility() == 0) {
                this.fTd.setVisibility(0);
                return;
            } else {
                this.fTd.setVisibility(8);
                return;
            }
        }
        this.fTd.setVisibility(8);
    }

    private void bIF() {
        this.fSZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!d.this.kY(true)) {
                    d.this.kZ(true);
                }
            }
        });
        this.fTa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = d.this.fTa.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (d.this.fTa.hasFocus()) {
                        d.this.fTN = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        d.this.fTa.setText(String.valueOf(parseLong));
                        return;
                    }
                    d.this.fTx = parseLong;
                    if (parseLong >= d.this.aKZ && parseLong <= d.this.aLa) {
                        d.this.fTc.setVisibility(8);
                        d.this.fTB = true;
                    } else {
                        d.this.fTc.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aKZ), Integer.valueOf(d.this.aLa)));
                        d.this.fTc.setVisibility(0);
                        d.this.fTB = false;
                    }
                } else {
                    d.this.fTc.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aKZ), Integer.valueOf(d.this.aLa)));
                    d.this.fTc.setVisibility(0);
                    d.this.fTx = 0L;
                    d.this.fTB = false;
                }
                d.this.fTa.setSelection(d.this.fTa.getText().toString().length());
                TextView textView = d.this.fTk;
                if (!d.this.fTA || !d.this.fTB) {
                    z = false;
                }
                textView.setEnabled(z);
                d.this.kY(false);
                d.this.kZ(false);
            }
        });
    }

    private void bIG() {
        this.fSZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fSZ.setText("");
                    d.this.fSZ.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fSZ.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.fTa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fTa.setText("");
                    d.this.fTa.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fTa.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kY(boolean z) {
        boolean z2 = true;
        this.fTu = this.fTM;
        String obj = this.fSZ.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.fTb.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fTr), Long.valueOf(this.fTs)));
            this.fTb.setVisibility(0);
            this.fTw = 0L;
            this.fTA = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fSZ.setText(String.valueOf(parseLong));
                return true;
            } else if (this.fTw != parseLong && this.fTw > this.fTs && parseLong > this.fTs) {
                this.fSZ.setText(String.valueOf(this.fTw));
                return true;
            } else {
                boolean z3 = bIH() && parseLong < this.aLg;
                this.fTw = parseLong;
                if (bIH()) {
                    this.fTu = this.aLh;
                }
                if (parseLong < this.fTr || parseLong > this.fTs) {
                    if (parseLong == 0) {
                        this.fSZ.setText("0");
                    }
                    this.fTb.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fTr), Long.valueOf(this.fTs)));
                    this.fTb.setVisibility(0);
                    this.fTA = false;
                } else {
                    if (z && this.fTa != null && bII() && !this.fTa.hasFocus()) {
                        boolean z4 = !this.fTN;
                        if (!z4 && this.fTa.getText() != null) {
                            String obj2 = this.fTa.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bIH()) {
                                long j = this.fTw / this.aLh;
                                if (this.aLa > 0 && j > this.aLa) {
                                    j = this.aLa;
                                }
                                this.fTa.setText(String.valueOf(j));
                            } else if (z3) {
                                this.fTa.setText(String.valueOf(this.fTL));
                            }
                        }
                    }
                    this.fTb.setVisibility(8);
                    this.fTA = true;
                }
            }
        }
        this.fSZ.setSelection(this.fSZ.getText().toString().length());
        TextView textView = this.fTk;
        if (!this.fTA || !this.fTB) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (this.fTB && this.fTA && this.fTx != 0 && this.fTw / this.fTx < this.fTu) {
            this.fTb.setVisibility(0);
            if (z) {
                this.fTb.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fTx * this.fTu)));
            } else {
                this.fTb.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fTw / this.fTu)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fTn.getVisibility() == 0) {
            this.fTn.setVisibility(8);
            return;
        }
        if (view == this.fTq && !this.fTK) {
            this.activity.finish();
        } else if (view == this.fSW && !this.fTK) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fSX) {
            this.fTn.setVisibility(0);
        } else if (view == this.fTe) {
            this.fTC = this.fTC ? false : true;
            if (this.fTC) {
                this.fTi.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fTi.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fTf) {
            this.fTD = this.fTD ? false : true;
            if (this.fTD) {
                this.fTj.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fTj.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fTk) {
            if (this.fTC && this.fTD) {
                str = this.fTy + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fTz;
            } else if (this.fTC) {
                str = this.fTy;
            } else if (this.fTD) {
                str = this.fTz;
            } else {
                str = "";
            }
            p pVar = new p();
            pVar.dW(this.fTw);
            pVar.dX(this.fTx);
            pVar.Ff(str);
            if (this.fTG != null) {
                this.fTG.a(pVar);
            }
        }
        if (this.fTK && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void la(boolean z) {
        if (this.fTk != null) {
            this.fTk.setEnabled(z);
        }
    }

    public View getView() {
        return this.fSW;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fTK = z;
        if (!z) {
            if (this.fTa != null) {
                this.fTa.clearFocus();
            }
            if (this.fSZ != null) {
                this.fSZ.clearFocus();
            }
        }
        if (this.fTm != null && this.fTm.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fTm.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fTE;
                }
            } else {
                layoutParams.topMargin = this.fTF;
            }
            this.fTm.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fTq.setVisibility(0);
        } else {
            this.fTq.setVisibility(8);
        }
    }

    public void Fq() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.Y(this.fSW);
        } else {
            h.Z(this.fSW);
        }
        if (this.fTp != null && this.fTp.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fTp.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fTI;
            } else {
                layoutParams.height = -2;
            }
            this.fTp.setLayoutParams(layoutParams);
        }
        if (this.fTm != null && this.fTm.getLayoutParams() != null && this.fTH > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fTm.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fTm.setPivotX(this.fTH / 2);
            this.fTm.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fTm.setScaleX(this.fTJ);
                this.fTm.setScaleY(this.fTJ);
            } else {
                layoutParams2.width = -1;
                this.fTm.setScaleX(1.0f);
                this.fTm.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fTK);
        }
    }

    private boolean bIH() {
        return bII() && this.fTw >= this.aLg && this.fTw <= this.fTs;
    }

    private boolean bII() {
        return this.aLg >= ((long) this.fTr) && this.aLh > 0;
    }
}
