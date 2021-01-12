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
/* loaded from: classes10.dex */
public class c implements View.OnClickListener, com.baidu.live.guess.b {
    private static final String TAG = c.class.getSimpleName();
    private boolean fgC;
    private Dialog hdL;
    private TextView hdM;
    private TextView hdN;
    private TextView hdO;
    private TextView hdP;
    private TextView hdQ;
    private TimeCountTextView hdR;
    private MagicProgressCircle hdS;
    private int hdT;
    private String hdU;
    private String hdV;
    private String hdW;
    private boolean hdX;
    private boolean hdY;
    private b.a hdZ;
    private ImageView hdt;
    private ForegroundColorSpan hdv;
    private TextView hdy;
    private DialogInterface.OnKeyListener hea;
    private RelativeSizeSpan heb;
    private String hec;
    private LinearLayout mContentView;
    private Activity mContext;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.hdT = 30;
        this.mDialogGravity = 17;
        this.hdU = "";
        this.hdV = "";
        this.hdW = "";
        this.hdX = true;
        this.hdY = false;
        this.hec = "(本轮奖金";
        this.fgC = true;
        this.mContext = activity;
        this.hdU = aVar.gEc;
        this.hdT = aVar.maxCount;
        this.hdV = aVar.hee;
        this.hdW = aVar.hef;
        this.mDialogGravity = aVar.gravity;
        this.hdY = aVar.hdY;
        this.hdX = aVar.hdX;
        this.hdZ = aVar.heh;
        this.hea = aVar.heg;
    }

    public void apI() {
        if (this.hdZ != null) {
            this.hdZ.HM();
            this.hdL = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
            this.hdL.setCancelable(this.hdX);
            this.hdL.setCanceledOnTouchOutside(this.hdY);
            this.hdL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.hdZ.onDismiss(dialogInterface);
                }
            });
            if (this.hea != null) {
                this.hdL.setOnKeyListener(this.hea);
            }
            FP();
            bWQ();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void FP() {
        Window window = this.hdL.getWindow();
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

    private void bWQ() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.hdR = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.hdS = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.hdM = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.hdN = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.hdO = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.hdP = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.hdy = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.hdt = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hdv = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        this.heb = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.hdO.setOnClickListener(this);
        this.hdP.setOnClickListener(this);
        this.hdt.setOnClickListener(this);
        a(new b(this.hea));
    }

    @Override // com.baidu.live.guess.b
    public void dr(int i) {
        this.hdT = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.hdL != null) {
            return this.hdL.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void gv(String str) {
        int length = this.hec.length();
        this.hec += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hec);
        spannableStringBuilder.setSpan(this.hdv, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.heb, length, str.length() + length, 34);
        this.hdM.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void gw(String str) {
        this.hdO.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void gx(String str) {
        this.hdP.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.hdN.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.hdL == null) {
            apI();
        }
        if (!isShowing()) {
            this.fgC = true;
            ShowUtil.showDialog(this.hdL, this.mContext);
            this.hdL.setContentView(this.mRootView);
            bWR();
        }
    }

    private void bWR() {
        this.hdS.ay(100.0f).uF(this.hdT * 1000).startAnim();
        this.hdR.a(this.hdT * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.hdZ != null) {
                    c.this.hdZ.onTimeout();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.hdL != null && this.hdL.isShowing()) {
            ShowUtil.dismissDialog(this.hdL, this.mContext);
        }
        this.fgC = true;
    }

    public void np(boolean z) {
        this.fgC = z;
        this.hdO.setEnabled(z);
        this.hdP.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void HK() {
        this.hdt.setVisibility(0);
        if (this.hdQ != null) {
            this.hdQ.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hdQ.setBackgroundResource(a.e.guess_button_choice_background);
            np(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void HL() {
        this.hdR.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.hea = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.hdY) {
            dismiss();
        } else if (view == this.hdO && this.fgC) {
            if (this.hdZ != null) {
                this.hdQ = (TextView) view;
                this.hdZ.a(this);
            }
        } else if (view == this.hdP && this.fgC) {
            if (this.hdZ != null) {
                this.hdQ = (TextView) view;
                this.hdZ.b(this);
            }
        } else if (view == this.hdt) {
            this.hdZ.onExit();
            HL();
            dismiss();
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener heg;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.heg = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.heg.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gEc = "";
        private String hee = "";
        private String hef = "";
        private boolean hdX = true;
        private boolean hdY = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener heg = null;
        private b.a heh = null;

        public a nq(boolean z) {
            this.hdX = z;
            return this;
        }

        public a nr(boolean z) {
            this.hdY = z;
            return this;
        }

        public a uD(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.heh = aVar;
            return this;
        }

        public c ap(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.apI();
            return cVar;
        }
    }
}
