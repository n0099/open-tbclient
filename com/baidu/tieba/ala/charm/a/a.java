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
    private String aGk;
    private boolean bns;
    private com.baidu.tieba.ala.charm.model.a gDD;
    private String gDy;
    private b gEB;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gEC = true;
    a.InterfaceC0650a gDH = new a.InterfaceC0650a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gEB.hideLoadingView();
            a.this.gEB.completePullRefresh();
            a.this.gEB.ab(aLaCharmDataList.data);
            a.this.gEC = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0650a
        public void t(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gEB.completePullRefresh();
            a.this.gEB.hideLoadingView();
            a.this.gEB.bUs();
            a.this.gEC = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gED = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gDD != null) {
                a.this.gDD.bH(1, 10);
            }
        }
    };
    private CustomMessageListener blx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gEB != null) {
                        a.this.gEB.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gEB != null) {
                        a.this.gEB.aA(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Yo().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.blx);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gEB == null) {
            this.gEB = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bns, this.aGk);
            this.gEB.setCharmValue(this.gDy);
            this.gEB.a(this.gED);
        }
        this.gDD = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gDH);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gEB.showLoadingView();
            this.gDD.bH(1, 10);
        }
    }

    public a Hi(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Hj(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Hk(String str) {
        this.mUid = str;
        return this;
    }

    public a Hl(String str) {
        this.gDy = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gEB == null) {
            createView();
        }
        if (this.gEB == null) {
            return null;
        }
        return this.gEB.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        MessageManager.getInstance().unRegisterListener(this.blx);
        if (this.gDD != null) {
            this.gDD.onDestroy();
        }
        if (this.gEB != null) {
            this.gEB.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gEB != null) {
            this.gEB.onSkinTypeChanged(i);
        }
    }
}
