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
    public static ArrayList<String> eHT = new ArrayList<>();
    private long aQm;
    private RelativeLayout eHM;
    private Button eHO;
    private e eHP;
    private RelativeLayout eHQ;
    private h eHR;
    private TextView eHU;
    private int eHV;
    private CommonEmptyView eHW;
    private boolean eHX;
    private View eHd;
    private g eHu;
    private BdListView mListView;
    private View mRootView;
    private boolean azj = false;
    private boolean aCn = false;
    private boolean aCo = false;
    ArrayList<l> eHS = new ArrayList<>();
    private h.a eHY = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.f.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.eHS.clear();
                AlaLiveWishListActivity.eHT.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.feH), cVar.feF, cVar.mGiftName, String.valueOf(cVar.feM), cVar.mDesc, String.valueOf(cVar.feC), String.valueOf(cVar.feD), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.eHX = true;
                    }
                    lVar.pE(1);
                    AlaLiveWishListActivity.this.eHS.add(lVar);
                    AlaLiveWishListActivity.eHT.add(String.valueOf(cVar.feD));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.eHV) {
                    l lVar2 = new l();
                    lVar2.pE(0);
                    AlaLiveWishListActivity.this.eHS.add(lVar2);
                }
                AlaLiveWishListActivity.this.eHQ.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.eHS.clear();
                l lVar3 = new l();
                lVar3.pE(0);
                AlaLiveWishListActivity.this.eHS.add(lVar3);
                AlaLiveWishListActivity.this.eHQ.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.eHP != null) {
                AlaLiveWishListActivity.this.eHP.setData(AlaLiveWishListActivity.this.eHS);
            }
            AlaLiveWishListActivity.this.bjG();
            AlaLiveWishListActivity.this.eHO.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.f.h.a
        public void ar(int i, String str) {
            AlaLiveWishListActivity.this.bjH();
        }
    };
    private CustomMessageListener azz = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.azA);
            registerListener(this.azz);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aCn = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.aQm = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.eHR == null) {
                this.eHR = new h(getPageContext(), this.eHY);
            }
            this.eHR.bBr();
            this.eHu = new g(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.azj) {
            this.mRootView.setVisibility(0);
            xL();
            this.azj = true;
        }
    }

    private void xL() {
        Animation loadAnimation;
        this.aCn = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aCn = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void xM() {
        Animation loadAnimation;
        if (!this.aCo && !this.aCn) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_out_to_bottom);
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
            this.aCo = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        xM();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eHM = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eHM.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eHM.setLayoutParams(layoutParams);
        this.eHd = findViewById(a.g.ala_live_wish_list_root_bg);
        this.eHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.eHW = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.eHP = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.eHP);
        this.eHQ = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.eHU = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar != null && asVar.avL != null) {
            this.eHV = asVar.avL.axw;
        }
        if (this.eHV <= 0) {
            this.eHV = 3;
        }
        if (this.eHV == 1) {
            this.eHU.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.eHV)));
        } else {
            this.eHU.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.eHV)));
        }
        this.eHO = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bjG();
        this.eHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.eHP != null && AlaLiveWishListActivity.this.eHP.getCount() < 2 && AlaLiveWishListActivity.this.eHV != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.eHu.dK(AlaLiveWishListActivity.this.aQm);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjG() {
        if (this.eHX) {
            this.eHO.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.eHO.setEnabled(true);
            return;
        }
        this.eHO.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.eHO.setEnabled(false);
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
        if (this.eHR != null) {
            this.eHR.onDestroy();
        }
        if (this.eHu != null) {
            this.eHu.onDestroy();
        }
        if (this.eHu != null) {
            this.eHu.bBq();
        }
        MessageManager.getInstance().unRegisterListener(this.azA);
        MessageManager.getInstance().unRegisterListener(this.azz);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
        if (this.eHP == null || this.eHP.getCount() >= 2) {
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
                if (this.eHR != null) {
                    this.eHR.bBr();
                }
            } else if (i == 1002 && this.eHR != null) {
                this.eHR.bBr();
            }
        }
    }

    public void bjH() {
        if (this.eHW != null) {
            this.eHW.reset();
            this.eHW.setTitle(a.i.sdk_net_fail_tip_rank);
            this.eHW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.eHW.setVisibility(8);
                    if (AlaLiveWishListActivity.this.eHR == null) {
                        AlaLiveWishListActivity.this.eHR = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.eHY);
                    }
                    AlaLiveWishListActivity.this.eHR.bBr();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.eHW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.eHW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.eHW.setVisibility(0);
            this.eHQ.setVisibility(8);
            this.eHO.setVisibility(8);
        }
    }
}
