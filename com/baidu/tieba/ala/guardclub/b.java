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
import com.baidu.live.data.ab;
import com.baidu.live.data.bn;
import com.baidu.live.data.bv;
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
    private ab aDd;
    private ViewGroup bRb;
    protected Context context;
    private com.baidu.live.guardclub.l gXs;
    protected com.baidu.tieba.ala.guardclub.view.b gXt;
    private com.baidu.live.guardclub.a gXu;
    private com.baidu.tieba.ala.guardclub.view.a gXv;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gOC = BdUniqueId.gen();
    private boolean bjd = false;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aDd != null && b.this.aDd.aId != null && ViewHelper.checkUpIsLogin(b.this.context)) {
                b.this.GP("");
            }
        }
    };
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
    private HttpMessageListener gXw = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aDd != null && b.this.aDd.aId != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.biY != null && guardClubInfoHttpResponseMessage.biY.anchorId == b.this.aDd.aId.userId) {
                    b.this.gXu = guardClubInfoHttpResponseMessage.biY;
                    b.this.bjd = guardClubInfoHttpResponseMessage.bjd;
                    if (b.this.gXt != null) {
                        b.this.gXt.b(b.this.bjd, guardClubInfoHttpResponseMessage.bjg);
                    }
                    if (b.this.bjd) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).IP()) {
                        b.this.a(String.valueOf(guardClubInfoHttpResponseMessage.biY.id), guardClubInfoHttpResponseMessage.bjh, guardClubInfoHttpResponseMessage.bjg, guardClubInfoHttpResponseMessage.biZ);
                    }
                }
            }
        }
    };
    CustomMessageListener gXx = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GP((String) customResponsedMessage.getData());
            } else {
                b.this.GP("");
            }
        }
    };
    CustomMessageListener gXy = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bVs();
        }
    };
    HttpMessageListener gXz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.8
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
                    if (b.this.gXu != null && b.this.gXu.id == guardClubJoinHttpResponseMessage.bji) {
                        b.this.bVt();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bjl) {
                    guardClubJoinHttpResponseMessage.bjl = true;
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
        MessageManager.getInstance().registerListener(this.gNs);
        MessageManager.getInstance().registerListener(this.gXw);
        MessageManager.getInstance().registerListener(this.gXx);
        MessageManager.getInstance().registerListener(this.gXy);
        MessageManager.getInstance().registerListener(this.gXz);
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gXt == null) {
            this.gXt = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.onClickListener);
        }
        if (this.bRb != null && this.bRb.indexOfChild(this.gXt.getView()) >= 0) {
            this.bRb.removeView(this.gXt.getView());
        }
        this.bRb = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gXs = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ab abVar) {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPP != null && bvVar.aPP.aSu) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && au(viewGroup)) {
                this.aDd = abVar;
                this.gXu = null;
                this.gXt.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void xh() {
        this.gXu = null;
        if (this.gXv != null) {
            this.gXv.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gNs);
        MessageManager.getInstance().unRegisterListener(this.gXw);
        MessageManager.getInstance().unRegisterListener(this.gXx);
        MessageManager.getInstance().unRegisterListener(this.gXy);
        MessageManager.getInstance().unRegisterListener(this.gXz);
        if (this.gXt != null) {
            this.gXt.onDestroy();
        }
        if (this.gXv != null) {
            this.gXv.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP(String str) {
        if (this.context != null && this.aDd != null && this.aDd.aId != null && this.aDd.mLiveInfo != null) {
            long j = this.aDd.aId.userId;
            long j2 = this.aDd.mLiveInfo.live_id;
            long j3 = this.aDd.mLiveInfo.room_id;
            String str2 = this.aDd.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aDd.aId.nickName, this.aDd.aId.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bjd);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bVr();
        } else if (fVar.bjq > 0) {
            eq(str, str2);
        }
    }

    private void bVr() {
        this.gXv = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gXv.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.b.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onConfirm() {
                if (b.this.bVs()) {
                    b.this.gXv.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
            public void onCancel() {
                b.this.gXv.dismiss();
            }
        });
        bn IV = com.baidu.live.guardclub.g.IT().IV();
        this.gXv.ad(0, IV != null ? IV.aPq : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eq(String str, final String str2) {
        JSONException e;
        boolean z;
        boolean z2;
        boolean z3 = false;
        bn IV = com.baidu.live.guardclub.g.IT().IV();
        if (IV != null && IV.aPo > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b2 = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.xc().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dN = com.baidu.tieba.ala.guardclub.model.a.dN(jSONArray.optJSONObject(i));
                            if (dN != null && dN.date.equals(b2)) {
                                if (dN.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dN);
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
                            com.baidu.live.d.xc().putString("guardclub_attenuat_daily", jSONArray2.toString());
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
                aVar.brp = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.brp >= IV.aPo) {
                        z3 = true;
                    } else {
                        aVar2.brp++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            if (!z3) {
                this.gXv = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gXv.a(new a.InterfaceC0635a() { // from class: com.baidu.tieba.ala.guardclub.b.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0635a
                    public void onConfirm() {
                        b.this.gXv.dismiss();
                        if (b.this.gXs != null) {
                            b.this.gXs.IY();
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
                this.gXv.ad(1, IV.aPp);
            }
            com.baidu.live.d.xc().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVs() {
        long j;
        if (this.gXu == null) {
            return false;
        }
        bn IV = com.baidu.live.guardclub.g.IT().IV();
        if (IV == null || IV.aPj <= 0) {
            j = 1000;
        } else {
            j = IV.aPj;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            ux(this.gXu.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void ux(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dp(i);
        cVar.a(this.gXu);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVt() {
        if (this.aDd != null && this.aDd.aId != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aDd.aId.userId);
            bVar.setParams();
            bVar.setTag(this.gOC);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
