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
    private Activity bFt;
    private boolean eGO;
    private ImageView gvQ;
    private ForegroundColorSpan gvS;
    private TextView gvV;
    private Dialog gwi;
    private TextView gwj;
    private TextView gwk;
    private TextView gwl;
    private TextView gwm;
    private TextView gwn;
    private TimeCountTextView gwo;
    private MagicProgressCircle gwp;
    private int gwq;
    private String gwr;
    private String gws;
    private String gwt;
    private boolean gwu;
    private boolean gwv;
    private b.a gww;
    private DialogInterface.OnKeyListener gwx;
    private RelativeSizeSpan gwy;
    private String gwz;
    private LinearLayout mContentView;
    private int mDialogGravity;
    private ViewGroup mRootView;

    private c(a aVar, Activity activity) {
        this.gwq = 30;
        this.mDialogGravity = 17;
        this.gwr = "";
        this.gws = "";
        this.gwt = "";
        this.gwu = true;
        this.gwv = false;
        this.gwz = "(本轮奖金";
        this.eGO = true;
        this.bFt = activity;
        this.gwr = aVar.fZV;
        this.gwq = aVar.maxCount;
        this.gws = aVar.gwB;
        this.gwt = aVar.gwC;
        this.mDialogGravity = aVar.gravity;
        this.gwv = aVar.gwv;
        this.gwu = aVar.gwu;
        this.gww = aVar.gwE;
        this.gwx = aVar.gwD;
    }

    public void alq() {
        if (this.gww != null) {
            this.gww.JW();
            this.gwi = new AlertDialog.Builder(this.bFt, a.j.guess_theme_dialog).create();
            this.gwi.setCancelable(this.gwu);
            this.gwi.setCanceledOnTouchOutside(this.gwv);
            this.gwi.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.live.guess.a.c.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    c.this.gww.onDismiss(dialogInterface);
                }
            });
            if (this.gwx != null) {
                this.gwi.setOnKeyListener(this.gwx);
            }
            Og();
            bPD();
            registerListener();
            return;
        }
        throw new IllegalArgumentException("Must set dialog listener");
    }

    private void Og() {
        Window window = this.gwi.getWindow();
        window.setGravity(this.mDialogGravity);
        window.setWindowAnimations(a.j.sdk_dialog_windowanim);
        window.setBackgroundDrawableResource(a.f.sdk_transparent_bg);
        if (window.getWindowManager() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.65f;
            if (UtilHelper.getRealScreenOrientation(this.bFt) == 2) {
                attributes.width = ScreenHelper.getRealScreenHeight(this.bFt);
                attributes.height = -1;
            } else {
                attributes.width = -1;
                attributes.height = ScreenHelper.getRealScreenHeight(this.bFt) - UtilHelper.getStatusBarHeight();
            }
            window.setAttributes(attributes);
        }
    }

    private void bPD() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.bFt).inflate(a.h.ala_guess_dialog, (ViewGroup) null);
        this.gwo = (TimeCountTextView) this.mRootView.findViewById(a.g.txt_center_number);
        this.gwp = (MagicProgressCircle) this.mRootView.findViewById(a.g.circle_guess_progress);
        this.mContentView = (LinearLayout) this.mRootView.findViewById(a.g.dialog_content);
        this.gwj = (TextView) this.mRootView.findViewById(a.g.tv_guess_bonus);
        this.gwk = (TextView) this.mRootView.findViewById(a.g.tv_guess_ques);
        this.gwl = (TextView) this.mRootView.findViewById(a.g.tv_guess_success);
        this.gwm = (TextView) this.mRootView.findViewById(a.g.tv_guess_failure);
        this.gvV = (TextView) this.mRootView.findViewById(a.g.tv_guess_notify);
        this.gvQ = (ImageView) this.mRootView.findViewById(a.g.img_exit);
        this.gvS = new ForegroundColorSpan(this.bFt.getResources().getColor(a.d.ala_guess_bonus));
        this.gwy = new RelativeSizeSpan(1.3f);
    }

    private void registerListener() {
        this.mContentView.setOnClickListener(this);
        this.gwl.setOnClickListener(this);
        this.gwm.setOnClickListener(this);
        this.gvQ.setOnClickListener(this);
        a(new b(this.gwx));
    }

    @Override // com.baidu.live.guess.b
    public void eG(int i) {
        this.gwq = i;
    }

    @Override // com.baidu.live.guess.b
    public boolean isShowing() {
        if (this.gwi != null) {
            return this.gwi.isShowing();
        }
        return false;
    }

    @Override // com.baidu.live.guess.b
    public void hm(String str) {
        int length = this.gwz.length();
        this.gwz += str + "元)";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.gwz);
        spannableStringBuilder.setSpan(this.gvS, length, str.length() + length, 34);
        spannableStringBuilder.setSpan(this.gwy, length, str.length() + length, 34);
        this.gwj.setText(spannableStringBuilder);
    }

    @Override // com.baidu.live.guess.b
    public void hn(String str) {
        this.gwl.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void ho(String str) {
        this.gwm.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void setQuesContent(String str) {
        this.gwk.setText(str);
    }

    @Override // com.baidu.live.guess.b
    public void show() {
        if (this.gwi == null) {
            alq();
        }
        if (!isShowing()) {
            this.eGO = true;
            ShowUtil.showDialog(this.gwi, this.bFt);
            this.gwi.setContentView(this.mRootView);
            bPE();
        }
    }

    private void bPE() {
        this.gwp.ap(100.0f).us(this.gwq * 1000).startAnim();
        this.gwo.a(this.gwq * 1000, IMConnection.RETRY_DELAY_TIMES, new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.a.c.2
            @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
            public void onFinish() {
                if (c.this.gww != null) {
                    c.this.gww.JX();
                }
            }
        });
    }

    @Override // com.baidu.live.guess.b
    public void dismiss() {
        if (this.gwi != null && this.gwi.isShowing()) {
            ShowUtil.dismissDialog(this.gwi, this.bFt);
        }
        this.eGO = true;
    }

    public void lX(boolean z) {
        this.eGO = z;
        this.gwl.setEnabled(z);
        this.gwm.setEnabled(z);
    }

    @Override // com.baidu.live.guess.b
    public void JU() {
        this.gvQ.setVisibility(0);
        if (this.gwn != null) {
            this.gwn.setTextColor(this.bFt.getResources().getColor(a.d.sdk_white_alpha100));
            this.gwn.setBackgroundResource(a.f.guess_button_choice_background);
            lX(false);
        }
    }

    @Override // com.baidu.live.guess.b
    public void JV() {
        this.gwo.cancel();
    }

    @Override // com.baidu.live.guess.b
    public void a(DialogInterface.OnKeyListener onKeyListener) {
        this.gwx = onKeyListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mContentView && this.gwv) {
            dismiss();
        } else if (view == this.gwl && this.eGO) {
            if (this.gww != null) {
                this.gwn = (TextView) view;
                this.gww.a(this);
            }
        } else if (view == this.gwm && this.eGO) {
            if (this.gww != null) {
                this.gwn = (TextView) view;
                this.gww.b(this);
            }
        } else if (view == this.gvQ) {
            this.gww.onExit();
            JV();
            dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements DialogInterface.OnKeyListener {
        private DialogInterface.OnKeyListener gwD;

        public b(DialogInterface.OnKeyListener onKeyListener) {
            this.gwD = onKeyListener;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                this.gwD.onKey(dialogInterface, i, keyEvent);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        private Activity context;
        private int maxCount = 30;
        private String fZV = "";
        private String gwB = "";
        private String gwC = "";
        private boolean gwu = true;
        private boolean gwv = false;
        private int gravity = 17;
        private DialogInterface.OnKeyListener gwD = null;
        private b.a gwE = null;

        public a lY(boolean z) {
            this.gwu = z;
            return this;
        }

        public a lZ(boolean z) {
            this.gwv = z;
            return this;
        }

        public a uq(int i) {
            this.gravity = i;
            return this;
        }

        public a a(b.a aVar) {
            this.gwE = aVar;
            return this;
        }

        public c an(Activity activity) {
            this.context = activity;
            c cVar = new c(this, this.context);
            cVar.alq();
            return cVar;
        }
    }
}
