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
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
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
    public static ArrayList<String> ehu = new ArrayList<>();
    private long awr;
    private View egE;
    private g egV;
    private RelativeLayout ehn;
    private Button ehp;
    private e ehq;
    private RelativeLayout ehr;
    private h ehs;
    private TextView ehv;
    private int ehw;
    private CommonEmptyView ehx;
    private boolean ehy;
    private BdListView mListView;
    private View mRootView;
    private boolean agD = false;
    private boolean ajy = false;
    private boolean ajz = false;
    ArrayList<l> eht = new ArrayList<>();
    private h.a ehz = new h.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.e.h.a
        public void a(ArrayList<com.baidu.tieba.ala.data.c> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.eht.clear();
                AlaLiveWishListActivity.ehu.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.c cVar = arrayList.get(i2);
                    l lVar = new l(String.valueOf(cVar.ezy), cVar.ezw, cVar.mGiftName, String.valueOf(cVar.ezD), cVar.mDesc, String.valueOf(cVar.ezt), String.valueOf(cVar.ezu), cVar.mStatus);
                    if (cVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.ehy = true;
                    }
                    lVar.ph(1);
                    AlaLiveWishListActivity.this.eht.add(lVar);
                    AlaLiveWishListActivity.ehu.add(String.valueOf(cVar.ezu));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.ehw) {
                    l lVar2 = new l();
                    lVar2.ph(0);
                    AlaLiveWishListActivity.this.eht.add(lVar2);
                }
                AlaLiveWishListActivity.this.ehr.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.eht.clear();
                l lVar3 = new l();
                lVar3.ph(0);
                AlaLiveWishListActivity.this.eht.add(lVar3);
                AlaLiveWishListActivity.this.ehr.setVisibility(0);
            }
            if (AlaLiveWishListActivity.this.ehq != null) {
                AlaLiveWishListActivity.this.ehq.setData(AlaLiveWishListActivity.this.eht);
            }
            AlaLiveWishListActivity.this.bby();
            AlaLiveWishListActivity.this.ehp.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.e.h.a
        public void ac(int i, String str) {
            AlaLiveWishListActivity.this.bbz();
        }
    };
    private CustomMessageListener agT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
        registerListener(this.agU);
        registerListener(this.agT);
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajy = false;
        this.mRootView.setVisibility(4);
        if (getIntent() != null) {
            this.awr = getIntent().getLongExtra("live_id", 0L);
        }
        if (this.ehs == null) {
            this.ehs = new h(getPageContext(), this.ehz);
        }
        this.ehs.brI();
        this.egV = new g(getPageContext(), null, null, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agD) {
            this.mRootView.setVisibility(0);
            tn();
            this.agD = true;
        }
    }

    private void tn() {
        Animation loadAnimation;
        this.ajy = true;
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
                AlaLiveWishListActivity.this.ajy = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tp() {
        Animation loadAnimation;
        if (!this.ajz && !this.ajy) {
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
            this.ajz = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tp();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ehn = (RelativeLayout) findViewById(a.g.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ehn.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ehn.setLayoutParams(layoutParams);
        this.egE = findViewById(a.g.ala_live_wish_list_root_bg);
        this.egE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.wish_list);
        this.ehx = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_live_wish_list_empty_view);
        this.ehq = new e(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.ehq);
        this.ehr = (RelativeLayout) this.mRootView.findViewById(a.g.live_wish_list_empty_view);
        this.ehv = (TextView) this.mRootView.findViewById(a.g.ala_live_wish_list_limit);
        ap apVar = com.baidu.live.v.a.zj().axB;
        if (apVar != null && apVar.ade != null) {
            this.ehw = apVar.ade.aeQ;
        }
        if (this.ehw <= 0) {
            this.ehw = 3;
        }
        if (this.ehw == 1) {
            this.ehv.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_one), Integer.valueOf(this.ehw)));
        } else {
            this.ehv.setText(String.format(getPageContext().getResources().getString(a.i.wish_list_top_title_des), Integer.valueOf(this.ehw)));
        }
        this.ehp = (Button) this.mRootView.findViewById(a.g.live_wish_list_create_wish_bt);
        bby();
        this.ehp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.ehq != null && AlaLiveWishListActivity.this.ehq.getCount() < 2 && AlaLiveWishListActivity.this.ehw != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.i.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.egV.dc(AlaLiveWishListActivity.this.awr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bby() {
        if (this.ehy) {
            this.ehp.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            this.ehp.setEnabled(true);
            return;
        }
        this.ehp.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
        this.ehp.setEnabled(false);
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
        if (this.ehs != null) {
            this.ehs.onDestroy();
        }
        if (this.egV != null) {
            this.egV.onDestroy();
        }
        if (this.egV != null) {
            this.egV.brH();
        }
        MessageManager.getInstance().unRegisterListener(this.agU);
        MessageManager.getInstance().unRegisterListener(this.agT);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
        if (this.ehq == null || this.ehq.getCount() >= 2) {
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
                if (this.ehs != null) {
                    this.ehs.brI();
                }
            } else if (i == 1002 && this.ehs != null) {
                this.ehs.brI();
            }
        }
    }

    public void bbz() {
        if (this.ehx != null) {
            this.ehx.reset();
            this.ehx.setTitle(a.i.sdk_net_fail_tip_rank);
            this.ehx.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.ehx.setVisibility(8);
                    if (AlaLiveWishListActivity.this.ehs == null) {
                        AlaLiveWishListActivity.this.ehs = new h(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.ehz);
                    }
                    AlaLiveWishListActivity.this.ehs.brI();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.ehx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.ehx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.ehx.setVisibility(0);
            this.ehr.setVisibility(8);
            this.ehp.setVisibility(8);
        }
    }
}
