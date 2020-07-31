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
import com.baidu.live.data.at;
import com.baidu.live.data.bc;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.guardclub.h {
    private q avf;
    protected Context context;
    private com.baidu.live.guardclub.l fNu;
    protected com.baidu.tieba.ala.guardclub.view.b fNv;
    private ViewGroup fNw;
    private com.baidu.live.guardclub.a fNx;
    private com.baidu.tieba.ala.guardclub.view.a fNy;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fFJ = BdUniqueId.gen();
    private boolean aSI = false;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.avf != null && a.this.avf.ayC != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.CX("");
            }
        }
    };
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fNz = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.avf != null && a.this.avf.ayC != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aSF != null && guardClubInfoHttpResponseMessage.aSF.axs == a.this.avf.ayC.userId) {
                    a.this.fNx = guardClubInfoHttpResponseMessage.aSF;
                    a.this.aSI = guardClubInfoHttpResponseMessage.aSI;
                    if (a.this.fNv != null) {
                        a.this.fNv.b(a.this.aSI, guardClubInfoHttpResponseMessage.aSL);
                    }
                    if (a.this.aSI) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).CF()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aSF.id), guardClubInfoHttpResponseMessage.aSM, guardClubInfoHttpResponseMessage.aSL, guardClubInfoHttpResponseMessage.aSG);
                    }
                }
            }
        }
    };
    CustomMessageListener fNA = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.CX((String) customResponsedMessage.getData());
            } else {
                a.this.CX("");
            }
        }
    };
    CustomMessageListener fNB = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bAA();
        }
    };
    HttpMessageListener fNC = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fNx != null && a.this.fNx.id == guardClubJoinHttpResponseMessage.aSN) {
                        a.this.bAB();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aSQ) {
                    guardClubJoinHttpResponseMessage.aSQ = true;
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
        MessageManager.getInstance().registerListener(this.fEy);
        MessageManager.getInstance().registerListener(this.fNz);
        MessageManager.getInstance().registerListener(this.fNA);
        MessageManager.getInstance().registerListener(this.fNB);
        MessageManager.getInstance().registerListener(this.fNC);
    }

    protected boolean ai(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fNv == null) {
            this.fNv = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.eve);
        }
        if (this.fNw != null && this.fNw.indexOfChild(this.fNv.getView()) >= 0) {
            this.fNw.removeView(this.fNv.getView());
        }
        this.fNw = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fNu = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, q qVar) {
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEr != null && bcVar.aEr.aGf) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && ai(viewGroup)) {
                this.avf = qVar;
                this.fNx = null;
                this.fNv.reset();
                viewGroup.addView(this.fNv.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fNv != null && this.fNv.getView() != null) {
            this.fNv.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void CN() {
        this.fNx = null;
        if (this.fNy != null) {
            this.fNy.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fEy);
        MessageManager.getInstance().unRegisterListener(this.fNz);
        MessageManager.getInstance().unRegisterListener(this.fNA);
        MessageManager.getInstance().unRegisterListener(this.fNB);
        MessageManager.getInstance().unRegisterListener(this.fNC);
        if (this.fNv != null) {
            this.fNv.onDestroy();
        }
        if (this.fNy != null) {
            this.fNy.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX(String str) {
        if (this.context != null && this.avf != null && this.avf.ayC != null && this.avf.mLiveInfo != null) {
            long j = this.avf.ayC.userId;
            long j2 = this.avf.mLiveInfo.live_id;
            long j3 = this.avf.mLiveInfo.room_id;
            String str2 = this.avf.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.avf.ayC.nickName, this.avf.ayC.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.aSI);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bAz();
        } else if (fVar.aSX > 0) {
            dG(str, str2);
        }
    }

    private void bAz() {
        this.fNy = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fNy.a(new a.InterfaceC0559a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0559a
            public void onConfirm() {
                if (a.this.bAA()) {
                    a.this.fNy.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0559a
            public void onCancel() {
                a.this.fNy.dismiss();
            }
        });
        at CL = com.baidu.live.guardclub.g.CJ().CL();
        this.fNy.aI(0, CL != null ? CL.aDN : "");
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
        at CL = com.baidu.live.guardclub.g.CJ().CL();
        if (CL != null && CL.aDL > 0) {
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
                            com.baidu.tieba.ala.guardclub.model.a dc = com.baidu.tieba.ala.guardclub.model.a.dc(jSONArray.optJSONObject(i));
                            if (dc != null && dc.date.equals(b)) {
                                if (dc.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dc);
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
                aVar.cVg = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.cVg >= CL.aDL) {
                        z3 = true;
                    } else {
                        aVar2.cVg++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fNy = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fNy.a(new a.InterfaceC0559a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0559a
                    public void onConfirm() {
                        a.this.fNy.dismiss();
                        if (a.this.fNu != null) {
                            a.this.fNu.CP();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0559a
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
                this.fNy.aI(1, CL.aDM);
            }
            com.baidu.live.c.vf().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAA() {
        long j;
        if (this.fNx == null) {
            return false;
        }
        at CL = com.baidu.live.guardclub.g.CJ().CL();
        if (CL == null || CL.aDG <= 0) {
            j = 1000;
        } else {
            j = CL.aDG;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            rc(this.fNx.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void rc(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.cA(i);
        cVar.a(this.fNx);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bAB() {
        if (this.avf != null && this.avf.ayC != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.avf.ayC.userId);
            bVar.setParams();
            bVar.setTag(this.fFJ);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.fNw == null || this.fNv == null || this.fNw.indexOfChild(this.fNv.getView()) < 0) ? false : true;
    }
}
