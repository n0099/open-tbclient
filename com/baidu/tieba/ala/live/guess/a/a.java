package com.baidu.tieba.ala.live.guess.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.live.guess.widget.HorizontalProgressBar;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private DecimalFormat gNF;
    private InterfaceC0659a gNG;
    private ImageView gNq;
    private TextView gNr;
    private ForegroundColorSpan gNs;
    private RelativeSizeSpan gNt;
    private HorizontalProgressBar gNu;
    private TextView gNv;
    private TextView gNw;
    private ImageView gNx;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private float gNy = 0.0f;
    private int gNz = 0;
    private float gNA = 0.0f;
    private int gNB = 0;
    private float gNC = 0.0f;
    private boolean gND = false;
    private int gNE = -1;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0659a {
        void bUO();

        void bUP();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void Pe() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) this.mDialog.getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.65f;
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.mContext);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    public void a(InterfaceC0659a interfaceC0659a) {
        if (interfaceC0659a != null) {
            this.gNG = interfaceC0659a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Pe();
        initView();
        GB();
    }

    private void GB() {
        this.gNq.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.gNr = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.gNv = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.gNw = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.gNq = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gNx = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.gNu = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
        this.mDialog.setContentView(this.mRootView);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.a.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNq) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gNr.setText(bUW());
            bUV();
        }
    }

    private void bUV() {
        if (this.gNE == this.gNB) {
            this.gNx.setImageResource(a.e.ala_guess_success);
            this.gNw.setText(a.h.ala_guess_congratulate);
            if (this.gNG != null) {
                this.gNG.bUO();
            }
        } else {
            this.gNx.setImageResource(a.e.ala_guess_failure);
            this.gNw.setText(a.h.ala_guess_regret);
            if (this.gNG != null) {
                this.gNG.bUP();
            }
        }
        if (this.gNB == 0) {
            this.gND = false;
        } else {
            this.gND = true;
        }
        if (Math.abs(this.gNA) <= 1.0E-6d) {
            this.gNA = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gNz).append("人瓜分").append((int) this.gNA).append("元");
        this.gNv.setText(sb);
        this.gNu.mA(this.gND);
        int i = (int) (this.gNC * 100.0f);
        int i2 = 100 - i;
        if (this.gND) {
            this.gNu.bI(i, i2);
        } else {
            this.gNu.bI(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void uR(int i) {
        this.gNE = i;
    }

    public void setAverage(float f) {
        this.gNy = f;
    }

    public void uS(int i) {
        this.gNz = i;
    }

    public void ar(float f) {
        this.gNA = f;
    }

    public void h(int i, float f) {
        this.gNC = f;
        this.gNB = i;
    }

    public void eo(String str, String str2) {
        this.gNu.setLeftFirstString(str);
        this.gNu.setRightFirstString(str2);
    }

    private SpannableStringBuilder bUW() {
        if (this.gNF == null) {
            this.gNF = new DecimalFormat("0.00");
        }
        String bUX = bUX();
        int length = "人均".length();
        String str = "人均" + bUX + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gNs = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gNs, length, length2, 34);
        this.gNt = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gNt, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bUX() {
        String str = this.gNy + "";
        if (Math.abs(this.gNy) <= 1.0E-6d) {
            return "0";
        }
        if (!Hy(str) && isDecimal(str)) {
            return this.gNF.format(this.gNy);
        }
        return ((int) this.gNy) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean Hy(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    private boolean isDecimal(String str) {
        if (str != null) {
            try {
                if (str.equals("")) {
                    return false;
                }
                return Float.parseFloat(str.split("\\.")[1]) > 0.0f;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
