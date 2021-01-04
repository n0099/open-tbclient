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
/* loaded from: classes11.dex */
public class f implements View.OnClickListener {
    private boolean aLL;
    private String aQG;
    private String aQH;
    private String aYx;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.p.c bgO;
    private com.baidu.live.guardclub.a bkF;
    private String bkG;
    private String bkH;
    private String bkI;
    private boolean bkK;
    private View bxY;
    private int dXO;
    private String gZB;
    private boolean gZH;
    private View.OnClickListener gZJ;
    private GuardClubInfoActivity gZM;
    private View gZN;
    private View gZO;
    private View gZP;
    private String gZQ;
    private View gZR;
    private TextView gZS;
    private int gZT;
    private int gZU;
    private View gZV;
    private LinearLayout gZW;
    private RelativeLayout gZX;
    private ImageView gZY;
    private ImageView gZZ;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private LinearLayout haa;
    private GuardClubInfoHeaderView hab;
    private RelativeLayout hac;
    private RelativeLayout had;
    private TextView hae;
    private LinearLayout haf;
    private FrameLayout hag;
    private RelativeLayout hah;
    private ImageView hai;
    private k haj;
    private Bitmap hak;
    private Bitmap hal;
    private EditText ham;
    private TextView han;
    private TextView hao;
    private CommonEmptyView hap;
    private TbImageView haq;
    private LinearLayout har;
    private LinearLayout has;
    private com.baidu.live.ap.a hat;
    private final Dialog hau;
    private final Button hav;
    private Button haw;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bNW = true;
    private boolean mIsKeyboardOpen = false;

    public f(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gZM = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aYx = str;
        this.aLL = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bkK = z3;
        this.gZH = z4;
        this.gZB = str3;
        this.isTranslucent = z5;
        this.aQG = str4;
        this.aQH = str5;
        this.gZJ = onClickListener;
        if (!z3) {
            if (this.bgO == null) {
                this.bgO = new com.baidu.live.p.c();
            }
            this.bgO.initListener();
            this.bgO.refreshCurUserScores();
        }
        this.gZT = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gZU = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gZR = View.inflate(this.gZM, a.g.dialog_guard_club_rename, null);
        this.hau = new Dialog(this.gZM, a.i.RegimentRenameDiolog);
        this.hav = (Button) this.gZR.findViewById(a.f.rename_confirm);
        this.haw = (Button) this.gZR.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gZM.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gZM.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gZM.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bNW) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.hau.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.hau.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gZM.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void Is() {
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
        if (this.gZW != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gZW.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gZW.setLayoutParams(layoutParams);
        }
        if (this.gZO != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gZO.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gZO.setLayoutParams(layoutParams2);
        }
        if (this.gZN != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gZN.getLayoutParams();
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
                gradientDrawable.setColor(this.gZT);
            } else {
                gradientDrawable.setColor(this.gZU);
            }
            this.gZN.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gZZ != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gZZ.setImageBitmap(this.hal);
            } else {
                this.gZZ.setImageBitmap(this.hak);
            }
        }
        if (this.haj != null) {
            this.haj.Is();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bVU();
        Is();
        this.gZV.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dXO = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gZV.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gZY.setVisibility(8);
                this.hai.setVisibility(8);
            } else {
                this.gZY.setVisibility(0);
                this.hai.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.haa.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gZY.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.hai.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gZZ.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gZT);
        } else {
            this.gZV.setVisibility(0);
            this.gZY.setVisibility(8);
            this.hai.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gZN.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gZM.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = (int) (this.dXO * 0.7d);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gZT);
            } else {
                gradientDrawable.setColor(this.gZU);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.has.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.has.setLayoutParams(layoutParams2);
        }
        this.gZN.setBackgroundDrawable(gradientDrawable);
        if (this.aLL) {
            nl(false);
        } else {
            nl(this.bkK);
            this.hab.hdA.setVisibility(8);
        }
        if (this.gZH) {
            this.hab.hdy.setVisibility(8);
        }
        bi LA = com.baidu.live.guardclub.g.Ly().LA();
        if (LA != null && LA.aQY > 0) {
            this.hae.setText(LA.aQY + "T豆加入");
        } else {
            this.hae.setText("1000T豆加入");
        }
        this.haq.setOnClickListener(this);
        this.gZY.setOnClickListener(this);
        this.hab.hdv.setOnClickListener(this);
        this.hab.hdA.setOnClickListener(this);
        this.hae.setOnClickListener(this);
        this.hai.setOnClickListener(this);
        this.hab.hdq.setOnClickListener(this);
        this.hab.hdr.setOnClickListener(this);
        this.hab.hdy.setOnClickListener(this);
        this.hab.aGM.setOnClickListener(this);
        this.han.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hab.hdn.setIsRound(true);
        this.hab.hdn.setDrawBorder(false);
        this.hab.hdn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hab.hdn.setAutoChangeStyle(false);
        this.hab.hdn.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hab.hdo.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aLL) {
            if (this.bkK) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aYx, str, this.otherParams);
        }
        this.ham.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bYH();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYH() {
        if (this.han != null) {
            if (TextUtils.isEmpty(this.ham.getText())) {
                this.han.setEnabled(false);
                this.hao.setText(String.valueOf(0));
            } else {
                this.han.setEnabled(true);
                this.hao.setText(String.valueOf(this.ham.getText().length()));
            }
        }
        if (this.ham.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.ham.setText(this.ham.getText().subSequence(0, 10));
            this.ham.setSelection(this.ham.getText().length());
        }
    }

    private void bVU() {
        this.gZW = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gZV = this.mRootView.findViewById(a.f.space_view);
        this.gZN = this.mRootView.findViewById(a.f.layout_guard_info);
        this.bxY = this.mRootView.findViewById(a.f.info_layout);
        this.ham = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gZO = this.mRootView.findViewById(a.f.input_name_layout);
        this.gZP = this.mRootView.findViewById(a.f.input_name);
        this.han = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.hao = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gZX = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gZY = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gZZ = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.haa = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.hab = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.hac = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.had = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.hae = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.haf = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.hag = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.haq = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.hah = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.hap = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.hai = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.har = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.has = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void nl(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZZ.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aLL) {
                this.gZZ.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gZT);
                this.gZZ.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aLL) {
            if (this.hak == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.hak = com.baidu.live.utils.n.c(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.hak) {
                    decodeResource.recycle();
                }
            }
            if (this.hal == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.hal = com.baidu.live.utils.n.c(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.hal) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gZZ.setImageBitmap(this.hal);
            } else {
                this.gZZ.setImageBitmap(this.hak);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gZZ.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gZZ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hab.getLayoutParams();
        if (z || this.aLL) {
            this.hab.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.had.setVisibility(8);
            this.has.setVisibility(0);
            this.hae.setVisibility(8);
        } else {
            this.hab.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.had.setVisibility(0);
            this.has.setVisibility(8);
            this.hae.setVisibility(0);
        }
        this.hab.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String str2, String str3, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bkF = aVar;
        this.bkG = str;
        this.bkH = str3;
        this.bkI = str2;
        if (aVar == null || aVar.id <= 0) {
            this.gZX.setVisibility(8);
            this.hac.setVisibility(8);
            this.hap.reset();
            this.hap.setTitle(a.h.guard_club_no_create);
            this.hap.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.hah.setVisibility(0);
            return;
        }
        this.gZX.setVisibility(0);
        this.hac.setVisibility(0);
        this.hah.setVisibility(8);
        nl(z);
        this.hab.hdn.startLoad(aVar.bky, 12, false);
        this.hab.hdo.startLoad(com.baidu.live.guardclub.g.Ly().eS(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aLL && aVar.bkA != null) {
            z2 = aVar.bkA.optInt("can_update_name", 0) == 1;
        }
        if (this.hab.haI.getWidth() <= 0) {
            this.hab.haI.measure(0, 0);
            this.hab.haI.getMeasuredWidth();
        }
        String str4 = aVar.bks;
        if (z2) {
            this.hab.hdp.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.hab.hdp.setVisibility(8);
        }
        this.hab.aGM.setText(str4);
        String eU = com.baidu.live.guardclub.g.Ly().eU(aVar.guardLevel);
        String str5 = (eU == null || "null".equals(eU)) ? "" : eU;
        Resources resources = this.hab.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hab.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.haq.startLoad(str3, 10, false);
            this.haq.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.haq.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aLL) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.haq.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.haq.setLayoutParams(layoutParams2);
            this.hab.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bku;
            if (aVar.bkx > 0) {
                str6 = str6 + " / " + aVar.bkx;
            }
            this.hab.hds.setText(str6);
            this.hab.hdu.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.had.setVisibility(8);
            this.has.setVisibility(0);
            this.hae.setVisibility(8);
            nm(this.gZH);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.haq.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.haq.setLayoutParams(layoutParams3);
            this.hab.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.bku;
            if (aVar.bkx > 0) {
                str7 = str7 + " / " + aVar.bkx;
            }
            this.hab.hds.setText(str7);
            this.hab.hdu.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.had.setVisibility(0);
            this.has.setVisibility(8);
            this.hae.setVisibility(0);
            if (dVarArr != null) {
                this.haf.setVisibility(0);
                this.har.removeAllViews();
                View view2 = null;
                int i2 = 0;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.har.addView(view, layoutParams4);
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
                        tbImageView.startLoad(dVar.bkT, 10, false);
                        textView.setText(dVar.bkU + "");
                    }
                    i2++;
                    view2 = view;
                }
            } else {
                this.haf.setVisibility(8);
            }
        }
        this.hab.setLayoutParams(layoutParams);
        if (aVar.bku == aVar.bkx) {
            i = 100;
        } else if (aVar.bku <= 0) {
            i = 0;
        } else if (aVar.bkx <= 0) {
            i = 100;
        } else if (aVar.bku >= aVar.bkx) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bku * 100) / aVar.bkx);
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
        this.hab.hdt.setProgress(i);
        this.hab.hdx.setText(aVar.bkw < 10000 ? aVar.bkw + "" : String.format("%.1f", Float.valueOf(((float) aVar.bkw) / 10000.0f)) + "万");
        String str8 = aVar.bkz;
        this.hab.gRr.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.bkB == 0) {
            this.hab.hdA.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.hab.hdC.setAlpha(60);
            this.hab.hdB.setTextColor(this.gZM.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bYI() {
        this.gZX.setVisibility(8);
        this.hac.setVisibility(8);
        this.hap.reset();
        this.hap.setTitle(a.h.sdk_net_fail_tip_rank);
        this.hap.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gZJ != null) {
                    f.this.gZJ.onClick(view);
                }
            }
        });
        this.hap.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.hah.setVisibility(0);
    }

    public void nm(boolean z) {
        if (this.haj == null) {
            this.haj = new k(this.gZM, this.liveId, this.roomId, this.anchorId, this.aYx, this.aLL, true, false, this.isFullScreen, this.otherParams, this.gZM.getUniqueId(), null);
        }
        this.haj.nn(z);
        View view = this.haj.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.hag.removeAllViews();
            this.hag.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bgO != null) {
            this.bgO.onDestroy();
        }
        if (this.hak != null) {
            this.hak.recycle();
        }
        if (this.hal != null) {
            this.hal.recycle();
        }
        if (this.haj != null) {
            this.haj.onPageDestroy();
        }
        this.gZM.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hat != null) {
            this.hat.release();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913290));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gZV || view == this.gZY || view == this.hai) {
            this.activity.finish();
        } else if (view == this.hab.hdr || view == this.hab.hdq) {
            if (!TextUtils.isEmpty(this.bkG)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bkG);
            }
            if (!this.aLL) {
                if (this.bkK) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aYx, str, this.otherParams);
            }
        } else if (view == this.hab.hdv) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aLL, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aYx);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.hab.hdy || view == this.haq) {
            this.activity.setRequestedOrientation(1);
            this.gZM.setRequestedOrientation(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913287));
            if (this.hat == null) {
                this.hat = new com.baidu.live.ap.a(this.activity);
            }
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aLL, EncryptionHelper.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", HttpConstants.OS_TYPE_VALUE);
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bkI, a2);
            cVar.isFullScreen = true;
            this.hat.b(cVar);
        } else if (view == this.hae) {
            if (this.bkF != null) {
                bi LA = com.baidu.live.guardclub.g.Ly().LA();
                if (LA == null || LA.aQY <= 0) {
                    j = 1000;
                } else {
                    j = LA.aQY;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    vX(this.bkF.id);
                } else if (this.gZH) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bkF));
                    this.activity.finish();
                }
            }
            if (!this.aLL) {
                if (TextUtils.isEmpty(this.gZB)) {
                    this.gZB = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aYx, this.gZB, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.ham.clearFocus();
                this.ham.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gZM.getActivity(), this.ham);
                return;
            }
            this.activity.finish();
        } else if (view == this.han) {
            String obj = this.ham.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.bkF.id, obj, "");
            }
        } else if (view == this.hab.hdp) {
            this.ham.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gZM.getActivity(), this.ham);
        } else if (view == this.hab.hdA) {
            if (this.bkF != null && this.bkF.bkB == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.bkF != null && this.bkF.bkB == 1) {
                bYJ();
            }
        }
    }

    public void HD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hab.aGM.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.ham.setText("");
            this.ham.clearFocus();
            this.hau.dismiss();
            this.hab.hdA.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gZM.getActivity(), this.ham);
        }
    }

    public void vX(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eQ(i);
        cVar.a(this.bkF);
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

    public void bYJ() {
        this.gZS = (TextView) this.gZR.findViewById(a.f.rename_club_name);
        this.hav.setEnabled(false);
        this.hav.setTextColor(this.gZM.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gZR.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gZR.findViewById(a.f.hint_num);
        this.haw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gZQ = null;
                f.this.hau.dismiss();
            }
        });
        this.hav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gZQ = editText.getText().toString();
                }
                if (f.this.gZQ != null && f.this.bkF != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gZM, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.bkF.id, f.this.gZQ, "");
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
                    textView.setTextColor(f.this.gZM.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.hav.setTextColor(f.this.gZM.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.hav.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.hav.setEnabled(true);
                    f.this.hav.setTextColor(f.this.gZM.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gZM, "仅支持中英文及数字");
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
                            BdUtilHelper.showToast(f.this.gZM, "不能超过3个字符");
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
                            textView.setTextColor(f.this.gZM.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gZM.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hau.setContentView(this.gZR);
        this.hau.setCanceledOnTouchOutside(true);
        this.gZR.setMinimumHeight((int) (o.getScreenHeight(this.gZM) * 0.24f));
        Window window = this.hau.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gZM) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.hau.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gZM, editText);
            }
        }, 100L);
    }
}
