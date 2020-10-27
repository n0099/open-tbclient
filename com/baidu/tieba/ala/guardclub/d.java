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
    private boolean aJi;
    private String aUg;
    private long anchorId;
    private com.baidu.live.guardclub.a bfe;
    private e gzA;
    private GuardClubInfoActivity gzy;
    private boolean gzz;
    private boolean isFullScreen;
    private boolean isTranslucent;
    private long liveId;
    private String otherParams;
    private long roomId;
    private BdUniqueId gqL = BdUniqueId.gen();
    private View.OnClickListener gzB = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bQw();
        }
    };
    private HttpMessageListener gzk = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.guardclub.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.hasError() || !(httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                if (d.this.gzA != null) {
                    d.this.gzA.bQz();
                }
            } else if (d.this.gzA != null && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == d.this.gqL && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bfe != null) {
                d.this.bfe = guardClubInfoHttpResponseMessage.bfe;
                d.this.gzA.a(guardClubInfoHttpResponseMessage.bfe, guardClubInfoHttpResponseMessage.bff, guardClubInfoHttpResponseMessage.bfg, guardClubInfoHttpResponseMessage.bfh, guardClubInfoHttpResponseMessage.bfj);
            }
        }
    };
    HttpMessageListener gzn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
                    if (d.this.bfe != null && d.this.bfe.id == guardClubJoinHttpResponseMessage.bfm) {
                        d.this.bQw();
                    }
                } else if (!guardClubJoinHttpResponseMessage.bfp) {
                    guardClubJoinHttpResponseMessage.bfp = true;
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "加入真爱团失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                }
            }
        }
    };
    HttpMessageListener gzC = new HttpMessageListener(1021142) { // from class: com.baidu.tieba.ala.guardclub.d.4
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bfe;
                if (aVar != null && d.this.bfe != null && d.this.bfe.id == aVar.id) {
                    if (d.this.gzA != null) {
                        d.this.gzA.Hb(aVar.beR);
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
    private HttpMessageListener bsB = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.d.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).NM() != null) {
                    d.this.bQw();
                }
            }
        }
    };

    public d(GuardClubInfoActivity guardClubInfoActivity, long j, long j2, long j3, String str, boolean z, String str2, boolean z2, boolean z3, boolean z4, String str3, boolean z5, String str4, String str5) {
        this.gzy = guardClubInfoActivity;
        this.anchorId = j;
        this.liveId = j2;
        this.roomId = j3;
        this.aUg = str;
        this.aJi = z;
        this.otherParams = str2;
        this.isFullScreen = z2;
        this.gzz = z4;
        this.isTranslucent = z5;
        this.gzA = new e(guardClubInfoActivity, j, j2, j3, str, z, str2, z2, z3, z4, str3, z5, str4, str5, this.gzB);
        MessageManager.getInstance().registerListener(this.gzk);
        MessageManager.getInstance().registerListener(this.gzn);
        MessageManager.getInstance().registerListener(this.bsB);
        MessageManager.getInstance().registerListener(this.gzC);
        bQw();
    }

    public View getView() {
        return this.gzA.getView();
    }

    public void Hi() {
        if (this.gzA != null) {
            this.gzA.Hi();
        }
    }

    public void bQw() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            bVar.setAnchorId(this.anchorId);
            bVar.setParams();
            bVar.setTag(this.gqL);
            MessageManager.getInstance().sendMessage(bVar);
        } else if (this.gzA != null) {
            this.gzA.bQz();
        }
    }

    public void onDestroy() {
        this.gzA.onDestory();
        if (this.gzk != null) {
            MessageManager.getInstance().unRegisterListener(this.gzk);
        }
        if (this.gzn != null) {
            MessageManager.getInstance().unRegisterListener(this.gzn);
        }
        if (this.bsB != null) {
            MessageManager.getInstance().unRegisterListener(this.bsB);
        }
        if (this.gzC != null) {
            MessageManager.getInstance().unRegisterListener(this.gzC);
        }
    }
}
