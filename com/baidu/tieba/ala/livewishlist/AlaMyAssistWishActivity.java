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
    private String brl;
    private CommonEmptyView btg;
    private View gfO;
    private ImageView hGM;
    private ListView hGN;
    private e hGO;
    private com.baidu.tieba.ala.livewishlist.a.a hGP;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private e.a hGQ = new e.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.g.e.a
        public void ag(ArrayList<f> arrayList) {
            AlaMyAssistWishActivity.this.btg.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.hGN != null) {
                    AlaMyAssistWishActivity.this.hGN.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.hGP != null) {
                    AlaMyAssistWishActivity.this.hGP.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.g.e.a
        public void bl(int i, String str) {
            AlaMyAssistWishActivity.this.aud();
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
            this.hGO = new e(getPageContext(), this.hGQ);
            this.hGO.IQ(this.brl);
            MessageManager.getInstance().registerListener(this.aWM);
            MessageManager.getInstance().registerListener(this.aWL);
            MessageManager.getInstance().registerListener(this.aAS);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            lL(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.brl = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gfO = findViewById(a.f.ala_wish_list_my_assist_root_bg);
        this.gfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155));
            }
        });
        this.hGM = (ImageView) findViewById(a.f.ala_wish_list_my_assist_back);
        this.hGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.f.ala_wish_list_my_assist_content);
        this.hGN = (ListView) findViewById(a.f.my_assist_list_view);
        this.btg = (CommonEmptyView) findViewById(a.f.my_assist_list_empty_view);
        this.hGP = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.hGN.setAdapter((ListAdapter) this.hGP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aud() {
        bSj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        bSj();
    }

    private void bSj() {
        if (this.hGN != null) {
            this.hGN.setVisibility(8);
        }
        this.btg.setVisibility(0);
        this.btg.reset();
        this.btg.setTitle(a.h.sdk_net_fail_tip_rank);
        this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.btg.setVisibility(8);
                if (AlaMyAssistWishActivity.this.hGO != null) {
                    AlaMyAssistWishActivity.this.hGO.IQ(AlaMyAssistWishActivity.this.brl);
                }
            }
        });
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.btg.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lL(configuration.orientation == 2);
    }

    private void lL(boolean z) {
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
        if (!this.aWv) {
            this.mRootView.setVisibility(0);
            Je();
            this.aWv = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Jf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hGO != null) {
            this.hGO.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aWM);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.aAS);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void Je() {
        this.baH = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Jf() {
        if (!this.baI && !this.baH) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_bottom);
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
