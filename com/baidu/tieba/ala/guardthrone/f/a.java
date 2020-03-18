package com.baidu.tieba.ala.guardthrone.f;

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
import com.baidu.live.data.r;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardthrone.GuardThroneActivity;
import com.baidu.tieba.ala.guardthrone.a.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private String abe;
    private String awz;
    private com.baidu.tieba.ala.guardthrone.b.a eJT;
    private View eJX;
    private FrameLayout eJY;
    private View eJZ;
    private View eKa;
    private HeadImageView eKb;
    private TbImageView eKc;
    private TextView eKd;
    private TextView eKe;
    private ListView eKf;
    private ScrollView eKg;
    private HListView eKh;
    private RelativeLayout eKi;
    private TextView eKj;
    private TextView eKk;
    protected final GuardThroneActivity eKl;
    private com.baidu.tieba.ala.guardthrone.d.a eKm;
    private a.InterfaceC0445a eKn;
    private b eKo;
    private com.baidu.tieba.ala.guardthrone.a.a eKp;
    private Animation eKq;
    private boolean eKr;
    private long eKs;
    private long eKt;
    private long eKu;
    private long eKv;
    private long eKw;
    private boolean eKx;
    private ImageView eis;
    private LinearLayout ekO;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eKy = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eKm != null) {
                a.this.eKm.cR(a.this.mLiveId, a.this.awz);
            }
        }
    };
    private final Runnable eKz = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eKs <= 0) {
                a.this.eKs = 0L;
                a.this.bgq();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eKs <= 0 || a.this.eKe == null || a.this.eJT == null || a.this.eJT.eJE == null || TextUtils.isEmpty(a.this.eJT.eJE.eJI)) {
                if (a.this.eKe != null && a.this.eKe.getVisibility() == 0) {
                    a.this.eKe.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eJT.eJE.eJI + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eKs));
            if (a.this.eKe.getVisibility() != 0) {
                a.this.eKe.setVisibility(0);
            }
            a.this.eKe.setText(str);
        }
    };
    private final Runnable eKA = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eKv <= 0) {
                a.this.eKv = 0L;
                a.this.bgs();
            } else {
                a.i(a.this);
                a.this.bgr();
            }
            if (a.this.eKv >= 0 && a.this.eKe != null && a.this.eJT != null && a.this.eJT.eJE != null && !TextUtils.isEmpty(a.this.eJT.eJE.eJI)) {
                a.this.eKe.setText(a.this.eJT.eJE.eJI + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eKv)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eKs;
        aVar.eKs = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eKv;
        aVar.eKv = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eKl = guardThroneActivity;
        this.eKr = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = iI(this.eKr);
        this.eJX = this.mRootView.findViewById(a.g.content_layout);
        this.eJY = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eJZ = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eKa = this.mRootView.findViewById(a.g.view_foreground);
        this.eis = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eKb = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eKc = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eKd = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eKe = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.ekO = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eKf = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eKf.setDividerHeight(0);
        this.eKg = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eKh = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eKh.setSelector(this.eKl.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eKi = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eKj = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eKk = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bgi();
        bgj();
        bgk();
        bgl();
    }

    private void bgi() {
        this.eKb.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eKb.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eKb.setIsRound(true);
        this.eKb.setAutoChangeStyle(false);
        this.eKb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKc.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eKc.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bgj() {
        if (this.eKl != null) {
            ViewGroup.LayoutParams layoutParams = this.eKa.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eKl) / 2;
            this.eKa.setLayoutParams(layoutParams);
        }
    }

    private void bgk() {
        if (this.eKr) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eJZ.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eKl) - BdUtilHelper.dip2px(this.eKl, 68.0f);
            this.eJZ.setLayoutParams(layoutParams);
            this.eKi.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bgl() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKg.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eKg.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eJX.setOnClickListener(this);
        this.eJY.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eis.setOnClickListener(this);
        this.eKk.setOnClickListener(this);
        this.eKi.setOnClickListener(this);
    }

    private void dQ() {
        bgm();
        this.eKm = new com.baidu.tieba.ala.guardthrone.d.a(this.eKl.getPageContext(), this.eKn);
        this.eKm.cR(this.mLiveId, this.awz);
    }

    private void bgm() {
        this.eKn = new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void onFail(int i, String str) {
                a.this.eKw = 5L;
                a.this.cO(a.this.eKw);
                if (a.this.eKl != null && !a.this.eKx) {
                    a.this.eKx = true;
                    BdUtilHelper.showToast(a.this.eKl, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.awz = str2;
        this.abe = str3;
        this.mTabId = i;
        dQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eJE == null || aVar.eJF == null || this.eKl == null) {
            this.eKw = 5L;
            cO(this.eKw);
            return;
        }
        this.eJT = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eJE.eJH)) {
            this.eKc.startLoad(aVar.eJE.eJH, 10, false);
        }
        if (i2 == 1) {
            this.eKb.setVisibility(8);
        } else {
            String str = aVar.eJE.eJG;
            if (!TextUtils.isEmpty(str)) {
                this.eKb.setVisibility(0);
                this.eKb.startLoad(str, 12, false);
            } else {
                this.eKb.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eJE.eJI)) {
                this.eKd.setVisibility(0);
                this.eKd.setText(aVar.eJE.eJI);
            } else {
                this.eKd.setVisibility(4);
            }
        } else {
            String str2 = aVar.eJE.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eKd.setVisibility(0);
                this.eKd.setText(str2);
            } else {
                this.eKd.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eKe.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eKt != aVar.eJE.startTime || this.eKs > aVar.eJE.eJL) {
                this.eKt = aVar.eJE.startTime;
                if (aVar.eJE.eJL > 0) {
                    this.eKs = aVar.eJE.eJL;
                    if (!TextUtils.isEmpty(aVar.eJE.eJI)) {
                        this.eKe.setVisibility(0);
                        this.eKe.setText(aVar.eJE.eJI + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eKs)));
                        if (this.mHandler != null && this.eKA != null) {
                            this.mHandler.removeCallbacks(this.eKA);
                        }
                        startCountDown();
                    }
                } else {
                    this.eKe.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eKu != aVar.eJE.startTime || this.eKv != aVar.eJE.eJM)) {
            this.eKu = aVar.eJE.startTime;
            if (aVar.eJE.eJM >= 0) {
                this.eKv = aVar.eJE.eJM;
                if (!TextUtils.isEmpty(aVar.eJE.eJI)) {
                    this.eKe.setVisibility(0);
                    this.eKe.setText(aVar.eJE.eJI + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eKv)));
                    if (this.mHandler != null && this.eKz != null) {
                        this.mHandler.removeCallbacks(this.eKz);
                    }
                    bgr();
                }
            } else {
                this.eKe.setVisibility(8);
            }
        }
        if (!this.eKr) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKg.getLayoutParams();
            if (i2 == 2 && aVar.eJF.eJQ != null && aVar.eJF.eJQ.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eKl, i);
            this.eKg.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eKh.setVisibility(8);
        } else if (aVar.eJE.eJO != null && aVar.eJE.eJO.size() > 0) {
            if (this.eKp == null) {
                this.eKp = new com.baidu.tieba.ala.guardthrone.a.a(this.eKl);
                this.eKh.setAdapter((ListAdapter) this.eKp);
            }
            this.eKp.setList(aVar.eJE.eJO);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eKl, this.eKh);
            this.eKh.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKh.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eKh.setLayoutParams(layoutParams2);
            this.eKh.setVisibility(0);
        } else {
            this.eKh.setVisibility(8);
        }
        if (i2 == 2 && aVar.eJF.eJQ != null && aVar.eJF.eJQ.size() > 0) {
            if (this.eKo == null) {
                this.eKo = new b(this.eKl);
                this.eKf.setAdapter((ListAdapter) this.eKo);
            }
            this.eKo.setList(aVar.eJF.eJQ);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eKf);
            this.ekO.setVisibility(0);
        } else {
            this.ekO.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eKi.setVisibility(8);
        } else {
            this.eKi.setVisibility(0);
            if (aVar.eJF.eJP != null && !TextUtils.isEmpty(aVar.eJF.eJP.text)) {
                if (aVar.eJF.eJP.rank > 0 && aVar.eJF.eJP.rank < 4) {
                    this.eKj.setTextColor(this.eKl.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eKj.setTextColor(this.eKl.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eKj.setText(aVar.eJF.eJP.text);
            }
            if (!TextUtils.isEmpty(aVar.eJE.eJK) && TextUtils.equals(aVar.eJE.eJK, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eKk.setVisibility(8);
            } else {
                this.eKk.setVisibility(0);
            }
        }
        this.eKw = aVar.eJE.eJN;
        cO(this.eKw);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eKl.finish();
        } else if (view == this.eis) {
            bgn();
        } else if (view == this.eKk || view == this.eKi) {
            bgo();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bgn() {
        if (this.eKl == null || this.eJT == null || this.eJT.eJE == null || TextUtils.isEmpty(this.eJT.eJE.eJJ)) {
            BdUtilHelper.showToast(this.eKl, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eKl.getPageContext(), "", new String[]{this.eJT.eJE.eJJ}, false, null, true);
        }
    }

    private void bgo() {
        if (this.eKl != null) {
            this.eKl.bgg();
        }
        try {
            r rVar = new r();
            rVar.YE = Integer.parseInt(this.abe);
            rVar.YC = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cO(long j) {
        if (this.mHandler != null && this.eKy != null) {
            this.mHandler.removeCallbacks(this.eKy);
            this.mHandler.postDelayed(this.eKy, 1000 * j);
        }
    }

    public void bgp() {
        if (this.mHandler != null && this.eKy != null) {
            this.mHandler.removeCallbacks(this.eKy);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eKz);
        this.mHandler.postDelayed(this.eKz, 1000L);
    }

    public void bgq() {
        if (this.mHandler != null && this.eKz != null) {
            this.mHandler.removeCallbacks(this.eKz);
        }
    }

    public void bgr() {
        this.mHandler.removeCallbacks(this.eKA);
        this.mHandler.postDelayed(this.eKA, 1000L);
    }

    public void bgs() {
        if (this.mHandler != null && this.eKA != null) {
            this.mHandler.removeCallbacks(this.eKA);
        }
    }

    public void azf() {
    }

    private View iI(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eKl.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eKl.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eKq == null) {
                        a.this.eKq = AnimationUtils.loadAnimation(a.this.eKl.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    a.this.eJZ.setAnimation(a.this.eKq);
                    a.this.eJZ.setVisibility(0);
                    a.this.eKq.setDuration(300L);
                    a.this.eKq.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eJZ != null) {
            this.eJZ.clearAnimation();
        }
        if (this.eKm != null) {
            this.eKm.onDestroy();
        }
        bgq();
        bgs();
        bgp();
    }

    public Animation bgt() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eKq != null) {
            this.eKq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eKl.getActivity(), a.C0102a.sdk_push_up_out);
        this.eJZ.setAnimation(loadAnimation);
        this.eJZ.setVisibility(8);
        return loadAnimation;
    }
}
