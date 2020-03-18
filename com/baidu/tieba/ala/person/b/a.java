package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a implements e {
    private boolean atc;
    private String atd;
    private c fst;
    private int fsu;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId exr = BdUniqueId.gen();
    private InterfaceC0474a fsv = new InterfaceC0474a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0474a
        public void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i) {
            if (bVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), bVar.id, bVar.name, bVar.portrait, 0, 0, null, null, 0L, 0L, 0L, bVar.eMk, a.this.mGroupId, a.this.mLiveId, a.this.atc, a.this.atd, null, bVar.getNameShow(), "")));
            }
        }
    };
    private CustomMessageListener arV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (a.this.fst != null) {
                            a.this.fst.Z(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(a.this.exr)) {
                            if (updateAttentionMessage.getData().isAttention) {
                                com.baidu.live.view.a.Bq().a(a.this.mPageContext, true);
                                return;
                            } else {
                                CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        return;
                    }
                    if (a.this.fst != null) {
                        a.this.fst.Z(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                    }
                    if (!com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                        CustomToast.newInstance().showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0474a {
        void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.arV);
    }

    private void createView() {
        if (this.fst == null) {
            this.fst = new c(this.mPageContext, this.mUserId, this.exr);
            if (this.fsu == 1) {
                this.fst.qL(0);
            } else if (this.fsu == 2) {
                this.fst.qL(1);
            }
            this.fst.a(this.fsv);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        if (this.fst == null) {
            createView();
        }
        if (this.fst == null) {
            return null;
        }
        return this.fst.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.fst != null) {
            this.fst.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.arV);
        if (this.fst != null) {
            this.fst.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fst != null) {
            this.fst.onChangeSkinType(i);
        }
    }
}
