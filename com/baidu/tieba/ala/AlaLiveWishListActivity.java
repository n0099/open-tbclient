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
    public static ArrayList<String> fvs = new ArrayList<>();
    private long bey;
    private h fuH;
    private View fup;
    private RelativeLayout fvj;
    private Button fvn;
    private f fvo;
    private RelativeLayout fvp;
    private i fvq;
    private TextView fvt;
    private int fvu;
    private CommonEmptyView fvv;
    private boolean fvw;
    private BdListView mListView;
    private View mRootView;
    private boolean aNF = false;
    private boolean aRa = false;
    private boolean aRb = false;
    ArrayList<m> fvr = new ArrayList<>();
    private i.a fvx = new i.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.i.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fvr.clear();
                AlaLiveWishListActivity.fvs.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    m mVar = new m(String.valueOf(dVar.fUy), dVar.fUw, dVar.mGiftName, String.valueOf(dVar.fUD), dVar.mDesc, String.valueOf(dVar.fUt), String.valueOf(dVar.fUu), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fvw = true;
                    }
                    mVar.ti(1);
                    AlaLiveWishListActivity.this.fvr.add(mVar);
                    AlaLiveWishListActivity.fvs.add(String.valueOf(dVar.fUu));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fvu) {
                    m mVar2 = new m();
                    mVar2.ti(0);
                    AlaLiveWishListActivity.this.fvr.add(mVar2);
                }
                AlaLiveWishListActivity.this.fvp.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fvr.clear();
                m mVar3 = new m();
                mVar3.ti(0);
                AlaLiveWishListActivity.this.fvr.add(mVar3);
                AlaLiveWishListActivity.this.fvp.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fvo = new f(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fvo.setData(AlaLiveWishListActivity.this.fvr);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fvo);
            AlaLiveWishListActivity.this.bDF();
            AlaLiveWishListActivity.this.fvn.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.i.a
        public void ax(int i, String str) {
            AlaLiveWishListActivity.this.bDG();
        }
    };
    private CustomMessageListener aNV = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aNW = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aNW);
            registerListener(this.aNV);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aRa = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bey = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fvq == null) {
                this.fvq = new i(getPageContext(), this.fvx);
            }
            this.fvq.bXZ();
            this.fuH = new h(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aNF) {
            this.mRootView.setVisibility(0);
            FD();
            this.aNF = true;
        }
    }

    private void FD() {
        Animation loadAnimation;
        this.aRa = true;
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
                AlaLiveWishListActivity.this.aRa = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aRb && !this.aRa) {
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
            this.aRb = true;
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
        this.fvj = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fvj.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fvj.setLayoutParams(layoutParams);
        this.fup = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fvv = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fvo = new f(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fvo);
        this.fvp = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fvt = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJL != null) {
            this.fvu = beVar.aJL.aLL;
        }
        if (this.fvu <= 0) {
            this.fvu = 3;
        }
        if (this.fvu == 1) {
            this.fvt.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fvu)));
        } else {
            this.fvt.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fvu)));
        }
        this.fvn = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bDF();
        this.fvn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fvo != null && AlaLiveWishListActivity.this.fvo.getCount() < 2 && AlaLiveWishListActivity.this.fvu != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fuH.em(AlaLiveWishListActivity.this.bey);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDF() {
        if (this.fvw) {
            this.fvn.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fvn.setEnabled(true);
            return;
        }
        this.fvn.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fvn.setEnabled(false);
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
        if (this.fvq != null) {
            this.fvq.onDestroy();
        }
        if (this.fuH != null) {
            this.fuH.onDestroy();
        }
        if (this.fuH != null) {
            this.fuH.bXY();
        }
        MessageManager.getInstance().unRegisterListener(this.aNW);
        MessageManager.getInstance().unRegisterListener(this.aNV);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void c(k kVar) {
        if (this.fvo == null || this.fvo.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void aw(int i, String str) {
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
                if (this.fvq != null) {
                    this.fvq.bXZ();
                }
            } else if (i == 1002 && this.fvq != null) {
                this.fvq.bXZ();
            }
        }
    }

    public void bDG() {
        if (this.fvv != null) {
            this.fvv.reset();
            this.fvv.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fvv.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fvv.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fvq == null) {
                        AlaLiveWishListActivity.this.fvq = new i(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fvx);
                    }
                    AlaLiveWishListActivity.this.fvq.bXZ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fvv.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fvv.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fvv.setVisibility(0);
            this.fvp.setVisibility(8);
            this.fvn.setVisibility(8);
        }
    }
}
