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
    private int cdv;
    private LinearLayout eyA;
    private ScrollView eyB;
    private View eyC;
    private long eyE;
    private int eyF;
    private int eyG;
    private List<bc.a> eyH;
    private String eyK;
    private String eyL;
    private boolean eyO;
    private boolean eyP;
    private int eyQ;
    private int eyR;
    private a eyS;
    private int eyT;
    private int eyU;
    private float eyV;
    private boolean eyW;
    private View eyd;
    private View eyf;
    private TextView eyg;
    private EditText eyh;
    private EditText eyi;
    private TextView eyj;
    private TextView eyk;
    private LinearLayout eyl;
    private LinearLayout eyn;
    private LinearLayout eyo;
    private TextView eyp;
    private TextView eyq;
    private ImageView eyr;
    private ImageView eys;
    private TextView eyt;
    private TextView eyu;
    private TextView eyv;
    private TextView eyw;
    private RelativeLayout eyx;
    private RelativeLayout eyy;
    private LinearLayout eyz;
    private int screenWidth;
    private int eyD = 2000;
    private long eyI = 2000;
    private long eyJ = 10;
    private boolean eyM = true;
    private boolean eyN = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.eyS = aVar;
        initView();
        bef();
        beg();
        this.eyx.setVisibility(4);
        this.eyx.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cdv = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cdv) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cdv;
                    b.this.cdv = i;
                }
                b.this.eyT = b.this.screenWidth;
                b.this.eyR = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.eyU = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.eyR * 2);
                b.this.eyV = (i2 * 1.0f) / b.this.eyx.getHeight();
                if (b.this.cdv > b.this.eyx.getHeight()) {
                    b.this.eyQ = (b.this.cdv - b.this.eyx.getHeight()) / 2;
                }
                b.this.ta();
                b.this.eyx.setVisibility(0);
            }
        });
    }

    private void bef() {
        bc.a aVar;
        bc.a aVar2;
        if (com.baidu.live.v.a.zl() != null && com.baidu.live.v.a.zl().axC != null && com.baidu.live.v.a.zl().axC.acS != null && com.baidu.live.v.a.zl().axC.acS.adR != null) {
            bc bcVar = com.baidu.live.v.a.zl().axC.acS.adR;
            this.eyE = bcVar.aen;
            this.aep = bcVar.aep;
            this.aeq = bcVar.aeq;
            this.eyF = bcVar.aer;
            this.eyG = bcVar.aeo;
            this.aes = bcVar.aes;
            this.eyH = bcVar.aet;
        }
        this.eyg.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.eyF)));
        this.eyu.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aes)));
        this.eyv.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aes)));
        this.eyw.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.eyG)));
        if (this.eyH != null && !this.eyH.isEmpty()) {
            if (this.eyH.size() == 1) {
                aVar = this.eyH.get(0);
                aVar2 = null;
            } else {
                aVar = this.eyH.get(0);
                aVar2 = this.eyH.get(1);
            }
            if (aVar == null) {
                this.eyn.setVisibility(8);
            } else {
                this.eyp.setText(aVar.aeu);
                this.eyn.setVisibility(0);
                this.eyK = aVar.aev;
            }
            if (aVar2 == null) {
                this.eyo.setVisibility(8);
            } else {
                this.eyq.setText(aVar2.aeu);
                this.eyo.setVisibility(0);
                this.eyL = aVar2.aev;
            }
            if (this.eyn.getVisibility() == 0 || this.eyo.getVisibility() == 0) {
                this.eyl.setVisibility(0);
                return;
            } else {
                this.eyl.setVisibility(8);
                return;
            }
        }
        this.eyl.setVisibility(8);
    }

    private void initView() {
        this.eyd = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.eyf = this.eyd.findViewById(a.g.iv_send_red_q);
        this.eyg = (TextView) this.eyd.findViewById(a.g.tv_red_broad_hint);
        this.eyh = (EditText) this.eyd.findViewById(a.g.edt_t_num);
        this.eyi = (EditText) this.eyd.findViewById(a.g.edt_pkt_num);
        this.eyj = (TextView) this.eyd.findViewById(a.g.tv_send_t_num_hint);
        this.eyk = (TextView) this.eyd.findViewById(a.g.tv_send_pkt_num_hint);
        this.eyl = (LinearLayout) this.eyd.findViewById(a.g.layout_red_pkt_condition);
        this.eyn = (LinearLayout) this.eyd.findViewById(a.g.layout_condition_first);
        this.eyo = (LinearLayout) this.eyd.findViewById(a.g.layout_condition_second);
        this.eyx = (RelativeLayout) this.eyd.findViewById(a.g.layout_send_red_content);
        this.eyy = (RelativeLayout) this.eyd.findViewById(a.g.layout_send_red);
        this.eyp = (TextView) this.eyd.findViewById(a.g.tv_condition_first);
        this.eyq = (TextView) this.eyd.findViewById(a.g.tv_condition_second);
        this.eyr = (ImageView) this.eyd.findViewById(a.g.iv_condition_first);
        this.eys = (ImageView) this.eyd.findViewById(a.g.iv_condition_second);
        this.eyt = (TextView) this.eyd.findViewById(a.g.tv_send_pkt_submit);
        this.eyv = (TextView) this.eyd.findViewById(a.g.tv_red_send_rule1);
        this.eyw = (TextView) this.eyd.findViewById(a.g.tv_red_send_rule3);
        this.eyu = (TextView) this.eyd.findViewById(a.g.tv_send_pkt_time);
        this.eyz = (LinearLayout) this.eyd.findViewById(a.g.layout_red_send_rule);
        this.eyA = (LinearLayout) this.eyd.findViewById(a.g.layout_red_send_rule_content);
        this.eyB = (ScrollView) this.eyd.findViewById(a.g.layout_input_scroll);
        this.eyC = this.eyd.findViewById(a.g.layout_send_red_close);
        this.eyd.setOnClickListener(this);
        this.eyn.setOnClickListener(this);
        this.eyo.setOnClickListener(this);
        this.eyt.setOnClickListener(this);
        this.eyf.setOnClickListener(this);
        this.eyz.setOnClickListener(this);
        this.eyA.setOnClickListener(this);
        this.eyy.setOnClickListener(this);
        this.eyC.setOnClickListener(this);
        ((ImageView) this.eyd.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.eyh.setText(String.valueOf(this.eyI));
        this.eyi.setText(String.valueOf(this.eyJ));
        this.eyh.setSelection(this.eyh.getText().toString().length());
        this.eyi.setSelection(this.eyi.getText().toString().length());
    }

    private void beg() {
        this.eyh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.beh()) {
                    b.this.in(true);
                }
            }
        });
        this.eyi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.eyi.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.eyi.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.eyk.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                    b.this.eyk.setVisibility(0);
                    b.this.eyJ = 0L;
                    b.this.eyN = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.eyi.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.eyJ = parseLong;
                    if (parseLong >= b.this.aep && parseLong <= b.this.aeq) {
                        b.this.eyk.setVisibility(8);
                        b.this.eyN = true;
                    } else {
                        b.this.eyk.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                        b.this.eyk.setVisibility(0);
                        b.this.eyN = false;
                    }
                }
                b.this.eyi.setSelection(b.this.eyi.getText().toString().length());
                TextView textView = b.this.eyt;
                if (!b.this.eyM || !b.this.eyN) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.beh();
                b.this.in(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beh() {
        boolean z = true;
        String obj = this.eyh.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.eyh.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.eyj.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyD), Long.valueOf(this.eyE)));
            this.eyj.setVisibility(0);
            this.eyI = 0L;
            this.eyM = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.eyh.setText(String.valueOf(parseLong));
                return true;
            }
            this.eyI = parseLong;
            if (parseLong < this.eyD || parseLong > this.eyE) {
                if (parseLong == 0) {
                    this.eyh.setText("0");
                }
                this.eyj.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyD), Long.valueOf(this.eyE)));
                this.eyj.setVisibility(0);
                this.eyM = false;
            } else {
                this.eyj.setVisibility(8);
                this.eyM = true;
            }
        }
        this.eyh.setSelection(this.eyh.getText().toString().length());
        TextView textView = this.eyt;
        if (!this.eyM || !this.eyN) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (this.eyN && this.eyM && this.eyJ != 0 && this.eyI / this.eyJ < this.eyG) {
            this.eyj.setVisibility(0);
            if (z) {
                this.eyj.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.eyJ * 100)));
            } else {
                this.eyj.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.eyI / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.eyz.getVisibility() == 0) {
            this.eyz.setVisibility(8);
            return;
        }
        if (view == this.eyC && !this.eyW) {
            this.activity.finish();
        } else if (view == this.eyd && !this.eyW) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.eyf) {
            this.eyz.setVisibility(0);
        } else if (view == this.eyn) {
            this.eyO = this.eyO ? false : true;
            if (this.eyO) {
                this.eyr.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eyr.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyo) {
            this.eyP = this.eyP ? false : true;
            if (this.eyP) {
                this.eys.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eys.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyt) {
            if (this.eyO && this.eyP) {
                str = this.eyK + Constants.ACCEPT_TIME_SEPARATOR_SP + this.eyL;
            } else if (this.eyO) {
                str = this.eyK;
            } else if (this.eyP) {
                str = this.eyL;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cK(this.eyI);
            oVar.cL(this.eyJ);
            oVar.yg(str);
            if (this.eyS != null) {
                this.eyS.a(oVar);
            }
        }
        if (this.eyW && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void io(boolean z) {
        if (this.eyt != null) {
            this.eyt.setEnabled(z);
        }
    }

    public View getView() {
        return this.eyd;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.eyW = z;
        if (!z) {
            if (this.eyi != null) {
                this.eyi.clearFocus();
            }
            if (this.eyh != null) {
                this.eyh.clearFocus();
            }
        }
        if (this.eyx != null && this.eyx.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyx.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.eyQ;
                }
            } else {
                layoutParams.topMargin = this.eyR;
            }
            this.eyx.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eyC.setVisibility(0);
        } else {
            this.eyC.setVisibility(8);
        }
    }

    public void ta() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.S(this.eyd);
        } else {
            h.T(this.eyd);
        }
        if (this.eyB != null && this.eyB.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyB.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.eyU;
            } else {
                layoutParams.height = -2;
            }
            this.eyB.setLayoutParams(layoutParams);
        }
        if (this.eyx != null && this.eyx.getLayoutParams() != null && this.eyT > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eyx.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.eyx.setPivotX(this.eyT / 2);
            this.eyx.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eyx.setScaleX(this.eyV);
                this.eyx.setScaleY(this.eyV);
            } else {
                layoutParams2.width = -1;
                this.eyx.setScaleX(1.0f);
                this.eyx.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.eyW);
        }
    }
}
