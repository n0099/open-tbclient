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
    private CustomMessageListener aAi;
    private w aES;
    AlaShowHeadlineView gKS;
    AlaGetHeadlineView gKT;
    ImageView gKU;
    CustomMessageListener gKV;
    RelativeLayout gKW;
    View gKX;
    private a gKY;
    private CustomMessageListener gKZ;
    private CustomMessageListener gLa;
    ImageView gLc;
    boolean gLd;
    private boolean gLb = true;
    String otherParams = "";
    boolean gLe = false;
    private HttpMessageListener gLf = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.gLe) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.Jp() != null && alaSdkGetGiftListHttpResponseMessage.Jp().size() > 0) {
                    if (AlaHeadlineActivity.this.gLd) {
                        AlaHeadlineActivity.this.gKS.setVisibility(0);
                        AlaHeadlineActivity.this.gKT.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.gKS.setVisibility(8);
                    AlaHeadlineActivity.this.gKT.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.gLe = false;
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
        bUk();
        lp(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.gKW = (RelativeLayout) findViewById(a.f.root_container);
        this.gKX = findViewById(a.f.sdk_headline_dialog_bg);
        this.gKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.gLc = (ImageView) findViewById(a.f.topBG);
        this.gKU = (ImageView) findViewById(a.f.close_dialog);
        this.gKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.gKS = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.gKS.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Ho = aa.Ho();
                if (Ho == null || Ho.length() == 0) {
                    AlaHeadlineActivity.this.gLe = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).ho(p.UK());
                    return;
                }
                AlaHeadlineActivity.this.gKS.setVisibility(8);
                AlaHeadlineActivity.this.gKT.setVisibility(0);
            }
        });
        this.gKT = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.gKT.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.gLe = false;
                AlaHeadlineActivity.this.gKS.setVisibility(0);
                AlaHeadlineActivity.this.gKT.setVisibility(8);
            }
        });
        this.gKS.setActivity(getActivity());
        this.gKT.setActivity(getActivity());
        w wVar = new w();
        wVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.gLd = wVar.isHost;
        wVar.aIV.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        wVar.aIV.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        wVar.aIV.userName = getIntent().getStringExtra("ala_get_headline_userName");
        wVar.aIV.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        wVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        wVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        wVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        wVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        wVar.aJt = bUj();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(wVar, this.otherParams);
        if (wVar.isHost) {
            ((RelativeLayout.LayoutParams) this.gKU.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.gKS.setVisibility(0);
            this.gKT.setVisibility(8);
        }
        bUi();
    }

    private void bUi() {
        this.gKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private l bUj() {
        l lVar = new l();
        lVar.aIl = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        lVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        lVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        lVar.aIm = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        lVar.aIo = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        lVar.aIv = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        lVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        lVar.aIr = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        lVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        lVar.aIq = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        lVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        lVar.aIt = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        lVar.aIu = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        lVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        lVar.aIs = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return lVar;
    }

    public void setData(w wVar, String str) {
        if (wVar != null && wVar.aJt != null) {
            this.aES = wVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.gLb) {
                if (intExtra == 1) {
                    this.gKS.gLo = 0L;
                    this.gKT.gLo = 0L;
                } else {
                    this.gKS.gLo = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.gKT.gLo = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.gKS.gLo > 0) {
                        this.gKS.gMo.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.gKS.gLo + ""}));
                    }
                }
                this.gLb = false;
            }
            this.gKS.setData(wVar, str);
            this.gKT.setData(wVar, str);
        }
    }

    private void bUk() {
        this.aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aAi);
        if (this.gKV == null) {
            this.gKV = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((w) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gKV);
        }
        if (this.gKZ == null) {
            this.gKZ = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.gKY == null) {
                            AlaHeadlineActivity.this.gKY = new com.baidu.live.ak.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.gKY.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gKZ);
        }
        if (this.gLa == null) {
            this.gLa = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.gKS != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.gKS.gLo = longValue;
                        AlaHeadlineActivity.this.gKT.gLo = longValue;
                        AlaHeadlineActivity.this.gKS.setData(AlaHeadlineActivity.this.aES, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.gKT.setData(AlaHeadlineActivity.this.aES, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.gKS.gMo.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gLa);
        }
        MessageManager.getInstance().registerListener(this.gLf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAi);
        MessageManager.getInstance().unRegisterListener(this.gKV);
        MessageManager.getInstance().unRegisterListener(this.gKZ);
        MessageManager.getInstance().unRegisterListener(this.gLa);
        MessageManager.getInstance().unRegisterListener(this.gLf);
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
        lp(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void lp(boolean z) {
        if (z) {
            this.gLc.setVisibility(8);
            this.gKU.setVisibility(8);
            this.gKT.gLn.setVisibility(0);
            this.gKS.gMu.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gKT.gLn.setVisibility(8);
                this.gKS.gMu.setVisibility(8);
            }
            o(this.gKT, a.d.sdk_ds0);
            o(this.gKS, a.d.sdk_ds0);
            o(this.gKT.gKW, a.d.sdk_ds20);
            o(this.gKS.gMf, a.d.sdk_ds0);
            o(this.gKS.gMg, a.d.sdk_ds20);
            return;
        }
        this.gLc.setVisibility(0);
        this.gKU.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gKU.setVisibility(8);
        }
        this.gKT.gLn.setVisibility(8);
        this.gKS.gMu.setVisibility(8);
        o(this.gKT, a.d.sdk_ds_170);
        o(this.gKS, a.d.sdk_ds_170);
        o(this.gKT.gKW, a.d.sdk_ds122);
        o(this.gKS.gMf, a.d.sdk_ds70);
        o(this.gKS.gMg, a.d.sdk_ds122);
    }

    private void o(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
