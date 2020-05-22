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
    private ImageView eUL;
    private b fCA;
    private com.baidu.tieba.ala.guardthrone.adapter.a fCB;
    private Animation fCC;
    private boolean fCD;
    private long fCE;
    private long fCF;
    private long fCG;
    private long fCH;
    private boolean fCI;
    private com.baidu.tieba.ala.guardthrone.b.a fCd;
    private View fCk;
    private FrameLayout fCl;
    private View fCm;
    private View fCn;
    private HeadImageView fCo;
    private TbImageView fCp;
    private TextView fCq;
    private TextView fCr;
    private ListView fCs;
    private ScrollView fCt;
    private HListView fCu;
    private RelativeLayout fCv;
    private TextView fCw;
    private TextView fCx;
    private com.baidu.tieba.ala.guardthrone.d.a fCy;
    private a.InterfaceC0548a fCz;
    private LinearLayout fba;
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
            if (a.this.fCy != null) {
                a.this.fCy.dD(a.this.mLiveId, a.this.aWr);
            }
        }
    };
    private final Runnable fCJ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fCE <= 0) {
                a.this.fCE = 0L;
                a.this.bvw();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.fCE <= 0 || a.this.fCr == null || a.this.fCd == null || a.this.fCd.fBN == null || TextUtils.isEmpty(a.this.fCd.fBN.fBR)) {
                if (a.this.fCr != null && a.this.fCr.getVisibility() == 0) {
                    a.this.fCr.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fCd.fBN.fBR + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fCE));
            if (a.this.fCr.getVisibility() != 0) {
                a.this.fCr.setVisibility(0);
            }
            a.this.fCr.setText(str);
        }
    };
    private final Runnable fCK = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fCH <= 0) {
                a.this.fCH = 0L;
                a.this.bvy();
            } else {
                a.i(a.this);
                a.this.bvx();
            }
            if (a.this.fCH >= 0 && a.this.fCr != null && a.this.fCd != null && a.this.fCd.fBN != null && !TextUtils.isEmpty(a.this.fCd.fBN.fBR)) {
                a.this.fCr.setText(a.this.fCd.fBN.fBR + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fCH)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.fCE;
        aVar.fCE = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.fCH;
        aVar.fCH = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.fCD = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = kc(this.fCD);
        this.fCk = this.mRootView.findViewById(a.g.content_layout);
        this.fCl = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fCm = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.fCn = this.mRootView.findViewById(a.g.view_foreground);
        this.eUL = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fCo = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.fCp = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.fCq = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.fCr = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fba = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.fCs = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.fCs.setDividerHeight(0);
        this.fCt = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.fCu = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.fCu.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.fCv = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.fCw = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.fCx = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bvo();
        bvp();
        bvq();
        bvr();
    }

    private void bvo() {
        this.fCo.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fCo.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fCo.setIsRound(true);
        this.fCo.setAutoChangeStyle(false);
        this.fCo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fCp.setDefaultResource(a.f.portrait_no_guard_bg);
        this.fCp.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bvp() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.fCn.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.fCn.setLayoutParams(layoutParams);
        }
    }

    private void bvq() {
        if (this.fCD) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fCm.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.fCm.setLayoutParams(layoutParams);
            this.fCv.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bvr() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCt.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.fCt.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.fCk.setOnClickListener(this);
        this.fCl.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eUL.setOnClickListener(this);
        this.fCx.setOnClickListener(this);
        this.fCv.setOnClickListener(this);
    }

    private void AC() {
        bvs();
        this.fCy = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.fCz);
        this.fCy.dD(this.mLiveId, this.aWr);
    }

    private void bvs() {
        this.fCz = new a.InterfaceC0548a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0548a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0548a
            public void onFail(int i, String str) {
                a.this.aXA = 5L;
                a.this.ao(a.this.aXA);
                if (a.this.mActivity != null && !a.this.fCI) {
                    a.this.fCI = true;
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
        if (aVar == null || aVar.fBN == null || aVar.fBO == null || this.mActivity == null) {
            this.aXA = 5L;
            ao(this.aXA);
            return;
        }
        this.fCd = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.fBN.fBQ)) {
            this.fCp.startLoad(aVar.fBN.fBQ, 10, false);
        }
        if (i == 1) {
            this.fCo.setVisibility(8);
        } else {
            String str = aVar.fBN.fBP;
            if (!TextUtils.isEmpty(str)) {
                this.fCo.setVisibility(0);
                this.fCo.startLoad(str, 12, false);
            } else {
                this.fCo.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.fBN.fBR)) {
                this.fCq.setVisibility(0);
                this.fCq.setText(aVar.fBN.fBR);
            } else {
                this.fCq.setVisibility(4);
            }
        } else {
            String str2 = aVar.fBN.username;
            if (!TextUtils.isEmpty(str2)) {
                this.fCq.setVisibility(0);
                this.fCq.setText(str2);
            } else {
                this.fCq.setVisibility(8);
            }
        }
        if (i == 1) {
            this.fCr.setVisibility(4);
        } else if (i == 2) {
            if (this.fCF != aVar.fBN.startTime || this.fCE > aVar.fBN.fBU) {
                this.fCF = aVar.fBN.startTime;
                if (aVar.fBN.fBU > 0) {
                    this.fCE = aVar.fBN.fBU;
                    if (!TextUtils.isEmpty(aVar.fBN.fBR)) {
                        this.fCr.setVisibility(0);
                        this.fCr.setText(aVar.fBN.fBR + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fCE)));
                        if (this.mHandler != null && this.fCK != null) {
                            this.mHandler.removeCallbacks(this.fCK);
                        }
                        startCountDown();
                    }
                } else {
                    this.fCr.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.fCG != aVar.fBN.startTime || this.fCH != aVar.fBN.fBV)) {
            this.fCG = aVar.fBN.startTime;
            if (aVar.fBN.fBV >= 0) {
                this.fCH = aVar.fBN.fBV;
                if (!TextUtils.isEmpty(aVar.fBN.fBR)) {
                    this.fCr.setVisibility(0);
                    this.fCr.setText(aVar.fBN.fBR + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fCH)));
                    if (this.mHandler != null && this.fCJ != null) {
                        this.mHandler.removeCallbacks(this.fCJ);
                    }
                    bvx();
                }
            } else {
                this.fCr.setVisibility(8);
            }
        }
        if (i == 2) {
            this.fCu.setVisibility(8);
        } else if (aVar.fBN.fBX != null && aVar.fBN.fBX.size() > 0) {
            if (this.fCB == null) {
                this.fCB = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.fCu.setAdapter((ListAdapter) this.fCB);
            }
            this.fCB.setList(aVar.fBN.fBX);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.fCu);
            this.fCu.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fCu.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.fCu.setLayoutParams(layoutParams);
            this.fCu.setVisibility(0);
        } else {
            this.fCu.setVisibility(8);
        }
        if (i == 2 && aVar.fBO.fBZ != null && aVar.fBO.fBZ.size() > 0) {
            if (this.fCA == null) {
                this.fCA = new b(this.mActivity);
                this.fCs.setAdapter((ListAdapter) this.fCA);
            }
            this.fCA.setList(aVar.fBO.fBZ);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.fCs);
            this.fba.setVisibility(0);
        } else {
            this.fba.setVisibility(8);
        }
        if (this.mIsHost) {
            this.fCv.setVisibility(8);
        } else {
            this.fCv.setVisibility(0);
            if (aVar.fBO.fBY != null && !TextUtils.isEmpty(aVar.fBO.fBY.text)) {
                if (aVar.fBO.fBY.rank > 0 && aVar.fBO.fBY.rank < 4) {
                    this.fCw.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.fCw.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.fCw.setText(aVar.fBO.fBY.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.fBN.fBT) && TextUtils.equals(aVar.fBN.fBT, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.fCx.setVisibility(8);
            } else {
                this.fCx.setVisibility(0);
            }
        }
        this.aXA = aVar.fBN.fBW;
        ao(this.aXA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.eUL) {
            bvt();
        } else if (view == this.fCx || view == this.fCv) {
            bvu();
        }
    }

    private void bvt() {
        if (this.mActivity == null || this.fCd == null || this.fCd.fBN == null || TextUtils.isEmpty(this.fCd.fBN.fBS)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.fCd.fBN.fBS}, false, null, true);
        }
    }

    private void bvu() {
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

    public void bvv() {
        if (this.mHandler != null && this.aXD != null) {
            this.mHandler.removeCallbacks(this.aXD);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fCJ);
        this.mHandler.postDelayed(this.fCJ, 1000L);
    }

    public void bvw() {
        if (this.mHandler != null && this.fCJ != null) {
            this.mHandler.removeCallbacks(this.fCJ);
        }
    }

    public void bvx() {
        this.mHandler.removeCallbacks(this.fCK);
        this.mHandler.postDelayed(this.fCK, 1000L);
    }

    public void bvy() {
        if (this.mHandler != null && this.fCK != null) {
            this.mHandler.removeCallbacks(this.fCK);
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
        if (this.fCm != null) {
            this.fCm.clearAnimation();
        }
        if (this.fCy != null) {
            this.fCy.onDestroy();
        }
        bvw();
        bvy();
        bvv();
    }

    public Animation bvz() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fCC != null) {
            this.fCC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0182a.sdk_push_up_out);
        this.fCm.setAnimation(loadAnimation);
        this.fCm.setVisibility(8);
        return loadAnimation;
    }
}
