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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private ImageView hdA;
    private float hdB = 0.0f;
    private int hdC = 0;
    private float hdD = 0.0f;
    private int hdE = 0;
    private float hdF = 0.0f;
    private boolean hdG = false;
    private int hdH = -1;
    private DecimalFormat hdI;
    private InterfaceC0647a hdJ;
    private ImageView hdt;
    private TextView hdu;
    private ForegroundColorSpan hdv;
    private RelativeSizeSpan hdw;
    private HorizontalProgressBar hdx;
    private TextView hdy;
    private TextView hdz;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0647a {
        void bWF();

        void bWG();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void FP() {
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

    public void a(InterfaceC0647a interfaceC0647a) {
        if (interfaceC0647a != null) {
            this.hdJ = interfaceC0647a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        FP();
        initView();
        Dn();
    }

    private void Dn() {
        this.hdt.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_con_dialog, (ViewGroup) null);
        this.hdu = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.hdy = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.hdz = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.hdt = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hdA = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.hdx = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
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
        if (view == this.hdt) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.hdu.setText(bWN());
            bWM();
        }
    }

    private void bWM() {
        if (this.hdH == this.hdE) {
            this.hdA.setImageResource(a.e.ala_guess_success);
            this.hdz.setText(a.h.ala_guess_congratulate);
            if (this.hdJ != null) {
                this.hdJ.bWF();
            }
        } else {
            this.hdA.setImageResource(a.e.ala_guess_failure);
            this.hdz.setText(a.h.ala_guess_regret);
            if (this.hdJ != null) {
                this.hdJ.bWG();
            }
        }
        if (this.hdE == 0) {
            this.hdG = false;
        } else {
            this.hdG = true;
        }
        if (Math.abs(this.hdD) <= 1.0E-6d) {
            this.hdD = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.hdC).append("人瓜分").append((int) this.hdD).append("元");
        this.hdy.setText(sb);
        this.hdx.ns(this.hdG);
        int i = (int) (this.hdF * 100.0f);
        int i2 = 100 - i;
        if (this.hdG) {
            this.hdx.bL(i, i2);
        } else {
            this.hdx.bL(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void uB(int i) {
        this.hdH = i;
    }

    public void setAverage(float f) {
        this.hdB = f;
    }

    public void uC(int i) {
        this.hdC = i;
    }

    public void aw(float f) {
        this.hdD = f;
    }

    public void h(int i, float f) {
        this.hdF = f;
        this.hdE = i;
    }

    public void et(String str, String str2) {
        this.hdx.setLeftFirstString(str);
        this.hdx.setRightFirstString(str2);
    }

    private SpannableStringBuilder bWN() {
        if (this.hdI == null) {
            this.hdI = new DecimalFormat("0.00");
        }
        String bWO = bWO();
        int length = "人均".length();
        String str = "人均" + bWO + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.hdv = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.hdv, length, length2, 34);
        this.hdw = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.hdw, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bWO() {
        String str = this.hdB + "";
        if (Math.abs(this.hdB) <= 1.0E-6d) {
            return "0";
        }
        if (!GB(str) && isDecimal(str)) {
            return this.hdI.format(this.hdB);
        }
        return ((int) this.hdB) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean GB(String str) {
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
