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
    private Activity bMo;
    private boolean eUh;
    private ImageView gMX;
    private ForegroundColorSpan gMZ;
    private String gNA;
    private boolean gNB;
    private boolean gNC;
    private b.a gND;
    private DialogInterface.OnKeyListener gNE;
    private RelativeSizeSpan gNF;
    private String gNG;
    private TextView gNc;
    private Dialog gNp;
    private TextView gNq;
    private TextView gNr;
    private TextView gNs;
    private TextView gNt;
    private TextView gNu;
    private TimeCountTextView gNv;
    private MagicProgressCircle gNw;
    private int gNx;
    private String gNy;
    private String gNz;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gNx = 30;
        this.mDialogGravity = 17;
        this.gNy = "";
        this.gNz = "";
        this.gNA = "";
        this.gNB = true;
        this.gNC = false;
        this.gNG = "(本轮奖金";
        this.eUh = true;
        this.bMo = activity;
        this.gNy = aVar.gpu;
        this.gNx = aVar.maxCount;
        this.gNz = aVar.gNI;
        this.gNA = aVar.gNJ;
        this.mDialogGravity = aVar.gravity;
        this.gNC = aVar.gNC;
        this.gNB = aVar.gNB;
        this.gND = aVar.gNL;
        this.gNE = aVar.gNK;
    }

    public void apc() {
        if (this.gND != null) {
            this.gND.Kh();
            this.gNp = new AlertDialog.Builder(this.bMo, a.i.guess_theme_dialog).create();
            this.gNp.setCancelable(this.gNB);
            this.gNp.setCanceledOnTouchOutside(this.gNC);
            this.gNp.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gND.onDismiss(dialogInterface);
                }
            });
            if (this.gNE != null) {
                this.gNp.setOnKeyListener(this.gNE);
            }
            Ov();
            bUs();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Ov() {
        Window window = this.gNp.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.i.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.65f;
            if (UtilHelper.getRealScreenOrientation(this.bMo) == 2) {
                attributes.width = ScreenHelper.getRealScreenHeight(this.bMo);
                attributes.height = -1;
            } else {
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.bMo) - UtilHelper.getStatusBarHeight();
            }
            window.setAttributes(attributes);
        }
    }

    private void bUs() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.bMo).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.gNv = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.gNw = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.gNq = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.gNr = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.gNs = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.gNt = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.gNc = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.gMX = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gMZ = new ForegroundColorSpan(this.bMo.getResources().getColor(a.c.ala_guess_bonus));
        this.gNF = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gNs.setOnClickListener(this);
        this.gNt.setOnClickListener(this);
        this.gMX.setOnClickListener(this);
        a(new b(this.gNE));
    }

    @Override // com.baidu.live.guess.b
    public void eD(int i) {
        this.gNx = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gNp != null) {
            return this.gNp.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hv(String str) {
        int length = this.gNG.length();
        this.gNG += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gNG);
        spannableStringBuilder.setSpan(this.gMZ, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gNF, length, str.length() + length, 34);
        this.gNq.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hw(String str) {
        this.gNs.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hx(String str) {
        this.gNt.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gNr.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gNp == null) {
            apc();
        }
        if (!isShowing()) {
            this.eUh = true;
            ShowUtil.showDialog(this.gNp, this.bMo);
            this.gNp.setContentView(this.mRootView);
            bUt();
        }
    }

    private void bUt() {
        this.gNw.av(100.0f).vt(this.gNx * 1000).startAnim();
        this.gNv.a(this.gNx * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gND != null) {
                    c.this.gND.Ki();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gNp != null && this.gNp.isShowing()) {
            ShowUtil.dismissDialog(this.gNp, this.bMo);
        }
        this.eUh = true;
    }

    public void my(boolean z) {
        this.eUh = z;
        this.gNs.setEnabled(z);
        this.gNt.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void Kf() {
        this.gMX.setVisibility(0);
        if (this.gNu != null) {
            this.gNu.setTextColor(this.bMo.getResources().getColor(a.c.sdk_white_alpha100));
            this.gNu.setBackgroundResource(a.e.guess_button_choice_background);
            my(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void Kg() {
        this.gNv.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gNE = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gNC) {
            dismiss();
        } else if (view == this.gNs && this.eUh) {
            if (this.gND != null) {
                this.gNu = (TextView) view;
                this.gND.a(this);
            }
        } else if (view == this.gNt && this.eUh) {
            if (this.gND != null) {
                this.gNu = (TextView) view;
                this.gND.b(this);
            }
        } else if (view == this.gMX) {
            this.gND.onExit();
            Kg();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gNK;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gNK = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gNK.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gpu = "";
        private String gNI = "";
        private String gNJ = "";
        private boolean gNB = true;
        private boolean gNC = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gNK = null;
        private b.a gNL = null;

        public a mz(boolean z) {
            this.gNB = z;
            return this;
        }

        public a mA(boolean z) {
            this.gNC = z;
            return this;
        }

        public a vr(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gNL = aVar;
            return this;
        }

        public c am(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.apc();
            return cVar;
        }
    }
}
