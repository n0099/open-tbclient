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
    private boolean aKf;
    private String aVy;
    private long anchorId;
    private com.baidu.live.guardclub.a bgz;
    private GuardClubInfoActivity gFm;
    private boolean gFn;
    private e gFo;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gwz = BdUniqueId.gen();
    private View.OnClickListener gFp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bSW();
        }
    };
    private HttpMessageListener gEY = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.gFo != null) {
                    d.this.gFo.bSZ();
                }
            } else if (d.this.gFo != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.gwz && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bgz != null) {
                d.this.bgz = guardClubInfoHttpResponseMessage.bgz;
                d.this.gFo.a(guardClubInfoHttpResponseMessage.bgz, guardClubInfoHttpResponseMessage.bgA, guardClubInfoHttpResponseMessage.bgB, guardClubInfoHttpResponseMessage.bgC, guardClubInfoHttpResponseMessage.bgE);
            }
        }
    };
    HttpMessageListener gFb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.bgz != null && d.this.bgz.id == guardClubJoinHttpResponseMessage.bgH) {
                        d.this.bSW();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bgK) {
                    guardClubJoinHttpResponseMessage.bgK = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gFq = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bgz;
                if (aVar != null && d.this.bgz != null && d.this.bgz.id == aVar.id) {
                    if (d.this.gFo != null) {
                        d.this.gFo.Ho(aVar.bgm);
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
    private HttpMessageListener btW = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Om() != null) {
                    d.this.bSW();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gFm = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aVy = str;
        this.aKf = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gFn = z4;
        this.isTranslucent = z5;
        this.gFo = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gFp);
        MessageManager.getInstance().registerListener(this.gEY);
        MessageManager.getInstance().registerListener(this.gFb);
        MessageManager.getInstance().registerListener(this.btW);
        MessageManager.getInstance().registerListener(this.gFq);
        bSW();
    }

    public View getView() {
        return this.gFo.getView();
    }

    public void HJ() {
        if (this.gFo != null) {
            this.gFo.HJ();
        }
    }

    public void bSW() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gwz);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gFo != null) {
            this.gFo.bSZ();
        }
    }

    public void onDestroy() {
        this.gFo.onDestory();
        if (this.gEY != null) {
            MessageManager.getInstance().unRegisterListener(this.gEY);
        }
        if (this.gFb != null) {
            MessageManager.getInstance().unRegisterListener(this.gFb);
        }
        if (this.btW != null) {
            MessageManager.getInstance().unRegisterListener(this.btW);
        }
        if (this.gFq != null) {
            MessageManager.getInstance().unRegisterListener(this.gFq);
        }
    }
}
