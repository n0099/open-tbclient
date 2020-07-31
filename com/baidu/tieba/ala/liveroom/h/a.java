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
    private CustomMessageListener aUL;
    private com.baidu.live.l.d gkG;
    private String gkH;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.h.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.gkH)) {
                    if (a.this.gkG == null) {
                        a.this.gkG = new com.baidu.live.l.d(a.this.getPageContext());
                    }
                    a.this.gkG.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.aUL.setTag(tbPageContext.getUniqueId());
        this.aUL.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        super.ar(viewGroup);
        getPageContext().registerListener(this.aUL);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
        MessageManager.getInstance().unRegisterListener(this.aUL);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void Dx(String str) {
        this.gkH = str;
    }
}
