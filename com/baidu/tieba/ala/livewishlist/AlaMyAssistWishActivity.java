package com.baidu.tieba.ala.livewishlist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.h;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.e.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaMyAssistWishActivity extends BaseFragmentActivity {
    private String asd;
    private View ecB;
    private CommonEmptyView erG;
    private ImageView flK;
    private ListView flL;
    private c flM;
    private com.baidu.tieba.ala.livewishlist.a.a flN;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean aew = false;
    private boolean ahp = false;
    private boolean ahq = false;
    private CustomMessageListener aeM = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener eef = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private c.a flO = new c.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.e.c.a
        public void V(ArrayList<e> arrayList) {
            AlaMyAssistWishActivity.this.erG.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.flL != null) {
                    AlaMyAssistWishActivity.this.flL.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.flN != null) {
                    AlaMyAssistWishActivity.this.flN.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.e.c.a
        public void ay(int i, String str) {
            AlaMyAssistWishActivity.this.Oe();
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        parserIntent();
        this.flM = new c(getPageContext(), this.flO);
        this.flM.zg(this.asd);
        MessageManager.getInstance().registerListener(this.aeN);
        MessageManager.getInstance().registerListener(this.aeM);
        MessageManager.getInstance().registerListener(this.eef);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ahp = false;
        hG(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.asd = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ecB = findViewById(a.g.ala_wish_list_my_assist_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913150));
            }
        });
        this.flK = (ImageView) findViewById(a.g.ala_wish_list_my_assist_back);
        this.flK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.g.ala_wish_list_my_assist_content);
        this.flL = (ListView) findViewById(a.g.my_assist_list_view);
        this.erG = (CommonEmptyView) findViewById(a.g.my_assist_list_empty_view);
        this.flN = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.flL.setAdapter((ListAdapter) this.flN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oe() {
        age();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        age();
    }

    private void age() {
        if (this.flL != null) {
            this.flL.setVisibility(8);
        }
        this.erG.setVisibility(0);
        this.erG.reset();
        this.erG.setTitle(a.i.sdk_net_fail_tip_rank);
        this.erG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.erG.setVisibility(8);
                if (AlaMyAssistWishActivity.this.flM != null) {
                    AlaMyAssistWishActivity.this.flM.zg(AlaMyAssistWishActivity.this.asd);
                }
            }
        });
        this.erG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.erG.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hG(configuration.orientation == 2);
    }

    private void hG(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (z) {
            h.S(this.mRootView);
            r.d(getActivity(), false);
            this.mContentView.setBackgroundResource(a.f.ala_wish_list_bg);
            layoutParams.width = screenDimensions[1];
            layoutParams.height = screenDimensions[1];
            layoutParams.gravity = 53;
        } else {
            h.T(this.mRootView);
            r.d(getActivity(), true);
            this.mContentView.setBackgroundResource(a.f.ala_wish_list_bg);
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (int) (screenDimensions[1] * 0.68d);
            layoutParams.gravity = 80;
        }
        this.mContentView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aew) {
            this.mRootView.setVisibility(0);
            sc();
            this.aew = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        sd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.flM != null) {
            this.flM.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aeN);
        MessageManager.getInstance().unRegisterListener(this.aeM);
        MessageManager.getInstance().unRegisterListener(this.eef);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void sc() {
        this.ahp = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.ahp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void sd() {
        if (!this.ahq && !this.ahp) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_bottom);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaMyAssistWishActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaMyAssistWishActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ahq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
