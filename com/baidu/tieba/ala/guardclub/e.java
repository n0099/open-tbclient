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
import com.baidu.live.data.ah;
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
    private long WZ;
    private boolean Yr;
    private Activity activity;
    private String agZ;
    private com.baidu.live.k.c amV;
    private com.baidu.live.guardclub.a apX;
    private String apY;
    private boolean aqa;
    private int cdv;
    private RelativeLayout eEA;
    private RelativeLayout eEB;
    private TextView eEC;
    private LinearLayout eED;
    private FrameLayout eEE;
    private RelativeLayout eEF;
    private ImageView eEG;
    private j eEH;
    private Bitmap eEI;
    private Bitmap eEJ;
    private EditText eEK;
    private TextView eEL;
    private TextView eEM;
    private CommonEmptyView eEN;
    private LinearLayout eEO;
    private LinearLayout eEP;
    private String eEb;
    private boolean eEh;
    private View.OnClickListener eEj;
    private GuardClubInfoActivity eEm;
    private View eEn;
    private View eEo;
    private View eEp;
    private View eEq;
    private int eEr;
    private int eEs;
    private View eEt;
    private LinearLayout eEu;
    private RelativeLayout eEv;
    private ImageView eEw;
    private ImageView eEx;
    private LinearLayout eEy;
    private GuardClubInfoHeaderView eEz;
    private ViewTreeObserver.OnGlobalLayoutListener eis;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eir = true;
    private boolean ajw = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.eEm = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aqa = z3;
        this.eEh = z4;
        this.eEb = str3;
        this.isTranslucent = z5;
        this.eEj = onClickListener;
        if (!z3) {
            if (this.amV == null) {
                this.amV = new com.baidu.live.k.c();
            }
            this.amV.initListener();
            this.amV.refreshCurUserScores();
        }
        this.eEr = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eEs = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eis = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.eEm.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.eEm.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.eEm.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.ajw && e.this.eir) {
                    e.this.ajw = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.ajw) {
                    e.this.ajw = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.eEm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eis);
    }

    public void ta() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.S(this.mRootView);
                r.d(this.activity, false);
            } else {
                com.baidu.live.utils.h.T(this.mRootView);
                r.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.eEu != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEu.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eEu.setLayoutParams(layoutParams);
        }
        if (this.eEp != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eEp.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.eEp.setLayoutParams(layoutParams2);
        }
        if (this.eEn != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.eEn.getLayoutParams();
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
                gradientDrawable.setColor(this.eEr);
            } else {
                gradientDrawable.setColor(this.eEs);
            }
            this.eEn.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eEx != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEx.setImageBitmap(this.eEJ);
            } else {
                this.eEx.setImageBitmap(this.eEI);
            }
        }
        if (this.eEH != null) {
            this.eEH.ta();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bdO();
        ta();
        this.eEt.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cdv = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eEt.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eEw.setVisibility(8);
                this.eEG.setVisibility(8);
            } else {
                this.eEw.setVisibility(0);
                this.eEG.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eEy.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eEw.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.eEG.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eEx.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.eEr);
        } else {
            this.eEt.setVisibility(0);
            this.eEw.setVisibility(8);
            this.eEG.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eEn.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.eEm.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.eEr);
            } else {
                gradientDrawable.setColor(this.eEs);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eEP.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.eEP.setLayoutParams(layoutParams2);
        }
        this.eEn.setBackgroundDrawable(gradientDrawable);
        if (this.Yr) {
            iA(false);
        } else {
            iA(this.aqa);
        }
        if (this.eEh) {
            this.eEz.eHZ.setVisibility(8);
        }
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        if (vJ != null && vJ.acj > 0) {
            this.eEC.setText(vJ.acj + "T豆加入");
        } else {
            this.eEC.setText("1000T豆加入");
        }
        this.eEw.setOnClickListener(this);
        this.eEz.eHW.setOnClickListener(this);
        this.eEC.setOnClickListener(this);
        this.eEG.setOnClickListener(this);
        this.eEz.eHS.setOnClickListener(this);
        this.eEz.eHZ.setOnClickListener(this);
        this.eEz.eHR.setOnClickListener(this);
        this.eEL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eEz.eHP.setIsRound(true);
        this.eEz.eHP.setDrawBorder(false);
        this.eEz.eHP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEz.eHP.setAutoChangeStyle(false);
        this.eEz.eHP.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eEz.eHQ.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.Yr) {
            if (this.aqa) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.agZ, str, this.otherParams);
        }
        this.eEK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.xU();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU() {
        if (this.eEL != null) {
            if (TextUtils.isEmpty(this.eEK.getText())) {
                this.eEL.setEnabled(false);
                this.eEM.setText(String.valueOf(0));
            } else {
                this.eEL.setEnabled(true);
                this.eEM.setText(String.valueOf(this.eEK.getText().length()));
            }
        }
        if (this.eEK.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.eEK.setText(this.eEK.getText().subSequence(0, 10));
            this.eEK.setSelection(this.eEK.getText().length());
        }
    }

    private void bdO() {
        this.eEu = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eEt = this.mRootView.findViewById(a.g.space_view);
        this.eEn = this.mRootView.findViewById(a.g.layout_guard_info);
        this.eEo = this.mRootView.findViewById(a.g.info_layout);
        this.eEK = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.eEp = this.mRootView.findViewById(a.g.input_name_layout);
        this.eEq = this.mRootView.findViewById(a.g.input_name);
        this.eEL = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.eEM = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eEv = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eEw = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eEx = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eEy = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eEz = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eEA = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eEB = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eEC = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eED = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.eEE = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.eEF = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.eEN = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.eEG = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.eEO = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.eEP = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void iA(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEx.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.Yr) {
                this.eEx.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.eEr);
                this.eEx.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.Yr) {
            if (this.eEI == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEI = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.eEI) {
                    decodeResource.recycle();
                }
            }
            if (this.eEJ == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEJ = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.eEJ) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEx.setImageBitmap(this.eEJ);
            } else {
                this.eEx.setImageBitmap(this.eEI);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eEx.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eEx.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEz.getLayoutParams();
        if (z || this.Yr) {
            this.eEz.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eEB.setVisibility(8);
            this.eEP.setVisibility(0);
            this.eEC.setVisibility(8);
        } else {
            this.eEz.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eEB.setVisibility(0);
            this.eEP.setVisibility(8);
            this.eEC.setVisibility(0);
        }
        this.eEz.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.apX = aVar;
        this.apY = str;
        if (aVar == null || aVar.id <= 0) {
            this.eEv.setVisibility(8);
            this.eEA.setVisibility(8);
            this.eEN.reset();
            this.eEN.setTitle(a.i.guard_club_no_create);
            this.eEN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.eEF.setVisibility(0);
            return;
        }
        this.eEv.setVisibility(0);
        this.eEA.setVisibility(0);
        this.eEF.setVisibility(8);
        iA(z);
        this.eEz.eHP.startLoad(aVar.apS, 12, false);
        this.eEz.eHQ.startLoad(com.baidu.live.guardclub.g.vH().bS(aVar.apQ), 10, false);
        boolean z2 = false;
        if (this.Yr && aVar.apU != null) {
            z2 = aVar.apU.optInt("can_update_name", 0) == 1;
        }
        int width = this.eEz.eFb.getWidth();
        if (width <= 0) {
            this.eEz.eFb.measure(0, 0);
            width = this.eEz.eFb.getMeasuredWidth();
        }
        String str3 = aVar.apL;
        int i2 = 0;
        if (z2) {
            this.eEz.eHR.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eEz.eHR.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eEz.avp.setPadding(0, 0, width + i2, 0);
            this.eEz.eFb.setPadding(0, 0, i2, 0);
            this.eEz.eFb.setVisibility(0);
        } else {
            this.eEz.avp.setPadding(0, 0, i2, 0);
            this.eEz.eFb.setPadding(0, 0, i2, 0);
            this.eEz.eFb.setVisibility(4);
            str2 = str3;
        }
        this.eEz.avp.setText(str2);
        String bU = com.baidu.live.guardclub.g.vH().bU(aVar.apQ);
        String str4 = (bU == null || "null".equals(bU)) ? "" : bU;
        Resources resources = this.eEz.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEz.getLayoutParams();
        if (z || this.Yr) {
            this.eEz.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.apN;
            if (aVar.apR > 0) {
                str5 = str5 + " / " + aVar.apR;
            }
            this.eEz.eHT.setText(str5);
            this.eEz.eHV.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eEB.setVisibility(8);
            this.eEP.setVisibility(0);
            this.eEC.setVisibility(8);
            iB(this.eEh);
        } else {
            this.eEz.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.apN;
            if (aVar.apR > 0) {
                str6 = str6 + " / " + aVar.apR;
            }
            this.eEz.eHT.setText(str6);
            this.eEz.eHV.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eEB.setVisibility(0);
            this.eEP.setVisibility(8);
            this.eEC.setVisibility(0);
            if (dVarArr != null) {
                this.eED.setVisibility(0);
                this.eEO.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.eEO.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aqj, 10, false);
                        textView.setText(dVar.aqk + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.eED.setVisibility(8);
            }
        }
        this.eEz.setLayoutParams(layoutParams);
        if (aVar.apN == aVar.apR) {
            i = 100;
        } else if (aVar.apN <= 0) {
            i = 0;
        } else if (aVar.apR <= 0) {
            i = 100;
        } else if (aVar.apN >= aVar.apR) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.apN * 100) / aVar.apR);
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
        this.eEz.eHU.setProgress(i);
        this.eEz.eHY.setText(aVar.apP < 10000 ? aVar.apP + "" : String.format("%.1f", Float.valueOf(((float) aVar.apP) / 10000.0f)) + "万");
        String str7 = aVar.apT;
        this.eEz.eGy.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bfd() {
        this.eEv.setVisibility(8);
        this.eEA.setVisibility(8);
        this.eEN.reset();
        this.eEN.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eEN.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eEj != null) {
                    e.this.eEj.onClick(view);
                }
            }
        });
        this.eEN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eEF.setVisibility(0);
    }

    public void iB(boolean z) {
        this.eEH = new j(this.eEm, this.liveId, this.roomId, this.WZ, this.Yr, true, false, this.isFullScreen, this.otherParams, this.eEm.getUniqueId(), null);
        this.eEH.iC(z);
        View view = this.eEH.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eEE.removeAllViews();
            this.eEE.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.amV != null) {
            this.amV.onDestroy();
        }
        if (this.eEI != null) {
            this.eEI.recycle();
        }
        if (this.eEJ != null) {
            this.eEJ.recycle();
        }
        this.eEm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eis);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eEt || view == this.eEw || view == this.eEG) {
            this.activity.finish();
        } else if (view == this.eEz.eHS) {
            if (!TextUtils.isEmpty(this.apY)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.apY);
            }
            if (!this.Yr) {
                if (this.aqa) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.agZ, str, this.otherParams);
            }
        } else if (view == this.eEz.eHW) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.agZ);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eEz.eHZ) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.agZ);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eEC) {
            if (this.apX != null) {
                ah vJ = com.baidu.live.guardclub.g.vH().vJ();
                if (vJ == null || vJ.acj <= 0) {
                    j = 1000;
                } else {
                    j = vJ.acj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    po(this.apX.id);
                } else if (this.eEh) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.apX));
                    this.activity.finish();
                }
            }
            if (!this.Yr) {
                if (TextUtils.isEmpty(this.eEb)) {
                    this.eEb = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.agZ, this.eEb, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.ajw) {
                this.eEK.clearFocus();
                this.eEK.setText("");
                BdUtilHelper.hideSoftKeyPad(this.eEm.getActivity(), this.eEK);
                return;
            }
            this.activity.finish();
        } else if (view == this.eEL) {
            String obj = this.eEK.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.apX.id, obj, "");
            }
        } else if (view == this.eEz.eHR) {
            this.eEK.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.eEm.getActivity(), this.eEK);
        }
    }

    public void yu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eEz.avp.setText(str);
            this.eEK.setText("");
            this.eEK.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.eEm.getActivity(), this.eEK);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEq.getLayoutParams();
        if (z) {
            this.eEn.setVisibility(this.isFullScreen ? 0 : 8);
            this.eEp.setVisibility(0);
            String charSequence = this.eEz.avp.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.eEK.setText(charSequence);
                this.eEK.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.eEK.setText("");
            }
            layoutParams.bottomMargin = bfe();
        } else {
            layoutParams.bottomMargin = 0;
            this.eEp.setVisibility(8);
            this.eEn.setVisibility(0);
        }
        this.eEq.setLayoutParams(layoutParams);
    }

    protected int bfe() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.eEm.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.eEm.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void po(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.bQ(i);
        cVar.a(this.apX);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void f(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.cM(i);
        cVar.yw(str);
        cVar.yx(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
