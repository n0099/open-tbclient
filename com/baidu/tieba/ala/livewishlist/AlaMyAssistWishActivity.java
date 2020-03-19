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
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.e.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaMyAssistWishActivity extends BaseFragmentActivity {
    private String awz;
    private View ehi;
    private CommonEmptyView ewA;
    private ImageView fpa;
    private ListView fpb;
    private c fpc;
    private com.baidu.tieba.ala.livewishlist.a.a fpd;
    private FrameLayout mContentView;
    private View mRootView;
    private boolean agN = false;
    private boolean ajI = false;
    private boolean ajJ = false;
    private CustomMessageListener ahd = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener eiM = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMyAssistWishActivity.this.finish();
        }
    };
    private c.a fpe = new c.a() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.4
        @Override // com.baidu.tieba.ala.e.c.a
        public void W(ArrayList<e> arrayList) {
            AlaMyAssistWishActivity.this.ewA.setVisibility(8);
            if (!ListUtils.isEmpty(arrayList)) {
                if (AlaMyAssistWishActivity.this.fpb != null) {
                    AlaMyAssistWishActivity.this.fpb.setVisibility(0);
                }
                if (AlaMyAssistWishActivity.this.fpd != null) {
                    AlaMyAssistWishActivity.this.fpd.setData(arrayList);
                    return;
                }
                return;
            }
            AlaMyAssistWishActivity.this.showNoDataView();
        }

        @Override // com.baidu.tieba.ala.e.c.a
        public void az(int i, String str) {
            AlaMyAssistWishActivity.this.Qx();
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
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        parserIntent();
        this.fpc = new c(getPageContext(), this.fpe);
        this.fpc.zA(this.awz);
        MessageManager.getInstance().registerListener(this.ahe);
        MessageManager.getInstance().registerListener(this.ahd);
        MessageManager.getInstance().registerListener(this.eiM);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajI = false;
        hO(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.awz = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_my_assis_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ehi = findViewById(a.g.ala_wish_list_my_assist_root_bg);
        this.ehi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155));
            }
        });
        this.fpa = (ImageView) findViewById(a.g.ala_wish_list_my_assist_back);
        this.fpa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.closeActivity();
            }
        });
        this.mContentView = (FrameLayout) findViewById(a.g.ala_wish_list_my_assist_content);
        this.fpb = (ListView) findViewById(a.g.my_assist_list_view);
        this.ewA = (CommonEmptyView) findViewById(a.g.my_assist_list_empty_view);
        this.fpd = new com.baidu.tieba.ala.livewishlist.a.a(getPageContext().getPageActivity());
        this.fpb.setAdapter((ListAdapter) this.fpd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qx() {
        aix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        aix();
    }

    private void aix() {
        if (this.fpb != null) {
            this.fpb.setVisibility(8);
        }
        this.ewA.setVisibility(0);
        this.ewA.reset();
        this.ewA.setTitle(a.i.sdk_net_fail_tip_rank);
        this.ewA.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMyAssistWishActivity.this.ewA.setVisibility(8);
                if (AlaMyAssistWishActivity.this.fpc != null) {
                    AlaMyAssistWishActivity.this.fpc.zA(AlaMyAssistWishActivity.this.awz);
                }
            }
        });
        this.ewA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.ewA.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hO(configuration.orientation == 2);
    }

    private void hO(boolean z) {
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
        if (!this.agN) {
            this.mRootView.setVisibility(0);
            tt();
            this.agN = true;
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fpc != null) {
            this.fpc.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ahe);
        MessageManager.getInstance().unRegisterListener(this.ahd);
        MessageManager.getInstance().unRegisterListener(this.eiM);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    private void tt() {
        this.ajI = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaMyAssistWishActivity.this.ajI = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tu() {
        if (!this.ajJ && !this.ajI) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_bottom);
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
            this.ajJ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
