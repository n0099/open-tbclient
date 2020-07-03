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
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.q;
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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.guardclub.h {
    private q aLQ;
    protected Context context;
    private com.baidu.live.guardclub.l fHZ;
    protected com.baidu.tieba.ala.guardclub.view.b fIa;
    private ViewGroup fIb;
    private com.baidu.live.guardclub.a fIc;
    private com.baidu.tieba.ala.guardclub.view.a fId;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fAz = BdUniqueId.gen();
    private boolean aRp = false;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aLQ != null && a.this.aLQ.axp != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Cl("");
            }
        }
    };
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fIe = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aLQ != null && a.this.aLQ.axp != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aRm != null && guardClubInfoHttpResponseMessage.aRm.awn == a.this.aLQ.axp.userId) {
                    a.this.fIc = guardClubInfoHttpResponseMessage.aRm;
                    a.this.aRp = guardClubInfoHttpResponseMessage.aRp;
                    if (a.this.fIa != null) {
                        a.this.fIa.b(a.this.aRp, guardClubInfoHttpResponseMessage.aRs);
                    }
                    if (a.this.aRp) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Cd()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aRm.id), guardClubInfoHttpResponseMessage.aRt, guardClubInfoHttpResponseMessage.aRs, guardClubInfoHttpResponseMessage.aRn);
                    }
                }
            }
        }
    };
    CustomMessageListener fIf = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Cl((String) customResponsedMessage.getData());
            } else {
                a.this.Cl("");
            }
        }
    };
    CustomMessageListener fIg = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bxj();
        }
    };
    HttpMessageListener fIh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fIc != null && a.this.fIc.id == guardClubJoinHttpResponseMessage.aRu) {
                        a.this.bxk();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aRx) {
                    guardClubJoinHttpResponseMessage.aRx = true;
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
        MessageManager.getInstance().registerListener(this.fzr);
        MessageManager.getInstance().registerListener(this.fIe);
        MessageManager.getInstance().registerListener(this.fIf);
        MessageManager.getInstance().registerListener(this.fIg);
        MessageManager.getInstance().registerListener(this.fIh);
    }

    protected boolean ah(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fIa == null) {
            this.fIa = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.eoP);
        }
        if (this.fIb != null && this.fIb.indexOfChild(this.fIa.getView()) >= 0) {
            this.fIb.removeView(this.fIa.getView());
        }
        this.fIb = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fHZ = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, q qVar) {
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar != null && bbVar.aCW != null && bbVar.aCW.aEL) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ah(viewGroup)) {
                this.aLQ = qVar;
                this.fIc = null;
                this.fIa.reset();
                viewGroup.addView(this.fIa.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fIa != null && this.fIa.getView() != null) {
            this.fIa.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Cl() {
        this.fIc = null;
        if (this.fId != null) {
            this.fId.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzr);
        MessageManager.getInstance().unRegisterListener(this.fIe);
        MessageManager.getInstance().unRegisterListener(this.fIf);
        MessageManager.getInstance().unRegisterListener(this.fIg);
        MessageManager.getInstance().unRegisterListener(this.fIh);
        if (this.fIa != null) {
            this.fIa.onDestroy();
        }
        if (this.fId != null) {
            this.fId.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cl(String str) {
        if (this.context != null && this.aLQ != null && this.aLQ.axp != null && this.aLQ.mLiveInfo != null) {
            long j = this.aLQ.axp.userId;
            long j2 = this.aLQ.mLiveInfo.live_id;
            long j3 = this.aLQ.mLiveInfo.room_id;
            String str2 = this.aLQ.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aLQ.axp.nickName, this.aLQ.axp.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.aRp);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bxi();
        } else if (fVar.aRE > 0) {
            dG(str, str2);
        }
    }

    private void bxi() {
        this.fId = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fId.a(new a.InterfaceC0548a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0548a
            public void onConfirm() {
                if (a.this.bxj()) {
                    a.this.fId.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0548a
            public void onCancel() {
                a.this.fId.dismiss();
            }
        });
        as Cj = com.baidu.live.guardclub.g.Ch().Cj();
        this.fId.aG(0, Cj != null ? Cj.aCs : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dG(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        as Cj = com.baidu.live.guardclub.g.Ch().Cj();
        if (Cj != null && Cj.aCq > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.vf().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a cW = com.baidu.tieba.ala.guardclub.model.a.cW(jSONArray.optJSONObject(i));
                            if (cW != null && cW.date.equals(b)) {
                                if (cW.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(cW);
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
                            com.baidu.live.c.vf().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.fKO = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.fKO >= Cj.aCq) {
                        z3 = true;
                    } else {
                        aVar2.fKO++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fId = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fId.a(new a.InterfaceC0548a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0548a
                    public void onConfirm() {
                        a.this.fId.dismiss();
                        if (a.this.fHZ != null) {
                            a.this.fHZ.Cn();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0548a
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
                this.fId.aG(1, Cj.aCr);
            }
            com.baidu.live.c.vf().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxj() {
        long j;
        if (this.fIc == null) {
            return false;
        }
        as Cj = com.baidu.live.guardclub.g.Ch().Cj();
        if (Cj == null || Cj.aCl <= 0) {
            j = 1000;
        } else {
            j = Cj.aCl;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            qM(this.fIc.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void qM(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cu(i);
        cVar.a(this.fIc);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bxk() {
        if (this.aLQ != null && this.aLQ.axp != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.aLQ.axp.userId);
            bVar.setParams();
            bVar.setTag(this.fAz);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.fIb == null || this.fIa == null || this.fIb.indexOfChild(this.fIa.getView()) < 0) ? false : true;
    }
}
