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
/* loaded from: classes4.dex */
public class c implements View.OnClickListener, com.baidu.live.guess.b {
    private static final String TAG = c.class.getSimpleName();
    private Activity beD;
    private boolean fbE;
    private Dialog gWC;
    private TextView gWD;
    private TextView gWE;
    private TextView gWF;
    private TextView gWG;
    private TextView gWH;
    private TimeCountTextView gWI;
    private MagicProgressCircle gWJ;
    private int gWK;
    private String gWL;
    private String gWM;
    private String gWN;
    private boolean gWO;
    private boolean gWP;
    private b.a gWQ;
    private DialogInterface.OnKeyListener gWR;
    private RelativeSizeSpan gWS;
    private String gWT;
    private ImageView gWk;
    private ForegroundColorSpan gWm;
    private TextView gWp;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gWK = 30;
        this.mDialogGravity = 17;
        this.gWL = "";
        this.gWM = "";
        this.gWN = "";
        this.gWO = true;
        this.gWP = false;
        this.gWT = "(本轮奖金";
        this.fbE = true;
        this.beD = activity;
        this.gWL = aVar.gxD;
        this.gWK = aVar.maxCount;
        this.gWM = aVar.gWV;
        this.gWN = aVar.gWW;
        this.mDialogGravity = aVar.gravity;
        this.gWP = aVar.gWP;
        this.gWO = aVar.gWO;
        this.gWQ = aVar.gWY;
        this.gWR = aVar.gWX;
    }

    public void ask() {
        if (this.gWQ != null) {
            this.gWQ.Mj();
            this.gWC = new AlertDialog.Builder(this.beD, a.i.guess_theme_dialog).create();
            this.gWC.setCancelable(this.gWO);
            this.gWC.setCanceledOnTouchOutside(this.gWP);
            this.gWC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gWQ.onDismiss(dialogInterface);
                }
            });
            if (this.gWR != null) {
                this.gWC.setOnKeyListener(this.gWR);
            }
            Ki();
            bYb();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Ki() {
        Window window = this.gWC.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.i.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.65f;
            if (UtilHelper.getRealScreenOrientation(this.beD) == 2) {
                attributes.width = ScreenHelper.getRealScreenHeight(this.beD);
                attributes.height = -1;
            } else {
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.beD) - UtilHelper.getStatusBarHeight();
            }
            window.setAttributes(attributes);
        }
    }

    private void bYb() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.beD).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.gWI = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.gWJ = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.gWD = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.gWE = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.gWF = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.gWG = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.gWp = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.gWk = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gWm = new ForegroundColorSpan(this.beD.getResources().getColor(a.c.ala_guess_bonus));
        this.gWS = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gWF.setOnClickListener(this);
        this.gWG.setOnClickListener(this);
        this.gWk.setOnClickListener(this);
        a(new b(this.gWR));
    }

    @Override // com.baidu.live.guess.b
    public void eZ(int i) {
        this.gWK = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gWC != null) {
            return this.gWC.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hV(String str) {
        int length = this.gWT.length();
        this.gWT += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gWT);
        spannableStringBuilder.setSpan(this.gWm, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gWS, length, str.length() + length, 34);
        this.gWD.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hW(String str) {
        this.gWF.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hX(String str) {
        this.gWG.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gWE.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gWC == null) {
            ask();
        }
        if (!isShowing()) {
            this.fbE = true;
            ShowUtil.showDialog(this.gWC, this.beD);
            this.gWC.setContentView(this.mRootView);
            bYc();
        }
    }

    private void bYc() {
        this.gWJ.aw(100.0f).wa(this.gWK * 1000).startAnim();
        this.gWI.a(this.gWK * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gWQ != null) {
                    c.this.gWQ.Mk();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gWC != null && this.gWC.isShowing()) {
            ShowUtil.dismissDialog(this.gWC, this.beD);
        }
        this.fbE = true;
    }

    public void mT(boolean z) {
        this.fbE = z;
        this.gWF.setEnabled(z);
        this.gWG.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void Mh() {
        this.gWk.setVisibility(0);
        if (this.gWH != null) {
            this.gWH.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha100));
            this.gWH.setBackgroundResource(a.e.guess_button_choice_background);
            mT(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void Mi() {
        this.gWI.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gWR = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gWP) {
            dismiss();
        } else if (view == this.gWF && this.fbE) {
            if (this.gWQ != null) {
                this.gWH = (TextView) view;
                this.gWQ.a(this);
            }
        } else if (view == this.gWG && this.fbE) {
            if (this.gWQ != null) {
                this.gWH = (TextView) view;
                this.gWQ.b(this);
            }
        } else if (view == this.gWk) {
            this.gWQ.onExit();
            Mi();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gWX;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gWX = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gWX.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gxD = "";
        private String gWV = "";
        private String gWW = "";
        private boolean gWO = true;
        private boolean gWP = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gWX = null;
        private b.a gWY = null;

        public a mU(boolean z) {
            this.gWO = z;
            return this;
        }

        public a mV(boolean z) {
            this.gWP = z;
            return this;
        }

        public a vY(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gWY = aVar;
            return this;
        }

        public c an(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.ask();
            return cVar;
        }
    }
}
