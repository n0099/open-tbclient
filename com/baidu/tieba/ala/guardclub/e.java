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
    private int cdu;
    private RelativeLayout eEA;
    private TextView eEB;
    private LinearLayout eEC;
    private FrameLayout eED;
    private RelativeLayout eEE;
    private ImageView eEF;
    private j eEG;
    private Bitmap eEH;
    private Bitmap eEI;
    private EditText eEJ;
    private TextView eEK;
    private TextView eEL;
    private CommonEmptyView eEM;
    private LinearLayout eEN;
    private LinearLayout eEO;
    private String eEa;
    private boolean eEg;
    private View.OnClickListener eEi;
    private GuardClubInfoActivity eEl;
    private View eEm;
    private View eEn;
    private View eEo;
    private View eEp;
    private int eEq;
    private int eEr;
    private View eEs;
    private LinearLayout eEt;
    private RelativeLayout eEu;
    private ImageView eEv;
    private ImageView eEw;
    private LinearLayout eEx;
    private GuardClubInfoHeaderView eEy;
    private RelativeLayout eEz;
    private ViewTreeObserver.OnGlobalLayoutListener eir;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eiq = true;
    private boolean ajw = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.eEl = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aqa = z3;
        this.eEg = z4;
        this.eEa = str3;
        this.isTranslucent = z5;
        this.eEi = onClickListener;
        if (!z3) {
            if (this.amV == null) {
                this.amV = new com.baidu.live.k.c();
            }
            this.amV.initListener();
            this.amV.refreshCurUserScores();
        }
        this.eEq = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eEr = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eir = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.eEl.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.eEl.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.eEl.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.ajw && e.this.eiq) {
                    e.this.ajw = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.ajw) {
                    e.this.ajw = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.eEl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eir);
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
        if (this.eEt != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eEt.setLayoutParams(layoutParams);
        }
        if (this.eEo != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eEo.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.eEo.setLayoutParams(layoutParams2);
        }
        if (this.eEm != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.eEm.getLayoutParams();
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
                gradientDrawable.setColor(this.eEq);
            } else {
                gradientDrawable.setColor(this.eEr);
            }
            this.eEm.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eEw != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEw.setImageBitmap(this.eEI);
            } else {
                this.eEw.setImageBitmap(this.eEH);
            }
        }
        if (this.eEG != null) {
            this.eEG.ta();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bdM();
        ta();
        this.eEs.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cdu = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eEs.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eEv.setVisibility(8);
                this.eEF.setVisibility(8);
            } else {
                this.eEv.setVisibility(0);
                this.eEF.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eEx.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eEv.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.eEF.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eEw.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.eEq);
        } else {
            this.eEs.setVisibility(0);
            this.eEv.setVisibility(8);
            this.eEF.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eEm.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.eEl.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.eEq);
            } else {
                gradientDrawable.setColor(this.eEr);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eEO.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.eEO.setLayoutParams(layoutParams2);
        }
        this.eEm.setBackgroundDrawable(gradientDrawable);
        if (this.Yr) {
            iA(false);
        } else {
            iA(this.aqa);
        }
        if (this.eEg) {
            this.eEy.eHY.setVisibility(8);
        }
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        if (vJ != null && vJ.acj > 0) {
            this.eEB.setText(vJ.acj + "T豆加入");
        } else {
            this.eEB.setText("1000T豆加入");
        }
        this.eEv.setOnClickListener(this);
        this.eEy.eHV.setOnClickListener(this);
        this.eEB.setOnClickListener(this);
        this.eEF.setOnClickListener(this);
        this.eEy.eHR.setOnClickListener(this);
        this.eEy.eHY.setOnClickListener(this);
        this.eEy.eHQ.setOnClickListener(this);
        this.eEK.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eEy.eHO.setIsRound(true);
        this.eEy.eHO.setDrawBorder(false);
        this.eEy.eHO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEy.eHO.setAutoChangeStyle(false);
        this.eEy.eHO.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eEy.eHP.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.Yr) {
            if (this.aqa) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.agZ, str, this.otherParams);
        }
        this.eEJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
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
        if (this.eEK != null) {
            if (TextUtils.isEmpty(this.eEJ.getText())) {
                this.eEK.setEnabled(false);
                this.eEL.setText(String.valueOf(0));
            } else {
                this.eEK.setEnabled(true);
                this.eEL.setText(String.valueOf(this.eEJ.getText().length()));
            }
        }
        if (this.eEJ.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.eEJ.setText(this.eEJ.getText().subSequence(0, 10));
            this.eEJ.setSelection(this.eEJ.getText().length());
        }
    }

    private void bdM() {
        this.eEt = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eEs = this.mRootView.findViewById(a.g.space_view);
        this.eEm = this.mRootView.findViewById(a.g.layout_guard_info);
        this.eEn = this.mRootView.findViewById(a.g.info_layout);
        this.eEJ = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.eEo = this.mRootView.findViewById(a.g.input_name_layout);
        this.eEp = this.mRootView.findViewById(a.g.input_name);
        this.eEK = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.eEL = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eEu = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eEv = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eEw = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eEx = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eEy = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eEz = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eEA = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eEB = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eEC = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.eED = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.eEE = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.eEM = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.eEF = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.eEN = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.eEO = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void iA(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEw.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.Yr) {
                this.eEw.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.eEq);
                this.eEw.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.Yr) {
            if (this.eEH == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEH = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.eEH) {
                    decodeResource.recycle();
                }
            }
            if (this.eEI == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEI = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.eEI) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEw.setImageBitmap(this.eEI);
            } else {
                this.eEw.setImageBitmap(this.eEH);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eEw.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eEw.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEy.getLayoutParams();
        if (z || this.Yr) {
            this.eEy.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eEA.setVisibility(8);
            this.eEO.setVisibility(0);
            this.eEB.setVisibility(8);
        } else {
            this.eEy.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eEA.setVisibility(0);
            this.eEO.setVisibility(8);
            this.eEB.setVisibility(0);
        }
        this.eEy.setLayoutParams(layoutParams2);
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
            this.eEu.setVisibility(8);
            this.eEz.setVisibility(8);
            this.eEM.reset();
            this.eEM.setTitle(a.i.guard_club_no_create);
            this.eEM.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.eEE.setVisibility(0);
            return;
        }
        this.eEu.setVisibility(0);
        this.eEz.setVisibility(0);
        this.eEE.setVisibility(8);
        iA(z);
        this.eEy.eHO.startLoad(aVar.apS, 12, false);
        this.eEy.eHP.startLoad(com.baidu.live.guardclub.g.vH().bS(aVar.apQ), 10, false);
        boolean z2 = false;
        if (this.Yr && aVar.apU != null) {
            z2 = aVar.apU.optInt("can_update_name", 0) == 1;
        }
        int width = this.eEy.eFa.getWidth();
        if (width <= 0) {
            this.eEy.eFa.measure(0, 0);
            width = this.eEy.eFa.getMeasuredWidth();
        }
        String str3 = aVar.apL;
        int i2 = 0;
        if (z2) {
            this.eEy.eHQ.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eEy.eHQ.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eEy.avp.setPadding(0, 0, width + i2, 0);
            this.eEy.eFa.setPadding(0, 0, i2, 0);
            this.eEy.eFa.setVisibility(0);
        } else {
            this.eEy.avp.setPadding(0, 0, i2, 0);
            this.eEy.eFa.setPadding(0, 0, i2, 0);
            this.eEy.eFa.setVisibility(4);
            str2 = str3;
        }
        this.eEy.avp.setText(str2);
        String bU = com.baidu.live.guardclub.g.vH().bU(aVar.apQ);
        String str4 = (bU == null || "null".equals(bU)) ? "" : bU;
        Resources resources = this.eEy.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEy.getLayoutParams();
        if (z || this.Yr) {
            this.eEy.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.apN;
            if (aVar.apR > 0) {
                str5 = str5 + " / " + aVar.apR;
            }
            this.eEy.eHS.setText(str5);
            this.eEy.eHU.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eEA.setVisibility(8);
            this.eEO.setVisibility(0);
            this.eEB.setVisibility(8);
            iB(this.eEg);
        } else {
            this.eEy.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.apN;
            if (aVar.apR > 0) {
                str6 = str6 + " / " + aVar.apR;
            }
            this.eEy.eHS.setText(str6);
            this.eEy.eHU.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eEA.setVisibility(0);
            this.eEO.setVisibility(8);
            this.eEB.setVisibility(0);
            if (dVarArr != null) {
                this.eEC.setVisibility(0);
                this.eEN.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.eEN.addView(view, layoutParams2);
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
                this.eEC.setVisibility(8);
            }
        }
        this.eEy.setLayoutParams(layoutParams);
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
        this.eEy.eHT.setProgress(i);
        this.eEy.eHX.setText(aVar.apP < 10000 ? aVar.apP + "" : String.format("%.1f", Float.valueOf(((float) aVar.apP) / 10000.0f)) + "万");
        String str7 = aVar.apT;
        this.eEy.eGx.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bfb() {
        this.eEu.setVisibility(8);
        this.eEz.setVisibility(8);
        this.eEM.reset();
        this.eEM.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eEM.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eEi != null) {
                    e.this.eEi.onClick(view);
                }
            }
        });
        this.eEM.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eEE.setVisibility(0);
    }

    public void iB(boolean z) {
        this.eEG = new j(this.eEl, this.liveId, this.roomId, this.WZ, this.Yr, true, false, this.isFullScreen, this.otherParams, this.eEl.getUniqueId(), null);
        this.eEG.iC(z);
        View view = this.eEG.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eED.removeAllViews();
            this.eED.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.amV != null) {
            this.amV.onDestroy();
        }
        if (this.eEH != null) {
            this.eEH.recycle();
        }
        if (this.eEI != null) {
            this.eEI.recycle();
        }
        this.eEl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eir);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eEs || view == this.eEv || view == this.eEF) {
            this.activity.finish();
        } else if (view == this.eEy.eHR) {
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
        } else if (view == this.eEy.eHV) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.agZ);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eEy.eHY) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.agZ);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eEB) {
            if (this.apX != null) {
                ah vJ = com.baidu.live.guardclub.g.vH().vJ();
                if (vJ == null || vJ.acj <= 0) {
                    j = 1000;
                } else {
                    j = vJ.acj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    po(this.apX.id);
                } else if (this.eEg) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.apX));
                    this.activity.finish();
                }
            }
            if (!this.Yr) {
                if (TextUtils.isEmpty(this.eEa)) {
                    this.eEa = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.agZ, this.eEa, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.ajw) {
                this.eEJ.clearFocus();
                this.eEJ.setText("");
                BdUtilHelper.hideSoftKeyPad(this.eEl.getActivity(), this.eEJ);
                return;
            }
            this.activity.finish();
        } else if (view == this.eEK) {
            String obj = this.eEJ.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.apX.id, obj, "");
            }
        } else if (view == this.eEy.eHQ) {
            this.eEJ.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.eEl.getActivity(), this.eEJ);
        }
    }

    public void yu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eEy.avp.setText(str);
            this.eEJ.setText("");
            this.eEJ.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.eEl.getActivity(), this.eEJ);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEp.getLayoutParams();
        if (z) {
            this.eEm.setVisibility(this.isFullScreen ? 0 : 8);
            this.eEo.setVisibility(0);
            String charSequence = this.eEy.avp.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.eEJ.setText(charSequence);
                this.eEJ.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.eEJ.setText("");
            }
            layoutParams.bottomMargin = bfc();
        } else {
            layoutParams.bottomMargin = 0;
            this.eEo.setVisibility(8);
            this.eEm.setVisibility(0);
        }
        this.eEp.setLayoutParams(layoutParams);
    }

    protected int bfc() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.eEl.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.eEl.getPageContext().getPageActivity(), 48.0f);
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
