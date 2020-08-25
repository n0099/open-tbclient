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
import com.baidu.live.data.y;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private String aHi;
    private String ber;
    private long bfC;
    private LinearLayout fCZ;
    private ImageView fvG;
    private com.baidu.tieba.ala.guardthrone.b.a geP;
    private View geW;
    private FrameLayout geX;
    private View geY;
    private View geZ;
    private HeadImageView gfa;
    private TbImageView gfb;
    private TextView gfc;
    private TextView gfd;
    private ListView gfe;
    private ScrollView gff;
    private HListView gfg;
    private RelativeLayout gfh;
    private TextView gfi;
    private TextView gfj;
    private com.baidu.tieba.ala.guardthrone.d.a gfk;
    private a.InterfaceC0614a gfl;
    private b gfm;
    private com.baidu.tieba.ala.guardthrone.adapter.a gfn;
    private Animation gfo;
    private boolean gfp;
    private long gfq;
    private long gfr;
    private long gfs;
    private long gft;
    private boolean gfu;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bfF = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gfk != null) {
                a.this.gfk.dX(a.this.mLiveId, a.this.ber);
            }
        }
    };
    private final Runnable gfv = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gfq <= 0) {
                a.this.gfq = 0L;
                a.this.bLc();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gfq <= 0 || a.this.gfd == null || a.this.geP == null || a.this.geP.gez == null || TextUtils.isEmpty(a.this.geP.gez.geD)) {
                if (a.this.gfd != null && a.this.gfd.getVisibility() == 0) {
                    a.this.gfd.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.geP.gez.geD + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.gfq));
            if (a.this.gfd.getVisibility() != 0) {
                a.this.gfd.setVisibility(0);
            }
            a.this.gfd.setText(str);
        }
    };
    private final Runnable gfw = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gft <= 0) {
                a.this.gft = 0L;
                a.this.bLe();
            } else {
                a.i(a.this);
                a.this.bLd();
            }
            if (a.this.gft >= 0 && a.this.gfd != null && a.this.geP != null && a.this.geP.gez != null && !TextUtils.isEmpty(a.this.geP.gez.geD)) {
                a.this.gfd.setText(a.this.geP.gez.geD + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.gft)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gfq;
        aVar.gfq = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gft;
        aVar.gft = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gfp = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = lu(this.gfp);
        this.geW = this.mRootView.findViewById(a.g.content_layout);
        this.geX = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.geY = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.geZ = this.mRootView.findViewById(a.g.view_foreground);
        this.fvG = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.gfa = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.gfb = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.gfc = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.gfd = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fCZ = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.gfe = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.gfe.setDividerHeight(0);
        this.gff = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.gfg = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.gfg.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gfh = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.gfi = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.gfj = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bKU();
        bKV();
        bKW();
        bKX();
    }

    private void bKU() {
        this.gfa.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gfa.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gfa.setIsRound(true);
        this.gfa.setAutoChangeStyle(false);
        this.gfa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfb.setDefaultResource(a.f.portrait_no_guard_bg);
        this.gfb.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bKV() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.geZ.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.geZ.setLayoutParams(layoutParams);
        }
    }

    private void bKW() {
        if (this.gfp) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.geY.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.geY.setLayoutParams(layoutParams);
            this.gfh.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bKX() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gff.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gff.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.geW.setOnClickListener(this);
        this.geX.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fvG.setOnClickListener(this);
        this.gfj.setOnClickListener(this);
        this.gfh.setOnClickListener(this);
    }

    private void Hh() {
        bKY();
        this.gfk = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gfl);
        this.gfk.dX(this.mLiveId, this.ber);
    }

    private void bKY() {
        this.gfl = new a.InterfaceC0614a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0614a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0614a
            public void onFail(int i, String str) {
                a.this.bfC = 5L;
                a.this.ap(a.this.bfC);
                if (a.this.mActivity != null && !a.this.gfu) {
                    a.this.gfu = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.ber = str2;
        this.aHi = str3;
        this.mTabId = i;
        Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gez == null || aVar.geA == null || this.mActivity == null) {
            this.bfC = 5L;
            ap(this.bfC);
            return;
        }
        this.geP = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gez.geC)) {
            this.gfb.startLoad(aVar.gez.geC, 10, false);
        }
        if (i == 1) {
            this.gfa.setVisibility(8);
        } else {
            String str = aVar.gez.geB;
            if (!TextUtils.isEmpty(str)) {
                this.gfa.setVisibility(0);
                this.gfa.startLoad(str, 12, false);
            } else {
                this.gfa.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gez.geD)) {
                this.gfc.setVisibility(0);
                this.gfc.setText(aVar.gez.geD);
            } else {
                this.gfc.setVisibility(4);
            }
        } else {
            String str2 = aVar.gez.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gfc.setVisibility(0);
                this.gfc.setText(str2);
            } else {
                this.gfc.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gfd.setVisibility(4);
        } else if (i == 2) {
            if (this.gfr != aVar.gez.startTime || this.gfq > aVar.gez.geG) {
                this.gfr = aVar.gez.startTime;
                if (aVar.gez.geG > 0) {
                    this.gfq = aVar.gez.geG;
                    if (!TextUtils.isEmpty(aVar.gez.geD)) {
                        this.gfd.setVisibility(0);
                        this.gfd.setText(aVar.gez.geD + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.gfq)));
                        if (this.mHandler != null && this.gfw != null) {
                            this.mHandler.removeCallbacks(this.gfw);
                        }
                        startCountDown();
                    }
                } else {
                    this.gfd.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gfs != aVar.gez.startTime || this.gft != aVar.gez.geH)) {
            this.gfs = aVar.gez.startTime;
            if (aVar.gez.geH >= 0) {
                this.gft = aVar.gez.geH;
                if (!TextUtils.isEmpty(aVar.gez.geD)) {
                    this.gfd.setVisibility(0);
                    this.gfd.setText(aVar.gez.geD + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.gft)));
                    if (this.mHandler != null && this.gfv != null) {
                        this.mHandler.removeCallbacks(this.gfv);
                    }
                    bLd();
                }
            } else {
                this.gfd.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gfg.setVisibility(8);
        } else if (aVar.gez.geJ != null && aVar.gez.geJ.size() > 0) {
            if (this.gfn == null) {
                this.gfn = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gfg.setAdapter((ListAdapter) this.gfn);
            }
            this.gfn.setList(aVar.gez.geJ);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gfg);
            this.gfg.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gfg.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.gfg.setLayoutParams(layoutParams);
            this.gfg.setVisibility(0);
        } else {
            this.gfg.setVisibility(8);
        }
        if (i == 2 && aVar.geA.geL != null && aVar.geA.geL.size() > 0) {
            if (this.gfm == null) {
                this.gfm = new b(this.mActivity);
                this.gfe.setAdapter((ListAdapter) this.gfm);
            }
            this.gfm.setList(aVar.geA.geL);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gfe);
            this.fCZ.setVisibility(0);
        } else {
            this.fCZ.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gfh.setVisibility(8);
        } else {
            this.gfh.setVisibility(0);
            if (aVar.geA.geK != null && !TextUtils.isEmpty(aVar.geA.geK.text)) {
                if (aVar.geA.geK.rank > 0 && aVar.geA.geK.rank < 4) {
                    this.gfi.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.gfi.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.gfi.setText(aVar.geA.geK.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gez.geF) && TextUtils.equals(aVar.gez.geF, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gfj.setVisibility(8);
            } else {
                this.gfj.setVisibility(0);
            }
        }
        this.bfC = aVar.gez.geI;
        ap(this.bfC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fvG) {
            bKZ();
        } else if (view == this.gfj || view == this.gfh) {
            bLa();
        }
    }

    private void bKZ() {
        if (this.mActivity == null || this.geP == null || this.geP.gez == null || TextUtils.isEmpty(this.geP.gez.geE)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.geP.gez.geE}, false, null, true);
        }
    }

    private void bLa() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            y yVar = new y();
            yVar.aEA = Integer.parseInt(this.aHi);
            yVar.aEy = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ap(long j) {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
            this.mHandler.postDelayed(this.bfF, 1000 * j);
        }
    }

    public void bLb() {
        if (this.mHandler != null && this.bfF != null) {
            this.mHandler.removeCallbacks(this.bfF);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gfv);
        this.mHandler.postDelayed(this.gfv, 1000L);
    }

    public void bLc() {
        if (this.mHandler != null && this.gfv != null) {
            this.mHandler.removeCallbacks(this.gfv);
        }
    }

    public void bLd() {
        this.mHandler.removeCallbacks(this.gfw);
        this.mHandler.postDelayed(this.gfw, 1000L);
    }

    public void bLe() {
        if (this.mHandler != null && this.gfw != null) {
            this.mHandler.removeCallbacks(this.gfw);
        }
    }

    public void baR() {
    }

    private View lu(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.geY != null) {
            this.geY.clearAnimation();
        }
        if (this.gfk != null) {
            this.gfk.onDestroy();
        }
        bLc();
        bLe();
        bLb();
    }

    public Animation bLf() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gfo != null) {
            this.gfo.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0185a.sdk_push_up_out);
        this.geY.setAnimation(loadAnimation);
        this.geY.setVisibility(8);
        return loadAnimation;
    }
}
