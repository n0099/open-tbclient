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
/* loaded from: classes10.dex */
public class AlaHeadlineActivity extends BaseFragmentActivity {
    private x aBr;
    private CustomMessageListener aww;
    AlaShowHeadlineView haU;
    AlaGetHeadlineView haV;
    ImageView haW;
    CustomMessageListener haX;
    RelativeLayout haY;
    View haZ;
    private a hba;
    private CustomMessageListener hbb;
    private CustomMessageListener hbc;
    ImageView hbe;
    View hbf;
    boolean hbg;
    private boolean hbd = true;
    String otherParams = "";
    boolean hbh = false;
    private HttpMessageListener hbi = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.hbh) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.Gm() != null && alaSdkGetGiftListHttpResponseMessage.Gm().size() > 0) {
                    if (AlaHeadlineActivity.this.hbg) {
                        AlaHeadlineActivity.this.haU.setVisibility(0);
                        AlaHeadlineActivity.this.haV.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.haU.setVisibility(8);
                    AlaHeadlineActivity.this.haV.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.hbh = false;
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
        bWb();
        me(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.haY = (RelativeLayout) findViewById(a.f.root_container);
        this.haZ = findViewById(a.f.headline_dialog);
        this.haZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.hbf = findViewById(a.f.topBG_click);
        this.hbe = (ImageView) findViewById(a.f.topBG);
        this.haW = (ImageView) findViewById(a.f.close_dialog);
        this.haW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.haU = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.haU.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Ec = ac.Ec();
                if (Ec == null || Ec.length() == 0) {
                    AlaHeadlineActivity.this.hbh = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).gc(q.TN());
                    return;
                }
                AlaHeadlineActivity.this.haU.setVisibility(8);
                AlaHeadlineActivity.this.haV.setVisibility(0);
            }
        });
        this.haV = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.haV.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.hbh = false;
                AlaHeadlineActivity.this.haU.setVisibility(0);
                AlaHeadlineActivity.this.haV.setVisibility(8);
            }
        });
        this.haU.setActivity(getActivity());
        this.haV.setActivity(getActivity());
        x xVar = new x();
        xVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.hbg = xVar.isHost;
        xVar.aFH.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        xVar.aFH.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        xVar.aFH.userName = getIntent().getStringExtra("ala_get_headline_userName");
        xVar.aFH.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        xVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        xVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        xVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        xVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        xVar.aGf = bWa();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(xVar, this.otherParams);
        if (xVar.isHost) {
            ((RelativeLayout.LayoutParams) this.haW.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.haU.setVisibility(0);
            this.haV.setVisibility(8);
        }
    }

    private m bWa() {
        m mVar = new m();
        mVar.aEV = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        mVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        mVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        mVar.aEW = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        mVar.aEY = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        mVar.aFg = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        mVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        mVar.aFb = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        mVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        mVar.aFa = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        mVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        mVar.aFd = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        mVar.aFe = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        mVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        mVar.aFc = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return mVar;
    }

    public void setData(x xVar, String str) {
        if (xVar != null && xVar.aGf != null) {
            this.aBr = xVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.hbd) {
                if (intExtra == 1) {
                    this.haU.hbr = 0L;
                    this.haV.hbr = 0L;
                } else {
                    this.haU.hbr = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.haV.hbr = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.haU.hbr > 0) {
                        this.haU.hcr.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.haU.hbr + ""}));
                    }
                }
                this.hbd = false;
            }
            this.haU.setData(xVar, str);
            this.haV.setData(xVar, str);
        }
    }

    private void bWb() {
        this.aww = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aww);
        if (this.haX == null) {
            this.haX = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((x) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.haX);
        }
        if (this.hbb == null) {
            this.hbb = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.hba == null) {
                            AlaHeadlineActivity.this.hba = new com.baidu.live.ap.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.hba.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hbb);
        }
        if (this.hbc == null) {
            this.hbc = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.haU != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.haU.hbr = longValue;
                        AlaHeadlineActivity.this.haV.hbr = longValue;
                        AlaHeadlineActivity.this.haU.setData(AlaHeadlineActivity.this.aBr, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.haV.setData(AlaHeadlineActivity.this.aBr, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.haU.hcr.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hbc);
        }
        MessageManager.getInstance().registerListener(this.hbi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aww);
        MessageManager.getInstance().unRegisterListener(this.haX);
        MessageManager.getInstance().unRegisterListener(this.hbb);
        MessageManager.getInstance().unRegisterListener(this.hbc);
        MessageManager.getInstance().unRegisterListener(this.hbi);
        if (this.hba != null) {
            this.hba.release();
            this.hba = null;
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
        me(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void me(boolean z) {
        if (z) {
            this.hbe.setVisibility(8);
            this.hbf.setVisibility(8);
            this.haW.setVisibility(8);
            this.haV.hbq.setVisibility(0);
            this.haU.hcx.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.haV.hbq.setVisibility(8);
                this.haU.hcx.setVisibility(8);
            }
            u(this.haV, a.d.sdk_ds0);
            u(this.haU, a.d.sdk_ds0);
            u(this.haV.haY, a.d.sdk_ds20);
            u(this.haU.hci, a.d.sdk_ds0);
            u(this.haU.hcj, a.d.sdk_ds20);
            return;
        }
        this.hbe.setVisibility(0);
        this.hbf.setVisibility(0);
        this.haW.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.haW.setVisibility(8);
        }
        this.haV.hbq.setVisibility(8);
        this.haU.hcx.setVisibility(8);
        u(this.haV, a.d.sdk_ds_170);
        u(this.haU, a.d.sdk_ds_170);
        u(this.haV.haY, a.d.sdk_ds122);
        u(this.haU.hci, a.d.sdk_ds70);
        u(this.haU.hcj, a.d.sdk_ds122);
    }

    private void u(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
