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
import com.baidu.live.data.bo;
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
/* loaded from: classes4.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> ggN = new ArrayList<>();
    private long brr;
    private View gfO;
    private RelativeLayout ggE;
    private Button ggI;
    private g ggJ;
    private RelativeLayout ggK;
    private j ggL;
    private TextView ggO;
    private int ggP;
    private CommonEmptyView ggQ;
    private boolean ggR;
    private i ggf;
    private BdListView mListView;
    private View mRootView;
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    ArrayList<o> ggM = new ArrayList<>();
    private j.a ggS = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.ggM.clear();
                AlaLiveWishListActivity.ggN.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gID), dVar.gIB, dVar.mGiftName, String.valueOf(dVar.gII), dVar.mDesc, String.valueOf(dVar.gIy), String.valueOf(dVar.gIz), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.ggR = true;
                    }
                    oVar.vG(1);
                    AlaLiveWishListActivity.this.ggM.add(oVar);
                    AlaLiveWishListActivity.ggN.add(String.valueOf(dVar.gIz));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.ggP) {
                    o oVar2 = new o();
                    oVar2.vG(0);
                    AlaLiveWishListActivity.this.ggM.add(oVar2);
                }
                AlaLiveWishListActivity.this.ggK.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.ggM.clear();
                o oVar3 = new o();
                oVar3.vG(0);
                AlaLiveWishListActivity.this.ggM.add(oVar3);
                AlaLiveWishListActivity.this.ggK.setVisibility(0);
            }
            AlaLiveWishListActivity.this.ggJ = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.ggJ.setData(AlaLiveWishListActivity.this.ggM);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.ggJ);
            AlaLiveWishListActivity.this.bOX();
            AlaLiveWishListActivity.this.ggI.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aN(int i, String str) {
            AlaLiveWishListActivity.this.bOY();
        }
    };
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aWM);
            registerListener(this.aWL);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.brr = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.ggL == null) {
                this.ggL = new j(getPageContext(), this.ggS);
            }
            this.ggL.cmc();
            this.ggf = new i(getPageContext(), null, null, this);
        }
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

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.baH = false;
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Jf();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ggE = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ggE.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ggE.setLayoutParams(layoutParams);
        this.gfO = findViewById(a.f.ala_live_wish_list_root_bg);
        this.gfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.ggQ = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.ggJ = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ggJ);
        this.ggK = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.ggO = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQX != null) {
            this.ggP = boVar.aQX.aTO;
        }
        if (this.ggP <= 0) {
            this.ggP = 3;
        }
        if (this.ggP == 1) {
            this.ggO.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.ggP)));
        } else {
            this.ggO.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.ggP)));
        }
        this.ggI = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bOX();
        this.ggI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.ggJ != null && AlaLiveWishListActivity.this.ggJ.getCount() < 2 && AlaLiveWishListActivity.this.ggP != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.ggf.fJ(AlaLiveWishListActivity.this.brr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOX() {
        if (this.ggR) {
            this.ggI.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.ggI.setEnabled(true);
            return;
        }
        this.ggI.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.ggI.setEnabled(false);
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
        if (this.ggL != null) {
            this.ggL.onDestroy();
        }
        if (this.ggf != null) {
            this.ggf.onDestroy();
        }
        if (this.ggf != null) {
            this.ggf.cmb();
        }
        MessageManager.getInstance().unRegisterListener(this.aWM);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.ggJ == null || this.ggJ.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aM(int i, String str) {
        String string = getPageContext().getResources().getString(a.h.live_wish_create_tip_fail);
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
                if (this.ggL != null) {
                    this.ggL.cmc();
                }
            } else if (i == 1002 && this.ggL != null) {
                this.ggL.cmc();
            }
        }
    }

    public void bOY() {
        if (this.ggQ != null) {
            this.ggQ.reset();
            this.ggQ.setTitle(a.h.sdk_net_fail_tip_rank);
            this.ggQ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.ggQ.setVisibility(8);
                    if (AlaLiveWishListActivity.this.ggL == null) {
                        AlaLiveWishListActivity.this.ggL = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.ggS);
                    }
                    AlaLiveWishListActivity.this.ggL.cmc();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.ggQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.ggQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.ggQ.setVisibility(0);
            this.ggK.setVisibility(8);
            this.ggI.setVisibility(8);
        }
    }
}
