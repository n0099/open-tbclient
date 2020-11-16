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
    private String aDE;
    private boolean bja;
    private String guN;
    private com.baidu.tieba.ala.charm.model.a guS;
    private b gvQ;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gvR = true;
    a.InterfaceC0638a guW = new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gvQ.hideLoadingView();
            a.this.gvQ.completePullRefresh();
            a.this.gvQ.aa(aLaCharmDataList.data);
            a.this.gvR = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void t(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gvQ.completePullRefresh();
            a.this.gvQ.hideLoadingView();
            a.this.gvQ.bQH();
            a.this.gvR = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gvS = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.guS != null) {
                a.this.guS.bF(1, 10);
            }
        }
    };
    private CustomMessageListener bhi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gvQ != null) {
                        a.this.gvQ.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.VO().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gvQ != null) {
                        a.this.gvQ.az(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.VO().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.bhi);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gvQ == null) {
            this.gvQ = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bja, this.aDE);
            this.gvQ.setCharmValue(this.guN);
            this.gvQ.a(this.gvS);
        }
        this.guS = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.guW);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gvQ.showLoadingView();
            this.guS.bF(1, 10);
        }
    }

    public a Gu(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gv(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Gw(String str) {
        this.mUid = str;
        return this;
    }

    public a Gx(String str) {
        this.guN = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gvQ == null) {
            createView();
        }
        if (this.gvQ == null) {
            return null;
        }
        return this.gvQ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        MessageManager.getInstance().unRegisterListener(this.bhi);
        if (this.guS != null) {
            this.guS.onDestroy();
        }
        if (this.gvQ != null) {
            this.gvQ.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gvQ != null) {
            this.gvQ.onSkinTypeChanged(i);
        }
    }
}
