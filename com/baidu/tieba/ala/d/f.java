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
import com.baidu.live.data.cj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.s;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private int aSQ;
    private int aSR;
    private int aST;
    private long aSY;
    private int aSZ;
    private Activity activity;
    private int dOW;
    private View gGY;
    private View gGZ;
    private String gHA;
    private String gHB;
    private boolean gHE;
    private boolean gHF;
    private int gHG;
    private int gHH;
    private e gHI;
    private int gHJ;
    private int gHK;
    private float gHL;
    private boolean gHM;
    private int gHO;
    private boolean gHP;
    private TextView gHa;
    private EditText gHb;
    private EditText gHc;
    private TextView gHd;
    private TextView gHe;
    private LinearLayout gHf;
    private LinearLayout gHg;
    private LinearLayout gHh;
    private TextView gHi;
    private TextView gHj;
    private ImageView gHk;
    private ImageView gHl;
    private TextView gHm;
    private TextView gHn;
    private RelativeLayout gHo;
    private LinearLayout gHp;
    private LinearLayout gHq;
    private ScrollView gHr;
    private View gHs;
    private long gHu;
    private int gHv;
    private int gHw;
    private List<cj.a> gHx;
    private long gHz;
    private int screenWidth;
    private int gHt = 2000;
    private long gHy = 2000;
    private boolean gHC = true;
    private boolean gHD = true;
    private int gHN = 10;

    public f(final Activity activity, e eVar) {
        this.activity = activity;
        this.gHI = eVar;
        initView();
        initData();
        bUE();
        bUF();
        this.gHo.setVisibility(4);
        this.gHo.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                f.this.dOW = ScreenHelper.getScreenHeight(activity);
                if (f.this.screenWidth > f.this.dOW) {
                    int i = f.this.screenWidth;
                    f.this.screenWidth = f.this.dOW;
                    f.this.dOW = i;
                }
                f.this.gHJ = f.this.screenWidth;
                f.this.gHH = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                f.this.gHK = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = f.this.screenWidth - (f.this.gHH * 2);
                f.this.gHL = (i2 * 1.0f) / f.this.gHo.getHeight();
                if (f.this.dOW > f.this.gHo.getHeight()) {
                    f.this.gHG = (f.this.dOW - f.this.gHo.getHeight()) / 2;
                }
                f.this.IR();
                f.this.gHo.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gGY = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gGZ = this.gGY.findViewById(a.f.iv_send_red_q);
        this.gHa = (TextView) this.gGY.findViewById(a.f.tv_red_broad_hint);
        this.gHb = (EditText) this.gGY.findViewById(a.f.edt_t_num);
        this.gHc = (EditText) this.gGY.findViewById(a.f.edt_pkt_num);
        this.gHd = (TextView) this.gGY.findViewById(a.f.tv_send_t_num_hint);
        this.gHe = (TextView) this.gGY.findViewById(a.f.tv_send_pkt_num_hint);
        this.gHf = (LinearLayout) this.gGY.findViewById(a.f.layout_red_pkt_condition);
        this.gHg = (LinearLayout) this.gGY.findViewById(a.f.layout_condition_first);
        this.gHh = (LinearLayout) this.gGY.findViewById(a.f.layout_condition_second);
        this.gHo = (RelativeLayout) this.gGY.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gGY.findViewById(a.f.layout_send_red);
        this.gHi = (TextView) this.gGY.findViewById(a.f.tv_condition_first);
        this.gHj = (TextView) this.gGY.findViewById(a.f.tv_condition_second);
        this.gHk = (ImageView) this.gGY.findViewById(a.f.iv_condition_first);
        this.gHl = (ImageView) this.gGY.findViewById(a.f.iv_condition_second);
        this.gHm = (TextView) this.gGY.findViewById(a.f.tv_send_pkt_submit);
        this.gHn = (TextView) this.gGY.findViewById(a.f.tv_send_pkt_time);
        this.gHp = (LinearLayout) this.gGY.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gGY.findViewById(a.f.layout_red_send_rule_content);
        this.gHq = (LinearLayout) this.gGY.findViewById(a.f.layout_rule_desc);
        this.gHr = (ScrollView) this.gGY.findViewById(a.f.layout_input_scroll);
        this.gHs = this.gGY.findViewById(a.f.layout_send_red_close);
        this.gGY.setOnClickListener(this);
        this.gHg.setOnClickListener(this);
        this.gHh.setOnClickListener(this);
        this.gHm.setOnClickListener(this);
        this.gGZ.setOnClickListener(this);
        this.gHp.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gHs.setOnClickListener(this);
        ((ImageView) this.gGY.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        cj.a aVar;
        cj.a aVar2 = null;
        if (com.baidu.live.ae.a.RB() == null || com.baidu.live.ae.a.RB().bxq == null || com.baidu.live.ae.a.RB().bxq.aQM == null || com.baidu.live.ae.a.RB().bxq.aQM.aSl == null) {
            strArr = null;
            str = null;
        } else {
            cj cjVar = com.baidu.live.ae.a.RB().bxq.aQM.aSl;
            if (cjVar.aSW > 0) {
                this.gHy = cjVar.aSW;
            }
            if (cjVar.aSX > 0) {
                this.gHN = cjVar.aSX;
            }
            this.gHz = this.gHN;
            this.gHu = cjVar.aSO;
            this.aSQ = cjVar.aSQ;
            this.aSR = cjVar.aSR;
            this.gHv = cjVar.aSS;
            this.gHO = cjVar.aSP;
            this.aST = cjVar.aST;
            this.gHx = cjVar.aSU;
            this.aSY = cjVar.aSY;
            this.aSZ = cjVar.aSZ;
            str = cjVar.aTa;
            strArr = cjVar.aTb;
            if (bUG()) {
                this.gHw = this.aSZ;
            } else {
                this.gHw = this.gHO;
            }
        }
        this.gHb.setText(String.valueOf(this.gHy));
        this.gHc.setText(String.valueOf(this.gHz));
        this.gHb.setSelection(this.gHb.getText().toString().length());
        this.gHc.setSelection(this.gHc.getText().toString().length());
        TextView textView = this.gHa;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gHv));
        }
        textView.setText(str);
        this.gHn.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aST)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aST)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gHO))};
        }
        if (this.gHq != null) {
            this.gHq.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gHq.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gHq.addView(textView2, layoutParams);
            }
        }
        if (this.gHx != null && !this.gHx.isEmpty()) {
            if (this.gHx.size() == 1) {
                aVar = this.gHx.get(0);
            } else {
                aVar = this.gHx.get(0);
                aVar2 = this.gHx.get(1);
            }
            if (aVar == null) {
                this.gHg.setVisibility(8);
            } else {
                this.gHi.setText(aVar.aTc);
                this.gHg.setVisibility(0);
                this.gHA = aVar.aTd;
            }
            if (aVar2 == null) {
                this.gHh.setVisibility(8);
            } else {
                this.gHj.setText(aVar2.aTc);
                this.gHh.setVisibility(0);
                this.gHB = aVar2.aTd;
            }
            if (this.gHg.getVisibility() == 0 || this.gHh.getVisibility() == 0) {
                this.gHf.setVisibility(0);
                return;
            } else {
                this.gHf.setVisibility(8);
                return;
            }
        }
        this.gHf.setVisibility(8);
    }

    private void bUE() {
        this.gHb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!f.this.mw(true)) {
                    f.this.mx(true);
                }
            }
        });
        this.gHc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.f.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = f.this.gHc.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (f.this.gHc.hasFocus()) {
                        f.this.gHP = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        f.this.gHc.setText(String.valueOf(parseLong));
                        return;
                    }
                    f.this.gHz = parseLong;
                    if (parseLong >= f.this.aSQ && parseLong <= f.this.aSR) {
                        f.this.gHe.setVisibility(8);
                        f.this.gHD = true;
                    } else {
                        f.this.gHe.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aSQ), Integer.valueOf(f.this.aSR)));
                        f.this.gHe.setVisibility(0);
                        f.this.gHD = false;
                    }
                } else {
                    f.this.gHe.setText(String.format(f.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(f.this.aSQ), Integer.valueOf(f.this.aSR)));
                    f.this.gHe.setVisibility(0);
                    f.this.gHz = 0L;
                    f.this.gHD = false;
                }
                f.this.gHc.setSelection(f.this.gHc.getText().toString().length());
                TextView textView = f.this.gHm;
                if (!f.this.gHC || !f.this.gHD) {
                    z = false;
                }
                textView.setEnabled(z);
                f.this.mw(false);
                f.this.mx(false);
            }
        });
    }

    private void bUF() {
        this.gHb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gHb.setText("");
                    f.this.gHb.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gHb.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gHc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.f.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.gHc.setText("");
                    f.this.gHc.post(new Runnable() { // from class: com.baidu.tieba.ala.d.f.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.gHc.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mw(boolean z) {
        boolean z2 = true;
        this.gHw = this.gHO;
        String obj = this.gHb.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gHd.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gHt), Long.valueOf(this.gHu)));
            this.gHd.setVisibility(0);
            this.gHy = 0L;
            this.gHC = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gHb.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gHy != parseLong && this.gHy > this.gHu && parseLong > this.gHu) {
                this.gHb.setText(String.valueOf(this.gHy));
                return true;
            } else {
                boolean z3 = bUG() && parseLong < this.aSY;
                this.gHy = parseLong;
                if (bUG()) {
                    this.gHw = this.aSZ;
                }
                if (parseLong < this.gHt || parseLong > this.gHu) {
                    if (parseLong == 0) {
                        this.gHb.setText("0");
                    }
                    this.gHd.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gHt), Long.valueOf(this.gHu)));
                    this.gHd.setVisibility(0);
                    this.gHC = false;
                } else {
                    if (z && this.gHc != null && bUH() && !this.gHc.hasFocus()) {
                        boolean z4 = !this.gHP;
                        if (!z4 && this.gHc.getText() != null) {
                            String obj2 = this.gHc.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bUG()) {
                                long j = this.gHy / this.aSZ;
                                if (this.aSR > 0 && j > this.aSR) {
                                    j = this.aSR;
                                }
                                this.gHc.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gHc.setText(String.valueOf(this.gHN));
                            }
                        }
                    }
                    this.gHd.setVisibility(8);
                    this.gHC = true;
                }
            }
        }
        this.gHb.setSelection(this.gHb.getText().toString().length());
        TextView textView = this.gHm;
        if (!this.gHC || !this.gHD) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (this.gHD && this.gHC && this.gHz != 0 && this.gHy / this.gHz < this.gHw) {
            this.gHd.setVisibility(0);
            if (z) {
                this.gHd.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gHz * this.gHw)));
            } else {
                this.gHd.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gHy / this.gHw)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gHp.getVisibility() == 0) {
            this.gHp.setVisibility(8);
            return;
        }
        if (view == this.gHs && !this.gHM) {
            this.activity.finish();
        } else if (view == this.gGY && !this.gHM) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gGZ) {
            this.gHp.setVisibility(0);
        } else if (view == this.gHg) {
            this.gHE = this.gHE ? false : true;
            if (this.gHE) {
                this.gHk.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gHk.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gHh) {
            this.gHF = this.gHF ? false : true;
            if (this.gHF) {
                this.gHl.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gHl.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gHm) {
            if (this.gHE && this.gHF) {
                str = this.gHA + "," + this.gHB;
            } else if (this.gHE) {
                str = this.gHA;
            } else if (this.gHF) {
                str = this.gHB;
            } else {
                str = "";
            }
            s sVar = new s();
            sVar.fi(this.gHy);
            sVar.fj(this.gHz);
            sVar.Hp(str);
            if (this.gHI != null) {
                this.gHI.a(sVar);
            }
        }
        if (this.gHM && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void my(boolean z) {
        if (this.gHm != null) {
            this.gHm.setEnabled(z);
        }
    }

    public View getView() {
        return this.gGY;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gHM = z;
        if (!z) {
            if (this.gHc != null) {
                this.gHc.clearFocus();
            }
            if (this.gHb != null) {
                this.gHb.clearFocus();
            }
        }
        if (this.gHo != null && this.gHo.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHo.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gHG;
                }
            } else {
                layoutParams.topMargin = this.gHH;
            }
            this.gHo.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gHs.setVisibility(0);
        } else {
            this.gHs.setVisibility(8);
        }
    }

    public void IR() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gGY);
        } else {
            i.af(this.gGY);
        }
        if (this.gHr != null && this.gHr.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gHr.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gHK;
            } else {
                layoutParams.height = -2;
            }
            this.gHr.setLayoutParams(layoutParams);
        }
        if (this.gHo != null && this.gHo.getLayoutParams() != null && this.gHJ > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHo.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gHo.setPivotX(this.gHJ / 2);
            this.gHo.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gHo.setScaleX(this.gHL);
                this.gHo.setScaleY(this.gHL);
            } else {
                layoutParams2.width = -1;
                this.gHo.setScaleX(1.0f);
                this.gHo.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gHM);
        }
    }

    private boolean bUG() {
        return bUH() && this.gHy >= this.aSY && this.gHy <= this.gHu;
    }

    private boolean bUH() {
        return this.aSY >= ((long) this.gHt) && this.aSZ > 0;
    }
}
