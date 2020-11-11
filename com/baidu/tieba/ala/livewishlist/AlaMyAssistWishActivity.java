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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.g.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaMyAssistWishActivity extends BaseFragmentActivity {
    private String bnP;
    private CommonEmptyView bpJ;
    private View fXU;
    private e hxA;
    private com.baidu.tieba.ala.livewishlist.a.a hxB;
    private ImageView hxy;
    private ListView hxz;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private CustomMessageListener aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private e.a hxC = new e.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.g.e.a
        public void af(ArrayList<f> arrayList) {
            AlaMyAssistWishActivity.this.bpJ.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.hxz != null) {
                    AlaMyAssistWishActivity.this.hxz.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.hxB != null) {
                    AlaMyAssistWishActivity.this.hxB.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.g.e.a
        public void bn(int i, String str) {
            AlaMyAssistWishActivity.this.arD();
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
        if (!isFinishing()) {
            parserIntent();
            this.hxA = new e(getPageContext(), this.hxC);
            this.hxA.IA(this.bnP);
            MessageManager.getInstance().registerListener(this.aVt);
            MessageManager.getInstance().registerListener(this.aVs);
            MessageManager.getInstance().registerListener(this.aAi);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            lp(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.bnP = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fXU = findViewById(a.f.ala_wish_list_my_assist_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155));
            }
        });
        this.hxy = (ImageView) findViewById(a.f.ala_wish_list_my_assist_back);
        this.hxy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.f.ala_wish_list_my_assist_content);
        this.hxz = (ListView) findViewById(a.f.my_assist_list_view);
        this.bpJ = (CommonEmptyView) findViewById(a.f.my_assist_list_empty_view);
        this.hxB = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.hxz.setAdapter((ListAdapter) this.hxB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arD() {
        bPe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        bPe();
    }

    private void bPe() {
        if (this.hxz != null) {
            this.hxz.setVisibility(8);
        }
        this.bpJ.setVisibility(0);
        this.bpJ.reset();
        this.bpJ.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.bpJ.setVisibility(8);
                if (AlaMyAssistWishActivity.this.hxA != null) {
                    AlaMyAssistWishActivity.this.hxA.IA(AlaMyAssistWishActivity.this.bnP);
                }
            }
        });
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bpJ.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lp(configuration.orientation == 2);
    }

    private void lp(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (z) {
            i.ae(this.mRootView);
            q.e(getActivity(), false);
            this.mContentView.setBackgroundResource(a.e.ala_wish_list_bg);
            layoutParams.width = screenDimensions[1];
            layoutParams.height = screenDimensions[1];
            layoutParams.gravity = 53;
        } else {
            i.af(this.mRootView);
            q.e(getActivity(), true);
            this.mContentView.setBackgroundResource(a.e.ala_wish_list_bg);
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
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hxA != null) {
            this.hxA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aVt);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        MessageManager.getInstance().unRegisterListener(this.aAi);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void HW() {
        this.aZb = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        if (!this.aZc && !this.aZb) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
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
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
