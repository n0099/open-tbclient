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
    private String fwR;
    private boolean fwX;
    private View.OnClickListener fwZ;
    private TextView fxA;
    private TextView fxB;
    private CommonEmptyView fxC;
    private LinearLayout fxD;
    private LinearLayout fxE;
    private GuardClubInfoActivity fxc;
    private View fxd;
    private View fxe;
    private View fxf;
    private int fxg;
    private int fxh;
    private View fxi;
    private LinearLayout fxj;
    private RelativeLayout fxk;
    private ImageView fxl;
    private ImageView fxm;
    private LinearLayout fxn;
    private GuardClubInfoHeaderView fxo;
    private RelativeLayout fxp;
    private RelativeLayout fxq;
    private TextView fxr;
    private LinearLayout fxs;
    private FrameLayout fxt;
    private RelativeLayout fxu;
    private ImageView fxv;
    private j fxw;
    private Bitmap fxx;
    private Bitmap fxy;
    private EditText fxz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eVj = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.fxc = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aul = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aEX = str;
        this.avR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aOJ = z3;
        this.fwX = z4;
        this.fwR = str3;
        this.isTranslucent = z5;
        this.fwZ = onClickListener;
        if (!z3) {
            if (this.aLm == null) {
                this.aLm = new com.baidu.live.k.c();
            }
            this.aLm.initListener();
            this.aLm.refreshCurUserScores();
        }
        this.fxg = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fxh = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fxc.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fxc.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fxc.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.eVj) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fxc.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
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
        if (this.fxj != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fxj.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fxj.setLayoutParams(layoutParams);
        }
        if (this.fxe != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fxe.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fxe.setLayoutParams(layoutParams2);
        }
        if (this.fxd != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fxd.getLayoutParams();
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
                gradientDrawable.setColor(this.fxg);
            } else {
                gradientDrawable.setColor(this.fxh);
            }
            this.fxd.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fxm != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fxm.setImageBitmap(this.fxy);
            } else {
                this.fxm.setImageBitmap(this.fxx);
            }
        }
        if (this.fxw != null) {
            this.fxw.yL();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bsh();
        yL();
        this.fxi.setOnClickListener(this);
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
            this.fxi.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fxl.setVisibility(8);
                this.fxv.setVisibility(8);
            } else {
                this.fxl.setVisibility(0);
                this.fxv.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fxn.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fxl.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fxv.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fxm.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fxg);
        } else {
            this.fxi.setVisibility(0);
            this.fxl.setVisibility(8);
            this.fxv.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fxd.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fxc.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fxg);
            } else {
                gradientDrawable.setColor(this.fxh);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxE.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fxE.setLayoutParams(layoutParams2);
        }
        this.fxd.setBackgroundDrawable(gradientDrawable);
        if (this.avR) {
            jW(false);
        } else {
            jW(this.aOJ);
        }
        if (this.fwX) {
            this.fxo.fAL.setVisibility(8);
        }
        ao BJ = com.baidu.live.guardclub.g.BH().BJ();
        if (BJ != null && BJ.aAa > 0) {
            this.fxr.setText(BJ.aAa + "T豆加入");
        } else {
            this.fxr.setText("1000T豆加入");
        }
        this.fxl.setOnClickListener(this);
        this.fxo.fAI.setOnClickListener(this);
        this.fxr.setOnClickListener(this);
        this.fxv.setOnClickListener(this);
        this.fxo.fAE.setOnClickListener(this);
        this.fxo.fAL.setOnClickListener(this);
        this.fxo.fAD.setOnClickListener(this);
        this.fxA.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fxo.fAB.setIsRound(true);
        this.fxo.fAB.setDrawBorder(false);
        this.fxo.fAB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fxo.fAB.setAutoChangeStyle(false);
        this.fxo.fAB.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fxo.fAC.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.avR) {
            if (this.aOJ) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aEX, str, this.otherParams);
        }
        this.fxz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bup();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        if (this.fxA != null) {
            if (TextUtils.isEmpty(this.fxz.getText())) {
                this.fxA.setEnabled(false);
                this.fxB.setText(String.valueOf(0));
            } else {
                this.fxA.setEnabled(true);
                this.fxB.setText(String.valueOf(this.fxz.getText().length()));
            }
        }
        if (this.fxz.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fxz.setText(this.fxz.getText().subSequence(0, 10));
            this.fxz.setSelection(this.fxz.getText().length());
        }
    }

    private void bsh() {
        this.fxj = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fxi = this.mRootView.findViewById(a.g.space_view);
        this.fxd = this.mRootView.findViewById(a.g.layout_guard_info);
        this.aYn = this.mRootView.findViewById(a.g.info_layout);
        this.fxz = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fxe = this.mRootView.findViewById(a.g.input_name_layout);
        this.fxf = this.mRootView.findViewById(a.g.input_name);
        this.fxA = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fxB = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fxk = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fxl = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fxm = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fxn = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fxo = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fxp = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fxq = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fxr = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fxs = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fxt = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fxu = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fxC = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fxv = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fxD = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fxE = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void jW(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxm.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.avR) {
                this.fxm.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fxg);
                this.fxm.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.avR) {
            if (this.fxx == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fxx = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fxx) {
                    decodeResource.recycle();
                }
            }
            if (this.fxy == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fxy = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fxy) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fxm.setImageBitmap(this.fxy);
            } else {
                this.fxm.setImageBitmap(this.fxx);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fxm.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fxm.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fxo.getLayoutParams();
        if (z || this.avR) {
            this.fxo.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fxq.setVisibility(8);
            this.fxE.setVisibility(0);
            this.fxr.setVisibility(8);
        } else {
            this.fxo.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fxq.setVisibility(0);
            this.fxE.setVisibility(8);
            this.fxr.setVisibility(0);
        }
        this.fxo.setLayoutParams(layoutParams2);
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
            this.fxk.setVisibility(8);
            this.fxp.setVisibility(8);
            this.fxC.reset();
            this.fxC.setTitle(a.i.guard_club_no_create);
            this.fxC.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fxu.setVisibility(0);
            return;
        }
        this.fxk.setVisibility(0);
        this.fxp.setVisibility(0);
        this.fxu.setVisibility(8);
        jW(z);
        this.fxo.fAB.startLoad(aVar.aOB, 12, false);
        this.fxo.fAC.startLoad(com.baidu.live.guardclub.g.BH().co(aVar.aOz), 10, false);
        boolean z2 = false;
        if (this.avR && aVar.aOD != null) {
            z2 = aVar.aOD.optInt("can_update_name", 0) == 1;
        }
        int width = this.fxo.fxQ.getWidth();
        if (width <= 0) {
            this.fxo.fxQ.measure(0, 0);
            width = this.fxo.fxQ.getMeasuredWidth();
        }
        String str3 = aVar.aOu;
        int i2 = 0;
        if (z2) {
            this.fxo.fAD.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fxo.fAD.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fxo.aVs.setPadding(0, 0, width + i2, 0);
            this.fxo.fxQ.setPadding(0, 0, i2, 0);
            this.fxo.fxQ.setVisibility(0);
        } else {
            this.fxo.aVs.setPadding(0, 0, i2, 0);
            this.fxo.fxQ.setPadding(0, 0, i2, 0);
            this.fxo.fxQ.setVisibility(4);
            str2 = str3;
        }
        this.fxo.aVs.setText(str2);
        String cq = com.baidu.live.guardclub.g.BH().cq(aVar.aOz);
        String str4 = (cq == null || "null".equals(cq)) ? "" : cq;
        Resources resources = this.fxo.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxo.getLayoutParams();
        if (z || this.avR) {
            this.fxo.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aOw;
            if (aVar.aOA > 0) {
                str5 = str5 + " / " + aVar.aOA;
            }
            this.fxo.fAF.setText(str5);
            this.fxo.fAH.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fxq.setVisibility(8);
            this.fxE.setVisibility(0);
            this.fxr.setVisibility(8);
            jX(this.fwX);
        } else {
            this.fxo.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aOw;
            if (aVar.aOA > 0) {
                str6 = str6 + " / " + aVar.aOA;
            }
            this.fxo.fAF.setText(str6);
            this.fxo.fAH.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fxq.setVisibility(0);
            this.fxE.setVisibility(8);
            this.fxr.setVisibility(0);
            if (dVarArr != null) {
                this.fxs.setVisibility(0);
                this.fxD.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fxD.addView(view, layoutParams2);
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
                this.fxs.setVisibility(8);
            }
        }
        this.fxo.setLayoutParams(layoutParams);
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
        this.fxo.fAG.setProgress(i);
        this.fxo.fAK.setText(aVar.aOy < 10000 ? aVar.aOy + "" : String.format("%.1f", Float.valueOf(((float) aVar.aOy) / 10000.0f)) + "万");
        String str7 = aVar.aOC;
        this.fxo.fpQ.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void buq() {
        this.fxk.setVisibility(8);
        this.fxp.setVisibility(8);
        this.fxC.reset();
        this.fxC.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fxC.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fwZ != null) {
                    e.this.fwZ.onClick(view);
                }
            }
        });
        this.fxC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fxu.setVisibility(0);
    }

    public void jX(boolean z) {
        this.fxw = new j(this.fxc, this.liveId, this.roomId, this.aul, this.aEX, this.avR, true, false, this.isFullScreen, this.otherParams, this.fxc.getUniqueId(), null);
        this.fxw.jY(z);
        View view = this.fxw.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fxt.removeAllViews();
            this.fxt.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aLm != null) {
            this.aLm.onDestroy();
        }
        if (this.fxx != null) {
            this.fxx.recycle();
        }
        if (this.fxy != null) {
            this.fxy.recycle();
        }
        if (this.fxw != null) {
            this.fxw.aCE();
        }
        this.fxc.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fxi || view == this.fxl || view == this.fxv) {
            this.activity.finish();
        } else if (view == this.fxo.fAE) {
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
        } else if (view == this.fxo.fAI) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aul, this.liveId, this.avR, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aEX);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fxo.fAL) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aul, this.liveId, this.avR, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aEX);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fxr) {
            if (this.aOG != null) {
                ao BJ = com.baidu.live.guardclub.g.BH().BJ();
                if (BJ == null || BJ.aAa <= 0) {
                    j = 1000;
                } else {
                    j = BJ.aAa;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    ql(this.aOG.id);
                } else if (this.fwX) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aOG));
                    this.activity.finish();
                }
            }
            if (!this.avR) {
                if (TextUtils.isEmpty(this.fwR)) {
                    this.fwR = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aEX, this.fwR, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.fxz.clearFocus();
                this.fxz.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fxc.getActivity(), this.fxz);
                return;
            }
            this.activity.finish();
        } else if (view == this.fxA) {
            String obj = this.fxz.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aOG.id, obj, "");
            }
        } else if (view == this.fxo.fAD) {
            this.fxz.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fxc.getActivity(), this.fxz);
        }
    }

    public void BO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fxo.aVs.setText(str);
            this.fxz.setText("");
            this.fxz.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fxc.getActivity(), this.fxz);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxf.getLayoutParams();
        if (z) {
            this.fxd.setVisibility(this.isFullScreen ? 0 : 8);
            this.fxe.setVisibility(0);
            String charSequence = this.fxo.aVs.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fxz.setText(charSequence);
                this.fxz.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fxz.setText("");
            }
            layoutParams.bottomMargin = bur();
        } else {
            layoutParams.bottomMargin = 0;
            this.fxe.setVisibility(8);
            this.fxd.setVisibility(0);
        }
        this.fxf.setLayoutParams(layoutParams);
    }

    protected int bur() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fxc.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fxc.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void ql(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cm(i);
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
