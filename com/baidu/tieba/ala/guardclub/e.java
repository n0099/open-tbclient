package com.baidu.tieba.ala.guardclub;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ak;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atom.GuardClubRankActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubMemberListActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes3.dex */
public class e implements View.OnClickListener {
    private com.baidu.live.k.c aFy;
    private com.baidu.live.guardclub.a aIR;
    private String aIS;
    private boolean aIU;
    private Activity activity;
    private long apl;
    private boolean aqL;
    private String azz;
    private int cCF;
    private ViewTreeObserver.OnGlobalLayoutListener eIH;
    private ImageView fjA;
    private ImageView fjB;
    private LinearLayout fjC;
    private GuardClubInfoHeaderView fjD;
    private RelativeLayout fjE;
    private RelativeLayout fjF;
    private TextView fjG;
    private LinearLayout fjH;
    private FrameLayout fjI;
    private RelativeLayout fjJ;
    private ImageView fjK;
    private j fjL;
    private Bitmap fjM;
    private Bitmap fjN;
    private EditText fjO;
    private TextView fjP;
    private TextView fjQ;
    private CommonEmptyView fjR;
    private LinearLayout fjS;
    private LinearLayout fjT;
    private String fjf;
    private boolean fjl;
    private View.OnClickListener fjn;
    private GuardClubInfoActivity fjq;
    private View fjr;
    private View fjs;
    private View fjt;
    private View fju;
    private int fjv;
    private int fjw;
    private View fjx;
    private LinearLayout fjy;
    private RelativeLayout fjz;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eIG = true;
    private boolean aCe = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.fjq = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.apl = j;
        this.liveId = j2;
        this.roomId = j3;
        this.azz = str;
        this.aqL = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aIU = z3;
        this.fjl = z4;
        this.fjf = str3;
        this.isTranslucent = z5;
        this.fjn = onClickListener;
        if (!z3) {
            if (this.aFy == null) {
                this.aFy = new com.baidu.live.k.c();
            }
            this.aFy.initListener();
            this.aFy.refreshCurUserScores();
        }
        this.fjv = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fjw = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eIH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fjq.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fjq.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fjq.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.aCe && e.this.eIG) {
                    e.this.aCe = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.aCe) {
                    e.this.aCe = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fjq.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eIH);
    }

    public void xy() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.U(this.mRootView);
                r.d(this.activity, false);
            } else {
                com.baidu.live.utils.h.V(this.mRootView);
                r.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.fjy != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fjy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fjy.setLayoutParams(layoutParams);
        }
        if (this.fjt != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fjt.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fjt.setLayoutParams(layoutParams2);
        }
        if (this.fjr != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fjr.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (this.isFullScreen) {
                    layoutParams3.height = -1;
                } else {
                    layoutParams3.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                }
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams3.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fjv);
            } else {
                gradientDrawable.setColor(this.fjw);
            }
            this.fjr.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fjB != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fjB.setImageBitmap(this.fjN);
            } else {
                this.fjB.setImageBitmap(this.fjM);
            }
        }
        if (this.fjL != null) {
            this.fjL.xy();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bmL();
        xy();
        this.fjx.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cCF = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fjx.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fjA.setVisibility(8);
                this.fjK.setVisibility(8);
            } else {
                this.fjA.setVisibility(0);
                this.fjK.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fjC.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fjA.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fjK.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fjB.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fjv);
        } else {
            this.fjx.setVisibility(0);
            this.fjA.setVisibility(8);
            this.fjK.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fjr.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fjq.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fjv);
            } else {
                gradientDrawable.setColor(this.fjw);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fjT.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fjT.setLayoutParams(layoutParams2);
        }
        this.fjr.setBackgroundDrawable(gradientDrawable);
        if (this.aqL) {
            jD(false);
        } else {
            jD(this.aIU);
        }
        if (this.fjl) {
            this.fjD.fmZ.setVisibility(8);
        }
        ak Au = com.baidu.live.guardclub.g.As().Au();
        if (Au != null && Au.auQ > 0) {
            this.fjG.setText(Au.auQ + "T豆加入");
        } else {
            this.fjG.setText("1000T豆加入");
        }
        this.fjA.setOnClickListener(this);
        this.fjD.fmW.setOnClickListener(this);
        this.fjG.setOnClickListener(this);
        this.fjK.setOnClickListener(this);
        this.fjD.fmS.setOnClickListener(this);
        this.fjD.fmZ.setOnClickListener(this);
        this.fjD.fmR.setOnClickListener(this);
        this.fjP.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fjD.fmP.setIsRound(true);
        this.fjD.fmP.setDrawBorder(false);
        this.fjD.fmP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fjD.fmP.setAutoChangeStyle(false);
        this.fjD.fmP.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fjD.fmQ.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aqL) {
            if (this.aIU) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.azz, str, this.otherParams);
        }
        this.fjO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.boz();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boz() {
        if (this.fjP != null) {
            if (TextUtils.isEmpty(this.fjO.getText())) {
                this.fjP.setEnabled(false);
                this.fjQ.setText(String.valueOf(0));
            } else {
                this.fjP.setEnabled(true);
                this.fjQ.setText(String.valueOf(this.fjO.getText().length()));
            }
        }
        if (this.fjO.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fjO.setText(this.fjO.getText().subSequence(0, 10));
            this.fjO.setSelection(this.fjO.getText().length());
        }
    }

    private void bmL() {
        this.fjy = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fjx = this.mRootView.findViewById(a.g.space_view);
        this.fjr = this.mRootView.findViewById(a.g.layout_guard_info);
        this.fjs = this.mRootView.findViewById(a.g.info_layout);
        this.fjO = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fjt = this.mRootView.findViewById(a.g.input_name_layout);
        this.fju = this.mRootView.findViewById(a.g.input_name);
        this.fjP = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fjQ = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fjz = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fjA = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fjB = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fjC = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fjD = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fjE = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fjF = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fjG = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fjH = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fjI = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fjJ = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fjR = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fjK = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fjS = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fjT = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void jD(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjB.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aqL) {
                this.fjB.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fjv);
                this.fjB.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aqL) {
            if (this.fjM == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fjM = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fjM) {
                    decodeResource.recycle();
                }
            }
            if (this.fjN == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fjN = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fjN) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fjB.setImageBitmap(this.fjN);
            } else {
                this.fjB.setImageBitmap(this.fjM);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fjB.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fjB.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fjD.getLayoutParams();
        if (z || this.aqL) {
            this.fjD.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fjF.setVisibility(8);
            this.fjT.setVisibility(0);
            this.fjG.setVisibility(8);
        } else {
            this.fjD.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fjF.setVisibility(0);
            this.fjT.setVisibility(8);
            this.fjG.setVisibility(0);
        }
        this.fjD.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aIR = aVar;
        this.aIS = str;
        if (aVar == null || aVar.id <= 0) {
            this.fjz.setVisibility(8);
            this.fjE.setVisibility(8);
            this.fjR.reset();
            this.fjR.setTitle(a.i.guard_club_no_create);
            this.fjR.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fjJ.setVisibility(0);
            return;
        }
        this.fjz.setVisibility(0);
        this.fjE.setVisibility(0);
        this.fjJ.setVisibility(8);
        jD(z);
        this.fjD.fmP.startLoad(aVar.aIM, 12, false);
        this.fjD.fmQ.startLoad(com.baidu.live.guardclub.g.As().ch(aVar.aIK), 10, false);
        boolean z2 = false;
        if (this.aqL && aVar.aIO != null) {
            z2 = aVar.aIO.optInt("can_update_name", 0) == 1;
        }
        int width = this.fjD.fkf.getWidth();
        if (width <= 0) {
            this.fjD.fkf.measure(0, 0);
            width = this.fjD.fkf.getMeasuredWidth();
        }
        String str3 = aVar.aIF;
        int i2 = 0;
        if (z2) {
            this.fjD.fmR.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fjD.fmR.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fjD.aPd.setPadding(0, 0, width + i2, 0);
            this.fjD.fkf.setPadding(0, 0, i2, 0);
            this.fjD.fkf.setVisibility(0);
        } else {
            this.fjD.aPd.setPadding(0, 0, i2, 0);
            this.fjD.fkf.setPadding(0, 0, i2, 0);
            this.fjD.fkf.setVisibility(4);
            str2 = str3;
        }
        this.fjD.aPd.setText(str2);
        String cj = com.baidu.live.guardclub.g.As().cj(aVar.aIK);
        String str4 = (cj == null || "null".equals(cj)) ? "" : cj;
        Resources resources = this.fjD.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjD.getLayoutParams();
        if (z || this.aqL) {
            this.fjD.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aIH;
            if (aVar.aIL > 0) {
                str5 = str5 + " / " + aVar.aIL;
            }
            this.fjD.fmT.setText(str5);
            this.fjD.fmV.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fjF.setVisibility(8);
            this.fjT.setVisibility(0);
            this.fjG.setVisibility(8);
            jE(this.fjl);
        } else {
            this.fjD.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aIH;
            if (aVar.aIL > 0) {
                str6 = str6 + " / " + aVar.aIL;
            }
            this.fjD.fmT.setText(str6);
            this.fjD.fmV.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fjF.setVisibility(0);
            this.fjT.setVisibility(8);
            this.fjG.setVisibility(0);
            if (dVarArr != null) {
                this.fjH.setVisibility(0);
                this.fjS.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fjS.addView(view, layoutParams2);
                    } else {
                        view = view2;
                    }
                    if (view == null) {
                        break;
                    }
                    if (i3 % 4 == 0) {
                        tbImageView = (TbImageView) view.findViewById(a.g.privilegeIcon1);
                        textView = (TextView) view.findViewById(a.g.privilegeTitle1);
                    } else if (i3 % 4 == 1) {
                        tbImageView = (TbImageView) view.findViewById(a.g.privilegeIcon2);
                        textView = (TextView) view.findViewById(a.g.privilegeTitle2);
                    } else if (i3 % 4 == 2) {
                        tbImageView = (TbImageView) view.findViewById(a.g.privilegeIcon3);
                        textView = (TextView) view.findViewById(a.g.privilegeTitle3);
                    } else {
                        tbImageView = (TbImageView) view.findViewById(a.g.privilegeIcon4);
                        textView = (TextView) view.findViewById(a.g.privilegeTitle4);
                    }
                    com.baidu.live.guardclub.d dVar = dVarArr[i3];
                    if (dVar != null) {
                        tbImageView.startLoad(dVar.aJd, 10, false);
                        textView.setText(dVar.aJe + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.fjH.setVisibility(8);
            }
        }
        this.fjD.setLayoutParams(layoutParams);
        if (aVar.aIH == aVar.aIL) {
            i = 100;
        } else if (aVar.aIH <= 0) {
            i = 0;
        } else if (aVar.aIL <= 0) {
            i = 100;
        } else if (aVar.aIH >= aVar.aIL) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aIH * 100) / aVar.aIL);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
        }
        if (i < 10) {
            i = 10;
        }
        if (i > 100) {
            i = 100;
        }
        this.fjD.fmU.setProgress(i);
        this.fjD.fmY.setText(aVar.aIJ < 10000 ? aVar.aIJ + "" : String.format("%.1f", Float.valueOf(((float) aVar.aIJ) / 10000.0f)) + "万");
        String str7 = aVar.aIN;
        this.fjD.fci.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void boA() {
        this.fjz.setVisibility(8);
        this.fjE.setVisibility(8);
        this.fjR.reset();
        this.fjR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fjR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fjn != null) {
                    e.this.fjn.onClick(view);
                }
            }
        });
        this.fjR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fjJ.setVisibility(0);
    }

    public void jE(boolean z) {
        this.fjL = new j(this.fjq, this.liveId, this.roomId, this.apl, this.aqL, true, false, this.isFullScreen, this.otherParams, this.fjq.getUniqueId(), null);
        this.fjL.jF(z);
        View view = this.fjL.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fjI.removeAllViews();
            this.fjI.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aFy != null) {
            this.aFy.onDestroy();
        }
        if (this.fjM != null) {
            this.fjM.recycle();
        }
        if (this.fjN != null) {
            this.fjN.recycle();
        }
        this.fjq.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eIH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fjx || view == this.fjA || view == this.fjK) {
            this.activity.finish();
        } else if (view == this.fjD.fmS) {
            if (!TextUtils.isEmpty(this.aIS)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aIS);
            }
            if (!this.aqL) {
                if (this.aIU) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.azz, str, this.otherParams);
            }
        } else if (view == this.fjD.fmW) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.apl, this.liveId, this.aqL, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.azz);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fjD.fmZ) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.apl, this.liveId, this.aqL, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.azz);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fjG) {
            if (this.aIR != null) {
                ak Au = com.baidu.live.guardclub.g.As().Au();
                if (Au == null || Au.auQ <= 0) {
                    j = 1000;
                } else {
                    j = Au.auQ;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    pK(this.aIR.id);
                } else if (this.fjl) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aIR));
                    this.activity.finish();
                }
            }
            if (!this.aqL) {
                if (TextUtils.isEmpty(this.fjf)) {
                    this.fjf = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.azz, this.fjf, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.aCe) {
                this.fjO.clearFocus();
                this.fjO.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fjq.getActivity(), this.fjO);
                return;
            }
            this.activity.finish();
        } else if (view == this.fjP) {
            String obj = this.fjO.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aIR.id, obj, "");
            }
        } else if (view == this.fjD.fmR) {
            this.fjO.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fjq.getActivity(), this.fjO);
        }
    }

    public void Ae(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fjD.aPd.setText(str);
            this.fjO.setText("");
            this.fjO.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fjq.getActivity(), this.fjO);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fju.getLayoutParams();
        if (z) {
            this.fjr.setVisibility(this.isFullScreen ? 0 : 8);
            this.fjt.setVisibility(0);
            String charSequence = this.fjD.aPd.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fjO.setText(charSequence);
                this.fjO.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fjO.setText("");
            }
            layoutParams.bottomMargin = boB();
        } else {
            layoutParams.bottomMargin = 0;
            this.fjt.setVisibility(8);
            this.fjr.setVisibility(0);
        }
        this.fju.setLayoutParams(layoutParams);
    }

    protected int boB() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fjq.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fjq.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void pK(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cf(i);
        cVar.a(this.aIR);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.du(i);
        cVar.Ag(str);
        cVar.Ah(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
