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
import com.baidu.live.data.o;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.GuardThroneActivity;
import com.baidu.tieba.ala.guardthrone.a.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private String YP;
    private String arr;
    private b eEA;
    private com.baidu.tieba.ala.guardthrone.a.a eEB;
    private Animation eEC;
    private boolean eED;
    private long eEE;
    private long eEF;
    private long eEG;
    private long eEH;
    private long eEI;
    private boolean eEJ;
    private com.baidu.tieba.ala.guardthrone.b.a eEf;
    private View eEj;
    private FrameLayout eEk;
    private View eEl;
    private View eEm;
    private HeadImageView eEn;
    private TbImageView eEo;
    private TextView eEp;
    private TextView eEq;
    private ListView eEr;
    private ScrollView eEs;
    private HListView eEt;
    private RelativeLayout eEu;
    private TextView eEv;
    private TextView eEw;
    protected final GuardThroneActivity eEx;
    private com.baidu.tieba.ala.guardthrone.d.a eEy;
    private a.InterfaceC0431a eEz;
    private ImageView edD;
    private LinearLayout efW;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eEK = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eEy != null) {
                a.this.eEy.cH(a.this.mLiveId, a.this.arr);
            }
        }
    };
    private final Runnable eEL = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eEE <= 0) {
                a.this.eEE = 0L;
                a.this.bdD();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eEE <= 0 || a.this.eEq == null || a.this.eEf == null || a.this.eEf.eDP == null || TextUtils.isEmpty(a.this.eEf.eDP.eDT)) {
                if (a.this.eEq != null && a.this.eEq.getVisibility() == 0) {
                    a.this.eEq.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eEf.eDP.eDT + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eEE));
            if (a.this.eEq.getVisibility() != 0) {
                a.this.eEq.setVisibility(0);
            }
            a.this.eEq.setText(str);
        }
    };
    private final Runnable eEM = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eEH <= 0) {
                a.this.eEH = 0L;
                a.this.bdF();
            } else {
                a.i(a.this);
                a.this.bdE();
            }
            if (a.this.eEH >= 0 && a.this.eEq != null && a.this.eEf != null && a.this.eEf.eDP != null && !TextUtils.isEmpty(a.this.eEf.eDP.eDT)) {
                a.this.eEq.setText(a.this.eEf.eDP.eDT + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eEH)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eEE;
        aVar.eEE = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eEH;
        aVar.eEH = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eEx = guardThroneActivity;
        this.eED = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = ip(this.eED);
        this.eEj = this.mRootView.findViewById(a.g.content_layout);
        this.eEk = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eEl = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eEm = this.mRootView.findViewById(a.g.view_foreground);
        this.edD = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eEn = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eEo = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eEp = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eEq = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.efW = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eEr = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eEr.setDividerHeight(0);
        this.eEs = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eEt = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eEt.setSelector(this.eEx.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eEu = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eEv = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eEw = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bdv();
        bdw();
        bdx();
        bdy();
    }

    private void bdv() {
        this.eEn.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eEn.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eEn.setIsRound(true);
        this.eEn.setAutoChangeStyle(false);
        this.eEn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eEo.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eEo.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bdw() {
        if (this.eEx != null) {
            ViewGroup.LayoutParams layoutParams = this.eEm.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eEx) / 2;
            this.eEm.setLayoutParams(layoutParams);
        }
    }

    private void bdx() {
        if (this.eED) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eEl.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eEx) - BdUtilHelper.dip2px(this.eEx, 68.0f);
            this.eEl.setLayoutParams(layoutParams);
            this.eEu.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bdy() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEs.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eEs.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eEj.setOnClickListener(this);
        this.eEk.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.edD.setOnClickListener(this);
        this.eEw.setOnClickListener(this);
        this.eEu.setOnClickListener(this);
    }

    private void dP() {
        bdz();
        this.eEy = new com.baidu.tieba.ala.guardthrone.d.a(this.eEx.getPageContext(), this.eEz);
        this.eEy.cH(this.mLiveId, this.arr);
    }

    private void bdz() {
        this.eEz = new a.InterfaceC0431a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0431a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0431a
            public void onFail(int i, String str) {
                a.this.eEI = 5L;
                a.this.cH(a.this.eEI);
                if (a.this.eEx != null && !a.this.eEJ) {
                    a.this.eEJ = true;
                    BdUtilHelper.showToast(a.this.eEx, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.arr = str2;
        this.YP = str3;
        this.mTabId = i;
        dP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eDP == null || aVar.eDQ == null || this.eEx == null) {
            this.eEI = 5L;
            cH(this.eEI);
            return;
        }
        this.eEf = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eDP.eDS)) {
            this.eEo.startLoad(aVar.eDP.eDS, 10, false);
        }
        if (i2 == 1) {
            this.eEn.setVisibility(8);
        } else {
            String str = aVar.eDP.eDR;
            if (!TextUtils.isEmpty(str)) {
                this.eEn.setVisibility(0);
                this.eEn.startLoad(str, 12, false);
            } else {
                this.eEn.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eDP.eDT)) {
                this.eEp.setVisibility(0);
                this.eEp.setText(aVar.eDP.eDT);
            } else {
                this.eEp.setVisibility(4);
            }
        } else {
            String str2 = aVar.eDP.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eEp.setVisibility(0);
                this.eEp.setText(str2);
            } else {
                this.eEp.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eEq.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eEF != aVar.eDP.startTime || this.eEE > aVar.eDP.eDW) {
                this.eEF = aVar.eDP.startTime;
                if (aVar.eDP.eDW > 0) {
                    this.eEE = aVar.eDP.eDW;
                    if (!TextUtils.isEmpty(aVar.eDP.eDT)) {
                        this.eEq.setVisibility(0);
                        this.eEq.setText(aVar.eDP.eDT + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eEE)));
                        if (this.mHandler != null && this.eEM != null) {
                            this.mHandler.removeCallbacks(this.eEM);
                        }
                        startCountDown();
                    }
                } else {
                    this.eEq.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eEG != aVar.eDP.startTime || this.eEH != aVar.eDP.eDX)) {
            this.eEG = aVar.eDP.startTime;
            if (aVar.eDP.eDX >= 0) {
                this.eEH = aVar.eDP.eDX;
                if (!TextUtils.isEmpty(aVar.eDP.eDT)) {
                    this.eEq.setVisibility(0);
                    this.eEq.setText(aVar.eDP.eDT + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eEH)));
                    if (this.mHandler != null && this.eEL != null) {
                        this.mHandler.removeCallbacks(this.eEL);
                    }
                    bdE();
                }
            } else {
                this.eEq.setVisibility(8);
            }
        }
        if (!this.eED) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eEs.getLayoutParams();
            if (i2 == 2 && aVar.eDQ.eEb != null && aVar.eDQ.eEb.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eEx, i);
            this.eEs.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eEt.setVisibility(8);
        } else if (aVar.eDP.eDZ != null && aVar.eDP.eDZ.size() > 0) {
            if (this.eEB == null) {
                this.eEB = new com.baidu.tieba.ala.guardthrone.a.a(this.eEx);
                this.eEt.setAdapter((ListAdapter) this.eEB);
            }
            this.eEB.setList(aVar.eDP.eDZ);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eEx, this.eEt);
            this.eEt.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEt.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eEt.setLayoutParams(layoutParams2);
            this.eEt.setVisibility(0);
        } else {
            this.eEt.setVisibility(8);
        }
        if (i2 == 2 && aVar.eDQ.eEb != null && aVar.eDQ.eEb.size() > 0) {
            if (this.eEA == null) {
                this.eEA = new b(this.eEx);
                this.eEr.setAdapter((ListAdapter) this.eEA);
            }
            this.eEA.setList(aVar.eDQ.eEb);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eEr);
            this.efW.setVisibility(0);
        } else {
            this.efW.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eEu.setVisibility(8);
        } else {
            this.eEu.setVisibility(0);
            if (aVar.eDQ.eEa != null && !TextUtils.isEmpty(aVar.eDQ.eEa.text)) {
                if (aVar.eDQ.eEa.rank > 0 && aVar.eDQ.eEa.rank < 4) {
                    this.eEv.setTextColor(this.eEx.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eEv.setTextColor(this.eEx.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eEv.setText(aVar.eDQ.eEa.text);
            }
            if (!TextUtils.isEmpty(aVar.eDP.eDV) && TextUtils.equals(aVar.eDP.eDV, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eEw.setVisibility(8);
            } else {
                this.eEw.setVisibility(0);
            }
        }
        this.eEI = aVar.eDP.eDY;
        cH(this.eEI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eEx.finish();
        } else if (view == this.edD) {
            bdA();
        } else if (view == this.eEw || view == this.eEu) {
            bdB();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bdA() {
        if (this.eEx == null || this.eEf == null || this.eEf.eDP == null || TextUtils.isEmpty(this.eEf.eDP.eDU)) {
            BdUtilHelper.showToast(this.eEx, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eEx.getPageContext(), "", new String[]{this.eEf.eDP.eDU}, false, null, true);
        }
    }

    private void bdB() {
        if (this.eEx != null) {
            this.eEx.bdt();
        }
        try {
            o oVar = new o();
            oVar.Wp = Integer.parseInt(this.YP);
            oVar.Wn = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, oVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cH(long j) {
        if (this.mHandler != null && this.eEK != null) {
            this.mHandler.removeCallbacks(this.eEK);
            this.mHandler.postDelayed(this.eEK, 1000 * j);
        }
    }

    public void bdC() {
        if (this.mHandler != null && this.eEK != null) {
            this.mHandler.removeCallbacks(this.eEK);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eEL);
        this.mHandler.postDelayed(this.eEL, 1000L);
    }

    public void bdD() {
        if (this.mHandler != null && this.eEL != null) {
            this.mHandler.removeCallbacks(this.eEL);
        }
    }

    public void bdE() {
        this.mHandler.removeCallbacks(this.eEM);
        this.mHandler.postDelayed(this.eEM, 1000L);
    }

    public void bdF() {
        if (this.mHandler != null && this.eEM != null) {
            this.mHandler.removeCallbacks(this.eEM);
        }
    }

    public void awu() {
    }

    private View ip(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eEx.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eEx.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eEC == null) {
                        a.this.eEC = AnimationUtils.loadAnimation(a.this.eEx.getActivity(), a.C0086a.sdk_push_up_in);
                    }
                    a.this.eEl.setAnimation(a.this.eEC);
                    a.this.eEl.setVisibility(0);
                    a.this.eEC.setDuration(300L);
                    a.this.eEC.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eEl != null) {
            this.eEl.clearAnimation();
        }
        if (this.eEy != null) {
            this.eEy.onDestroy();
        }
        bdD();
        bdF();
        bdC();
    }

    public Animation bdG() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eEC != null) {
            this.eEC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eEx.getActivity(), a.C0086a.sdk_push_up_out);
        this.eEl.setAnimation(loadAnimation);
        this.eEl.setVisibility(8);
        return loadAnimation;
    }
}
