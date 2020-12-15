package com.baidu.tieba.ala.liveroom.h;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.bdswitchview.BdSwitchView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener blx;
    private com.baidu.live.o.d hpB;
    private String hpC;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.blx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.hpC)) {
                    if (a.this.hpB == null) {
                        a.this.hpB = new com.baidu.live.o.d(a.this.getPageContext());
                    }
                    a.this.hpB.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.blx.setTag(tbPageContext.getUniqueId());
        this.blx.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        getPageContext().registerListener(this.blx);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        MessageManager.getInstance().unRegisterListener(this.blx);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void Il(String str) {
        this.hpC = str;
    }
}
