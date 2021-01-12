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
/* loaded from: classes10.dex */
public class e {
    private boolean aGY;
    private String aTK;
    private long anchorId;
    private com.baidu.live.guardclub.a bfP;
    private GuardClubInfoActivity gVa;
    private boolean gVb;
    private f gVc;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gLW = BdUniqueId.gen();
    private View.OnClickListener gVd = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bUO();
        }
    };
    private HttpMessageListener gUM = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (e.this.gVc != null) {
                    e.this.gVc.bUR();
                }
            } else if (e.this.gVc != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == e.this.gLW && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bfP != null) {
                e.this.bfP = guardClubInfoHttpResponseMessage.bfP;
                e.this.gVc.a(guardClubInfoHttpResponseMessage.bfP, guardClubInfoHttpResponseMessage.bfQ, guardClubInfoHttpResponseMessage.bfS, guardClubInfoHttpResponseMessage.bfR, guardClubInfoHttpResponseMessage.bfT, guardClubInfoHttpResponseMessage.bfU, guardClubInfoHttpResponseMessage.bfW);
            }
        }
    };
    HttpMessageListener gUP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.e.3
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
                    if (e.this.bfP != null && e.this.bfP.id == guardClubJoinHttpResponseMessage.bfZ) {
                        e.this.bUO();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bgc) {
                    guardClubJoinHttpResponseMessage.bgc = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gVe = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.e.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bfP;
                if (aVar != null && e.this.bfP != null && e.this.bfP.id == aVar.id) {
                    if (e.this.gVc != null) {
                        e.this.gVc.Gr(aVar.bfC);
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
    private HttpMessageListener bxs = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Na() != null) {
                    e.this.bUO();
                }
            }
        }
    };

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gVa = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aTK = str;
        this.aGY = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gVb = z4;
        this.isTranslucent = z5;
        this.gVc = new f(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gVd);
        MessageManager.getInstance().registerListener(this.gUM);
        MessageManager.getInstance().registerListener(this.gUP);
        MessageManager.getInstance().registerListener(this.bxs);
        MessageManager.getInstance().registerListener(this.gVe);
        bUO();
    }

    public View getView() {
        return this.gVc.getView();
    }

    public void Ex() {
        if (this.gVc != null) {
            this.gVc.Ex();
        }
    }

    public void bUO() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gLW);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gVc != null) {
            this.gVc.bUR();
        }
    }

    public void onDestroy() {
        this.gVc.onDestory();
        if (this.gUM != null) {
            MessageManager.getInstance().unRegisterListener(this.gUM);
        }
        if (this.gUP != null) {
            MessageManager.getInstance().unRegisterListener(this.gUP);
        }
        if (this.bxs != null) {
            MessageManager.getInstance().unRegisterListener(this.bxs);
        }
        if (this.gVe != null) {
            MessageManager.getInstance().unRegisterListener(this.gVe);
        }
    }
}
