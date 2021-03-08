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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.guardclub.h {
    private ab aED;
    private ViewGroup bSB;
    protected Context context;
    private com.baidu.live.guardclub.l gZp;
    protected com.baidu.tieba.ala.guardclub.view.b gZq;
    private com.baidu.live.guardclub.a gZr;
    private com.baidu.tieba.ala.guardclub.view.a gZs;
    private boolean isHost;
    private String otherParams;
    private BdUniqueId gQz = BdUniqueId.gen();
    private boolean bkD = false;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.aED != null && b.this.aED.aJD != null && ViewHelper.checkUpIsLogin(b.this.context)) {
                b.this.GZ("");
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
    private HttpMessageListener gZt = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.aED != null && b.this.aED.aJD != null && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bky != null && guardClubInfoHttpResponseMessage.bky.anchorId == b.this.aED.aJD.userId) {
                    b.this.gZr = guardClubInfoHttpResponseMessage.bky;
                    b.this.bkD = guardClubInfoHttpResponseMessage.bkD;
                    if (b.this.gZq != null) {
                        b.this.gZq.b(b.this.bkD, guardClubInfoHttpResponseMessage.bkG);
                    }
                    if (b.this.bkD) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913120));
                    }
                    if ((httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.guardclub.b) && ((com.baidu.live.guardclub.b) httpResponsedMessage.getOrginalMessage()).IS()) {
                        b.this.a(String.valueOf(guardClubInfoHttpResponseMessage.bky.id), guardClubInfoHttpResponseMessage.bkH, guardClubInfoHttpResponseMessage.bkG, guardClubInfoHttpResponseMessage.bkz);
                    }
                }
            }
        }
    };
    CustomMessageListener gZu = new CustomMessageListener(2913106) { // from class: com.baidu.tieba.ala.guardclub.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                b.this.GZ((String) customResponsedMessage.getData());
            } else {
                b.this.GZ("");
            }
        }
    };
    CustomMessageListener gZv = new CustomMessageListener(2913119) { // from class: com.baidu.tieba.ala.guardclub.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bVF();
        }
    };
    HttpMessageListener gZw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.8
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
                    if (b.this.gZr != null && b.this.gZr.id == guardClubJoinHttpResponseMessage.bkI) {
                        b.this.bVG();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bkL) {
                    guardClubJoinHttpResponseMessage.bkL = true;
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
        MessageManager.getInstance().registerListener(this.gPp);
        MessageManager.getInstance().registerListener(this.gZt);
        MessageManager.getInstance().registerListener(this.gZu);
        MessageManager.getInstance().registerListener(this.gZv);
        MessageManager.getInstance().registerListener(this.gZw);
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gZq == null) {
            this.gZq = new com.baidu.tieba.ala.guardclub.view.b(this.context, this.isHost, this.onClickListener);
        }
        if (this.bSB != null && this.bSB.indexOfChild(this.gZq.getView()) >= 0) {
            this.bSB.removeView(this.gZq.getView());
        }
        this.bSB = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(com.baidu.live.guardclub.l lVar) {
        this.gZp = lVar;
    }

    @Override // com.baidu.live.guardclub.h
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ab abVar) {
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRp != null && bvVar.aRp.aTU) {
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && au(viewGroup)) {
                this.aED = abVar;
                this.gZr = null;
                this.gZq.reset();
            }
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void xk() {
        this.gZr = null;
        if (this.gZs != null) {
            this.gZs.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gPp);
        MessageManager.getInstance().unRegisterListener(this.gZt);
        MessageManager.getInstance().unRegisterListener(this.gZu);
        MessageManager.getInstance().unRegisterListener(this.gZv);
        MessageManager.getInstance().unRegisterListener(this.gZw);
        if (this.gZq != null) {
            this.gZq.onDestroy();
        }
        if (this.gZs != null) {
            this.gZs.dismiss();
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(String str) {
        if (this.context != null && this.aED != null && this.aED.aJD != null && this.aED.mLiveInfo != null) {
            long j = this.aED.aJD.userId;
            long j2 = this.aED.mLiveInfo.live_id;
            long j3 = this.aED.mLiveInfo.room_id;
            String str2 = this.aED.mLiveInfo.feed_id;
            GuardClubInfoActivityConfig guardClubInfoActivityConfig = new GuardClubInfoActivityConfig(this.context, j, j2, this.isHost, this.otherParams, false, str);
            guardClubInfoActivityConfig.setRoomId(j3);
            guardClubInfoActivityConfig.setFeedId(str2);
            guardClubInfoActivityConfig.setAnchorInfo(this.aED.aJD.nickName, this.aED.aJD.portrait);
            guardClubInfoActivityConfig.setIsClubMember(this.bkD);
            guardClubInfoActivityConfig.setRequestCode(RequestResponseCode.REQUEST_GUARD_CLUB_INFO);
            guardClubInfoActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, guardClubInfoActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, com.baidu.live.guardclub.f fVar, String str2) {
        if (z) {
            bVE();
        } else if (fVar.bkQ > 0) {
            eq(str, str2);
        }
    }

    private void bVE() {
        this.gZs = new com.baidu.tieba.ala.guardclub.view.a(this.context);
        this.gZs.a(new a.InterfaceC0642a() { // from class: com.baidu.tieba.ala.guardclub.b.2
            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0642a
            public void onConfirm() {
                if (b.this.bVF()) {
                    b.this.gZs.dismiss();
                }
            }

            @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0642a
            public void onCancel() {
                b.this.gZs.dismiss();
            }
        });
        bn IY = com.baidu.live.guardclub.g.IW().IY();
        this.gZs.ad(0, IY != null ? IY.aQQ : "");
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
        bn IY = com.baidu.live.guardclub.g.IW().IY();
        if (IY != null && IY.aQO > 0) {
            ArrayList<com.baidu.tieba.ala.guardclub.model.a> arrayList = new ArrayList();
            String b = com.baidu.live.utils.k.b(new Date());
            String string = com.baidu.live.d.xf().getString("guardclub_attenuat_daily", "");
            if (TextUtils.isEmpty(string)) {
                z2 = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    z2 = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            com.baidu.tieba.ala.guardclub.model.a dP = com.baidu.tieba.ala.guardclub.model.a.dP(jSONArray.optJSONObject(i));
                            if (dP != null && dP.date.equals(b)) {
                                if (dP.id.equals(str)) {
                                    z2 = true;
                                }
                                arrayList.add(dP);
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
                aVar.date = b;
                aVar.bsP = 0;
                arrayList.add(aVar);
            }
            JSONArray jSONArray22 = new JSONArray();
            for (com.baidu.tieba.ala.guardclub.model.a aVar2 : arrayList) {
                if (aVar2.id.equals(str)) {
                    if (aVar2.bsP >= IY.aQO) {
                        z3 = true;
                    } else {
                        aVar2.bsP++;
                    }
                }
                try {
                    jSONArray22.put(new JSONObject(aVar2.toJsonString()));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            if (!z3) {
                this.gZs = new com.baidu.tieba.ala.guardclub.view.a(this.context);
                this.gZs.a(new a.InterfaceC0642a() { // from class: com.baidu.tieba.ala.guardclub.b.3
                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0642a
                    public void onConfirm() {
                        b.this.gZs.dismiss();
                        if (b.this.gZp != null) {
                            b.this.gZp.Jb();
                        }
                    }

                    @Override // com.baidu.tieba.ala.guardclub.view.a.InterfaceC0642a
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
                this.gZs.ad(1, IY.aQP);
            }
            com.baidu.live.d.xf().putString("guardclub_attenuat_daily", jSONArray22.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVF() {
        long j;
        if (this.gZr == null) {
            return false;
        }
        bn IY = com.baidu.live.guardclub.g.IW().IY();
        if (IY == null || IY.aQJ <= 0) {
            j = 1000;
        } else {
            j = IY.aQJ;
        }
        if (TbadkCoreApplication.getInst().currentAccountTdouNum >= j) {
            uz(this.gZr.id);
            return true;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.context, 0L, this.otherParams, true, "", true)));
        return false;
    }

    public void uz(int i) {
        com.baidu.live.guardclub.c cVar = new com.baidu.live.guardclub.c();
        cVar.dq(i);
        cVar.a(this.gZr);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void bVG() {
        if (this.aED != null && this.aED.aJD != null) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.aED.aJD.userId);
            bVar.setParams();
            bVar.setTag(this.gQz);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.guardclub.h
    public void setHost(boolean z) {
        this.isHost = z;
    }
}
