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
/* loaded from: classes11.dex */
public class a implements d {
    private String aDB;
    private boolean bnF;
    private String gNk;
    private com.baidu.tieba.ala.charm.model.a gNp;
    private b gOm;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gOn = true;
    a.InterfaceC0623a gNt = new a.InterfaceC0623a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0623a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gOm.hideLoadingView();
            a.this.gOm.completePullRefresh();
            a.this.gOm.V(aLaCharmDataList.data);
            a.this.gOn = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0623a
        public void A(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gOm.completePullRefresh();
            a.this.gOm.hideLoadingView();
            a.this.gOm.bTI();
            a.this.gOn = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gOo = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gNp != null) {
                a.this.gNp.bD(1, 10);
            }
        }
    };
    private CustomMessageListener aVh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gOm != null) {
                        a.this.gOm.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gOm != null) {
                        a.this.gOm.aA(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Xo().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aVh);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gOm == null) {
            this.gOm = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bnF, this.aDB);
            this.gOm.Gy(this.gNk);
            this.gOm.a(this.gOo);
        }
        this.gNp = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gNt);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gOm.showLoadingView();
            this.gNp.bD(1, 10);
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
        this.gNk = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gOm == null) {
            createView();
        }
        if (this.gOm == null) {
            return null;
        }
        return this.gOm.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        MessageManager.getInstance().unRegisterListener(this.aVh);
        if (this.gNp != null) {
            this.gNp.onDestroy();
        }
        if (this.gOm != null) {
            this.gOm.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gOm != null) {
            this.gOm.onSkinTypeChanged(i);
        }
    }
}
