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
import com.baidu.live.data.bf;
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
    private int awV;
    private int awW;
    private int awY;
    private int cCL;
    private ImageView fdA;
    private TextView fdB;
    private TextView fdC;
    private TextView fdD;
    private TextView fdE;
    private RelativeLayout fdF;
    private RelativeLayout fdG;
    private LinearLayout fdH;
    private LinearLayout fdI;
    private ScrollView fdJ;
    private View fdK;
    private long fdM;
    private int fdN;
    private int fdO;
    private List<bf.a> fdP;
    private String fdS;
    private String fdT;
    private boolean fdW;
    private boolean fdX;
    private int fdY;
    private int fdZ;
    private View fdn;
    private View fdo;
    private TextView fdp;
    private EditText fdq;
    private EditText fdr;
    private TextView fds;
    private TextView fdt;
    private LinearLayout fdu;
    private LinearLayout fdv;
    private LinearLayout fdw;
    private TextView fdx;
    private TextView fdy;
    private ImageView fdz;
    private a fea;
    private int feb;
    private int fec;
    private float fed;
    private boolean fee;
    private int screenWidth;
    private int fdL = 2000;
    private long fdQ = 2000;
    private long fdR = 10;
    private boolean fdU = true;
    private boolean fdV = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.fea = aVar;
        initView();
        bnz();
        bnA();
        this.fdF.setVisibility(4);
        this.fdF.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cCL = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cCL) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cCL;
                    b.this.cCL = i;
                }
                b.this.feb = b.this.screenWidth;
                b.this.fdZ = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.fec = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.fdZ * 2);
                b.this.fed = (i2 * 1.0f) / b.this.fdF.getHeight();
                if (b.this.cCL > b.this.fdF.getHeight()) {
                    b.this.fdY = (b.this.cCL - b.this.fdF.getHeight()) / 2;
                }
                b.this.xx();
                b.this.fdF.setVisibility(0);
            }
        });
    }

    private void bnz() {
        bf.a aVar;
        bf.a aVar2;
        if (com.baidu.live.v.a.En() != null && com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avA != null && com.baidu.live.v.a.En().aRB.avA.awy != null) {
            bf bfVar = com.baidu.live.v.a.En().aRB.avA.awy;
            this.fdM = bfVar.awT;
            this.awV = bfVar.awV;
            this.awW = bfVar.awW;
            this.fdN = bfVar.awX;
            this.fdO = bfVar.awU;
            this.awY = bfVar.awY;
            this.fdP = bfVar.awZ;
        }
        this.fdp.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fdN)));
        this.fdC.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.awY)));
        this.fdD.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.awY)));
        this.fdE.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fdO)));
        if (this.fdP != null && !this.fdP.isEmpty()) {
            if (this.fdP.size() == 1) {
                aVar = this.fdP.get(0);
                aVar2 = null;
            } else {
                aVar = this.fdP.get(0);
                aVar2 = this.fdP.get(1);
            }
            if (aVar == null) {
                this.fdv.setVisibility(8);
            } else {
                this.fdx.setText(aVar.axa);
                this.fdv.setVisibility(0);
                this.fdS = aVar.axb;
            }
            if (aVar2 == null) {
                this.fdw.setVisibility(8);
            } else {
                this.fdy.setText(aVar2.axa);
                this.fdw.setVisibility(0);
                this.fdT = aVar2.axb;
            }
            if (this.fdv.getVisibility() == 0 || this.fdw.getVisibility() == 0) {
                this.fdu.setVisibility(0);
                return;
            } else {
                this.fdu.setVisibility(8);
                return;
            }
        }
        this.fdu.setVisibility(8);
    }

    private void initView() {
        this.fdn = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fdo = this.fdn.findViewById(a.g.iv_send_red_q);
        this.fdp = (TextView) this.fdn.findViewById(a.g.tv_red_broad_hint);
        this.fdq = (EditText) this.fdn.findViewById(a.g.edt_t_num);
        this.fdr = (EditText) this.fdn.findViewById(a.g.edt_pkt_num);
        this.fds = (TextView) this.fdn.findViewById(a.g.tv_send_t_num_hint);
        this.fdt = (TextView) this.fdn.findViewById(a.g.tv_send_pkt_num_hint);
        this.fdu = (LinearLayout) this.fdn.findViewById(a.g.layout_red_pkt_condition);
        this.fdv = (LinearLayout) this.fdn.findViewById(a.g.layout_condition_first);
        this.fdw = (LinearLayout) this.fdn.findViewById(a.g.layout_condition_second);
        this.fdF = (RelativeLayout) this.fdn.findViewById(a.g.layout_send_red_content);
        this.fdG = (RelativeLayout) this.fdn.findViewById(a.g.layout_send_red);
        this.fdx = (TextView) this.fdn.findViewById(a.g.tv_condition_first);
        this.fdy = (TextView) this.fdn.findViewById(a.g.tv_condition_second);
        this.fdz = (ImageView) this.fdn.findViewById(a.g.iv_condition_first);
        this.fdA = (ImageView) this.fdn.findViewById(a.g.iv_condition_second);
        this.fdB = (TextView) this.fdn.findViewById(a.g.tv_send_pkt_submit);
        this.fdD = (TextView) this.fdn.findViewById(a.g.tv_red_send_rule1);
        this.fdE = (TextView) this.fdn.findViewById(a.g.tv_red_send_rule3);
        this.fdC = (TextView) this.fdn.findViewById(a.g.tv_send_pkt_time);
        this.fdH = (LinearLayout) this.fdn.findViewById(a.g.layout_red_send_rule);
        this.fdI = (LinearLayout) this.fdn.findViewById(a.g.layout_red_send_rule_content);
        this.fdJ = (ScrollView) this.fdn.findViewById(a.g.layout_input_scroll);
        this.fdK = this.fdn.findViewById(a.g.layout_send_red_close);
        this.fdn.setOnClickListener(this);
        this.fdv.setOnClickListener(this);
        this.fdw.setOnClickListener(this);
        this.fdB.setOnClickListener(this);
        this.fdo.setOnClickListener(this);
        this.fdH.setOnClickListener(this);
        this.fdI.setOnClickListener(this);
        this.fdG.setOnClickListener(this);
        this.fdK.setOnClickListener(this);
        ((ImageView) this.fdn.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.fdq.setText(String.valueOf(this.fdQ));
        this.fdr.setText(String.valueOf(this.fdR));
        this.fdq.setSelection(this.fdq.getText().toString().length());
        this.fdr.setSelection(this.fdr.getText().toString().length());
    }

    private void bnA() {
        this.fdq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bnB()) {
                    b.this.jq(true);
                }
            }
        });
        this.fdr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.fdr.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.fdr.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.fdt.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.awV), Integer.valueOf(b.this.awW)));
                    b.this.fdt.setVisibility(0);
                    b.this.fdR = 0L;
                    b.this.fdV = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.fdr.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.fdR = parseLong;
                    if (parseLong >= b.this.awV && parseLong <= b.this.awW) {
                        b.this.fdt.setVisibility(8);
                        b.this.fdV = true;
                    } else {
                        b.this.fdt.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.awV), Integer.valueOf(b.this.awW)));
                        b.this.fdt.setVisibility(0);
                        b.this.fdV = false;
                    }
                }
                b.this.fdr.setSelection(b.this.fdr.getText().toString().length());
                TextView textView = b.this.fdB;
                if (!b.this.fdU || !b.this.fdV) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bnB();
                b.this.jq(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnB() {
        boolean z = true;
        String obj = this.fdq.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.fdq.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.fds.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fdL), Long.valueOf(this.fdM)));
            this.fds.setVisibility(0);
            this.fdQ = 0L;
            this.fdU = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fdq.setText(String.valueOf(parseLong));
                return true;
            }
            this.fdQ = parseLong;
            if (parseLong < this.fdL || parseLong > this.fdM) {
                if (parseLong == 0) {
                    this.fdq.setText("0");
                }
                this.fds.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fdL), Long.valueOf(this.fdM)));
                this.fds.setVisibility(0);
                this.fdU = false;
            } else {
                this.fds.setVisibility(8);
                this.fdU = true;
            }
        }
        this.fdq.setSelection(this.fdq.getText().toString().length());
        TextView textView = this.fdB;
        if (!this.fdU || !this.fdV) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(boolean z) {
        if (this.fdV && this.fdU && this.fdR != 0 && this.fdQ / this.fdR < this.fdO) {
            this.fds.setVisibility(0);
            if (z) {
                this.fds.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fdR * 100)));
            } else {
                this.fds.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fdQ / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fdH.getVisibility() == 0) {
            this.fdH.setVisibility(8);
            return;
        }
        if (view == this.fdK && !this.fee) {
            this.activity.finish();
        } else if (view == this.fdn && !this.fee) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fdo) {
            this.fdH.setVisibility(0);
        } else if (view == this.fdv) {
            this.fdW = this.fdW ? false : true;
            if (this.fdW) {
                this.fdz.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fdz.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fdw) {
            this.fdX = this.fdX ? false : true;
            if (this.fdX) {
                this.fdA.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fdA.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fdB) {
            if (this.fdW && this.fdX) {
                str = this.fdS + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fdT;
            } else if (this.fdW) {
                str = this.fdS;
            } else if (this.fdX) {
                str = this.fdT;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.ds(this.fdQ);
            oVar.dt(this.fdR);
            oVar.zT(str);
            if (this.fea != null) {
                this.fea.a(oVar);
            }
        }
        if (this.fee && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void jr(boolean z) {
        if (this.fdB != null) {
            this.fdB.setEnabled(z);
        }
    }

    public View getView() {
        return this.fdn;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fee = z;
        if (!z) {
            if (this.fdr != null) {
                this.fdr.clearFocus();
            }
            if (this.fdq != null) {
                this.fdq.clearFocus();
            }
        }
        if (this.fdF != null && this.fdF.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdF.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fdY;
                }
            } else {
                layoutParams.topMargin = this.fdZ;
            }
            this.fdF.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fdK.setVisibility(0);
        } else {
            this.fdK.setVisibility(8);
        }
    }

    public void xx() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.U(this.fdn);
        } else {
            h.V(this.fdn);
        }
        if (this.fdJ != null && this.fdJ.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdJ.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fec;
            } else {
                layoutParams.height = -2;
            }
            this.fdJ.setLayoutParams(layoutParams);
        }
        if (this.fdF != null && this.fdF.getLayoutParams() != null && this.feb > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fdF.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fdF.setPivotX(this.feb / 2);
            this.fdF.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fdF.setScaleX(this.fed);
                this.fdF.setScaleY(this.fed);
            } else {
                layoutParams2.width = -1;
                this.fdF.setScaleX(1.0f);
                this.fdF.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fee);
        }
    }
}
