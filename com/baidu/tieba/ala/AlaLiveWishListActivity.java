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
import com.baidu.live.data.bn;
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
/* loaded from: classes4.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> fYT = new ArrayList<>();
    private long bnV;
    private View fXU;
    private RelativeLayout fYK;
    private Button fYO;
    private g fYP;
    private RelativeLayout fYQ;
    private j fYR;
    private TextView fYU;
    private int fYV;
    private CommonEmptyView fYW;
    private boolean fYX;
    private i fYl;
    private BdListView mListView;
    private View mRootView;
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    ArrayList<o> fYS = new ArrayList<>();
    private j.a fYY = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fYS.clear();
                AlaLiveWishListActivity.fYT.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gzY), dVar.gzW, dVar.mGiftName, String.valueOf(dVar.gAd), dVar.mDesc, String.valueOf(dVar.gzT), String.valueOf(dVar.gzU), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fYX = true;
                    }
                    oVar.uB(1);
                    AlaLiveWishListActivity.this.fYS.add(oVar);
                    AlaLiveWishListActivity.fYT.add(String.valueOf(dVar.gzU));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fYV) {
                    o oVar2 = new o();
                    oVar2.uB(0);
                    AlaLiveWishListActivity.this.fYS.add(oVar2);
                }
                AlaLiveWishListActivity.this.fYQ.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fYS.clear();
                o oVar3 = new o();
                oVar3.uB(0);
                AlaLiveWishListActivity.this.fYS.add(oVar3);
                AlaLiveWishListActivity.this.fYQ.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fYP = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fYP.setData(AlaLiveWishListActivity.this.fYS);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fYP);
            AlaLiveWishListActivity.this.bLU();
            AlaLiveWishListActivity.this.fYO.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aP(int i, String str) {
            AlaLiveWishListActivity.this.bLV();
        }
    };
    private CustomMessageListener aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aVt);
            registerListener(this.aVs);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bnV = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fYR == null) {
                this.fYR = new j(getPageContext(), this.fYY);
            }
            this.fYR.ciO();
            this.fYl = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    private void HW() {
        Animation loadAnimation;
        this.aZb = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        Animation loadAnimation;
        if (!this.aZc && !this.aZb) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
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
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fYK = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fYK.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fYK.setLayoutParams(layoutParams);
        this.fXU = findViewById(a.f.ala_live_wish_list_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.fYW = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.fYP = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fYP);
        this.fYQ = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.fYU = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPI != null) {
            this.fYV = bnVar.aPI.aSx;
        }
        if (this.fYV <= 0) {
            this.fYV = 3;
        }
        if (this.fYV == 1) {
            this.fYU.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.fYV)));
        } else {
            this.fYU.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.fYV)));
        }
        this.fYO = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bLU();
        this.fYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fYP != null && AlaLiveWishListActivity.this.fYP.getCount() < 2 && AlaLiveWishListActivity.this.fYV != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fYl.ff(AlaLiveWishListActivity.this.bnV);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLU() {
        if (this.fYX) {
            this.fYO.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.fYO.setEnabled(true);
            return;
        }
        this.fYO.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.fYO.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fYR != null) {
            this.fYR.onDestroy();
        }
        if (this.fYl != null) {
            this.fYl.onDestroy();
        }
        if (this.fYl != null) {
            this.fYl.ciN();
        }
        MessageManager.getInstance().unRegisterListener(this.aVt);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.fYP == null || this.fYP.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aO(int i, String str) {
        String string = getPageContext().getResources().getString(a.h.live_wish_create_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 1001) {
                if (this.fYR != null) {
                    this.fYR.ciO();
                }
            } else if (i == 1002 && this.fYR != null) {
                this.fYR.ciO();
            }
        }
    }

    public void bLV() {
        if (this.fYW != null) {
            this.fYW.reset();
            this.fYW.setTitle(a.h.sdk_net_fail_tip_rank);
            this.fYW.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fYW.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fYR == null) {
                        AlaLiveWishListActivity.this.fYR = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fYY);
                    }
                    AlaLiveWishListActivity.this.fYR.ciO();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fYW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fYW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fYW.setVisibility(0);
            this.fYQ.setVisibility(8);
            this.fYO.setVisibility(8);
        }
    }
}
