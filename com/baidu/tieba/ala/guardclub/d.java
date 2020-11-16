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
    private boolean aIu;
    private String aTN;
    private long anchorId;
    private com.baidu.live.guardclub.a beL;
    private GuardClubInfoActivity gET;
    private boolean gEU;
    private e gEV;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gwg = BdUniqueId.gen();
    private View.OnClickListener gEW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bSp();
        }
    };
    private HttpMessageListener gEF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.gEV != null) {
                    d.this.gEV.bSs();
                }
            } else if (d.this.gEV != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.gwg && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.beL != null) {
                d.this.beL = guardClubInfoHttpResponseMessage.beL;
                d.this.gEV.a(guardClubInfoHttpResponseMessage.beL, guardClubInfoHttpResponseMessage.beM, guardClubInfoHttpResponseMessage.beN, guardClubInfoHttpResponseMessage.beO, guardClubInfoHttpResponseMessage.beQ);
            }
        }
    };
    HttpMessageListener gEI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.beL != null && d.this.beL.id == guardClubJoinHttpResponseMessage.beT) {
                        d.this.bSp();
                    }
                } else if (!guardClubJoinHttpResponseMessage.beW) {
                    guardClubJoinHttpResponseMessage.beW = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gEX = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).beL;
                if (aVar != null && d.this.beL != null && d.this.beL.id == aVar.id) {
                    if (d.this.gEV != null) {
                        d.this.gEV.GP(aVar.bez);
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
    private HttpMessageListener bsk = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).ND() != null) {
                    d.this.bSp();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gET = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aTN = str;
        this.aIu = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gEU = z4;
        this.isTranslucent = z5;
        this.gEV = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gEW);
        MessageManager.getInstance().registerListener(this.gEF);
        MessageManager.getInstance().registerListener(this.gEI);
        MessageManager.getInstance().registerListener(this.bsk);
        MessageManager.getInstance().registerListener(this.gEX);
        bSp();
    }

    public View getView() {
        return this.gEV.getView();
    }

    public void Ha() {
        if (this.gEV != null) {
            this.gEV.Ha();
        }
    }

    public void bSp() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gwg);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gEV != null) {
            this.gEV.bSs();
        }
    }

    public void onDestroy() {
        this.gEV.onDestory();
        if (this.gEF != null) {
            MessageManager.getInstance().unRegisterListener(this.gEF);
        }
        if (this.gEI != null) {
            MessageManager.getInstance().unRegisterListener(this.gEI);
        }
        if (this.bsk != null) {
            MessageManager.getInstance().unRegisterListener(this.bsk);
        }
        if (this.gEX != null) {
            MessageManager.getInstance().unRegisterListener(this.gEX);
        }
    }
}
