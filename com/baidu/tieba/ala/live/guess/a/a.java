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
    private InterfaceC0672a gWA;
    private ImageView gWk;
    private TextView gWl;
    private ForegroundColorSpan gWm;
    private RelativeSizeSpan gWn;
    private HorizontalProgressBar gWo;
    private TextView gWp;
    private TextView gWq;
    private ImageView gWr;
    private float gWs = 0.0f;
    private int gWt = 0;
    private float gWu = 0.0f;
    private int gWv = 0;
    private float gWw = 0.0f;
    private boolean gWx = false;
    private int gWy = -1;
    private DecimalFormat gWz;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0672a {
        void bXQ();

        void bXR();
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
            this.gWA = interfaceC0672a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Ki();
        initView();
        HH();
    }

    private void HH() {
        this.gWk.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.gWl = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.gWp = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.gWq = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.gWk = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gWr = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.gWo = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
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
        if (view == this.gWk) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gWl.setText(bXY());
            bXX();
        }
    }

    private void bXX() {
        if (this.gWy == this.gWv) {
            this.gWr.setImageResource(a.e.ala_guess_success);
            this.gWq.setText(a.h.ala_guess_congratulate);
            if (this.gWA != null) {
                this.gWA.bXQ();
            }
        } else {
            this.gWr.setImageResource(a.e.ala_guess_failure);
            this.gWq.setText(a.h.ala_guess_regret);
            if (this.gWA != null) {
                this.gWA.bXR();
            }
        }
        if (this.gWv == 0) {
            this.gWx = false;
        } else {
            this.gWx = true;
        }
        if (Math.abs(this.gWu) <= 1.0E-6d) {
            this.gWu = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gWt).append("人瓜分").append((int) this.gWu).append("元");
        this.gWp.setText(sb);
        this.gWo.mW(this.gWx);
        int i = (int) (this.gWw * 100.0f);
        int i2 = 100 - i;
        if (this.gWx) {
            this.gWo.bM(i, i2);
        } else {
            this.gWo.bM(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void vW(int i) {
        this.gWy = i;
    }

    public void setAverage(float f) {
        this.gWs = f;
    }

    public void vX(int i) {
        this.gWt = i;
    }

    public void au(float f) {
        this.gWu = f;
    }

    public void h(int i, float f) {
        this.gWw = f;
        this.gWv = i;
    }

    public void ev(String str, String str2) {
        this.gWo.setLeftFirstString(str);
        this.gWo.setRightFirstString(str2);
    }

    private SpannableStringBuilder bXY() {
        if (this.gWz == null) {
            this.gWz = new DecimalFormat("0.00");
        }
        String bXZ = bXZ();
        int length = "人均".length();
        String str = "人均" + bXZ + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gWm = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gWm, length, length2, 34);
        this.gWn = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gWn, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bXZ() {
        String str = this.gWs + "";
        if (Math.abs(this.gWs) <= 1.0E-6d) {
            return "0";
        }
        if (!HN(str) && isDecimal(str)) {
            return this.gWz.format(this.gWs);
        }
        return ((int) this.gWs) + "";
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
