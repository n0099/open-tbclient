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
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private String aPa;
    private String bvS;
    private long bxl;
    private LinearLayout gBi;
    private ImageView grD;
    private com.baidu.tieba.ala.guardthrone.b.a heQ;
    private View heX;
    private FrameLayout heY;
    private View heZ;
    private View hfa;
    private HeadImageView hfb;
    private TbImageView hfc;
    private TextView hfd;
    private TextView hfe;
    private ListView hff;
    private ScrollView hfg;
    private HListView hfh;
    private RelativeLayout hfi;
    private TextView hfj;
    private TextView hfk;
    private com.baidu.tieba.ala.guardthrone.d.a hfl;
    private a.InterfaceC0660a hfm;
    private b hfn;
    private com.baidu.tieba.ala.guardthrone.adapter.a hfo;
    private Animation hfp;
    private boolean hfq;
    private long hfr;
    private long hfs;
    private long hft;
    private long hfu;
    private boolean hfv;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bxo = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfl != null) {
                a.this.hfl.et(a.this.mLiveId, a.this.bvS);
            }
        }
    };
    private final Runnable hfw = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfr <= 0) {
                a.this.hfr = 0L;
                a.this.bZL();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.hfr <= 0 || a.this.hfe == null || a.this.heQ == null || a.this.heQ.heB == null || TextUtils.isEmpty(a.this.heQ.heB.heF)) {
                if (a.this.hfe != null && a.this.hfe.getVisibility() == 0) {
                    a.this.hfe.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.heQ.heB.heF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hfr));
            if (a.this.hfe.getVisibility() != 0) {
                a.this.hfe.setVisibility(0);
            }
            a.this.hfe.setText(str);
        }
    };
    private final Runnable hfx = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hfu <= 0) {
                a.this.hfu = 0L;
                a.this.bZN();
            } else {
                a.i(a.this);
                a.this.bZM();
            }
            if (a.this.hfu >= 0 && a.this.hfe != null && a.this.heQ != null && a.this.heQ.heB != null && !TextUtils.isEmpty(a.this.heQ.heB.heF)) {
                a.this.hfe.setText(a.this.heQ.heB.heF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hfu)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.hfr;
        aVar.hfr = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.hfu;
        aVar.hfu = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.hfq = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = nr(this.hfq);
        this.heX = this.mRootView.findViewById(a.f.content_layout);
        this.heY = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.heZ = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.hfa = this.mRootView.findViewById(a.f.view_foreground);
        this.grD = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.hfb = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.hfc = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.hfd = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.hfe = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gBi = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.hff = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.hff.setDividerHeight(0);
        this.hfg = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.hfh = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.hfh.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.hfi = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.hfj = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.hfk = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bZD();
        bZE();
        bZF();
        bZG();
    }

    private void bZD() {
        this.hfb.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hfb.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hfb.setIsRound(true);
        this.hfb.setAutoChangeStyle(false);
        this.hfb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hfc.setDefaultResource(a.e.portrait_no_guard_bg);
        this.hfc.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bZE() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.hfa.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.hfa.setLayoutParams(layoutParams);
        }
    }

    private void bZF() {
        if (this.hfq) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.heZ.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.heZ.setLayoutParams(layoutParams);
            this.hfi.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bZG() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfg.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.hfg.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.heX.setOnClickListener(this);
        this.heY.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.grD.setOnClickListener(this);
        this.hfk.setOnClickListener(this);
        this.hfi.setOnClickListener(this);
    }

    private void initModel() {
        bZH();
        this.hfl = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.hfm);
        this.hfl.et(this.mLiveId, this.bvS);
    }

    private void bZH() {
        this.hfm = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0660a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0660a
            public void onFail(int i, String str) {
                a.this.bxl = 5L;
                a.this.bb(a.this.bxl);
                if (a.this.mActivity != null && !a.this.hfv) {
                    a.this.hfv = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void i(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bvS = str2;
        this.aPa = str3;
        this.mTabId = i;
        initModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.heB == null || aVar.heC == null || this.mActivity == null) {
            this.bxl = 5L;
            bb(this.bxl);
            return;
        }
        this.heQ = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.heB.heE)) {
            this.hfc.startLoad(aVar.heB.heE, 10, false);
        }
        if (i == 1) {
            this.hfb.setVisibility(8);
        } else {
            String str = aVar.heB.heD;
            if (!TextUtils.isEmpty(str)) {
                this.hfb.setVisibility(0);
                this.hfb.startLoad(str, 12, false);
            } else {
                this.hfb.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.heB.heF)) {
                this.hfd.setVisibility(0);
                this.hfd.setText(aVar.heB.heF);
            } else {
                this.hfd.setVisibility(4);
            }
        } else {
            String str2 = aVar.heB.username;
            if (!TextUtils.isEmpty(str2)) {
                this.hfd.setVisibility(0);
                this.hfd.setText(str2);
            } else {
                this.hfd.setVisibility(8);
            }
        }
        if (i == 1) {
            this.hfe.setVisibility(4);
        } else if (i == 2) {
            if (this.hfs != aVar.heB.startTime || this.hfr > aVar.heB.countdown) {
                this.hfs = aVar.heB.startTime;
                if (aVar.heB.countdown > 0) {
                    this.hfr = aVar.heB.countdown;
                    if (!TextUtils.isEmpty(aVar.heB.heF)) {
                        this.hfe.setVisibility(0);
                        this.hfe.setText(aVar.heB.heF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hfr)));
                        if (this.mHandler != null && this.hfx != null) {
                            this.mHandler.removeCallbacks(this.hfx);
                        }
                        startCountDown();
                    }
                } else {
                    this.hfe.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.hft != aVar.heB.startTime || this.hfu != aVar.heB.heI)) {
            this.hft = aVar.heB.startTime;
            if (aVar.heB.heI >= 0) {
                this.hfu = aVar.heB.heI;
                if (!TextUtils.isEmpty(aVar.heB.heF)) {
                    this.hfe.setVisibility(0);
                    this.hfe.setText(aVar.heB.heF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hfu)));
                    if (this.mHandler != null && this.hfw != null) {
                        this.mHandler.removeCallbacks(this.hfw);
                    }
                    bZM();
                }
            } else {
                this.hfe.setVisibility(8);
            }
        }
        if (i == 2) {
            this.hfh.setVisibility(8);
        } else if (aVar.heB.heK != null && aVar.heB.heK.size() > 0) {
            if (this.hfo == null) {
                this.hfo = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.hfh.setAdapter((ListAdapter) this.hfo);
            }
            this.hfo.setList(aVar.heB.heK);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.hfh);
            this.hfh.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hfh.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.hfh.setLayoutParams(layoutParams);
            this.hfh.setVisibility(0);
        } else {
            this.hfh.setVisibility(8);
        }
        if (i == 2 && aVar.heC.aJx != null && aVar.heC.aJx.size() > 0) {
            if (this.hfn == null) {
                this.hfn = new b(this.mActivity);
                this.hff.setAdapter((ListAdapter) this.hfn);
            }
            this.hfn.setList(aVar.heC.aJx);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.hff);
            this.gBi.setVisibility(0);
        } else {
            this.gBi.setVisibility(8);
        }
        if (this.mIsHost) {
            this.hfi.setVisibility(8);
        } else {
            this.hfi.setVisibility(0);
            if (aVar.heC.heL != null && !TextUtils.isEmpty(aVar.heC.heL.text)) {
                if (aVar.heC.heL.rank > 0 && aVar.heC.heL.rank < 4) {
                    this.hfj.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.hfj.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.hfj.setText(aVar.heC.heL.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.heB.heH) && TextUtils.equals(aVar.heB.heH, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.hfk.setVisibility(8);
            } else {
                this.hfk.setVisibility(0);
            }
        }
        this.bxl = aVar.heB.heJ;
        bb(this.bxl);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.grD) {
            bZI();
        } else if (view == this.hfk || view == this.hfi) {
            bZJ();
        }
    }

    private void bZI() {
        if (this.mActivity == null || this.heQ == null || this.heQ.heB == null || TextUtils.isEmpty(this.heQ.heB.heG)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.heQ.heB.heG}, false, null, true);
        }
    }

    private void bZJ() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ak akVar = new ak();
            akVar.aMf = Integer.parseInt(this.aPa);
            akVar.aMd = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void bb(long j) {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
            this.mHandler.postDelayed(this.bxo, 1000 * j);
        }
    }

    public void bZK() {
        if (this.mHandler != null && this.bxo != null) {
            this.mHandler.removeCallbacks(this.bxo);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hfw);
        this.mHandler.postDelayed(this.hfw, 1000L);
    }

    public void bZL() {
        if (this.mHandler != null && this.hfw != null) {
            this.mHandler.removeCallbacks(this.hfw);
        }
    }

    public void bZM() {
        this.mHandler.removeCallbacks(this.hfx);
        this.mHandler.postDelayed(this.hfx, 1000L);
    }

    public void bZN() {
        if (this.mHandler != null && this.hfx != null) {
            this.mHandler.removeCallbacks(this.hfx);
        }
    }

    public void bnP() {
    }

    private View nr(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.heZ != null) {
            this.heZ.clearAnimation();
        }
        if (this.hfl != null) {
            this.hfl.onDestroy();
        }
        bZL();
        bZN();
        bZK();
    }

    public Animation bZO() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfp != null) {
            this.hfp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0203a.sdk_push_up_out);
        this.heZ.setAnimation(loadAnimation);
        this.heZ.setVisibility(8);
        return loadAnimation;
    }
}
