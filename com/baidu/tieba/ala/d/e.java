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
import com.baidu.live.data.ca;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.q;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    private int aMI;
    private int aMJ;
    private int aML;
    private long aMQ;
    private int aMR;
    private Activity activity;
    private int djl;
    private ImageView fWA;
    private TextView fWB;
    private TextView fWC;
    private RelativeLayout fWD;
    private LinearLayout fWE;
    private LinearLayout fWF;
    private ScrollView fWG;
    private View fWH;
    private long fWJ;
    private int fWK;
    private int fWL;
    private List<ca.a> fWM;
    private long fWO;
    private String fWP;
    private String fWQ;
    private boolean fWT;
    private boolean fWU;
    private int fWV;
    private int fWW;
    private d fWX;
    private int fWY;
    private int fWZ;
    private View fWn;
    private View fWo;
    private TextView fWp;
    private EditText fWq;
    private EditText fWr;
    private TextView fWs;
    private TextView fWt;
    private LinearLayout fWu;
    private LinearLayout fWv;
    private LinearLayout fWw;
    private TextView fWx;
    private TextView fWy;
    private ImageView fWz;
    private float fXa;
    private boolean fXb;
    private int fXd;
    private boolean fXe;
    private int screenWidth;
    private int fWI = 2000;
    private long fWN = 2000;
    private boolean fWR = true;
    private boolean fWS = true;
    private int fXc = 10;

    public e(final Activity activity, d dVar) {
        this.activity = activity;
        this.fWX = dVar;
        initView();
        initData();
        bJP();
        bJQ();
        this.fWD.setVisibility(4);
        this.fWD.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                e.this.djl = ScreenHelper.getScreenHeight(activity);
                if (e.this.screenWidth > e.this.djl) {
                    int i = e.this.screenWidth;
                    e.this.screenWidth = e.this.djl;
                    e.this.djl = i;
                }
                e.this.fWY = e.this.screenWidth;
                e.this.fWW = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                e.this.fWZ = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = e.this.screenWidth - (e.this.fWW * 2);
                e.this.fXa = (i2 * 1.0f) / e.this.fWD.getHeight();
                if (e.this.djl > e.this.fWD.getHeight()) {
                    e.this.fWV = (e.this.djl - e.this.fWD.getHeight()) / 2;
                }
                e.this.FQ();
                e.this.fWD.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.fWn = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fWo = this.fWn.findViewById(a.g.iv_send_red_q);
        this.fWp = (TextView) this.fWn.findViewById(a.g.tv_red_broad_hint);
        this.fWq = (EditText) this.fWn.findViewById(a.g.edt_t_num);
        this.fWr = (EditText) this.fWn.findViewById(a.g.edt_pkt_num);
        this.fWs = (TextView) this.fWn.findViewById(a.g.tv_send_t_num_hint);
        this.fWt = (TextView) this.fWn.findViewById(a.g.tv_send_pkt_num_hint);
        this.fWu = (LinearLayout) this.fWn.findViewById(a.g.layout_red_pkt_condition);
        this.fWv = (LinearLayout) this.fWn.findViewById(a.g.layout_condition_first);
        this.fWw = (LinearLayout) this.fWn.findViewById(a.g.layout_condition_second);
        this.fWD = (RelativeLayout) this.fWn.findViewById(a.g.layout_send_red_content);
        View findViewById = this.fWn.findViewById(a.g.layout_send_red);
        this.fWx = (TextView) this.fWn.findViewById(a.g.tv_condition_first);
        this.fWy = (TextView) this.fWn.findViewById(a.g.tv_condition_second);
        this.fWz = (ImageView) this.fWn.findViewById(a.g.iv_condition_first);
        this.fWA = (ImageView) this.fWn.findViewById(a.g.iv_condition_second);
        this.fWB = (TextView) this.fWn.findViewById(a.g.tv_send_pkt_submit);
        this.fWC = (TextView) this.fWn.findViewById(a.g.tv_send_pkt_time);
        this.fWE = (LinearLayout) this.fWn.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.fWn.findViewById(a.g.layout_red_send_rule_content);
        this.fWF = (LinearLayout) this.fWn.findViewById(a.g.layout_rule_desc);
        this.fWG = (ScrollView) this.fWn.findViewById(a.g.layout_input_scroll);
        this.fWH = this.fWn.findViewById(a.g.layout_send_red_close);
        this.fWn.setOnClickListener(this);
        this.fWv.setOnClickListener(this);
        this.fWw.setOnClickListener(this);
        this.fWB.setOnClickListener(this);
        this.fWo.setOnClickListener(this);
        this.fWE.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.fWH.setOnClickListener(this);
        ((ImageView) this.fWn.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        ca.a aVar;
        ca.a aVar2 = null;
        if (com.baidu.live.x.a.NN() == null || com.baidu.live.x.a.NN().bmW == null || com.baidu.live.x.a.NN().bmW.aKQ == null || com.baidu.live.x.a.NN().bmW.aKQ.aMd == null) {
            strArr = null;
            str = null;
        } else {
            ca caVar = com.baidu.live.x.a.NN().bmW.aKQ.aMd;
            if (caVar.aMO > 0) {
                this.fWN = caVar.aMO;
            }
            if (caVar.aMP > 0) {
                this.fXc = caVar.aMP;
            }
            this.fWO = this.fXc;
            this.fWJ = caVar.aMG;
            this.aMI = caVar.aMI;
            this.aMJ = caVar.aMJ;
            this.fWK = caVar.aMK;
            this.fXd = caVar.aMH;
            this.aML = caVar.aML;
            this.fWM = caVar.aMM;
            this.aMQ = caVar.aMQ;
            this.aMR = caVar.aMR;
            str = caVar.aMS;
            strArr = caVar.aMT;
            if (bJR()) {
                this.fWL = this.aMR;
            } else {
                this.fWL = this.fXd;
            }
        }
        this.fWq.setText(String.valueOf(this.fWN));
        this.fWr.setText(String.valueOf(this.fWO));
        this.fWq.setSelection(this.fWq.getText().toString().length());
        this.fWr.setSelection(this.fWr.getText().toString().length());
        TextView textView = this.fWp;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fWK));
        }
        textView.setText(str);
        this.fWC.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aML)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aML)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fXd))};
        }
        if (this.fWF != null) {
            this.fWF.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.fWF.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.fWF.addView(textView2, layoutParams);
            }
        }
        if (this.fWM != null && !this.fWM.isEmpty()) {
            if (this.fWM.size() == 1) {
                aVar = this.fWM.get(0);
            } else {
                aVar = this.fWM.get(0);
                aVar2 = this.fWM.get(1);
            }
            if (aVar == null) {
                this.fWv.setVisibility(8);
            } else {
                this.fWx.setText(aVar.aMU);
                this.fWv.setVisibility(0);
                this.fWP = aVar.aMV;
            }
            if (aVar2 == null) {
                this.fWw.setVisibility(8);
            } else {
                this.fWy.setText(aVar2.aMU);
                this.fWw.setVisibility(0);
                this.fWQ = aVar2.aMV;
            }
            if (this.fWv.getVisibility() == 0 || this.fWw.getVisibility() == 0) {
                this.fWu.setVisibility(0);
                return;
            } else {
                this.fWu.setVisibility(8);
                return;
            }
        }
        this.fWu.setVisibility(8);
    }

    private void bJP() {
        this.fWq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!e.this.lc(true)) {
                    e.this.ld(true);
                }
            }
        });
        this.fWr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = e.this.fWr.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (e.this.fWr.hasFocus()) {
                        e.this.fXe = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        e.this.fWr.setText(String.valueOf(parseLong));
                        return;
                    }
                    e.this.fWO = parseLong;
                    if (parseLong >= e.this.aMI && parseLong <= e.this.aMJ) {
                        e.this.fWt.setVisibility(8);
                        e.this.fWS = true;
                    } else {
                        e.this.fWt.setText(String.format(e.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(e.this.aMI), Integer.valueOf(e.this.aMJ)));
                        e.this.fWt.setVisibility(0);
                        e.this.fWS = false;
                    }
                } else {
                    e.this.fWt.setText(String.format(e.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(e.this.aMI), Integer.valueOf(e.this.aMJ)));
                    e.this.fWt.setVisibility(0);
                    e.this.fWO = 0L;
                    e.this.fWS = false;
                }
                e.this.fWr.setSelection(e.this.fWr.getText().toString().length());
                TextView textView = e.this.fWB;
                if (!e.this.fWR || !e.this.fWS) {
                    z = false;
                }
                textView.setEnabled(z);
                e.this.lc(false);
                e.this.ld(false);
            }
        });
    }

    private void bJQ() {
        this.fWq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.fWq.setText("");
                    e.this.fWq.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.fWq.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.fWr.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.fWr.setText("");
                    e.this.fWr.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.fWr.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lc(boolean z) {
        boolean z2 = true;
        this.fWL = this.fXd;
        String obj = this.fWq.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.fWs.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fWI), Long.valueOf(this.fWJ)));
            this.fWs.setVisibility(0);
            this.fWN = 0L;
            this.fWR = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fWq.setText(String.valueOf(parseLong));
                return true;
            } else if (this.fWN != parseLong && this.fWN > this.fWJ && parseLong > this.fWJ) {
                this.fWq.setText(String.valueOf(this.fWN));
                return true;
            } else {
                boolean z3 = bJR() && parseLong < this.aMQ;
                this.fWN = parseLong;
                if (bJR()) {
                    this.fWL = this.aMR;
                }
                if (parseLong < this.fWI || parseLong > this.fWJ) {
                    if (parseLong == 0) {
                        this.fWq.setText("0");
                    }
                    this.fWs.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fWI), Long.valueOf(this.fWJ)));
                    this.fWs.setVisibility(0);
                    this.fWR = false;
                } else {
                    if (z && this.fWr != null && bJS() && !this.fWr.hasFocus()) {
                        boolean z4 = !this.fXe;
                        if (!z4 && this.fWr.getText() != null) {
                            String obj2 = this.fWr.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bJR()) {
                                long j = this.fWN / this.aMR;
                                if (this.aMJ > 0 && j > this.aMJ) {
                                    j = this.aMJ;
                                }
                                this.fWr.setText(String.valueOf(j));
                            } else if (z3) {
                                this.fWr.setText(String.valueOf(this.fXc));
                            }
                        }
                    }
                    this.fWs.setVisibility(8);
                    this.fWR = true;
                }
            }
        }
        this.fWq.setSelection(this.fWq.getText().toString().length());
        TextView textView = this.fWB;
        if (!this.fWR || !this.fWS) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld(boolean z) {
        if (this.fWS && this.fWR && this.fWO != 0 && this.fWN / this.fWO < this.fWL) {
            this.fWs.setVisibility(0);
            if (z) {
                this.fWs.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fWO * this.fWL)));
            } else {
                this.fWs.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fWN / this.fWL)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fWE.getVisibility() == 0) {
            this.fWE.setVisibility(8);
            return;
        }
        if (view == this.fWH && !this.fXb) {
            this.activity.finish();
        } else if (view == this.fWn && !this.fXb) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fWo) {
            this.fWE.setVisibility(0);
        } else if (view == this.fWv) {
            this.fWT = this.fWT ? false : true;
            if (this.fWT) {
                this.fWz.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fWz.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fWw) {
            this.fWU = this.fWU ? false : true;
            if (this.fWU) {
                this.fWA.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fWA.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fWB) {
            if (this.fWT && this.fWU) {
                str = this.fWP + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fWQ;
            } else if (this.fWT) {
                str = this.fWP;
            } else if (this.fWU) {
                str = this.fWQ;
            } else {
                str = "";
            }
            q qVar = new q();
            qVar.dY(this.fWN);
            qVar.dZ(this.fWO);
            qVar.FE(str);
            if (this.fWX != null) {
                this.fWX.a(qVar);
            }
        }
        if (this.fXb && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void le(boolean z) {
        if (this.fWB != null) {
            this.fWB.setEnabled(z);
        }
    }

    public View getView() {
        return this.fWn;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fXb = z;
        if (!z) {
            if (this.fWr != null) {
                this.fWr.clearFocus();
            }
            if (this.fWq != null) {
                this.fWq.clearFocus();
            }
        }
        if (this.fWD != null && this.fWD.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWD.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fWV;
                }
            } else {
                layoutParams.topMargin = this.fWW;
            }
            this.fWD.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fWH.setVisibility(0);
        } else {
            this.fWH.setVisibility(8);
        }
    }

    public void FQ() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.aa(this.fWn);
        } else {
            i.ab(this.fWn);
        }
        if (this.fWG != null && this.fWG.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWG.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fWZ;
            } else {
                layoutParams.height = -2;
            }
            this.fWG.setLayoutParams(layoutParams);
        }
        if (this.fWD != null && this.fWD.getLayoutParams() != null && this.fWY > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWD.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fWD.setPivotX(this.fWY / 2);
            this.fWD.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fWD.setScaleX(this.fXa);
                this.fWD.setScaleY(this.fXa);
            } else {
                layoutParams2.width = -1;
                this.fWD.setScaleX(1.0f);
                this.fWD.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fXb);
        }
    }

    private boolean bJR() {
        return bJS() && this.fWN >= this.aMQ && this.fWN <= this.fWJ;
    }

    private boolean bJS() {
        return this.aMQ >= ((long) this.fWI) && this.aMR > 0;
    }
}
