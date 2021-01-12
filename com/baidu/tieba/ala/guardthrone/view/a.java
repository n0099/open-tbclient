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
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private String aKn;
    private String bre;
    private long bsx;
    private ImageView gmW;
    private LinearLayout gwB;
    private ScrollView haA;
    private HListView haB;
    private RelativeLayout haC;
    private TextView haD;
    private TextView haE;
    private com.baidu.tieba.ala.guardthrone.d.a haF;
    private a.InterfaceC0643a haG;
    private b haH;
    private com.baidu.tieba.ala.guardthrone.adapter.a haI;
    private Animation haJ;
    private boolean haK;
    private long haL;
    private long haM;
    private long haN;
    private long haO;
    private boolean haP;
    private com.baidu.tieba.ala.guardthrone.b.a hak;
    private View har;
    private FrameLayout has;
    private View hat;
    private View hau;
    private HeadImageView hav;
    private TbImageView haw;
    private TextView hax;
    private TextView hay;
    private ListView haz;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bsA = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.haF != null) {
                a.this.haF.es(a.this.mLiveId, a.this.bre);
            }
        }
    };
    private final Runnable haQ = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.haL <= 0) {
                a.this.haL = 0L;
                a.this.bVT();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.haL <= 0 || a.this.hay == null || a.this.hak == null || a.this.hak.gZV == null || TextUtils.isEmpty(a.this.hak.gZV.gZZ)) {
                if (a.this.hay != null && a.this.hay.getVisibility() == 0) {
                    a.this.hay.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.hak.gZV.gZZ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.haL));
            if (a.this.hay.getVisibility() != 0) {
                a.this.hay.setVisibility(0);
            }
            a.this.hay.setText(str);
        }
    };
    private final Runnable haR = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.haO <= 0) {
                a.this.haO = 0L;
                a.this.bVV();
            } else {
                a.i(a.this);
                a.this.bVU();
            }
            if (a.this.haO >= 0 && a.this.hay != null && a.this.hak != null && a.this.hak.gZV != null && !TextUtils.isEmpty(a.this.hak.gZV.gZZ)) {
                a.this.hay.setText(a.this.hak.gZV.gZZ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(a.this.haO)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.haL;
        aVar.haL = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.haO;
        aVar.haO = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.haK = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = nn(this.haK);
        this.har = this.mRootView.findViewById(a.f.content_layout);
        this.has = (FrameLayout) this.mRootView.findViewById(a.f.portrait_layout);
        this.hat = this.mRootView.findViewById(a.f.guard_throne_layout);
        this.hau = this.mRootView.findViewById(a.f.view_foreground);
        this.gmW = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.hav = (HeadImageView) this.mRootView.findViewById(a.f.iv_portrait);
        this.haw = (TbImageView) this.mRootView.findViewById(a.f.iv_portrait_border);
        this.hax = (TextView) this.mRootView.findViewById(a.f.tv_guarder_name);
        this.hay = (TextView) this.mRootView.findViewById(a.f.tv_guard_throne_countdown);
        this.gwB = (LinearLayout) this.mRootView.findViewById(a.f.guard_throne_rank_view);
        this.haz = (ListView) this.mRootView.findViewById(a.f.rank_list_view);
        this.haz.setDividerHeight(0);
        this.haA = (ScrollView) this.mRootView.findViewById(a.f.guard_throne_scrollview);
        this.haB = (HListView) this.mRootView.findViewById(a.f.privilege_list_view);
        this.haB.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.haC = (RelativeLayout) this.mRootView.findViewById(a.f.guard_throne_bottom_view);
        this.haD = (TextView) this.mRootView.findViewById(a.f.tv_bottom);
        this.haE = (TextView) this.mRootView.findViewById(a.f.btn_bottom_start);
        bVL();
        bVM();
        bVN();
        bVO();
    }

    private void bVL() {
        this.hav.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hav.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hav.setIsRound(true);
        this.hav.setAutoChangeStyle(false);
        this.hav.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.haw.setDefaultResource(a.e.portrait_no_guard_bg);
        this.haw.setDefaultBgResource(a.c.sdk_transparent);
    }

    private void bVM() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.hau.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.hau.setLayoutParams(layoutParams);
        }
    }

    private void bVN() {
        if (this.haK) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hat.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.hat.setLayoutParams(layoutParams);
            this.haC.setBackgroundResource(a.e.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bVO() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.haA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.haA.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.har.setOnClickListener(this);
        this.has.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gmW.setOnClickListener(this);
        this.haE.setOnClickListener(this);
        this.haC.setOnClickListener(this);
    }

    private void initModel() {
        bVP();
        this.haF = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.haG);
        this.haF.es(this.mLiveId, this.bre);
    }

    private void bVP() {
        this.haG = new a.InterfaceC0643a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void onFail(int i, String str) {
                a.this.bsx = 5L;
                a.this.bb(a.this.bsx);
                if (a.this.mActivity != null && !a.this.haP) {
                    a.this.haP = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void i(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bre = str2;
        this.aKn = str3;
        this.mTabId = i;
        initModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gZV == null || aVar.gZW == null || this.mActivity == null) {
            this.bsx = 5L;
            bb(this.bsx);
            return;
        }
        this.hak = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gZV.gZY)) {
            this.haw.startLoad(aVar.gZV.gZY, 10, false);
        }
        if (i == 1) {
            this.hav.setVisibility(8);
        } else {
            String str = aVar.gZV.gZX;
            if (!TextUtils.isEmpty(str)) {
                this.hav.setVisibility(0);
                this.hav.startLoad(str, 12, false);
            } else {
                this.hav.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gZV.gZZ)) {
                this.hax.setVisibility(0);
                this.hax.setText(aVar.gZV.gZZ);
            } else {
                this.hax.setVisibility(4);
            }
        } else {
            String str2 = aVar.gZV.username;
            if (!TextUtils.isEmpty(str2)) {
                this.hax.setVisibility(0);
                this.hax.setText(str2);
            } else {
                this.hax.setVisibility(8);
            }
        }
        if (i == 1) {
            this.hay.setVisibility(4);
        } else if (i == 2) {
            if (this.haM != aVar.gZV.startTime || this.haL > aVar.gZV.countdown) {
                this.haM = aVar.gZV.startTime;
                if (aVar.gZV.countdown > 0) {
                    this.haL = aVar.gZV.countdown;
                    if (!TextUtils.isEmpty(aVar.gZV.gZZ)) {
                        this.hay.setVisibility(0);
                        this.hay.setText(aVar.gZV.gZZ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.haL)));
                        if (this.mHandler != null && this.haR != null) {
                            this.mHandler.removeCallbacks(this.haR);
                        }
                        startCountDown();
                    }
                } else {
                    this.hay.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.haN != aVar.gZV.startTime || this.haO != aVar.gZV.hac)) {
            this.haN = aVar.gZV.startTime;
            if (aVar.gZV.hac >= 0) {
                this.haO = aVar.gZV.hac;
                if (!TextUtils.isEmpty(aVar.gZV.gZZ)) {
                    this.hay.setVisibility(0);
                    this.hay.setText(aVar.gZV.gZZ + com.baidu.tieba.ala.guardthrone.e.a.f(Long.valueOf(this.haO)));
                    if (this.mHandler != null && this.haQ != null) {
                        this.mHandler.removeCallbacks(this.haQ);
                    }
                    bVU();
                }
            } else {
                this.hay.setVisibility(8);
            }
        }
        if (i == 2) {
            this.haB.setVisibility(8);
        } else if (aVar.gZV.hae != null && aVar.gZV.hae.size() > 0) {
            if (this.haI == null) {
                this.haI = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.haB.setAdapter((ListAdapter) this.haI);
            }
            this.haI.setList(aVar.gZV.hae);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.haB);
            this.haB.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.haB.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.haB.setLayoutParams(layoutParams);
            this.haB.setVisibility(0);
        } else {
            this.haB.setVisibility(8);
        }
        if (i == 2 && aVar.gZW.aEK != null && aVar.gZW.aEK.size() > 0) {
            if (this.haH == null) {
                this.haH = new b(this.mActivity);
                this.haz.setAdapter((ListAdapter) this.haH);
            }
            this.haH.setList(aVar.gZW.aEK);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.haz);
            this.gwB.setVisibility(0);
        } else {
            this.gwB.setVisibility(8);
        }
        if (this.mIsHost) {
            this.haC.setVisibility(8);
        } else {
            this.haC.setVisibility(0);
            if (aVar.gZW.haf != null && !TextUtils.isEmpty(aVar.gZW.haf.text)) {
                if (aVar.gZW.haf.rank > 0 && aVar.gZW.haf.rank < 4) {
                    this.haD.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_FFB92D));
                } else {
                    this.haD.setTextColor(this.mActivity.getResources().getColor(a.c.ala_guard_throne_color_E5B372));
                }
                this.haD.setText(aVar.gZW.haf.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gZV.hab) && TextUtils.equals(aVar.gZV.hab, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.haE.setVisibility(8);
            } else {
                this.haE.setVisibility(0);
            }
        }
        this.bsx = aVar.gZV.had;
        bb(this.bsx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.gmW) {
            bVQ();
        } else if (view == this.haE || view == this.haC) {
            bVR();
        }
    }

    private void bVQ() {
        if (this.mActivity == null || this.hak == null || this.hak.gZV == null || TextUtils.isEmpty(this.hak.gZV.haa)) {
            BdUtilHelper.showToast(this.mActivity, a.h.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.hak.gZV.haa}, false, null, true);
        }
    }

    private void bVR() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ak akVar = new ak();
            akVar.aHs = Integer.parseInt(this.aKn);
            akVar.aHq = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void bb(long j) {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
            this.mHandler.postDelayed(this.bsA, 1000 * j);
        }
    }

    public void bVS() {
        if (this.mHandler != null && this.bsA != null) {
            this.mHandler.removeCallbacks(this.bsA);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.haQ);
        this.mHandler.postDelayed(this.haQ, 1000L);
    }

    public void bVT() {
        if (this.mHandler != null && this.haQ != null) {
            this.mHandler.removeCallbacks(this.haQ);
        }
    }

    public void bVU() {
        this.mHandler.removeCallbacks(this.haR);
        this.mHandler.postDelayed(this.haR, 1000L);
    }

    public void bVV() {
        if (this.mHandler != null && this.haR != null) {
            this.mHandler.removeCallbacks(this.haR);
        }
    }

    public void bjV() {
    }

    private View nn(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.g.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.hat != null) {
            this.hat.clearAnimation();
        }
        if (this.haF != null) {
            this.haF.onDestroy();
        }
        bVT();
        bVV();
        bVS();
    }

    public Animation bVW() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.haJ != null) {
            this.haJ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0194a.sdk_push_up_out);
        this.hat.setAnimation(loadAnimation);
        this.hat.setVisibility(8);
        return loadAnimation;
    }
}
