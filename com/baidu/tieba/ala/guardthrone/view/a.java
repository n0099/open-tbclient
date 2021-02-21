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
    private ImageView gpT;
    private LinearLayout gzz;
    private RelativeLayout hdA;
    private TextView hdB;
    private TextView hdC;
    private com.baidu.tieba.ala.guardthrone.d.a hdD;
    private a.InterfaceC0644a hdE;
    private b hdF;
    private com.baidu.tieba.ala.guardthrone.adapter.a hdG;
    private Animation hdH;
    private boolean hdI;
    private long hdJ;
    private long hdK;
    private long hdL;
    private long hdM;
    private boolean hdN;
    private com.baidu.tieba.ala.guardthrone.b.a hdi;
    private View hdp;
    private FrameLayout hdq;
    private View hdr;
    private View hds;
    private HeadImageView hdt;
    private TbImageView hdu;
    private TextView hdv;
    private TextView hdw;
    private ListView hdx;
    private ScrollView hdy;
    private HListView hdz;
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
            if (a.this.hdD != null) {
                a.this.hdD.er(a.this.mLiveId, a.this.buH);
            }
        }
    };
    private final Runnable hdO = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hdJ <= 0) {
                a.this.hdJ = 0L;
                a.this.bWE();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.hdJ <= 0 || a.this.hdw == null || a.this.hdi == null || a.this.hdi.hcT == null || TextUtils.isEmpty(a.this.hdi.hcT.hcX)) {
                if (a.this.hdw != null && a.this.hdw.getVisibility() == 0) {
                    a.this.hdw.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.hdi.hcT.hcX + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hdJ));
            if (a.this.hdw.getVisibility() != 0) {
                a.this.hdw.setVisibility(0);
            }
            a.this.hdw.setText(str);
        }
    };
    private final Runnable hdP = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hdM <= 0) {
                a.this.hdM = 0L;
                a.this.bWG();
            } else {
                a.i(a.this);
                a.this.bWF();
            }
            if (a.this.hdM >= 0 && a.this.hdw != null && a.this.hdi != null && a.this.hdi.hcT != null && !TextUtils.isEmpty(a.this.hdi.hcT.hcX)) {
                a.this.hdw.setText(a.this.hdi.hcT.hcX + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.hdM)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.hdJ;
        aVar.hdJ = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.hdM;
        aVar.hdM = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.hdI = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = ns(this.hdI);
        this.hdp = this.mRootView.findViewById(a.f.content_layout);
        this.hdq = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.hdr = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.hds = this.mRootView.findViewById(a.f.view_foreground);
        this.gpT = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.hdt = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.hdu = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.hdv = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.hdw = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gzz = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.hdx = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.hdx.setDividerHeight(0);
        this.hdy = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.hdz = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.hdz.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.hdA = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.hdB = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.hdC = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bWw();
        bWx();
        bWy();
        bWz();
    }

    private void bWw() {
        this.hdt.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hdt.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hdt.setIsRound(true);
        this.hdt.setAutoChangeStyle(false);
        this.hdt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hdu.setDefaultResource(a.e.portrait_no_guard_bg);
        this.hdu.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bWx() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.hds.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.hds.setLayoutParams(layoutParams);
        }
    }

    private void bWy() {
        if (this.hdI) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hdr.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.hdr.setLayoutParams(layoutParams);
            this.hdA.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bWz() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdy.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.hdy.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.hdp.setOnClickListener(this);
        this.hdq.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gpT.setOnClickListener(this);
        this.hdC.setOnClickListener(this);
        this.hdA.setOnClickListener(this);
    }

    private void initModel() {
        bWA();
        this.hdD = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.hdE);
        this.hdD.er(this.mLiveId, this.buH);
    }

    private void bWA() {
        this.hdE = new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0644a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0644a
            public void onFail(int i, String str) {
                a.this.bwb = 5L;
                a.this.bf(a.this.bwb);
                if (a.this.mActivity != null && !a.this.hdN) {
                    a.this.hdN = true;
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
        if (aVar == null || aVar.hcT == null || aVar.hcU == null || this.mActivity == null) {
            this.bwb = 5L;
            bf(this.bwb);
            return;
        }
        this.hdi = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.hcT.hcW)) {
            this.hdu.startLoad(aVar.hcT.hcW, 10, false);
        }
        if (i == 1) {
            this.hdt.setVisibility(8);
        } else {
            String str = aVar.hcT.hcV;
            if (!TextUtils.isEmpty(str)) {
                this.hdt.setVisibility(0);
                this.hdt.startLoad(str, 12, false);
            } else {
                this.hdt.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.hcT.hcX)) {
                this.hdv.setVisibility(0);
                this.hdv.setText(aVar.hcT.hcX);
            } else {
                this.hdv.setVisibility(4);
            }
        } else {
            String str2 = aVar.hcT.username;
            if (!TextUtils.isEmpty(str2)) {
                this.hdv.setVisibility(0);
                this.hdv.setText(str2);
            } else {
                this.hdv.setVisibility(8);
            }
        }
        if (i == 1) {
            this.hdw.setVisibility(4);
        } else if (i == 2) {
            if (this.hdK != aVar.hcT.startTime || this.hdJ > aVar.hcT.countdown) {
                this.hdK = aVar.hcT.startTime;
                if (aVar.hcT.countdown > 0) {
                    this.hdJ = aVar.hcT.countdown;
                    if (!TextUtils.isEmpty(aVar.hcT.hcX)) {
                        this.hdw.setVisibility(0);
                        this.hdw.setText(aVar.hcT.hcX + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hdJ)));
                        if (this.mHandler != null && this.hdP != null) {
                            this.mHandler.removeCallbacks(this.hdP);
                        }
                        startCountDown();
                    }
                } else {
                    this.hdw.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.hdL != aVar.hcT.startTime || this.hdM != aVar.hcT.hda)) {
            this.hdL = aVar.hcT.startTime;
            if (aVar.hcT.hda >= 0) {
                this.hdM = aVar.hcT.hda;
                if (!TextUtils.isEmpty(aVar.hcT.hcX)) {
                    this.hdw.setVisibility(0);
                    this.hdw.setText(aVar.hcT.hcX + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.hdM)));
                    if (this.mHandler != null && this.hdO != null) {
                        this.mHandler.removeCallbacks(this.hdO);
                    }
                    bWF();
                }
            } else {
                this.hdw.setVisibility(8);
            }
        }
        if (i == 2) {
            this.hdz.setVisibility(8);
        } else if (aVar.hcT.hdc != null && aVar.hcT.hdc.size() > 0) {
            if (this.hdG == null) {
                this.hdG = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.hdz.setAdapter((ListAdapter) this.hdG);
            }
            this.hdG.setList(aVar.hcT.hdc);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.hdz);
            this.hdz.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdz.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.hdz.setLayoutParams(layoutParams);
            this.hdz.setVisibility(0);
        } else {
            this.hdz.setVisibility(8);
        }
        if (i == 2 && aVar.hcU.aGx != null && aVar.hcU.aGx.size() > 0) {
            if (this.hdF == null) {
                this.hdF = new b(this.mActivity);
                this.hdx.setAdapter((ListAdapter) this.hdF);
            }
            this.hdF.setList(aVar.hcU.aGx);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.hdx);
            this.gzz.setVisibility(0);
        } else {
            this.gzz.setVisibility(8);
        }
        if (this.mIsHost) {
            this.hdA.setVisibility(8);
        } else {
            this.hdA.setVisibility(0);
            if (aVar.hcU.hdd != null && !TextUtils.isEmpty(aVar.hcU.hdd.text)) {
                if (aVar.hcU.hdd.rank > 0 && aVar.hcU.hdd.rank < 4) {
                    this.hdB.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.hdB.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.hdB.setText(aVar.hcU.hdd.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.hcT.hcZ) && TextUtils.equals(aVar.hcT.hcZ, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.hdC.setVisibility(8);
            } else {
                this.hdC.setVisibility(0);
            }
        }
        this.bwb = aVar.hcT.hdb;
        bf(this.bwb);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.gpT) {
            bWB();
        } else if (view == this.hdC || view == this.hdA) {
            bWC();
        }
    }

    private void bWB() {
        if (this.mActivity == null || this.hdi == null || this.hdi.hcT == null || TextUtils.isEmpty(this.hdi.hcT.hcY)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.hdi.hcT.hcY}, false, null, true);
        }
    }

    private void bWC() {
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

    public void bWD() {
        if (this.mHandler != null && this.bwe != null) {
            this.mHandler.removeCallbacks(this.bwe);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hdO);
        this.mHandler.postDelayed(this.hdO, 1000L);
    }

    public void bWE() {
        if (this.mHandler != null && this.hdO != null) {
            this.mHandler.removeCallbacks(this.hdO);
        }
    }

    public void bWF() {
        this.mHandler.removeCallbacks(this.hdP);
        this.mHandler.postDelayed(this.hdP, 1000L);
    }

    public void bWG() {
        if (this.mHandler != null && this.hdP != null) {
            this.mHandler.removeCallbacks(this.hdP);
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
        if (this.hdr != null) {
            this.hdr.clearAnimation();
        }
        if (this.hdD != null) {
            this.hdD.onDestroy();
        }
        bWE();
        bWG();
        bWD();
    }

    public Animation bWH() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdH != null) {
            this.hdH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0195a.sdk_push_up_out);
        this.hdr.setAnimation(loadAnimation);
        this.hdr.setVisibility(8);
        return loadAnimation;
    }
}
