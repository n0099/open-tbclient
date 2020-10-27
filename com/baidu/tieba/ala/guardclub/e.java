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
import com.baidu.live.data.bd;
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
    private boolean aJi;
    private String aNA;
    private String aNB;
    private String aUg;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.m.c bby;
    private com.baidu.live.guardclub.a bfe;
    private String bff;
    private boolean bfh;
    private View bov;
    private int dDO;
    private Bitmap gAa;
    private EditText gAb;
    private TextView gAc;
    private TextView gAd;
    private CommonEmptyView gAe;
    private LinearLayout gAf;
    private LinearLayout gAg;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private View.OnClickListener gzB;
    private GuardClubInfoActivity gzE;
    private View gzF;
    private View gzG;
    private View gzH;
    private int gzI;
    private int gzJ;
    private View gzK;
    private LinearLayout gzL;
    private RelativeLayout gzM;
    private ImageView gzN;
    private ImageView gzO;
    private LinearLayout gzP;
    private GuardClubInfoHeaderView gzQ;
    private RelativeLayout gzR;
    private RelativeLayout gzS;
    private TextView gzT;
    private LinearLayout gzU;
    private FrameLayout gzV;
    private RelativeLayout gzW;
    private ImageView gzX;
    private j gzY;
    private Bitmap gzZ;
    private String gzt;
    private boolean gzz;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bzA = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gzE = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aUg = str;
        this.aJi = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bfh = z3;
        this.gzz = z4;
        this.gzt = str3;
        this.isTranslucent = z5;
        this.aNA = str4;
        this.aNB = str5;
        this.gzB = onClickListener;
        if (!z3) {
            if (this.bby == null) {
                this.bby = new com.baidu.live.m.c();
            }
            this.bby.initListener();
            this.bby.refreshCurUserScores();
        }
        this.gzI = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.gzJ = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.gzE.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.gzE.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.gzE.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.bzA) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gzE.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void Hi() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.i.aa(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.i.ab(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.gzL != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzL.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gzL.setLayoutParams(layoutParams);
        }
        if (this.gzG != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gzG.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gzG.setLayoutParams(layoutParams2);
        }
        if (this.gzF != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gzF.getLayoutParams();
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
                gradientDrawable.setColor(this.gzI);
            } else {
                gradientDrawable.setColor(this.gzJ);
            }
            this.gzF.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gzO != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gzO.setImageBitmap(this.gAa);
            } else {
                this.gzO.setImageBitmap(this.gzZ);
            }
        }
        if (this.gzY != null) {
            this.gzY.Hi();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bNJ();
        Hi();
        this.gzK.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dDO = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gzK.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gzN.setVisibility(8);
                this.gzX.setVisibility(8);
            } else {
                this.gzN.setVisibility(0);
                this.gzX.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gzP.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gzN.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gzX.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gzO.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.gzI);
        } else {
            this.gzK.setVisibility(0);
            this.gzN.setVisibility(8);
            this.gzX.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gzF.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gzE.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gzI);
            } else {
                gradientDrawable.setColor(this.gzJ);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gAg.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.gAg.setLayoutParams(layoutParams2);
        }
        this.gzF.setBackgroundDrawable(gradientDrawable);
        if (this.aJi) {
            mg(false);
        } else {
            mg(this.bfh);
        }
        if (this.gzz) {
            this.gzQ.gDg.setVisibility(8);
        }
        bd Kh = com.baidu.live.guardclub.g.Kf().Kh();
        if (Kh != null && Kh.aNS > 0) {
            this.gzT.setText(Kh.aNS + "T豆加入");
        } else {
            this.gzT.setText("1000T豆加入");
        }
        this.gzN.setOnClickListener(this);
        this.gzQ.gDd.setOnClickListener(this);
        this.gzT.setOnClickListener(this);
        this.gzX.setOnClickListener(this);
        this.gzQ.gCZ.setOnClickListener(this);
        this.gzQ.gDg.setOnClickListener(this);
        this.gzQ.gCY.setOnClickListener(this);
        this.gAc.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gzQ.gCW.setIsRound(true);
        this.gzQ.gCW.setDrawBorder(false);
        this.gzQ.gCW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gzQ.gCW.setAutoChangeStyle(false);
        this.gzQ.gCW.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gzQ.gCX.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aJi) {
            if (this.bfh) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aUg, str, this.otherParams);
        }
        this.gAb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bQy();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQy() {
        if (this.gAc != null) {
            if (TextUtils.isEmpty(this.gAb.getText())) {
                this.gAc.setEnabled(false);
                this.gAd.setText(String.valueOf(0));
            } else {
                this.gAc.setEnabled(true);
                this.gAd.setText(String.valueOf(this.gAb.getText().length()));
            }
        }
        if (this.gAb.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.gAb.setText(this.gAb.getText().subSequence(0, 10));
            this.gAb.setSelection(this.gAb.getText().length());
        }
    }

    private void bNJ() {
        this.gzL = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.gzK = this.mRootView.findViewById(a.g.space_view);
        this.gzF = this.mRootView.findViewById(a.g.layout_guard_info);
        this.bov = this.mRootView.findViewById(a.g.info_layout);
        this.gAb = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.gzG = this.mRootView.findViewById(a.g.input_name_layout);
        this.gzH = this.mRootView.findViewById(a.g.input_name);
        this.gAc = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.gAd = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.gzM = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.gzN = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.gzO = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.gzP = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.gzQ = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.gzR = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.gzS = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.gzT = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.gzU = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.gzV = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.gzW = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.gAe = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.gzX = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.gAf = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.gAg = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void mg(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzO.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aJi) {
                this.gzO.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gzI);
                this.gzO.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aJi) {
            if (this.gzZ == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gzZ = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.gzZ) {
                    decodeResource.recycle();
                }
            }
            if (this.gAa == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gAa = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.gAa) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gzO.setImageBitmap(this.gAa);
            } else {
                this.gzO.setImageBitmap(this.gzZ);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gzO.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.gzO.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gzQ.getLayoutParams();
        if (z || this.aJi) {
            this.gzQ.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gzS.setVisibility(8);
            this.gAg.setVisibility(0);
            this.gzT.setVisibility(8);
        } else {
            this.gzQ.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gzS.setVisibility(0);
            this.gAg.setVisibility(8);
            this.gzT.setVisibility(0);
        }
        this.gzQ.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bfe = aVar;
        this.bff = str;
        if (aVar == null || aVar.id <= 0) {
            this.gzM.setVisibility(8);
            this.gzR.setVisibility(8);
            this.gAe.reset();
            this.gAe.setTitle(a.i.guard_club_no_create);
            this.gAe.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gzW.setVisibility(0);
            return;
        }
        this.gzM.setVisibility(0);
        this.gzR.setVisibility(0);
        this.gzW.setVisibility(8);
        mg(z);
        this.gzQ.gCW.startLoad(aVar.beY, 12, false);
        this.gzQ.gCX.startLoad(com.baidu.live.guardclub.g.Kf().eC(aVar.beW), 10, false);
        boolean z2 = false;
        if (this.aJi && aVar.bfa != null) {
            z2 = aVar.bfa.optInt("can_update_name", 0) == 1;
        }
        int width = this.gzQ.gAr.getWidth();
        if (width <= 0) {
            this.gzQ.gAr.measure(0, 0);
            width = this.gzQ.gAr.getMeasuredWidth();
        }
        String str3 = aVar.beR;
        int i2 = 0;
        if (z2) {
            this.gzQ.gCY.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.gzQ.gCY.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gzQ.aEK.setPadding(0, 0, width + i2, 0);
            this.gzQ.gAr.setPadding(0, 0, i2, 0);
            this.gzQ.gAr.setVisibility(0);
        } else {
            this.gzQ.aEK.setPadding(0, 0, i2, 0);
            this.gzQ.gAr.setPadding(0, 0, i2, 0);
            this.gzQ.gAr.setVisibility(4);
            str2 = str3;
        }
        this.gzQ.aEK.setText(str2);
        String eE = com.baidu.live.guardclub.g.Kf().eE(aVar.beW);
        String str4 = (eE == null || "null".equals(eE)) ? "" : eE;
        Resources resources = this.gzQ.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzQ.getLayoutParams();
        if (z || this.aJi) {
            this.gzQ.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.beT;
            if (aVar.beX > 0) {
                str5 = str5 + " / " + aVar.beX;
            }
            this.gzQ.gDa.setText(str5);
            this.gzQ.gDc.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gzS.setVisibility(8);
            this.gAg.setVisibility(0);
            this.gzT.setVisibility(8);
            mh(this.gzz);
        } else {
            this.gzQ.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.beT;
            if (aVar.beX > 0) {
                str6 = str6 + " / " + aVar.beX;
            }
            this.gzQ.gDa.setText(str6);
            this.gzQ.gDc.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gzS.setVisibility(0);
            this.gAg.setVisibility(8);
            this.gzT.setVisibility(0);
            if (dVarArr != null) {
                this.gzU.setVisibility(0);
                this.gAf.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gAf.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.bfq, 10, false);
                        textView.setText(dVar.bfr + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gzU.setVisibility(8);
            }
        }
        this.gzQ.setLayoutParams(layoutParams);
        if (aVar.beT == aVar.beX) {
            i = 100;
        } else if (aVar.beT <= 0) {
            i = 0;
        } else if (aVar.beX <= 0) {
            i = 100;
        } else if (aVar.beT >= aVar.beX) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.beT * 100) / aVar.beX);
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
        this.gzQ.gDb.setProgress(i);
        this.gzQ.gDf.setText(aVar.beV < 10000 ? aVar.beV + "" : String.format("%.1f", Float.valueOf(((float) aVar.beV) / 10000.0f)) + "万");
        String str7 = aVar.beZ;
        this.gzQ.gry.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bQz() {
        this.gzM.setVisibility(8);
        this.gzR.setVisibility(8);
        this.gAe.reset();
        this.gAe.setTitle(a.i.sdk_net_fail_tip_rank);
        this.gAe.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gzB != null) {
                    e.this.gzB.onClick(view);
                }
            }
        });
        this.gAe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gzW.setVisibility(0);
    }

    public void mh(boolean z) {
        if (this.gzY == null) {
            this.gzY = new j(this.gzE, this.liveId, this.roomId, this.anchorId, this.aUg, this.aJi, true, false, this.isFullScreen, this.otherParams, this.gzE.getUniqueId(), null);
        }
        this.gzY.mi(z);
        View view = this.gzY.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gzV.removeAllViews();
            this.gzV.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bby != null) {
            this.bby.onDestroy();
        }
        if (this.gzZ != null) {
            this.gzZ.recycle();
        }
        if (this.gAa != null) {
            this.gAa.recycle();
        }
        if (this.gzY != null) {
            this.gzY.aVG();
        }
        this.gzE.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gzK || view == this.gzN || view == this.gzX) {
            this.activity.finish();
        } else if (view == this.gzQ.gCZ) {
            if (!TextUtils.isEmpty(this.bff)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bff);
            }
            if (!this.aJi) {
                if (this.bfh) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aUg, str, this.otherParams);
            }
        } else if (view == this.gzQ.gDd) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aJi, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aUg);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gzQ.gDg) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.anchorId, this.liveId, this.aJi, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aUg);
            guardClubRankActivityConfig.setAnchorInfo(this.aNA, this.aNB);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gzT) {
            if (this.bfe != null) {
                bd Kh = com.baidu.live.guardclub.g.Kf().Kh();
                if (Kh == null || Kh.aNS <= 0) {
                    j = 1000;
                } else {
                    j = Kh.aNS;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    ux(this.bfe.id);
                } else if (this.gzz) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bfe));
                    this.activity.finish();
                }
            }
            if (!this.aJi) {
                if (TextUtils.isEmpty(this.gzt)) {
                    this.gzt = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aUg, this.gzt, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gAb.clearFocus();
                this.gAb.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gzE.getActivity(), this.gAb);
                return;
            }
            this.activity.finish();
        } else if (view == this.gAc) {
            String obj = this.gAb.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                i(this.bfe.id, obj, "");
            }
        } else if (view == this.gzQ.gCY) {
            this.gAb.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gzE.getActivity(), this.gAb);
        }
    }

    public void Hb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gzQ.aEK.setText(str);
            this.gAb.setText("");
            this.gAb.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.gzE.getActivity(), this.gAb);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzH.getLayoutParams();
        if (z) {
            this.gzF.setVisibility(this.isFullScreen ? 0 : 8);
            this.gzG.setVisibility(0);
            String charSequence = this.gzQ.aEK.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gAb.setText(charSequence);
                this.gAb.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gAb.setText("");
            }
            layoutParams.bottomMargin = bQA();
        } else {
            layoutParams.bottomMargin = 0;
            this.gzG.setVisibility(8);
            this.gzF.setVisibility(0);
        }
        this.gzH.setLayoutParams(layoutParams);
    }

    protected int bQA() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.gzE.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.gzE.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void ux(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eA(i);
        cVar.a(this.bfe);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void i(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.ek(i);
        cVar.Hc(str);
        cVar.Hd(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
