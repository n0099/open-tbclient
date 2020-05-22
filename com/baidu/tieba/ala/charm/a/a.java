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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes3.dex */
public class a implements d {
    private boolean aSw;
    private String aSx;
    private String fnL;
    private com.baidu.tieba.ala.charm.model.a fnQ;
    private b foM;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean foN = true;
    a.InterfaceC0532a fnU = new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.foM.hideLoadingView();
            a.this.foM.completePullRefresh();
            a.this.foM.T(aLaCharmDataList.data);
            a.this.foN = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void ax(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.foM.completePullRefresh();
            a.this.foM.hideLoadingView();
            a.this.foM.btf();
            a.this.foN = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener foO = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fnQ != null) {
                a.this.fnQ.bo(1, 10);
            }
        }
    };
    private CustomMessageListener aQM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.foM != null) {
                        a.this.foM.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.foM != null) {
                        a.this.foM.ap(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Jl().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aQM);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.foM == null) {
            this.foM = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aSw, this.aSx);
            this.foM.Bw(this.fnL);
            this.foM.a(this.foO);
        }
        this.fnQ = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fnU);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.foM.showLoadingView();
            this.fnQ.bo(1, 10);
        }
    }

    public a Bs(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Bt(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Bu(String str) {
        this.mUid = str;
        return this;
    }

    public a Bv(String str) {
        this.fnL = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.foM == null) {
            createView();
        }
        if (this.foM == null) {
            return null;
        }
        return this.foM.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        MessageManager.getInstance().unRegisterListener(this.aQM);
        if (this.fnQ != null) {
            this.fnQ.onDestroy();
        }
        if (this.foM != null) {
            this.foM.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.foM != null) {
            this.foM.onSkinTypeChanged(i);
        }
    }
}
