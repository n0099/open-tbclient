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
import com.baidu.live.ak.a;
import com.baidu.live.ak.c;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.container.e;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.headline.view.AlaGetHeadlineView;
import com.baidu.tieba.ala.headline.view.AlaShowHeadlineView;
/* loaded from: classes4.dex */
public class AlaHeadlineActivity extends BaseFragmentActivity {
    private w aDh;
    private CustomMessageListener ayx;
    AlaGetHeadlineView gKA;
    ImageView gKB;
    CustomMessageListener gKC;
    RelativeLayout gKD;
    View gKE;
    private a gKF;
    private CustomMessageListener gKG;
    private CustomMessageListener gKH;
    ImageView gKJ;
    boolean gKK;
    AlaShowHeadlineView gKz;
    private boolean gKI = true;
    String otherParams = "";
    boolean gKL = false;
    private HttpMessageListener gKM = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.gKL) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.IG() != null && alaSdkGetGiftListHttpResponseMessage.IG().size() > 0) {
                    if (AlaHeadlineActivity.this.gKK) {
                        AlaHeadlineActivity.this.gKz.setVisibility(0);
                        AlaHeadlineActivity.this.gKA.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.gKz.setVisibility(8);
                    AlaHeadlineActivity.this.gKA.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.gKL = false;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.sdk_headline_dialog);
        initView();
        bTD();
        lq(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.gKD = (RelativeLayout) findViewById(a.f.root_container);
        this.gKE = findViewById(a.f.sdk_headline_dialog_bg);
        this.gKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.gKJ = (ImageView) findViewById(a.f.topBG);
        this.gKB = (ImageView) findViewById(a.f.close_dialog);
        this.gKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.gKz = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.gKz.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String GF = aa.GF();
                if (GF == null || GF.length() == 0) {
                    AlaHeadlineActivity.this.gKL = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).hi(p.Ub());
                    return;
                }
                AlaHeadlineActivity.this.gKz.setVisibility(8);
                AlaHeadlineActivity.this.gKA.setVisibility(0);
            }
        });
        this.gKA = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.gKA.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.gKL = false;
                AlaHeadlineActivity.this.gKz.setVisibility(0);
                AlaHeadlineActivity.this.gKA.setVisibility(8);
            }
        });
        this.gKz.setActivity(getActivity());
        this.gKA.setActivity(getActivity());
        w wVar = new w();
        wVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.gKK = wVar.isHost;
        wVar.aHk.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        wVar.aHk.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        wVar.aHk.userName = getIntent().getStringExtra("ala_get_headline_userName");
        wVar.aHk.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        wVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        wVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        wVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        wVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        wVar.aHI = bTC();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(wVar, this.otherParams);
        if (wVar.isHost) {
            ((RelativeLayout.LayoutParams) this.gKB.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.gKz.setVisibility(0);
            this.gKA.setVisibility(8);
        }
        bTB();
    }

    private void bTB() {
        this.gKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gKA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private l bTC() {
        l lVar = new l();
        lVar.aGA = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        lVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        lVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        lVar.aGB = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        lVar.aGD = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        lVar.aGK = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        lVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        lVar.aGG = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        lVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        lVar.aGF = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        lVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        lVar.aGI = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        lVar.aGJ = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        lVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        lVar.aGH = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return lVar;
    }

    public void setData(w wVar, String str) {
        if (wVar != null && wVar.aHI != null) {
            this.aDh = wVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.gKI) {
                if (intExtra == 1) {
                    this.gKz.gKV = 0L;
                    this.gKA.gKV = 0L;
                } else {
                    this.gKz.gKV = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.gKA.gKV = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.gKz.gKV > 0) {
                        this.gKz.gLV.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.gKz.gKV + ""}));
                    }
                }
                this.gKI = false;
            }
            this.gKz.setData(wVar, str);
            this.gKA.setData(wVar, str);
        }
    }

    private void bTD() {
        this.ayx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.ayx);
        if (this.gKC == null) {
            this.gKC = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((w) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gKC);
        }
        if (this.gKG == null) {
            this.gKG = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.gKF == null) {
                            AlaHeadlineActivity.this.gKF = new com.baidu.live.ak.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.gKF.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gKG);
        }
        if (this.gKH == null) {
            this.gKH = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.gKz != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.gKz.gKV = longValue;
                        AlaHeadlineActivity.this.gKA.gKV = longValue;
                        AlaHeadlineActivity.this.gKz.setData(AlaHeadlineActivity.this.aDh, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.gKA.setData(AlaHeadlineActivity.this.aDh, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.gKz.gLV.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gKH);
        }
        MessageManager.getInstance().registerListener(this.gKM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ayx);
        MessageManager.getInstance().unRegisterListener(this.gKC);
        MessageManager.getInstance().unRegisterListener(this.gKG);
        MessageManager.getInstance().unRegisterListener(this.gKH);
        MessageManager.getInstance().unRegisterListener(this.gKM);
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lq(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void lq(boolean z) {
        if (z) {
            this.gKJ.setVisibility(8);
            this.gKB.setVisibility(8);
            this.gKA.gKU.setVisibility(0);
            this.gKz.gMb.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gKA.gKU.setVisibility(8);
                this.gKz.gMb.setVisibility(8);
            }
            r(this.gKA, a.d.sdk_ds0);
            r(this.gKz, a.d.sdk_ds0);
            r(this.gKA.gKD, a.d.sdk_ds20);
            r(this.gKz.gLM, a.d.sdk_ds0);
            r(this.gKz.gLN, a.d.sdk_ds20);
            return;
        }
        this.gKJ.setVisibility(0);
        this.gKB.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gKB.setVisibility(8);
        }
        this.gKA.gKU.setVisibility(8);
        this.gKz.gMb.setVisibility(8);
        r(this.gKA, a.d.sdk_ds_170);
        r(this.gKz, a.d.sdk_ds_170);
        r(this.gKA.gKD, a.d.sdk_ds122);
        r(this.gKz.gLM, a.d.sdk_ds70);
        r(this.gKz.gLN, a.d.sdk_ds122);
    }

    private void r(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
