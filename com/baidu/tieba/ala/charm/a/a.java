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
/* loaded from: classes7.dex */
public class a implements d {
    private String aAG;
    private boolean bbJ;
    private String fPL;
    private com.baidu.tieba.ala.charm.model.a fPQ;
    private b fQO;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fQP = true;
    a.InterfaceC0597a fPU = new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fQO.hideLoadingView();
            a.this.fQO.completePullRefresh();
            a.this.fQO.aa(aLaCharmDataList.data);
            a.this.fQP = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void ay(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fQO.completePullRefresh();
            a.this.fQO.hideLoadingView();
            a.this.fQO.bIu();
            a.this.fQP = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fQQ = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fPQ != null) {
                a.this.fPQ.bE(1, 10);
            }
        }
    };
    private CustomMessageListener bab = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fQO != null) {
                        a.this.fQO.at(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fQO != null) {
                        a.this.fQO.at(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Qx().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.bab);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fQO == null) {
            this.fQO = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bbJ, this.aAG);
            this.fQO.Fb(this.fPL);
            this.fQO.a(this.fQQ);
        }
        this.fPQ = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fPU);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fQO.showLoadingView();
            this.fPQ.bE(1, 10);
        }
    }

    public a EX(String str) {
        this.mGroupId = str;
        return this;
    }

    public a EY(String str) {
        this.mLiveId = str;
        return this;
    }

    public a EZ(String str) {
        this.mUid = str;
        return this;
    }

    public a Fa(String str) {
        this.fPL = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fQO == null) {
            createView();
        }
        if (this.fQO == null) {
            return null;
        }
        return this.fQO.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        MessageManager.getInstance().unRegisterListener(this.bab);
        if (this.fPQ != null) {
            this.fPQ.onDestroy();
        }
        if (this.fQO != null) {
            this.fQO.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fQO != null) {
            this.fQO.onSkinTypeChanged(i);
        }
    }
}
