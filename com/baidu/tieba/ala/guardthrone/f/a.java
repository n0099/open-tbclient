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
import com.baidu.live.data.s;
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
    private String aQc;
    private String ats;
    private ImageView eIh;
    private LinearLayout eOo;
    private TextView foA;
    private TextView foB;
    protected final GuardThroneActivity foC;
    private com.baidu.tieba.ala.guardthrone.d.a foD;
    private a.InterfaceC0480a foE;
    private b foF;
    private com.baidu.tieba.ala.guardthrone.a.a foG;
    private Animation foH;
    private boolean foI;
    private long foJ;
    private long foK;
    private long foL;
    private long foM;
    private long foN;
    private boolean foO;
    private com.baidu.tieba.ala.guardthrone.b.a fok;
    private View foo;
    private FrameLayout fop;
    private View foq;

    /* renamed from: for  reason: not valid java name */
    private View f3for;
    private HeadImageView fos;
    private TbImageView fot;
    private TextView fou;
    private TextView fov;
    private ListView fow;
    private ScrollView fox;
    private HListView foy;
    private RelativeLayout foz;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable foP = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foD != null) {
                a.this.foD.df(a.this.mLiveId, a.this.aQc);
            }
        }
    };
    private final Runnable foQ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foJ <= 0) {
                a.this.foJ = 0L;
                a.this.bpH();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.foJ <= 0 || a.this.fov == null || a.this.fok == null || a.this.fok.fnV == null || TextUtils.isEmpty(a.this.fok.fnV.fnZ)) {
                if (a.this.fov != null && a.this.fov.getVisibility() == 0) {
                    a.this.fov.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fok.fnV.fnZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.foJ));
            if (a.this.fov.getVisibility() != 0) {
                a.this.fov.setVisibility(0);
            }
            a.this.fov.setText(str);
        }
    };
    private final Runnable foR = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foM <= 0) {
                a.this.foM = 0L;
                a.this.bpJ();
            } else {
                a.i(a.this);
                a.this.bpI();
            }
            if (a.this.foM >= 0 && a.this.fov != null && a.this.fok != null && a.this.fok.fnV != null && !TextUtils.isEmpty(a.this.fok.fnV.fnZ)) {
                a.this.fov.setText(a.this.fok.fnV.fnZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.foM)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.foJ;
        aVar.foJ = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.foM;
        aVar.foM = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.foC = guardThroneActivity;
        this.foI = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = jJ(this.foI);
        this.foo = this.mRootView.findViewById(a.g.content_layout);
        this.fop = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.foq = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.f3for = this.mRootView.findViewById(a.g.view_foreground);
        this.eIh = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fos = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.fot = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.fou = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.fov = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.eOo = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.fow = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.fow.setDividerHeight(0);
        this.fox = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.foy = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.foy.setSelector(this.foC.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.foz = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.foA = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.foB = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bpz();
        bpA();
        bpB();
        bpC();
    }

    private void bpz() {
        this.fos.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fos.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fos.setIsRound(true);
        this.fos.setAutoChangeStyle(false);
        this.fos.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fot.setDefaultResource(a.f.portrait_no_guard_bg);
        this.fot.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bpA() {
        if (this.foC != null) {
            ViewGroup.LayoutParams layoutParams = this.f3for.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.foC) / 2;
            this.f3for.setLayoutParams(layoutParams);
        }
    }

    private void bpB() {
        if (this.foI) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.foq.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.foC) - BdUtilHelper.dip2px(this.foC, 68.0f);
            this.foq.setLayoutParams(layoutParams);
            this.foz.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bpC() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fox.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.fox.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.foo.setOnClickListener(this);
        this.fop.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eIh.setOnClickListener(this);
        this.foB.setOnClickListener(this);
        this.foz.setOnClickListener(this);
    }

    private void zq() {
        bpD();
        this.foD = new com.baidu.tieba.ala.guardthrone.d.a(this.foC.getPageContext(), this.foE);
        this.foD.df(this.mLiveId, this.aQc);
    }

    private void bpD() {
        this.foE = new a.InterfaceC0480a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0480a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0480a
            public void onFail(int i, String str) {
                a.this.foN = 5L;
                a.this.dw(a.this.foN);
                if (a.this.foC != null && !a.this.foO) {
                    a.this.foO = true;
                    BdUtilHelper.showToast(a.this.foC, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.aQc = str2;
        this.ats = str3;
        this.mTabId = i;
        zq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.fnV == null || aVar.fnW == null || this.foC == null) {
            this.foN = 5L;
            dw(this.foN);
            return;
        }
        this.fok = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.fnV.fnY)) {
            this.fot.startLoad(aVar.fnV.fnY, 10, false);
        }
        if (i2 == 1) {
            this.fos.setVisibility(8);
        } else {
            String str = aVar.fnV.fnX;
            if (!TextUtils.isEmpty(str)) {
                this.fos.setVisibility(0);
                this.fos.startLoad(str, 12, false);
            } else {
                this.fos.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.fnV.fnZ)) {
                this.fou.setVisibility(0);
                this.fou.setText(aVar.fnV.fnZ);
            } else {
                this.fou.setVisibility(4);
            }
        } else {
            String str2 = aVar.fnV.username;
            if (!TextUtils.isEmpty(str2)) {
                this.fou.setVisibility(0);
                this.fou.setText(str2);
            } else {
                this.fou.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.fov.setVisibility(4);
        } else if (i2 == 2) {
            if (this.foK != aVar.fnV.startTime || this.foJ > aVar.fnV.foc) {
                this.foK = aVar.fnV.startTime;
                if (aVar.fnV.foc > 0) {
                    this.foJ = aVar.fnV.foc;
                    if (!TextUtils.isEmpty(aVar.fnV.fnZ)) {
                        this.fov.setVisibility(0);
                        this.fov.setText(aVar.fnV.fnZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.foJ)));
                        if (this.mHandler != null && this.foR != null) {
                            this.mHandler.removeCallbacks(this.foR);
                        }
                        startCountDown();
                    }
                } else {
                    this.fov.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.foL != aVar.fnV.startTime || this.foM != aVar.fnV.fod)) {
            this.foL = aVar.fnV.startTime;
            if (aVar.fnV.fod >= 0) {
                this.foM = aVar.fnV.fod;
                if (!TextUtils.isEmpty(aVar.fnV.fnZ)) {
                    this.fov.setVisibility(0);
                    this.fov.setText(aVar.fnV.fnZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.foM)));
                    if (this.mHandler != null && this.foQ != null) {
                        this.mHandler.removeCallbacks(this.foQ);
                    }
                    bpI();
                }
            } else {
                this.fov.setVisibility(8);
            }
        }
        if (!this.foI) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fox.getLayoutParams();
            if (i2 == 2 && aVar.fnW.foh != null && aVar.fnW.foh.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.foC, i);
            this.fox.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.foy.setVisibility(8);
        } else if (aVar.fnV.fof != null && aVar.fnV.fof.size() > 0) {
            if (this.foG == null) {
                this.foG = new com.baidu.tieba.ala.guardthrone.a.a(this.foC);
                this.foy.setAdapter((ListAdapter) this.foG);
            }
            this.foG.setList(aVar.fnV.fof);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.foC, this.foy);
            this.foy.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.foy.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.foy.setLayoutParams(layoutParams2);
            this.foy.setVisibility(0);
        } else {
            this.foy.setVisibility(8);
        }
        if (i2 == 2 && aVar.fnW.foh != null && aVar.fnW.foh.size() > 0) {
            if (this.foF == null) {
                this.foF = new b(this.foC);
                this.fow.setAdapter((ListAdapter) this.foF);
            }
            this.foF.setList(aVar.fnW.foh);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.fow);
            this.eOo.setVisibility(0);
        } else {
            this.eOo.setVisibility(8);
        }
        if (this.mIsHost) {
            this.foz.setVisibility(8);
        } else {
            this.foz.setVisibility(0);
            if (aVar.fnW.fog != null && !TextUtils.isEmpty(aVar.fnW.fog.text)) {
                if (aVar.fnW.fog.rank > 0 && aVar.fnW.fog.rank < 4) {
                    this.foA.setTextColor(this.foC.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.foA.setTextColor(this.foC.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.foA.setText(aVar.fnW.fog.text);
            }
            if (!TextUtils.isEmpty(aVar.fnV.fob) && TextUtils.equals(aVar.fnV.fob, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.foB.setVisibility(8);
            } else {
                this.foB.setVisibility(0);
            }
        }
        this.foN = aVar.fnV.foe;
        dw(this.foN);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.foC.finish();
        } else if (view == this.eIh) {
            bpE();
        } else if (view == this.foB || view == this.foz) {
            bpF();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bpE() {
        if (this.foC == null || this.fok == null || this.fok.fnV == null || TextUtils.isEmpty(this.fok.fnV.foa)) {
            BdUtilHelper.showToast(this.foC, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.foC.getPageContext(), "", new String[]{this.fok.fnV.foa}, false, null, true);
        }
    }

    private void bpF() {
        if (this.foC != null) {
            this.foC.bpx();
        }
        try {
            s sVar = new s();
            sVar.aqO = Integer.parseInt(this.ats);
            sVar.aqM = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void dw(long j) {
        if (this.mHandler != null && this.foP != null) {
            this.mHandler.removeCallbacks(this.foP);
            this.mHandler.postDelayed(this.foP, 1000 * j);
        }
    }

    public void bpG() {
        if (this.mHandler != null && this.foP != null) {
            this.mHandler.removeCallbacks(this.foP);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.foQ);
        this.mHandler.postDelayed(this.foQ, 1000L);
    }

    public void bpH() {
        if (this.mHandler != null && this.foQ != null) {
            this.mHandler.removeCallbacks(this.foQ);
        }
    }

    public void bpI() {
        this.mHandler.removeCallbacks(this.foR);
        this.mHandler.postDelayed(this.foR, 1000L);
    }

    public void bpJ() {
        if (this.mHandler != null && this.foR != null) {
            this.mHandler.removeCallbacks(this.foR);
        }
    }

    public void aHq() {
    }

    private View jJ(boolean z) {
        if (z) {
            return LayoutInflater.from(this.foC.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.foC.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.foH == null) {
                        a.this.foH = AnimationUtils.loadAnimation(a.this.foC.getActivity(), a.C0128a.sdk_push_up_in);
                    }
                    a.this.foq.setAnimation(a.this.foH);
                    a.this.foq.setVisibility(0);
                    a.this.foH.setDuration(300L);
                    a.this.foH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.foq != null) {
            this.foq.clearAnimation();
        }
        if (this.foD != null) {
            this.foD.onDestroy();
        }
        bpH();
        bpJ();
        bpG();
    }

    public Animation bpK() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.foH != null) {
            this.foH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.foC.getActivity(), a.C0128a.sdk_push_up_out);
        this.foq.setAnimation(loadAnimation);
        this.foq.setVisibility(8);
        return loadAnimation;
    }
}
