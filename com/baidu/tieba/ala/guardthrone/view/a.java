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
import com.baidu.live.data.ad;
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
    private String aIB;
    private String bhk;
    private long biw;
    private LinearLayout fGp;
    private ImageView fyV;
    private a.InterfaceC0610a giA;
    private b giB;
    private com.baidu.tieba.ala.guardthrone.adapter.a giC;
    private Animation giD;
    private boolean giE;
    private long giF;
    private long giG;
    private long giH;
    private long giI;
    private boolean giJ;
    private com.baidu.tieba.ala.guardthrone.b.a gie;
    private View gil;
    private FrameLayout gim;
    private View gin;
    private View gio;
    private HeadImageView gip;
    private TbImageView giq;
    private TextView gir;
    private TextView gis;
    private ListView git;
    private ScrollView giu;
    private HListView giv;
    private RelativeLayout giw;
    private TextView gix;
    private TextView giy;
    private com.baidu.tieba.ala.guardthrone.d.a giz;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable biz = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.giz != null) {
                a.this.giz.ea(a.this.mLiveId, a.this.bhk);
            }
        }
    };
    private final Runnable giK = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.giF <= 0) {
                a.this.giF = 0L;
                a.this.bMn();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.giF <= 0 || a.this.gis == null || a.this.gie == null || a.this.gie.ghO == null || TextUtils.isEmpty(a.this.gie.ghO.ghS)) {
                if (a.this.gis != null && a.this.gis.getVisibility() == 0) {
                    a.this.gis.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gie.ghO.ghS + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.giF));
            if (a.this.gis.getVisibility() != 0) {
                a.this.gis.setVisibility(0);
            }
            a.this.gis.setText(str);
        }
    };
    private final Runnable giL = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.giI <= 0) {
                a.this.giI = 0L;
                a.this.bMp();
            } else {
                a.i(a.this);
                a.this.bMo();
            }
            if (a.this.giI >= 0 && a.this.gis != null && a.this.gie != null && a.this.gie.ghO != null && !TextUtils.isEmpty(a.this.gie.ghO.ghS)) {
                a.this.gis.setText(a.this.gie.ghO.ghS + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.giI)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.giF;
        aVar.giF = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.giI;
        aVar.giI = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.giE = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = ly(this.giE);
        this.gil = this.mRootView.findViewById(a.g.content_layout);
        this.gim = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.gin = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.gio = this.mRootView.findViewById(a.g.view_foreground);
        this.fyV = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.gip = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.giq = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.gir = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.gis = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fGp = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.git = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.git.setDividerHeight(0);
        this.giu = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.giv = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.giv.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.giw = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.gix = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.giy = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bMf();
        bMg();
        bMh();
        bMi();
    }

    private void bMf() {
        this.gip.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gip.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gip.setIsRound(true);
        this.gip.setAutoChangeStyle(false);
        this.gip.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.giq.setDefaultResource(a.f.portrait_no_guard_bg);
        this.giq.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bMg() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gio.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gio.setLayoutParams(layoutParams);
        }
    }

    private void bMh() {
        if (this.giE) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gin.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gin.setLayoutParams(layoutParams);
            this.giw.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bMi() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.giu.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.giu.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gil.setOnClickListener(this);
        this.gim.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fyV.setOnClickListener(this);
        this.giy.setOnClickListener(this);
        this.giw.setOnClickListener(this);
    }

    private void HI() {
        bMj();
        this.giz = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.giA);
        this.giz.ea(this.mLiveId, this.bhk);
    }

    private void bMj() {
        this.giA = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0610a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0610a
            public void onFail(int i, String str) {
                a.this.biw = 5L;
                a.this.ap(a.this.biw);
                if (a.this.mActivity != null && !a.this.giJ) {
                    a.this.giJ = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bhk = str2;
        this.aIB = str3;
        this.mTabId = i;
        HI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.ghO == null || aVar.ghP == null || this.mActivity == null) {
            this.biw = 5L;
            ap(this.biw);
            return;
        }
        this.gie = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.ghO.ghR)) {
            this.giq.startLoad(aVar.ghO.ghR, 10, false);
        }
        if (i == 1) {
            this.gip.setVisibility(8);
        } else {
            String str = aVar.ghO.ghQ;
            if (!TextUtils.isEmpty(str)) {
                this.gip.setVisibility(0);
                this.gip.startLoad(str, 12, false);
            } else {
                this.gip.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.ghO.ghS)) {
                this.gir.setVisibility(0);
                this.gir.setText(aVar.ghO.ghS);
            } else {
                this.gir.setVisibility(4);
            }
        } else {
            String str2 = aVar.ghO.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gir.setVisibility(0);
                this.gir.setText(str2);
            } else {
                this.gir.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gis.setVisibility(4);
        } else if (i == 2) {
            if (this.giG != aVar.ghO.startTime || this.giF > aVar.ghO.ghV) {
                this.giG = aVar.ghO.startTime;
                if (aVar.ghO.ghV > 0) {
                    this.giF = aVar.ghO.ghV;
                    if (!TextUtils.isEmpty(aVar.ghO.ghS)) {
                        this.gis.setVisibility(0);
                        this.gis.setText(aVar.ghO.ghS + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.giF)));
                        if (this.mHandler != null && this.giL != null) {
                            this.mHandler.removeCallbacks(this.giL);
                        }
                        startCountDown();
                    }
                } else {
                    this.gis.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.giH != aVar.ghO.startTime || this.giI != aVar.ghO.ghW)) {
            this.giH = aVar.ghO.startTime;
            if (aVar.ghO.ghW >= 0) {
                this.giI = aVar.ghO.ghW;
                if (!TextUtils.isEmpty(aVar.ghO.ghS)) {
                    this.gis.setVisibility(0);
                    this.gis.setText(aVar.ghO.ghS + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.giI)));
                    if (this.mHandler != null && this.giK != null) {
                        this.mHandler.removeCallbacks(this.giK);
                    }
                    bMo();
                }
            } else {
                this.gis.setVisibility(8);
            }
        }
        if (i == 2) {
            this.giv.setVisibility(8);
        } else if (aVar.ghO.ghY != null && aVar.ghO.ghY.size() > 0) {
            if (this.giC == null) {
                this.giC = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.giv.setAdapter((ListAdapter) this.giC);
            }
            this.giC.setList(aVar.ghO.ghY);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.giv);
            this.giv.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.giv.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.giv.setLayoutParams(layoutParams);
            this.giv.setVisibility(0);
        } else {
            this.giv.setVisibility(8);
        }
        if (i == 2 && aVar.ghP.aDV != null && aVar.ghP.aDV.size() > 0) {
            if (this.giB == null) {
                this.giB = new b(this.mActivity);
                this.git.setAdapter((ListAdapter) this.giB);
            }
            this.giB.setList(aVar.ghP.aDV);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.git);
            this.fGp.setVisibility(0);
        } else {
            this.fGp.setVisibility(8);
        }
        if (this.mIsHost) {
            this.giw.setVisibility(8);
        } else {
            this.giw.setVisibility(0);
            if (aVar.ghP.ghZ != null && !TextUtils.isEmpty(aVar.ghP.ghZ.text)) {
                if (aVar.ghP.ghZ.rank > 0 && aVar.ghP.ghZ.rank < 4) {
                    this.gix.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.gix.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.gix.setText(aVar.ghP.ghZ.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.ghO.ghU) && TextUtils.equals(aVar.ghO.ghU, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.giy.setVisibility(8);
            } else {
                this.giy.setVisibility(0);
            }
        }
        this.biw = aVar.ghO.ghX;
        ap(this.biw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fyV) {
            bMk();
        } else if (view == this.giy || view == this.giw) {
            bMl();
        }
    }

    private void bMk() {
        if (this.mActivity == null || this.gie == null || this.gie.ghO == null || TextUtils.isEmpty(this.gie.ghO.ghT)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gie.ghO.ghT}, false, null, true);
        }
    }

    private void bMl() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ad adVar = new ad();
            adVar.aFN = Integer.parseInt(this.aIB);
            adVar.aFL = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ap(long j) {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
            this.mHandler.postDelayed(this.biz, 1000 * j);
        }
    }

    public void bMm() {
        if (this.mHandler != null && this.biz != null) {
            this.mHandler.removeCallbacks(this.biz);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.giK);
        this.mHandler.postDelayed(this.giK, 1000L);
    }

    public void bMn() {
        if (this.mHandler != null && this.giK != null) {
            this.mHandler.removeCallbacks(this.giK);
        }
    }

    public void bMo() {
        this.mHandler.removeCallbacks(this.giL);
        this.mHandler.postDelayed(this.giL, 1000L);
    }

    public void bMp() {
        if (this.mHandler != null && this.giL != null) {
            this.mHandler.removeCallbacks(this.giL);
        }
    }

    public void bbL() {
    }

    private View ly(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gin != null) {
            this.gin.clearAnimation();
        }
        if (this.giz != null) {
            this.giz.onDestroy();
        }
        bMn();
        bMp();
        bMm();
    }

    public Animation bMq() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.giD != null) {
            this.giD.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0186a.sdk_push_up_out);
        this.gin.setAnimation(loadAnimation);
        this.gin.setVisibility(8);
        return loadAnimation;
    }
}
