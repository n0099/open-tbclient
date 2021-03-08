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
/* loaded from: classes10.dex */
public class f implements View.OnClickListener {
    private boolean aLc;
    private String aQq;
    private String aQr;
    private String aYp;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.o.c bgH;
    private String bkA;
    private String bkB;
    private boolean bkD;
    private com.baidu.live.guardclub.a bky;
    private String bkz;
    private View byo;
    private int dWJ;
    private String gZC;
    private boolean gZI;
    private View.OnClickListener gZK;
    private GuardClubInfoActivity gZN;
    private View gZO;
    private View gZP;
    private View gZQ;
    private String gZR;
    private View gZS;
    private TextView gZT;
    private int gZU;
    private int gZV;
    private View gZW;
    private LinearLayout gZX;
    private RelativeLayout gZY;
    private ImageView gZZ;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private ImageView haa;
    private LinearLayout hab;
    private GuardClubInfoHeaderView hac;
    private RelativeLayout had;
    private RelativeLayout hae;
    private TextView haf;
    private LinearLayout hag;
    private FrameLayout hah;
    private RelativeLayout hai;
    private ImageView haj;
    private k hak;
    private Bitmap hal;
    private Bitmap ham;
    private EditText han;
    private TextView hao;
    private TextView hap;
    private CommonEmptyView haq;
    private TbImageView har;
    private LinearLayout has;
    private LinearLayout hat;
    private com.baidu.live.an.a hau;
    private final Dialog hav;
    private final Button haw;
    private Button hax;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bOu = true;
    private boolean mIsKeyboardOpen = false;

    public f(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gZN = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aYp = str;
        this.aLc = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.bkD = z3;
        this.gZI = z4;
        this.gZC = str3;
        this.isTranslucent = z5;
        this.aQq = str4;
        this.aQr = str5;
        this.gZK = onClickListener;
        if (!z3) {
            if (this.bgH == null) {
                this.bgH = new com.baidu.live.o.c();
            }
            this.bgH.initListener();
            this.bgH.refreshCurUserScores();
        }
        this.gZU = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gZV = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        this.gZS = View.inflate(this.gZN, a.g.dialog_guard_club_rename, null);
        this.hav = new Dialog(this.gZN, a.i.RegimentRenameDiolog);
        this.haw = (Button) this.gZS.findViewById(a.f.rename_confirm);
        this.hax = (Button) this.gZS.findViewById(a.f.rename_cancel);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.f.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                f.this.gZN.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(f.this.gZN.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(f.this.gZN.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !f.this.mIsKeyboardOpen && f.this.bOu) {
                    f.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    Window window = f.this.hav.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 80;
                    attributes.x = 0;
                    attributes.y = 50;
                    window.setAttributes(attributes);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && f.this.mIsKeyboardOpen) {
                    f.this.mIsKeyboardOpen = false;
                    Window window2 = f.this.hav.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 17;
                    attributes2.x = 0;
                    attributes2.y = 0;
                    window2.setAttributes(attributes2);
                }
            }
        };
        this.gZN.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void FQ() {
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
        if (this.gZX != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gZX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gZX.setLayoutParams(layoutParams);
        }
        if (this.gZP != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gZP.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gZP.setLayoutParams(layoutParams2);
        }
        if (this.gZO != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gZO.getLayoutParams();
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
                gradientDrawable.setColor(this.gZU);
            } else {
                gradientDrawable.setColor(this.gZV);
            }
            this.gZO.setBackgroundDrawable(gradientDrawable);
        }
        if (this.haa != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.haa.setImageBitmap(this.ham);
            } else {
                this.haa.setImageBitmap(this.hal);
            }
        }
        if (this.hak != null) {
            this.hak.FQ();
        }
    }

    public final void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bST();
        FQ();
        this.gZW.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dWJ = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gZW.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gZZ.setVisibility(8);
                this.haj.setVisibility(8);
            } else {
                this.gZZ.setVisibility(0);
                this.haj.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.hab.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gZZ.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.haj.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.haa.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gZU);
        } else {
            this.gZW.setVisibility(0);
            this.gZZ.setVisibility(8);
            this.haj.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gZO.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gZN.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = (int) (this.dWJ * 0.7d);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gZU);
            } else {
                gradientDrawable.setColor(this.gZV);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hat.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.hat.setLayoutParams(layoutParams2);
        }
        this.gZO.setBackgroundDrawable(gradientDrawable);
        if (this.aLc) {
            nm(false);
        } else {
            nm(this.bkD);
            this.hac.hdB.setVisibility(8);
        }
        if (this.gZI) {
            this.hac.hdz.setVisibility(8);
        }
        bn IY = com.baidu.live.guardclub.g.IW().IY();
        if (IY != null && IY.aQJ > 0) {
            this.haf.setText(IY.aQJ + "T豆加入");
        } else {
            this.haf.setText("1000T豆加入");
        }
        this.har.setOnClickListener(this);
        this.gZZ.setOnClickListener(this);
        this.hac.hdw.setOnClickListener(this);
        this.hac.hdB.setOnClickListener(this);
        this.haf.setOnClickListener(this);
        this.haj.setOnClickListener(this);
        this.hac.hdr.setOnClickListener(this);
        this.hac.hds.setOnClickListener(this);
        this.hac.hdz.setOnClickListener(this);
        this.hac.aFm.setOnClickListener(this);
        this.hao.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hac.hdo.setIsRound(true);
        this.hac.hdo.setDrawBorder(false);
        this.hac.hdo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hac.hdo.setAutoChangeStyle(false);
        this.hac.hdo.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hac.hdp.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aLc) {
            if (this.bkD) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aYp, str, this.otherParams);
        }
        this.han.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                f.this.bVI();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        if (this.hao != null) {
            if (TextUtils.isEmpty(this.han.getText())) {
                this.hao.setEnabled(false);
                this.hap.setText(String.valueOf(0));
            } else {
                this.hao.setEnabled(true);
                this.hap.setText(String.valueOf(this.han.getText().length()));
            }
        }
        if (this.han.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.han.setText(this.han.getText().subSequence(0, 10));
            this.han.setSelection(this.han.getText().length());
        }
    }

    private void bST() {
        this.gZX = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gZW = this.mRootView.findViewById(a.f.space_view);
        this.gZO = this.mRootView.findViewById(a.f.layout_guard_info);
        this.byo = this.mRootView.findViewById(a.f.info_layout);
        this.han = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gZP = this.mRootView.findViewById(a.f.input_name_layout);
        this.gZQ = this.mRootView.findViewById(a.f.input_name);
        this.hao = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.hap = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gZY = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gZZ = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.haa = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.hab = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.hac = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.had = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.hae = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.haf = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.hag = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.hah = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.har = (TbImageView) this.mRootView.findViewById(a.f.extra_img);
        this.hai = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.haq = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.haj = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.has = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.hat = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void nm(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.haa.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aLc) {
                this.haa.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gZU);
                this.haa.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aLc) {
            if (this.hal == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.hal = com.baidu.live.utils.n.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.hal) {
                    decodeResource.recycle();
                }
            }
            if (this.ham == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.ham = com.baidu.live.utils.n.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.ham) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.haa.setImageBitmap(this.ham);
            } else {
                this.haa.setImageBitmap(this.hal);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.haa.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.haa.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hac.getLayoutParams();
        if (z || this.aLc) {
            this.hac.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.hae.setVisibility(8);
            this.hat.setVisibility(0);
            this.haf.setVisibility(8);
        } else {
            this.hac.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.hae.setVisibility(0);
            this.hat.setVisibility(8);
            this.haf.setVisibility(0);
        }
        this.hac.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String str2, String str3, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.bky = aVar;
        this.bkz = str;
        this.bkA = str3;
        this.bkB = str2;
        if (aVar == null || aVar.id <= 0) {
            this.gZY.setVisibility(8);
            this.had.setVisibility(8);
            this.haq.reset();
            this.haq.setTitle(a.h.guard_club_no_create);
            this.haq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.hai.setVisibility(0);
            return;
        }
        this.gZY.setVisibility(0);
        this.had.setVisibility(0);
        this.hai.setVisibility(8);
        nm(z);
        this.hac.hdo.startLoad(aVar.bkr, 12, false);
        this.hac.hdp.startLoad(com.baidu.live.guardclub.g.IW().ds(aVar.guardLevel), 10, false);
        boolean z2 = false;
        if (this.aLc && aVar.bkt != null) {
            z2 = aVar.bkt.optInt("can_update_name", 0) == 1;
        }
        if (this.hac.haJ.getWidth() <= 0) {
            this.hac.haJ.measure(0, 0);
            this.hac.haJ.getMeasuredWidth();
        }
        String str4 = aVar.bkl;
        if (z2) {
            this.hac.hdq.setVisibility(0);
            this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.hac.hdq.setVisibility(8);
        }
        this.hac.aFm.setText(str4);
        String du = com.baidu.live.guardclub.g.IW().du(aVar.guardLevel);
        String str5 = (du == null || "null".equals(du)) ? "" : du;
        Resources resources = this.hac.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hac.getLayoutParams();
        if (!TextUtils.isEmpty(str3)) {
            this.har.startLoad(str3, 10, false);
            this.har.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            this.har.setDefaultBgResource(a.e.gcb_banner);
        }
        if (z || this.aLc) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.har.getLayoutParams();
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds1);
            this.har.setLayoutParams(layoutParams2);
            this.hac.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.bkn;
            if (aVar.bkq > 0) {
                str6 = str6 + " / " + aVar.bkq;
            }
            this.hac.hdt.setText(str6);
            this.hac.hdv.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str5 + "</font>"));
            this.hae.setVisibility(8);
            this.hat.setVisibility(0);
            this.haf.setVisibility(8);
            nn(this.gZI);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.har.getLayoutParams();
            layoutParams3.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
            this.har.setLayoutParams(layoutParams3);
            this.hac.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str7 = "总真爱值 " + aVar.bkn;
            if (aVar.bkq > 0) {
                str7 = str7 + " / " + aVar.bkq;
            }
            this.hac.hdt.setText(str7);
            this.hac.hdv.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str5 + "</font>"));
            this.hae.setVisibility(0);
            this.hat.setVisibility(8);
            this.haf.setVisibility(0);
            if (dVarArr != null) {
                this.hag.setVisibility(0);
                this.has.removeAllViews();
                View view2 = null;
                int i2 = 0;
                while (i2 < dVarArr.length) {
                    if (i2 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams4.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.has.addView(view, layoutParams4);
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
                        tbImageView.startLoad(dVar.bkM, 10, false);
                        textView.setText(dVar.bkN + "");
                    }
                    i2++;
                    view2 = view;
                }
            } else {
                this.hag.setVisibility(8);
            }
        }
        this.hac.setLayoutParams(layoutParams);
        if (aVar.bkn == aVar.bkq) {
            i = 100;
        } else if (aVar.bkn <= 0) {
            i = 0;
        } else if (aVar.bkq <= 0) {
            i = 100;
        } else if (aVar.bkn >= aVar.bkq) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.bkn * 100) / aVar.bkq);
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
        this.hac.hdu.setProgress(i);
        this.hac.hdy.setText(aVar.bkp < 10000 ? aVar.bkp + "" : String.format("%.1f", Float.valueOf(((float) aVar.bkp) / 10000.0f)) + "万");
        String str8 = aVar.bks;
        this.hac.gRo.setText((str8 == null || TextUtils.equals(str8, "null")) ? "" : "");
        if (aVar != null && aVar.bku == 0) {
            this.hac.hdB.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            this.hac.hdD.setAlpha(60);
            this.hac.hdC.setTextColor(this.gZN.getPageContext().getResources().getColor(a.c.sdk_white_alpha60));
        }
    }

    public void bVJ() {
        this.gZY.setVisibility(8);
        this.had.setVisibility(8);
        this.haq.reset();
        this.haq.setTitle(a.h.sdk_net_fail_tip_rank);
        this.haq.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gZK != null) {
                    f.this.gZK.onClick(view);
                }
            }
        });
        this.haq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.hai.setVisibility(0);
    }

    public void nn(boolean z) {
        if (this.hak == null) {
            this.hak = new k(this.gZN, this.liveId, this.roomId, this.anchorId, this.aYp, this.aLc, true, false, this.isFullScreen, this.otherParams, this.gZN.getUniqueId(), null);
        }
        this.hak.no(z);
        View view = this.hak.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.hah.removeAllViews();
            this.hah.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bgH != null) {
            this.bgH.onDestroy();
        }
        if (this.hal != null) {
            this.hal.recycle();
        }
        if (this.ham != null) {
            this.ham.recycle();
        }
        if (this.hak != null) {
            this.hak.onPageDestroy();
        }
        this.gZN.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hau != null) {
            this.hau.release();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913290));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        long j;
        if (view == this.gZW || view == this.gZZ || view == this.haj) {
            this.activity.finish();
        } else if (view == this.hac.hds || view == this.hac.hdr) {
            if (!TextUtils.isEmpty(this.bkz)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.bkz);
            }
            if (!this.aLc) {
                if (this.bkD) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aYp, str, this.otherParams);
            }
        } else if (view == this.hac.hdw) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aLc, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aYp);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.hac.hdz || view == this.har) {
            if (Build.VERSION.SDK_INT != 26) {
                this.activity.setRequestedOrientation(1);
                this.gZN.setRequestedOrientation(1);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913287));
            if (this.hau == null) {
                this.hau = new com.baidu.live.an.a(this.activity);
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            Map<String, Object> a2 = com.baidu.live.utils.b.a(this.aLc, EncryptionHelper.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())), EncryptionHelper.getEncryptionUserId(String.valueOf(this.anchorId)), String.valueOf(this.roomId), String.valueOf(this.liveId));
            a2.put("_client_type", HttpConstants.OS_TYPE_VALUE);
            a2.put("subapp_type", TbConfig.getSubappType());
            cVar.url = WebviewHelper.addQueryParams(this.bkB, a2);
            cVar.isFullScreen = true;
            this.hau.a(cVar);
        } else if (view == this.haf) {
            if (this.bky != null) {
                bn IY = com.baidu.live.guardclub.g.IW().IY();
                if (IY == null || IY.aQJ <= 0) {
                    j = 1000;
                } else {
                    j = IY.aQJ;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    uz(this.bky.id);
                } else if (this.gZI) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.bky));
                    this.activity.finish();
                }
            }
            if (!this.aLc) {
                if (TextUtils.isEmpty(this.gZC)) {
                    this.gZC = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aYp, this.gZC, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.han.clearFocus();
                this.han.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gZN.getActivity(), this.han);
                return;
            }
            this.activity.finish();
        } else if (view == this.hao) {
            String obj = this.han.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                k(this.bky.id, obj, "");
            }
        } else if (view == this.hac.hdq) {
            this.han.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gZN.getActivity(), this.han);
        } else if (view == this.hac.hdB) {
            if (this.bky != null && this.bky.bku == 0) {
                UtilHelper.showToast(this.activity, "真爱团名每个月只能修改1次哦");
            }
            if (this.bky != null && this.bky.bku == 1) {
                bVK();
            }
        }
    }

    public void Ha(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hac.aFm.setText(str);
            UtilHelper.showToast(this.activity, "修改成功");
            this.han.setText("");
            this.han.clearFocus();
            this.hav.dismiss();
            this.hac.hdB.setBackgroundResource(a.e.shape_corners_cant_rename_button);
            BdUtilHelper.hideSoftKeyPad(this.gZN.getActivity(), this.han);
        }
    }

    public void uz(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dq(i);
        cVar.a(this.bky);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.fq(i);
        cVar.Hb(str);
        cVar.Hc(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVK() {
        this.gZT = (TextView) this.gZS.findViewById(a.f.rename_club_name);
        this.haw.setEnabled(false);
        this.haw.setTextColor(this.gZN.getResources().getColor(a.c.sdk_black_alpha40));
        final EditText editText = (EditText) this.gZS.findViewById(a.f.guard_club_rename_edittext);
        final TextView textView = (TextView) this.gZS.findViewById(a.f.hint_num);
        this.hax.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.gZR = null;
                f.this.hav.dismiss();
            }
        });
        this.haw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (editText.getText().toString() != null) {
                    f.this.gZR = editText.getText().toString();
                }
                if (f.this.gZR != null && f.this.bky != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(f.this.gZN, "网络故障，请刷新重试");
                    } else {
                        f.this.k(f.this.bky.id, f.this.gZR, "");
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
                    textView.setTextColor(f.this.gZN.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.haw.setTextColor(f.this.gZN.getResources().getColor(a.c.sdk_black_alpha40));
                    f.this.haw.setEnabled(false);
                    textView.setText("0");
                } else {
                    f.this.haw.setEnabled(true);
                    f.this.haw.setTextColor(f.this.gZN.getResources().getColor(a.c.rename_hint_color));
                }
                if (obj.length() > 0) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < obj.length(); i6++) {
                        String substring = obj.substring(i6, i6 + 1);
                        if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                            BdUtilHelper.showToast(f.this.gZN, "仅支持中英文及数字");
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
                            BdUtilHelper.showToast(f.this.gZN, "不能超过3个字符");
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
                            textView.setTextColor(f.this.gZN.getResources().getColor(a.c.rename_hint_color));
                        } else {
                            textView.setTextColor(f.this.gZN.getResources().getColor(a.c.sdk_black_alpha40));
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.hav.setContentView(this.gZS);
        this.hav.setCanceledOnTouchOutside(true);
        this.gZS.setMinimumHeight((int) (o.getScreenHeight(this.gZN) * 0.24f));
        Window window = this.hav.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (o.getScreenWidth(this.gZN) * 0.74f);
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 50;
        window.setAttributes(attributes);
        this.hav.show();
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.f.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                BdUtilHelper.showSoftKeyPad(f.this.gZN, editText);
            }
        }, 100L);
    }
}
