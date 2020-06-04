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
import com.baidu.live.data.bk;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.o;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private int aCk;
    private int aCl;
    private int aCn;
    private Activity activity;
    private int cOy;
    private View frA;
    private long frC;
    private int frD;
    private int frE;
    private List<bk.a> frF;
    private String frI;
    private String frJ;
    private boolean frM;
    private boolean frN;
    private int frO;
    private int frP;
    private a frQ;
    private int frR;
    private int frS;
    private float frT;
    private boolean frU;
    private View frb;
    private View frd;
    private TextView fre;
    private EditText frf;
    private EditText frg;
    private TextView frh;
    private TextView fri;
    private LinearLayout frj;
    private LinearLayout frk;
    private LinearLayout frl;
    private TextView frm;
    private TextView frn;
    private ImageView fro;
    private ImageView frp;
    private TextView frq;
    private TextView frr;
    private TextView frt;
    private TextView fru;
    private RelativeLayout frv;
    private RelativeLayout frw;
    private LinearLayout frx;
    private LinearLayout fry;
    private ScrollView frz;
    private int screenWidth;
    private int frB = 2000;
    private long frG = 2000;
    private long frH = 10;
    private boolean frK = true;
    private boolean frL = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.frQ = aVar;
        initView();
        btt();
        btu();
        this.frv.setVisibility(4);
        this.frv.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cOy = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cOy) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cOy;
                    b.this.cOy = i;
                }
                b.this.frR = b.this.screenWidth;
                b.this.frP = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.frS = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.frP * 2);
                b.this.frT = (i2 * 1.0f) / b.this.frv.getHeight();
                if (b.this.cOy > b.this.frv.getHeight()) {
                    b.this.frO = (b.this.cOy - b.this.frv.getHeight()) / 2;
                }
                b.this.yL();
                b.this.frv.setVisibility(0);
            }
        });
    }

    private void btt() {
        bk.a aVar;
        bk.a aVar2;
        if (com.baidu.live.v.a.Ge() != null && com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAI != null && com.baidu.live.v.a.Ge().aYP.aAI.aBH != null) {
            bk bkVar = com.baidu.live.v.a.Ge().aYP.aAI.aBH;
            this.frC = bkVar.aCi;
            this.aCk = bkVar.aCk;
            this.aCl = bkVar.aCl;
            this.frD = bkVar.aCm;
            this.frE = bkVar.aCj;
            this.aCn = bkVar.aCn;
            this.frF = bkVar.aCo;
        }
        this.fre.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.frD)));
        this.frr.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aCn)));
        this.frt.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aCn)));
        this.fru.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.frE)));
        if (this.frF != null && !this.frF.isEmpty()) {
            if (this.frF.size() == 1) {
                aVar = this.frF.get(0);
                aVar2 = null;
            } else {
                aVar = this.frF.get(0);
                aVar2 = this.frF.get(1);
            }
            if (aVar == null) {
                this.frk.setVisibility(8);
            } else {
                this.frm.setText(aVar.aCp);
                this.frk.setVisibility(0);
                this.frI = aVar.aCq;
            }
            if (aVar2 == null) {
                this.frl.setVisibility(8);
            } else {
                this.frn.setText(aVar2.aCp);
                this.frl.setVisibility(0);
                this.frJ = aVar2.aCq;
            }
            if (this.frk.getVisibility() == 0 || this.frl.getVisibility() == 0) {
                this.frj.setVisibility(0);
                return;
            } else {
                this.frj.setVisibility(8);
                return;
            }
        }
        this.frj.setVisibility(8);
    }

    private void initView() {
        this.frb = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.frd = this.frb.findViewById(a.g.iv_send_red_q);
        this.fre = (TextView) this.frb.findViewById(a.g.tv_red_broad_hint);
        this.frf = (EditText) this.frb.findViewById(a.g.edt_t_num);
        this.frg = (EditText) this.frb.findViewById(a.g.edt_pkt_num);
        this.frh = (TextView) this.frb.findViewById(a.g.tv_send_t_num_hint);
        this.fri = (TextView) this.frb.findViewById(a.g.tv_send_pkt_num_hint);
        this.frj = (LinearLayout) this.frb.findViewById(a.g.layout_red_pkt_condition);
        this.frk = (LinearLayout) this.frb.findViewById(a.g.layout_condition_first);
        this.frl = (LinearLayout) this.frb.findViewById(a.g.layout_condition_second);
        this.frv = (RelativeLayout) this.frb.findViewById(a.g.layout_send_red_content);
        this.frw = (RelativeLayout) this.frb.findViewById(a.g.layout_send_red);
        this.frm = (TextView) this.frb.findViewById(a.g.tv_condition_first);
        this.frn = (TextView) this.frb.findViewById(a.g.tv_condition_second);
        this.fro = (ImageView) this.frb.findViewById(a.g.iv_condition_first);
        this.frp = (ImageView) this.frb.findViewById(a.g.iv_condition_second);
        this.frq = (TextView) this.frb.findViewById(a.g.tv_send_pkt_submit);
        this.frt = (TextView) this.frb.findViewById(a.g.tv_red_send_rule1);
        this.fru = (TextView) this.frb.findViewById(a.g.tv_red_send_rule3);
        this.frr = (TextView) this.frb.findViewById(a.g.tv_send_pkt_time);
        this.frx = (LinearLayout) this.frb.findViewById(a.g.layout_red_send_rule);
        this.fry = (LinearLayout) this.frb.findViewById(a.g.layout_red_send_rule_content);
        this.frz = (ScrollView) this.frb.findViewById(a.g.layout_input_scroll);
        this.frA = this.frb.findViewById(a.g.layout_send_red_close);
        this.frb.setOnClickListener(this);
        this.frk.setOnClickListener(this);
        this.frl.setOnClickListener(this);
        this.frq.setOnClickListener(this);
        this.frd.setOnClickListener(this);
        this.frx.setOnClickListener(this);
        this.fry.setOnClickListener(this);
        this.frw.setOnClickListener(this);
        this.frA.setOnClickListener(this);
        ((ImageView) this.frb.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.frf.setText(String.valueOf(this.frG));
        this.frg.setText(String.valueOf(this.frH));
        this.frf.setSelection(this.frf.getText().toString().length());
        this.frg.setSelection(this.frg.getText().toString().length());
    }

    private void btu() {
        this.frf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.btv()) {
                    b.this.jJ(true);
                }
            }
        });
        this.frg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.frg.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.frg.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.fri.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aCk), Integer.valueOf(b.this.aCl)));
                    b.this.fri.setVisibility(0);
                    b.this.frH = 0L;
                    b.this.frL = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.frg.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.frH = parseLong;
                    if (parseLong >= b.this.aCk && parseLong <= b.this.aCl) {
                        b.this.fri.setVisibility(8);
                        b.this.frL = true;
                    } else {
                        b.this.fri.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aCk), Integer.valueOf(b.this.aCl)));
                        b.this.fri.setVisibility(0);
                        b.this.frL = false;
                    }
                }
                b.this.frg.setSelection(b.this.frg.getText().toString().length());
                TextView textView = b.this.frq;
                if (!b.this.frK || !b.this.frL) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.btv();
                b.this.jJ(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btv() {
        boolean z = true;
        String obj = this.frf.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.frf.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.frh.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.frB), Long.valueOf(this.frC)));
            this.frh.setVisibility(0);
            this.frG = 0L;
            this.frK = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.frf.setText(String.valueOf(parseLong));
                return true;
            }
            this.frG = parseLong;
            if (parseLong < this.frB || parseLong > this.frC) {
                if (parseLong == 0) {
                    this.frf.setText("0");
                }
                this.frh.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.frB), Long.valueOf(this.frC)));
                this.frh.setVisibility(0);
                this.frK = false;
            } else {
                this.frh.setVisibility(8);
                this.frK = true;
            }
        }
        this.frf.setSelection(this.frf.getText().toString().length());
        TextView textView = this.frq;
        if (!this.frK || !this.frL) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        if (this.frL && this.frK && this.frH != 0 && this.frG / this.frH < this.frE) {
            this.frh.setVisibility(0);
            if (z) {
                this.frh.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.frH * 100)));
            } else {
                this.frh.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.frG / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.frx.getVisibility() == 0) {
            this.frx.setVisibility(8);
            return;
        }
        if (view == this.frA && !this.frU) {
            this.activity.finish();
        } else if (view == this.frb && !this.frU) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.frd) {
            this.frx.setVisibility(0);
        } else if (view == this.frk) {
            this.frM = this.frM ? false : true;
            if (this.frM) {
                this.fro.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fro.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.frl) {
            this.frN = this.frN ? false : true;
            if (this.frN) {
                this.frp.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.frp.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.frq) {
            if (this.frM && this.frN) {
                str = this.frI + Constants.ACCEPT_TIME_SEPARATOR_SP + this.frJ;
            } else if (this.frM) {
                str = this.frI;
            } else if (this.frN) {
                str = this.frJ;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.du(this.frG);
            oVar.dv(this.frH);
            oVar.BA(str);
            if (this.frQ != null) {
                this.frQ.a(oVar);
            }
        }
        if (this.frU && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void jK(boolean z) {
        if (this.frq != null) {
            this.frq.setEnabled(z);
        }
    }

    public View getView() {
        return this.frb;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.frU = z;
        if (!z) {
            if (this.frg != null) {
                this.frg.clearFocus();
            }
            if (this.frf != null) {
                this.frf.clearFocus();
            }
        }
        if (this.frv != null && this.frv.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frv.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.frO;
                }
            } else {
                layoutParams.topMargin = this.frP;
            }
            this.frv.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.frA.setVisibility(0);
        } else {
            this.frA.setVisibility(8);
        }
    }

    public void yL() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.T(this.frb);
        } else {
            h.U(this.frb);
        }
        if (this.frz != null && this.frz.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frz.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.frS;
            } else {
                layoutParams.height = -2;
            }
            this.frz.setLayoutParams(layoutParams);
        }
        if (this.frv != null && this.frv.getLayoutParams() != null && this.frR > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.frv.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.frv.setPivotX(this.frR / 2);
            this.frv.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.frv.setScaleX(this.frT);
                this.frv.setScaleY(this.frT);
            } else {
                layoutParams2.width = -1;
                this.frv.setScaleX(1.0f);
                this.frv.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.frU);
        }
    }
}
