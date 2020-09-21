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
import com.baidu.live.data.bj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.g.i;
import com.baidu.tieba.ala.g.j;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> fyD = new ArrayList<>();
    private long bhr;
    private View fxA;
    private i fxS;
    private RelativeLayout fyA;
    private j fyB;
    private TextView fyE;
    private int fyF;
    private CommonEmptyView fyG;
    private boolean fyH;
    private RelativeLayout fyu;
    private Button fyy;
    private g fyz;
    private BdListView mListView;
    private View mRootView;
    private boolean aPD = false;
    private boolean aTd = false;
    private boolean aTe = false;
    ArrayList<m> fyC = new ArrayList<>();
    private j.a fyI = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fyC.clear();
                AlaLiveWishListActivity.fyD.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    m mVar = new m(String.valueOf(dVar.fXN), dVar.fXL, dVar.mGiftName, String.valueOf(dVar.fXS), dVar.mDesc, String.valueOf(dVar.fXI), String.valueOf(dVar.fXJ), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fyH = true;
                    }
                    mVar.tB(1);
                    AlaLiveWishListActivity.this.fyC.add(mVar);
                    AlaLiveWishListActivity.fyD.add(String.valueOf(dVar.fXJ));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fyF) {
                    m mVar2 = new m();
                    mVar2.tB(0);
                    AlaLiveWishListActivity.this.fyC.add(mVar2);
                }
                AlaLiveWishListActivity.this.fyA.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fyC.clear();
                m mVar3 = new m();
                mVar3.tB(0);
                AlaLiveWishListActivity.this.fyC.add(mVar3);
                AlaLiveWishListActivity.this.fyA.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fyz = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fyz.setData(AlaLiveWishListActivity.this.fyC);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fyz);
            AlaLiveWishListActivity.this.bES();
            AlaLiveWishListActivity.this.fyy.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void ay(int i, String str) {
            AlaLiveWishListActivity.this.bET();
        }
    };
    private CustomMessageListener aPT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aPU);
            registerListener(this.aPT);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aTd = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bhr = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fyB == null) {
                this.fyB = new j(getPageContext(), this.fyI);
            }
            this.fyB.bZM();
            this.fxS = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aPD) {
            this.mRootView.setVisibility(0);
            Gd();
            this.aPD = true;
        }
    }

    private void Gd() {
        Animation loadAnimation;
        this.aTd = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aTd = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ge() {
        Animation loadAnimation;
        if (!this.aTe && !this.aTd) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_bottom);
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
            this.aTe = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ge();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fyu = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fyu.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fyu.setLayoutParams(layoutParams);
        this.fxA = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fyG = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fyz = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fyz);
        this.fyA = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fyE = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && bjVar.aLb != null) {
            this.fyF = bjVar.aLb.aNu;
        }
        if (this.fyF <= 0) {
            this.fyF = 3;
        }
        if (this.fyF == 1) {
            this.fyE.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fyF)));
        } else {
            this.fyE.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fyF)));
        }
        this.fyy = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bES();
        this.fyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fyz != null && AlaLiveWishListActivity.this.fyz.getCount() < 2 && AlaLiveWishListActivity.this.fyF != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fxS.eq(AlaLiveWishListActivity.this.bhr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        if (this.fyH) {
            this.fyy.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fyy.setEnabled(true);
            return;
        }
        this.fyy.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fyy.setEnabled(false);
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
        if (this.fyB != null) {
            this.fyB.onDestroy();
        }
        if (this.fxS != null) {
            this.fxS.onDestroy();
        }
        if (this.fxS != null) {
            this.fxS.bZL();
        }
        MessageManager.getInstance().unRegisterListener(this.aPU);
        MessageManager.getInstance().unRegisterListener(this.aPT);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(k kVar) {
        if (this.fyz == null || this.fyz.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void ax(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.live_wish_create_tip_fail);
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
                if (this.fyB != null) {
                    this.fyB.bZM();
                }
            } else if (i == 1002 && this.fyB != null) {
                this.fyB.bZM();
            }
        }
    }

    public void bET() {
        if (this.fyG != null) {
            this.fyG.reset();
            this.fyG.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fyG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fyG.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fyB == null) {
                        AlaLiveWishListActivity.this.fyB = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fyI);
                    }
                    AlaLiveWishListActivity.this.fyB.bZM();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fyG.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fyG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fyG.setVisibility(0);
            this.fyA.setVisibility(8);
            this.fyy.setVisibility(8);
        }
    }
}
