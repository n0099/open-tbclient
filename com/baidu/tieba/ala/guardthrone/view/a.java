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
import com.baidu.live.data.ad;
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
    private String aLF;
    private String bla;
    private long bmj;
    private ImageView fLe;
    private LinearLayout fSy;
    private View guA;
    private View guB;
    private HeadImageView guC;
    private TbImageView guD;
    private TextView guE;
    private TextView guF;
    private ListView guG;
    private ScrollView guH;
    private HListView guI;
    private RelativeLayout guJ;
    private TextView guK;
    private TextView guL;
    private com.baidu.tieba.ala.guardthrone.d.a guM;
    private a.InterfaceC0627a guN;
    private b guO;
    private com.baidu.tieba.ala.guardthrone.adapter.a guP;
    private Animation guQ;
    private boolean guR;
    private long guS;
    private long guT;
    private long guU;
    private long guV;
    private boolean guW;
    private com.baidu.tieba.ala.guardthrone.b.a gur;
    private View guy;
    private FrameLayout guz;
    protected final Activity mActivity;
    private boolean mIsHost;
    private String mLiveId;
    private View mRootView;
    private int mTabId;
    private TbPageContext mTbPageContext;
    private Handler mHandler = new Handler();
    private final Runnable bmm = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.guM != null) {
                a.this.guM.eg(a.this.mLiveId, a.this.bla);
            }
        }
    };
    private final Runnable guX = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.guS <= 0) {
                a.this.guS = 0L;
                a.this.bOX();
            } else {
                a.e(a.this);
                a.this.startCountDown();
            }
            if (a.this.guS <= 0 || a.this.guF == null || a.this.gur == null || a.this.gur.gud == null || TextUtils.isEmpty(a.this.gur.gud.guh)) {
                if (a.this.guF != null && a.this.guF.getVisibility() == 0) {
                    a.this.guF.setVisibility(8);
                    return;
                }
                return;
            }
            String str = a.this.gur.gud.guh + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.guS));
            if (a.this.guF.getVisibility() != 0) {
                a.this.guF.setVisibility(0);
            }
            a.this.guF.setText(str);
        }
    };
    private final Runnable guY = new Runnable() { // from class: com.baidu.tieba.ala.guardthrone.view.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.guV <= 0) {
                a.this.guV = 0L;
                a.this.bOZ();
            } else {
                a.i(a.this);
                a.this.bOY();
            }
            if (a.this.guV >= 0 && a.this.guF != null && a.this.gur != null && a.this.gur.gud != null && !TextUtils.isEmpty(a.this.gur.gud.guh)) {
                a.this.guF.setText(a.this.gur.gud.guh + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(a.this.guV)));
            }
        }
    };

    static /* synthetic */ long e(a aVar) {
        long j = aVar.guS;
        aVar.guS = j - 1;
        return j;
    }

    static /* synthetic */ long i(a aVar) {
        long j = aVar.guV;
        aVar.guV = 1 + j;
        return j;
    }

    public a(TbPageContext tbPageContext, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.guR = z;
        this.mIsHost = z2;
        initView();
        initListener();
    }

    private void initView() {
        this.mRootView = lW(this.guR);
        this.guy = this.mRootView.findViewById(a.g.content_layout);
        this.guz = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.guA = this.mRootView.findViewById(a.g.guard_throne_layout);
        this.guB = this.mRootView.findViewById(a.g.view_foreground);
        this.fLe = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.guC = (HeadImageView) this.mRootView.findViewById(a.g.iv_portrait);
        this.guD = (TbImageView) this.mRootView.findViewById(a.g.iv_portrait_border);
        this.guE = (TextView) this.mRootView.findViewById(a.g.tv_guarder_name);
        this.guF = (TextView) this.mRootView.findViewById(a.g.tv_guard_throne_countdown);
        this.fSy = (LinearLayout) this.mRootView.findViewById(a.g.guard_throne_rank_view);
        this.guG = (ListView) this.mRootView.findViewById(a.g.rank_list_view);
        this.guG.setDividerHeight(0);
        this.guH = (ScrollView) this.mRootView.findViewById(a.g.guard_throne_scrollview);
        this.guI = (HListView) this.mRootView.findViewById(a.g.privilege_list_view);
        this.guI.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.guJ = (RelativeLayout) this.mRootView.findViewById(a.g.guard_throne_bottom_view);
        this.guK = (TextView) this.mRootView.findViewById(a.g.tv_bottom);
        this.guL = (TextView) this.mRootView.findViewById(a.g.btn_bottom_start);
        bOP();
        bOQ();
        bOR();
        bOS();
    }

    private void bOP() {
        this.guC.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.guC.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.guC.setIsRound(true);
        this.guC.setAutoChangeStyle(false);
        this.guC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guD.setDefaultResource(a.f.portrait_no_guard_bg);
        this.guD.setDefaultBgResource(a.d.sdk_transparent);
    }

    private void bOQ() {
        if (this.mActivity != null) {
            ViewGroup.LayoutParams layoutParams = this.guB.getLayoutParams();
            layoutParams.height = BdUtilHelper.getEquipmentWidth(this.mActivity) / 2;
            this.guB.setLayoutParams(layoutParams);
        }
    }

    private void bOR() {
        if (this.guR) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.guA.getLayoutParams();
            layoutParams.width = BdUtilHelper.getEquipmentWidth(this.mActivity);
            this.guA.setLayoutParams(layoutParams);
            this.guJ.setBackgroundResource(a.f.ala_guard_throne_land_bottom_bg);
        }
    }

    private void bOS() {
        if (this.mIsHost) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guH.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.guH.setLayoutParams(layoutParams);
        }
    }

    private void initListener() {
        this.guy.setOnClickListener(this);
        this.guz.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fLe.setOnClickListener(this);
        this.guL.setOnClickListener(this);
        this.guJ.setOnClickListener(this);
    }

    private void IF() {
        bOT();
        this.guM = new com.baidu.tieba.ala.guardthrone.d.a(this.mTbPageContext, this.guN);
        this.guM.eg(this.mLiveId, this.bla);
    }

    private void bOT() {
        this.guN = new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.guardthrone.view.a.4
            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0627a
            public void a(com.baidu.tieba.ala.guardthrone.b.a aVar) {
                a.this.b(aVar);
            }

            @Override // com.baidu.tieba.ala.guardthrone.d.a.InterfaceC0627a
            public void onFail(int i, String str) {
                a.this.bmj = 5L;
                a.this.aq(a.this.bmj);
                if (a.this.mActivity != null && !a.this.guW) {
                    a.this.guW = true;
                    BdUtilHelper.showToast(a.this.mActivity, str);
                }
            }
        };
    }

    public void d(String str, String str2, String str3, int i) {
        this.mLiveId = str;
        this.bla = str2;
        this.aLF = str3;
        this.mTabId = i;
        IF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.ala.guardthrone.b.a aVar) {
        if (aVar == null || aVar.gud == null || aVar.gue == null || this.mActivity == null) {
            this.bmj = 5L;
            aq(this.bmj);
            return;
        }
        this.gur = aVar;
        int i = aVar.status;
        if (!TextUtils.isEmpty(aVar.gud.gug)) {
            this.guD.startLoad(aVar.gud.gug, 10, false);
        }
        if (i == 1) {
            this.guC.setVisibility(8);
        } else {
            String str = aVar.gud.guf;
            if (!TextUtils.isEmpty(str)) {
                this.guC.setVisibility(0);
                this.guC.startLoad(str, 12, false);
            } else {
                this.guC.setVisibility(8);
            }
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(aVar.gud.guh)) {
                this.guE.setVisibility(0);
                this.guE.setText(aVar.gud.guh);
            } else {
                this.guE.setVisibility(4);
            }
        } else {
            String str2 = aVar.gud.username;
            if (!TextUtils.isEmpty(str2)) {
                this.guE.setVisibility(0);
                this.guE.setText(str2);
            } else {
                this.guE.setVisibility(8);
            }
        }
        if (i == 1) {
            this.guF.setVisibility(4);
        } else if (i == 2) {
            if (this.guT != aVar.gud.startTime || this.guS > aVar.gud.bze) {
                this.guT = aVar.gud.startTime;
                if (aVar.gud.bze > 0) {
                    this.guS = aVar.gud.bze;
                    if (!TextUtils.isEmpty(aVar.gud.guh)) {
                        this.guF.setVisibility(0);
                        this.guF.setText(aVar.gud.guh + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.guS)));
                        if (this.mHandler != null && this.guY != null) {
                            this.mHandler.removeCallbacks(this.guY);
                        }
                        startCountDown();
                    }
                } else {
                    this.guF.setVisibility(8);
                }
            }
        } else if (i == 3 && (this.guU != aVar.gud.startTime || this.guV != aVar.gud.guk)) {
            this.guU = aVar.gud.startTime;
            if (aVar.gud.guk >= 0) {
                this.guV = aVar.gud.guk;
                if (!TextUtils.isEmpty(aVar.gud.guh)) {
                    this.guF.setVisibility(0);
                    this.guF.setText(aVar.gud.guh + com.baidu.tieba.ala.guardthrone.e.a.d(Long.valueOf(this.guV)));
                    if (this.mHandler != null && this.guX != null) {
                        this.mHandler.removeCallbacks(this.guX);
                    }
                    bOY();
                }
            } else {
                this.guF.setVisibility(8);
            }
        }
        if (i == 2) {
            this.guI.setVisibility(8);
        } else if (aVar.gud.gum != null && aVar.gud.gum.size() > 0) {
            if (this.guP == null) {
                this.guP = new com.baidu.tieba.ala.guardthrone.adapter.a(this.mActivity);
                this.guI.setAdapter((ListAdapter) this.guP);
            }
            this.guP.setList(aVar.gud.gum);
            int a2 = com.baidu.tieba.ala.guardthrone.e.a.a(this.mActivity, this.guI);
            this.guI.setDividerWidth(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.guI.getLayoutParams();
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a2;
            this.guI.setLayoutParams(layoutParams);
            this.guI.setVisibility(0);
        } else {
            this.guI.setVisibility(8);
        }
        if (i == 2 && aVar.gue.aGZ != null && aVar.gue.aGZ.size() > 0) {
            if (this.guO == null) {
                this.guO = new b(this.mActivity);
                this.guG.setAdapter((ListAdapter) this.guO);
            }
            this.guO.setList(aVar.gue.aGZ);
            com.baidu.tieba.ala.guardthrone.e.a.c(this.guG);
            this.fSy.setVisibility(0);
        } else {
            this.fSy.setVisibility(8);
        }
        if (this.mIsHost) {
            this.guJ.setVisibility(8);
        } else {
            this.guJ.setVisibility(0);
            if (aVar.gue.gun != null && !TextUtils.isEmpty(aVar.gue.gun.text)) {
                if (aVar.gue.gun.rank > 0 && aVar.gue.gun.rank < 4) {
                    this.guK.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_FFB92D));
                } else {
                    this.guK.setTextColor(this.mActivity.getResources().getColor(a.d.ala_guard_throne_color_E5B372));
                }
                this.guK.setText(aVar.gue.gun.text);
            }
            if (TbadkCoreApplication.getCurrentAccountId() > 0 && !TextUtils.isEmpty(aVar.gud.guj) && TextUtils.equals(aVar.gud.guj, String.valueOf(TbadkCoreApplication.getCurrentAccountId()))) {
                this.guL.setVisibility(8);
            } else {
                this.guL.setVisibility(0);
            }
        }
        this.bmj = aVar.gud.gul;
        aq(this.bmj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            this.mActivity.finish();
        } else if (view == this.fLe) {
            bOU();
        } else if (view == this.guL || view == this.guJ) {
            bOV();
        }
    }

    private void bOU() {
        if (this.mActivity == null || this.gur == null || this.gur.gud == null || TextUtils.isEmpty(this.gur.gud.gui)) {
            BdUtilHelper.showToast(this.mActivity, a.i.sdk_url_is_null);
        } else {
            UrlManager.getInstance().dealOneLinkWithDialog(this.mTbPageContext, "", new String[]{this.gur.gud.gui}, false, null, true);
        }
    }

    private void bOV() {
        if (this.mActivity != null) {
            this.mActivity.finish();
        }
        try {
            ad adVar = new ad();
            adVar.aIR = Integer.parseInt(this.aLF);
            adVar.aIP = this.mTabId;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void aq(long j) {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
            this.mHandler.postDelayed(this.bmm, 1000 * j);
        }
    }

    public void bOW() {
        if (this.mHandler != null && this.bmm != null) {
            this.mHandler.removeCallbacks(this.bmm);
        }
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.guX);
        this.mHandler.postDelayed(this.guX, 1000L);
    }

    public void bOX() {
        if (this.mHandler != null && this.guX != null) {
            this.mHandler.removeCallbacks(this.guX);
        }
    }

    public void bOY() {
        this.mHandler.removeCallbacks(this.guY);
        this.mHandler.postDelayed(this.guY, 1000L);
    }

    public void bOZ() {
        if (this.mHandler != null && this.guY != null) {
            this.mHandler.removeCallbacks(this.guY);
        }
    }

    public void bet() {
    }

    private View lW(boolean z) {
        if (z) {
            return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.mActivity).inflate(a.h.ala_activity_guard_throne, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onDestroy() {
        if (this.guA != null) {
            this.guA.clearAnimation();
        }
        if (this.guM != null) {
            this.guM.onDestroy();
        }
        bOX();
        bOZ();
        bOW();
    }

    public Animation bPa() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.guQ != null) {
            this.guQ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivity, a.C0194a.sdk_push_up_out);
        this.guA.setAnimation(loadAnimation);
        this.guA.setVisibility(8);
        return loadAnimation;
    }
}
