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
    private int aep;
    private int aeq;
    private int aes;
    private int cdw;
    private LinearLayout eyA;
    private LinearLayout eyB;
    private TextView eyC;
    private TextView eyD;
    private ImageView eyE;
    private ImageView eyF;
    private TextView eyG;
    private TextView eyH;
    private TextView eyI;
    private TextView eyJ;
    private RelativeLayout eyK;
    private RelativeLayout eyL;
    private LinearLayout eyM;
    private LinearLayout eyN;
    private ScrollView eyO;
    private View eyP;
    private long eyR;
    private int eyS;
    private int eyT;
    private List<bc.a> eyU;
    private String eyX;
    private String eyY;
    private View eys;
    private View eyt;
    private TextView eyu;
    private EditText eyv;
    private EditText eyw;
    private TextView eyx;
    private TextView eyy;
    private LinearLayout eyz;
    private boolean ezb;
    private boolean ezc;
    private int ezd;
    private int eze;
    private a ezf;
    private int ezg;
    private int ezh;
    private float ezi;
    private boolean ezj;
    private int screenWidth;
    private int eyQ = 2000;
    private long eyV = 2000;
    private long eyW = 10;
    private boolean eyZ = true;
    private boolean eza = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.ezf = aVar;
        initView();
        beg();
        beh();
        this.eyK.setVisibility(4);
        this.eyK.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cdw = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cdw) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cdw;
                    b.this.cdw = i;
                }
                b.this.ezg = b.this.screenWidth;
                b.this.eze = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.ezh = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.eze * 2);
                b.this.ezi = (i2 * 1.0f) / b.this.eyK.getHeight();
                if (b.this.cdw > b.this.eyK.getHeight()) {
                    b.this.ezd = (b.this.cdw - b.this.eyK.getHeight()) / 2;
                }
                b.this.ta();
                b.this.eyK.setVisibility(0);
            }
        });
    }

    private void beg() {
        bc.a aVar;
        bc.a aVar2;
        if (com.baidu.live.v.a.zl() != null && com.baidu.live.v.a.zl().axD != null && com.baidu.live.v.a.zl().axD.acS != null && com.baidu.live.v.a.zl().axD.acS.adR != null) {
            bc bcVar = com.baidu.live.v.a.zl().axD.acS.adR;
            this.eyR = bcVar.aen;
            this.aep = bcVar.aep;
            this.aeq = bcVar.aeq;
            this.eyS = bcVar.aer;
            this.eyT = bcVar.aeo;
            this.aes = bcVar.aes;
            this.eyU = bcVar.aet;
        }
        this.eyu.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.eyS)));
        this.eyH.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aes)));
        this.eyI.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aes)));
        this.eyJ.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.eyT)));
        if (this.eyU != null && !this.eyU.isEmpty()) {
            if (this.eyU.size() == 1) {
                aVar = this.eyU.get(0);
                aVar2 = null;
            } else {
                aVar = this.eyU.get(0);
                aVar2 = this.eyU.get(1);
            }
            if (aVar == null) {
                this.eyA.setVisibility(8);
            } else {
                this.eyC.setText(aVar.aeu);
                this.eyA.setVisibility(0);
                this.eyX = aVar.aev;
            }
            if (aVar2 == null) {
                this.eyB.setVisibility(8);
            } else {
                this.eyD.setText(aVar2.aeu);
                this.eyB.setVisibility(0);
                this.eyY = aVar2.aev;
            }
            if (this.eyA.getVisibility() == 0 || this.eyB.getVisibility() == 0) {
                this.eyz.setVisibility(0);
                return;
            } else {
                this.eyz.setVisibility(8);
                return;
            }
        }
        this.eyz.setVisibility(8);
    }

    private void initView() {
        this.eys = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.eyt = this.eys.findViewById(a.g.iv_send_red_q);
        this.eyu = (TextView) this.eys.findViewById(a.g.tv_red_broad_hint);
        this.eyv = (EditText) this.eys.findViewById(a.g.edt_t_num);
        this.eyw = (EditText) this.eys.findViewById(a.g.edt_pkt_num);
        this.eyx = (TextView) this.eys.findViewById(a.g.tv_send_t_num_hint);
        this.eyy = (TextView) this.eys.findViewById(a.g.tv_send_pkt_num_hint);
        this.eyz = (LinearLayout) this.eys.findViewById(a.g.layout_red_pkt_condition);
        this.eyA = (LinearLayout) this.eys.findViewById(a.g.layout_condition_first);
        this.eyB = (LinearLayout) this.eys.findViewById(a.g.layout_condition_second);
        this.eyK = (RelativeLayout) this.eys.findViewById(a.g.layout_send_red_content);
        this.eyL = (RelativeLayout) this.eys.findViewById(a.g.layout_send_red);
        this.eyC = (TextView) this.eys.findViewById(a.g.tv_condition_first);
        this.eyD = (TextView) this.eys.findViewById(a.g.tv_condition_second);
        this.eyE = (ImageView) this.eys.findViewById(a.g.iv_condition_first);
        this.eyF = (ImageView) this.eys.findViewById(a.g.iv_condition_second);
        this.eyG = (TextView) this.eys.findViewById(a.g.tv_send_pkt_submit);
        this.eyI = (TextView) this.eys.findViewById(a.g.tv_red_send_rule1);
        this.eyJ = (TextView) this.eys.findViewById(a.g.tv_red_send_rule3);
        this.eyH = (TextView) this.eys.findViewById(a.g.tv_send_pkt_time);
        this.eyM = (LinearLayout) this.eys.findViewById(a.g.layout_red_send_rule);
        this.eyN = (LinearLayout) this.eys.findViewById(a.g.layout_red_send_rule_content);
        this.eyO = (ScrollView) this.eys.findViewById(a.g.layout_input_scroll);
        this.eyP = this.eys.findViewById(a.g.layout_send_red_close);
        this.eys.setOnClickListener(this);
        this.eyA.setOnClickListener(this);
        this.eyB.setOnClickListener(this);
        this.eyG.setOnClickListener(this);
        this.eyt.setOnClickListener(this);
        this.eyM.setOnClickListener(this);
        this.eyN.setOnClickListener(this);
        this.eyL.setOnClickListener(this);
        this.eyP.setOnClickListener(this);
        ((ImageView) this.eys.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.eyv.setText(String.valueOf(this.eyV));
        this.eyw.setText(String.valueOf(this.eyW));
        this.eyv.setSelection(this.eyv.getText().toString().length());
        this.eyw.setSelection(this.eyw.getText().toString().length());
    }

    private void beh() {
        this.eyv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bei()) {
                    b.this.in(true);
                }
            }
        });
        this.eyw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.eyw.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.eyw.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.eyy.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                    b.this.eyy.setVisibility(0);
                    b.this.eyW = 0L;
                    b.this.eza = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.eyw.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.eyW = parseLong;
                    if (parseLong >= b.this.aep && parseLong <= b.this.aeq) {
                        b.this.eyy.setVisibility(8);
                        b.this.eza = true;
                    } else {
                        b.this.eyy.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                        b.this.eyy.setVisibility(0);
                        b.this.eza = false;
                    }
                }
                b.this.eyw.setSelection(b.this.eyw.getText().toString().length());
                TextView textView = b.this.eyG;
                if (!b.this.eyZ || !b.this.eza) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bei();
                b.this.in(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bei() {
        boolean z = true;
        String obj = this.eyv.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.eyv.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.eyx.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyQ), Long.valueOf(this.eyR)));
            this.eyx.setVisibility(0);
            this.eyV = 0L;
            this.eyZ = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.eyv.setText(String.valueOf(parseLong));
                return true;
            }
            this.eyV = parseLong;
            if (parseLong < this.eyQ || parseLong > this.eyR) {
                if (parseLong == 0) {
                    this.eyv.setText("0");
                }
                this.eyx.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyQ), Long.valueOf(this.eyR)));
                this.eyx.setVisibility(0);
                this.eyZ = false;
            } else {
                this.eyx.setVisibility(8);
                this.eyZ = true;
            }
        }
        this.eyv.setSelection(this.eyv.getText().toString().length());
        TextView textView = this.eyG;
        if (!this.eyZ || !this.eza) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (this.eza && this.eyZ && this.eyW != 0 && this.eyV / this.eyW < this.eyT) {
            this.eyx.setVisibility(0);
            if (z) {
                this.eyx.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.eyW * 100)));
            } else {
                this.eyx.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.eyV / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.eyM.getVisibility() == 0) {
            this.eyM.setVisibility(8);
            return;
        }
        if (view == this.eyP && !this.ezj) {
            this.activity.finish();
        } else if (view == this.eys && !this.ezj) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.eyt) {
            this.eyM.setVisibility(0);
        } else if (view == this.eyA) {
            this.ezb = this.ezb ? false : true;
            if (this.ezb) {
                this.eyE.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eyE.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyB) {
            this.ezc = this.ezc ? false : true;
            if (this.ezc) {
                this.eyF.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eyF.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyG) {
            if (this.ezb && this.ezc) {
                str = this.eyX + Constants.ACCEPT_TIME_SEPARATOR_SP + this.eyY;
            } else if (this.ezb) {
                str = this.eyX;
            } else if (this.ezc) {
                str = this.eyY;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cK(this.eyV);
            oVar.cL(this.eyW);
            oVar.yh(str);
            if (this.ezf != null) {
                this.ezf.a(oVar);
            }
        }
        if (this.ezj && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void io(boolean z) {
        if (this.eyG != null) {
            this.eyG.setEnabled(z);
        }
    }

    public View getView() {
        return this.eys;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ezj = z;
        if (!z) {
            if (this.eyw != null) {
                this.eyw.clearFocus();
            }
            if (this.eyv != null) {
                this.eyv.clearFocus();
            }
        }
        if (this.eyK != null && this.eyK.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyK.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.ezd;
                }
            } else {
                layoutParams.topMargin = this.eze;
            }
            this.eyK.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eyP.setVisibility(0);
        } else {
            this.eyP.setVisibility(8);
        }
    }

    public void ta() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.S(this.eys);
        } else {
            h.T(this.eys);
        }
        if (this.eyO != null && this.eyO.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyO.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.ezh;
            } else {
                layoutParams.height = -2;
            }
            this.eyO.setLayoutParams(layoutParams);
        }
        if (this.eyK != null && this.eyK.getLayoutParams() != null && this.ezg > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eyK.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.eyK.setPivotX(this.ezg / 2);
            this.eyK.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eyK.setScaleX(this.ezi);
                this.eyK.setScaleY(this.ezi);
            } else {
                layoutParams2.width = -1;
                this.eyK.setScaleX(1.0f);
                this.eyK.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.ezj);
        }
    }
}
