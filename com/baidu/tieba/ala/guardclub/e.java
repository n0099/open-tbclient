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
/* loaded from: classes11.dex */
public class e {
    private boolean aJC;
    private String aWP;
    private long anchorId;
    private com.baidu.live.guardclub.a biY;
    private GuardClubInfoActivity gXK;
    private boolean gXL;
    private f gXM;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gOC = BdUniqueId.gen();
    private View.OnClickListener gXN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bVt();
        }
    };
    private HttpMessageListener gXw = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (e.this.gXM != null) {
                    e.this.gXM.bVw();
                }
            } else if (e.this.gXM != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == e.this.gOC && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.biY != null) {
                e.this.biY = guardClubInfoHttpResponseMessage.biY;
                e.this.gXM.a(guardClubInfoHttpResponseMessage.biY, guardClubInfoHttpResponseMessage.biZ, guardClubInfoHttpResponseMessage.bjb, guardClubInfoHttpResponseMessage.bja, guardClubInfoHttpResponseMessage.bjc, guardClubInfoHttpResponseMessage.bjd, guardClubInfoHttpResponseMessage.bjf);
            }
        }
    };
    HttpMessageListener gXz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.e.3
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
                    if (e.this.biY != null && e.this.biY.id == guardClubJoinHttpResponseMessage.bji) {
                        e.this.bVt();
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
    HttpMessageListener gXO = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.e.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).biY;
                if (aVar != null && e.this.biY != null && e.this.biY.id == aVar.id) {
                    if (e.this.gXM != null) {
                        e.this.gXM.GQ(aVar.biL);
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
    private HttpMessageListener bAV = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Oy() != null) {
                    e.this.bVt();
                }
            }
        }
    };

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gXK = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aWP = str;
        this.aJC = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gXL = z4;
        this.isTranslucent = z5;
        this.gXM = new f(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gXN);
        MessageManager.getInstance().registerListener(this.gXw);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.bAV);
        MessageManager.getInstance().registerListener(this.gXO);
        bVt();
    }

    public View getView() {
        return this.gXM.getView();
    }

    public void FN() {
        if (this.gXM != null) {
            this.gXM.FN();
        }
    }

    public final void bVt() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gOC);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gXM != null) {
            this.gXM.bVw();
        }
    }

    public void onDestroy() {
        this.gXM.onDestory();
        if (this.gXw != null) {
            MessageManager.getInstance().unRegisterListener(this.gXw);
        }
        if (this.gXz != null) {
            MessageManager.getInstance().unRegisterListener(this.gXz);
        }
        if (this.bAV != null) {
            MessageManager.getInstance().unRegisterListener(this.bAV);
        }
        if (this.gXO != null) {
            MessageManager.getInstance().unRegisterListener(this.gXO);
        }
    }
}
