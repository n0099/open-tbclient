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
/* loaded from: classes11.dex */
public class AlaPokeDialogActivity extends BaseFragmentActivity {
    private ab bxN;
    HeadImageView caZ;
    ImageView hdU;
    TbImageView ifA;
    ImageView ifB;
    TextView ifC;
    TextView ifD;
    TbImageView ifE;
    ImageView ifF;
    g ifI;
    int ifJ;
    TextView ifs;
    RelativeLayout ift;
    TextView ifu;
    TextView ifv;
    TbImageView ifw;
    ImageView ifx;
    TextView ify;
    TextView ifz;
    String otherParams = "";
    String ifG = "";
    private ArrayList<g> ifH = new ArrayList<>();
    boolean fCP = true;
    private HttpMessageListener ifK = new HttpMessageListener(1021228) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021228 && (httpResponsedMessage instanceof AlaPokeBackResponseMessage)) {
                AlaPokeBackResponseMessage alaPokeBackResponseMessage = (AlaPokeBackResponseMessage) httpResponsedMessage;
                if (alaPokeBackResponseMessage.getError() == 0 && alaPokeBackResponseMessage.isSuccess()) {
                    AlaPokeDialogActivity.this.pi(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, true));
                    AlaPokeDialogActivity.this.fCP = false;
                    AlaPokeDialogActivity.this.finish();
                    return;
                }
                AlaPokeDialogActivity.this.fCP = true;
            }
        }
    };
    private CustomMessageListener awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaPokeDialogActivity.this.finish();
        }
    };
    private HttpMessageListener bvv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    TbadkCoreApplication.getInst().currentAccountTdouNum = alaGiftRefreshScoresHttpResponseMessage.Op().mTDouScores;
                }
                long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                g gVar = (g) AlaPokeDialogActivity.this.ifH.get(AlaPokeDialogActivity.this.ifJ);
                AlaPokeDialogActivity.this.ifI = gVar;
                if (j < Long.parseLong(gVar.getPrice())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaPokeDialogActivity.this.getActivity(), 0L, AlaPokeDialogActivity.this.otherParams, true, "", true)));
                    return;
                }
                AlaPokeDialogActivity.this.fCP = false;
                HttpMessage httpMessage = new HttpMessage(1021228);
                httpMessage.addParam(LogConfig.LOG_GIFT_ID, AlaPokeDialogActivity.this.ifJ == 0 ? 0 : gVar.DR());
                httpMessage.addParam("live_id", AlaPokeDialogActivity.this.bxN.mLiveInfo.live_id);
                httpMessage.addParam("charm_user_id", AlaPokeDialogActivity.this.bxN.aId.userId);
                httpMessage.addParam("poke_id", AlaPokeDialogActivity.this.ifG);
                httpMessage.addParam("scene_from", q.Fv());
                MessageManager.getInstance().sendMessage(httpMessage);
                b.Hr().a(gVar, 1L, AlaPokeDialogActivity.this.bxN.aId.userId + "", AlaPokeDialogActivity.this.bxN.aId.userName, AlaPokeDialogActivity.this.bxN.mLiveInfo.live_id + "", AlaPokeDialogActivity.this.bxN.mLiveInfo.room_id + "", AlaPokeDialogActivity.this.bxN.mLiveInfo.appId, AlaPokeDialogActivity.this.bxN.mLiveInfo.feed_id, AlaPokeDialogActivity.this.otherParams, 0L, System.currentTimeMillis());
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
        MessageManager.getInstance().registerListener(this.awl);
        MessageManager.getInstance().registerListener(this.ifK);
        MessageManager.getInstance().registerListener(this.bvv);
        cow();
    }

    private void initView() {
        if (!cov()) {
            finish();
            return;
        }
        this.ift = (RelativeLayout) findViewById(a.f.sdk_poke_dialog);
        this.ift.post(new Runnable() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.1
            @Override // java.lang.Runnable
            public void run() {
                float screenWidth = n.getScreenWidth(AlaPokeDialogActivity.this.getActivity());
                float width = AlaPokeDialogActivity.this.ift.getWidth();
                if (screenWidth < width) {
                    AlaPokeDialogActivity.this.ift.setScaleX(screenWidth / width);
                    AlaPokeDialogActivity.this.ift.setScaleY(screenWidth / width);
                }
            }
        });
        this.hdU = (ImageView) findViewById(a.f.sdk_poke_close_poke);
        this.hdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.finish();
            }
        });
        this.caZ = (HeadImageView) findViewById(a.f.poke_user_head);
        this.ifs = (TextView) findViewById(a.f.sdk_poke_user_title);
        this.ifu = (TextView) findViewById(a.f.poke_free_name);
        this.ifv = (TextView) findViewById(a.f.poke_free_cost);
        this.ifw = (TbImageView) findViewById(a.f.poke_free_img);
        this.ifx = (ImageView) findViewById(a.f.poke_free_button);
        this.ify = (TextView) findViewById(a.f.poke_center_name);
        this.ifz = (TextView) findViewById(a.f.poke_center_cost);
        this.ifA = (TbImageView) findViewById(a.f.poke_center_img);
        this.ifB = (ImageView) findViewById(a.f.poke_center_button);
        this.ifC = (TextView) findViewById(a.f.poke_right_name);
        this.ifD = (TextView) findViewById(a.f.poke_right_cost);
        this.ifE = (TbImageView) findViewById(a.f.poke_right_img);
        this.ifF = (ImageView) findViewById(a.f.poke_right_button);
        cot();
        this.ifx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wz(0);
            }
        });
        this.ifB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wz(1);
            }
        });
        this.ifF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.wz(2);
            }
        });
    }

    private void cot() {
        this.ifs.setText(this.bxN.aId.nickName);
        this.caZ.setDefaultBgResource(a.e.sdk_default_avatar);
        this.caZ.setIsRound(true);
        this.caZ.setAutoChangeStyle(false);
        this.caZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.caZ.startLoad(this.bxN.aId.portrait, 12, false);
        this.ifu.setText(this.ifH.get(0).DS());
        this.ify.setText(this.ifH.get(1).DS());
        this.ifC.setText(this.ifH.get(2).DS());
        this.ifv.setText("免费");
        this.ifz.setText(cou().append((CharSequence) this.ifH.get(1).getPrice()));
        this.ifD.setText(cou().append((CharSequence) this.ifH.get(2).getPrice()));
        this.ifw.startLoad(this.ifH.get(0).getThumbnail_url(), 10, false);
        this.ifA.startLoad(this.ifH.get(1).getThumbnail_url(), 10, false);
        this.ifE.startLoad(this.ifH.get(2).getThumbnail_url(), 10, false);
    }

    private SpannableStringBuilder cou() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getActivity(), BitmapFactory.decodeResource(getResources(), a.e.sdk_icon_huobi_tdou));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
        spannableStringBuilder2.setSpan(centeredImageSpan, 1, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private boolean cov() {
        this.bxN = new ab();
        this.bxN.aId.userId = getIntent().getLongExtra("ala_get_poke_user_id", 0L);
        this.bxN.aId.portrait = getIntent().getStringExtra("ala_get_poke_portrait");
        this.bxN.aId.userName = getIntent().getStringExtra("ala_get_poke_userName");
        this.bxN.aId.nickName = getIntent().getStringExtra("ala_get_poke_nickName");
        this.bxN.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_poke_live_id", 0L);
        this.bxN.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_poke_room_id", 0L);
        this.bxN.mLiveInfo.appId = getIntent().getStringExtra("ala_get_poke_appId");
        this.bxN.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_poke_feed_id");
        this.otherParams = getIntent().getStringExtra("ala_get_poke_other_params");
        if (getIntent().getStringExtra("ala_get_poke_poke_info") == null) {
            finish();
        }
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("ala_get_poke_poke_info"));
            this.ifG = jSONObject.optString("poke_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                g gVar = new g();
                gVar.setPrice(optJSONArray.optJSONObject(i).optString("tdou"));
                gVar.setThumbnailUrl(optJSONArray.optJSONObject(i).optString("pic"));
                gVar.setGiftName(optJSONArray.optJSONObject(i).optString("gift_name"));
                gVar.fQ(optJSONArray.optJSONObject(i).optString(LogConfig.LOG_GIFT_ID));
                if (gVar.getPrice().isEmpty() || gVar.getThumbnail_url().isEmpty() || gVar.DR().isEmpty() || gVar.DS().isEmpty()) {
                    this.ifH.clear();
                    break;
                }
                this.ifH.add(gVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.ifG.isEmpty() || this.ifH.size() < 3) {
            return false;
        }
        Y(this.ifH);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(int i) {
        if (this.ifH.size() >= i && this.fCP) {
            this.ifJ = i;
            HU();
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

    private void cow() {
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
        MessageManager.getInstance().unRegisterListener(this.awl);
        MessageManager.getInstance().unRegisterListener(this.ifK);
        MessageManager.getInstance().unRegisterListener(this.bvv);
        MessageManager.getInstance().unRegisterTask(1021228);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, this.ifI.DR());
            jSONObject.putOpt("gift_name", this.ifI.DS());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, this.ifI.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", z ? UbcStatConstant.Value.VALUE_USER_POKE_BACK_SUCCESS : UbcStatConstant.Value.VALUE_USER_POKE_BACK).setContentExt(this.ifJ == 0 ? "normal" : "pay", null, jSONObject));
    }

    private void HU() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
