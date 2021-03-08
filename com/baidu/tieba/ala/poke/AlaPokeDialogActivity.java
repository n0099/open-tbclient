package com.baidu.tieba.ala.poke;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.data.ab;
import com.baidu.live.gift.c.b;
import com.baidu.live.gift.g;
import com.baidu.live.gift.n;
import com.baidu.live.message.AlaGiftRefreshScoresHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaPokeDialogActivity extends BaseFragmentActivity {
    private ab bzn;
    HeadImageView ccB;
    ImageView hfD;
    TextView ihb;
    RelativeLayout ihc;
    TextView ihd;
    TextView ihe;
    TbImageView ihf;
    ImageView ihg;
    TextView ihh;
    TextView ihi;
    TbImageView ihj;
    ImageView ihk;
    TextView ihl;
    TextView ihm;
    TbImageView ihn;
    ImageView iho;
    g ihr;
    int ihs;
    String otherParams = "";
    String ihp = "";
    private ArrayList<g> ihq = new ArrayList<>();
    boolean fEo = true;
    private HttpMessageListener iht = new HttpMessageListener(1021228) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021228 && (httpResponsedMessage instanceof AlaPokeBackResponseMessage)) {
                AlaPokeBackResponseMessage alaPokeBackResponseMessage = (AlaPokeBackResponseMessage) httpResponsedMessage;
                if (alaPokeBackResponseMessage.getError() == 0 && alaPokeBackResponseMessage.isSuccess()) {
                    AlaPokeDialogActivity.this.pi(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, true));
                    AlaPokeDialogActivity.this.fEo = false;
                    AlaPokeDialogActivity.this.finish();
                    return;
                }
                AlaPokeDialogActivity.this.fEo = true;
            }
        }
    };
    private CustomMessageListener axL = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaPokeDialogActivity.this.finish();
        }
    };
    private HttpMessageListener bwV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    TbadkCoreApplication.getInst().currentAccountTdouNum = alaGiftRefreshScoresHttpResponseMessage.Os().mTDouScores;
                }
                long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                g gVar = (g) AlaPokeDialogActivity.this.ihq.get(AlaPokeDialogActivity.this.ihs);
                AlaPokeDialogActivity.this.ihr = gVar;
                if (j < Long.parseLong(gVar.getPrice())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaPokeDialogActivity.this.getActivity(), 0L, AlaPokeDialogActivity.this.otherParams, true, "", true)));
                    return;
                }
                AlaPokeDialogActivity.this.fEo = false;
                HttpMessage httpMessage = new HttpMessage(1021228);
                httpMessage.addParam(LogConfig.LOG_GIFT_ID, AlaPokeDialogActivity.this.ihs == 0 ? 0 : gVar.DU());
                httpMessage.addParam("live_id", AlaPokeDialogActivity.this.bzn.mLiveInfo.live_id);
                httpMessage.addParam("charm_user_id", AlaPokeDialogActivity.this.bzn.aJD.userId);
                httpMessage.addParam("poke_id", AlaPokeDialogActivity.this.ihp);
                httpMessage.addParam("scene_from", q.Fy());
                MessageManager.getInstance().sendMessage(httpMessage);
                b.Hu().a(gVar, 1L, AlaPokeDialogActivity.this.bzn.aJD.userId + "", AlaPokeDialogActivity.this.bzn.aJD.userName, AlaPokeDialogActivity.this.bzn.mLiveInfo.live_id + "", AlaPokeDialogActivity.this.bzn.mLiveInfo.room_id + "", AlaPokeDialogActivity.this.bzn.mLiveInfo.appId, AlaPokeDialogActivity.this.bzn.mLiveInfo.feed_id, AlaPokeDialogActivity.this.otherParams, 0L, System.currentTimeMillis());
                AlaPokeDialogActivity.this.pi(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.ala_poke_dialog_activity);
        initView();
        MessageManager.getInstance().registerListener(this.axL);
        MessageManager.getInstance().registerListener(this.iht);
        MessageManager.getInstance().registerListener(this.bwV);
        coC();
    }

    private void initView() {
        if (!coB()) {
            finish();
            return;
        }
        this.ihc = (RelativeLayout) findViewById(a.f.sdk_poke_dialog);
        this.ihc.post(new Runnable() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.1
            @Override // java.lang.Runnable
            public void run() {
                float screenWidth = n.getScreenWidth(AlaPokeDialogActivity.this.getActivity());
                float width = AlaPokeDialogActivity.this.ihc.getWidth();
                if (screenWidth < width) {
                    AlaPokeDialogActivity.this.ihc.setScaleX(screenWidth / width);
                    AlaPokeDialogActivity.this.ihc.setScaleY(screenWidth / width);
                }
            }
        });
        this.hfD = (ImageView) findViewById(a.f.sdk_poke_close_poke);
        this.hfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.finish();
            }
        });
        this.ccB = (HeadImageView) findViewById(a.f.poke_user_head);
        this.ihb = (TextView) findViewById(a.f.sdk_poke_user_title);
        this.ihd = (TextView) findViewById(a.f.poke_free_name);
        this.ihe = (TextView) findViewById(a.f.poke_free_cost);
        this.ihf = (TbImageView) findViewById(a.f.poke_free_img);
        this.ihg = (ImageView) findViewById(a.f.poke_free_button);
        this.ihh = (TextView) findViewById(a.f.poke_center_name);
        this.ihi = (TextView) findViewById(a.f.poke_center_cost);
        this.ihj = (TbImageView) findViewById(a.f.poke_center_img);
        this.ihk = (ImageView) findViewById(a.f.poke_center_button);
        this.ihl = (TextView) findViewById(a.f.poke_right_name);
        this.ihm = (TextView) findViewById(a.f.poke_right_cost);
        this.ihn = (TbImageView) findViewById(a.f.poke_right_img);
        this.iho = (ImageView) findViewById(a.f.poke_right_button);
        coz();
        this.ihg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wA(0);
            }
        });
        this.ihk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wA(1);
            }
        });
        this.iho.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wA(2);
            }
        });
    }

    private void coz() {
        this.ihb.setText(this.bzn.aJD.nickName);
        this.ccB.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ccB.setIsRound(true);
        this.ccB.setAutoChangeStyle(false);
        this.ccB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ccB.startLoad(this.bzn.aJD.portrait, 12, false);
        this.ihd.setText(this.ihq.get(0).DV());
        this.ihh.setText(this.ihq.get(1).DV());
        this.ihl.setText(this.ihq.get(2).DV());
        this.ihe.setText("免费");
        this.ihi.setText(coA().append((CharSequence) this.ihq.get(1).getPrice()));
        this.ihm.setText(coA().append((CharSequence) this.ihq.get(2).getPrice()));
        this.ihf.startLoad(this.ihq.get(0).getThumbnail_url(), 10, false);
        this.ihj.startLoad(this.ihq.get(1).getThumbnail_url(), 10, false);
        this.ihn.startLoad(this.ihq.get(2).getThumbnail_url(), 10, false);
    }

    private SpannableStringBuilder coA() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getActivity(), BitmapFactory.decodeResource(getResources(), a.e.sdk_icon_huobi_tdou));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
        spannableStringBuilder2.setSpan(centeredImageSpan, 1, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private boolean coB() {
        this.bzn = new ab();
        this.bzn.aJD.userId = getIntent().getLongExtra("ala_get_poke_user_id", 0L);
        this.bzn.aJD.portrait = getIntent().getStringExtra("ala_get_poke_portrait");
        this.bzn.aJD.userName = getIntent().getStringExtra("ala_get_poke_userName");
        this.bzn.aJD.nickName = getIntent().getStringExtra("ala_get_poke_nickName");
        this.bzn.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_poke_live_id", 0L);
        this.bzn.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_poke_room_id", 0L);
        this.bzn.mLiveInfo.appId = getIntent().getStringExtra("ala_get_poke_appId");
        this.bzn.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_poke_feed_id");
        this.otherParams = getIntent().getStringExtra("ala_get_poke_other_params");
        if (getIntent().getStringExtra("ala_get_poke_poke_info") == null) {
            finish();
        }
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("ala_get_poke_poke_info"));
            this.ihp = jSONObject.optString("poke_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                g gVar = new g();
                gVar.setPrice(optJSONArray.optJSONObject(i).optString("tdou"));
                gVar.setThumbnailUrl(optJSONArray.optJSONObject(i).optString("pic"));
                gVar.setGiftName(optJSONArray.optJSONObject(i).optString("gift_name"));
                gVar.fW(optJSONArray.optJSONObject(i).optString(LogConfig.LOG_GIFT_ID));
                if (gVar.getPrice().isEmpty() || gVar.getThumbnail_url().isEmpty() || gVar.DU().isEmpty() || gVar.DV().isEmpty()) {
                    this.ihq.clear();
                    break;
                }
                this.ihq.add(gVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.ihp.isEmpty() || this.ihq.size() < 3) {
            return false;
        }
        Y(this.ihq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(int i) {
        if (this.ihq.size() >= i && this.fEo) {
            this.ihs = i;
            HX();
        }
    }

    private void Y(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = Long.parseLong(gVar.getPrice()) - Long.parseLong(gVar2.getPrice());
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
                return 0;
            }
        });
    }

    private void coC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021228, TbConfig.SERVER_ADDRESS + "/ala/live/pokeBack");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AlaPokeBackResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axL);
        MessageManager.getInstance().unRegisterListener(this.iht);
        MessageManager.getInstance().unRegisterListener(this.bwV);
        MessageManager.getInstance().unRegisterTask(1021228);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, this.ihr.DU());
            jSONObject.putOpt("gift_name", this.ihr.DV());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, this.ihr.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", z ? UbcStatConstant.Value.VALUE_USER_POKE_BACK_SUCCESS : UbcStatConstant.Value.VALUE_USER_POKE_BACK).setContentExt(this.ihs == 0 ? "normal" : "pay", null, jSONObject));
    }

    private void HX() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
