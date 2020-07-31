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
import com.baidu.live.data.bc;
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
/* loaded from: classes4.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements h.b {
    public static ArrayList<String> fjS = new ArrayList<>();
    private long aZc;
    private View fiP;
    private RelativeLayout fjJ;
    private Button fjN;
    private f fjO;
    private RelativeLayout fjP;
    private i fjQ;
    private TextView fjT;
    private int fjU;
    private CommonEmptyView fjV;
    private boolean fjW;
    private h fjh;
    private BdListView mListView;
    private View mRootView;
    private boolean aIs = false;
    private boolean aLL = false;
    private boolean aLM = false;
    ArrayList<m> fjR = new ArrayList<>();
    private i.a fjX = new i.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.i.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fjR.clear();
                AlaLiveWishListActivity.fjS.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    m mVar = new m(String.valueOf(dVar.fJd), dVar.fJb, dVar.mGiftName, String.valueOf(dVar.fJi), dVar.mDesc, String.valueOf(dVar.fIY), String.valueOf(dVar.fIZ), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fjW = true;
                    }
                    mVar.qW(1);
                    AlaLiveWishListActivity.this.fjR.add(mVar);
                    AlaLiveWishListActivity.fjS.add(String.valueOf(dVar.fIZ));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fjU) {
                    m mVar2 = new m();
                    mVar2.qW(0);
                    AlaLiveWishListActivity.this.fjR.add(mVar2);
                }
                AlaLiveWishListActivity.this.fjP.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fjR.clear();
                m mVar3 = new m();
                mVar3.qW(0);
                AlaLiveWishListActivity.this.fjR.add(mVar3);
                AlaLiveWishListActivity.this.fjP.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fjO = new f(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fjO.setData(AlaLiveWishListActivity.this.fjR);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fjO);
            AlaLiveWishListActivity.this.buJ();
            AlaLiveWishListActivity.this.fjN.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.i.a
        public void aA(int i, String str) {
            AlaLiveWishListActivity.this.buK();
        }
    };
    private CustomMessageListener aII = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aIJ);
            registerListener(this.aII);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aLL = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.aZc = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fjQ == null) {
                this.fjQ = new i(getPageContext(), this.fjX);
            }
            this.fjQ.bNY();
            this.fjh = new h(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aIs) {
            this.mRootView.setVisibility(0);
            Aa();
            this.aIs = true;
        }
    }

    private void Aa() {
        Animation loadAnimation;
        this.aLL = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aLL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ab() {
        Animation loadAnimation;
        if (!this.aLM && !this.aLL) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0178a.sdk_out_to_bottom);
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
            this.aLM = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ab();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fjJ = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fjJ.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fjJ.setLayoutParams(layoutParams);
        this.fiP = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fiP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fjV = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fjO = new f(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fjO);
        this.fjP = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fjT = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEz != null) {
            this.fjU = bcVar.aEz.aGz;
        }
        if (this.fjU <= 0) {
            this.fjU = 3;
        }
        if (this.fjU == 1) {
            this.fjT.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fjU)));
        } else {
            this.fjT.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fjU)));
        }
        this.fjN = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        buJ();
        this.fjN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fjO != null && AlaLiveWishListActivity.this.fjO.getCount() < 2 && AlaLiveWishListActivity.this.fjU != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fjh.eb(AlaLiveWishListActivity.this.aZc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buJ() {
        if (this.fjW) {
            this.fjN.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fjN.setEnabled(true);
            return;
        }
        this.fjN.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fjN.setEnabled(false);
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
        if (this.fjQ != null) {
            this.fjQ.onDestroy();
        }
        if (this.fjh != null) {
            this.fjh.onDestroy();
        }
        if (this.fjh != null) {
            this.fjh.bNX();
        }
        MessageManager.getInstance().unRegisterListener(this.aIJ);
        MessageManager.getInstance().unRegisterListener(this.aII);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void c(k kVar) {
        if (this.fjO == null || this.fjO.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void az(int i, String str) {
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
                if (this.fjQ != null) {
                    this.fjQ.bNY();
                }
            } else if (i == 1002 && this.fjQ != null) {
                this.fjQ.bNY();
            }
        }
    }

    public void buK() {
        if (this.fjV != null) {
            this.fjV.reset();
            this.fjV.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fjV.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fjV.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fjQ == null) {
                        AlaLiveWishListActivity.this.fjQ = new i(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fjX);
                    }
                    AlaLiveWishListActivity.this.fjQ.bNY();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fjV.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fjV.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fjV.setVisibility(0);
            this.fjP.setVisibility(8);
            this.fjN.setVisibility(8);
        }
    }
}
