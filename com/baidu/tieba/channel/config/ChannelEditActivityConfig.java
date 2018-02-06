package com.baidu.tieba.channel.config;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes3.dex */
public class ChannelEditActivityConfig extends IntentConfig {
    public static final String CHANNEL_INFO = "channelInfo";

    public ChannelEditActivityConfig(Context context, ChannelInfo channelInfo) {
        super(context);
        getIntent().putExtra(CHANNEL_INFO, channelInfo);
    }
}
