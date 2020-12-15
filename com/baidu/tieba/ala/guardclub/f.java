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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bg;
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
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private boolean aLj;
    private String aPR;
    private String aPS;
    private String aWR;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.o.c bff;
    private com.baidu.live.guardclub.a bja;
    private String bjb;
    private String bjc;
    private String bjd;
    private boolean bjf;
    private View btl;
    private int dOW;
    private String gNO;
    private boolean gNU;
    private View.OnClickListener gNW;
    private GuardClubInfoActivity gNZ;
    private TextView gOA;
    private TextView gOB;
    private CommonEmptyView gOC;
    private TbImageView gOD;
    private LinearLayout gOE;
    private LinearLayout gOF;
    private com.baidu.live.ao.a gOG;
    private final Dialog gOH;
    private final Button gOI;
    private Button gOJ;
    private View gOa;
    private View gOb;
    private View gOc;
    private String gOd;
    private View gOe;
    private TextView gOf;
    private int gOg;
    private int gOh;
    private View gOi;
    private LinearLayout gOj;
    private RelativeLayout gOk;
    private ImageView gOl;
    private ImageView gOm;
    private LinearLayout gOn;
    private GuardClubInfoHeaderView gOo;
    private RelativeLayout gOp;
    private RelativeLayout gOq;
    private TextView gOr;
    private LinearLayout gOs;
    private FrameLayout gOt;
    private RelativeLayout gOu;
    private ImageView gOv;
    private k gOw;
    private Bitmap gOx;
    private Bitmap gOy;
    private EditText gOz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bJi = true;
    private boolean mIsKeyboardOpen = false;

    public f(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gNZ = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aWR = str;
        this.aLj = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bjf = z3;
        this.gNU = z4;
        this.gNO = str3;
        this.isTranslucent = z5;
        this.aPR = str4;
        this.aPS = str5;
        this.gNW = onClickListener;
        if (!z3) {
            if (this.bff == null) {
                this.bff = new com.baidu.live.o.c();
            }
            this.bff.initListener();
            this.bff.refreshCurUserScores();
        }
        this.gOg = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gOh = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gOe = View.inflate(this.gNZ, a.g.dialog_guard_club_rename, null);
        this.gOH = new Dialog(this.gNZ, a.i.RegimentRenameDiolog);
        this.gOI = (Button) this.gOe.findViewById(a.f.rename_confirm);
        this.gOJ = (Button) this.gOe.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gNZ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gNZ.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gNZ.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bJi) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.gOH.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.gOH.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gNZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void IR() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.i.ae(this.mRootView);
                q.e(this.activity, false);
            } else {
                com.baidu.live.utils.i.af(this.mRootView);
                q.e(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.gOj != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gOj.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gOj.setLayoutParams(layoutParams);
        }
        if (this.gOb != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gOb.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gOb.setLayoutParams(layoutParams2);
        }
        if (this.gOa != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gOa.getLayoutParams();
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
                gradientDrawable.setColor(this.gOg);
            } else {
                gradientDrawable.setColor(this.gOh);
            }
            this.gOa.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gOm != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gOm.setImageBitmap(this.gOy);
            } else {
                this.gOm.setImageBitmap(this.gOx);
            }
        }
        if (this.gOw != null) {
            this.gOw.IR();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bTp();
        IR();
        this.gOi.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dOW = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gOi.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gOl.setVisibility(8);
                this.gOv.setVisibility(8);
            } else {
                this.gOl.setVisibility(0);
                this.gOv.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gOn.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gOl.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gOv.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gOm.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gOg);
        } else {
            this.gOi.setVisibility(0);
            this.gOl.setVisibility(8);
            this.gOv.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gOa.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gNZ.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds1160);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gOg);
            } else {
                gradientDrawable.setColor(this.gOh);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gOF.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gOF.setLayoutParams(layoutParams2);
        }
        this.gOa.setBackgroundDrawable(gradientDrawable);
        if (this.aLj) {
            mL(false);
        } else {
            mL(this.bjf);
            this.gOo.gRN.setVisibility(8);
        }
        if (this.gNU) {
            this.gOo.gRL.setVisibility(8);
        }
        bg Mb = com.baidu.live.guardclub.g.LZ().Mb();
        if (Mb != null && Mb.aQj > 0) {
            this.gOr.setText(Mb.aQj + "T豆加入");
        } else {
            this.gOr.setText("1000T豆加入");
        }
        this.gOD.setOnClickListener(this);
        this.gOl.setOnClickListener(this);
        this.gOo.gRI.setOnClickListener(this);
        this.gOo.gRN.setOnClickListener(this);
        this.gOr.setOnClickListener(this);
        this.gOv.setOnClickListener(this);
        this.gOo.gRD.setOnClickListener(this);
        this.gOo.gRE.setOnClickListener(this);
        this.gOo.gRL.setOnClickListener(this);
        this.gOo.aGv.setOnClickListener(this);
        this.gOA.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gOo.gRA.setIsRound(true);
        this.gOo.gRA.setDrawBorder(false);
        this.gOo.gRA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gOo.gRA.setAutoChangeStyle(false);
        this.gOo.gRA.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gOo.gRB.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aLj) {
            if (this.bjf) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aWR, str, this.otherParams);
        }
        this.gOz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bWc();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWc() {
        if (this.gOA != null) {
            if (TextUtils.isEmpty(this.gOz.getText())) {
                this.gOA.setEnabled(false);
                this.gOB.setText(String.valueOf(0));
            } else {
                this.gOA.setEnabled(true);
                this.gOB.setText(String.valueOf(this.gOz.getText().length()));
            }
        }
        if (this.gOz.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gOz.setText(this.gOz.getText().subSequence(0, 10));
            this.gOz.setSelection(this.gOz.getText().length());
        }
    }

    private void bTp() {
        this.gOj = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gOi = this.mRootView.findViewById(a.f.space_view);
        this.gOa = this.mRootView.findViewById(a.f.layout_guard_info);
        this.btl = this.mRootView.findViewById(a.f.info_layout);
        this.gOz = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gOb = this.mRootView.findViewById(a.f.input_name_layout);
        this.gOc = this.mRootView.findViewById(a.f.input_name);
        this.gOA = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gOB = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gOk = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gOl = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gOm = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gOn = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gOo = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gOp = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gOq = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gOr = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gOs = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gOt = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gOD = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.gOu = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gOC = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gOv = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gOE = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gOF = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void mL(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gOm.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aLj) {
                this.gOm.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gOg);
                this.gOm.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aLj) {
            if (this.gOx == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gOx = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gOx) {
                    decodeResource.recycle();
                }
            }
            if (this.gOy == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gOy = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gOy) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gOm.setImageBitmap(this.gOy);
            } else {
                this.gOm.setImageBitmap(this.gOx);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gOm.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gOm.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gOo.getLayoutParams();
        if (z || this.aLj) {
            this.gOo.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gOq.setVisibility(8);
            this.gOF.setVisibility(0);
            this.gOr.setVisibility(8);
        } else {
            this.gOo.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gOq.setVisibility(0);
            this.gOF.setVisibility(8);
            this.gOr.setVisibility(0);
        }
        this.gOo.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String str2, String str3, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bja = aVar;
        this.bjb = str;
        this.bjc = str3;
        this.bjd = str2;
        if (aVar == null || aVar.id <= 0) {
            this.gOk.setVisibility(8);
            this.gOp.setVisibility(8);
            this.gOC.reset();
            this.gOC.setTitle(a.h.guard_club_no_create);
            this.gOC.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gOu.setVisibility(0);
            return;
        }
        this.gOk.setVisibility(0);
        this.gOp.setVisibility(0);
        this.gOu.setVisibility(8);
        mL(z);
        this.gOo.gRA.startLoad(aVar.biT, 12, false);
        this.gOo.gRB.startLoad(com.baidu.live.guardclub.g.LZ().eU(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aLj && aVar.biV != null) {
            z2 = aVar.biV.optInt("can_update_name", 0) == 1;
        }
        if (this.gOo.gOV.getWidth() <= 0) {
            this.gOo.gOV.measure(0, 0);
            this.gOo.gOV.getMeasuredWidth();
        }
        String str4 = aVar.biN;
        if (z2) {
            this.gOo.gRC.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gOo.gRC.setVisibility(8);
        }
        this.gOo.aGv.setText(str4);
        String eW = com.baidu.live.guardclub.g.LZ().eW(aVar.guardLevel);
        String str5 = (eW == null || "null".equals(eW)) ? "" : eW;
        Resources resources = this.gOo.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gOo.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.gOD.startLoad(str3, 10, false);
            this.gOD.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.gOD.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aLj) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gOD.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.gOD.setLayoutParams(layoutParams2);
            this.gOo.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.biP;
            if (aVar.biS > 0) {
                str6 = str6 + " / " + aVar.biS;
            }
            this.gOo.gRF.setText(str6);
            this.gOo.gRH.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.gOq.setVisibility(8);
            this.gOF.setVisibility(0);
            this.gOr.setVisibility(8);
            mM(this.gNU);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gOD.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.gOD.setLayoutParams(layoutParams3);
            this.gOo.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.biP;
            if (aVar.biS > 0) {
                str7 = str7 + " / " + aVar.biS;
            }
            this.gOo.gRF.setText(str7);
            this.gOo.gRH.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.gOq.setVisibility(0);
            this.gOF.setVisibility(8);
            this.gOr.setVisibility(0);
            if (dVarArr != null) {
                this.gOs.setVisibility(0);
                this.gOE.removeAllViews();
                int i2 = 0;
                View view2 = null;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gOE.addView(view, layoutParams4);
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
                        tbImageView.startLoad(dVar.bjo, 10, false);
                        textView.setText(dVar.bjp + "");
                    }
                    i2++;
                    view2 = view;
                }
            } else {
                this.gOs.setVisibility(8);
            }
        }
        this.gOo.setLayoutParams(layoutParams);
        if (aVar.biP == aVar.biS) {
            i = 100;
        } else if (aVar.biP <= 0) {
            i = 0;
        } else if (aVar.biS <= 0) {
            i = 100;
        } else if (aVar.biP >= aVar.biS) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.biP * 100) / aVar.biS);
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
        this.gOo.gRG.setProgress(i);
        this.gOo.gRK.setText(aVar.biR < 10000 ? aVar.biR + "" : String.format("%.1f", Float.valueOf(((float) aVar.biR) / 10000.0f)) + "万");
        String str8 = aVar.biU;
        this.gOo.gFG.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.biW == 0) {
            this.gOo.gRN.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.gOo.gRP.setAlpha(60);
            this.gOo.gRO.setTextColor(this.gNZ.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bWd() {
        this.gOk.setVisibility(8);
        this.gOp.setVisibility(8);
        this.gOC.reset();
        this.gOC.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gOC.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gNW != null) {
                    f.this.gNW.onClick(view);
                }
            }
        });
        this.gOC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gOu.setVisibility(0);
    }

    public void mM(boolean z) {
        if (this.gOw == null) {
            this.gOw = new k(this.gNZ, this.liveId, this.roomId, this.anchorId, this.aWR, this.aLj, true, false, this.isFullScreen, this.otherParams, this.gNZ.getUniqueId(), null);
        }
        this.gOw.mN(z);
        View view = this.gOw.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gOt.removeAllViews();
            this.gOt.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bff != null) {
            this.bff.onDestroy();
        }
        if (this.gOx != null) {
            this.gOx.recycle();
        }
        if (this.gOy != null) {
            this.gOy.recycle();
        }
        if (this.gOw != null) {
            this.gOw.baD();
        }
        this.gNZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gOi || view == this.gOl || view == this.gOv) {
            this.activity.finish();
        } else if (view == this.gOo.gRE || view == this.gOo.gRD) {
            if (!TextUtils.isEmpty(this.bjb)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bjb);
            }
            if (!this.aLj) {
                if (this.bjf) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aWR, str, this.otherParams);
            }
        } else if (view == this.gOo.gRI) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aLj, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aWR);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gOo.gRL || view == this.gOD) {
            this.gOG = new com.baidu.live.ao.a(this.activity);
            com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aLj, String.valueOf(TbadkCoreApplication.getCurrentAccountId()), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", "android");
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bjd, a2);
            cVar.isFullScreen = true;
            this.gOG.a(cVar);
        } else if (view == this.gOr) {
            if (this.bja != null) {
                bg Mb = com.baidu.live.guardclub.g.LZ().Mb();
                if (Mb == null || Mb.aQj <= 0) {
                    j = 1000;
                } else {
                    j = Mb.aQj;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    vM(this.bja.id);
                } else if (this.gNU) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bja));
                    this.activity.finish();
                }
            }
            if (!this.aLj) {
                if (TextUtils.isEmpty(this.gNO)) {
                    this.gNO = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aWR, this.gNO, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gOz.clearFocus();
                this.gOz.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gNZ.getActivity(), this.gOz);
                return;
            }
            this.activity.finish();
        } else if (view == this.gOA) {
            String obj = this.gOz.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.bja.id, obj, "");
            }
        } else if (view == this.gOo.gRC) {
            this.gOz.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gNZ.getActivity(), this.gOz);
        } else if (view == this.gOo.gRN) {
            if (this.bja != null && this.bja.biW == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.bja != null && this.bja.biW == 1) {
                bWe();
            }
        } else if (view == this.gOo.aGv && this.bja != null && this.bja.biW == 0 && this.aLj) {
            this.gOo.aGv.setTextColor(this.gNZ.getPageContext().getResources().getColor(a.c.sdk_white_alpha50));
            UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
        }
    }

    public void HD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gOo.aGv.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.gOz.setText("");
            this.gOz.clearFocus();
            this.gOH.dismiss();
            this.gOo.gRN.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gNZ.getActivity(), this.gOz);
        }
    }

    public void vM(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eS(i);
        cVar.a(this.bja);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.fk(i);
        cVar.HE(str);
        cVar.HF(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bWe() {
        this.gOf = (TextView) this.gOe.findViewById(a.f.rename_club_name);
        this.gOI.setEnabled(false);
        this.gOI.setTextColor(this.gNZ.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gOe.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gOe.findViewById(a.f.hint_num);
        this.gOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gOd = null;
                f.this.gOH.dismiss();
            }
        });
        this.gOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gOd = editText.getText().toString();
                }
                if (f.this.gOd != null && f.this.bja != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gNZ, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.bja.id, f.this.gOd, "");
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
                    textView.setTextColor(f.this.gNZ.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gOI.setTextColor(f.this.gNZ.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gOI.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.gOI.setEnabled(true);
                    f.this.gOI.setTextColor(f.this.gNZ.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gNZ, "仅支持中英文及数字");
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
                            BdUtilHelper.showToast(f.this.gNZ, "不能超过3个字符");
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
                            textView.setTextColor(f.this.gNZ.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gNZ.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gOH.setContentView(this.gOe);
        this.gOH.setCanceledOnTouchOutside(true);
        this.gOe.setMinimumHeight((int) (o.getScreenHeight(this.gNZ) * 0.24f));
        Window window = this.gOH.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gNZ) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.gOH.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gNZ, editText);
            }
        }, 100L);
    }
}
