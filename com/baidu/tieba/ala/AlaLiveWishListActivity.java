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
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.o;
import com.baidu.tieba.ala.g.i;
import com.baidu.tieba.ala.g.j;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> gmE = new ArrayList<>();
    private long brk;
    private i glW;
    private View glm;
    private h gmA;
    private RelativeLayout gmB;
    private j gmC;
    private TextView gmF;
    private int gmG;
    private CommonEmptyView gmH;
    private boolean gmI;
    private RelativeLayout gmv;
    private Button gmz;
    private BdListView mListView;
    private View mRootView;
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    ArrayList<o> gmD = new ArrayList<>();
    private j.a gmJ = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.gmD.clear();
                AlaLiveWishListActivity.gmE.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gPJ), dVar.gPH, dVar.mGiftName, String.valueOf(dVar.gPO), dVar.mDesc, String.valueOf(dVar.gPE), String.valueOf(dVar.gPF), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.gmI = true;
                    }
                    oVar.ul(1);
                    AlaLiveWishListActivity.this.gmD.add(oVar);
                    AlaLiveWishListActivity.gmE.add(String.valueOf(dVar.gPF));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.gmG) {
                    o oVar2 = new o();
                    oVar2.ul(0);
                    AlaLiveWishListActivity.this.gmD.add(oVar2);
                }
                AlaLiveWishListActivity.this.gmB.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.gmD.clear();
                o oVar3 = new o();
                oVar3.ul(0);
                AlaLiveWishListActivity.this.gmD.add(oVar3);
                AlaLiveWishListActivity.this.gmB.setVisibility(0);
            }
            AlaLiveWishListActivity.this.gmA = new h(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.gmA.setData(AlaLiveWishListActivity.this.gmD);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.gmA);
            AlaLiveWishListActivity.this.bNG();
            AlaLiveWishListActivity.this.gmz.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aQ(int i, String str) {
            AlaLiveWishListActivity.this.bNH();
        }
    };
    private CustomMessageListener aTE = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aTF);
            registerListener(this.aTE);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXA = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.brk = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.gmC == null) {
                this.gmC = new j(getPageContext(), this.gmJ);
            }
            this.gmC.clc();
            this.glW = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    private void EL() {
        Animation loadAnimation;
        this.aXA = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void EM() {
        Animation loadAnimation;
        if (!this.aXB && !this.aXA) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
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
            this.aXB = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        EM();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gmv = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gmv.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.gmv.setLayoutParams(layoutParams);
        this.glm = findViewById(a.f.ala_live_wish_list_root_bg);
        this.glm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.gmH = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.gmA = new h(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gmA);
        this.gmB = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.gmF = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMZ != null) {
            this.gmG = bqVar.aMZ.aPZ;
        }
        if (this.gmG <= 0) {
            this.gmG = 3;
        }
        if (this.gmG == 1) {
            this.gmF.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.gmG)));
        } else {
            this.gmF.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.gmG)));
        }
        this.gmz = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bNG();
        this.gmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.gmA != null && AlaLiveWishListActivity.this.gmA.getCount() < 2 && AlaLiveWishListActivity.this.gmG != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.glW.fJ(AlaLiveWishListActivity.this.brk);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNG() {
        if (this.gmI) {
            this.gmz.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.gmz.setEnabled(true);
            return;
        }
        this.gmz.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.gmz.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gmC != null) {
            this.gmC.onDestroy();
        }
        if (this.glW != null) {
            this.glW.onDestroy();
        }
        if (this.glW != null) {
            this.glW.clb();
        }
        MessageManager.getInstance().unRegisterListener(this.aTF);
        MessageManager.getInstance().unRegisterListener(this.aTE);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.gmA == null || this.gmA.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aP(int i, String str) {
        String string = getPageContext().getResources().getString(a.h.live_wish_create_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 1001) {
                if (this.gmC != null) {
                    this.gmC.clc();
                }
            } else if (i == 1002 && this.gmC != null) {
                this.gmC.clc();
            }
        }
    }

    public void bNH() {
        if (this.gmH != null) {
            this.gmH.reset();
            this.gmH.setTitle(a.h.sdk_net_fail_tip_rank);
            this.gmH.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.gmH.setVisibility(8);
                    if (AlaLiveWishListActivity.this.gmC == null) {
                        AlaLiveWishListActivity.this.gmC = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.gmJ);
                    }
                    AlaLiveWishListActivity.this.gmC.clc();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.gmH.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.gmH.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.gmH.setVisibility(0);
            this.gmB.setVisibility(8);
            this.gmz.setVisibility(8);
        }
    }
}
