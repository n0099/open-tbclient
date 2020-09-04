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
    private long aCw;
    private boolean aEy;
    private String aOb;
    private com.baidu.live.guardclub.a aXV;
    private GuardClubInfoActivity fZP;
    private boolean fZQ;
    private e fZR;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fRe = BdUniqueId.gen();
    private View.OnClickListener fZS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bJX();
        }
    };
    private HttpMessageListener fZB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fZR != null) {
                    d.this.fZR.bKa();
                }
            } else if (d.this.fZR != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fRe && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aXV != null) {
                d.this.aXV = guardClubInfoHttpResponseMessage.aXV;
                d.this.fZR.a(guardClubInfoHttpResponseMessage.aXV, guardClubInfoHttpResponseMessage.aXW, guardClubInfoHttpResponseMessage.aXX, guardClubInfoHttpResponseMessage.aXY, guardClubInfoHttpResponseMessage.aYa);
            }
        }
    };
    HttpMessageListener fZE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aXV != null && d.this.aXV.id == guardClubJoinHttpResponseMessage.aYd) {
                        d.this.bJX();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aYg) {
                    guardClubJoinHttpResponseMessage.aYg = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener fZT = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aXV;
                if (aVar != null && d.this.aXV != null && d.this.aXV.id == aVar.id) {
                    if (d.this.fZR != null) {
                        d.this.fZR.Fu(aVar.aXJ);
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
    private HttpMessageListener bkg = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).LM() != null) {
                    d.this.bJX();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.fZP = guardClubInfoActivity;
        this.aCw = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aOb = str;
        this.aEy = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fZQ = z4;
        this.isTranslucent = z5;
        this.fZR = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.fZS);
        MessageManager.getInstance().registerListener(this.fZB);
        MessageManager.getInstance().registerListener(this.fZE);
        MessageManager.getInstance().registerListener(this.bkg);
        MessageManager.getInstance().registerListener(this.fZT);
        bJX();
    }

    public View getView() {
        return this.fZR.getView();
    }

    public void Fq() {
        if (this.fZR != null) {
            this.fZR.Fq();
        }
    }

    public void bJX() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.ag(this.aCw);
            bVar.setParams();
            bVar.setTag(this.fRe);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fZR != null) {
            this.fZR.bKa();
        }
    }

    public void onDestroy() {
        this.fZR.onDestory();
        if (this.fZB != null) {
            MessageManager.getInstance().unRegisterListener(this.fZB);
        }
        if (this.fZE != null) {
            MessageManager.getInstance().unRegisterListener(this.fZE);
        }
        if (this.bkg != null) {
            MessageManager.getInstance().unRegisterListener(this.bkg);
        }
        if (this.fZT != null) {
            MessageManager.getInstance().unRegisterListener(this.fZT);
        }
    }
}
