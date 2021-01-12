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
    private String aBO;
    private boolean bkm;
    private String gKE;
    private com.baidu.tieba.ala.charm.model.a gKJ;
    private b gLG;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gLH = true;
    a.InterfaceC0624a gKN = new a.InterfaceC0624a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gLG.hideLoadingView();
            a.this.gLG.completePullRefresh();
            a.this.gLG.W(aLaCharmDataList.data);
            a.this.gLH = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0624a
        public void w(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gLG.completePullRefresh();
            a.this.gLG.hideLoadingView();
            a.this.gLG.bTf();
            a.this.gLH = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gLI = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gKJ != null) {
                a.this.gKJ.bG(1, 10);
            }
        }
    };
    private CustomMessageListener aSd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gLG != null) {
                        a.this.gLG.aB(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.VF().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gLG != null) {
                        a.this.gLG.aB(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.VF().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aSd);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gLG == null) {
            this.gLG = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bkm, this.aBO);
            this.gLG.FZ(this.gKE);
            this.gLG.a(this.gLI);
        }
        this.gKJ = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gKN);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gLG.showLoadingView();
            this.gKJ.bG(1, 10);
        }
    }

    public a FV(String str) {
        this.mGroupId = str;
        return this;
    }

    public a FW(String str) {
        this.mLiveId = str;
        return this;
    }

    public a FX(String str) {
        this.mUid = str;
        return this;
    }

    public a FY(String str) {
        this.gKE = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gLG == null) {
            createView();
        }
        if (this.gLG == null) {
            return null;
        }
        return this.gLG.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        MessageManager.getInstance().unRegisterListener(this.aSd);
        if (this.gKJ != null) {
            this.gKJ.onDestroy();
        }
        if (this.gLG != null) {
            this.gLG.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gLG != null) {
            this.gLG.onSkinTypeChanged(i);
        }
    }
}
