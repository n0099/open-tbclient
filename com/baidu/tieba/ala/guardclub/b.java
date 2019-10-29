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
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
/* loaded from: classes6.dex */
public class b {
    private long OF;
    private boolean PW;
    private String WX;
    private GuardClubInfoActivity dLb;
    private boolean dLc;
    private com.baidu.tieba.ala.guardclub.model.c dLd;
    private c dLe;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId dFZ = BdUniqueId.gen();
    private View.OnClickListener dLf = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aLi();
        }
    };
    private HttpMessageListener dLg = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (b.this.dLe != null) {
                    b.this.dLe.aLk();
                }
            } else if (b.this.dLe != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == b.this.dFZ && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.dLd != null) {
                b.this.dLd = guardClubInfoHttpResponseMessage.dLd;
                b.this.dLe.a(guardClubInfoHttpResponseMessage.dLd, guardClubInfoHttpResponseMessage.dLG, guardClubInfoHttpResponseMessage.dOj, guardClubInfoHttpResponseMessage.dLJ, guardClubInfoHttpResponseMessage.dOl);
            }
        }
    };
    HttpMessageListener dLh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.b.3
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
                    if (b.this.dLd != null && b.this.dLd.id == guardClubJoinHttpResponseMessage.dOq) {
                        b.this.aLi();
                    }
                } else if (!guardClubJoinHttpResponseMessage.dOt) {
                    guardClubJoinHttpResponseMessage.dOt = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener dLi = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.b.4
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
                com.baidu.tieba.ala.guardclub.model.c cVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).dLd;
                if (cVar != null && b.this.dLd != null && b.this.dLd.id == cVar.id) {
                    if (b.this.dLe != null) {
                        b.this.dLe.tj(cVar.dNX);
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
    private HttpMessageListener akQ = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).us() != null) {
                    b.this.aLi();
                }
            }
        }
    };

    public b(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5) {
        this.dLb = guardClubInfoActivity;
        this.OF = j;
        this.liveId = j2;
        this.roomId = j3;
        this.WX = str;
        this.PW = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.dLc = z4;
        this.isTranslucent = z5;
        this.dLe = new c(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, this.dLf);
        MessageManager.getInstance().registerListener(this.dLg);
        MessageManager.getInstance().registerListener(this.dLh);
        MessageManager.getInstance().registerListener(this.akQ);
        MessageManager.getInstance().registerListener(this.dLi);
        aLi();
    }

    public View getView() {
        return this.dLe.getView();
    }

    public void pZ() {
        if (this.dLe != null) {
            this.dLe.pZ();
        }
    }

    public void aLi() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
            dVar.ca(this.OF);
            dVar.setParams();
            dVar.setTag(this.dFZ);
            MessageManager.getInstance().sendMessage(dVar);
        } else if (this.dLe != null) {
            this.dLe.aLk();
        }
    }

    public void onDestroy() {
        this.dLe.onDestory();
        if (this.dLg != null) {
            MessageManager.getInstance().unRegisterListener(this.dLg);
        }
        if (this.dLh != null) {
            MessageManager.getInstance().unRegisterListener(this.dLh);
        }
        if (this.akQ != null) {
            MessageManager.getInstance().unRegisterListener(this.akQ);
        }
        if (this.dLi != null) {
            MessageManager.getInstance().unRegisterListener(this.dLi);
        }
    }
}
