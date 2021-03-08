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
    private boolean aLc;
    private String aYp;
    private long anchorId;
    private com.baidu.live.guardclub.a bky;
    private GuardClubInfoActivity gZH;
    private boolean gZI;
    private f gZJ;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gQz = BdUniqueId.gen();
    private View.OnClickListener gZK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.bVG();
        }
    };
    private HttpMessageListener gZt = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (e.this.gZJ != null) {
                    e.this.gZJ.bVJ();
                }
            } else if (e.this.gZJ != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == e.this.gQz && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bky != null) {
                e.this.bky = guardClubInfoHttpResponseMessage.bky;
                e.this.gZJ.a(guardClubInfoHttpResponseMessage.bky, guardClubInfoHttpResponseMessage.bkz, guardClubInfoHttpResponseMessage.bkB, guardClubInfoHttpResponseMessage.bkA, guardClubInfoHttpResponseMessage.bkC, guardClubInfoHttpResponseMessage.bkD, guardClubInfoHttpResponseMessage.bkF);
            }
        }
    };
    HttpMessageListener gZw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.e.3
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
                    if (e.this.bky != null && e.this.bky.id == guardClubJoinHttpResponseMessage.bkI) {
                        e.this.bVG();
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
    HttpMessageListener gZL = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.e.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bky;
                if (aVar != null && e.this.bky != null && e.this.bky.id == aVar.id) {
                    if (e.this.gZJ != null) {
                        e.this.gZJ.Ha(aVar.bkl);
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
    private HttpMessageListener bCv = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).OB() != null) {
                    e.this.bVG();
                }
            }
        }
    };

    public e(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gZH = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aYp = str;
        this.aLc = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gZI = z4;
        this.isTranslucent = z5;
        this.gZJ = new f(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gZK);
        MessageManager.getInstance().registerListener(this.gZt);
        MessageManager.getInstance().registerListener(this.gZw);
        MessageManager.getInstance().registerListener(this.bCv);
        MessageManager.getInstance().registerListener(this.gZL);
        bVG();
    }

    public View getView() {
        return this.gZJ.getView();
    }

    public void FQ() {
        if (this.gZJ != null) {
            this.gZJ.FQ();
        }
    }

    public final void bVG() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gQz);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gZJ != null) {
            this.gZJ.bVJ();
        }
    }

    public void onDestroy() {
        this.gZJ.onDestory();
        if (this.gZt != null) {
            MessageManager.getInstance().unRegisterListener(this.gZt);
        }
        if (this.gZw != null) {
            MessageManager.getInstance().unRegisterListener(this.gZw);
        }
        if (this.bCv != null) {
            MessageManager.getInstance().unRegisterListener(this.bCv);
        }
        if (this.gZL != null) {
            MessageManager.getInstance().unRegisterListener(this.gZL);
        }
    }
}
