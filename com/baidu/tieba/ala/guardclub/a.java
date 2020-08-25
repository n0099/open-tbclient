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
import com.baidu.live.data.av;
import com.baidu.live.data.be;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.guardclub.h {
    private r aAh;
    protected Context context;
    private com.baidu.live.guardclub.l fZs;
    protected com.baidu.tieba.ala.guardclub.view.b fZt;
    private ViewGroup fZu;
    private com.baidu.live.guardclub.a fZv;
    private com.baidu.tieba.ala.guardclub.view.a fZw;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId fRa = BdUniqueId.gen();
    private boolean aXW = false;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aAh != null && a.this.aAh.aDE != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Fs("");
            }
        }
    };
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener fZx = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aAh != null && a.this.aAh.aDE != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXT != null && guardClubInfoHttpResponseMessage.aXT.aCu == a.this.aAh.aDE.userId) {
                    a.this.fZv = guardClubInfoHttpResponseMessage.aXT;
                    a.this.aXW = guardClubInfoHttpResponseMessage.aXW;
                    if (a.this.fZt != null) {
                        a.this.fZt.b(a.this.aXW, guardClubInfoHttpResponseMessage.aXZ);
                    }
                    if (a.this.aXW) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Ii()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.aXT.id), guardClubInfoHttpResponseMessage.aYa, guardClubInfoHttpResponseMessage.aXZ, guardClubInfoHttpResponseMessage.aXU);
                    }
                }
            }
        }
    };
    CustomMessageListener fZy = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Fs((String) customResponsedMessage.getData());
            } else {
                a.this.Fs("");
            }
        }
    };
    CustomMessageListener fZz = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bJV();
        }
    };
    HttpMessageListener fZA = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.fZv != null && a.this.fZv.id == guardClubJoinHttpResponseMessage.aYb) {
                        a.this.bJW();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aYe) {
                    guardClubJoinHttpResponseMessage.aYe = true;
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
        MessageManager.getInstance().registerListener(this.fPP);
        MessageManager.getInstance().registerListener(this.fZx);
        MessageManager.getInstance().registerListener(this.fZy);
        MessageManager.getInstance().registerListener(this.fZz);
        MessageManager.getInstance().registerListener(this.fZA);
    }

    protected boolean aj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fZt == null) {
            this.fZt = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.eFC);
        }
        if (this.fZu != null && this.fZu.indexOfChild(this.fZt.getView()) >= 0) {
            this.fZu.removeView(this.fZt.getView());
        }
        this.fZu = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.fZs = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, r rVar) {
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJB != null && beVar.aJB.aLp) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && aj(viewGroup)) {
                this.aAh = rVar;
                this.fZv = null;
                this.fZt.reset();
                viewGroup.addView(this.fZt.getView(), layoutParams);
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setVisible(int i) {
        if (this.fZt != null && this.fZt.getView() != null) {
            this.fZt.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Iq() {
        this.fZv = null;
        if (this.fZw != null) {
            this.fZw.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fPP);
        MessageManager.getInstance().unRegisterListener(this.fZx);
        MessageManager.getInstance().unRegisterListener(this.fZy);
        MessageManager.getInstance().unRegisterListener(this.fZz);
        MessageManager.getInstance().unRegisterListener(this.fZA);
        if (this.fZt != null) {
            this.fZt.onDestroy();
        }
        if (this.fZw != null) {
            this.fZw.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs(String str) {
        if (this.context != null && this.aAh != null && this.aAh.aDE != null && this.aAh.mLiveInfo != null) {
            long j = this.aAh.aDE.userId;
            long j2 = this.aAh.mLiveInfo.live_id;
            long j3 = this.aAh.mLiveInfo.room_id;
            String str2 = this.aAh.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aAh.aDE.nickName, this.aAh.aDE.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.aXW);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bJU();
        } else if (fVar.aYl > 0) {
            dW(str, str2);
        }
    }

    private void bJU() {
        this.fZw = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.fZw.a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
            public void onConfirm() {
                if (a.this.bJV()) {
                    a.this.fZw.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
            public void onCancel() {
                a.this.fZw.dismiss();
            }
        });
        av Io = com.baidu.live.guardclub.g.Im().Io();
        this.fZw.aG(0, Io != null ? Io.aIX : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dW(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io != null && Io.aIV > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.j.b(new Date());
            String string = com.baidu.live.c.AD().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dl = com.baidu.tieba.ala.guardclub.model.a.dl(jSONArray.optJSONObject(i));
                            if (dl != null && dl.date.equals(b)) {
                                if (dl.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dl);
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
                            com.baidu.live.c.AD().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dej = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dej >= Io.aIV) {
                        z3 = true;
                    } else {
                        aVar2.dej++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.fZw = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.fZw.a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
                    public void onConfirm() {
                        a.this.fZw.dismiss();
                        if (a.this.fZs != null) {
                            a.this.fZs.Is();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0606a
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
                this.fZw.aG(1, Io.aIW);
            }
            com.baidu.live.c.AD().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJV() {
        long j;
        if (this.fZv == null) {
            return false;
        }
        av Io = com.baidu.live.guardclub.g.Im().Io();
        if (Io == null || Io.aIQ <= 0) {
            j = 1000;
        } else {
            j = Io.aIQ;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            to(this.fZv.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void to(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eq(i);
        cVar.a(this.fZv);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bJW() {
        if (this.aAh != null && this.aAh.aDE != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ag(this.aAh.aDE.userId);
            bVar.setParams();
            bVar.setTag(this.fRa);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }

    @Override // com.baidu.live.guardclub.h
    public boolean isShowing() {
        return (this.fZu == null || this.fZt == null || this.fZu.indexOfChild(this.fZt.getView()) < 0) ? false : true;
    }
}
