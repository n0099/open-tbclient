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
import com.baidu.live.data.bf;
import com.baidu.live.sdk.a;
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
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardclub.view.GuardClubInfoHeaderView;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    private boolean aIu;
    private String aMS;
    private String aMT;
    private String aTN;
    private Activity activity;
    private long anchorId;
    private com.baidu.live.m.c bbg;
    private com.baidu.live.guardclub.a beL;
    private String beM;
    private boolean beO;
    private View bod;
    private int dHY;
    private String gEO;
    private boolean gEU;
    private View.OnClickListener gEW;
    private GuardClubInfoActivity gEZ;
    private LinearLayout gFA;
    private LinearLayout gFB;
    private View gFa;
    private View gFb;
    private View gFc;
    private int gFd;
    private int gFe;
    private View gFf;
    private LinearLayout gFg;
    private RelativeLayout gFh;
    private ImageView gFi;
    private ImageView gFj;
    private LinearLayout gFk;
    private GuardClubInfoHeaderView gFl;
    private RelativeLayout gFm;
    private RelativeLayout gFn;
    private TextView gFo;
    private LinearLayout gFp;
    private FrameLayout gFq;
    private RelativeLayout gFr;
    private ImageView gFs;
    private j gFt;
    private Bitmap gFu;
    private Bitmap gFv;
    private EditText gFw;
    private TextView gFx;
    private TextView gFy;
    private CommonEmptyView gFz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean bEa = true;
    private boolean mIsKeyboardOpen = false;

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5, View.OnClickListener onClickListener) {
        this.gEZ = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aTN = str;
        this.aIu = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.beO = z3;
        this.gEU = z4;
        this.gEO = str3;
        this.isTranslucent = z5;
        this.aMS = str4;
        this.aMT = str5;
        this.gEW = onClickListener;
        if (!z3) {
            if (this.bbg == null) {
                this.bbg = new com.baidu.live.m.c();
            }
            this.bbg.initListener();
            this.bbg.refreshCurUserScores();
        }
        this.gFd = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary);
        this.gFe = guardClubInfoActivity.getResources().getColor(a.c.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                e.this.gEZ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(e.this.gEZ.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(e.this.gEZ.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !e.this.mIsKeyboardOpen && e.this.bEa) {
                    e.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    e.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && e.this.mIsKeyboardOpen) {
                    e.this.mIsKeyboardOpen = false;
                    e.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gEZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    public void Ha() {
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
        if (this.gFg != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gFg.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.gFg.setLayoutParams(layoutParams);
        }
        if (this.gFb != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gFb.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.gFb.setLayoutParams(layoutParams2);
        }
        if (this.gFa != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.gFa.getLayoutParams();
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
                gradientDrawable.setColor(this.gFd);
            } else {
                gradientDrawable.setColor(this.gFe);
            }
            this.gFa.setBackgroundDrawable(gradientDrawable);
        }
        if (this.gFj != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gFj.setImageBitmap(this.gFv);
            } else {
                this.gFj.setImageBitmap(this.gFu);
            }
        }
        if (this.gFt != null) {
            this.gFt.Ha();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.g.view_guardclub_info, (ViewGroup) null);
        bPC();
        Ha();
        this.gFf.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dHY = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.gFf.setVisibility(8);
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFi.setVisibility(8);
                this.gFs.setVisibility(8);
            } else {
                this.gFi.setVisibility(0);
                this.gFs.setVisibility(0);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.gFk.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.gFi.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.gFs.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.gFj.setImageResource(a.e.gcb_bg_info_top);
            gradientDrawable.setColor(this.gFd);
        } else {
            this.gFf.setVisibility(0);
            this.gFi.setVisibility(8);
            this.gFs.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.gFa.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.gEZ.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.d.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.gFd);
            } else {
                gradientDrawable.setColor(this.gFe);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gFB.getLayoutParams();
            layoutParams2.addRule(8, a.f.notJoin_layout);
            this.gFB.setLayoutParams(layoutParams2);
        }
        this.gFa.setBackgroundDrawable(gradientDrawable);
        if (this.aIu) {
            mq(false);
        } else {
            mq(this.beO);
        }
        if (this.gEU) {
            this.gFl.gIB.setVisibility(8);
        }
        bf JY = com.baidu.live.guardclub.g.JW().JY();
        if (JY != null && JY.aNk > 0) {
            this.gFo.setText(JY.aNk + "T豆加入");
        } else {
            this.gFo.setText("1000T豆加入");
        }
        this.gFi.setOnClickListener(this);
        this.gFl.gIy.setOnClickListener(this);
        this.gFo.setOnClickListener(this);
        this.gFs.setOnClickListener(this);
        this.gFl.gIu.setOnClickListener(this);
        this.gFl.gIB.setOnClickListener(this);
        this.gFl.gIt.setOnClickListener(this);
        this.gFx.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gFl.gIr.setIsRound(true);
        this.gFl.gIr.setDrawBorder(false);
        this.gFl.gIr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFl.gIr.setAutoChangeStyle(false);
        this.gFl.gIr.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gFl.gIs.setDefaultBgResource(a.e.sdk_transparent_bg);
        if (!this.aIu) {
            if (this.beO) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aTN, str, this.otherParams);
        }
        this.gFw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.e.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                e.this.bSr();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSr() {
        if (this.gFx != null) {
            if (TextUtils.isEmpty(this.gFw.getText())) {
                this.gFx.setEnabled(false);
                this.gFy.setText(String.valueOf(0));
            } else {
                this.gFx.setEnabled(true);
                this.gFy.setText(String.valueOf(this.gFw.getText().length()));
            }
        }
        if (this.gFw.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.h.sdk_send_im_over_max), 10));
            this.gFw.setText(this.gFw.getText().subSequence(0, 10));
            this.gFw.setSelection(this.gFw.getText().length());
        }
    }

    private void bPC() {
        this.gFg = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_club_info);
        this.gFf = this.mRootView.findViewById(a.f.space_view);
        this.gFa = this.mRootView.findViewById(a.f.layout_guard_info);
        this.bod = this.mRootView.findViewById(a.f.info_layout);
        this.gFw = (EditText) this.mRootView.findViewById(a.f.edit_guard_rename);
        this.gFb = this.mRootView.findViewById(a.f.input_name_layout);
        this.gFc = this.mRootView.findViewById(a.f.input_name);
        this.gFx = (TextView) this.mRootView.findViewById(a.f.tv_send);
        this.gFy = (TextView) this.mRootView.findViewById(a.f.tv_input_name_length);
        this.gFh = (RelativeLayout) this.mRootView.findViewById(a.f.info_layout);
        this.gFi = (ImageView) this.mRootView.findViewById(a.f.back_imageView);
        this.gFj = (ImageView) this.mRootView.findViewById(a.f.infoHeadBg_imageView);
        this.gFk = (LinearLayout) this.mRootView.findViewById(a.f.infoHead_layout);
        this.gFl = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.f.infoHeadInner_layout);
        this.gFm = (RelativeLayout) this.mRootView.findViewById(a.f.memberInfo_layout);
        this.gFn = (RelativeLayout) this.mRootView.findViewById(a.f.notJoin_layout);
        this.gFo = (TextView) this.mRootView.findViewById(a.f.toJoin_textView);
        this.gFp = (LinearLayout) this.mRootView.findViewById(a.f.privilege_layout);
        this.gFq = (FrameLayout) this.mRootView.findViewById(a.f.memberList_layout);
        this.gFr = (RelativeLayout) this.mRootView.findViewById(a.f.noData_layout);
        this.gFz = (CommonEmptyView) this.mRootView.findViewById(a.f.noData_view);
        this.gFs = (ImageView) this.mRootView.findViewById(a.f.back2_imageView);
        this.gFA = (LinearLayout) this.mRootView.findViewById(a.f.joinPrivilegeIcons_layout);
        this.gFB = (LinearLayout) this.mRootView.findViewById(a.f.hasJoin_layout);
    }

    private void mq(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFj.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.aIu) {
                this.gFj.setImageResource(a.e.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.gFd);
                this.gFj.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.f.infoHead_layout);
            }
        } else if (z || this.aIu) {
            if (this.gFu == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gFu = com.baidu.live.utils.m.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 3);
                if (decodeResource != this.gFu) {
                    decodeResource.recycle();
                }
            }
            if (this.gFv == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.e.gcb_bg_info_top);
                this.gFv = com.baidu.live.utils.m.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds26), 1);
                if (decodeResource2 != this.gFv) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.gFj.setImageBitmap(this.gFv);
            } else {
                this.gFj.setImageBitmap(this.gFu);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.d.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.gFj.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.f.infoHead_layout);
        }
        this.gFj.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFl.getLayoutParams();
        if (z || this.aIu) {
            this.gFl.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.gFn.setVisibility(8);
            this.gFB.setVisibility(0);
            this.gFo.setVisibility(8);
        } else {
            this.gFl.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.gFn.setVisibility(0);
            this.gFB.setVisibility(8);
            this.gFo.setVisibility(0);
        }
        this.gFl.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.live.guardclub.a aVar, String str, String[] strArr, boolean z, com.baidu.live.guardclub.d[] dVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.beL = aVar;
        this.beM = str;
        if (aVar == null || aVar.id <= 0) {
            this.gFh.setVisibility(8);
            this.gFm.setVisibility(8);
            this.gFz.reset();
            this.gFz.setTitle(a.h.guard_club_no_create);
            this.gFz.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.gFr.setVisibility(0);
            return;
        }
        this.gFh.setVisibility(0);
        this.gFm.setVisibility(0);
        this.gFr.setVisibility(8);
        mq(z);
        this.gFl.gIr.startLoad(aVar.beG, 12, false);
        this.gFl.gIs.startLoad(com.baidu.live.guardclub.g.JW().ey(aVar.beE), 10, false);
        boolean z2 = false;
        if (this.aIu && aVar.beI != null) {
            z2 = aVar.beI.optInt("can_update_name", 0) == 1;
        }
        int width = this.gFl.gFM.getWidth();
        if (width <= 0) {
            this.gFl.gFM.measure(0, 0);
            width = this.gFl.gFM.getMeasuredWidth();
        }
        String str3 = aVar.bez;
        int i2 = 0;
        if (z2) {
            this.gFl.gIt.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        } else {
            this.gFl.gIt.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.gFl.aDP.setPadding(0, 0, width + i2, 0);
            this.gFl.gFM.setPadding(0, 0, i2, 0);
            this.gFl.gFM.setVisibility(0);
        } else {
            this.gFl.aDP.setPadding(0, 0, i2, 0);
            this.gFl.gFM.setPadding(0, 0, i2, 0);
            this.gFl.gFM.setVisibility(4);
            str2 = str3;
        }
        this.gFl.aDP.setText(str2);
        String eA = com.baidu.live.guardclub.g.JW().eA(aVar.beE);
        String str4 = (eA == null || "null".equals(eA)) ? "" : eA;
        Resources resources = this.gFl.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFl.getLayoutParams();
        if (z || this.aIu) {
            this.gFl.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + aVar.beB;
            if (aVar.beF > 0) {
                str5 = str5 + " / " + aVar.beF;
            }
            this.gFl.gIv.setText(str5);
            this.gFl.gIx.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.gFn.setVisibility(8);
            this.gFB.setVisibility(0);
            this.gFo.setVisibility(8);
            mr(this.gEU);
        } else {
            this.gFl.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.d.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.d.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.d.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + aVar.beB;
            if (aVar.beF > 0) {
                str6 = str6 + " / " + aVar.beF;
            }
            this.gFl.gIv.setText(str6);
            this.gFl.gIx.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.gFn.setVisibility(0);
            this.gFB.setVisibility(8);
            this.gFo.setVisibility(0);
            if (dVarArr != null) {
                this.gFp.setVisibility(0);
                this.gFA.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < dVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.g.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.gFA.addView(view, layoutParams2);
                    } else {
                        view = view2;
                    }
                    if (view == null) {
                        break;
                    }
                    if (i3 % 4 == 0) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon1);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle1);
                    } else if (i3 % 4 == 1) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon2);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle2);
                    } else if (i3 % 4 == 2) {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon3);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle3);
                    } else {
                        tbImageView = (TbImageView) view.findViewById(a.f.privilegeIcon4);
                        textView = (TextView) view.findViewById(a.f.privilegeTitle4);
                    }
                    com.baidu.live.guardclub.d dVar = dVarArr[i3];
                    if (dVar != null) {
                        tbImageView.startLoad(dVar.beX, 10, false);
                        textView.setText(dVar.beY + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.gFp.setVisibility(8);
            }
        }
        this.gFl.setLayoutParams(layoutParams);
        if (aVar.beB == aVar.beF) {
            i = 100;
        } else if (aVar.beB <= 0) {
            i = 0;
        } else if (aVar.beF <= 0) {
            i = 100;
        } else if (aVar.beB >= aVar.beF) {
            i = 100;
        } else {
            try {
                i = (int) ((aVar.beB * 100) / aVar.beF);
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
        this.gFl.gIw.setProgress(i);
        this.gFl.gIA.setText(aVar.beD < 10000 ? aVar.beD + "" : String.format("%.1f", Float.valueOf(((float) aVar.beD) / 10000.0f)) + "万");
        String str7 = aVar.beH;
        this.gFl.gwT.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bSs() {
        this.gFh.setVisibility(8);
        this.gFm.setVisibility(8);
        this.gFz.reset();
        this.gFz.setTitle(a.h.sdk_net_fail_tip_rank);
        this.gFz.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gEW != null) {
                    e.this.gEW.onClick(view);
                }
            }
        });
        this.gFz.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.gFr.setVisibility(0);
    }

    public void mr(boolean z) {
        if (this.gFt == null) {
            this.gFt = new j(this.gEZ, this.liveId, this.roomId, this.anchorId, this.aTN, this.aIu, true, false, this.isFullScreen, this.otherParams, this.gEZ.getUniqueId(), null);
        }
        this.gFt.ms(z);
        View view = this.gFt.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.gFq.removeAllViews();
            this.gFq.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.bbg != null) {
            this.bbg.onDestroy();
        }
        if (this.gFu != null) {
            this.gFu.recycle();
        }
        if (this.gFv != null) {
            this.gFv.recycle();
        }
        if (this.gFt != null) {
            this.gFt.aXy();
        }
        this.gEZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.gFf || view == this.gFi || view == this.gFs) {
            this.activity.finish();
        } else if (view == this.gFl.gIu) {
            if (!TextUtils.isEmpty(this.beM)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.beM);
            }
            if (!this.aIu) {
                if (this.beO) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aTN, str, this.otherParams);
            }
        } else if (view == this.gFl.gIy) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.anchorId, this.liveId, this.aIu, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aTN);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.gFl.gIB) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.anchorId, this.liveId, this.aIu, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aTN);
            guardClubRankActivityConfig.setAnchorInfo(this.aMS, this.aMT);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.gFo) {
            if (this.beL != null) {
                bf JY = com.baidu.live.guardclub.g.JW().JY();
                if (JY == null || JY.aNk <= 0) {
                    j = 1000;
                } else {
                    j = JY.aNk;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    vf(this.beL.id);
                } else if (this.gEU) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.beL));
                    this.activity.finish();
                }
            }
            if (!this.aIu) {
                if (TextUtils.isEmpty(this.gEO)) {
                    this.gEO = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aTN, this.gEO, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.mIsKeyboardOpen) {
                this.gFw.clearFocus();
                this.gFw.setText("");
                BdUtilHelper.hideSoftKeyPad(this.gEZ.getActivity(), this.gFw);
                return;
            }
            this.activity.finish();
        } else if (view == this.gFx) {
            String obj = this.gFw.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                i(this.beL.id, obj, "");
            }
        } else if (view == this.gFl.gIt) {
            this.gFw.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.gEZ.getActivity(), this.gFw);
        }
    }

    public void GP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gFl.aDP.setText(str);
            this.gFw.setText("");
            this.gFw.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.gEZ.getActivity(), this.gFw);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFc.getLayoutParams();
        if (z) {
            this.gFa.setVisibility(this.isFullScreen ? 0 : 8);
            this.gFb.setVisibility(0);
            String charSequence = this.gFl.aDP.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.gFw.setText(charSequence);
                this.gFw.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.gFw.setText("");
            }
            layoutParams.bottomMargin = bSt();
        } else {
            layoutParams.bottomMargin = 0;
            this.gFb.setVisibility(8);
            this.gFa.setVisibility(0);
        }
        this.gFc.setLayoutParams(layoutParams);
    }

    protected int bSt() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.gEZ.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.gEZ.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void vf(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.ew(i);
        cVar.a(this.beL);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void i(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.c cVar = new com.baidu.tieba.ala.guardclub.model.c();
        cVar.eG(i);
        cVar.GQ(str);
        cVar.GR(str2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }
}
