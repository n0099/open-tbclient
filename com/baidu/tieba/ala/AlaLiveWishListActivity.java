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
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.f.h;
import com.baidu.tieba.ala.f.i;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements h.b {
    public static ArrayList<String> fvo = new ArrayList<>();
    private long bew;
    private h fuD;
    private View ful;
    private RelativeLayout fvf;
    private Button fvj;
    private f fvk;
    private RelativeLayout fvl;
    private i fvm;
    private TextView fvp;
    private int fvq;
    private CommonEmptyView fvr;
    private boolean fvs;
    private BdListView mListView;
    private View mRootView;
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    ArrayList<m> fvn = new ArrayList<>();
    private i.a fvt = new i.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.i.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fvn.clear();
                AlaLiveWishListActivity.fvo.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    m mVar = new m(String.valueOf(dVar.fUu), dVar.fUs, dVar.mGiftName, String.valueOf(dVar.fUz), dVar.mDesc, String.valueOf(dVar.fUp), String.valueOf(dVar.fUq), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fvs = true;
                    }
                    mVar.ti(1);
                    AlaLiveWishListActivity.this.fvn.add(mVar);
                    AlaLiveWishListActivity.fvo.add(String.valueOf(dVar.fUq));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fvq) {
                    m mVar2 = new m();
                    mVar2.ti(0);
                    AlaLiveWishListActivity.this.fvn.add(mVar2);
                }
                AlaLiveWishListActivity.this.fvl.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fvn.clear();
                m mVar3 = new m();
                mVar3.ti(0);
                AlaLiveWishListActivity.this.fvn.add(mVar3);
                AlaLiveWishListActivity.this.fvl.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fvk = new f(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fvk.setData(AlaLiveWishListActivity.this.fvn);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fvk);
            AlaLiveWishListActivity.this.bDE();
            AlaLiveWishListActivity.this.fvj.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.i.a
        public void ay(int i, String str) {
            AlaLiveWishListActivity.this.bDF();
        }
    };
    private CustomMessageListener aNT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aNU);
            registerListener(this.aNT);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aQY = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bew = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fvm == null) {
                this.fvm = new i(getPageContext(), this.fvt);
            }
            this.fvm.bXY();
            this.fuD = new h(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aND) {
            this.mRootView.setVisibility(0);
            FD();
            this.aND = true;
        }
    }

    private void FD() {
        Animation loadAnimation;
        this.aQY = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aQZ && !this.aQY) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
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
            this.aQZ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        FE();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fvf = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fvf.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fvf.setLayoutParams(layoutParams);
        this.ful = findViewById(a.g.ala_live_wish_list_root_bg);
        this.ful.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fvr = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fvk = new f(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fvk);
        this.fvl = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fvp = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJJ != null) {
            this.fvq = beVar.aJJ.aLJ;
        }
        if (this.fvq <= 0) {
            this.fvq = 3;
        }
        if (this.fvq == 1) {
            this.fvp.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fvq)));
        } else {
            this.fvp.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fvq)));
        }
        this.fvj = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bDE();
        this.fvj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fvk != null && AlaLiveWishListActivity.this.fvk.getCount() < 2 && AlaLiveWishListActivity.this.fvq != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fuD.em(AlaLiveWishListActivity.this.bew);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDE() {
        if (this.fvs) {
            this.fvj.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fvj.setEnabled(true);
            return;
        }
        this.fvj.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fvj.setEnabled(false);
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
        if (this.fvm != null) {
            this.fvm.onDestroy();
        }
        if (this.fuD != null) {
            this.fuD.onDestroy();
        }
        if (this.fuD != null) {
            this.fuD.bXX();
        }
        MessageManager.getInstance().unRegisterListener(this.aNU);
        MessageManager.getInstance().unRegisterListener(this.aNT);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void c(k kVar) {
        if (this.fvk == null || this.fvk.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.h.b
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
                if (this.fvm != null) {
                    this.fvm.bXY();
                }
            } else if (i == 1002 && this.fvm != null) {
                this.fvm.bXY();
            }
        }
    }

    public void bDF() {
        if (this.fvr != null) {
            this.fvr.reset();
            this.fvr.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fvr.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fvr.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fvm == null) {
                        AlaLiveWishListActivity.this.fvm = new i(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fvt);
                    }
                    AlaLiveWishListActivity.this.fvm.bXY();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fvr.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fvr.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fvr.setVisibility(0);
            this.fvl.setVisibility(8);
            this.fvj.setVisibility(8);
        }
    }
}
