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
import com.baidu.live.data.ao;
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
    private String aEX;
    private com.baidu.live.k.c aLm;
    private com.baidu.live.guardclub.a aOG;
    private String aOH;
    private boolean aOJ;
    private View aYn;
    private Activity activity;
    private long aul;
    private boolean avR;
    private int cOy;
    private RelativeLayout fxA;
    private RelativeLayout fxB;
    private TextView fxC;
    private LinearLayout fxD;
    private FrameLayout fxE;
    private RelativeLayout fxF;
    private ImageView fxG;
    private j fxH;
    private Bitmap fxI;
    private Bitmap fxJ;
    private EditText fxK;
    private TextView fxL;
    private TextView fxM;
    private CommonEmptyView fxN;
    private LinearLayout fxO;
    private LinearLayout fxP;
    private String fxc;
    private boolean fxi;
    private View.OnClickListener fxk;
    private GuardClubInfoActivity fxn;
    private View fxo;
    private View fxp;
    private View fxq;
    private int fxr;
    private int fxs;
    private View fxt;
    private LinearLayout fxu;
    private RelativeLayout fxv;
    private ImageView fxw;
    private ImageView fxx;
    private LinearLayout fxy;
    private GuardClubInfoHeaderView fxz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eVu = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.fxn = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aul = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aEX = str;
        this.avR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aOJ = z3;
        this.fxi = z4;
        this.fxc = str3;
        this.isTranslucent = z5;
        this.fxk = onClickListener;
        if (!z3) {
            if (this.aLm == null) {
                this.aLm = new com.baidu.live.k.c();
            }
            this.aLm.initListener();
            this.aLm.refreshCurUserScores();
        }
        this.fxr = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fxs = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fxn.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fxn.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fxn.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.eVu) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fxn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void yL() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.T(this.mRootView);
                r.d(this.activity, false);
            } else {
                com.baidu.live.utils.h.U(this.mRootView);
                r.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.fxu != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fxu.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fxu.setLayoutParams(layoutParams);
        }
        if (this.fxp != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fxp.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fxp.setLayoutParams(layoutParams2);
        }
        if (this.fxo != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fxo.getLayoutParams();
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
                gradientDrawable.setColor(this.fxr);
            } else {
                gradientDrawable.setColor(this.fxs);
            }
            this.fxo.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fxx != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fxx.setImageBitmap(this.fxJ);
            } else {
                this.fxx.setImageBitmap(this.fxI);
            }
        }
        if (this.fxH != null) {
            this.fxH.yL();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bsj();
        yL();
        this.fxt.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cOy = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fxt.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fxw.setVisibility(8);
                this.fxG.setVisibility(8);
            } else {
                this.fxw.setVisibility(0);
                this.fxG.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fxy.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fxw.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fxG.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fxx.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fxr);
        } else {
            this.fxt.setVisibility(0);
            this.fxw.setVisibility(8);
            this.fxG.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fxo.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fxn.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fxr);
            } else {
                gradientDrawable.setColor(this.fxs);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxP.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fxP.setLayoutParams(layoutParams2);
        }
        this.fxo.setBackgroundDrawable(gradientDrawable);
        if (this.avR) {
            jW(false);
        } else {
            jW(this.aOJ);
        }
        if (this.fxi) {
            this.fxz.fAW.setVisibility(8);
        }
        ao BJ = com.baidu.live.guardclub.g.BH().BJ();
        if (BJ != null && BJ.aAa > 0) {
            this.fxC.setText(BJ.aAa + "T豆加入");
        } else {
            this.fxC.setText("1000T豆加入");
        }
        this.fxw.setOnClickListener(this);
        this.fxz.fAT.setOnClickListener(this);
        this.fxC.setOnClickListener(this);
        this.fxG.setOnClickListener(this);
        this.fxz.fAP.setOnClickListener(this);
        this.fxz.fAW.setOnClickListener(this);
        this.fxz.fAO.setOnClickListener(this);
        this.fxL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fxz.fAM.setIsRound(true);
        this.fxz.fAM.setDrawBorder(false);
        this.fxz.fAM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fxz.fAM.setAutoChangeStyle(false);
        this.fxz.fAM.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fxz.fAN.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.avR) {
            if (this.aOJ) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aEX, str, this.otherParams);
        }
        this.fxK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bur();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bur() {
        if (this.fxL != null) {
            if (TextUtils.isEmpty(this.fxK.getText())) {
                this.fxL.setEnabled(false);
                this.fxM.setText(String.valueOf(0));
            } else {
                this.fxL.setEnabled(true);
                this.fxM.setText(String.valueOf(this.fxK.getText().length()));
            }
        }
        if (this.fxK.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fxK.setText(this.fxK.getText().subSequence(0, 10));
            this.fxK.setSelection(this.fxK.getText().length());
        }
    }

    private void bsj() {
        this.fxu = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fxt = this.mRootView.findViewById(a.g.space_view);
        this.fxo = this.mRootView.findViewById(a.g.layout_guard_info);
        this.aYn = this.mRootView.findViewById(a.g.info_layout);
        this.fxK = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fxp = this.mRootView.findViewById(a.g.input_name_layout);
        this.fxq = this.mRootView.findViewById(a.g.input_name);
        this.fxL = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fxM = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fxv = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fxw = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fxx = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fxy = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fxz = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fxA = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fxB = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fxC = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fxD = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fxE = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fxF = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fxN = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fxG = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fxO = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fxP = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void jW(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxx.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.avR) {
                this.fxx.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fxr);
                this.fxx.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.avR) {
            if (this.fxI == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fxI = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fxI) {
                    decodeResource.recycle();
                }
            }
            if (this.fxJ == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fxJ = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fxJ) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fxx.setImageBitmap(this.fxJ);
            } else {
                this.fxx.setImageBitmap(this.fxI);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fxx.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fxx.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fxz.getLayoutParams();
        if (z || this.avR) {
            this.fxz.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fxB.setVisibility(8);
            this.fxP.setVisibility(0);
            this.fxC.setVisibility(8);
        } else {
            this.fxz.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fxB.setVisibility(0);
            this.fxP.setVisibility(8);
            this.fxC.setVisibility(0);
        }
        this.fxz.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aOG = aVar;
        this.aOH = str;
        if (aVar == null || aVar.id <= 0) {
            this.fxv.setVisibility(8);
            this.fxA.setVisibility(8);
            this.fxN.reset();
            this.fxN.setTitle(a.i.guard_club_no_create);
            this.fxN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fxF.setVisibility(0);
            return;
        }
        this.fxv.setVisibility(0);
        this.fxA.setVisibility(0);
        this.fxF.setVisibility(8);
        jW(z);
        this.fxz.fAM.startLoad(aVar.aOB, 12, false);
        this.fxz.fAN.startLoad(com.baidu.live.guardclub.g.BH().cq(aVar.aOz), 10, false);
        boolean z2 = false;
        if (this.avR && aVar.aOD != null) {
            z2 = aVar.aOD.optInt("can_update_name", 0) == 1;
        }
        int width = this.fxz.fyb.getWidth();
        if (width <= 0) {
            this.fxz.fyb.measure(0, 0);
            width = this.fxz.fyb.getMeasuredWidth();
        }
        String str3 = aVar.aOu;
        int i2 = 0;
        if (z2) {
            this.fxz.fAO.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fxz.fAO.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fxz.aVs.setPadding(0, 0, width + i2, 0);
            this.fxz.fyb.setPadding(0, 0, i2, 0);
            this.fxz.fyb.setVisibility(0);
        } else {
            this.fxz.aVs.setPadding(0, 0, i2, 0);
            this.fxz.fyb.setPadding(0, 0, i2, 0);
            this.fxz.fyb.setVisibility(4);
            str2 = str3;
        }
        this.fxz.aVs.setText(str2);
        String cs = com.baidu.live.guardclub.g.BH().cs(aVar.aOz);
        String str4 = (cs == null || "null".equals(cs)) ? "" : cs;
        Resources resources = this.fxz.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxz.getLayoutParams();
        if (z || this.avR) {
            this.fxz.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aOw;
            if (aVar.aOA > 0) {
                str5 = str5 + " / " + aVar.aOA;
            }
            this.fxz.fAQ.setText(str5);
            this.fxz.fAS.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fxB.setVisibility(8);
            this.fxP.setVisibility(0);
            this.fxC.setVisibility(8);
            jX(this.fxi);
        } else {
            this.fxz.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aOw;
            if (aVar.aOA > 0) {
                str6 = str6 + " / " + aVar.aOA;
            }
            this.fxz.fAQ.setText(str6);
            this.fxz.fAS.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fxB.setVisibility(0);
            this.fxP.setVisibility(8);
            this.fxC.setVisibility(0);
            if (dVarArr != null) {
                this.fxD.setVisibility(0);
                this.fxO.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fxO.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aOS, 10, false);
                        textView.setText(dVar.aOT + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.fxD.setVisibility(8);
            }
        }
        this.fxz.setLayoutParams(layoutParams);
        if (aVar.aOw == aVar.aOA) {
            i = 100;
        } else if (aVar.aOw <= 0) {
            i = 0;
        } else if (aVar.aOA <= 0) {
            i = 100;
        } else if (aVar.aOw >= aVar.aOA) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aOw * 100) / aVar.aOA);
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
        this.fxz.fAR.setProgress(i);
        this.fxz.fAV.setText(aVar.aOy < 10000 ? aVar.aOy + "" : String.format("%.1f", Float.valueOf(((float) aVar.aOy) / 10000.0f)) + "万");
        String str7 = aVar.aOC;
        this.fxz.fqb.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bus() {
        this.fxv.setVisibility(8);
        this.fxA.setVisibility(8);
        this.fxN.reset();
        this.fxN.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fxN.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fxk != null) {
                    e.this.fxk.onClick(view);
                }
            }
        });
        this.fxN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fxF.setVisibility(0);
    }

    public void jX(boolean z) {
        this.fxH = new j(this.fxn, this.liveId, this.roomId, this.aul, this.aEX, this.avR, true, false, this.isFullScreen, this.otherParams, this.fxn.getUniqueId(), null);
        this.fxH.jY(z);
        View view = this.fxH.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fxE.removeAllViews();
            this.fxE.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aLm != null) {
            this.aLm.onDestroy();
        }
        if (this.fxI != null) {
            this.fxI.recycle();
        }
        if (this.fxJ != null) {
            this.fxJ.recycle();
        }
        if (this.fxH != null) {
            this.fxH.aCE();
        }
        this.fxn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fxt || view == this.fxw || view == this.fxG) {
            this.activity.finish();
        } else if (view == this.fxz.fAP) {
            if (!TextUtils.isEmpty(this.aOH)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aOH);
            }
            if (!this.avR) {
                if (this.aOJ) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aEX, str, this.otherParams);
            }
        } else if (view == this.fxz.fAT) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aul, this.liveId, this.avR, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aEX);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fxz.fAW) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aul, this.liveId, this.avR, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aEX);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fxC) {
            if (this.aOG != null) {
                ao BJ = com.baidu.live.guardclub.g.BH().BJ();
                if (BJ == null || BJ.aAa <= 0) {
                    j = 1000;
                } else {
                    j = BJ.aAa;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    qn(this.aOG.id);
                } else if (this.fxi) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aOG));
                    this.activity.finish();
                }
            }
            if (!this.avR) {
                if (TextUtils.isEmpty(this.fxc)) {
                    this.fxc = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aEX, this.fxc, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.fxK.clearFocus();
                this.fxK.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fxn.getActivity(), this.fxK);
                return;
            }
            this.activity.finish();
        } else if (view == this.fxL) {
            String obj = this.fxK.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aOG.id, obj, "");
            }
        } else if (view == this.fxz.fAO) {
            this.fxK.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fxn.getActivity(), this.fxK);
        }
    }

    public void BO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fxz.aVs.setText(str);
            this.fxK.setText("");
            this.fxK.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fxn.getActivity(), this.fxK);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxq.getLayoutParams();
        if (z) {
            this.fxo.setVisibility(this.isFullScreen ? 0 : 8);
            this.fxp.setVisibility(0);
            String charSequence = this.fxz.aVs.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fxK.setText(charSequence);
                this.fxK.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fxK.setText("");
            }
            layoutParams.bottomMargin = but();
        } else {
            layoutParams.bottomMargin = 0;
            this.fxp.setVisibility(8);
            this.fxo.setVisibility(0);
        }
        this.fxq.setLayoutParams(layoutParams);
    }

    protected int but() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fxn.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fxn.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void qn(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.co(i);
        cVar.a(this.aOG);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.dw(i);
        cVar.BQ(str);
        cVar.BR(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
