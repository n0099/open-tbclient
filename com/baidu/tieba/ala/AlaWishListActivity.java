package com.baidu.tieba.ala;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.data.ai;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.utils.i;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.g.j;
import com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class AlaWishListActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private String brl;
    private j ggL;
    private ImageView gih;
    private BdListView gii;
    private TextView gij;
    private ArrayList<AlaLiveWishListData> gil;
    private long gim;
    private com.baidu.tieba.ala.livewishlist.a.b gin;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private Timer mTimer;
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private boolean gik = true;
    private CustomMessageListener gio = new CustomMessageListener(2913155) { // from class: com.baidu.tieba.ala.AlaWishListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaWishListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener gip = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.AlaWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(wVar.aKw)) {
                    AlaWishListActivity.this.X(wVar.aKw);
                }
            }
        }
    };
    private j.a ggS = new j.a() { // from class: com.baidu.tieba.ala.AlaWishListActivity.8
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (AlaWishListActivity.this.gin == null || ListUtils.isEmpty(arrayList)) {
                if (AlaWishListActivity.this.gij != null) {
                    AlaWishListActivity.this.gij.setVisibility(8);
                }
            } else {
                AlaWishListActivity.this.gin.setData(arrayList);
                AlaWishListActivity.this.gim = j;
                AlaWishListActivity.this.gin.fH(AlaWishListActivity.this.gim);
            }
            if (!ListUtils.isEmpty(AlaWishListActivity.this.gil)) {
                AlaWishListActivity.this.Y(AlaWishListActivity.this.gil);
            }
            if (AlaWishListActivity.this.gij != null && !TextUtils.isEmpty(str)) {
                AlaWishListActivity.this.gij.setVisibility(0);
                AlaWishListActivity.this.gij.setText(str);
            }
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aN(int i, String str) {
            AlaWishListActivity.this.showToast(a.h.sdk_net_fail_tip);
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.2
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaWishListActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaWishListActivity.this.mScreenWidth) {
                AlaWishListActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaWishListActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaWishListActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaWishListActivity.this.mRootView != null) {
                                i.ae(AlaWishListActivity.this.mRootView);
                                q.e(AlaWishListActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
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
            this.ggL = new j(getPageContext(), this.ggS);
            this.ggL.IQ(this.brl);
            MessageManager.getInstance().registerListener(this.aWM);
            MessageManager.getInstance().registerListener(this.aWL);
            MessageManager.getInstance().registerListener(this.gip);
            MessageManager.getInstance().registerListener(this.gio);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            bPt();
        }
    }

    private void bPt() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.ala.AlaWishListActivity.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AlaWishListActivity.this.gim++;
                AlaWishListActivity.this.gin.fH(AlaWishListActivity.this.gim);
            }
        }, 1000L, 1000L);
    }

    private void parserIntent() {
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.brl = getIntent().getStringExtra("anchor_id");
        this.gik = getIntent().getBooleanExtra("is_guest_state", true);
        String stringExtra = getIntent().getStringExtra("ala_wish_list_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.gil = AlaLiveWishListData.toWishListData(stringExtra);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_wish_list_layout, (ViewGroup) null);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.e.ala_wish_list_bg);
        } else {
            this.mRootView.setBackgroundResource(a.e.ala_wish_list_bg);
        }
        setContentView(this.mRootView);
        this.gih = (ImageView) findViewById(a.f.wish_list_title_tv);
        this.gii = (BdListView) findViewById(a.f.wish_list_view);
        View findViewById = findViewById(a.f.ala_wish_list_my_assist_tv);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ViewHelper.checkUpIsLogin(AlaWishListActivity.this.getPageContext().getPageActivity())) {
                    Intent intent = new Intent(AlaWishListActivity.this, AlaMyAssistWishActivity.class);
                    intent.putExtra("anchor_id", AlaWishListActivity.this.brl);
                    AlaWishListActivity.this.startActivity(intent);
                }
            }
        });
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdLog.e("is rootview");
            }
        });
        this.gin = new com.baidu.tieba.ala.livewishlist.a.b(getPageContext().getPageActivity());
        this.gin.aj(this.gil);
        this.gin.oo(this.gik);
        this.gii.setAdapter((ListAdapter) this.gin);
        this.gii.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AlaWishListActivity.this.gin != null && !ListUtils.isEmpty(AlaWishListActivity.this.gin.getData()) && AlaWishListActivity.this.gin.getData().size() > i) {
                    com.baidu.tieba.ala.data.d dVar = AlaWishListActivity.this.gin.getData().get(i);
                    if (dVar.gIC < dVar.gID && dVar.Nn > AlaWishListActivity.this.gim) {
                        ai aiVar = new ai();
                        aiVar.aLB = dVar.gIz;
                        aiVar.aLA = Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID;
                        aiVar.aLC = 111;
                        AlaWishListActivity.this.a(aiVar);
                        AlaWishListActivity.this.closeActivity();
                    }
                }
            }
        });
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_wish_tips_list_item_view, (ViewGroup) null);
        this.gij = (TextView) inflate.findViewById(a.f.wish_tips_tv);
        this.gii.addFooterView(inflate);
        if (!this.gik) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        Y(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (this.gin != null && !ListUtils.isEmpty(arrayList)) {
            this.gin.aj(arrayList);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                i.ae(this.mRootView);
                q.e(getActivity(), false);
            } else {
                i.af(this.mRootView);
                q.e(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.e.ala_wish_list_bg);
            } else {
                this.mRootView.setBackgroundResource(a.e.ala_wish_list_bg);
            }
            Wi();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Wi();
    }

    private void Wi() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (screenDimensions[1] > screenDimensions[0]) {
                    attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                    attributes.gravity = 80;
                } else {
                    attributes.height = screenDimensions[1];
                    attributes.gravity = 48;
                }
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.68d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view == this.mRootView) {
                BdLog.e("is rootview");
                return true;
            }
            setResult(0);
            finish();
            return true;
        }
        return false;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ggL != null) {
            this.ggL.onDestroy();
        }
        if (this.gin != null) {
            this.gin.clO();
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        MessageManager.getInstance().unRegisterListener(this.aWM);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.gip);
        MessageManager.getInstance().unRegisterListener(this.gio);
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Jf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ai aiVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
    }

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaWishListActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Jf() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaWishListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaWishListActivity.this.getPageContext(), 0);
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
