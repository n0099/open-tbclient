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
    public static ArrayList<String> fYA = new ArrayList<>();
    private long bmk;
    private View fXB;
    private i fXS;
    private TextView fYB;
    private int fYC;
    private CommonEmptyView fYD;
    private boolean fYE;
    private RelativeLayout fYr;
    private Button fYv;
    private g fYw;
    private RelativeLayout fYx;
    private j fYy;
    private BdListView mListView;
    private View mRootView;
    private boolean aTr = false;
    private boolean aXq = false;
    private boolean aXr = false;
    ArrayList<o> fYz = new ArrayList<>();
    private j.a fYF = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fYz.clear();
                AlaLiveWishListActivity.fYA.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gzF), dVar.gzD, dVar.mGiftName, String.valueOf(dVar.gzK), dVar.mDesc, String.valueOf(dVar.gzA), String.valueOf(dVar.gzB), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fYE = true;
                    }
                    oVar.uZ(1);
                    AlaLiveWishListActivity.this.fYz.add(oVar);
                    AlaLiveWishListActivity.fYA.add(String.valueOf(dVar.gzB));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fYC) {
                    o oVar2 = new o();
                    oVar2.uZ(0);
                    AlaLiveWishListActivity.this.fYz.add(oVar2);
                }
                AlaLiveWishListActivity.this.fYx.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fYz.clear();
                o oVar3 = new o();
                oVar3.uZ(0);
                AlaLiveWishListActivity.this.fYz.add(oVar3);
                AlaLiveWishListActivity.this.fYx.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fYw = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fYw.setData(AlaLiveWishListActivity.this.fYz);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fYw);
            AlaLiveWishListActivity.this.bLn();
            AlaLiveWishListActivity.this.fYv.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aN(int i, String str) {
            AlaLiveWishListActivity.this.bLo();
        }
    };
    private CustomMessageListener aTH = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aTI = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aTI);
            registerListener(this.aTH);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXq = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bmk = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fYy == null) {
                this.fYy = new j(getPageContext(), this.fYF);
            }
            this.fYy.cih();
            this.fXS = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTr) {
            this.mRootView.setVisibility(0);
            Hn();
            this.aTr = true;
        }
    }

    private void Hn() {
        Animation loadAnimation;
        this.aXq = true;
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
                AlaLiveWishListActivity.this.aXq = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ho() {
        Animation loadAnimation;
        if (!this.aXr && !this.aXq) {
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
            this.aXr = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ho();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fYr = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fYr.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fYr.setLayoutParams(layoutParams);
        this.fXB = findViewById(a.f.ala_live_wish_list_root_bg);
        this.fXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.fYD = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.fYw = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fYw);
        this.fYx = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.fYB = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNX != null) {
            this.fYC = bnVar.aNX.aQM;
        }
        if (this.fYC <= 0) {
            this.fYC = 3;
        }
        if (this.fYC == 1) {
            this.fYB.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.fYC)));
        } else {
            this.fYB.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.fYC)));
        }
        this.fYv = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bLn();
        this.fYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fYw != null && AlaLiveWishListActivity.this.fYw.getCount() < 2 && AlaLiveWishListActivity.this.fYC != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fXS.ff(AlaLiveWishListActivity.this.bmk);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLn() {
        if (this.fYE) {
            this.fYv.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.fYv.setEnabled(true);
            return;
        }
        this.fYv.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.fYv.setEnabled(false);
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
        if (this.fYy != null) {
            this.fYy.onDestroy();
        }
        if (this.fXS != null) {
            this.fXS.onDestroy();
        }
        if (this.fXS != null) {
            this.fXS.cig();
        }
        MessageManager.getInstance().unRegisterListener(this.aTI);
        MessageManager.getInstance().unRegisterListener(this.aTH);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.fYw == null || this.fYw.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aM(int i, String str) {
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
                if (this.fYy != null) {
                    this.fYy.cih();
                }
            } else if (i == 1002 && this.fYy != null) {
                this.fYy.cih();
            }
        }
    }

    public void bLo() {
        if (this.fYD != null) {
            this.fYD.reset();
            this.fYD.setTitle(a.h.sdk_net_fail_tip_rank);
            this.fYD.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fYD.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fYy == null) {
                        AlaLiveWishListActivity.this.fYy = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fYF);
                    }
                    AlaLiveWishListActivity.this.fYy.cih();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fYD.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fYD.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fYD.setVisibility(0);
            this.fYx.setVisibility(8);
            this.fYv.setVisibility(8);
        }
    }
}
