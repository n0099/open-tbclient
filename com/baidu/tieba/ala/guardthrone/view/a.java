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
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.guardthrone.adapter.b;
import com.baidu.tieba.ala.guardthrone.d.a;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private String aAL;
    private String aZa;
    private long bai;
    private View fNE;
    private FrameLayout fNF;
    private View fNG;
    private View fNH;
    private HeadImageView fNI;
    private TbImageView fNJ;
    private TextView fNK;
    private TextView fNL;
    private ListView fNM;
    private ScrollView fNN;
    private HListView fNO;
    private RelativeLayout fNP;
    private TextView fNQ;
    private TextView fNR;
    private com.baidu.tieba.ala.guardthrone.d.a fNS;
    private a.InterfaceC0556a fNT;
    private b fNU;
    private com.baidu.tieba.ala.guardthrone.adapter.a fNV;
    private Animation fNW;
    private boolean fNX;
    private long fNY;
    private long fNZ;
    private com.baidu.tieba.ala.guardthrone.b.a fNx;
    private long fOa;
    private long fOb;
    private boolean fOc;
    private ImageView ffh;
    private LinearLayout fmv;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bal = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fNS != null) {
                a.this.fNS.dH(a.this.mLiveId, a.this.aZa);
            }
        }
    };
    private final Runnable fOd = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fNY <= 0) {
                a.this.fNY = 0L;
                a.this.byu();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.fNY <= 0 || a.this.fNL == null || a.this.fNx == null || a.this.fNx.fNh == null || TextUtils.isEmpty(a.this.fNx.fNh.fNl)) {
                if (a.this.fNL != null && a.this.fNL.getVisibility() == 0) {
                    a.this.fNL.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fNx.fNh.fNl + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fNY));
            if (a.this.fNL.getVisibility() != 0) {
                a.this.fNL.setVisibility(0);
            }
            a.this.fNL.setText(str);
        }
    };
    private final Runnable fOe = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fOb <= 0) {
                a.this.fOb = 0L;
                a.this.byw();
            } else {
                a.i(a.this);
                a.this.byv();
            }
            if (a.this.fOb >= 0 && a.this.fNL != null && a.this.fNx != null && a.this.fNx.fNh != null && !TextUtils.isEmpty(a.this.fNx.fNh.fNl)) {
                a.this.fNL.setText(a.this.fNx.fNh.fNl + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fOb)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.fNY;
        aVar.fNY = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.fOb;
        aVar.fOb = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.fNX = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = kq(this.fNX);
        this.fNE = this.mRootView.findViewById(a.g.content_layout);
        this.fNF = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fNG = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.fNH = this.mRootView.findViewById(a.g.view_foreground);
        this.ffh = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fNI = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.fNJ = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.fNK = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.fNL = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fmv = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.fNM = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.fNM.setDividerHeight(0);
        this.fNN = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.fNO = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.fNO.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.fNP = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.fNQ = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.fNR = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bym();
        byn();
        byo();
        byp();
    }

    private void bym() {
        this.fNI.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fNI.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fNI.setIsRound(true);
        this.fNI.setAutoChangeStyle(false);
        this.fNI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fNJ.setDefaultResource(a.f.portrait_no_guard_bg);
        this.fNJ.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void byn() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.fNH.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.fNH.setLayoutParams(layoutParams);
        }
    }

    private void byo() {
        if (this.fNX) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fNG.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.fNG.setLayoutParams(layoutParams);
            this.fNP.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void byp() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNN.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.fNN.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.fNE.setOnClickListener(this);
        this.fNF.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ffh.setOnClickListener(this);
        this.fNR.setOnClickListener(this);
        this.fNP.setOnClickListener(this);
    }

    private void Bc() {
        byq();
        this.fNS = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.fNT);
        this.fNS.dH(this.mLiveId, this.aZa);
    }

    private void byq() {
        this.fNT = new a.InterfaceC0556a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0556a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0556a
            public void onFail(int i, String str) {
                a.this.bai = 5L;
                a.this.ao(a.this.bai);
                if (a.this.mActivity != null && !a.this.fOc) {
                    a.this.fOc = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.aZa = str2;
        this.aAL = str3;
        this.mTabId = i;
        Bc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.fNh == null || aVar.fNi == null || this.mActivity == null) {
            this.bai = 5L;
            ao(this.bai);
            return;
        }
        this.fNx = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.fNh.fNk)) {
            this.fNJ.startLoad(aVar.fNh.fNk, 10, false);
        }
        if (i == 1) {
            this.fNI.setVisibility(8);
        } else {
            String str = aVar.fNh.fNj;
            if (!TextUtils.isEmpty(str)) {
                this.fNI.setVisibility(0);
                this.fNI.startLoad(str, 12, false);
            } else {
                this.fNI.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.fNh.fNl)) {
                this.fNK.setVisibility(0);
                this.fNK.setText(aVar.fNh.fNl);
            } else {
                this.fNK.setVisibility(4);
            }
        } else {
            String str2 = aVar.fNh.username;
            if (!TextUtils.isEmpty(str2)) {
                this.fNK.setVisibility(0);
                this.fNK.setText(str2);
            } else {
                this.fNK.setVisibility(8);
            }
        }
        if (i == 1) {
            this.fNL.setVisibility(4);
        } else if (i == 2) {
            if (this.fNZ != aVar.fNh.startTime || this.fNY > aVar.fNh.fNo) {
                this.fNZ = aVar.fNh.startTime;
                if (aVar.fNh.fNo > 0) {
                    this.fNY = aVar.fNh.fNo;
                    if (!TextUtils.isEmpty(aVar.fNh.fNl)) {
                        this.fNL.setVisibility(0);
                        this.fNL.setText(aVar.fNh.fNl + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fNY)));
                        if (this.mHandler != null && this.fOe != null) {
                            this.mHandler.removeCallbacks(this.fOe);
                        }
                        startCountDown();
                    }
                } else {
                    this.fNL.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.fOa != aVar.fNh.startTime || this.fOb != aVar.fNh.fNp)) {
            this.fOa = aVar.fNh.startTime;
            if (aVar.fNh.fNp >= 0) {
                this.fOb = aVar.fNh.fNp;
                if (!TextUtils.isEmpty(aVar.fNh.fNl)) {
                    this.fNL.setVisibility(0);
                    this.fNL.setText(aVar.fNh.fNl + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fOb)));
                    if (this.mHandler != null && this.fOd != null) {
                        this.mHandler.removeCallbacks(this.fOd);
                    }
                    byv();
                }
            } else {
                this.fNL.setVisibility(8);
            }
        }
        if (i == 2) {
            this.fNO.setVisibility(8);
        } else if (aVar.fNh.fNr != null && aVar.fNh.fNr.size() > 0) {
            if (this.fNV == null) {
                this.fNV = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.fNO.setAdapter((ListAdapter) this.fNV);
            }
            this.fNV.setList(aVar.fNh.fNr);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.fNO);
            this.fNO.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fNO.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.fNO.setLayoutParams(layoutParams);
            this.fNO.setVisibility(0);
        } else {
            this.fNO.setVisibility(8);
        }
        if (i == 2 && aVar.fNi.fNt != null && aVar.fNi.fNt.size() > 0) {
            if (this.fNU == null) {
                this.fNU = new b(this.mActivity);
                this.fNM.setAdapter((ListAdapter) this.fNU);
            }
            this.fNU.setList(aVar.fNi.fNt);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.fNM);
            this.fmv.setVisibility(0);
        } else {
            this.fmv.setVisibility(8);
        }
        if (this.mIsHost) {
            this.fNP.setVisibility(8);
        } else {
            this.fNP.setVisibility(0);
            if (aVar.fNi.fNs != null && !TextUtils.isEmpty(aVar.fNi.fNs.text)) {
                if (aVar.fNi.fNs.rank > 0 && aVar.fNi.fNs.rank < 4) {
                    this.fNQ.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.fNQ.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.fNQ.setText(aVar.fNi.fNs.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.fNh.fNn) && TextUtils.equals(aVar.fNh.fNn, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.fNR.setVisibility(8);
            } else {
                this.fNR.setVisibility(0);
            }
        }
        this.bai = aVar.fNh.fNq;
        ao(this.bai);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.ffh) {
            byr();
        } else if (view == this.fNR || view == this.fNP) {
            bys();
        }
    }

    private void byr() {
        if (this.mActivity == null || this.fNx == null || this.fNx.fNh == null || TextUtils.isEmpty(this.fNx.fNh.fNm)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.fNx.fNh.fNm}, false, null, true);
        }
    }

    private void bys() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            w wVar = new w();
            wVar.ayc = Integer.parseInt(this.aAL);
            wVar.aya = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ao(long j) {
        if (this.mHandler != null && this.bal != null) {
            this.mHandler.removeCallbacks(this.bal);
            this.mHandler.postDelayed(this.bal, 1000 * j);
        }
    }

    public void byt() {
        if (this.mHandler != null && this.bal != null) {
            this.mHandler.removeCallbacks(this.bal);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fOd);
        this.mHandler.postDelayed(this.fOd, 1000L);
    }

    public void byu() {
        if (this.mHandler != null && this.fOd != null) {
            this.mHandler.removeCallbacks(this.fOd);
        }
    }

    public void byv() {
        this.mHandler.removeCallbacks(this.fOe);
        this.mHandler.postDelayed(this.fOe, 1000L);
    }

    public void byw() {
        if (this.mHandler != null && this.fOe != null) {
            this.mHandler.removeCallbacks(this.fOe);
        }
    }

    public void aOF() {
    }

    private View kq(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.fNG != null) {
            this.fNG.clearAnimation();
        }
        if (this.fNS != null) {
            this.fNS.onDestroy();
        }
        byu();
        byw();
        byt();
    }

    public Animation byx() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fNW != null) {
            this.fNW.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0176a.sdk_push_up_out);
        this.fNG.setAnimation(loadAnimation);
        this.fNG.setVisibility(8);
        return loadAnimation;
    }
}
