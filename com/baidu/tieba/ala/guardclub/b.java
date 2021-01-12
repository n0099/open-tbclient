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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.guardclub.h {
    private x aBr;
    private ViewGroup bNl;
    protected Context context;
    private com.baidu.live.guardclub.l gUI;
    protected com.baidu.tieba.ala.guardclub.view.b gUJ;
    private com.baidu.live.guardclub.a gUK;
    private com.baidu.tieba.ala.guardclub.view.a gUL;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gLW = BdUniqueId.gen();
    private boolean bfU = false;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aBr != null && b.this.aBr.aFH != null && ViewHelper.checkUpIsLogin(b.this.context)) {
                b.this.Gq("");
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
    private HttpMessageListener gUM = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aBr != null && b.this.aBr.aFH != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bfP != null && guardClubInfoHttpResponseMessage.bfP.anchorId == b.this.aBr.aFH.userId) {
                    b.this.gUK = guardClubInfoHttpResponseMessage.bfP;
                    b.this.bfU = guardClubInfoHttpResponseMessage.bfU;
                    if (b.this.gUJ != null) {
                        b.this.gUJ.b(b.this.bfU, guardClubInfoHttpResponseMessage.bfX);
                    }
                    if (b.this.bfU) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Hz()) {
                        b.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bfP.id), guardClubInfoHttpResponseMessage.bfY, guardClubInfoHttpResponseMessage.bfX, guardClubInfoHttpResponseMessage.bfQ);
                    }
                }
            }
        }
    };
    CustomMessageListener gUN = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.Gq((String) customResponsedMessage.getData());
            } else {
                b.this.Gq("");
            }
        }
    };
    CustomMessageListener gUO = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bUN();
        }
    };
    HttpMessageListener gUP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.8
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
                    if (b.this.gUK != null && b.this.gUK.id == guardClubJoinHttpResponseMessage.bfZ) {
                        b.this.bUO();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bgc) {
                    guardClubJoinHttpResponseMessage.bgc = true;
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
        MessageManager.getInstance().registerListener(this.gKM);
        MessageManager.getInstance().registerListener(this.gUM);
        MessageManager.getInstance().registerListener(this.gUN);
        MessageManager.getInstance().registerListener(this.gUO);
        MessageManager.getInstance().registerListener(this.gUP);
    }

    protected boolean aw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gUJ == null) {
            this.gUJ = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.onClickListener);
        }
        if (this.bNl != null && this.bNl.indexOfChild(this.gUJ.getView()) >= 0) {
            this.bNl.removeView(this.gUJ.getView());
        }
        this.bNl = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gUI = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, x xVar) {
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMR != null && bqVar.aMR.aPs) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && aw(viewGroup)) {
                this.aBr = xVar;
                this.gUK = null;
                this.gUJ.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void xk() {
        this.gUK = null;
        if (this.gUL != null) {
            this.gUL.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gKM);
        MessageManager.getInstance().unRegisterListener(this.gUM);
        MessageManager.getInstance().unRegisterListener(this.gUN);
        MessageManager.getInstance().unRegisterListener(this.gUO);
        MessageManager.getInstance().unRegisterListener(this.gUP);
        if (this.gUJ != null) {
            this.gUJ.onDestroy();
        }
        if (this.gUL != null) {
            this.gUL.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (this.context != null && this.aBr != null && this.aBr.aFH != null && this.aBr.mLiveInfo != null) {
            long j = this.aBr.aFH.userId;
            long j2 = this.aBr.mLiveInfo.live_id;
            long j3 = this.aBr.mLiveInfo.room_id;
            String str2 = this.aBr.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aBr.aFH.nickName, this.aBr.aFH.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bfU);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bUM();
        } else if (fVar.bgh > 0) {
            er(str, str2);
        }
    }

    private void bUM() {
        this.gUL = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gUL.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.b.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onConfirm() {
                if (b.this.bUN()) {
                    b.this.gUL.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onCancel() {
                b.this.gUL.dismiss();
            }
        });
        bi HF = com.baidu.live.guardclub.g.HD().HF();
        this.gUL.Z(0, HF != null ? HF.aMs : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void er(String str, final String str2) {
        JSONException e;
        boolean z;
        boolean z2;
        boolean z3 = false;
        bi HF = com.baidu.live.guardclub.g.HD().HF();
        if (HF != null && HF.aMq > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b2 = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.xf().getString("guardclub_attenuat_daily", "");
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
                            com.baidu.live.d.xf().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.bnO = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.bnO >= HF.aMq) {
                        z3 = true;
                    } else {
                        aVar2.bnO++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            if (!z3) {
                this.gUL = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gUL.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.b.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
                    public void onConfirm() {
                        b.this.gUL.dismiss();
                        if (b.this.gUI != null) {
                            b.this.gUI.HI();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
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
                this.gUL.Z(1, HF.aMr);
            }
            com.baidu.live.d.xf().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bUN() {
        long j;
        if (this.gUK == null) {
            return false;
        }
        bi HF = com.baidu.live.guardclub.g.HD().HF();
        if (HF == null || HF.aMl <= 0) {
            j = 1000;
        } else {
            j = HF.aMl;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            ur(this.gUK.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void ur(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dk(i);
        cVar.a(this.gUK);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bUO() {
        if (this.aBr != null && this.aBr.aFH != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aBr.aFH.userId);
            bVar.setParams();
            bVar.setTag(this.gLW);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
