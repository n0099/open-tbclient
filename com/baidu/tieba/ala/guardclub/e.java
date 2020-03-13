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
    private com.baidu.live.k.c amW;
    private com.baidu.live.guardclub.a apY;
    private String apZ;
    private boolean aqb;
    private int cdw;
    private View eEA;
    private View eEB;
    private View eEC;
    private View eED;
    private int eEE;
    private int eEF;
    private View eEG;
    private LinearLayout eEH;
    private RelativeLayout eEI;
    private ImageView eEJ;
    private ImageView eEK;
    private LinearLayout eEL;
    private GuardClubInfoHeaderView eEM;
    private RelativeLayout eEN;
    private RelativeLayout eEO;
    private TextView eEP;
    private LinearLayout eEQ;
    private FrameLayout eER;
    private RelativeLayout eES;
    private ImageView eET;
    private j eEU;
    private Bitmap eEV;
    private Bitmap eEW;
    private EditText eEX;
    private TextView eEY;
    private TextView eEZ;
    private String eEo;
    private boolean eEu;
    private View.OnClickListener eEw;
    private GuardClubInfoActivity eEz;
    private CommonEmptyView eFa;
    private LinearLayout eFb;
    private LinearLayout eFc;
    private ViewTreeObserver.OnGlobalLayoutListener eiF;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eiE = true;
    private boolean ajw = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.eEz = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.WZ = j;
        this.liveId = j2;
        this.roomId = j3;
        this.agZ = str;
        this.Yr = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aqb = z3;
        this.eEu = z4;
        this.eEo = str3;
        this.isTranslucent = z5;
        this.eEw = onClickListener;
        if (!z3) {
            if (this.amW == null) {
                this.amW = new com.baidu.live.k.c();
            }
            this.amW.initListener();
            this.amW.refreshCurUserScores();
        }
        this.eEE = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eEF = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eiF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.eEz.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.eEz.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.eEz.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.ajw && e.this.eiE) {
                    e.this.ajw = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.ajw) {
                    e.this.ajw = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.eEz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eiF);
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
        if (this.eEH != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEH.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eEH.setLayoutParams(layoutParams);
        }
        if (this.eEC != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eEC.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.eEC.setLayoutParams(layoutParams2);
        }
        if (this.eEA != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.eEA.getLayoutParams();
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
                gradientDrawable.setColor(this.eEE);
            } else {
                gradientDrawable.setColor(this.eEF);
            }
            this.eEA.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eEK != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEK.setImageBitmap(this.eEW);
            } else {
                this.eEK.setImageBitmap(this.eEV);
            }
        }
        if (this.eEU != null) {
            this.eEU.ta();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bdP();
        ta();
        this.eEG.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cdw = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eEG.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eEJ.setVisibility(8);
                this.eET.setVisibility(8);
            } else {
                this.eEJ.setVisibility(0);
                this.eET.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eEL.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eEJ.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.eET.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eEK.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.eEE);
        } else {
            this.eEG.setVisibility(0);
            this.eEJ.setVisibility(8);
            this.eET.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eEA.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.eEz.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.eEE);
            } else {
                gradientDrawable.setColor(this.eEF);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eFc.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.eFc.setLayoutParams(layoutParams2);
        }
        this.eEA.setBackgroundDrawable(gradientDrawable);
        if (this.Yr) {
            iA(false);
        } else {
            iA(this.aqb);
        }
        if (this.eEu) {
            this.eEM.eIm.setVisibility(8);
        }
        ah vJ = com.baidu.live.guardclub.g.vH().vJ();
        if (vJ != null && vJ.acj > 0) {
            this.eEP.setText(vJ.acj + "T豆加入");
        } else {
            this.eEP.setText("1000T豆加入");
        }
        this.eEJ.setOnClickListener(this);
        this.eEM.eIj.setOnClickListener(this);
        this.eEP.setOnClickListener(this);
        this.eET.setOnClickListener(this);
        this.eEM.eIf.setOnClickListener(this);
        this.eEM.eIm.setOnClickListener(this);
        this.eEM.eIe.setOnClickListener(this);
        this.eEY.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eEM.eIc.setIsRound(true);
        this.eEM.eIc.setDrawBorder(false);
        this.eEM.eIc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEM.eIc.setAutoChangeStyle(false);
        this.eEM.eIc.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eEM.eId.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.Yr) {
            if (this.aqb) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.agZ, str, this.otherParams);
        }
        this.eEX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
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
        if (this.eEY != null) {
            if (TextUtils.isEmpty(this.eEX.getText())) {
                this.eEY.setEnabled(false);
                this.eEZ.setText(String.valueOf(0));
            } else {
                this.eEY.setEnabled(true);
                this.eEZ.setText(String.valueOf(this.eEX.getText().length()));
            }
        }
        if (this.eEX.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.eEX.setText(this.eEX.getText().subSequence(0, 10));
            this.eEX.setSelection(this.eEX.getText().length());
        }
    }

    private void bdP() {
        this.eEH = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eEG = this.mRootView.findViewById(a.g.space_view);
        this.eEA = this.mRootView.findViewById(a.g.layout_guard_info);
        this.eEB = this.mRootView.findViewById(a.g.info_layout);
        this.eEX = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.eEC = this.mRootView.findViewById(a.g.input_name_layout);
        this.eED = this.mRootView.findViewById(a.g.input_name);
        this.eEY = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.eEZ = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eEI = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eEJ = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eEK = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eEL = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eEM = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eEN = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eEO = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eEP = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eEQ = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.eER = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.eES = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.eFa = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.eET = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.eFb = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.eFc = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void iA(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEK.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.Yr) {
                this.eEK.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.eEE);
                this.eEK.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.Yr) {
            if (this.eEV == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEV = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.eEV) {
                    decodeResource.recycle();
                }
            }
            if (this.eEW == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eEW = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.eEW) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eEK.setImageBitmap(this.eEW);
            } else {
                this.eEK.setImageBitmap(this.eEV);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eEK.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eEK.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEM.getLayoutParams();
        if (z || this.Yr) {
            this.eEM.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eEO.setVisibility(8);
            this.eFc.setVisibility(0);
            this.eEP.setVisibility(8);
        } else {
            this.eEM.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eEO.setVisibility(0);
            this.eFc.setVisibility(8);
            this.eEP.setVisibility(0);
        }
        this.eEM.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.apY = aVar;
        this.apZ = str;
        if (aVar == null || aVar.id <= 0) {
            this.eEI.setVisibility(8);
            this.eEN.setVisibility(8);
            this.eFa.reset();
            this.eFa.setTitle(a.i.guard_club_no_create);
            this.eFa.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.eES.setVisibility(0);
            return;
        }
        this.eEI.setVisibility(0);
        this.eEN.setVisibility(0);
        this.eES.setVisibility(8);
        iA(z);
        this.eEM.eIc.startLoad(aVar.apT, 12, false);
        this.eEM.eId.startLoad(com.baidu.live.guardclub.g.vH().bS(aVar.apR), 10, false);
        boolean z2 = false;
        if (this.Yr && aVar.apV != null) {
            z2 = aVar.apV.optInt("can_update_name", 0) == 1;
        }
        int width = this.eEM.eFo.getWidth();
        if (width <= 0) {
            this.eEM.eFo.measure(0, 0);
            width = this.eEM.eFo.getMeasuredWidth();
        }
        String str3 = aVar.apM;
        int i2 = 0;
        if (z2) {
            this.eEM.eIe.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eEM.eIe.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eEM.avq.setPadding(0, 0, width + i2, 0);
            this.eEM.eFo.setPadding(0, 0, i2, 0);
            this.eEM.eFo.setVisibility(0);
        } else {
            this.eEM.avq.setPadding(0, 0, i2, 0);
            this.eEM.eFo.setPadding(0, 0, i2, 0);
            this.eEM.eFo.setVisibility(4);
            str2 = str3;
        }
        this.eEM.avq.setText(str2);
        String bU = com.baidu.live.guardclub.g.vH().bU(aVar.apR);
        String str4 = (bU == null || "null".equals(bU)) ? "" : bU;
        Resources resources = this.eEM.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEM.getLayoutParams();
        if (z || this.Yr) {
            this.eEM.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.apO;
            if (aVar.apS > 0) {
                str5 = str5 + " / " + aVar.apS;
            }
            this.eEM.eIg.setText(str5);
            this.eEM.eIi.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eEO.setVisibility(8);
            this.eFc.setVisibility(0);
            this.eEP.setVisibility(8);
            iB(this.eEu);
        } else {
            this.eEM.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.apO;
            if (aVar.apS > 0) {
                str6 = str6 + " / " + aVar.apS;
            }
            this.eEM.eIg.setText(str6);
            this.eEM.eIi.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eEO.setVisibility(0);
            this.eFc.setVisibility(8);
            this.eEP.setVisibility(0);
            if (dVarArr != null) {
                this.eEQ.setVisibility(0);
                this.eFb.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.eFb.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aqk, 10, false);
                        textView.setText(dVar.aql + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.eEQ.setVisibility(8);
            }
        }
        this.eEM.setLayoutParams(layoutParams);
        if (aVar.apO == aVar.apS) {
            i = 100;
        } else if (aVar.apO <= 0) {
            i = 0;
        } else if (aVar.apS <= 0) {
            i = 100;
        } else if (aVar.apO >= aVar.apS) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.apO * 100) / aVar.apS);
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
        this.eEM.eIh.setProgress(i);
        this.eEM.eIl.setText(aVar.apQ < 10000 ? aVar.apQ + "" : String.format("%.1f", Float.valueOf(((float) aVar.apQ) / 10000.0f)) + "万");
        String str7 = aVar.apU;
        this.eEM.eGL.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bfe() {
        this.eEI.setVisibility(8);
        this.eEN.setVisibility(8);
        this.eFa.reset();
        this.eFa.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eFa.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eEw != null) {
                    e.this.eEw.onClick(view);
                }
            }
        });
        this.eFa.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eES.setVisibility(0);
    }

    public void iB(boolean z) {
        this.eEU = new j(this.eEz, this.liveId, this.roomId, this.WZ, this.Yr, true, false, this.isFullScreen, this.otherParams, this.eEz.getUniqueId(), null);
        this.eEU.iC(z);
        View view = this.eEU.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eER.removeAllViews();
            this.eER.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.amW != null) {
            this.amW.onDestroy();
        }
        if (this.eEV != null) {
            this.eEV.recycle();
        }
        if (this.eEW != null) {
            this.eEW.recycle();
        }
        this.eEz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eiF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eEG || view == this.eEJ || view == this.eET) {
            this.activity.finish();
        } else if (view == this.eEM.eIf) {
            if (!TextUtils.isEmpty(this.apZ)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.apZ);
            }
            if (!this.Yr) {
                if (this.aqb) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.agZ, str, this.otherParams);
            }
        } else if (view == this.eEM.eIj) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.agZ);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eEM.eIm) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.WZ, this.liveId, this.Yr, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.agZ);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eEP) {
            if (this.apY != null) {
                ah vJ = com.baidu.live.guardclub.g.vH().vJ();
                if (vJ == null || vJ.acj <= 0) {
                    j = 1000;
                } else {
                    j = vJ.acj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    po(this.apY.id);
                } else if (this.eEu) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.apY));
                    this.activity.finish();
                }
            }
            if (!this.Yr) {
                if (TextUtils.isEmpty(this.eEo)) {
                    this.eEo = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.agZ, this.eEo, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.ajw) {
                this.eEX.clearFocus();
                this.eEX.setText("");
                BdUtilHelper.hideSoftKeyPad(this.eEz.getActivity(), this.eEX);
                return;
            }
            this.activity.finish();
        } else if (view == this.eEY) {
            String obj = this.eEX.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.apY.id, obj, "");
            }
        } else if (view == this.eEM.eIe) {
            this.eEX.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.eEz.getActivity(), this.eEX);
        }
    }

    public void yv(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eEM.avq.setText(str);
            this.eEX.setText("");
            this.eEX.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.eEz.getActivity(), this.eEX);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eED.getLayoutParams();
        if (z) {
            this.eEA.setVisibility(this.isFullScreen ? 0 : 8);
            this.eEC.setVisibility(0);
            String charSequence = this.eEM.avq.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.eEX.setText(charSequence);
                this.eEX.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.eEX.setText("");
            }
            layoutParams.bottomMargin = bff();
        } else {
            layoutParams.bottomMargin = 0;
            this.eEC.setVisibility(8);
            this.eEA.setVisibility(0);
        }
        this.eED.setLayoutParams(layoutParams);
    }

    protected int bff() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.eEz.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.eEz.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void po(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.bQ(i);
        cVar.a(this.apY);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void f(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.cM(i);
        cVar.yx(str);
        cVar.yy(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
