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
    private String aFp;
    private boolean bkL;
    private String gvg;
    private com.baidu.tieba.ala.charm.model.a gvl;
    private b gwj;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gwk = true;
    a.InterfaceC0638a gvp = new a.InterfaceC0638a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gwj.hideLoadingView();
            a.this.gwj.completePullRefresh();
            a.this.gwj.aa(aLaCharmDataList.data);
            a.this.gwk = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0638a
        public void t(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gwj.completePullRefresh();
            a.this.gwj.hideLoadingView();
            a.this.gwj.bRo();
            a.this.gwk = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gwl = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gvl != null) {
                a.this.gvl.bF(1, 10);
            }
        }
    };
    private CustomMessageListener biW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gwj != null) {
                        a.this.gwj.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gwj != null) {
                        a.this.gwj.az(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Wx().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.biW);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gwj == null) {
            this.gwj = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bkL, this.aFp);
            this.gwj.setCharmValue(this.gvg);
            this.gwj.a(this.gwl);
        }
        this.gvl = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gvp);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gwj.showLoadingView();
            this.gvl.bF(1, 10);
        }
    }

    public a GT(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GU(String str) {
        this.mLiveId = str;
        return this;
    }

    public a GV(String str) {
        this.mUid = str;
        return this;
    }

    public a GW(String str) {
        this.gvg = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gwj == null) {
            createView();
        }
        if (this.gwj == null) {
            return null;
        }
        return this.gwj.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        MessageManager.getInstance().unRegisterListener(this.biW);
        if (this.gvl != null) {
            this.gvl.onDestroy();
        }
        if (this.gwj != null) {
            this.gwj.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gwj != null) {
            this.gwj.onSkinTypeChanged(i);
        }
    }
}
