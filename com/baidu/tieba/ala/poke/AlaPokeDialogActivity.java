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
/* loaded from: classes11.dex */
public class AlaPokeDialogActivity extends BaseFragmentActivity {
    private x bzc;
    HeadImageView cbK;
    ImageView hfC;
    ImageView ifA;
    TextView ifB;
    TextView ifC;
    TbImageView ifD;
    ImageView ifE;
    g ifH;
    int ifI;
    TextView ifr;
    RelativeLayout ifs;
    TextView ift;
    TextView ifu;
    TbImageView ifv;
    ImageView ifw;
    TextView ifx;
    TextView ify;
    TbImageView ifz;
    String otherParams = "";
    String ifF = "";
    private ArrayList<g> ifG = new ArrayList<>();
    boolean fFi = true;
    private HttpMessageListener ifJ = new HttpMessageListener(1021228) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021228 && (httpResponsedMessage instanceof AlaPokeBackResponseMessage)) {
                AlaPokeBackResponseMessage alaPokeBackResponseMessage = (AlaPokeBackResponseMessage) httpResponsedMessage;
                if (alaPokeBackResponseMessage.getError() == 0 && alaPokeBackResponseMessage.isSuccess()) {
                    AlaPokeDialogActivity.this.pc(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913263, true));
                    AlaPokeDialogActivity.this.fFi = false;
                    AlaPokeDialogActivity.this.finish();
                    return;
                }
                AlaPokeDialogActivity.this.fFi = true;
            }
        }
    };
    private CustomMessageListener aBj = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaPokeDialogActivity.this.finish();
        }
    };
    private HttpMessageListener bwH = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES) { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGiftRefreshScoresHttpResponseMessage)) {
                AlaGiftRefreshScoresHttpResponseMessage alaGiftRefreshScoresHttpResponseMessage = (AlaGiftRefreshScoresHttpResponseMessage) httpResponsedMessage;
                if (alaGiftRefreshScoresHttpResponseMessage.getError() == 0) {
                    TbadkCoreApplication.getInst().currentAccountTdouNum = alaGiftRefreshScoresHttpResponseMessage.QM().mTDouScores;
                }
                long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                g gVar = (g) AlaPokeDialogActivity.this.ifG.get(AlaPokeDialogActivity.this.ifI);
                AlaPokeDialogActivity.this.ifH = gVar;
                if (j < Long.parseLong(gVar.getPrice())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaPokeDialogActivity.this.getActivity(), 0L, AlaPokeDialogActivity.this.otherParams, true, "", true)));
                    return;
                }
                AlaPokeDialogActivity.this.fFi = false;
                HttpMessage httpMessage = new HttpMessage(1021228);
                httpMessage.addParam(LogConfig.LOG_GIFT_ID, AlaPokeDialogActivity.this.ifI == 0 ? 0 : gVar.Gx());
                httpMessage.addParam("live_id", AlaPokeDialogActivity.this.bzc.mLiveInfo.live_id);
                httpMessage.addParam("charm_user_id", AlaPokeDialogActivity.this.bzc.aKu.userId);
                httpMessage.addParam("poke_id", AlaPokeDialogActivity.this.ifF);
                httpMessage.addParam("scene_from", q.Ia());
                MessageManager.getInstance().sendMessage(httpMessage);
                b.JW().a(gVar, 1L, AlaPokeDialogActivity.this.bzc.aKu.userId + "", AlaPokeDialogActivity.this.bzc.aKu.userName, AlaPokeDialogActivity.this.bzc.mLiveInfo.live_id + "", AlaPokeDialogActivity.this.bzc.mLiveInfo.room_id + "", AlaPokeDialogActivity.this.bzc.mLiveInfo.appId, AlaPokeDialogActivity.this.bzc.mLiveInfo.feed_id, AlaPokeDialogActivity.this.otherParams, 0L, System.currentTimeMillis());
                AlaPokeDialogActivity.this.pc(false);
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
        MessageManager.getInstance().registerListener(this.aBj);
        MessageManager.getInstance().registerListener(this.ifJ);
        MessageManager.getInstance().registerListener(this.bwH);
        crj();
    }

    private void initView() {
        if (!cri()) {
            finish();
            return;
        }
        this.ifs = (RelativeLayout) findViewById(a.f.sdk_poke_dialog);
        this.ifs.post(new Runnable() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.1
            @Override // java.lang.Runnable
            public void run() {
                float screenWidth = n.getScreenWidth(AlaPokeDialogActivity.this.getActivity());
                float width = AlaPokeDialogActivity.this.ifs.getWidth();
                if (screenWidth < width) {
                    AlaPokeDialogActivity.this.ifs.setScaleX(screenWidth / width);
                    AlaPokeDialogActivity.this.ifs.setScaleY(screenWidth / width);
                }
            }
        });
        this.hfC = (ImageView) findViewById(a.f.sdk_poke_close_poke);
        this.hfC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.finish();
            }
        });
        this.cbK = (HeadImageView) findViewById(a.f.poke_user_head);
        this.ifr = (TextView) findViewById(a.f.sdk_poke_user_title);
        this.ift = (TextView) findViewById(a.f.poke_free_name);
        this.ifu = (TextView) findViewById(a.f.poke_free_cost);
        this.ifv = (TbImageView) findViewById(a.f.poke_free_img);
        this.ifw = (ImageView) findViewById(a.f.poke_free_button);
        this.ifx = (TextView) findViewById(a.f.poke_center_name);
        this.ify = (TextView) findViewById(a.f.poke_center_cost);
        this.ifz = (TbImageView) findViewById(a.f.poke_center_img);
        this.ifA = (ImageView) findViewById(a.f.poke_center_button);
        this.ifB = (TextView) findViewById(a.f.poke_right_name);
        this.ifC = (TextView) findViewById(a.f.poke_right_cost);
        this.ifD = (TbImageView) findViewById(a.f.poke_right_img);
        this.ifE = (ImageView) findViewById(a.f.poke_right_button);
        crg();
        this.ifw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xU(0);
            }
        });
        this.ifA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xU(1);
            }
        });
        this.ifE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.poke.AlaPokeDialogActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPokeDialogActivity.this.xU(2);
            }
        });
    }

    private void crg() {
        this.ifr.setText(this.bzc.aKu.nickName);
        this.cbK.setDefaultBgResource(a.e.sdk_default_avatar);
        this.cbK.setIsRound(true);
        this.cbK.setAutoChangeStyle(false);
        this.cbK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbK.startLoad(this.bzc.aKu.portrait, 12, false);
        this.ift.setText(this.ifG.get(0).Gy());
        this.ifx.setText(this.ifG.get(1).Gy());
        this.ifB.setText(this.ifG.get(2).Gy());
        this.ifu.setText("免费");
        this.ify.setText(crh().append((CharSequence) this.ifG.get(1).getPrice()));
        this.ifC.setText(crh().append((CharSequence) this.ifG.get(2).getPrice()));
        this.ifv.startLoad(this.ifG.get(0).getThumbnail_url(), 10, false);
        this.ifz.startLoad(this.ifG.get(1).getThumbnail_url(), 10, false);
        this.ifD.startLoad(this.ifG.get(2).getThumbnail_url(), 10, false);
    }

    private SpannableStringBuilder crh() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getActivity(), BitmapFactory.decodeResource(getResources(), a.e.sdk_icon_huobi_tdou));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
        spannableStringBuilder2.setSpan(centeredImageSpan, 1, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private boolean cri() {
        this.bzc = new x();
        this.bzc.aKu.userId = getIntent().getLongExtra("ala_get_poke_user_id", 0L);
        this.bzc.aKu.portrait = getIntent().getStringExtra("ala_get_poke_portrait");
        this.bzc.aKu.userName = getIntent().getStringExtra("ala_get_poke_userName");
        this.bzc.aKu.nickName = getIntent().getStringExtra("ala_get_poke_nickName");
        this.bzc.mLiveInfo.live_id = getIntent().getLongExtra("ala_get_poke_live_id", 0L);
        this.bzc.mLiveInfo.room_id = getIntent().getLongExtra("ala_get_poke_room_id", 0L);
        this.bzc.mLiveInfo.appId = getIntent().getStringExtra("ala_get_poke_appId");
        this.bzc.mLiveInfo.feed_id = getIntent().getStringExtra("ala_get_poke_feed_id");
        this.otherParams = getIntent().getStringExtra("ala_get_poke_other_params");
        if (getIntent().getStringExtra("ala_get_poke_poke_info") == null) {
            finish();
        }
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("ala_get_poke_poke_info"));
            this.ifF = jSONObject.optString("poke_id");
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_list");
            for (int i = 0; i < optJSONArray.length(); i++) {
                g gVar = new g();
                gVar.setPrice(optJSONArray.optJSONObject(i).optString("tdou"));
                gVar.setThumbnailUrl(optJSONArray.optJSONObject(i).optString("pic"));
                gVar.setGiftName(optJSONArray.optJSONObject(i).optString("gift_name"));
                gVar.gH(optJSONArray.optJSONObject(i).optString(LogConfig.LOG_GIFT_ID));
                if (gVar.getPrice().isEmpty() || gVar.getThumbnail_url().isEmpty() || gVar.Gx().isEmpty() || gVar.Gy().isEmpty()) {
                    this.ifG.clear();
                    break;
                }
                this.ifG.add(gVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.ifF.isEmpty() || this.ifG.size() < 3) {
            return false;
        }
        ae(this.ifG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(int i) {
        if (this.ifG.size() >= i && this.fFi) {
            this.ifI = i;
            Kz();
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

    private void crj() {
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
        MessageManager.getInstance().unRegisterListener(this.aBj);
        MessageManager.getInstance().unRegisterListener(this.ifJ);
        MessageManager.getInstance().unRegisterListener(this.bwH);
        MessageManager.getInstance().unRegisterTask(1021228);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pc(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, this.ifH.Gx());
            jSONObject.putOpt("gift_name", this.ifH.Gy());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, this.ifH.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", z ? UbcStatConstant.Value.VALUE_USER_POKE_BACK_SUCCESS : UbcStatConstant.Value.VALUE_USER_POKE_BACK).setContentExt(this.ifI == 0 ? "normal" : "pay", null, jSONObject));
    }

    private void Kz() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
        httpMessage.addParam("tbs", TbadkCoreApplication.getCurrentTbs());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
