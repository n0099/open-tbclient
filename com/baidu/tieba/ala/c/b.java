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
import com.baidu.live.data.bp;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.o;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private long aEC;
    private int aED;
    private int aEv;
    private int aEw;
    private int aEy;
    private Activity activity;
    private int cTi;
    private TextView fCA;
    private TextView fCB;
    private RelativeLayout fCC;
    private LinearLayout fCD;
    private LinearLayout fCE;
    private ScrollView fCF;
    private View fCG;
    private long fCI;
    private int fCJ;
    private int fCK;
    private List<bp.a> fCL;
    private long fCN;
    private String fCO;
    private String fCP;
    private boolean fCS;
    private boolean fCT;
    private int fCU;
    private int fCV;
    private a fCW;
    private int fCX;
    private int fCY;
    private float fCZ;
    private View fCm;
    private View fCn;
    private TextView fCo;
    private EditText fCp;
    private EditText fCq;
    private TextView fCr;
    private TextView fCs;
    private LinearLayout fCt;
    private LinearLayout fCu;
    private LinearLayout fCv;
    private TextView fCw;
    private TextView fCx;
    private ImageView fCy;
    private ImageView fCz;
    private boolean fDa;
    private int fDc;
    private boolean fDd;
    private int screenWidth;
    private int fCH = 2000;
    private long fCM = 2000;
    private boolean fCQ = true;
    private boolean fCR = true;
    private int fDb = 10;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.fCW = aVar;
        initView();
        initData();
        bwn();
        bwo();
        this.fCC.setVisibility(4);
        this.fCC.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cTi = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cTi) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cTi;
                    b.this.cTi = i;
                }
                b.this.fCX = b.this.screenWidth;
                b.this.fCV = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.fCY = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.fCV * 2);
                b.this.fCZ = (i2 * 1.0f) / b.this.fCC.getHeight();
                if (b.this.cTi > b.this.fCC.getHeight()) {
                    b.this.fCU = (b.this.cTi - b.this.fCC.getHeight()) / 2;
                }
                b.this.zl();
                b.this.fCC.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.fCm = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fCn = this.fCm.findViewById(a.g.iv_send_red_q);
        this.fCo = (TextView) this.fCm.findViewById(a.g.tv_red_broad_hint);
        this.fCp = (EditText) this.fCm.findViewById(a.g.edt_t_num);
        this.fCq = (EditText) this.fCm.findViewById(a.g.edt_pkt_num);
        this.fCr = (TextView) this.fCm.findViewById(a.g.tv_send_t_num_hint);
        this.fCs = (TextView) this.fCm.findViewById(a.g.tv_send_pkt_num_hint);
        this.fCt = (LinearLayout) this.fCm.findViewById(a.g.layout_red_pkt_condition);
        this.fCu = (LinearLayout) this.fCm.findViewById(a.g.layout_condition_first);
        this.fCv = (LinearLayout) this.fCm.findViewById(a.g.layout_condition_second);
        this.fCC = (RelativeLayout) this.fCm.findViewById(a.g.layout_send_red_content);
        View findViewById = this.fCm.findViewById(a.g.layout_send_red);
        this.fCw = (TextView) this.fCm.findViewById(a.g.tv_condition_first);
        this.fCx = (TextView) this.fCm.findViewById(a.g.tv_condition_second);
        this.fCy = (ImageView) this.fCm.findViewById(a.g.iv_condition_first);
        this.fCz = (ImageView) this.fCm.findViewById(a.g.iv_condition_second);
        this.fCA = (TextView) this.fCm.findViewById(a.g.tv_send_pkt_submit);
        this.fCB = (TextView) this.fCm.findViewById(a.g.tv_send_pkt_time);
        this.fCD = (LinearLayout) this.fCm.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.fCm.findViewById(a.g.layout_red_send_rule_content);
        this.fCE = (LinearLayout) this.fCm.findViewById(a.g.layout_rule_desc);
        this.fCF = (ScrollView) this.fCm.findViewById(a.g.layout_input_scroll);
        this.fCG = this.fCm.findViewById(a.g.layout_send_red_close);
        this.fCm.setOnClickListener(this);
        this.fCu.setOnClickListener(this);
        this.fCv.setOnClickListener(this);
        this.fCA.setOnClickListener(this);
        this.fCn.setOnClickListener(this);
        this.fCD.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.fCG.setOnClickListener(this);
        ((ImageView) this.fCm.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        bp.a aVar;
        bp.a aVar2 = null;
        if (com.baidu.live.v.a.Hm() == null || com.baidu.live.v.a.Hm().bdV == null || com.baidu.live.v.a.Hm().bdV.aCT == null || com.baidu.live.v.a.Hm().bdV.aCT.aDS == null) {
            strArr = null;
            str = null;
        } else {
            bp bpVar = com.baidu.live.v.a.Hm().bdV.aCT.aDS;
            if (bpVar.aEA > 0) {
                this.fCM = bpVar.aEA;
            }
            if (bpVar.aEB > 0) {
                this.fDb = bpVar.aEB;
            }
            this.fCN = this.fDb;
            this.fCI = bpVar.aEt;
            this.aEv = bpVar.aEv;
            this.aEw = bpVar.aEw;
            this.fCJ = bpVar.aEx;
            this.fDc = bpVar.aEu;
            this.aEy = bpVar.aEy;
            this.fCL = bpVar.aEz;
            this.aEC = bpVar.aEC;
            this.aED = bpVar.aED;
            str = bpVar.aEE;
            strArr = bpVar.aEF;
            if (bwp()) {
                this.fCK = this.aED;
            } else {
                this.fCK = this.fDc;
            }
        }
        this.fCp.setText(String.valueOf(this.fCM));
        this.fCq.setText(String.valueOf(this.fCN));
        this.fCp.setSelection(this.fCp.getText().toString().length());
        this.fCq.setSelection(this.fCq.getText().toString().length());
        TextView textView = this.fCo;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fCJ));
        }
        textView.setText(str);
        this.fCB.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aEy)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aEy)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fDc))};
        }
        if (this.fCE != null) {
            this.fCE.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.fCE.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.fCE.addView(textView2, layoutParams);
            }
        }
        if (this.fCL != null && !this.fCL.isEmpty()) {
            if (this.fCL.size() == 1) {
                aVar = this.fCL.get(0);
            } else {
                aVar = this.fCL.get(0);
                aVar2 = this.fCL.get(1);
            }
            if (aVar == null) {
                this.fCu.setVisibility(8);
            } else {
                this.fCw.setText(aVar.aEG);
                this.fCu.setVisibility(0);
                this.fCO = aVar.aEH;
            }
            if (aVar2 == null) {
                this.fCv.setVisibility(8);
            } else {
                this.fCx.setText(aVar2.aEG);
                this.fCv.setVisibility(0);
                this.fCP = aVar2.aEH;
            }
            if (this.fCu.getVisibility() == 0 || this.fCv.getVisibility() == 0) {
                this.fCt.setVisibility(0);
                return;
            } else {
                this.fCt.setVisibility(8);
                return;
            }
        }
        this.fCt.setVisibility(8);
    }

    private void bwn() {
        this.fCp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.jW(true)) {
                    b.this.jX(true);
                }
            }
        });
        this.fCq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.fCq.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (b.this.fCq.hasFocus()) {
                        b.this.fDd = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.fCq.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.fCN = parseLong;
                    if (parseLong >= b.this.aEv && parseLong <= b.this.aEw) {
                        b.this.fCs.setVisibility(8);
                        b.this.fCR = true;
                    } else {
                        b.this.fCs.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aEv), Integer.valueOf(b.this.aEw)));
                        b.this.fCs.setVisibility(0);
                        b.this.fCR = false;
                    }
                } else {
                    b.this.fCs.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aEv), Integer.valueOf(b.this.aEw)));
                    b.this.fCs.setVisibility(0);
                    b.this.fCN = 0L;
                    b.this.fCR = false;
                }
                b.this.fCq.setSelection(b.this.fCq.getText().toString().length());
                TextView textView = b.this.fCA;
                if (!b.this.fCQ || !b.this.fCR) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.jW(false);
                b.this.jX(false);
            }
        });
    }

    private void bwo() {
        this.fCp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.b.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.fCp.setText("");
                    b.this.fCp.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fCp.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.fCq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.c.b.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.fCq.setText("");
                    b.this.fCq.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fCq.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jW(boolean z) {
        boolean z2 = true;
        this.fCK = this.fDc;
        String obj = this.fCp.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.fCr.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fCH), Long.valueOf(this.fCI)));
            this.fCr.setVisibility(0);
            this.fCM = 0L;
            this.fCQ = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fCp.setText(String.valueOf(parseLong));
                return true;
            } else if (this.fCM != parseLong && this.fCM > this.fCI && parseLong > this.fCI) {
                this.fCp.setText(String.valueOf(this.fCM));
                return true;
            } else {
                boolean z3 = bwp() && parseLong < this.aEC;
                this.fCM = parseLong;
                if (bwp()) {
                    this.fCK = this.aED;
                }
                if (parseLong < this.fCH || parseLong > this.fCI) {
                    if (parseLong == 0) {
                        this.fCp.setText("0");
                    }
                    this.fCr.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fCH), Long.valueOf(this.fCI)));
                    this.fCr.setVisibility(0);
                    this.fCQ = false;
                } else {
                    if (z && this.fCq != null && bwq() && !this.fCq.hasFocus()) {
                        boolean z4 = !this.fDd;
                        if (!z4 && this.fCq.getText() != null) {
                            String obj2 = this.fCq.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bwp()) {
                                long j = this.fCM / this.aED;
                                if (this.aEw > 0 && j > this.aEw) {
                                    j = this.aEw;
                                }
                                this.fCq.setText(String.valueOf(j));
                            } else if (z3) {
                                this.fCq.setText(String.valueOf(this.fDb));
                            }
                        }
                    }
                    this.fCr.setVisibility(8);
                    this.fCQ = true;
                }
            }
        }
        this.fCp.setSelection(this.fCp.getText().toString().length());
        TextView textView = this.fCA;
        if (!this.fCQ || !this.fCR) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(boolean z) {
        if (this.fCR && this.fCQ && this.fCN != 0 && this.fCM / this.fCN < this.fCK) {
            this.fCr.setVisibility(0);
            if (z) {
                this.fCr.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fCN * this.fCK)));
            } else {
                this.fCr.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fCM / this.fCK)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fCD.getVisibility() == 0) {
            this.fCD.setVisibility(8);
            return;
        }
        if (view == this.fCG && !this.fDa) {
            this.activity.finish();
        } else if (view == this.fCm && !this.fDa) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fCn) {
            this.fCD.setVisibility(0);
        } else if (view == this.fCu) {
            this.fCS = this.fCS ? false : true;
            if (this.fCS) {
                this.fCy.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fCy.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fCv) {
            this.fCT = this.fCT ? false : true;
            if (this.fCT) {
                this.fCz.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fCz.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fCA) {
            if (this.fCS && this.fCT) {
                str = this.fCO + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fCP;
            } else if (this.fCS) {
                str = this.fCO;
            } else if (this.fCT) {
                str = this.fCP;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.dx(this.fCM);
            oVar.dy(this.fCN);
            oVar.BY(str);
            if (this.fCW != null) {
                this.fCW.a(oVar);
            }
        }
        if (this.fDa && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void jY(boolean z) {
        if (this.fCA != null) {
            this.fCA.setEnabled(z);
        }
    }

    public View getView() {
        return this.fCm;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fDa = z;
        if (!z) {
            if (this.fCq != null) {
                this.fCq.clearFocus();
            }
            if (this.fCp != null) {
                this.fCp.clearFocus();
            }
        }
        if (this.fCC != null && this.fCC.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCC.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fCU;
                }
            } else {
                layoutParams.topMargin = this.fCV;
            }
            this.fCC.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fCG.setVisibility(0);
        } else {
            this.fCG.setVisibility(8);
        }
    }

    public void zl() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.U(this.fCm);
        } else {
            h.V(this.fCm);
        }
        if (this.fCF != null && this.fCF.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCF.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fCY;
            } else {
                layoutParams.height = -2;
            }
            this.fCF.setLayoutParams(layoutParams);
        }
        if (this.fCC != null && this.fCC.getLayoutParams() != null && this.fCX > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fCC.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fCC.setPivotX(this.fCX / 2);
            this.fCC.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fCC.setScaleX(this.fCZ);
                this.fCC.setScaleY(this.fCZ);
            } else {
                layoutParams2.width = -1;
                this.fCC.setScaleX(1.0f);
                this.fCC.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fDa);
        }
    }

    private boolean bwp() {
        return bwq() && this.fCM >= this.aEC && this.fCM <= this.fCI;
    }

    private boolean bwq() {
        return this.aEC >= ((long) this.fCH) && this.aED > 0;
    }
}
