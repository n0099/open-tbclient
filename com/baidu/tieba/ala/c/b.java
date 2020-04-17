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
    private int awP;
    private int awQ;
    private int awS;
    private int cCF;
    private RelativeLayout fdA;
    private RelativeLayout fdB;
    private LinearLayout fdC;
    private LinearLayout fdD;
    private ScrollView fdE;
    private View fdF;
    private long fdH;
    private int fdI;
    private int fdJ;
    private List<bf.a> fdK;
    private String fdN;
    private String fdO;
    private boolean fdR;
    private boolean fdS;
    private int fdT;
    private int fdU;
    private a fdV;
    private int fdW;
    private int fdX;
    private float fdY;
    private boolean fdZ;
    private View fdi;
    private View fdj;
    private TextView fdk;
    private EditText fdl;
    private EditText fdm;
    private TextView fdn;
    private TextView fdo;
    private LinearLayout fdp;
    private LinearLayout fdq;
    private LinearLayout fdr;
    private TextView fds;
    private TextView fdt;
    private ImageView fdu;
    private ImageView fdv;
    private TextView fdw;
    private TextView fdx;
    private TextView fdy;
    private TextView fdz;
    private int screenWidth;
    private int fdG = 2000;
    private long fdL = 2000;
    private long fdM = 10;
    private boolean fdP = true;
    private boolean fdQ = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.fdV = aVar;
        initView();
        bnB();
        bnC();
        this.fdA.setVisibility(4);
        this.fdA.post(new Runnable() { // from class: com.baidu.tieba.ala.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cCF = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cCF) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cCF;
                    b.this.cCF = i;
                }
                b.this.fdW = b.this.screenWidth;
                b.this.fdU = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.fdX = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.fdU * 2);
                b.this.fdY = (i2 * 1.0f) / b.this.fdA.getHeight();
                if (b.this.cCF > b.this.fdA.getHeight()) {
                    b.this.fdT = (b.this.cCF - b.this.fdA.getHeight()) / 2;
                }
                b.this.xy();
                b.this.fdA.setVisibility(0);
            }
        });
    }

    private void bnB() {
        bf.a aVar;
        bf.a aVar2;
        if (com.baidu.live.v.a.Eo() != null && com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avu != null && com.baidu.live.v.a.Eo().aRw.avu.aws != null) {
            bf bfVar = com.baidu.live.v.a.Eo().aRw.avu.aws;
            this.fdH = bfVar.awN;
            this.awP = bfVar.awP;
            this.awQ = bfVar.awQ;
            this.fdI = bfVar.awR;
            this.fdJ = bfVar.awO;
            this.awS = bfVar.awS;
            this.fdK = bfVar.awT;
        }
        this.fdk.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.fdI)));
        this.fdx.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.awS)));
        this.fdy.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.awS)));
        this.fdz.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.fdJ)));
        if (this.fdK != null && !this.fdK.isEmpty()) {
            if (this.fdK.size() == 1) {
                aVar = this.fdK.get(0);
                aVar2 = null;
            } else {
                aVar = this.fdK.get(0);
                aVar2 = this.fdK.get(1);
            }
            if (aVar == null) {
                this.fdq.setVisibility(8);
            } else {
                this.fds.setText(aVar.awU);
                this.fdq.setVisibility(0);
                this.fdN = aVar.awV;
            }
            if (aVar2 == null) {
                this.fdr.setVisibility(8);
            } else {
                this.fdt.setText(aVar2.awU);
                this.fdr.setVisibility(0);
                this.fdO = aVar2.awV;
            }
            if (this.fdq.getVisibility() == 0 || this.fdr.getVisibility() == 0) {
                this.fdp.setVisibility(0);
                return;
            } else {
                this.fdp.setVisibility(8);
                return;
            }
        }
        this.fdp.setVisibility(8);
    }

    private void initView() {
        this.fdi = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.fdj = this.fdi.findViewById(a.g.iv_send_red_q);
        this.fdk = (TextView) this.fdi.findViewById(a.g.tv_red_broad_hint);
        this.fdl = (EditText) this.fdi.findViewById(a.g.edt_t_num);
        this.fdm = (EditText) this.fdi.findViewById(a.g.edt_pkt_num);
        this.fdn = (TextView) this.fdi.findViewById(a.g.tv_send_t_num_hint);
        this.fdo = (TextView) this.fdi.findViewById(a.g.tv_send_pkt_num_hint);
        this.fdp = (LinearLayout) this.fdi.findViewById(a.g.layout_red_pkt_condition);
        this.fdq = (LinearLayout) this.fdi.findViewById(a.g.layout_condition_first);
        this.fdr = (LinearLayout) this.fdi.findViewById(a.g.layout_condition_second);
        this.fdA = (RelativeLayout) this.fdi.findViewById(a.g.layout_send_red_content);
        this.fdB = (RelativeLayout) this.fdi.findViewById(a.g.layout_send_red);
        this.fds = (TextView) this.fdi.findViewById(a.g.tv_condition_first);
        this.fdt = (TextView) this.fdi.findViewById(a.g.tv_condition_second);
        this.fdu = (ImageView) this.fdi.findViewById(a.g.iv_condition_first);
        this.fdv = (ImageView) this.fdi.findViewById(a.g.iv_condition_second);
        this.fdw = (TextView) this.fdi.findViewById(a.g.tv_send_pkt_submit);
        this.fdy = (TextView) this.fdi.findViewById(a.g.tv_red_send_rule1);
        this.fdz = (TextView) this.fdi.findViewById(a.g.tv_red_send_rule3);
        this.fdx = (TextView) this.fdi.findViewById(a.g.tv_send_pkt_time);
        this.fdC = (LinearLayout) this.fdi.findViewById(a.g.layout_red_send_rule);
        this.fdD = (LinearLayout) this.fdi.findViewById(a.g.layout_red_send_rule_content);
        this.fdE = (ScrollView) this.fdi.findViewById(a.g.layout_input_scroll);
        this.fdF = this.fdi.findViewById(a.g.layout_send_red_close);
        this.fdi.setOnClickListener(this);
        this.fdq.setOnClickListener(this);
        this.fdr.setOnClickListener(this);
        this.fdw.setOnClickListener(this);
        this.fdj.setOnClickListener(this);
        this.fdC.setOnClickListener(this);
        this.fdD.setOnClickListener(this);
        this.fdB.setOnClickListener(this);
        this.fdF.setOnClickListener(this);
        ((ImageView) this.fdi.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.fdl.setText(String.valueOf(this.fdL));
        this.fdm.setText(String.valueOf(this.fdM));
        this.fdl.setSelection(this.fdl.getText().toString().length());
        this.fdm.setSelection(this.fdm.getText().toString().length());
    }

    private void bnC() {
        this.fdl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bnD()) {
                    b.this.jq(true);
                }
            }
        });
        this.fdm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.c.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.fdm.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.fdm.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.fdo.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.awP), Integer.valueOf(b.this.awQ)));
                    b.this.fdo.setVisibility(0);
                    b.this.fdM = 0L;
                    b.this.fdQ = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.fdm.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.fdM = parseLong;
                    if (parseLong >= b.this.awP && parseLong <= b.this.awQ) {
                        b.this.fdo.setVisibility(8);
                        b.this.fdQ = true;
                    } else {
                        b.this.fdo.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.awP), Integer.valueOf(b.this.awQ)));
                        b.this.fdo.setVisibility(0);
                        b.this.fdQ = false;
                    }
                }
                b.this.fdm.setSelection(b.this.fdm.getText().toString().length());
                TextView textView = b.this.fdw;
                if (!b.this.fdP || !b.this.fdQ) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bnD();
                b.this.jq(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnD() {
        boolean z = true;
        String obj = this.fdl.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.fdl.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.fdn.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fdG), Long.valueOf(this.fdH)));
            this.fdn.setVisibility(0);
            this.fdL = 0L;
            this.fdP = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.fdl.setText(String.valueOf(parseLong));
                return true;
            }
            this.fdL = parseLong;
            if (parseLong < this.fdG || parseLong > this.fdH) {
                if (parseLong == 0) {
                    this.fdl.setText("0");
                }
                this.fdn.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.fdG), Long.valueOf(this.fdH)));
                this.fdn.setVisibility(0);
                this.fdP = false;
            } else {
                this.fdn.setVisibility(8);
                this.fdP = true;
            }
        }
        this.fdl.setSelection(this.fdl.getText().toString().length());
        TextView textView = this.fdw;
        if (!this.fdP || !this.fdQ) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(boolean z) {
        if (this.fdQ && this.fdP && this.fdM != 0 && this.fdL / this.fdM < this.fdJ) {
            this.fdn.setVisibility(0);
            if (z) {
                this.fdn.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.fdM * 100)));
            } else {
                this.fdn.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.fdL / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.fdC.getVisibility() == 0) {
            this.fdC.setVisibility(8);
            return;
        }
        if (view == this.fdF && !this.fdZ) {
            this.activity.finish();
        } else if (view == this.fdi && !this.fdZ) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.fdj) {
            this.fdC.setVisibility(0);
        } else if (view == this.fdq) {
            this.fdR = this.fdR ? false : true;
            if (this.fdR) {
                this.fdu.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fdu.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fdr) {
            this.fdS = this.fdS ? false : true;
            if (this.fdS) {
                this.fdv.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.fdv.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.fdw) {
            if (this.fdR && this.fdS) {
                str = this.fdN + Constants.ACCEPT_TIME_SEPARATOR_SP + this.fdO;
            } else if (this.fdR) {
                str = this.fdN;
            } else if (this.fdS) {
                str = this.fdO;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.ds(this.fdL);
            oVar.dt(this.fdM);
            oVar.zQ(str);
            if (this.fdV != null) {
                this.fdV.a(oVar);
            }
        }
        if (this.fdZ && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void jr(boolean z) {
        if (this.fdw != null) {
            this.fdw.setEnabled(z);
        }
    }

    public View getView() {
        return this.fdi;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fdZ = z;
        if (!z) {
            if (this.fdm != null) {
                this.fdm.clearFocus();
            }
            if (this.fdl != null) {
                this.fdl.clearFocus();
            }
        }
        if (this.fdA != null && this.fdA.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdA.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.fdT;
                }
            } else {
                layoutParams.topMargin = this.fdU;
            }
            this.fdA.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fdF.setVisibility(0);
        } else {
            this.fdF.setVisibility(8);
        }
    }

    public void xy() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.U(this.fdi);
        } else {
            h.V(this.fdi);
        }
        if (this.fdE != null && this.fdE.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fdE.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.fdX;
            } else {
                layoutParams.height = -2;
            }
            this.fdE.setLayoutParams(layoutParams);
        }
        if (this.fdA != null && this.fdA.getLayoutParams() != null && this.fdW > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fdA.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.fdA.setPivotX(this.fdW / 2);
            this.fdA.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fdA.setScaleX(this.fdY);
                this.fdA.setScaleY(this.fdY);
            } else {
                layoutParams2.width = -1;
                this.fdA.setScaleX(1.0f);
                this.fdA.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.fdZ);
        }
    }
}
