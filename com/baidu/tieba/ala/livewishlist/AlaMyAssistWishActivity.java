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
import com.baidu.live.utils.h;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.f.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaMyAssistWishActivity extends BaseFragmentActivity {
    private String aZa;
    private CommonEmptyView baR;
    private View fdW;
    private ImageView gvr;
    private ListView gvs;
    private c gvt;
    private com.baidu.tieba.ala.livewishlist.a.a gvu;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean aGX = false;
    private boolean aKp = false;
    private boolean aKq = false;
    private CustomMessageListener aHn = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener ffy = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private c.a gvv = new c.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.f.c.a
        public void X(ArrayList<e> arrayList) {
            AlaMyAssistWishActivity.this.baR.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.gvs != null) {
                    AlaMyAssistWishActivity.this.gvs.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.gvu != null) {
                    AlaMyAssistWishActivity.this.gvu.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.f.c.a
        public void aX(int i, String str) {
            AlaMyAssistWishActivity.this.acn();
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
            this.gvt = new c(getPageContext(), this.gvv);
            this.gvt.Dr(this.aZa);
            MessageManager.getInstance().registerListener(this.aHo);
            MessageManager.getInstance().registerListener(this.aHn);
            MessageManager.getInstance().registerListener(this.ffy);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aKp = false;
            jq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.aZa = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fdW = findViewById(a.g.ala_wish_list_my_assist_root_bg);
        this.fdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155));
            }
        });
        this.gvr = (ImageView) findViewById(a.g.ala_wish_list_my_assist_back);
        this.gvr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.g.ala_wish_list_my_assist_content);
        this.gvs = (ListView) findViewById(a.g.my_assist_list_view);
        this.baR = (CommonEmptyView) findViewById(a.g.my_assist_list_empty_view);
        this.gvu = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.gvs.setAdapter((ListAdapter) this.gvu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acn() {
        btR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        btR();
    }

    private void btR() {
        if (this.gvs != null) {
            this.gvs.setVisibility(8);
        }
        this.baR.setVisibility(0);
        this.baR.reset();
        this.baR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.baR.setVisibility(8);
                if (AlaMyAssistWishActivity.this.gvt != null) {
                    AlaMyAssistWishActivity.this.gvt.Dr(AlaMyAssistWishActivity.this.aZa);
                }
            }
        });
        this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.baR.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        jq(configuration.orientation == 2);
    }

    private void jq(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (z) {
            h.U(this.mRootView);
            q.e(getActivity(), false);
            this.mContentView.setBackgroundResource(a.f.ala_wish_list_bg);
            layoutParams.width = screenDimensions[1];
            layoutParams.height = screenDimensions[1];
            layoutParams.gravity = 53;
        } else {
            h.V(this.mRootView);
            q.e(getActivity(), true);
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
        if (!this.aGX) {
            this.mRootView.setVisibility(0);
            zy();
            this.aGX = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        zz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gvt != null) {
            this.gvt.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aHo);
        MessageManager.getInstance().unRegisterListener(this.aHn);
        MessageManager.getInstance().unRegisterListener(this.ffy);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void zy() {
        this.aKp = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.aKp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void zz() {
        if (!this.aKq && !this.aKp) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_out_to_bottom);
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
            this.aKq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
