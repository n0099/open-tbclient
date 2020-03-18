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
import com.baidu.live.data.bc;
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
    private Activity activity;
    private int aeA;
    private int aeC;
    private int aez;
    private int cdH;
    private View eyO;
    private View eyP;
    private TextView eyQ;
    private EditText eyR;
    private EditText eyS;
    private TextView eyT;
    private TextView eyU;
    private LinearLayout eyV;
    private LinearLayout eyW;
    private LinearLayout eyX;
    private TextView eyY;
    private TextView eyZ;
    private int ezA;
    private a ezB;
    private int ezC;
    private int ezD;
    private float ezE;
    private boolean ezF;
    private ImageView eza;
    private ImageView ezb;
    private TextView ezc;
    private TextView ezd;
    private TextView eze;
    private TextView ezf;
    private RelativeLayout ezg;
    private RelativeLayout ezh;
    private LinearLayout ezi;
    private LinearLayout ezj;
    private ScrollView ezk;
    private View ezl;
    private long ezn;
    private int ezo;
    private int ezp;
    private List<bc.a> ezq;
    private String ezt;
    private String ezu;
    private boolean ezx;
    private boolean ezy;
    private int ezz;
    private int screenWidth;
    private int ezm = 2000;
    private long ezr = 2000;
    private long ezs = 10;
    private boolean ezv = true;
    private boolean ezw = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.ezB = aVar;
        initView();
        bel();
        bem();
        this.ezg.setVisibility(4);
        this.ezg.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cdH = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cdH) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cdH;
                    b.this.cdH = i;
                }
                b.this.ezC = b.this.screenWidth;
                b.this.ezA = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.ezD = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.ezA * 2);
                b.this.ezE = (i2 * 1.0f) / b.this.ezg.getHeight();
                if (b.this.cdH > b.this.ezg.getHeight()) {
                    b.this.ezz = (b.this.cdH - b.this.ezg.getHeight()) / 2;
                }
                b.this.tf();
                b.this.ezg.setVisibility(0);
            }
        });
    }

    private void bel() {
        bc.a aVar;
        bc.a aVar2;
        if (com.baidu.live.v.a.zs() != null && com.baidu.live.v.a.zs().axR != null && com.baidu.live.v.a.zs().axR.adc != null && com.baidu.live.v.a.zs().axR.adc.aeb != null) {
            bc bcVar = com.baidu.live.v.a.zs().axR.adc.aeb;
            this.ezn = bcVar.aex;
            this.aez = bcVar.aez;
            this.aeA = bcVar.aeA;
            this.ezo = bcVar.aeB;
            this.ezp = bcVar.aey;
            this.aeC = bcVar.aeC;
            this.ezq = bcVar.aeD;
        }
        this.eyQ.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.ezo)));
        this.ezd.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aeC)));
        this.eze.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aeC)));
        this.ezf.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.ezp)));
        if (this.ezq != null && !this.ezq.isEmpty()) {
            if (this.ezq.size() == 1) {
                aVar = this.ezq.get(0);
                aVar2 = null;
            } else {
                aVar = this.ezq.get(0);
                aVar2 = this.ezq.get(1);
            }
            if (aVar == null) {
                this.eyW.setVisibility(8);
            } else {
                this.eyY.setText(aVar.aeE);
                this.eyW.setVisibility(0);
                this.ezt = aVar.aeF;
            }
            if (aVar2 == null) {
                this.eyX.setVisibility(8);
            } else {
                this.eyZ.setText(aVar2.aeE);
                this.eyX.setVisibility(0);
                this.ezu = aVar2.aeF;
            }
            if (this.eyW.getVisibility() == 0 || this.eyX.getVisibility() == 0) {
                this.eyV.setVisibility(0);
                return;
            } else {
                this.eyV.setVisibility(8);
                return;
            }
        }
        this.eyV.setVisibility(8);
    }

    private void initView() {
        this.eyO = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.eyP = this.eyO.findViewById(a.g.iv_send_red_q);
        this.eyQ = (TextView) this.eyO.findViewById(a.g.tv_red_broad_hint);
        this.eyR = (EditText) this.eyO.findViewById(a.g.edt_t_num);
        this.eyS = (EditText) this.eyO.findViewById(a.g.edt_pkt_num);
        this.eyT = (TextView) this.eyO.findViewById(a.g.tv_send_t_num_hint);
        this.eyU = (TextView) this.eyO.findViewById(a.g.tv_send_pkt_num_hint);
        this.eyV = (LinearLayout) this.eyO.findViewById(a.g.layout_red_pkt_condition);
        this.eyW = (LinearLayout) this.eyO.findViewById(a.g.layout_condition_first);
        this.eyX = (LinearLayout) this.eyO.findViewById(a.g.layout_condition_second);
        this.ezg = (RelativeLayout) this.eyO.findViewById(a.g.layout_send_red_content);
        this.ezh = (RelativeLayout) this.eyO.findViewById(a.g.layout_send_red);
        this.eyY = (TextView) this.eyO.findViewById(a.g.tv_condition_first);
        this.eyZ = (TextView) this.eyO.findViewById(a.g.tv_condition_second);
        this.eza = (ImageView) this.eyO.findViewById(a.g.iv_condition_first);
        this.ezb = (ImageView) this.eyO.findViewById(a.g.iv_condition_second);
        this.ezc = (TextView) this.eyO.findViewById(a.g.tv_send_pkt_submit);
        this.eze = (TextView) this.eyO.findViewById(a.g.tv_red_send_rule1);
        this.ezf = (TextView) this.eyO.findViewById(a.g.tv_red_send_rule3);
        this.ezd = (TextView) this.eyO.findViewById(a.g.tv_send_pkt_time);
        this.ezi = (LinearLayout) this.eyO.findViewById(a.g.layout_red_send_rule);
        this.ezj = (LinearLayout) this.eyO.findViewById(a.g.layout_red_send_rule_content);
        this.ezk = (ScrollView) this.eyO.findViewById(a.g.layout_input_scroll);
        this.ezl = this.eyO.findViewById(a.g.layout_send_red_close);
        this.eyO.setOnClickListener(this);
        this.eyW.setOnClickListener(this);
        this.eyX.setOnClickListener(this);
        this.ezc.setOnClickListener(this);
        this.eyP.setOnClickListener(this);
        this.ezi.setOnClickListener(this);
        this.ezj.setOnClickListener(this);
        this.ezh.setOnClickListener(this);
        this.ezl.setOnClickListener(this);
        ((ImageView) this.eyO.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.eyR.setText(String.valueOf(this.ezr));
        this.eyS.setText(String.valueOf(this.ezs));
        this.eyR.setSelection(this.eyR.getText().toString().length());
        this.eyS.setSelection(this.eyS.getText().toString().length());
    }

    private void bem() {
        this.eyR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.ben()) {
                    b.this.ip(true);
                }
            }
        });
        this.eyS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.eyS.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.eyS.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.eyU.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aez), Integer.valueOf(b.this.aeA)));
                    b.this.eyU.setVisibility(0);
                    b.this.ezs = 0L;
                    b.this.ezw = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.eyS.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.ezs = parseLong;
                    if (parseLong >= b.this.aez && parseLong <= b.this.aeA) {
                        b.this.eyU.setVisibility(8);
                        b.this.ezw = true;
                    } else {
                        b.this.eyU.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aez), Integer.valueOf(b.this.aeA)));
                        b.this.eyU.setVisibility(0);
                        b.this.ezw = false;
                    }
                }
                b.this.eyS.setSelection(b.this.eyS.getText().toString().length());
                TextView textView = b.this.ezc;
                if (!b.this.ezv || !b.this.ezw) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.ben();
                b.this.ip(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ben() {
        boolean z = true;
        String obj = this.eyR.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.eyR.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.eyT.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.ezm), Long.valueOf(this.ezn)));
            this.eyT.setVisibility(0);
            this.ezr = 0L;
            this.ezv = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.eyR.setText(String.valueOf(parseLong));
                return true;
            }
            this.ezr = parseLong;
            if (parseLong < this.ezm || parseLong > this.ezn) {
                if (parseLong == 0) {
                    this.eyR.setText("0");
                }
                this.eyT.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.ezm), Long.valueOf(this.ezn)));
                this.eyT.setVisibility(0);
                this.ezv = false;
            } else {
                this.eyT.setVisibility(8);
                this.ezv = true;
            }
        }
        this.eyR.setSelection(this.eyR.getText().toString().length());
        TextView textView = this.ezc;
        if (!this.ezv || !this.ezw) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip(boolean z) {
        if (this.ezw && this.ezv && this.ezs != 0 && this.ezr / this.ezs < this.ezp) {
            this.eyT.setVisibility(0);
            if (z) {
                this.eyT.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.ezs * 100)));
            } else {
                this.eyT.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.ezr / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.ezi.getVisibility() == 0) {
            this.ezi.setVisibility(8);
            return;
        }
        if (view == this.ezl && !this.ezF) {
            this.activity.finish();
        } else if (view == this.eyO && !this.ezF) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.eyP) {
            this.ezi.setVisibility(0);
        } else if (view == this.eyW) {
            this.ezx = this.ezx ? false : true;
            if (this.ezx) {
                this.eza.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eza.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyX) {
            this.ezy = this.ezy ? false : true;
            if (this.ezy) {
                this.ezb.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.ezb.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.ezc) {
            if (this.ezx && this.ezy) {
                str = this.ezt + Constants.ACCEPT_TIME_SEPARATOR_SP + this.ezu;
            } else if (this.ezx) {
                str = this.ezt;
            } else if (this.ezy) {
                str = this.ezu;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cK(this.ezr);
            oVar.cL(this.ezs);
            oVar.yh(str);
            if (this.ezB != null) {
                this.ezB.a(oVar);
            }
        }
        if (this.ezF && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void iq(boolean z) {
        if (this.ezc != null) {
            this.ezc.setEnabled(z);
        }
    }

    public View getView() {
        return this.eyO;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ezF = z;
        if (!z) {
            if (this.eyS != null) {
                this.eyS.clearFocus();
            }
            if (this.eyR != null) {
                this.eyR.clearFocus();
            }
        }
        if (this.ezg != null && this.ezg.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezg.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.ezz;
                }
            } else {
                layoutParams.topMargin = this.ezA;
            }
            this.ezg.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ezl.setVisibility(0);
        } else {
            this.ezl.setVisibility(8);
        }
    }

    public void tf() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.S(this.eyO);
        } else {
            h.T(this.eyO);
        }
        if (this.ezk != null && this.ezk.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ezk.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.ezD;
            } else {
                layoutParams.height = -2;
            }
            this.ezk.setLayoutParams(layoutParams);
        }
        if (this.ezg != null && this.ezg.getLayoutParams() != null && this.ezC > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ezg.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.ezg.setPivotX(this.ezC / 2);
            this.ezg.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.ezg.setScaleX(this.ezE);
                this.ezg.setScaleY(this.ezE);
            } else {
                layoutParams2.width = -1;
                this.ezg.setScaleX(1.0f);
                this.ezg.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.ezF);
        }
    }
}
