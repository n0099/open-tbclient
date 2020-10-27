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
    private Activity bIs;
    private boolean ePk;
    private ImageView gHE;
    private ForegroundColorSpan gHG;
    private TextView gHJ;
    private Dialog gHW;
    private TextView gHX;
    private TextView gHY;
    private TextView gHZ;
    private TextView gIa;
    private TextView gIb;
    private TimeCountTextView gIc;
    private MagicProgressCircle gId;
    private int gIe;
    private String gIf;
    private String gIg;
    private String gIh;
    private boolean gIi;
    private boolean gIj;
    private b.a gIk;
    private DialogInterface.OnKeyListener gIl;
    private RelativeSizeSpan gIm;
    private String gIn;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gIe = 30;
        this.mDialogGravity = 17;
        this.gIf = "";
        this.gIg = "";
        this.gIh = "";
        this.gIi = true;
        this.gIj = false;
        this.gIn = "(本轮奖金";
        this.ePk = true;
        this.bIs = activity;
        this.gIf = aVar.gka;
        this.gIe = aVar.maxCount;
        this.gIg = aVar.gIp;
        this.gIh = aVar.gIq;
        this.mDialogGravity = aVar.gravity;
        this.gIj = aVar.gIj;
        this.gIi = aVar.gIi;
        this.gIk = aVar.gIs;
        this.gIl = aVar.gIr;
    }

    public void ank() {
        if (this.gIk != null) {
            this.gIk.Kq();
            this.gHW = new AlertDialog.Builder(this.bIs, a.j.guess_theme_dialog).create();
            this.gHW.setCancelable(this.gIi);
            this.gHW.setCanceledOnTouchOutside(this.gIj);
            this.gHW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gIk.onDismiss(dialogInterface);
                }
            });
            if (this.gIl != null) {
                this.gHW.setOnKeyListener(this.gIl);
            }
            OE();
            bSA();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void OE() {
        Window window = this.gHW.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.j.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.f.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.65f;
            if (UtilHelper.getRealScreenOrientation(this.bIs) == 2) {
                attributes.width = ScreenHelper.getRealScreenHeight(this.bIs);
                attributes.height = -1;
            } else {
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.bIs) - UtilHelper.getStatusBarHeight();
            }
            window.setAttributes(attributes);
        }
    }

    private void bSA() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.bIs).inflate(a.h.ala_guess_dialog, (ViewGroup) null);
        this.gIc = (TimeCountTextView) this.mRootView.findViewById(a.g.txt_center_number);
        this.gId = (MagicProgressCircle) this.mRootView.findViewById(a.g.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.g.dialog_content);
        this.gHX = (TextView) this.mRootView.findViewById(a.g.tv_guess_bonus);
        this.gHY = (TextView) this.mRootView.findViewById(a.g.tv_guess_ques);
        this.gHZ = (TextView) this.mRootView.findViewById(a.g.tv_guess_success);
        this.gIa = (TextView) this.mRootView.findViewById(a.g.tv_guess_failure);
        this.gHJ = (TextView) this.mRootView.findViewById(a.g.tv_guess_notify);
        this.gHE = (ImageView) this.mRootView.findViewById(a.g.img_exit);
        this.gHG = new ForegroundColorSpan(this.bIs.getResources().getColor(a.d.ala_guess_bonus));
        this.gIm = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gHZ.setOnClickListener(this);
        this.gIa.setOnClickListener(this);
        this.gHE.setOnClickListener(this);
        a(new b(this.gIl));
    }

    @Override // com.baidu.live.guess.b
    public void eH(int i) {
        this.gIe = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gHW != null) {
            return this.gHW.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hu(String str) {
        int length = this.gIn.length();
        this.gIn += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gIn);
        spannableStringBuilder.setSpan(this.gHG, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gIm, length, str.length() + length, 34);
        this.gHX.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hv(String str) {
        this.gHZ.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hw(String str) {
        this.gIa.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gHY.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gHW == null) {
            ank();
        }
        if (!isShowing()) {
            this.ePk = true;
            ShowUtil.showDialog(this.gHW, this.bIs);
            this.gHW.setContentView(this.mRootView);
            bSB();
        }
    }

    private void bSB() {
        this.gId.ar(100.0f).uL(this.gIe * 1000).startAnim();
        this.gIc.a(this.gIe * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gIk != null) {
                    c.this.gIk.Kr();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gHW != null && this.gHW.isShowing()) {
            ShowUtil.dismissDialog(this.gHW, this.bIs);
        }
        this.ePk = true;
    }

    public void mo(boolean z) {
        this.ePk = z;
        this.gHZ.setEnabled(z);
        this.gIa.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void Ko() {
        this.gHE.setVisibility(0);
        if (this.gIb != null) {
            this.gIb.setTextColor(this.bIs.getResources().getColor(a.d.sdk_white_alpha100));
            this.gIb.setBackgroundResource(a.f.guess_button_choice_background);
            mo(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void Kp() {
        this.gIc.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gIl = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gIj) {
            dismiss();
        } else if (view == this.gHZ && this.ePk) {
            if (this.gIk != null) {
                this.gIb = (TextView) view;
                this.gIk.a(this);
            }
        } else if (view == this.gIa && this.ePk) {
            if (this.gIk != null) {
                this.gIb = (TextView) view;
                this.gIk.b(this);
            }
        } else if (view == this.gHE) {
            this.gIk.onExit();
            Kp();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gIr;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gIr = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gIr.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gka = "";
        private String gIp = "";
        private String gIq = "";
        private boolean gIi = true;
        private boolean gIj = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gIr = null;
        private b.a gIs = null;

        public a mp(boolean z) {
            this.gIi = z;
            return this;
        }

        public a mq(boolean z) {
            this.gIj = z;
            return this;
        }

        public a uJ(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gIs = aVar;
            return this;
        }

        public c an(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.ank();
            return cVar;
        }
    }
}
