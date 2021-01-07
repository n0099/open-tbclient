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
    private boolean aLL;
    private String aYx;
    private long anchorId;
    private com.baidu.live.guardclub.a bkF;
    private GuardClubInfoActivity gZG;
    private boolean gZH;
    private f gZI;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gQC = BdUniqueId.gen();
    private View.OnClickListener gZJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bYG();
        }
    };
    private HttpMessageListener gZs = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (e.this.gZI != null) {
                    e.this.gZI.bYJ();
                }
            } else if (e.this.gZI != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == e.this.gQC && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bkF != null) {
                e.this.bkF = guardClubInfoHttpResponseMessage.bkF;
                e.this.gZI.a(guardClubInfoHttpResponseMessage.bkF, guardClubInfoHttpResponseMessage.bkG, guardClubInfoHttpResponseMessage.bkI, guardClubInfoHttpResponseMessage.bkH, guardClubInfoHttpResponseMessage.bkJ, guardClubInfoHttpResponseMessage.bkK, guardClubInfoHttpResponseMessage.bkM);
            }
        }
    };
    HttpMessageListener gZv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.e.3
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
                    if (e.this.bkF != null && e.this.bkF.id == guardClubJoinHttpResponseMessage.bkP) {
                        e.this.bYG();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bkS) {
                    guardClubJoinHttpResponseMessage.bkS = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gZK = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.e.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bkF;
                if (aVar != null && e.this.bkF != null && e.this.bkF.id == aVar.id) {
                    if (e.this.gZI != null) {
                        e.this.gZI.HC(aVar.bks);
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
    private HttpMessageListener bCe = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).QV() != null) {
                    e.this.bYG();
                }
            }
        }
    };

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gZG = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aYx = str;
        this.aLL = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gZH = z4;
        this.isTranslucent = z5;
        this.gZI = new f(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gZJ);
        MessageManager.getInstance().registerListener(this.gZs);
        MessageManager.getInstance().registerListener(this.gZv);
        MessageManager.getInstance().registerListener(this.bCe);
        MessageManager.getInstance().registerListener(this.gZK);
        bYG();
    }

    public View getView() {
        return this.gZI.getView();
    }

    public void Is() {
        if (this.gZI != null) {
            this.gZI.Is();
        }
    }

    public void bYG() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gQC);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gZI != null) {
            this.gZI.bYJ();
        }
    }

    public void onDestroy() {
        this.gZI.onDestory();
        if (this.gZs != null) {
            MessageManager.getInstance().unRegisterListener(this.gZs);
        }
        if (this.gZv != null) {
            MessageManager.getInstance().unRegisterListener(this.gZv);
        }
        if (this.bCe != null) {
            MessageManager.getInstance().unRegisterListener(this.bCe);
        }
        if (this.gZK != null) {
            MessageManager.getInstance().unRegisterListener(this.gZK);
        }
    }
}
