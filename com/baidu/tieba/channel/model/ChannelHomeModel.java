package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes3.dex */
public class ChannelHomeModel extends BdBaseModel<ChannelHomeActivity> {
    private boolean ddT;

    public ChannelHomeModel(ChannelHomeActivity channelHomeActivity) {
        super(channelHomeActivity.getPageContext());
        this.ddT = false;
        registerTask();
    }

    private void registerTask() {
        a.a(309437, ChannelInfoGetSocketResponseMessage.class, false, false);
        a.a(309437, CmdConfigHttp.CMD_CHANNEL_GET_INFO, TbConfig.CMD_CHANNEL_GET_INFO, ChannelInfoGetHttpResponseMessage.class, false, false, true, true);
        c.a(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP, TbConfig.CMD_VIDEO_SET_TOP, ChannelVideoSetTopHttpResponseMessage.class);
        c.a(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO, TbConfig.CMD_CHANNEL_REMOVE_VIDEO, ChannelVideoRemoveHttpResponseMessage.class);
        c.a(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP, TbConfig.CMD_CHANNEL_VIDEO_UNSET_TOP, ChannelVideoUnSetTopHttpResponseMessage.class);
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
        this.ddT = true;
        sendMessage(new ChannelInfoGetMessage(j, i, i2));
    }

    public void fC(boolean z) {
        this.ddT = z;
    }

    public boolean aro() {
        return this.ddT;
    }

    public void a(long j, h hVar) {
        if (hVar != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_VIDEO_SET_TOP);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public void b(long j, h hVar) {
        if (hVar != null && hVar.Ah()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_VIDEO_UNSET_TOP);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public void c(long j, h hVar) {
        if (hVar != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_REMOVE_VIDEO);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("thread_id", hVar.getThreadId());
            httpMessage.setExtra(hVar);
            sendMessage(httpMessage);
        }
    }

    public static void a(long j, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_FOLLOW);
            httpMessage.addParam("channel_id", j);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void b(long j, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_UNFOLLOW);
            httpMessage.addParam("channel_id", j);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void a(long j, boolean z, com.baidu.tbadk.core.b.a aVar) {
        if (j > 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_UPDATE_PUSH);
            httpMessage.addParam("channel_id", j);
            httpMessage.addParam("push_switch", z ? 1 : 2);
            httpMessage.setExtra(aVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
