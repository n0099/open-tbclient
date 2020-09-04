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
import com.baidu.live.data.av;
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
/* loaded from: classes7.dex */
public class e implements View.OnClickListener {
    private long aCw;
    private boolean aEy;
    private String aIA;
    private String aIB;
    private String aOb;
    private com.baidu.live.l.c aUD;
    private com.baidu.live.guardclub.a aXV;
    private String aXW;
    private boolean aXY;
    private Activity activity;
    private View bgt;
    private int dhi;
    private String fZK;
    private boolean fZQ;
    private View.OnClickListener fZS;
    private GuardClubInfoActivity fZV;
    private View fZW;
    private View fZX;
    private View fZY;
    private int fZZ;
    private int gaa;
    private View gab;
    private LinearLayout gac;
    private RelativeLayout gad;
    private ImageView gae;
    private ImageView gaf;
    private LinearLayout gag;
    private GuardClubInfoHeaderView gah;
    private RelativeLayout gai;
    private RelativeLayout gaj;
    private TextView gak;
    private LinearLayout gal;
    private FrameLayout gam;
    private RelativeLayout gan;
    private ImageView gao;
    private j gaq;
    private Bitmap gar;
    private Bitmap gas;
    private EditText gat;
    private TextView gau;
    private TextView gav;
    private CommonEmptyView gaw;
    private LinearLayout gax;
    private LinearLayout gay;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean fuO = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.fZV = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aCw = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aOb = str;
        this.aEy = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aXY = z3;
        this.fZQ = z4;
        this.fZK = str3;
        this.isTranslucent = z5;
        this.aIA = str4;
        this.aIB = str5;
        this.fZS = onClickListener;
        if (!z3) {
            if (this.aUD == null) {
                this.aUD = new com.baidu.live.l.c();
            }
            this.aUD.initListener();
            this.aUD.refreshCurUserScores();
        }
        this.fZZ = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.gaa = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fZV.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fZV.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fZV.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.fuO) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fZV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void Fq() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.Y(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.h.Z(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.gac != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gac.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gac.setLayoutParams(layoutParams);
        }
        if (this.fZX != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZX.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fZX.setLayoutParams(layoutParams2);
        }
        if (this.fZW != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fZW.getLayoutParams();
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
                gradientDrawable.setColor(this.fZZ);
            } else {
                gradientDrawable.setColor(this.gaa);
            }
            this.fZW.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gaf != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gaf.setImageBitmap(this.gas);
            } else {
                this.gaf.setImageBitmap(this.gar);
            }
        }
        if (this.gaq != null) {
            this.gaq.Fq();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bHp();
        Fq();
        this.gab.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dhi = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gab.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gae.setVisibility(8);
                this.gao.setVisibility(8);
            } else {
                this.gae.setVisibility(0);
                this.gao.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gag.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gae.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gao.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gaf.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fZZ);
        } else {
            this.gab.setVisibility(0);
            this.gae.setVisibility(8);
            this.gao.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fZW.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fZV.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fZZ);
            } else {
                gradientDrawable.setColor(this.gaa);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gay.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.gay.setLayoutParams(layoutParams2);
        }
        this.fZW.setBackgroundDrawable(gradientDrawable);
        if (this.aEy) {
            lq(false);
        } else {
            lq(this.aXY);
        }
        if (this.fZQ) {
            this.gah.gdB.setVisibility(8);
        }
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io != null && Io.aIS > 0) {
            this.gak.setText(Io.aIS + "T豆加入");
        } else {
            this.gak.setText("1000T豆加入");
        }
        this.gae.setOnClickListener(this);
        this.gah.gdy.setOnClickListener(this);
        this.gak.setOnClickListener(this);
        this.gao.setOnClickListener(this);
        this.gah.gdu.setOnClickListener(this);
        this.gah.gdB.setOnClickListener(this);
        this.gah.gdt.setOnClickListener(this);
        this.gau.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gah.gdr.setIsRound(true);
        this.gah.gdr.setDrawBorder(false);
        this.gah.gdr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gah.gdr.setAutoChangeStyle(false);
        this.gah.gdr.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gah.gds.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aEy) {
            if (this.aXY) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aOb, str, this.otherParams);
        }
        this.gat.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bJZ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (this.gau != null) {
            if (TextUtils.isEmpty(this.gat.getText())) {
                this.gau.setEnabled(false);
                this.gav.setText(String.valueOf(0));
            } else {
                this.gau.setEnabled(true);
                this.gav.setText(String.valueOf(this.gat.getText().length()));
            }
        }
        if (this.gat.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.gat.setText(this.gat.getText().subSequence(0, 10));
            this.gat.setSelection(this.gat.getText().length());
        }
    }

    private void bHp() {
        this.gac = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.gab = this.mRootView.findViewById(a.g.space_view);
        this.fZW = this.mRootView.findViewById(a.g.layout_guard_info);
        this.bgt = this.mRootView.findViewById(a.g.info_layout);
        this.gat = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fZX = this.mRootView.findViewById(a.g.input_name_layout);
        this.fZY = this.mRootView.findViewById(a.g.input_name);
        this.gau = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.gav = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.gad = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.gae = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.gaf = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.gag = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.gah = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.gai = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.gaj = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.gak = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.gal = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.gam = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.gan = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.gaw = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.gao = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.gax = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.gay = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void lq(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gaf.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aEy) {
                this.gaf.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fZZ);
                this.gaf.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aEy) {
            if (this.gar == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gar = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.gar) {
                    decodeResource.recycle();
                }
            }
            if (this.gas == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gas = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.gas) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gaf.setImageBitmap(this.gas);
            } else {
                this.gaf.setImageBitmap(this.gar);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gaf.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.gaf.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gah.getLayoutParams();
        if (z || this.aEy) {
            this.gah.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gaj.setVisibility(8);
            this.gay.setVisibility(0);
            this.gak.setVisibility(8);
        } else {
            this.gah.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gaj.setVisibility(0);
            this.gay.setVisibility(8);
            this.gak.setVisibility(0);
        }
        this.gah.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aXV = aVar;
        this.aXW = str;
        if (aVar == null || aVar.id <= 0) {
            this.gad.setVisibility(8);
            this.gai.setVisibility(8);
            this.gaw.reset();
            this.gaw.setTitle(a.i.guard_club_no_create);
            this.gaw.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gan.setVisibility(0);
            return;
        }
        this.gad.setVisibility(0);
        this.gai.setVisibility(0);
        this.gan.setVisibility(8);
        lq(z);
        this.gah.gdr.startLoad(aVar.aXQ, 12, false);
        this.gah.gds.startLoad(com.baidu.live.guardclub.g.Im().es(aVar.aXO), 10, false);
        boolean z2 = false;
        if (this.aEy && aVar.aXS != null) {
            z2 = aVar.aXS.optInt("can_update_name", 0) == 1;
        }
        int width = this.gah.gaJ.getWidth();
        if (width <= 0) {
            this.gah.gaJ.measure(0, 0);
            width = this.gah.gaJ.getMeasuredWidth();
        }
        String str3 = aVar.aXJ;
        int i2 = 0;
        if (z2) {
            this.gah.gdt.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.gah.gdt.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gah.aAR.setPadding(0, 0, width + i2, 0);
            this.gah.gaJ.setPadding(0, 0, i2, 0);
            this.gah.gaJ.setVisibility(0);
        } else {
            this.gah.aAR.setPadding(0, 0, i2, 0);
            this.gah.gaJ.setPadding(0, 0, i2, 0);
            this.gah.gaJ.setVisibility(4);
            str2 = str3;
        }
        this.gah.aAR.setText(str2);
        String eu = com.baidu.live.guardclub.g.Im().eu(aVar.aXO);
        String str4 = (eu == null || "null".equals(eu)) ? "" : eu;
        Resources resources = this.gah.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gah.getLayoutParams();
        if (z || this.aEy) {
            this.gah.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aXL;
            if (aVar.aXP > 0) {
                str5 = str5 + " / " + aVar.aXP;
            }
            this.gah.gdv.setText(str5);
            this.gah.gdx.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gaj.setVisibility(8);
            this.gay.setVisibility(0);
            this.gak.setVisibility(8);
            lr(this.fZQ);
        } else {
            this.gah.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aXL;
            if (aVar.aXP > 0) {
                str6 = str6 + " / " + aVar.aXP;
            }
            this.gah.gdv.setText(str6);
            this.gah.gdx.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gaj.setVisibility(0);
            this.gay.setVisibility(8);
            this.gak.setVisibility(0);
            if (dVarArr != null) {
                this.gal.setVisibility(0);
                this.gax.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gax.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aYh, 10, false);
                        textView.setText(dVar.aYi + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gal.setVisibility(8);
            }
        }
        this.gah.setLayoutParams(layoutParams);
        if (aVar.aXL == aVar.aXP) {
            i = 100;
        } else if (aVar.aXL <= 0) {
            i = 0;
        } else if (aVar.aXP <= 0) {
            i = 100;
        } else if (aVar.aXL >= aVar.aXP) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aXL * 100) / aVar.aXP);
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
        this.gah.gdw.setProgress(i);
        this.gah.gdA.setText(aVar.aXN < 10000 ? aVar.aXN + "" : String.format("%.1f", Float.valueOf(((float) aVar.aXN) / 10000.0f)) + "万");
        String str7 = aVar.aXR;
        this.gah.fRR.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bKa() {
        this.gad.setVisibility(8);
        this.gai.setVisibility(8);
        this.gaw.reset();
        this.gaw.setTitle(a.i.sdk_net_fail_tip_rank);
        this.gaw.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fZS != null) {
                    e.this.fZS.onClick(view);
                }
            }
        });
        this.gaw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gan.setVisibility(0);
    }

    public void lr(boolean z) {
        if (this.gaq == null) {
            this.gaq = new j(this.fZV, this.liveId, this.roomId, this.aCw, this.aOb, this.aEy, true, false, this.isFullScreen, this.otherParams, this.fZV.getUniqueId(), null);
        }
        this.gaq.ls(z);
        View view = this.gaq.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gam.removeAllViews();
            this.gam.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aUD != null) {
            this.aUD.onDestroy();
        }
        if (this.gar != null) {
            this.gar.recycle();
        }
        if (this.gas != null) {
            this.gas.recycle();
        }
        if (this.gaq != null) {
            this.gaq.aQr();
        }
        this.fZV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gab || view == this.gae || view == this.gao) {
            this.activity.finish();
        } else if (view == this.gah.gdu) {
            if (!TextUtils.isEmpty(this.aXW)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aXW);
            }
            if (!this.aEy) {
                if (this.aXY) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aOb, str, this.otherParams);
            }
        } else if (view == this.gah.gdy) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aCw, this.liveId, this.aEy, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aOb);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gah.gdB) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aCw, this.liveId, this.aEy, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aOb);
            guardClubRankActivityConfig.setAnchorInfo(this.aIA, this.aIB);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gak) {
            if (this.aXV != null) {
                av Io = com.baidu.live.guardclub.g.Im().Io();
                if (Io == null || Io.aIS <= 0) {
                    j = 1000;
                } else {
                    j = Io.aIS;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    to(this.aXV.id);
                } else if (this.fZQ) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aXV));
                    this.activity.finish();
                }
            }
            if (!this.aEy) {
                if (TextUtils.isEmpty(this.fZK)) {
                    this.fZK = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aOb, this.fZK, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gat.clearFocus();
                this.gat.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fZV.getActivity(), this.gat);
                return;
            }
            this.activity.finish();
        } else if (view == this.gau) {
            String obj = this.gat.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                h(this.aXV.id, obj, "");
            }
        } else if (view == this.gah.gdt) {
            this.gat.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fZV.getActivity(), this.gat);
        }
    }

    public void Fu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gah.aAR.setText(str);
            this.gat.setText("");
            this.gat.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fZV.getActivity(), this.gat);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fZY.getLayoutParams();
        if (z) {
            this.fZW.setVisibility(this.isFullScreen ? 0 : 8);
            this.fZX.setVisibility(0);
            String charSequence = this.gah.aAR.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gat.setText(charSequence);
                this.gat.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gat.setText("");
            }
            layoutParams.bottomMargin = bKb();
        } else {
            layoutParams.bottomMargin = 0;
            this.fZX.setVisibility(8);
            this.fZW.setVisibility(0);
        }
        this.fZY.setLayoutParams(layoutParams);
    }

    protected int bKb() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fZV.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fZV.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void to(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eq(i);
        cVar.a(this.aXV);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void h(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.dY(i);
        cVar.Fw(str);
        cVar.Fx(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
