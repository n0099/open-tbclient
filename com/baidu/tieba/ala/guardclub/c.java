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
import com.baidu.live.data.ag;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    private long Vt;
    private boolean WF;
    private Activity activity;
    private String aeS;
    private com.baidu.live.j.c akJ;
    private int bZo;
    private LinearLayout eAA;
    private int eAa;
    private View eAb;
    private LinearLayout eAc;
    private RelativeLayout eAd;
    private ImageView eAe;
    private ImageView eAf;
    private LinearLayout eAg;
    private GuardClubInfoHeaderView eAh;
    private RelativeLayout eAi;
    private RelativeLayout eAj;
    private TextView eAk;
    private LinearLayout eAl;
    private FrameLayout eAm;
    private RelativeLayout eAn;
    private ImageView eAo;
    private h eAp;
    private String eAq;
    private Bitmap eAr;
    private Bitmap eAs;
    private boolean eAt;
    private String eAu;
    private EditText eAv;
    private TextView eAw;
    private TextView eAx;
    private CommonEmptyView eAy;
    private LinearLayout eAz;
    private ViewTreeObserver.OnGlobalLayoutListener eeo;
    private boolean ezM;
    private com.baidu.tieba.ala.guardclub.model.c ezN;
    private View.OnClickListener ezP;
    private GuardClubInfoActivity ezU;
    private View ezV;
    private View ezW;
    private View ezX;
    private View ezY;
    private int ezZ;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean een = true;
    private boolean ahn = false;

    public c(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.ezU = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.Vt = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aeS = str;
        this.WF = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.eAt = z3;
        this.ezM = z4;
        this.eAu = str3;
        this.isTranslucent = z5;
        this.ezP = onClickListener;
        if (!z3) {
            if (this.akJ == null) {
                this.akJ = new com.baidu.live.j.c();
            }
            this.akJ.initListener();
            this.akJ.refreshCurUserScores();
        }
        this.ezZ = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eAa = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eeo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.c.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                c.this.ezU.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(c.this.ezU.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(c.this.ezU.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !c.this.ahn && c.this.een) {
                    c.this.ahn = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    c.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.ahn) {
                    c.this.ahn = false;
                    c.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.ezU.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeo);
    }

    public void rP() {
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
        if (this.eAc != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eAc.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eAc.setLayoutParams(layoutParams);
        }
        if (this.ezX != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ezX.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.ezX.setLayoutParams(layoutParams2);
        }
        if (this.ezV != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.ezV.getLayoutParams();
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
                gradientDrawable.setColor(this.ezZ);
            } else {
                gradientDrawable.setColor(this.eAa);
            }
            this.ezV.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eAf != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eAf.setImageBitmap(this.eAs);
            } else {
                this.eAf.setImageBitmap(this.eAr);
            }
        }
        if (this.eAp != null) {
            this.eAp.rP();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bbx();
        rP();
        this.eAb.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.bZo = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eAb.setVisibility(8);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eAe.setVisibility(0);
                this.eAo.setVisibility(0);
            } else {
                this.eAe.setVisibility(8);
                this.eAo.setVisibility(8);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eAg.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eAe.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.eAo.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eAf.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.ezZ);
        } else {
            this.eAb.setVisibility(0);
            this.eAe.setVisibility(8);
            this.eAo.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.ezV.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.ezU.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.ezZ);
            } else {
                gradientDrawable.setColor(this.eAa);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eAA.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.eAA.setLayoutParams(layoutParams2);
        }
        this.ezV.setBackgroundDrawable(gradientDrawable);
        if (this.WF) {
            it(false);
        } else {
            it(this.eAt);
        }
        if (this.ezM) {
            this.eAh.eEe.setVisibility(8);
        }
        ag bdb = l.bcZ().bdb();
        if (bdb != null && bdb.aap > 0) {
            this.eAk.setText(bdb.aap + "T豆加入");
        } else {
            this.eAk.setText("1000T豆加入");
        }
        this.eAe.setOnClickListener(this);
        this.eAh.eEb.setOnClickListener(this);
        this.eAk.setOnClickListener(this);
        this.eAo.setOnClickListener(this);
        this.eAh.eDX.setOnClickListener(this);
        this.eAh.eEe.setOnClickListener(this);
        this.eAh.eDW.setOnClickListener(this);
        this.eAw.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eAh.eDU.setIsRound(true);
        this.eAh.eDU.setDrawBorder(false);
        this.eAh.eDU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAh.eDU.setAutoChangeStyle(false);
        this.eAh.eDU.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eAh.eDV.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.WF) {
            if (this.eAt) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aeS, str, this.otherParams);
        }
        this.eAv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                c.this.vV();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (this.eAw != null) {
            if (TextUtils.isEmpty(this.eAv.getText())) {
                this.eAw.setEnabled(false);
                this.eAx.setText(String.valueOf(0));
            } else {
                this.eAw.setEnabled(true);
                this.eAx.setText(String.valueOf(this.eAv.getText().length()));
            }
        }
        if (this.eAv.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.eAv.setText(this.eAv.getText().subSequence(0, 10));
            this.eAv.setSelection(this.eAv.getText().length());
        }
    }

    private void bbx() {
        this.eAc = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eAb = this.mRootView.findViewById(a.g.space_view);
        this.ezV = this.mRootView.findViewById(a.g.layout_guard_info);
        this.ezW = this.mRootView.findViewById(a.g.info_layout);
        this.eAv = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.ezX = this.mRootView.findViewById(a.g.input_name_layout);
        this.ezY = this.mRootView.findViewById(a.g.input_name);
        this.eAw = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.eAx = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eAd = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eAe = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eAf = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eAg = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eAh = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eAi = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eAj = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eAk = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eAl = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.eAm = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.eAn = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.eAy = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.eAo = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.eAz = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.eAA = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void it(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAf.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.WF) {
                this.eAf.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.ezZ);
                this.eAf.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.WF) {
            if (this.eAr == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eAr = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.eAr) {
                    decodeResource.recycle();
                }
            }
            if (this.eAs == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eAs = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.eAs) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eAf.setImageBitmap(this.eAs);
            } else {
                this.eAf.setImageBitmap(this.eAr);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eAf.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eAf.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAh.getLayoutParams();
        if (z || this.WF) {
            this.eAh.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eAj.setVisibility(8);
            this.eAA.setVisibility(0);
            this.eAk.setVisibility(8);
        } else {
            this.eAh.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eAj.setVisibility(0);
            this.eAA.setVisibility(8);
            this.eAk.setVisibility(0);
        }
        this.eAh.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, String str, String[] strArr, boolean z, com.baidu.tieba.ala.guardclub.model.j[] jVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.ezN = cVar;
        this.eAq = str;
        if (cVar == null || cVar.id <= 0) {
            this.eAd.setVisibility(8);
            this.eAi.setVisibility(8);
            this.eAy.reset();
            this.eAy.setTitle(a.i.guard_club_no_create);
            this.eAy.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.eAn.setVisibility(0);
            return;
        }
        this.eAd.setVisibility(0);
        this.eAi.setVisibility(0);
        this.eAn.setVisibility(8);
        it(z);
        this.eAh.eDU.startLoad(cVar.eCG, 12, false);
        this.eAh.eDV.startLoad(l.bcZ().pd(cVar.eCE), 10, false);
        boolean z2 = false;
        if (this.WF && cVar.eCI != null) {
            z2 = cVar.eCI.optInt("can_update_name", 0) == 1;
        }
        int width = this.eAh.eAM.getWidth();
        if (width <= 0) {
            this.eAh.eAM.measure(0, 0);
            width = this.eAh.eAM.getMeasuredWidth();
        }
        String str3 = cVar.eCz;
        int i2 = 0;
        if (z2) {
            this.eAh.eDW.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eAh.eDW.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eAh.aro.setPadding(0, 0, width + i2, 0);
            this.eAh.eAM.setPadding(0, 0, i2, 0);
            this.eAh.eAM.setVisibility(0);
        } else {
            this.eAh.aro.setPadding(0, 0, i2, 0);
            this.eAh.eAM.setPadding(0, 0, i2, 0);
            this.eAh.eAM.setVisibility(4);
            str2 = str3;
        }
        this.eAh.aro.setText(str2);
        String pf = l.bcZ().pf(cVar.eCE);
        String str4 = (pf == null || "null".equals(pf)) ? "" : pf;
        Resources resources = this.eAh.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAh.getLayoutParams();
        if (z || this.WF) {
            this.eAh.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + cVar.eCB;
            if (cVar.eCF > 0) {
                str5 = str5 + " / " + cVar.eCF;
            }
            this.eAh.eDY.setText(str5);
            this.eAh.eEa.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eAj.setVisibility(8);
            this.eAA.setVisibility(0);
            this.eAk.setVisibility(8);
            iu(this.ezM);
        } else {
            this.eAh.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + cVar.eCB;
            if (cVar.eCF > 0) {
                str6 = str6 + " / " + cVar.eCF;
            }
            this.eAh.eDY.setText(str6);
            this.eAh.eEa.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eAj.setVisibility(0);
            this.eAA.setVisibility(8);
            this.eAk.setVisibility(0);
            if (jVarArr != null) {
                this.eAl.setVisibility(0);
                this.eAz.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < jVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.eAz.addView(view, layoutParams2);
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
                        tbImageView.startLoad(jVar.eDg, 10, false);
                        textView.setText(jVar.eDh + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.eAl.setVisibility(8);
            }
        }
        this.eAh.setLayoutParams(layoutParams);
        if (cVar.eCB == cVar.eCF) {
            i = 100;
        } else if (cVar.eCB <= 0) {
            i = 0;
        } else if (cVar.eCF <= 0) {
            i = 100;
        } else if (cVar.eCB >= cVar.eCF) {
            i = 100;
        } else {
            try {
                i = (int) ((cVar.eCB * 100) / cVar.eCF);
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
        this.eAh.eDZ.setProgress(i);
        this.eAh.eEd.setText(cVar.eCD < 10000 ? cVar.eCD + "" : String.format("%.1f", Float.valueOf(((float) cVar.eCD) / 10000.0f)) + "万");
        String str7 = cVar.eCH;
        this.eAh.eCj.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bcN() {
        this.eAd.setVisibility(8);
        this.eAi.setVisibility(8);
        this.eAy.reset();
        this.eAy.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eAy.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ezP != null) {
                    c.this.ezP.onClick(view);
                }
            }
        });
        this.eAy.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eAn.setVisibility(0);
    }

    public void iu(boolean z) {
        this.eAp = new h(this.ezU, this.liveId, this.roomId, this.Vt, this.WF, true, false, this.isFullScreen, this.otherParams, this.ezU.getUniqueId(), null);
        this.eAp.iv(z);
        View view = this.eAp.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eAm.removeAllViews();
            this.eAm.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.akJ != null) {
            this.akJ.onDestroy();
        }
        if (this.eAr != null) {
            this.eAr.recycle();
        }
        if (this.eAs != null) {
            this.eAs.recycle();
        }
        this.ezU.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eAb || view == this.eAe || view == this.eAo) {
            this.activity.finish();
        } else if (view == this.eAh.eDX) {
            if (!TextUtils.isEmpty(this.eAq)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.eAq);
            }
            if (!this.WF) {
                if (this.eAt) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aeS, str, this.otherParams);
            }
        } else if (view == this.eAh.eEb) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.Vt, this.liveId, this.WF, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aeS);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eAh.eEe) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.Vt, this.liveId, this.WF, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aeS);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eAk) {
            if (this.ezN != null) {
                ag bdb = l.bcZ().bdb();
                if (bdb == null || bdb.aap <= 0) {
                    j = 1000;
                } else {
                    j = bdb.aap;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    oX(this.ezN.id);
                } else if (this.ezM) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.ezN));
                    this.activity.finish();
                }
            }
            if (!this.WF) {
                if (TextUtils.isEmpty(this.eAu)) {
                    this.eAu = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aeS, this.eAu, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.ahn) {
                this.eAv.clearFocus();
                this.eAv.setText("");
                BdUtilHelper.hideSoftKeyPad(this.ezU.getActivity(), this.eAv);
                return;
            }
            this.activity.finish();
        } else if (view == this.eAw) {
            String obj = this.eAv.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.ezN.id, obj, "");
            }
        } else if (view == this.eAh.eDW) {
            this.eAv.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.ezU.getActivity(), this.eAv);
        }
    }

    public void xZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eAh.aro.setText(str);
            this.eAv.setText("");
            this.eAv.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.ezU.getActivity(), this.eAv);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ezY.getLayoutParams();
        if (z) {
            this.ezV.setVisibility(this.isFullScreen ? 0 : 8);
            this.ezX.setVisibility(0);
            String charSequence = this.eAh.aro.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.eAv.setText(charSequence);
                this.eAv.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.eAv.setText("");
            }
            layoutParams.bottomMargin = bcO();
        } else {
            layoutParams.bottomMargin = 0;
            this.ezX.setVisibility(8);
            this.ezV.setVisibility(0);
        }
        this.ezY.setLayoutParams(layoutParams);
    }

    protected int bcO() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.ezU.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.ezU.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void oX(int i) {
        com.baidu.tieba.ala.guardclub.model.f fVar = new com.baidu.tieba.ala.guardclub.model.f();
        fVar.pg(i);
        fVar.a(this.ezN);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void f(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.e eVar = new com.baidu.tieba.ala.guardclub.model.e();
        eVar.cK(i);
        eVar.yb(str);
        eVar.yc(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
