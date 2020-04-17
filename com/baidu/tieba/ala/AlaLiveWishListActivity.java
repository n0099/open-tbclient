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
import com.baidu.live.data.as;
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
    public static ArrayList<String> eHO = new ArrayList<>();
    private long aQg;
    private View eGY;
    private RelativeLayout eHH;
    private Button eHJ;
    private e eHK;
    private RelativeLayout eHL;
    private h eHM;
    private TextView eHP;
    private int eHQ;
    private CommonEmptyView eHR;
    private boolean eHS;
    private g eHp;
    private BdListView mListView;
    private View mRootView;
    private boolean azd = false;
    private boolean aCh = false;
    private boolean aCi = false;
    ArrayList<l> eHN = new ArrayList<>();
    private h.a eHT = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.eHN.clear();
                AlaLiveWishListActivity.eHO.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.feC), cVar.feA, cVar.mGiftName, String.valueOf(cVar.feH), cVar.mDesc, String.valueOf(cVar.fex), String.valueOf(cVar.fey), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.eHS = true;
                    }
                    lVar.pE(1);
                    AlaLiveWishListActivity.this.eHN.add(lVar);
                    AlaLiveWishListActivity.eHO.add(String.valueOf(cVar.fey));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.eHQ) {
                    l lVar2 = new l();
                    lVar2.pE(0);
                    AlaLiveWishListActivity.this.eHN.add(lVar2);
                }
                AlaLiveWishListActivity.this.eHL.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.eHN.clear();
                l lVar3 = new l();
                lVar3.pE(0);
                AlaLiveWishListActivity.this.eHN.add(lVar3);
                AlaLiveWishListActivity.this.eHL.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.eHK != null) {
                AlaLiveWishListActivity.this.eHK.setData(AlaLiveWishListActivity.this.eHN);
            }
            AlaLiveWishListActivity.this.bjI();
            AlaLiveWishListActivity.this.eHJ.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void ar(int i, String str) {
            AlaLiveWishListActivity.this.bjJ();
        }
    };
    private CustomMessageListener azt = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.azu);
            registerListener(this.azt);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aCh = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.aQg = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.eHM == null) {
                this.eHM = new h(getPageContext(), this.eHT);
            }
            this.eHM.bBt();
            this.eHp = new g(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.azd) {
            this.mRootView.setVisibility(0);
            xM();
            this.azd = true;
        }
    }

    private void xM() {
        Animation loadAnimation;
        this.aCh = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0128a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0128a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aCh = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void xN() {
        Animation loadAnimation;
        if (!this.aCi && !this.aCh) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0128a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0128a.sdk_out_to_bottom);
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
            this.aCi = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        xN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eHH = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eHH.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eHH.setLayoutParams(layoutParams);
        this.eGY = findViewById(a.g.ala_live_wish_list_root_bg);
        this.eGY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.eHR = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.eHK = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.eHK);
        this.eHL = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.eHP = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar != null && asVar.avF != null) {
            this.eHQ = asVar.avF.axq;
        }
        if (this.eHQ <= 0) {
            this.eHQ = 3;
        }
        if (this.eHQ == 1) {
            this.eHP.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.eHQ)));
        } else {
            this.eHP.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.eHQ)));
        }
        this.eHJ = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bjI();
        this.eHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.eHK != null && AlaLiveWishListActivity.this.eHK.getCount() < 2 && AlaLiveWishListActivity.this.eHQ != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.eHp.dK(AlaLiveWishListActivity.this.aQg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjI() {
        if (this.eHS) {
            this.eHJ.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.eHJ.setEnabled(true);
            return;
        }
        this.eHJ.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.eHJ.setEnabled(false);
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
        if (this.eHM != null) {
            this.eHM.onDestroy();
        }
        if (this.eHp != null) {
            this.eHp.onDestroy();
        }
        if (this.eHp != null) {
            this.eHp.bBs();
        }
        MessageManager.getInstance().unRegisterListener(this.azu);
        MessageManager.getInstance().unRegisterListener(this.azt);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
        if (this.eHK == null || this.eHK.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void aq(int i, String str) {
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
                if (this.eHM != null) {
                    this.eHM.bBt();
                }
            } else if (i == 1002 && this.eHM != null) {
                this.eHM.bBt();
            }
        }
    }

    public void bjJ() {
        if (this.eHR != null) {
            this.eHR.reset();
            this.eHR.setTitle(a.i.sdk_net_fail_tip_rank);
            this.eHR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.eHR.setVisibility(8);
                    if (AlaLiveWishListActivity.this.eHM == null) {
                        AlaLiveWishListActivity.this.eHM = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.eHT);
                    }
                    AlaLiveWishListActivity.this.eHM.bBt();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.eHR.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.eHR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.eHR.setVisibility(0);
            this.eHL.setVisibility(8);
            this.eHJ.setVisibility(8);
        }
    }
}
