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
import com.baidu.live.ai.a;
import com.baidu.live.ai.c;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
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
    private w aEc;
    AlaShowHeadlineView gFg;
    AlaGetHeadlineView gFh;
    ImageView gFi;
    CustomMessageListener gFj;
    RelativeLayout gFk;
    View gFl;
    private a gFm;
    private CustomMessageListener gFn;
    private CustomMessageListener gFo;
    ImageView gFq;
    boolean gFr;
    private boolean gFp = true;
    String otherParams = "";
    boolean gFs = false;
    private HttpMessageListener gFt = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.gFs) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.IO() != null && alaSdkGetGiftListHttpResponseMessage.IO().size() > 0) {
                    if (AlaHeadlineActivity.this.gFr) {
                        AlaHeadlineActivity.this.gFg.setVisibility(0);
                        AlaHeadlineActivity.this.gFh.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.gFg.setVisibility(8);
                    AlaHeadlineActivity.this.gFh.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.i.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.gFs = false;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.h.sdk_headline_dialog);
        initView();
        bRL();
        lg(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.gFk = (RelativeLayout) findViewById(a.g.root_container);
        this.gFl = findViewById(a.g.sdk_headline_dialog_bg);
        this.gFl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.gFq = (ImageView) findViewById(a.g.topBG);
        this.gFi = (ImageView) findViewById(a.g.close_dialog);
        this.gFi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.gFg = (AlaShowHeadlineView) findViewById(a.g.show_view);
        ((Button) this.gFg.findViewById(a.g.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String GN = ab.GN();
                if (GN == null || GN.length() == 0) {
                    AlaHeadlineActivity.this.gFs = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).hh(p.Sc());
                    return;
                }
                AlaHeadlineActivity.this.gFg.setVisibility(8);
                AlaHeadlineActivity.this.gFh.setVisibility(0);
            }
        });
        this.gFh = (AlaGetHeadlineView) findViewById(a.g.get_view);
        this.gFh.findViewById(a.g.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.gFs = false;
                AlaHeadlineActivity.this.gFg.setVisibility(0);
                AlaHeadlineActivity.this.gFh.setVisibility(8);
            }
        });
        this.gFg.setActivity(getActivity());
        this.gFh.setActivity(getActivity());
        w wVar = new w();
        wVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.gFr = wVar.isHost;
        wVar.aIe.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        wVar.aIe.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        wVar.aIe.userName = getIntent().getStringExtra("ala_get_headline_userName");
        wVar.aIe.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        wVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        wVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        wVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        wVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        wVar.aIC = bRK();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(wVar, this.otherParams);
        if (wVar.isHost) {
            ((RelativeLayout.LayoutParams) this.gFi.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds520);
            this.gFg.setVisibility(0);
            this.gFh.setVisibility(8);
        }
        bRJ();
    }

    private void bRJ() {
        this.gFg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.gFh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private l bRK() {
        l lVar = new l();
        lVar.aHt = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        lVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        lVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        lVar.aHu = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        lVar.aHw = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        lVar.aHE = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        lVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        lVar.aHz = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        lVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        lVar.aHy = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        lVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        lVar.aHC = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        lVar.aHD = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        lVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        lVar.aHA = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return lVar;
    }

    public void setData(w wVar, String str) {
        if (wVar != null && wVar.aIC != null) {
            this.aEc = wVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.gFp) {
                if (intExtra == 1) {
                    this.gFg.gFC = 0L;
                    this.gFh.gFC = 0L;
                } else {
                    this.gFg.gFC = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.gFh.gFC = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.gFg.gFC > 0) {
                        this.gFg.gGC.setText(getString(a.i.sdk_get_headline_timer, new Object[]{this.gFg.gFC + ""}));
                    }
                }
                this.gFp = false;
            }
            this.gFg.setData(wVar, str);
            this.gFh.setData(wVar, str);
        }
    }

    private void bRL() {
        this.aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.aAi);
        if (this.gFj == null) {
            this.gFj = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.12
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((w) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gFj);
        }
        if (this.gFn == null) {
            this.gFn = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.gFm == null) {
                            AlaHeadlineActivity.this.gFm = new com.baidu.live.ai.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.gFm.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gFn);
        }
        if (this.gFo == null) {
            this.gFo = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.gFg != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.gFg.gFC = longValue;
                        AlaHeadlineActivity.this.gFh.gFC = longValue;
                        AlaHeadlineActivity.this.gFg.setData(AlaHeadlineActivity.this.aEc, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.gFh.setData(AlaHeadlineActivity.this.aEc, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.gFg.gGC.setText(AlaHeadlineActivity.this.getString(a.i.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gFo);
        }
        MessageManager.getInstance().registerListener(this.gFt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAi);
        MessageManager.getInstance().unRegisterListener(this.gFj);
        MessageManager.getInstance().unRegisterListener(this.gFn);
        MessageManager.getInstance().unRegisterListener(this.gFo);
        MessageManager.getInstance().unRegisterListener(this.gFt);
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
        lg(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void lg(boolean z) {
        if (z) {
            this.gFq.setVisibility(8);
            this.gFi.setVisibility(8);
            this.gFh.gFB.setVisibility(0);
            this.gFg.gGI.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFh.gFB.setVisibility(8);
                this.gFg.gGI.setVisibility(8);
            }
            o(this.gFh, a.e.sdk_ds0);
            o(this.gFg, a.e.sdk_ds0);
            o(this.gFh.gFk, a.e.sdk_ds20);
            o(this.gFg.gGt, a.e.sdk_ds0);
            o(this.gFg.gGu, a.e.sdk_ds20);
            return;
        }
        this.gFq.setVisibility(0);
        this.gFi.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gFi.setVisibility(8);
        }
        this.gFh.gFB.setVisibility(8);
        this.gFg.gGI.setVisibility(8);
        o(this.gFh, a.e.sdk_ds_170);
        o(this.gFg, a.e.sdk_ds_170);
        o(this.gFh.gFk, a.e.sdk_ds122);
        o(this.gFg.gGt, a.e.sdk_ds70);
        o(this.gFg.gGu, a.e.sdk_ds122);
    }

    private void o(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
