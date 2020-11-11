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
import com.baidu.live.data.ah;
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
    private String bnP;
    private j fYR;
    private ImageView gam;
    private BdListView gan;
    private TextView gao;
    private ArrayList<AlaLiveWishListData> gar;
    private long gas;
    private com.baidu.tieba.ala.livewishlist.a.b gat;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private Timer mTimer;
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private boolean gaq = true;
    private CustomMessageListener gau = new CustomMessageListener(2913155) { // from class: com.baidu.tieba.ala.AlaWishListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaWishListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener gav = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.AlaWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(wVar.aJw)) {
                    AlaWishListActivity.this.X(wVar.aJw);
                }
            }
        }
    };
    private j.a fYY = new j.a() { // from class: com.baidu.tieba.ala.AlaWishListActivity.8
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (AlaWishListActivity.this.gat == null || ListUtils.isEmpty(arrayList)) {
                if (AlaWishListActivity.this.gao != null) {
                    AlaWishListActivity.this.gao.setVisibility(8);
                }
            } else {
                AlaWishListActivity.this.gat.setData(arrayList);
                AlaWishListActivity.this.gas = j;
                AlaWishListActivity.this.gat.fd(AlaWishListActivity.this.gas);
            }
            if (!ListUtils.isEmpty(AlaWishListActivity.this.gar)) {
                AlaWishListActivity.this.Y(AlaWishListActivity.this.gar);
            }
            if (AlaWishListActivity.this.gao != null && !TextUtils.isEmpty(str)) {
                AlaWishListActivity.this.gao.setVisibility(0);
                AlaWishListActivity.this.gao.setText(str);
            }
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aP(int i, String str) {
            AlaWishListActivity.this.showToast(a.h.sdk_net_fail_tip);
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aYX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.2
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
            this.fYR = new j(getPageContext(), this.fYY);
            this.fYR.IA(this.bnP);
            MessageManager.getInstance().registerListener(this.aVt);
            MessageManager.getInstance().registerListener(this.aVs);
            MessageManager.getInstance().registerListener(this.gav);
            MessageManager.getInstance().registerListener(this.gau);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            bMq();
        }
    }

    private void bMq() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.ala.AlaWishListActivity.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AlaWishListActivity.this.gas++;
                AlaWishListActivity.this.gat.fd(AlaWishListActivity.this.gas);
            }
        }, 1000L, 1000L);
    }

    private void parserIntent() {
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bnP = getIntent().getStringExtra("anchor_id");
        this.gaq = getIntent().getBooleanExtra("is_guest_state", true);
        String stringExtra = getIntent().getStringExtra("ala_wish_list_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.gar = AlaLiveWishListData.toWishListData(stringExtra);
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
        this.gam = (ImageView) findViewById(a.f.wish_list_title_tv);
        this.gan = (BdListView) findViewById(a.f.wish_list_view);
        View findViewById = findViewById(a.f.ala_wish_list_my_assist_tv);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ViewHelper.checkUpIsLogin(AlaWishListActivity.this.getPageContext().getPageActivity())) {
                    Intent intent = new Intent(AlaWishListActivity.this, AlaMyAssistWishActivity.class);
                    intent.putExtra("anchor_id", AlaWishListActivity.this.bnP);
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
        this.gat = new com.baidu.tieba.ala.livewishlist.a.b(getPageContext().getPageActivity());
        this.gat.ai(this.gar);
        this.gat.nS(this.gaq);
        this.gan.setAdapter((ListAdapter) this.gat);
        this.gan.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AlaWishListActivity.this.gat != null && !ListUtils.isEmpty(AlaWishListActivity.this.gat.getData()) && AlaWishListActivity.this.gat.getData().size() > i) {
                    com.baidu.tieba.ala.data.d dVar = AlaWishListActivity.this.gat.getData().get(i);
                    if (dVar.gzX < dVar.gzY && dVar.Ms > AlaWishListActivity.this.gas) {
                        ah ahVar = new ah();
                        ahVar.aKt = dVar.gzU;
                        ahVar.aKs = Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID;
                        ahVar.aKu = 111;
                        AlaWishListActivity.this.a(ahVar);
                        AlaWishListActivity.this.closeActivity();
                    }
                }
            }
        });
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_wish_tips_list_item_view, (ViewGroup) null);
        this.gao = (TextView) inflate.findViewById(a.f.wish_tips_tv);
        this.gan.addFooterView(inflate);
        if (!this.gaq) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(ArrayList<AlaLiveWishListData> arrayList) {
        Y(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        if (this.gat != null && !ListUtils.isEmpty(arrayList)) {
            this.gat.ai(arrayList);
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
            Ur();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ur();
    }

    private void Ur() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aYX);
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
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fYR != null) {
            this.fYR.onDestroy();
        }
        if (this.gat != null) {
            this.gat.ciz();
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        MessageManager.getInstance().unRegisterListener(this.aVt);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        MessageManager.getInstance().unRegisterListener(this.gav);
        MessageManager.getInstance().unRegisterListener(this.gau);
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ah ahVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    private void HW() {
        Animation loadAnimation;
        this.aZb = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaWishListActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        Animation loadAnimation;
        if (!this.aZc && !this.aZb) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
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
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
