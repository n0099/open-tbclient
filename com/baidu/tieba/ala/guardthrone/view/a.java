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
import com.baidu.live.data.ai;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private String aOt;
    private String brl;
    private long bsA;
    private Animation gTA;
    private boolean gTB;
    private long gTC;
    private long gTD;
    private long gTE;
    private long gTF;
    private boolean gTG;
    private com.baidu.tieba.ala.guardthrone.b.a gTb;
    private View gTi;
    private FrameLayout gTj;
    private View gTk;
    private View gTl;
    private HeadImageView gTm;
    private TbImageView gTn;
    private TextView gTo;
    private TextView gTp;
    private ListView gTq;
    private ScrollView gTr;
    private HListView gTs;
    private RelativeLayout gTt;
    private TextView gTu;
    private TextView gTv;
    private com.baidu.tieba.ala.guardthrone.d.a gTw;
    private a.InterfaceC0668a gTx;
    private b gTy;
    private com.baidu.tieba.ala.guardthrone.adapter.a gTz;
    private ImageView ghd;
    private LinearLayout gqh;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bsD = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gTw != null) {
                a.this.gTw.eu(a.this.mLiveId, a.this.brl);
            }
        }
    };
    private final Runnable gTH = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gTC <= 0) {
                a.this.gTC = 0L;
                a.this.bXe();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gTC <= 0 || a.this.gTp == null || a.this.gTb == null || a.this.gTb.gSM == null || TextUtils.isEmpty(a.this.gTb.gSM.gSQ)) {
                if (a.this.gTp != null && a.this.gTp.getVisibility() == 0) {
                    a.this.gTp.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gTb.gSM.gSQ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gTC));
            if (a.this.gTp.getVisibility() != 0) {
                a.this.gTp.setVisibility(0);
            }
            a.this.gTp.setText(str);
        }
    };
    private final Runnable gTI = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gTF <= 0) {
                a.this.gTF = 0L;
                a.this.bXg();
            } else {
                a.i(a.this);
                a.this.bXf();
            }
            if (a.this.gTF >= 0 && a.this.gTp != null && a.this.gTb != null && a.this.gTb.gSM != null && !TextUtils.isEmpty(a.this.gTb.gSM.gSQ)) {
                a.this.gTp.setText(a.this.gTb.gSM.gSQ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gTF)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gTC;
        aVar.gTC = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gTF;
        aVar.gTF = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gTB = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = mR(this.gTB);
        this.gTi = this.mRootView.findViewById(a.f.content_layout);
        this.gTj = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.gTk = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.gTl = this.mRootView.findViewById(a.f.view_foreground);
        this.ghd = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.gTm = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.gTn = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.gTo = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.gTp = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gqh = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.gTq = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.gTq.setDividerHeight(0);
        this.gTr = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.gTs = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.gTs.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gTt = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.gTu = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.gTv = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bWW();
        bWX();
        bWY();
        bWZ();
    }

    private void bWW() {
        this.gTm.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gTm.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gTm.setIsRound(true);
        this.gTm.setAutoChangeStyle(false);
        this.gTm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gTn.setDefaultResource(a.e.portrait_no_guard_bg);
        this.gTn.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bWX() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gTl.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gTl.setLayoutParams(layoutParams);
        }
    }

    private void bWY() {
        if (this.gTB) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTk.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gTk.setLayoutParams(layoutParams);
            this.gTt.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bWZ() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTr.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gTr.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gTi.setOnClickListener(this);
        this.gTj.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ghd.setOnClickListener(this);
        this.gTv.setOnClickListener(this);
        this.gTt.setOnClickListener(this);
    }

    private void KR() {
        bXa();
        this.gTw = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gTx);
        this.gTw.eu(this.mLiveId, this.brl);
    }

    private void bXa() {
        this.gTx = new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0668a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0668a
            public void onFail(int i, String str) {
                a.this.bsA = 5L;
                a.this.bb(a.this.bsA);
                if (a.this.mActivity != null && !a.this.gTG) {
                    a.this.gTG = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.brl = str2;
        this.aOt = str3;
        this.mTabId = i;
        KR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gSM == null || aVar.gSN == null || this.mActivity == null) {
            this.bsA = 5L;
            bb(this.bsA);
            return;
        }
        this.gTb = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gSM.gSP)) {
            this.gTn.startLoad(aVar.gSM.gSP, 10, false);
        }
        if (i == 1) {
            this.gTm.setVisibility(8);
        } else {
            String str = aVar.gSM.gSO;
            if (!TextUtils.isEmpty(str)) {
                this.gTm.setVisibility(0);
                this.gTm.startLoad(str, 12, false);
            } else {
                this.gTm.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gSM.gSQ)) {
                this.gTo.setVisibility(0);
                this.gTo.setText(aVar.gSM.gSQ);
            } else {
                this.gTo.setVisibility(4);
            }
        } else {
            String str2 = aVar.gSM.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gTo.setVisibility(0);
                this.gTo.setText(str2);
            } else {
                this.gTo.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gTp.setVisibility(4);
        } else if (i == 2) {
            if (this.gTD != aVar.gSM.startTime || this.gTC > aVar.gSM.bzb) {
                this.gTD = aVar.gSM.startTime;
                if (aVar.gSM.bzb > 0) {
                    this.gTC = aVar.gSM.bzb;
                    if (!TextUtils.isEmpty(aVar.gSM.gSQ)) {
                        this.gTp.setVisibility(0);
                        this.gTp.setText(aVar.gSM.gSQ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gTC)));
                        if (this.mHandler != null && this.gTI != null) {
                            this.mHandler.removeCallbacks(this.gTI);
                        }
                        startCountDown();
                    }
                } else {
                    this.gTp.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gTE != aVar.gSM.startTime || this.gTF != aVar.gSM.gST)) {
            this.gTE = aVar.gSM.startTime;
            if (aVar.gSM.gST >= 0) {
                this.gTF = aVar.gSM.gST;
                if (!TextUtils.isEmpty(aVar.gSM.gSQ)) {
                    this.gTp.setVisibility(0);
                    this.gTp.setText(aVar.gSM.gSQ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gTF)));
                    if (this.mHandler != null && this.gTH != null) {
                        this.mHandler.removeCallbacks(this.gTH);
                    }
                    bXf();
                }
            } else {
                this.gTp.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gTs.setVisibility(8);
        } else if (aVar.gSM.gSV != null && aVar.gSM.gSV.size() > 0) {
            if (this.gTz == null) {
                this.gTz = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gTs.setAdapter((ListAdapter) this.gTz);
            }
            this.gTz.setList(aVar.gSM.gSV);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gTs);
            this.gTs.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTs.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.gTs.setLayoutParams(layoutParams);
            this.gTs.setVisibility(0);
        } else {
            this.gTs.setVisibility(8);
        }
        if (i == 2 && aVar.gSN.aIZ != null && aVar.gSN.aIZ.size() > 0) {
            if (this.gTy == null) {
                this.gTy = new b(this.mActivity);
                this.gTq.setAdapter((ListAdapter) this.gTy);
            }
            this.gTy.setList(aVar.gSN.aIZ);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gTq);
            this.gqh.setVisibility(0);
        } else {
            this.gqh.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gTt.setVisibility(8);
        } else {
            this.gTt.setVisibility(0);
            if (aVar.gSN.gSW != null && !TextUtils.isEmpty(aVar.gSN.gSW.text)) {
                if (aVar.gSN.gSW.rank > 0 && aVar.gSN.gSW.rank < 4) {
                    this.gTu.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.gTu.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.gTu.setText(aVar.gSN.gSW.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gSM.gSS) && TextUtils.equals(aVar.gSM.gSS, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gTv.setVisibility(8);
            } else {
                this.gTv.setVisibility(0);
            }
        }
        this.bsA = aVar.gSM.gSU;
        bb(this.bsA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.ghd) {
            bXb();
        } else if (view == this.gTv || view == this.gTt) {
            bXc();
        }
    }

    private void bXb() {
        if (this.mActivity == null || this.gTb == null || this.gTb.gSM == null || TextUtils.isEmpty(this.gTb.gSM.gSR)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gTb.gSM.gSR}, false, null, true);
        }
    }

    private void bXc() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ai aiVar = new ai();
            aiVar.aLB = Integer.parseInt(this.aOt);
            aiVar.aLz = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void bb(long j) {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
            this.mHandler.postDelayed(this.bsD, 1000 * j);
        }
    }

    public void bXd() {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gTH);
        this.mHandler.postDelayed(this.gTH, 1000L);
    }

    public void bXe() {
        if (this.mHandler != null && this.gTH != null) {
            this.mHandler.removeCallbacks(this.gTH);
        }
    }

    public void bXf() {
        this.mHandler.removeCallbacks(this.gTI);
        this.mHandler.postDelayed(this.gTI, 1000L);
    }

    public void bXg() {
        if (this.mHandler != null && this.gTI != null) {
            this.mHandler.removeCallbacks(this.gTI);
        }
    }

    public void blq() {
    }

    private View mR(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gTk != null) {
            this.gTk.clearAnimation();
        }
        if (this.gTw != null) {
            this.gTw.onDestroy();
        }
        bXe();
        bXg();
        bXd();
    }

    public Animation bXh() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gTA != null) {
            this.gTA.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0205a.sdk_push_up_out);
        this.gTk.setAnimation(loadAnimation);
        this.gTk.setVisibility(8);
        return loadAnimation;
    }
}
