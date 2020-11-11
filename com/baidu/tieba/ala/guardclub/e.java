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
import com.baidu.live.data.bf;
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
    private boolean aKf;
    private String aOD;
    private String aOE;
    private String aVy;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.m.c bcR;
    private String bgA;
    private boolean bgC;
    private com.baidu.live.guardclub.a bgz;
    private View bpO;
    private int dJG;
    private RelativeLayout gFA;
    private ImageView gFB;
    private ImageView gFC;
    private LinearLayout gFD;
    private GuardClubInfoHeaderView gFE;
    private RelativeLayout gFF;
    private RelativeLayout gFG;
    private TextView gFH;
    private LinearLayout gFI;
    private FrameLayout gFJ;
    private RelativeLayout gFK;
    private ImageView gFL;
    private j gFM;
    private Bitmap gFN;
    private Bitmap gFO;
    private EditText gFP;
    private TextView gFQ;
    private TextView gFR;
    private CommonEmptyView gFS;
    private LinearLayout gFT;
    private LinearLayout gFU;
    private String gFh;
    private boolean gFn;
    private View.OnClickListener gFp;
    private GuardClubInfoActivity gFs;
    private View gFt;
    private View gFu;
    private View gFv;
    private int gFw;
    private int gFx;
    private View gFy;
    private LinearLayout gFz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bFL = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gFs = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aVy = str;
        this.aKf = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bgC = z3;
        this.gFn = z4;
        this.gFh = str3;
        this.isTranslucent = z5;
        this.aOD = str4;
        this.aOE = str5;
        this.gFp = onClickListener;
        if (!z3) {
            if (this.bcR == null) {
                this.bcR = new com.baidu.live.m.c();
            }
            this.bcR.initListener();
            this.bcR.refreshCurUserScores();
        }
        this.gFw = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gFx = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.gFs.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.gFs.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.gFs.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.bFL) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gFs.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void HJ() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.i.ae(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.i.af(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.gFz != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gFz.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gFz.setLayoutParams(layoutParams);
        }
        if (this.gFu != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gFu.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gFu.setLayoutParams(layoutParams2);
        }
        if (this.gFt != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gFt.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (this.isFullScreen) {
                    layoutParams3.height = -1;
                } else {
                    layoutParams3.height = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds854);
                }
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams3.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gFw);
            } else {
                gradientDrawable.setColor(this.gFx);
            }
            this.gFt.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gFC != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gFC.setImageBitmap(this.gFO);
            } else {
                this.gFC.setImageBitmap(this.gFN);
            }
        }
        if (this.gFM != null) {
            this.gFM.HJ();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bQj();
        HJ();
        this.gFy.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dJG = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gFy.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFB.setVisibility(8);
                this.gFL.setVisibility(8);
            } else {
                this.gFB.setVisibility(0);
                this.gFL.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gFD.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gFB.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gFL.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gFC.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gFw);
        } else {
            this.gFy.setVisibility(0);
            this.gFB.setVisibility(8);
            this.gFL.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gFt.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gFs.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gFw);
            } else {
                gradientDrawable.setColor(this.gFx);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gFU.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gFU.setLayoutParams(layoutParams2);
        }
        this.gFt.setBackgroundDrawable(gradientDrawable);
        if (this.aKf) {
            mp(false);
        } else {
            mp(this.bgC);
        }
        if (this.gFn) {
            this.gFE.gIU.setVisibility(8);
        }
        bf KH = com.baidu.live.guardclub.g.KF().KH();
        if (KH != null && KH.aOV > 0) {
            this.gFH.setText(KH.aOV + "T豆加入");
        } else {
            this.gFH.setText("1000T豆加入");
        }
        this.gFB.setOnClickListener(this);
        this.gFE.gIR.setOnClickListener(this);
        this.gFH.setOnClickListener(this);
        this.gFL.setOnClickListener(this);
        this.gFE.gIN.setOnClickListener(this);
        this.gFE.gIU.setOnClickListener(this);
        this.gFE.gIM.setOnClickListener(this);
        this.gFQ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gFE.gIK.setIsRound(true);
        this.gFE.gIK.setDrawBorder(false);
        this.gFE.gIK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFE.gIK.setAutoChangeStyle(false);
        this.gFE.gIK.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gFE.gIL.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aKf) {
            if (this.bgC) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aVy, str, this.otherParams);
        }
        this.gFP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bSY();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSY() {
        if (this.gFQ != null) {
            if (TextUtils.isEmpty(this.gFP.getText())) {
                this.gFQ.setEnabled(false);
                this.gFR.setText(String.valueOf(0));
            } else {
                this.gFQ.setEnabled(true);
                this.gFR.setText(String.valueOf(this.gFP.getText().length()));
            }
        }
        if (this.gFP.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gFP.setText(this.gFP.getText().subSequence(0, 10));
            this.gFP.setSelection(this.gFP.getText().length());
        }
    }

    private void bQj() {
        this.gFz = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gFy = this.mRootView.findViewById(a.f.space_view);
        this.gFt = this.mRootView.findViewById(a.f.layout_guard_info);
        this.bpO = this.mRootView.findViewById(a.f.info_layout);
        this.gFP = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gFu = this.mRootView.findViewById(a.f.input_name_layout);
        this.gFv = this.mRootView.findViewById(a.f.input_name);
        this.gFQ = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gFR = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gFA = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gFB = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gFC = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gFD = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gFE = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gFF = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gFG = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gFH = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gFI = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gFJ = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gFK = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gFS = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gFL = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gFT = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gFU = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void mp(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFC.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aKf) {
                this.gFC.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gFw);
                this.gFC.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aKf) {
            if (this.gFN == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gFN = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gFN) {
                    decodeResource.recycle();
                }
            }
            if (this.gFO == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gFO = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gFO) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gFC.setImageBitmap(this.gFO);
            } else {
                this.gFC.setImageBitmap(this.gFN);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gFC.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gFC.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFE.getLayoutParams();
        if (z || this.aKf) {
            this.gFE.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gFG.setVisibility(8);
            this.gFU.setVisibility(0);
            this.gFH.setVisibility(8);
        } else {
            this.gFE.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gFG.setVisibility(0);
            this.gFU.setVisibility(8);
            this.gFH.setVisibility(0);
        }
        this.gFE.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bgz = aVar;
        this.bgA = str;
        if (aVar == null || aVar.id <= 0) {
            this.gFA.setVisibility(8);
            this.gFF.setVisibility(8);
            this.gFS.reset();
            this.gFS.setTitle(a.h.guard_club_no_create);
            this.gFS.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gFK.setVisibility(0);
            return;
        }
        this.gFA.setVisibility(0);
        this.gFF.setVisibility(0);
        this.gFK.setVisibility(8);
        mp(z);
        this.gFE.gIK.startLoad(aVar.bgu, 12, false);
        this.gFE.gIL.startLoad(com.baidu.live.guardclub.g.KF().eC(aVar.bgr), 10, false);
        boolean z2 = false;
        if (this.aKf && aVar.bgw != null) {
            z2 = aVar.bgw.optInt("can_update_name", 0) == 1;
        }
        int width = this.gFE.gGf.getWidth();
        if (width <= 0) {
            this.gFE.gGf.measure(0, 0);
            width = this.gFE.gGf.getMeasuredWidth();
        }
        String str3 = aVar.bgm;
        int i2 = 0;
        if (z2) {
            this.gFE.gIM.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gFE.gIM.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gFE.aFA.setPadding(0, 0, width + i2, 0);
            this.gFE.gGf.setPadding(0, 0, i2, 0);
            this.gFE.gGf.setVisibility(0);
        } else {
            this.gFE.aFA.setPadding(0, 0, i2, 0);
            this.gFE.gGf.setPadding(0, 0, i2, 0);
            this.gFE.gGf.setVisibility(4);
            str2 = str3;
        }
        this.gFE.aFA.setText(str2);
        String eE = com.baidu.live.guardclub.g.KF().eE(aVar.bgr);
        String str4 = (eE == null || "null".equals(eE)) ? "" : eE;
        Resources resources = this.gFE.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFE.getLayoutParams();
        if (z || this.aKf) {
            this.gFE.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.bgo;
            if (aVar.bgt > 0) {
                str5 = str5 + " / " + aVar.bgt;
            }
            this.gFE.gIO.setText(str5);
            this.gFE.gIQ.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gFG.setVisibility(8);
            this.gFU.setVisibility(0);
            this.gFH.setVisibility(8);
            mq(this.gFn);
        } else {
            this.gFE.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bgo;
            if (aVar.bgt > 0) {
                str6 = str6 + " / " + aVar.bgt;
            }
            this.gFE.gIO.setText(str6);
            this.gFE.gIQ.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gFG.setVisibility(0);
            this.gFU.setVisibility(8);
            this.gFH.setVisibility(0);
            if (dVarArr != null) {
                this.gFI.setVisibility(0);
                this.gFT.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gFT.addView(view, layoutParams2);
                    } else {
                        view = view2;
                    }
                    if (view == null) {
                        break;
                    }
                    if (i3 % 4 == 0) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon1);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle1);
                    } else if (i3 % 4 == 1) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon2);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle2);
                    } else if (i3 % 4 == 2) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon3);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle3);
                    } else {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon4);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle4);
                    }
                    com.baidu.live.guardclub.d dVar = dVarArr[i3];
                    if (dVar != null) {
                        tbImageView.startLoad(dVar.bgL, 10, false);
                        textView.setText(dVar.bgM + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gFI.setVisibility(8);
            }
        }
        this.gFE.setLayoutParams(layoutParams);
        if (aVar.bgo == aVar.bgt) {
            i = 100;
        } else if (aVar.bgo <= 0) {
            i = 0;
        } else if (aVar.bgt <= 0) {
            i = 100;
        } else if (aVar.bgo >= aVar.bgt) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bgo * 100) / aVar.bgt);
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
        this.gFE.gIP.setProgress(i);
        this.gFE.gIT.setText(aVar.bgq < 10000 ? aVar.bgq + "" : String.format("%.1f", Float.valueOf(((float) aVar.bgq) / 10000.0f)) + "万");
        String str7 = aVar.bgv;
        this.gFE.gxm.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bSZ() {
        this.gFA.setVisibility(8);
        this.gFF.setVisibility(8);
        this.gFS.reset();
        this.gFS.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gFS.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gFp != null) {
                    e.this.gFp.onClick(view);
                }
            }
        });
        this.gFS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gFK.setVisibility(0);
    }

    public void mq(boolean z) {
        if (this.gFM == null) {
            this.gFM = new j(this.gFs, this.liveId, this.roomId, this.anchorId, this.aVy, this.aKf, true, false, this.isFullScreen, this.otherParams, this.gFs.getUniqueId(), null);
        }
        this.gFM.mr(z);
        View view = this.gFM.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gFJ.removeAllViews();
            this.gFJ.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bcR != null) {
            this.bcR.onDestroy();
        }
        if (this.gFN != null) {
            this.gFN.recycle();
        }
        if (this.gFO != null) {
            this.gFO.recycle();
        }
        if (this.gFM != null) {
            this.gFM.aYg();
        }
        this.gFs.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gFy || view == this.gFB || view == this.gFL) {
            this.activity.finish();
        } else if (view == this.gFE.gIN) {
            if (!TextUtils.isEmpty(this.bgA)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bgA);
            }
            if (!this.aKf) {
                if (this.bgC) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aVy, str, this.otherParams);
            }
        } else if (view == this.gFE.gIR) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aKf, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aVy);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gFE.gIU) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.anchorId, this.liveId, this.aKf, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aVy);
            guardClubRankActivityConfig.setAnchorInfo(this.aOD, this.aOE);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gFH) {
            if (this.bgz != null) {
                bf KH = com.baidu.live.guardclub.g.KF().KH();
                if (KH == null || KH.aOV <= 0) {
                    j = 1000;
                } else {
                    j = KH.aOV;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    uH(this.bgz.id);
                } else if (this.gFn) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bgz));
                    this.activity.finish();
                }
            }
            if (!this.aKf) {
                if (TextUtils.isEmpty(this.gFh)) {
                    this.gFh = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aVy, this.gFh, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gFP.clearFocus();
                this.gFP.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gFs.getActivity(), this.gFP);
                return;
            }
            this.activity.finish();
        } else if (view == this.gFQ) {
            String obj = this.gFP.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                i(this.bgz.id, obj, "");
            }
        } else if (view == this.gFE.gIM) {
            this.gFP.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gFs.getActivity(), this.gFP);
        }
    }

    public void Ho(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gFE.aFA.setText(str);
            this.gFP.setText("");
            this.gFP.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.gFs.getActivity(), this.gFP);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFv.getLayoutParams();
        if (z) {
            this.gFt.setVisibility(this.isFullScreen ? 0 : 8);
            this.gFu.setVisibility(0);
            String charSequence = this.gFE.aFA.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gFP.setText(charSequence);
                this.gFP.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gFP.setText("");
            }
            layoutParams.bottomMargin = bTa();
        } else {
            layoutParams.bottomMargin = 0;
            this.gFu.setVisibility(8);
            this.gFt.setVisibility(0);
        }
        this.gFv.setLayoutParams(layoutParams);
    }

    protected int bTa() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.gFs.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.gFs.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void uH(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eA(i);
        cVar.a(this.bgz);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void i(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.eG(i);
        cVar.Hp(str);
        cVar.Hq(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
