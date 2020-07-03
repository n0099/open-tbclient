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
import com.baidu.live.data.as;
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
/* loaded from: classes3.dex */
public class e implements View.OnClickListener {
    private String aBT;
    private String aBU;
    private String aHt;
    private com.baidu.live.l.c aNS;
    private com.baidu.live.guardclub.a aRm;
    private String aRn;
    private boolean aRp;
    private Activity activity;
    private long awn;
    private boolean axZ;
    private View baV;
    private int cTi;
    private View fIA;
    private View fIB;
    private int fIC;
    private int fID;
    private View fIE;
    private LinearLayout fIF;
    private RelativeLayout fIG;
    private ImageView fIH;
    private ImageView fII;
    private LinearLayout fIJ;
    private GuardClubInfoHeaderView fIK;
    private RelativeLayout fIL;
    private RelativeLayout fIM;
    private TextView fIN;
    private LinearLayout fIO;
    private FrameLayout fIP;
    private RelativeLayout fIQ;
    private ImageView fIR;
    private j fIS;
    private Bitmap fIT;
    private Bitmap fIU;
    private EditText fIV;
    private TextView fIW;
    private TextView fIX;
    private CommonEmptyView fIY;
    private LinearLayout fIZ;
    private String fIn;
    private boolean fIt;
    private View.OnClickListener fIv;
    private GuardClubInfoActivity fIy;
    private View fIz;
    private LinearLayout fJa;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean ffF = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.fIy = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.awn = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aHt = str;
        this.axZ = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aRp = z3;
        this.fIt = z4;
        this.fIn = str3;
        this.isTranslucent = z5;
        this.aBT = str4;
        this.aBU = str5;
        this.fIv = onClickListener;
        if (!z3) {
            if (this.aNS == null) {
                this.aNS = new com.baidu.live.l.c();
            }
            this.aNS.initListener();
            this.aNS.refreshCurUserScores();
        }
        this.fIC = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fID = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fIy.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fIy.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fIy.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.ffF) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fIy.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void zl() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.U(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.h.V(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.fIF != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fIF.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fIF.setLayoutParams(layoutParams);
        }
        if (this.fIA != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fIA.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fIA.setLayoutParams(layoutParams2);
        }
        if (this.fIz != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fIz.getLayoutParams();
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
                gradientDrawable.setColor(this.fIC);
            } else {
                gradientDrawable.setColor(this.fID);
            }
            this.fIz.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fII != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fII.setImageBitmap(this.fIU);
            } else {
                this.fII.setImageBitmap(this.fIT);
            }
        }
        if (this.fIS != null) {
            this.fIS.zl();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bve();
        zl();
        this.fIE.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cTi = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fIE.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fIH.setVisibility(8);
                this.fIR.setVisibility(8);
            } else {
                this.fIH.setVisibility(0);
                this.fIR.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fIJ.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fIH.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fIR.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fII.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fIC);
        } else {
            this.fIE.setVisibility(0);
            this.fIH.setVisibility(8);
            this.fIR.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fIz.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fIy.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fIC);
            } else {
                gradientDrawable.setColor(this.fID);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fJa.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fJa.setLayoutParams(layoutParams2);
        }
        this.fIz.setBackgroundDrawable(gradientDrawable);
        if (this.axZ) {
            kk(false);
        } else {
            kk(this.aRp);
        }
        if (this.fIt) {
            this.fIK.fMf.setVisibility(8);
        }
        as Cj = com.baidu.live.guardclub.g.Ch().Cj();
        if (Cj != null && Cj.aCl > 0) {
            this.fIN.setText(Cj.aCl + "T豆加入");
        } else {
            this.fIN.setText("1000T豆加入");
        }
        this.fIH.setOnClickListener(this);
        this.fIK.fMc.setOnClickListener(this);
        this.fIN.setOnClickListener(this);
        this.fIR.setOnClickListener(this);
        this.fIK.fLY.setOnClickListener(this);
        this.fIK.fMf.setOnClickListener(this);
        this.fIK.fLX.setOnClickListener(this);
        this.fIW.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fIK.fLV.setIsRound(true);
        this.fIK.fLV.setDrawBorder(false);
        this.fIK.fLV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fIK.fLV.setAutoChangeStyle(false);
        this.fIK.fLV.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fIK.fLW.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.axZ) {
            if (this.aRp) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aHt, str, this.otherParams);
        }
        this.fIV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bxm();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxm() {
        if (this.fIW != null) {
            if (TextUtils.isEmpty(this.fIV.getText())) {
                this.fIW.setEnabled(false);
                this.fIX.setText(String.valueOf(0));
            } else {
                this.fIW.setEnabled(true);
                this.fIX.setText(String.valueOf(this.fIV.getText().length()));
            }
        }
        if (this.fIV.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fIV.setText(this.fIV.getText().subSequence(0, 10));
            this.fIV.setSelection(this.fIV.getText().length());
        }
    }

    private void bve() {
        this.fIF = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fIE = this.mRootView.findViewById(a.g.space_view);
        this.fIz = this.mRootView.findViewById(a.g.layout_guard_info);
        this.baV = this.mRootView.findViewById(a.g.info_layout);
        this.fIV = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fIA = this.mRootView.findViewById(a.g.input_name_layout);
        this.fIB = this.mRootView.findViewById(a.g.input_name);
        this.fIW = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fIX = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fIG = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fIH = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fII = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fIJ = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fIK = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fIL = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fIM = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fIN = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fIO = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fIP = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fIQ = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fIY = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fIR = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fIZ = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fJa = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void kk(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fII.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.axZ) {
                this.fII.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fIC);
                this.fII.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.axZ) {
            if (this.fIT == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fIT = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fIT) {
                    decodeResource.recycle();
                }
            }
            if (this.fIU == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fIU = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fIU) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fII.setImageBitmap(this.fIU);
            } else {
                this.fII.setImageBitmap(this.fIT);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fII.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fII.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fIK.getLayoutParams();
        if (z || this.axZ) {
            this.fIK.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fIM.setVisibility(8);
            this.fJa.setVisibility(0);
            this.fIN.setVisibility(8);
        } else {
            this.fIK.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fIM.setVisibility(0);
            this.fJa.setVisibility(8);
            this.fIN.setVisibility(0);
        }
        this.fIK.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aRm = aVar;
        this.aRn = str;
        if (aVar == null || aVar.id <= 0) {
            this.fIG.setVisibility(8);
            this.fIL.setVisibility(8);
            this.fIY.reset();
            this.fIY.setTitle(a.i.guard_club_no_create);
            this.fIY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fIQ.setVisibility(0);
            return;
        }
        this.fIG.setVisibility(0);
        this.fIL.setVisibility(0);
        this.fIQ.setVisibility(8);
        kk(z);
        this.fIK.fLV.startLoad(aVar.aRh, 12, false);
        this.fIK.fLW.startLoad(com.baidu.live.guardclub.g.Ch().cw(aVar.aRf), 10, false);
        boolean z2 = false;
        if (this.axZ && aVar.aRj != null) {
            z2 = aVar.aRj.optInt("can_update_name", 0) == 1;
        }
        int width = this.fIK.fJl.getWidth();
        if (width <= 0) {
            this.fIK.fJl.measure(0, 0);
            width = this.fIK.fJl.getMeasuredWidth();
        }
        String str3 = aVar.aRa;
        int i2 = 0;
        if (z2) {
            this.fIK.fLX.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fIK.fLX.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fIK.aXZ.setPadding(0, 0, width + i2, 0);
            this.fIK.fJl.setPadding(0, 0, i2, 0);
            this.fIK.fJl.setVisibility(0);
        } else {
            this.fIK.aXZ.setPadding(0, 0, i2, 0);
            this.fIK.fJl.setPadding(0, 0, i2, 0);
            this.fIK.fJl.setVisibility(4);
            str2 = str3;
        }
        this.fIK.aXZ.setText(str2);
        String cy = com.baidu.live.guardclub.g.Ch().cy(aVar.aRf);
        String str4 = (cy == null || "null".equals(cy)) ? "" : cy;
        Resources resources = this.fIK.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIK.getLayoutParams();
        if (z || this.axZ) {
            this.fIK.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aRc;
            if (aVar.aRg > 0) {
                str5 = str5 + " / " + aVar.aRg;
            }
            this.fIK.fLZ.setText(str5);
            this.fIK.fMb.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fIM.setVisibility(8);
            this.fJa.setVisibility(0);
            this.fIN.setVisibility(8);
            kl(this.fIt);
        } else {
            this.fIK.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aRc;
            if (aVar.aRg > 0) {
                str6 = str6 + " / " + aVar.aRg;
            }
            this.fIK.fLZ.setText(str6);
            this.fIK.fMb.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fIM.setVisibility(0);
            this.fJa.setVisibility(8);
            this.fIN.setVisibility(0);
            if (dVarArr != null) {
                this.fIO.setVisibility(0);
                this.fIZ.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fIZ.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aRy, 10, false);
                        textView.setText(dVar.aRz + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.fIO.setVisibility(8);
            }
        }
        this.fIK.setLayoutParams(layoutParams);
        if (aVar.aRc == aVar.aRg) {
            i = 100;
        } else if (aVar.aRc <= 0) {
            i = 0;
        } else if (aVar.aRg <= 0) {
            i = 100;
        } else if (aVar.aRc >= aVar.aRg) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aRc * 100) / aVar.aRg);
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
        this.fIK.fMa.setProgress(i);
        this.fIK.fMe.setText(aVar.aRe < 10000 ? aVar.aRe + "" : String.format("%.1f", Float.valueOf(((float) aVar.aRe) / 10000.0f)) + "万");
        String str7 = aVar.aRi;
        this.fIK.fBm.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bxn() {
        this.fIG.setVisibility(8);
        this.fIL.setVisibility(8);
        this.fIY.reset();
        this.fIY.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fIY.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fIv != null) {
                    e.this.fIv.onClick(view);
                }
            }
        });
        this.fIY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fIQ.setVisibility(0);
    }

    public void kl(boolean z) {
        if (this.fIS == null) {
            this.fIS = new j(this.fIy, this.liveId, this.roomId, this.awn, this.aHt, this.axZ, true, false, this.isFullScreen, this.otherParams, this.fIy.getUniqueId(), null);
        }
        this.fIS.km(z);
        View view = this.fIS.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fIP.removeAllViews();
            this.fIP.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aNS != null) {
            this.aNS.onDestroy();
        }
        if (this.fIT != null) {
            this.fIT.recycle();
        }
        if (this.fIU != null) {
            this.fIU.recycle();
        }
        if (this.fIS != null) {
            this.fIS.aDK();
        }
        this.fIy.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fIE || view == this.fIH || view == this.fIR) {
            this.activity.finish();
        } else if (view == this.fIK.fLY) {
            if (!TextUtils.isEmpty(this.aRn)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aRn);
            }
            if (!this.axZ) {
                if (this.aRp) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aHt, str, this.otherParams);
            }
        } else if (view == this.fIK.fMc) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.awn, this.liveId, this.axZ, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aHt);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fIK.fMf) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.awn, this.liveId, this.axZ, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aHt);
            guardClubRankActivityConfig.setAnchorInfo(this.aBT, this.aBU);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fIN) {
            if (this.aRm != null) {
                as Cj = com.baidu.live.guardclub.g.Ch().Cj();
                if (Cj == null || Cj.aCl <= 0) {
                    j = 1000;
                } else {
                    j = Cj.aCl;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    qM(this.aRm.id);
                } else if (this.fIt) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aRm));
                    this.activity.finish();
                }
            }
            if (!this.axZ) {
                if (TextUtils.isEmpty(this.fIn)) {
                    this.fIn = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aHt, this.fIn, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.fIV.clearFocus();
                this.fIV.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fIy.getActivity(), this.fIV);
                return;
            }
            this.activity.finish();
        } else if (view == this.fIW) {
            String obj = this.fIV.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aRm.id, obj, "");
            }
        } else if (view == this.fIK.fLX) {
            this.fIV.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fIy.getActivity(), this.fIV);
        }
    }

    public void Cm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fIK.aXZ.setText(str);
            this.fIV.setText("");
            this.fIV.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fIy.getActivity(), this.fIV);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIB.getLayoutParams();
        if (z) {
            this.fIz.setVisibility(this.isFullScreen ? 0 : 8);
            this.fIA.setVisibility(0);
            String charSequence = this.fIK.aXZ.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fIV.setText(charSequence);
                this.fIV.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fIV.setText("");
            }
            layoutParams.bottomMargin = bxo();
        } else {
            layoutParams.bottomMargin = 0;
            this.fIA.setVisibility(8);
            this.fIz.setVisibility(0);
        }
        this.fIB.setLayoutParams(layoutParams);
    }

    protected int bxo() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fIy.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fIy.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void qM(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cu(i);
        cVar.a(this.aRm);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.dz(i);
        cVar.Co(str);
        cVar.Cp(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
