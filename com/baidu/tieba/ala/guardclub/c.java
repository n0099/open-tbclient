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
import com.baidu.live.data.z;
import com.baidu.live.k.a;
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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private long OF;
    private boolean PW;
    private String WX;
    private Activity activity;
    private com.baidu.live.e.b acu;
    private TextView dLA;
    private LinearLayout dLB;
    private FrameLayout dLC;
    private RelativeLayout dLD;
    private ImageView dLE;
    private h dLF;
    private String dLG;
    private Bitmap dLH;
    private Bitmap dLI;
    private boolean dLJ;
    private String dLK;
    private EditText dLL;
    private TextView dLM;
    private TextView dLN;
    private CommonEmptyView dLO;
    private LinearLayout dLP;
    private LinearLayout dLQ;
    private ViewTreeObserver.OnGlobalLayoutListener dLS;
    private int dLT;
    private boolean dLc;
    private com.baidu.tieba.ala.guardclub.model.c dLd;
    private View.OnClickListener dLf;
    private GuardClubInfoActivity dLk;
    private View dLl;
    private View dLm;
    private View dLn;
    private View dLo;
    private View dLp;
    private int dLq;
    private int dLr;
    private View dLs;
    private LinearLayout dLt;
    private RelativeLayout dLu;
    private ImageView dLv;
    private ImageView dLw;
    private GuardClubInfoHeaderView dLx;
    private RelativeLayout dLy;
    private RelativeLayout dLz;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;
    private boolean dLR = true;
    private boolean YX = false;

    public c(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, View.OnClickListener onClickListener) {
        this.dLk = guardClubInfoActivity;
        this.activity = guardClubInfoActivity.getPageContext().getPageActivity();
        this.OF = j;
        this.liveId = j2;
        this.roomId = j3;
        this.WX = str;
        this.PW = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.dLJ = z3;
        this.dLc = z4;
        this.dLK = str3;
        this.isTranslucent = z5;
        this.dLf = onClickListener;
        if (!z3) {
            if (this.acu == null) {
                this.acu = new com.baidu.live.e.b();
            }
            this.acu.initListener();
            this.acu.refreshCurUserScores();
        }
        this.dLq = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary);
        this.dLr = guardClubInfoActivity.getResources().getColor(a.d.live_gcb_primary_alpha90);
        initView();
        initListener();
    }

    private void initListener() {
        this.dLS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.guardclub.c.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                c.this.dLk.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(c.this.dLk.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(c.this.dLk.getPageContext().getPageActivity());
                if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !c.this.YX && c.this.dLR) {
                    c.this.YX = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    c.this.onKeyboardVisibilityChanged(true);
                } else if (screenFullSize[1] - rect.height() <= statusBarHeight && c.this.YX) {
                    c.this.YX = false;
                    c.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dLk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLS);
    }

    public void pZ() {
        boolean z = UtilHelper.getRealScreenOrientation(this.activity) == 2;
        if (this.mRootView != null) {
            if (z) {
                com.baidu.live.utils.g.P(this.mRootView);
                q.d(this.activity, false);
            } else {
                com.baidu.live.utils.g.Q(this.mRootView);
                q.d(this.activity, true);
            }
        }
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.activity);
        int min = z ? Math.min(screenDimensions[0], screenDimensions[1]) : -1;
        if (this.dLt != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dLt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = min;
            this.dLt.setLayoutParams(layoutParams);
        }
        if (this.dLn != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dLn.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams2.width = min;
            this.dLn.setLayoutParams(layoutParams2);
        }
        if (this.dLl != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            ViewGroup.LayoutParams layoutParams3 = this.dLl.getLayoutParams();
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
                gradientDrawable.setColor(this.dLq);
            } else {
                gradientDrawable.setColor(this.dLr);
            }
            this.dLl.setBackgroundDrawable(gradientDrawable);
        }
        if (this.dLw != null) {
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.dLw.setImageBitmap(this.dLI);
            } else {
                this.dLw.setImageBitmap(this.dLH);
            }
        }
        if (this.dLF != null) {
            this.dLF.pZ();
        }
    }

    private void initView() {
        String str;
        this.mRootView = LayoutInflater.from(this.activity).inflate(a.h.view_guardclub_info, (ViewGroup) null);
        aLj();
        pZ();
        this.dLs.setOnClickListener(this);
        WindowManager windowManager = (WindowManager) this.activity.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.dLT = displayMetrics.heightPixels;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.isFullScreen) {
            this.dLs.setVisibility(8);
            this.dLv.setVisibility(0);
            this.dLE.setVisibility(0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(this.activity);
                ((LinearLayout.LayoutParams) this.dLv.getLayoutParams()).topMargin = statusBarHeight;
                ((RelativeLayout.LayoutParams) this.dLE.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.dLw.setImageResource(a.f.gcb_bg_info_top);
            gradientDrawable.setColor(this.dLq);
        } else {
            this.dLs.setVisibility(0);
            this.dLv.setVisibility(8);
            this.dLE.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.dLl.getLayoutParams();
            float dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (UtilHelper.getRealScreenOrientation(this.dLk.getPageContext().getPageActivity()) == 1) {
                layoutParams.height = this.activity.getResources().getDimensionPixelOffset(a.e.sdk_ds854);
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            } else {
                layoutParams.height = -2;
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            }
            if (this.isTranslucent) {
                gradientDrawable.setColor(this.dLq);
            } else {
                gradientDrawable.setColor(this.dLr);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLQ.getLayoutParams();
            layoutParams2.addRule(8, a.g.notJoin_layout);
            this.dLQ.setLayoutParams(layoutParams2);
        }
        this.dLl.setBackgroundDrawable(gradientDrawable);
        if (this.PW) {
            hc(false);
        } else {
            hc(this.dLJ);
        }
        if (this.dLc) {
            this.dLx.dPE.setVisibility(8);
        }
        z aLz = m.aLx().aLz();
        if (aLz != null && aLz.TF > 0) {
            this.dLA.setText(aLz.TF + "T豆加入");
        } else {
            this.dLA.setText("1000T豆加入");
        }
        this.dLv.setOnClickListener(this);
        this.dLx.dPB.setOnClickListener(this);
        this.dLA.setOnClickListener(this);
        this.dLE.setOnClickListener(this);
        this.dLx.dPx.setOnClickListener(this);
        this.dLx.dPE.setOnClickListener(this);
        this.dLx.dPw.setOnClickListener(this);
        this.dLM.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.dLx.dPu.setIsRound(true);
        this.dLx.dPu.setDrawBorder(false);
        this.dLx.dPu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dLx.dPu.setAutoChangeStyle(false);
        this.dLx.dPu.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dLx.dPv.setDefaultBgResource(a.f.sdk_transparent_bg);
        if (!this.PW) {
            if (this.dLJ) {
                str = "guard";
            } else {
                str = "no_guard";
            }
            LogManager.getGuardClubLogger().doDisplayLiveGuardLog(this.liveId + "", this.roomId + "", this.WX, str, this.otherParams);
        }
        this.dLL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.guardclub.c.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                c.this.tI();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        if (this.dLM != null) {
            if (TextUtils.isEmpty(this.dLL.getText())) {
                this.dLM.setEnabled(false);
                this.dLp.setVisibility(0);
                this.dLN.setText(String.valueOf(0));
            } else {
                this.dLM.setEnabled(true);
                this.dLp.setVisibility(8);
                this.dLN.setText(String.valueOf(this.dLL.getText().length()));
            }
        }
        if (this.dLL.getText().length() > 10) {
            BdUtilHelper.showToast(this.activity, String.format(this.activity.getResources().getString(a.i.sdk_send_im_over_max), 10));
            this.dLL.setText(this.dLL.getText().subSequence(0, 10));
            this.dLL.setSelection(this.dLL.getText().length());
        }
    }

    private void aLj() {
        this.dLt = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_club_info);
        this.dLs = this.mRootView.findViewById(a.g.space_view);
        this.dLl = this.mRootView.findViewById(a.g.layout_guard_info);
        this.dLm = this.mRootView.findViewById(a.g.info_layout);
        this.dLL = (EditText) this.mRootView.findViewById(a.g.edit_guard_rename);
        this.dLn = this.mRootView.findViewById(a.g.input_name_layout);
        this.dLo = this.mRootView.findViewById(a.g.input_name);
        this.dLp = this.mRootView.findViewById(a.g.mask_send);
        this.dLM = (TextView) this.mRootView.findViewById(a.g.tv_send);
        this.dLN = (TextView) this.mRootView.findViewById(a.g.tv_input_name_length);
        this.dLu = (RelativeLayout) this.mRootView.findViewById(a.g.info_layout);
        this.dLv = (ImageView) this.mRootView.findViewById(a.g.back_imageView);
        this.dLw = (ImageView) this.mRootView.findViewById(a.g.infoHeadBg_imageView);
        this.dLx = (GuardClubInfoHeaderView) this.mRootView.findViewById(a.g.infoHeadInner_layout);
        this.dLy = (RelativeLayout) this.mRootView.findViewById(a.g.memberInfo_layout);
        this.dLz = (RelativeLayout) this.mRootView.findViewById(a.g.notJoin_layout);
        this.dLA = (TextView) this.mRootView.findViewById(a.g.toJoin_textView);
        this.dLB = (LinearLayout) this.mRootView.findViewById(a.g.privilege_layout);
        this.dLC = (FrameLayout) this.mRootView.findViewById(a.g.memberList_layout);
        this.dLD = (RelativeLayout) this.mRootView.findViewById(a.g.noData_layout);
        this.dLO = (CommonEmptyView) this.mRootView.findViewById(a.g.noData_view);
        this.dLE = (ImageView) this.mRootView.findViewById(a.g.back2_imageView);
        this.dLP = (LinearLayout) this.mRootView.findViewById(a.g.joinPrivilegeIcons_layout);
        this.dLQ = (LinearLayout) this.mRootView.findViewById(a.g.hasJoin_layout);
    }

    private void hc(boolean z) {
        Resources resources = this.mRootView.getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLw.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (this.isFullScreen) {
            if (z || this.PW) {
                this.dLw.setImageResource(a.f.gcb_bg_info_top);
                layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds266);
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.removeRule(8);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(this.dLq);
                this.dLw.setImageDrawable(gradientDrawable);
                layoutParams.height = -1;
                layoutParams.addRule(8, a.g.infoHead_layout);
            }
        } else if (z || this.PW) {
            if (this.dLH == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.dLH = com.baidu.live.utils.k.b(decodeResource, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 3);
                if (decodeResource != this.dLH) {
                    decodeResource.recycle();
                }
            }
            if (this.dLI == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(this.activity.getResources(), a.f.gcb_bg_info_top);
                this.dLI = com.baidu.live.utils.k.b(decodeResource2, this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds26), 1);
                if (decodeResource2 != this.dLI) {
                    decodeResource2.recycle();
                }
            }
            if (UtilHelper.getRealScreenOrientation(this.activity) == 2) {
                this.dLw.setImageBitmap(this.dLI);
            } else {
                this.dLw.setImageBitmap(this.dLH);
            }
            layoutParams.height = resources.getDimensionPixelOffset(a.e.sdk_ds176);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(8);
            }
        } else {
            this.dLw.setImageDrawable(new ColorDrawable(0));
            layoutParams.height = -1;
            layoutParams.addRule(8, a.g.infoHead_layout);
        }
        this.dLw.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLx.getLayoutParams();
        if (z || this.PW) {
            this.dLx.setStyle(1);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams2.bottomMargin = 0;
            this.dLz.setVisibility(8);
            this.dLQ.setVisibility(0);
            this.dLA.setVisibility(8);
        } else {
            this.dLx.setStyle(0);
            layoutParams2.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams2.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams2.bottomMargin = 0;
            this.dLz.setVisibility(0);
            this.dLQ.setVisibility(8);
            this.dLA.setVisibility(0);
        }
        this.dLx.setLayoutParams(layoutParams2);
    }

    public void a(com.baidu.tieba.ala.guardclub.model.c cVar, String str, String[] strArr, boolean z, com.baidu.tieba.ala.guardclub.model.j[] jVarArr) {
        String str2;
        int i;
        View view;
        TbImageView tbImageView;
        TextView textView;
        this.dLd = cVar;
        this.dLG = str;
        if (cVar == null || cVar.id <= 0) {
            this.dLu.setVisibility(8);
            this.dLy.setVisibility(8);
            this.dLO.reset();
            this.dLO.setTitle(a.i.guard_club_no_create);
            this.dLO.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.dLD.setVisibility(0);
            return;
        }
        this.dLu.setVisibility(0);
        this.dLy.setVisibility(0);
        this.dLD.setVisibility(8);
        hc(z);
        this.dLx.dPu.startLoad(cVar.dOe, 12, false);
        this.dLx.dPv.startLoad(m.aLx().mN(cVar.dOc), 10, false);
        boolean z2 = false;
        if (this.PW && cVar.dOg != null) {
            z2 = cVar.dOg.optInt("can_update_name", 0) == 1;
        }
        int width = this.dLx.dMg.getWidth();
        if (width <= 0) {
            this.dLx.dMg.measure(0, 0);
            width = this.dLx.dMg.getMeasuredWidth();
        }
        String str3 = cVar.dNX;
        int i2 = 0;
        if (z2) {
            this.dLx.dPw.setVisibility(0);
            i2 = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds36);
        } else {
            this.dLx.dPw.setVisibility(8);
        }
        if (str3 != null && str3.endsWith("的真爱团")) {
            str2 = str3.substring(0, str3.lastIndexOf("的真爱团"));
            this.dLx.dMf.setPadding(0, 0, width + i2, 0);
            this.dLx.dMg.setPadding(0, 0, i2, 0);
            this.dLx.dMg.setVisibility(0);
        } else {
            this.dLx.dMf.setPadding(0, 0, i2, 0);
            this.dLx.dMg.setPadding(0, 0, i2, 0);
            this.dLx.dMg.setVisibility(4);
            str2 = str3;
        }
        this.dLx.dMf.setText(str2);
        String mP = m.aLx().mP(cVar.dOc);
        String str4 = (mP == null || "null".equals(mP)) ? "" : mP;
        Resources resources = this.dLx.getResources();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLx.getLayoutParams();
        if (z || this.PW) {
            this.dLx.setStyle(1);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds4);
            layoutParams.bottomMargin = 0;
            String str5 = "总真爱值 " + cVar.dNZ;
            if (cVar.dOd > 0) {
                str5 = str5 + " / " + cVar.dOd;
            }
            this.dLx.dPy.setText(str5);
            this.dLx.dPA.setText(Html.fromHtml("<font color='#CDFFFFFF'>" + str4 + "</font>"));
            this.dLz.setVisibility(8);
            this.dLQ.setVisibility(0);
            this.dLA.setVisibility(8);
            hd(this.dLc);
        } else {
            this.dLx.setStyle(0);
            layoutParams.leftMargin = resources.getDimensionPixelOffset(a.e.sdk_ds12);
            layoutParams.topMargin = resources.getDimensionPixelOffset(a.e.sdk_ds8);
            layoutParams.rightMargin = resources.getDimensionPixelOffset(a.e.sdk_ds32);
            layoutParams.bottomMargin = 0;
            String str6 = "总真爱值 " + cVar.dNZ;
            if (cVar.dOd > 0) {
                str6 = str6 + " / " + cVar.dOd;
            }
            this.dLx.dPy.setText(str6);
            this.dLx.dPA.setText(Html.fromHtml("<font color='#9AFFFFFF'>" + str4 + "</font>"));
            this.dLz.setVisibility(0);
            this.dLQ.setVisibility(8);
            this.dLA.setVisibility(0);
            if (jVarArr != null) {
                this.dLB.setVisibility(0);
                this.dLP.removeAllViews();
                int i3 = 0;
                View view2 = null;
                while (i3 < jVarArr.length) {
                    if (i3 % 4 == 0) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
                        layoutParams2.weight = 1.0f;
                        view = this.activity.getLayoutInflater().inflate(a.h.layout_guardclub_join_privilege_row, (ViewGroup) null);
                        this.dLP.addView(view, layoutParams2);
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
                        tbImageView.startLoad(jVar.dOF, 10, false);
                        textView.setText(jVar.dOG + "");
                    }
                    i3++;
                    view2 = view;
                }
            } else {
                this.dLB.setVisibility(8);
            }
        }
        this.dLx.setLayoutParams(layoutParams);
        if (cVar.dNZ == cVar.dOd) {
            i = 100;
        } else if (cVar.dNZ <= 0) {
            i = 0;
        } else if (cVar.dOd <= 0) {
            i = 100;
        } else if (cVar.dNZ >= cVar.dOd) {
            i = 100;
        } else {
            try {
                i = (int) ((cVar.dNZ * 100) / cVar.dOd);
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
        this.dLx.dPz.setProgress(i);
        this.dLx.dPD.setText(cVar.dOb < 10000 ? cVar.dOb + "" : String.format("%.1f", Float.valueOf(((float) cVar.dOb) / 10000.0f)) + "万");
        String str7 = cVar.dOf;
        this.dLx.dNH.setText((str7 == null || TextUtils.equals(str7, "null")) ? "" : "");
    }

    public void aLk() {
        this.dLu.setVisibility(8);
        this.dLy.setVisibility(8);
        this.dLO.reset();
        this.dLO.setTitle(a.i.sdk_net_fail_tip_rank);
        this.dLO.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.dLf != null) {
                    c.this.dLf.onClick(view);
                }
            }
        });
        this.dLO.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.dLD.setVisibility(0);
    }

    public void hd(boolean z) {
        this.dLF = new h(this.dLk, this.liveId, this.roomId, this.OF, this.PW, true, false, this.isFullScreen, this.otherParams, this.dLk.getUniqueId(), null);
        this.dLF.he(z);
        View view = this.dLF.getView();
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dLC.removeAllViews();
            this.dLC.addView(view, layoutParams);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void onDestory() {
        if (this.acu != null) {
            this.acu.onDestroy();
        }
        if (this.dLH != null) {
            this.dLH.recycle();
        }
        if (this.dLI != null) {
            this.dLI.recycle();
        }
        this.dLk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        String str;
        if (view == this.dLs || view == this.dLv || view == this.dLE) {
            this.activity.finish();
        } else if (view == this.dLx.dPx) {
            if (!TextUtils.isEmpty(this.dLG)) {
                BrowserHelper.startInternalWebActivity(this.activity, this.dLG);
            }
            if (!this.PW) {
                if (this.dLJ) {
                    str = "guard";
                } else {
                    str = "no_guard";
                }
                LogManager.getGuardClubLogger().doClickLiveRuleLog(this.liveId + "", this.roomId + "", this.WX, str, this.otherParams);
            }
        } else if (view == this.dLx.dPB) {
            GuardClubMemberListActivityConfig guardClubMemberListActivityConfig = new GuardClubMemberListActivityConfig(this.activity, this.OF, this.liveId, this.PW, this.otherParams);
            guardClubMemberListActivityConfig.setRoomId(this.roomId);
            guardClubMemberListActivityConfig.setFeedId(this.WX);
            guardClubMemberListActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST);
            guardClubMemberListActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubMemberListActivityConfig));
        } else if (view == this.dLx.dPE) {
            GuardClubRankActivityConfig guardClubRankActivityConfig = new GuardClubRankActivityConfig(this.activity, this.OF, this.liveId, this.PW, this.otherParams);
            guardClubRankActivityConfig.setRoomId(this.roomId);
            guardClubRankActivityConfig.setFeedId(this.WX);
            guardClubRankActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_RANK);
            guardClubRankActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubRankActivityConfig));
        } else if (view == this.dLA) {
            if (this.dLd != null) {
                z aLz = m.aLx().aLz();
                if (aLz == null || aLz.TF <= 0) {
                    j = 1000;
                } else {
                    j = aLz.TF;
                }
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
                    mH(this.dLd.id);
                } else if (this.dLc) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.activity, 0L, this.otherParams, true, "", true)));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913105, this.dLd));
                    this.activity.finish();
                }
            }
            if (!this.PW) {
                if (TextUtils.isEmpty(this.dLK)) {
                    this.dLK = "guard";
                }
                LogManager.getGuardClubLogger().doClickLiveGuardJoinLog(this.liveId + "", this.roomId + "", this.WX, this.dLK, this.otherParams);
            }
        } else if (view == this.mRootView) {
            if (this.YX) {
                this.dLL.clearFocus();
                this.dLL.setText("");
                BdUtilHelper.hideSoftKeyPad(this.dLk.getActivity(), this.dLL);
                return;
            }
            this.activity.finish();
        } else if (view == this.dLM) {
            String obj = this.dLL.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                h(this.dLd.id, obj, "");
            }
        } else if (view == this.dLx.dPw) {
            this.dLL.requestFocus();
            BdUtilHelper.showSoftKeyPad(this.dLk.getActivity(), this.dLL);
        }
    }

    public void tj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dLx.dMf.setText(str);
            this.dLL.setText("");
            this.dLL.clearFocus();
            BdUtilHelper.hideSoftKeyPad(this.dLk.getActivity(), this.dLL);
        }
    }

    protected void onKeyboardVisibilityChanged(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLo.getLayoutParams();
        if (z) {
            this.dLl.setVisibility(this.isFullScreen ? 0 : 8);
            this.dLn.setVisibility(0);
            String charSequence = this.dLx.dMf.getText().toString();
            if (!TextUtils.isEmpty(charSequence)) {
                this.dLL.setText(charSequence);
                this.dLL.setSelection(charSequence.length() > 10 ? 10 : charSequence.length());
            } else {
                this.dLL.setText("");
            }
            layoutParams.bottomMargin = aLl();
        } else {
            layoutParams.bottomMargin = 0;
            this.dLn.setVisibility(8);
            this.dLl.setVisibility(0);
        }
        this.dLo.setLayoutParams(layoutParams);
    }

    protected int aLl() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        int i = ViewCommonUtil.getScreenFullSize(this.dLk.getPageContext().getPageActivity())[1] - rect.bottom;
        int i2 = 0;
        if (MenuKeyUtils.hasSmartBar()) {
            i2 = BdUtilHelper.dip2px(this.dLk.getPageContext().getPageActivity(), 48.0f);
        }
        return i - i2;
    }

    public void mH(int i) {
        com.baidu.tieba.ala.guardclub.model.f fVar = new com.baidu.tieba.ala.guardclub.model.f();
        fVar.mQ(i);
        fVar.a(this.dLd);
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void h(int i, String str, String str2) {
        com.baidu.tieba.ala.guardclub.model.e eVar = new com.baidu.tieba.ala.guardclub.model.e();
        eVar.cb(i);
        eVar.tl(str);
        eVar.tm(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
