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
    private String aaT;
    private String awp;
    private View eJB;
    private FrameLayout eJC;
    private View eJD;
    private View eJE;
    private HeadImageView eJF;
    private TbImageView eJG;
    private TextView eJH;
    private TextView eJI;
    private ListView eJJ;
    private ScrollView eJK;
    private HListView eJL;
    private RelativeLayout eJM;
    private TextView eJN;
    private TextView eJO;
    protected final GuardThroneActivity eJP;
    private com.baidu.tieba.ala.guardthrone.d.a eJQ;
    private a.InterfaceC0445a eJR;
    private b eJS;
    private com.baidu.tieba.ala.guardthrone.a.a eJT;
    private Animation eJU;
    private boolean eJV;
    private long eJW;
    private long eJX;
    private long eJY;
    private long eJZ;
    private com.baidu.tieba.ala.guardthrone.b.a eJx;
    private long eKa;
    private boolean eKb;
    private ImageView eic;
    private LinearLayout eky;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eKc = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJQ != null) {
                a.this.eJQ.cS(a.this.mLiveId, a.this.awp);
            }
        }
    };
    private final Runnable eKd = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJW <= 0) {
                a.this.eJW = 0L;
                a.this.bgl();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eJW <= 0 || a.this.eJI == null || a.this.eJx == null || a.this.eJx.eJi == null || TextUtils.isEmpty(a.this.eJx.eJi.eJm)) {
                if (a.this.eJI != null && a.this.eJI.getVisibility() == 0) {
                    a.this.eJI.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eJx.eJi.eJm + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJW));
            if (a.this.eJI.getVisibility() != 0) {
                a.this.eJI.setVisibility(0);
            }
            a.this.eJI.setText(str);
        }
    };
    private final Runnable eKe = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJZ <= 0) {
                a.this.eJZ = 0L;
                a.this.bgn();
            } else {
                a.i(a.this);
                a.this.bgm();
            }
            if (a.this.eJZ >= 0 && a.this.eJI != null && a.this.eJx != null && a.this.eJx.eJi != null && !TextUtils.isEmpty(a.this.eJx.eJi.eJm)) {
                a.this.eJI.setText(a.this.eJx.eJi.eJm + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJZ)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eJW;
        aVar.eJW = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eJZ;
        aVar.eJZ = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eJP = guardThroneActivity;
        this.eJV = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = iG(this.eJV);
        this.eJB = this.mRootView.findViewById(a.g.content_layout);
        this.eJC = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eJD = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eJE = this.mRootView.findViewById(a.g.view_foreground);
        this.eic = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eJF = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eJG = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eJH = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eJI = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.eky = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eJJ = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eJJ.setDividerHeight(0);
        this.eJK = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eJL = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eJL.setSelector(this.eJP.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eJM = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eJN = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eJO = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bgd();
        bge();
        bgf();
        bgg();
    }

    private void bgd() {
        this.eJF.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJF.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJF.setIsRound(true);
        this.eJF.setAutoChangeStyle(false);
        this.eJF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eJG.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eJG.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bge() {
        if (this.eJP != null) {
            ViewGroup.LayoutParams layoutParams = this.eJE.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJP) / 2;
            this.eJE.setLayoutParams(layoutParams);
        }
    }

    private void bgf() {
        if (this.eJV) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eJD.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJP) - BdUtilHelper.dip2px(this.eJP, 68.0f);
            this.eJD.setLayoutParams(layoutParams);
            this.eJM.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bgg() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eJK.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eJB.setOnClickListener(this);
        this.eJC.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eic.setOnClickListener(this);
        this.eJO.setOnClickListener(this);
        this.eJM.setOnClickListener(this);
    }

    private void dQ() {
        bgh();
        this.eJQ = new com.baidu.tieba.ala.guardthrone.d.a(this.eJP.getPageContext(), this.eJR);
        this.eJQ.cS(this.mLiveId, this.awp);
    }

    private void bgh() {
        this.eJR = new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void onFail(int i, String str) {
                a.this.eKa = 5L;
                a.this.cO(a.this.eKa);
                if (a.this.eJP != null && !a.this.eKb) {
                    a.this.eKb = true;
                    BdUtilHelper.showToast(a.this.eJP, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.awp = str2;
        this.aaT = str3;
        this.mTabId = i;
        dQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eJi == null || aVar.eJj == null || this.eJP == null) {
            this.eKa = 5L;
            cO(this.eKa);
            return;
        }
        this.eJx = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eJi.eJl)) {
            this.eJG.startLoad(aVar.eJi.eJl, 10, false);
        }
        if (i2 == 1) {
            this.eJF.setVisibility(8);
        } else {
            String str = aVar.eJi.eJk;
            if (!TextUtils.isEmpty(str)) {
                this.eJF.setVisibility(0);
                this.eJF.startLoad(str, 12, false);
            } else {
                this.eJF.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eJi.eJm)) {
                this.eJH.setVisibility(0);
                this.eJH.setText(aVar.eJi.eJm);
            } else {
                this.eJH.setVisibility(4);
            }
        } else {
            String str2 = aVar.eJi.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eJH.setVisibility(0);
                this.eJH.setText(str2);
            } else {
                this.eJH.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eJI.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eJX != aVar.eJi.startTime || this.eJW > aVar.eJi.eJp) {
                this.eJX = aVar.eJi.startTime;
                if (aVar.eJi.eJp > 0) {
                    this.eJW = aVar.eJi.eJp;
                    if (!TextUtils.isEmpty(aVar.eJi.eJm)) {
                        this.eJI.setVisibility(0);
                        this.eJI.setText(aVar.eJi.eJm + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJW)));
                        if (this.mHandler != null && this.eKe != null) {
                            this.mHandler.removeCallbacks(this.eKe);
                        }
                        startCountDown();
                    }
                } else {
                    this.eJI.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eJY != aVar.eJi.startTime || this.eJZ != aVar.eJi.eJq)) {
            this.eJY = aVar.eJi.startTime;
            if (aVar.eJi.eJq >= 0) {
                this.eJZ = aVar.eJi.eJq;
                if (!TextUtils.isEmpty(aVar.eJi.eJm)) {
                    this.eJI.setVisibility(0);
                    this.eJI.setText(aVar.eJi.eJm + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJZ)));
                    if (this.mHandler != null && this.eKd != null) {
                        this.mHandler.removeCallbacks(this.eKd);
                    }
                    bgm();
                }
            } else {
                this.eJI.setVisibility(8);
            }
        }
        if (!this.eJV) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJK.getLayoutParams();
            if (i2 == 2 && aVar.eJj.eJu != null && aVar.eJj.eJu.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eJP, i);
            this.eJK.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eJL.setVisibility(8);
        } else if (aVar.eJi.eJs != null && aVar.eJi.eJs.size() > 0) {
            if (this.eJT == null) {
                this.eJT = new com.baidu.tieba.ala.guardthrone.a.a(this.eJP);
                this.eJL.setAdapter((ListAdapter) this.eJT);
            }
            this.eJT.setList(aVar.eJi.eJs);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eJP, this.eJL);
            this.eJL.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJL.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eJL.setLayoutParams(layoutParams2);
            this.eJL.setVisibility(0);
        } else {
            this.eJL.setVisibility(8);
        }
        if (i2 == 2 && aVar.eJj.eJu != null && aVar.eJj.eJu.size() > 0) {
            if (this.eJS == null) {
                this.eJS = new b(this.eJP);
                this.eJJ.setAdapter((ListAdapter) this.eJS);
            }
            this.eJS.setList(aVar.eJj.eJu);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eJJ);
            this.eky.setVisibility(0);
        } else {
            this.eky.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eJM.setVisibility(8);
        } else {
            this.eJM.setVisibility(0);
            if (aVar.eJj.eJt != null && !TextUtils.isEmpty(aVar.eJj.eJt.text)) {
                if (aVar.eJj.eJt.rank > 0 && aVar.eJj.eJt.rank < 4) {
                    this.eJN.setTextColor(this.eJP.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eJN.setTextColor(this.eJP.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eJN.setText(aVar.eJj.eJt.text);
            }
            if (!TextUtils.isEmpty(aVar.eJi.eJo) && TextUtils.equals(aVar.eJi.eJo, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eJO.setVisibility(8);
            } else {
                this.eJO.setVisibility(0);
            }
        }
        this.eKa = aVar.eJi.eJr;
        cO(this.eKa);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eJP.finish();
        } else if (view == this.eic) {
            bgi();
        } else if (view == this.eJO || view == this.eJM) {
            bgj();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bgi() {
        if (this.eJP == null || this.eJx == null || this.eJx.eJi == null || TextUtils.isEmpty(this.eJx.eJi.eJn)) {
            BdUtilHelper.showToast(this.eJP, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eJP.getPageContext(), "", new String[]{this.eJx.eJi.eJn}, false, null, true);
        }
    }

    private void bgj() {
        if (this.eJP != null) {
            this.eJP.bgb();
        }
        try {
            r rVar = new r();
            rVar.Yu = Integer.parseInt(this.aaT);
            rVar.Ys = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cO(long j) {
        if (this.mHandler != null && this.eKc != null) {
            this.mHandler.removeCallbacks(this.eKc);
            this.mHandler.postDelayed(this.eKc, 1000 * j);
        }
    }

    public void bgk() {
        if (this.mHandler != null && this.eKc != null) {
            this.mHandler.removeCallbacks(this.eKc);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eKd);
        this.mHandler.postDelayed(this.eKd, 1000L);
    }

    public void bgl() {
        if (this.mHandler != null && this.eKd != null) {
            this.mHandler.removeCallbacks(this.eKd);
        }
    }

    public void bgm() {
        this.mHandler.removeCallbacks(this.eKe);
        this.mHandler.postDelayed(this.eKe, 1000L);
    }

    public void bgn() {
        if (this.mHandler != null && this.eKe != null) {
            this.mHandler.removeCallbacks(this.eKe);
        }
    }

    public void azc() {
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eJP.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eJP.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eJU == null) {
                        a.this.eJU = AnimationUtils.loadAnimation(a.this.eJP.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    a.this.eJD.setAnimation(a.this.eJU);
                    a.this.eJD.setVisibility(0);
                    a.this.eJU.setDuration(300L);
                    a.this.eJU.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eJD != null) {
            this.eJD.clearAnimation();
        }
        if (this.eJQ != null) {
            this.eJQ.onDestroy();
        }
        bgl();
        bgn();
        bgk();
    }

    public Animation bgo() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJU != null) {
            this.eJU.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eJP.getActivity(), a.C0102a.sdk_push_up_out);
        this.eJD.setAnimation(loadAnimation);
        this.eJD.setVisibility(8);
        return loadAnimation;
    }
}
