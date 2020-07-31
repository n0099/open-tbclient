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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private String aBY;
    private String aYY;
    private long bag;
    private com.baidu.tieba.ala.guardthrone.b.a fSQ;
    private View fSX;
    private FrameLayout fSY;
    private View fSZ;
    private View fTa;
    private HeadImageView fTb;
    private TbImageView fTc;
    private TextView fTd;
    private TextView fTe;
    private ListView fTf;
    private ScrollView fTg;
    private HListView fTh;
    private RelativeLayout fTi;
    private TextView fTj;
    private TextView fTk;
    private com.baidu.tieba.ala.guardthrone.d.a fTl;
    private a.InterfaceC0567a fTm;
    private b fTn;
    private com.baidu.tieba.ala.guardthrone.adapter.a fTo;
    private Animation fTp;
    private boolean fTq;
    private long fTr;
    private long fTs;
    private long fTt;
    private long fTu;
    private boolean fTv;
    private ImageView fkk;
    private LinearLayout frF;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable baj = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fTl != null) {
                a.this.fTl.dH(a.this.mLiveId, a.this.aYY);
            }
        }
    };
    private final Runnable fTw = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fTr <= 0) {
                a.this.fTr = 0L;
                a.this.bBI();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.fTr <= 0 || a.this.fTe == null || a.this.fSQ == null || a.this.fSQ.fSA == null || TextUtils.isEmpty(a.this.fSQ.fSA.fSE)) {
                if (a.this.fTe != null && a.this.fTe.getVisibility() == 0) {
                    a.this.fTe.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.fSQ.fSA.fSE + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fTr));
            if (a.this.fTe.getVisibility() != 0) {
                a.this.fTe.setVisibility(0);
            }
            a.this.fTe.setText(str);
        }
    };
    private final Runnable fTx = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fTu <= 0) {
                a.this.fTu = 0L;
                a.this.bBK();
            } else {
                a.i(a.this);
                a.this.bBJ();
            }
            if (a.this.fTu >= 0 && a.this.fTe != null && a.this.fSQ != null && a.this.fSQ.fSA != null && !TextUtils.isEmpty(a.this.fSQ.fSA.fSE)) {
                a.this.fTe.setText(a.this.fSQ.fSA.fSE + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.fTu)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.fTr;
        aVar.fTr = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.fTu;
        aVar.fTu = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.fTq = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = kU(this.fTq);
        this.fSX = this.mRootView.findViewById(a.g.content_layout);
        this.fSY = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fSZ = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.fTa = this.mRootView.findViewById(a.g.view_foreground);
        this.fkk = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.fTb = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.fTc = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.fTd = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.fTe = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.frF = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.fTf = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.fTf.setDividerHeight(0);
        this.fTg = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.fTh = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.fTh.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.fTi = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.fTj = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.fTk = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bBA();
        bBB();
        bBC();
        bBD();
    }

    private void bBA() {
        this.fTb.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fTb.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.fTb.setIsRound(true);
        this.fTb.setAutoChangeStyle(false);
        this.fTb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fTc.setDefaultResource(a.f.portrait_no_guard_bg);
        this.fTc.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bBB() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.fTa.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.fTa.setLayoutParams(layoutParams);
        }
    }

    private void bBC() {
        if (this.fTq) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fSZ.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.fSZ.setLayoutParams(layoutParams);
            this.fTi.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bBD() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fTg.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.fTg.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.fSX.setOnClickListener(this);
        this.fSY.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fkk.setOnClickListener(this);
        this.fTk.setOnClickListener(this);
        this.fTi.setOnClickListener(this);
    }

    private void BE() {
        bBE();
        this.fTl = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.fTm);
        this.fTl.dH(this.mLiveId, this.aYY);
    }

    private void bBE() {
        this.fTm = new a.InterfaceC0567a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0567a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0567a
            public void onFail(int i, String str) {
                a.this.bag = 5L;
                a.this.ao(a.this.bag);
                if (a.this.mActivity != null && !a.this.fTv) {
                    a.this.fTv = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.aYY = str2;
        this.aBY = str3;
        this.mTabId = i;
        BE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.fSA == null || aVar.fSB == null || this.mActivity == null) {
            this.bag = 5L;
            ao(this.bag);
            return;
        }
        this.fSQ = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.fSA.fSD)) {
            this.fTc.startLoad(aVar.fSA.fSD, 10, false);
        }
        if (i == 1) {
            this.fTb.setVisibility(8);
        } else {
            String str = aVar.fSA.fSC;
            if (!TextUtils.isEmpty(str)) {
                this.fTb.setVisibility(0);
                this.fTb.startLoad(str, 12, false);
            } else {
                this.fTb.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.fSA.fSE)) {
                this.fTd.setVisibility(0);
                this.fTd.setText(aVar.fSA.fSE);
            } else {
                this.fTd.setVisibility(4);
            }
        } else {
            String str2 = aVar.fSA.username;
            if (!TextUtils.isEmpty(str2)) {
                this.fTd.setVisibility(0);
                this.fTd.setText(str2);
            } else {
                this.fTd.setVisibility(8);
            }
        }
        if (i == 1) {
            this.fTe.setVisibility(4);
        } else if (i == 2) {
            if (this.fTs != aVar.fSA.startTime || this.fTr > aVar.fSA.fSH) {
                this.fTs = aVar.fSA.startTime;
                if (aVar.fSA.fSH > 0) {
                    this.fTr = aVar.fSA.fSH;
                    if (!TextUtils.isEmpty(aVar.fSA.fSE)) {
                        this.fTe.setVisibility(0);
                        this.fTe.setText(aVar.fSA.fSE + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fTr)));
                        if (this.mHandler != null && this.fTx != null) {
                            this.mHandler.removeCallbacks(this.fTx);
                        }
                        startCountDown();
                    }
                } else {
                    this.fTe.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.fTt != aVar.fSA.startTime || this.fTu != aVar.fSA.fSI)) {
            this.fTt = aVar.fSA.startTime;
            if (aVar.fSA.fSI >= 0) {
                this.fTu = aVar.fSA.fSI;
                if (!TextUtils.isEmpty(aVar.fSA.fSE)) {
                    this.fTe.setVisibility(0);
                    this.fTe.setText(aVar.fSA.fSE + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.fTu)));
                    if (this.mHandler != null && this.fTw != null) {
                        this.mHandler.removeCallbacks(this.fTw);
                    }
                    bBJ();
                }
            } else {
                this.fTe.setVisibility(8);
            }
        }
        if (i == 2) {
            this.fTh.setVisibility(8);
        } else if (aVar.fSA.fSK != null && aVar.fSA.fSK.size() > 0) {
            if (this.fTo == null) {
                this.fTo = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.fTh.setAdapter((ListAdapter) this.fTo);
            }
            this.fTo.setList(aVar.fSA.fSK);
            int a = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.fTh);
            this.fTh.setDividerWidth(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fTh.getLayoutParams();
            layoutParams.leftMargin = a;
            layoutParams.rightMargin = a;
            this.fTh.setLayoutParams(layoutParams);
            this.fTh.setVisibility(0);
        } else {
            this.fTh.setVisibility(8);
        }
        if (i == 2 && aVar.fSB.fSM != null && aVar.fSB.fSM.size() > 0) {
            if (this.fTn == null) {
                this.fTn = new b(this.mActivity);
                this.fTf.setAdapter((ListAdapter) this.fTn);
            }
            this.fTn.setList(aVar.fSB.fSM);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.fTf);
            this.frF.setVisibility(0);
        } else {
            this.frF.setVisibility(8);
        }
        if (this.mIsHost) {
            this.fTi.setVisibility(8);
        } else {
            this.fTi.setVisibility(0);
            if (aVar.fSB.fSL != null && !TextUtils.isEmpty(aVar.fSB.fSL.text)) {
                if (aVar.fSB.fSL.rank > 0 && aVar.fSB.fSL.rank < 4) {
                    this.fTj.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.fTj.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.fTj.setText(aVar.fSB.fSL.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.fSA.fSG) && TextUtils.equals(aVar.fSA.fSG, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.fTk.setVisibility(8);
            } else {
                this.fTk.setVisibility(0);
            }
        }
        this.bag = aVar.fSA.fSJ;
        ao(this.bag);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fkk) {
            bBF();
        } else if (view == this.fTk || view == this.fTi) {
            bBG();
        }
    }

    private void bBF() {
        if (this.mActivity == null || this.fSQ == null || this.fSQ.fSA == null || TextUtils.isEmpty(this.fSQ.fSA.fSF)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.fSQ.fSA.fSF}, false, null, true);
        }
    }

    private void bBG() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            w wVar = new w();
            wVar.azp = Integer.parseInt(this.aBY);
            wVar.azn = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void ao(long j) {
        if (this.mHandler != null && this.baj != null) {
            this.mHandler.removeCallbacks(this.baj);
            this.mHandler.postDelayed(this.baj, 1000 * j);
        }
    }

    public void bBH() {
        if (this.mHandler != null && this.baj != null) {
            this.mHandler.removeCallbacks(this.baj);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fTw);
        this.mHandler.postDelayed(this.fTw, 1000L);
    }

    public void bBI() {
        if (this.mHandler != null && this.fTw != null) {
            this.mHandler.removeCallbacks(this.fTw);
        }
    }

    public void bBJ() {
        this.mHandler.removeCallbacks(this.fTx);
        this.mHandler.postDelayed(this.fTx, 1000L);
    }

    public void bBK() {
        if (this.mHandler != null && this.fTx != null) {
            this.mHandler.removeCallbacks(this.fTx);
        }
    }

    public void aSA() {
    }

    private View kU(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.fSZ != null) {
            this.fSZ.clearAnimation();
        }
        if (this.fTl != null) {
            this.fTl.onDestroy();
        }
        bBI();
        bBK();
        bBH();
    }

    public Animation bBL() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fTp != null) {
            this.fTp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0178a.sdk_push_up_out);
        this.fSZ.setAnimation(loadAnimation);
        this.fSZ.setVisibility(8);
        return loadAnimation;
    }
}
