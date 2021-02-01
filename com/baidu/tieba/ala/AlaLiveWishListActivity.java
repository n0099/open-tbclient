package com.baidu.tieba.ala;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bv;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.g.i;
import com.baidu.tieba.ala.g.j;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> gpn = new ArrayList<>();
    private long buN;
    private View gnS;
    private com.baidu.tieba.ala.g.i goF;
    private RelativeLayout gpe;
    private Button gpi;
    private i gpj;
    private RelativeLayout gpk;
    private j gpl;
    private TextView gpo;
    private int gpp;
    private CommonEmptyView gpq;
    private boolean gpr;
    private BdListView mListView;
    private View mRootView;
    private boolean aWt = false;
    private boolean baH = false;
    private boolean baI = false;
    ArrayList<o> gpm = new ArrayList<>();
    private j.a gps = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.gpm.clear();
                AlaLiveWishListActivity.gpn.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gSs), dVar.gSq, dVar.mGiftName, String.valueOf(dVar.gSx), dVar.mDesc, String.valueOf(dVar.gSn), String.valueOf(dVar.gSo), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.gpr = true;
                    }
                    oVar.ur(1);
                    AlaLiveWishListActivity.this.gpm.add(oVar);
                    AlaLiveWishListActivity.gpn.add(String.valueOf(dVar.gSo));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.gpp) {
                    o oVar2 = new o();
                    oVar2.ur(0);
                    AlaLiveWishListActivity.this.gpm.add(oVar2);
                }
                AlaLiveWishListActivity.this.gpk.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.gpm.clear();
                o oVar3 = new o();
                oVar3.ur(0);
                AlaLiveWishListActivity.this.gpm.add(oVar3);
                AlaLiveWishListActivity.this.gpk.setVisibility(0);
            }
            AlaLiveWishListActivity.this.gpj = new i(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.gpj.setData(AlaLiveWishListActivity.this.gpm);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.gpj);
            AlaLiveWishListActivity.this.bOh();
            AlaLiveWishListActivity.this.gpi.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aV(int i, String str) {
            AlaLiveWishListActivity.this.bOi();
        }
    };
    private CustomMessageListener aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aWK);
            registerListener(this.aWJ);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.buN = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.gpl == null) {
                this.gpl = new j(getPageContext(), this.gps);
            }
            this.gpl.cma();
            this.goF = new com.baidu.tieba.ala.g.i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWt) {
            this.mRootView.setVisibility(0);
            Gb();
            this.aWt = true;
        }
    }

    private void Gb() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gc() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveWishListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaLiveWishListActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gc();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gpe = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpe.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.gpe.setLayoutParams(layoutParams);
        this.gnS = findViewById(a.f.ala_live_wish_list_root_bg);
        this.gnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.gpq = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.gpj = new i(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gpj);
        this.gpk = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.gpo = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPX != null) {
            this.gpp = bvVar.aPX.aTc;
        }
        if (this.gpp <= 0) {
            this.gpp = 3;
        }
        if (this.gpp == 1) {
            this.gpo.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.gpp)));
        } else {
            this.gpo.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.gpp)));
        }
        this.gpi = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bOh();
        this.gpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.gpj != null && AlaLiveWishListActivity.this.gpj.getCount() < 2 && AlaLiveWishListActivity.this.gpp != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.goF.fO(AlaLiveWishListActivity.this.buN);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOh() {
        if (this.gpr) {
            this.gpi.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.gpi.setEnabled(true);
            return;
        }
        this.gpi.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.gpi.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gpl != null) {
            this.gpl.onDestroy();
        }
        if (this.goF != null) {
            this.goF.onDestroy();
        }
        if (this.goF != null) {
            this.goF.clZ();
        }
        MessageManager.getInstance().unRegisterListener(this.aWK);
        MessageManager.getInstance().unRegisterListener(this.aWJ);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.gpj == null || this.gpj.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aU(int i, String str) {
        String string = getPageContext().getResources().getString(a.h.live_wish_create_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 1001) {
                if (this.gpl != null) {
                    this.gpl.cma();
                }
            } else if (i == 1002 && this.gpl != null) {
                this.gpl.cma();
            }
        }
    }

    public void bOi() {
        if (this.gpq != null) {
            this.gpq.reset();
            this.gpq.setTitle(a.h.sdk_net_fail_tip_rank);
            this.gpq.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.gpq.setVisibility(8);
                    if (AlaLiveWishListActivity.this.gpl == null) {
                        AlaLiveWishListActivity.this.gpl = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.gps);
                    }
                    AlaLiveWishListActivity.this.gpl.cma();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.gpq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.gpq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.gpq.setVisibility(0);
            this.gpk.setVisibility(8);
            this.gpi.setVisibility(8);
        }
    }
}
