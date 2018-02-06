package com.baidu.tieba.channel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.c.c;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.message.ChannelUpdateInfoHttpResponsedMessage;
/* loaded from: classes3.dex */
public class ChannelEditModel extends BdBaseModel<ChannelEditActivity> {
    public ChannelEditModel(ChannelEditActivity channelEditActivity) {
        super(channelEditActivity.getPageContext());
        HQ();
    }

    private void HQ() {
        c.a(CmdConfigHttp.CMD_CHANNEL_UPDATE_INFO, TbConfig.CMD_CHANNEL_UPDATE_INFO, ChannelUpdateInfoHttpResponsedMessage.class);
    }

    public void b(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHANNEL_UPDATE_INFO);
            httpMessage.addParam("channel_id", channelInfo.getChannelId());
            httpMessage.addParam("channel_cover", channelInfo.getChannelCover());
            httpMessage.addParam("channel_avatar", channelInfo.getChannelAvatar());
            httpMessage.addParam("description", channelInfo.getDescription());
            httpMessage.setExtra(channelInfo);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
