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
import com.baidu.live.data.ak;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.e.g;
import com.baidu.tieba.ala.e.h;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements g.b {
    public static ArrayList<String> edj = new ArrayList<>();
    private long arv;
    private g ecJ;
    private View ecs;
    private RelativeLayout edc;
    private Button ede;
    private e edf;
    private RelativeLayout edg;
    private h edh;
    private TextView edk;
    private int edl;
    private CommonEmptyView edm;
    private boolean edn;
    private BdListView mListView;
    private View mRootView;
    private boolean agF = false;
    private boolean agG = false;
    private boolean agH = false;
    ArrayList<l> edi = new ArrayList<>();
    private h.a edo = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.e.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.edi.clear();
                AlaLiveWishListActivity.edj.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.euc), cVar.eua, cVar.mGiftName, String.valueOf(cVar.euh), cVar.mDesc, String.valueOf(cVar.etX), String.valueOf(cVar.etY), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.edn = true;
                    }
                    lVar.oP(1);
                    AlaLiveWishListActivity.this.edi.add(lVar);
                    AlaLiveWishListActivity.edj.add(String.valueOf(cVar.etY));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.edl) {
                    l lVar2 = new l();
                    lVar2.oP(0);
                    AlaLiveWishListActivity.this.edi.add(lVar2);
                }
                AlaLiveWishListActivity.this.edg.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.edi.clear();
                l lVar3 = new l();
                lVar3.oP(0);
                AlaLiveWishListActivity.this.edi.add(lVar3);
                AlaLiveWishListActivity.this.edg.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.edf != null) {
                AlaLiveWishListActivity.this.edf.setData(AlaLiveWishListActivity.this.edi);
            }
            AlaLiveWishListActivity.this.aYP();
            AlaLiveWishListActivity.this.ede.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.e.h.a
        public void Z(int i, String str) {
            AlaLiveWishListActivity.this.aYQ();
        }
    };
    private CustomMessageListener ecM = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener anV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
        registerListener(this.anV);
        registerListener(this.ecM);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.agG = false;
        this.mRootView.setVisibility(4);
        if (getIntent() != null) {
            this.arv = getIntent().getLongExtra("live_id", 0L);
        }
        if (this.edh == null) {
            this.edh = new h(getPageContext(), this.edo);
        }
        this.edh.bpd();
        this.ecJ = new g(getPageContext(), null, null, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agF) {
            this.mRootView.setVisibility(0);
            rM();
            this.agF = true;
        }
    }

    private void rM() {
        Animation loadAnimation;
        this.agG = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.agG = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void rN() {
        Animation loadAnimation;
        if (!this.agH && !this.agG) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_bottom);
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
            this.agH = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        rN();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.edc = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.edc.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.edc.setLayoutParams(layoutParams);
        this.ecs = findViewById(a.g.ala_live_wish_list_root_bg);
        this.ecs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.edm = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.edf = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.edf);
        this.edg = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.edk = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar != null && akVar.aaS != null) {
            this.edl = akVar.aaS.acC;
        }
        if (this.edl <= 0) {
            this.edl = 3;
        }
        if (this.edl == 1) {
            this.edk.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.edl)));
        } else {
            this.edk.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.edl)));
        }
        this.ede = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        aYP();
        this.ede.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.edf != null && AlaLiveWishListActivity.this.edf.getCount() < 2 && AlaLiveWishListActivity.this.edl != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.ecJ.cV(AlaLiveWishListActivity.this.arv);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYP() {
        if (this.edn) {
            this.ede.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.ede.setEnabled(true);
            return;
        }
        this.ede.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.ede.setEnabled(false);
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
        if (this.edh != null) {
            this.edh.onDestroy();
        }
        if (this.ecJ != null) {
            this.ecJ.onDestroy();
        }
        if (this.ecJ != null) {
            this.ecJ.bpc();
        }
        MessageManager.getInstance().unRegisterListener(this.anV);
        MessageManager.getInstance().unRegisterListener(this.ecM);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
        if (this.edf == null || this.edf.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void Y(int i, String str) {
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
                if (this.edh != null) {
                    this.edh.bpd();
                }
            } else if (i == 1002 && this.edh != null) {
                this.edh.bpd();
            }
        }
    }

    public void aYQ() {
        if (this.edm != null) {
            this.edm.reset();
            this.edm.setTitle(a.i.sdk_net_fail_tip_rank);
            this.edm.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.edm.setVisibility(8);
                    if (AlaLiveWishListActivity.this.edh == null) {
                        AlaLiveWishListActivity.this.edh = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.edo);
                    }
                    AlaLiveWishListActivity.this.edh.bpd();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.edm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.edm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.edm.setVisibility(0);
            this.edg.setVisibility(8);
            this.ede.setVisibility(8);
        }
    }
}
