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
/* loaded from: classes11.dex */
public class b implements View.OnClickListener, com.baidu.live.guess.c {
    private static final String TAG = b.class.getSimpleName();
    private RelativeLayout amz;
    private boolean fiV;
    private Dialog hhE;
    private TextView hhF;
    private TextView hhG;
    private TextView hhH;
    private TextView hhI;
    private TextView hhJ;
    private TextView hhK;
    private RelativeLayout hhL;
    private LinearLayout hhM;
    private ImageView hhN;
    private ImageView hhO;
    private LinearLayout hhP;
    private ImageView hhQ;
    private TextView hhR;
    private TextView hhS;
    private TextView hhT;
    private TimeCountTextView hhU;
    private MagicProgressCircle hhV;
    private int hhW;
    private String hhX;
    private String hhY;
    private String hhZ;
    private ForegroundColorSpan hhs;
    private boolean hia;
    private boolean hib;
    private c.a hic;
    private DialogInterface.OnKeyListener hie;
    private RelativeSizeSpan hif;
    private String hig;
    private String hih;
    private String hii;
    private String hij;
    private int hik;
    private FrameLayout hil;
    private View him;
    private boolean hin;
    private LinearLayout mContentView;
    private Activity mContext;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private b(a aVar, Activity activity) {
        this.hhW = 30;
        this.mDialogGravity = 17;
        this.hhX = "";
        this.hhY = "";
        this.hhZ = "";
        this.hia = false;
        this.hib = false;
        this.hig = "(本轮奖金";
        this.fiV = true;
        this.hin = false;
        this.mContext = activity;
        this.hhX = aVar.gHa;
        this.hhW = aVar.maxCount;
        this.hhY = aVar.hip;
        this.hhZ = aVar.hiq;
        this.mDialogGravity = aVar.gravity;
        this.hib = aVar.hib;
        this.hia = aVar.hia;
        this.hic = aVar.his;
        this.hie = aVar.hir;
    }

    public void aqg() {
        if (this.hic != null) {
            this.hic.Jf();
            this.hhE = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
            this.hhE.setCancelable(this.hia);
            this.hhE.setCanceledOnTouchOutside(this.hib);
            this.hhE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.view.b.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.hic.onDismiss(dialogInterface);
                }
            });
            Hf();
            bXT();
            bXU();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Hf() {
        Window window = this.hhE.getWindow();
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

    private void bXT() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.guess_dialog_container);
        this.hhU = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.hhV = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.hhF = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.hhG = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.hhH = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.hhI = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.hhJ = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_success);
        this.hhK = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_failure);
        this.hhL = (RelativeLayout) this.mRootView.findViewById(a.f.rl_team_opt);
        this.hhM = (LinearLayout) this.mRootView.findViewById(a.f.ll_single_opt);
        this.hhN = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hhO = (ImageView) this.mRootView.findViewById(a.f.img_guess_help_tips);
        this.hhQ = (ImageView) this.mRootView.findViewById(a.f.img_guess_double_checkbox);
        this.hhR = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_title);
        this.hhS = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_number);
        this.hhP = (LinearLayout) this.mRootView.findViewById(a.f.llayout_double_ticket);
        this.hil = (FrameLayout) this.mRootView.findViewById(a.f.frame_group_container);
        this.him = this.mRootView.findViewById(a.f.line1);
        this.hhs = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        this.hif = new RelativeSizeSpan(1.3f);
    }

    private void bXU() {
        com.baidu.tieba.ala.live.guess.c.c.p(this.amz, 318, -2);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhJ, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhK, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hhH, -1, 50, 10, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hhI, -1, 50, 25, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhP, -1, 60);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hhF, 16);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hhG, 20);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.hhH.setOnClickListener(this);
        this.hhI.setOnClickListener(this);
        this.hhK.setOnClickListener(this);
        this.hhJ.setOnClickListener(this);
        this.hhN.setOnClickListener(this);
        this.hhO.setOnClickListener(this);
        this.hhQ.setOnClickListener(this);
        a(new DialogInterface$OnKeyListenerC0648b(this.hie));
    }

    @Override // com.baidu.live.guess.c
    public void dw(int i) {
        this.hhW = i;
    }

    @Override // com.baidu.live.guess.c
    public boolean isShowing() {
        if (this.hhE != null) {
            return this.hhE.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.c
    public void gS(String str) {
        int length = this.hig.length();
        this.hig += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hig);
        spannableStringBuilder.setSpan(this.hhs, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.hif, length, str.length() + length, 34);
        this.hhF.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.c
    public void gT(String str) {
        this.hhH.setText(str);
        this.hhJ.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void gU(String str) {
        this.hhI.setText(str);
        this.hhK.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void setQuesContent(String str) {
        this.hhG.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void show() {
        if (this.hhE == null) {
            aqg();
        }
        if (!isShowing()) {
            this.fiV = true;
            ShowUtil.showDialog(this.hhE, this.mContext);
            this.hhE.setContentView(this.mRootView);
            bXV();
        }
    }

    private void bXV() {
        this.hhV.aA(100.0f).uP(this.hhW * 1000).startAnim();
        this.hhU.a("#CC9E67", this.hhW * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.view.b.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (b.this.hic != null) {
                    b.this.hic.onTimeout();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.c
    public void dismiss() {
        if (this.hhE != null && this.hhE.isShowing()) {
            ShowUtil.dismissDialog(this.hhE, this.mContext);
        }
        this.fiV = true;
    }

    public void nA(boolean z) {
        this.fiV = z;
        if (this.hhM.getVisibility() == 0) {
            this.hhH.setEnabled(z);
            this.hhI.setEnabled(z);
            return;
        }
        this.hhJ.setEnabled(z);
        this.hhK.setEnabled(z);
    }

    @Override // com.baidu.live.guess.c
    public void Ja() {
        this.hhN.setVisibility(0);
        if (this.hhT != null) {
            this.hhT.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hhT.setBackgroundResource(a.e.guess_button_choice_background);
            nA(false);
        }
    }

    @Override // com.baidu.live.guess.c
    public void Jb() {
        this.hhU.cancel();
    }

    @Override // com.baidu.live.guess.c
    public void ce(boolean z) {
        this.hin = z;
        if (z) {
            this.him.setVisibility(8);
            this.hhM.setVisibility(0);
            this.hhL.setVisibility(8);
            return;
        }
        this.him.setVisibility(0);
        this.hhM.setVisibility(8);
        this.hhL.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public boolean Jc() {
        return this.hin;
    }

    @Override // com.baidu.live.guess.c
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.hie = onKeyListener;
        if (this.hie != null) {
            this.hhE.setOnKeyListener(this.hie);
        }
    }

    @Override // com.baidu.live.guess.c
    public ViewGroup Je() {
        return this.hil;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.hib) {
            dismiss();
        } else if (view == this.hhH && this.fiV) {
            if (this.hic != null) {
                this.hhT = (TextView) view;
                this.hic.a(this);
            }
        } else if (view == this.hhI && this.fiV) {
            if (this.hic != null) {
                this.hhT = (TextView) view;
                this.hic.b(this);
            }
        } else if (view == this.hhJ && this.fiV) {
            if (this.hic != null) {
                this.hhT = (TextView) view;
                this.hic.a(this);
            }
        } else if (view == this.hhK && this.fiV) {
            if (this.hic != null) {
                this.hhT = (TextView) view;
                this.hic.b(this);
            }
        } else if (view == this.hhN) {
            this.hic.onExit();
            Jb();
            dismiss();
        } else if (view == this.hhO) {
            bXX();
        } else if (view == this.hhQ) {
            bXW();
        }
    }

    private void bXW() {
        if (!this.fiV) {
            CustomToast.newInstance().showToast("答题后无法勾选");
        } else if (this.hik > 0) {
            this.hhQ.setSelected(!this.hhQ.isSelected());
            if (this.hic != null) {
                this.hic.cg(this.hhQ.isSelected());
            }
        } else {
            CustomToast.newInstance().showToast(this.mContext.getResources().getString(a.h.ala_guess_double_ticket_not_enough));
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.guess.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class DialogInterface$OnKeyListenerC0648b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener hir;

        public DialogInterface$OnKeyListenerC0648b(DialogInterface.OnKeyListener onKeyListener) {
            this.hir = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.hir.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gHa = "";
        private String hip = "";
        private String hiq = "";
        private boolean hia = true;
        private boolean hib = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener hir = null;
        private c.a his = null;

        public a nB(boolean z) {
            this.hia = z;
            return this;
        }

        public a nC(boolean z) {
            this.hib = z;
            return this;
        }

        public a uN(int i) {
            this.gravity = i;
            return this;
        }

        public a a(c.a aVar) {
            this.his = aVar;
            return this;
        }

        public b aj(Activity activity) {
            this.context = activity;
            b bVar = new b(this, this.context);
            bVar.aqg();
            return bVar;
        }
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketTitle(String str) {
        this.hih = str;
        if (TextUtils.isEmpty(this.hih)) {
            this.hih = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        this.hhR.setText(this.hih);
    }

    @Override // com.baidu.live.guess.c
    public void cf(boolean z) {
        this.hhP.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketNumber(int i) {
        this.hik = i;
        this.hhS.setText(String.format("(剩余%d张)", Integer.valueOf(i)));
        this.hhQ.setSelected(i > 0);
        if (this.hic != null) {
            this.hic.cg(i > 0);
        }
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketContent(String str) {
        this.hii = str;
    }

    @Override // com.baidu.live.guess.c
    public void gV(String str) {
        this.hij = str;
    }

    @Override // com.baidu.live.guess.c
    public int Jd() {
        return this.hhQ.isSelected() ? 1 : 0;
    }

    public void bXX() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_poup_double_ticket_tips, (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(a.f.img_tips_icon);
        TextView textView = (TextView) viewGroup.findViewById(a.f.txt_tips_top);
        TextView textView2 = (TextView) viewGroup.findViewById(a.f.txt_tips_number);
        TextView textView3 = (TextView) viewGroup.findViewById(a.f.txt_tips_bottom);
        if (TextUtils.isEmpty(this.hih)) {
            this.hih = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        if (TextUtils.isEmpty(this.hii)) {
            this.hii = this.mContext.getResources().getString(a.h.ala_guess_tip_content);
        }
        textView.setText(this.hih);
        textView2.setText(String.format("剩余%d张", Integer.valueOf(this.hik)));
        textView3.setText(this.hii);
        PopupWindow popupWindow = new PopupWindow((View) viewGroup, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAsDropDown(this.hhO, -com.baidu.tieba.ala.live.guess.c.b.P(140.0f), 0);
        popupWindow.update();
    }
}
