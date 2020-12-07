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
import com.baidu.live.data.bg;
import com.baidu.live.data.bo;
import com.baidu.live.data.w;
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
public class b implements com.baidu.live.guardclub.h {
    private w aFN;
    private ViewGroup bNk;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.b gNA;
    private com.baidu.live.guardclub.a gNB;
    private com.baidu.tieba.ala.guardclub.view.a gNC;
    private com.baidu.live.guardclub.l gNz;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gEP = BdUniqueId.gen();
    private boolean bjf = false;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aFN != null && b.this.aFN.aJV != null && ViewHelper.checkUpIsLogin(b.this.context)) {
                b.this.HC("");
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
    private HttpMessageListener gND = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aFN != null && b.this.aFN.aJV != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bja != null && guardClubInfoHttpResponseMessage.bja.anchorId == b.this.aFN.aJV.userId) {
                    b.this.gNB = guardClubInfoHttpResponseMessage.bja;
                    b.this.bjf = guardClubInfoHttpResponseMessage.bjf;
                    if (b.this.gNA != null) {
                        b.this.gNA.b(b.this.bjf, guardClubInfoHttpResponseMessage.bji);
                    }
                    if (b.this.bjf) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).LV()) {
                        b.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bja.id), guardClubInfoHttpResponseMessage.bjj, guardClubInfoHttpResponseMessage.bji, guardClubInfoHttpResponseMessage.bjb);
                    }
                }
            }
        }
    };
    CustomMessageListener gNE = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.b.6
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
    CustomMessageListener gNF = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bVY();
        }
    };
    HttpMessageListener gNG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.8
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
                    if (b.this.gNB != null && b.this.gNB.id == guardClubJoinHttpResponseMessage.bjk) {
                        b.this.bVZ();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bjn) {
                    guardClubJoinHttpResponseMessage.bjn = true;
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
        MessageManager.getInstance().registerListener(this.gDE);
        MessageManager.getInstance().registerListener(this.gND);
        MessageManager.getInstance().registerListener(this.gNE);
        MessageManager.getInstance().registerListener(this.gNF);
        MessageManager.getInstance().registerListener(this.gNG);
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gNA == null) {
            this.gNA = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.foP);
        }
        if (this.bNk != null && this.bNk.indexOfChild(this.gNA.getView()) >= 0) {
            this.bNk.removeView(this.gNA.getView());
        }
        this.bNk = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gNz = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQP != null && boVar.aQP.aTh) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ak(viewGroup)) {
                this.aFN = wVar;
                this.gNB = null;
                this.gNA.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Do() {
        this.gNB = null;
        if (this.gNC != null) {
            this.gNC.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gDE);
        MessageManager.getInstance().unRegisterListener(this.gND);
        MessageManager.getInstance().unRegisterListener(this.gNE);
        MessageManager.getInstance().unRegisterListener(this.gNF);
        MessageManager.getInstance().unRegisterListener(this.gNG);
        if (this.gNA != null) {
            this.gNA.onDestroy();
        }
        if (this.gNC != null) {
            this.gNC.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(String str) {
        if (this.context != null && this.aFN != null && this.aFN.aJV != null && this.aFN.mLiveInfo != null) {
            long j = this.aFN.aJV.userId;
            long j2 = this.aFN.mLiveInfo.live_id;
            long j3 = this.aFN.mLiveInfo.room_id;
            String str2 = this.aFN.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aFN.aJV.nickName, this.aFN.aJV.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bjf);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bVX();
        } else if (fVar.bjt > 0) {
            et(str, str2);
        }
    }

    private void bVX() {
        this.gNC = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gNC.a(new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.guardclub.b.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0660a
            public void onConfirm() {
                if (b.this.bVY()) {
                    b.this.gNC.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0660a
            public void onCancel() {
                b.this.gNC.dismiss();
            }
        });
        bg Mb = com.baidu.live.guardclub.g.LZ().Mb();
        this.gNC.W(0, Mb != null ? Mb.aQq : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void et(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        bg Mb = com.baidu.live.guardclub.g.LZ().Mb();
        if (Mb != null && Mb.aQo > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.BM().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dD = com.baidu.tieba.ala.guardclub.model.a.dD(jSONArray.optJSONObject(i));
                            if (dD != null && dD.date.equals(b)) {
                                if (dD.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dD);
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
                            com.baidu.live.d.BM().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dMd = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dMd >= Mb.aQo) {
                        z3 = true;
                    } else {
                        aVar2.dMd++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gNC = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gNC.a(new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.guardclub.b.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0660a
                    public void onConfirm() {
                        b.this.gNC.dismiss();
                        if (b.this.gNz != null) {
                            b.this.gNz.Me();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0660a
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
                this.gNC.W(1, Mb.aQp);
            }
            com.baidu.live.d.BM().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVY() {
        long j;
        if (this.gNB == null) {
            return false;
        }
        bg Mb = com.baidu.live.guardclub.g.LZ().Mb();
        if (Mb == null || Mb.aQj <= 0) {
            j = 1000;
        } else {
            j = Mb.aQj;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            vM(this.gNB.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void vM(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eS(i);
        cVar.a(this.gNB);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVZ() {
        if (this.aFN != null && this.aFN.aJV != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aFN.aJV.userId);
            bVar.setParams();
            bVar.setTag(this.gEP);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
