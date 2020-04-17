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
    private boolean aMq;
    private String aMr;
    private String fad;
    private com.baidu.tieba.ala.charm.model.a fai;
    private b fbf;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fbg = true;
    a.InterfaceC0463a fam = new a.InterfaceC0463a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0463a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fbf.hideLoadingView();
            a.this.fbf.completePullRefresh();
            a.this.fbf.T(aLaCharmDataList.data);
            a.this.fbg = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0463a
        public void as(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fbf.completePullRefresh();
            a.this.fbf.hideLoadingView();
            a.this.fbf.bnp();
            a.this.fbg = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fbh = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fai != null) {
                a.this.fai.bl(1, 10);
            }
        }
    };
    private CustomMessageListener aKS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fbf != null) {
                        a.this.fbf.ac(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Ht().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fbf != null) {
                        a.this.fbf.ac(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Ht().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aKS);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fbf == null) {
            this.fbf = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aMq, this.aMr);
            this.fbf.zM(this.fad);
            this.fbf.a(this.fbh);
        }
        this.fai = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fam);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fbf.showLoadingView();
            this.fai.bl(1, 10);
        }
    }

    public a zI(String str) {
        this.mGroupId = str;
        return this;
    }

    public a zJ(String str) {
        this.mLiveId = str;
        return this;
    }

    public a zK(String str) {
        this.mUid = str;
        return this;
    }

    public a zL(String str) {
        this.fad = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fbf == null) {
            createView();
        }
        if (this.fbf == null) {
            return null;
        }
        return this.fbf.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AT() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
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
        MessageManager.getInstance().unRegisterListener(this.aKS);
        if (this.fai != null) {
            this.fai.onDestroy();
        }
        if (this.fbf != null) {
            this.fbf.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fbf != null) {
            this.fbf.onSkinTypeChanged(i);
        }
    }
}
