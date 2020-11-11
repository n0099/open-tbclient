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
    private Activity bNY;
    private boolean eUZ;
    private Dialog gNI;
    private TextView gNJ;
    private TextView gNK;
    private TextView gNL;
    private TextView gNM;
    private TextView gNN;
    private TimeCountTextView gNO;
    private MagicProgressCircle gNP;
    private int gNQ;
    private String gNR;
    private String gNS;
    private String gNT;
    private boolean gNU;
    private boolean gNV;
    private b.a gNW;
    private DialogInterface.OnKeyListener gNX;
    private RelativeSizeSpan gNY;
    private String gNZ;
    private ImageView gNq;
    private ForegroundColorSpan gNs;
    private TextView gNv;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gNQ = 30;
        this.mDialogGravity = 17;
        this.gNR = "";
        this.gNS = "";
        this.gNT = "";
        this.gNU = true;
        this.gNV = false;
        this.gNZ = "(本轮奖金";
        this.eUZ = true;
        this.bNY = activity;
        this.gNR = aVar.gpN;
        this.gNQ = aVar.maxCount;
        this.gNS = aVar.gOb;
        this.gNT = aVar.gOc;
        this.mDialogGravity = aVar.gravity;
        this.gNV = aVar.gNV;
        this.gNU = aVar.gNU;
        this.gNW = aVar.gOe;
        this.gNX = aVar.gOd;
    }

    public void apL() {
        if (this.gNW != null) {
            this.gNW.KQ();
            this.gNI = new AlertDialog.Builder(this.bNY, a.i.guess_theme_dialog).create();
            this.gNI.setCancelable(this.gNU);
            this.gNI.setCanceledOnTouchOutside(this.gNV);
            this.gNI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gNW.onDismiss(dialogInterface);
                }
            });
            if (this.gNX != null) {
                this.gNI.setOnKeyListener(this.gNX);
            }
            Pe();
            bUZ();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Pe() {
        Window window = this.gNI.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.i.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.65f;
            if (UtilHelper.getRealScreenOrientation(this.bNY) == 2) {
                attributes.width = ScreenHelper.getRealScreenHeight(this.bNY);
                attributes.height = -1;
            } else {
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.bNY) - UtilHelper.getStatusBarHeight();
            }
            window.setAttributes(attributes);
        }
    }

    private void bUZ() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.bNY).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.gNO = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.gNP = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.gNJ = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.gNK = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.gNL = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.gNM = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.gNv = (TextView) this.mRootView.findViewById(a.f.tv_guess_notify);
        this.gNq = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.gNs = new ForegroundColorSpan(this.bNY.getResources().getColor(a.c.ala_guess_bonus));
        this.gNY = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gNL.setOnClickListener(this);
        this.gNM.setOnClickListener(this);
        this.gNq.setOnClickListener(this);
        a(new b(this.gNX));
    }

    @Override // com.baidu.live.guess.b
    public void eH(int i) {
        this.gNQ = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gNI != null) {
            return this.gNI.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hB(String str) {
        int length = this.gNZ.length();
        this.gNZ += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gNZ);
        spannableStringBuilder.setSpan(this.gNs, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gNY, length, str.length() + length, 34);
        this.gNJ.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hC(String str) {
        this.gNL.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void hD(String str) {
        this.gNM.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gNK.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gNI == null) {
            apL();
        }
        if (!isShowing()) {
            this.eUZ = true;
            ShowUtil.showDialog(this.gNI, this.bNY);
            this.gNI.setContentView(this.mRootView);
            bVa();
        }
    }

    private void bVa() {
        this.gNP.at(100.0f).uV(this.gNQ * 1000).startAnim();
        this.gNO.a(this.gNQ * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gNW != null) {
                    c.this.gNW.KR();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gNI != null && this.gNI.isShowing()) {
            ShowUtil.dismissDialog(this.gNI, this.bNY);
        }
        this.eUZ = true;
    }

    public void mx(boolean z) {
        this.eUZ = z;
        this.gNL.setEnabled(z);
        this.gNM.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void KO() {
        this.gNq.setVisibility(0);
        if (this.gNN != null) {
            this.gNN.setTextColor(this.bNY.getResources().getColor(a.c.sdk_white_alpha100));
            this.gNN.setBackgroundResource(a.e.guess_button_choice_background);
            mx(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void KP() {
        this.gNO.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gNX = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gNV) {
            dismiss();
        } else if (view == this.gNL && this.eUZ) {
            if (this.gNW != null) {
                this.gNN = (TextView) view;
                this.gNW.a(this);
            }
        } else if (view == this.gNM && this.eUZ) {
            if (this.gNW != null) {
                this.gNN = (TextView) view;
                this.gNW.b(this);
            }
        } else if (view == this.gNq) {
            this.gNW.onExit();
            KP();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gOd;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gOd = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gOd.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gpN = "";
        private String gOb = "";
        private String gOc = "";
        private boolean gNU = true;
        private boolean gNV = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gOd = null;
        private b.a gOe = null;

        public a my(boolean z) {
            this.gNU = z;
            return this;
        }

        public a mz(boolean z) {
            this.gNV = z;
            return this;
        }

        public a uT(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gOe = aVar;
            return this;
        }

        public c an(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.apL();
            return cVar;
        }
    }
}
