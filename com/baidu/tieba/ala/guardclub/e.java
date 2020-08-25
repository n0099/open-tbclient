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
    private long aCu;
    private boolean aEw;
    private String aIy;
    private String aIz;
    private String aNZ;
    private com.baidu.live.l.c aUB;
    private com.baidu.live.guardclub.a aXT;
    private String aXU;
    private boolean aXW;
    private Activity activity;
    private View bgq;
    private int dhe;
    private String fZG;
    private boolean fZM;
    private View.OnClickListener fZO;
    private GuardClubInfoActivity fZR;
    private View fZS;
    private View fZT;
    private View fZU;
    private int fZV;
    private int fZW;
    private View fZX;
    private LinearLayout fZY;
    private RelativeLayout fZZ;
    private ImageView gaa;
    private ImageView gab;
    private LinearLayout gac;
    private GuardClubInfoHeaderView gad;
    private RelativeLayout gae;
    private RelativeLayout gaf;
    private TextView gag;
    private LinearLayout gah;
    private FrameLayout gai;
    private RelativeLayout gaj;
    private ImageView gak;
    private j gal;
    private Bitmap gam;
    private Bitmap gan;
    private EditText gao;
    private TextView gaq;
    private TextView gar;
    private CommonEmptyView gas;
    private LinearLayout gat;
    private LinearLayout gau;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean fuK = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.fZR = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.aCu = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aNZ = str;
        this.aEw = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aXW = z3;
        this.fZM = z4;
        this.fZG = str3;
        this.isTranslucent = z5;
        this.aIy = str4;
        this.aIz = str5;
        this.fZO = onClickListener;
        if (!z3) {
            if (this.aUB == null) {
                this.aUB = new com.baidu.live.l.c();
            }
            this.aUB.initListener();
            this.aUB.refreshCurUserScores();
        }
        this.fZV = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.fZW = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.fZR.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.fZR.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.fZR.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.fuK) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fZR.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
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
        if (this.fZY != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZY.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.fZY.setLayoutParams(layoutParams);
        }
        if (this.fZT != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZT.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.fZT.setLayoutParams(layoutParams2);
        }
        if (this.fZS != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.fZS.getLayoutParams();
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
                gradientDrawable.setColor(this.fZV);
            } else {
                gradientDrawable.setColor(this.fZW);
            }
            this.fZS.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gab != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gab.setImageBitmap(this.gan);
            } else {
                this.gab.setImageBitmap(this.gam);
            }
        }
        if (this.gal != null) {
            this.gal.Fq();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bHo();
        Fq();
        this.fZX.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dhe = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.fZX.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gaa.setVisibility(8);
                this.gak.setVisibility(8);
            } else {
                this.gaa.setVisibility(0);
                this.gak.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gac.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gaa.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gak.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gab.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.fZV);
        } else {
            this.fZX.setVisibility(0);
            this.gaa.setVisibility(8);
            this.gak.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.fZS.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.fZR.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.fZV);
            } else {
                gradientDrawable.setColor(this.fZW);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gau.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.gau.setLayoutParams(layoutParams2);
        }
        this.fZS.setBackgroundDrawable(gradientDrawable);
        if (this.aEw) {
            lo(false);
        } else {
            lo(this.aXW);
        }
        if (this.fZM) {
            this.gad.gdx.setVisibility(8);
        }
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io != null && Io.aIQ > 0) {
            this.gag.setText(Io.aIQ + "T豆加入");
        } else {
            this.gag.setText("1000T豆加入");
        }
        this.gaa.setOnClickListener(this);
        this.gad.gdu.setOnClickListener(this);
        this.gag.setOnClickListener(this);
        this.gak.setOnClickListener(this);
        this.gad.gdq.setOnClickListener(this);
        this.gad.gdx.setOnClickListener(this);
        this.gad.gdp.setOnClickListener(this);
        this.gaq.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gad.gdn.setIsRound(true);
        this.gad.gdn.setDrawBorder(false);
        this.gad.gdn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gad.gdn.setAutoChangeStyle(false);
        this.gad.gdn.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gad.gdo.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.aEw) {
            if (this.aXW) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aNZ, str, this.otherParams);
        }
        this.gao.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bJY();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        if (this.gaq != null) {
            if (TextUtils.isEmpty(this.gao.getText())) {
                this.gaq.setEnabled(false);
                this.gar.setText(String.valueOf(0));
            } else {
                this.gaq.setEnabled(true);
                this.gar.setText(String.valueOf(this.gao.getText().length()));
            }
        }
        if (this.gao.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.gao.setText(this.gao.getText().subSequence(0, 10));
            this.gao.setSelection(this.gao.getText().length());
        }
    }

    private void bHo() {
        this.fZY = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.fZX = this.mRootView.findViewById(a.g.space_view);
        this.fZS = this.mRootView.findViewById(a.g.layout_guard_info);
        this.bgq = this.mRootView.findViewById(a.g.info_layout);
        this.gao = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.fZT = this.mRootView.findViewById(a.g.input_name_layout);
        this.fZU = this.mRootView.findViewById(a.g.input_name);
        this.gaq = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.gar = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.fZZ = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.gaa = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.gab = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.gac = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.gad = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.gae = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.gaf = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.gag = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.gah = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.gai = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.gaj = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.gas = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.gak = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.gat = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.gau = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void lo(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gab.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aEw) {
                this.gab.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.fZV);
                this.gab.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.aEw) {
            if (this.gam == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gam = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.gam) {
                    decodeResource.recycle();
                }
            }
            if (this.gan == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.gan = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.gan) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gab.setImageBitmap(this.gan);
            } else {
                this.gab.setImageBitmap(this.gam);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gab.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.gab.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gad.getLayoutParams();
        if (z || this.aEw) {
            this.gad.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gaf.setVisibility(8);
            this.gau.setVisibility(0);
            this.gag.setVisibility(8);
        } else {
            this.gad.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gaf.setVisibility(0);
            this.gau.setVisibility(8);
            this.gag.setVisibility(0);
        }
        this.gad.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aXT = aVar;
        this.aXU = str;
        if (aVar == null || aVar.id <= 0) {
            this.fZZ.setVisibility(8);
            this.gae.setVisibility(8);
            this.gas.reset();
            this.gas.setTitle(a.i.guard_club_no_create);
            this.gas.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gaj.setVisibility(0);
            return;
        }
        this.fZZ.setVisibility(0);
        this.gae.setVisibility(0);
        this.gaj.setVisibility(8);
        lo(z);
        this.gad.gdn.startLoad(aVar.aXO, 12, false);
        this.gad.gdo.startLoad(com.baidu.live.guardclub.g.Im().es(aVar.aXM), 10, false);
        boolean z2 = false;
        if (this.aEw && aVar.aXQ != null) {
            z2 = aVar.aXQ.optInt("can_update_name", 0) == 1;
        }
        int width = this.gad.gaF.getWidth();
        if (width <= 0) {
            this.gad.gaF.measure(0, 0);
            width = this.gad.gaF.getMeasuredWidth();
        }
        String str3 = aVar.aXH;
        int i2 = 0;
        if (z2) {
            this.gad.gdp.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.gad.gdp.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gad.aAP.setPadding(0, 0, width + i2, 0);
            this.gad.gaF.setPadding(0, 0, i2, 0);
            this.gad.gaF.setVisibility(0);
        } else {
            this.gad.aAP.setPadding(0, 0, i2, 0);
            this.gad.gaF.setPadding(0, 0, i2, 0);
            this.gad.gaF.setVisibility(4);
            str2 = str3;
        }
        this.gad.aAP.setText(str2);
        String eu = com.baidu.live.guardclub.g.Im().eu(aVar.aXM);
        String str4 = (eu == null || "null".equals(eu)) ? "" : eu;
        Resources resources = this.gad.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gad.getLayoutParams();
        if (z || this.aEw) {
            this.gad.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.aXJ;
            if (aVar.aXN > 0) {
                str5 = str5 + " / " + aVar.aXN;
            }
            this.gad.gdr.setText(str5);
            this.gad.gdt.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gaf.setVisibility(8);
            this.gau.setVisibility(0);
            this.gag.setVisibility(8);
            lp(this.fZM);
        } else {
            this.gad.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.aXJ;
            if (aVar.aXN > 0) {
                str6 = str6 + " / " + aVar.aXN;
            }
            this.gad.gdr.setText(str6);
            this.gad.gdt.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gaf.setVisibility(0);
            this.gau.setVisibility(8);
            this.gag.setVisibility(0);
            if (dVarArr != null) {
                this.gah.setVisibility(0);
                this.gat.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gat.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aYf, 10, false);
                        textView.setText(dVar.aYg + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gah.setVisibility(8);
            }
        }
        this.gad.setLayoutParams(layoutParams);
        if (aVar.aXJ == aVar.aXN) {
            i = 100;
        } else if (aVar.aXJ <= 0) {
            i = 0;
        } else if (aVar.aXN <= 0) {
            i = 100;
        } else if (aVar.aXJ >= aVar.aXN) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.aXJ * 100) / aVar.aXN);
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
        this.gad.gds.setProgress(i);
        this.gad.gdw.setText(aVar.aXL < 10000 ? aVar.aXL + "" : String.format("%.1f", Float.valueOf(((float) aVar.aXL) / 10000.0f)) + "万");
        String str7 = aVar.aXP;
        this.gad.fRN.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bJZ() {
        this.fZZ.setVisibility(8);
        this.gae.setVisibility(8);
        this.gas.reset();
        this.gas.setTitle(a.i.sdk_net_fail_tip_rank);
        this.gas.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.fZO != null) {
                    e.this.fZO.onClick(view);
                }
            }
        });
        this.gas.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gaj.setVisibility(0);
    }

    public void lp(boolean z) {
        if (this.gal == null) {
            this.gal = new j(this.fZR, this.liveId, this.roomId, this.aCu, this.aNZ, this.aEw, true, false, this.isFullScreen, this.otherParams, this.fZR.getUniqueId(), null);
        }
        this.gal.lq(z);
        View view = this.gal.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gai.removeAllViews();
            this.gai.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.aUB != null) {
            this.aUB.onDestroy();
        }
        if (this.gam != null) {
            this.gam.recycle();
        }
        if (this.gan != null) {
            this.gan.recycle();
        }
        if (this.gal != null) {
            this.gal.aQr();
        }
        this.fZR.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.fZX || view == this.gaa || view == this.gak) {
            this.activity.finish();
        } else if (view == this.gad.gdq) {
            if (!TextUtils.isEmpty(this.aXU)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aXU);
            }
            if (!this.aEw) {
                if (this.aXW) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aNZ, str, this.otherParams);
            }
        } else if (view == this.gad.gdu) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.aCu, this.liveId, this.aEw, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aNZ);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gad.gdx) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.aCu, this.liveId, this.aEw, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aNZ);
            guardClubRankActivityConfig.setAnchorInfo(this.aIy, this.aIz);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gag) {
            if (this.aXT != null) {
                av Io = com.baidu.live.guardclub.g.Im().Io();
                if (Io == null || Io.aIQ <= 0) {
                    j = 1000;
                } else {
                    j = Io.aIQ;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    to(this.aXT.id);
                } else if (this.fZM) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aXT));
                    this.activity.finish();
                }
            }
            if (!this.aEw) {
                if (TextUtils.isEmpty(this.fZG)) {
                    this.fZG = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aNZ, this.fZG, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gao.clearFocus();
                this.gao.setText("");
                BdUtilHelper.hideSoftKeyPad(this.fZR.getActivity(), this.gao);
                return;
            }
            this.activity.finish();
        } else if (view == this.gaq) {
            String obj = this.gao.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                g(this.aXT.id, obj, "");
            }
        } else if (view == this.gad.gdp) {
            this.gao.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.fZR.getActivity(), this.gao);
        }
    }

    public void Ft(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gad.aAP.setText(str);
            this.gao.setText("");
            this.gao.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.fZR.getActivity(), this.gao);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fZU.getLayoutParams();
        if (z) {
            this.fZS.setVisibility(this.isFullScreen ? 0 : 8);
            this.fZT.setVisibility(0);
            String charSequence = this.gad.aAP.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gao.setText(charSequence);
                this.gao.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gao.setText("");
            }
            layoutParams.bottomMargin = bKa();
        } else {
            layoutParams.bottomMargin = 0;
            this.fZT.setVisibility(8);
            this.fZS.setVisibility(0);
        }
        this.fZU.setLayoutParams(layoutParams);
    }

    protected int bKa() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.fZR.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.fZR.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void to(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eq(i);
        cVar.a(this.aXT);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void g(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.dY(i);
        cVar.Fv(str);
        cVar.Fw(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
