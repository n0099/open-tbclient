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
/* loaded from: classes10.dex */
public class AlaHeadlineActivity extends BaseFragmentActivity {
    private ab aED;
    private CustomMessageListener axL;
    private a bif;
    AlaShowHeadlineView hfB;
    AlaGetHeadlineView hfC;
    ImageView hfD;
    CustomMessageListener hfE;
    RelativeLayout hfF;
    View hfG;
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
                if (alaSdkGetGiftListHttpResponseMessage.HF() != null && alaSdkGetGiftListHttpResponseMessage.HF().size() > 0) {
                    if (AlaHeadlineActivity.this.hfM) {
                        AlaHeadlineActivity.this.hfB.setVisibility(0);
                        AlaHeadlineActivity.this.hfC.setVisibility(8);
                        return;
                    }
                    AlaHeadlineActivity.this.hfB.setVisibility(8);
                    AlaHeadlineActivity.this.hfC.setVisibility(0);
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
        bWS();
        mi(UtilHelper.getRealScreenOrientation(getActivity()) == 2);
    }

    private void initView() {
        this.hfF = (RelativeLayout) findViewById(a.f.root_container);
        this.hfG = findViewById(a.f.headline_dialog);
        this.hfG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaHeadlineActivity.this.finish();
                }
            }
        });
        this.hfL = findViewById(a.f.topBG_click);
        this.hfK = (ImageView) findViewById(a.f.topBG);
        this.hfD = (ImageView) findViewById(a.f.close_dialog);
        this.hfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.finish();
            }
        });
        this.hfB = (AlaShowHeadlineView) findViewById(a.f.show_view);
        ((Button) this.hfB.findViewById(a.f.show_view_get_headline)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String Fv = ac.Fv();
                if (Fv == null || Fv.length() == 0) {
                    AlaHeadlineActivity.this.hfN = true;
                    new e(AlaHeadlineActivity.this.getPageContext(), true).gG(q.Vx());
                    return;
                }
                AlaHeadlineActivity.this.hfB.setVisibility(8);
                AlaHeadlineActivity.this.hfC.setVisibility(0);
            }
        });
        this.hfC = (AlaGetHeadlineView) findViewById(a.f.get_view);
        this.hfC.findViewById(a.f.get_view_back_dialog_click).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaHeadlineActivity.this.hfN = false;
                AlaHeadlineActivity.this.hfB.setVisibility(0);
                AlaHeadlineActivity.this.hfC.setVisibility(8);
            }
        });
        this.hfB.setActivity(getActivity());
        this.hfC.setActivity(getActivity());
        ab abVar = new ab();
        abVar.isHost = getIntent().getBooleanExtra("ala_get_headline_is_host", false);
        this.hfM = abVar.isHost;
        abVar.aJD.userId = getIntent().getLongExtra("ala_get_headline_user_id", 0L);
        abVar.aJD.portrait = getIntent().getStringExtra("ala_get_headline_portrait");
        abVar.aJD.userName = getIntent().getStringExtra("ala_get_headline_userName");
        abVar.aJD.nickName = getIntent().getStringExtra("ala_get_headline_nickName");
        abVar.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_headline_live_id", 0L);
        abVar.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_headline_room_id", 0L);
        abVar.mLiveInfo.appId = getIntent().getStringExtra("ala_get_headline_appId");
        abVar.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_headline_feed_id");
        abVar.aKb = bWR();
        this.otherParams = getIntent().getStringExtra("ala_get_headline_other_params");
        setData(abVar, this.otherParams);
        if (abVar.isHost) {
            ((RelativeLayout.LayoutParams) this.hfD.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds520);
            this.hfB.setVisibility(0);
            this.hfC.setVisibility(8);
        }
    }

    private com.baidu.live.data.q bWR() {
        com.baidu.live.data.q qVar = new com.baidu.live.data.q();
        qVar.aIR = getIntent().getBooleanExtra("ala_get_headline_headline_info_is_open", true);
        qVar.endTime = getIntent().getLongExtra("ala_get_headline_headline_info_end_time", 0L);
        qVar.serverTime = getIntent().getLongExtra("ala_get_headline_headline_info_server_time", 0L);
        qVar.aIS = getIntent().getLongExtra("ala_get_headline_headline_info_init_score", 0L);
        qVar.aIU = getIntent().getLongExtra("ala_get_headline_headline_info_cur_score", 0L);
        qVar.aJc = getIntent().getStringExtra("ala_get_headline_headline_info_support_url");
        qVar.giftName = getIntent().getStringExtra("ala_get_headline_headline_info_gift_name");
        qVar.aIX = getIntent().getStringExtra("ala_get_headline_headline_info_gift_image_url");
        qVar.giftNum = getIntent().getLongExtra("ala_get_headline_headline_info_gift_num", 0L);
        qVar.aIW = getIntent().getLongExtra("ala_get_headline_headline_info_gift_score", 0L);
        qVar.liveId = getIntent().getLongExtra("ala_get_headline_headline_info_live_id", 0L);
        qVar.aIZ = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_head");
        qVar.aJa = getIntent().getStringExtra("ala_get_headline_headline_info_user_head");
        qVar.userName = getIntent().getStringExtra("ala_get_headline_headline_info_user_name");
        qVar.aIY = getIntent().getStringExtra("ala_get_headline_headline_info_anchor_name");
        return qVar;
    }

    public void setData(ab abVar, String str) {
        if (abVar != null && abVar.aKb != null) {
            this.aED = abVar;
            int intExtra = getIntent().getIntExtra("ala_get_headline_current_status", 1);
            if (this.hfJ) {
                if (intExtra == 1) {
                    this.hfB.hfX = 0L;
                    this.hfC.hfX = 0L;
                } else {
                    this.hfB.hfX = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    this.hfC.hfX = getIntent().getLongExtra("ala_get_headline_count_down_time", 0L);
                    if (this.hfB.hfX > 0) {
                        this.hfB.hgX.setText(getString(a.h.sdk_get_headline_timer, new Object[]{this.hfB.hfX + ""}));
                    }
                }
                this.hfJ = false;
            }
            this.hfB.setData(abVar, str);
            this.hfC.setData(abVar, str);
        }
    }

    private void bWS() {
        this.axL = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaHeadlineActivity.this.finish();
            }
        };
        MessageManager.getInstance().registerListener(this.axL);
        if (this.hfE == null) {
            this.hfE = new CustomMessageListener(2913242) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        AlaHeadlineActivity.this.setData((ab) customResponsedMessage.getData(), AlaHeadlineActivity.this.otherParams);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hfE);
        }
        if (this.hfH == null) {
            this.hfH = new CustomMessageListener(2913244) { // from class: com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c)) {
                        if (AlaHeadlineActivity.this.bif == null) {
                            AlaHeadlineActivity.this.bif = new com.baidu.live.an.a(AlaHeadlineActivity.this.getActivity());
                        }
                        AlaHeadlineActivity.this.bif.a((c) customResponsedMessage.getData());
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
                    if (customResponsedMessage.getData() != null && AlaHeadlineActivity.this.hfB != null) {
                        long longValue = ((Long) customResponsedMessage.getData()).longValue();
                        AlaHeadlineActivity.this.hfB.hfX = longValue;
                        AlaHeadlineActivity.this.hfC.hfX = longValue;
                        AlaHeadlineActivity.this.hfB.setData(AlaHeadlineActivity.this.aED, AlaHeadlineActivity.this.otherParams);
                        AlaHeadlineActivity.this.hfC.setData(AlaHeadlineActivity.this.aED, AlaHeadlineActivity.this.otherParams);
                        if (longValue > 0) {
                            AlaHeadlineActivity.this.hfB.hgX.setText(AlaHeadlineActivity.this.getString(a.h.sdk_get_headline_timer, new Object[]{longValue + ""}));
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
        MessageManager.getInstance().unRegisterListener(this.axL);
        MessageManager.getInstance().unRegisterListener(this.hfE);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.hfI);
        MessageManager.getInstance().unRegisterListener(this.hfO);
        if (this.bif != null) {
            this.bif.release();
            this.bif = null;
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
            this.hfD.setVisibility(8);
            this.hfC.hfW.setVisibility(0);
            this.hfB.hhd.setVisibility(0);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hfC.hfW.setVisibility(8);
                this.hfB.hhd.setVisibility(8);
            }
            u(this.hfC, a.d.sdk_ds0);
            u(this.hfB, a.d.sdk_ds0);
            u(this.hfC.hfF, a.d.sdk_ds20);
            u(this.hfB.hgO, a.d.sdk_ds0);
            u(this.hfB.hgP, a.d.sdk_ds20);
            return;
        }
        this.hfK.setVisibility(0);
        this.hfL.setVisibility(0);
        this.hfD.setVisibility(0);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hfD.setVisibility(8);
        }
        this.hfC.hfW.setVisibility(8);
        this.hfB.hhd.setVisibility(8);
        u(this.hfC, a.d.sdk_ds_170);
        u(this.hfB, a.d.sdk_ds_170);
        u(this.hfC.hfF, a.d.sdk_ds122);
        u(this.hfB.hgO, a.d.sdk_ds70);
        u(this.hfB.hgP, a.d.sdk_ds122);
    }

    private void u(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(i);
        view.setLayoutParams(layoutParams);
    }
}
