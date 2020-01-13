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
import com.baidu.live.data.ao;
import com.baidu.live.r.a;
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
    public static ArrayList<String> edr = new ArrayList<>();
    private long ash;
    private View ecB;
    private g ecS;
    private RelativeLayout edk;
    private Button edm;
    private e edn;
    private RelativeLayout edo;
    private h edp;
    private TextView eds;
    private int edt;
    private CommonEmptyView edu;
    private boolean edv;
    private BdListView mListView;
    private View mRootView;
    private boolean aew = false;
    private boolean ahp = false;
    private boolean ahq = false;
    ArrayList<l> edq = new ArrayList<>();
    private h.a edw = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.e.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.edq.clear();
                AlaLiveWishListActivity.edr.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.evn), cVar.evl, cVar.mGiftName, String.valueOf(cVar.evs), cVar.mDesc, String.valueOf(cVar.evi), String.valueOf(cVar.evj), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.edv = true;
                    }
                    lVar.oQ(1);
                    AlaLiveWishListActivity.this.edq.add(lVar);
                    AlaLiveWishListActivity.edr.add(String.valueOf(cVar.evj));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.edt) {
                    l lVar2 = new l();
                    lVar2.oQ(0);
                    AlaLiveWishListActivity.this.edq.add(lVar2);
                }
                AlaLiveWishListActivity.this.edo.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.edq.clear();
                l lVar3 = new l();
                lVar3.oQ(0);
                AlaLiveWishListActivity.this.edq.add(lVar3);
                AlaLiveWishListActivity.this.edo.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.edn != null) {
                AlaLiveWishListActivity.this.edn.setData(AlaLiveWishListActivity.this.edq);
            }
            AlaLiveWishListActivity.this.aZj();
            AlaLiveWishListActivity.this.edm.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.e.h.a
        public void ab(int i, String str) {
            AlaLiveWishListActivity.this.aZk();
        }
    };
    private CustomMessageListener aeM = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
        registerListener(this.aeN);
        registerListener(this.aeM);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ahp = false;
        this.mRootView.setVisibility(4);
        if (getIntent() != null) {
            this.ash = getIntent().getLongExtra("live_id", 0L);
        }
        if (this.edp == null) {
            this.edp = new h(getPageContext(), this.edw);
        }
        this.edp.bqe();
        this.ecS = new g(getPageContext(), null, null, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aew) {
            this.mRootView.setVisibility(0);
            sc();
            this.aew = true;
        }
    }

    private void sc() {
        Animation loadAnimation;
        this.ahp = true;
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
                AlaLiveWishListActivity.this.ahp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void sd() {
        Animation loadAnimation;
        if (!this.ahq && !this.ahp) {
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
            this.ahq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        sd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.edk = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.edk.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.edk.setLayoutParams(layoutParams);
        this.ecB = findViewById(a.g.ala_live_wish_list_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.edu = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.edn = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.edn);
        this.edo = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.eds = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar != null && aoVar.abg != null) {
            this.edt = aoVar.abg.acO;
        }
        if (this.edt <= 0) {
            this.edt = 3;
        }
        if (this.edt == 1) {
            this.eds.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.edt)));
        } else {
            this.eds.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.edt)));
        }
        this.edm = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        aZj();
        this.edm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.edn != null && AlaLiveWishListActivity.this.edn.getCount() < 2 && AlaLiveWishListActivity.this.edt != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.ecS.da(AlaLiveWishListActivity.this.ash);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZj() {
        if (this.edv) {
            this.edm.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.edm.setEnabled(true);
            return;
        }
        this.edm.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.edm.setEnabled(false);
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
        if (this.edp != null) {
            this.edp.onDestroy();
        }
        if (this.ecS != null) {
            this.ecS.onDestroy();
        }
        if (this.ecS != null) {
            this.ecS.bqd();
        }
        MessageManager.getInstance().unRegisterListener(this.aeN);
        MessageManager.getInstance().unRegisterListener(this.aeM);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
        if (this.edn == null || this.edn.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.i.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void aa(int i, String str) {
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
                if (this.edp != null) {
                    this.edp.bqe();
                }
            } else if (i == 1002 && this.edp != null) {
                this.edp.bqe();
            }
        }
    }

    public void aZk() {
        if (this.edu != null) {
            this.edu.reset();
            this.edu.setTitle(a.i.sdk_net_fail_tip_rank);
            this.edu.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.edu.setVisibility(8);
                    if (AlaLiveWishListActivity.this.edp == null) {
                        AlaLiveWishListActivity.this.edp = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.edw);
                    }
                    AlaLiveWishListActivity.this.edp.bqe();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.edu.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.edu.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.edu.setVisibility(0);
            this.edo.setVisibility(8);
            this.edm.setVisibility(8);
        }
    }
}
