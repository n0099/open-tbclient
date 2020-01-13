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
import com.baidu.live.data.l;
import com.baidu.live.data.q;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.r;
import com.baidu.tieba.ala.e.h;
import com.baidu.tieba.ala.livewishlist.AlaMyAssistWishActivity;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class AlaWishListActivity extends BaseFragmentActivity implements View.OnTouchListener {
    private String asd;
    private h edp;
    private ImageView eeS;
    private BdListView eeT;
    private TextView eeU;
    private ArrayList<AlaLiveWishListData> eeW;
    private long eeX;
    private com.baidu.tieba.ala.livewishlist.a.b eeY;
    private String mLiveId;
    private View mRootView;
    private int mScreenWidth;
    private Timer mTimer;
    private boolean aew = false;
    private boolean ahp = false;
    private boolean ahq = false;
    private boolean eeV = true;
    private CustomMessageListener eeZ = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.AlaWishListActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aeM = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaWishListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaWishListActivity.this.closeActivity();
        }
    };
    private CustomMessageListener efa = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.AlaWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (!ListUtils.isEmpty(lVar.Wv)) {
                    AlaWishListActivity.this.O(lVar.Wv);
                }
            }
        }
    };
    private h.a edw = new h.a() { // from class: com.baidu.tieba.ala.AlaWishListActivity.8
        @Override // com.baidu.tieba.ala.e.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (AlaWishListActivity.this.eeY == null || ListUtils.isEmpty(arrayList)) {
                if (AlaWishListActivity.this.eeU != null) {
                    AlaWishListActivity.this.eeU.setVisibility(8);
                }
            } else {
                AlaWishListActivity.this.eeY.setData(arrayList);
                AlaWishListActivity.this.eeX = j;
                AlaWishListActivity.this.eeY.cZ(AlaWishListActivity.this.eeX);
            }
            if (!ListUtils.isEmpty(AlaWishListActivity.this.eeW)) {
                AlaWishListActivity.this.P(AlaWishListActivity.this.eeW);
            }
            if (AlaWishListActivity.this.eeU != null && !TextUtils.isEmpty(str)) {
                AlaWishListActivity.this.eeU.setVisibility(0);
                AlaWishListActivity.this.eeU.setText(str);
            }
        }

        @Override // com.baidu.tieba.ala.e.h.a
        public void ab(int i, String str) {
            AlaWishListActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener ahl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.2
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
                                com.baidu.live.utils.h.S(AlaWishListActivity.this.mRootView);
                                r.d(AlaWishListActivity.this.getActivity(), false);
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
        parserIntent();
        this.edp = new h(getPageContext(), this.edw);
        this.edp.zg(this.asd);
        MessageManager.getInstance().registerListener(this.aeN);
        MessageManager.getInstance().registerListener(this.aeM);
        MessageManager.getInstance().registerListener(this.efa);
        MessageManager.getInstance().registerListener(this.eeZ);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ahp = false;
        aZB();
    }

    private void aZB() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tieba.ala.AlaWishListActivity.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AlaWishListActivity.this.eeX++;
                AlaWishListActivity.this.eeY.cZ(AlaWishListActivity.this.eeX);
            }
        }, 1000L, 1000L);
    }

    private void parserIntent() {
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.asd = getIntent().getStringExtra("anchor_id");
        this.eeV = getIntent().getBooleanExtra("is_guest_state", true);
        String stringExtra = getIntent().getStringExtra("ala_wish_list_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.eeW = AlaLiveWishListData.toWishListData(stringExtra);
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
        this.eeS = (ImageView) findViewById(a.g.wish_list_title_tv);
        this.eeT = (BdListView) findViewById(a.g.wish_list_view);
        View findViewById = findViewById(a.g.ala_wish_list_my_assist_tv);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(AlaWishListActivity.this, AlaMyAssistWishActivity.class);
                intent.putExtra("anchor_id", AlaWishListActivity.this.asd);
                AlaWishListActivity.this.startActivity(intent);
            }
        });
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdLog.e("is rootview");
            }
        });
        this.eeY = new com.baidu.tieba.ala.livewishlist.a.b(getPageContext().getPageActivity());
        this.eeY.Y(this.eeW);
        this.eeY.jQ(this.eeV);
        this.eeT.setAdapter((ListAdapter) this.eeY);
        this.eeT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AlaWishListActivity.this.eeY != null && !ListUtils.isEmpty(AlaWishListActivity.this.eeY.getData()) && AlaWishListActivity.this.eeY.getData().size() > i) {
                    com.baidu.tieba.ala.data.c cVar = AlaWishListActivity.this.eeY.getData().get(i);
                    if (cVar.evm < cVar.evn && cVar.rs > AlaWishListActivity.this.eeX) {
                        q qVar = new q();
                        qVar.WI = cVar.evj;
                        qVar.WH = Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID;
                        qVar.WJ = 111;
                        AlaWishListActivity.this.a(qVar);
                        AlaWishListActivity.this.closeActivity();
                    }
                }
            }
        });
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_wish_tips_list_item_view, (ViewGroup) null);
        this.eeU = (TextView) inflate.findViewById(a.g.wish_tips_tv);
        this.eeT.addFooterView(inflate);
        if (!this.eeV) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(ArrayList<AlaLiveWishListData> arrayList) {
        P(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(ArrayList<AlaLiveWishListData> arrayList) {
        if (this.eeY != null && !ListUtils.isEmpty(arrayList)) {
            this.eeY.Y(arrayList);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mRootView != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                com.baidu.live.utils.h.S(this.mRootView);
                r.d(getActivity(), false);
            } else {
                com.baidu.live.utils.h.T(this.mRootView);
                r.d(getActivity(), true);
            }
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
            } else {
                this.mRootView.setBackgroundResource(a.f.ala_wish_list_bg);
            }
            aZd();
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aZd();
    }

    private void aZd() {
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
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ahl);
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
        if (!this.aew) {
            this.mRootView.setVisibility(0);
            sc();
            this.aew = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.edp != null) {
            this.edp.onDestroy();
        }
        if (this.eeY != null) {
            this.eeY.bpS();
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        MessageManager.getInstance().unRegisterListener(this.aeN);
        MessageManager.getInstance().unRegisterListener(this.aeM);
        MessageManager.getInstance().unRegisterListener(this.efa);
        MessageManager.getInstance().unRegisterListener(this.eeZ);
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        sd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, qVar));
    }

    private void sc() {
        Animation loadAnimation;
        this.ahp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaWishListActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaWishListActivity.this.ahp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void sd() {
        Animation loadAnimation;
        if (!this.ahq && !this.ahp) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_bottom);
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
            this.ahq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }
}
