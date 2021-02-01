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
    private ab hfI;
    private ImageView hhz;
    private o hiA;
    private TextView hii;
    private TextView hil;
    private HorizontalProgressBar him;
    private TextView hin;
    private ImageView hio;
    private RelativeLayout hip;
    private RelativeLayout hiq;
    private LinearLayout hir;
    private TextView his;
    private ImageView hit;
    private Space hiu;
    private FrameLayout hiv;
    private TextView hiw;
    private TextView hix;
    private com.baidu.tieba.ala.live.guess.result.a hiy;
    private AlaGuessGroupBottomView hiz;
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
        this.hhz.setOnClickListener(this);
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_guess_result_dialog, (ViewGroup) null);
        this.hip = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hil = (TextView) this.mRootView.findViewById(a.f.tv_average);
        this.hin = (TextView) this.mRootView.findViewById(a.f.tv_notify);
        this.hii = (TextView) this.mRootView.findViewById(a.f.tv_guess_cong);
        this.hhz = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hio = (ImageView) this.mRootView.findViewById(a.f.img_crown);
        this.him = (HorizontalProgressBar) this.mRootView.findViewById(a.f.progress_horizontal);
        this.hiq = (RelativeLayout) this.mRootView.findViewById(a.f.rlayout_guess_no_double_ticket);
        this.hir = (LinearLayout) this.mRootView.findViewById(a.f.llayout_guess_have_double_ticket);
        this.his = (TextView) this.mRootView.findViewById(a.f.txt_double_ticket_group);
        this.hit = (ImageView) this.mRootView.findViewById(a.f.img_double_ticket_single);
        this.hiu = (Space) this.mRootView.findViewById(a.f.space_double_ticket_single);
        this.hiw = (TextView) this.mRootView.findViewById(a.f.txt_left_average);
        this.hix = (TextView) this.mRootView.findViewById(a.f.txt_right_average);
        this.hiv = (FrameLayout) this.mRootView.findViewById(a.f.flayout_guess_result_bottom_container);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhz) {
            dismiss();
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !this.mContext.isFinishing() && this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mContext);
            this.mDialog.setContentView(this.mRootView);
            this.hiy = new com.baidu.tieba.ala.live.guess.result.a();
            this.hiy.a(this.mContext, this);
            this.hiy.a(this.hiA, this.hfI);
        }
    }

    public void dismiss() {
        ShowUtil.dismissDialog(this.mDialog, this.mContext);
    }

    public void c(o oVar, ab abVar) {
        this.hiA = oVar;
        this.hfI = abVar;
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void f(SpannableStringBuilder spannableStringBuilder) {
        if (this.hil != null) {
            this.hil.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uI(int i) {
        if (this.hio != null) {
            this.hio.setImageResource(i);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hd(String str) {
        if (this.hii != null) {
            this.hii.setText(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void He(String str) {
        if (this.him != null) {
            this.him.setLeftFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void Hf(String str) {
        if (this.him != null) {
            this.him.setRightFirstString(str);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void g(SpannableStringBuilder spannableStringBuilder) {
        if (this.hiw != null) {
            this.hiw.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void h(SpannableStringBuilder spannableStringBuilder) {
        if (this.hix != null) {
            this.hix.setText(spannableStringBuilder);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(StringBuilder sb) {
        if (this.hin != null) {
            this.hin.setText(sb);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void nw(boolean z) {
        if (this.him != null) {
            this.him.nD(z);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void bI(int i, int i2) {
        if (this.him != null) {
            this.him.bJ(i, i2);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uJ(int i) {
        if (i == 1) {
            this.hip.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            this.hiq.setVisibility(0);
            this.hir.setVisibility(8);
        } else if (i == 2) {
            this.hip.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            this.hiq.setVisibility(8);
            this.hir.setVisibility(0);
            this.his.setVisibility(8);
            this.hit.setVisibility(0);
            this.hiu.setVisibility(0);
        } else if (i == 5) {
            this.hip.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds720);
            ay(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hiq.setVisibility(0);
            this.hir.setVisibility(8);
            if (this.hiz != null) {
                this.hiz.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        } else if (i == 4) {
            this.hip.getLayoutParams().height = (int) this.mContext.getResources().getDimension(a.d.sdk_ds740);
            ay(this.mContext.getResources().getDimension(a.d.sdk_ds40));
            this.hiq.setVisibility(8);
            this.hir.setVisibility(0);
            this.his.setVisibility(0);
            this.hit.setVisibility(8);
            this.hiu.setVisibility(8);
            if (this.hiz != null) {
                this.hiz.setLeftRightMarging(this.mContext.getResources().getDimension(a.d.sdk_ds48));
            }
        }
    }

    private void ay(float f) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hiv.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = (int) f;
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void k(int i, List<o.b> list) {
        if (this.hiv != null) {
            this.hiv.removeAllViews();
            this.hiz = new AlaGuessGroupBottomView(this.mContext);
            this.hiz.setData(i, list);
            this.hiz.setUIStyle();
            this.hiv.addView(this.hiz);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void a(o.c cVar, boolean z, String str) {
        if (this.hiv != null && this.hip != null) {
            this.hiv.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.2
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abu() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXJ();
                }
            });
            this.hiv.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setData(cVar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hip.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void u(boolean z, String str) {
        if (this.hiv != null && this.hip != null) {
            this.hiv.removeAllViews();
            AlaGuessSingleJoinGroupButtonView alaGuessSingleJoinGroupButtonView = new AlaGuessSingleJoinGroupButtonView(this.mContext);
            alaGuessSingleJoinGroupButtonView.setData(z, str);
            alaGuessSingleJoinGroupButtonView.setOnClickJoinButtonListener(new AlaGuessSingleJoinGroupButtonView.a() { // from class: com.baidu.tieba.ala.live.guess.view.e.3
                @Override // com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.a
                public void abu() {
                    e.this.dismiss();
                    com.baidu.tieba.ala.live.guess.result.c.bXJ();
                }
            });
            this.hiv.addView(alaGuessSingleJoinGroupButtonView);
            AlaGuessSingleBottomCenterView alaGuessSingleBottomCenterView = new AlaGuessSingleBottomCenterView(this.mContext);
            alaGuessSingleBottomCenterView.setSpecialUI();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.hip.addView(alaGuessSingleBottomCenterView, layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.live.guess.result.b
    public void uK(int i) {
        if (this.his != null) {
            this.his.setText(String.format("x%d倍", Integer.valueOf(i)));
        }
    }
}
