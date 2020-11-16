package com.baidu.tieba.ala.d;

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
import com.baidu.live.data.ch;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.s;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    private int aPO;
    private int aPP;
    private int aPR;
    private long aPW;
    private int aPX;
    private Activity activity;
    private int dHY;
    private int gyA;
    private List<ch.a> gyB;
    private long gyD;
    private String gyE;
    private String gyF;
    private boolean gyI;
    private boolean gyJ;
    private int gyK;
    private int gyL;
    private d gyM;
    private int gyN;
    private int gyO;
    private float gyP;
    private boolean gyQ;
    private int gyS;
    private boolean gyT;
    private View gyc;
    private View gyd;
    private TextView gye;
    private EditText gyf;
    private EditText gyg;
    private TextView gyh;
    private TextView gyi;
    private LinearLayout gyj;
    private LinearLayout gyk;
    private LinearLayout gyl;
    private TextView gym;
    private TextView gyn;
    private ImageView gyo;
    private ImageView gyp;
    private TextView gyq;
    private TextView gyr;
    private RelativeLayout gys;
    private LinearLayout gyt;
    private LinearLayout gyu;
    private ScrollView gyv;
    private View gyw;
    private long gyy;
    private int gyz;
    private int screenWidth;
    private int gyx = 2000;
    private long gyC = 2000;
    private boolean gyG = true;
    private boolean gyH = true;
    private int gyR = 10;

    public e(final Activity activity, d dVar) {
        this.activity = activity;
        this.gyM = dVar;
        initView();
        initData();
        bQU();
        bQV();
        this.gys.setVisibility(4);
        this.gys.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                e.this.dHY = ScreenHelper.getScreenHeight(activity);
                if (e.this.screenWidth > e.this.dHY) {
                    int i = e.this.screenWidth;
                    e.this.screenWidth = e.this.dHY;
                    e.this.dHY = i;
                }
                e.this.gyN = e.this.screenWidth;
                e.this.gyL = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds40);
                e.this.gyO = activity.getResources().getDimensionPixelOffset(a.d.sdk_ds204);
                int i2 = e.this.screenWidth - (e.this.gyL * 2);
                e.this.gyP = (i2 * 1.0f) / e.this.gys.getHeight();
                if (e.this.dHY > e.this.gys.getHeight()) {
                    e.this.gyK = (e.this.dHY - e.this.gys.getHeight()) / 2;
                }
                e.this.Ha();
                e.this.gys.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.gyc = LayoutInflater.from(this.activity).inflate(a.g.ala_red_pkt_send_layout, (ViewGroup) null);
        this.gyd = this.gyc.findViewById(a.f.iv_send_red_q);
        this.gye = (TextView) this.gyc.findViewById(a.f.tv_red_broad_hint);
        this.gyf = (EditText) this.gyc.findViewById(a.f.edt_t_num);
        this.gyg = (EditText) this.gyc.findViewById(a.f.edt_pkt_num);
        this.gyh = (TextView) this.gyc.findViewById(a.f.tv_send_t_num_hint);
        this.gyi = (TextView) this.gyc.findViewById(a.f.tv_send_pkt_num_hint);
        this.gyj = (LinearLayout) this.gyc.findViewById(a.f.layout_red_pkt_condition);
        this.gyk = (LinearLayout) this.gyc.findViewById(a.f.layout_condition_first);
        this.gyl = (LinearLayout) this.gyc.findViewById(a.f.layout_condition_second);
        this.gys = (RelativeLayout) this.gyc.findViewById(a.f.layout_send_red_content);
        View findViewById = this.gyc.findViewById(a.f.layout_send_red);
        this.gym = (TextView) this.gyc.findViewById(a.f.tv_condition_first);
        this.gyn = (TextView) this.gyc.findViewById(a.f.tv_condition_second);
        this.gyo = (ImageView) this.gyc.findViewById(a.f.iv_condition_first);
        this.gyp = (ImageView) this.gyc.findViewById(a.f.iv_condition_second);
        this.gyq = (TextView) this.gyc.findViewById(a.f.tv_send_pkt_submit);
        this.gyr = (TextView) this.gyc.findViewById(a.f.tv_send_pkt_time);
        this.gyt = (LinearLayout) this.gyc.findViewById(a.f.layout_red_send_rule);
        View findViewById2 = this.gyc.findViewById(a.f.layout_red_send_rule_content);
        this.gyu = (LinearLayout) this.gyc.findViewById(a.f.layout_rule_desc);
        this.gyv = (ScrollView) this.gyc.findViewById(a.f.layout_input_scroll);
        this.gyw = this.gyc.findViewById(a.f.layout_send_red_close);
        this.gyc.setOnClickListener(this);
        this.gyk.setOnClickListener(this);
        this.gyl.setOnClickListener(this);
        this.gyq.setOnClickListener(this);
        this.gyd.setOnClickListener(this);
        this.gyt.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gyw.setOnClickListener(this);
        ((ImageView) this.gyc.findViewById(a.f.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        ch.a aVar;
        ch.a aVar2 = null;
        if (com.baidu.live.aa.a.Ph() == null || com.baidu.live.aa.a.Ph().bsh == null || com.baidu.live.aa.a.Ph().bsh.aNM == null || com.baidu.live.aa.a.Ph().bsh.aNM.aPj == null) {
            strArr = null;
            str = null;
        } else {
            ch chVar = com.baidu.live.aa.a.Ph().bsh.aNM.aPj;
            if (chVar.aPU > 0) {
                this.gyC = chVar.aPU;
            }
            if (chVar.aPV > 0) {
                this.gyR = chVar.aPV;
            }
            this.gyD = this.gyR;
            this.gyy = chVar.aPM;
            this.aPO = chVar.aPO;
            this.aPP = chVar.aPP;
            this.gyz = chVar.aPQ;
            this.gyS = chVar.aPN;
            this.aPR = chVar.aPR;
            this.gyB = chVar.aPS;
            this.aPW = chVar.aPW;
            this.aPX = chVar.aPX;
            str = chVar.aPY;
            strArr = chVar.aPZ;
            if (bQW()) {
                this.gyA = this.aPX;
            } else {
                this.gyA = this.gyS;
            }
        }
        this.gyf.setText(String.valueOf(this.gyC));
        this.gyg.setText(String.valueOf(this.gyD));
        this.gyf.setSelection(this.gyf.getText().toString().length());
        this.gyg.setSelection(this.gyg.getText().toString().length());
        TextView textView = this.gye;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.h.red_pkt_broad_condition), Integer.valueOf(this.gyz));
        }
        textView.setText(str);
        this.gyr.setText(String.format(this.activity.getString(a.h.red_send_between), Integer.valueOf(this.aPR)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.h.red_pkt_send_rule1), Integer.valueOf(this.aPR)), this.activity.getString(a.h.red_pkt_send_rule2), String.format(this.activity.getString(a.h.red_pkt_send_rule3), Integer.valueOf(this.gyS))};
        }
        if (this.gyu != null) {
            this.gyu.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.gyu.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds8);
                }
                this.gyu.addView(textView2, layoutParams);
            }
        }
        if (this.gyB != null && !this.gyB.isEmpty()) {
            if (this.gyB.size() == 1) {
                aVar = this.gyB.get(0);
            } else {
                aVar = this.gyB.get(0);
                aVar2 = this.gyB.get(1);
            }
            if (aVar == null) {
                this.gyk.setVisibility(8);
            } else {
                this.gym.setText(aVar.aQa);
                this.gyk.setVisibility(0);
                this.gyE = aVar.aQb;
            }
            if (aVar2 == null) {
                this.gyl.setVisibility(8);
            } else {
                this.gyn.setText(aVar2.aQa);
                this.gyl.setVisibility(0);
                this.gyF = aVar2.aQb;
            }
            if (this.gyk.getVisibility() == 0 || this.gyl.getVisibility() == 0) {
                this.gyj.setVisibility(0);
                return;
            } else {
                this.gyj.setVisibility(8);
                return;
            }
        }
        this.gyj.setVisibility(8);
    }

    private void bQU() {
        this.gyf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!e.this.mb(true)) {
                    e.this.mc(true);
                }
            }
        });
        this.gyg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = e.this.gyg.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (e.this.gyg.hasFocus()) {
                        e.this.gyT = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        e.this.gyg.setText(String.valueOf(parseLong));
                        return;
                    }
                    e.this.gyD = parseLong;
                    if (parseLong >= e.this.aPO && parseLong <= e.this.aPP) {
                        e.this.gyi.setVisibility(8);
                        e.this.gyH = true;
                    } else {
                        e.this.gyi.setText(String.format(e.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(e.this.aPO), Integer.valueOf(e.this.aPP)));
                        e.this.gyi.setVisibility(0);
                        e.this.gyH = false;
                    }
                } else {
                    e.this.gyi.setText(String.format(e.this.activity.getString(a.h.red_pkt_num_hint), Integer.valueOf(e.this.aPO), Integer.valueOf(e.this.aPP)));
                    e.this.gyi.setVisibility(0);
                    e.this.gyD = 0L;
                    e.this.gyH = false;
                }
                e.this.gyg.setSelection(e.this.gyg.getText().toString().length());
                TextView textView = e.this.gyq;
                if (!e.this.gyG || !e.this.gyH) {
                    z = false;
                }
                textView.setEnabled(z);
                e.this.mb(false);
                e.this.mc(false);
            }
        });
    }

    private void bQV() {
        this.gyf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.gyf.setText("");
                    e.this.gyf.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.gyf.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.gyg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.gyg.setText("");
                    e.this.gyg.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.gyg.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mb(boolean z) {
        boolean z2 = true;
        this.gyA = this.gyS;
        String obj = this.gyf.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.gyh.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gyx), Long.valueOf(this.gyy)));
            this.gyh.setVisibility(0);
            this.gyC = 0L;
            this.gyG = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.gyf.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gyC != parseLong && this.gyC > this.gyy && parseLong > this.gyy) {
                this.gyf.setText(String.valueOf(this.gyC));
                return true;
            } else {
                boolean z3 = bQW() && parseLong < this.aPW;
                this.gyC = parseLong;
                if (bQW()) {
                    this.gyA = this.aPX;
                }
                if (parseLong < this.gyx || parseLong > this.gyy) {
                    if (parseLong == 0) {
                        this.gyf.setText("0");
                    }
                    this.gyh.setText(String.format(this.activity.getString(a.h.red_t_num_hint), Integer.valueOf(this.gyx), Long.valueOf(this.gyy)));
                    this.gyh.setVisibility(0);
                    this.gyG = false;
                } else {
                    if (z && this.gyg != null && bQX() && !this.gyg.hasFocus()) {
                        boolean z4 = !this.gyT;
                        if (!z4 && this.gyg.getText() != null) {
                            String obj2 = this.gyg.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bQW()) {
                                long j = this.gyC / this.aPX;
                                if (this.aPP > 0 && j > this.aPP) {
                                    j = this.aPP;
                                }
                                this.gyg.setText(String.valueOf(j));
                            } else if (z3) {
                                this.gyg.setText(String.valueOf(this.gyR));
                            }
                        }
                    }
                    this.gyh.setVisibility(8);
                    this.gyG = true;
                }
            }
        }
        this.gyf.setSelection(this.gyf.getText().toString().length());
        TextView textView = this.gyq;
        if (!this.gyG || !this.gyH) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        if (this.gyH && this.gyG && this.gyD != 0 && this.gyC / this.gyD < this.gyA) {
            this.gyh.setVisibility(0);
            if (z) {
                this.gyh.setText(String.format(this.activity.getString(a.h.red_t_num_limit_by_pkt_num), Long.valueOf(this.gyD * this.gyA)));
            } else {
                this.gyh.setText(String.format(this.activity.getString(a.h.red_pkt_num_limit_by_t_num), Long.valueOf(this.gyC / this.gyA)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.gyt.getVisibility() == 0) {
            this.gyt.setVisibility(8);
            return;
        }
        if (view == this.gyw && !this.gyQ) {
            this.activity.finish();
        } else if (view == this.gyc && !this.gyQ) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.gyd) {
            this.gyt.setVisibility(0);
        } else if (view == this.gyk) {
            this.gyI = this.gyI ? false : true;
            if (this.gyI) {
                this.gyo.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gyo.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gyl) {
            this.gyJ = this.gyJ ? false : true;
            if (this.gyJ) {
                this.gyp.setImageResource(a.e.live_red_condition_choose);
            } else {
                this.gyp.setImageResource(a.e.live_red_condition_choose_false);
            }
        } else if (view == this.gyq) {
            if (this.gyI && this.gyJ) {
                str = this.gyE + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gyF;
            } else if (this.gyI) {
                str = this.gyE;
            } else if (this.gyJ) {
                str = this.gyF;
            } else {
                str = "";
            }
            s sVar = new s();
            sVar.eE(this.gyC);
            sVar.eF(this.gyD);
            sVar.GB(str);
            if (this.gyM != null) {
                this.gyM.a(sVar);
            }
        }
        if (this.gyQ && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void md(boolean z) {
        if (this.gyq != null) {
            this.gyq.setEnabled(z);
        }
    }

    public View getView() {
        return this.gyc;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gyQ = z;
        if (!z) {
            if (this.gyg != null) {
                this.gyg.clearFocus();
            }
            if (this.gyf != null) {
                this.gyf.clearFocus();
            }
        }
        if (this.gys != null && this.gys.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gys.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gyK;
                }
            } else {
                layoutParams.topMargin = this.gyL;
            }
            this.gys.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gyw.setVisibility(0);
        } else {
            this.gyw.setVisibility(8);
        }
    }

    public void Ha() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.ae(this.gyc);
        } else {
            i.af(this.gyc);
        }
        if (this.gyv != null && this.gyv.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyv.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gyO;
            } else {
                layoutParams.height = -2;
            }
            this.gyv.setLayoutParams(layoutParams);
        }
        if (this.gys != null && this.gys.getLayoutParams() != null && this.gyN > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gys.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.gys.setPivotX(this.gyN / 2);
            this.gys.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gys.setScaleX(this.gyP);
                this.gys.setScaleY(this.gyP);
            } else {
                layoutParams2.width = -1;
                this.gys.setScaleX(1.0f);
                this.gys.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gyQ);
        }
    }

    private boolean bQW() {
        return bQX() && this.gyC >= this.aPW && this.gyC <= this.gyy;
    }

    private boolean bQX() {
        return this.aPW >= ((long) this.gyx) && this.aPX > 0;
    }
}
