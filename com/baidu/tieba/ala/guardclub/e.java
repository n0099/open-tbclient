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
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
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
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    private String aDo;
    private String aDp;
    private String aIO;
    private com.baidu.live.l.c aPn;
    private com.baidu.live.guardclub.a aSF;
    private String aSG;
    private boolean aSI;
    private Activity activity;
    private long axs;
    private boolean azm;
    private View baV;
    private int cXV;
    private String fNI;
    private boolean fNO;
    private View.OnClickListener fNQ;
    private GuardClubInfoActivity fNT;
    private View fNU;
    private View fNV;
    private View fNW;
    private int fNX;
    private int fNY;
    private View fNZ;
    private LinearLayout fOa;
    private RelativeLayout fOb;
    private ImageView fOc;
    private ImageView fOd;
    private LinearLayout fOe;
    private GuardClubInfoHeaderView fOf;
    private RelativeLayout fOg;
    private RelativeLayout fOh;
    private TextView fOi;
    private LinearLayout fOj;
    private FrameLayout fOk;
    private RelativeLayout fOl;
    private ImageView fOm;
    private j fOn;
    private Bitmap fOo;
    private Bitmap fOp;
    private EditText fOq;
    private TextView fOr;
    private TextView fOs;
    private CommonEmptyView fOt;
    private LinearLayout fOu;
    private LinearLayout fOv;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean fjo = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.fNT = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.axs = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aIO = str;
        this.azm = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aSI = z3;
        this.fNO = z4;
        this.fNI = str3;
        this.isTranslucent = z5;
        this.aDo = str4;
        this.aDp = str5;
        this.fNQ = onClickListener;
        if (!z3) {
            if (this.aPn == null) {
                this.aPn = new com.baidu.live.l.c();
            }
            this.aPn.initListener();
            this.aPn.refreshCurUserScores();
        }
        this.fNX = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fNY = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fNT.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fNT.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fNT.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.fjo) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fNT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void zN() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.X(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.h.Y(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.fOa != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fOa.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fOa.setLayoutParams(layoutParams);
        }
        if (this.fNV != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fNV.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fNV.setLayoutParams(layoutParams2);
        }
        if (this.fNU != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fNU.getLayoutParams();
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
                gradientDrawable.setColor(this.fNX);
            } else {
                gradientDrawable.setColor(this.fNY);
            }
            this.fNU.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fOd != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fOd.setImageBitmap(this.fOp);
            } else {
                this.fOd.setImageBitmap(this.fOo);
            }
        }
        if (this.fOn != null) {
            this.fOn.zN();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        byo();
        zN();
        this.fNZ.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cXV = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fNZ.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fOc.setVisibility(8);
                this.fOm.setVisibility(8);
            } else {
                this.fOc.setVisibility(0);
                this.fOm.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fOe.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fOc.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fOm.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fOd.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fNX);
        } else {
            this.fNZ.setVisibility(0);
            this.fOc.setVisibility(8);
            this.fOm.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fNU.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fNT.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fNX);
            } else {
                gradientDrawable.setColor(this.fNY);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fOv.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fOv.setLayoutParams(layoutParams2);
        }
        this.fNU.setBackgroundDrawable(gradientDrawable);
        if (this.azm) {
            kO(false);
        } else {
            kO(this.aSI);
        }
        if (this.fNO) {
            this.fOf.fRz.setVisibility(8);
        }
        at CL = com.baidu.live.guardclub.g.CJ().CL();
        if (CL != null && CL.aDG > 0) {
            this.fOi.setText(CL.aDG + "T豆加入");
        } else {
            this.fOi.setText("1000T豆加入");
        }
        this.fOc.setOnClickListener(this);
        this.fOf.fRw.setOnClickListener(this);
        this.fOi.setOnClickListener(this);
        this.fOm.setOnClickListener(this);
        this.fOf.fRs.setOnClickListener(this);
        this.fOf.fRz.setOnClickListener(this);
        this.fOf.fRr.setOnClickListener(this);
        this.fOr.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fOf.fRp.setIsRound(true);
        this.fOf.fRp.setDrawBorder(false);
        this.fOf.fRp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOf.fRp.setAutoChangeStyle(false);
        this.fOf.fRp.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fOf.fRq.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.azm) {
            if (this.aSI) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aIO, str, this.otherParams);
        }
        this.fOq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bAD();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAD() {
        if (this.fOr != null) {
            if (TextUtils.isEmpty(this.fOq.getText())) {
                this.fOr.setEnabled(false);
                this.fOs.setText(String.valueOf(0));
            } else {
                this.fOr.setEnabled(true);
                this.fOs.setText(String.valueOf(this.fOq.getText().length()));
            }
        }
        if (this.fOq.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fOq.setText(this.fOq.getText().subSequence(0, 10));
            this.fOq.setSelection(this.fOq.getText().length());
        }
    }

    private void byo() {
        this.fOa = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fNZ = this.mRootView.findViewById(a.g.space_view);
        this.fNU = this.mRootView.findViewById(a.g.layout_guard_info);
        this.baV = this.mRootView.findViewById(a.g.info_layout);
        this.fOq = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fNV = this.mRootView.findViewById(a.g.input_name_layout);
        this.fNW = this.mRootView.findViewById(a.g.input_name);
        this.fOr = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fOs = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fOb = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fOc = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fOd = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fOe = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fOf = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fOg = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fOh = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fOi = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fOj = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fOk = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fOl = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fOt = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fOm = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fOu = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fOv = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void kO(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fOd.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.azm) {
                this.fOd.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fNX);
                this.fOd.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.azm) {
            if (this.fOo == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fOo = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fOo) {
                    decodeResource.recycle();
                }
            }
            if (this.fOp == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fOp = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fOp) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fOd.setImageBitmap(this.fOp);
            } else {
                this.fOd.setImageBitmap(this.fOo);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fOd.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fOd.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fOf.getLayoutParams();
        if (z || this.azm) {
            this.fOf.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fOh.setVisibility(8);
            this.fOv.setVisibility(0);
            this.fOi.setVisibility(8);
        } else {
            this.fOf.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fOh.setVisibility(0);
            this.fOv.setVisibility(8);
            this.fOi.setVisibility(0);
        }
        this.fOf.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aSF = aVar;
        this.aSG = str;
        if (aVar == null || aVar.id <= 0) {
            this.fOb.setVisibility(8);
            this.fOg.setVisibility(8);
            this.fOt.reset();
            this.fOt.setTitle(a.i.guard_club_no_create);
            this.fOt.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fOl.setVisibility(0);
            return;
        }
        this.fOb.setVisibility(0);
        this.fOg.setVisibility(0);
        this.fOl.setVisibility(8);
        kO(z);
        this.fOf.fRp.startLoad(aVar.aSA, 12, false);
        this.fOf.fRq.startLoad(com.baidu.live.guardclub.g.CJ().cC(aVar.aSy), 10, false);
        boolean z2 = false;
        if (this.azm && aVar.aSC != null) {
            z2 = aVar.aSC.optInt("can_update_name", 0) == 1;
        }
        int width = this.fOf.fOG.getWidth();
        if (width <= 0) {
            this.fOf.fOG.measure(0, 0);
            width = this.fOf.fOG.getMeasuredWidth();
        }
        String str3 = aVar.aSt;
        int i2 = 0;
        if (z2) {
            this.fOf.fRr.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fOf.fRr.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fOf.avN.setPadding(0, 0, width + i2, 0);
            this.fOf.fOG.setPadding(0, 0, i2, 0);
            this.fOf.fOG.setVisibility(0);
        } else {
            this.fOf.avN.setPadding(0, 0, i2, 0);
            this.fOf.fOG.setPadding(0, 0, i2, 0);
            this.fOf.fOG.setVisibility(4);
            str2 = str3;
        }
        this.fOf.avN.setText(str2);
        String cE = com.baidu.live.guardclub.g.CJ().cE(aVar.aSy);
        String str4 = (cE == null || "null".equals(cE)) ? "" : cE;
        Resources resources = this.fOf.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fOf.getLayoutParams();
        if (z || this.azm) {
            this.fOf.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aSv;
            if (aVar.aSz > 0) {
                str5 = str5 + " / " + aVar.aSz;
            }
            this.fOf.fRt.setText(str5);
            this.fOf.fRv.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fOh.setVisibility(8);
            this.fOv.setVisibility(0);
            this.fOi.setVisibility(8);
            kP(this.fNO);
        } else {
            this.fOf.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aSv;
            if (aVar.aSz > 0) {
                str6 = str6 + " / " + aVar.aSz;
            }
            this.fOf.fRt.setText(str6);
            this.fOf.fRv.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fOh.setVisibility(0);
            this.fOv.setVisibility(8);
            this.fOi.setVisibility(0);
            if (dVarArr != null) {
                this.fOj.setVisibility(0);
                this.fOu.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fOu.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aSR, 10, false);
                        textView.setText(dVar.aSS + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.fOj.setVisibility(8);
            }
        }
        this.fOf.setLayoutParams(layoutParams);
        if (aVar.aSv == aVar.aSz) {
            i = 100;
        } else if (aVar.aSv <= 0) {
            i = 0;
        } else if (aVar.aSz <= 0) {
            i = 100;
        } else if (aVar.aSv >= aVar.aSz) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aSv * 100) / aVar.aSz);
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
        this.fOf.fRu.setProgress(i);
        this.fOf.fRy.setText(aVar.aSx < 10000 ? aVar.aSx + "" : String.format("%.1f", Float.valueOf(((float) aVar.aSx) / 10000.0f)) + "万");
        String str7 = aVar.aSB;
        this.fOf.fGw.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bAE() {
        this.fOb.setVisibility(8);
        this.fOg.setVisibility(8);
        this.fOt.reset();
        this.fOt.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fOt.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fNQ != null) {
                    e.this.fNQ.onClick(view);
                }
            }
        });
        this.fOt.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fOl.setVisibility(0);
    }

    public void kP(boolean z) {
        if (this.fOn == null) {
            this.fOn = new j(this.fNT, this.liveId, this.roomId, this.axs, this.aIO, this.azm, true, false, this.isFullScreen, this.otherParams, this.fNT.getUniqueId(), null);
        }
        this.fOn.kQ(z);
        View view = this.fOn.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fOk.removeAllViews();
            this.fOk.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aPn != null) {
            this.aPn.onDestroy();
        }
        if (this.fOo != null) {
            this.fOo.recycle();
        }
        if (this.fOp != null) {
            this.fOp.recycle();
        }
        if (this.fOn != null) {
            this.fOn.aHB();
        }
        this.fNT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fNZ || view == this.fOc || view == this.fOm) {
            this.activity.finish();
        } else if (view == this.fOf.fRs) {
            if (!TextUtils.isEmpty(this.aSG)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aSG);
            }
            if (!this.azm) {
                if (this.aSI) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aIO, str, this.otherParams);
            }
        } else if (view == this.fOf.fRw) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.axs, this.liveId, this.azm, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aIO);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fOf.fRz) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.axs, this.liveId, this.azm, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aIO);
            guardClubRankActivityConfig.setAnchorInfo(this.aDo, this.aDp);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fOi) {
            if (this.aSF != null) {
                at CL = com.baidu.live.guardclub.g.CJ().CL();
                if (CL == null || CL.aDG <= 0) {
                    j = 1000;
                } else {
                    j = CL.aDG;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    rc(this.aSF.id);
                } else if (this.fNO) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aSF));
                    this.activity.finish();
                }
            }
            if (!this.azm) {
                if (TextUtils.isEmpty(this.fNI)) {
                    this.fNI = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aIO, this.fNI, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.fOq.clearFocus();
                this.fOq.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fNT.getActivity(), this.fOq);
                return;
            }
            this.activity.finish();
        } else if (view == this.fOr) {
            String obj = this.fOq.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aSF.id, obj, "");
            }
        } else if (view == this.fOf.fRr) {
            this.fOq.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fNT.getActivity(), this.fOq);
        }
    }

    public void CY(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fOf.avN.setText(str);
            this.fOq.setText("");
            this.fOq.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fNT.getActivity(), this.fOq);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fNW.getLayoutParams();
        if (z) {
            this.fNU.setVisibility(this.isFullScreen ? 0 : 8);
            this.fNV.setVisibility(0);
            String charSequence = this.fOf.avN.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fOq.setText(charSequence);
                this.fOq.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fOq.setText("");
            }
            layoutParams.bottomMargin = bAF();
        } else {
            layoutParams.bottomMargin = 0;
            this.fNV.setVisibility(8);
            this.fNU.setVisibility(0);
        }
        this.fNW.setLayoutParams(layoutParams);
    }

    protected int bAF() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fNT.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fNT.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void rc(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cA(i);
        cVar.a(this.aSF);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.dN(i);
        cVar.Da(str);
        cVar.Db(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
