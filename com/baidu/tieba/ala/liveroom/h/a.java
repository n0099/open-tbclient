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
    private CustomMessageListener bgl;
    private com.baidu.live.l.d gOt;
    private String gOu;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bgl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.gOu)) {
                    if (a.this.gOt == null) {
                        a.this.gOt = new com.baidu.live.l.d(a.this.getPageContext());
                    }
                    a.this.gOt.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.bgl.setTag(tbPageContext.getUniqueId());
        this.bgl.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        getPageContext().registerListener(this.bgl);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        super.CN();
        MessageManager.getInstance().unRegisterListener(this.bgl);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void Hf(String str) {
        this.gOu = str;
    }
}
