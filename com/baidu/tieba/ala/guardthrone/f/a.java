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
import com.baidu.live.data.q;
import com.baidu.live.r.a;
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
    private String Zb;
    private String asd;
    private TextView eFA;
    private ListView eFB;
    private ScrollView eFC;
    private HListView eFD;
    private RelativeLayout eFE;
    private TextView eFF;
    private TextView eFG;
    protected final GuardThroneActivity eFH;
    private com.baidu.tieba.ala.guardthrone.d.a eFI;
    private a.InterfaceC0434a eFJ;
    private b eFK;
    private com.baidu.tieba.ala.guardthrone.a.a eFL;
    private Animation eFM;
    private boolean eFN;
    private long eFO;
    private long eFP;
    private long eFQ;
    private long eFR;
    private long eFS;
    private boolean eFT;
    private com.baidu.tieba.ala.guardthrone.b.a eFp;
    private View eFt;
    private FrameLayout eFu;
    private View eFv;
    private View eFw;
    private HeadImageView eFx;
    private TbImageView eFy;
    private TextView eFz;
    private ImageView edL;
    private LinearLayout egg;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eFU = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eFI != null) {
                a.this.eFI.cH(a.this.mLiveId, a.this.asd);
            }
        }
    };
    private final Runnable eFV = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eFO <= 0) {
                a.this.eFO = 0L;
                a.this.bdY();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eFO <= 0 || a.this.eFA == null || a.this.eFp == null || a.this.eFp.eFa == null || TextUtils.isEmpty(a.this.eFp.eFa.eFe)) {
                if (a.this.eFA != null && a.this.eFA.getVisibility() == 0) {
                    a.this.eFA.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eFp.eFa.eFe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eFO));
            if (a.this.eFA.getVisibility() != 0) {
                a.this.eFA.setVisibility(0);
            }
            a.this.eFA.setText(str);
        }
    };
    private final Runnable eFW = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eFR <= 0) {
                a.this.eFR = 0L;
                a.this.bea();
            } else {
                a.i(a.this);
                a.this.bdZ();
            }
            if (a.this.eFR >= 0 && a.this.eFA != null && a.this.eFp != null && a.this.eFp.eFa != null && !TextUtils.isEmpty(a.this.eFp.eFa.eFe)) {
                a.this.eFA.setText(a.this.eFp.eFa.eFe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eFR)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eFO;
        aVar.eFO = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eFR;
        aVar.eFR = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eFH = guardThroneActivity;
        this.eFN = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = iz(this.eFN);
        this.eFt = this.mRootView.findViewById(a.g.content_layout);
        this.eFu = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eFv = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eFw = this.mRootView.findViewById(a.g.view_foreground);
        this.edL = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eFx = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eFy = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eFz = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eFA = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.egg = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eFB = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eFB.setDividerHeight(0);
        this.eFC = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eFD = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eFD.setSelector(this.eFH.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eFE = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eFF = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eFG = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bdQ();
        bdR();
        bdS();
        bdT();
    }

    private void bdQ() {
        this.eFx.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eFx.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eFx.setIsRound(true);
        this.eFx.setAutoChangeStyle(false);
        this.eFx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eFy.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eFy.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bdR() {
        if (this.eFH != null) {
            ViewGroup.LayoutParams layoutParams = this.eFw.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eFH) / 2;
            this.eFw.setLayoutParams(layoutParams);
        }
    }

    private void bdS() {
        if (this.eFN) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eFv.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eFH) - BdUtilHelper.dip2px(this.eFH, 68.0f);
            this.eFv.setLayoutParams(layoutParams);
            this.eFE.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bdT() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eFC.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eFt.setOnClickListener(this);
        this.eFu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.edL.setOnClickListener(this);
        this.eFG.setOnClickListener(this);
        this.eFE.setOnClickListener(this);
    }

    private void dP() {
        bdU();
        this.eFI = new com.baidu.tieba.ala.guardthrone.d.a(this.eFH.getPageContext(), this.eFJ);
        this.eFI.cH(this.mLiveId, this.asd);
    }

    private void bdU() {
        this.eFJ = new a.InterfaceC0434a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0434a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0434a
            public void onFail(int i, String str) {
                a.this.eFS = 5L;
                a.this.cM(a.this.eFS);
                if (a.this.eFH != null && !a.this.eFT) {
                    a.this.eFT = true;
                    BdUtilHelper.showToast(a.this.eFH, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.asd = str2;
        this.Zb = str3;
        this.mTabId = i;
        dP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eFa == null || aVar.eFb == null || this.eFH == null) {
            this.eFS = 5L;
            cM(this.eFS);
            return;
        }
        this.eFp = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eFa.eFd)) {
            this.eFy.startLoad(aVar.eFa.eFd, 10, false);
        }
        if (i2 == 1) {
            this.eFx.setVisibility(8);
        } else {
            String str = aVar.eFa.eFc;
            if (!TextUtils.isEmpty(str)) {
                this.eFx.setVisibility(0);
                this.eFx.startLoad(str, 12, false);
            } else {
                this.eFx.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eFa.eFe)) {
                this.eFz.setVisibility(0);
                this.eFz.setText(aVar.eFa.eFe);
            } else {
                this.eFz.setVisibility(4);
            }
        } else {
            String str2 = aVar.eFa.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eFz.setVisibility(0);
                this.eFz.setText(str2);
            } else {
                this.eFz.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eFA.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eFP != aVar.eFa.startTime || this.eFO > aVar.eFa.eFh) {
                this.eFP = aVar.eFa.startTime;
                if (aVar.eFa.eFh > 0) {
                    this.eFO = aVar.eFa.eFh;
                    if (!TextUtils.isEmpty(aVar.eFa.eFe)) {
                        this.eFA.setVisibility(0);
                        this.eFA.setText(aVar.eFa.eFe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eFO)));
                        if (this.mHandler != null && this.eFW != null) {
                            this.mHandler.removeCallbacks(this.eFW);
                        }
                        startCountDown();
                    }
                } else {
                    this.eFA.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eFQ != aVar.eFa.startTime || this.eFR != aVar.eFa.eFi)) {
            this.eFQ = aVar.eFa.startTime;
            if (aVar.eFa.eFi >= 0) {
                this.eFR = aVar.eFa.eFi;
                if (!TextUtils.isEmpty(aVar.eFa.eFe)) {
                    this.eFA.setVisibility(0);
                    this.eFA.setText(aVar.eFa.eFe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eFR)));
                    if (this.mHandler != null && this.eFV != null) {
                        this.mHandler.removeCallbacks(this.eFV);
                    }
                    bdZ();
                }
            } else {
                this.eFA.setVisibility(8);
            }
        }
        if (!this.eFN) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFC.getLayoutParams();
            if (i2 == 2 && aVar.eFb.eFm != null && aVar.eFb.eFm.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eFH, i);
            this.eFC.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eFD.setVisibility(8);
        } else if (aVar.eFa.eFk != null && aVar.eFa.eFk.size() > 0) {
            if (this.eFL == null) {
                this.eFL = new com.baidu.tieba.ala.guardthrone.a.a(this.eFH);
                this.eFD.setAdapter((ListAdapter) this.eFL);
            }
            this.eFL.setList(aVar.eFa.eFk);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eFH, this.eFD);
            this.eFD.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eFD.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eFD.setLayoutParams(layoutParams2);
            this.eFD.setVisibility(0);
        } else {
            this.eFD.setVisibility(8);
        }
        if (i2 == 2 && aVar.eFb.eFm != null && aVar.eFb.eFm.size() > 0) {
            if (this.eFK == null) {
                this.eFK = new b(this.eFH);
                this.eFB.setAdapter((ListAdapter) this.eFK);
            }
            this.eFK.setList(aVar.eFb.eFm);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eFB);
            this.egg.setVisibility(0);
        } else {
            this.egg.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eFE.setVisibility(8);
        } else {
            this.eFE.setVisibility(0);
            if (aVar.eFb.eFl != null && !TextUtils.isEmpty(aVar.eFb.eFl.text)) {
                if (aVar.eFb.eFl.rank > 0 && aVar.eFb.eFl.rank < 4) {
                    this.eFF.setTextColor(this.eFH.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eFF.setTextColor(this.eFH.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eFF.setText(aVar.eFb.eFl.text);
            }
            if (!TextUtils.isEmpty(aVar.eFa.eFg) && TextUtils.equals(aVar.eFa.eFg, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eFG.setVisibility(8);
            } else {
                this.eFG.setVisibility(0);
            }
        }
        this.eFS = aVar.eFa.eFj;
        cM(this.eFS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eFH.finish();
        } else if (view == this.edL) {
            bdV();
        } else if (view == this.eFG || view == this.eFE) {
            bdW();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bdV() {
        if (this.eFH == null || this.eFp == null || this.eFp.eFa == null || TextUtils.isEmpty(this.eFp.eFa.eFf)) {
            BdUtilHelper.showToast(this.eFH, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eFH.getPageContext(), "", new String[]{this.eFp.eFa.eFf}, false, null, true);
        }
    }

    private void bdW() {
        if (this.eFH != null) {
            this.eFH.bdO();
        }
        try {
            q qVar = new q();
            qVar.WI = Integer.parseInt(this.Zb);
            qVar.WG = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, qVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void cM(long j) {
        if (this.mHandler != null && this.eFU != null) {
            this.mHandler.removeCallbacks(this.eFU);
            this.mHandler.postDelayed(this.eFU, 1000 * j);
        }
    }

    public void bdX() {
        if (this.mHandler != null && this.eFU != null) {
            this.mHandler.removeCallbacks(this.eFU);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eFV);
        this.mHandler.postDelayed(this.eFV, 1000L);
    }

    public void bdY() {
        if (this.mHandler != null && this.eFV != null) {
            this.mHandler.removeCallbacks(this.eFV);
        }
    }

    public void bdZ() {
        this.mHandler.removeCallbacks(this.eFW);
        this.mHandler.postDelayed(this.eFW, 1000L);
    }

    public void bea() {
        if (this.mHandler != null && this.eFW != null) {
            this.mHandler.removeCallbacks(this.eFW);
        }
    }

    public void awN() {
    }

    private View iz(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eFH.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eFH.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eFM == null) {
                        a.this.eFM = AnimationUtils.loadAnimation(a.this.eFH.getActivity(), a.C0086a.sdk_push_up_in);
                    }
                    a.this.eFv.setAnimation(a.this.eFM);
                    a.this.eFv.setVisibility(0);
                    a.this.eFM.setDuration(300L);
                    a.this.eFM.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eFv != null) {
            this.eFv.clearAnimation();
        }
        if (this.eFI != null) {
            this.eFI.onDestroy();
        }
        bdY();
        bea();
        bdX();
    }

    public Animation beb() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eFM != null) {
            this.eFM.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eFH.getActivity(), a.C0086a.sdk_push_up_out);
        this.eFv.setAnimation(loadAnimation);
        this.eFv.setVisibility(8);
        return loadAnimation;
    }
}
