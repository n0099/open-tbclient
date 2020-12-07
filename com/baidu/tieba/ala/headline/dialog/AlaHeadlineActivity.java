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
    AlaShowHeadlineView gTL;
    AlaGetHeadlineView gTM;
    ImageView gTN;
    CustomMessageListener gTO;
    RelativeLayout gTP;
    View gTQ;
    private a gTR;
    private CustomMessageListener gTS;
    private CustomMessageListener gTT;
    ImageView gTV;
    View gTW;
    boolean gTX;
    private boolean gTU = true;
    String otherParams = "";
    boolean gTY = false;
    private HttpMessageListener gTZ = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.gTY) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.KG() != null && alaSdkGetGiftListHttpResponseMessage.KG().size() > 0) {
                    if (AlaHeadlineActivity.this.gTX) {
                        AlaHeadlineActivity.this.gTL.setVisibility(0);
                        AlaHeadlineActivity.this.gTM.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.gTL.setVisibility(8);
                    AlaHeadlineActivity.this.gTM.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.gTY = false;
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
        bXm();
        lL(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.gTP = (RelativeLayout) findViewById(a.f.root_container);
        this.gTQ = findViewById(a.f.headline_dialog);
        this.gTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.gTW = findViewById(a.f.topBG_click);
        this.gTV = (ImageView) findViewById(a.f.topBG);
        this.gTN = (ImageView) findViewById(a.f.close_dialog);
        this.gTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.gTL = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.gTL.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Iw = ac.Iw();
                if (Iw == null || Iw.length() == 0) {
                    AlaHeadlineActivity.this.gTY = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).hD(p.WB());
                    return;
                }
                AlaHeadlineActivity.this.gTL.setVisibility(8);
                AlaHeadlineActivity.this.gTM.setVisibility(0);
            }
        });
        this.gTM = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.gTM.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.gTY = false;
                AlaHeadlineActivity.this.gTL.setVisibility(0);
                AlaHeadlineActivity.this.gTM.setVisibility(8);
            }
        });
        this.gTL.setActivity(getActivity());
        this.gTM.setActivity(getActivity());
        w wVar = new w();
        wVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.gTX = wVar.isHost;
        wVar.aJV.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        wVar.aJV.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        wVar.aJV.userName = getIntent().getStringExtra("ala_get_headline_userName");
        wVar.aJV.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        wVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        wVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        wVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        wVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        wVar.aKt = bXl();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(wVar, this.otherParams);
        if (wVar.isHost) {
            ((RelativeLayout.LayoutParams) this.gTN.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.gTL.setVisibility(0);
            this.gTM.setVisibility(8);
        }
    }

    private l bXl() {
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
            if (this.gTU) {
                if (intExtra == 1) {
                    this.gTL.gUi = 0L;
                    this.gTM.gUi = 0L;
                } else {
                    this.gTL.gUi = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.gTM.gUi = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.gTL.gUi > 0) {
                        this.gTL.gVi.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.gTL.gUi + ""}));
                    }
                }
                this.gTU = false;
            }
            this.gTL.setData(wVar, str);
            this.gTM.setData(wVar, str);
        }
    }

    private void bXm() {
        this.aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aAS);
        if (this.gTO == null) {
            this.gTO = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((w) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTO);
        }
        if (this.gTS == null) {
            this.gTS = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.gTR == null) {
                            AlaHeadlineActivity.this.gTR = new com.baidu.live.ao.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.gTR.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTS);
        }
        if (this.gTT == null) {
            this.gTT = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.gTL != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.gTL.gUi = longValue;
                        AlaHeadlineActivity.this.gTM.gUi = longValue;
                        AlaHeadlineActivity.this.gTL.setData(AlaHeadlineActivity.this.aFN, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.gTM.setData(AlaHeadlineActivity.this.aFN, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.gTL.gVi.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gTT);
        }
        MessageManager.getInstance().registerListener(this.gTZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAS);
        MessageManager.getInstance().unRegisterListener(this.gTO);
        MessageManager.getInstance().unRegisterListener(this.gTS);
        MessageManager.getInstance().unRegisterListener(this.gTT);
        MessageManager.getInstance().unRegisterListener(this.gTZ);
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
            this.gTV.setVisibility(8);
            this.gTW.setVisibility(8);
            this.gTN.setVisibility(8);
            this.gTM.gUh.setVisibility(0);
            this.gTL.gVo.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gTM.gUh.setVisibility(8);
                this.gTL.gVo.setVisibility(8);
            }
            r(this.gTM, a.d.sdk_ds0);
            r(this.gTL, a.d.sdk_ds0);
            r(this.gTM.gTP, a.d.sdk_ds20);
            r(this.gTL.gUZ, a.d.sdk_ds0);
            r(this.gTL.gVa, a.d.sdk_ds20);
            return;
        }
        this.gTV.setVisibility(0);
        this.gTW.setVisibility(0);
        this.gTN.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTN.setVisibility(8);
        }
        this.gTM.gUh.setVisibility(8);
        this.gTL.gVo.setVisibility(8);
        r(this.gTM, a.d.sdk_ds_170);
        r(this.gTL, a.d.sdk_ds_170);
        r(this.gTM.gTP, a.d.sdk_ds122);
        r(this.gTL.gUZ, a.d.sdk_ds70);
        r(this.gTL.gVa, a.d.sdk_ds122);
    }

    private void r(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
