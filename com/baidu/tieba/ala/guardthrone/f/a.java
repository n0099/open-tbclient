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
    private String awo;
    private TextView eJA;
    private TextView eJB;
    protected final GuardThroneActivity eJC;
    private com.baidu.tieba.ala.guardthrone.d.a eJD;
    private a.InterfaceC0445a eJE;
    private b eJF;
    private com.baidu.tieba.ala.guardthrone.a.a eJG;
    private Animation eJH;
    private boolean eJI;
    private long eJJ;
    private long eJK;
    private long eJL;
    private long eJM;
    private long eJN;
    private boolean eJO;
    private com.baidu.tieba.ala.guardthrone.b.a eJk;
    private View eJo;
    private FrameLayout eJp;
    private View eJq;
    private View eJr;
    private HeadImageView eJs;
    private TbImageView eJt;
    private TextView eJu;
    private TextView eJv;
    private ListView eJw;
    private ScrollView eJx;
    private HListView eJy;
    private RelativeLayout eJz;
    private ImageView ehP;
    private LinearLayout ekl;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eJP = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJD != null) {
                a.this.eJD.cS(a.this.mLiveId, a.this.awo);
            }
        }
    };
    private final Runnable eJQ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJJ <= 0) {
                a.this.eJJ = 0L;
                a.this.bgk();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eJJ <= 0 || a.this.eJv == null || a.this.eJk == null || a.this.eJk.eIV == null || TextUtils.isEmpty(a.this.eJk.eIV.eIZ)) {
                if (a.this.eJv != null && a.this.eJv.getVisibility() == 0) {
                    a.this.eJv.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eJk.eIV.eIZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJJ));
            if (a.this.eJv.getVisibility() != 0) {
                a.this.eJv.setVisibility(0);
            }
            a.this.eJv.setText(str);
        }
    };
    private final Runnable eJR = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJM <= 0) {
                a.this.eJM = 0L;
                a.this.bgm();
            } else {
                a.i(a.this);
                a.this.bgl();
            }
            if (a.this.eJM >= 0 && a.this.eJv != null && a.this.eJk != null && a.this.eJk.eIV != null && !TextUtils.isEmpty(a.this.eJk.eIV.eIZ)) {
                a.this.eJv.setText(a.this.eJk.eIV.eIZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJM)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eJJ;
        aVar.eJJ = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eJM;
        aVar.eJM = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eJC = guardThroneActivity;
        this.eJI = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = iG(this.eJI);
        this.eJo = this.mRootView.findViewById(a.g.content_layout);
        this.eJp = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eJq = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eJr = this.mRootView.findViewById(a.g.view_foreground);
        this.ehP = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eJs = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eJt = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eJu = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eJv = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.ekl = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eJw = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eJw.setDividerHeight(0);
        this.eJx = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eJy = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eJy.setSelector(this.eJC.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eJz = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eJA = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eJB = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bgc();
        bgd();
        bge();
        bgf();
    }

    private void bgc() {
        this.eJs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJs.setIsRound(true);
        this.eJs.setAutoChangeStyle(false);
        this.eJs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eJt.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eJt.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bgd() {
        if (this.eJC != null) {
            ViewGroup.LayoutParams layoutParams = this.eJr.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJC) / 2;
            this.eJr.setLayoutParams(layoutParams);
        }
    }

    private void bge() {
        if (this.eJI) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eJq.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJC) - BdUtilHelper.dip2px(this.eJC, 68.0f);
            this.eJq.setLayoutParams(layoutParams);
            this.eJz.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bgf() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJx.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eJx.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eJo.setOnClickListener(this);
        this.eJp.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ehP.setOnClickListener(this);
        this.eJB.setOnClickListener(this);
        this.eJz.setOnClickListener(this);
    }

    private void dQ() {
        bgg();
        this.eJD = new com.baidu.tieba.ala.guardthrone.d.a(this.eJC.getPageContext(), this.eJE);
        this.eJD.cS(this.mLiveId, this.awo);
    }

    private void bgg() {
        this.eJE = new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void onFail(int i, String str) {
                a.this.eJN = 5L;
                a.this.cO(a.this.eJN);
                if (a.this.eJC != null && !a.this.eJO) {
                    a.this.eJO = true;
                    BdUtilHelper.showToast(a.this.eJC, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.awo = str2;
        this.aaT = str3;
        this.mTabId = i;
        dQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eIV == null || aVar.eIW == null || this.eJC == null) {
            this.eJN = 5L;
            cO(this.eJN);
            return;
        }
        this.eJk = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eIV.eIY)) {
            this.eJt.startLoad(aVar.eIV.eIY, 10, false);
        }
        if (i2 == 1) {
            this.eJs.setVisibility(8);
        } else {
            String str = aVar.eIV.eIX;
            if (!TextUtils.isEmpty(str)) {
                this.eJs.setVisibility(0);
                this.eJs.startLoad(str, 12, false);
            } else {
                this.eJs.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eIV.eIZ)) {
                this.eJu.setVisibility(0);
                this.eJu.setText(aVar.eIV.eIZ);
            } else {
                this.eJu.setVisibility(4);
            }
        } else {
            String str2 = aVar.eIV.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eJu.setVisibility(0);
                this.eJu.setText(str2);
            } else {
                this.eJu.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eJv.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eJK != aVar.eIV.startTime || this.eJJ > aVar.eIV.eJc) {
                this.eJK = aVar.eIV.startTime;
                if (aVar.eIV.eJc > 0) {
                    this.eJJ = aVar.eIV.eJc;
                    if (!TextUtils.isEmpty(aVar.eIV.eIZ)) {
                        this.eJv.setVisibility(0);
                        this.eJv.setText(aVar.eIV.eIZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJJ)));
                        if (this.mHandler != null && this.eJR != null) {
                            this.mHandler.removeCallbacks(this.eJR);
                        }
                        startCountDown();
                    }
                } else {
                    this.eJv.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eJL != aVar.eIV.startTime || this.eJM != aVar.eIV.eJd)) {
            this.eJL = aVar.eIV.startTime;
            if (aVar.eIV.eJd >= 0) {
                this.eJM = aVar.eIV.eJd;
                if (!TextUtils.isEmpty(aVar.eIV.eIZ)) {
                    this.eJv.setVisibility(0);
                    this.eJv.setText(aVar.eIV.eIZ + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJM)));
                    if (this.mHandler != null && this.eJQ != null) {
                        this.mHandler.removeCallbacks(this.eJQ);
                    }
                    bgl();
                }
            } else {
                this.eJv.setVisibility(8);
            }
        }
        if (!this.eJI) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJx.getLayoutParams();
            if (i2 == 2 && aVar.eIW.eJh != null && aVar.eIW.eJh.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eJC, i);
            this.eJx.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eJy.setVisibility(8);
        } else if (aVar.eIV.eJf != null && aVar.eIV.eJf.size() > 0) {
            if (this.eJG == null) {
                this.eJG = new com.baidu.tieba.ala.guardthrone.a.a(this.eJC);
                this.eJy.setAdapter((ListAdapter) this.eJG);
            }
            this.eJG.setList(aVar.eIV.eJf);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eJC, this.eJy);
            this.eJy.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJy.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eJy.setLayoutParams(layoutParams2);
            this.eJy.setVisibility(0);
        } else {
            this.eJy.setVisibility(8);
        }
        if (i2 == 2 && aVar.eIW.eJh != null && aVar.eIW.eJh.size() > 0) {
            if (this.eJF == null) {
                this.eJF = new b(this.eJC);
                this.eJw.setAdapter((ListAdapter) this.eJF);
            }
            this.eJF.setList(aVar.eIW.eJh);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eJw);
            this.ekl.setVisibility(0);
        } else {
            this.ekl.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eJz.setVisibility(8);
        } else {
            this.eJz.setVisibility(0);
            if (aVar.eIW.eJg != null && !TextUtils.isEmpty(aVar.eIW.eJg.text)) {
                if (aVar.eIW.eJg.rank > 0 && aVar.eIW.eJg.rank < 4) {
                    this.eJA.setTextColor(this.eJC.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eJA.setTextColor(this.eJC.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eJA.setText(aVar.eIW.eJg.text);
            }
            if (!TextUtils.isEmpty(aVar.eIV.eJb) && TextUtils.equals(aVar.eIV.eJb, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eJB.setVisibility(8);
            } else {
                this.eJB.setVisibility(0);
            }
        }
        this.eJN = aVar.eIV.eJe;
        cO(this.eJN);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eJC.finish();
        } else if (view == this.ehP) {
            bgh();
        } else if (view == this.eJB || view == this.eJz) {
            bgi();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bgh() {
        if (this.eJC == null || this.eJk == null || this.eJk.eIV == null || TextUtils.isEmpty(this.eJk.eIV.eJa)) {
            BdUtilHelper.showToast(this.eJC, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eJC.getPageContext(), "", new String[]{this.eJk.eIV.eJa}, false, null, true);
        }
    }

    private void bgi() {
        if (this.eJC != null) {
            this.eJC.bga();
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
        if (this.mHandler != null && this.eJP != null) {
            this.mHandler.removeCallbacks(this.eJP);
            this.mHandler.postDelayed(this.eJP, 1000 * j);
        }
    }

    public void bgj() {
        if (this.mHandler != null && this.eJP != null) {
            this.mHandler.removeCallbacks(this.eJP);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eJQ);
        this.mHandler.postDelayed(this.eJQ, 1000L);
    }

    public void bgk() {
        if (this.mHandler != null && this.eJQ != null) {
            this.mHandler.removeCallbacks(this.eJQ);
        }
    }

    public void bgl() {
        this.mHandler.removeCallbacks(this.eJR);
        this.mHandler.postDelayed(this.eJR, 1000L);
    }

    public void bgm() {
        if (this.mHandler != null && this.eJR != null) {
            this.mHandler.removeCallbacks(this.eJR);
        }
    }

    public void azc() {
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eJC.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eJC.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eJH == null) {
                        a.this.eJH = AnimationUtils.loadAnimation(a.this.eJC.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    a.this.eJq.setAnimation(a.this.eJH);
                    a.this.eJq.setVisibility(0);
                    a.this.eJH.setDuration(300L);
                    a.this.eJH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eJq != null) {
            this.eJq.clearAnimation();
        }
        if (this.eJD != null) {
            this.eJD.onDestroy();
        }
        bgk();
        bgm();
        bgj();
    }

    public Animation bgn() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJH != null) {
            this.eJH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eJC.getActivity(), a.C0102a.sdk_push_up_out);
        this.eJq.setAnimation(loadAnimation);
        this.eJq.setVisibility(8);
        return loadAnimation;
    }
}
