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
import com.baidu.live.data.ag;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private String aMj;
    private String bmv;
    private long bnK;
    private ImageView fTv;
    private View gEC;
    private FrameLayout gED;
    private View gEE;
    private View gEF;
    private HeadImageView gEG;
    private TbImageView gEH;
    private TextView gEI;
    private TextView gEJ;
    private ListView gEK;
    private ScrollView gEL;
    private HListView gEM;
    private RelativeLayout gEN;
    private TextView gEO;
    private TextView gEP;
    private com.baidu.tieba.ala.guardthrone.d.a gEQ;
    private a.InterfaceC0643a gER;
    private b gES;
    private com.baidu.tieba.ala.guardthrone.adapter.a gET;
    private Animation gEU;
    private boolean gEV;
    private long gEW;
    private long gEX;
    private long gEY;
    private long gEZ;
    private com.baidu.tieba.ala.guardthrone.b.a gEv;
    private boolean gFa;
    private LinearLayout gcB;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bnN = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gEQ != null) {
                a.this.gEQ.en(a.this.mLiveId, a.this.bmv);
            }
        }
    };
    private final Runnable gFb = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gEW <= 0) {
                a.this.gEW = 0L;
                a.this.bRC();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.gEW <= 0 || a.this.gEJ == null || a.this.gEv == null || a.this.gEv.gEh == null || TextUtils.isEmpty(a.this.gEv.gEh.gEl)) {
                if (a.this.gEJ != null && a.this.gEJ.getVisibility() == 0) {
                    a.this.gEJ.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gEv.gEh.gEl + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(a.this.gEW));
            if (a.this.gEJ.getVisibility() != 0) {
                a.this.gEJ.setVisibility(0);
            }
            a.this.gEJ.setText(str);
        }
    };
    private final Runnable gFc = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gEZ <= 0) {
                a.this.gEZ = 0L;
                a.this.bRE();
            } else {
                a.i(a.this);
                a.this.bRD();
            }
            if (a.this.gEZ >= 0 && a.this.gEJ != null && a.this.gEv != null && a.this.gEv.gEh != null && !TextUtils.isEmpty(a.this.gEv.gEh.gEl)) {
                a.this.gEJ.setText(a.this.gEv.gEh.gEl + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(a.this.gEZ)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.gEW;
        aVar.gEW = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.gEZ;
        aVar.gEZ = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.gEV = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = mm(this.gEV);
        this.gEC = this.mRootView.findViewById(a.g.content_layout);
        this.gED = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.gEE = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.gEF = this.mRootView.findViewById(a.g.view_foreground);
        this.fTv = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.gEG = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.gEH = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.gEI = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.gEJ = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.gcB = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.gEK = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.gEK.setDividerHeight(0);
        this.gEL = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.gEM = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.gEM.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.gEN = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.gEO = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.gEP = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bRu();
        bRv();
        bRw();
        bRx();
    }

    private void bRu() {
        this.gEG.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gEG.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gEG.setIsRound(true);
        this.gEG.setAutoChangeStyle(false);
        this.gEG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gEH.setDefaultResource(a.f.portrait_no_guard_bg);
        this.gEH.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bRv() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.gEF.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.gEF.setLayoutParams(layoutParams);
        }
    }

    private void bRw() {
        if (this.gEV) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gEE.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.gEE.setLayoutParams(layoutParams);
            this.gEN.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bRx() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEL.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.gEL.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.gEC.setOnClickListener(this);
        this.gED.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fTv.setOnClickListener(this);
        this.gEP.setOnClickListener(this);
        this.gEN.setOnClickListener(this);
    }

    private void IY() {
        bRy();
        this.gEQ = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.gER);
        this.gEQ.en(this.mLiveId, this.bmv);
    }

    private void bRy() {
        this.gER = new a.InterfaceC0643a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0643a
            public void onFail(int i, String str) {
                a.this.bnK = 5L;
                a.this.ar(a.this.bnK);
                if (a.this.mActivity != null && !a.this.gFa) {
                    a.this.gFa = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bmv = str2;
        this.aMj = str3;
        this.mTabId = i;
        IY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gEh == null || aVar.gEi == null || this.mActivity == null) {
            this.bnK = 5L;
            ar(this.bnK);
            return;
        }
        this.gEv = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gEh.gEk)) {
            this.gEH.startLoad(aVar.gEh.gEk, 10, false);
        }
        if (i == 1) {
            this.gEG.setVisibility(8);
        } else {
            String str = aVar.gEh.gEj;
            if (!TextUtils.isEmpty(str)) {
                this.gEG.setVisibility(0);
                this.gEG.startLoad(str, 12, false);
            } else {
                this.gEG.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gEh.gEl)) {
                this.gEI.setVisibility(0);
                this.gEI.setText(aVar.gEh.gEl);
            } else {
                this.gEI.setVisibility(4);
            }
        } else {
            String str2 = aVar.gEh.username;
            if (!TextUtils.isEmpty(str2)) {
                this.gEI.setVisibility(0);
                this.gEI.setText(str2);
            } else {
                this.gEI.setVisibility(8);
            }
        }
        if (i == 1) {
            this.gEJ.setVisibility(4);
        } else if (i == 2) {
            if (this.gEX != aVar.gEh.startTime || this.gEW > aVar.gEh.bCa) {
                this.gEX = aVar.gEh.startTime;
                if (aVar.gEh.bCa > 0) {
                    this.gEW = aVar.gEh.bCa;
                    if (!TextUtils.isEmpty(aVar.gEh.gEl)) {
                        this.gEJ.setVisibility(0);
                        this.gEJ.setText(aVar.gEh.gEl + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(this.gEW)));
                        if (this.mHandler != null && this.gFc != null) {
                            this.mHandler.removeCallbacks(this.gFc);
                        }
                        startCountDown();
                    }
                } else {
                    this.gEJ.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.gEY != aVar.gEh.startTime || this.gEZ != aVar.gEh.gEo)) {
            this.gEY = aVar.gEh.startTime;
            if (aVar.gEh.gEo >= 0) {
                this.gEZ = aVar.gEh.gEo;
                if (!TextUtils.isEmpty(aVar.gEh.gEl)) {
                    this.gEJ.setVisibility(0);
                    this.gEJ.setText(aVar.gEh.gEl + com.baidu.tieba.ala.guardthrone.e.a.e(Long.valueOf(this.gEZ)));
                    if (this.mHandler != null && this.gFb != null) {
                        this.mHandler.removeCallbacks(this.gFb);
                    }
                    bRD();
                }
            } else {
                this.gEJ.setVisibility(8);
            }
        }
        if (i == 2) {
            this.gEM.setVisibility(8);
        } else if (aVar.gEh.gEq != null && aVar.gEh.gEq.size() > 0) {
            if (this.gET == null) {
                this.gET = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.gEM.setAdapter((ListAdapter) this.gET);
            }
            this.gET.setList(aVar.gEh.gEq);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.gEM);
            this.gEM.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEM.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.gEM.setLayoutParams(layoutParams);
            this.gEM.setVisibility(0);
        } else {
            this.gEM.setVisibility(8);
        }
        if (i == 2 && aVar.gEi.aHk != null && aVar.gEi.aHk.size() > 0) {
            if (this.gES == null) {
                this.gES = new b(this.mActivity);
                this.gEK.setAdapter((ListAdapter) this.gES);
            }
            this.gES.setList(aVar.gEi.aHk);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.gEK);
            this.gcB.setVisibility(0);
        } else {
            this.gcB.setVisibility(8);
        }
        if (this.mIsHost) {
            this.gEN.setVisibility(8);
        } else {
            this.gEN.setVisibility(0);
            if (aVar.gEi.gEr != null && !TextUtils.isEmpty(aVar.gEi.gEr.text)) {
                if (aVar.gEi.gEr.rank > 0 && aVar.gEi.gEr.rank < 4) {
                    this.gEO.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.gEO.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.gEO.setText(aVar.gEi.gEr.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gEh.gEn) && TextUtils.equals(aVar.gEh.gEn, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.gEP.setVisibility(8);
            } else {
                this.gEP.setVisibility(0);
            }
        }
        this.bnK = aVar.gEh.gEp;
        ar(this.bnK);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fTv) {
            bRz();
        } else if (view == this.gEP || view == this.gEN) {
            bRA();
        }
    }

    private void bRz() {
        if (this.mActivity == null || this.gEv == null || this.gEv.gEh == null || TextUtils.isEmpty(this.gEv.gEh.gEm)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gEv.gEh.gEm}, false, null, true);
        }
    }

    private void bRA() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ag agVar = new ag();
            agVar.aJt = Integer.parseInt(this.aMj);
            agVar.aJr = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ar(long j) {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
            this.mHandler.postDelayed(this.bnN, 1000 * j);
        }
    }

    public void bRB() {
        if (this.mHandler != null && this.bnN != null) {
            this.mHandler.removeCallbacks(this.bnN);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gFb);
        this.mHandler.postDelayed(this.gFb, 1000L);
    }

    public void bRC() {
        if (this.mHandler != null && this.gFb != null) {
            this.mHandler.removeCallbacks(this.gFb);
        }
    }

    public void bRD() {
        this.mHandler.removeCallbacks(this.gFc);
        this.mHandler.postDelayed(this.gFc, 1000L);
    }

    public void bRE() {
        if (this.mHandler != null && this.gFc != null) {
            this.mHandler.removeCallbacks(this.gFc);
        }
    }

    public void bgm() {
    }

    private View mm(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.gEE != null) {
            this.gEE.clearAnimation();
        }
        if (this.gEQ != null) {
            this.gEQ.onDestroy();
        }
        bRC();
        bRE();
        bRB();
    }

    public Animation bRF() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gEU != null) {
            this.gEU.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0195a.sdk_push_up_out);
        this.gEE.setAnimation(loadAnimation);
        this.gEE.setVisibility(8);
        return loadAnimation;
    }
}
