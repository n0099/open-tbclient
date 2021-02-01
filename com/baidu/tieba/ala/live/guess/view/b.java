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
    private ImageView hhA;
    private LinearLayout hhB;
    private ImageView hhC;
    private TextView hhD;
    private TextView hhE;
    private TextView hhF;
    private TimeCountTextView hhG;
    private MagicProgressCircle hhH;
    private int hhI;
    private String hhJ;
    private String hhK;
    private String hhL;
    private boolean hhM;
    private boolean hhN;
    private c.a hhO;
    private DialogInterface.OnKeyListener hhP;
    private RelativeSizeSpan hhQ;
    private String hhR;
    private String hhS;
    private String hhT;
    private String hhU;
    private int hhV;
    private FrameLayout hhW;
    private View hhX;
    private boolean hhY;
    private ForegroundColorSpan hhe;
    private Dialog hhq;
    private TextView hhr;
    private TextView hhs;
    private TextView hht;
    private TextView hhu;
    private TextView hhv;
    private TextView hhw;
    private RelativeLayout hhx;
    private LinearLayout hhy;
    private ImageView hhz;
    private LinearLayout mContentView;
    private Activity mContext;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private b(a aVar, Activity activity) {
        this.hhI = 30;
        this.mDialogGravity = 17;
        this.hhJ = "";
        this.hhK = "";
        this.hhL = "";
        this.hhM = false;
        this.hhN = false;
        this.hhR = "(本轮奖金";
        this.fiV = true;
        this.hhY = false;
        this.mContext = activity;
        this.hhJ = aVar.gGM;
        this.hhI = aVar.maxCount;
        this.hhK = aVar.hia;
        this.hhL = aVar.hib;
        this.mDialogGravity = aVar.gravity;
        this.hhN = aVar.hhN;
        this.hhM = aVar.hhM;
        this.hhO = aVar.hie;
        this.hhP = aVar.hic;
    }

    public void aqg() {
        if (this.hhO != null) {
            this.hhO.Jf();
            this.hhq = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
            this.hhq.setCancelable(this.hhM);
            this.hhq.setCanceledOnTouchOutside(this.hhN);
            this.hhq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.view.b.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.hhO.onDismiss(dialogInterface);
                }
            });
            Hf();
            bXM();
            bXN();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Hf() {
        Window window = this.hhq.getWindow();
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

    private void bXM() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_dialog, (ViewGroup) null);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.guess_dialog_container);
        this.hhG = (TimeCountTextView) this.mRootView.findViewById(a.f.txt_center_number);
        this.hhH = (MagicProgressCircle) this.mRootView.findViewById(a.f.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.f.dialog_content);
        this.hhr = (TextView) this.mRootView.findViewById(a.f.tv_guess_bonus);
        this.hhs = (TextView) this.mRootView.findViewById(a.f.tv_guess_ques);
        this.hht = (TextView) this.mRootView.findViewById(a.f.tv_guess_success);
        this.hhu = (TextView) this.mRootView.findViewById(a.f.tv_guess_failure);
        this.hhv = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_success);
        this.hhw = (TextView) this.mRootView.findViewById(a.f.tv_guess_team_failure);
        this.hhx = (RelativeLayout) this.mRootView.findViewById(a.f.rl_team_opt);
        this.hhy = (LinearLayout) this.mRootView.findViewById(a.f.ll_single_opt);
        this.hhz = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hhA = (ImageView) this.mRootView.findViewById(a.f.img_guess_help_tips);
        this.hhC = (ImageView) this.mRootView.findViewById(a.f.img_guess_double_checkbox);
        this.hhD = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_title);
        this.hhE = (TextView) this.mRootView.findViewById(a.f.txt_guess_double_number);
        this.hhB = (LinearLayout) this.mRootView.findViewById(a.f.llayout_double_ticket);
        this.hhW = (FrameLayout) this.mRootView.findViewById(a.f.frame_group_container);
        this.hhX = this.mRootView.findViewById(a.f.line1);
        this.hhe = new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.ala_guess_bonus));
        this.hhQ = new RelativeSizeSpan(1.3f);
    }

    private void bXN() {
        com.baidu.tieba.ala.live.guess.c.c.p(this.amz, 318, -2);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhv, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhw, 120, 50);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hht, -1, 50, 10, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.d(this.hhu, -1, 50, 25, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.n(this.hhB, -1, 60);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hhr, 16);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hhs, 20);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.hht.setOnClickListener(this);
        this.hhu.setOnClickListener(this);
        this.hhw.setOnClickListener(this);
        this.hhv.setOnClickListener(this);
        this.hhz.setOnClickListener(this);
        this.hhA.setOnClickListener(this);
        this.hhC.setOnClickListener(this);
        a(new DialogInterface$OnKeyListenerC0647b(this.hhP));
    }

    @Override // com.baidu.live.guess.c
    public void dw(int i) {
        this.hhI = i;
    }

    @Override // com.baidu.live.guess.c
    public boolean isShowing() {
        if (this.hhq != null) {
            return this.hhq.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.c
    public void gS(String str) {
        int length = this.hhR.length();
        this.hhR += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.hhR);
        spannableStringBuilder.setSpan(this.hhe, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.hhQ, length, str.length() + length, 34);
        this.hhr.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.c
    public void gT(String str) {
        this.hht.setText(str);
        this.hhv.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void gU(String str) {
        this.hhu.setText(str);
        this.hhw.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void setQuesContent(String str) {
        this.hhs.setText(str);
    }

    @Override // com.baidu.live.guess.c
    public void show() {
        if (this.hhq == null) {
            aqg();
        }
        if (!isShowing()) {
            this.fiV = true;
            ShowUtil.showDialog(this.hhq, this.mContext);
            this.hhq.setContentView(this.mRootView);
            bXO();
        }
    }

    private void bXO() {
        this.hhH.aA(100.0f).uP(this.hhI * 1000).startAnim();
        this.hhG.a("#CC9E67", this.hhI * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.view.b.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (b.this.hhO != null) {
                    b.this.hhO.onTimeout();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.c
    public void dismiss() {
        if (this.hhq != null && this.hhq.isShowing()) {
            ShowUtil.dismissDialog(this.hhq, this.mContext);
        }
        this.fiV = true;
    }

    public void nA(boolean z) {
        this.fiV = z;
        if (this.hhy.getVisibility() == 0) {
            this.hht.setEnabled(z);
            this.hhu.setEnabled(z);
            return;
        }
        this.hhv.setEnabled(z);
        this.hhw.setEnabled(z);
    }

    @Override // com.baidu.live.guess.c
    public void Ja() {
        this.hhz.setVisibility(0);
        if (this.hhF != null) {
            this.hhF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hhF.setBackgroundResource(a.e.guess_button_choice_background);
            nA(false);
        }
    }

    @Override // com.baidu.live.guess.c
    public void Jb() {
        this.hhG.cancel();
    }

    @Override // com.baidu.live.guess.c
    public void ce(boolean z) {
        this.hhY = z;
        if (z) {
            this.hhX.setVisibility(8);
            this.hhy.setVisibility(0);
            this.hhx.setVisibility(8);
            return;
        }
        this.hhX.setVisibility(0);
        this.hhy.setVisibility(8);
        this.hhx.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public boolean Jc() {
        return this.hhY;
    }

    @Override // com.baidu.live.guess.c
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.hhP = onKeyListener;
        if (this.hhP != null) {
            this.hhq.setOnKeyListener(this.hhP);
        }
    }

    @Override // com.baidu.live.guess.c
    public ViewGroup Je() {
        return this.hhW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.hhN) {
            dismiss();
        } else if (view == this.hht && this.fiV) {
            if (this.hhO != null) {
                this.hhF = (TextView) view;
                this.hhO.a(this);
            }
        } else if (view == this.hhu && this.fiV) {
            if (this.hhO != null) {
                this.hhF = (TextView) view;
                this.hhO.b(this);
            }
        } else if (view == this.hhv && this.fiV) {
            if (this.hhO != null) {
                this.hhF = (TextView) view;
                this.hhO.a(this);
            }
        } else if (view == this.hhw && this.fiV) {
            if (this.hhO != null) {
                this.hhF = (TextView) view;
                this.hhO.b(this);
            }
        } else if (view == this.hhz) {
            this.hhO.onExit();
            Jb();
            dismiss();
        } else if (view == this.hhA) {
            bXQ();
        } else if (view == this.hhC) {
            bXP();
        }
    }

    private void bXP() {
        if (!this.fiV) {
            CustomToast.newInstance().showToast("答题后无法勾选");
        } else if (this.hhV > 0) {
            this.hhC.setSelected(!this.hhC.isSelected());
            if (this.hhO != null) {
                this.hhO.cg(this.hhC.isSelected());
            }
        } else {
            CustomToast.newInstance().showToast(this.mContext.getResources().getString(a.h.ala_guess_double_ticket_not_enough));
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.guess.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class DialogInterface$OnKeyListenerC0647b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener hic;

        public DialogInterface$OnKeyListenerC0647b(DialogInterface.OnKeyListener onKeyListener) {
            this.hic = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.hic.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String gGM = "";
        private String hia = "";
        private String hib = "";
        private boolean hhM = true;
        private boolean hhN = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener hic = null;
        private c.a hie = null;

        public a nB(boolean z) {
            this.hhM = z;
            return this;
        }

        public a nC(boolean z) {
            this.hhN = z;
            return this;
        }

        public a uN(int i) {
            this.gravity = i;
            return this;
        }

        public a a(c.a aVar) {
            this.hie = aVar;
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
        this.hhS = str;
        if (TextUtils.isEmpty(this.hhS)) {
            this.hhS = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        this.hhD.setText(this.hhS);
    }

    @Override // com.baidu.live.guess.c
    public void cf(boolean z) {
        this.hhB.setVisibility(0);
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketNumber(int i) {
        this.hhV = i;
        this.hhE.setText(String.format("(剩余%d张)", Integer.valueOf(i)));
        this.hhC.setSelected(i > 0);
        if (this.hhO != null) {
            this.hhO.cg(i > 0);
        }
    }

    @Override // com.baidu.live.guess.c
    public void setDoubleTicketContent(String str) {
        this.hhT = str;
    }

    @Override // com.baidu.live.guess.c
    public void gV(String str) {
        this.hhU = str;
    }

    @Override // com.baidu.live.guess.c
    public int Jd() {
        return this.hhC.isSelected() ? 1 : 0;
    }

    public void bXQ() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_poup_double_ticket_tips, (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(a.f.img_tips_icon);
        TextView textView = (TextView) viewGroup.findViewById(a.f.txt_tips_top);
        TextView textView2 = (TextView) viewGroup.findViewById(a.f.txt_tips_number);
        TextView textView3 = (TextView) viewGroup.findViewById(a.f.txt_tips_bottom);
        if (TextUtils.isEmpty(this.hhS)) {
            this.hhS = this.mContext.getResources().getString(a.h.ala_guess_tip_title);
        }
        if (TextUtils.isEmpty(this.hhT)) {
            this.hhT = this.mContext.getResources().getString(a.h.ala_guess_tip_content);
        }
        textView.setText(this.hhS);
        textView2.setText(String.format("剩余%d张", Integer.valueOf(this.hhV)));
        textView3.setText(this.hhT);
        PopupWindow popupWindow = new PopupWindow((View) viewGroup, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAsDropDown(this.hhA, -com.baidu.tieba.ala.live.guess.c.b.P(140.0f), 0);
        popupWindow.update();
    }
}
