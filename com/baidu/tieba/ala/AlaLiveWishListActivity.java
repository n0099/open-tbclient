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
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.f.g;
import com.baidu.tieba.ala.f.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements g.b {
    public static ArrayList<String> feP = new ArrayList<>();
    private long aZe;
    private View fdW;
    private RelativeLayout feG;
    private Button feK;
    private e feL;
    private RelativeLayout feM;
    private h feN;
    private TextView feQ;
    private int feR;
    private CommonEmptyView feS;
    private boolean feT;
    private g feo;
    private BdListView mListView;
    private View mRootView;
    private boolean aGX = false;
    private boolean aKp = false;
    private boolean aKq = false;
    ArrayList<l> feO = new ArrayList<>();
    private h.a feU = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.feO.clear();
                AlaLiveWishListActivity.feP.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.fDI), cVar.fDG, cVar.mGiftName, String.valueOf(cVar.fDN), cVar.mDesc, String.valueOf(cVar.fDD), String.valueOf(cVar.fDE), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.feT = true;
                    }
                    lVar.qG(1);
                    AlaLiveWishListActivity.this.feO.add(lVar);
                    AlaLiveWishListActivity.feP.add(String.valueOf(cVar.fDE));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.feR) {
                    l lVar2 = new l();
                    lVar2.qG(0);
                    AlaLiveWishListActivity.this.feO.add(lVar2);
                }
                AlaLiveWishListActivity.this.feM.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.feO.clear();
                l lVar3 = new l();
                lVar3.qG(0);
                AlaLiveWishListActivity.this.feO.add(lVar3);
                AlaLiveWishListActivity.this.feM.setVisibility(0);
            }
            AlaLiveWishListActivity.this.feL = new e(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.feL.setData(AlaLiveWishListActivity.this.feO);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.feL);
            AlaLiveWishListActivity.this.brD();
            AlaLiveWishListActivity.this.feK.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void ay(int i, String str) {
            AlaLiveWishListActivity.this.brE();
        }
    };
    private CustomMessageListener aHn = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aHo);
            registerListener(this.aHn);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aKp = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.aZe = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.feN == null) {
                this.feN = new h(getPageContext(), this.feU);
            }
            this.feN.bKP();
            this.feo = new g(getPageContext(), null, null, this);
        }
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

    private void zy() {
        Animation loadAnimation;
        this.aKp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0176a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aKp = false;
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
            this.aKq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        zz();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.feG = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.feG.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.feG.setLayoutParams(layoutParams);
        this.fdW = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.feS = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.feL = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.feL);
        this.feM = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.feQ = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar != null && bbVar.aDe != null) {
            this.feR = bbVar.aDe.aFe;
        }
        if (this.feR <= 0) {
            this.feR = 3;
        }
        if (this.feR == 1) {
            this.feQ.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.feR)));
        } else {
            this.feQ.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.feR)));
        }
        this.feK = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        brD();
        this.feK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.feL != null && AlaLiveWishListActivity.this.feL.getCount() < 2 && AlaLiveWishListActivity.this.feR != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.feo.dO(AlaLiveWishListActivity.this.aZe);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brD() {
        if (this.feT) {
            this.feK.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.feK.setEnabled(true);
            return;
        }
        this.feK.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.feK.setEnabled(false);
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
        if (this.feN != null) {
            this.feN.onDestroy();
        }
        if (this.feo != null) {
            this.feo.onDestroy();
        }
        if (this.feo != null) {
            this.feo.bKO();
        }
        MessageManager.getInstance().unRegisterListener(this.aHo);
        MessageManager.getInstance().unRegisterListener(this.aHn);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
        if (this.feL == null || this.feL.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void ax(int i, String str) {
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
                if (this.feN != null) {
                    this.feN.bKP();
                }
            } else if (i == 1002 && this.feN != null) {
                this.feN.bKP();
            }
        }
    }

    public void brE() {
        if (this.feS != null) {
            this.feS.reset();
            this.feS.setTitle(a.i.sdk_net_fail_tip_rank);
            this.feS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.feS.setVisibility(8);
                    if (AlaLiveWishListActivity.this.feN == null) {
                        AlaLiveWishListActivity.this.feN = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.feU);
                    }
                    AlaLiveWishListActivity.this.feN.bKP();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.feS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.feS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.feS.setVisibility(0);
            this.feM.setVisibility(8);
            this.feK.setVisibility(8);
        }
    }
}
