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
    private long aDf;
    private boolean aFD;
    private String aJQ;
    private String aJR;
    private String aPZ;
    private com.baidu.live.l.c aWS;
    private Activity activity;
    private com.baidu.live.guardclub.a bat;
    private String bau;
    private boolean baw;
    private View bjk;
    private int djl;
    private String gcY;
    private FrameLayout gdA;
    private RelativeLayout gdB;
    private ImageView gdC;
    private j gdD;
    private Bitmap gdE;
    private Bitmap gdF;
    private EditText gdG;
    private TextView gdH;
    private TextView gdI;
    private CommonEmptyView gdJ;
    private LinearLayout gdK;
    private LinearLayout gdL;
    private boolean gde;
    private View.OnClickListener gdg;
    private GuardClubInfoActivity gdj;
    private View gdk;
    private View gdl;
    private View gdm;
    private int gdn;
    private int gdo;
    private View gdp;
    private LinearLayout gdq;
    private RelativeLayout gdr;
    private ImageView gds;
    private ImageView gdt;
    private LinearLayout gdu;
    private GuardClubInfoHeaderView gdv;
    private RelativeLayout gdw;
    private RelativeLayout gdx;
    private TextView gdy;
    private LinearLayout gdz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean fxZ = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gdj = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aDf = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aPZ = str;
        this.aFD = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.baw = z3;
        this.gde = z4;
        this.gcY = str3;
        this.isTranslucent = z5;
        this.aJQ = str4;
        this.aJR = str5;
        this.gdg = onClickListener;
        if (!z3) {
            if (this.aWS == null) {
                this.aWS = new com.baidu.live.l.c();
            }
            this.aWS.initListener();
            this.aWS.refreshCurUserScores();
        }
        this.gdn = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.gdo = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.gdj.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.gdj.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.gdj.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.fxZ) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gdj.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void FQ() {
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
        if (this.gdq != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gdq.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gdq.setLayoutParams(layoutParams);
        }
        if (this.gdl != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gdl.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gdl.setLayoutParams(layoutParams2);
        }
        if (this.gdk != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gdk.getLayoutParams();
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
                gradientDrawable.setColor(this.gdn);
            } else {
                gradientDrawable.setColor(this.gdo);
            }
            this.gdk.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gdt != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gdt.setImageBitmap(this.gdF);
            } else {
                this.gdt.setImageBitmap(this.gdE);
            }
        }
        if (this.gdD != null) {
            this.gdD.FQ();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bIx();
        FQ();
        this.gdp.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.djl = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gdp.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gds.setVisibility(8);
                this.gdC.setVisibility(8);
            } else {
                this.gds.setVisibility(0);
                this.gdC.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gdu.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gds.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gdC.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gdt.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.gdn);
        } else {
            this.gdp.setVisibility(0);
            this.gds.setVisibility(8);
            this.gdC.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gdk.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gdj.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gdn);
            } else {
                gradientDrawable.setColor(this.gdo);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gdL.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.gdL.setLayoutParams(layoutParams2);
        }
        this.gdk.setBackgroundDrawable(gradientDrawable);
        if (this.aFD) {
            ls(false);
        } else {
            ls(this.baw);
        }
        if (this.gde) {
            this.gdv.ggN.setVisibility(8);
        }
        ba IR = com.baidu.live.guardclub.g.IP().IR();
        if (IR != null && IR.aKi > 0) {
            this.gdy.setText(IR.aKi + "T豆加入");
        } else {
            this.gdy.setText("1000T豆加入");
        }
        this.gds.setOnClickListener(this);
        this.gdv.ggK.setOnClickListener(this);
        this.gdy.setOnClickListener(this);
        this.gdC.setOnClickListener(this);
        this.gdv.ggG.setOnClickListener(this);
        this.gdv.ggN.setOnClickListener(this);
        this.gdv.ggF.setOnClickListener(this);
        this.gdH.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gdv.ggD.setIsRound(true);
        this.gdv.ggD.setDrawBorder(false);
        this.gdv.ggD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gdv.ggD.setAutoChangeStyle(false);
        this.gdv.ggD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gdv.ggE.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aFD) {
            if (this.baw) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aPZ, str, this.otherParams);
        }
        this.gdG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bLj();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLj() {
        if (this.gdH != null) {
            if (TextUtils.isEmpty(this.gdG.getText())) {
                this.gdH.setEnabled(false);
                this.gdI.setText(String.valueOf(0));
            } else {
                this.gdH.setEnabled(true);
                this.gdI.setText(String.valueOf(this.gdG.getText().length()));
            }
        }
        if (this.gdG.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.gdG.setText(this.gdG.getText().subSequence(0, 10));
            this.gdG.setSelection(this.gdG.getText().length());
        }
    }

    private void bIx() {
        this.gdq = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.gdp = this.mRootView.findViewById(a.g.space_view);
        this.gdk = this.mRootView.findViewById(a.g.layout_guard_info);
        this.bjk = this.mRootView.findViewById(a.g.info_layout);
        this.gdG = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.gdl = this.mRootView.findViewById(a.g.input_name_layout);
        this.gdm = this.mRootView.findViewById(a.g.input_name);
        this.gdH = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.gdI = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.gdr = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.gds = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.gdt = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.gdu = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.gdv = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.gdw = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.gdx = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.gdy = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.gdz = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.gdA = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.gdB = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.gdJ = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.gdC = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.gdK = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.gdL = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void ls(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gdt.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aFD) {
                this.gdt.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gdn);
                this.gdt.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aFD) {
            if (this.gdE == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gdE = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.gdE) {
                    decodeResource.recycle();
                }
            }
            if (this.gdF == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gdF = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.gdF) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gdt.setImageBitmap(this.gdF);
            } else {
                this.gdt.setImageBitmap(this.gdE);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gdt.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.gdt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdv.getLayoutParams();
        if (z || this.aFD) {
            this.gdv.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gdx.setVisibility(8);
            this.gdL.setVisibility(0);
            this.gdy.setVisibility(8);
        } else {
            this.gdv.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gdx.setVisibility(0);
            this.gdL.setVisibility(8);
            this.gdy.setVisibility(0);
        }
        this.gdv.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bat = aVar;
        this.bau = str;
        if (aVar == null || aVar.id <= 0) {
            this.gdr.setVisibility(8);
            this.gdw.setVisibility(8);
            this.gdJ.reset();
            this.gdJ.setTitle(a.i.guard_club_no_create);
            this.gdJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gdB.setVisibility(0);
            return;
        }
        this.gdr.setVisibility(0);
        this.gdw.setVisibility(0);
        this.gdB.setVisibility(8);
        ls(z);
        this.gdv.ggD.startLoad(aVar.ban, 12, false);
        this.gdv.ggE.startLoad(com.baidu.live.guardclub.g.IP().ew(aVar.bal), 10, false);
        boolean z2 = false;
        if (this.aFD && aVar.bap != null) {
            z2 = aVar.bap.optInt("can_update_name", 0) == 1;
        }
        int width = this.gdv.gdW.getWidth();
        if (width <= 0) {
            this.gdv.gdW.measure(0, 0);
            width = this.gdv.gdW.getMeasuredWidth();
        }
        String str3 = aVar.bag;
        int i2 = 0;
        if (z2) {
            this.gdv.ggF.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.gdv.ggF.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gdv.aBx.setPadding(0, 0, width + i2, 0);
            this.gdv.gdW.setPadding(0, 0, i2, 0);
            this.gdv.gdW.setVisibility(0);
        } else {
            this.gdv.aBx.setPadding(0, 0, i2, 0);
            this.gdv.gdW.setPadding(0, 0, i2, 0);
            this.gdv.gdW.setVisibility(4);
            str2 = str3;
        }
        this.gdv.aBx.setText(str2);
        String ey = com.baidu.live.guardclub.g.IP().ey(aVar.bal);
        String str4 = (ey == null || "null".equals(ey)) ? "" : ey;
        Resources resources = this.gdv.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdv.getLayoutParams();
        if (z || this.aFD) {
            this.gdv.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.bai;
            if (aVar.bam > 0) {
                str5 = str5 + " / " + aVar.bam;
            }
            this.gdv.ggH.setText(str5);
            this.gdv.ggJ.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gdx.setVisibility(8);
            this.gdL.setVisibility(0);
            this.gdy.setVisibility(8);
            lt(this.gde);
        } else {
            this.gdv.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bai;
            if (aVar.bam > 0) {
                str6 = str6 + " / " + aVar.bam;
            }
            this.gdv.ggH.setText(str6);
            this.gdv.ggJ.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gdx.setVisibility(0);
            this.gdL.setVisibility(8);
            this.gdy.setVisibility(0);
            if (dVarArr != null) {
                this.gdz.setVisibility(0);
                this.gdK.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gdK.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.baF, 10, false);
                        textView.setText(dVar.baG + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gdz.setVisibility(8);
            }
        }
        this.gdv.setLayoutParams(layoutParams);
        if (aVar.bai == aVar.bam) {
            i = 100;
        } else if (aVar.bai <= 0) {
            i = 0;
        } else if (aVar.bam <= 0) {
            i = 100;
        } else if (aVar.bai >= aVar.bam) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bai * 100) / aVar.bam);
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
        this.gdv.ggI.setProgress(i);
        this.gdv.ggM.setText(aVar.bak < 10000 ? aVar.bak + "" : String.format("%.1f", Float.valueOf(((float) aVar.bak) / 10000.0f)) + "万");
        String str7 = aVar.bao;
        this.gdv.fVc.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bLk() {
        this.gdr.setVisibility(8);
        this.gdw.setVisibility(8);
        this.gdJ.reset();
        this.gdJ.setTitle(a.i.sdk_net_fail_tip_rank);
        this.gdJ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gdg != null) {
                    e.this.gdg.onClick(view);
                }
            }
        });
        this.gdJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gdB.setVisibility(0);
    }

    public void lt(boolean z) {
        if (this.gdD == null) {
            this.gdD = new j(this.gdj, this.liveId, this.roomId, this.aDf, this.aPZ, this.aFD, true, false, this.isFullScreen, this.otherParams, this.gdj.getUniqueId(), null);
        }
        this.gdD.lu(z);
        View view = this.gdD.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gdA.removeAllViews();
            this.gdA.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aWS != null) {
            this.aWS.onDestroy();
        }
        if (this.gdE != null) {
            this.gdE.recycle();
        }
        if (this.gdF != null) {
            this.gdF.recycle();
        }
        if (this.gdD != null) {
            this.gdD.aRd();
        }
        this.gdj.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gdp || view == this.gds || view == this.gdC) {
            this.activity.finish();
        } else if (view == this.gdv.ggG) {
            if (!TextUtils.isEmpty(this.bau)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bau);
            }
            if (!this.aFD) {
                if (this.baw) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aPZ, str, this.otherParams);
            }
        } else if (view == this.gdv.ggK) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aDf, this.liveId, this.aFD, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aPZ);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gdv.ggN) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aDf, this.liveId, this.aFD, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aPZ);
            guardClubRankActivityConfig.setAnchorInfo(this.aJQ, this.aJR);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gdy) {
            if (this.bat != null) {
                ba IR = com.baidu.live.guardclub.g.IP().IR();
                if (IR == null || IR.aKi <= 0) {
                    j = 1000;
                } else {
                    j = IR.aKi;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    tH(this.bat.id);
                } else if (this.gde) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bat));
                    this.activity.finish();
                }
            }
            if (!this.aFD) {
                if (TextUtils.isEmpty(this.gcY)) {
                    this.gcY = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aPZ, this.gcY, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gdG.clearFocus();
                this.gdG.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gdj.getActivity(), this.gdG);
                return;
            }
            this.activity.finish();
        } else if (view == this.gdH) {
            String obj = this.gdG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                h(this.bat.id, obj, "");
            }
        } else if (view == this.gdv.ggF) {
            this.gdG.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gdj.getActivity(), this.gdG);
        }
    }

    public void FS(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gdv.aBx.setText(str);
            this.gdG.setText("");
            this.gdG.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.gdj.getActivity(), this.gdG);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdm.getLayoutParams();
        if (z) {
            this.gdk.setVisibility(this.isFullScreen ? 0 : 8);
            this.gdl.setVisibility(0);
            String charSequence = this.gdv.aBx.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gdG.setText(charSequence);
                this.gdG.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gdG.setText("");
            }
            layoutParams.bottomMargin = bLl();
        } else {
            layoutParams.bottomMargin = 0;
            this.gdl.setVisibility(8);
            this.gdk.setVisibility(0);
        }
        this.gdm.setLayoutParams(layoutParams);
    }

    protected int bLl() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.gdj.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.gdj.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void tH(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eu(i);
        cVar.a(this.bat);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void h(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.ea(i);
        cVar.FT(str);
        cVar.FU(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
