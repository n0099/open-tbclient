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
import com.baidu.live.data.ba;
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
    private boolean aIH;
    private String aMV;
    private String aMW;
    private String aTk;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.l.c bae;
    private com.baidu.live.guardclub.a bdN;
    private String bdO;
    private boolean bdQ;
    private View bmX;
    private int dvr;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private View gpA;
    private View gpB;
    private View gpC;
    private int gpD;
    private int gpE;
    private View gpF;
    private LinearLayout gpG;
    private RelativeLayout gpH;
    private ImageView gpI;
    private ImageView gpJ;
    private LinearLayout gpK;
    private GuardClubInfoHeaderView gpL;
    private RelativeLayout gpM;
    private RelativeLayout gpN;
    private TextView gpO;
    private LinearLayout gpP;
    private FrameLayout gpQ;
    private RelativeLayout gpR;
    private ImageView gpS;
    private j gpT;
    private Bitmap gpU;
    private Bitmap gpV;
    private EditText gpW;
    private TextView gpX;
    private TextView gpY;
    private CommonEmptyView gpZ;
    private String gpo;
    private boolean gpu;
    private View.OnClickListener gpw;
    private GuardClubInfoActivity gpz;
    private LinearLayout gqa;
    private LinearLayout gqb;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean fKi = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gpz = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aTk = str;
        this.aIH = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bdQ = z3;
        this.gpu = z4;
        this.gpo = str3;
        this.isTranslucent = z5;
        this.aMV = str4;
        this.aMW = str5;
        this.gpw = onClickListener;
        if (!z3) {
            if (this.bae == null) {
                this.bae = new com.baidu.live.l.c();
            }
            this.bae.initListener();
            this.bae.refreshCurUserScores();
        }
        this.gpD = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.gpE = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.gpz.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.gpz.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.gpz.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.fKi) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gpz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void GM() {
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
        if (this.gpG != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpG.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gpG.setLayoutParams(layoutParams);
        }
        if (this.gpB != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gpB.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gpB.setLayoutParams(layoutParams2);
        }
        if (this.gpA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gpA.getLayoutParams();
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
                gradientDrawable.setColor(this.gpD);
            } else {
                gradientDrawable.setColor(this.gpE);
            }
            this.gpA.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gpJ != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gpJ.setImageBitmap(this.gpV);
            } else {
                this.gpJ.setImageBitmap(this.gpU);
            }
        }
        if (this.gpT != null) {
            this.gpT.GM();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bLh();
        GM();
        this.gpF.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dvr = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gpF.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gpI.setVisibility(8);
                this.gpS.setVisibility(8);
            } else {
                this.gpI.setVisibility(0);
                this.gpS.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gpK.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gpI.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gpS.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gpJ.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.gpD);
        } else {
            this.gpF.setVisibility(0);
            this.gpI.setVisibility(8);
            this.gpS.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gpA.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gpz.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gpD);
            } else {
                gradientDrawable.setColor(this.gpE);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqb.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.gqb.setLayoutParams(layoutParams2);
        }
        this.gpA.setBackgroundDrawable(gradientDrawable);
        if (this.aIH) {
            lQ(false);
        } else {
            lQ(this.bdQ);
        }
        if (this.gpu) {
            this.gpL.gtc.setVisibility(8);
        }
        ba JO = com.baidu.live.guardclub.g.JM().JO();
        if (JO != null && JO.aNn > 0) {
            this.gpO.setText(JO.aNn + "T豆加入");
        } else {
            this.gpO.setText("1000T豆加入");
        }
        this.gpI.setOnClickListener(this);
        this.gpL.gsZ.setOnClickListener(this);
        this.gpO.setOnClickListener(this);
        this.gpS.setOnClickListener(this);
        this.gpL.gsV.setOnClickListener(this);
        this.gpL.gtc.setOnClickListener(this);
        this.gpL.gsU.setOnClickListener(this);
        this.gpX.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gpL.gsS.setIsRound(true);
        this.gpL.gsS.setDrawBorder(false);
        this.gpL.gsS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gpL.gsS.setAutoChangeStyle(false);
        this.gpL.gsS.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gpL.gsT.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aIH) {
            if (this.bdQ) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aTk, str, this.otherParams);
        }
        this.gpW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bNT();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNT() {
        if (this.gpX != null) {
            if (TextUtils.isEmpty(this.gpW.getText())) {
                this.gpX.setEnabled(false);
                this.gpY.setText(String.valueOf(0));
            } else {
                this.gpX.setEnabled(true);
                this.gpY.setText(String.valueOf(this.gpW.getText().length()));
            }
        }
        if (this.gpW.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.gpW.setText(this.gpW.getText().subSequence(0, 10));
            this.gpW.setSelection(this.gpW.getText().length());
        }
    }

    private void bLh() {
        this.gpG = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.gpF = this.mRootView.findViewById(a.g.space_view);
        this.gpA = this.mRootView.findViewById(a.g.layout_guard_info);
        this.bmX = this.mRootView.findViewById(a.g.info_layout);
        this.gpW = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.gpB = this.mRootView.findViewById(a.g.input_name_layout);
        this.gpC = this.mRootView.findViewById(a.g.input_name);
        this.gpX = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.gpY = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.gpH = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.gpI = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.gpJ = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.gpK = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.gpL = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.gpM = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.gpN = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.gpO = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.gpP = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.gpQ = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.gpR = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.gpZ = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.gpS = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.gqa = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.gqb = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void lQ(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpJ.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aIH) {
                this.gpJ.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gpD);
                this.gpJ.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aIH) {
            if (this.gpU == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gpU = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.gpU) {
                    decodeResource.recycle();
                }
            }
            if (this.gpV == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gpV = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.gpV) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gpJ.setImageBitmap(this.gpV);
            } else {
                this.gpJ.setImageBitmap(this.gpU);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gpJ.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.gpJ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpL.getLayoutParams();
        if (z || this.aIH) {
            this.gpL.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gpN.setVisibility(8);
            this.gqb.setVisibility(0);
            this.gpO.setVisibility(8);
        } else {
            this.gpL.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gpN.setVisibility(0);
            this.gqb.setVisibility(8);
            this.gpO.setVisibility(0);
        }
        this.gpL.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bdN = aVar;
        this.bdO = str;
        if (aVar == null || aVar.id <= 0) {
            this.gpH.setVisibility(8);
            this.gpM.setVisibility(8);
            this.gpZ.reset();
            this.gpZ.setTitle(a.i.guard_club_no_create);
            this.gpZ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gpR.setVisibility(0);
            return;
        }
        this.gpH.setVisibility(0);
        this.gpM.setVisibility(0);
        this.gpR.setVisibility(8);
        lQ(z);
        this.gpL.gsS.startLoad(aVar.bdI, 12, false);
        this.gpL.gsT.startLoad(com.baidu.live.guardclub.g.JM().eB(aVar.bdG), 10, false);
        boolean z2 = false;
        if (this.aIH && aVar.bdK != null) {
            z2 = aVar.bdK.optInt("can_update_name", 0) == 1;
        }
        int width = this.gpL.gqm.getWidth();
        if (width <= 0) {
            this.gpL.gqm.measure(0, 0);
            width = this.gpL.gqm.getMeasuredWidth();
        }
        String str3 = aVar.bdB;
        int i2 = 0;
        if (z2) {
            this.gpL.gsU.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.gpL.gsU.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gpL.aEC.setPadding(0, 0, width + i2, 0);
            this.gpL.gqm.setPadding(0, 0, i2, 0);
            this.gpL.gqm.setVisibility(0);
        } else {
            this.gpL.aEC.setPadding(0, 0, i2, 0);
            this.gpL.gqm.setPadding(0, 0, i2, 0);
            this.gpL.gqm.setVisibility(4);
            str2 = str3;
        }
        this.gpL.aEC.setText(str2);
        String eD = com.baidu.live.guardclub.g.JM().eD(aVar.bdG);
        String str4 = (eD == null || "null".equals(eD)) ? "" : eD;
        Resources resources = this.gpL.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpL.getLayoutParams();
        if (z || this.aIH) {
            this.gpL.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.bdD;
            if (aVar.bdH > 0) {
                str5 = str5 + " / " + aVar.bdH;
            }
            this.gpL.gsW.setText(str5);
            this.gpL.gsY.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gpN.setVisibility(8);
            this.gqb.setVisibility(0);
            this.gpO.setVisibility(8);
            lR(this.gpu);
        } else {
            this.gpL.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bdD;
            if (aVar.bdH > 0) {
                str6 = str6 + " / " + aVar.bdH;
            }
            this.gpL.gsW.setText(str6);
            this.gpL.gsY.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gpN.setVisibility(0);
            this.gqb.setVisibility(8);
            this.gpO.setVisibility(0);
            if (dVarArr != null) {
                this.gpP.setVisibility(0);
                this.gqa.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gqa.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.bdZ, 10, false);
                        textView.setText(dVar.bea + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gpP.setVisibility(8);
            }
        }
        this.gpL.setLayoutParams(layoutParams);
        if (aVar.bdD == aVar.bdH) {
            i = 100;
        } else if (aVar.bdD <= 0) {
            i = 0;
        } else if (aVar.bdH <= 0) {
            i = 100;
        } else if (aVar.bdD >= aVar.bdH) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bdD * 100) / aVar.bdH);
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
        this.gpL.gsX.setProgress(i);
        this.gpL.gtb.setText(aVar.bdF < 10000 ? aVar.bdF + "" : String.format("%.1f", Float.valueOf(((float) aVar.bdF) / 10000.0f)) + "万");
        String str7 = aVar.bdJ;
        this.gpL.ghv.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bNU() {
        this.gpH.setVisibility(8);
        this.gpM.setVisibility(8);
        this.gpZ.reset();
        this.gpZ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.gpZ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gpw != null) {
                    e.this.gpw.onClick(view);
                }
            }
        });
        this.gpZ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gpR.setVisibility(0);
    }

    public void lR(boolean z) {
        if (this.gpT == null) {
            this.gpT = new j(this.gpz, this.liveId, this.roomId, this.anchorId, this.aTk, this.aIH, true, false, this.isFullScreen, this.otherParams, this.gpz.getUniqueId(), null);
        }
        this.gpT.lS(z);
        View view = this.gpT.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gpQ.removeAllViews();
            this.gpQ.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bae != null) {
            this.bae.onDestroy();
        }
        if (this.gpU != null) {
            this.gpU.recycle();
        }
        if (this.gpV != null) {
            this.gpV.recycle();
        }
        if (this.gpT != null) {
            this.gpT.aTM();
        }
        this.gpz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gpF || view == this.gpI || view == this.gpS) {
            this.activity.finish();
        } else if (view == this.gpL.gsV) {
            if (!TextUtils.isEmpty(this.bdO)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bdO);
            }
            if (!this.aIH) {
                if (this.bdQ) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aTk, str, this.otherParams);
            }
        } else if (view == this.gpL.gsZ) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aIH, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aTk);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gpL.gtc) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.anchorId, this.liveId, this.aIH, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aTk);
            guardClubRankActivityConfig.setAnchorInfo(this.aMV, this.aMW);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gpO) {
            if (this.bdN != null) {
                ba JO = com.baidu.live.guardclub.g.JM().JO();
                if (JO == null || JO.aNn <= 0) {
                    j = 1000;
                } else {
                    j = JO.aNn;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    uf(this.bdN.id);
                } else if (this.gpu) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bdN));
                    this.activity.finish();
                }
            }
            if (!this.aIH) {
                if (TextUtils.isEmpty(this.gpo)) {
                    this.gpo = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aTk, this.gpo, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gpW.clearFocus();
                this.gpW.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gpz.getActivity(), this.gpW);
                return;
            }
            this.activity.finish();
        } else if (view == this.gpX) {
            String obj = this.gpW.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                h(this.bdN.id, obj, "");
            }
        } else if (view == this.gpL.gsU) {
            this.gpW.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gpz.getActivity(), this.gpW);
        }
    }

    public void GD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gpL.aEC.setText(str);
            this.gpW.setText("");
            this.gpW.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.gpz.getActivity(), this.gpW);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gpC.getLayoutParams();
        if (z) {
            this.gpA.setVisibility(this.isFullScreen ? 0 : 8);
            this.gpB.setVisibility(0);
            String charSequence = this.gpL.aEC.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gpW.setText(charSequence);
                this.gpW.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gpW.setText("");
            }
            layoutParams.bottomMargin = bNV();
        } else {
            layoutParams.bottomMargin = 0;
            this.gpB.setVisibility(8);
            this.gpA.setVisibility(0);
        }
        this.gpC.setLayoutParams(layoutParams);
    }

    protected int bNV() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.gpz.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.gpz.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void uf(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.ez(i);
        cVar.a(this.bdN);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void h(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.ej(i);
        cVar.GE(str);
        cVar.GF(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
