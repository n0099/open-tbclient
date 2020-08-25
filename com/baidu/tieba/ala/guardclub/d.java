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
/* loaded from: classes7.dex */
public class d {
    private long aCu;
    private boolean aEw;
    private String aNZ;
    private com.baidu.live.guardclub.a aXT;
    private GuardClubInfoActivity fZL;
    private boolean fZM;
    private e fZN;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fRa = BdUniqueId.gen();
    private View.OnClickListener fZO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bJW();
        }
    };
    private HttpMessageListener fZx = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fZN != null) {
                    d.this.fZN.bJZ();
                }
            } else if (d.this.fZN != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fRa && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXT != null) {
                d.this.aXT = guardClubInfoHttpResponseMessage.aXT;
                d.this.fZN.a(guardClubInfoHttpResponseMessage.aXT, guardClubInfoHttpResponseMessage.aXU, guardClubInfoHttpResponseMessage.aXV, guardClubInfoHttpResponseMessage.aXW, guardClubInfoHttpResponseMessage.aXY);
            }
        }
    };
    HttpMessageListener fZA = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aXT != null && d.this.aXT.id == guardClubJoinHttpResponseMessage.aYb) {
                        d.this.bJW();
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
    HttpMessageListener fZP = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aXT;
                if (aVar != null && d.this.aXT != null && d.this.aXT.id == aVar.id) {
                    if (d.this.fZN != null) {
                        d.this.fZN.Ft(aVar.aXH);
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
    private HttpMessageListener bkd = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).LM() != null) {
                    d.this.bJW();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.fZL = guardClubInfoActivity;
        this.aCu = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aNZ = str;
        this.aEw = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fZM = z4;
        this.isTranslucent = z5;
        this.fZN = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.fZO);
        MessageManager.getInstance().registerListener(this.fZx);
        MessageManager.getInstance().registerListener(this.fZA);
        MessageManager.getInstance().registerListener(this.bkd);
        MessageManager.getInstance().registerListener(this.fZP);
        bJW();
    }

    public View getView() {
        return this.fZN.getView();
    }

    public void Fq() {
        if (this.fZN != null) {
            this.fZN.Fq();
        }
    }

    public void bJW() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ag(this.aCu);
            bVar.setParams();
            bVar.setTag(this.fRa);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fZN != null) {
            this.fZN.bJZ();
        }
    }

    public void onDestroy() {
        this.fZN.onDestory();
        if (this.fZx != null) {
            MessageManager.getInstance().unRegisterListener(this.fZx);
        }
        if (this.fZA != null) {
            MessageManager.getInstance().unRegisterListener(this.fZA);
        }
        if (this.bkd != null) {
            MessageManager.getInstance().unRegisterListener(this.bkd);
        }
        if (this.fZP != null) {
            MessageManager.getInstance().unRegisterListener(this.fZP);
        }
    }
}
