package com.baidu.tieba.ala.live.guess.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.guess.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.live.guess.widget.MagicProgressCircle;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener, com.baidu.live.guess.c {
    private static final String TAG = b.class.getSimpleName();
    private RelativeLayout anR;
    private boolean fku;
    private ImageView hjA;
    private TextView hjB;
    private TextView hjC;
    private TextView hjD;
    private TimeCountTextView hjE;
    private MagicProgressCircle hjF;
    private int hjG;
    private String hjH;
    private String hjI;
    private String hjJ;
    private boolean hjK;
    private boolean hjL;
    private c.a hjM;
    private DialogInterface.OnKeyListener hjN;
    private RelativeSizeSpan hjO;
    private String hjP;
    private String hjQ;
    private String hjR;
    private String hjS;
    private int hjT;
    private FrameLayout hjU;
    private View hjV;
    private boolean hjW;
    private ForegroundColorSpan hjc;
    private Dialog hjo;
    private TextView hjp;
    private TextView hjq;
    private TextView hjr;
    private TextView hjs;
    private TextView hjt;
    private TextView hju;
    private RelativeLayout hjv;
    private LinearLayout hjw;
    private ImageView hjx;
    private ImageView hjy;
    private LinearLayout hjz;
    private LinearLayout mContentView;
    private Activity mContext;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private b(a aVar, Activity activity) {
        this.hjG = 30;
        this.mDialogGravity = 17;
        this.hjH = "";
        this.hjI = "";
        this.hjJ = "";
        this.hjK = false;
        this.hjL = false;
        this.hjP = "(本轮奖金";
        this.fku = true;
        this.hjW = false;
        this.mContext = activity;
        this.hjH = aVar.gIJ;
        this.hjG = aVar.maxCount;
        this.hjI = aVar.hjY;
        this.hjJ = aVar.hjZ;
        this.mDialogGravity = aVar.gravity;
        this.hjL = aVar.hjL;
        this.hjK = aVar.hjK;
        this.hjM = aVar.hkb;
        this.hjN = aVar.hka;
    }

    public void aqj() {
        if (this.hjM != null) {
            this.hjM.Ji();
            this.hjo = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
            this.hjo.setCancelable(this.hjK);
            this.hjo.setCanceledOnTouchOutside(this.hjL);
            this.hjo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.view.b.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.hjM.onDismiss(dialogInterface);
                }
            });
            Hi();
            bXZ();
            bYa();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Hi() {
        Window window = this.hjo.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.i.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.3f;
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

    private void bXZ() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.anR = (RelativeLayout) this.mRootView.findViewById(a.f.guess_dialog_container);
        this.hjE = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.hjF = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.hjp = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.hjq = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.hjr = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.hjs = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.hjt = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_success);
        this.hju = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_failure);
        this.hjv = (RelativeLayout) this.mRootView.findViewById(a.f.rl_team_opt);
        this.hjw = (LinearLayout) this.mRootView.findViewById(a.f.ll_single_opt);
        this.hjx = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hjy = (ImageView) this.mRootView.findViewById(a.f.img_guess_help_tips);
        this.hjA = (ImageView) this.mRootView.findViewById(a.f.img_guess_double_checkbox);
        this.hjB = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_title);
        this.hjC = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_number);
        this.hjz = (LinearLayout) this.mRootView.findViewById(a.f.llayout_double_ticket);
        this.hjU = (FrameLayout) this.mRootView.findViewById(a.f.frame_group_container);
        this.hjV = this.mRootView.findViewById(a.f.line1);
        this.hjc = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        this.hjO = new RelativeSizeSpan(1.3f);
    }

    private void bYa() {
        com.baidu.tieba.ala.live.guess.c.c.p(this.anR, 318, -2);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hjt, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hju, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hjr, -1, 50, 10, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hjs, -1, 50, 25, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hjz, -1, 60);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hjp, 16);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hjq, 20);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.hjr.setOnClickListener(this);
        this.hjs.setOnClickListener(this);
        this.hju.setOnClickListener(this);
        this.hjt.setOnClickListener(this);
        this.hjx.setOnClickListener(this);
        this.hjy.setOnClickListener(this);
        this.hjA.setOnClickListener(this);
        a(new DialogInterface$OnKeyListenerC0654b(this.hjN));
    }

    @Override // com.baidu.live.guess.c
    public void dx(int i) {
        this.hjG = i;
    }

    @Override // com.baidu.live.guess.c
    public boolean isShowing() {
        if (this.hjo != null) {
            return this.hjo.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.c
    public void gY(String str) {
        int length = this.hjP.length();
        this.hjP += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hjP);
        spannableStringBuilder.setSpan(this.hjc, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.hjO, length, str.length() + length, 34);
        this.hjp.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.c
    public void gZ(String str) {
        this.hjr.setText(str);
        this.hjt.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void ha(String str) {
        this.hjs.setText(str);
        this.hju.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void setQuesContent(String str) {
        this.hjq.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void show() {
        if (this.hjo == null) {
            aqj();
        }
        if (!isShowing()) {
            this.fku = true;
            ShowUtil.showDialog(this.hjo, this.mContext);
            this.hjo.setContentView(this.mRootView);
            bYb();
        }
    }

    private void bYb() {
        this.hjF.aE(100.0f).uR(this.hjG * 1000).startAnim();
        this.hjE.a("#CC9E67", this.hjG * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.view.b.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (b.this.hjM != null) {
                    b.this.hjM.onTimeout();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.c
    public void dismiss() {
        if (this.hjo != null && this.hjo.isShowing()) {
            ShowUtil.dismissDialog(this.hjo, this.mContext);
        }
        this.fku = true;
    }

    public void nA(boolean z) {
        this.fku = z;
        if (this.hjw.getVisibility() == 0) {
            this.hjr.setEnabled(z);
            this.hjs.setEnabled(z);
            return;
        }
        this.hjt.setEnabled(z);
        this.hju.setEnabled(z);
    }

    @Override // com.baidu.live.guess.c
    public void Jd() {
        this.hjx.setVisibility(0);
        if (this.hjD != null) {
            this.hjD.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hjD.setBackgroundResource(a.e.guess_button_choice_background);
            nA(false);
        }
    }

    @Override // com.baidu.live.guess.c
    public void Je() {
        this.hjE.cancel();
    }

    @Override // com.baidu.live.guess.c
    public void ce(boolean z) {
        this.hjW = z;
        if (z) {
            this.hjV.setVisibility(8);
            this.hjw.setVisibility(0);
            this.hjv.setVisibility(8);
            return;
        }
        this.hjV.setVisibility(0);
        this.hjw.setVisibility(8);
        this.hjv.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public boolean Jf() {
        return this.hjW;
    }

    @Override // com.baidu.live.guess.c
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.hjN = onKeyListener;
        if (this.hjN != null) {
            this.hjo.setOnKeyListener(this.hjN);
        }
    }

    @Override // com.baidu.live.guess.c
    public ViewGroup Jh() {
        return this.hjU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.hjL) {
            dismiss();
        } else if (view == this.hjr && this.fku) {
            if (this.hjM != null) {
                this.hjD = (TextView) view;
                this.hjM.a(this);
            }
        } else if (view == this.hjs && this.fku) {
            if (this.hjM != null) {
                this.hjD = (TextView) view;
                this.hjM.b(this);
            }
        } else if (view == this.hjt && this.fku) {
            if (this.hjM != null) {
                this.hjD = (TextView) view;
                this.hjM.a(this);
            }
        } else if (view == this.hju && this.fku) {
            if (this.hjM != null) {
                this.hjD = (TextView) view;
                this.hjM.b(this);
            }
        } else if (view == this.hjx) {
            this.hjM.onExit();
            Je();
            dismiss();
        } else if (view == this.hjy) {
            bYd();
        } else if (view == this.hjA) {
            bYc();
        }
    }

    private void bYc() {
        if (!this.fku) {
            CustomToast.newInstance().showToast("答题后无法勾选");
        } else if (this.hjT > 0) {
            this.hjA.setSelected(!this.hjA.isSelected());
            if (this.hjM != null) {
                this.hjM.cg(this.hjA.isSelected());
            }
        } else {
            CustomToast.newInstance().showToast(this.mContext.getResources().getString(a.h.ala_guess_double_ticket_not_enough));
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.guess.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class DialogInterface$OnKeyListenerC0654b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener hka;

        public DialogInterface$OnKeyListenerC0654b(DialogInterface.OnKeyListener onKeyListener) {
            this.hka = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.hka.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gIJ = "";
        private String hjY = "";
        private String hjZ = "";
        private boolean hjK = true;
        private boolean hjL = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener hka = null;
        private c.a hkb = null;

        public a nB(boolean z) {
            this.hjK = z;
            return this;
        }

        public a nC(boolean z) {
            this.hjL = z;
            return this;
        }

        public a uP(int i) {
            this.gravity = i;
            return this;
        }

        public a a(c.a aVar) {
            this.hkb = aVar;
            return this;
        }

        public b aj(Activity activity) {
            this.context = activity;
            b bVar = new b(this, this.context);
            bVar.aqj();
            return bVar;
        }
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketTitle(String str) {
        this.hjQ = str;
        if (TextUtils.isEmpty(this.hjQ)) {
            this.hjQ = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        this.hjB.setText(this.hjQ);
    }

    @Override // com.baidu.live.guess.c
    public void cf(boolean z) {
        this.hjz.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketNumber(int i) {
        this.hjT = i;
        this.hjC.setText(String.format("(剩余%d张)", Integer.valueOf(i)));
        this.hjA.setSelected(i > 0);
        if (this.hjM != null) {
            this.hjM.cg(i > 0);
        }
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketContent(String str) {
        this.hjR = str;
    }

    @Override // com.baidu.live.guess.c
    public void hb(String str) {
        this.hjS = str;
    }

    @Override // com.baidu.live.guess.c
    public int Jg() {
        return this.hjA.isSelected() ? 1 : 0;
    }

    public void bYd() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_poup_double_ticket_tips, (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(a.f.img_tips_icon);
        TextView textView = (TextView) viewGroup.findViewById(a.f.txt_tips_top);
        TextView textView2 = (TextView) viewGroup.findViewById(a.f.txt_tips_number);
        TextView textView3 = (TextView) viewGroup.findViewById(a.f.txt_tips_bottom);
        if (TextUtils.isEmpty(this.hjQ)) {
            this.hjQ = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        if (TextUtils.isEmpty(this.hjR)) {
            this.hjR = this.mContext.getResources().getString(a.h.ala_guess_tip_content);
        }
        textView.setText(this.hjQ);
        textView2.setText(String.format("剩余%d张", Integer.valueOf(this.hjT)));
        textView3.setText(this.hjR);
        PopupWindow popupWindow = new PopupWindow((View) viewGroup, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAsDropDown(this.hjy, -com.baidu.tieba.ala.live.guess.c.b.T(140.0f), 0);
        popupWindow.update();
    }
}
