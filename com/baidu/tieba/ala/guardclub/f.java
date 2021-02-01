package com.baidu.tieba.ala.guardclub;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubMemberListActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class f implements View.OnClickListener {
    private boolean aJC;
    private String aOQ;
    private String aOR;
    private String aWP;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.o.c bff;
    private com.baidu.live.guardclub.a biY;
    private String biZ;
    private String bja;
    private String bjb;
    private boolean bjd;
    private View bwO;
    private int dVi;
    private String gXF;
    private boolean gXL;
    private View.OnClickListener gXN;
    private GuardClubInfoActivity gXQ;
    private View gXR;
    private View gXS;
    private View gXT;
    private String gXU;
    private View gXV;
    private TextView gXW;
    private int gXX;
    private int gXY;
    private View gXZ;
    private Button gYA;
    private LinearLayout gYa;
    private RelativeLayout gYb;
    private ImageView gYc;
    private ImageView gYd;
    private LinearLayout gYe;
    private GuardClubInfoHeaderView gYf;
    private RelativeLayout gYg;
    private RelativeLayout gYh;
    private TextView gYi;
    private LinearLayout gYj;
    private FrameLayout gYk;
    private RelativeLayout gYl;
    private ImageView gYm;
    private k gYn;
    private Bitmap gYo;
    private Bitmap gYp;
    private EditText gYq;
    private TextView gYr;
    private TextView gYs;
    private CommonEmptyView gYt;
    private TbImageView gYu;
    private LinearLayout gYv;
    private LinearLayout gYw;
    private com.baidu.live.an.a gYx;
    private final Dialog gYy;
    private final Button gYz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bMU = true;
    private boolean mIsKeyboardOpen = false;

    public f(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gXQ = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aWP = str;
        this.aJC = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bjd = z3;
        this.gXL = z4;
        this.gXF = str3;
        this.isTranslucent = z5;
        this.aOQ = str4;
        this.aOR = str5;
        this.gXN = onClickListener;
        if (!z3) {
            if (this.bff == null) {
                this.bff = new com.baidu.live.o.c();
            }
            this.bff.initListener();
            this.bff.refreshCurUserScores();
        }
        this.gXX = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gXY = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gXV = View.inflate(this.gXQ, a.g.dialog_guard_club_rename, null);
        this.gYy = new Dialog(this.gXQ, a.i.RegimentRenameDiolog);
        this.gYz = (Button) this.gXV.findViewById(a.f.rename_confirm);
        this.gYA = (Button) this.gXV.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gXQ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gXQ.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gXQ.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bMU) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.gYy.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.gYy.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gXQ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void FN() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.i.ae(this.mRootView);
                r.e(this.activity, false);
            } else {
                com.baidu.live.utils.i.af(this.mRootView);
                r.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.gYa != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gYa.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gYa.setLayoutParams(layoutParams);
        }
        if (this.gXS != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gXS.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gXS.setLayoutParams(layoutParams2);
        }
        if (this.gXR != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gXR.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.activity) == 1) {
                if (this.isFullScreen) {
                    layoutParams3.height = -1;
                } else {
                    layoutParams3.height = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds854);
                }
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams3.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gXX);
            } else {
                gradientDrawable.setColor(this.gXY);
            }
            this.gXR.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gYd != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gYd.setImageBitmap(this.gYp);
            } else {
                this.gYd.setImageBitmap(this.gYo);
            }
        }
        if (this.gYn != null) {
            this.gYn.FN();
        }
    }

    public final void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bSG();
        FN();
        this.gXZ.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dVi = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gXZ.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gYc.setVisibility(8);
                this.gYm.setVisibility(8);
            } else {
                this.gYc.setVisibility(0);
                this.gYm.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gYe.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gYc.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gYm.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gYd.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gXX);
        } else {
            this.gXZ.setVisibility(0);
            this.gYc.setVisibility(8);
            this.gYm.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gXR.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gXQ.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = (int) (this.dVi * 0.7d);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gXX);
            } else {
                gradientDrawable.setColor(this.gXY);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYw.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gYw.setLayoutParams(layoutParams2);
        }
        this.gXR.setBackgroundDrawable(gradientDrawable);
        if (this.aJC) {
            nm(false);
        } else {
            nm(this.bjd);
            this.gYf.hbE.setVisibility(8);
        }
        if (this.gXL) {
            this.gYf.hbC.setVisibility(8);
        }
        bn IV = com.baidu.live.guardclub.g.IT().IV();
        if (IV != null && IV.aPj > 0) {
            this.gYi.setText(IV.aPj + "T豆加入");
        } else {
            this.gYi.setText("1000T豆加入");
        }
        this.gYu.setOnClickListener(this);
        this.gYc.setOnClickListener(this);
        this.gYf.hbz.setOnClickListener(this);
        this.gYf.hbE.setOnClickListener(this);
        this.gYi.setOnClickListener(this);
        this.gYm.setOnClickListener(this);
        this.gYf.hbu.setOnClickListener(this);
        this.gYf.hbv.setOnClickListener(this);
        this.gYf.hbC.setOnClickListener(this);
        this.gYf.aDM.setOnClickListener(this);
        this.gYr.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gYf.hbr.setIsRound(true);
        this.gYf.hbr.setDrawBorder(false);
        this.gYf.hbr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gYf.hbr.setAutoChangeStyle(false);
        this.gYf.hbr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gYf.hbs.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aJC) {
            if (this.bjd) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aWP, str, this.otherParams);
        }
        this.gYq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bVv();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVv() {
        if (this.gYr != null) {
            if (TextUtils.isEmpty(this.gYq.getText())) {
                this.gYr.setEnabled(false);
                this.gYs.setText(String.valueOf(0));
            } else {
                this.gYr.setEnabled(true);
                this.gYs.setText(String.valueOf(this.gYq.getText().length()));
            }
        }
        if (this.gYq.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gYq.setText(this.gYq.getText().subSequence(0, 10));
            this.gYq.setSelection(this.gYq.getText().length());
        }
    }

    private void bSG() {
        this.gYa = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gXZ = this.mRootView.findViewById(a.f.space_view);
        this.gXR = this.mRootView.findViewById(a.f.layout_guard_info);
        this.bwO = this.mRootView.findViewById(a.f.info_layout);
        this.gYq = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gXS = this.mRootView.findViewById(a.f.input_name_layout);
        this.gXT = this.mRootView.findViewById(a.f.input_name);
        this.gYr = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gYs = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gYb = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gYc = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gYd = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gYe = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gYf = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gYg = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gYh = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gYi = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gYj = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gYk = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gYu = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.gYl = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gYt = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gYm = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gYv = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gYw = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void nm(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYd.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aJC) {
                this.gYd.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gXX);
                this.gYd.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aJC) {
            if (this.gYo == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gYo = com.baidu.live.utils.n.c(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gYo) {
                    decodeResource.recycle();
                }
            }
            if (this.gYp == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gYp = com.baidu.live.utils.n.c(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gYp) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gYd.setImageBitmap(this.gYp);
            } else {
                this.gYd.setImageBitmap(this.gYo);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gYd.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gYd.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gYf.getLayoutParams();
        if (z || this.aJC) {
            this.gYf.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gYh.setVisibility(8);
            this.gYw.setVisibility(0);
            this.gYi.setVisibility(8);
        } else {
            this.gYf.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gYh.setVisibility(0);
            this.gYw.setVisibility(8);
            this.gYi.setVisibility(0);
        }
        this.gYf.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String str2, String str3, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.biY = aVar;
        this.biZ = str;
        this.bja = str3;
        this.bjb = str2;
        if (aVar == null || aVar.id <= 0) {
            this.gYb.setVisibility(8);
            this.gYg.setVisibility(8);
            this.gYt.reset();
            this.gYt.setTitle(a.h.guard_club_no_create);
            this.gYt.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gYl.setVisibility(0);
            return;
        }
        this.gYb.setVisibility(0);
        this.gYg.setVisibility(0);
        this.gYl.setVisibility(8);
        nm(z);
        this.gYf.hbr.startLoad(aVar.biR, 12, false);
        this.gYf.hbs.startLoad(com.baidu.live.guardclub.g.IT().dr(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aJC && aVar.biT != null) {
            z2 = aVar.biT.optInt("can_update_name", 0) == 1;
        }
        if (this.gYf.gYM.getWidth() <= 0) {
            this.gYf.gYM.measure(0, 0);
            this.gYf.gYM.getMeasuredWidth();
        }
        String str4 = aVar.biL;
        if (z2) {
            this.gYf.hbt.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gYf.hbt.setVisibility(8);
        }
        this.gYf.aDM.setText(str4);
        String dt = com.baidu.live.guardclub.g.IT().dt(aVar.guardLevel);
        String str5 = (dt == null || "null".equals(dt)) ? "" : dt;
        Resources resources = this.gYf.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gYf.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.gYu.startLoad(str3, 10, false);
            this.gYu.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.gYu.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aJC) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYu.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.gYu.setLayoutParams(layoutParams2);
            this.gYf.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.biN;
            if (aVar.biQ > 0) {
                str6 = str6 + " / " + aVar.biQ;
            }
            this.gYf.hbw.setText(str6);
            this.gYf.hby.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.gYh.setVisibility(8);
            this.gYw.setVisibility(0);
            this.gYi.setVisibility(8);
            nn(this.gXL);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gYu.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.gYu.setLayoutParams(layoutParams3);
            this.gYf.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.biN;
            if (aVar.biQ > 0) {
                str7 = str7 + " / " + aVar.biQ;
            }
            this.gYf.hbw.setText(str7);
            this.gYf.hby.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.gYh.setVisibility(0);
            this.gYw.setVisibility(8);
            this.gYi.setVisibility(0);
            if (dVarArr != null) {
                this.gYj.setVisibility(0);
                this.gYv.removeAllViews();
                View view2 = null;
                int i2 = 0;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gYv.addView(view, layoutParams4);
                    } else {
                        view = view2;
                    }
                    if (view == null) {
                        break;
                    }
                    if (i2 % 4 == 0) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon1);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle1);
                    } else if (i2 % 4 == 1) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon2);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle2);
                    } else if (i2 % 4 == 2) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon3);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle3);
                    } else {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon4);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle4);
                    }
                    com.baidu.live.guardclub.d dVar = dVarArr[i2];
                    if (dVar != null) {
                        tbImageView.startLoad(dVar.bjm, 10, false);
                        textView.setText(dVar.bjn + "");
                    }
                    i2++;
                    view2 = view;
                }
            } else {
                this.gYj.setVisibility(8);
            }
        }
        this.gYf.setLayoutParams(layoutParams);
        if (aVar.biN == aVar.biQ) {
            i = 100;
        } else if (aVar.biN <= 0) {
            i = 0;
        } else if (aVar.biQ <= 0) {
            i = 100;
        } else if (aVar.biN >= aVar.biQ) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.biN * 100) / aVar.biQ);
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
        this.gYf.hbx.setProgress(i);
        this.gYf.hbB.setText(aVar.biP < 10000 ? aVar.biP + "" : String.format("%.1f", Float.valueOf(((float) aVar.biP) / 10000.0f)) + "万");
        String str8 = aVar.biS;
        this.gYf.gPr.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.biU == 0) {
            this.gYf.hbE.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.gYf.hbG.setAlpha(60);
            this.gYf.hbF.setTextColor(this.gXQ.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bVw() {
        this.gYb.setVisibility(8);
        this.gYg.setVisibility(8);
        this.gYt.reset();
        this.gYt.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gYt.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gXN != null) {
                    f.this.gXN.onClick(view);
                }
            }
        });
        this.gYt.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gYl.setVisibility(0);
    }

    public void nn(boolean z) {
        if (this.gYn == null) {
            this.gYn = new k(this.gXQ, this.liveId, this.roomId, this.anchorId, this.aWP, this.aJC, true, false, this.isFullScreen, this.otherParams, this.gXQ.getUniqueId(), null);
        }
        this.gYn.no(z);
        View view = this.gYn.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gYk.removeAllViews();
            this.gYk.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bff != null) {
            this.bff.onDestroy();
        }
        if (this.gYo != null) {
            this.gYo.recycle();
        }
        if (this.gYp != null) {
            this.gYp.recycle();
        }
        if (this.gYn != null) {
            this.gYn.onPageDestroy();
        }
        this.gXQ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.gYx != null) {
            this.gYx.release();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913290));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gXZ || view == this.gYc || view == this.gYm) {
            this.activity.finish();
        } else if (view == this.gYf.hbv || view == this.gYf.hbu) {
            if (!TextUtils.isEmpty(this.biZ)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.biZ);
            }
            if (!this.aJC) {
                if (this.bjd) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aWP, str, this.otherParams);
            }
        } else if (view == this.gYf.hbz) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aJC, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aWP);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gYf.hbC || view == this.gYu) {
            if (Build.VERSION.SDK_INT != 26) {
                this.activity.setRequestedOrientation(1);
                this.gXQ.setRequestedOrientation(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913287));
            if (this.gYx == null) {
                this.gYx = new com.baidu.live.an.a(this.activity);
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aJC, EncryptionHelper.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", HttpConstants.OS_TYPE_VALUE);
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bjb, a2);
            cVar.isFullScreen = true;
            this.gYx.a(cVar);
        } else if (view == this.gYi) {
            if (this.biY != null) {
                bn IV = com.baidu.live.guardclub.g.IT().IV();
                if (IV == null || IV.aPj <= 0) {
                    j = 1000;
                } else {
                    j = IV.aPj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    ux(this.biY.id);
                } else if (this.gXL) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.biY));
                    this.activity.finish();
                }
            }
            if (!this.aJC) {
                if (TextUtils.isEmpty(this.gXF)) {
                    this.gXF = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aWP, this.gXF, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gYq.clearFocus();
                this.gYq.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gXQ.getActivity(), this.gYq);
                return;
            }
            this.activity.finish();
        } else if (view == this.gYr) {
            String obj = this.gYq.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.biY.id, obj, "");
            }
        } else if (view == this.gYf.hbt) {
            this.gYq.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gXQ.getActivity(), this.gYq);
        } else if (view == this.gYf.hbE) {
            if (this.biY != null && this.biY.biU == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.biY != null && this.biY.biU == 1) {
                bVx();
            }
        }
    }

    public void GQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gYf.aDM.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.gYq.setText("");
            this.gYq.clearFocus();
            this.gYy.dismiss();
            this.gYf.hbE.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gXQ.getActivity(), this.gYq);
        }
    }

    public void ux(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dp(i);
        cVar.a(this.biY);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.fq(i);
        cVar.GR(str);
        cVar.GS(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVx() {
        this.gXW = (TextView) this.gXV.findViewById(a.f.rename_club_name);
        this.gYz.setEnabled(false);
        this.gYz.setTextColor(this.gXQ.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gXV.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gXV.findViewById(a.f.hint_num);
        this.gYA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gXU = null;
                f.this.gYy.dismiss();
            }
        });
        this.gYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gXU = editText.getText().toString();
                }
                if (f.this.gXU != null && f.this.biY != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gXQ, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.biY.id, f.this.gXU, "");
                    }
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String obj = editText.getText().toString();
                if (obj.length() == 0) {
                    textView.setTextColor(f.this.gXQ.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gYz.setTextColor(f.this.gXQ.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gYz.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.gYz.setEnabled(true);
                    f.this.gYz.setTextColor(f.this.gXQ.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gXQ, "仅支持中英文及数字");
                            editText.setText(editText.getText().subSequence(0, i6));
                            editText.setSelection(editText.getText().length());
                            textView.setText((i4 + i5) + "");
                            return;
                        }
                        if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                            i5++;
                        }
                        if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                            i5++;
                        }
                        if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            i4++;
                        }
                        if (i5 + i4 > 3) {
                            BdUtilHelper.showToast(f.this.gXQ, "不能超过3个字符");
                            editText.setText(editText.getText().subSequence(0, (i4 + i5) - 1));
                            editText.setSelection(editText.getText().length());
                            if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                                i5--;
                            }
                            if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                                i5--;
                            }
                            if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                i4--;
                            }
                            textView.setText((i4 + i5) + "");
                            return;
                        }
                        int i7 = i4 + i5;
                        textView.setText(i7 + "");
                        if (i7 == 3) {
                            textView.setTextColor(f.this.gXQ.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gXQ.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gYy.setContentView(this.gXV);
        this.gYy.setCanceledOnTouchOutside(true);
        this.gXV.setMinimumHeight((int) (o.getScreenHeight(this.gXQ) * 0.24f));
        Window window = this.gYy.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gXQ) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.gYy.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gXQ, editText);
            }
        }, 100L);
    }
}
