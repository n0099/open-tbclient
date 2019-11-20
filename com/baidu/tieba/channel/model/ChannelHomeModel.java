package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.channel.activity.ChannelHomeActivity;
import com.baidu.tieba.channel.c.c;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.channel.message.ChannelInfoGetHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelInfoGetMessage;
import com.baidu.tieba.channel.message.ChannelInfoGetSocketResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoRemoveHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoSetTopHttpResponseMessage;
import com.baidu.tieba.channel.message.ChannelVideoUnSetTopHttpResponseMessage;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes6.dex */
public class ChannelHomeModel extends BdBaseModel<ChannelHomeActivity> {
    private boolean eSA;

    public ChannelHomeModel(ChannelHomeActivity channelHomeActivity) {
        super(channelHomeActivity.getPageContext());
        this.eSA = false;
        registerTask();
    }

    private void registerTask() {
        a.a(CmdConfigSocket.CMD_CHANNEL_GET_INFO, ChannelInfoGetSocketResponseMessage.class, false, false);
        a.a(CmdConfigSocket.CMD_CHANNEL_GET_INFO, 1003307, TbConfig.CMD_CHANNEL_GET_INFO, ChannelInfoGetHttpResponseMessage.class, false, false, true, true);
        c.a(1003305, TbConfig.CMD_VIDEO_SET_TOP, ChannelVideoSetTopHttpResponseMessage.class);
        c.a(1003306, TbConfig.CMD_CHANNEL_REMOVE_VIDEO, ChannelVideoRemoveHttpResponseMessage.class);
        c.a(1003308, TbConfig.CMD_CHANNEL_VIDEO_UNSET_TOP, ChannelVideoUnSetTopHttpResponseMessage.class);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(long j, int i, int i2) {
        this.eSA = true;
        sendMessage(new ChannelInfoGetMessage(j, i, i2));
    }

    public void iR(boolean z) {
        this.eSA = z;
    }

    public boolean bbu() {
        return this.eSA;
    }

    public void a(long j, h hVar) {
        if (hVar != null) {
            HttpMessage httpMessage = new HttpMessage(1003305);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public void b(long j, h hVar) {
        if (hVar != null && hVar.ajl()) {
            HttpMessage httpMessage = new HttpMessage(1003308);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public void c(long j, h hVar) {
        if (hVar != null) {
            HttpMessage httpMessage = new HttpMessage(1003306);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public static void a(long j, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(1003311);
            httpMessage.addParam("channel_id", j);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void b(long j, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(1003309);
            httpMessage.addParam("channel_id", j);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(long j, boolean z, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(1003310);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("push_switch", z ? 1 : 2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
