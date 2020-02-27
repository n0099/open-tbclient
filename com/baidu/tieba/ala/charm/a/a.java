package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
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
    private boolean asR;
    private String asS;
    private String evC;
    private com.baidu.tieba.ala.charm.model.a evH;
    private b ews;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean ewt = true;
    a.InterfaceC0428a evL = new a.InterfaceC0428a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.ews.hideLoadingView();
            a.this.ews.completePullRefresh();
            a.this.ews.S(aLaCharmDataList.data);
            a.this.ewt = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void ad(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.ews.completePullRefresh();
            a.this.ews.hideLoadingView();
            a.this.ews.bdV();
            a.this.ewt = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener ewu = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.evH != null) {
                a.this.evH.bf(1, 10);
            }
        }
    };
    private CustomMessageListener arK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.ews != null) {
                        a.this.ews.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Bh().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.ews != null) {
                        a.this.ews.X(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Bh().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.arK);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.ews == null) {
            this.ews = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.asR, this.asS);
            this.ews.yd(this.evC);
            this.ews.a(this.ewu);
        }
        this.evH = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.evL);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.ews.showLoadingView();
            this.evH.bf(1, 10);
        }
    }

    public a xZ(String str) {
        this.mGroupId = str;
        return this;
    }

    public a ya(String str) {
        this.mLiveId = str;
        return this;
    }

    public a yb(String str) {
        this.mUid = str;
        return this;
    }

    public a yc(String str) {
        this.evC = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.ews == null) {
            createView();
        }
        if (this.ews == null) {
            return null;
        }
        return this.ews.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
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
        MessageManager.getInstance().unRegisterListener(this.arK);
        if (this.evH != null) {
            this.evH.onDestroy();
        }
        if (this.ews != null) {
            this.ews.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.ews != null) {
            this.ews.onSkinTypeChanged(i);
        }
    }
}
