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
/* loaded from: classes11.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> grl = new ArrayList<>();
    private long bvY;
    private View gpT;
    private i gqD;
    private RelativeLayout grc;
    private Button grg;
    private h grh;
    private RelativeLayout gri;
    private j grj;
    private TextView grm;
    private int grn;
    private CommonEmptyView gro;
    private boolean grp;
    private BdListView mListView;
    private View mRootView;
    private boolean aYb = false;
    private boolean bco = false;
    private boolean bcp = false;
    ArrayList<o> grk = new ArrayList<>();
    private j.a grq = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.grk.clear();
                AlaLiveWishListActivity.grl.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gUp), dVar.gUn, dVar.mGiftName, String.valueOf(dVar.gUu), dVar.mDesc, String.valueOf(dVar.gUk), String.valueOf(dVar.gUl), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.grp = true;
                    }
                    oVar.vR(1);
                    AlaLiveWishListActivity.this.grk.add(oVar);
                    AlaLiveWishListActivity.grl.add(String.valueOf(dVar.gUl));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.grn) {
                    o oVar2 = new o();
                    oVar2.vR(0);
                    AlaLiveWishListActivity.this.grk.add(oVar2);
                }
                AlaLiveWishListActivity.this.gri.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.grk.clear();
                o oVar3 = new o();
                oVar3.vR(0);
                AlaLiveWishListActivity.this.grk.add(oVar3);
                AlaLiveWishListActivity.this.gri.setVisibility(0);
            }
            AlaLiveWishListActivity.this.grh = new h(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.grh.setData(AlaLiveWishListActivity.this.grk);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.grh);
            AlaLiveWishListActivity.this.bRx();
            AlaLiveWishListActivity.this.grg.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aP(int i, String str) {
            AlaLiveWishListActivity.this.bRy();
        }
    };
    private CustomMessageListener aYr = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aYs);
            registerListener(this.aYr);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.bco = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bvY = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.grj == null) {
                this.grj = new j(getPageContext(), this.grq);
            }
            this.grj.coT();
            this.gqD = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aYb) {
            this.mRootView.setVisibility(0);
            IG();
            this.aYb = true;
        }
    }

    private void IG() {
        Animation loadAnimation;
        this.bco = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.bco = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void IH() {
        Animation loadAnimation;
        if (!this.bcp && !this.bco) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_bottom);
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
            this.bcp = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        IH();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.grc = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grc.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.grc.setLayoutParams(layoutParams);
        this.gpT = findViewById(a.f.ala_live_wish_list_root_bg);
        this.gpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.gro = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.grh = new h(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.grh);
        this.gri = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.grm = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRM != null) {
            this.grn = bqVar.aRM.aUM;
        }
        if (this.grn <= 0) {
            this.grn = 3;
        }
        if (this.grn == 1) {
            this.grm.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.grn)));
        } else {
            this.grm.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.grn)));
        }
        this.grg = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bRx();
        this.grg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.grh != null && AlaLiveWishListActivity.this.grh.getCount() < 2 && AlaLiveWishListActivity.this.grn != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.gqD.fJ(AlaLiveWishListActivity.this.bvY);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        if (this.grp) {
            this.grg.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.grg.setEnabled(true);
            return;
        }
        this.grg.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.grg.setEnabled(false);
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
        if (this.grj != null) {
            this.grj.onDestroy();
        }
        if (this.gqD != null) {
            this.gqD.onDestroy();
        }
        if (this.gqD != null) {
            this.gqD.coS();
        }
        MessageManager.getInstance().unRegisterListener(this.aYs);
        MessageManager.getInstance().unRegisterListener(this.aYr);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.grh == null || this.grh.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aO(int i, String str) {
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
                if (this.grj != null) {
                    this.grj.coT();
                }
            } else if (i == 1002 && this.grj != null) {
                this.grj.coT();
            }
        }
    }

    public void bRy() {
        if (this.gro != null) {
            this.gro.reset();
            this.gro.setTitle(a.h.sdk_net_fail_tip_rank);
            this.gro.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.gro.setVisibility(8);
                    if (AlaLiveWishListActivity.this.grj == null) {
                        AlaLiveWishListActivity.this.grj = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.grq);
                    }
                    AlaLiveWishListActivity.this.grj.coT();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.gro.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.gro.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.gro.setVisibility(0);
            this.gri.setVisibility(8);
            this.grg.setVisibility(8);
        }
    }
}
