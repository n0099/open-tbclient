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
public class e {
    private boolean aLj;
    private String aWR;
    private long anchorId;
    private com.baidu.live.guardclub.a bja;
    private GuardClubInfoActivity gNR;
    private boolean gNS;
    private f gNT;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gEP = BdUniqueId.gen();
    private View.OnClickListener gNU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bVZ();
        }
    };
    private HttpMessageListener gND = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (e.this.gNT != null) {
                    e.this.gNT.bWc();
                }
            } else if (e.this.gNT != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == e.this.gEP && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bja != null) {
                e.this.bja = guardClubInfoHttpResponseMessage.bja;
                e.this.gNT.a(guardClubInfoHttpResponseMessage.bja, guardClubInfoHttpResponseMessage.bjb, guardClubInfoHttpResponseMessage.bjd, guardClubInfoHttpResponseMessage.bjc, guardClubInfoHttpResponseMessage.bje, guardClubInfoHttpResponseMessage.bjf, guardClubInfoHttpResponseMessage.bjh);
            }
        }
    };
    HttpMessageListener gNG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.e.3
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
                    if (e.this.bja != null && e.this.bja.id == guardClubJoinHttpResponseMessage.bjk) {
                        e.this.bVZ();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bjn) {
                    guardClubJoinHttpResponseMessage.bjn = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gNV = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.e.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bja;
                if (aVar != null && e.this.bja != null && e.this.bja.id == aVar.id) {
                    if (e.this.gNT != null) {
                        e.this.gNT.HD(aVar.biN);
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
    private HttpMessageListener bxt = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).PW() != null) {
                    e.this.bVZ();
                }
            }
        }
    };

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gNR = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aWR = str;
        this.aLj = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gNS = z4;
        this.isTranslucent = z5;
        this.gNT = new f(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gNU);
        MessageManager.getInstance().registerListener(this.gND);
        MessageManager.getInstance().registerListener(this.gNG);
        MessageManager.getInstance().registerListener(this.bxt);
        MessageManager.getInstance().registerListener(this.gNV);
        bVZ();
    }

    public View getView() {
        return this.gNT.getView();
    }

    public void IR() {
        if (this.gNT != null) {
            this.gNT.IR();
        }
    }

    public void bVZ() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gEP);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gNT != null) {
            this.gNT.bWc();
        }
    }

    public void onDestroy() {
        this.gNT.onDestory();
        if (this.gND != null) {
            MessageManager.getInstance().unRegisterListener(this.gND);
        }
        if (this.gNG != null) {
            MessageManager.getInstance().unRegisterListener(this.gNG);
        }
        if (this.bxt != null) {
            MessageManager.getInstance().unRegisterListener(this.bxt);
        }
        if (this.gNV != null) {
            MessageManager.getInstance().unRegisterListener(this.gNV);
        }
    }
}
