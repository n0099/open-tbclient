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
import com.baidu.live.data.ac;
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    private long Vc;
    private boolean Wm;
    private Activity activity;
    private String aej;
    private com.baidu.live.i.c ajY;
    private int bZc;
    private ViewTreeObserver.OnGlobalLayoutListener eeg;
    private boolean eyB;
    private com.baidu.tieba.ala.guardclub.model.c eyC;
    private View.OnClickListener eyE;
    private GuardClubInfoActivity eyJ;
    private View eyK;
    private View eyL;
    private View eyM;
    private View eyN;
    private int eyO;
    private int eyP;
    private View eyQ;
    private LinearLayout eyR;
    private RelativeLayout eyS;
    private ImageView eyT;
    private ImageView eyU;
    private LinearLayout eyV;
    private GuardClubInfoHeaderView eyW;
    private RelativeLayout eyX;
    private RelativeLayout eyY;
    private TextView eyZ;
    private LinearLayout eza;
    private FrameLayout ezb;
    private RelativeLayout ezc;
    private ImageView ezd;
    private h eze;
    private String ezf;
    private Bitmap ezg;
    private Bitmap ezh;
    private boolean ezi;
    private String ezj;
    private EditText ezk;
    private TextView ezl;
    private TextView ezm;
    private CommonEmptyView ezn;
    private LinearLayout ezo;
    private LinearLayout ezp;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean eef = true;
    private boolean agD = false;

    public c(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.eyJ = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.Vc = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aej = str;
        this.Wm = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.ezi = z3;
        this.eyB = z4;
        this.ezj = str3;
        this.isTranslucent = z5;
        this.eyE = onClickListener;
        if (!z3) {
            if (this.ajY == null) {
                this.ajY = new com.baidu.live.i.c();
            }
            this.ajY.initListener();
            this.ajY.refreshCurUserScores();
        }
        this.eyO = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.eyP = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.eeg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.c.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                c.this.eyJ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(c.this.eyJ.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(c.this.eyJ.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !c.this.agD && c.this.eef) {
                    c.this.agD = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    c.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.agD) {
                    c.this.agD = false;
                    c.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.eyJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeg);
    }

    public void rC() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.h.Q(this.mRootView);
                q.d(this.activity, false);
            } else {
                com.baidu.live.utils.h.R(this.mRootView);
                q.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.eyR != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eyR.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.eyR.setLayoutParams(layoutParams);
        }
        if (this.eyM != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eyM.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.eyM.setLayoutParams(layoutParams2);
        }
        if (this.eyK != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.eyK.getLayoutParams();
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
                gradientDrawable.setColor(this.eyO);
            } else {
                gradientDrawable.setColor(this.eyP);
            }
            this.eyK.setBackgroundDrawable(gradientDrawable);
        }
        if (this.eyU != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eyU.setImageBitmap(this.ezh);
            } else {
                this.eyU.setImageBitmap(this.ezg);
            }
        }
        if (this.eze != null) {
            this.eze.rC();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        bbc();
        rC();
        this.eyQ.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.bZc = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.eyQ.setVisibility(8);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eyT.setVisibility(0);
                this.ezd.setVisibility(0);
            } else {
                this.eyT.setVisibility(8);
                this.ezd.setVisibility(8);
            }
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    ((RelativeLayout.LayoutParams) this.eyV.getLayoutParams()).topMargin = statusBarHeight;
                } else {
                    ((LinearLayout.LayoutParams) this.eyT.getLayoutParams()).topMargin = statusBarHeight;
                }
                ((RelativeLayout.LayoutParams) this.ezd.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.eyU.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.eyO);
        } else {
            this.eyQ.setVisibility(0);
            this.eyT.setVisibility(8);
            this.ezd.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.eyK.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.eyJ.getPageContext().getPageActivity()) != 2) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.eyO);
            } else {
                gradientDrawable.setColor(this.eyP);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ezp.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.ezp.setLayoutParams(layoutParams2);
        }
        this.eyK.setBackgroundDrawable(gradientDrawable);
        if (this.Wm) {
            ij(false);
        } else {
            ij(this.ezi);
        }
        if (this.eyB) {
            this.eyW.eCT.setVisibility(8);
        }
        ac bcG = l.bcE().bcG();
        if (bcG != null && bcG.aab > 0) {
            this.eyZ.setText(bcG.aab + "T豆加入");
        } else {
            this.eyZ.setText("1000T豆加入");
        }
        this.eyT.setOnClickListener(this);
        this.eyW.eCQ.setOnClickListener(this);
        this.eyZ.setOnClickListener(this);
        this.ezd.setOnClickListener(this);
        this.eyW.eCM.setOnClickListener(this);
        this.eyW.eCT.setOnClickListener(this);
        this.eyW.eCL.setOnClickListener(this);
        this.ezl.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eyW.eCJ.setIsRound(true);
        this.eyW.eCJ.setDrawBorder(false);
        this.eyW.eCJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eyW.eCJ.setAutoChangeStyle(false);
        this.eyW.eCJ.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eyW.eCK.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.Wm) {
            if (this.ezi) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.aej, str, this.otherParams);
        }
        this.ezk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                c.this.vE();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE() {
        if (this.ezl != null) {
            if (TextUtils.isEmpty(this.ezk.getText())) {
                this.ezl.setEnabled(false);
                this.ezm.setText(String.valueOf(0));
            } else {
                this.ezl.setEnabled(true);
                this.ezm.setText(String.valueOf(this.ezk.getText().length()));
            }
        }
        if (this.ezk.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.ezk.setText(this.ezk.getText().subSequence(0, 10));
            this.ezk.setSelection(this.ezk.getText().length());
        }
    }

    private void bbc() {
        this.eyR = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.eyQ = this.mRootView.findViewById(a.g.space_view);
        this.eyK = this.mRootView.findViewById(a.g.layout_guard_info);
        this.eyL = this.mRootView.findViewById(a.g.info_layout);
        this.ezk = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.eyM = this.mRootView.findViewById(a.g.input_name_layout);
        this.eyN = this.mRootView.findViewById(a.g.input_name);
        this.ezl = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.ezm = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.eyS = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.eyT = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.eyU = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.eyV = (LinearLayout) this.mRootView.findViewById(a.g.infoHead_layout);
        this.eyW = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.eyX = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.eyY = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.eyZ = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.eza = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.ezb = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.ezc = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.ezn = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.ezd = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.ezo = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.ezp = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void ij(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyU.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.Wm) {
                this.eyU.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.eyO);
                this.eyU.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.Wm) {
            if (this.ezg == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.ezg = com.baidu.live.utils.l.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.ezg) {
                    decodeResource.recycle();
                }
            }
            if (this.ezh == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.ezh = com.baidu.live.utils.l.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.ezh) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.eyU.setImageBitmap(this.ezh);
            } else {
                this.eyU.setImageBitmap(this.ezg);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.eyU.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.eyU.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eyW.getLayoutParams();
        if (z || this.Wm) {
            this.eyW.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.eyY.setVisibility(8);
            this.ezp.setVisibility(0);
            this.eyZ.setVisibility(8);
        } else {
            this.eyW.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.eyY.setVisibility(0);
            this.ezp.setVisibility(8);
            this.eyZ.setVisibility(0);
        }
        this.eyW.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, String str, String[] strArr, boolean z, com.baidu.tieba.ala.guardclub.model.j[] jVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.eyC = cVar;
        this.ezf = str;
        if (cVar == null || cVar.id <= 0) {
            this.eyS.setVisibility(8);
            this.eyX.setVisibility(8);
            this.ezn.reset();
            this.ezn.setTitle(a.i.guard_club_no_create);
            this.ezn.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.ezc.setVisibility(0);
            return;
        }
        this.eyS.setVisibility(0);
        this.eyX.setVisibility(0);
        this.ezc.setVisibility(8);
        ij(z);
        this.eyW.eCJ.startLoad(cVar.eBv, 12, false);
        this.eyW.eCK.startLoad(l.bcE().pc(cVar.eBt), 10, false);
        boolean z2 = false;
        if (this.Wm && cVar.eBx != null) {
            z2 = cVar.eBx.optInt("can_update_name", 0) == 1;
        }
        int width = this.eyW.ezB.getWidth();
        if (width <= 0) {
            this.eyW.ezB.measure(0, 0);
            width = this.eyW.ezB.getMeasuredWidth();
        }
        String str3 = cVar.eBo;
        int i2 = 0;
        if (z2) {
            this.eyW.eCL.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.eyW.eCL.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.eyW.aqC.setPadding(0, 0, width + i2, 0);
            this.eyW.ezB.setPadding(0, 0, i2, 0);
            this.eyW.ezB.setVisibility(0);
        } else {
            this.eyW.aqC.setPadding(0, 0, i2, 0);
            this.eyW.ezB.setPadding(0, 0, i2, 0);
            this.eyW.ezB.setVisibility(4);
            str2 = str3;
        }
        this.eyW.aqC.setText(str2);
        String pe = l.bcE().pe(cVar.eBt);
        String str4 = (pe == null || "null".equals(pe)) ? "" : pe;
        Resources resources = this.eyW.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eyW.getLayoutParams();
        if (z || this.Wm) {
            this.eyW.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + cVar.eBq;
            if (cVar.eBu > 0) {
                str5 = str5 + " / " + cVar.eBu;
            }
            this.eyW.eCN.setText(str5);
            this.eyW.eCP.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.eyY.setVisibility(8);
            this.ezp.setVisibility(0);
            this.eyZ.setVisibility(8);
            ik(this.eyB);
        } else {
            this.eyW.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + cVar.eBq;
            if (cVar.eBu > 0) {
                str6 = str6 + " / " + cVar.eBu;
            }
            this.eyW.eCN.setText(str6);
            this.eyW.eCP.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.eyY.setVisibility(0);
            this.ezp.setVisibility(8);
            this.eyZ.setVisibility(0);
            if (jVarArr != null) {
                this.eza.setVisibility(0);
                this.ezo.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < jVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.ezo.addView(view, layoutParams2);
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
                        tbImageView.startLoad(jVar.eBV, 10, false);
                        textView.setText(jVar.eBW + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.eza.setVisibility(8);
            }
        }
        this.eyW.setLayoutParams(layoutParams);
        if (cVar.eBq == cVar.eBu) {
            i = 100;
        } else if (cVar.eBq <= 0) {
            i = 0;
        } else if (cVar.eBu <= 0) {
            i = 100;
        } else if (cVar.eBq >= cVar.eBu) {
            i = 100;
        } else {
            try {
                i = (int) ((cVar.eBq * 100) / cVar.eBu);
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
        this.eyW.eCO.setProgress(i);
        this.eyW.eCS.setText(cVar.eBs < 10000 ? cVar.eBs + "" : String.format("%.1f", Float.valueOf(((float) cVar.eBs) / 10000.0f)) + "万");
        String str7 = cVar.eBw;
        this.eyW.eAY.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void bcs() {
        this.eyS.setVisibility(8);
        this.eyX.setVisibility(8);
        this.ezn.reset();
        this.ezn.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ezn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eyE != null) {
                    c.this.eyE.onClick(view);
                }
            }
        });
        this.ezn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ezc.setVisibility(0);
    }

    public void ik(boolean z) {
        this.eze = new h(this.eyJ, this.liveId, this.roomId, this.Vc, this.Wm, true, false, this.isFullScreen, this.otherParams, this.eyJ.getUniqueId(), null);
        this.eze.il(z);
        View view = this.eze.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.ezb.removeAllViews();
            this.ezb.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.ajY != null) {
            this.ajY.onDestroy();
        }
        if (this.ezg != null) {
            this.ezg.recycle();
        }
        if (this.ezh != null) {
            this.ezh.recycle();
        }
        this.eyJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.eyQ || view == this.eyT || view == this.ezd) {
            this.activity.finish();
        } else if (view == this.eyW.eCM) {
            if (!TextUtils.isEmpty(this.ezf)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.ezf);
            }
            if (!this.Wm) {
                if (this.ezi) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.aej, str, this.otherParams);
            }
        } else if (view == this.eyW.eCQ) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.Vc, this.liveId, this.Wm, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.aej);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.eyW.eCT) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.Vc, this.liveId, this.Wm, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.aej);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.eyZ) {
            if (this.eyC != null) {
                ac bcG = l.bcE().bcG();
                if (bcG == null || bcG.aab <= 0) {
                    j = 1000;
                } else {
                    j = bcG.aab;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    oW(this.eyC.id);
                } else if (this.eyB) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.eyC));
                    this.activity.finish();
                }
            }
            if (!this.Wm) {
                if (TextUtils.isEmpty(this.ezj)) {
                    this.ezj = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.aej, this.ezj, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.agD) {
                this.ezk.clearFocus();
                this.ezk.setText("");
                BdUtilHelper.hideSoftKeyPad(this.eyJ.getActivity(), this.ezk);
                return;
            }
            this.activity.finish();
        } else if (view == this.ezl) {
            String obj = this.ezk.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                f(this.eyC.id, obj, "");
            }
        } else if (view == this.eyW.eCL) {
            this.ezk.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.eyJ.getActivity(), this.ezk);
        }
    }

    public void xU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eyW.aqC.setText(str);
            this.ezk.setText("");
            this.ezk.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.eyJ.getActivity(), this.ezk);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eyN.getLayoutParams();
        if (z) {
            this.eyK.setVisibility(this.isFullScreen ? 0 : 8);
            this.eyM.setVisibility(0);
            String charSequence = this.eyW.aqC.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.ezk.setText(charSequence);
                this.ezk.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.ezk.setText("");
            }
            layoutParams.bottomMargin = bct();
        } else {
            layoutParams.bottomMargin = 0;
            this.eyM.setVisibility(8);
            this.eyK.setVisibility(0);
        }
        this.eyN.setLayoutParams(layoutParams);
    }

    protected int bct() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.eyJ.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.eyJ.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void oW(int i) {
        com.baidu.tieba.ala.guardclub.model.f fVar = new com.baidu.tieba.ala.guardclub.model.f();
        fVar.pf(i);
        fVar.a(this.eyC);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void f(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.e eVar = new com.baidu.tieba.ala.guardclub.model.e();
        eVar.cF(i);
        eVar.xW(str);
        eVar.xX(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
