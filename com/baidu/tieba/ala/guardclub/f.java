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
import com.baidu.live.data.bi;
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
/* loaded from: classes10.dex */
public class f implements View.OnClickListener {
    private boolean aGY;
    private String aLT;
    private String aLU;
    private String aTK;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.p.c bbX;
    private com.baidu.live.guardclub.a bfP;
    private String bfQ;
    private String bfR;
    private String bfS;
    private boolean bfU;
    private View btk;
    private int dTc;
    private String gUV;
    private FrameLayout gVA;
    private RelativeLayout gVB;
    private ImageView gVC;
    private k gVD;
    private Bitmap gVE;
    private Bitmap gVF;
    private EditText gVG;
    private TextView gVH;
    private TextView gVI;
    private CommonEmptyView gVJ;
    private TbImageView gVK;
    private LinearLayout gVL;
    private LinearLayout gVM;
    private com.baidu.live.ap.a gVN;
    private final Dialog gVO;
    private final Button gVP;
    private Button gVQ;
    private boolean gVb;
    private View.OnClickListener gVd;
    private GuardClubInfoActivity gVg;
    private View gVh;
    private View gVi;
    private View gVj;
    private String gVk;
    private View gVl;
    private TextView gVm;
    private int gVn;
    private int gVo;
    private View gVp;
    private LinearLayout gVq;
    private RelativeLayout gVr;
    private ImageView gVs;
    private ImageView gVt;
    private LinearLayout gVu;
    private GuardClubInfoHeaderView gVv;
    private RelativeLayout gVw;
    private RelativeLayout gVx;
    private TextView gVy;
    private LinearLayout gVz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bJk = true;
    private boolean mIsKeyboardOpen = false;

    public f(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gVg = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aTK = str;
        this.aGY = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bfU = z3;
        this.gVb = z4;
        this.gUV = str3;
        this.isTranslucent = z5;
        this.aLT = str4;
        this.aLU = str5;
        this.gVd = onClickListener;
        if (!z3) {
            if (this.bbX == null) {
                this.bbX = new com.baidu.live.p.c();
            }
            this.bbX.initListener();
            this.bbX.refreshCurUserScores();
        }
        this.gVn = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gVo = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gVl = View.inflate(this.gVg, a.g.dialog_guard_club_rename, null);
        this.gVO = new Dialog(this.gVg, a.i.RegimentRenameDiolog);
        this.gVP = (Button) this.gVl.findViewById(a.f.rename_confirm);
        this.gVQ = (Button) this.gVl.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gVg.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gVg.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gVg.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bJk) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.gVO.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.gVO.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gVg.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void Ex() {
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
        if (this.gVq != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gVq.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gVq.setLayoutParams(layoutParams);
        }
        if (this.gVi != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gVi.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gVi.setLayoutParams(layoutParams2);
        }
        if (this.gVh != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gVh.getLayoutParams();
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
                gradientDrawable.setColor(this.gVn);
            } else {
                gradientDrawable.setColor(this.gVo);
            }
            this.gVh.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gVt != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gVt.setImageBitmap(this.gVF);
            } else {
                this.gVt.setImageBitmap(this.gVE);
            }
        }
        if (this.gVD != null) {
            this.gVD.Ex();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bSd();
        Ex();
        this.gVp.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dTc = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gVp.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gVs.setVisibility(8);
                this.gVC.setVisibility(8);
            } else {
                this.gVs.setVisibility(0);
                this.gVC.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gVu.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gVs.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gVC.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gVt.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gVn);
        } else {
            this.gVp.setVisibility(0);
            this.gVs.setVisibility(8);
            this.gVC.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gVh.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gVg.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = (int) (this.dTc * 0.7d);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gVn);
            } else {
                gradientDrawable.setColor(this.gVo);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVM.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gVM.setLayoutParams(layoutParams2);
        }
        this.gVh.setBackgroundDrawable(gradientDrawable);
        if (this.aGY) {
            nh(false);
        } else {
            nh(this.bfU);
            this.gVv.gYU.setVisibility(8);
        }
        if (this.gVb) {
            this.gVv.gYS.setVisibility(8);
        }
        bi HF = com.baidu.live.guardclub.g.HD().HF();
        if (HF != null && HF.aMl > 0) {
            this.gVy.setText(HF.aMl + "T豆加入");
        } else {
            this.gVy.setText("1000T豆加入");
        }
        this.gVK.setOnClickListener(this);
        this.gVs.setOnClickListener(this);
        this.gVv.gYP.setOnClickListener(this);
        this.gVv.gYU.setOnClickListener(this);
        this.gVy.setOnClickListener(this);
        this.gVC.setOnClickListener(this);
        this.gVv.gYK.setOnClickListener(this);
        this.gVv.gYL.setOnClickListener(this);
        this.gVv.gYS.setOnClickListener(this);
        this.gVv.aBZ.setOnClickListener(this);
        this.gVH.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gVv.gYH.setIsRound(true);
        this.gVv.gYH.setDrawBorder(false);
        this.gVv.gYH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVv.gYH.setAutoChangeStyle(false);
        this.gVv.gYH.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gVv.gYI.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aGY) {
            if (this.bfU) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aTK, str, this.otherParams);
        }
        this.gVG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bUQ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUQ() {
        if (this.gVH != null) {
            if (TextUtils.isEmpty(this.gVG.getText())) {
                this.gVH.setEnabled(false);
                this.gVI.setText(String.valueOf(0));
            } else {
                this.gVH.setEnabled(true);
                this.gVI.setText(String.valueOf(this.gVG.getText().length()));
            }
        }
        if (this.gVG.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gVG.setText(this.gVG.getText().subSequence(0, 10));
            this.gVG.setSelection(this.gVG.getText().length());
        }
    }

    private void bSd() {
        this.gVq = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gVp = this.mRootView.findViewById(a.f.space_view);
        this.gVh = this.mRootView.findViewById(a.f.layout_guard_info);
        this.btk = this.mRootView.findViewById(a.f.info_layout);
        this.gVG = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gVi = this.mRootView.findViewById(a.f.input_name_layout);
        this.gVj = this.mRootView.findViewById(a.f.input_name);
        this.gVH = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gVI = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gVr = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gVs = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gVt = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gVu = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gVv = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gVw = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gVx = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gVy = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gVz = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gVA = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gVK = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.gVB = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gVJ = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gVC = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gVL = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gVM = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void nh(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVt.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aGY) {
                this.gVt.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gVn);
                this.gVt.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aGY) {
            if (this.gVE == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gVE = com.baidu.live.utils.n.c(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gVE) {
                    decodeResource.recycle();
                }
            }
            if (this.gVF == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gVF = com.baidu.live.utils.n.c(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gVF) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gVt.setImageBitmap(this.gVF);
            } else {
                this.gVt.setImageBitmap(this.gVE);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gVt.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gVt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gVv.getLayoutParams();
        if (z || this.aGY) {
            this.gVv.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gVx.setVisibility(8);
            this.gVM.setVisibility(0);
            this.gVy.setVisibility(8);
        } else {
            this.gVv.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gVx.setVisibility(0);
            this.gVM.setVisibility(8);
            this.gVy.setVisibility(0);
        }
        this.gVv.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String str2, String str3, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bfP = aVar;
        this.bfQ = str;
        this.bfR = str3;
        this.bfS = str2;
        if (aVar == null || aVar.id <= 0) {
            this.gVr.setVisibility(8);
            this.gVw.setVisibility(8);
            this.gVJ.reset();
            this.gVJ.setTitle(a.h.guard_club_no_create);
            this.gVJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gVB.setVisibility(0);
            return;
        }
        this.gVr.setVisibility(0);
        this.gVw.setVisibility(0);
        this.gVB.setVisibility(8);
        nh(z);
        this.gVv.gYH.startLoad(aVar.bfI, 12, false);
        this.gVv.gYI.startLoad(com.baidu.live.guardclub.g.HD().dm(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aGY && aVar.bfK != null) {
            z2 = aVar.bfK.optInt("can_update_name", 0) == 1;
        }
        if (this.gVv.gWc.getWidth() <= 0) {
            this.gVv.gWc.measure(0, 0);
            this.gVv.gWc.getMeasuredWidth();
        }
        String str4 = aVar.bfC;
        if (z2) {
            this.gVv.gYJ.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gVv.gYJ.setVisibility(8);
        }
        this.gVv.aBZ.setText(str4);
        String m19do = com.baidu.live.guardclub.g.HD().m19do(aVar.guardLevel);
        String str5 = (m19do == null || "null".equals(m19do)) ? "" : m19do;
        Resources resources = this.gVv.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gVv.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.gVK.startLoad(str3, 10, false);
            this.gVK.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.gVK.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aGY) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gVK.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.gVK.setLayoutParams(layoutParams2);
            this.gVv.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bfE;
            if (aVar.bfH > 0) {
                str6 = str6 + " / " + aVar.bfH;
            }
            this.gVv.gYM.setText(str6);
            this.gVv.gYO.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.gVx.setVisibility(8);
            this.gVM.setVisibility(0);
            this.gVy.setVisibility(8);
            ni(this.gVb);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gVK.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.gVK.setLayoutParams(layoutParams3);
            this.gVv.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.bfE;
            if (aVar.bfH > 0) {
                str7 = str7 + " / " + aVar.bfH;
            }
            this.gVv.gYM.setText(str7);
            this.gVv.gYO.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.gVx.setVisibility(0);
            this.gVM.setVisibility(8);
            this.gVy.setVisibility(0);
            if (dVarArr != null) {
                this.gVz.setVisibility(0);
                this.gVL.removeAllViews();
                View view2 = null;
                int i2 = 0;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gVL.addView(view, layoutParams4);
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
                        tbImageView.startLoad(dVar.bgd, 10, false);
                        textView.setText(dVar.bge + "");
                    }
                    i2++;
                    view2 = view;
                }
            } else {
                this.gVz.setVisibility(8);
            }
        }
        this.gVv.setLayoutParams(layoutParams);
        if (aVar.bfE == aVar.bfH) {
            i = 100;
        } else if (aVar.bfE <= 0) {
            i = 0;
        } else if (aVar.bfH <= 0) {
            i = 100;
        } else if (aVar.bfE >= aVar.bfH) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bfE * 100) / aVar.bfH);
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
        this.gVv.gYN.setProgress(i);
        this.gVv.gYR.setText(aVar.bfG < 10000 ? aVar.bfG + "" : String.format("%.1f", Float.valueOf(((float) aVar.bfG) / 10000.0f)) + "万");
        String str8 = aVar.bfJ;
        this.gVv.gML.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.bfL == 0) {
            this.gVv.gYU.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.gVv.gYW.setAlpha(60);
            this.gVv.gYV.setTextColor(this.gVg.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bUR() {
        this.gVr.setVisibility(8);
        this.gVw.setVisibility(8);
        this.gVJ.reset();
        this.gVJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gVJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gVd != null) {
                    f.this.gVd.onClick(view);
                }
            }
        });
        this.gVJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gVB.setVisibility(0);
    }

    public void ni(boolean z) {
        if (this.gVD == null) {
            this.gVD = new k(this.gVg, this.liveId, this.roomId, this.anchorId, this.aTK, this.aGY, true, false, this.isFullScreen, this.otherParams, this.gVg.getUniqueId(), null);
        }
        this.gVD.nj(z);
        View view = this.gVD.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gVA.removeAllViews();
            this.gVA.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bbX != null) {
            this.bbX.onDestroy();
        }
        if (this.gVE != null) {
            this.gVE.recycle();
        }
        if (this.gVF != null) {
            this.gVF.recycle();
        }
        if (this.gVD != null) {
            this.gVD.onPageDestroy();
        }
        this.gVg.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.gVN != null) {
            this.gVN.release();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913290));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gVp || view == this.gVs || view == this.gVC) {
            this.activity.finish();
        } else if (view == this.gVv.gYL || view == this.gVv.gYK) {
            if (!TextUtils.isEmpty(this.bfQ)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bfQ);
            }
            if (!this.aGY) {
                if (this.bfU) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aTK, str, this.otherParams);
            }
        } else if (view == this.gVv.gYP) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aGY, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aTK);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gVv.gYS || view == this.gVK) {
            this.activity.setRequestedOrientation(1);
            this.gVg.setRequestedOrientation(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913287));
            if (this.gVN == null) {
                this.gVN = new com.baidu.live.ap.a(this.activity);
            }
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aGY, EncryptionHelper.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", HttpConstants.OS_TYPE_VALUE);
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bfS, a2);
            cVar.isFullScreen = true;
            this.gVN.b(cVar);
        } else if (view == this.gVy) {
            if (this.bfP != null) {
                bi HF = com.baidu.live.guardclub.g.HD().HF();
                if (HF == null || HF.aMl <= 0) {
                    j = 1000;
                } else {
                    j = HF.aMl;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    ur(this.bfP.id);
                } else if (this.gVb) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bfP));
                    this.activity.finish();
                }
            }
            if (!this.aGY) {
                if (TextUtils.isEmpty(this.gUV)) {
                    this.gUV = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aTK, this.gUV, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gVG.clearFocus();
                this.gVG.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gVg.getActivity(), this.gVG);
                return;
            }
            this.activity.finish();
        } else if (view == this.gVH) {
            String obj = this.gVG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.bfP.id, obj, "");
            }
        } else if (view == this.gVv.gYJ) {
            this.gVG.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gVg.getActivity(), this.gVG);
        } else if (view == this.gVv.gYU) {
            if (this.bfP != null && this.bfP.bfL == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.bfP != null && this.bfP.bfL == 1) {
                bUS();
            }
        }
    }

    public void Gr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gVv.aBZ.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.gVG.setText("");
            this.gVG.clearFocus();
            this.gVO.dismiss();
            this.gVv.gYU.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gVg.getActivity(), this.gVG);
        }
    }

    public void ur(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dk(i);
        cVar.a(this.bfP);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.fk(i);
        cVar.Gs(str);
        cVar.Gt(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bUS() {
        this.gVm = (TextView) this.gVl.findViewById(a.f.rename_club_name);
        this.gVP.setEnabled(false);
        this.gVP.setTextColor(this.gVg.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gVl.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gVl.findViewById(a.f.hint_num);
        this.gVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gVk = null;
                f.this.gVO.dismiss();
            }
        });
        this.gVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gVk = editText.getText().toString();
                }
                if (f.this.gVk != null && f.this.bfP != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gVg, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.bfP.id, f.this.gVk, "");
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
                    textView.setTextColor(f.this.gVg.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gVP.setTextColor(f.this.gVg.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.gVP.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.gVP.setEnabled(true);
                    f.this.gVP.setTextColor(f.this.gVg.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gVg, "仅支持中英文及数字");
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
                            BdUtilHelper.showToast(f.this.gVg, "不能超过3个字符");
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
                            textView.setTextColor(f.this.gVg.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gVg.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gVO.setContentView(this.gVl);
        this.gVO.setCanceledOnTouchOutside(true);
        this.gVl.setMinimumHeight((int) (o.getScreenHeight(this.gVg) * 0.24f));
        Window window = this.gVO.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gVg) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.gVO.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gVg, editText);
            }
        }, 100L);
    }
}
