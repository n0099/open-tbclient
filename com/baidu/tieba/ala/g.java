package com.baidu.tieba.ala;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class g implements com.baidu.live.ag.d {
    ab gqS;
    private CustomMessageListener gqT = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private TbPageContext mTbPageContext;

    public g(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.live.ag.d
    public void h(ab abVar) {
        this.gqS = abVar;
        this.gqT.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gqT);
    }

    @Override // com.baidu.live.ag.d
    public void IZ() {
        MessageManager.getInstance().unRegisterListener(this.gqT);
    }

    @Override // com.baidu.live.ag.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gqT);
    }
}
