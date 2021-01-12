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
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.g.e;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaMyAssistWishActivity extends BaseFragmentActivity {
    private String bre;
    private CommonEmptyView btf;
    private View glm;
    private ImageView hOg;
    private ListView hOh;
    private e hOi;
    private com.baidu.tieba.ala.livewishlist.a.a hOj;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    private CustomMessageListener aTE = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aww = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private e.a hOk = new e.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.g.e.a
        public void ab(ArrayList<f> arrayList) {
            AlaMyAssistWishActivity.this.btf.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.hOh != null) {
                    AlaMyAssistWishActivity.this.hOh.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.hOj != null) {
                    AlaMyAssistWishActivity.this.hOj.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.g.e.a
        public void bo(int i, String str) {
            AlaMyAssistWishActivity.this.arA();
        }
    };

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            parserIntent();
            this.hOi = new e(getPageContext(), this.hOk);
            this.hOi.HA(this.bre);
            MessageManager.getInstance().registerListener(this.aTF);
            MessageManager.getInstance().registerListener(this.aTE);
            MessageManager.getInstance().registerListener(this.aww);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXA = false;
            me(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.bre = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.glm = findViewById(a.f.ala_wish_list_my_assist_root_bg);
        this.glm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155));
            }
        });
        this.hOg = (ImageView) findViewById(a.f.ala_wish_list_my_assist_back);
        this.hOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.f.ala_wish_list_my_assist_content);
        this.hOh = (ListView) findViewById(a.f.my_assist_list_view);
        this.btf = (CommonEmptyView) findViewById(a.f.my_assist_list_empty_view);
        this.hOj = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.hOh.setAdapter((ListAdapter) this.hOj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arA() {
        bQU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        bQU();
    }

    private void bQU() {
        if (this.hOh != null) {
            this.hOh.setVisibility(8);
        }
        this.btf.setVisibility(0);
        this.btf.reset();
        this.btf.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.btf.setVisibility(8);
                if (AlaMyAssistWishActivity.this.hOi != null) {
                    AlaMyAssistWishActivity.this.hOi.HA(AlaMyAssistWishActivity.this.bre);
                }
            }
        });
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btf.setVisibility(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        me(configuration.orientation == 2);
    }

    private void me(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (z) {
            i.ae(this.mRootView);
            r.e(getActivity(), false);
            this.mContentView.setBackgroundResource(a.e.ala_wish_list_bg);
            layoutParams.width = screenDimensions[1];
            layoutParams.height = screenDimensions[1];
            layoutParams.gravity = 53;
        } else {
            i.af(this.mRootView);
            r.e(getActivity(), true);
            this.mContentView.setBackgroundResource(a.e.ala_wish_list_bg);
            layoutParams.width = screenDimensions[0];
            layoutParams.height = (int) (screenDimensions[1] * 0.68d);
            layoutParams.gravity = 80;
        }
        this.mContentView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        EM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hOi != null) {
            this.hOi.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aTF);
        MessageManager.getInstance().unRegisterListener(this.aTE);
        MessageManager.getInstance().unRegisterListener(this.aww);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void EL() {
        this.aXA = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void EM() {
        if (!this.aXB && !this.aXA) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
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
            this.aXB = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
