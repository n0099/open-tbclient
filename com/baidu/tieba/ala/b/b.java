package com.baidu.tieba.ala.b;

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
import com.baidu.live.data.aw;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.o;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    private int abZ;
    private int aca;
    private int acc;
    private Activity activity;
    private int bZc;
    private View esG;
    private View esH;
    private TextView esI;
    private EditText esJ;
    private EditText esK;
    private TextView esL;
    private TextView esM;
    private LinearLayout esN;
    private LinearLayout esO;
    private LinearLayout esP;
    private TextView esQ;
    private TextView esR;
    private ImageView esS;
    private ImageView esT;
    private TextView esU;
    private TextView esV;
    private TextView esW;
    private TextView esX;
    private RelativeLayout esY;
    private RelativeLayout esZ;
    private LinearLayout eta;
    private LinearLayout etb;
    private ScrollView etd;
    private View ete;
    private long etg;
    private int eth;
    private int eti;
    private List<aw.a> etj;
    private String etm;
    private String etn;
    private boolean etq;
    private boolean etr;
    private int ets;
    private int ett;
    private a etu;
    private int etv;
    private int etw;
    private float etx;
    private boolean ety;
    private int screenWidth;
    private int etf = 2000;
    private long etk = 2000;
    private long etl = 10;
    private boolean eto = true;
    private boolean etp = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.etu = aVar;
        initView();
        bbt();
        bbu();
        this.esY.setVisibility(4);
        this.esY.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.bZc = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.bZc) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.bZc;
                    b.this.bZc = i;
                }
                b.this.etv = b.this.screenWidth;
                b.this.ett = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.etw = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.ett * 2);
                b.this.etx = (i2 * 1.0f) / b.this.esY.getHeight();
                if (b.this.bZc > b.this.esY.getHeight()) {
                    b.this.ets = (b.this.bZc - b.this.esY.getHeight()) / 2;
                }
                b.this.rC();
                b.this.esY.setVisibility(0);
            }
        });
    }

    private void bbt() {
        aw.a aVar;
        aw.a aVar2;
        if (com.baidu.live.r.a.wA() != null && com.baidu.live.r.a.wA().asy != null && com.baidu.live.r.a.wA().asy.aaH != null && com.baidu.live.r.a.wA().asy.aaH.abB != null) {
            aw awVar = com.baidu.live.r.a.wA().asy.aaH.abB;
            this.etg = awVar.abX;
            this.abZ = awVar.abZ;
            this.aca = awVar.aca;
            this.eth = awVar.acb;
            this.eti = awVar.abY;
            this.acc = awVar.acc;
            this.etj = awVar.acd;
        }
        this.esI.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.eth)));
        this.esV.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.acc)));
        this.esW.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.acc)));
        this.esX.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.eti)));
        if (this.etj != null && !this.etj.isEmpty()) {
            if (this.etj.size() == 1) {
                aVar = this.etj.get(0);
                aVar2 = null;
            } else {
                aVar = this.etj.get(0);
                aVar2 = this.etj.get(1);
            }
            if (aVar == null) {
                this.esO.setVisibility(8);
            } else {
                this.esQ.setText(aVar.ace);
                this.esO.setVisibility(0);
                this.etm = aVar.acf;
            }
            if (aVar2 == null) {
                this.esP.setVisibility(8);
            } else {
                this.esR.setText(aVar2.ace);
                this.esP.setVisibility(0);
                this.etn = aVar2.acf;
            }
            if (this.esO.getVisibility() == 0 || this.esP.getVisibility() == 0) {
                this.esN.setVisibility(0);
                return;
            } else {
                this.esN.setVisibility(8);
                return;
            }
        }
        this.esN.setVisibility(8);
    }

    private void initView() {
        this.esG = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.esH = this.esG.findViewById(a.g.iv_send_red_q);
        this.esI = (TextView) this.esG.findViewById(a.g.tv_red_broad_hint);
        this.esJ = (EditText) this.esG.findViewById(a.g.edt_t_num);
        this.esK = (EditText) this.esG.findViewById(a.g.edt_pkt_num);
        this.esL = (TextView) this.esG.findViewById(a.g.tv_send_t_num_hint);
        this.esM = (TextView) this.esG.findViewById(a.g.tv_send_pkt_num_hint);
        this.esN = (LinearLayout) this.esG.findViewById(a.g.layout_red_pkt_condition);
        this.esO = (LinearLayout) this.esG.findViewById(a.g.layout_condition_first);
        this.esP = (LinearLayout) this.esG.findViewById(a.g.layout_condition_second);
        this.esY = (RelativeLayout) this.esG.findViewById(a.g.layout_send_red_content);
        this.esZ = (RelativeLayout) this.esG.findViewById(a.g.layout_send_red);
        this.esQ = (TextView) this.esG.findViewById(a.g.tv_condition_first);
        this.esR = (TextView) this.esG.findViewById(a.g.tv_condition_second);
        this.esS = (ImageView) this.esG.findViewById(a.g.iv_condition_first);
        this.esT = (ImageView) this.esG.findViewById(a.g.iv_condition_second);
        this.esU = (TextView) this.esG.findViewById(a.g.tv_send_pkt_submit);
        this.esW = (TextView) this.esG.findViewById(a.g.tv_red_send_rule1);
        this.esX = (TextView) this.esG.findViewById(a.g.tv_red_send_rule3);
        this.esV = (TextView) this.esG.findViewById(a.g.tv_send_pkt_time);
        this.eta = (LinearLayout) this.esG.findViewById(a.g.layout_red_send_rule);
        this.etb = (LinearLayout) this.esG.findViewById(a.g.layout_red_send_rule_content);
        this.etd = (ScrollView) this.esG.findViewById(a.g.layout_input_scroll);
        this.ete = this.esG.findViewById(a.g.layout_send_red_close);
        this.esG.setOnClickListener(this);
        this.esO.setOnClickListener(this);
        this.esP.setOnClickListener(this);
        this.esU.setOnClickListener(this);
        this.esH.setOnClickListener(this);
        this.eta.setOnClickListener(this);
        this.etb.setOnClickListener(this);
        this.esZ.setOnClickListener(this);
        this.ete.setOnClickListener(this);
        ((ImageView) this.esG.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.esJ.setText(String.valueOf(this.etk));
        this.esK.setText(String.valueOf(this.etl));
        this.esJ.setSelection(this.esJ.getText().toString().length());
        this.esK.setSelection(this.esK.getText().toString().length());
    }

    private void bbu() {
        this.esJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bbv()) {
                    b.this.hW(true);
                }
            }
        });
        this.esK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.esK.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.esK.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.esM.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.abZ), Integer.valueOf(b.this.aca)));
                    b.this.esM.setVisibility(0);
                    b.this.etl = 0L;
                    b.this.etp = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.esK.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.etl = parseLong;
                    if (parseLong >= b.this.abZ && parseLong <= b.this.aca) {
                        b.this.esM.setVisibility(8);
                        b.this.etp = true;
                    } else {
                        b.this.esM.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.abZ), Integer.valueOf(b.this.aca)));
                        b.this.esM.setVisibility(0);
                        b.this.etp = false;
                    }
                }
                b.this.esK.setSelection(b.this.esK.getText().toString().length());
                TextView textView = b.this.esU;
                if (!b.this.eto || !b.this.etp) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bbv();
                b.this.hW(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbv() {
        boolean z = true;
        String obj = this.esJ.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.esJ.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.esL.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.etf), Long.valueOf(this.etg)));
            this.esL.setVisibility(0);
            this.etk = 0L;
            this.eto = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.esJ.setText(String.valueOf(parseLong));
                return true;
            }
            this.etk = parseLong;
            if (parseLong < this.etf || parseLong > this.etg) {
                if (parseLong == 0) {
                    this.esJ.setText("0");
                }
                this.esL.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.etf), Long.valueOf(this.etg)));
                this.esL.setVisibility(0);
                this.eto = false;
            } else {
                this.esL.setVisibility(8);
                this.eto = true;
            }
        }
        this.esJ.setSelection(this.esJ.getText().toString().length());
        TextView textView = this.esU;
        if (!this.eto || !this.etp) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(boolean z) {
        if (this.etp && this.eto && this.etl != 0 && this.etk / this.etl < this.eti) {
            this.esL.setVisibility(0);
            if (z) {
                this.esL.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.etl * 100)));
            } else {
                this.esL.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.etk / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.eta.getVisibility() == 0) {
            this.eta.setVisibility(8);
            return;
        }
        if (view == this.ete && !this.ety) {
            this.activity.finish();
        } else if (view == this.esG && !this.ety) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.esH) {
            this.eta.setVisibility(0);
        } else if (view == this.esO) {
            this.etq = this.etq ? false : true;
            if (this.etq) {
                this.esS.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.esS.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.esP) {
            this.etr = this.etr ? false : true;
            if (this.etr) {
                this.esT.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.esT.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.esU) {
            if (this.etq && this.etr) {
                str = this.etm + Constants.ACCEPT_TIME_SEPARATOR_SP + this.etn;
            } else if (this.etq) {
                str = this.etm;
            } else if (this.etr) {
                str = this.etn;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cC(this.etk);
            oVar.cD(this.etl);
            oVar.xH(str);
            if (this.etu != null) {
                this.etu.a(oVar);
            }
        }
        if (this.ety && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void hX(boolean z) {
        if (this.esU != null) {
            this.esU.setEnabled(z);
        }
    }

    public View getView() {
        return this.esG;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ety = z;
        if (!z) {
            if (this.esK != null) {
                this.esK.clearFocus();
            }
            if (this.esJ != null) {
                this.esJ.clearFocus();
            }
        }
        if (this.esY != null && this.esY.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.esY.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.ets;
                }
            } else {
                layoutParams.topMargin = this.ett;
            }
            this.esY.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ete.setVisibility(0);
        } else {
            this.ete.setVisibility(8);
        }
    }

    public void rC() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.Q(this.esG);
        } else {
            h.R(this.esG);
        }
        if (this.etd != null && this.etd.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etd.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.etw;
            } else {
                layoutParams.height = -2;
            }
            this.etd.setLayoutParams(layoutParams);
        }
        if (this.esY != null && this.esY.getLayoutParams() != null && this.etv > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.esY.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.esY.setPivotX(this.etv / 2);
            this.esY.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.esY.setScaleX(this.etx);
                this.esY.setScaleY(this.etx);
            } else {
                layoutParams2.width = -1;
                this.esY.setScaleX(1.0f);
                this.esY.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.ety);
        }
    }
}
