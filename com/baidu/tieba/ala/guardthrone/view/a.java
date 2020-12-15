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
    private b gTA;
    private com.baidu.tieba.ala.guardthrone.adapter.a gTB;
    private Animation gTC;
    private boolean gTD;
    private long gTE;
    private long gTF;
    private long gTG;
    private long gTH;
    private boolean gTI;
    private com.baidu.tieba.ala.guardthrone.b.a gTd;
    private View gTk;
    private FrameLayout gTl;
    private View gTm;
    private View gTn;
    private HeadImageView gTo;
    private TbImageView gTp;
    private TextView gTq;
    private TextView gTr;
    private ListView gTs;
    private ScrollView gTt;
    private HListView gTu;
    private RelativeLayout gTv;
    private TextView gTw;
    private TextView gTx;
    private com.baidu.tieba.ala.guardthrone.d.a gTy;
    private a.InterfaceC0668a gTz;
    private ImageView ghf;
    private LinearLayout gqj;
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
            if (a.this.gTy != null) {
                a.this.gTy.eu(a.this.mLiveId, a.this.brl);
            }
        }
    };
    private final Runnable gTJ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gTE <= 0) {
                a.this.gTE = 0L;
                a.this.bXf();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gTE <= 0 || a.this.gTr == null || a.this.gTd == null || a.this.gTd.gSO == null || TextUtils.isEmpty(a.this.gTd.gSO.gSS)) {
                if (a.this.gTr != null && a.this.gTr.getVisibility() == 0) {
                    a.this.gTr.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gTd.gSO.gSS + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gTE));
            if (a.this.gTr.getVisibility() != 0) {
                a.this.gTr.setVisibility(0);
            }
            a.this.gTr.setText(str);
        }
    };
    private final Runnable gTK = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gTH <= 0) {
                a.this.gTH = 0L;
                a.this.bXh();
            } else {
                a.i(a.this);
                a.this.bXg();
            }
            if (a.this.gTH >= 0 && a.this.gTr != null && a.this.gTd != null && a.this.gTd.gSO != null && !TextUtils.isEmpty(a.this.gTd.gSO.gSS)) {
                a.this.gTr.setText(a.this.gTd.gSO.gSS + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gTH)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gTE;
        aVar.gTE = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gTH;
        aVar.gTH = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gTD = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = mR(this.gTD);
        this.gTk = this.mRootView.findViewById(a.f.content_layout);
        this.gTl = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.gTm = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.gTn = this.mRootView.findViewById(a.f.view_foreground);
        this.ghf = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.gTo = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.gTp = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.gTq = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.gTr = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gqj = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.gTs = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.gTs.setDividerHeight(0);
        this.gTt = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.gTu = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.gTu.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gTv = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.gTw = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.gTx = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bWX();
        bWY();
        bWZ();
        bXa();
    }

    private void bWX() {
        this.gTo.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gTo.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gTo.setIsRound(true);
        this.gTo.setAutoChangeStyle(false);
        this.gTo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gTp.setDefaultResource(a.e.portrait_no_guard_bg);
        this.gTp.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bWY() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gTn.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gTn.setLayoutParams(layoutParams);
        }
    }

    private void bWZ() {
        if (this.gTD) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gTm.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gTm.setLayoutParams(layoutParams);
            this.gTv.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bXa() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTt.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gTt.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gTk.setOnClickListener(this);
        this.gTl.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ghf.setOnClickListener(this);
        this.gTx.setOnClickListener(this);
        this.gTv.setOnClickListener(this);
    }

    private void KR() {
        bXb();
        this.gTy = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gTz);
        this.gTy.eu(this.mLiveId, this.brl);
    }

    private void bXb() {
        this.gTz = new a.InterfaceC0668a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0668a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0668a
            public void onFail(int i, String str) {
                a.this.bsA = 5L;
                a.this.bb(a.this.bsA);
                if (a.this.mActivity != null && !a.this.gTI) {
                    a.this.gTI = true;
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
        if (aVar == null || aVar.gSO == null || aVar.gSP == null || this.mActivity == null) {
            this.bsA = 5L;
            bb(this.bsA);
            return;
        }
        this.gTd = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gSO.gSR)) {
            this.gTp.startLoad(aVar.gSO.gSR, 10, false);
        }
        if (i == 1) {
            this.gTo.setVisibility(8);
        } else {
            String str = aVar.gSO.gSQ;
            if (!TextUtils.isEmpty(str)) {
                this.gTo.setVisibility(0);
                this.gTo.startLoad(str, 12, false);
            } else {
                this.gTo.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gSO.gSS)) {
                this.gTq.setVisibility(0);
                this.gTq.setText(aVar.gSO.gSS);
            } else {
                this.gTq.setVisibility(4);
            }
        } else {
            String str2 = aVar.gSO.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gTq.setVisibility(0);
                this.gTq.setText(str2);
            } else {
                this.gTq.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gTr.setVisibility(4);
        } else if (i == 2) {
            if (this.gTF != aVar.gSO.startTime || this.gTE > aVar.gSO.bzb) {
                this.gTF = aVar.gSO.startTime;
                if (aVar.gSO.bzb > 0) {
                    this.gTE = aVar.gSO.bzb;
                    if (!TextUtils.isEmpty(aVar.gSO.gSS)) {
                        this.gTr.setVisibility(0);
                        this.gTr.setText(aVar.gSO.gSS + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gTE)));
                        if (this.mHandler != null && this.gTK != null) {
                            this.mHandler.removeCallbacks(this.gTK);
                        }
                        startCountDown();
                    }
                } else {
                    this.gTr.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gTG != aVar.gSO.startTime || this.gTH != aVar.gSO.gSV)) {
            this.gTG = aVar.gSO.startTime;
            if (aVar.gSO.gSV >= 0) {
                this.gTH = aVar.gSO.gSV;
                if (!TextUtils.isEmpty(aVar.gSO.gSS)) {
                    this.gTr.setVisibility(0);
                    this.gTr.setText(aVar.gSO.gSS + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gTH)));
                    if (this.mHandler != null && this.gTJ != null) {
                        this.mHandler.removeCallbacks(this.gTJ);
                    }
                    bXg();
                }
            } else {
                this.gTr.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gTu.setVisibility(8);
        } else if (aVar.gSO.gSX != null && aVar.gSO.gSX.size() > 0) {
            if (this.gTB == null) {
                this.gTB = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gTu.setAdapter((ListAdapter) this.gTB);
            }
            this.gTB.setList(aVar.gSO.gSX);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gTu);
            this.gTu.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTu.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.gTu.setLayoutParams(layoutParams);
            this.gTu.setVisibility(0);
        } else {
            this.gTu.setVisibility(8);
        }
        if (i == 2 && aVar.gSP.aIZ != null && aVar.gSP.aIZ.size() > 0) {
            if (this.gTA == null) {
                this.gTA = new b(this.mActivity);
                this.gTs.setAdapter((ListAdapter) this.gTA);
            }
            this.gTA.setList(aVar.gSP.aIZ);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gTs);
            this.gqj.setVisibility(0);
        } else {
            this.gqj.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gTv.setVisibility(8);
        } else {
            this.gTv.setVisibility(0);
            if (aVar.gSP.gSY != null && !TextUtils.isEmpty(aVar.gSP.gSY.text)) {
                if (aVar.gSP.gSY.rank > 0 && aVar.gSP.gSY.rank < 4) {
                    this.gTw.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.gTw.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.gTw.setText(aVar.gSP.gSY.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gSO.gSU) && TextUtils.equals(aVar.gSO.gSU, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gTx.setVisibility(8);
            } else {
                this.gTx.setVisibility(0);
            }
        }
        this.bsA = aVar.gSO.gSW;
        bb(this.bsA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.ghf) {
            bXc();
        } else if (view == this.gTx || view == this.gTv) {
            bXd();
        }
    }

    private void bXc() {
        if (this.mActivity == null || this.gTd == null || this.gTd.gSO == null || TextUtils.isEmpty(this.gTd.gSO.gST)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gTd.gSO.gST}, false, null, true);
        }
    }

    private void bXd() {
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

    public void bXe() {
        if (this.mHandler != null && this.bsD != null) {
            this.mHandler.removeCallbacks(this.bsD);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gTJ);
        this.mHandler.postDelayed(this.gTJ, 1000L);
    }

    public void bXf() {
        if (this.mHandler != null && this.gTJ != null) {
            this.mHandler.removeCallbacks(this.gTJ);
        }
    }

    public void bXg() {
        this.mHandler.removeCallbacks(this.gTK);
        this.mHandler.postDelayed(this.gTK, 1000L);
    }

    public void bXh() {
        if (this.mHandler != null && this.gTK != null) {
            this.mHandler.removeCallbacks(this.gTK);
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
        if (this.gTm != null) {
            this.gTm.clearAnimation();
        }
        if (this.gTy != null) {
            this.gTy.onDestroy();
        }
        bXf();
        bXh();
        bXe();
    }

    public Animation bXi() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gTC != null) {
            this.gTC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0205a.sdk_push_up_out);
        this.gTm.setAnimation(loadAnimation);
        this.gTm.setVisibility(8);
        return loadAnimation;
    }
}
