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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aWH;
    private com.baidu.live.o.e hCY;
    private String hCZ;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aWH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.hCZ)) {
                    if (a.this.hCY == null) {
                        a.this.hCY = new com.baidu.live.o.e(a.this.getPageContext());
                    }
                    a.this.hCY.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aWH.setTag(tbPageContext.getUniqueId());
        this.aWH.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        getPageContext().registerListener(this.aWH);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Au() {
        super.Au();
        MessageManager.getInstance().unRegisterListener(this.aWH);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void HP(String str) {
        this.hCZ = str;
    }
}
