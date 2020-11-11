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
    private String aNj;
    private String bnP;
    private long bpd;
    private ImageView fZl;
    private RelativeLayout gKA;
    private TextView gKB;
    private TextView gKC;
    private com.baidu.tieba.ala.guardthrone.d.a gKD;
    private a.InterfaceC0655a gKE;
    private b gKF;
    private com.baidu.tieba.ala.guardthrone.adapter.a gKG;
    private Animation gKH;
    private boolean gKI;
    private long gKJ;
    private long gKK;
    private long gKL;
    private long gKM;
    private boolean gKN;
    private com.baidu.tieba.ala.guardthrone.b.a gKi;
    private View gKp;
    private FrameLayout gKq;
    private View gKr;
    private View gKs;
    private HeadImageView gKt;
    private TbImageView gKu;
    private TextView gKv;
    private TextView gKw;
    private ListView gKx;
    private ScrollView gKy;
    private HListView gKz;
    private LinearLayout gir;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bpg = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKD != null) {
                a.this.gKD.en(a.this.mLiveId, a.this.bnP);
            }
        }
    };
    private final Runnable gKO = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKJ <= 0) {
                a.this.gKJ = 0L;
                a.this.bUb();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gKJ <= 0 || a.this.gKw == null || a.this.gKi == null || a.this.gKi.gJU == null || TextUtils.isEmpty(a.this.gKi.gJU.gJY)) {
                if (a.this.gKw != null && a.this.gKw.getVisibility() == 0) {
                    a.this.gKw.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gKi.gJU.gJY + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(a.this.gKJ));
            if (a.this.gKw.getVisibility() != 0) {
                a.this.gKw.setVisibility(0);
            }
            a.this.gKw.setText(str);
        }
    };
    private final Runnable gKP = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gKM <= 0) {
                a.this.gKM = 0L;
                a.this.bUd();
            } else {
                a.i(a.this);
                a.this.bUc();
            }
            if (a.this.gKM >= 0 && a.this.gKw != null && a.this.gKi != null && a.this.gKi.gJU != null && !TextUtils.isEmpty(a.this.gKi.gJU.gJY)) {
                a.this.gKw.setText(a.this.gKi.gJU.gJY + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(a.this.gKM)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gKJ;
        aVar.gKJ = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gKM;
        aVar.gKM = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gKI = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = mv(this.gKI);
        this.gKp = this.mRootView.findViewById(a.f.content_layout);
        this.gKq = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.gKr = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.gKs = this.mRootView.findViewById(a.f.view_foreground);
        this.fZl = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.gKt = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.gKu = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.gKv = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.gKw = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gir = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.gKx = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.gKx.setDividerHeight(0);
        this.gKy = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.gKz = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.gKz.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.gKA = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.gKB = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.gKC = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bTT();
        bTU();
        bTV();
        bTW();
    }

    private void bTT() {
        this.gKt.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gKt.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.gKt.setIsRound(true);
        this.gKt.setAutoChangeStyle(false);
        this.gKt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gKu.setDefaultResource(a.e.portrait_no_guard_bg);
        this.gKu.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bTU() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gKs.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gKs.setLayoutParams(layoutParams);
        }
    }

    private void bTV() {
        if (this.gKI) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gKr.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gKr.setLayoutParams(layoutParams);
            this.gKA.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bTW() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKy.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gKy.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gKp.setOnClickListener(this);
        this.gKq.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fZl.setOnClickListener(this);
        this.gKC.setOnClickListener(this);
        this.gKA.setOnClickListener(this);
    }

    private void Jz() {
        bTX();
        this.gKD = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gKE);
        this.gKD.en(this.mLiveId, this.bnP);
    }

    private void bTX() {
        this.gKE = new a.InterfaceC0655a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0655a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0655a
            public void onFail(int i, String str) {
                a.this.bpd = 5L;
                a.this.aD(a.this.bpd);
                if (a.this.mActivity != null && !a.this.gKN) {
                    a.this.gKN = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bnP = str2;
        this.aNj = str3;
        this.mTabId = i;
        Jz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gJU == null || aVar.gJV == null || this.mActivity == null) {
            this.bpd = 5L;
            aD(this.bpd);
            return;
        }
        this.gKi = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gJU.gJX)) {
            this.gKu.startLoad(aVar.gJU.gJX, 10, false);
        }
        if (i == 1) {
            this.gKt.setVisibility(8);
        } else {
            String str = aVar.gJU.gJW;
            if (!TextUtils.isEmpty(str)) {
                this.gKt.setVisibility(0);
                this.gKt.startLoad(str, 12, false);
            } else {
                this.gKt.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gJU.gJY)) {
                this.gKv.setVisibility(0);
                this.gKv.setText(aVar.gJU.gJY);
            } else {
                this.gKv.setVisibility(4);
            }
        } else {
            String str2 = aVar.gJU.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gKv.setVisibility(0);
                this.gKv.setText(str2);
            } else {
                this.gKv.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gKw.setVisibility(4);
        } else if (i == 2) {
            if (this.gKK != aVar.gJU.startTime || this.gKJ > aVar.gJU.bvC) {
                this.gKK = aVar.gJU.startTime;
                if (aVar.gJU.bvC > 0) {
                    this.gKJ = aVar.gJU.bvC;
                    if (!TextUtils.isEmpty(aVar.gJU.gJY)) {
                        this.gKw.setVisibility(0);
                        this.gKw.setText(aVar.gJU.gJY + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(this.gKJ)));
                        if (this.mHandler != null && this.gKP != null) {
                            this.mHandler.removeCallbacks(this.gKP);
                        }
                        startCountDown();
                    }
                } else {
                    this.gKw.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gKL != aVar.gJU.startTime || this.gKM != aVar.gJU.gKb)) {
            this.gKL = aVar.gJU.startTime;
            if (aVar.gJU.gKb >= 0) {
                this.gKM = aVar.gJU.gKb;
                if (!TextUtils.isEmpty(aVar.gJU.gJY)) {
                    this.gKw.setVisibility(0);
                    this.gKw.setText(aVar.gJU.gJY + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(this.gKM)));
                    if (this.mHandler != null && this.gKO != null) {
                        this.mHandler.removeCallbacks(this.gKO);
                    }
                    bUc();
                }
            } else {
                this.gKw.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gKz.setVisibility(8);
        } else if (aVar.gJU.gKd != null && aVar.gJU.gKd.size() > 0) {
            if (this.gKG == null) {
                this.gKG = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gKz.setAdapter((ListAdapter) this.gKG);
            }
            this.gKG.setList(aVar.gJU.gKd);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gKz);
            this.gKz.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKz.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.gKz.setLayoutParams(layoutParams);
            this.gKz.setVisibility(0);
        } else {
            this.gKz.setVisibility(8);
        }
        if (i == 2 && aVar.gJV.aIb != null && aVar.gJV.aIb.size() > 0) {
            if (this.gKF == null) {
                this.gKF = new b(this.mActivity);
                this.gKx.setAdapter((ListAdapter) this.gKF);
            }
            this.gKF.setList(aVar.gJV.aIb);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gKx);
            this.gir.setVisibility(0);
        } else {
            this.gir.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gKA.setVisibility(8);
        } else {
            this.gKA.setVisibility(0);
            if (aVar.gJV.gKe != null && !TextUtils.isEmpty(aVar.gJV.gKe.text)) {
                if (aVar.gJV.gKe.rank > 0 && aVar.gJV.gKe.rank < 4) {
                    this.gKB.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.gKB.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.gKB.setText(aVar.gJV.gKe.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gJU.gKa) && TextUtils.equals(aVar.gJU.gKa, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gKC.setVisibility(8);
            } else {
                this.gKC.setVisibility(0);
            }
        }
        this.bpd = aVar.gJU.gKc;
        aD(this.bpd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fZl) {
            bTY();
        } else if (view == this.gKC || view == this.gKA) {
            bTZ();
        }
    }

    private void bTY() {
        if (this.mActivity == null || this.gKi == null || this.gKi.gJU == null || TextUtils.isEmpty(this.gKi.gJU.gJZ)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gKi.gJU.gJZ}, false, null, true);
        }
    }

    private void bTZ() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ah ahVar = new ah();
            ahVar.aKt = Integer.parseInt(this.aNj);
            ahVar.aKr = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void aD(long j) {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
            this.mHandler.postDelayed(this.bpg, 1000 * j);
        }
    }

    public void bUa() {
        if (this.mHandler != null && this.bpg != null) {
            this.mHandler.removeCallbacks(this.bpg);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gKO);
        this.mHandler.postDelayed(this.gKO, 1000L);
    }

    public void bUb() {
        if (this.mHandler != null && this.gKO != null) {
            this.mHandler.removeCallbacks(this.gKO);
        }
    }

    public void bUc() {
        this.mHandler.removeCallbacks(this.gKP);
        this.mHandler.postDelayed(this.gKP, 1000L);
    }

    public void bUd() {
        if (this.mHandler != null && this.gKP != null) {
            this.mHandler.removeCallbacks(this.gKP);
        }
    }

    public void biM() {
    }

    private View mv(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gKr != null) {
            this.gKr.clearAnimation();
        }
        if (this.gKD != null) {
            this.gKD.onDestroy();
        }
        bUb();
        bUd();
        bUa();
    }

    public Animation bUe() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gKH != null) {
            this.gKH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0197a.sdk_push_up_out);
        this.gKr.setAnimation(loadAnimation);
        this.gKr.setVisibility(8);
        return loadAnimation;
    }
}
