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
import com.baidu.live.data.bm;
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
    public static ArrayList<String> fTd = new ArrayList<>();
    private long bmB;
    private RelativeLayout fSU;
    private Button fSY;
    private g fSZ;
    private View fSe;
    private i fSv;
    private RelativeLayout fTa;
    private j fTb;
    private TextView fTe;
    private int fTf;
    private CommonEmptyView fTg;
    private boolean fTh;
    private BdListView mListView;
    private View mRootView;
    private boolean aTK = false;
    private boolean aXJ = false;
    private boolean aXK = false;
    ArrayList<o> fTc = new ArrayList<>();
    private j.a fTi = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.fTc.clear();
                AlaLiveWishListActivity.fTd.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.guk), dVar.gui, dVar.mGiftName, String.valueOf(dVar.gup), dVar.mDesc, String.valueOf(dVar.guf), String.valueOf(dVar.gug), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.fTh = true;
                    }
                    oVar.ur(1);
                    AlaLiveWishListActivity.this.fTc.add(oVar);
                    AlaLiveWishListActivity.fTd.add(String.valueOf(dVar.gug));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.fTf) {
                    o oVar2 = new o();
                    oVar2.ur(0);
                    AlaLiveWishListActivity.this.fTc.add(oVar2);
                }
                AlaLiveWishListActivity.this.fTa.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.fTc.clear();
                o oVar3 = new o();
                oVar3.ur(0);
                AlaLiveWishListActivity.this.fTc.add(oVar3);
                AlaLiveWishListActivity.this.fTa.setVisibility(0);
            }
            AlaLiveWishListActivity.this.fSZ = new g(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.fSZ.setData(AlaLiveWishListActivity.this.fTc);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.fSZ);
            AlaLiveWishListActivity.this.bJv();
            AlaLiveWishListActivity.this.fSY.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aL(int i, String str) {
            AlaLiveWishListActivity.this.bJw();
        }
    };
    private CustomMessageListener aUa = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aUb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aUb);
            registerListener(this.aUa);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXJ = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bmB = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.fTb == null) {
                this.fTb = new j(getPageContext(), this.fTi);
            }
            this.fTb.cgm();
            this.fSv = new i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTK) {
            this.mRootView.setVisibility(0);
            Hv();
            this.aTK = true;
        }
    }

    private void Hv() {
        Animation loadAnimation;
        this.aXJ = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.aXJ = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Hw() {
        Animation loadAnimation;
        if (!this.aXK && !this.aXJ) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
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
            this.aXK = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Hw();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fSU = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fSU.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fSU.setLayoutParams(layoutParams);
        this.fSe = findViewById(a.g.ala_live_wish_list_root_bg);
        this.fSe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.fTg = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.fSZ = new g(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.fSZ);
        this.fTa = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.fTe = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOL != null) {
            this.fTf = bmVar.aOL.aRq;
        }
        if (this.fTf <= 0) {
            this.fTf = 3;
        }
        if (this.fTf == 1) {
            this.fTe.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.fTf)));
        } else {
            this.fTe.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.fTf)));
        }
        this.fSY = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bJv();
        this.fSY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.fSZ != null && AlaLiveWishListActivity.this.fSZ.getCount() < 2 && AlaLiveWishListActivity.this.fTf != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.fSv.eJ(AlaLiveWishListActivity.this.bmB);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJv() {
        if (this.fTh) {
            this.fSY.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.fSY.setEnabled(true);
            return;
        }
        this.fSY.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.fSY.setEnabled(false);
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
        if (this.fTb != null) {
            this.fTb.onDestroy();
        }
        if (this.fSv != null) {
            this.fSv.onDestroy();
        }
        if (this.fSv != null) {
            this.fSv.cgl();
        }
        MessageManager.getInstance().unRegisterListener(this.aUb);
        MessageManager.getInstance().unRegisterListener(this.aUa);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.fSZ == null || this.fSZ.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aK(int i, String str) {
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
                if (this.fTb != null) {
                    this.fTb.cgm();
                }
            } else if (i == 1002 && this.fTb != null) {
                this.fTb.cgm();
            }
        }
    }

    public void bJw() {
        if (this.fTg != null) {
            this.fTg.reset();
            this.fTg.setTitle(a.i.sdk_net_fail_tip_rank);
            this.fTg.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.fTg.setVisibility(8);
                    if (AlaLiveWishListActivity.this.fTb == null) {
                        AlaLiveWishListActivity.this.fTb = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.fTi);
                    }
                    AlaLiveWishListActivity.this.fTb.cgm();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.fTg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.fTg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.fTg.setVisibility(0);
            this.fTa.setVisibility(8);
            this.fSY.setVisibility(8);
        }
    }
}
