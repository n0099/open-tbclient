package com.baidu.tieba.ala.liveroom.m;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.AlaRoomAllowFollowedSetResponseMessage;
/* loaded from: classes6.dex */
public class a {
    public final HttpMessageListener ekL = new HttpMessageListener(1021022) { // from class: com.baidu.tieba.ala.liveroom.m.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaRoomAllowFollowedSetResponseMessage)) {
                AlaRoomAllowFollowedSetResponseMessage alaRoomAllowFollowedSetResponseMessage = (AlaRoomAllowFollowedSetResponseMessage) httpResponsedMessage;
                int statusCode = alaRoomAllowFollowedSetResponseMessage.getStatusCode();
                int error = alaRoomAllowFollowedSetResponseMessage.getError();
                if (statusCode != 200 || error != 0) {
                    a.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                Message<?> message = alaRoomAllowFollowedSetResponseMessage.getmOrginalMessage();
                if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageContext.getUniqueId())) {
                    a.this.mPageContext.showToast(a.this.mPageContext.getString(a.i.ala_allow_follow_success));
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aUJ();
        this.mPageContext.registerListener(this.ekL);
    }

    private void aUJ() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021022, TbConfig.SERVER_ADDRESS + "ala/user/setUserStatus");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRoomAllowFollowedSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void aUK() {
        HttpMessage httpMessage = new HttpMessage(1021022);
        httpMessage.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
