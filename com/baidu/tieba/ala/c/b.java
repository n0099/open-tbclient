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
    private View fqQ;
    private View fqR;
    private TextView fqS;
    private EditText fqT;
    private EditText fqU;
    private TextView fqV;
    private TextView fqW;
    private LinearLayout fqX;
    private LinearLayout fqY;
    private LinearLayout fqZ;
    private boolean frB;
    private boolean frC;
    private int frD;
    private int frE;
    private a frF;
    private int frG;
    private int frH;
    private float frI;
    private boolean frJ;
    private TextView fra;
    private TextView frb;
    private ImageView frd;
    private ImageView fre;
    private TextView frf;
    private TextView frg;
    private TextView frh;
    private TextView fri;
    private RelativeLayout frj;
    private RelativeLayout frk;
    private LinearLayout frl;
    private LinearLayout frm;
    private ScrollView frn;
    private View fro;
    private long frq;
    private int frr;
    private int frt;
    private List<bk.a> fru;
    private String frx;
    private String fry;
    private int screenWidth;
    private int frp = 2000;
    private long frv = 2000;
    private long frw = 10;
    private boolean frz = true;
    private boolean frA = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.frF = aVar;
        initView();
        btr();
        bts();
        this.frj.setVisibility(4);
        this.frj.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cOy = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cOy) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cOy;
                    b.this.cOy = i;
                }
                b.this.frG = b.this.screenWidth;
                b.this.frE = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.frH = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.frE * 2);
                b.this.frI = (i2 * 1.0f) / b.this.frj.getHeight();
                if (b.this.cOy > b.this.frj.getHeight()) {
                    b.this.frD = (b.this.cOy - b.this.frj.getHeight()) / 2;
                }
                b.this.yL();
                b.this.frj.setVisibility(0);
            }
        });
    }

    private void btr() {
        bk.a aVar;
        bk.a aVar2;
        if (com.baidu.live.v.a.Ge() != null && com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAI != null && com.baidu.live.v.a.Ge().aYP.aAI.aBH != null) {
            bk bkVar = com.baidu.live.v.a.Ge().aYP.aAI.aBH;
            this.frq = bkVar.aCi;
            this.aCk = bkVar.aCk;
            this.aCl = bkVar.aCl;
            this.frr = bkVar.aCm;
            this.frt = bkVar.aCj;
            this.aCn = bkVar.aCn;
            this.fru = bkVar.aCo;
        }
        this.fqS.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.frr)));
        this.frg.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aCn)));
        this.frh.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aCn)));
        this.fri.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.frt)));
        if (this.fru != null && !this.fru.isEmpty()) {
            if (this.fru.size() == 1) {
                aVar = this.fru.get(0);
                aVar2 = null;
            } else {
                aVar = this.fru.get(0);
                aVar2 = this.fru.get(1);
            }
            if (aVar == null) {
                this.fqY.setVisibility(8);
            } else {
                this.fra.setText(aVar.aCp);
                this.fqY.setVisibility(0);
                this.frx = aVar.aCq;
            }
            if (aVar2 == null) {
                this.fqZ.setVisibility(8);
            } else {
                this.frb.setText(aVar2.aCp);
                this.fqZ.setVisibility(0);
                this.fry = aVar2.aCq;
            }
            if (this.fqY.getVisibility() == 0 || this.fqZ.getVisibility() == 0) {
                this.fqX.setVisibility(0);
                return;
            } else {
                this.fqX.setVisibility(8);
                return;
            }
        }
        this.fqX.setVisibility(8);
    }

    private void initView() {
        this.fqQ = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fqR = this.fqQ.findViewById(a.g.iv_send_red_q);
        this.fqS = (TextView) this.fqQ.findViewById(a.g.tv_red_broad_hint);
        this.fqT = (EditText) this.fqQ.findViewById(a.g.edt_t_num);
        this.fqU = (EditText) this.fqQ.findViewById(a.g.edt_pkt_num);
        this.fqV = (TextView) this.fqQ.findViewById(a.g.tv_send_t_num_hint);
        this.fqW = (TextView) this.fqQ.findViewById(a.g.tv_send_pkt_num_hint);
        this.fqX = (LinearLayout) this.fqQ.findViewById(a.g.layout_red_pkt_condition);
        this.fqY = (LinearLayout) this.fqQ.findViewById(a.g.layout_condition_first);
        this.fqZ = (LinearLayout) this.fqQ.findViewById(a.g.layout_condition_second);
        this.frj = (RelativeLayout) this.fqQ.findViewById(a.g.layout_send_red_content);
        this.frk = (RelativeLayout) this.fqQ.findViewById(a.g.layout_send_red);
        this.fra = (TextView) this.fqQ.findViewById(a.g.tv_condition_first);
        this.frb = (TextView) this.fqQ.findViewById(a.g.tv_condition_second);
        this.frd = (ImageView) this.fqQ.findViewById(a.g.iv_condition_first);
        this.fre = (ImageView) this.fqQ.findViewById(a.g.iv_condition_second);
        this.frf = (TextView) this.fqQ.findViewById(a.g.tv_send_pkt_submit);
        this.frh = (TextView) this.fqQ.findViewById(a.g.tv_red_send_rule1);
        this.fri = (TextView) this.fqQ.findViewById(a.g.tv_red_send_rule3);
        this.frg = (TextView) this.fqQ.findViewById(a.g.tv_send_pkt_time);
        this.frl = (LinearLayout) this.fqQ.findViewById(a.g.layout_red_send_rule);
        this.frm = (LinearLayout) this.fqQ.findViewById(a.g.layout_red_send_rule_content);
        this.frn = (ScrollView) this.fqQ.findViewById(a.g.layout_input_scroll);
        this.fro = this.fqQ.findViewById(a.g.layout_send_red_close);
        this.fqQ.setOnClickListener(this);
        this.fqY.setOnClickListener(this);
        this.fqZ.setOnClickListener(this);
        this.frf.setOnClickListener(this);
        this.fqR.setOnClickListener(this);
        this.frl.setOnClickListener(this);
        this.frm.setOnClickListener(this);
        this.frk.setOnClickListener(this);
        this.fro.setOnClickListener(this);
        ((ImageView) this.fqQ.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.fqT.setText(String.valueOf(this.frv));
        this.fqU.setText(String.valueOf(this.frw));
        this.fqT.setSelection(this.fqT.getText().toString().length());
        this.fqU.setSelection(this.fqU.getText().toString().length());
    }

    private void bts() {
        this.fqT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.btt()) {
                    b.this.jJ(true);
                }
            }
        });
        this.fqU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.fqU.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.fqU.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.fqW.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aCk), Integer.valueOf(b.this.aCl)));
                    b.this.fqW.setVisibility(0);
                    b.this.frw = 0L;
                    b.this.frA = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.fqU.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.frw = parseLong;
                    if (parseLong >= b.this.aCk && parseLong <= b.this.aCl) {
                        b.this.fqW.setVisibility(8);
                        b.this.frA = true;
                    } else {
                        b.this.fqW.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aCk), Integer.valueOf(b.this.aCl)));
                        b.this.fqW.setVisibility(0);
                        b.this.frA = false;
                    }
                }
                b.this.fqU.setSelection(b.this.fqU.getText().toString().length());
                TextView textView = b.this.frf;
                if (!b.this.frz || !b.this.frA) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.btt();
                b.this.jJ(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btt() {
        boolean z = true;
        String obj = this.fqT.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.fqT.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.fqV.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.frp), Long.valueOf(this.frq)));
            this.fqV.setVisibility(0);
            this.frv = 0L;
            this.frz = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fqT.setText(String.valueOf(parseLong));
                return true;
            }
            this.frv = parseLong;
            if (parseLong < this.frp || parseLong > this.frq) {
                if (parseLong == 0) {
                    this.fqT.setText("0");
                }
                this.fqV.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.frp), Long.valueOf(this.frq)));
                this.fqV.setVisibility(0);
                this.frz = false;
            } else {
                this.fqV.setVisibility(8);
                this.frz = true;
            }
        }
        this.fqT.setSelection(this.fqT.getText().toString().length());
        TextView textView = this.frf;
        if (!this.frz || !this.frA) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jJ(boolean z) {
        if (this.frA && this.frz && this.frw != 0 && this.frv / this.frw < this.frt) {
            this.fqV.setVisibility(0);
            if (z) {
                this.fqV.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.frw * 100)));
            } else {
                this.fqV.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.frv / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.frl.getVisibility() == 0) {
            this.frl.setVisibility(8);
            return;
        }
        if (view == this.fro && !this.frJ) {
            this.activity.finish();
        } else if (view == this.fqQ && !this.frJ) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fqR) {
            this.frl.setVisibility(0);
        } else if (view == this.fqY) {
            this.frB = this.frB ? false : true;
            if (this.frB) {
                this.frd.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.frd.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fqZ) {
            this.frC = this.frC ? false : true;
            if (this.frC) {
                this.fre.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fre.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.frf) {
            if (this.frB && this.frC) {
                str = this.frx + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fry;
            } else if (this.frB) {
                str = this.frx;
            } else if (this.frC) {
                str = this.fry;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.du(this.frv);
            oVar.dv(this.frw);
            oVar.BA(str);
            if (this.frF != null) {
                this.frF.a(oVar);
            }
        }
        if (this.frJ && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void jK(boolean z) {
        if (this.frf != null) {
            this.frf.setEnabled(z);
        }
    }

    public View getView() {
        return this.fqQ;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.frJ = z;
        if (!z) {
            if (this.fqU != null) {
                this.fqU.clearFocus();
            }
            if (this.fqT != null) {
                this.fqT.clearFocus();
            }
        }
        if (this.frj != null && this.frj.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frj.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.frD;
                }
            } else {
                layoutParams.topMargin = this.frE;
            }
            this.frj.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fro.setVisibility(0);
        } else {
            this.fro.setVisibility(8);
        }
    }

    public void yL() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.T(this.fqQ);
        } else {
            h.U(this.fqQ);
        }
        if (this.frn != null && this.frn.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.frn.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.frH;
            } else {
                layoutParams.height = -2;
            }
            this.frn.setLayoutParams(layoutParams);
        }
        if (this.frj != null && this.frj.getLayoutParams() != null && this.frG > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.frj.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.frj.setPivotX(this.frG / 2);
            this.frj.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.frj.setScaleX(this.frI);
                this.frj.setScaleY(this.frI);
            } else {
                layoutParams2.width = -1;
                this.frj.setScaleX(1.0f);
                this.frj.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.frJ);
        }
    }
}
