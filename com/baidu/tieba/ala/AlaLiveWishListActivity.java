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
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.e.g;
import com.baidu.tieba.ala.e.h;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements g.b {
    public static ArrayList<String> ehY = new ArrayList<>();
    private long awD;
    private RelativeLayout ehR;
    private Button ehT;
    private e ehU;
    private RelativeLayout ehV;
    private h ehW;
    private TextView ehZ;
    private View ehi;
    private g ehz;
    private int eia;
    private CommonEmptyView eib;
    private boolean eic;
    private BdListView mListView;
    private View mRootView;
    private boolean agN = false;
    private boolean ajI = false;
    private boolean ajJ = false;
    ArrayList<l> ehX = new ArrayList<>();
    private h.a eid = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.e.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.ehX.clear();
                AlaLiveWishListActivity.ehY.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.eAi), cVar.eAg, cVar.mGiftName, String.valueOf(cVar.eAn), cVar.mDesc, String.valueOf(cVar.eAd), String.valueOf(cVar.eAe), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.eic = true;
                    }
                    lVar.pj(1);
                    AlaLiveWishListActivity.this.ehX.add(lVar);
                    AlaLiveWishListActivity.ehY.add(String.valueOf(cVar.eAe));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.eia) {
                    l lVar2 = new l();
                    lVar2.pj(0);
                    AlaLiveWishListActivity.this.ehX.add(lVar2);
                }
                AlaLiveWishListActivity.this.ehV.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.ehX.clear();
                l lVar3 = new l();
                lVar3.pj(0);
                AlaLiveWishListActivity.this.ehX.add(lVar3);
                AlaLiveWishListActivity.this.ehV.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.ehU != null) {
                AlaLiveWishListActivity.this.ehU.setData(AlaLiveWishListActivity.this.ehX);
            }
            AlaLiveWishListActivity.this.bbF();
            AlaLiveWishListActivity.this.ehT.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.e.h.a
        public void ac(int i, String str) {
            AlaLiveWishListActivity.this.bbG();
        }
    };
    private CustomMessageListener ahd = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        registerListener(this.ahe);
        registerListener(this.ahd);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajI = false;
        this.mRootView.setVisibility(4);
        if (getIntent() != null) {
            this.awD = getIntent().getLongExtra("live_id", 0L);
        }
        if (this.ehW == null) {
            this.ehW = new h(getPageContext(), this.eid);
        }
        this.ehW.brQ();
        this.ehz = new g(getPageContext(), null, null, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agN) {
            this.mRootView.setVisibility(0);
            tt();
            this.agN = true;
        }
    }

    private void tt() {
        Animation loadAnimation;
        this.ajI = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.ajI = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tu() {
        Animation loadAnimation;
        if (!this.ajJ && !this.ajI) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_bottom);
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
            this.ajJ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tu();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ehR = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ehR.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ehR.setLayoutParams(layoutParams);
        this.ehi = findViewById(a.g.ala_live_wish_list_root_bg);
        this.ehi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.eib = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.ehU = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ehU);
        this.ehV = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.ehZ = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar != null && apVar.ado != null) {
            this.eia = apVar.ado.afa;
        }
        if (this.eia <= 0) {
            this.eia = 3;
        }
        if (this.eia == 1) {
            this.ehZ.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.eia)));
        } else {
            this.ehZ.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.eia)));
        }
        this.ehT = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bbF();
        this.ehT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.ehU != null && AlaLiveWishListActivity.this.ehU.getCount() < 2 && AlaLiveWishListActivity.this.eia != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.ehz.dc(AlaLiveWishListActivity.this.awD);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbF() {
        if (this.eic) {
            this.ehT.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.ehT.setEnabled(true);
            return;
        }
        this.ehT.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.ehT.setEnabled(false);
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
        if (this.ehW != null) {
            this.ehW.onDestroy();
        }
        if (this.ehz != null) {
            this.ehz.onDestroy();
        }
        if (this.ehz != null) {
            this.ehz.brP();
        }
        MessageManager.getInstance().unRegisterListener(this.ahe);
        MessageManager.getInstance().unRegisterListener(this.ahd);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
        if (this.ehU == null || this.ehU.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void ab(int i, String str) {
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
                if (this.ehW != null) {
                    this.ehW.brQ();
                }
            } else if (i == 1002 && this.ehW != null) {
                this.ehW.brQ();
            }
        }
    }

    public void bbG() {
        if (this.eib != null) {
            this.eib.reset();
            this.eib.setTitle(a.i.sdk_net_fail_tip_rank);
            this.eib.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.eib.setVisibility(8);
                    if (AlaLiveWishListActivity.this.ehW == null) {
                        AlaLiveWishListActivity.this.ehW = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.eid);
                    }
                    AlaLiveWishListActivity.this.ehW.brQ();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.eib.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.eib.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.eib.setVisibility(0);
            this.ehV.setVisibility(8);
            this.ehT.setVisibility(8);
        }
    }
}
