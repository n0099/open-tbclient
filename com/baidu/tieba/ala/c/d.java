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
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private int aFP;
    private int aFQ;
    private int aFS;
    private long aFW;
    private int aFX;
    private Activity activity;
    private int cXV;
    private View fHF;
    private View fHG;
    private TextView fHH;
    private EditText fHI;
    private EditText fHJ;
    private TextView fHK;
    private TextView fHL;
    private LinearLayout fHM;
    private LinearLayout fHN;
    private LinearLayout fHO;
    private TextView fHP;
    private TextView fHQ;
    private ImageView fHR;
    private ImageView fHS;
    private TextView fHT;
    private TextView fHU;
    private RelativeLayout fHV;
    private LinearLayout fHW;
    private LinearLayout fHX;
    private ScrollView fHY;
    private View fHZ;
    private long fIb;
    private int fIc;
    private int fId;
    private List<bq.a> fIe;
    private long fIg;
    private String fIh;
    private String fIi;
    private boolean fIl;
    private boolean fIm;
    private int fIn;
    private int fIo;
    private c fIp;
    private int fIq;
    private int fIr;
    private float fIs;
    private boolean fIt;
    private int fIv;
    private boolean fIw;
    private int screenWidth;
    private int fIa = 2000;
    private long fIf = 2000;
    private boolean fIj = true;
    private boolean fIk = true;
    private int fIu = 10;

    public d(final Activity activity, c cVar) {
        this.activity = activity;
        this.fIp = cVar;
        initView();
        initData();
        bzC();
        bzD();
        this.fHV.setVisibility(4);
        this.fHV.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                d.this.cXV = ScreenHelper.getScreenHeight(activity);
                if (d.this.screenWidth > d.this.cXV) {
                    int i = d.this.screenWidth;
                    d.this.screenWidth = d.this.cXV;
                    d.this.cXV = i;
                }
                d.this.fIq = d.this.screenWidth;
                d.this.fIo = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                d.this.fIr = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = d.this.screenWidth - (d.this.fIo * 2);
                d.this.fIs = (i2 * 1.0f) / d.this.fHV.getHeight();
                if (d.this.cXV > d.this.fHV.getHeight()) {
                    d.this.fIn = (d.this.cXV - d.this.fHV.getHeight()) / 2;
                }
                d.this.zN();
                d.this.fHV.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.fHF = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fHG = this.fHF.findViewById(a.g.iv_send_red_q);
        this.fHH = (TextView) this.fHF.findViewById(a.g.tv_red_broad_hint);
        this.fHI = (EditText) this.fHF.findViewById(a.g.edt_t_num);
        this.fHJ = (EditText) this.fHF.findViewById(a.g.edt_pkt_num);
        this.fHK = (TextView) this.fHF.findViewById(a.g.tv_send_t_num_hint);
        this.fHL = (TextView) this.fHF.findViewById(a.g.tv_send_pkt_num_hint);
        this.fHM = (LinearLayout) this.fHF.findViewById(a.g.layout_red_pkt_condition);
        this.fHN = (LinearLayout) this.fHF.findViewById(a.g.layout_condition_first);
        this.fHO = (LinearLayout) this.fHF.findViewById(a.g.layout_condition_second);
        this.fHV = (RelativeLayout) this.fHF.findViewById(a.g.layout_send_red_content);
        View findViewById = this.fHF.findViewById(a.g.layout_send_red);
        this.fHP = (TextView) this.fHF.findViewById(a.g.tv_condition_first);
        this.fHQ = (TextView) this.fHF.findViewById(a.g.tv_condition_second);
        this.fHR = (ImageView) this.fHF.findViewById(a.g.iv_condition_first);
        this.fHS = (ImageView) this.fHF.findViewById(a.g.iv_condition_second);
        this.fHT = (TextView) this.fHF.findViewById(a.g.tv_send_pkt_submit);
        this.fHU = (TextView) this.fHF.findViewById(a.g.tv_send_pkt_time);
        this.fHW = (LinearLayout) this.fHF.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.fHF.findViewById(a.g.layout_red_send_rule_content);
        this.fHX = (LinearLayout) this.fHF.findViewById(a.g.layout_rule_desc);
        this.fHY = (ScrollView) this.fHF.findViewById(a.g.layout_input_scroll);
        this.fHZ = this.fHF.findViewById(a.g.layout_send_red_close);
        this.fHF.setOnClickListener(this);
        this.fHN.setOnClickListener(this);
        this.fHO.setOnClickListener(this);
        this.fHT.setOnClickListener(this);
        this.fHG.setOnClickListener(this);
        this.fHW.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.fHZ.setOnClickListener(this);
        ((ImageView) this.fHF.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        bq.a aVar;
        bq.a aVar2 = null;
        if (com.baidu.live.v.a.Hs() == null || com.baidu.live.v.a.Hs().beo == null || com.baidu.live.v.a.Hs().beo.aEo == null || com.baidu.live.v.a.Hs().beo.aEo.aFm == null) {
            strArr = null;
            str = null;
        } else {
            bq bqVar = com.baidu.live.v.a.Hs().beo.aEo.aFm;
            if (bqVar.aFU > 0) {
                this.fIf = bqVar.aFU;
            }
            if (bqVar.aFV > 0) {
                this.fIu = bqVar.aFV;
            }
            this.fIg = this.fIu;
            this.fIb = bqVar.aFN;
            this.aFP = bqVar.aFP;
            this.aFQ = bqVar.aFQ;
            this.fIc = bqVar.aFR;
            this.fIv = bqVar.aFO;
            this.aFS = bqVar.aFS;
            this.fIe = bqVar.aFT;
            this.aFW = bqVar.aFW;
            this.aFX = bqVar.aFX;
            str = bqVar.aFY;
            strArr = bqVar.aFZ;
            if (bzE()) {
                this.fId = this.aFX;
            } else {
                this.fId = this.fIv;
            }
        }
        this.fHI.setText(String.valueOf(this.fIf));
        this.fHJ.setText(String.valueOf(this.fIg));
        this.fHI.setSelection(this.fHI.getText().toString().length());
        this.fHJ.setSelection(this.fHJ.getText().toString().length());
        TextView textView = this.fHH;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fIc));
        }
        textView.setText(str);
        this.fHU.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aFS)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aFS)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fIv))};
        }
        if (this.fHX != null) {
            this.fHX.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.fHX.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.fHX.addView(textView2, layoutParams);
            }
        }
        if (this.fIe != null && !this.fIe.isEmpty()) {
            if (this.fIe.size() == 1) {
                aVar = this.fIe.get(0);
            } else {
                aVar = this.fIe.get(0);
                aVar2 = this.fIe.get(1);
            }
            if (aVar == null) {
                this.fHN.setVisibility(8);
            } else {
                this.fHP.setText(aVar.aGa);
                this.fHN.setVisibility(0);
                this.fIh = aVar.aGb;
            }
            if (aVar2 == null) {
                this.fHO.setVisibility(8);
            } else {
                this.fHQ.setText(aVar2.aGa);
                this.fHO.setVisibility(0);
                this.fIi = aVar2.aGb;
            }
            if (this.fHN.getVisibility() == 0 || this.fHO.getVisibility() == 0) {
                this.fHM.setVisibility(0);
                return;
            } else {
                this.fHM.setVisibility(8);
                return;
            }
        }
        this.fHM.setVisibility(8);
    }

    private void bzC() {
        this.fHI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!d.this.kA(true)) {
                    d.this.kB(true);
                }
            }
        });
        this.fHJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = d.this.fHJ.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (d.this.fHJ.hasFocus()) {
                        d.this.fIw = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        d.this.fHJ.setText(String.valueOf(parseLong));
                        return;
                    }
                    d.this.fIg = parseLong;
                    if (parseLong >= d.this.aFP && parseLong <= d.this.aFQ) {
                        d.this.fHL.setVisibility(8);
                        d.this.fIk = true;
                    } else {
                        d.this.fHL.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aFP), Integer.valueOf(d.this.aFQ)));
                        d.this.fHL.setVisibility(0);
                        d.this.fIk = false;
                    }
                } else {
                    d.this.fHL.setText(String.format(d.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(d.this.aFP), Integer.valueOf(d.this.aFQ)));
                    d.this.fHL.setVisibility(0);
                    d.this.fIg = 0L;
                    d.this.fIk = false;
                }
                d.this.fHJ.setSelection(d.this.fHJ.getText().toString().length());
                TextView textView = d.this.fHT;
                if (!d.this.fIj || !d.this.fIk) {
                    z = false;
                }
                textView.setEnabled(z);
                d.this.kA(false);
                d.this.kB(false);
            }
        });
    }

    private void bzD() {
        this.fHI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fHI.setText("");
                    d.this.fHI.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fHI.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.fHJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.d.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    d.this.fHJ.setText("");
                    d.this.fHJ.post(new Runnable() { // from class: com.baidu.tieba.ala.c.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.fHJ.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kA(boolean z) {
        boolean z2 = true;
        this.fId = this.fIv;
        String obj = this.fHI.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.fHK.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fIa), Long.valueOf(this.fIb)));
            this.fHK.setVisibility(0);
            this.fIf = 0L;
            this.fIj = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fHI.setText(String.valueOf(parseLong));
                return true;
            } else if (this.fIf != parseLong && this.fIf > this.fIb && parseLong > this.fIb) {
                this.fHI.setText(String.valueOf(this.fIf));
                return true;
            } else {
                boolean z3 = bzE() && parseLong < this.aFW;
                this.fIf = parseLong;
                if (bzE()) {
                    this.fId = this.aFX;
                }
                if (parseLong < this.fIa || parseLong > this.fIb) {
                    if (parseLong == 0) {
                        this.fHI.setText("0");
                    }
                    this.fHK.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fIa), Long.valueOf(this.fIb)));
                    this.fHK.setVisibility(0);
                    this.fIj = false;
                } else {
                    if (z && this.fHJ != null && bzF() && !this.fHJ.hasFocus()) {
                        boolean z4 = !this.fIw;
                        if (!z4 && this.fHJ.getText() != null) {
                            String obj2 = this.fHJ.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bzE()) {
                                long j = this.fIf / this.aFX;
                                if (this.aFQ > 0 && j > this.aFQ) {
                                    j = this.aFQ;
                                }
                                this.fHJ.setText(String.valueOf(j));
                            } else if (z3) {
                                this.fHJ.setText(String.valueOf(this.fIu));
                            }
                        }
                    }
                    this.fHK.setVisibility(8);
                    this.fIj = true;
                }
            }
        }
        this.fHI.setSelection(this.fHI.getText().toString().length());
        TextView textView = this.fHT;
        if (!this.fIj || !this.fIk) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(boolean z) {
        if (this.fIk && this.fIj && this.fIg != 0 && this.fIf / this.fIg < this.fId) {
            this.fHK.setVisibility(0);
            if (z) {
                this.fHK.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fIg * this.fId)));
            } else {
                this.fHK.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fIf / this.fId)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fHW.getVisibility() == 0) {
            this.fHW.setVisibility(8);
            return;
        }
        if (view == this.fHZ && !this.fIt) {
            this.activity.finish();
        } else if (view == this.fHF && !this.fIt) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fHG) {
            this.fHW.setVisibility(0);
        } else if (view == this.fHN) {
            this.fIl = this.fIl ? false : true;
            if (this.fIl) {
                this.fHR.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fHR.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fHO) {
            this.fIm = this.fIm ? false : true;
            if (this.fIm) {
                this.fHS.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fHS.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fHT) {
            if (this.fIl && this.fIm) {
                str = this.fIh + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fIi;
            } else if (this.fIl) {
                str = this.fIh;
            } else if (this.fIm) {
                str = this.fIi;
            } else {
                str = "";
            }
            p pVar = new p();
            pVar.dL(this.fIf);
            pVar.dM(this.fIg);
            pVar.CK(str);
            if (this.fIp != null) {
                this.fIp.a(pVar);
            }
        }
        if (this.fIt && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void kC(boolean z) {
        if (this.fHT != null) {
            this.fHT.setEnabled(z);
        }
    }

    public View getView() {
        return this.fHF;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fIt = z;
        if (!z) {
            if (this.fHJ != null) {
                this.fHJ.clearFocus();
            }
            if (this.fHI != null) {
                this.fHI.clearFocus();
            }
        }
        if (this.fHV != null && this.fHV.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fHV.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fIn;
                }
            } else {
                layoutParams.topMargin = this.fIo;
            }
            this.fHV.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fHZ.setVisibility(0);
        } else {
            this.fHZ.setVisibility(8);
        }
    }

    public void zN() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.X(this.fHF);
        } else {
            h.Y(this.fHF);
        }
        if (this.fHY != null && this.fHY.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fHY.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fIr;
            } else {
                layoutParams.height = -2;
            }
            this.fHY.setLayoutParams(layoutParams);
        }
        if (this.fHV != null && this.fHV.getLayoutParams() != null && this.fIq > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fHV.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fHV.setPivotX(this.fIq / 2);
            this.fHV.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fHV.setScaleX(this.fIs);
                this.fHV.setScaleY(this.fIs);
            } else {
                layoutParams2.width = -1;
                this.fHV.setScaleX(1.0f);
                this.fHV.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fIt);
        }
    }

    private boolean bzE() {
        return bzF() && this.fIf >= this.aFW && this.fIf <= this.fIb;
    }

    private boolean bzF() {
        return this.aFW >= ((long) this.fIa) && this.aFX > 0;
    }
}
