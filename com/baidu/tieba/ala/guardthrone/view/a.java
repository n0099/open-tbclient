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
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private String aNa;
    private String buH;
    private long bwb;
    private ImageView gpF;
    private LinearLayout gzl;
    private com.baidu.tieba.ala.guardthrone.b.a hcU;
    private View hdb;
    private FrameLayout hdc;
    private View hdd;
    private View hde;
    private HeadImageView hdf;
    private TbImageView hdg;
    private TextView hdh;
    private TextView hdi;
    private ListView hdj;
    private ScrollView hdk;
    private HListView hdl;
    private RelativeLayout hdm;
    private TextView hdn;
    private TextView hdo;
    private com.baidu.tieba.ala.guardthrone.d.a hdp;
    private a.InterfaceC0643a hdq;
    private b hdr;
    private com.baidu.tieba.ala.guardthrone.adapter.a hds;
    private Animation hdt;
    private boolean hdu;
    private long hdv;
    private long hdw;
    private long hdx;
    private long hdy;
    private boolean hdz;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bwe = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hdp != null) {
                a.this.hdp.er(a.this.mLiveId, a.this.buH);
            }
        }
    };
    private final Runnable hdA = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hdv <= 0) {
                a.this.hdv = 0L;
                a.this.bWx();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.hdv <= 0 || a.this.hdi == null || a.this.hcU == null || a.this.hcU.hcF == null || TextUtils.isEmpty(a.this.hcU.hcF.hcJ)) {
                if (a.this.hdi != null && a.this.hdi.getVisibility() == 0) {
                    a.this.hdi.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.hcU.hcF.hcJ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hdv));
            if (a.this.hdi.getVisibility() != 0) {
                a.this.hdi.setVisibility(0);
            }
            a.this.hdi.setText(str);
        }
    };
    private final Runnable hdB = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hdy <= 0) {
                a.this.hdy = 0L;
                a.this.bWz();
            } else {
                a.i(a.this);
                a.this.bWy();
            }
            if (a.this.hdy >= 0 && a.this.hdi != null && a.this.hcU != null && a.this.hcU.hcF != null && !TextUtils.isEmpty(a.this.hcU.hcF.hcJ)) {
                a.this.hdi.setText(a.this.hcU.hcF.hcJ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hdy)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.hdv;
        aVar.hdv = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.hdy;
        aVar.hdy = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.hdu = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = ns(this.hdu);
        this.hdb = this.mRootView.findViewById(a.f.content_layout);
        this.hdc = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.hdd = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.hde = this.mRootView.findViewById(a.f.view_foreground);
        this.gpF = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.hdf = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.hdg = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.hdh = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.hdi = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gzl = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.hdj = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.hdj.setDividerHeight(0);
        this.hdk = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.hdl = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.hdl.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.hdm = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.hdn = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.hdo = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bWp();
        bWq();
        bWr();
        bWs();
    }

    private void bWp() {
        this.hdf.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hdf.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hdf.setIsRound(true);
        this.hdf.setAutoChangeStyle(false);
        this.hdf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hdg.setDefaultResource(a.e.portrait_no_guard_bg);
        this.hdg.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bWq() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.hde.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.hde.setLayoutParams(layoutParams);
        }
    }

    private void bWr() {
        if (this.hdu) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdd.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.hdd.setLayoutParams(layoutParams);
            this.hdm.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bWs() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdk.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.hdk.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.hdb.setOnClickListener(this);
        this.hdc.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gpF.setOnClickListener(this);
        this.hdo.setOnClickListener(this);
        this.hdm.setOnClickListener(this);
    }

    private void initModel() {
        bWt();
        this.hdp = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.hdq);
        this.hdp.er(this.mLiveId, this.buH);
    }

    private void bWt() {
        this.hdq = new a.InterfaceC0643a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void onFail(int i, String str) {
                a.this.bwb = 5L;
                a.this.bf(a.this.bwb);
                if (a.this.mActivity != null && !a.this.hdz) {
                    a.this.hdz = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void i(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.buH = str2;
        this.aNa = str3;
        this.mTabId = i;
        initModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.hcF == null || aVar.hcG == null || this.mActivity == null) {
            this.bwb = 5L;
            bf(this.bwb);
            return;
        }
        this.hcU = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.hcF.hcI)) {
            this.hdg.startLoad(aVar.hcF.hcI, 10, false);
        }
        if (i == 1) {
            this.hdf.setVisibility(8);
        } else {
            String str = aVar.hcF.hcH;
            if (!TextUtils.isEmpty(str)) {
                this.hdf.setVisibility(0);
                this.hdf.startLoad(str, 12, false);
            } else {
                this.hdf.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.hcF.hcJ)) {
                this.hdh.setVisibility(0);
                this.hdh.setText(aVar.hcF.hcJ);
            } else {
                this.hdh.setVisibility(4);
            }
        } else {
            String str2 = aVar.hcF.username;
            if (!TextUtils.isEmpty(str2)) {
                this.hdh.setVisibility(0);
                this.hdh.setText(str2);
            } else {
                this.hdh.setVisibility(8);
            }
        }
        if (i == 1) {
            this.hdi.setVisibility(4);
        } else if (i == 2) {
            if (this.hdw != aVar.hcF.startTime || this.hdv > aVar.hcF.countdown) {
                this.hdw = aVar.hcF.startTime;
                if (aVar.hcF.countdown > 0) {
                    this.hdv = aVar.hcF.countdown;
                    if (!TextUtils.isEmpty(aVar.hcF.hcJ)) {
                        this.hdi.setVisibility(0);
                        this.hdi.setText(aVar.hcF.hcJ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hdv)));
                        if (this.mHandler != null && this.hdB != null) {
                            this.mHandler.removeCallbacks(this.hdB);
                        }
                        startCountDown();
                    }
                } else {
                    this.hdi.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.hdx != aVar.hcF.startTime || this.hdy != aVar.hcF.hcM)) {
            this.hdx = aVar.hcF.startTime;
            if (aVar.hcF.hcM >= 0) {
                this.hdy = aVar.hcF.hcM;
                if (!TextUtils.isEmpty(aVar.hcF.hcJ)) {
                    this.hdi.setVisibility(0);
                    this.hdi.setText(aVar.hcF.hcJ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hdy)));
                    if (this.mHandler != null && this.hdA != null) {
                        this.mHandler.removeCallbacks(this.hdA);
                    }
                    bWy();
                }
            } else {
                this.hdi.setVisibility(8);
            }
        }
        if (i == 2) {
            this.hdl.setVisibility(8);
        } else if (aVar.hcF.hcO != null && aVar.hcF.hcO.size() > 0) {
            if (this.hds == null) {
                this.hds = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.hdl.setAdapter((ListAdapter) this.hds);
            }
            this.hds.setList(aVar.hcF.hcO);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.hdl);
            this.hdl.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdl.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.hdl.setLayoutParams(layoutParams);
            this.hdl.setVisibility(0);
        } else {
            this.hdl.setVisibility(8);
        }
        if (i == 2 && aVar.hcG.aGx != null && aVar.hcG.aGx.size() > 0) {
            if (this.hdr == null) {
                this.hdr = new b(this.mActivity);
                this.hdj.setAdapter((ListAdapter) this.hdr);
            }
            this.hdr.setList(aVar.hcG.aGx);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.hdj);
            this.gzl.setVisibility(0);
        } else {
            this.gzl.setVisibility(8);
        }
        if (this.mIsHost) {
            this.hdm.setVisibility(8);
        } else {
            this.hdm.setVisibility(0);
            if (aVar.hcG.hcP != null && !TextUtils.isEmpty(aVar.hcG.hcP.text)) {
                if (aVar.hcG.hcP.rank > 0 && aVar.hcG.hcP.rank < 4) {
                    this.hdn.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.hdn.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.hdn.setText(aVar.hcG.hcP.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.hcF.hcL) && TextUtils.equals(aVar.hcF.hcL, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.hdo.setVisibility(8);
            } else {
                this.hdo.setVisibility(0);
            }
        }
        this.bwb = aVar.hcF.hcN;
        bf(this.bwb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.gpF) {
            bWu();
        } else if (view == this.hdo || view == this.hdm) {
            bWv();
        }
    }

    private void bWu() {
        if (this.mActivity == null || this.hcU == null || this.hcU.hcF == null || TextUtils.isEmpty(this.hcU.hcF.hcK)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.hcU.hcF.hcK}, false, null, true);
        }
    }

    private void bWv() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ao aoVar = new ao();
            aoVar.aJX = Integer.parseInt(this.aNa);
            aoVar.aJV = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void bf(long j) {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
            this.mHandler.postDelayed(this.bwe, 1000 * j);
        }
    }

    public void bWw() {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hdA);
        this.mHandler.postDelayed(this.hdA, 1000L);
    }

    public void bWx() {
        if (this.mHandler != null && this.hdA != null) {
            this.mHandler.removeCallbacks(this.hdA);
        }
    }

    public void bWy() {
        this.mHandler.removeCallbacks(this.hdB);
        this.mHandler.postDelayed(this.hdB, 1000L);
    }

    public void bWz() {
        if (this.mHandler != null && this.hdB != null) {
            this.mHandler.removeCallbacks(this.hdB);
        }
    }

    public void bkp() {
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
        if (this.hdd != null) {
            this.hdd.clearAnimation();
        }
        if (this.hdp != null) {
            this.hdp.onDestroy();
        }
        bWx();
        bWz();
        bWw();
    }

    public Animation bWA() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdt != null) {
            this.hdt.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0195a.sdk_push_up_out);
        this.hdd.setAnimation(loadAnimation);
        this.hdd.setVisibility(8);
        return loadAnimation;
    }
}
