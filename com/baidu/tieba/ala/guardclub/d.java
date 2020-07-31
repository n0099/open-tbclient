package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
/* loaded from: classes4.dex */
public class d {
    private String aIO;
    private com.baidu.live.guardclub.a aSF;
    private long axs;
    private boolean azm;
    private GuardClubInfoActivity fNN;
    private boolean fNO;
    private e fNP;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fFJ = BdUniqueId.gen();
    private View.OnClickListener fNQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bAB();
        }
    };
    private HttpMessageListener fNz = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fNP != null) {
                    d.this.fNP.bAE();
                }
            } else if (d.this.fNP != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fFJ && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aSF != null) {
                d.this.aSF = guardClubInfoHttpResponseMessage.aSF;
                d.this.fNP.a(guardClubInfoHttpResponseMessage.aSF, guardClubInfoHttpResponseMessage.aSG, guardClubInfoHttpResponseMessage.aSH, guardClubInfoHttpResponseMessage.aSI, guardClubInfoHttpResponseMessage.aSK);
            }
        }
    };
    HttpMessageListener fNC = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aSF != null && d.this.aSF.id == guardClubJoinHttpResponseMessage.aSN) {
                        d.this.bAB();
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
    HttpMessageListener fNR = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021142) {
                if (!(httpResponsedMessage instanceof GuardClubInfoRenameResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString, 0);
                    return;
                }
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aSF;
                if (aVar != null && d.this.aSF != null && d.this.aSF.id == aVar.id) {
                    if (d.this.fNP != null) {
                        d.this.fNP.CY(aVar.aSt);
                        return;
                    }
                    return;
                }
                String errorString2 = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = "修改真爱团名称失败";
                }
                BdUtilHelper.getCustomToast().showToast(errorString2, 0);
            }
        }
    };
    private HttpMessageListener ber = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).FY() != null) {
                    d.this.bAB();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.fNN = guardClubInfoActivity;
        this.axs = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aIO = str;
        this.azm = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fNO = z4;
        this.isTranslucent = z5;
        this.fNP = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.fNQ);
        MessageManager.getInstance().registerListener(this.fNz);
        MessageManager.getInstance().registerListener(this.fNC);
        MessageManager.getInstance().registerListener(this.ber);
        MessageManager.getInstance().registerListener(this.fNR);
        bAB();
    }

    public View getView() {
        return this.fNP.getView();
    }

    public void zN() {
        if (this.fNP != null) {
            this.fNP.zN();
        }
    }

    public void bAB() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.axs);
            bVar.setParams();
            bVar.setTag(this.fFJ);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fNP != null) {
            this.fNP.bAE();
        }
    }

    public void onDestroy() {
        this.fNP.onDestory();
        if (this.fNz != null) {
            MessageManager.getInstance().unRegisterListener(this.fNz);
        }
        if (this.fNC != null) {
            MessageManager.getInstance().unRegisterListener(this.fNC);
        }
        if (this.ber != null) {
            MessageManager.getInstance().unRegisterListener(this.ber);
        }
        if (this.fNR != null) {
            MessageManager.getInstance().unRegisterListener(this.fNR);
        }
    }
}
