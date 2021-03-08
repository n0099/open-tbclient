package com.baidu.tieba.ala.d;

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
import com.baidu.live.data.cs;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.s;
import java.util.List;
/* loaded from: classes10.dex */
public class f implements View.OnClickListener {
    private int aTD;
    private int aTE;
    private int aTG;
    private long aTL;
    private int aTM;
    private Activity activity;
    private int dWJ;
    private View gSJ;
    private View gSK;
    private TextView gSL;
    private EditText gSM;
    private EditText gSN;
    private TextView gSO;
    private TextView gSP;
    private LinearLayout gSQ;
    private LinearLayout gSR;
    private LinearLayout gSS;
    private TextView gST;
    private TextView gSU;
    private ImageView gSV;
    private ImageView gSW;
    private TextView gSX;
    private TextView gSY;
    private RelativeLayout gSZ;
    private boolean gTA;
    private LinearLayout gTa;
    private LinearLayout gTb;
    private ScrollView gTc;
    private View gTd;
    private long gTf;
    private int gTg;
    private int gTh;
    private List<cs.a> gTi;
    private long gTk;
    private String gTl;
    private String gTm;
    private boolean gTp;
    private boolean gTq;
    private int gTr;
    private int gTs;
    private e gTt;
    private int gTu;
    private int gTv;
    private float gTw;
    private boolean gTx;
    private int gTz;
    private int screenWidth;
    private int gTe = 2000;
    private long gTj = 2000;
    private boolean gTn = true;
    private boolean gTo = true;
    private int gTy = 10;

    public f(final Activity activity, e eVar) {
        this.activity = activity;
        this.gTt = eVar;
        initView();
        initData();
        bUj();
        bUk();
        this.gSZ.setVisibility(4);
        this.gSZ.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                f.this.dWJ = ScreenHelper.getScreenHeight(activity);
                if (f.this.screenWidth > f.this.dWJ) {
                    int i = f.this.screenWidth;
                    f.this.screenWidth = f.this.dWJ;
                    f.this.dWJ = i;
                }
                f.this.gTu = f.this.screenWidth;
                f.this.gTs = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                f.this.gTv = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = f.this.screenWidth - (f.this.gTs * 2);
                f.this.gTw = (i2 * 1.0f) / f.this.gSZ.getHeight();
                if (f.this.dWJ > f.this.gSZ.getHeight()) {
                    f.this.gTr = (f.this.dWJ - f.this.gSZ.getHeight()) / 2;
                }
                f.this.FQ();
                f.this.gSZ.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gSJ = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gSK = this.gSJ.findViewById(a.f.iv_send_red_q);
        this.gSL = (TextView) this.gSJ.findViewById(a.f.tv_red_broad_hint);
        this.gSM = (EditText) this.gSJ.findViewById(a.f.edt_t_num);
        this.gSN = (EditText) this.gSJ.findViewById(a.f.edt_pkt_num);
        this.gSO = (TextView) this.gSJ.findViewById(a.f.tv_send_t_num_hint);
        this.gSP = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_num_hint);
        this.gSQ = (LinearLayout) this.gSJ.findViewById(a.f.layout_red_pkt_condition);
        this.gSR = (LinearLayout) this.gSJ.findViewById(a.f.layout_condition_first);
        this.gSS = (LinearLayout) this.gSJ.findViewById(a.f.layout_condition_second);
        this.gSZ = (RelativeLayout) this.gSJ.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gSJ.findViewById(a.f.layout_send_red);
        this.gST = (TextView) this.gSJ.findViewById(a.f.tv_condition_first);
        this.gSU = (TextView) this.gSJ.findViewById(a.f.tv_condition_second);
        this.gSV = (ImageView) this.gSJ.findViewById(a.f.iv_condition_first);
        this.gSW = (ImageView) this.gSJ.findViewById(a.f.iv_condition_second);
        this.gSX = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_submit);
        this.gSY = (TextView) this.gSJ.findViewById(a.f.tv_send_pkt_time);
        this.gTa = (LinearLayout) this.gSJ.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gSJ.findViewById(a.f.layout_red_send_rule_content);
        this.gTb = (LinearLayout) this.gSJ.findViewById(a.f.layout_rule_desc);
        this.gTc = (ScrollView) this.gSJ.findViewById(a.f.layout_input_scroll);
        this.gTd = this.gSJ.findViewById(a.f.layout_send_red_close);
        this.gSJ.setOnClickListener(this);
        this.gSR.setOnClickListener(this);
        this.gSS.setOnClickListener(this);
        this.gSX.setOnClickListener(this);
        this.gSK.setOnClickListener(this);
        this.gTa.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gTd.setOnClickListener(this);
        ((ImageView) this.gSJ.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cs.a aVar;
        cs.a aVar2 = null;
        if (com.baidu.live.ae.a.Qm() == null || com.baidu.live.ae.a.Qm().bCs == null || com.baidu.live.ae.a.Qm().bCs.aRm == null || com.baidu.live.ae.a.Qm().bCs.aRm.aSV == null) {
            strArr = null;
            str = null;
        } else {
            cs csVar = com.baidu.live.ae.a.Qm().bCs.aRm.aSV;
            if (csVar.aTJ > 0) {
                this.gTj = csVar.aTJ;
            }
            if (csVar.aTK > 0) {
                this.gTy = csVar.aTK;
            }
            this.gTk = this.gTy;
            this.gTf = csVar.aTB;
            this.aTD = csVar.aTD;
            this.aTE = csVar.aTE;
            this.gTg = csVar.aTF;
            this.gTz = csVar.aTC;
            this.aTG = csVar.aTG;
            this.gTi = csVar.aTH;
            this.aTL = csVar.aTL;
            this.aTM = csVar.aTM;
            str = csVar.aTN;
            strArr = csVar.aTO;
            if (bUl()) {
                this.gTh = this.aTM;
            } else {
                this.gTh = this.gTz;
            }
        }
        this.gSM.setText(String.valueOf(this.gTj));
        this.gSN.setText(String.valueOf(this.gTk));
        this.gSM.setSelection(this.gSM.getText().toString().length());
        this.gSN.setSelection(this.gSN.getText().toString().length());
        TextView textView = this.gSL;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gTg));
        }
        textView.setText(str);
        this.gSY.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aTG)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aTG)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gTz))};
        }
        if (this.gTb != null) {
            this.gTb.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gTb.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gTb.addView(textView2, layoutParams);
            }
        }
        if (this.gTi != null && !this.gTi.isEmpty()) {
            if (this.gTi.size() == 1) {
                aVar = this.gTi.get(0);
            } else {
                aVar = this.gTi.get(0);
                aVar2 = this.gTi.get(1);
            }
            if (aVar == null) {
                this.gSR.setVisibility(8);
            } else {
                this.gST.setText(aVar.aTP);
                this.gSR.setVisibility(0);
                this.gTl = aVar.aTQ;
            }
            if (aVar2 == null) {
                this.gSS.setVisibility(8);
            } else {
                this.gSU.setText(aVar2.aTP);
                this.gSS.setVisibility(0);
                this.gTm = aVar2.aTQ;
            }
            if (this.gSR.getVisibility() == 0 || this.gSS.getVisibility() == 0) {
                this.gSQ.setVisibility(0);
                return;
            } else {
                this.gSQ.setVisibility(8);
                return;
            }
        }
        this.gSQ.setVisibility(8);
    }

    private void bUj() {
        this.gSM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!f.this.mW(true)) {
                    f.this.mX(true);
                }
            }
        });
        this.gSN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = f.this.gSN.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (f.this.gSN.hasFocus()) {
                        f.this.gTA = true;
                    }
                    try {
                        long parseLong = Long.parseLong(obj);
                        if (obj.startsWith("0")) {
                            f.this.gSN.setText(String.valueOf(parseLong));
                            return;
                        }
                        f.this.gTk = parseLong;
                        if (parseLong >= f.this.aTD && parseLong <= f.this.aTE) {
                            f.this.gSP.setVisibility(8);
                            f.this.gTo = true;
                        } else {
                            f.this.gSP.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aTD), Integer.valueOf(f.this.aTE)));
                            f.this.gSP.setVisibility(0);
                            f.this.gTo = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    f.this.gSP.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aTD), Integer.valueOf(f.this.aTE)));
                    f.this.gSP.setVisibility(0);
                    f.this.gTk = 0L;
                    f.this.gTo = false;
                }
                f.this.gSN.setSelection(f.this.gSN.getText().toString().length());
                TextView textView = f.this.gSX;
                if (!f.this.gTn || !f.this.gTo) {
                    z = false;
                }
                textView.setEnabled(z);
                f.this.mW(false);
                f.this.mX(false);
            }
        });
    }

    private void bUk() {
        this.gSM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gSM.setText("");
                    f.this.gSM.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gSM.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gSN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gSN.setText("");
                    f.this.gSN.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gSN.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mW(boolean z) {
        long j;
        boolean z2 = true;
        this.gTh = this.gTz;
        String obj = this.gSM.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTe), Long.valueOf(this.gTf)));
            this.gSO.setVisibility(0);
            this.gTj = 0L;
            this.gTn = false;
        } else {
            try {
                j = Long.parseLong(obj);
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (obj.startsWith("0")) {
                this.gSM.setText(String.valueOf(j));
                return true;
            } else if (this.gTj != j && this.gTj > this.gTf && j > this.gTf) {
                this.gSM.setText(String.valueOf(this.gTj));
                return true;
            } else {
                boolean z3 = bUl() && j < this.aTL;
                this.gTj = j;
                if (bUl()) {
                    this.gTh = this.aTM;
                }
                if (j < this.gTe || j > this.gTf) {
                    if (j == 0) {
                        this.gSM.setText("0");
                    }
                    this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gTe), Long.valueOf(this.gTf)));
                    this.gSO.setVisibility(0);
                    this.gTn = false;
                } else {
                    if (z && this.gSN != null && bUm() && !this.gSN.hasFocus()) {
                        boolean z4 = !this.gTA;
                        if (!z4 && this.gSN.getText() != null) {
                            String obj2 = this.gSN.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bUl()) {
                                long j2 = this.gTj / this.aTM;
                                if (this.aTE > 0 && j2 > this.aTE) {
                                    j2 = this.aTE;
                                }
                                this.gSN.setText(String.valueOf(j2));
                            } else if (z3) {
                                this.gSN.setText(String.valueOf(this.gTy));
                            }
                        }
                    }
                    this.gSO.setVisibility(8);
                    this.gTn = true;
                }
            }
        }
        this.gSM.setSelection(this.gSM.getText().toString().length());
        TextView textView = this.gSX;
        if (!this.gTn || !this.gTo) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        if (this.gTo && this.gTn && this.gTk != 0 && this.gTj / this.gTk < this.gTh) {
            this.gSO.setVisibility(0);
            if (z) {
                this.gSO.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gTk * this.gTh)));
            } else {
                this.gSO.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gTj / this.gTh)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gTa.getVisibility() == 0) {
            this.gTa.setVisibility(8);
            return;
        }
        if (view == this.gTd && !this.gTx) {
            this.activity.finish();
        } else if (view == this.gSJ && !this.gTx) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gSK) {
            this.gTa.setVisibility(0);
        } else if (view == this.gSR) {
            this.gTp = this.gTp ? false : true;
            if (this.gTp) {
                this.gSV.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSV.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gSS) {
            this.gTq = this.gTq ? false : true;
            if (this.gTq) {
                this.gSW.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gSW.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gSX) {
            if (this.gTp && this.gTq) {
                str = this.gTl + "," + this.gTm;
            } else if (this.gTp) {
                str = this.gTl;
            } else if (this.gTq) {
                str = this.gTm;
            } else {
                str = "";
            }
            s sVar = new s();
            sVar.fo(this.gTj);
            sVar.fp(this.gTk);
            sVar.GM(str);
            if (this.gTt != null) {
                this.gTt.a(sVar);
            }
        }
        if (this.gTx && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mY(boolean z) {
        if (this.gSX != null) {
            this.gSX.setEnabled(z);
        }
    }

    public View getView() {
        return this.gSJ;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gTx = z;
        if (!z) {
            if (this.gSN != null) {
                this.gSN.clearFocus();
            }
            if (this.gSM != null) {
                this.gSM.clearFocus();
            }
        }
        if (this.gSZ != null && this.gSZ.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSZ.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gTr;
                }
            } else {
                layoutParams.topMargin = this.gTs;
            }
            this.gSZ.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTd.setVisibility(0);
        } else {
            this.gTd.setVisibility(8);
        }
    }

    public void FQ() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gSJ);
        } else {
            i.af(this.gSJ);
        }
        if (this.gTc != null && this.gTc.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTc.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gTv;
            } else {
                layoutParams.height = -2;
            }
            this.gTc.setLayoutParams(layoutParams);
        }
        if (this.gSZ != null && this.gSZ.getLayoutParams() != null && this.gTu > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gSZ.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gSZ.setPivotX(this.gTu / 2);
            this.gSZ.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gSZ.setScaleX(this.gTw);
                this.gSZ.setScaleY(this.gTw);
            } else {
                layoutParams2.width = -1;
                this.gSZ.setScaleX(1.0f);
                this.gSZ.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gTx);
        }
    }

    private boolean bUl() {
        return bUm() && this.gTj >= this.aTL && this.gTj <= this.gTf;
    }

    private boolean bUm() {
        return this.aTL >= ((long) this.gTe) && this.aTM > 0;
    }
}
