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
import com.baidu.live.data.bd;
import com.baidu.live.data.bm;
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
public class a implements com.baidu.live.guardclub.h {
    private w aEc;
    private ViewGroup bEg;
    protected Context context;
    private com.baidu.live.guardclub.l gzg;
    protected com.baidu.tieba.ala.guardclub.view.b gzh;
    private com.baidu.live.guardclub.a gzi;
    private com.baidu.tieba.ala.guardclub.view.a gzj;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gqL = BdUniqueId.gen();
    private boolean bfh = false;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aEc != null && a.this.aEc.aIe != null && ViewHelper.checkUpIsLogin(a.this.context)) {
                a.this.Ha("");
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.a.4
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
    private HttpMessageListener gzk = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (a.this.aEc != null && a.this.aEc.aIe != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bfe != null && guardClubInfoHttpResponseMessage.bfe.anchorId == a.this.aEc.aIe.userId) {
                    a.this.gzi = guardClubInfoHttpResponseMessage.bfe;
                    a.this.bfh = guardClubInfoHttpResponseMessage.bfh;
                    if (a.this.gzh != null) {
                        a.this.gzh.b(a.this.bfh, guardClubInfoHttpResponseMessage.bfk);
                    }
                    if (a.this.bfh) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).Kb()) {
                        a.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bfe.id), guardClubInfoHttpResponseMessage.bfl, guardClubInfoHttpResponseMessage.bfk, guardClubInfoHttpResponseMessage.bff);
                    }
                }
            }
        }
    };
    CustomMessageListener gzl = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                a.this.Ha((String) customResponsedMessage.getData());
            } else {
                a.this.Ha("");
            }
        }
    };
    CustomMessageListener gzm = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.bQv();
        }
    };
    HttpMessageListener gzn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.a.8
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
                    if (a.this.gzi != null && a.this.gzi.id == guardClubJoinHttpResponseMessage.bfm) {
                        a.this.bQw();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bfp) {
                    guardClubJoinHttpResponseMessage.bfp = true;
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
        MessageManager.getInstance().registerListener(this.gpA);
        MessageManager.getInstance().registerListener(this.gzk);
        MessageManager.getInstance().registerListener(this.gzl);
        MessageManager.getInstance().registerListener(this.gzm);
        MessageManager.getInstance().registerListener(this.gzn);
    }

    protected boolean am(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gzh == null) {
            this.gzh = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.fcr);
        }
        if (this.bEg != null && this.bEg.indexOfChild(this.gzh.getView()) >= 0) {
            this.bEg.removeView(this.gzh.getView());
        }
        this.bEg = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gzg = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOD != null && bmVar.aOD.aQO) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && am(viewGroup)) {
                this.aEc = wVar;
                this.gzi = null;
                this.gzh.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void Kj() {
        this.gzi = null;
        if (this.gzj != null) {
            this.gzj.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpA);
        MessageManager.getInstance().unRegisterListener(this.gzk);
        MessageManager.getInstance().unRegisterListener(this.gzl);
        MessageManager.getInstance().unRegisterListener(this.gzm);
        MessageManager.getInstance().unRegisterListener(this.gzn);
        if (this.gzh != null) {
            this.gzh.onDestroy();
        }
        if (this.gzj != null) {
            this.gzj.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(String str) {
        if (this.context != null && this.aEc != null && this.aEc.aIe != null && this.aEc.mLiveInfo != null) {
            long j = this.aEc.aIe.userId;
            long j2 = this.aEc.mLiveInfo.live_id;
            long j3 = this.aEc.mLiveInfo.room_id;
            String str2 = this.aEc.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aEc.aIe.nickName, this.aEc.aIe.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bfh);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bQu();
        } else if (fVar.bfw > 0) {
            em(str, str2);
        }
    }

    private void bQu() {
        this.gzj = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gzj.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.a.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onConfirm() {
                if (a.this.bQv()) {
                    a.this.gzj.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onCancel() {
                a.this.gzj.dismiss();
            }
        });
        bd Kh = com.baidu.live.guardclub.g.Kf().Kh();
        this.gzj.S(0, Kh != null ? Kh.aNZ : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void em(String str, final String str2) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        bd Kh = com.baidu.live.guardclub.g.Kf().Kh();
        if (Kh != null && Kh.aNX > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.AZ().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dB = com.baidu.tieba.ala.guardclub.model.a.dB(jSONArray.optJSONObject(i));
                            if (dB != null && dB.date.equals(b)) {
                                if (dB.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dB);
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
                            com.baidu.live.d.AZ().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.dAU = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.dAU >= Kh.aNX) {
                        z3 = true;
                    } else {
                        aVar2.dAU++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (!z3) {
                this.gzj = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gzj.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.a.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
                    public void onConfirm() {
                        a.this.gzj.dismiss();
                        if (a.this.gzg != null) {
                            a.this.gzg.Kl();
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
                            BrowserHelper.startInternalWebActivity(a.this.context, sb.toString());
                        }
                    }
                });
                this.gzj.S(1, Kh.aNY);
            }
            com.baidu.live.d.AZ().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQv() {
        long j;
        if (this.gzi == null) {
            return false;
        }
        bd Kh = com.baidu.live.guardclub.g.Kf().Kh();
        if (Kh == null || Kh.aNS <= 0) {
            j = 1000;
        } else {
            j = Kh.aNS;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            ux(this.gzi.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void ux(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.eA(i);
        cVar.a(this.gzi);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bQw() {
        if (this.aEc != null && this.aEc.aIe != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aEc.aIe.userId);
            bVar.setParams();
            bVar.setTag(this.gqL);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
