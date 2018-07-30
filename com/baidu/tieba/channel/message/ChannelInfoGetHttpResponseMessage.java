package com.baidu.tieba.channel.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.channel.data.ChannelHomeVideoList;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.data.d;
import com.baidu.tieba.channel.data.g;
import com.baidu.tieba.channel.data.h;
import com.squareup.wire.Wire;
import java.util.Calendar;
import tbclient.GetChannelInfo.GetChannelInfoResIdl;
/* loaded from: classes3.dex */
public class ChannelInfoGetHttpResponseMessage extends TbHttpResponsedMessage {
    private d channelHomeData;

    public ChannelInfoGetHttpResponseMessage() {
        super(CmdConfigHttp.CMD_CHANNEL_GET_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetChannelInfoResIdl getChannelInfoResIdl = (GetChannelInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetChannelInfoResIdl.class);
        if (getChannelInfoResIdl != null) {
            if (getChannelInfoResIdl.error != null) {
                setError(getChannelInfoResIdl.error.errorno.intValue());
                setErrorString(getChannelInfoResIdl.error.errmsg);
            }
            if (getChannelInfoResIdl.data != null && getChannelInfoResIdl.data != null) {
                this.channelHomeData = d.a(getChannelInfoResIdl.data);
            }
        }
    }

    public d getData() {
        return this.channelHomeData;
    }

    private void createData() {
        this.channelHomeData = new d();
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setChannelAvatar("http://img5.imgtn.bdimg.com/it/u=1421693742,2794906433&fm=23&gp=0.jpg");
        channelInfo.setChannelCover("http://img3.imgtn.bdimg.com/it/u=4198572056,790045769&fm=23&gp=0.jpg");
        channelInfo.setPortrait("http://img1.imgtn.bdimg.com/it/u=2284747396,4078580773&fm=23&gp=0.jpg");
        channelInfo.setChannelId(100L);
        channelInfo.setChannelName("为了艾泽拉斯");
        channelInfo.setDescription("暴风城的将士们，听我号令！-----  瓦里安*乌瑞恩");
        channelInfo.setFansCount(108080);
        channelInfo.setIsSubscribe(0);
        channelInfo.setUserId(1L);
        channelInfo.setUserName("瓦里安*乌瑞恩");
        channelInfo.setVideoCount(200);
        channelInfo.setVideoPlayCount(30000);
        this.channelHomeData.a(channelInfo);
        this.channelHomeData.a(new ChannelHomeVideoList<>());
        h hVar = new h();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 2016);
        calendar.set(2, 3);
        calendar.set(5, 11);
        hVar.setCreateTime(calendar.getTimeInMillis());
        hVar.setVideoWidth(100);
        hVar.setVideoHeight(200);
        hVar.setVideoDuration(1000);
        hVar.setVideoUrl("");
        hVar.bk(1L);
        hVar.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=2128544508,2586003047&fm=11&gp=0.jpg");
        hVar.setForumId(2);
        hVar.setForumName("李毅吧");
        hVar.jj(1);
        hVar.jf(9090);
        hVar.setThreadId(1L);
        hVar.jh(200);
        hVar.ji(200);
        hVar.setTitle("萌萌哒");
        hVar.setForumId(555555);
        this.channelHomeData.ajK().add(hVar);
        h hVar2 = new h();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, 2014);
        calendar2.set(2, 3);
        calendar2.set(5, 12);
        hVar2.setCreateTime(calendar2.getTimeInMillis());
        hVar2.setVideoWidth(100);
        hVar2.setVideoHeight(200);
        hVar2.setVideoDuration(12);
        hVar2.setVideoUrl("");
        hVar2.bk(1L);
        hVar2.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=3009713972,3252974559&fm=23&gp=0.jpg");
        hVar2.setForumId(2);
        hVar2.setForumName("李毅吧");
        hVar2.jj(0);
        hVar2.jf(878);
        hVar2.setThreadId(2L);
        hVar2.jh(200);
        hVar2.ji(200);
        hVar2.setTitle("萌萌哒2233333");
        hVar2.setForumId(555555);
        this.channelHomeData.ajK().add(hVar2);
        h hVar3 = new h();
        hVar3.setCreateTime(Calendar.getInstance().getTimeInMillis());
        hVar3.setVideoWidth(100);
        hVar3.setVideoHeight(200);
        hVar3.setVideoDuration(565656);
        hVar3.setVideoUrl("");
        hVar3.bk(1L);
        hVar3.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=2128544508,2586003047&fm=11&gp=0.jpg");
        hVar3.setForumId(2);
        hVar3.setForumName("李毅吧");
        hVar3.jj(0);
        hVar3.jf(4545);
        hVar3.setThreadId(3L);
        hVar3.jh(200);
        hVar3.ji(200);
        hVar3.setTitle("萌3333");
        hVar3.setForumId(555555);
        this.channelHomeData.ajK().add(hVar3);
        h hVar4 = new h();
        hVar4.setCreateTime(Calendar.getInstance().getTimeInMillis());
        hVar4.setVideoWidth(100);
        hVar4.setVideoHeight(200);
        hVar4.setVideoDuration(34);
        hVar4.setVideoUrl("");
        hVar4.bk(1L);
        hVar4.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=3009713972,3252974559&fm=23&gp=0.jpg");
        hVar4.setForumId(2);
        hVar4.setForumName("李毅吧");
        hVar4.jj(0);
        hVar4.jf(90090);
        hVar4.setThreadId(4L);
        hVar4.jh(200);
        hVar4.ji(200);
        hVar4.setTitle("3434434434");
        hVar4.setForumId(555555);
        this.channelHomeData.ajK().add(hVar4);
        h hVar5 = new h();
        hVar5.setCreateTime(Calendar.getInstance().getTimeInMillis());
        hVar5.setVideoWidth(100);
        hVar5.setVideoHeight(200);
        hVar5.setVideoDuration(767676);
        hVar5.setVideoUrl("");
        hVar5.bk(1L);
        hVar5.setThumbnailUrl("http://cdn.duitang.com/uploads/item/201504/16/20150416H0802_XtS2F.jpeg");
        hVar5.setForumId(2);
        hVar5.setForumName("李毅吧");
        hVar5.jj(0);
        hVar5.jf(8);
        hVar5.setThreadId(5L);
        hVar5.jh(200);
        hVar5.ji(200);
        hVar5.setTitle("无敌是多么寂寞多么寂寞，无敌是多么空虚多么空虚");
        hVar5.setForumId(555555);
        this.channelHomeData.ajK().add(hVar5);
        h hVar6 = new h();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, 2013);
        calendar3.set(2, 2);
        calendar3.set(5, 12);
        hVar6.setCreateTime(calendar3.getTimeInMillis());
        hVar6.setVideoWidth(100);
        hVar6.setVideoHeight(200);
        hVar6.setVideoDuration(1000);
        hVar6.setVideoUrl("");
        hVar6.bk(1L);
        hVar6.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=3009713972,3252974559&fm=23&gp=0.jpg");
        hVar6.setForumId(2);
        hVar6.setForumName("李毅吧");
        hVar6.jj(0);
        hVar6.jf(4545);
        hVar6.setThreadId(6L);
        hVar6.jh(200);
        hVar6.ji(200);
        hVar6.setTitle("呵呵呵呵呵呵");
        hVar6.setForumId(555555);
        this.channelHomeData.ajK().add(hVar6);
        h hVar7 = new h();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(1, 2016);
        calendar4.set(2, 3);
        calendar4.set(5, 38);
        hVar7.setCreateTime(calendar4.getTimeInMillis());
        hVar7.setVideoWidth(100);
        hVar7.setVideoHeight(200);
        hVar7.setVideoDuration(1000);
        hVar7.setVideoUrl("");
        hVar7.bk(1L);
        hVar7.setThumbnailUrl("http://cdn.duitang.com/uploads/item/201504/16/20150416H0802_XtS2F.jpeg");
        hVar7.setForumId(2);
        hVar7.setForumName("李毅吧");
        hVar7.jj(0);
        hVar7.jf(112);
        hVar7.setThreadId(7L);
        hVar7.jh(200);
        hVar7.ji(200);
        hVar7.setTitle("good job");
        hVar7.setForumId(555555);
        this.channelHomeData.ajK().add(hVar7);
        h hVar8 = new h();
        hVar8.setCreateTime(Calendar.getInstance().getTimeInMillis());
        hVar8.setVideoWidth(100);
        hVar8.setVideoHeight(200);
        hVar8.setVideoDuration(1000);
        hVar8.setVideoUrl("");
        hVar8.bk(1L);
        hVar8.setThumbnailUrl("http://img1.imgtn.bdimg.com/it/u=2128544508,2586003047&fm=11&gp=0.jpg");
        hVar8.setForumId(2);
        hVar8.setForumName("李毅吧");
        hVar8.jj(0);
        hVar8.jf(343434);
        hVar8.setThreadId(8L);
        hVar8.jh(200);
        hVar8.ji(200);
        hVar8.setTitle("哇哈哈哈哈哈哈");
        hVar8.setForumId(555555);
        this.channelHomeData.ajK().add(hVar8);
        this.channelHomeData.jd(0);
        g gVar = new g();
        gVar.setHasMore(0);
        gVar.je(12);
        this.channelHomeData.a(gVar);
    }
}
