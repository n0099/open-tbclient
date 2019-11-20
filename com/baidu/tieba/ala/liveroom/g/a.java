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
    private CustomMessageListener afD;
    private com.baidu.live.e.c eeo;
    private String eep;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.afD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                UpdateAttentionMessage.UpdateAttentionData data;
                if ((customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && data.isAttention && data.isSucc && TextUtils.equals(data.toUid, a.this.eep)) {
                    if (a.this.eeo == null) {
                        a.this.eeo = new com.baidu.live.e.c(a.this.getPageContext());
                    }
                    a.this.eeo.a(BdSwitchView.SwitchState.ON, "", 2);
                }
            }
        };
        this.afD.setTag(tbPageContext.getUniqueId());
        this.afD.setSelfListener(true);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        getPageContext().registerListener(this.afD);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        MessageManager.getInstance().unRegisterListener(this.afD);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
    }

    public void tF(String str) {
        this.eep = str;
    }
}
