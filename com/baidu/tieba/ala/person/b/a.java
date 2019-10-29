package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.c.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes6.dex */
public class a implements e {
    private boolean ahd;
    private String ahe;
    private c evo;
    private int evp;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId dFZ = BdUniqueId.gen();
    private InterfaceC0378a evq = new InterfaceC0378a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0378a
        public void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i) {
            if (bVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), bVar.id, bVar.name, bVar.portrait, 0, 0, null, null, 0L, 0L, 0L, bVar.dRG, a.this.mGroupId, a.this.mLiveId, a.this.ahd, a.this.ahe, null, bVar.getNameShow(), "")));
            }
        }
    };
    private CustomMessageListener afV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (a.this.evo != null) {
                            a.this.evo.V(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(a.this.dFZ)) {
                            if (updateAttentionMessage.getData().isAttention) {
                                com.baidu.live.view.a.wx().a(a.this.mPageContext, true);
                                return;
                            } else {
                                CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.i.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        return;
                    }
                    if (a.this.evo != null) {
                        a.this.evo.V(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                    }
                    if (!com.baidu.live.view.a.wx().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                        CustomToast.newInstance().showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0378a {
        void a(com.baidu.tieba.ala.person.a.b bVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.afV);
    }

    private void nw() {
        if (this.evo == null) {
            this.evo = new c(this.mPageContext, this.mUserId, this.dFZ);
            if (this.evp == 1) {
                this.evo.og(0);
            } else if (this.evp == 2) {
                this.evo.og(1);
            }
            this.evo.a(this.evq);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        if (this.evo == null) {
            nw();
        }
        if (this.evo == null) {
            return null;
        }
        return this.evo.getView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
        if (this.evo != null) {
            this.evo.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.afV);
        if (this.evo != null) {
            this.evo.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.evo != null) {
            this.evo.onChangeSkinType(i);
        }
    }
}
