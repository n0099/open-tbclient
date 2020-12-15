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
    private Dialog gWE;
    private TextView gWF;
    private TextView gWG;
    private TextView gWH;
    private TextView gWI;
    private TextView gWJ;
    private TimeCountTextView gWK;
    private MagicProgressCircle gWL;
    private int gWM;
    private String gWN;
    private String gWO;
    private String gWP;
    private boolean gWQ;
    private boolean gWR;
    private b.a gWS;
    private DialogInterface.OnKeyListener gWT;
    private RelativeSizeSpan gWU;
    private String gWV;
    private ImageView gWm;
    private ForegroundColorSpan gWo;
    private TextView gWr;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gWM = 30;
        this.mDialogGravity = 17;
        this.gWN = "";
        this.gWO = "";
        this.gWP = "";
        this.gWQ = true;
        this.gWR = false;
        this.gWV = "(本轮奖金";
        this.fbE = true;
        this.beD = activity;
        this.gWN = aVar.gxF;
        this.gWM = aVar.maxCount;
        this.gWO = aVar.gWX;
        this.gWP = aVar.gWY;
        this.mDialogGravity = aVar.gravity;
        this.gWR = aVar.gWR;
        this.gWQ = aVar.gWQ;
        this.gWS = aVar.gXa;
        this.gWT = aVar.gWZ;
    }

    public void ask() {
        if (this.gWS != null) {
            this.gWS.Mj();
            this.gWE = new AlertDialog.Builder(this.beD, a.i.guess_theme_dialog).create();
            this.gWE.setCancelable(this.gWQ);
            this.gWE.setCanceledOnTouchOutside(this.gWR);
            this.gWE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gWS.onDismiss(dialogInterface);
                }
            });
            if (this.gWT != null) {
                this.gWE.setOnKeyListener(this.gWT);
            }
            Ki();
            bYc();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Ki() {
        Window window = this.gWE.getWindow();
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

    private void bYc() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.beD).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.gWK = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.gWL = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.gWF = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.gWG = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.gWH = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.gWI = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.gWr = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.gWm = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gWo = new ForegroundColorSpan(this.beD.getResources().getColor(a.c.ala_guess_bonus));
        this.gWU = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gWH.setOnClickListener(this);
        this.gWI.setOnClickListener(this);
        this.gWm.setOnClickListener(this);
        a(new b(this.gWT));
    }

    @Override // com.baidu.live.guess.b
    public void eZ(int i) {
        this.gWM = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gWE != null) {
            return this.gWE.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hV(String str) {
        int length = this.gWV.length();
        this.gWV += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gWV);
        spannableStringBuilder.setSpan(this.gWo, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gWU, length, str.length() + length, 34);
        this.gWF.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hW(String str) {
        this.gWH.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hX(String str) {
        this.gWI.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gWG.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gWE == null) {
            ask();
        }
        if (!isShowing()) {
            this.fbE = true;
            ShowUtil.showDialog(this.gWE, this.beD);
            this.gWE.setContentView(this.mRootView);
            bYd();
        }
    }

    private void bYd() {
        this.gWL.aw(100.0f).wa(this.gWM * 1000).startAnim();
        this.gWK.a(this.gWM * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gWS != null) {
                    c.this.gWS.Mk();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gWE != null && this.gWE.isShowing()) {
            ShowUtil.dismissDialog(this.gWE, this.beD);
        }
        this.fbE = true;
    }

    public void mT(boolean z) {
        this.fbE = z;
        this.gWH.setEnabled(z);
        this.gWI.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void Mh() {
        this.gWm.setVisibility(0);
        if (this.gWJ != null) {
            this.gWJ.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha100));
            this.gWJ.setBackgroundResource(a.e.guess_button_choice_background);
            mT(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void Mi() {
        this.gWK.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gWT = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gWR) {
            dismiss();
        } else if (view == this.gWH && this.fbE) {
            if (this.gWS != null) {
                this.gWJ = (TextView) view;
                this.gWS.a(this);
            }
        } else if (view == this.gWI && this.fbE) {
            if (this.gWS != null) {
                this.gWJ = (TextView) view;
                this.gWS.b(this);
            }
        } else if (view == this.gWm) {
            this.gWS.onExit();
            Mi();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gWZ;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gWZ = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gWZ.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gxF = "";
        private String gWX = "";
        private String gWY = "";
        private boolean gWQ = true;
        private boolean gWR = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gWZ = null;
        private b.a gXa = null;

        public a mU(boolean z) {
            this.gWQ = z;
            return this;
        }

        public a mV(boolean z) {
            this.gWR = z;
            return this;
        }

        public a vY(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gXa = aVar;
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
