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
import com.baidu.live.data.x;
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
    HeadImageView bWX;
    private x buq;
    ImageView haW;
    TextView iaG;
    RelativeLayout iaH;
    TextView iaI;
    TextView iaJ;
    TbImageView iaK;
    ImageView iaL;
    TextView iaM;
    TextView iaN;
    TbImageView iaO;
    ImageView iaP;
    TextView iaQ;
    TextView iaR;
    TbImageView iaS;
    ImageView iaT;
    g iaW;
    int iaX;
    String otherParams = "";
    String iaU = "";
    private ArrayList<g> iaV = new ArrayList<>();
    boolean fAA = true;
    private HttpMessageListener iaY = new HttpMessageListener(1021228) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021228 && (httpResponsedMessage instanceof AlaPokeBackResponseMessage)) {
                AlaPokeBackResponseMessage alaPokeBackResponseMessage = (AlaPokeBackResponseMessage) httpResponsedMessage;
                if (alaPokeBackResponseMessage.getError() == 0 && alaPokeBackResponseMessage.isSuccess()) {
                    AlaPokeDialogActivity.this.oY(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, true));
                    AlaPokeDialogActivity.this.fAA = false;
                    AlaPokeDialogActivity.this.finish();
                    return;
                }
                AlaPokeDialogActivity.this.fAA = true;
            }
        }
    };
    private CustomMessageListener aww = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaPokeDialogActivity.this.finish();
        }
    };
    private HttpMessageListener brT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    TbadkCoreApplication.getInst().currentAccountTdouNum = alaGiftRefreshScoresHttpResponseMessage.MR().mTDouScores;
                }
                long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                g gVar = (g) AlaPokeDialogActivity.this.iaV.get(AlaPokeDialogActivity.this.iaX);
                AlaPokeDialogActivity.this.iaW = gVar;
                if (j < Long.parseLong(gVar.getPrice())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaPokeDialogActivity.this.getActivity(), 0L, AlaPokeDialogActivity.this.otherParams, true, "", true)));
                    return;
                }
                AlaPokeDialogActivity.this.fAA = false;
                HttpMessage httpMessage = new HttpMessage(1021228);
                httpMessage.addParam(LogConfig.LOG_GIFT_ID, AlaPokeDialogActivity.this.iaX == 0 ? 0 : gVar.CC());
                httpMessage.addParam("live_id", AlaPokeDialogActivity.this.buq.mLiveInfo.live_id);
                httpMessage.addParam("charm_user_id", AlaPokeDialogActivity.this.buq.aFH.userId);
                httpMessage.addParam("poke_id", AlaPokeDialogActivity.this.iaU);
                httpMessage.addParam("scene_from", q.Ef());
                MessageManager.getInstance().sendMessage(httpMessage);
                b.Gb().a(gVar, 1L, AlaPokeDialogActivity.this.buq.aFH.userId + "", AlaPokeDialogActivity.this.buq.aFH.userName, AlaPokeDialogActivity.this.buq.mLiveInfo.live_id + "", AlaPokeDialogActivity.this.buq.mLiveInfo.room_id + "", AlaPokeDialogActivity.this.buq.mLiveInfo.appId, AlaPokeDialogActivity.this.buq.mLiveInfo.feed_id, AlaPokeDialogActivity.this.otherParams, 0L, System.currentTimeMillis());
                AlaPokeDialogActivity.this.oY(false);
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
        MessageManager.getInstance().registerListener(this.aww);
        MessageManager.getInstance().registerListener(this.iaY);
        MessageManager.getInstance().registerListener(this.brT);
        cnr();
    }

    private void initView() {
        if (!cnq()) {
            finish();
            return;
        }
        this.iaH = (RelativeLayout) findViewById(a.f.sdk_poke_dialog);
        this.iaH.post(new Runnable() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.1
            @Override // java.lang.Runnable
            public void run() {
                float screenWidth = n.getScreenWidth(AlaPokeDialogActivity.this.getActivity());
                float width = AlaPokeDialogActivity.this.iaH.getWidth();
                if (screenWidth < width) {
                    AlaPokeDialogActivity.this.iaH.setScaleX(screenWidth / width);
                    AlaPokeDialogActivity.this.iaH.setScaleY(screenWidth / width);
                }
            }
        });
        this.haW = (ImageView) findViewById(a.f.sdk_poke_close_poke);
        this.haW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.finish();
            }
        });
        this.bWX = (HeadImageView) findViewById(a.f.poke_user_head);
        this.iaG = (TextView) findViewById(a.f.sdk_poke_user_title);
        this.iaI = (TextView) findViewById(a.f.poke_free_name);
        this.iaJ = (TextView) findViewById(a.f.poke_free_cost);
        this.iaK = (TbImageView) findViewById(a.f.poke_free_img);
        this.iaL = (ImageView) findViewById(a.f.poke_free_button);
        this.iaM = (TextView) findViewById(a.f.poke_center_name);
        this.iaN = (TextView) findViewById(a.f.poke_center_cost);
        this.iaO = (TbImageView) findViewById(a.f.poke_center_img);
        this.iaP = (ImageView) findViewById(a.f.poke_center_button);
        this.iaQ = (TextView) findViewById(a.f.poke_right_name);
        this.iaR = (TextView) findViewById(a.f.poke_right_cost);
        this.iaS = (TbImageView) findViewById(a.f.poke_right_img);
        this.iaT = (ImageView) findViewById(a.f.poke_right_button);
        cno();
        this.iaL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wo(0);
            }
        });
        this.iaP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wo(1);
            }
        });
        this.iaT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wo(2);
            }
        });
    }

    private void cno() {
        this.iaG.setText(this.buq.aFH.nickName);
        this.bWX.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bWX.setIsRound(true);
        this.bWX.setAutoChangeStyle(false);
        this.bWX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bWX.startLoad(this.buq.aFH.portrait, 12, false);
        this.iaI.setText(this.iaV.get(0).CD());
        this.iaM.setText(this.iaV.get(1).CD());
        this.iaQ.setText(this.iaV.get(2).CD());
        this.iaJ.setText("免费");
        this.iaN.setText(cnp().append((CharSequence) this.iaV.get(1).getPrice()));
        this.iaR.setText(cnp().append((CharSequence) this.iaV.get(2).getPrice()));
        this.iaK.startLoad(this.iaV.get(0).getThumbnail_url(), 10, false);
        this.iaO.startLoad(this.iaV.get(1).getThumbnail_url(), 10, false);
        this.iaS.startLoad(this.iaV.get(2).getThumbnail_url(), 10, false);
    }

    private SpannableStringBuilder cnp() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getActivity(), BitmapFactory.decodeResource(getResources(), a.e.sdk_icon_huobi_tdou));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
        spannableStringBuilder2.setSpan(centeredImageSpan, 1, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private boolean cnq() {
        this.buq = new x();
        this.buq.aFH.userId = getIntent().getLongExtra("ala_get_poke_user_id", 0L);
        this.buq.aFH.portrait = getIntent().getStringExtra("ala_get_poke_portrait");
        this.buq.aFH.userName = getIntent().getStringExtra("ala_get_poke_userName");
        this.buq.aFH.nickName = getIntent().getStringExtra("ala_get_poke_nickName");
        this.buq.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_poke_live_id", 0L);
        this.buq.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_poke_room_id", 0L);
        this.buq.mLiveInfo.appId = getIntent().getStringExtra("ala_get_poke_appId");
        this.buq.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_poke_feed_id");
        this.otherParams = getIntent().getStringExtra("ala_get_poke_other_params");
        if (getIntent().getStringExtra("ala_get_poke_poke_info") == null) {
            finish();
        }
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("ala_get_poke_poke_info"));
            this.iaU = jSONObject.optString("poke_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                g gVar = new g();
                gVar.setPrice(optJSONArray.optJSONObject(i).optString("tdou"));
                gVar.setThumbnailUrl(optJSONArray.optJSONObject(i).optString("pic"));
                gVar.setGiftName(optJSONArray.optJSONObject(i).optString("gift_name"));
                gVar.fv(optJSONArray.optJSONObject(i).optString(LogConfig.LOG_GIFT_ID));
                if (gVar.getPrice().isEmpty() || gVar.getThumbnail_url().isEmpty() || gVar.CC().isEmpty() || gVar.CD().isEmpty()) {
                    this.iaV.clear();
                    break;
                }
                this.iaV.add(gVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iaU.isEmpty() || this.iaV.size() < 3) {
            return false;
        }
        Z(this.iaV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo(int i) {
        if (this.iaV.size() >= i && this.fAA) {
            this.iaX = i;
            GE();
        }
    }

    private void Z(ArrayList<g> arrayList) {
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

    private void cnr() {
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
        MessageManager.getInstance().unRegisterListener(this.aww);
        MessageManager.getInstance().unRegisterListener(this.iaY);
        MessageManager.getInstance().unRegisterListener(this.brT);
        MessageManager.getInstance().unRegisterTask(1021228);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, this.iaW.CC());
            jSONObject.putOpt("gift_name", this.iaW.CD());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, this.iaW.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", z ? UbcStatConstant.Value.VALUE_USER_POKE_BACK_SUCCESS : UbcStatConstant.Value.VALUE_USER_POKE_BACK).setContentExt(this.iaX == 0 ? "normal" : "pay", null, jSONObject));
    }

    private void GE() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
