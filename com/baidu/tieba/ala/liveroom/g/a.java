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
    private CustomMessageListener aTs;
    private com.baidu.live.l.d gfy;
    private String gfz;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aTs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.gfz)) {
                    if (a.this.gfy == null) {
                        a.this.gfy = new com.baidu.live.l.d(a.this.getPageContext());
                    }
                    a.this.gfy.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aTs.setTag(tbPageContext.getUniqueId());
        this.aTs.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        super.aq(viewGroup);
        getPageContext().registerListener(this.aTs);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        MessageManager.getInstance().unRegisterListener(this.aTs);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void CL(String str) {
        this.gfz = str;
    }
}
