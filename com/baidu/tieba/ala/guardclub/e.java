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
    private long Xj;
    private boolean YB;
    private Activity activity;
    private String ahj;
    private com.baidu.live.k.c ang;
    private com.baidu.live.guardclub.a aqi;
    private String aqj;
    private boolean aql;
    private int cdH;
    private String eEK;
    private boolean eEQ;
    private View.OnClickListener eES;
    private GuardClubInfoActivity eEV;
    private View eEW;
    private View eEX;
    private View eEY;
    private View eEZ;
    private int eFa;
    private int eFb;
    private View eFc;
    private LinearLayout eFd;
    private RelativeLayout eFe;
    private ImageView eFf;
    private ImageView eFg;
    private LinearLayout eFh;
    private GuardClubInfoHeaderView eFi;
    private RelativeLayout eFj;
    private RelativeLayout eFk;
    private TextView eFl;
    private LinearLayout eFm;
    private FrameLayout eFn;
    private RelativeLayout eFo;
    private ImageView eFp;
    private j eFq;
    private Bitmap eFr;
    private Bitmap eFs;
    private EditText eFt;
    private TextView eFu;
    private TextView eFv;
    private CommonEmptyView eFw;
    private LinearLayout eFx;
    private LinearLayout eFy;
    private ViewTreeObserver.OnGlobalLayoutListener eiV;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eiU = true;
    private boolean ajG = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.eEV = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.Xj = j;
        this.liveId = j2;
        this.roomId = j3;
        this.ahj = str;
        this.YB = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.aql = z3;
        this.eEQ = z4;
        this.eEK = str3;
        this.isTranslucent = z5;
        this.eES = onClickListener;
        if (!z3) {
            if (this.ang == null) {
                this.ang = new com.baidu.live.k.c();
            }
            this.ang.initListener();
            this.ang.refreshCurUserScores();
        }
        this.eFa = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eFb = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eiV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.eEV.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.eEV.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.eEV.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.ajG && e.this.eiU) {
                    e.this.ajG = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.ajG) {
                    e.this.ajG = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.eEV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eiV);
    }

    public void tf() {
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
        if (this.eFd != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eFd.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eFd.setLayoutParams(layoutParams);
        }
        if (this.eEY != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eEY.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.eEY.setLayoutParams(layoutParams2);
        }
        if (this.eEW != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.eEW.getLayoutParams();
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
                gradientDrawable.setColor(this.eFa);
            } else {
                gradientDrawable.setColor(this.eFb);
            }
            this.eEW.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eFg != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eFg.setImageBitmap(this.eFs);
            } else {
                this.eFg.setImageBitmap(this.eFr);
            }
        }
        if (this.eFq != null) {
            this.eFq.tf();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bdU();
        tf();
        this.eFc.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.cdH = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eFc.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eFf.setVisibility(8);
                this.eFp.setVisibility(8);
            } else {
                this.eFf.setVisibility(0);
                this.eFp.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eFh.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eFf.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.eFp.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eFg.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.eFa);
        } else {
            this.eFc.setVisibility(0);
            this.eFf.setVisibility(8);
            this.eFp.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eEW.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.eEV.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.eFa);
            } else {
                gradientDrawable.setColor(this.eFb);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eFy.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.eFy.setLayoutParams(layoutParams2);
        }
        this.eEW.setBackgroundDrawable(gradientDrawable);
        if (this.YB) {
            iC(false);
        } else {
            iC(this.aql);
        }
        if (this.eEQ) {
            this.eFi.eII.setVisibility(8);
        }
        ah vO = com.baidu.live.guardclub.g.vM().vO();
        if (vO != null && vO.acx > 0) {
            this.eFl.setText(vO.acx + "T豆加入");
        } else {
            this.eFl.setText("1000T豆加入");
        }
        this.eFf.setOnClickListener(this);
        this.eFi.eIF.setOnClickListener(this);
        this.eFl.setOnClickListener(this);
        this.eFp.setOnClickListener(this);
        this.eFi.eIB.setOnClickListener(this);
        this.eFi.eII.setOnClickListener(this);
        this.eFi.eIA.setOnClickListener(this);
        this.eFu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eFi.eIy.setIsRound(true);
        this.eFi.eIy.setDrawBorder(false);
        this.eFi.eIy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eFi.eIy.setAutoChangeStyle(false);
        this.eFi.eIy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eFi.eIz.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.YB) {
            if (this.aql) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.ahj, str, this.otherParams);
        }
        this.eFt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.xZ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xZ() {
        if (this.eFu != null) {
            if (TextUtils.isEmpty(this.eFt.getText())) {
                this.eFu.setEnabled(false);
                this.eFv.setText(String.valueOf(0));
            } else {
                this.eFu.setEnabled(true);
                this.eFv.setText(String.valueOf(this.eFt.getText().length()));
            }
        }
        if (this.eFt.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.eFt.setText(this.eFt.getText().subSequence(0, 10));
            this.eFt.setSelection(this.eFt.getText().length());
        }
    }

    private void bdU() {
        this.eFd = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eFc = this.mRootView.findViewById(a.g.space_view);
        this.eEW = this.mRootView.findViewById(a.g.layout_guard_info);
        this.eEX = this.mRootView.findViewById(a.g.info_layout);
        this.eFt = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.eEY = this.mRootView.findViewById(a.g.input_name_layout);
        this.eEZ = this.mRootView.findViewById(a.g.input_name);
        this.eFu = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.eFv = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eFe = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eFf = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eFg = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eFh = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eFi = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eFj = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eFk = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eFl = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eFm = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.eFn = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.eFo = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.eFw = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.eFp = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.eFx = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.eFy = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void iC(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFg.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.YB) {
                this.eFg.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.eFa);
                this.eFg.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.YB) {
            if (this.eFr == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eFr = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.eFr) {
                    decodeResource.recycle();
                }
            }
            if (this.eFs == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.eFs = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.eFs) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eFg.setImageBitmap(this.eFs);
            } else {
                this.eFg.setImageBitmap(this.eFr);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eFg.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eFg.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eFi.getLayoutParams();
        if (z || this.YB) {
            this.eFi.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eFk.setVisibility(8);
            this.eFy.setVisibility(0);
            this.eFl.setVisibility(8);
        } else {
            this.eFi.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eFk.setVisibility(0);
            this.eFy.setVisibility(8);
            this.eFl.setVisibility(0);
        }
        this.eFi.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.aqi = aVar;
        this.aqj = str;
        if (aVar == null || aVar.id <= 0) {
            this.eFe.setVisibility(8);
            this.eFj.setVisibility(8);
            this.eFw.reset();
            this.eFw.setTitle(a.i.guard_club_no_create);
            this.eFw.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.eFo.setVisibility(0);
            return;
        }
        this.eFe.setVisibility(0);
        this.eFj.setVisibility(0);
        this.eFo.setVisibility(8);
        iC(z);
        this.eFi.eIy.startLoad(aVar.aqd, 12, false);
        this.eFi.eIz.startLoad(com.baidu.live.guardclub.g.vM().bS(aVar.aqb), 10, false);
        boolean z2 = false;
        if (this.YB && aVar.aqf != null) {
            z2 = aVar.aqf.optInt("can_update_name", 0) == 1;
        }
        int width = this.eFi.eFK.getWidth();
        if (width <= 0) {
            this.eFi.eFK.measure(0, 0);
            width = this.eFi.eFK.getMeasuredWidth();
        }
        String str3 = aVar.apW;
        int i2 = 0;
        if (z2) {
            this.eFi.eIA.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eFi.eIA.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eFi.avA.setPadding(0, 0, width + i2, 0);
            this.eFi.eFK.setPadding(0, 0, i2, 0);
            this.eFi.eFK.setVisibility(0);
        } else {
            this.eFi.avA.setPadding(0, 0, i2, 0);
            this.eFi.eFK.setPadding(0, 0, i2, 0);
            this.eFi.eFK.setVisibility(4);
            str2 = str3;
        }
        this.eFi.avA.setText(str2);
        String bU = com.baidu.live.guardclub.g.vM().bU(aVar.aqb);
        String str4 = (bU == null || "null".equals(bU)) ? "" : bU;
        Resources resources = this.eFi.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFi.getLayoutParams();
        if (z || this.YB) {
            this.eFi.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.apY;
            if (aVar.aqc > 0) {
                str5 = str5 + " / " + aVar.aqc;
            }
            this.eFi.eIC.setText(str5);
            this.eFi.eIE.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eFk.setVisibility(8);
            this.eFy.setVisibility(0);
            this.eFl.setVisibility(8);
            iD(this.eEQ);
        } else {
            this.eFi.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.apY;
            if (aVar.aqc > 0) {
                str6 = str6 + " / " + aVar.aqc;
            }
            this.eFi.eIC.setText(str6);
            this.eFi.eIE.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eFk.setVisibility(0);
            this.eFy.setVisibility(8);
            this.eFl.setVisibility(0);
            if (dVarArr != null) {
                this.eFm.setVisibility(0);
                this.eFx.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.eFx.addView(view, layoutParams2);
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
                        tbImageView.startLoad(dVar.aqu, 10, false);
                        textView.setText(dVar.aqv + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.eFm.setVisibility(8);
            }
        }
        this.eFi.setLayoutParams(layoutParams);
        if (aVar.apY == aVar.aqc) {
            i = 100;
        } else if (aVar.apY <= 0) {
            i = 0;
        } else if (aVar.aqc <= 0) {
            i = 100;
        } else if (aVar.apY >= aVar.aqc) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.apY * 100) / aVar.aqc);
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
        this.eFi.eID.setProgress(i);
        this.eFi.eIH.setText(aVar.aqa < 10000 ? aVar.aqa + "" : String.format("%.1f", Float.valueOf(((float) aVar.aqa) / 10000.0f)) + "万");
        String str7 = aVar.aqe;
        this.eFi.eHh.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bfj() {
        this.eFe.setVisibility(8);
        this.eFj.setVisibility(8);
        this.eFw.reset();
        this.eFw.setTitle(a.i.sdk_net_fail_tip_rank);
        this.eFw.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eES != null) {
                    e.this.eES.onClick(view);
                }
            }
        });
        this.eFw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.eFo.setVisibility(0);
    }

    public void iD(boolean z) {
        this.eFq = new j(this.eEV, this.liveId, this.roomId, this.Xj, this.YB, true, false, this.isFullScreen, this.otherParams, this.eEV.getUniqueId(), null);
        this.eFq.iE(z);
        View view = this.eFq.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eFn.removeAllViews();
            this.eFn.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.ang != null) {
            this.ang.onDestroy();
        }
        if (this.eFr != null) {
            this.eFr.recycle();
        }
        if (this.eFs != null) {
            this.eFs.recycle();
        }
        this.eEV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eiV);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eFc || view == this.eFf || view == this.eFp) {
            this.activity.finish();
        } else if (view == this.eFi.eIB) {
            if (!TextUtils.isEmpty(this.aqj)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.aqj);
            }
            if (!this.YB) {
                if (this.aql) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.ahj, str, this.otherParams);
            }
        } else if (view == this.eFi.eIF) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.Xj, this.liveId, this.YB, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.ahj);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eFi.eII) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.Xj, this.liveId, this.YB, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.ahj);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eFl) {
            if (this.aqi != null) {
                ah vO = com.baidu.live.guardclub.g.vM().vO();
                if (vO == null || vO.acx <= 0) {
                    j = 1000;
                } else {
                    j = vO.acx;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    pq(this.aqi.id);
                } else if (this.eEQ) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.aqi));
                    this.activity.finish();
                }
            }
            if (!this.YB) {
                if (TextUtils.isEmpty(this.eEK)) {
                    this.eEK = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.ahj, this.eEK, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.ajG) {
                this.eFt.clearFocus();
                this.eFt.setText("");
                BdUtilHelper.hideSoftKeyPad(this.eEV.getActivity(), this.eFt);
                return;
            }
            this.activity.finish();
        } else if (view == this.eFu) {
            String obj = this.eFt.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.aqi.id, obj, "");
            }
        } else if (view == this.eFi.eIA) {
            this.eFt.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.eEV.getActivity(), this.eFt);
        }
    }

    public void yv(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eFi.avA.setText(str);
            this.eFt.setText("");
            this.eFt.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.eEV.getActivity(), this.eFt);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEZ.getLayoutParams();
        if (z) {
            this.eEW.setVisibility(this.isFullScreen ? 0 : 8);
            this.eEY.setVisibility(0);
            String charSequence = this.eFi.avA.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.eFt.setText(charSequence);
                this.eFt.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.eFt.setText("");
            }
            layoutParams.bottomMargin = bfk();
        } else {
            layoutParams.bottomMargin = 0;
            this.eEY.setVisibility(8);
            this.eEW.setVisibility(0);
        }
        this.eEZ.setLayoutParams(layoutParams);
    }

    protected int bfk() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.eEV.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.eEV.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void pq(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.bQ(i);
        cVar.a(this.aqi);
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
