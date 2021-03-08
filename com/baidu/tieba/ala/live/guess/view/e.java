package com.baidu.tieba.ala.live.guess.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.data.ab;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.live.guess.result.AlaGuessGroupBottomView;
import com.baidu.tieba.ala.live.guess.result.AlaGuessSingleBottomCenterView;
import com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView;
import com.baidu.tieba.ala.live.guess.widget.HorizontalProgressBar;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements View.OnClickListener, com.baidu.tieba.ala.live.guess.result.b {
    private ab hhF;
    private ImageView hjx;
    private TextView hkf;
    private TextView hki;
    private HorizontalProgressBar hkj;
    private TextView hkk;
    private ImageView hkl;
    private RelativeLayout hkm;
    private RelativeLayout hkn;
    private LinearLayout hko;
    private TextView hkp;
    private ImageView hkq;
    private Space hkr;
    private FrameLayout hks;
    private TextView hkt;
    private TextView hku;
    private com.baidu.tieba.ala.live.guess.result.a hkv;
    private AlaGuessGroupBottomView hkw;
    private o hkx;
    private Activity mContext;
    private Dialog mDialog;
    private View mRootView;

    public e(Activity activity) {
        this.mContext = activity;
        initDialog();
    }

    private void initDialog() {
        this.mDialog = new AlertDialog.Builder(this.mContext, a.i.guess_theme_dialog).create();
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(false);
        Hi();
        initView();
        EG();
    }

    private void Hi() {
        if (this.mDialog != null) {
            Window window = this.mDialog.getWindow();
            window.setGravity(17);
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
    }

    private void EG() {
        this.hjx.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_result_dialog, (ViewGroup) null);
        this.hkm = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hki = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.hkk = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.hkf = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.hjx = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hkl = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.hkj = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
        this.hkn = (RelativeLayout) this.mRootView.findViewById(a.f.rlayout_guess_no_double_ticket);
        this.hko = (LinearLayout) this.mRootView.findViewById(a.f.llayout_guess_have_double_ticket);
        this.hkp = (TextView) this.mRootView.findViewById(a.f.txt_double_ticket_group);
        this.hkq = (ImageView) this.mRootView.findViewById(a.f.img_double_ticket_single);
        this.hkr = (Space) this.mRootView.findViewById(a.f.space_double_ticket_single);
        this.hkt = (TextView) this.mRootView.findViewById(a.f.txt_left_average);
        this.hku = (TextView) this.mRootView.findViewById(a.f.txt_right_average);
        this.hks = (FrameLayout) this.mRootView.findViewById(a.f.flayout_guess_result_bottom_container);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hjx) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !this.mContext.isFinishing() && this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mContext);
            this.mDialog.setContentView(this.mRootView);
            this.hkv = new com.baidu.tieba.ala.live.guess.result.a();
            this.hkv.a(this.mContext, this);
            this.hkv.a(this.hkx, this.hhF);
        }
    }

    public void dismiss() {
        ShowUtil.dismissDialog(this.mDialog, this.mContext);
    }

    public void c(o oVar, ab abVar) {
        this.hkx = oVar;
        this.hhF = abVar;
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void f(SpannableStringBuilder spannableStringBuilder) {
        if (this.hki != null) {
            this.hki.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uK(int i) {
        if (this.hkl != null) {
            this.hkl.setImageResource(i);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hn(String str) {
        if (this.hkf != null) {
            this.hkf.setText(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Ho(String str) {
        if (this.hkj != null) {
            this.hkj.setLeftFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hp(String str) {
        if (this.hkj != null) {
            this.hkj.setRightFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void g(SpannableStringBuilder spannableStringBuilder) {
        if (this.hkt != null) {
            this.hkt.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void h(SpannableStringBuilder spannableStringBuilder) {
        if (this.hku != null) {
            this.hku.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(StringBuilder sb) {
        if (this.hkk != null) {
            this.hkk.setText(sb);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void nw(boolean z) {
        if (this.hkj != null) {
            this.hkj.nD(z);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void bJ(int i, int i2) {
        if (this.hkj != null) {
            this.hkj.bK(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uL(int i) {
        if (i == 1) {
            this.hkm.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            this.hkn.setVisibility(0);
            this.hko.setVisibility(8);
        } else if (i == 2) {
            this.hkm.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            this.hkn.setVisibility(8);
            this.hko.setVisibility(0);
            this.hkp.setVisibility(8);
            this.hkq.setVisibility(0);
            this.hkr.setVisibility(0);
        } else if (i == 5) {
            this.hkm.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            aC(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hkn.setVisibility(0);
            this.hko.setVisibility(8);
            if (this.hkw != null) {
                this.hkw.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        } else if (i == 4) {
            this.hkm.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            aC(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hkn.setVisibility(8);
            this.hko.setVisibility(0);
            this.hkp.setVisibility(0);
            this.hkq.setVisibility(8);
            this.hkr.setVisibility(8);
            if (this.hkw != null) {
                this.hkw.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        }
    }

    private void aC(float f) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hks.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = (int) f;
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void k(int i, List<o.b> list) {
        if (this.hks != null) {
            this.hks.removeAllViews();
            this.hkw = new AlaGuessGroupBottomView(this.mContext);
            this.hkw.setData(i, list);
            this.hkw.setUIStyle();
            this.hks.addView(this.hkw);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(o.c cVar, boolean z, String str) {
        if (this.hks != null && this.hkm != null) {
            this.hks.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.2
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abx() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXW();
                }
            });
            this.hks.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setData(cVar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hkm.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void u(boolean z, String str) {
        if (this.hks != null && this.hkm != null) {
            this.hks.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.3
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abx() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXW();
                }
            });
            this.hks.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setSpecialUI();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hkm.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uM(int i) {
        if (this.hkp != null) {
            this.hkp.setText(String.format("x%d倍", Integer.valueOf(i)));
        }
    }
}
