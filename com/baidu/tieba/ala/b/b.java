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
    private int cdu;
    private ScrollView eyA;
    private View eyB;
    private long eyD;
    private int eyE;
    private int eyF;
    private List<bc.a> eyG;
    private String eyJ;
    private String eyK;
    private boolean eyN;
    private boolean eyO;
    private int eyP;
    private int eyQ;
    private a eyR;
    private int eyS;
    private int eyT;
    private float eyU;
    private boolean eyV;
    private View eyc;
    private View eyd;
    private TextView eyf;
    private EditText eyg;
    private EditText eyh;
    private TextView eyi;
    private TextView eyj;
    private LinearLayout eyk;
    private LinearLayout eyl;
    private LinearLayout eyn;
    private TextView eyo;
    private TextView eyp;
    private ImageView eyq;
    private ImageView eyr;
    private TextView eys;
    private TextView eyt;
    private TextView eyu;
    private TextView eyv;
    private RelativeLayout eyw;
    private RelativeLayout eyx;
    private LinearLayout eyy;
    private LinearLayout eyz;
    private int screenWidth;
    private int eyC = 2000;
    private long eyH = 2000;
    private long eyI = 10;
    private boolean eyL = true;
    private boolean eyM = true;

    public b(final Activity activity, a aVar) {
        this.activity = activity;
        this.eyR = aVar;
        initView();
        bed();
        bee();
        this.eyw.setVisibility(4);
        this.eyw.post(new Runnable() { // from class: com.baidu.tieba.ala.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                b.this.cdu = ScreenHelper.getScreenHeight(activity);
                if (b.this.screenWidth > b.this.cdu) {
                    int i = b.this.screenWidth;
                    b.this.screenWidth = b.this.cdu;
                    b.this.cdu = i;
                }
                b.this.eyS = b.this.screenWidth;
                b.this.eyQ = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                b.this.eyT = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = b.this.screenWidth - (b.this.eyQ * 2);
                b.this.eyU = (i2 * 1.0f) / b.this.eyw.getHeight();
                if (b.this.cdu > b.this.eyw.getHeight()) {
                    b.this.eyP = (b.this.cdu - b.this.eyw.getHeight()) / 2;
                }
                b.this.ta();
                b.this.eyw.setVisibility(0);
            }
        });
    }

    private void bed() {
        bc.a aVar;
        bc.a aVar2;
        if (com.baidu.live.v.a.zj() != null && com.baidu.live.v.a.zj().axB != null && com.baidu.live.v.a.zj().axB.acS != null && com.baidu.live.v.a.zj().axB.acS.adR != null) {
            bc bcVar = com.baidu.live.v.a.zj().axB.acS.adR;
            this.eyD = bcVar.aen;
            this.aep = bcVar.aep;
            this.aeq = bcVar.aeq;
            this.eyE = bcVar.aer;
            this.eyF = bcVar.aeo;
            this.aes = bcVar.aes;
            this.eyG = bcVar.aet;
        }
        this.eyf.setText(String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.eyE)));
        this.eyt.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aes)));
        this.eyu.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aes)));
        this.eyv.setText(String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.eyF)));
        if (this.eyG != null && !this.eyG.isEmpty()) {
            if (this.eyG.size() == 1) {
                aVar = this.eyG.get(0);
                aVar2 = null;
            } else {
                aVar = this.eyG.get(0);
                aVar2 = this.eyG.get(1);
            }
            if (aVar == null) {
                this.eyl.setVisibility(8);
            } else {
                this.eyo.setText(aVar.aeu);
                this.eyl.setVisibility(0);
                this.eyJ = aVar.aev;
            }
            if (aVar2 == null) {
                this.eyn.setVisibility(8);
            } else {
                this.eyp.setText(aVar2.aeu);
                this.eyn.setVisibility(0);
                this.eyK = aVar2.aev;
            }
            if (this.eyl.getVisibility() == 0 || this.eyn.getVisibility() == 0) {
                this.eyk.setVisibility(0);
                return;
            } else {
                this.eyk.setVisibility(8);
                return;
            }
        }
        this.eyk.setVisibility(8);
    }

    private void initView() {
        this.eyc = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.eyd = this.eyc.findViewById(a.g.iv_send_red_q);
        this.eyf = (TextView) this.eyc.findViewById(a.g.tv_red_broad_hint);
        this.eyg = (EditText) this.eyc.findViewById(a.g.edt_t_num);
        this.eyh = (EditText) this.eyc.findViewById(a.g.edt_pkt_num);
        this.eyi = (TextView) this.eyc.findViewById(a.g.tv_send_t_num_hint);
        this.eyj = (TextView) this.eyc.findViewById(a.g.tv_send_pkt_num_hint);
        this.eyk = (LinearLayout) this.eyc.findViewById(a.g.layout_red_pkt_condition);
        this.eyl = (LinearLayout) this.eyc.findViewById(a.g.layout_condition_first);
        this.eyn = (LinearLayout) this.eyc.findViewById(a.g.layout_condition_second);
        this.eyw = (RelativeLayout) this.eyc.findViewById(a.g.layout_send_red_content);
        this.eyx = (RelativeLayout) this.eyc.findViewById(a.g.layout_send_red);
        this.eyo = (TextView) this.eyc.findViewById(a.g.tv_condition_first);
        this.eyp = (TextView) this.eyc.findViewById(a.g.tv_condition_second);
        this.eyq = (ImageView) this.eyc.findViewById(a.g.iv_condition_first);
        this.eyr = (ImageView) this.eyc.findViewById(a.g.iv_condition_second);
        this.eys = (TextView) this.eyc.findViewById(a.g.tv_send_pkt_submit);
        this.eyu = (TextView) this.eyc.findViewById(a.g.tv_red_send_rule1);
        this.eyv = (TextView) this.eyc.findViewById(a.g.tv_red_send_rule3);
        this.eyt = (TextView) this.eyc.findViewById(a.g.tv_send_pkt_time);
        this.eyy = (LinearLayout) this.eyc.findViewById(a.g.layout_red_send_rule);
        this.eyz = (LinearLayout) this.eyc.findViewById(a.g.layout_red_send_rule_content);
        this.eyA = (ScrollView) this.eyc.findViewById(a.g.layout_input_scroll);
        this.eyB = this.eyc.findViewById(a.g.layout_send_red_close);
        this.eyc.setOnClickListener(this);
        this.eyl.setOnClickListener(this);
        this.eyn.setOnClickListener(this);
        this.eys.setOnClickListener(this);
        this.eyd.setOnClickListener(this);
        this.eyy.setOnClickListener(this);
        this.eyz.setOnClickListener(this);
        this.eyx.setOnClickListener(this);
        this.eyB.setOnClickListener(this);
        ((ImageView) this.eyc.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
        this.eyg.setText(String.valueOf(this.eyH));
        this.eyh.setText(String.valueOf(this.eyI));
        this.eyg.setSelection(this.eyg.getText().toString().length());
        this.eyh.setSelection(this.eyh.getText().toString().length());
    }

    private void bee() {
        this.eyg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!b.this.bef()) {
                    b.this.in(true);
                }
            }
        });
        this.eyh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.b.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = b.this.eyh.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    b.this.eyh.setText("0");
                    return;
                }
                if ("0".equals(obj)) {
                    b.this.eyj.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                    b.this.eyj.setVisibility(0);
                    b.this.eyI = 0L;
                    b.this.eyM = false;
                } else {
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        b.this.eyh.setText(String.valueOf(parseLong));
                        return;
                    }
                    b.this.eyI = parseLong;
                    if (parseLong >= b.this.aep && parseLong <= b.this.aeq) {
                        b.this.eyj.setVisibility(8);
                        b.this.eyM = true;
                    } else {
                        b.this.eyj.setText(String.format(b.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(b.this.aep), Integer.valueOf(b.this.aeq)));
                        b.this.eyj.setVisibility(0);
                        b.this.eyM = false;
                    }
                }
                b.this.eyh.setSelection(b.this.eyh.getText().toString().length());
                TextView textView = b.this.eys;
                if (!b.this.eyL || !b.this.eyM) {
                    z = false;
                }
                textView.setEnabled(z);
                b.this.bef();
                b.this.in(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bef() {
        boolean z = true;
        String obj = this.eyg.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.eyg.setText("0");
            return true;
        }
        if ("0".equals(obj)) {
            this.eyi.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyC), Long.valueOf(this.eyD)));
            this.eyi.setVisibility(0);
            this.eyH = 0L;
            this.eyL = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.eyg.setText(String.valueOf(parseLong));
                return true;
            }
            this.eyH = parseLong;
            if (parseLong < this.eyC || parseLong > this.eyD) {
                if (parseLong == 0) {
                    this.eyg.setText("0");
                }
                this.eyi.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.eyC), Long.valueOf(this.eyD)));
                this.eyi.setVisibility(0);
                this.eyL = false;
            } else {
                this.eyi.setVisibility(8);
                this.eyL = true;
            }
        }
        this.eyg.setSelection(this.eyg.getText().toString().length());
        TextView textView = this.eys;
        if (!this.eyL || !this.eyM) {
            z = false;
        }
        textView.setEnabled(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (this.eyM && this.eyL && this.eyI != 0 && this.eyH / this.eyI < this.eyF) {
            this.eyi.setVisibility(0);
            if (z) {
                this.eyi.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.eyI * 100)));
            } else {
                this.eyi.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.eyH / 100)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.eyy.getVisibility() == 0) {
            this.eyy.setVisibility(8);
            return;
        }
        if (view == this.eyB && !this.eyV) {
            this.activity.finish();
        } else if (view == this.eyc && !this.eyV) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.eyd) {
            this.eyy.setVisibility(0);
        } else if (view == this.eyl) {
            this.eyN = this.eyN ? false : true;
            if (this.eyN) {
                this.eyq.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eyq.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eyn) {
            this.eyO = this.eyO ? false : true;
            if (this.eyO) {
                this.eyr.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.eyr.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.eys) {
            if (this.eyN && this.eyO) {
                str = this.eyJ + Constants.ACCEPT_TIME_SEPARATOR_SP + this.eyK;
            } else if (this.eyN) {
                str = this.eyJ;
            } else if (this.eyO) {
                str = this.eyK;
            } else {
                str = "";
            }
            o oVar = new o();
            oVar.cK(this.eyH);
            oVar.cL(this.eyI);
            oVar.yg(str);
            if (this.eyR != null) {
                this.eyR.a(oVar);
            }
        }
        if (this.eyV && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void io(boolean z) {
        if (this.eys != null) {
            this.eys.setEnabled(z);
        }
    }

    public View getView() {
        return this.eyc;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.eyV = z;
        if (!z) {
            if (this.eyh != null) {
                this.eyh.clearFocus();
            }
            if (this.eyg != null) {
                this.eyg.clearFocus();
            }
        }
        if (this.eyw != null && this.eyw.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyw.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.eyP;
                }
            } else {
                layoutParams.topMargin = this.eyQ;
            }
            this.eyw.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eyB.setVisibility(0);
        } else {
            this.eyB.setVisibility(8);
        }
    }

    public void ta() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            h.S(this.eyc);
        } else {
            h.T(this.eyc);
        }
        if (this.eyA != null && this.eyA.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyA.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.eyT;
            } else {
                layoutParams.height = -2;
            }
            this.eyA.setLayoutParams(layoutParams);
        }
        if (this.eyw != null && this.eyw.getLayoutParams() != null && this.eyS > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eyw.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.eyw.setPivotX(this.eyS / 2);
            this.eyw.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eyw.setScaleX(this.eyU);
                this.eyw.setScaleY(this.eyU);
            } else {
                layoutParams2.width = -1;
                this.eyw.setScaleX(1.0f);
                this.eyw.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.eyV);
        }
    }
}
