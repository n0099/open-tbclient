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
/* loaded from: classes11.dex */
public class e implements View.OnClickListener, com.baidu.tieba.ala.live.guess.result.b {
    private ab hfW;
    private ImageView hhN;
    private HorizontalProgressBar hiA;
    private TextView hiB;
    private ImageView hiC;
    private RelativeLayout hiD;
    private RelativeLayout hiE;
    private LinearLayout hiF;
    private TextView hiG;
    private ImageView hiH;
    private Space hiI;
    private FrameLayout hiJ;
    private TextView hiK;
    private TextView hiL;
    private com.baidu.tieba.ala.live.guess.result.a hiM;
    private AlaGuessGroupBottomView hiN;
    private o hiO;
    private TextView hiw;
    private TextView hiz;
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
        Hf();
        initView();
        ED();
    }

    private void Hf() {
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

    private void ED() {
        this.hhN.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_result_dialog, (ViewGroup) null);
        this.hiD = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hiz = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.hiB = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.hiw = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.hhN = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hiC = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.hiA = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
        this.hiE = (RelativeLayout) this.mRootView.findViewById(a.f.rlayout_guess_no_double_ticket);
        this.hiF = (LinearLayout) this.mRootView.findViewById(a.f.llayout_guess_have_double_ticket);
        this.hiG = (TextView) this.mRootView.findViewById(a.f.txt_double_ticket_group);
        this.hiH = (ImageView) this.mRootView.findViewById(a.f.img_double_ticket_single);
        this.hiI = (Space) this.mRootView.findViewById(a.f.space_double_ticket_single);
        this.hiK = (TextView) this.mRootView.findViewById(a.f.txt_left_average);
        this.hiL = (TextView) this.mRootView.findViewById(a.f.txt_right_average);
        this.hiJ = (FrameLayout) this.mRootView.findViewById(a.f.flayout_guess_result_bottom_container);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhN) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !this.mContext.isFinishing() && this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mContext);
            this.mDialog.setContentView(this.mRootView);
            this.hiM = new com.baidu.tieba.ala.live.guess.result.a();
            this.hiM.a(this.mContext, this);
            this.hiM.a(this.hiO, this.hfW);
        }
    }

    public void dismiss() {
        ShowUtil.dismissDialog(this.mDialog, this.mContext);
    }

    public void c(o oVar, ab abVar) {
        this.hiO = oVar;
        this.hfW = abVar;
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void f(SpannableStringBuilder spannableStringBuilder) {
        if (this.hiz != null) {
            this.hiz.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uI(int i) {
        if (this.hiC != null) {
            this.hiC.setImageResource(i);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void He(String str) {
        if (this.hiw != null) {
            this.hiw.setText(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hf(String str) {
        if (this.hiA != null) {
            this.hiA.setLeftFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hg(String str) {
        if (this.hiA != null) {
            this.hiA.setRightFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void g(SpannableStringBuilder spannableStringBuilder) {
        if (this.hiK != null) {
            this.hiK.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void h(SpannableStringBuilder spannableStringBuilder) {
        if (this.hiL != null) {
            this.hiL.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(StringBuilder sb) {
        if (this.hiB != null) {
            this.hiB.setText(sb);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void nw(boolean z) {
        if (this.hiA != null) {
            this.hiA.nD(z);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void bJ(int i, int i2) {
        if (this.hiA != null) {
            this.hiA.bK(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uJ(int i) {
        if (i == 1) {
            this.hiD.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            this.hiE.setVisibility(0);
            this.hiF.setVisibility(8);
        } else if (i == 2) {
            this.hiD.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            this.hiE.setVisibility(8);
            this.hiF.setVisibility(0);
            this.hiG.setVisibility(8);
            this.hiH.setVisibility(0);
            this.hiI.setVisibility(0);
        } else if (i == 5) {
            this.hiD.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            ay(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hiE.setVisibility(0);
            this.hiF.setVisibility(8);
            if (this.hiN != null) {
                this.hiN.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        } else if (i == 4) {
            this.hiD.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            ay(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hiE.setVisibility(8);
            this.hiF.setVisibility(0);
            this.hiG.setVisibility(0);
            this.hiH.setVisibility(8);
            this.hiI.setVisibility(8);
            if (this.hiN != null) {
                this.hiN.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        }
    }

    private void ay(float f) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hiJ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = (int) f;
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void k(int i, List<o.b> list) {
        if (this.hiJ != null) {
            this.hiJ.removeAllViews();
            this.hiN = new AlaGuessGroupBottomView(this.mContext);
            this.hiN.setData(i, list);
            this.hiN.setUIStyle();
            this.hiJ.addView(this.hiN);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(o.c cVar, boolean z, String str) {
        if (this.hiJ != null && this.hiD != null) {
            this.hiJ.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.2
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abu() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXQ();
                }
            });
            this.hiJ.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setData(cVar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hiD.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void u(boolean z, String str) {
        if (this.hiJ != null && this.hiD != null) {
            this.hiJ.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.3
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abu() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXQ();
                }
            });
            this.hiJ.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setSpecialUI();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hiD.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uK(int i) {
        if (this.hiG != null) {
            this.hiG.setText(String.format("x%d倍", Integer.valueOf(i)));
        }
    }
}
