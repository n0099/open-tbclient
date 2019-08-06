package com.baidu.tieba.channel;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.b;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelAddVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelFansActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelListActivityConfig;
import com.baidu.tbadk.core.b.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.activity.ChannelListActivity;
import com.baidu.tieba.channel.c.c;
import com.baidu.tieba.channel.config.ChannelEditActivityConfig;
import com.baidu.tieba.channel.message.ChannelFollowHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelUnFollowHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelUpdatePushHttpResponseMessage;
import com.baidu.tieba.channel.model.ChannelHomeModel;
import java.util.Map;
/* loaded from: classes6.dex */
public class ChannelStatic {
    private static HttpMessageListener eHh = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_FOLLOW) { // from class: com.baidu.tieba.channel.ChannelStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelFollowHttpResponseMessage)) {
                a.C0240a c0240a = (a.C0240a) httpResponsedMessage.getOrginalMessage().getExtra();
                c0240a.bEk = httpResponsedMessage;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016513, c0240a));
            }
        }
    };
    private static HttpMessageListener eHi = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_UNFOLLOW) { // from class: com.baidu.tieba.channel.ChannelStatic.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUnFollowHttpResponseMessage)) {
                a.c cVar = (a.c) httpResponsedMessage.getOrginalMessage().getExtra();
                cVar.bEk = httpResponsedMessage;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016513, cVar));
            }
        }
    };
    private static HttpMessageListener eHj = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_UPDATE_PUSH) { // from class: com.baidu.tieba.channel.ChannelStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdatePushHttpResponseMessage)) {
                a.b bVar = (a.b) httpResponsedMessage.getOrginalMessage().getExtra();
                bVar.bEk = httpResponsedMessage;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016513, bVar));
            }
        }
    };

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ChannelHomeActivityConfig.class, ChannelHomeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ChannelListActivityConfig.class, ChannelListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ChannelAddVideoActivityConfig.class, ChannelAddVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ChannelFansActivityConfig.class, ChannelFansActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ChannelEditActivityConfig.class, ChannelEditActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016513, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tieba.channel.ChannelStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<a> customMessage) {
                a data;
                if (customMessage != null && customMessage.getData() != null && (data = customMessage.getData()) != null) {
                    if (data instanceof a.C0240a) {
                        ChannelHomeModel.a(((a.C0240a) data).channelId, data);
                    } else if (data instanceof a.c) {
                        ChannelHomeModel.b(((a.c) data).channelId, data);
                    } else if (data instanceof a.b) {
                        a.b bVar = (a.b) data;
                        ChannelHomeModel.a(bVar.channelId, bVar.isOpen, data);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        aWC();
        bau();
        bb.ajE().a("vchannel://", new bb.b() { // from class: com.baidu.tieba.channel.ChannelStatic.5
            @Override // com.baidu.tbadk.core.util.bb.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null && map != null && map.size() > 0) {
                    String str = map.get(IXAdRequestInfo.CELL_ID);
                    if (!TextUtils.isEmpty(str)) {
                        int indexOf = str.indexOf("?");
                        if (indexOf >= 0) {
                            str = str.substring(0, indexOf);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(tbPageContext.getPageActivity(), b.c(str, 0L), 0)));
                    }
                }
            }
        });
    }

    private static void aWC() {
        c.a(CmdConfigHttp.CMD_CHANNEL_FOLLOW, TbConfig.CMD_CHANNEL_FOLLOW, ChannelFollowHttpResponseMessage.class);
        c.a(CmdConfigHttp.CMD_CHANNEL_UNFOLLOW, TbConfig.CMD_CHANNEL_UNFOLLOW, ChannelUnFollowHttpResponseMessage.class);
        c.a(CmdConfigHttp.CMD_CHANNEL_UPDATE_PUSH, TbConfig.CMD_CHANNEL_UPDATE_PUSH, ChannelUpdatePushHttpResponseMessage.class);
    }

    private static void bau() {
        MessageManager.getInstance().registerListener(eHh);
        MessageManager.getInstance().registerListener(eHi);
        MessageManager.getInstance().registerListener(eHj);
    }
}
