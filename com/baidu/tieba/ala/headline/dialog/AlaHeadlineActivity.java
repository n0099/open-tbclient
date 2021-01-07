package com.baidu.tieba.ala.headline.dialog;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ap.a;
import com.baidu.live.ap.c;
import com.baidu.live.data.m;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.container.e;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.headline.view.AlaGetHeadlineView;
import com.baidu.tieba.ala.headline.view.AlaShowHeadlineView;
/* loaded from: classes11.dex */
public class AlaHeadlineActivity extends BaseFragmentActivity {
    private CustomMessageListener aBj;
    private x aGe;
    AlaShowHeadlineView hfA;
    AlaGetHeadlineView hfB;
    ImageView hfC;
    CustomMessageListener hfD;
    RelativeLayout hfE;
    View hfF;
    private a hfG;
    private CustomMessageListener hfH;
    private CustomMessageListener hfI;
    ImageView hfK;
    View hfL;
    boolean hfM;
    private boolean hfJ = true;
    String otherParams = "";
    boolean hfN = false;
    private HttpMessageListener hfO = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.hfN) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.Kh() != null && alaSdkGetGiftListHttpResponseMessage.Kh().size() > 0) {
                    if (AlaHeadlineActivity.this.hfM) {
                        AlaHeadlineActivity.this.hfA.setVisibility(0);
                        AlaHeadlineActivity.this.hfB.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.hfA.setVisibility(8);
                    AlaHeadlineActivity.this.hfB.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.hfN = false;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.sdk_headline_dialog);
        initView();
        bZT();
        mi(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.hfE = (RelativeLayout) findViewById(a.f.root_container);
        this.hfF = findViewById(a.f.headline_dialog);
        this.hfF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.hfL = findViewById(a.f.topBG_click);
        this.hfK = (ImageView) findViewById(a.f.topBG);
        this.hfC = (ImageView) findViewById(a.f.close_dialog);
        this.hfC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.hfA = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.hfA.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String HX = ac.HX();
                if (HX == null || HX.length() == 0) {
                    AlaHeadlineActivity.this.hfN = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).ho(q.XG());
                    return;
                }
                AlaHeadlineActivity.this.hfA.setVisibility(8);
                AlaHeadlineActivity.this.hfB.setVisibility(0);
            }
        });
        this.hfB = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.hfB.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.hfN = false;
                AlaHeadlineActivity.this.hfA.setVisibility(0);
                AlaHeadlineActivity.this.hfB.setVisibility(8);
            }
        });
        this.hfA.setActivity(getActivity());
        this.hfB.setActivity(getActivity());
        x xVar = new x();
        xVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.hfM = xVar.isHost;
        xVar.aKu.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        xVar.aKu.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        xVar.aKu.userName = getIntent().getStringExtra("ala_get_headline_userName");
        xVar.aKu.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        xVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        xVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        xVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        xVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        xVar.aKS = bZS();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(xVar, this.otherParams);
        if (xVar.isHost) {
            ((RelativeLayout.LayoutParams) this.hfC.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.hfA.setVisibility(0);
            this.hfB.setVisibility(8);
        }
    }

    private m bZS() {
        m mVar = new m();
        mVar.aJI = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        mVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        mVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        mVar.aJJ = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        mVar.aJL = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        mVar.aJT = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        mVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        mVar.aJO = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        mVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        mVar.aJN = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        mVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        mVar.aJQ = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        mVar.aJR = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        mVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        mVar.aJP = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return mVar;
    }

    public void setData(x xVar, String str) {
        if (xVar != null && xVar.aKS != null) {
            this.aGe = xVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.hfJ) {
                if (intExtra == 1) {
                    this.hfA.hfX = 0L;
                    this.hfB.hfX = 0L;
                } else {
                    this.hfA.hfX = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.hfB.hfX = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.hfA.hfX > 0) {
                        this.hfA.hgX.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.hfA.hfX + ""}));
                    }
                }
                this.hfJ = false;
            }
            this.hfA.setData(xVar, str);
            this.hfB.setData(xVar, str);
        }
    }

    private void bZT() {
        this.aBj = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aBj);
        if (this.hfD == null) {
            this.hfD = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((x) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hfD);
        }
        if (this.hfH == null) {
            this.hfH = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.hfG == null) {
                            AlaHeadlineActivity.this.hfG = new com.baidu.live.ap.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.hfG.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hfH);
        }
        if (this.hfI == null) {
            this.hfI = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.hfA != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.hfA.hfX = longValue;
                        AlaHeadlineActivity.this.hfB.hfX = longValue;
                        AlaHeadlineActivity.this.hfA.setData(AlaHeadlineActivity.this.aGe, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.hfB.setData(AlaHeadlineActivity.this.aGe, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.hfA.hgX.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hfI);
        }
        MessageManager.getInstance().registerListener(this.hfO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBj);
        MessageManager.getInstance().unRegisterListener(this.hfD);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.hfI);
        MessageManager.getInstance().unRegisterListener(this.hfO);
        if (this.hfG != null) {
            this.hfG.release();
            this.hfG = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mi(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void mi(boolean z) {
        if (z) {
            this.hfK.setVisibility(8);
            this.hfL.setVisibility(8);
            this.hfC.setVisibility(8);
            this.hfB.hfW.setVisibility(0);
            this.hfA.hhd.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hfB.hfW.setVisibility(8);
                this.hfA.hhd.setVisibility(8);
            }
            u(this.hfB, a.d.sdk_ds0);
            u(this.hfA, a.d.sdk_ds0);
            u(this.hfB.hfE, a.d.sdk_ds20);
            u(this.hfA.hgO, a.d.sdk_ds0);
            u(this.hfA.hgP, a.d.sdk_ds20);
            return;
        }
        this.hfK.setVisibility(0);
        this.hfL.setVisibility(0);
        this.hfC.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hfC.setVisibility(8);
        }
        this.hfB.hfW.setVisibility(8);
        this.hfA.hhd.setVisibility(8);
        u(this.hfB, a.d.sdk_ds_170);
        u(this.hfA, a.d.sdk_ds_170);
        u(this.hfB.hfE, a.d.sdk_ds122);
        u(this.hfA.hgO, a.d.sdk_ds70);
        u(this.hfA.hgP, a.d.sdk_ds122);
    }

    private void u(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
