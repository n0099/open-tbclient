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
import com.baidu.live.an.a;
import com.baidu.live.an.c;
import com.baidu.live.data.ab;
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
    private ab aDd;
    private CustomMessageListener awl;
    private a bgE;
    AlaShowHeadlineView hdE;
    AlaGetHeadlineView hdF;
    ImageView hdG;
    CustomMessageListener hdH;
    RelativeLayout hdI;
    View hdJ;
    private CustomMessageListener hdK;
    private CustomMessageListener hdL;
    ImageView hdN;
    View hdO;
    boolean hdP;
    private boolean hdM = true;
    String otherParams = "";
    boolean hdQ = false;
    private HttpMessageListener hdR = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.hdQ) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.HC() != null && alaSdkGetGiftListHttpResponseMessage.HC().size() > 0) {
                    if (AlaHeadlineActivity.this.hdP) {
                        AlaHeadlineActivity.this.hdE.setVisibility(0);
                        AlaHeadlineActivity.this.hdF.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.hdE.setVisibility(8);
                    AlaHeadlineActivity.this.hdF.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.hdQ = false;
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
        bWF();
        mi(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.hdI = (RelativeLayout) findViewById(a.f.root_container);
        this.hdJ = findViewById(a.f.headline_dialog);
        this.hdJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.hdO = findViewById(a.f.topBG_click);
        this.hdN = (ImageView) findViewById(a.f.topBG);
        this.hdG = (ImageView) findViewById(a.f.close_dialog);
        this.hdG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.hdE = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.hdE.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Fs = ac.Fs();
                if (Fs == null || Fs.length() == 0) {
                    AlaHeadlineActivity.this.hdQ = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).gA(q.Vu());
                    return;
                }
                AlaHeadlineActivity.this.hdE.setVisibility(8);
                AlaHeadlineActivity.this.hdF.setVisibility(0);
            }
        });
        this.hdF = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.hdF.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.hdQ = false;
                AlaHeadlineActivity.this.hdE.setVisibility(0);
                AlaHeadlineActivity.this.hdF.setVisibility(8);
            }
        });
        this.hdE.setActivity(getActivity());
        this.hdF.setActivity(getActivity());
        ab abVar = new ab();
        abVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.hdP = abVar.isHost;
        abVar.aId.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        abVar.aId.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        abVar.aId.userName = getIntent().getStringExtra("ala_get_headline_userName");
        abVar.aId.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        abVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        abVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        abVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        abVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        abVar.aIB = bWE();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(abVar, this.otherParams);
        if (abVar.isHost) {
            ((RelativeLayout.LayoutParams) this.hdG.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.hdE.setVisibility(0);
            this.hdF.setVisibility(8);
        }
    }

    private com.baidu.live.data.q bWE() {
        com.baidu.live.data.q qVar = new com.baidu.live.data.q();
        qVar.aHr = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        qVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        qVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        qVar.aHs = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        qVar.aHu = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        qVar.aHC = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        qVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        qVar.aHx = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        qVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        qVar.aHw = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        qVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        qVar.aHz = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        qVar.aHA = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        qVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        qVar.aHy = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return qVar;
    }

    public void setData(ab abVar, String str) {
        if (abVar != null && abVar.aIB != null) {
            this.aDd = abVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.hdM) {
                if (intExtra == 1) {
                    this.hdE.hea = 0L;
                    this.hdF.hea = 0L;
                } else {
                    this.hdE.hea = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.hdF.hea = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.hdE.hea > 0) {
                        this.hdE.hfa.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.hdE.hea + ""}));
                    }
                }
                this.hdM = false;
            }
            this.hdE.setData(abVar, str);
            this.hdF.setData(abVar, str);
        }
    }

    private void bWF() {
        this.awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.awl);
        if (this.hdH == null) {
            this.hdH = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((ab) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hdH);
        }
        if (this.hdK == null) {
            this.hdK = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.bgE == null) {
                            AlaHeadlineActivity.this.bgE = new com.baidu.live.an.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.bgE.a((c) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hdK);
        }
        if (this.hdL == null) {
            this.hdL = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.hdE != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.hdE.hea = longValue;
                        AlaHeadlineActivity.this.hdF.hea = longValue;
                        AlaHeadlineActivity.this.hdE.setData(AlaHeadlineActivity.this.aDd, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.hdF.setData(AlaHeadlineActivity.this.aDd, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.hdE.hfa.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hdL);
        }
        MessageManager.getInstance().registerListener(this.hdR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.awl);
        MessageManager.getInstance().unRegisterListener(this.hdH);
        MessageManager.getInstance().unRegisterListener(this.hdK);
        MessageManager.getInstance().unRegisterListener(this.hdL);
        MessageManager.getInstance().unRegisterListener(this.hdR);
        if (this.bgE != null) {
            this.bgE.release();
            this.bgE = null;
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
            this.hdN.setVisibility(8);
            this.hdO.setVisibility(8);
            this.hdG.setVisibility(8);
            this.hdF.hdZ.setVisibility(0);
            this.hdE.hfg.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hdF.hdZ.setVisibility(8);
                this.hdE.hfg.setVisibility(8);
            }
            u(this.hdF, a.d.sdk_ds0);
            u(this.hdE, a.d.sdk_ds0);
            u(this.hdF.hdI, a.d.sdk_ds20);
            u(this.hdE.heR, a.d.sdk_ds0);
            u(this.hdE.heS, a.d.sdk_ds20);
            return;
        }
        this.hdN.setVisibility(0);
        this.hdO.setVisibility(0);
        this.hdG.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hdG.setVisibility(8);
        }
        this.hdF.hdZ.setVisibility(8);
        this.hdE.hfg.setVisibility(8);
        u(this.hdF, a.d.sdk_ds_170);
        u(this.hdE, a.d.sdk_ds_170);
        u(this.hdF.hdI, a.d.sdk_ds122);
        u(this.hdE.heR, a.d.sdk_ds70);
        u(this.hdE.heS, a.d.sdk_ds122);
    }

    private void u(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
