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
/* loaded from: classes10.dex */
public class a implements d {
    private String aFb;
    private boolean bpf;
    private String gPh;
    private com.baidu.tieba.ala.charm.model.a gPm;
    private b gQj;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gQk = true;
    a.InterfaceC0630a gPq = new a.InterfaceC0630a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0630a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gQj.hideLoadingView();
            a.this.gQj.completePullRefresh();
            a.this.gQj.V(aLaCharmDataList.data);
            a.this.gQk = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0630a
        public void A(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gQj.completePullRefresh();
            a.this.gQj.hideLoadingView();
            a.this.gQj.bTV();
            a.this.gQk = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gQl = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gPm != null) {
                a.this.gPm.bE(1, 10);
            }
        }
    };
    private CustomMessageListener aWH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gQj != null) {
                        a.this.gQj.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Xr().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gQj != null) {
                        a.this.gQj.aA(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Xr().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aWH);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gQj == null) {
            this.gQj = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bpf, this.aFb);
            this.gQj.GI(this.gPh);
            this.gQj.a(this.gQl);
        }
        this.gPm = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gPq);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gQj.showLoadingView();
            this.gPm.bE(1, 10);
        }
    }

    public a GE(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GF(String str) {
        this.mLiveId = str;
        return this;
    }

    public a GG(String str) {
        this.mUid = str;
        return this;
    }

    public a GH(String str) {
        this.gPh = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gQj == null) {
            createView();
        }
        if (this.gQj == null) {
            return null;
        }
        return this.gQj.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        MessageManager.getInstance().unRegisterListener(this.aWH);
        if (this.gPm != null) {
            this.gPm.onDestroy();
        }
        if (this.gQj != null) {
            this.gQj.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gQj != null) {
            this.gQj.onSkinTypeChanged(i);
        }
    }
}
