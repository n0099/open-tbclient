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
    private DecimalFormat gWB;
    private InterfaceC0672a gWC;
    private ImageView gWm;
    private TextView gWn;
    private ForegroundColorSpan gWo;
    private RelativeSizeSpan gWp;
    private HorizontalProgressBar gWq;
    private TextView gWr;
    private TextView gWs;
    private ImageView gWt;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;
    private float gWu = 0.0f;
    private int gWv = 0;
    private float gWw = 0.0f;
    private int gWx = 0;
    private float gWy = 0.0f;
    private boolean gWz = false;
    private int gWA = -1;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0672a {
        void bXR();

        void bXS();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void Ki() {
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

    public void a(InterfaceC0672a interfaceC0672a) {
        if (interfaceC0672a != null) {
            this.gWC = interfaceC0672a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Ki();
        initView();
        HH();
    }

    private void HH() {
        this.gWm.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.gWn = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.gWr = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.gWs = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.gWm = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gWt = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.gWq = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
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
        if (view == this.gWm) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gWn.setText(bXZ());
            bXY();
        }
    }

    private void bXY() {
        if (this.gWA == this.gWx) {
            this.gWt.setImageResource(a.e.ala_guess_success);
            this.gWs.setText(a.h.ala_guess_congratulate);
            if (this.gWC != null) {
                this.gWC.bXR();
            }
        } else {
            this.gWt.setImageResource(a.e.ala_guess_failure);
            this.gWs.setText(a.h.ala_guess_regret);
            if (this.gWC != null) {
                this.gWC.bXS();
            }
        }
        if (this.gWx == 0) {
            this.gWz = false;
        } else {
            this.gWz = true;
        }
        if (Math.abs(this.gWw) <= 1.0E-6d) {
            this.gWw = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gWv).append("人瓜分").append((int) this.gWw).append("元");
        this.gWr.setText(sb);
        this.gWq.mW(this.gWz);
        int i = (int) (this.gWy * 100.0f);
        int i2 = 100 - i;
        if (this.gWz) {
            this.gWq.bM(i, i2);
        } else {
            this.gWq.bM(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void vW(int i) {
        this.gWA = i;
    }

    public void setAverage(float f) {
        this.gWu = f;
    }

    public void vX(int i) {
        this.gWv = i;
    }

    public void au(float f) {
        this.gWw = f;
    }

    public void h(int i, float f) {
        this.gWy = f;
        this.gWx = i;
    }

    public void ev(String str, String str2) {
        this.gWq.setLeftFirstString(str);
        this.gWq.setRightFirstString(str2);
    }

    private SpannableStringBuilder bXZ() {
        if (this.gWB == null) {
            this.gWB = new DecimalFormat("0.00");
        }
        String bYa = bYa();
        int length = "人均".length();
        String str = "人均" + bYa + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gWo = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gWo, length, length2, 34);
        this.gWp = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gWp, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bYa() {
        String str = this.gWu + "";
        if (Math.abs(this.gWu) <= 1.0E-6d) {
            return "0";
        }
        if (!HN(str) && isDecimal(str)) {
            return this.gWB.format(this.gWu);
        }
        return ((int) this.gWu) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean HN(String str) {
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
