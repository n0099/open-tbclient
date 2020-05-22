package com.baidu.tieba.ala;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.ax;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.f.g;
import com.baidu.tieba.ala.f.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements g.b {
    public static ArrayList<String> eUt = new ArrayList<>();
    private long aWv;
    private View eTA;
    private g eTS;
    private RelativeLayout eUk;
    private Button eUo;
    private e eUp;
    private RelativeLayout eUq;
    private h eUr;
    private TextView eUu;
    private int eUv;
    private CommonEmptyView eUw;
    private boolean eUx;
    private BdListView mListView;
    private View mRootView;
    private boolean aEB = false;
    private boolean aHL = false;
    private boolean aHM = false;
    ArrayList<l> eUs = new ArrayList<>();
    private h.a eUy = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.eUs.clear();
                AlaLiveWishListActivity.eUt.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.fsm), cVar.fsk, cVar.mGiftName, String.valueOf(cVar.fsr), cVar.mDesc, String.valueOf(cVar.fsh), String.valueOf(cVar.fsi), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.eUx = true;
                    }
                    lVar.qf(1);
                    AlaLiveWishListActivity.this.eUs.add(lVar);
                    AlaLiveWishListActivity.eUt.add(String.valueOf(cVar.fsi));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.eUv) {
                    l lVar2 = new l();
                    lVar2.qf(0);
                    AlaLiveWishListActivity.this.eUs.add(lVar2);
                }
                AlaLiveWishListActivity.this.eUq.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.eUs.clear();
                l lVar3 = new l();
                lVar3.qf(0);
                AlaLiveWishListActivity.this.eUs.add(lVar3);
                AlaLiveWishListActivity.this.eUq.setVisibility(0);
            }
            AlaLiveWishListActivity.this.eUp = new e(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.eUp.setData(AlaLiveWishListActivity.this.eUs);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.eUp);
            AlaLiveWishListActivity.this.bpa();
            AlaLiveWishListActivity.this.eUo.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void aw(int i, String str) {
            AlaLiveWishListActivity.this.bpb();
        }
    };
    private CustomMessageListener aER = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aES);
            registerListener(this.aER);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aHL = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.aWv = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.eUr == null) {
                this.eUr = new h(getPageContext(), this.eUy);
            }
            this.eUr.bHI();
            this.eTS = new g(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aEB) {
            this.mRootView.setVisibility(0);
            yY();
            this.aEB = true;
        }
    }

    private void yY() {
        Animation loadAnimation;
        this.aHL = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aHL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void yZ() {
        Animation loadAnimation;
        if (!this.aHM && !this.aHL) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveWishListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaLiveWishListActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aHM = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        yZ();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eUk = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eUk.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eUk.setLayoutParams(layoutParams);
        this.eTA = findViewById(a.g.ala_live_wish_list_root_bg);
        this.eTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.eUw = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.eUp = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.eUp);
        this.eUq = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.eUu = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAT != null) {
            this.eUv = axVar.aAT.aCM;
        }
        if (this.eUv <= 0) {
            this.eUv = 3;
        }
        if (this.eUv == 1) {
            this.eUu.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.eUv)));
        } else {
            this.eUu.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.eUv)));
        }
        this.eUo = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bpa();
        this.eUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.eUp != null && AlaLiveWishListActivity.this.eUp.getCount() < 2 && AlaLiveWishListActivity.this.eUv != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.eTS.dL(AlaLiveWishListActivity.this.aWv);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpa() {
        if (this.eUx) {
            this.eUo.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.eUo.setEnabled(true);
            return;
        }
        this.eUo.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.eUo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eUr != null) {
            this.eUr.onDestroy();
        }
        if (this.eTS != null) {
            this.eTS.onDestroy();
        }
        if (this.eTS != null) {
            this.eTS.bHH();
        }
        MessageManager.getInstance().unRegisterListener(this.aES);
        MessageManager.getInstance().unRegisterListener(this.aER);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
        if (this.eUp == null || this.eUp.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void av(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.live_wish_create_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 1001) {
                if (this.eUr != null) {
                    this.eUr.bHI();
                }
            } else if (i == 1002 && this.eUr != null) {
                this.eUr.bHI();
            }
        }
    }

    public void bpb() {
        if (this.eUw != null) {
            this.eUw.reset();
            this.eUw.setTitle(a.i.sdk_net_fail_tip_rank);
            this.eUw.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.eUw.setVisibility(8);
                    if (AlaLiveWishListActivity.this.eUr == null) {
                        AlaLiveWishListActivity.this.eUr = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.eUy);
                    }
                    AlaLiveWishListActivity.this.eUr.bHI();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.eUw.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.eUw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.eUw.setVisibility(0);
            this.eUq.setVisibility(8);
            this.eUo.setVisibility(8);
        }
    }
}
