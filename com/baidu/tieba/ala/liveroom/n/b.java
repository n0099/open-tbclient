package com.baidu.tieba.ala.liveroom.n;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.AlaRoomAllowFollowedSetResponseMessage;
/* loaded from: classes11.dex */
public class b {
    public final HttpMessageListener hJM = new HttpMessageListener(1021022) { // from class: com.baidu.tieba.ala.liveroom.n.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaRoomAllowFollowedSetResponseMessage)) {
                AlaRoomAllowFollowedSetResponseMessage alaRoomAllowFollowedSetResponseMessage = (AlaRoomAllowFollowedSetResponseMessage) httpResponsedMessage;
                int statusCode = alaRoomAllowFollowedSetResponseMessage.getStatusCode();
                int error = alaRoomAllowFollowedSetResponseMessage.getError();
                if (statusCode != 200 || error != 0) {
                    b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    return;
                }
                Message<?> message = alaRoomAllowFollowedSetResponseMessage.getmOrginalMessage();
                if (message != null && message.getTag() != null && message.getTag().equals(b.this.mPageContext.getUniqueId())) {
                    b.this.mPageContext.showToast(b.this.mPageContext.getString(a.h.ala_allow_follow_success));
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        ciV();
        this.mPageContext.registerListener(this.hJM);
    }

    private void ciV() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021022, TbConfig.SERVER_ADDRESS + "ala/user/setUserStatus");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRoomAllowFollowedSetResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void ciW() {
        HttpMessage httpMessage = new HttpMessage(1021022);
        httpMessage.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
