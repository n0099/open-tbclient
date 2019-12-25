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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener anF;
    private com.baidu.live.i.d eUj;
    private String eUk;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.anF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.eUk)) {
                    if (a.this.eUj == null) {
                        a.this.eUj = new com.baidu.live.i.d(a.this.getPageContext());
                    }
                    a.this.eUj.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.anF.setTag(tbPageContext.getUniqueId());
        this.anF.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        getPageContext().registerListener(this.anF);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
        MessageManager.getInstance().unRegisterListener(this.anF);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void yu(String str) {
        this.eUk = str;
    }
}
