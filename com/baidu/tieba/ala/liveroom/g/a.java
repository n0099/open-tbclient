package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.bdswitchview.BdSwitchView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aKS;
    private com.baidu.live.k.d fEI;
    private String fEJ;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aKS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.fEJ)) {
                    if (a.this.fEI == null) {
                        a.this.fEI = new com.baidu.live.k.d(a.this.getPageContext());
                    }
                    a.this.fEI.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aKS.setTag(tbPageContext.getUniqueId());
        this.aKS.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        getPageContext().registerListener(this.aKS);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ug() {
        super.ug();
        MessageManager.getInstance().unRegisterListener(this.aKS);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void AC(String str) {
        this.fEJ = str;
    }
}
