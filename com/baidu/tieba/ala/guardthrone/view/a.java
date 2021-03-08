package com.baidu.tieba.ala.guardthrone.view;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ao;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private String aOA;
    private String bwh;
    private long bxB;
    private LinearLayout gBi;
    private ImageView grC;
    private com.baidu.tieba.ala.guardthrone.b.a heR;
    private View heY;
    private FrameLayout heZ;
    private View hfa;
    private View hfb;
    private HeadImageView hfc;
    private TbImageView hfd;
    private TextView hfe;
    private TextView hff;
    private ListView hfg;
    private ScrollView hfh;
    private HListView hfi;
    private RelativeLayout hfj;
    private TextView hfk;
    private TextView hfl;
    private com.baidu.tieba.ala.guardthrone.d.a hfm;
    private a.InterfaceC0650a hfn;
    private b hfo;
    private com.baidu.tieba.ala.guardthrone.adapter.a hfp;
    private Animation hfq;
    private boolean hfr;
    private long hfs;
    private long hft;
    private long hfu;
    private long hfv;
    private boolean hfw;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bxE = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfm != null) {
                a.this.hfm.er(a.this.mLiveId, a.this.bwh);
            }
        }
    };
    private final Runnable hfx = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfs <= 0) {
                a.this.hfs = 0L;
                a.this.bWK();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.hfs <= 0 || a.this.hff == null || a.this.heR == null || a.this.heR.heC == null || TextUtils.isEmpty(a.this.heR.heC.heG)) {
                if (a.this.hff != null && a.this.hff.getVisibility() == 0) {
                    a.this.hff.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.heR.heC.heG + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hfs));
            if (a.this.hff.getVisibility() != 0) {
                a.this.hff.setVisibility(0);
            }
            a.this.hff.setText(str);
        }
    };
    private final Runnable hfy = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfv <= 0) {
                a.this.hfv = 0L;
                a.this.bWM();
            } else {
                a.i(a.this);
                a.this.bWL();
            }
            if (a.this.hfv >= 0 && a.this.hff != null && a.this.heR != null && a.this.heR.heC != null && !TextUtils.isEmpty(a.this.heR.heC.heG)) {
                a.this.hff.setText(a.this.heR.heC.heG + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hfv)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.hfs;
        aVar.hfs = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.hfv;
        aVar.hfv = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.hfr = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = ns(this.hfr);
        this.heY = this.mRootView.findViewById(a.f.content_layout);
        this.heZ = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.hfa = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.hfb = this.mRootView.findViewById(a.f.view_foreground);
        this.grC = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.hfc = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.hfd = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.hfe = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.hff = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gBi = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.hfg = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.hfg.setDividerHeight(0);
        this.hfh = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.hfi = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.hfi.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.hfj = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.hfk = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.hfl = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bWC();
        bWD();
        bWE();
        bWF();
    }

    private void bWC() {
        this.hfc.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hfc.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hfc.setIsRound(true);
        this.hfc.setAutoChangeStyle(false);
        this.hfc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hfd.setDefaultResource(a.e.portrait_no_guard_bg);
        this.hfd.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bWD() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.hfb.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.hfb.setLayoutParams(layoutParams);
        }
    }

    private void bWE() {
        if (this.hfr) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hfa.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.hfa.setLayoutParams(layoutParams);
            this.hfj.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bWF() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfh.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.hfh.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.heY.setOnClickListener(this);
        this.heZ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.grC.setOnClickListener(this);
        this.hfl.setOnClickListener(this);
        this.hfj.setOnClickListener(this);
    }

    private void initModel() {
        bWG();
        this.hfm = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.hfn);
        this.hfm.er(this.mLiveId, this.bwh);
    }

    private void bWG() {
        this.hfn = new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0650a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0650a
            public void onFail(int i, String str) {
                a.this.bxB = 5L;
                a.this.bf(a.this.bxB);
                if (a.this.mActivity != null && !a.this.hfw) {
                    a.this.hfw = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void i(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bwh = str2;
        this.aOA = str3;
        this.mTabId = i;
        initModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.heC == null || aVar.heD == null || this.mActivity == null) {
            this.bxB = 5L;
            bf(this.bxB);
            return;
        }
        this.heR = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.heC.heF)) {
            this.hfd.startLoad(aVar.heC.heF, 10, false);
        }
        if (i == 1) {
            this.hfc.setVisibility(8);
        } else {
            String str = aVar.heC.heE;
            if (!TextUtils.isEmpty(str)) {
                this.hfc.setVisibility(0);
                this.hfc.startLoad(str, 12, false);
            } else {
                this.hfc.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.heC.heG)) {
                this.hfe.setVisibility(0);
                this.hfe.setText(aVar.heC.heG);
            } else {
                this.hfe.setVisibility(4);
            }
        } else {
            String str2 = aVar.heC.username;
            if (!TextUtils.isEmpty(str2)) {
                this.hfe.setVisibility(0);
                this.hfe.setText(str2);
            } else {
                this.hfe.setVisibility(8);
            }
        }
        if (i == 1) {
            this.hff.setVisibility(4);
        } else if (i == 2) {
            if (this.hft != aVar.heC.startTime || this.hfs > aVar.heC.countdown) {
                this.hft = aVar.heC.startTime;
                if (aVar.heC.countdown > 0) {
                    this.hfs = aVar.heC.countdown;
                    if (!TextUtils.isEmpty(aVar.heC.heG)) {
                        this.hff.setVisibility(0);
                        this.hff.setText(aVar.heC.heG + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hfs)));
                        if (this.mHandler != null && this.hfy != null) {
                            this.mHandler.removeCallbacks(this.hfy);
                        }
                        startCountDown();
                    }
                } else {
                    this.hff.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.hfu != aVar.heC.startTime || this.hfv != aVar.heC.heJ)) {
            this.hfu = aVar.heC.startTime;
            if (aVar.heC.heJ >= 0) {
                this.hfv = aVar.heC.heJ;
                if (!TextUtils.isEmpty(aVar.heC.heG)) {
                    this.hff.setVisibility(0);
                    this.hff.setText(aVar.heC.heG + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hfv)));
                    if (this.mHandler != null && this.hfx != null) {
                        this.mHandler.removeCallbacks(this.hfx);
                    }
                    bWL();
                }
            } else {
                this.hff.setVisibility(8);
            }
        }
        if (i == 2) {
            this.hfi.setVisibility(8);
        } else if (aVar.heC.heL != null && aVar.heC.heL.size() > 0) {
            if (this.hfp == null) {
                this.hfp = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.hfi.setAdapter((ListAdapter) this.hfp);
            }
            this.hfp.setList(aVar.heC.heL);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.hfi);
            this.hfi.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hfi.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.hfi.setLayoutParams(layoutParams);
            this.hfi.setVisibility(0);
        } else {
            this.hfi.setVisibility(8);
        }
        if (i == 2 && aVar.heD.aHX != null && aVar.heD.aHX.size() > 0) {
            if (this.hfo == null) {
                this.hfo = new b(this.mActivity);
                this.hfg.setAdapter((ListAdapter) this.hfo);
            }
            this.hfo.setList(aVar.heD.aHX);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.hfg);
            this.gBi.setVisibility(0);
        } else {
            this.gBi.setVisibility(8);
        }
        if (this.mIsHost) {
            this.hfj.setVisibility(8);
        } else {
            this.hfj.setVisibility(0);
            if (aVar.heD.heM != null && !TextUtils.isEmpty(aVar.heD.heM.text)) {
                if (aVar.heD.heM.rank > 0 && aVar.heD.heM.rank < 4) {
                    this.hfk.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.hfk.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.hfk.setText(aVar.heD.heM.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.heC.heI) && TextUtils.equals(aVar.heC.heI, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.hfl.setVisibility(8);
            } else {
                this.hfl.setVisibility(0);
            }
        }
        this.bxB = aVar.heC.heK;
        bf(this.bxB);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.grC) {
            bWH();
        } else if (view == this.hfl || view == this.hfj) {
            bWI();
        }
    }

    private void bWH() {
        if (this.mActivity == null || this.heR == null || this.heR.heC == null || TextUtils.isEmpty(this.heR.heC.heH)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.heR.heC.heH}, false, null, true);
        }
    }

    private void bWI() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ao aoVar = new ao();
            aoVar.aLx = Integer.parseInt(this.aOA);
            aoVar.aLv = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void bf(long j) {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
            this.mHandler.postDelayed(this.bxE, 1000 * j);
        }
    }

    public void bWJ() {
        if (this.mHandler != null && this.bxE != null) {
            this.mHandler.removeCallbacks(this.bxE);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hfx);
        this.mHandler.postDelayed(this.hfx, 1000L);
    }

    public void bWK() {
        if (this.mHandler != null && this.hfx != null) {
            this.mHandler.removeCallbacks(this.hfx);
        }
    }

    public void bWL() {
        this.mHandler.removeCallbacks(this.hfy);
        this.mHandler.postDelayed(this.hfy, 1000L);
    }

    public void bWM() {
        if (this.mHandler != null && this.hfy != null) {
            this.mHandler.removeCallbacks(this.hfy);
        }
    }

    public void bkr() {
    }

    private View ns(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.hfa != null) {
            this.hfa.clearAnimation();
        }
        if (this.hfm != null) {
            this.hfm.onDestroy();
        }
        bWK();
        bWM();
        bWJ();
    }

    public Animation bWN() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfq != null) {
            this.hfq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0201a.sdk_push_up_out);
        this.hfa.setAnimation(loadAnimation);
        this.hfa.setVisibility(8);
        return loadAnimation;
    }
}
