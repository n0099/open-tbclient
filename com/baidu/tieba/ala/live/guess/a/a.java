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
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private ImageView hhZ;
    private TextView hia;
    private ForegroundColorSpan hib;
    private RelativeSizeSpan hic;
    private HorizontalProgressBar hie;
    private TextView hif;
    private TextView hig;
    private ImageView hih;
    private float hii = 0.0f;
    private int hij = 0;
    private float hik = 0.0f;
    private int hil = 0;
    private float him = 0.0f;
    private boolean hin = false;
    private int hio = -1;
    private DecimalFormat hip;
    private InterfaceC0664a hiq;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0664a {
        void caw();

        void cax();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void JK() {
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

    public void a(InterfaceC0664a interfaceC0664a) {
        if (interfaceC0664a != null) {
            this.hiq = interfaceC0664a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        JK();
        initView();
        Hi();
    }

    private void Hi() {
        this.hhZ.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.hia = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.hif = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.hig = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.hhZ = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hih = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.hie = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
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
        if (view == this.hhZ) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.hia.setText(caE());
            caD();
        }
    }

    private void caD() {
        if (this.hio == this.hil) {
            this.hih.setImageResource(a.e.ala_guess_success);
            this.hig.setText(a.h.ala_guess_congratulate);
            if (this.hiq != null) {
                this.hiq.caw();
            }
        } else {
            this.hih.setImageResource(a.e.ala_guess_failure);
            this.hig.setText(a.h.ala_guess_regret);
            if (this.hiq != null) {
                this.hiq.cax();
            }
        }
        if (this.hil == 0) {
            this.hin = false;
        } else {
            this.hin = true;
        }
        if (Math.abs(this.hik) <= 1.0E-6d) {
            this.hik = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.hij).append("人瓜分").append((int) this.hik).append("元");
        this.hif.setText(sb);
        this.hie.nw(this.hin);
        int i = (int) (this.him * 100.0f);
        int i2 = 100 - i;
        if (this.hin) {
            this.hie.bL(i, i2);
        } else {
            this.hie.bL(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void wh(int i) {
        this.hio = i;
    }

    public void setAverage(float f) {
        this.hii = f;
    }

    public void wi(int i) {
        this.hij = i;
    }

    public void aw(float f) {
        this.hik = f;
    }

    public void h(int i, float f) {
        this.him = f;
        this.hil = i;
    }

    public void eu(String str, String str2) {
        this.hie.setLeftFirstString(str);
        this.hie.setRightFirstString(str2);
    }

    private SpannableStringBuilder caE() {
        if (this.hip == null) {
            this.hip = new DecimalFormat("0.00");
        }
        String caF = caF();
        int length = "人均".length();
        String str = "人均" + caF + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hib = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.hib, length, length2, 34);
        this.hic = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hic, length, length2, 34);
        return spannableStringBuilder;
    }

    private String caF() {
        String str = this.hii + "";
        if (Math.abs(this.hii) <= 1.0E-6d) {
            return "0";
        }
        if (!HN(str) && isDecimal(str)) {
            return this.hip.format(this.hii);
        }
        return ((int) this.hii) + "";
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
