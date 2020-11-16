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
    private ImageView gMX;
    private TextView gMY;
    private ForegroundColorSpan gMZ;
    private RelativeSizeSpan gNa;
    private HorizontalProgressBar gNb;
    private TextView gNc;
    private TextView gNd;
    private ImageView gNe;
    private float gNf = 0.0f;
    private int gNg = 0;
    private float gNh = 0.0f;
    private int gNi = 0;
    private float gNj = 0.0f;
    private boolean gNk = false;
    private int gNl = -1;
    private DecimalFormat gNm;
    private InterfaceC0659a gNn;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0659a {
        void bUh();

        void bUi();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void Ov() {
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
            this.gNn = interfaceC0659a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Ov();
        initView();
        FS();
    }

    private void FS() {
        this.gMX.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.gMY = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.gNc = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.gNd = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.gMX = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gNe = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.gNb = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
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
        if (view == this.gMX) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gMY.setText(bUp());
            bUo();
        }
    }

    private void bUo() {
        if (this.gNl == this.gNi) {
            this.gNe.setImageResource(a.e.ala_guess_success);
            this.gNd.setText(a.h.ala_guess_congratulate);
            if (this.gNn != null) {
                this.gNn.bUh();
            }
        } else {
            this.gNe.setImageResource(a.e.ala_guess_failure);
            this.gNd.setText(a.h.ala_guess_regret);
            if (this.gNn != null) {
                this.gNn.bUi();
            }
        }
        if (this.gNi == 0) {
            this.gNk = false;
        } else {
            this.gNk = true;
        }
        if (Math.abs(this.gNh) <= 1.0E-6d) {
            this.gNh = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gNg).append("人瓜分").append((int) this.gNh).append("元");
        this.gNc.setText(sb);
        this.gNb.mB(this.gNk);
        int i = (int) (this.gNj * 100.0f);
        int i2 = 100 - i;
        if (this.gNk) {
            this.gNb.bI(i, i2);
        } else {
            this.gNb.bI(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void vp(int i) {
        this.gNl = i;
    }

    public void setAverage(float f) {
        this.gNf = f;
    }

    public void vq(int i) {
        this.gNg = i;
    }

    public void at(float f) {
        this.gNh = f;
    }

    public void h(int i, float f) {
        this.gNj = f;
        this.gNi = i;
    }

    public void eo(String str, String str2) {
        this.gNb.setLeftFirstString(str);
        this.gNb.setRightFirstString(str2);
    }

    private SpannableStringBuilder bUp() {
        if (this.gNm == null) {
            this.gNm = new DecimalFormat("0.00");
        }
        String bUq = bUq();
        int length = "人均".length();
        String str = "人均" + bUq + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gMZ = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gMZ, length, length2, 34);
        this.gNa = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gNa, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bUq() {
        String str = this.gNf + "";
        if (Math.abs(this.gNf) <= 1.0E-6d) {
            return "0";
        }
        if (!GZ(str) && isDecimal(str)) {
            return this.gNm.format(this.gNf);
        }
        return ((int) this.gNf) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean GZ(String str) {
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
