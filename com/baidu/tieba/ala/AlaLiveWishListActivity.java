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
import com.baidu.live.data.bv;
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
    public static ArrayList<String> grk = new ArrayList<>();
    private long bwn;
    private View gpP;
    private com.baidu.tieba.ala.g.i gqC;
    private RelativeLayout grb;
    private Button grf;
    private i grg;
    private RelativeLayout grh;
    private j gri;
    private TextView grl;
    private int grm;
    private CommonEmptyView grn;
    private boolean gro;
    private BdListView mListView;
    private View mRootView;
    private boolean aXT = false;
    private boolean bch = false;
    private boolean bci = false;
    ArrayList<o> grj = new ArrayList<>();
    private j.a grp = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.grj.clear();
                AlaLiveWishListActivity.grk.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gUp), dVar.gUn, dVar.mGiftName, String.valueOf(dVar.gUu), dVar.mDesc, String.valueOf(dVar.gUk), String.valueOf(dVar.gUl), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.gro = true;
                    }
                    oVar.ut(1);
                    AlaLiveWishListActivity.this.grj.add(oVar);
                    AlaLiveWishListActivity.grk.add(String.valueOf(dVar.gUl));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.grm) {
                    o oVar2 = new o();
                    oVar2.ut(0);
                    AlaLiveWishListActivity.this.grj.add(oVar2);
                }
                AlaLiveWishListActivity.this.grh.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.grj.clear();
                o oVar3 = new o();
                oVar3.ut(0);
                AlaLiveWishListActivity.this.grj.add(oVar3);
                AlaLiveWishListActivity.this.grh.setVisibility(0);
            }
            AlaLiveWishListActivity.this.grg = new i(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.grg.setData(AlaLiveWishListActivity.this.grj);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.grg);
            AlaLiveWishListActivity.this.bOu();
            AlaLiveWishListActivity.this.grf.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aV(int i, String str) {
            AlaLiveWishListActivity.this.bOv();
        }
    };
    private CustomMessageListener aYj = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aYk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aYk);
            registerListener(this.aYj);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.bch = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.bwn = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.gri == null) {
                this.gri = new j(getPageContext(), this.grp);
            }
            this.gri.cmn();
            this.gqC = new com.baidu.tieba.ala.g.i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aXT) {
            this.mRootView.setVisibility(0);
            Ge();
            this.aXT = true;
        }
    }

    private void Ge() {
        Animation loadAnimation;
        this.bch = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveWishListActivity.this.bch = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gf() {
        Animation loadAnimation;
        if (!this.bci && !this.bch) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_bottom);
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
            this.bci = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gf();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.grb = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grb.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.grb.setLayoutParams(layoutParams);
        this.gpP = findViewById(a.f.ala_live_wish_list_root_bg);
        this.gpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.grn = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.grg = new i(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.grg);
        this.grh = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.grl = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRx != null) {
            this.grm = bvVar.aRx.aUC;
        }
        if (this.grm <= 0) {
            this.grm = 3;
        }
        if (this.grm == 1) {
            this.grl.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.grm)));
        } else {
            this.grl.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.grm)));
        }
        this.grf = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bOu();
        this.grf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.grg != null && AlaLiveWishListActivity.this.grg.getCount() < 2 && AlaLiveWishListActivity.this.grm != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.gqC.fO(AlaLiveWishListActivity.this.bwn);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOu() {
        if (this.gro) {
            this.grf.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.grf.setEnabled(true);
            return;
        }
        this.grf.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.grf.setEnabled(false);
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
        if (this.gri != null) {
            this.gri.onDestroy();
        }
        if (this.gqC != null) {
            this.gqC.onDestroy();
        }
        if (this.gqC != null) {
            this.gqC.cmm();
        }
        MessageManager.getInstance().unRegisterListener(this.aYk);
        MessageManager.getInstance().unRegisterListener(this.aYj);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.grg == null || this.grg.getCount() >= 2) {
            getPageContext().showToast(getPageContext().getResources().getString(a.h.live_wish_create_tip_succ));
            finish();
        }
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aU(int i, String str) {
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
                if (this.gri != null) {
                    this.gri.cmn();
                }
            } else if (i == 1002 && this.gri != null) {
                this.gri.cmn();
            }
        }
    }

    public void bOv() {
        if (this.grn != null) {
            this.grn.reset();
            this.grn.setTitle(a.h.sdk_net_fail_tip_rank);
            this.grn.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.grn.setVisibility(8);
                    if (AlaLiveWishListActivity.this.gri == null) {
                        AlaLiveWishListActivity.this.gri = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.grp);
                    }
                    AlaLiveWishListActivity.this.gri.cmn();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.grn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.grn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.grn.setVisibility(0);
            this.grh.setVisibility(8);
            this.grf.setVisibility(8);
        }
    }
}
