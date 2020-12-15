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
import com.baidu.live.ao.a;
import com.baidu.live.ao.c;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
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
    private CustomMessageListener aAS;
    private w aFN;
    AlaShowHeadlineView gTN;
    AlaGetHeadlineView gTO;
    ImageView gTP;
    CustomMessageListener gTQ;
    RelativeLayout gTR;
    View gTS;
    private a gTT;
    private CustomMessageListener gTU;
    private CustomMessageListener gTV;
    ImageView gTX;
    View gTY;
    boolean gTZ;
    private boolean gTW = true;
    String otherParams = "";
    boolean gUa = false;
    private HttpMessageListener gUb = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.gUa) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.KG() != null && alaSdkGetGiftListHttpResponseMessage.KG().size() > 0) {
                    if (AlaHeadlineActivity.this.gTZ) {
                        AlaHeadlineActivity.this.gTN.setVisibility(0);
                        AlaHeadlineActivity.this.gTO.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.gTN.setVisibility(8);
                    AlaHeadlineActivity.this.gTO.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.gUa = false;
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
        bXn();
        lL(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.gTR = (RelativeLayout) findViewById(a.f.root_container);
        this.gTS = findViewById(a.f.headline_dialog);
        this.gTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.gTY = findViewById(a.f.topBG_click);
        this.gTX = (ImageView) findViewById(a.f.topBG);
        this.gTP = (ImageView) findViewById(a.f.close_dialog);
        this.gTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.gTN = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.gTN.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Iw = ac.Iw();
                if (Iw == null || Iw.length() == 0) {
                    AlaHeadlineActivity.this.gUa = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).hD(p.WB());
                    return;
                }
                AlaHeadlineActivity.this.gTN.setVisibility(8);
                AlaHeadlineActivity.this.gTO.setVisibility(0);
            }
        });
        this.gTO = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.gTO.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.gUa = false;
                AlaHeadlineActivity.this.gTN.setVisibility(0);
                AlaHeadlineActivity.this.gTO.setVisibility(8);
            }
        });
        this.gTN.setActivity(getActivity());
        this.gTO.setActivity(getActivity());
        w wVar = new w();
        wVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.gTZ = wVar.isHost;
        wVar.aJV.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        wVar.aJV.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        wVar.aJV.userName = getIntent().getStringExtra("ala_get_headline_userName");
        wVar.aJV.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        wVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        wVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        wVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        wVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        wVar.aKt = bXm();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(wVar, this.otherParams);
        if (wVar.isHost) {
            ((RelativeLayout.LayoutParams) this.gTP.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.gTN.setVisibility(0);
            this.gTO.setVisibility(8);
        }
    }

    private l bXm() {
        l lVar = new l();
        lVar.aJk = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        lVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        lVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        lVar.aJl = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        lVar.aJn = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        lVar.aJu = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        lVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        lVar.aJq = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        lVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        lVar.aJp = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        lVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        lVar.aJs = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        lVar.aJt = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        lVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        lVar.aJr = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return lVar;
    }

    public void setData(w wVar, String str) {
        if (wVar != null && wVar.aKt != null) {
            this.aFN = wVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.gTW) {
                if (intExtra == 1) {
                    this.gTN.gUk = 0L;
                    this.gTO.gUk = 0L;
                } else {
                    this.gTN.gUk = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.gTO.gUk = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.gTN.gUk > 0) {
                        this.gTN.gVk.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.gTN.gUk + ""}));
                    }
                }
                this.gTW = false;
            }
            this.gTN.setData(wVar, str);
            this.gTO.setData(wVar, str);
        }
    }

    private void bXn() {
        this.aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aAS);
        if (this.gTQ == null) {
            this.gTQ = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((w) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTQ);
        }
        if (this.gTU == null) {
            this.gTU = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.gTT == null) {
                            AlaHeadlineActivity.this.gTT = new com.baidu.live.ao.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.gTT.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTU);
        }
        if (this.gTV == null) {
            this.gTV = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.gTN != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.gTN.gUk = longValue;
                        AlaHeadlineActivity.this.gTO.gUk = longValue;
                        AlaHeadlineActivity.this.gTN.setData(AlaHeadlineActivity.this.aFN, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.gTO.setData(AlaHeadlineActivity.this.aFN, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.gTN.gVk.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTV);
        }
        MessageManager.getInstance().registerListener(this.gUb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAS);
        MessageManager.getInstance().unRegisterListener(this.gTQ);
        MessageManager.getInstance().unRegisterListener(this.gTU);
        MessageManager.getInstance().unRegisterListener(this.gTV);
        MessageManager.getInstance().unRegisterListener(this.gUb);
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
        lL(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void lL(boolean z) {
        if (z) {
            this.gTX.setVisibility(8);
            this.gTY.setVisibility(8);
            this.gTP.setVisibility(8);
            this.gTO.gUj.setVisibility(0);
            this.gTN.gVq.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gTO.gUj.setVisibility(8);
                this.gTN.gVq.setVisibility(8);
            }
            r(this.gTO, a.d.sdk_ds0);
            r(this.gTN, a.d.sdk_ds0);
            r(this.gTO.gTR, a.d.sdk_ds20);
            r(this.gTN.gVb, a.d.sdk_ds0);
            r(this.gTN.gVc, a.d.sdk_ds20);
            return;
        }
        this.gTX.setVisibility(0);
        this.gTY.setVisibility(0);
        this.gTP.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTP.setVisibility(8);
        }
        this.gTO.gUj.setVisibility(8);
        this.gTN.gVq.setVisibility(8);
        r(this.gTO, a.d.sdk_ds_170);
        r(this.gTN, a.d.sdk_ds_170);
        r(this.gTO.gTR, a.d.sdk_ds122);
        r(this.gTN.gVb, a.d.sdk_ds70);
        r(this.gTN.gVc, a.d.sdk_ds122);
    }

    private void r(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
