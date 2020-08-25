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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aZZ;
    private com.baidu.live.l.d gwK;
    private String gwL;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.gwL)) {
                    if (a.this.gwK == null) {
                        a.this.gwK = new com.baidu.live.l.d(a.this.getPageContext());
                    }
                    a.this.gwK.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aZZ.setTag(tbPageContext.getUniqueId());
        this.aZZ.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        getPageContext().registerListener(this.aZZ);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        MessageManager.getInstance().unRegisterListener(this.aZZ);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void FU(String str) {
        this.gwL = str;
    }
}
