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
    private String gXT;
    private boolean gXZ;
    private ImageView gYA;
    private k gYB;
    private Bitmap gYC;
    private Bitmap gYD;
    private EditText gYE;
    private TextView gYF;
    private TextView gYG;
    private CommonEmptyView gYH;
    private TbImageView gYI;
    private LinearLayout gYJ;
    private LinearLayout gYK;
    private com.baidu.live.an.a gYL;
    private final Dialog gYM;
    private final Button gYN;
    private Button gYO;
    private View.OnClickListener gYb;
    private GuardClubInfoActivity gYe;
    private View gYf;
    private View gYg;
    private View gYh;
    private String gYi;
    private View gYj;
    private TextView gYk;
    private int gYl;
    private int gYm;
    private View gYn;
    private LinearLayout gYo;
    private RelativeLayout gYp;
    private ImageView gYq;
    private ImageView gYr;
    private LinearLayout gYs;
    private GuardClubInfoHeaderView gYt;
    private RelativeLayout gYu;
    private RelativeLayout gYv;
    private TextView gYw;
    private LinearLayout gYx;
    private FrameLayout gYy;
    private RelativeLayout gYz;
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
        this.gYe = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aWP = str;
        this.aJC = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bjd = z3;
        this.gXZ = z4;
        this.gXT = str3;
        this.isTranslucent = z5;
        this.aOQ = str4;
        this.aOR = str5;
        this.gYb = onClickListener;
        if (!z3) {
            if (this.bff == null) {
                this.bff = new com.baidu.live.o.c();
            }
            this.bff.initListener();
            this.bff.refreshCurUserScores();
        }
        this.gYl = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gYm = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gYj = View.inflate(this.gYe, a.g.dialog_guard_club_rename, null);
        this.gYM = new Dialog(this.gYe, a.i.RegimentRenameDiolog);
        this.gYN = (Button) this.gYj.findViewById(a.f.rename_confirm);
        this.gYO = (Button) this.gYj.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gYe.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gYe.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gYe.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bMU) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.gYM.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.gYM.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gYe.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
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
        if (this.gYo != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gYo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gYo.setLayoutParams(layoutParams);
        }
        if (this.gYg != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gYg.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gYg.setLayoutParams(layoutParams2);
        }
        if (this.gYf != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gYf.getLayoutParams();
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
                gradientDrawable.setColor(this.gYl);
            } else {
                gradientDrawable.setColor(this.gYm);
            }
            this.gYf.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gYr != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gYr.setImageBitmap(this.gYD);
            } else {
                this.gYr.setImageBitmap(this.gYC);
            }
        }
        if (this.gYB != null) {
            this.gYB.FN();
        }
    }

    public final void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bSN();
        FN();
        this.gYn.setOnClickListener(this);
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
            this.gYn.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gYq.setVisibility(8);
                this.gYA.setVisibility(8);
            } else {
                this.gYq.setVisibility(0);
                this.gYA.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gYs.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gYq.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gYA.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gYr.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gYl);
        } else {
            this.gYn.setVisibility(0);
            this.gYq.setVisibility(8);
            this.gYA.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gYf.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gYe.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = (int) (this.dVi * 0.7d);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gYl);
            } else {
                gradientDrawable.setColor(this.gYm);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYK.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gYK.setLayoutParams(layoutParams2);
        }
        this.gYf.setBackgroundDrawable(gradientDrawable);
        if (this.aJC) {
            nm(false);
        } else {
            nm(this.bjd);
            this.gYt.hbS.setVisibility(8);
        }
        if (this.gXZ) {
            this.gYt.hbQ.setVisibility(8);
        }
        bn IV = com.baidu.live.guardclub.g.IT().IV();
        if (IV != null && IV.aPj > 0) {
            this.gYw.setText(IV.aPj + "T豆加入");
        } else {
            this.gYw.setText("1000T豆加入");
        }
        this.gYI.setOnClickListener(this);
        this.gYq.setOnClickListener(this);
        this.gYt.hbN.setOnClickListener(this);
        this.gYt.hbS.setOnClickListener(this);
        this.gYw.setOnClickListener(this);
        this.gYA.setOnClickListener(this);
        this.gYt.hbI.setOnClickListener(this);
        this.gYt.hbJ.setOnClickListener(this);
        this.gYt.hbQ.setOnClickListener(this);
        this.gYt.aDM.setOnClickListener(this);
        this.gYF.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gYt.hbF.setIsRound(true);
        this.gYt.hbF.setDrawBorder(false);
        this.gYt.hbF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gYt.hbF.setAutoChangeStyle(false);
        this.gYt.hbF.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gYt.hbG.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aJC) {
            if (this.bjd) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aWP, str, this.otherParams);
        }
        this.gYE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bVC();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVC() {
        if (this.gYF != null) {
            if (TextUtils.isEmpty(this.gYE.getText())) {
                this.gYF.setEnabled(false);
                this.gYG.setText(String.valueOf(0));
            } else {
                this.gYF.setEnabled(true);
                this.gYG.setText(String.valueOf(this.gYE.getText().length()));
            }
        }
        if (this.gYE.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gYE.setText(this.gYE.getText().subSequence(0, 10));
            this.gYE.setSelection(this.gYE.getText().length());
        }
    }

    private void bSN() {
        this.gYo = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gYn = this.mRootView.findViewById(a.f.space_view);
        this.gYf = this.mRootView.findViewById(a.f.layout_guard_info);
        this.bwO = this.mRootView.findViewById(a.f.info_layout);
        this.gYE = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gYg = this.mRootView.findViewById(a.f.input_name_layout);
        this.gYh = this.mRootView.findViewById(a.f.input_name);
        this.gYF = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gYG = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gYp = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gYq = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gYr = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gYs = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gYt = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gYu = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gYv = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gYw = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gYx = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gYy = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gYI = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.gYz = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gYH = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gYA = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gYJ = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gYK = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void nm(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYr.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aJC) {
                this.gYr.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gYl);
                this.gYr.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aJC) {
            if (this.gYC == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gYC = com.baidu.live.utils.n.c(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gYC) {
                    decodeResource.recycle();
                }
            }
            if (this.gYD == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gYD = com.baidu.live.utils.n.c(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gYD) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gYr.setImageBitmap(this.gYD);
            } else {
                this.gYr.setImageBitmap(this.gYC);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gYr.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gYr.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gYt.getLayoutParams();
        if (z || this.aJC) {
            this.gYt.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gYv.setVisibility(8);
            this.gYK.setVisibility(0);
            this.gYw.setVisibility(8);
        } else {
            this.gYt.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gYv.setVisibility(0);
            this.gYK.setVisibility(8);
            this.gYw.setVisibility(0);
        }
        this.gYt.setLayoutParams(layoutParams2);
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
            this.gYp.setVisibility(8);
            this.gYu.setVisibility(8);
            this.gYH.reset();
            this.gYH.setTitle(a.h.guard_club_no_create);
            this.gYH.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gYz.setVisibility(0);
            return;
        }
        this.gYp.setVisibility(0);
        this.gYu.setVisibility(0);
        this.gYz.setVisibility(8);
        nm(z);
        this.gYt.hbF.startLoad(aVar.biR, 12, false);
        this.gYt.hbG.startLoad(com.baidu.live.guardclub.g.IT().dr(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aJC && aVar.biT != null) {
            z2 = aVar.biT.optInt("can_update_name", 0) == 1;
        }
        if (this.gYt.gZa.getWidth() <= 0) {
            this.gYt.gZa.measure(0, 0);
            this.gYt.gZa.getMeasuredWidth();
        }
        String str4 = aVar.biL;
        if (z2) {
            this.gYt.hbH.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gYt.hbH.setVisibility(8);
        }
        this.gYt.aDM.setText(str4);
        String dt = com.baidu.live.guardclub.g.IT().dt(aVar.guardLevel);
        String str5 = (dt == null || "null".equals(dt)) ? "" : dt;
        Resources resources = this.gYt.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gYt.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.gYI.startLoad(str3, 10, false);
            this.gYI.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.gYI.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aJC) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gYI.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.gYI.setLayoutParams(layoutParams2);
            this.gYt.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.biN;
            if (aVar.biQ > 0) {
                str6 = str6 + " / " + aVar.biQ;
            }
            this.gYt.hbK.setText(str6);
            this.gYt.hbM.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.gYv.setVisibility(8);
            this.gYK.setVisibility(0);
            this.gYw.setVisibility(8);
            nn(this.gXZ);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gYI.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.gYI.setLayoutParams(layoutParams3);
            this.gYt.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.biN;
            if (aVar.biQ > 0) {
                str7 = str7 + " / " + aVar.biQ;
            }
            this.gYt.hbK.setText(str7);
            this.gYt.hbM.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.gYv.setVisibility(0);
            this.gYK.setVisibility(8);
            this.gYw.setVisibility(0);
            if (dVarArr != null) {
                this.gYx.setVisibility(0);
                this.gYJ.removeAllViews();
                View view2 = null;
                int i2 = 0;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gYJ.addView(view, layoutParams4);
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
                this.gYx.setVisibility(8);
            }
        }
        this.gYt.setLayoutParams(layoutParams);
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
        this.gYt.hbL.setProgress(i);
        this.gYt.hbP.setText(aVar.biP < 10000 ? aVar.biP + "" : String.format("%.1f", Float.valueOf(((float) aVar.biP) / 10000.0f)) + "万");
        String str8 = aVar.biS;
        this.gYt.gPF.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.biU == 0) {
            this.gYt.hbS.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.gYt.hbU.setAlpha(60);
            this.gYt.hbT.setTextColor(this.gYe.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bVD() {
        this.gYp.setVisibility(8);
        this.gYu.setVisibility(8);
        this.gYH.reset();
        this.gYH.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gYH.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gYb != null) {
                    f.this.gYb.onClick(view);
                }
            }
        });
        this.gYH.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gYz.setVisibility(0);
    }

    public void nn(boolean z) {
        if (this.gYB == null) {
            this.gYB = new k(this.gYe, this.liveId, this.roomId, this.anchorId, this.aWP, this.aJC, true, false, this.isFullScreen, this.otherParams, this.gYe.getUniqueId(), null);
        }
        this.gYB.no(z);
        View view = this.gYB.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gYy.removeAllViews();
            this.gYy.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bff != null) {
            this.bff.onDestroy();
        }
        if (this.gYC != null) {
            this.gYC.recycle();
        }
        if (this.gYD != null) {
            this.gYD.recycle();
        }
        if (this.gYB != null) {
            this.gYB.onPageDestroy();
        }
        this.gYe.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.gYL != null) {
            this.gYL.release();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913290));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gYn || view == this.gYq || view == this.gYA) {
            this.activity.finish();
        } else if (view == this.gYt.hbJ || view == this.gYt.hbI) {
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
        } else if (view == this.gYt.hbN) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aJC, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aWP);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gYt.hbQ || view == this.gYI) {
            if (Build.VERSION.SDK_INT != 26) {
                this.activity.setRequestedOrientation(1);
                this.gYe.setRequestedOrientation(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913287));
            if (this.gYL == null) {
                this.gYL = new com.baidu.live.an.a(this.activity);
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aJC, EncryptionHelper.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", HttpConstants.OS_TYPE_VALUE);
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bjb, a2);
            cVar.isFullScreen = true;
            this.gYL.a(cVar);
        } else if (view == this.gYw) {
            if (this.biY != null) {
                bn IV = com.baidu.live.guardclub.g.IT().IV();
                if (IV == null || IV.aPj <= 0) {
                    j = 1000;
                } else {
                    j = IV.aPj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    ux(this.biY.id);
                } else if (this.gXZ) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.biY));
                    this.activity.finish();
                }
            }
            if (!this.aJC) {
                if (TextUtils.isEmpty(this.gXT)) {
                    this.gXT = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aWP, this.gXT, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gYE.clearFocus();
                this.gYE.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gYe.getActivity(), this.gYE);
                return;
            }
            this.activity.finish();
        } else if (view == this.gYF) {
            String obj = this.gYE.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.biY.id, obj, "");
            }
        } else if (view == this.gYt.hbH) {
            this.gYE.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gYe.getActivity(), this.gYE);
        } else if (view == this.gYt.hbS) {
            if (this.biY != null && this.biY.biU == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.biY != null && this.biY.biU == 1) {
                bVE();
            }
        }
    }

    public void GR(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gYt.aDM.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.gYE.setText("");
            this.gYE.clearFocus();
            this.gYM.dismiss();
            this.gYt.hbS.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gYe.getActivity(), this.gYE);
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
        cVar.GS(str);
        cVar.GT(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVE() {
        this.gYk = (TextView) this.gYj.findViewById(a.f.rename_club_name);
        this.gYN.setEnabled(false);
        this.gYN.setTextColor(this.gYe.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gYj.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gYj.findViewById(a.f.hint_num);
        this.gYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gYi = null;
                f.this.gYM.dismiss();
            }
        });
        this.gYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gYi = editText.getText().toString();
                }
                if (f.this.gYi != null && f.this.biY != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gYe, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.biY.id, f.this.gYi, "");
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
                    textView.setTextColor(f.this.gYe.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gYN.setTextColor(f.this.gYe.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gYN.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.gYN.setEnabled(true);
                    f.this.gYN.setTextColor(f.this.gYe.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gYe, "仅支持中英文及数字");
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
                            BdUtilHelper.showToast(f.this.gYe, "不能超过3个字符");
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
                            textView.setTextColor(f.this.gYe.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gYe.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gYM.setContentView(this.gYj);
        this.gYM.setCanceledOnTouchOutside(true);
        this.gYj.setMinimumHeight((int) (o.getScreenHeight(this.gYe) * 0.24f));
        Window window = this.gYM.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gYe) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.gYM.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gYe, editText);
            }
        }, 100L);
    }
}
