package com.baidu.tieba.ala;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class f implements com.baidu.live.ai.d {
    x gsQ;
    private CustomMessageListener gsR = new CustomMessageListener(2913220) { // from class: com.baidu.tieba.ala.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.live.ai.d
    public void f(x xVar) {
        this.gsQ = xVar;
        this.gsR.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gsR);
    }

    @Override // com.baidu.live.ai.d
    public void LE() {
        MessageManager.getInstance().unRegisterListener(this.gsR);
    }

    @Override // com.baidu.live.ai.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsR);
    }
}
