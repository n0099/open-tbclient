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
    public static ArrayList<String> fKM = new ArrayList<>();
    private long blh;
    private View fJJ;
    private RelativeLayout fKD;
    private Button fKH;
    private g fKI;
    private RelativeLayout fKJ;
    private j fKK;
    private TextView fKN;
    private int fKO;
    private CommonEmptyView fKP;
    private boolean fKQ;
    private i fKb;
    private BdListView mListView;
    private View mRootView;
    private boolean aSO = false;
    private boolean aWo = false;
    private boolean aWp = false;
    ArrayList<m> fKL = new ArrayList<>();
    private j.a fKR = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fKL.clear();
                AlaLiveWishListActivity.fKM.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    m mVar = new m(String.valueOf(dVar.gkg), dVar.gke, dVar.mGiftName, String.valueOf(dVar.gkl), dVar.mDesc, String.valueOf(dVar.gkb), String.valueOf(dVar.gkc), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fKQ = true;
                    }
                    mVar.tZ(1);
                    AlaLiveWishListActivity.this.fKL.add(mVar);
                    AlaLiveWishListActivity.fKM.add(String.valueOf(dVar.gkc));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fKO) {
                    m mVar2 = new m();
                    mVar2.tZ(0);
                    AlaLiveWishListActivity.this.fKL.add(mVar2);
                }
                AlaLiveWishListActivity.this.fKJ.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fKL.clear();
                m mVar3 = new m();
                mVar3.tZ(0);
                AlaLiveWishListActivity.this.fKL.add(mVar3);
                AlaLiveWishListActivity.this.fKJ.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fKI = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fKI.setData(AlaLiveWishListActivity.this.fKL);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fKI);
            AlaLiveWishListActivity.this.bHE();
            AlaLiveWishListActivity.this.fKH.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aJ(int i, String str) {
            AlaLiveWishListActivity.this.bHF();
        }
    };
    private CustomMessageListener aTe = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aTf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aTf);
            registerListener(this.aTe);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aWo = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.blh = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fKK == null) {
                this.fKK = new j(getPageContext(), this.fKR);
            }
            this.fKK.cdk();
            this.fKb = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aSO) {
            this.mRootView.setVisibility(0);
            GZ();
            this.aSO = true;
        }
    }

    private void GZ() {
        Animation loadAnimation;
        this.aWo = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aWo = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ha() {
        Animation loadAnimation;
        if (!this.aWp && !this.aWo) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
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
            this.aWp = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ha();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fKD = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fKD.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fKD.setLayoutParams(layoutParams);
        this.fJJ = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fKP = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fKI = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fKI);
        this.fKJ = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fKN = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aOg != null) {
            this.fKO = bjVar.aOg.aQF;
        }
        if (this.fKO <= 0) {
            this.fKO = 3;
        }
        if (this.fKO == 1) {
            this.fKN.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fKO)));
        } else {
            this.fKN.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fKO)));
        }
        this.fKH = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bHE();
        this.fKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fKI != null && AlaLiveWishListActivity.this.fKI.getCount() < 2 && AlaLiveWishListActivity.this.fKO != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fKb.eH(AlaLiveWishListActivity.this.blh);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHE() {
        if (this.fKQ) {
            this.fKH.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fKH.setEnabled(true);
            return;
        }
        this.fKH.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fKH.setEnabled(false);
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
        if (this.fKK != null) {
            this.fKK.onDestroy();
        }
        if (this.fKb != null) {
            this.fKb.onDestroy();
        }
        if (this.fKb != null) {
            this.fKb.cdj();
        }
        MessageManager.getInstance().unRegisterListener(this.aTf);
        MessageManager.getInstance().unRegisterListener(this.aTe);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(k kVar) {
        if (this.fKI == null || this.fKI.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aI(int i, String str) {
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
                if (this.fKK != null) {
                    this.fKK.cdk();
                }
            } else if (i == 1002 && this.fKK != null) {
                this.fKK.cdk();
            }
        }
    }

    public void bHF() {
        if (this.fKP != null) {
            this.fKP.reset();
            this.fKP.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fKP.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fKP.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fKK == null) {
                        AlaLiveWishListActivity.this.fKK = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fKR);
                    }
                    AlaLiveWishListActivity.this.fKK.cdk();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fKP.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fKP.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fKP.setVisibility(0);
            this.fKJ.setVisibility(8);
            this.fKH.setVisibility(8);
        }
    }
}
