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
    private String awn;
    private TextView eJA;
    protected final GuardThroneActivity eJB;
    private com.baidu.tieba.ala.guardthrone.d.a eJC;
    private a.InterfaceC0445a eJD;
    private b eJE;
    private com.baidu.tieba.ala.guardthrone.a.a eJF;
    private Animation eJG;
    private boolean eJH;
    private long eJI;
    private long eJJ;
    private long eJK;
    private long eJL;
    private long eJM;
    private boolean eJN;
    private com.baidu.tieba.ala.guardthrone.b.a eJj;
    private View eJn;
    private FrameLayout eJo;
    private View eJp;
    private View eJq;
    private HeadImageView eJr;
    private TbImageView eJs;
    private TextView eJt;
    private TextView eJu;
    private ListView eJv;
    private ScrollView eJw;
    private HListView eJx;
    private RelativeLayout eJy;
    private TextView eJz;
    private ImageView ehO;
    private LinearLayout ekk;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private Handler mHandler = new Handler();
    private final Runnable eJO = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJC != null) {
                a.this.eJC.cS(a.this.mLiveId, a.this.awn);
            }
        }
    };
    private final Runnable eJP = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJI <= 0) {
                a.this.eJI = 0L;
                a.this.bgi();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.eJI <= 0 || a.this.eJu == null || a.this.eJj == null || a.this.eJj.eIU == null || TextUtils.isEmpty(a.this.eJj.eIU.eIY)) {
                if (a.this.eJu != null && a.this.eJu.getVisibility() == 0) {
                    a.this.eJu.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.eJj.eIU.eIY + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJI));
            if (a.this.eJu.getVisibility() != 0) {
                a.this.eJu.setVisibility(0);
            }
            a.this.eJu.setText(str);
        }
    };
    private final Runnable eJQ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eJL <= 0) {
                a.this.eJL = 0L;
                a.this.bgk();
            } else {
                a.i(a.this);
                a.this.bgj();
            }
            if (a.this.eJL >= 0 && a.this.eJu != null && a.this.eJj != null && a.this.eJj.eIU != null && !TextUtils.isEmpty(a.this.eJj.eIU.eIY)) {
                a.this.eJu.setText(a.this.eJj.eIU.eIY + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.eJL)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.eJI;
        aVar.eJI = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.eJL;
        aVar.eJL = 1 + j;
        return j;
    }

    public a(GuardThroneActivity guardThroneActivity, boolean z, boolean z2) {
        this.eJB = guardThroneActivity;
        this.eJH = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = iG(this.eJH);
        this.eJn = this.mRootView.findViewById(a.g.content_layout);
        this.eJo = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.eJp = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.eJq = this.mRootView.findViewById(a.g.view_foreground);
        this.ehO = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.eJr = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.eJs = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.eJt = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.eJu = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.ekk = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.eJv = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.eJv.setDividerHeight(0);
        this.eJw = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.eJx = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.eJx.setSelector(this.eJB.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.eJy = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.eJz = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.eJA = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bga();
        bgb();
        bgc();
        bgd();
    }

    private void bga() {
        this.eJr.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJr.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.eJr.setIsRound(true);
        this.eJr.setAutoChangeStyle(false);
        this.eJr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eJs.setDefaultResource(a.f.portrait_no_guard_bg);
        this.eJs.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bgb() {
        if (this.eJB != null) {
            ViewGroup.LayoutParams layoutParams = this.eJq.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJB) / 2;
            this.eJq.setLayoutParams(layoutParams);
        }
    }

    private void bgc() {
        if (this.eJH) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eJp.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.eJB) - BdUtilHelper.dip2px(this.eJB, 68.0f);
            this.eJp.setLayoutParams(layoutParams);
            this.eJy.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bgd() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJw.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.eJw.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.eJn.setOnClickListener(this);
        this.eJo.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ehO.setOnClickListener(this);
        this.eJA.setOnClickListener(this);
        this.eJy.setOnClickListener(this);
    }

    private void dQ() {
        bge();
        this.eJC = new com.baidu.tieba.ala.guardthrone.d.a(this.eJB.getPageContext(), this.eJD);
        this.eJC.cS(this.mLiveId, this.awn);
    }

    private void bge() {
        this.eJD = new a.InterfaceC0445a() { // from class: com.baidu.tieba.ala.guardthrone.f.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0445a
            public void onFail(int i, String str) {
                a.this.eJM = 5L;
                a.this.cO(a.this.eJM);
                if (a.this.eJB != null && !a.this.eJN) {
                    a.this.eJN = true;
                    BdUtilHelper.showToast(a.this.eJB, str);
                }
            }
        };
    }

    public void e(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.awn = str2;
        this.aaT = str3;
        this.mTabId = i;
        dQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        int i;
        if (aVar == null || aVar.eIU == null || aVar.eIV == null || this.eJB == null) {
            this.eJM = 5L;
            cO(this.eJM);
            return;
        }
        this.eJj = aVar;
        int i2 = aVar.status;
        if (!TextUtils.isEmpty(aVar.eIU.eIX)) {
            this.eJs.startLoad(aVar.eIU.eIX, 10, false);
        }
        if (i2 == 1) {
            this.eJr.setVisibility(8);
        } else {
            String str = aVar.eIU.eIW;
            if (!TextUtils.isEmpty(str)) {
                this.eJr.setVisibility(0);
                this.eJr.startLoad(str, 12, false);
            } else {
                this.eJr.setVisibility(8);
            }
        }
        if (i2 == 1) {
            if (!TextUtils.isEmpty(aVar.eIU.eIY)) {
                this.eJt.setVisibility(0);
                this.eJt.setText(aVar.eIU.eIY);
            } else {
                this.eJt.setVisibility(4);
            }
        } else {
            String str2 = aVar.eIU.username;
            if (!TextUtils.isEmpty(str2)) {
                this.eJt.setVisibility(0);
                this.eJt.setText(str2);
            } else {
                this.eJt.setVisibility(8);
            }
        }
        if (i2 == 1) {
            this.eJu.setVisibility(4);
        } else if (i2 == 2) {
            if (this.eJJ != aVar.eIU.startTime || this.eJI > aVar.eIU.eJb) {
                this.eJJ = aVar.eIU.startTime;
                if (aVar.eIU.eJb > 0) {
                    this.eJI = aVar.eIU.eJb;
                    if (!TextUtils.isEmpty(aVar.eIU.eIY)) {
                        this.eJu.setVisibility(0);
                        this.eJu.setText(aVar.eIU.eIY + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJI)));
                        if (this.mHandler != null && this.eJQ != null) {
                            this.mHandler.removeCallbacks(this.eJQ);
                        }
                        startCountDown();
                    }
                } else {
                    this.eJu.setVisibility(8);
                }
            }
        } else if (i2 == 3 && (this.eJK != aVar.eIU.startTime || this.eJL != aVar.eIU.eJc)) {
            this.eJK = aVar.eIU.startTime;
            if (aVar.eIU.eJc >= 0) {
                this.eJL = aVar.eIU.eJc;
                if (!TextUtils.isEmpty(aVar.eIU.eIY)) {
                    this.eJu.setVisibility(0);
                    this.eJu.setText(aVar.eIU.eIY + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.eJL)));
                    if (this.mHandler != null && this.eJP != null) {
                        this.mHandler.removeCallbacks(this.eJP);
                    }
                    bgj();
                }
            } else {
                this.eJu.setVisibility(8);
            }
        }
        if (!this.eJH) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJw.getLayoutParams();
            if (i2 == 2 && aVar.eIV.eJg != null && aVar.eIV.eJg.size() > 0) {
                i = 20;
            } else {
                i = 40;
            }
            layoutParams.topMargin = BdUtilHelper.dip2px(this.eJB, i);
            this.eJw.setLayoutParams(layoutParams);
        }
        if (i2 == 2) {
            this.eJx.setVisibility(8);
        } else if (aVar.eIU.eJe != null && aVar.eIU.eJe.size() > 0) {
            if (this.eJF == null) {
                this.eJF = new com.baidu.tieba.ala.guardthrone.a.a(this.eJB);
                this.eJx.setAdapter((ListAdapter) this.eJF);
            }
            this.eJF.setList(aVar.eIU.eJe);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.eJB, this.eJx);
            this.eJx.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJx.getLayoutParams();
            layoutParams2.leftMargin = a;
            layoutParams2.rightMargin = a;
            this.eJx.setLayoutParams(layoutParams2);
            this.eJx.setVisibility(0);
        } else {
            this.eJx.setVisibility(8);
        }
        if (i2 == 2 && aVar.eIV.eJg != null && aVar.eIV.eJg.size() > 0) {
            if (this.eJE == null) {
                this.eJE = new b(this.eJB);
                this.eJv.setAdapter((ListAdapter) this.eJE);
            }
            this.eJE.setList(aVar.eIV.eJg);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.eJv);
            this.ekk.setVisibility(0);
        } else {
            this.ekk.setVisibility(8);
        }
        if (this.mIsHost) {
            this.eJy.setVisibility(8);
        } else {
            this.eJy.setVisibility(0);
            if (aVar.eIV.eJf != null && !TextUtils.isEmpty(aVar.eIV.eJf.text)) {
                if (aVar.eIV.eJf.rank > 0 && aVar.eIV.eJf.rank < 4) {
                    this.eJz.setTextColor(this.eJB.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.eJz.setTextColor(this.eJB.getResources().getColor(a.d.ala_guard_throne_color_FFBF6B));
                }
                this.eJz.setText(aVar.eIV.eJf.text);
            }
            if (!TextUtils.isEmpty(aVar.eIU.eJa) && TextUtils.equals(aVar.eIU.eJa, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.eJA.setVisibility(8);
            } else {
                this.eJA.setVisibility(0);
            }
        }
        this.eJM = aVar.eIU.eJd;
        cO(this.eJM);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.eJB.finish();
        } else if (view == this.ehO) {
            bgf();
        } else if (view == this.eJA || view == this.eJy) {
            bgg();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.ala.guardthrone.GuardThroneActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void bgf() {
        if (this.eJB == null || this.eJj == null || this.eJj.eIU == null || TextUtils.isEmpty(this.eJj.eIU.eIZ)) {
            BdUtilHelper.showToast(this.eJB, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.eJB.getPageContext(), "", new String[]{this.eJj.eIU.eIZ}, false, null, true);
        }
    }

    private void bgg() {
        if (this.eJB != null) {
            this.eJB.bfY();
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
        if (this.mHandler != null && this.eJO != null) {
            this.mHandler.removeCallbacks(this.eJO);
            this.mHandler.postDelayed(this.eJO, 1000 * j);
        }
    }

    public void bgh() {
        if (this.mHandler != null && this.eJO != null) {
            this.mHandler.removeCallbacks(this.eJO);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eJP);
        this.mHandler.postDelayed(this.eJP, 1000L);
    }

    public void bgi() {
        if (this.mHandler != null && this.eJP != null) {
            this.mHandler.removeCallbacks(this.eJP);
        }
    }

    public void bgj() {
        this.mHandler.removeCallbacks(this.eJQ);
        this.mHandler.postDelayed(this.eJQ, 1000L);
    }

    public void bgk() {
        if (this.mHandler != null && this.eJQ != null) {
            this.mHandler.removeCallbacks(this.eJQ);
        }
    }

    public void aza() {
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.eJB.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.eJB.getPageContext().getPageActivity()).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.f.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.eJG == null) {
                        a.this.eJG = AnimationUtils.loadAnimation(a.this.eJB.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    a.this.eJp.setAnimation(a.this.eJG);
                    a.this.eJp.setVisibility(0);
                    a.this.eJG.setDuration(300L);
                    a.this.eJG.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.eJp != null) {
            this.eJp.clearAnimation();
        }
        if (this.eJC != null) {
            this.eJC.onDestroy();
        }
        bgi();
        bgk();
        bgh();
    }

    public Animation bgl() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJG != null) {
            this.eJG.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.eJB.getActivity(), a.C0102a.sdk_push_up_out);
        this.eJp.setAnimation(loadAnimation);
        this.eJp.setVisibility(8);
        return loadAnimation;
    }
}
