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
    AlaShowHeadlineView hdS;
    AlaGetHeadlineView hdT;
    ImageView hdU;
    CustomMessageListener hdV;
    RelativeLayout hdW;
    View hdX;
    private CustomMessageListener hdY;
    private CustomMessageListener hdZ;
    ImageView heb;
    View hec;
    boolean hed;
    private boolean hea = true;
    String otherParams = "";
    boolean hee = false;
    private HttpMessageListener hef = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && AlaHeadlineActivity.this.hee) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.HC() != null && alaSdkGetGiftListHttpResponseMessage.HC().size() > 0) {
                    if (AlaHeadlineActivity.this.hed) {
                        AlaHeadlineActivity.this.hdS.setVisibility(0);
                        AlaHeadlineActivity.this.hdT.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.hdS.setVisibility(8);
                    AlaHeadlineActivity.this.hdT.setVisibility(0);
                    return;
                }
                BdUtilHelper.showToast(AlaHeadlineActivity.this.getActivity(), AlaHeadlineActivity.this.getResources().getString(a.h.sdk_get_headline_none_gift_tip));
                AlaHeadlineActivity.this.hee = false;
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
        bWM();
        mi(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.hdW = (RelativeLayout) findViewById(a.f.root_container);
        this.hdX = findViewById(a.f.headline_dialog);
        this.hdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.hec = findViewById(a.f.topBG_click);
        this.heb = (ImageView) findViewById(a.f.topBG);
        this.hdU = (ImageView) findViewById(a.f.close_dialog);
        this.hdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.hdS = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.hdS.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Fs = ac.Fs();
                if (Fs == null || Fs.length() == 0) {
                    AlaHeadlineActivity.this.hee = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).gA(q.Vu());
                    return;
                }
                AlaHeadlineActivity.this.hdS.setVisibility(8);
                AlaHeadlineActivity.this.hdT.setVisibility(0);
            }
        });
        this.hdT = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.hdT.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.hee = false;
                AlaHeadlineActivity.this.hdS.setVisibility(0);
                AlaHeadlineActivity.this.hdT.setVisibility(8);
            }
        });
        this.hdS.setActivity(getActivity());
        this.hdT.setActivity(getActivity());
        ab abVar = new ab();
        abVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.hed = abVar.isHost;
        abVar.aId.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        abVar.aId.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        abVar.aId.userName = getIntent().getStringExtra("ala_get_headline_userName");
        abVar.aId.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        abVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        abVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        abVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        abVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        abVar.aIB = bWL();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(abVar, this.otherParams);
        if (abVar.isHost) {
            ((RelativeLayout.LayoutParams) this.hdU.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.hdS.setVisibility(0);
            this.hdT.setVisibility(8);
        }
    }

    private com.baidu.live.data.q bWL() {
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
            if (this.hea) {
                if (intExtra == 1) {
                    this.hdS.heo = 0L;
                    this.hdT.heo = 0L;
                } else {
                    this.hdS.heo = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.hdT.heo = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.hdS.heo > 0) {
                        this.hdS.hfo.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.hdS.heo + ""}));
                    }
                }
                this.hea = false;
            }
            this.hdS.setData(abVar, str);
            this.hdT.setData(abVar, str);
        }
    }

    private void bWM() {
        this.awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.awl);
        if (this.hdV == null) {
            this.hdV = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((ab) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hdV);
        }
        if (this.hdY == null) {
            this.hdY = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
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
            MessageManager.getInstance().registerListener(this.hdY);
        }
        if (this.hdZ == null) {
            this.hdZ = new CustomMessageListener(2913245) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.hdS != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.hdS.heo = longValue;
                        AlaHeadlineActivity.this.hdT.heo = longValue;
                        AlaHeadlineActivity.this.hdS.setData(AlaHeadlineActivity.this.aDd, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.hdT.setData(AlaHeadlineActivity.this.aDd, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.hdS.hfo.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hdZ);
        }
        MessageManager.getInstance().registerListener(this.hef);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.awl);
        MessageManager.getInstance().unRegisterListener(this.hdV);
        MessageManager.getInstance().unRegisterListener(this.hdY);
        MessageManager.getInstance().unRegisterListener(this.hdZ);
        MessageManager.getInstance().unRegisterListener(this.hef);
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
            this.heb.setVisibility(8);
            this.hec.setVisibility(8);
            this.hdU.setVisibility(8);
            this.hdT.hen.setVisibility(0);
            this.hdS.hfu.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hdT.hen.setVisibility(8);
                this.hdS.hfu.setVisibility(8);
            }
            u(this.hdT, a.d.sdk_ds0);
            u(this.hdS, a.d.sdk_ds0);
            u(this.hdT.hdW, a.d.sdk_ds20);
            u(this.hdS.hff, a.d.sdk_ds0);
            u(this.hdS.hfg, a.d.sdk_ds20);
            return;
        }
        this.heb.setVisibility(0);
        this.hec.setVisibility(0);
        this.hdU.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hdU.setVisibility(8);
        }
        this.hdT.hen.setVisibility(8);
        this.hdS.hfu.setVisibility(8);
        u(this.hdT, a.d.sdk_ds_170);
        u(this.hdS, a.d.sdk_ds_170);
        u(this.hdT.hdW, a.d.sdk_ds122);
        u(this.hdS.hff, a.d.sdk_ds70);
        u(this.hdS.hfg, a.d.sdk_ds122);
    }

    private void u(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
