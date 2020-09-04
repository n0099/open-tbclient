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
    private String aHk;
    private String beu;
    private long bfE;
    private LinearLayout fDd;
    private ImageView fvK;
    private com.baidu.tieba.ala.guardthrone.b.a geT;
    private View gfa;
    private FrameLayout gfb;
    private View gfc;
    private View gfd;
    private HeadImageView gfe;
    private TbImageView gff;
    private TextView gfg;
    private TextView gfh;
    private ListView gfi;
    private ScrollView gfj;
    private HListView gfk;
    private RelativeLayout gfl;
    private TextView gfm;
    private TextView gfn;
    private com.baidu.tieba.ala.guardthrone.d.a gfo;
    private a.InterfaceC0614a gfp;
    private b gfq;
    private com.baidu.tieba.ala.guardthrone.adapter.a gfr;
    private Animation gfs;
    private boolean gft;
    private long gfu;
    private long gfv;
    private long gfw;
    private long gfx;
    private boolean gfy;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bfH = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gfo != null) {
                a.this.gfo.dY(a.this.mLiveId, a.this.beu);
            }
        }
    };
    private final Runnable gfz = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gfu <= 0) {
                a.this.gfu = 0L;
                a.this.bLd();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gfu <= 0 || a.this.gfh == null || a.this.geT == null || a.this.geT.geD == null || TextUtils.isEmpty(a.this.geT.geD.geH)) {
                if (a.this.gfh != null && a.this.gfh.getVisibility() == 0) {
                    a.this.gfh.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.geT.geD.geH + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.gfu));
            if (a.this.gfh.getVisibility() != 0) {
                a.this.gfh.setVisibility(0);
            }
            a.this.gfh.setText(str);
        }
    };
    private final Runnable gfA = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gfx <= 0) {
                a.this.gfx = 0L;
                a.this.bLf();
            } else {
                a.i(a.this);
                a.this.bLe();
            }
            if (a.this.gfx >= 0 && a.this.gfh != null && a.this.geT != null && a.this.geT.geD != null && !TextUtils.isEmpty(a.this.geT.geD.geH)) {
                a.this.gfh.setText(a.this.geT.geD.geH + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.gfx)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gfu;
        aVar.gfu = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gfx;
        aVar.gfx = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gft = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = lw(this.gft);
        this.gfa = this.mRootView.findViewById(a.g.content_layout);
        this.gfb = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.gfc = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.gfd = this.mRootView.findViewById(a.g.view_foreground);
        this.fvK = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.gfe = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.gff = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.gfg = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.gfh = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fDd = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.gfi = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.gfi.setDividerHeight(0);
        this.gfj = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.gfk = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.gfk.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gfl = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.gfm = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.gfn = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bKV();
        bKW();
        bKX();
        bKY();
    }

    private void bKV() {
        this.gfe.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gfe.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gfe.setIsRound(true);
        this.gfe.setAutoChangeStyle(false);
        this.gfe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gff.setDefaultResource(a.f.portrait_no_guard_bg);
        this.gff.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bKW() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gfd.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gfd.setLayoutParams(layoutParams);
        }
    }

    private void bKX() {
        if (this.gft) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfc.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gfc.setLayoutParams(layoutParams);
            this.gfl.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bKY() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfj.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gfj.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gfa.setOnClickListener(this);
        this.gfb.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fvK.setOnClickListener(this);
        this.gfn.setOnClickListener(this);
        this.gfl.setOnClickListener(this);
    }

    private void Hh() {
        bKZ();
        this.gfo = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gfp);
        this.gfo.dY(this.mLiveId, this.beu);
    }

    private void bKZ() {
        this.gfp = new a.InterfaceC0614a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0614a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0614a
            public void onFail(int i, String str) {
                a.this.bfE = 5L;
                a.this.ap(a.this.bfE);
                if (a.this.mActivity != null && !a.this.gfy) {
                    a.this.gfy = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.beu = str2;
        this.aHk = str3;
        this.mTabId = i;
        Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.geD == null || aVar.geE == null || this.mActivity == null) {
            this.bfE = 5L;
            ap(this.bfE);
            return;
        }
        this.geT = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.geD.geG)) {
            this.gff.startLoad(aVar.geD.geG, 10, false);
        }
        if (i == 1) {
            this.gfe.setVisibility(8);
        } else {
            String str = aVar.geD.geF;
            if (!TextUtils.isEmpty(str)) {
                this.gfe.setVisibility(0);
                this.gfe.startLoad(str, 12, false);
            } else {
                this.gfe.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.geD.geH)) {
                this.gfg.setVisibility(0);
                this.gfg.setText(aVar.geD.geH);
            } else {
                this.gfg.setVisibility(4);
            }
        } else {
            String str2 = aVar.geD.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gfg.setVisibility(0);
                this.gfg.setText(str2);
            } else {
                this.gfg.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gfh.setVisibility(4);
        } else if (i == 2) {
            if (this.gfv != aVar.geD.startTime || this.gfu > aVar.geD.geK) {
                this.gfv = aVar.geD.startTime;
                if (aVar.geD.geK > 0) {
                    this.gfu = aVar.geD.geK;
                    if (!TextUtils.isEmpty(aVar.geD.geH)) {
                        this.gfh.setVisibility(0);
                        this.gfh.setText(aVar.geD.geH + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.gfu)));
                        if (this.mHandler != null && this.gfA != null) {
                            this.mHandler.removeCallbacks(this.gfA);
                        }
                        startCountDown();
                    }
                } else {
                    this.gfh.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gfw != aVar.geD.startTime || this.gfx != aVar.geD.geL)) {
            this.gfw = aVar.geD.startTime;
            if (aVar.geD.geL >= 0) {
                this.gfx = aVar.geD.geL;
                if (!TextUtils.isEmpty(aVar.geD.geH)) {
                    this.gfh.setVisibility(0);
                    this.gfh.setText(aVar.geD.geH + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.gfx)));
                    if (this.mHandler != null && this.gfz != null) {
                        this.mHandler.removeCallbacks(this.gfz);
                    }
                    bLe();
                }
            } else {
                this.gfh.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gfk.setVisibility(8);
        } else if (aVar.geD.geN != null && aVar.geD.geN.size() > 0) {
            if (this.gfr == null) {
                this.gfr = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gfk.setAdapter((ListAdapter) this.gfr);
            }
            this.gfr.setList(aVar.geD.geN);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gfk);
            this.gfk.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gfk.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.gfk.setLayoutParams(layoutParams);
            this.gfk.setVisibility(0);
        } else {
            this.gfk.setVisibility(8);
        }
        if (i == 2 && aVar.geE.geP != null && aVar.geE.geP.size() > 0) {
            if (this.gfq == null) {
                this.gfq = new b(this.mActivity);
                this.gfi.setAdapter((ListAdapter) this.gfq);
            }
            this.gfq.setList(aVar.geE.geP);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gfi);
            this.fDd.setVisibility(0);
        } else {
            this.fDd.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gfl.setVisibility(8);
        } else {
            this.gfl.setVisibility(0);
            if (aVar.geE.geO != null && !TextUtils.isEmpty(aVar.geE.geO.text)) {
                if (aVar.geE.geO.rank > 0 && aVar.geE.geO.rank < 4) {
                    this.gfm.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.gfm.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.gfm.setText(aVar.geE.geO.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.geD.geJ) && TextUtils.equals(aVar.geD.geJ, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gfn.setVisibility(8);
            } else {
                this.gfn.setVisibility(0);
            }
        }
        this.bfE = aVar.geD.geM;
        ap(this.bfE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fvK) {
            bLa();
        } else if (view == this.gfn || view == this.gfl) {
            bLb();
        }
    }

    private void bLa() {
        if (this.mActivity == null || this.geT == null || this.geT.geD == null || TextUtils.isEmpty(this.geT.geD.geI)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.geT.geD.geI}, false, null, true);
        }
    }

    private void bLb() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            y yVar = new y();
            yVar.aEC = Integer.parseInt(this.aHk);
            yVar.aEA = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ap(long j) {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
            this.mHandler.postDelayed(this.bfH, 1000 * j);
        }
    }

    public void bLc() {
        if (this.mHandler != null && this.bfH != null) {
            this.mHandler.removeCallbacks(this.bfH);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gfz);
        this.mHandler.postDelayed(this.gfz, 1000L);
    }

    public void bLd() {
        if (this.mHandler != null && this.gfz != null) {
            this.mHandler.removeCallbacks(this.gfz);
        }
    }

    public void bLe() {
        this.mHandler.removeCallbacks(this.gfA);
        this.mHandler.postDelayed(this.gfA, 1000L);
    }

    public void bLf() {
        if (this.mHandler != null && this.gfA != null) {
            this.mHandler.removeCallbacks(this.gfA);
        }
    }

    public void baR() {
    }

    private View lw(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gfc != null) {
            this.gfc.clearAnimation();
        }
        if (this.gfo != null) {
            this.gfo.onDestroy();
        }
        bLd();
        bLf();
        bLc();
    }

    public Animation bLg() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gfs != null) {
            this.gfs.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0185a.sdk_push_up_out);
        this.gfc.setAnimation(loadAnimation);
        this.gfc.setVisibility(8);
        return loadAnimation;
    }
}
