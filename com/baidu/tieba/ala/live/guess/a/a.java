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
    private ImageView gvQ;
    private TextView gvR;
    private ForegroundColorSpan gvS;
    private RelativeSizeSpan gvT;
    private HorizontalProgressBar gvU;
    private TextView gvV;
    private TextView gvW;
    private ImageView gvX;
    private float gvY = 0.0f;
    private int gvZ = 0;
    private float gwa = 0.0f;
    private int gwb = 0;
    private float gwc = 0.0f;
    private boolean gwd = false;
    private int gwe = -1;
    private DecimalFormat gwf;
    private InterfaceC0631a gwg;
    private Context mContext;
    private Dialog mDialog;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.live.guess.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0631a {
        void bPs();

        void bPt();
    }

    public a(Context context) {
        this.mContext = context;
        initDialog();
    }

    private void Og() {
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

    public void a(InterfaceC0631a interfaceC0631a) {
        if (interfaceC0631a != null) {
            this.gwg = interfaceC0631a;
        }
    }

    private void initDialog() {
        this.mDialog = new e(this.mContext);
        Og();
        initView();
        FL();
    }

    private void FL() {
        this.gvQ.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_con_dialog, (ViewGroup) null);
        this.gvR = (TextView) this.mRootView.findViewById(a.g.tv_average);
        this.gvV = (TextView) this.mRootView.findViewById(a.g.tv_notify);
        this.gvW = (TextView) this.mRootView.findViewById(a.g.tv_guess_cong);
        this.gvQ = (ImageView) this.mRootView.findViewById(a.g.img_exit);
        this.gvX = (ImageView) this.mRootView.findViewById(a.g.img_crown);
        this.gvU = (HorizontalProgressBar) this.mRootView.findViewById(a.g.progress_horizontal);
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
        if (view == this.gvQ) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.show();
            this.gvR.setText(bPA());
            bPz();
        }
    }

    private void bPz() {
        if (this.gwe == this.gwb) {
            this.gvX.setImageResource(a.f.ala_guess_success);
            this.gvW.setText(a.i.ala_guess_congratulate);
            if (this.gwg != null) {
                this.gwg.bPs();
            }
        } else {
            this.gvX.setImageResource(a.f.ala_guess_failure);
            this.gvW.setText(a.i.ala_guess_regret);
            if (this.gwg != null) {
                this.gwg.bPt();
            }
        }
        if (this.gwb == 0) {
            this.gwd = false;
        } else {
            this.gwd = true;
        }
        if (Math.abs(this.gwa) <= 1.0E-6d) {
            this.gwa = 0.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.gvZ).append("人瓜分").append((int) this.gwa).append("元");
        this.gvV.setText(sb);
        this.gvU.ma(this.gwd);
        int i = (int) (this.gwc * 100.0f);
        int i2 = 100 - i;
        if (this.gwd) {
            this.gvU.bG(i, i2);
        } else {
            this.gvU.bG(i2, i);
        }
    }

    public void dismiss() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public void uo(int i) {
        this.gwe = i;
    }

    public void setAverage(float f) {
        this.gvY = f;
    }

    public void up(int i) {
        this.gvZ = i;
    }

    public void an(float f) {
        this.gwa = f;
    }

    public void h(int i, float f) {
        this.gwc = f;
        this.gwb = i;
    }

    public void eh(String str, String str2) {
        this.gvU.setLeftFirstString(str);
        this.gvU.setRightFirstString(str2);
    }

    private SpannableStringBuilder bPA() {
        if (this.gwf == null) {
            this.gwf = new DecimalFormat("0.00");
        }
        String bPB = bPB();
        int length = "人均".length();
        String str = "人均" + bPB + "元";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        this.gvS = new ForegroundColorSpan(this.mContext.getResources().getColor(a.d.ala_guess_bonus));
        int length2 = (str.length() - length) + 1;
        spannableStringBuilder.setSpan(this.gvS, length, length2, 34);
        this.gvT = new RelativeSizeSpan(1.8f);
        spannableStringBuilder.setSpan(this.gvT, length, length2, 34);
        return spannableStringBuilder;
    }

    private String bPB() {
        String str = this.gvY + "";
        if (Math.abs(this.gvY) <= 1.0E-6d) {
            return "0";
        }
        if (!GN(str) && isDecimal(str)) {
            return this.gwf.format(this.gvY);
        }
        return ((int) this.gvY) + "";
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private boolean GN(String str) {
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
