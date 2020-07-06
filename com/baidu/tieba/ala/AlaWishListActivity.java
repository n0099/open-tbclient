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
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.f.h;
import com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class AlaWishListActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private String aZa;
    private h feN;
    private ImageView fgj;
    private BdListView fgk;
    private TextView fgl;
    private ArrayList<AlaLiveWishListData> fgn;
    private long fgo;
    private com.baidu.tieba.ala.livewishlist.a.b fgp;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private Timer mTimer;
    private boolean aGX = false;
    private boolean aKp = false;
    private boolean aKq = false;
    private boolean fgm = true;
    private CustomMessageListener fgq = new CustomMessageListener(2913155) { // from class: com.baidu.tieba.ala.AlaWishListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aHn = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaWishListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener fgr = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.AlaWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof q)) {
                q qVar = (q) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(qVar.axL)) {
                    AlaWishListActivity.this.Q(qVar.axL);
                }
            }
        }
    };
    private h.a feU = new h.a() { // from class: com.baidu.tieba.ala.AlaWishListActivity.8
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (AlaWishListActivity.this.fgp == null || ListUtils.isEmpty(arrayList)) {
                if (AlaWishListActivity.this.fgl != null) {
                    AlaWishListActivity.this.fgl.setVisibility(8);
                }
            } else {
                AlaWishListActivity.this.fgp.setData(arrayList);
                AlaWishListActivity.this.fgo = j;
                AlaWishListActivity.this.fgp.dN(AlaWishListActivity.this.fgo);
            }
            if (!ListUtils.isEmpty(AlaWishListActivity.this.fgn)) {
                AlaWishListActivity.this.R(AlaWishListActivity.this.fgn);
            }
            if (AlaWishListActivity.this.fgl != null && !TextUtils.isEmpty(str)) {
                AlaWishListActivity.this.fgl.setVisibility(0);
                AlaWishListActivity.this.fgl.setText(str);
            }
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void ay(int i, String str) {
            AlaWishListActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener aKl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.2
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
                                com.baidu.live.utils.h.U(AlaWishListActivity.this.mRootView);
                                com.baidu.live.utils.q.e(AlaWishListActivity.this.getActivity(), false);
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
            this.feN = new h(getPageContext(), this.feU);
            this.feN.Dr(this.aZa);
            MessageManager.getInstance().registerListener(this.aHo);
            MessageManager.getInstance().registerListener(this.aHn);
            MessageManager.getInstance().registerListener(this.fgr);
            MessageManager.getInstance().registerListener(this.fgq);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aKp = false;
            brV();
        }
    }

    private void brV() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.ala.AlaWishListActivity.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AlaWishListActivity.this.fgo++;
                AlaWishListActivity.this.fgp.dN(AlaWishListActivity.this.fgo);
            }
        }, 1000L, 1000L);
    }

    private void parserIntent() {
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aZa = getIntent().getStringExtra("anchor_id");
        this.fgm = getIntent().getBooleanExtra("is_guest_state", true);
        String stringExtra = getIntent().getStringExtra("ala_wish_list_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fgn = AlaLiveWishListData.toWishListData(stringExtra);
        }
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_wish_list_layout, (ViewGroup) null);
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
        } else {
            this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
        }
        setContentView(this.mRootView);
        this.fgj = (ImageView) findViewById(a.g.wish_list_title_tv);
        this.fgk = (BdListView) findViewById(a.g.wish_list_view);
        View findViewById = findViewById(a.g.ala_wish_list_my_assist_tv);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ViewHelper.checkUpIsLogin(AlaWishListActivity.this.getPageContext().getPageActivity())) {
                    Intent intent = new Intent(AlaWishListActivity.this, AlaMyAssistWishActivity.class);
                    intent.putExtra("anchor_id", AlaWishListActivity.this.aZa);
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
        this.fgp = new com.baidu.tieba.ala.livewishlist.a.b(getPageContext().getPageActivity());
        this.fgp.aa(this.fgn);
        this.fgp.lD(this.fgm);
        this.fgk.setAdapter((ListAdapter) this.fgp);
        this.fgk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AlaWishListActivity.this.fgp != null && !ListUtils.isEmpty(AlaWishListActivity.this.fgp.getData()) && AlaWishListActivity.this.fgp.getData().size() > i) {
                    com.baidu.tieba.ala.data.c cVar = AlaWishListActivity.this.fgp.getData().get(i);
                    if (cVar.fDH < cVar.fDI && cVar.Li > AlaWishListActivity.this.fgo) {
                        w wVar = new w();
                        wVar.ayc = cVar.fDE;
                        wVar.ayb = Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID;
                        wVar.ayd = 111;
                        AlaWishListActivity.this.a(wVar);
                        AlaWishListActivity.this.closeActivity();
                    }
                }
            }
        });
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_wish_tips_list_item_view, (ViewGroup) null);
        this.fgl = (TextView) inflate.findViewById(a.g.wish_tips_tv);
        this.fgk.addFooterView(inflate);
        if (!this.fgm) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(ArrayList<AlaLiveWishListData> arrayList) {
        R(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ArrayList<AlaLiveWishListData> arrayList) {
        if (this.fgp != null && !ListUtils.isEmpty(arrayList)) {
            this.fgp.aa(arrayList);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                com.baidu.live.utils.h.U(this.mRootView);
                com.baidu.live.utils.q.e(getActivity(), false);
            } else {
                com.baidu.live.utils.h.V(this.mRootView);
                com.baidu.live.utils.q.e(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
            }
            brt();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        brt();
    }

    private void brt() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aKl);
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
        if (!this.aGX) {
            this.mRootView.setVisibility(0);
            zy();
            this.aGX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.feN != null) {
            this.feN.onDestroy();
        }
        if (this.fgp != null) {
            this.fgp.bKG();
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        MessageManager.getInstance().unRegisterListener(this.aHo);
        MessageManager.getInstance().unRegisterListener(this.aHn);
        MessageManager.getInstance().unRegisterListener(this.fgr);
        MessageManager.getInstance().unRegisterListener(this.fgq);
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        zz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    private void zy() {
        Animation loadAnimation;
        this.aKp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaWishListActivity.this.aKp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void zz() {
        Animation loadAnimation;
        if (!this.aKq && !this.aKp) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_out_to_bottom);
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
            this.aKq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
