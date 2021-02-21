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
/* loaded from: classes11.dex */
public class AlaLiveWishListActivity extends BaseFragmentActivity implements i.b {
    public static ArrayList<String> gpB = new ArrayList<>();
    private long buN;
    private com.baidu.tieba.ala.g.i goT;
    private View gog;
    private TextView gpC;
    private int gpD;
    private CommonEmptyView gpE;
    private boolean gpF;
    private RelativeLayout gps;
    private Button gpw;
    private i gpx;
    private RelativeLayout gpy;
    private j gpz;
    private BdListView mListView;
    private View mRootView;
    private boolean aWt = false;
    private boolean baH = false;
    private boolean baI = false;
    ArrayList<o> gpA = new ArrayList<>();
    private j.a gpG = new j.a() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.1
        @Override // com.baidu.tieba.ala.g.j.a
        public void a(ArrayList<com.baidu.tieba.ala.data.d> arrayList, String str, long j) {
            if (arrayList != null && arrayList.size() > 0) {
                AlaLiveWishListActivity.this.gpA.clear();
                AlaLiveWishListActivity.gpB.clear();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    com.baidu.tieba.ala.data.d dVar = arrayList.get(i2);
                    o oVar = new o(String.valueOf(dVar.gSG), dVar.gSE, dVar.mGiftName, String.valueOf(dVar.gSL), dVar.mDesc, String.valueOf(dVar.gSB), String.valueOf(dVar.gSC), dVar.mStatus);
                    if (dVar.mStatus == 0) {
                        AlaLiveWishListActivity.this.gpF = true;
                    }
                    oVar.ur(1);
                    AlaLiveWishListActivity.this.gpA.add(oVar);
                    AlaLiveWishListActivity.gpB.add(String.valueOf(dVar.gSC));
                    i = i2 + 1;
                }
                if (arrayList.size() < AlaLiveWishListActivity.this.gpD) {
                    o oVar2 = new o();
                    oVar2.ur(0);
                    AlaLiveWishListActivity.this.gpA.add(oVar2);
                }
                AlaLiveWishListActivity.this.gpy.setVisibility(8);
            } else {
                AlaLiveWishListActivity.this.gpA.clear();
                o oVar3 = new o();
                oVar3.ur(0);
                AlaLiveWishListActivity.this.gpA.add(oVar3);
                AlaLiveWishListActivity.this.gpy.setVisibility(0);
            }
            AlaLiveWishListActivity.this.gpx = new i(AlaLiveWishListActivity.this.getPageContext());
            AlaLiveWishListActivity.this.gpx.setData(AlaLiveWishListActivity.this.gpA);
            AlaLiveWishListActivity.this.mListView.setAdapter((ListAdapter) AlaLiveWishListActivity.this.gpx);
            AlaLiveWishListActivity.this.bOo();
            AlaLiveWishListActivity.this.gpw.setVisibility(0);
        }

        @Override // com.baidu.tieba.ala.g.j.a
        public void aV(int i, String str) {
            AlaLiveWishListActivity.this.bOp();
        }
    };
    private CustomMessageListener aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveWishListActivity.this.closeActivity();
        }
    };
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.7
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
            registerListener(this.aWK);
            registerListener(this.aWJ);
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            if (getIntent() != null) {
                this.buN = getIntent().getLongExtra("live_id", 0L);
            }
            if (this.gpz == null) {
                this.gpz = new j(getPageContext(), this.gpG);
            }
            this.gpz.cmh();
            this.goT = new com.baidu.tieba.ala.g.i(getPageContext(), null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWt) {
            this.mRootView.setVisibility(0);
            Gb();
            this.aWt = true;
        }
    }

    private void Gb() {
        Animation loadAnimation;
        this.baH = true;
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
                AlaLiveWishListActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gc() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gc();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_wish_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gps = (RelativeLayout) findViewById(a.f.ala_live_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gps.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.gps.setLayoutParams(layoutParams);
        this.gog = findViewById(a.f.ala_live_wish_list_root_bg);
        this.gog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveWishListActivity.this.finish();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.wish_list);
        this.gpE = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_live_wish_list_empty_view);
        this.gpx = new i(getPageContext());
        this.mListView.setAdapter((ListAdapter) this.gpx);
        this.gpy = (RelativeLayout) this.mRootView.findViewById(a.f.live_wish_list_empty_view);
        this.gpC = (TextView) this.mRootView.findViewById(a.f.ala_live_wish_list_limit);
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPX != null) {
            this.gpD = bvVar.aPX.aTc;
        }
        if (this.gpD <= 0) {
            this.gpD = 3;
        }
        if (this.gpD == 1) {
            this.gpC.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_one), Integer.valueOf(this.gpD)));
        } else {
            this.gpC.setText(String.format(getPageContext().getResources().getString(a.h.wish_list_top_title_des), Integer.valueOf(this.gpD)));
        }
        this.gpw = (Button) this.mRootView.findViewById(a.f.live_wish_list_create_wish_bt);
        bOo();
        this.gpw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveWishListActivity.this.gpx != null && AlaLiveWishListActivity.this.gpx.getCount() < 2 && AlaLiveWishListActivity.this.gpD != 1) {
                    AlaLiveWishListActivity.this.getPageContext().showToast(AlaLiveWishListActivity.this.getPageContext().getResources().getString(a.h.create_wish_tips_txt));
                } else if (!UtilHelper.isFastDoubleClick()) {
                    AlaLiveWishListActivity.this.goT.fO(AlaLiveWishListActivity.this.buN);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOo() {
        if (this.gpF) {
            this.gpw.setBackground(getPageContext().getResources().getDrawable(a.e.ala_live_create_wish_bt_bg));
            this.gpw.setEnabled(true);
            return;
        }
        this.gpw.setBackground(getPageContext().getResources().getDrawable(a.e.ala_add_wish_edit_next_bt_bg));
        this.gpw.setEnabled(false);
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
        if (this.gpz != null) {
            this.gpz.onDestroy();
        }
        if (this.goT != null) {
            this.goT.onDestroy();
        }
        if (this.goT != null) {
            this.goT.cmg();
        }
        MessageManager.getInstance().unRegisterListener(this.aWK);
        MessageManager.getInstance().unRegisterListener(this.aWJ);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
        if (this.gpx == null || this.gpx.getCount() >= 2) {
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
                if (this.gpz != null) {
                    this.gpz.cmh();
                }
            } else if (i == 1002 && this.gpz != null) {
                this.gpz.cmh();
            }
        }
    }

    public void bOp() {
        if (this.gpE != null) {
            this.gpE.reset();
            this.gpE.setTitle(a.h.sdk_net_fail_tip_rank);
            this.gpE.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveWishListActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaLiveWishListActivity.this.gpE.setVisibility(8);
                    if (AlaLiveWishListActivity.this.gpz == null) {
                        AlaLiveWishListActivity.this.gpz = new j(AlaLiveWishListActivity.this.getPageContext(), AlaLiveWishListActivity.this.gpG);
                    }
                    AlaLiveWishListActivity.this.gpz.cmh();
                }
            });
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.gpE.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else {
                this.gpE.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.gpE.setVisibility(0);
            this.gpy.setVisibility(8);
            this.gpw.setVisibility(8);
        }
    }
}
