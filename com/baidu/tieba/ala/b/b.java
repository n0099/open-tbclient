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
import com.baidu.live.data.ba;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.o;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    private int acm;
    private int acn;
    private int acp;
    private Activity activity;
    private int bZo;
    private View etS;
    private View etT;
    private TextView etU;
    private EditText etV;
    private EditText etW;
    private TextView etX;
    private TextView etY;
    private LinearLayout etZ;
    private boolean euB;
    private boolean euC;
    private int euD;
    private int euE;
    private a euF;
    private int euG;
    private int euH;
    private float euI;
    private boolean euJ;
    private LinearLayout eua;
    private LinearLayout eub;
    private TextView euc;
    private TextView eud;
    private ImageView eue;
    private ImageView euf;
    private TextView eug;
    private TextView euh;
    private TextView eui;
    private TextView euj;
    private RelativeLayout euk;
    private RelativeLayout eul;
    private LinearLayout eum;
    private LinearLayout eun;
    private ScrollView euo;
    private View eup;
    private long eur;
    private int eus;
    private int eut;
    private List<ba.a> euu;
    private String eux;
    private String euy;
    private int screenWidth;
    private int euq = 2000;
    private long euv = 2000;
    private long euw = 10;
    private boolean euz = true;
    private boolean euA = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.euF = aVar;
        initView();
        bbO();
        bbP();
        this.euk.setVisibility(4);
        this.euk.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.bZo = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.bZo) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.bZo;
                    b.this.bZo = i;
                }
                b.this.euG = b.this.screenWidth;
                b.this.euE = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.euH = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.euE * 2);
                b.this.euI = (i2 * 1.0f) / b.this.euk.getHeight();
                if (b.this.bZo > b.this.euk.getHeight()) {
                    b.this.euD = (b.this.bZo - b.this.euk.getHeight()) / 2;
                }
                b.this.rP();
                b.this.euk.setVisibility(0);
            }
        });
    }

    private void bbO() {
        ba.a aVar;
        ba.a aVar2;
        if (com.baidu.live.s.a.wR() != null && com.baidu.live.s.a.wR().atk != null && com.baidu.live.s.a.wR().atk.aaU != null && com.baidu.live.s.a.wR().atk.aaU.abM != null) {
            ba baVar = com.baidu.live.s.a.wR().atk.aaU.abM;
            this.eur = baVar.aci;
            this.acm = baVar.acm;
            this.acn = baVar.acn;
            this.eus = baVar.aco;
            this.eut = baVar.acj;
            this.acp = baVar.acp;
            this.euu = baVar.acq;
        }
        this.etU.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.eus)));
        this.euh.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.acp)));
        this.eui.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.acp)));
        this.euj.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.eut)));
        if (this.euu != null && !this.euu.isEmpty()) {
            if (this.euu.size() == 1) {
                aVar = this.euu.get(0);
                aVar2 = null;
            } else {
                aVar = this.euu.get(0);
                aVar2 = this.euu.get(1);
            }
            if (aVar == null) {
                this.eua.setVisibility(8);
            } else {
                this.euc.setText(aVar.acr);
                this.eua.setVisibility(0);
                this.eux = aVar.acs;
            }
            if (aVar2 == null) {
                this.eub.setVisibility(8);
            } else {
                this.eud.setText(aVar2.acr);
                this.eub.setVisibility(0);
                this.euy = aVar2.acs;
            }
            if (this.eua.getVisibility() == 0 || this.eub.getVisibility() == 0) {
                this.etZ.setVisibility(0);
                return;
            } else {
                this.etZ.setVisibility(8);
                return;
            }
        }
        this.etZ.setVisibility(8);
    }

    private void initView() {
        this.etS = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.etT = this.etS.findViewById(a.g.iv_send_red_q);
        this.etU = (TextView) this.etS.findViewById(a.g.tv_red_broad_hint);
        this.etV = (EditText) this.etS.findViewById(a.g.edt_t_num);
        this.etW = (EditText) this.etS.findViewById(a.g.edt_pkt_num);
        this.etX = (TextView) this.etS.findViewById(a.g.tv_send_t_num_hint);
        this.etY = (TextView) this.etS.findViewById(a.g.tv_send_pkt_num_hint);
        this.etZ = (LinearLayout) this.etS.findViewById(a.g.layout_red_pkt_condition);
        this.eua = (LinearLayout) this.etS.findViewById(a.g.layout_condition_first);
        this.eub = (LinearLayout) this.etS.findViewById(a.g.layout_condition_second);
        this.euk = (RelativeLayout) this.etS.findViewById(a.g.layout_send_red_content);
        this.eul = (RelativeLayout) this.etS.findViewById(a.g.layout_send_red);
        this.euc = (TextView) this.etS.findViewById(a.g.tv_condition_first);
        this.eud = (TextView) this.etS.findViewById(a.g.tv_condition_second);
        this.eue = (ImageView) this.etS.findViewById(a.g.iv_condition_first);
        this.euf = (ImageView) this.etS.findViewById(a.g.iv_condition_second);
        this.eug = (TextView) this.etS.findViewById(a.g.tv_send_pkt_submit);
        this.eui = (TextView) this.etS.findViewById(a.g.tv_red_send_rule1);
        this.euj = (TextView) this.etS.findViewById(a.g.tv_red_send_rule3);
        this.euh = (TextView) this.etS.findViewById(a.g.tv_send_pkt_time);
        this.eum = (LinearLayout) this.etS.findViewById(a.g.layout_red_send_rule);
        this.eun = (LinearLayout) this.etS.findViewById(a.g.layout_red_send_rule_content);
        this.euo = (ScrollView) this.etS.findViewById(a.g.layout_input_scroll);
        this.eup = this.etS.findViewById(a.g.layout_send_red_close);
        this.etS.setOnClickListener(this);
        this.eua.setOnClickListener(this);
        this.eub.setOnClickListener(this);
        this.eug.setOnClickListener(this);
        this.etT.setOnClickListener(this);
        this.eum.setOnClickListener(this);
        this.eun.setOnClickListener(this);
        this.eul.setOnClickListener(this);
        this.eup.setOnClickListener(this);
        ((ImageView) this.etS.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.etV.setText(String.valueOf(this.euv));
        this.etW.setText(String.valueOf(this.euw));
        this.etV.setSelection(this.etV.getText().toString().length());
        this.etW.setSelection(this.etW.getText().toString().length());
    }

    private void bbP() {
        this.etV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bbQ()) {
                    b.this.ig(true);
                }
            }
        });
        this.etW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.etW.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.etW.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.etY.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.acm), Integer.valueOf(b.this.acn)));
                    b.this.etY.setVisibility(0);
                    b.this.euw = 0L;
                    b.this.euA = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.etW.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.euw = parseLong;
                    if (parseLong >= b.this.acm && parseLong <= b.this.acn) {
                        b.this.etY.setVisibility(8);
                        b.this.euA = true;
                    } else {
                        b.this.etY.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.acm), Integer.valueOf(b.this.acn)));
                        b.this.etY.setVisibility(0);
                        b.this.euA = false;
                    }
                }
                b.this.etW.setSelection(b.this.etW.getText().toString().length());
                TextView textView = b.this.eug;
                if (!b.this.euz || !b.this.euA) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bbQ();
                b.this.ig(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbQ() {
        boolean z = true;
        String obj = this.etV.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.etV.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.etX.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.euq), Long.valueOf(this.eur)));
            this.etX.setVisibility(0);
            this.euv = 0L;
            this.euz = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.etV.setText(String.valueOf(parseLong));
                return true;
            }
            this.euv = parseLong;
            if (parseLong < this.euq || parseLong > this.eur) {
                if (parseLong == 0) {
                    this.etV.setText("0");
                }
                this.etX.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.euq), Long.valueOf(this.eur)));
                this.etX.setVisibility(0);
                this.euz = false;
            } else {
                this.etX.setVisibility(8);
                this.euz = true;
            }
        }
        this.etV.setSelection(this.etV.getText().toString().length());
        TextView textView = this.eug;
        if (!this.euz || !this.euA) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(boolean z) {
        if (this.euA && this.euz && this.euw != 0 && this.euv / this.euw < this.eut) {
            this.etX.setVisibility(0);
            if (z) {
                this.etX.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.euw * 100)));
            } else {
                this.etX.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.euv / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.eum.getVisibility() == 0) {
            this.eum.setVisibility(8);
            return;
        }
        if (view == this.eup && !this.euJ) {
            this.activity.finish();
        } else if (view == this.etS && !this.euJ) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.etT) {
            this.eum.setVisibility(0);
        } else if (view == this.eua) {
            this.euB = this.euB ? false : true;
            if (this.euB) {
                this.eue.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eue.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eub) {
            this.euC = this.euC ? false : true;
            if (this.euC) {
                this.euf.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.euf.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eug) {
            if (this.euB && this.euC) {
                str = this.eux + Constants.ACCEPT_TIME_SEPARATOR_SP + this.euy;
            } else if (this.euB) {
                str = this.eux;
            } else if (this.euC) {
                str = this.euy;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cH(this.euv);
            oVar.cI(this.euw);
            oVar.xM(str);
            if (this.euF != null) {
                this.euF.a(oVar);
            }
        }
        if (this.euJ && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void ih(boolean z) {
        if (this.eug != null) {
            this.eug.setEnabled(z);
        }
    }

    public View getView() {
        return this.etS;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.euJ = z;
        if (!z) {
            if (this.etW != null) {
                this.etW.clearFocus();
            }
            if (this.etV != null) {
                this.etV.clearFocus();
            }
        }
        if (this.euk != null && this.euk.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.euk.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.euD;
                }
            } else {
                layoutParams.topMargin = this.euE;
            }
            this.euk.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eup.setVisibility(0);
        } else {
            this.eup.setVisibility(8);
        }
    }

    public void rP() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.S(this.etS);
        } else {
            h.T(this.etS);
        }
        if (this.euo != null && this.euo.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.euo.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.euH;
            } else {
                layoutParams.height = -2;
            }
            this.euo.setLayoutParams(layoutParams);
        }
        if (this.euk != null && this.euk.getLayoutParams() != null && this.euG > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.euk.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.euk.setPivotX(this.euG / 2);
            this.euk.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.euk.setScaleX(this.euI);
                this.euk.setScaleY(this.euI);
            } else {
                layoutParams2.width = -1;
                this.euk.setScaleX(1.0f);
                this.euk.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.euJ);
        }
    }
}
