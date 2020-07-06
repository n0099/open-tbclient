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
/* loaded from: classes3.dex */
public class d {
    private String aHt;
    private com.baidu.live.guardclub.a aRm;
    private long awn;
    private boolean axZ;
    private GuardClubInfoActivity fIs;
    private boolean fIt;
    private e fIu;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId fAz = BdUniqueId.gen();
    private View.OnClickListener fIv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bxl();
        }
    };
    private HttpMessageListener fIe = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.fIu != null) {
                    d.this.fIu.bxo();
                }
            } else if (d.this.fIu != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.fAz && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.aRm != null) {
                d.this.aRm = guardClubInfoHttpResponseMessage.aRm;
                d.this.fIu.a(guardClubInfoHttpResponseMessage.aRm, guardClubInfoHttpResponseMessage.aRn, guardClubInfoHttpResponseMessage.aRo, guardClubInfoHttpResponseMessage.aRp, guardClubInfoHttpResponseMessage.aRr);
            }
        }
    };
    HttpMessageListener fIh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.aRm != null && d.this.aRm.id == guardClubJoinHttpResponseMessage.aRu) {
                        d.this.bxl();
                    }
                } else if (!guardClubJoinHttpResponseMessage.aRx) {
                    guardClubJoinHttpResponseMessage.aRx = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener fIw = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).aRm;
                if (aVar != null && d.this.aRm != null && d.this.aRm.id == aVar.id) {
                    if (d.this.fIu != null) {
                        d.this.fIu.Cm(aVar.aRa);
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
    private HttpMessageListener bdY = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).Ge() != null) {
                    d.this.bxl();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.fIs = guardClubInfoActivity;
        this.awn = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aHt = str;
        this.axZ = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.fIt = z4;
        this.isTranslucent = z5;
        this.fIu = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.fIv);
        MessageManager.getInstance().registerListener(this.fIe);
        MessageManager.getInstance().registerListener(this.fIh);
        MessageManager.getInstance().registerListener(this.bdY);
        MessageManager.getInstance().registerListener(this.fIw);
        bxl();
    }

    public View getView() {
        return this.fIu.getView();
    }

    public void zl() {
        if (this.fIu != null) {
            this.fIu.zl();
        }
    }

    public void bxl() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.af(this.awn);
            bVar.setParams();
            bVar.setTag(this.fAz);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.fIu != null) {
            this.fIu.bxo();
        }
    }

    public void onDestroy() {
        this.fIu.onDestory();
        if (this.fIe != null) {
            MessageManager.getInstance().unRegisterListener(this.fIe);
        }
        if (this.fIh != null) {
            MessageManager.getInstance().unRegisterListener(this.fIh);
        }
        if (this.bdY != null) {
            MessageManager.getInstance().unRegisterListener(this.bdY);
        }
        if (this.fIw != null) {
            MessageManager.getInstance().unRegisterListener(this.fIw);
        }
    }
}
