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
import com.baidu.live.data.ca;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.q;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    private int aPN;
    private int aPO;
    private int aPQ;
    private long aPV;
    private int aPW;
    private Activity activity;
    private int dvr;
    private View giG;
    private View giH;
    private TextView giI;
    private EditText giJ;
    private EditText giK;
    private TextView giL;
    private TextView giM;
    private LinearLayout giN;
    private LinearLayout giO;
    private LinearLayout giP;
    private TextView giQ;
    private TextView giR;
    private ImageView giS;
    private ImageView giT;
    private TextView giU;
    private TextView giV;
    private RelativeLayout giW;
    private LinearLayout giX;
    private LinearLayout giY;
    private ScrollView giZ;
    private View gja;
    private long gjc;
    private int gjd;
    private int gje;
    private List<ca.a> gjf;
    private long gjh;
    private String gji;
    private String gjj;
    private boolean gjm;
    private boolean gjn;
    private int gjo;
    private int gjp;
    private d gjq;
    private int gjr;
    private int gjs;
    private float gjt;
    private boolean gju;
    private int gjw;
    private boolean gjx;
    private int screenWidth;
    private int gjb = 2000;
    private long gjg = 2000;
    private boolean gjk = true;
    private boolean gjl = true;
    private int gjv = 10;

    public e(final Activity activity, d dVar) {
        this.activity = activity;
        this.gjq = dVar;
        initView();
        initData();
        bMz();
        bMA();
        this.giW.setVisibility(4);
        this.giW.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.screenWidth = ScreenHelper.getScreenWidth(activity);
                e.this.dvr = ScreenHelper.getScreenHeight(activity);
                if (e.this.screenWidth > e.this.dvr) {
                    int i = e.this.screenWidth;
                    e.this.screenWidth = e.this.dvr;
                    e.this.dvr = i;
                }
                e.this.gjr = e.this.screenWidth;
                e.this.gjp = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
                e.this.gjs = activity.getResources().getDimensionPixelOffset(a.e.sdk_ds204);
                int i2 = e.this.screenWidth - (e.this.gjp * 2);
                e.this.gjt = (i2 * 1.0f) / e.this.giW.getHeight();
                if (e.this.dvr > e.this.giW.getHeight()) {
                    e.this.gjo = (e.this.dvr - e.this.giW.getHeight()) / 2;
                }
                e.this.GM();
                e.this.giW.setVisibility(0);
            }
        });
    }

    private void initView() {
        this.giG = LayoutInflater.from(this.activity).inflate(a.h.ala_red_pkt_send_layout, (ViewGroup) null);
        this.giH = this.giG.findViewById(a.g.iv_send_red_q);
        this.giI = (TextView) this.giG.findViewById(a.g.tv_red_broad_hint);
        this.giJ = (EditText) this.giG.findViewById(a.g.edt_t_num);
        this.giK = (EditText) this.giG.findViewById(a.g.edt_pkt_num);
        this.giL = (TextView) this.giG.findViewById(a.g.tv_send_t_num_hint);
        this.giM = (TextView) this.giG.findViewById(a.g.tv_send_pkt_num_hint);
        this.giN = (LinearLayout) this.giG.findViewById(a.g.layout_red_pkt_condition);
        this.giO = (LinearLayout) this.giG.findViewById(a.g.layout_condition_first);
        this.giP = (LinearLayout) this.giG.findViewById(a.g.layout_condition_second);
        this.giW = (RelativeLayout) this.giG.findViewById(a.g.layout_send_red_content);
        View findViewById = this.giG.findViewById(a.g.layout_send_red);
        this.giQ = (TextView) this.giG.findViewById(a.g.tv_condition_first);
        this.giR = (TextView) this.giG.findViewById(a.g.tv_condition_second);
        this.giS = (ImageView) this.giG.findViewById(a.g.iv_condition_first);
        this.giT = (ImageView) this.giG.findViewById(a.g.iv_condition_second);
        this.giU = (TextView) this.giG.findViewById(a.g.tv_send_pkt_submit);
        this.giV = (TextView) this.giG.findViewById(a.g.tv_send_pkt_time);
        this.giX = (LinearLayout) this.giG.findViewById(a.g.layout_red_send_rule);
        View findViewById2 = this.giG.findViewById(a.g.layout_red_send_rule_content);
        this.giY = (LinearLayout) this.giG.findViewById(a.g.layout_rule_desc);
        this.giZ = (ScrollView) this.giG.findViewById(a.g.layout_input_scroll);
        this.gja = this.giG.findViewById(a.g.layout_send_red_close);
        this.giG.setOnClickListener(this);
        this.giO.setOnClickListener(this);
        this.giP.setOnClickListener(this);
        this.giU.setOnClickListener(this);
        this.giH.setOnClickListener(this);
        this.giX.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.gja.setOnClickListener(this);
        ((ImageView) this.giG.findViewById(a.g.img_red_send_top)).setOnClickListener(this);
    }

    private void initData() {
        String[] strArr;
        String str;
        ca.a aVar;
        ca.a aVar2 = null;
        if (com.baidu.live.x.a.OS() == null || com.baidu.live.x.a.OS().bqJ == null || com.baidu.live.x.a.OS().bqJ.aNV == null || com.baidu.live.x.a.OS().bqJ.aNV.aPi == null) {
            strArr = null;
            str = null;
        } else {
            ca caVar = com.baidu.live.x.a.OS().bqJ.aNV.aPi;
            if (caVar.aPT > 0) {
                this.gjg = caVar.aPT;
            }
            if (caVar.aPU > 0) {
                this.gjv = caVar.aPU;
            }
            this.gjh = this.gjv;
            this.gjc = caVar.aPL;
            this.aPN = caVar.aPN;
            this.aPO = caVar.aPO;
            this.gjd = caVar.aPP;
            this.gjw = caVar.aPM;
            this.aPQ = caVar.aPQ;
            this.gjf = caVar.aPR;
            this.aPV = caVar.aPV;
            this.aPW = caVar.aPW;
            str = caVar.aPX;
            strArr = caVar.aPY;
            if (bMB()) {
                this.gje = this.aPW;
            } else {
                this.gje = this.gjw;
            }
        }
        this.giJ.setText(String.valueOf(this.gjg));
        this.giK.setText(String.valueOf(this.gjh));
        this.giJ.setSelection(this.giJ.getText().toString().length());
        this.giK.setSelection(this.giK.getText().toString().length());
        TextView textView = this.giI;
        if (TextUtils.isEmpty(str)) {
            str = String.format(this.activity.getString(a.i.red_pkt_broad_condition), Integer.valueOf(this.gjd));
        }
        textView.setText(str);
        this.giV.setText(String.format(this.activity.getString(a.i.red_send_between), Integer.valueOf(this.aPQ)));
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{String.format(this.activity.getString(a.i.red_pkt_send_rule1), Integer.valueOf(this.aPQ)), this.activity.getString(a.i.red_pkt_send_rule2), String.format(this.activity.getString(a.i.red_pkt_send_rule3), Integer.valueOf(this.gjw))};
        }
        if (this.giY != null) {
            this.giY.removeAllViews();
            for (int i = 0; i < strArr.length; i++) {
                TextView textView2 = new TextView(this.giY.getContext());
                textView2.setText(strArr[i]);
                textView2.setTextColor(-7450624);
                textView2.setTextSize(0, this.activity.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i != 0) {
                    layoutParams.topMargin = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds8);
                }
                this.giY.addView(textView2, layoutParams);
            }
        }
        if (this.gjf != null && !this.gjf.isEmpty()) {
            if (this.gjf.size() == 1) {
                aVar = this.gjf.get(0);
            } else {
                aVar = this.gjf.get(0);
                aVar2 = this.gjf.get(1);
            }
            if (aVar == null) {
                this.giO.setVisibility(8);
            } else {
                this.giQ.setText(aVar.aPZ);
                this.giO.setVisibility(0);
                this.gji = aVar.aQa;
            }
            if (aVar2 == null) {
                this.giP.setVisibility(8);
            } else {
                this.giR.setText(aVar2.aPZ);
                this.giP.setVisibility(0);
                this.gjj = aVar2.aQa;
            }
            if (this.giO.getVisibility() == 0 || this.giP.getVisibility() == 0) {
                this.giN.setVisibility(0);
                return;
            } else {
                this.giN.setVisibility(8);
                return;
            }
        }
        this.giN.setVisibility(8);
    }

    private void bMz() {
        this.giJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!e.this.lA(true)) {
                    e.this.lB(true);
                }
            }
        });
        this.giK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.d.e.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z = true;
                String obj = e.this.giK.getText().toString();
                if (!TextUtils.isEmpty(obj) && !"0".equals(obj)) {
                    if (e.this.giK.hasFocus()) {
                        e.this.gjx = true;
                    }
                    long parseLong = Long.parseLong(obj);
                    if (obj.startsWith("0")) {
                        e.this.giK.setText(String.valueOf(parseLong));
                        return;
                    }
                    e.this.gjh = parseLong;
                    if (parseLong >= e.this.aPN && parseLong <= e.this.aPO) {
                        e.this.giM.setVisibility(8);
                        e.this.gjl = true;
                    } else {
                        e.this.giM.setText(String.format(e.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(e.this.aPN), Integer.valueOf(e.this.aPO)));
                        e.this.giM.setVisibility(0);
                        e.this.gjl = false;
                    }
                } else {
                    e.this.giM.setText(String.format(e.this.activity.getString(a.i.red_pkt_num_hint), Integer.valueOf(e.this.aPN), Integer.valueOf(e.this.aPO)));
                    e.this.giM.setVisibility(0);
                    e.this.gjh = 0L;
                    e.this.gjl = false;
                }
                e.this.giK.setSelection(e.this.giK.getText().toString().length());
                TextView textView = e.this.giU;
                if (!e.this.gjk || !e.this.gjl) {
                    z = false;
                }
                textView.setEnabled(z);
                e.this.lA(false);
                e.this.lB(false);
            }
        });
    }

    private void bMA() {
        this.giJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.giJ.setText("");
                    e.this.giJ.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.giJ.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
        this.giK.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.d.e.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e.this.giK.setText("");
                    e.this.giK.post(new Runnable() { // from class: com.baidu.tieba.ala.d.e.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.giK.setOnFocusChangeListener(null);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lA(boolean z) {
        boolean z2 = true;
        this.gje = this.gjw;
        String obj = this.giJ.getText().toString();
        if (TextUtils.isEmpty(obj) || "0".equals(obj)) {
            this.giL.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.gjb), Long.valueOf(this.gjc)));
            this.giL.setVisibility(0);
            this.gjg = 0L;
            this.gjk = false;
        } else {
            long parseLong = Long.parseLong(obj);
            if (obj.startsWith("0")) {
                this.giJ.setText(String.valueOf(parseLong));
                return true;
            } else if (this.gjg != parseLong && this.gjg > this.gjc && parseLong > this.gjc) {
                this.giJ.setText(String.valueOf(this.gjg));
                return true;
            } else {
                boolean z3 = bMB() && parseLong < this.aPV;
                this.gjg = parseLong;
                if (bMB()) {
                    this.gje = this.aPW;
                }
                if (parseLong < this.gjb || parseLong > this.gjc) {
                    if (parseLong == 0) {
                        this.giJ.setText("0");
                    }
                    this.giL.setText(String.format(this.activity.getString(a.i.red_t_num_hint), Integer.valueOf(this.gjb), Long.valueOf(this.gjc)));
                    this.giL.setVisibility(0);
                    this.gjk = false;
                } else {
                    if (z && this.giK != null && bMC() && !this.giK.hasFocus()) {
                        boolean z4 = !this.gjx;
                        if (!z4 && this.giK.getText() != null) {
                            String obj2 = this.giK.getText().toString();
                            if (TextUtils.isEmpty(obj2) || obj2.startsWith("0")) {
                                z4 = true;
                            }
                        }
                        if (z4) {
                            if (bMB()) {
                                long j = this.gjg / this.aPW;
                                if (this.aPO > 0 && j > this.aPO) {
                                    j = this.aPO;
                                }
                                this.giK.setText(String.valueOf(j));
                            } else if (z3) {
                                this.giK.setText(String.valueOf(this.gjv));
                            }
                        }
                    }
                    this.giL.setVisibility(8);
                    this.gjk = true;
                }
            }
        }
        this.giJ.setSelection(this.giJ.getText().toString().length());
        TextView textView = this.giU;
        if (!this.gjk || !this.gjl) {
            z2 = false;
        }
        textView.setEnabled(z2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lB(boolean z) {
        if (this.gjl && this.gjk && this.gjh != 0 && this.gjg / this.gjh < this.gje) {
            this.giL.setVisibility(0);
            if (z) {
                this.giL.setText(String.format(this.activity.getString(a.i.red_t_num_limit_by_pkt_num), Long.valueOf(this.gjh * this.gje)));
            } else {
                this.giL.setText(String.format(this.activity.getString(a.i.red_pkt_num_limit_by_t_num), Long.valueOf(this.gjg / this.gje)));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        InputMethodManager inputMethodManager;
        if (this.giX.getVisibility() == 0) {
            this.giX.setVisibility(8);
            return;
        }
        if (view == this.gja && !this.gju) {
            this.activity.finish();
        } else if (view == this.giG && !this.gju) {
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.activity.finish();
            }
        } else if (view == this.giH) {
            this.giX.setVisibility(0);
        } else if (view == this.giO) {
            this.gjm = this.gjm ? false : true;
            if (this.gjm) {
                this.giS.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.giS.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.giP) {
            this.gjn = this.gjn ? false : true;
            if (this.gjn) {
                this.giT.setImageResource(a.f.live_red_condition_choose);
            } else {
                this.giT.setImageResource(a.f.live_red_condition_choose_false);
            }
        } else if (view == this.giU) {
            if (this.gjm && this.gjn) {
                str = this.gji + Constants.ACCEPT_TIME_SEPARATOR_SP + this.gjj;
            } else if (this.gjm) {
                str = this.gji;
            } else if (this.gjn) {
                str = this.gjj;
            } else {
                str = "";
            }
            q qVar = new q();
            qVar.eh(this.gjg);
            qVar.ei(this.gjh);
            qVar.Gp(str);
            if (this.gjq != null) {
                this.gjq.a(qVar);
            }
        }
        if (this.gju && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public void lC(boolean z) {
        if (this.giU != null) {
            this.giU.setEnabled(z);
        }
    }

    public View getView() {
        return this.giG;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gju = z;
        if (!z) {
            if (this.giK != null) {
                this.giK.clearFocus();
            }
            if (this.giJ != null) {
                this.giJ.clearFocus();
            }
        }
        if (this.giW != null && this.giW.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.giW.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (z) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = this.gjo;
                }
            } else {
                layoutParams.topMargin = this.gjp;
            }
            this.giW.setLayoutParams(layoutParams);
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gja.setVisibility(0);
        } else {
            this.gja.setVisibility(8);
        }
    }

    public void GM() {
        if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
            i.aa(this.giG);
        } else {
            i.ab(this.giG);
        }
        if (this.giZ != null && this.giZ.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.giZ.getLayoutParams();
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                layoutParams.height = this.gjs;
            } else {
                layoutParams.height = -2;
            }
            this.giZ.setLayoutParams(layoutParams);
        }
        if (this.giW != null && this.giW.getLayoutParams() != null && this.gjr > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.giW.getLayoutParams();
            layoutParams2.width = this.screenWidth;
            this.giW.setPivotX(this.gjr / 2);
            this.giW.setPivotY(0.0f);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.giW.setScaleX(this.gjt);
                this.giW.setScaleY(this.gjt);
            } else {
                layoutParams2.width = -1;
                this.giW.setScaleX(1.0f);
                this.giW.setScaleY(1.0f);
            }
            onKeyboardVisibilityChanged(this.gju);
        }
    }

    private boolean bMB() {
        return bMC() && this.gjg >= this.aPV && this.gjg <= this.gjc;
    }

    private boolean bMC() {
        return this.aPV >= ((long) this.gjb) && this.aPW > 0;
    }
}
