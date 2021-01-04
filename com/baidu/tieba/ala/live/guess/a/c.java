package com.baidu.tieba.ala.live.guess.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.guess.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes11.dex */
public class c implements View.OnClickListener, com.baidu.live.guess.b {
    private static final String TAG = c.class.getSimpleName();
    private boolean fln;
    private ImageView hhZ;
    private int hiA;
    private String hiB;
    private String hiC;
    private String hiD;
    private boolean hiE;
    private boolean hiF;
    private b.a hiG;
    private DialogInterface.OnKeyListener hiH;
    private RelativeSizeSpan hiI;
    private String hiJ;
    private ForegroundColorSpan hib;
    private TextView hif;
    private Dialog his;
    private TextView hit;
    private TextView hiu;
    private TextView hiv;
    private TextView hiw;
    private TextView hix;
    private TimeCountTextView hiy;
    private MagicProgressCircle hiz;
    private LinearLayout mContentView;
    private Activity mContext;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.hiA = 30;
        this.mDialogGravity = 17;
        this.hiB = "";
        this.hiC = "";
        this.hiD = "";
        this.hiE = true;
        this.hiF = false;
        this.hiJ = "(本轮奖金";
        this.fln = true;
        this.mContext = activity;
        this.hiB = aVar.gII;
        this.hiA = aVar.maxCount;
        this.hiC = aVar.hiL;
        this.hiD = aVar.hiM;
        this.mDialogGravity = aVar.gravity;
        this.hiF = aVar.hiF;
        this.hiE = aVar.hiE;
        this.hiG = aVar.hiO;
        this.hiH = aVar.hiN;
    }

    public void atC() {
        if (this.hiG != null) {
            this.hiG.LH();
            this.his = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
            this.his.setCancelable(this.hiE);
            this.his.setCanceledOnTouchOutside(this.hiF);
            this.his.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.hiG.onDismiss(dialogInterface);
                }
            });
            if (this.hiH != null) {
                this.his.setOnKeyListener(this.hiH);
            }
            JK();
            caH();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void JK() {
        Window window = this.his.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.i.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
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

    private void caH() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.hiy = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.hiz = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.hit = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.hiu = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.hiv = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.hiw = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.hif = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.hhZ = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hib = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        this.hiI = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.hiv.setOnClickListener(this);
        this.hiw.setOnClickListener(this);
        this.hhZ.setOnClickListener(this);
        a(new b(this.hiH));
    }

    @Override // com.baidu.live.guess.b
    public void eX(int i) {
        this.hiA = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.his != null) {
            return this.his.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hG(String str) {
        int length = this.hiJ.length();
        this.hiJ += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hiJ);
        spannableStringBuilder.setSpan(this.hib, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.hiI, length, str.length() + length, 34);
        this.hit.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hH(String str) {
        this.hiv.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hI(String str) {
        this.hiw.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.hiu.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.his == null) {
            atC();
        }
        if (!isShowing()) {
            this.fln = true;
            ShowUtil.showDialog(this.his, this.mContext);
            this.his.setContentView(this.mRootView);
            caI();
        }
    }

    private void caI() {
        this.hiz.ay(100.0f).wl(this.hiA * 1000).startAnim();
        this.hiy.a(this.hiA * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.hiG != null) {
                    c.this.hiG.onTimeout();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.his != null && this.his.isShowing()) {
            ShowUtil.dismissDialog(this.his, this.mContext);
        }
        this.fln = true;
    }

    public void nt(boolean z) {
        this.fln = z;
        this.hiv.setEnabled(z);
        this.hiw.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void LF() {
        this.hhZ.setVisibility(0);
        if (this.hix != null) {
            this.hix.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hix.setBackgroundResource(a.e.guess_button_choice_background);
            nt(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void LG() {
        this.hiy.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.hiH = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.hiF) {
            dismiss();
        } else if (view == this.hiv && this.fln) {
            if (this.hiG != null) {
                this.hix = (TextView) view;
                this.hiG.a(this);
            }
        } else if (view == this.hiw && this.fln) {
            if (this.hiG != null) {
                this.hix = (TextView) view;
                this.hiG.b(this);
            }
        } else if (view == this.hhZ) {
            this.hiG.onExit();
            LG();
            dismiss();
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener hiN;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.hiN = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.hiN.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gII = "";
        private String hiL = "";
        private String hiM = "";
        private boolean hiE = true;
        private boolean hiF = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener hiN = null;
        private b.a hiO = null;

        public a nu(boolean z) {
            this.hiE = z;
            return this;
        }

        public a nv(boolean z) {
            this.hiF = z;
            return this;
        }

        public a wj(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.hiO = aVar;
            return this;
        }

        public c ap(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.atC();
            return cVar;
        }
    }
}
