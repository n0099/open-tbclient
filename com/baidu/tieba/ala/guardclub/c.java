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
import com.baidu.live.data.z;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private long Of;
    private boolean Pr;
    private String WE;
    private com.baidu.live.e.b acb;
    private Activity activity;
    private int dKA;
    private View dKB;
    private LinearLayout dKC;
    private RelativeLayout dKD;
    private ImageView dKE;
    private ImageView dKF;
    private GuardClubInfoHeaderView dKG;
    private RelativeLayout dKH;
    private RelativeLayout dKI;
    private TextView dKJ;
    private LinearLayout dKK;
    private FrameLayout dKL;
    private RelativeLayout dKM;
    private ImageView dKN;
    private h dKO;
    private String dKP;
    private Bitmap dKQ;
    private Bitmap dKR;
    private boolean dKS;
    private String dKT;
    private EditText dKU;
    private TextView dKV;
    private TextView dKW;
    private CommonEmptyView dKX;
    private LinearLayout dKY;
    private LinearLayout dKZ;
    private boolean dKl;
    private com.baidu.tieba.ala.guardclub.model.c dKm;
    private View.OnClickListener dKo;
    private GuardClubInfoActivity dKt;
    private View dKu;
    private View dKv;
    private View dKw;
    private View dKx;
    private View dKy;
    private int dKz;
    private ViewTreeObserver.OnGlobalLayoutListener dLb;
    private int dLc;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean dLa = true;
    private boolean YF = false;

    public c(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.dKt = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.Of = j;
        this.liveId = j2;
        this.roomId = j3;
        this.WE = str;
        this.Pr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.dKS = z3;
        this.dKl = z4;
        this.dKT = str3;
        this.isTranslucent = z5;
        this.dKo = onClickListener;
        if (!z3) {
            if (this.acb == null) {
                this.acb = new com.baidu.live.e.b();
            }
            this.acb.initListener();
            this.acb.refreshCurUserScores();
        }
        this.dKz = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.dKA = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.dLb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.c.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                c.this.dKt.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(c.this.dKt.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(c.this.dKt.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !c.this.YF && c.this.dLa) {
                    c.this.YF = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    c.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.YF) {
                    c.this.YF = false;
                    c.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dKt.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLb);
    }

    public void qa() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.g.P(this.mRootView);
                q.d(this.activity, false);
            } else {
                com.baidu.live.utils.g.Q(this.mRootView);
                q.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.dKC != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dKC.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.dKC.setLayoutParams(layoutParams);
        }
        if (this.dKw != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dKw.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.dKw.setLayoutParams(layoutParams2);
        }
        if (this.dKu != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.dKu.getLayoutParams();
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
                gradientDrawable.setColor(this.dKz);
            } else {
                gradientDrawable.setColor(this.dKA);
            }
            this.dKu.setBackgroundDrawable(gradientDrawable);
        }
        if (this.dKF != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.dKF.setImageBitmap(this.dKR);
            } else {
                this.dKF.setImageBitmap(this.dKQ);
            }
        }
        if (this.dKO != null) {
            this.dKO.qa();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        aLh();
        qa();
        this.dKB.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dLc = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.dKB.setVisibility(8);
            this.dKE.setVisibility(0);
            this.dKN.setVisibility(0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                ((LinearLayout.LayoutParams) this.dKE.getLayoutParams()).topMargin = statusBarHeight;
                ((RelativeLayout.LayoutParams) this.dKN.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.dKF.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.dKz);
        } else {
            this.dKB.setVisibility(0);
            this.dKE.setVisibility(8);
            this.dKN.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.dKu.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.dKt.getPageContext().getPageActivity()) == 1) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.dKz);
            } else {
                gradientDrawable.setColor(this.dKA);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dKZ.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.dKZ.setLayoutParams(layoutParams2);
        }
        this.dKu.setBackgroundDrawable(gradientDrawable);
        if (this.Pr) {
            hc(false);
        } else {
            hc(this.dKS);
        }
        if (this.dKl) {
            this.dKG.dON.setVisibility(8);
        }
        z aLx = m.aLv().aLx();
        if (aLx != null && aLx.Tl > 0) {
            this.dKJ.setText(aLx.Tl + "T豆加入");
        } else {
            this.dKJ.setText("1000T豆加入");
        }
        this.dKE.setOnClickListener(this);
        this.dKG.dOK.setOnClickListener(this);
        this.dKJ.setOnClickListener(this);
        this.dKN.setOnClickListener(this);
        this.dKG.dOG.setOnClickListener(this);
        this.dKG.dON.setOnClickListener(this);
        this.dKG.dOF.setOnClickListener(this);
        this.dKV.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.dKG.dOD.setIsRound(true);
        this.dKG.dOD.setDrawBorder(false);
        this.dKG.dOD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dKG.dOD.setAutoChangeStyle(false);
        this.dKG.dOD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dKG.dOE.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.Pr) {
            if (this.dKS) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.WE, str, this.otherParams);
        }
        this.dKU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                c.this.tJ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        if (this.dKV != null) {
            if (TextUtils.isEmpty(this.dKU.getText())) {
                this.dKV.setEnabled(false);
                this.dKy.setVisibility(0);
                this.dKW.setText(String.valueOf(0));
            } else {
                this.dKV.setEnabled(true);
                this.dKy.setVisibility(8);
                this.dKW.setText(String.valueOf(this.dKU.getText().length()));
            }
        }
        if (this.dKU.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.dKU.setText(this.dKU.getText().subSequence(0, 10));
            this.dKU.setSelection(this.dKU.getText().length());
        }
    }

    private void aLh() {
        this.dKC = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.dKB = this.mRootView.findViewById(a.g.space_view);
        this.dKu = this.mRootView.findViewById(a.g.layout_guard_info);
        this.dKv = this.mRootView.findViewById(a.g.info_layout);
        this.dKU = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.dKw = this.mRootView.findViewById(a.g.input_name_layout);
        this.dKx = this.mRootView.findViewById(a.g.input_name);
        this.dKy = this.mRootView.findViewById(a.g.mask_send);
        this.dKV = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.dKW = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.dKD = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.dKE = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.dKF = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.dKG = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.dKH = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.dKI = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.dKJ = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.dKK = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.dKL = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.dKM = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.dKX = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.dKN = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.dKY = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.dKZ = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void hc(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dKF.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.Pr) {
                this.dKF.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.dKz);
                this.dKF.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.Pr) {
            if (this.dKQ == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.dKQ = com.baidu.live.utils.k.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.dKQ) {
                    decodeResource.recycle();
                }
            }
            if (this.dKR == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.dKR = com.baidu.live.utils.k.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.dKR) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.dKF.setImageBitmap(this.dKR);
            } else {
                this.dKF.setImageBitmap(this.dKQ);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.dKF.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.dKF.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dKG.getLayoutParams();
        if (z || this.Pr) {
            this.dKG.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.dKI.setVisibility(8);
            this.dKZ.setVisibility(0);
            this.dKJ.setVisibility(8);
        } else {
            this.dKG.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.dKI.setVisibility(0);
            this.dKZ.setVisibility(8);
            this.dKJ.setVisibility(0);
        }
        this.dKG.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, String str, String[] strArr, boolean z, com.baidu.tieba.ala.guardclub.model.j[] jVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.dKm = cVar;
        this.dKP = str;
        if (cVar == null || cVar.id <= 0) {
            this.dKD.setVisibility(8);
            this.dKH.setVisibility(8);
            this.dKX.reset();
            this.dKX.setTitle(a.i.guard_club_no_create);
            this.dKX.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.dKM.setVisibility(0);
            return;
        }
        this.dKD.setVisibility(0);
        this.dKH.setVisibility(0);
        this.dKM.setVisibility(8);
        hc(z);
        this.dKG.dOD.startLoad(cVar.dNn, 12, false);
        this.dKG.dOE.startLoad(m.aLv().mM(cVar.dNl), 10, false);
        boolean z2 = false;
        if (this.Pr && cVar.dNp != null) {
            z2 = cVar.dNp.optInt("can_update_name", 0) == 1;
        }
        int width = this.dKG.dLp.getWidth();
        if (width <= 0) {
            this.dKG.dLp.measure(0, 0);
            width = this.dKG.dLp.getMeasuredWidth();
        }
        String str3 = cVar.dNg;
        int i2 = 0;
        if (z2) {
            this.dKG.dOF.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.dKG.dOF.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.dKG.dLo.setPadding(0, 0, width + i2, 0);
            this.dKG.dLp.setPadding(0, 0, i2, 0);
            this.dKG.dLp.setVisibility(0);
        } else {
            this.dKG.dLo.setPadding(0, 0, i2, 0);
            this.dKG.dLp.setPadding(0, 0, i2, 0);
            this.dKG.dLp.setVisibility(4);
            str2 = str3;
        }
        this.dKG.dLo.setText(str2);
        String mO = m.aLv().mO(cVar.dNl);
        String str4 = (mO == null || "null".equals(mO)) ? "" : mO;
        Resources resources = this.dKG.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dKG.getLayoutParams();
        if (z || this.Pr) {
            this.dKG.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + cVar.dNi;
            if (cVar.dNm > 0) {
                str5 = str5 + " / " + cVar.dNm;
            }
            this.dKG.dOH.setText(str5);
            this.dKG.dOJ.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.dKI.setVisibility(8);
            this.dKZ.setVisibility(0);
            this.dKJ.setVisibility(8);
            hd(this.dKl);
        } else {
            this.dKG.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + cVar.dNi;
            if (cVar.dNm > 0) {
                str6 = str6 + " / " + cVar.dNm;
            }
            this.dKG.dOH.setText(str6);
            this.dKG.dOJ.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.dKI.setVisibility(0);
            this.dKZ.setVisibility(8);
            this.dKJ.setVisibility(0);
            if (jVarArr != null) {
                this.dKK.setVisibility(0);
                this.dKY.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < jVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.dKY.addView(view, layoutParams2);
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
                    com.baidu.tieba.ala.guardclub.model.j jVar = jVarArr[i3];
                    if (jVar != null) {
                        tbImageView.startLoad(jVar.dNO, 10, false);
                        textView.setText(jVar.dNP + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.dKK.setVisibility(8);
            }
        }
        this.dKG.setLayoutParams(layoutParams);
        if (cVar.dNi == cVar.dNm) {
            i = 100;
        } else if (cVar.dNi <= 0) {
            i = 0;
        } else if (cVar.dNm <= 0) {
            i = 100;
        } else if (cVar.dNi >= cVar.dNm) {
            i = 100;
        } else {
            try {
                i = (int) ((cVar.dNi * 100) / cVar.dNm);
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
        this.dKG.dOI.setProgress(i);
        this.dKG.dOM.setText(cVar.dNk < 10000 ? cVar.dNk + "" : String.format("%.1f", Float.valueOf(((float) cVar.dNk) / 10000.0f)) + "万");
        String str7 = cVar.dNo;
        this.dKG.dMQ.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void aLi() {
        this.dKD.setVisibility(8);
        this.dKH.setVisibility(8);
        this.dKX.reset();
        this.dKX.setTitle(a.i.sdk_net_fail_tip_rank);
        this.dKX.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dKo != null) {
                    c.this.dKo.onClick(view);
                }
            }
        });
        this.dKX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dKM.setVisibility(0);
    }

    public void hd(boolean z) {
        this.dKO = new h(this.dKt, this.liveId, this.roomId, this.Of, this.Pr, true, false, this.isFullScreen, this.otherParams, this.dKt.getUniqueId(), null);
        this.dKO.he(z);
        View view = this.dKO.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dKL.removeAllViews();
            this.dKL.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.acb != null) {
            this.acb.onDestroy();
        }
        if (this.dKQ != null) {
            this.dKQ.recycle();
        }
        if (this.dKR != null) {
            this.dKR.recycle();
        }
        this.dKt.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.dKB || view == this.dKE || view == this.dKN) {
            this.activity.finish();
        } else if (view == this.dKG.dOG) {
            if (!TextUtils.isEmpty(this.dKP)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.dKP);
            }
            if (!this.Pr) {
                if (this.dKS) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.WE, str, this.otherParams);
            }
        } else if (view == this.dKG.dOK) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.Of, this.liveId, this.Pr, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.WE);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.dKG.dON) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.Of, this.liveId, this.Pr, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.WE);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.dKJ) {
            if (this.dKm != null) {
                z aLx = m.aLv().aLx();
                if (aLx == null || aLx.Tl <= 0) {
                    j = 1000;
                } else {
                    j = aLx.Tl;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    mG(this.dKm.id);
                } else if (this.dKl) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.dKm));
                    this.activity.finish();
                }
            }
            if (!this.Pr) {
                if (TextUtils.isEmpty(this.dKT)) {
                    this.dKT = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.WE, this.dKT, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.YF) {
                this.dKU.clearFocus();
                this.dKU.setText("");
                BdUtilHelper.hideSoftKeyPad(this.dKt.getActivity(), this.dKU);
                return;
            }
            this.activity.finish();
        } else if (view == this.dKV) {
            String obj = this.dKU.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                h(this.dKm.id, obj, "");
            }
        } else if (view == this.dKG.dOF) {
            this.dKU.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.dKt.getActivity(), this.dKU);
        }
    }

    public void tj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dKG.dLo.setText(str);
            this.dKU.setText("");
            this.dKU.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.dKt.getActivity(), this.dKU);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dKx.getLayoutParams();
        if (z) {
            this.dKu.setVisibility(this.isFullScreen ? 0 : 8);
            this.dKw.setVisibility(0);
            String charSequence = this.dKG.dLo.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.dKU.setText(charSequence);
                this.dKU.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.dKU.setText("");
            }
            layoutParams.bottomMargin = aLj();
        } else {
            layoutParams.bottomMargin = 0;
            this.dKw.setVisibility(8);
            this.dKu.setVisibility(0);
        }
        this.dKx.setLayoutParams(layoutParams);
    }

    protected int aLj() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.dKt.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.dKt.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void mG(int i) {
        com.baidu.tieba.ala.guardclub.model.f fVar = new com.baidu.tieba.ala.guardclub.model.f();
        fVar.mP(i);
        fVar.a(this.dKm);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void h(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.e eVar = new com.baidu.tieba.ala.guardclub.model.e();
        eVar.ca(i);
        eVar.tl(str);
        eVar.tm(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
