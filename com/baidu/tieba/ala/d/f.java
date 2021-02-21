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
/* loaded from: classes11.dex */
public class f implements View.OnClickListener {
    private int aSd;
    private int aSe;
    private int aSg;
    private long aSl;
    private int aSm;
    private Activity activity;
    private int dVi;
    private long gRB;
    private String gRC;
    private String gRD;
    private boolean gRG;
    private boolean gRH;
    private int gRI;
    private int gRJ;
    private e gRK;
    private int gRL;
    private int gRM;
    private float gRN;
    private boolean gRO;
    private int gRQ;
    private boolean gRR;
    private View gRa;
    private View gRb;
    private TextView gRc;
    private EditText gRd;
    private EditText gRe;
    private TextView gRf;
    private TextView gRg;
    private LinearLayout gRh;
    private LinearLayout gRi;
    private LinearLayout gRj;
    private TextView gRk;
    private TextView gRl;
    private ImageView gRm;
    private ImageView gRn;
    private TextView gRo;
    private TextView gRp;
    private RelativeLayout gRq;
    private LinearLayout gRr;
    private LinearLayout gRs;
    private ScrollView gRt;
    private View gRu;
    private long gRw;
    private int gRx;
    private int gRy;
    private List<cs.a> gRz;
    private int screenWidth;
    private int gRv = 2000;
    private long gRA = 2000;
    private boolean gRE = true;
    private boolean gRF = true;
    private int gRP = 10;

    public f(final Activity activity, e eVar) {
        this.activity = activity;
        this.gRK = eVar;
        initView();
        initData();
        bUd();
        bUe();
        this.gRq.setVisibility(4);
        this.gRq.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                f.this.dVi = ScreenHelper.getScreenHeight(activity);
                if (f.this.screenWidth > f.this.dVi) {
                    int i = f.this.screenWidth;
                    f.this.screenWidth = f.this.dVi;
                    f.this.dVi = i;
                }
                f.this.gRL = f.this.screenWidth;
                f.this.gRJ = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                f.this.gRM = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = f.this.screenWidth - (f.this.gRJ * 2);
                f.this.gRN = (i2 * 1.0f) / f.this.gRq.getHeight();
                if (f.this.dVi > f.this.gRq.getHeight()) {
                    f.this.gRI = (f.this.dVi - f.this.gRq.getHeight()) / 2;
                }
                f.this.FN();
                f.this.gRq.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gRa = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gRb = this.gRa.findViewById(a.f.iv_send_red_q);
        this.gRc = (TextView) this.gRa.findViewById(a.f.tv_red_broad_hint);
        this.gRd = (EditText) this.gRa.findViewById(a.f.edt_t_num);
        this.gRe = (EditText) this.gRa.findViewById(a.f.edt_pkt_num);
        this.gRf = (TextView) this.gRa.findViewById(a.f.tv_send_t_num_hint);
        this.gRg = (TextView) this.gRa.findViewById(a.f.tv_send_pkt_num_hint);
        this.gRh = (LinearLayout) this.gRa.findViewById(a.f.layout_red_pkt_condition);
        this.gRi = (LinearLayout) this.gRa.findViewById(a.f.layout_condition_first);
        this.gRj = (LinearLayout) this.gRa.findViewById(a.f.layout_condition_second);
        this.gRq = (RelativeLayout) this.gRa.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gRa.findViewById(a.f.layout_send_red);
        this.gRk = (TextView) this.gRa.findViewById(a.f.tv_condition_first);
        this.gRl = (TextView) this.gRa.findViewById(a.f.tv_condition_second);
        this.gRm = (ImageView) this.gRa.findViewById(a.f.iv_condition_first);
        this.gRn = (ImageView) this.gRa.findViewById(a.f.iv_condition_second);
        this.gRo = (TextView) this.gRa.findViewById(a.f.tv_send_pkt_submit);
        this.gRp = (TextView) this.gRa.findViewById(a.f.tv_send_pkt_time);
        this.gRr = (LinearLayout) this.gRa.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gRa.findViewById(a.f.layout_red_send_rule_content);
        this.gRs = (LinearLayout) this.gRa.findViewById(a.f.layout_rule_desc);
        this.gRt = (ScrollView) this.gRa.findViewById(a.f.layout_input_scroll);
        this.gRu = this.gRa.findViewById(a.f.layout_send_red_close);
        this.gRa.setOnClickListener(this);
        this.gRi.setOnClickListener(this);
        this.gRj.setOnClickListener(this);
        this.gRo.setOnClickListener(this);
        this.gRb.setOnClickListener(this);
        this.gRr.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gRu.setOnClickListener(this);
        ((ImageView) this.gRa.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cs.a aVar;
        cs.a aVar2 = null;
        if (com.baidu.live.ae.a.Qj() == null || com.baidu.live.ae.a.Qj().bAS == null || com.baidu.live.ae.a.Qj().bAS.aPM == null || com.baidu.live.ae.a.Qj().bAS.aPM.aRv == null) {
            strArr = null;
            str = null;
        } else {
            cs csVar = com.baidu.live.ae.a.Qj().bAS.aPM.aRv;
            if (csVar.aSj > 0) {
                this.gRA = csVar.aSj;
            }
            if (csVar.aSk > 0) {
                this.gRP = csVar.aSk;
            }
            this.gRB = this.gRP;
            this.gRw = csVar.aSb;
            this.aSd = csVar.aSd;
            this.aSe = csVar.aSe;
            this.gRx = csVar.aSf;
            this.gRQ = csVar.aSc;
            this.aSg = csVar.aSg;
            this.gRz = csVar.aSh;
            this.aSl = csVar.aSl;
            this.aSm = csVar.aSm;
            str = csVar.aSn;
            strArr = csVar.aSo;
            if (bUf()) {
                this.gRy = this.aSm;
            } else {
                this.gRy = this.gRQ;
            }
        }
        this.gRd.setText(String.valueOf(this.gRA));
        this.gRe.setText(String.valueOf(this.gRB));
        this.gRd.setSelection(this.gRd.getText().toString().length());
        this.gRe.setSelection(this.gRe.getText().toString().length());
        TextView textView = this.gRc;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gRx));
        }
        textView.setText(str);
        this.gRp.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aSg)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aSg)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gRQ))};
        }
        if (this.gRs != null) {
            this.gRs.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gRs.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gRs.addView(textView2, layoutParams);
            }
        }
        if (this.gRz != null && !this.gRz.isEmpty()) {
            if (this.gRz.size() == 1) {
                aVar = this.gRz.get(0);
            } else {
                aVar = this.gRz.get(0);
                aVar2 = this.gRz.get(1);
            }
            if (aVar == null) {
                this.gRi.setVisibility(8);
            } else {
                this.gRk.setText(aVar.aSp);
                this.gRi.setVisibility(0);
                this.gRC = aVar.aSq;
            }
            if (aVar2 == null) {
                this.gRj.setVisibility(8);
            } else {
                this.gRl.setText(aVar2.aSp);
                this.gRj.setVisibility(0);
                this.gRD = aVar2.aSq;
            }
            if (this.gRi.getVisibility() == 0 || this.gRj.getVisibility() == 0) {
                this.gRh.setVisibility(0);
                return;
            } else {
                this.gRh.setVisibility(8);
                return;
            }
        }
        this.gRh.setVisibility(8);
    }

    private void bUd() {
        this.gRd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.2
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
        this.gRe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = f.this.gRe.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (f.this.gRe.hasFocus()) {
                        f.this.gRR = true;
                    }
                    try {
                        long parseLong = Long.parseLong(obj);
                        if (obj.startsWith("0")) {
                            f.this.gRe.setText(String.valueOf(parseLong));
                            return;
                        }
                        f.this.gRB = parseLong;
                        if (parseLong >= f.this.aSd && parseLong <= f.this.aSe) {
                            f.this.gRg.setVisibility(8);
                            f.this.gRF = true;
                        } else {
                            f.this.gRg.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aSd), Integer.valueOf(f.this.aSe)));
                            f.this.gRg.setVisibility(0);
                            f.this.gRF = false;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    f.this.gRg.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aSd), Integer.valueOf(f.this.aSe)));
                    f.this.gRg.setVisibility(0);
                    f.this.gRB = 0L;
                    f.this.gRF = false;
                }
                f.this.gRe.setSelection(f.this.gRe.getText().toString().length());
                TextView textView = f.this.gRo;
                if (!f.this.gRE || !f.this.gRF) {
                    z = false;
                }
                textView.setEnabled(z);
                f.this.mW(false);
                f.this.mX(false);
            }
        });
    }

    private void bUe() {
        this.gRd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gRd.setText("");
                    f.this.gRd.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gRd.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gRe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gRe.setText("");
                    f.this.gRe.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gRe.setOnFocusChangeListener(null);
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
        this.gRy = this.gRQ;
        String obj = this.gRd.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gRf.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gRv), Long.valueOf(this.gRw)));
            this.gRf.setVisibility(0);
            this.gRA = 0L;
            this.gRE = false;
        } else {
            try {
                j = Long.parseLong(obj);
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (obj.startsWith("0")) {
                this.gRd.setText(String.valueOf(j));
                return true;
            } else if (this.gRA != j && this.gRA > this.gRw && j > this.gRw) {
                this.gRd.setText(String.valueOf(this.gRA));
                return true;
            } else {
                boolean z3 = bUf() && j < this.aSl;
                this.gRA = j;
                if (bUf()) {
                    this.gRy = this.aSm;
                }
                if (j < this.gRv || j > this.gRw) {
                    if (j == 0) {
                        this.gRd.setText("0");
                    }
                    this.gRf.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gRv), Long.valueOf(this.gRw)));
                    this.gRf.setVisibility(0);
                    this.gRE = false;
                } else {
                    if (z && this.gRe != null && bUg() && !this.gRe.hasFocus()) {
                        boolean z4 = !this.gRR;
                        if (!z4 && this.gRe.getText() != null) {
                            String obj2 = this.gRe.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bUf()) {
                                long j2 = this.gRA / this.aSm;
                                if (this.aSe > 0 && j2 > this.aSe) {
                                    j2 = this.aSe;
                                }
                                this.gRe.setText(String.valueOf(j2));
                            } else if (z3) {
                                this.gRe.setText(String.valueOf(this.gRP));
                            }
                        }
                    }
                    this.gRf.setVisibility(8);
                    this.gRE = true;
                }
            }
        }
        this.gRd.setSelection(this.gRd.getText().toString().length());
        TextView textView = this.gRo;
        if (!this.gRE || !this.gRF) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mX(boolean z) {
        if (this.gRF && this.gRE && this.gRB != 0 && this.gRA / this.gRB < this.gRy) {
            this.gRf.setVisibility(0);
            if (z) {
                this.gRf.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gRB * this.gRy)));
            } else {
                this.gRf.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gRA / this.gRy)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gRr.getVisibility() == 0) {
            this.gRr.setVisibility(8);
            return;
        }
        if (view == this.gRu && !this.gRO) {
            this.activity.finish();
        } else if (view == this.gRa && !this.gRO) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gRb) {
            this.gRr.setVisibility(0);
        } else if (view == this.gRi) {
            this.gRG = this.gRG ? false : true;
            if (this.gRG) {
                this.gRm.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gRm.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gRj) {
            this.gRH = this.gRH ? false : true;
            if (this.gRH) {
                this.gRn.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gRn.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gRo) {
            if (this.gRG && this.gRH) {
                str = this.gRC + "," + this.gRD;
            } else if (this.gRG) {
                str = this.gRC;
            } else if (this.gRH) {
                str = this.gRD;
            } else {
                str = "";
            }
            s sVar = new s();
            sVar.fo(this.gRA);
            sVar.fp(this.gRB);
            sVar.GD(str);
            if (this.gRK != null) {
                this.gRK.a(sVar);
            }
        }
        if (this.gRO && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void mY(boolean z) {
        if (this.gRo != null) {
            this.gRo.setEnabled(z);
        }
    }

    public View getView() {
        return this.gRa;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gRO = z;
        if (!z) {
            if (this.gRe != null) {
                this.gRe.clearFocus();
            }
            if (this.gRd != null) {
                this.gRd.clearFocus();
            }
        }
        if (this.gRq != null && this.gRq.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRq.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gRI;
                }
            } else {
                layoutParams.topMargin = this.gRJ;
            }
            this.gRq.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gRu.setVisibility(0);
        } else {
            this.gRu.setVisibility(8);
        }
    }

    public void FN() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gRa);
        } else {
            i.af(this.gRa);
        }
        if (this.gRt != null && this.gRt.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRt.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gRM;
            } else {
                layoutParams.height = -2;
            }
            this.gRt.setLayoutParams(layoutParams);
        }
        if (this.gRq != null && this.gRq.getLayoutParams() != null && this.gRL > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gRq.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gRq.setPivotX(this.gRL / 2);
            this.gRq.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gRq.setScaleX(this.gRN);
                this.gRq.setScaleY(this.gRN);
            } else {
                layoutParams2.width = -1;
                this.gRq.setScaleX(1.0f);
                this.gRq.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gRO);
        }
    }

    private boolean bUf() {
        return bUg() && this.gRA >= this.aSl && this.gRA <= this.gRw;
    }

    private boolean bUg() {
        return this.aSl >= ((long) this.gRv) && this.aSm > 0;
    }
}
