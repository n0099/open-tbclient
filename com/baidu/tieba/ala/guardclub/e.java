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
    private com.baidu.live.k.c aFE;
    private com.baidu.live.guardclub.a aIX;
    private String aIY;
    private boolean aJa;
    private Activity activity;
    private long aps;
    private boolean aqR;
    private String azF;
    private int cCL;
    private ViewTreeObserver.OnGlobalLayoutListener eIM;
    private int fjA;
    private int fjB;
    private View fjC;
    private LinearLayout fjD;
    private RelativeLayout fjE;
    private ImageView fjF;
    private ImageView fjG;
    private LinearLayout fjH;
    private GuardClubInfoHeaderView fjI;
    private RelativeLayout fjJ;
    private RelativeLayout fjK;
    private TextView fjL;
    private LinearLayout fjM;
    private FrameLayout fjN;
    private RelativeLayout fjO;
    private ImageView fjP;
    private j fjQ;
    private Bitmap fjR;
    private Bitmap fjS;
    private EditText fjT;
    private TextView fjU;
    private TextView fjV;
    private CommonEmptyView fjW;
    private LinearLayout fjX;
    private LinearLayout fjY;
    private String fjk;
    private boolean fjq;
    private View.OnClickListener fjs;
    private GuardClubInfoActivity fjv;
    private View fjw;
    private View fjx;
    private View fjy;
    private View fjz;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eIL = true;
    private boolean aCk = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.fjv = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aps = j;
        this.liveId = j2;
        this.roomId = j3;
        this.azF = str;
        this.aqR = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aJa = z3;
        this.fjq = z4;
        this.fjk = str3;
        this.isTranslucent = z5;
        this.fjs = onClickListener;
        if (!z3) {
            if (this.aFE == null) {
                this.aFE = new com.baidu.live.k.c();
            }
            this.aFE.initListener();
            this.aFE.refreshCurUserScores();
        }
        this.fjA = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fjB = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eIM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fjv.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fjv.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fjv.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.aCk && e.this.eIL) {
                    e.this.aCk = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.aCk) {
                    e.this.aCk = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fjv.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eIM);
    }

    public void xx() {
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
        if (this.fjD != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fjD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fjD.setLayoutParams(layoutParams);
        }
        if (this.fjy != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fjy.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fjy.setLayoutParams(layoutParams2);
        }
        if (this.fjw != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fjw.getLayoutParams();
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
                gradientDrawable.setColor(this.fjA);
            } else {
                gradientDrawable.setColor(this.fjB);
            }
            this.fjw.setBackgroundDrawable(gradientDrawable);
        }
        if (this.fjG != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fjG.setImageBitmap(this.fjS);
            } else {
                this.fjG.setImageBitmap(this.fjR);
            }
        }
        if (this.fjQ != null) {
            this.fjQ.xx();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bmJ();
        xx();
        this.fjC.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cCL = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fjC.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fjF.setVisibility(8);
                this.fjP.setVisibility(8);
            } else {
                this.fjF.setVisibility(0);
                this.fjP.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.fjH.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.fjF.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.fjP.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.fjG.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fjA);
        } else {
            this.fjC.setVisibility(0);
            this.fjF.setVisibility(8);
            this.fjP.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fjw.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fjv.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fjA);
            } else {
                gradientDrawable.setColor(this.fjB);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fjY.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.fjY.setLayoutParams(layoutParams2);
        }
        this.fjw.setBackgroundDrawable(gradientDrawable);
        if (this.aqR) {
            jD(false);
        } else {
            jD(this.aJa);
        }
        if (this.fjq) {
            this.fjI.fne.setVisibility(8);
        }
        ak At = com.baidu.live.guardclub.g.Ar().At();
        if (At != null && At.auW > 0) {
            this.fjL.setText(At.auW + "T豆加入");
        } else {
            this.fjL.setText("1000T豆加入");
        }
        this.fjF.setOnClickListener(this);
        this.fjI.fnb.setOnClickListener(this);
        this.fjL.setOnClickListener(this);
        this.fjP.setOnClickListener(this);
        this.fjI.fmX.setOnClickListener(this);
        this.fjI.fne.setOnClickListener(this);
        this.fjI.fmW.setOnClickListener(this);
        this.fjU.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fjI.fmU.setIsRound(true);
        this.fjI.fmU.setDrawBorder(false);
        this.fjI.fmU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fjI.fmU.setAutoChangeStyle(false);
        this.fjI.fmU.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fjI.fmV.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aqR) {
            if (this.aJa) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.azF, str, this.otherParams);
        }
        this.fjT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.box();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        if (this.fjU != null) {
            if (TextUtils.isEmpty(this.fjT.getText())) {
                this.fjU.setEnabled(false);
                this.fjV.setText(String.valueOf(0));
            } else {
                this.fjU.setEnabled(true);
                this.fjV.setText(String.valueOf(this.fjT.getText().length()));
            }
        }
        if (this.fjT.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.fjT.setText(this.fjT.getText().subSequence(0, 10));
            this.fjT.setSelection(this.fjT.getText().length());
        }
    }

    private void bmJ() {
        this.fjD = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fjC = this.mRootView.findViewById(a.g.space_view);
        this.fjw = this.mRootView.findViewById(a.g.layout_guard_info);
        this.fjx = this.mRootView.findViewById(a.g.info_layout);
        this.fjT = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fjy = this.mRootView.findViewById(a.g.input_name_layout);
        this.fjz = this.mRootView.findViewById(a.g.input_name);
        this.fjU = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.fjV = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fjE = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.fjF = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.fjG = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.fjH = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.fjI = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.fjJ = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.fjK = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.fjL = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.fjM = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.fjN = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.fjO = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.fjW = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.fjP = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.fjX = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.fjY = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void jD(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fjG.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aqR) {
                this.fjG.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fjA);
                this.fjG.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aqR) {
            if (this.fjR == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fjR = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.fjR) {
                    decodeResource.recycle();
                }
            }
            if (this.fjS == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.fjS = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.fjS) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.fjG.setImageBitmap(this.fjS);
            } else {
                this.fjG.setImageBitmap(this.fjR);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.fjG.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.fjG.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fjI.getLayoutParams();
        if (z || this.aqR) {
            this.fjI.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.fjK.setVisibility(8);
            this.fjY.setVisibility(0);
            this.fjL.setVisibility(8);
        } else {
            this.fjI.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.fjK.setVisibility(0);
            this.fjY.setVisibility(8);
            this.fjL.setVisibility(0);
        }
        this.fjI.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aIX = aVar;
        this.aIY = str;
        if (aVar == null || aVar.id <= 0) {
            this.fjE.setVisibility(8);
            this.fjJ.setVisibility(8);
            this.fjW.reset();
            this.fjW.setTitle(a.i.guard_club_no_create);
            this.fjW.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.fjO.setVisibility(0);
            return;
        }
        this.fjE.setVisibility(0);
        this.fjJ.setVisibility(0);
        this.fjO.setVisibility(8);
        jD(z);
        this.fjI.fmU.startLoad(aVar.aIS, 12, false);
        this.fjI.fmV.startLoad(com.baidu.live.guardclub.g.Ar().ch(aVar.aIQ), 10, false);
        boolean z2 = false;
        if (this.aqR && aVar.aIU != null) {
            z2 = aVar.aIU.optInt("can_update_name", 0) == 1;
        }
        int width = this.fjI.fkk.getWidth();
        if (width <= 0) {
            this.fjI.fkk.measure(0, 0);
            width = this.fjI.fkk.getMeasuredWidth();
        }
        String str3 = aVar.aIL;
        int i2 = 0;
        if (z2) {
            this.fjI.fmW.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.fjI.fmW.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.fjI.aPj.setPadding(0, 0, width + i2, 0);
            this.fjI.fkk.setPadding(0, 0, i2, 0);
            this.fjI.fkk.setVisibility(0);
        } else {
            this.fjI.aPj.setPadding(0, 0, i2, 0);
            this.fjI.fkk.setPadding(0, 0, i2, 0);
            this.fjI.fkk.setVisibility(4);
            str2 = str3;
        }
        this.fjI.aPj.setText(str2);
        String cj = com.baidu.live.guardclub.g.Ar().cj(aVar.aIQ);
        String str4 = (cj == null || "null".equals(cj)) ? "" : cj;
        Resources resources = this.fjI.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjI.getLayoutParams();
        if (z || this.aqR) {
            this.fjI.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aIN;
            if (aVar.aIR > 0) {
                str5 = str5 + " / " + aVar.aIR;
            }
            this.fjI.fmY.setText(str5);
            this.fjI.fna.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.fjK.setVisibility(8);
            this.fjY.setVisibility(0);
            this.fjL.setVisibility(8);
            jE(this.fjq);
        } else {
            this.fjI.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aIN;
            if (aVar.aIR > 0) {
                str6 = str6 + " / " + aVar.aIR;
            }
            this.fjI.fmY.setText(str6);
            this.fjI.fna.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.fjK.setVisibility(0);
            this.fjY.setVisibility(8);
            this.fjL.setVisibility(0);
            if (dVarArr != null) {
                this.fjM.setVisibility(0);
                this.fjX.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.fjX.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aJj, 10, false);
                        textView.setText(dVar.aJk + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.fjM.setVisibility(8);
            }
        }
        this.fjI.setLayoutParams(layoutParams);
        if (aVar.aIN == aVar.aIR) {
            i = 100;
        } else if (aVar.aIN <= 0) {
            i = 0;
        } else if (aVar.aIR <= 0) {
            i = 100;
        } else if (aVar.aIN >= aVar.aIR) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aIN * 100) / aVar.aIR);
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
        this.fjI.fmZ.setProgress(i);
        this.fjI.fnd.setText(aVar.aIP < 10000 ? aVar.aIP + "" : String.format("%.1f", Float.valueOf(((float) aVar.aIP) / 10000.0f)) + "万");
        String str7 = aVar.aIT;
        this.fjI.fcn.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void boy() {
        this.fjE.setVisibility(8);
        this.fjJ.setVisibility(8);
        this.fjW.reset();
        this.fjW.setTitle(a.i.sdk_net_fail_tip_rank);
        this.fjW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fjs != null) {
                    e.this.fjs.onClick(view);
                }
            }
        });
        this.fjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.fjO.setVisibility(0);
    }

    public void jE(boolean z) {
        this.fjQ = new j(this.fjv, this.liveId, this.roomId, this.aps, this.aqR, true, false, this.isFullScreen, this.otherParams, this.fjv.getUniqueId(), null);
        this.fjQ.jF(z);
        View view = this.fjQ.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.fjN.removeAllViews();
            this.fjN.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aFE != null) {
            this.aFE.onDestroy();
        }
        if (this.fjR != null) {
            this.fjR.recycle();
        }
        if (this.fjS != null) {
            this.fjS.recycle();
        }
        this.fjv.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eIM);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fjC || view == this.fjF || view == this.fjP) {
            this.activity.finish();
        } else if (view == this.fjI.fmX) {
            if (!TextUtils.isEmpty(this.aIY)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aIY);
            }
            if (!this.aqR) {
                if (this.aJa) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.azF, str, this.otherParams);
            }
        } else if (view == this.fjI.fnb) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aps, this.liveId, this.aqR, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.azF);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.fjI.fne) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aps, this.liveId, this.aqR, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.azF);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.fjL) {
            if (this.aIX != null) {
                ak At = com.baidu.live.guardclub.g.Ar().At();
                if (At == null || At.auW <= 0) {
                    j = 1000;
                } else {
                    j = At.auW;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    pK(this.aIX.id);
                } else if (this.fjq) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aIX));
                    this.activity.finish();
                }
            }
            if (!this.aqR) {
                if (TextUtils.isEmpty(this.fjk)) {
                    this.fjk = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.azF, this.fjk, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.aCk) {
                this.fjT.clearFocus();
                this.fjT.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fjv.getActivity(), this.fjT);
                return;
            }
            this.activity.finish();
        } else if (view == this.fjU) {
            String obj = this.fjT.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aIX.id, obj, "");
            }
        } else if (view == this.fjI.fmW) {
            this.fjT.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fjv.getActivity(), this.fjT);
        }
    }

    public void Ah(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fjI.aPj.setText(str);
            this.fjT.setText("");
            this.fjT.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fjv.getActivity(), this.fjT);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjz.getLayoutParams();
        if (z) {
            this.fjw.setVisibility(this.isFullScreen ? 0 : 8);
            this.fjy.setVisibility(0);
            String charSequence = this.fjI.aPj.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.fjT.setText(charSequence);
                this.fjT.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.fjT.setText("");
            }
            layoutParams.bottomMargin = boz();
        } else {
            layoutParams.bottomMargin = 0;
            this.fjy.setVisibility(8);
            this.fjw.setVisibility(0);
        }
        this.fjz.setLayoutParams(layoutParams);
    }

    protected int boz() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fjv.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fjv.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void pK(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cf(i);
        cVar.a(this.aIX);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.du(i);
        cVar.Aj(str);
        cVar.Ak(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
