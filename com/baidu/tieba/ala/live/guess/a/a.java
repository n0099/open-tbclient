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
    private ImageView gHE;
    private TextView gHF;
    private ForegroundColorSpan gHG;
    private RelativeSizeSpan gHH;
    private HorizontalProgressBar gHI;
    private TextView gHJ;
    private TextView gHK;
    private ImageView gHL;
    private float gHM = 0.0f;
    private int gHN = 0;
    private float gHO = 0.0f;
    private int gHP = 0;
    private float gHQ = 0.0f;
    private boolean gHR = false;
    private int gHS = -1;
    private DecimalFormat gHT;
    private InterfaceC0647a gHU;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0647a {
        void bSp();

        void bSq();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void OE() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(a.f.sdk_transparent_bg);
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

    public void a(InterfaceC0647a interfaceC0647a) {
        if (interfaceC0647a != null) {
            this.gHU = interfaceC0647a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        OE();
        initView();
        Ga();
    }

    private void Ga() {
        this.gHE.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_con_dialog, (ViewGroup) null);
        this.gHF = (TextView) this.mRootView.findViewById(a.g.tv_average);
        this.gHJ = (TextView) this.mRootView.findViewById(a.g.tv_notify);
        this.gHK = (TextView) this.mRootView.findViewById(a.g.tv_guess_cong);
        this.gHE = (ImageView) this.mRootView.findViewById(a.g.img_exit);
        this.gHL = (ImageView) this.mRootView.findViewById(a.g.img_crown);
        this.gHI = (HorizontalProgressBar) this.mRootView.findViewById(a.g.progress_horizontal);
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
        if (view == this.gHE) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gHF.setText(bSx());
            bSw();
        }
    }

    private void bSw() {
        if (this.gHS == this.gHP) {
            this.gHL.setImageResource(a.f.ala_guess_success);
            this.gHK.setText(a.i.ala_guess_congratulate);
            if (this.gHU != null) {
                this.gHU.bSp();
            }
        } else {
            this.gHL.setImageResource(a.f.ala_guess_failure);
            this.gHK.setText(a.i.ala_guess_regret);
            if (this.gHU != null) {
                this.gHU.bSq();
            }
        }
        if (this.gHP == 0) {
            this.gHR = false;
        } else {
            this.gHR = true;
        }
        if (Math.abs(this.gHO) <= 1.0E-6d) {
            this.gHO = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gHN).append("人瓜分").append((int) this.gHO).append("元");
        this.gHJ.setText(sb);
        this.gHI.mr(this.gHR);
        int i = (int) (this.gHQ * 100.0f);
        int i2 = 100 - i;
        if (this.gHR) {
            this.gHI.bI(i, i2);
        } else {
            this.gHI.bI(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void uH(int i) {
        this.gHS = i;
    }

    public void setAverage(float f) {
        this.gHM = f;
    }

    public void uI(int i) {
        this.gHN = i;
    }

    public void ap(float f) {
        this.gHO = f;
    }

    public void h(int i, float f) {
        this.gHQ = f;
        this.gHP = i;
    }

    public void eo(String str, String str2) {
        this.gHI.setLeftFirstString(str);
        this.gHI.setRightFirstString(str2);
    }

    private SpannableStringBuilder bSx() {
        if (this.gHT == null) {
            this.gHT = new DecimalFormat("0.00");
        }
        String bSy = bSy();
        int length = "人均".length();
        String str = "人均" + bSy + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gHG = new ForegroundColorSpan(this.mContext.getResources().getColor(a.d.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gHG, length, length2, 34);
        this.gHH = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gHH, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bSy() {
        String str = this.gHM + "";
        if (Math.abs(this.gHM) <= 1.0E-6d) {
            return "0";
        }
        if (!Hl(str) && isDecimal(str)) {
            return this.gHT.format(this.gHM);
        }
        return ((int) this.gHM) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean Hl(String str) {
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
