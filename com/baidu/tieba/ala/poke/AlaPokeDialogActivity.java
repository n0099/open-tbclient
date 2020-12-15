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
import com.baidu.live.data.w;
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
import com.baidu.live.utils.p;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaPokeDialogActivity extends BaseFragmentActivity {
    HeadImageView bki;
    private w bur;
    ImageView gTP;
    TextView hSR;
    RelativeLayout hSS;
    TextView hST;
    TextView hSU;
    TbImageView hSV;
    ImageView hSW;
    TextView hSX;
    TextView hSY;
    TbImageView hSZ;
    ImageView hTa;
    TextView hTb;
    TextView hTc;
    TbImageView hTd;
    ImageView hTe;
    g hTh;
    int hTi;
    String otherParams = "";
    String hTf = "";
    private ArrayList<g> hTg = new ArrayList<>();
    boolean fvC = true;
    private HttpMessageListener hTj = new HttpMessageListener(1021228) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021228 && (httpResponsedMessage instanceof AlaPokeBackResponseMessage)) {
                AlaPokeBackResponseMessage alaPokeBackResponseMessage = (AlaPokeBackResponseMessage) httpResponsedMessage;
                if (alaPokeBackResponseMessage.getError() == 0 && alaPokeBackResponseMessage.isSuccess()) {
                    AlaPokeDialogActivity.this.oD(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, true));
                    AlaPokeDialogActivity.this.fvC = false;
                    AlaPokeDialogActivity.this.finish();
                    return;
                }
                AlaPokeDialogActivity.this.fvC = true;
            }
        }
    };
    private CustomMessageListener aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaPokeDialogActivity.this.finish();
        }
    };
    private HttpMessageListener brZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    TbadkCoreApplication.getInst().currentAccountTdouNum = alaGiftRefreshScoresHttpResponseMessage.PO().mTDouScores;
                }
                long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                g gVar = (g) AlaPokeDialogActivity.this.hTg.get(AlaPokeDialogActivity.this.hTi);
                AlaPokeDialogActivity.this.hTh = gVar;
                if (j < Long.parseLong(gVar.getPrice())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaPokeDialogActivity.this.getActivity(), 0L, AlaPokeDialogActivity.this.otherParams, true, "", true)));
                    return;
                }
                AlaPokeDialogActivity.this.fvC = false;
                HttpMessage httpMessage = new HttpMessage(1021228);
                httpMessage.addParam(LogConfig.LOG_GIFT_ID, AlaPokeDialogActivity.this.hTi == 0 ? 0 : gVar.GX());
                httpMessage.addParam("live_id", AlaPokeDialogActivity.this.bur.mLiveInfo.live_id);
                httpMessage.addParam("charm_user_id", AlaPokeDialogActivity.this.bur.aJV.userId);
                httpMessage.addParam("poke_id", AlaPokeDialogActivity.this.hTf);
                httpMessage.addParam("scene_from", p.Iz());
                MessageManager.getInstance().sendMessage(httpMessage);
                b.Kv().a(gVar, 1L, AlaPokeDialogActivity.this.bur.aJV.userId + "", AlaPokeDialogActivity.this.bur.aJV.userName, AlaPokeDialogActivity.this.bur.mLiveInfo.live_id + "", AlaPokeDialogActivity.this.bur.mLiveInfo.room_id + "", AlaPokeDialogActivity.this.bur.mLiveInfo.appId, AlaPokeDialogActivity.this.bur.mLiveInfo.feed_id, AlaPokeDialogActivity.this.otherParams, 0L, System.currentTimeMillis());
                AlaPokeDialogActivity.this.oD(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        setContentView(a.g.ala_poke_dialog_activity);
        initView();
        MessageManager.getInstance().registerListener(this.aAS);
        MessageManager.getInstance().registerListener(this.hTj);
        MessageManager.getInstance().registerListener(this.brZ);
        coq();
    }

    private void initView() {
        if (!cop()) {
            finish();
            return;
        }
        this.hSS = (RelativeLayout) findViewById(a.f.sdk_poke_dialog);
        this.hSS.post(new Runnable() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.1
            @Override // java.lang.Runnable
            public void run() {
                float screenWidth = n.getScreenWidth(AlaPokeDialogActivity.this.getActivity());
                float width = AlaPokeDialogActivity.this.hSS.getWidth();
                if (screenWidth < width) {
                    AlaPokeDialogActivity.this.hSS.setScaleX(screenWidth / width);
                    AlaPokeDialogActivity.this.hSS.setScaleY(screenWidth / width);
                }
            }
        });
        this.gTP = (ImageView) findViewById(a.f.sdk_poke_close_poke);
        this.gTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.finish();
            }
        });
        this.bki = (HeadImageView) findViewById(a.f.poke_user_head);
        this.hSR = (TextView) findViewById(a.f.sdk_poke_user_title);
        this.hST = (TextView) findViewById(a.f.poke_free_name);
        this.hSU = (TextView) findViewById(a.f.poke_free_cost);
        this.hSV = (TbImageView) findViewById(a.f.poke_free_img);
        this.hSW = (ImageView) findViewById(a.f.poke_free_button);
        this.hSX = (TextView) findViewById(a.f.poke_center_name);
        this.hSY = (TextView) findViewById(a.f.poke_center_cost);
        this.hSZ = (TbImageView) findViewById(a.f.poke_center_img);
        this.hTa = (ImageView) findViewById(a.f.poke_center_button);
        this.hTb = (TextView) findViewById(a.f.poke_right_name);
        this.hTc = (TextView) findViewById(a.f.poke_right_cost);
        this.hTd = (TbImageView) findViewById(a.f.poke_right_img);
        this.hTe = (ImageView) findViewById(a.f.poke_right_button);
        con();
        this.hSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xH(0);
            }
        });
        this.hTa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xH(1);
            }
        });
        this.hTe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xH(2);
            }
        });
    }

    private void con() {
        this.hSR.setText(this.bur.aJV.nickName);
        this.bki.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bki.setIsRound(true);
        this.bki.setAutoChangeStyle(false);
        this.bki.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bki.startLoad(this.bur.aJV.portrait, 12, false);
        this.hST.setText(this.hTg.get(0).GY());
        this.hSX.setText(this.hTg.get(1).GY());
        this.hTb.setText(this.hTg.get(2).GY());
        this.hSU.setText("免费");
        this.hSY.setText(coo().append((CharSequence) this.hTg.get(1).getPrice()));
        this.hTc.setText(coo().append((CharSequence) this.hTg.get(2).getPrice()));
        this.hSV.startLoad(this.hTg.get(0).getThumbnail_url(), 10, false);
        this.hSZ.startLoad(this.hTg.get(1).getThumbnail_url(), 10, false);
        this.hTd.startLoad(this.hTg.get(2).getThumbnail_url(), 10, false);
    }

    private SpannableStringBuilder coo() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getActivity(), BitmapFactory.decodeResource(getResources(), a.e.sdk_icon_huobi_tdou));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
        spannableStringBuilder2.setSpan(centeredImageSpan, 1, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private boolean cop() {
        this.bur = new w();
        this.bur.aJV.userId = getIntent().getLongExtra("ala_get_poke_user_id", 0L);
        this.bur.aJV.portrait = getIntent().getStringExtra("ala_get_poke_portrait");
        this.bur.aJV.userName = getIntent().getStringExtra("ala_get_poke_userName");
        this.bur.aJV.nickName = getIntent().getStringExtra("ala_get_poke_nickName");
        this.bur.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_poke_live_id", 0L);
        this.bur.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_poke_room_id", 0L);
        this.bur.mLiveInfo.appId = getIntent().getStringExtra("ala_get_poke_appId");
        this.bur.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_poke_feed_id");
        this.otherParams = getIntent().getStringExtra("ala_get_poke_other_params");
        if (getIntent().getStringExtra("ala_get_poke_poke_info") == null) {
            finish();
        }
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("ala_get_poke_poke_info"));
            this.hTf = jSONObject.optString("poke_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                g gVar = new g();
                gVar.setPrice(optJSONArray.optJSONObject(i).optString("tdou"));
                gVar.setThumbnailUrl(optJSONArray.optJSONObject(i).optString(UgcUBCUtils.UGC_TYPE_PIC_BTN));
                gVar.setGiftName(optJSONArray.optJSONObject(i).optString("gift_name"));
                gVar.gW(optJSONArray.optJSONObject(i).optString(LogConfig.LOG_GIFT_ID));
                if (gVar.getPrice().isEmpty() || gVar.getThumbnail_url().isEmpty() || gVar.GX().isEmpty() || gVar.GY().isEmpty()) {
                    this.hTg.clear();
                    break;
                }
                this.hTg.add(gVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.hTf.isEmpty() || this.hTg.size() < 3) {
            return false;
        }
        ae(this.hTg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(int i) {
        if (this.hTg.size() >= i && this.fvC) {
            this.hTi = i;
            KZ();
        }
    }

    private void ae(ArrayList<g> arrayList) {
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

    private void coq() {
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
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAS);
        MessageManager.getInstance().unRegisterListener(this.hTj);
        MessageManager.getInstance().unRegisterListener(this.brZ);
        MessageManager.getInstance().unRegisterTask(1021228);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oD(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, this.hTh.GX());
            jSONObject.putOpt("gift_name", this.hTh.GY());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, this.hTh.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", z ? UbcStatConstant.Value.VALUE_USER_POKE_BACK_SUCCESS : UbcStatConstant.Value.VALUE_USER_POKE_BACK).setContentExt(this.hTi == 0 ? "normal" : "pay", null, jSONObject));
    }

    private void KZ() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
