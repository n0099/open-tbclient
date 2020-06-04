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
    public static ArrayList<String> eUE = new ArrayList<>();
    private long aWv;
    private View eTL;
    private e eUA;
    private RelativeLayout eUB;
    private h eUC;
    private TextView eUF;
    private int eUG;
    private CommonEmptyView eUH;
    private boolean eUI;
    private g eUd;
    private RelativeLayout eUv;
    private Button eUz;
    private BdListView mListView;
    private View mRootView;
    private boolean aEB = false;
    private boolean aHL = false;
    private boolean aHM = false;
    ArrayList<l> eUD = new ArrayList<>();
    private h.a eUJ = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.eUD.clear();
                AlaLiveWishListActivity.eUE.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.fsx), cVar.fsv, cVar.mGiftName, String.valueOf(cVar.fsC), cVar.mDesc, String.valueOf(cVar.fss), String.valueOf(cVar.fst), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.eUI = true;
                    }
                    lVar.qh(1);
                    AlaLiveWishListActivity.this.eUD.add(lVar);
                    AlaLiveWishListActivity.eUE.add(String.valueOf(cVar.fst));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.eUG) {
                    l lVar2 = new l();
                    lVar2.qh(0);
                    AlaLiveWishListActivity.this.eUD.add(lVar2);
                }
                AlaLiveWishListActivity.this.eUB.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.eUD.clear();
                l lVar3 = new l();
                lVar3.qh(0);
                AlaLiveWishListActivity.this.eUD.add(lVar3);
                AlaLiveWishListActivity.this.eUB.setVisibility(0);
            }
            AlaLiveWishListActivity.this.eUA = new e(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.eUA.setData(AlaLiveWishListActivity.this.eUD);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.eUA);
            AlaLiveWishListActivity.this.bpc();
            AlaLiveWishListActivity.this.eUz.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void aw(int i, String str) {
            AlaLiveWishListActivity.this.bpd();
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
            if (this.eUC == null) {
                this.eUC = new h(getPageContext(), this.eUJ);
            }
            this.eUC.bHK();
            this.eUd = new g(getPageContext(), null, null, this);
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
        this.eUv = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eUv.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eUv.setLayoutParams(layoutParams);
        this.eTL = findViewById(a.g.ala_live_wish_list_root_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.eUH = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.eUA = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.eUA);
        this.eUB = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.eUF = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAT != null) {
            this.eUG = axVar.aAT.aCM;
        }
        if (this.eUG <= 0) {
            this.eUG = 3;
        }
        if (this.eUG == 1) {
            this.eUF.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.eUG)));
        } else {
            this.eUF.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.eUG)));
        }
        this.eUz = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bpc();
        this.eUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.eUA != null && AlaLiveWishListActivity.this.eUA.getCount() < 2 && AlaLiveWishListActivity.this.eUG != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.eUd.dL(AlaLiveWishListActivity.this.aWv);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpc() {
        if (this.eUI) {
            this.eUz.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.eUz.setEnabled(true);
            return;
        }
        this.eUz.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.eUz.setEnabled(false);
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
        if (this.eUC != null) {
            this.eUC.onDestroy();
        }
        if (this.eUd != null) {
            this.eUd.onDestroy();
        }
        if (this.eUd != null) {
            this.eUd.bHJ();
        }
        MessageManager.getInstance().unRegisterListener(this.aES);
        MessageManager.getInstance().unRegisterListener(this.aER);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
        if (this.eUA == null || this.eUA.getCount() >= 2) {
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
                if (this.eUC != null) {
                    this.eUC.bHK();
                }
            } else if (i == 1002 && this.eUC != null) {
                this.eUC.bHK();
            }
        }
    }

    public void bpd() {
        if (this.eUH != null) {
            this.eUH.reset();
            this.eUH.setTitle(a.i.sdk_net_fail_tip_rank);
            this.eUH.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.eUH.setVisibility(8);
                    if (AlaLiveWishListActivity.this.eUC == null) {
                        AlaLiveWishListActivity.this.eUC = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.eUJ);
                    }
                    AlaLiveWishListActivity.this.eUC.bHK();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.eUH.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.eUH.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.eUH.setVisibility(0);
            this.eUB.setVisibility(8);
            this.eUz.setVisibility(8);
        }
    }
}
