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
    private String aQi;
    private String aty;
    private ImageView eIm;
    private LinearLayout eOt;
    private TextView foA;
    private ListView foB;
    private ScrollView foC;
    private HListView foD;
    private RelativeLayout foE;
    private TextView foF;
    private TextView foG;
    protected final GuardThroneActivity foH;
    private com.baidu.tieba.ala.guardthrone.d.a foI;
    private a.InterfaceC0501a foJ;
    private b foK;
    private com.baidu.tieba.ala.guardthrone.a.a foL;
    private Animation foM;
    private boolean foN;
    private long foO;
    private long foP;
    private long foQ;
    private long foR;
    private long foS;
    private boolean foT;
    private com.baidu.tieba.ala.guardthrone.b.a fop;
    private View fot;
    private FrameLayout fou;
    private View fov;
    private View fow;
    private HeadImageView fox;
    private TbImageView foy;
    private TextView foz;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable foU = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foI != null) {
                a.this.foI.df(a.this.mLiveId, a.this.aQi);
            }
        }
    };
    private final Runnable foV = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foO <= 0) {
                a.this.foO = 0L;
                a.this.bpF();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.foO <= 0 || a.this.foA == null || a.this.fop == null || a.this.fop.foa == null || TextUtils.isEmpty(a.this.fop.foa.foe)) {
                if (a.this.foA != null && a.this.foA.getVisibility() == 0) {
                    a.this.foA.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fop.foa.foe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.foO));
            if (a.this.foA.getVisibility() != 0) {
                a.this.foA.setVisibility(0);
            }
            a.this.foA.setText(str);
        }
    };
    private final Runnable foW = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.foR <= 0) {
                a.this.foR = 0L;
                a.this.bpH();
            } else {
                a.i(a.this);
                a.this.bpG();
            }
            if (a.this.foR >= 0 && a.this.foA != null && a.this.fop != null && a.this.fop.foa != null && !TextUtils.isEmpty(a.this.fop.foa.foe)) {
                a.this.foA.setText(a.this.fop.foa.foe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.foR)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.foO;
        aVar.foO = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.foR;
        aVar.foR = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.foH = guardThroneActivity;
        this.foN = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = jJ(this.foN);
        this.fot = this.mRootView.findViewById(a.g.content_layout);
        this.fou = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fov = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.fow = this.mRootView.findViewById(a.g.view_foreground);
        this.eIm = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fox = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.foy = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.foz = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.foA = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.eOt = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.foB = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.foB.setDividerHeight(0);
        this.foC = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.foD = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.foD.setSelector(this.foH.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.foE = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.foF = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.foG = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bpx();
        bpy();
        bpz();
        bpA();
    }

    private void bpx() {
        this.fox.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fox.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fox.setIsRound(true);
        this.fox.setAutoChangeStyle(false);
        this.fox.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.foy.setDefaultResource(a.f.portrait_no_guard_bg);
        this.foy.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bpy() {
        if (this.foH != null) {
            ViewGroup.LayoutParams layoutParams = this.fow.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.foH) / 2;
            this.fow.setLayoutParams(layoutParams);
        }
    }

    private void bpz() {
        if (this.foN) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fov.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.foH) - BdUtilHelper.dip2px(this.foH, 68.0f);
            this.fov.setLayoutParams(layoutParams);
            this.foE.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bpA() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foC.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.foC.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.fot.setOnClickListener(this);
        this.fou.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eIm.setOnClickListener(this);
        this.foG.setOnClickListener(this);
        this.foE.setOnClickListener(this);
    }

    private void zp() {
        bpB();
        this.foI = new com.baidu.tieba.ala.guardthrone.d.a(this.foH.getPageContext(), this.foJ);
        this.foI.df(this.mLiveId, this.aQi);
    }

    private void bpB() {
        this.foJ = new a.InterfaceC0501a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0501a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0501a
            public void onFail(int i, String str) {
                a.this.foS = 5L;
                a.this.dw(a.this.foS);
                if (a.this.foH != null && !a.this.foT) {
                    a.this.foT = true;
                    BdUtilHelper.showToast(a.this.foH, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.aQi = str2;
        this.aty = str3;
        this.mTabId = i;
        zp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.foa == null || aVar.fob == null || this.foH == null) {
            this.foS = 5L;
            dw(this.foS);
            return;
        }
        this.fop = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.foa.fod)) {
            this.foy.startLoad(aVar.foa.fod, 10, false);
        }
        if (i2 == 1) {
            this.fox.setVisibility(8);
        } else {
            String str = aVar.foa.foc;
            if (!TextUtils.isEmpty(str)) {
                this.fox.setVisibility(0);
                this.fox.startLoad(str, 12, false);
            } else {
                this.fox.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.foa.foe)) {
                this.foz.setVisibility(0);
                this.foz.setText(aVar.foa.foe);
            } else {
                this.foz.setVisibility(4);
            }
        } else {
            String str2 = aVar.foa.username;
            if (!TextUtils.isEmpty(str2)) {
                this.foz.setVisibility(0);
                this.foz.setText(str2);
            } else {
                this.foz.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.foA.setVisibility(4);
        } else if (i2 == 2) {
            if (this.foP != aVar.foa.startTime || this.foO > aVar.foa.foh) {
                this.foP = aVar.foa.startTime;
                if (aVar.foa.foh > 0) {
                    this.foO = aVar.foa.foh;
                    if (!TextUtils.isEmpty(aVar.foa.foe)) {
                        this.foA.setVisibility(0);
                        this.foA.setText(aVar.foa.foe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.foO)));
                        if (this.mHandler != null && this.foW != null) {
                            this.mHandler.removeCallbacks(this.foW);
                        }
                        startCountDown();
                    }
                } else {
                    this.foA.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.foQ != aVar.foa.startTime || this.foR != aVar.foa.foi)) {
            this.foQ = aVar.foa.startTime;
            if (aVar.foa.foi >= 0) {
                this.foR = aVar.foa.foi;
                if (!TextUtils.isEmpty(aVar.foa.foe)) {
                    this.foA.setVisibility(0);
                    this.foA.setText(aVar.foa.foe + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.foR)));
                    if (this.mHandler != null && this.foV != null) {
                        this.mHandler.removeCallbacks(this.foV);
                    }
                    bpG();
                }
            } else {
                this.foA.setVisibility(8);
            }
        }
        if (!this.foN) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foC.getLayoutParams();
            if (i2 == 2 && aVar.fob.fom != null && aVar.fob.fom.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.foH, i);
            this.foC.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.foD.setVisibility(8);
        } else if (aVar.foa.fok != null && aVar.foa.fok.size() > 0) {
            if (this.foL == null) {
                this.foL = new com.baidu.tieba.ala.guardthrone.a.a(this.foH);
                this.foD.setAdapter((ListAdapter) this.foL);
            }
            this.foL.setList(aVar.foa.fok);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.foH, this.foD);
            this.foD.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.foD.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.foD.setLayoutParams(layoutParams2);
            this.foD.setVisibility(0);
        } else {
            this.foD.setVisibility(8);
        }
        if (i2 == 2 && aVar.fob.fom != null && aVar.fob.fom.size() > 0) {
            if (this.foK == null) {
                this.foK = new b(this.foH);
                this.foB.setAdapter((ListAdapter) this.foK);
            }
            this.foK.setList(aVar.fob.fom);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.foB);
            this.eOt.setVisibility(0);
        } else {
            this.eOt.setVisibility(8);
        }
        if (this.mIsHost) {
            this.foE.setVisibility(8);
        } else {
            this.foE.setVisibility(0);
            if (aVar.fob.fol != null && !TextUtils.isEmpty(aVar.fob.fol.text)) {
                if (aVar.fob.fol.rank > 0 && aVar.fob.fol.rank < 4) {
                    this.foF.setTextColor(this.foH.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.foF.setTextColor(this.foH.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.foF.setText(aVar.fob.fol.text);
            }
            if (!TextUtils.isEmpty(aVar.foa.fog) && TextUtils.equals(aVar.foa.fog, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.foG.setVisibility(8);
            } else {
                this.foG.setVisibility(0);
            }
        }
        this.foS = aVar.foa.foj;
        dw(this.foS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.foH.finish();
        } else if (view == this.eIm) {
            bpC();
        } else if (view == this.foG || view == this.foE) {
            bpD();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bpC() {
        if (this.foH == null || this.fop == null || this.fop.foa == null || TextUtils.isEmpty(this.fop.foa.fof)) {
            BdUtilHelper.showToast(this.foH, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.foH.getPageContext(), "", new String[]{this.fop.foa.fof}, false, null, true);
        }
    }

    private void bpD() {
        if (this.foH != null) {
            this.foH.bpv();
        }
        try {
            s sVar = new s();
            sVar.aqU = Integer.parseInt(this.aty);
            sVar.aqS = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void dw(long j) {
        if (this.mHandler != null && this.foU != null) {
            this.mHandler.removeCallbacks(this.foU);
            this.mHandler.postDelayed(this.foU, 1000 * j);
        }
    }

    public void bpE() {
        if (this.mHandler != null && this.foU != null) {
            this.mHandler.removeCallbacks(this.foU);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.foV);
        this.mHandler.postDelayed(this.foV, 1000L);
    }

    public void bpF() {
        if (this.mHandler != null && this.foV != null) {
            this.mHandler.removeCallbacks(this.foV);
        }
    }

    public void bpG() {
        this.mHandler.removeCallbacks(this.foW);
        this.mHandler.postDelayed(this.foW, 1000L);
    }

    public void bpH() {
        if (this.mHandler != null && this.foW != null) {
            this.mHandler.removeCallbacks(this.foW);
        }
    }

    public void aHo() {
    }

    private View jJ(boolean z) {
        if (z) {
            return LayoutInflater.from(this.foH.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.foH.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.foM == null) {
                        a.this.foM = AnimationUtils.loadAnimation(a.this.foH.getActivity(), a.C0149a.sdk_push_up_in);
                    }
                    a.this.fov.setAnimation(a.this.foM);
                    a.this.fov.setVisibility(0);
                    a.this.foM.setDuration(300L);
                    a.this.foM.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fov != null) {
            this.fov.clearAnimation();
        }
        if (this.foI != null) {
            this.foI.onDestroy();
        }
        bpF();
        bpH();
        bpE();
    }

    public Animation bpI() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.foM != null) {
            this.foM.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.foH.getActivity(), a.C0149a.sdk_push_up_out);
        this.fov.setAnimation(loadAnimation);
        this.fov.setVisibility(8);
        return loadAnimation;
    }
}
