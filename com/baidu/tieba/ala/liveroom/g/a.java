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
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener afV;
    private com.baidu.live.e.c eff;
    private String efg;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.afV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.efg)) {
                    if (a.this.eff == null) {
                        a.this.eff = new com.baidu.live.e.c(a.this.getPageContext());
                    }
                    a.this.eff.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.afV.setTag(tbPageContext.getUniqueId());
        this.afV.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        getPageContext().registerListener(this.afV);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        MessageManager.getInstance().unRegisterListener(this.afV);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void tF(String str) {
        this.efg = str;
    }
}
