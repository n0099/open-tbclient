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
import com.baidu.live.data.ba;
import com.baidu.live.data.bj;
import com.baidu.live.data.u;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.guardclub.h {
    private u aDU;
    private ViewGroup bBk;
    protected Context context;
    private com.baidu.live.guardclub.l gpb;
    protected com.baidu.tieba.ala.guardclub.view.b gpc;
    private com.baidu.live.guardclub.a gpd;
    private com.baidu.tieba.ala.guardclub.view.a gpe;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId ggI = BdUniqueId.gen();
    private boolean bdQ = false;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aDU != null && a.this.aDU.aHD != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.GC("");
            }
        }
    };
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };
    private HttpMessageListener gpf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aDU != null && a.this.aDU.aHD != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bdN != null && guardClubInfoHttpResponseMessage.bdN.anchorId == a.this.aDU.aHD.userId) {
                    a.this.gpd = guardClubInfoHttpResponseMessage.bdN;
                    a.this.bdQ = guardClubInfoHttpResponseMessage.bdQ;
                    if (a.this.gpc != null) {
                        a.this.gpc.b(a.this.bdQ, guardClubInfoHttpResponseMessage.bdT);
                    }
                    if (a.this.bdQ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).JI()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bdN.id), guardClubInfoHttpResponseMessage.bdU, guardClubInfoHttpResponseMessage.bdT, guardClubInfoHttpResponseMessage.bdO);
                    }
                }
            }
        }
    };
    CustomMessageListener gpg = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.GC((String) customResponsedMessage.getData());
            } else {
                a.this.GC("");
            }
        }
    };
    CustomMessageListener gph = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bNQ();
        }
    };
    HttpMessageListener gpi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.gpd != null && a.this.gpd.id == guardClubJoinHttpResponseMessage.bdV) {
                        a.this.bNR();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bdY) {
                    guardClubJoinHttpResponseMessage.bdY = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        MessageManager.getInstance().registerListener(this.gfx);
        MessageManager.getInstance().registerListener(this.gpf);
        MessageManager.getInstance().registerListener(this.gpg);
        MessageManager.getInstance().registerListener(this.gph);
        MessageManager.getInstance().registerListener(this.gpi);
    }

    protected boolean am(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gpc == null) {
            this.gpc = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.eTU);
        }
        if (this.bBk != null && this.bBk.indexOfChild(this.gpc.getView()) >= 0) {
            this.bBk.removeView(this.gpc.getView());
        }
        this.bBk = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gpb = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, u uVar) {
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNY != null && bjVar.aNY.aQe) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && am(viewGroup)) {
                this.aDU = uVar;
                this.gpd = null;
                this.gpc.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.gpc != null && this.gpc.getView() != null) {
            this.gpc.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void JQ() {
        this.gpd = null;
        if (this.gpe != null) {
            this.gpe.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gfx);
        MessageManager.getInstance().unRegisterListener(this.gpf);
        MessageManager.getInstance().unRegisterListener(this.gpg);
        MessageManager.getInstance().unRegisterListener(this.gph);
        MessageManager.getInstance().unRegisterListener(this.gpi);
        if (this.gpc != null) {
            this.gpc.onDestroy();
        }
        if (this.gpe != null) {
            this.gpe.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC(String str) {
        if (this.context != null && this.aDU != null && this.aDU.aHD != null && this.aDU.mLiveInfo != null) {
            long j = this.aDU.aHD.userId;
            long j2 = this.aDU.mLiveInfo.live_id;
            long j3 = this.aDU.mLiveInfo.room_id;
            String str2 = this.aDU.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aDU.aHD.nickName, this.aDU.aHD.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bdQ);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bNP();
        } else if (fVar.bee > 0) {
            ef(str, str2);
        }
    }

    private void bNP() {
        this.gpe = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gpe.a(new a.InterfaceC0619a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0619a
            public void onConfirm() {
                if (a.this.bNQ()) {
                    a.this.gpe.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0619a
            public void onCancel() {
                a.this.gpe.dismiss();
            }
        });
        ba JO = com.baidu.live.guardclub.g.JM().JO();
        this.gpe.Q(0, JO != null ? JO.aNu : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ef(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        ba JO = com.baidu.live.guardclub.g.JM().JO();
        if (JO != null && JO.aNs > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.c.AZ().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dw = com.baidu.tieba.ala.guardclub.model.a.dw(jSONArray.optJSONObject(i));
                            if (dw != null && dw.date.equals(b)) {
                                if (dw.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dw);
                            }
                        } catch (JSONException e) {
                            z = z2;
                            e = e;
                            e.printStackTrace();
                            z2 = z;
                            if (!z2) {
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            while (r5.hasNext()) {
                            }
                            if (!z3) {
                            }
                            com.baidu.live.c.AZ().putString("guardclub_attenuat_daily", jSONArray2.toString());
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    z = false;
                }
            }
            if (!z2) {
                com.baidu.tieba.ala.guardclub.model.a aVar = new com.baidu.tieba.ala.guardclub.model.a();
                aVar.id = str;
                aVar.date = b;
                aVar.dsw = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dsw >= JO.aNs) {
                        z3 = true;
                    } else {
                        aVar2.dsw++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gpe = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gpe.a(new a.InterfaceC0619a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0619a
                    public void onConfirm() {
                        a.this.gpe.dismiss();
                        if (a.this.gpb != null) {
                            a.this.gpb.JS();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0619a
                    public void onCancel() {
                        if (!TextUtils.isEmpty(str2)) {
                            StringBuilder sb = new StringBuilder(str2);
                            if (str2.contains("?")) {
                                sb.append(ETAG.ITEM_SEPARATOR);
                            } else {
                                sb.append("?");
                            }
                            sb.append("source=2");
                            BrowserHelper.startInternalWebActivity(a.this.context, sb.toString());
                        }
                    }
                });
                this.gpe.Q(1, JO.aNt);
            }
            com.baidu.live.c.AZ().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNQ() {
        long j;
        if (this.gpd == null) {
            return false;
        }
        ba JO = com.baidu.live.guardclub.g.JM().JO();
        if (JO == null || JO.aNn <= 0) {
            j = 1000;
        } else {
            j = JO.aNn;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            uf(this.gpd.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void uf(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.ez(i);
        cVar.a(this.gpd);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bNR() {
        if (this.aDU != null && this.aDU.aHD != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aDU.aHD.userId);
            bVar.setParams();
            bVar.setTag(this.ggI);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.bBk == null || this.gpc == null || this.bBk.indexOfChild(this.gpc.getView()) < 0) ? false : true;
    }
}
