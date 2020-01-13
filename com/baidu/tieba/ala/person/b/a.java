package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.liveroom.c.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes2.dex */
public class a implements e {
    private String apA;
    private boolean apz;
    private c fpc;
    private int fpd;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId esx = BdUniqueId.gen();
    private InterfaceC0466a fpe = new InterfaceC0466a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0466a
        public void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i) {
            if (bVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), bVar.id, bVar.name, bVar.portrait, 0, 0, null, null, 0L, 0L, 0L, bVar.eHG, a.this.mGroupId, a.this.mLiveId, a.this.apz, a.this.apA, null, bVar.getNameShow(), "")));
            }
        }
    };
    private CustomMessageListener aos = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (a.this.fpc != null) {
                            a.this.fpc.Z(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(a.this.esx)) {
                            if (updateAttentionMessage.getData().isAttention) {
                                com.baidu.live.view.a.yR().a(a.this.mPageContext, true);
                                return;
                            } else {
                                CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        return;
                    }
                    if (a.this.fpc != null) {
                        a.this.fpc.Z(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                    }
                    if (!com.baidu.live.view.a.yR().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                        CustomToast.newInstance().showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0466a {
        void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aos);
    }

    private void createView() {
        if (this.fpc == null) {
            this.fpc = new c(this.mPageContext, this.mUserId, this.esx);
            if (this.fpd == 1) {
                this.fpc.qC(0);
            } else if (this.fpd == 2) {
                this.fpc.qC(1);
            }
            this.fpc.a(this.fpe);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        if (this.fpc == null) {
            createView();
        }
        if (this.fpc == null) {
            return null;
        }
        return this.fpc.getView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.fpc != null) {
            this.fpc.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aos);
        if (this.fpc != null) {
            this.fpc.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.fpc != null) {
            this.fpc.onChangeSkinType(i);
        }
    }
}
