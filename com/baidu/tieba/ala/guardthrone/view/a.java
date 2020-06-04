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
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private String aWr;
    private long aXA;
    private String ayw;
    private ImageView eUW;
    private TbImageView fCA;
    private TextView fCB;
    private TextView fCC;
    private ListView fCD;
    private ScrollView fCE;
    private HListView fCF;
    private RelativeLayout fCG;
    private TextView fCH;
    private TextView fCI;
    private com.baidu.tieba.ala.guardthrone.d.a fCJ;
    private a.InterfaceC0548a fCK;
    private b fCL;
    private com.baidu.tieba.ala.guardthrone.adapter.a fCM;
    private Animation fCN;
    private boolean fCO;
    private long fCP;
    private long fCQ;
    private long fCR;
    private long fCS;
    private boolean fCT;
    private com.baidu.tieba.ala.guardthrone.b.a fCo;
    private View fCv;
    private FrameLayout fCw;
    private View fCx;
    private View fCy;
    private HeadImageView fCz;
    private LinearLayout fbl;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable aXD = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fCJ != null) {
                a.this.fCJ.dD(a.this.mLiveId, a.this.aWr);
            }
        }
    };
    private final Runnable fCU = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fCP <= 0) {
                a.this.fCP = 0L;
                a.this.bvy();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.fCP <= 0 || a.this.fCC == null || a.this.fCo == null || a.this.fCo.fBY == null || TextUtils.isEmpty(a.this.fCo.fBY.fCc)) {
                if (a.this.fCC != null && a.this.fCC.getVisibility() == 0) {
                    a.this.fCC.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fCo.fBY.fCc + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fCP));
            if (a.this.fCC.getVisibility() != 0) {
                a.this.fCC.setVisibility(0);
            }
            a.this.fCC.setText(str);
        }
    };
    private final Runnable fCV = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fCS <= 0) {
                a.this.fCS = 0L;
                a.this.bvA();
            } else {
                a.i(a.this);
                a.this.bvz();
            }
            if (a.this.fCS >= 0 && a.this.fCC != null && a.this.fCo != null && a.this.fCo.fBY != null && !TextUtils.isEmpty(a.this.fCo.fBY.fCc)) {
                a.this.fCC.setText(a.this.fCo.fBY.fCc + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fCS)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.fCP;
        aVar.fCP = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.fCS;
        aVar.fCS = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.fCO = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = kc(this.fCO);
        this.fCv = this.mRootView.findViewById(a.g.content_layout);
        this.fCw = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fCx = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.fCy = this.mRootView.findViewById(a.g.view_foreground);
        this.eUW = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fCz = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.fCA = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.fCB = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.fCC = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fbl = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.fCD = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.fCD.setDividerHeight(0);
        this.fCE = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.fCF = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.fCF.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.fCG = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.fCH = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.fCI = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bvq();
        bvr();
        bvs();
        bvt();
    }

    private void bvq() {
        this.fCz.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fCz.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fCz.setIsRound(true);
        this.fCz.setAutoChangeStyle(false);
        this.fCz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fCA.setDefaultResource(a.f.portrait_no_guard_bg);
        this.fCA.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bvr() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.fCy.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.fCy.setLayoutParams(layoutParams);
        }
    }

    private void bvs() {
        if (this.fCO) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fCx.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.fCx.setLayoutParams(layoutParams);
            this.fCG.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bvt() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCE.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.fCE.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.fCv.setOnClickListener(this);
        this.fCw.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eUW.setOnClickListener(this);
        this.fCI.setOnClickListener(this);
        this.fCG.setOnClickListener(this);
    }

    private void AC() {
        bvu();
        this.fCJ = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.fCK);
        this.fCJ.dD(this.mLiveId, this.aWr);
    }

    private void bvu() {
        this.fCK = new a.InterfaceC0548a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0548a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0548a
            public void onFail(int i, String str) {
                a.this.aXA = 5L;
                a.this.ao(a.this.aXA);
                if (a.this.mActivity != null && !a.this.fCT) {
                    a.this.fCT = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.aWr = str2;
        this.ayw = str3;
        this.mTabId = i;
        AC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.fBY == null || aVar.fBZ == null || this.mActivity == null) {
            this.aXA = 5L;
            ao(this.aXA);
            return;
        }
        this.fCo = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.fBY.fCb)) {
            this.fCA.startLoad(aVar.fBY.fCb, 10, false);
        }
        if (i == 1) {
            this.fCz.setVisibility(8);
        } else {
            String str = aVar.fBY.fCa;
            if (!TextUtils.isEmpty(str)) {
                this.fCz.setVisibility(0);
                this.fCz.startLoad(str, 12, false);
            } else {
                this.fCz.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.fBY.fCc)) {
                this.fCB.setVisibility(0);
                this.fCB.setText(aVar.fBY.fCc);
            } else {
                this.fCB.setVisibility(4);
            }
        } else {
            String str2 = aVar.fBY.username;
            if (!TextUtils.isEmpty(str2)) {
                this.fCB.setVisibility(0);
                this.fCB.setText(str2);
            } else {
                this.fCB.setVisibility(8);
            }
        }
        if (i == 1) {
            this.fCC.setVisibility(4);
        } else if (i == 2) {
            if (this.fCQ != aVar.fBY.startTime || this.fCP > aVar.fBY.fCf) {
                this.fCQ = aVar.fBY.startTime;
                if (aVar.fBY.fCf > 0) {
                    this.fCP = aVar.fBY.fCf;
                    if (!TextUtils.isEmpty(aVar.fBY.fCc)) {
                        this.fCC.setVisibility(0);
                        this.fCC.setText(aVar.fBY.fCc + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fCP)));
                        if (this.mHandler != null && this.fCV != null) {
                            this.mHandler.removeCallbacks(this.fCV);
                        }
                        startCountDown();
                    }
                } else {
                    this.fCC.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.fCR != aVar.fBY.startTime || this.fCS != aVar.fBY.fCg)) {
            this.fCR = aVar.fBY.startTime;
            if (aVar.fBY.fCg >= 0) {
                this.fCS = aVar.fBY.fCg;
                if (!TextUtils.isEmpty(aVar.fBY.fCc)) {
                    this.fCC.setVisibility(0);
                    this.fCC.setText(aVar.fBY.fCc + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fCS)));
                    if (this.mHandler != null && this.fCU != null) {
                        this.mHandler.removeCallbacks(this.fCU);
                    }
                    bvz();
                }
            } else {
                this.fCC.setVisibility(8);
            }
        }
        if (i == 2) {
            this.fCF.setVisibility(8);
        } else if (aVar.fBY.fCi != null && aVar.fBY.fCi.size() > 0) {
            if (this.fCM == null) {
                this.fCM = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.fCF.setAdapter((ListAdapter) this.fCM);
            }
            this.fCM.setList(aVar.fBY.fCi);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.fCF);
            this.fCF.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fCF.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.fCF.setLayoutParams(layoutParams);
            this.fCF.setVisibility(0);
        } else {
            this.fCF.setVisibility(8);
        }
        if (i == 2 && aVar.fBZ.fCk != null && aVar.fBZ.fCk.size() > 0) {
            if (this.fCL == null) {
                this.fCL = new b(this.mActivity);
                this.fCD.setAdapter((ListAdapter) this.fCL);
            }
            this.fCL.setList(aVar.fBZ.fCk);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.fCD);
            this.fbl.setVisibility(0);
        } else {
            this.fbl.setVisibility(8);
        }
        if (this.mIsHost) {
            this.fCG.setVisibility(8);
        } else {
            this.fCG.setVisibility(0);
            if (aVar.fBZ.fCj != null && !TextUtils.isEmpty(aVar.fBZ.fCj.text)) {
                if (aVar.fBZ.fCj.rank > 0 && aVar.fBZ.fCj.rank < 4) {
                    this.fCH.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.fCH.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.fCH.setText(aVar.fBZ.fCj.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.fBY.fCe) && TextUtils.equals(aVar.fBY.fCe, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.fCI.setVisibility(8);
            } else {
                this.fCI.setVisibility(0);
            }
        }
        this.aXA = aVar.fBY.fCh;
        ao(this.aXA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.eUW) {
            bvv();
        } else if (view == this.fCI || view == this.fCG) {
            bvw();
        }
    }

    private void bvv() {
        if (this.mActivity == null || this.fCo == null || this.fCo.fBY == null || TextUtils.isEmpty(this.fCo.fBY.fCd)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.fCo.fBY.fCd}, false, null, true);
        }
    }

    private void bvw() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            v vVar = new v();
            vVar.avU = Integer.parseInt(this.ayw);
            vVar.avS = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, vVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ao(long j) {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
            this.mHandler.postDelayed(this.aXD, 1000 * j);
        }
    }

    public void bvx() {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fCU);
        this.mHandler.postDelayed(this.fCU, 1000L);
    }

    public void bvy() {
        if (this.mHandler != null && this.fCU != null) {
            this.mHandler.removeCallbacks(this.fCU);
        }
    }

    public void bvz() {
        this.mHandler.removeCallbacks(this.fCV);
        this.mHandler.postDelayed(this.fCV, 1000L);
    }

    public void bvA() {
        if (this.mHandler != null && this.fCV != null) {
            this.mHandler.removeCallbacks(this.fCV);
        }
    }

    public void aNc() {
    }

    private View kc(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.fCx != null) {
            this.fCx.clearAnimation();
        }
        if (this.fCJ != null) {
            this.fCJ.onDestroy();
        }
        bvy();
        bvA();
        bvx();
    }

    public Animation bvB() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fCN != null) {
            this.fCN.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0182a.sdk_push_up_out);
        this.fCx.setAnimation(loadAnimation);
        this.fCx.setVisibility(8);
        return loadAnimation;
    }
}
