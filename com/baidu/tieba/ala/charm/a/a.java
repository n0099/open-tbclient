package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes2.dex */
public class a implements d {
    private String apA;
    private boolean apz;
    private String ers;
    private com.baidu.tieba.ala.charm.model.a erx;
    private b esi;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean esj = true;
    a.InterfaceC0417a erB = new a.InterfaceC0417a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0417a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.esi.hideLoadingView();
            a.this.esi.completePullRefresh();
            a.this.esi.Q(aLaCharmDataList.data);
            a.this.esj = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0417a
        public void ac(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.esi.completePullRefresh();
            a.this.esi.hideLoadingView();
            a.this.esi.bbG();
            a.this.esj = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener esk = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.erx != null) {
                a.this.erx.bf(1, 10);
            }
        }
    };
    private CustomMessageListener aos = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.esi != null) {
                        a.this.esi.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.esi != null) {
                        a.this.esi.X(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.yR().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aos);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.esi == null) {
            this.esi = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.apz, this.apA);
            this.esi.xJ(this.ers);
            this.esi.a(this.esk);
        }
        this.erx = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.erB);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.esi.showLoadingView();
            this.erx.bf(1, 10);
        }
    }

    public a xF(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xG(String str) {
        this.mLiveId = str;
        return this;
    }

    public a xH(String str) {
        this.mUid = str;
        return this;
    }

    public a xI(String str) {
        this.ers = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        if (this.esi == null) {
            createView();
        }
        if (this.esi == null) {
            return null;
        }
        return this.esi.getView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 3;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aos);
        if (this.erx != null) {
            this.erx.onDestroy();
        }
        if (this.esi != null) {
            this.esi.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.esi != null) {
            this.esi.onSkinTypeChanged(i);
        }
    }
}
