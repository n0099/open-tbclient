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
    private CustomMessageListener arV;
    private com.baidu.live.k.d fau;
    private String fav;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.arV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.fav)) {
                    if (a.this.fau == null) {
                        a.this.fau = new com.baidu.live.k.d(a.this.getPageContext());
                    }
                    a.this.fau.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.arV.setTag(tbPageContext.getUniqueId());
        this.arV.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ag(ViewGroup viewGroup) {
        super.ag(viewGroup);
        getPageContext().registerListener(this.arV);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pP() {
        super.pP();
        MessageManager.getInstance().unRegisterListener(this.arV);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void yT(String str) {
        this.fav = str;
    }
}
