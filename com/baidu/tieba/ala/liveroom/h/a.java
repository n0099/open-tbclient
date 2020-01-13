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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aos;
    private com.baidu.live.j.d eVS;
    private String eVT;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aos = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.eVT)) {
                    if (a.this.eVS == null) {
                        a.this.eVS = new com.baidu.live.j.d(a.this.getPageContext());
                    }
                    a.this.eVS.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aos.setTag(tbPageContext.getUniqueId());
        this.aos.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ad(ViewGroup viewGroup) {
        super.ad(viewGroup);
        getPageContext().registerListener(this.aos);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
        MessageManager.getInstance().unRegisterListener(this.aos);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void yy(String str) {
        this.eVT = str;
    }
}
