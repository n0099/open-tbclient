package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes4.dex */
public class a implements d {
    private String aBm;
    private boolean bej;
    private String fSW;
    private b fTZ;
    private com.baidu.tieba.ala.charm.model.a fTb;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fUa = true;
    a.InterfaceC0593a fTf = new a.InterfaceC0593a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0593a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fTZ.hideLoadingView();
            a.this.fTZ.completePullRefresh();
            a.this.fTZ.aa(aLaCharmDataList.data);
            a.this.fUa = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0593a
        public void az(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fTZ.completePullRefresh();
            a.this.fTZ.hideLoadingView();
            a.this.fTZ.bJC();
            a.this.fUa = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fUb = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fTb != null) {
                a.this.fTb.bE(1, 10);
            }
        }
    };
    private CustomMessageListener bcz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fTZ != null) {
                        a.this.fTZ.at(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Rg().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fTZ != null) {
                        a.this.fTZ.at(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Rg().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.bcz);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fTZ == null) {
            this.fTZ = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bej, this.aBm);
            this.fTZ.Fz(this.fSW);
            this.fTZ.a(this.fUb);
        }
        this.fTb = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fTf);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fTZ.showLoadingView();
            this.fTb.bE(1, 10);
        }
    }

    public a Fv(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Fw(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Fx(String str) {
        this.mUid = str;
        return this;
    }

    public a Fy(String str) {
        this.fSW = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fTZ == null) {
            createView();
        }
        if (this.fTZ == null) {
            return null;
        }
        return this.fTZ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
        return (short) 3;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bcz);
        if (this.fTb != null) {
            this.fTb.onDestroy();
        }
        if (this.fTZ != null) {
            this.fTZ.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fTZ != null) {
            this.fTZ.onSkinTypeChanged(i);
        }
    }
}
