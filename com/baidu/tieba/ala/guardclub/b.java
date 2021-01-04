package com.baidu.tieba.ala.guardclub;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bi;
import com.baidu.live.data.bq;
import com.baidu.live.data.x;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.guardclub.view.a;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.guardclub.h {
    private x aGe;
    private ViewGroup bRX;
    protected Context context;
    private com.baidu.live.guardclub.l gZo;
    protected com.baidu.tieba.ala.guardclub.view.b gZp;
    private com.baidu.live.guardclub.a gZq;
    private com.baidu.tieba.ala.guardclub.view.a gZr;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gQC = BdUniqueId.gen();
    private boolean bkK = false;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aGe != null && b.this.aGe.aKu != null && ViewHelper.checkUpIsLogin(b.this.context)) {
                b.this.HC("");
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
            }
        }
    };
    private HttpMessageListener gZs = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aGe != null && b.this.aGe.aKu != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bkF != null && guardClubInfoHttpResponseMessage.bkF.anchorId == b.this.aGe.aKu.userId) {
                    b.this.gZq = guardClubInfoHttpResponseMessage.bkF;
                    b.this.bkK = guardClubInfoHttpResponseMessage.bkK;
                    if (b.this.gZp != null) {
                        b.this.gZp.b(b.this.bkK, guardClubInfoHttpResponseMessage.bkN);
                    }
                    if (b.this.bkK) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Lu()) {
                        b.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bkF.id), guardClubInfoHttpResponseMessage.bkO, guardClubInfoHttpResponseMessage.bkN, guardClubInfoHttpResponseMessage.bkG);
                    }
                }
            }
        }
    };
    CustomMessageListener gZt = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.HC((String) customResponsedMessage.getData());
            } else {
                b.this.HC("");
            }
        }
    };
    CustomMessageListener gZu = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bYE();
        }
    };
    HttpMessageListener gZv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135) {
                if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (!TextUtils.isEmpty(errorString)) {
                        BdUtilHelper.getCustomToast().showToast(errorString, 0);
                        return;
                    }
                    return;
                }
                GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (b.this.gZq != null && b.this.gZq.id == guardClubJoinHttpResponseMessage.bkP) {
                        b.this.bYF();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bkS) {
                    guardClubJoinHttpResponseMessage.bkS = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };

    public b(Context context) {
        this.context = context;
        MessageManager.getInstance().registerListener(this.gPs);
        MessageManager.getInstance().registerListener(this.gZs);
        MessageManager.getInstance().registerListener(this.gZt);
        MessageManager.getInstance().registerListener(this.gZu);
        MessageManager.getInstance().registerListener(this.gZv);
    }

    protected boolean aw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gZp == null) {
            this.gZp = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.onClickListener);
        }
        if (this.bRX != null && this.bRX.indexOfChild(this.gZp.getView()) >= 0) {
            this.bRX.removeView(this.gZp.getView());
        }
        this.bRX = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gZo = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, x xVar) {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRE != null && bqVar.aRE.aUf) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && aw(viewGroup)) {
                this.aGe = xVar;
                this.gZq = null;
                this.gZp.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Bf() {
        this.gZq = null;
        if (this.gZr != null) {
            this.gZr.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gPs);
        MessageManager.getInstance().unRegisterListener(this.gZs);
        MessageManager.getInstance().unRegisterListener(this.gZt);
        MessageManager.getInstance().unRegisterListener(this.gZu);
        MessageManager.getInstance().unRegisterListener(this.gZv);
        if (this.gZp != null) {
            this.gZp.onDestroy();
        }
        if (this.gZr != null) {
            this.gZr.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(String str) {
        if (this.context != null && this.aGe != null && this.aGe.aKu != null && this.aGe.mLiveInfo != null) {
            long j = this.aGe.aKu.userId;
            long j2 = this.aGe.mLiveInfo.live_id;
            long j3 = this.aGe.mLiveInfo.room_id;
            String str2 = this.aGe.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aGe.aKu.nickName, this.aGe.aKu.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bkK);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bYD();
        } else if (fVar.bkX > 0) {
            es(str, str2);
        }
    }

    private void bYD() {
        this.gZr = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gZr.a(new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.guardclub.b.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0652a
            public void onConfirm() {
                if (b.this.bYE()) {
                    b.this.gZr.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0652a
            public void onCancel() {
                b.this.gZr.dismiss();
            }
        });
        bi LA = com.baidu.live.guardclub.g.Ly().LA();
        this.gZr.Y(0, LA != null ? LA.aRf : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void es(String str, final String str2) {
        JSONException e;
        boolean z;
        boolean z2;
        boolean z3 = false;
        bi LA = com.baidu.live.guardclub.g.Ly().LA();
        if (LA != null && LA.aRd > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b2 = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.Ba().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dM = com.baidu.tieba.ala.guardclub.model.a.dM(jSONArray.optJSONObject(i));
                            if (dM != null && dM.date.equals(b2)) {
                                if (dM.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dM);
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            z = z2;
                            e.printStackTrace();
                            z2 = z;
                            if (!z2) {
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            while (r3.hasNext()) {
                            }
                            if (!z3) {
                            }
                            com.baidu.live.d.Ba().putString("guardclub_attenuat_daily", jSONArray2.toString());
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    z = false;
                }
            }
            if (!z2) {
                com.baidu.tieba.ala.guardclub.model.a aVar = new com.baidu.tieba.ala.guardclub.model.a();
                aVar.id = str;
                aVar.date = b2;
                aVar.bsA = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.bsA >= LA.aRd) {
                        z3 = true;
                    } else {
                        aVar2.bsA++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            if (!z3) {
                this.gZr = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gZr.a(new a.InterfaceC0652a() { // from class: com.baidu.tieba.ala.guardclub.b.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0652a
                    public void onConfirm() {
                        b.this.gZr.dismiss();
                        if (b.this.gZo != null) {
                            b.this.gZo.LD();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0652a
                    public void onCancel() {
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb = new StringBuilder(str2);
                            if (str2.contains("?")) {
                                sb.append(ETAG.ITEM_SEPARATOR);
                            } else {
                                sb.append("?");
                            }
                            sb.append("source=2");
                            BrowserHelper.startInternalWebActivity(b.this.context, sb.toString());
                        }
                    }
                });
                this.gZr.Y(1, LA.aRe);
            }
            com.baidu.live.d.Ba().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYE() {
        long j;
        if (this.gZq == null) {
            return false;
        }
        bi LA = com.baidu.live.guardclub.g.Ly().LA();
        if (LA == null || LA.aQY <= 0) {
            j = 1000;
        } else {
            j = LA.aQY;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            vX(this.gZq.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void vX(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eQ(i);
        cVar.a(this.gZq);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bYF() {
        if (this.aGe != null && this.aGe.aKu != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aGe.aKu.userId);
            bVar.setParams();
            bVar.setTag(this.gQC);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
