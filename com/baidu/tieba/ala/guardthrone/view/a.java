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
import com.baidu.live.data.ah;
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
    private String aLy;
    private String bme;
    private long bns;
    private ImageView fYS;
    private com.baidu.tieba.ala.guardthrone.b.a gJP;
    private View gJW;
    private FrameLayout gJX;
    private View gJY;
    private View gJZ;
    private HeadImageView gKa;
    private TbImageView gKb;
    private TextView gKc;
    private TextView gKd;
    private ListView gKe;
    private ScrollView gKf;
    private HListView gKg;
    private RelativeLayout gKh;
    private TextView gKi;
    private TextView gKj;
    private com.baidu.tieba.ala.guardthrone.d.a gKk;
    private a.InterfaceC0655a gKl;
    private b gKm;
    private com.baidu.tieba.ala.guardthrone.adapter.a gKn;
    private Animation gKo;
    private boolean gKp;
    private long gKq;
    private long gKr;
    private long gKs;
    private long gKt;
    private boolean gKu;
    private LinearLayout ghX;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bnv = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKk != null) {
                a.this.gKk.en(a.this.mLiveId, a.this.bme);
            }
        }
    };
    private final Runnable gKv = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKq <= 0) {
                a.this.gKq = 0L;
                a.this.bTu();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gKq <= 0 || a.this.gKd == null || a.this.gJP == null || a.this.gJP.gJB == null || TextUtils.isEmpty(a.this.gJP.gJB.gJF)) {
                if (a.this.gKd != null && a.this.gKd.getVisibility() == 0) {
                    a.this.gKd.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gJP.gJB.gJF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gKq));
            if (a.this.gKd.getVisibility() != 0) {
                a.this.gKd.setVisibility(0);
            }
            a.this.gKd.setText(str);
        }
    };
    private final Runnable gKw = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKt <= 0) {
                a.this.gKt = 0L;
                a.this.bTw();
            } else {
                a.i(a.this);
                a.this.bTv();
            }
            if (a.this.gKt >= 0 && a.this.gKd != null && a.this.gJP != null && a.this.gJP.gJB != null && !TextUtils.isEmpty(a.this.gJP.gJB.gJF)) {
                a.this.gKd.setText(a.this.gJP.gJB.gJF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.gKt)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gKq;
        aVar.gKq = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gKt;
        aVar.gKt = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gKp = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = mw(this.gKp);
        this.gJW = this.mRootView.findViewById(a.f.content_layout);
        this.gJX = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.gJY = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.gJZ = this.mRootView.findViewById(a.f.view_foreground);
        this.fYS = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.gKa = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.gKb = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.gKc = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.gKd = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.ghX = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.gKe = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.gKe.setDividerHeight(0);
        this.gKf = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.gKg = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.gKg.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gKh = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.gKi = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.gKj = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bTm();
        bTn();
        bTo();
        bTp();
    }

    private void bTm() {
        this.gKa.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gKa.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gKa.setIsRound(true);
        this.gKa.setAutoChangeStyle(false);
        this.gKa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gKb.setDefaultResource(a.e.portrait_no_guard_bg);
        this.gKb.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bTn() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gJZ.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gJZ.setLayoutParams(layoutParams);
        }
    }

    private void bTo() {
        if (this.gKp) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gJY.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gJY.setLayoutParams(layoutParams);
            this.gKh.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bTp() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKf.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gKf.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gJW.setOnClickListener(this);
        this.gJX.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fYS.setOnClickListener(this);
        this.gKj.setOnClickListener(this);
        this.gKh.setOnClickListener(this);
    }

    private void IQ() {
        bTq();
        this.gKk = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gKl);
        this.gKk.en(this.mLiveId, this.bme);
    }

    private void bTq() {
        this.gKl = new a.InterfaceC0655a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0655a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0655a
            public void onFail(int i, String str) {
                a.this.bns = 5L;
                a.this.aD(a.this.bns);
                if (a.this.mActivity != null && !a.this.gKu) {
                    a.this.gKu = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bme = str2;
        this.aLy = str3;
        this.mTabId = i;
        IQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gJB == null || aVar.gJC == null || this.mActivity == null) {
            this.bns = 5L;
            aD(this.bns);
            return;
        }
        this.gJP = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gJB.gJE)) {
            this.gKb.startLoad(aVar.gJB.gJE, 10, false);
        }
        if (i == 1) {
            this.gKa.setVisibility(8);
        } else {
            String str = aVar.gJB.gJD;
            if (!TextUtils.isEmpty(str)) {
                this.gKa.setVisibility(0);
                this.gKa.startLoad(str, 12, false);
            } else {
                this.gKa.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gJB.gJF)) {
                this.gKc.setVisibility(0);
                this.gKc.setText(aVar.gJB.gJF);
            } else {
                this.gKc.setVisibility(4);
            }
        } else {
            String str2 = aVar.gJB.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gKc.setVisibility(0);
                this.gKc.setText(str2);
            } else {
                this.gKc.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gKd.setVisibility(4);
        } else if (i == 2) {
            if (this.gKr != aVar.gJB.startTime || this.gKq > aVar.gJB.btQ) {
                this.gKr = aVar.gJB.startTime;
                if (aVar.gJB.btQ > 0) {
                    this.gKq = aVar.gJB.btQ;
                    if (!TextUtils.isEmpty(aVar.gJB.gJF)) {
                        this.gKd.setVisibility(0);
                        this.gKd.setText(aVar.gJB.gJF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gKq)));
                        if (this.mHandler != null && this.gKw != null) {
                            this.mHandler.removeCallbacks(this.gKw);
                        }
                        startCountDown();
                    }
                } else {
                    this.gKd.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gKs != aVar.gJB.startTime || this.gKt != aVar.gJB.gJI)) {
            this.gKs = aVar.gJB.startTime;
            if (aVar.gJB.gJI >= 0) {
                this.gKt = aVar.gJB.gJI;
                if (!TextUtils.isEmpty(aVar.gJB.gJF)) {
                    this.gKd.setVisibility(0);
                    this.gKd.setText(aVar.gJB.gJF + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.gKt)));
                    if (this.mHandler != null && this.gKv != null) {
                        this.mHandler.removeCallbacks(this.gKv);
                    }
                    bTv();
                }
            } else {
                this.gKd.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gKg.setVisibility(8);
        } else if (aVar.gJB.gJK != null && aVar.gJB.gJK.size() > 0) {
            if (this.gKn == null) {
                this.gKn = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gKg.setAdapter((ListAdapter) this.gKn);
            }
            this.gKn.setList(aVar.gJB.gJK);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gKg);
            this.gKg.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKg.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.gKg.setLayoutParams(layoutParams);
            this.gKg.setVisibility(0);
        } else {
            this.gKg.setVisibility(8);
        }
        if (i == 2 && aVar.gJC.aGq != null && aVar.gJC.aGq.size() > 0) {
            if (this.gKm == null) {
                this.gKm = new b(this.mActivity);
                this.gKe.setAdapter((ListAdapter) this.gKm);
            }
            this.gKm.setList(aVar.gJC.aGq);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gKe);
            this.ghX.setVisibility(0);
        } else {
            this.ghX.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gKh.setVisibility(8);
        } else {
            this.gKh.setVisibility(0);
            if (aVar.gJC.gJL != null && !TextUtils.isEmpty(aVar.gJC.gJL.text)) {
                if (aVar.gJC.gJL.rank > 0 && aVar.gJC.gJL.rank < 4) {
                    this.gKi.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.gKi.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.gKi.setText(aVar.gJC.gJL.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gJB.gJH) && TextUtils.equals(aVar.gJB.gJH, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gKj.setVisibility(8);
            } else {
                this.gKj.setVisibility(0);
            }
        }
        this.bns = aVar.gJB.gJJ;
        aD(this.bns);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fYS) {
            bTr();
        } else if (view == this.gKj || view == this.gKh) {
            bTs();
        }
    }

    private void bTr() {
        if (this.mActivity == null || this.gJP == null || this.gJP.gJB == null || TextUtils.isEmpty(this.gJP.gJB.gJG)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gJP.gJB.gJG}, false, null, true);
        }
    }

    private void bTs() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ah ahVar = new ah();
            ahVar.aII = Integer.parseInt(this.aLy);
            ahVar.aIG = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void aD(long j) {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
            this.mHandler.postDelayed(this.bnv, 1000 * j);
        }
    }

    public void bTt() {
        if (this.mHandler != null && this.bnv != null) {
            this.mHandler.removeCallbacks(this.bnv);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gKv);
        this.mHandler.postDelayed(this.gKv, 1000L);
    }

    public void bTu() {
        if (this.mHandler != null && this.gKv != null) {
            this.mHandler.removeCallbacks(this.gKv);
        }
    }

    public void bTv() {
        this.mHandler.removeCallbacks(this.gKw);
        this.mHandler.postDelayed(this.gKw, 1000L);
    }

    public void bTw() {
        if (this.mHandler != null && this.gKw != null) {
            this.mHandler.removeCallbacks(this.gKw);
        }
    }

    public void big() {
    }

    private View mw(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gJY != null) {
            this.gJY.clearAnimation();
        }
        if (this.gKk != null) {
            this.gKk.onDestroy();
        }
        bTu();
        bTw();
        bTt();
    }

    public Animation bTx() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gKo != null) {
            this.gKo.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0195a.sdk_push_up_out);
        this.gJY.setAnimation(loadAnimation);
        this.gJY.setVisibility(8);
        return loadAnimation;
    }
}
