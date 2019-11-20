package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes6.dex */
public class a implements d {
    private boolean agL;
    private String agM;
    private b dET;
    private String dEr;
    private com.baidu.tieba.ala.charm.model.a dEw;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean dEU = true;
    a.InterfaceC0341a dEA = new a.InterfaceC0341a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0341a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.dET.hideLoadingView();
            a.this.dET.completePullRefresh();
            a.this.dET.K(aLaCharmDataList.data);
            a.this.dEU = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0341a
        public void R(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.dET.completePullRefresh();
            a.this.dET.hideLoadingView();
            a.this.dET.aKv();
            a.this.dEU = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener dEV = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.dEw != null) {
                a.this.dEw.aL(1, 10);
            }
        }
    };
    private CustomMessageListener afD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.dET != null) {
                        a.this.dET.T(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.wy().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.dET != null) {
                        a.this.dET.T(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.wy().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.afD);
        this.mPageId = BdUniqueId.gen();
    }

    public void nw() {
        if (this.dET == null) {
            this.dET = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.agL, this.agM);
            this.dET.sW(this.dEr);
            this.dET.a(this.dEV);
        }
        this.dEw = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.dEA);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.dET.showLoadingView();
            this.dEw.aL(1, 10);
        }
    }

    public a sS(String str) {
        this.mGroupId = str;
        return this;
    }

    public a sT(String str) {
        this.mLiveId = str;
        return this;
    }

    public a sU(String str) {
        this.mUid = str;
        return this;
    }

    public a sV(String str) {
        this.dEr = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        if (this.dET == null) {
            nw();
        }
        if (this.dET == null) {
            return null;
        }
        return this.dET.getView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
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
        MessageManager.getInstance().unRegisterListener(this.afD);
        if (this.dEw != null) {
            this.dEw.onDestroy();
        }
        if (this.dET != null) {
            this.dET.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.dET != null) {
            this.dET.onSkinTypeChanged(i);
        }
    }
}
