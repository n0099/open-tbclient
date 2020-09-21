package com.baidu.tieba.card.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import tbclient.Abstract;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.PostInfoList;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.VideoInfo;
/* loaded from: classes23.dex */
public class CardPersonDynamicThreadData extends AbsThreadDataSupport {
    public static final BdUniqueId huI = BdUniqueId.gen();
    public int aul;
    public bw dXg;
    public String firstPostId;
    public String forumId;
    public String forumName;
    public int huJ;
    public String huK;
    public long huL;
    public int huM;
    public String huO;
    public String huP;
    public String huQ;
    public String hva;
    public boolean isPrivacy;
    public String postId;
    public List<PbContent> rich_abstract;
    public List<PbContent> rich_title;
    public int sex;
    public String threadId;
    public String title;
    public long userId;
    public String userName;
    public String userPortrait;
    public VideoInfo videoInfo;
    public boolean huw = false;
    public boolean eOt = true;
    public int huN = 0;
    public int from = 0;
    public Abs[] huR = new Abs[0];
    public MediaData[] huS = new MediaData[0];
    public VoiceData.VoiceModel[] huT = new VoiceData.VoiceModel[0];
    public ZhiBoInfoTW huU = new ZhiBoInfoTW();
    public MultipleForum[] huV = new MultipleForum[0];
    public boolean huW = true;
    public boolean huX = true;
    public boolean huY = false;
    public boolean huZ = false;
    public boolean isHost = true;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return huI;
    }

    public void a(User user, ThreadInfo threadInfo, int i, long j) {
        if (threadInfo != null) {
            this.forumId = String.valueOf(threadInfo.fid);
            this.threadId = String.valueOf(threadInfo.tid);
            this.postId = String.valueOf(threadInfo.post_id);
            this.firstPostId = this.postId;
            this.huJ = threadInfo.create_time.intValue();
            this.huO = at.getChineseYearBytime(j * 1000);
            this.huP = at.getChineseMonthBytime(j * 1000);
            this.huQ = at.getDateBytime(j * 1000);
            this.forumName = threadInfo.fname;
            this.videoInfo = threadInfo.video_info;
            this.title = threadInfo.title;
            this.rich_title = threadInfo.rich_title;
            this.rich_abstract = threadInfo.rich_abstract;
            if (threadInfo.author != null) {
                this.userName = threadInfo.author.name;
                this.userId = threadInfo.author.id.longValue();
                this.userPortrait = threadInfo.author.portrait;
            }
            this.huL = threadInfo.thread_type.intValue();
            this.huR = new Abs[threadInfo._abstract.size()];
            StringBuilder sb = new StringBuilder();
            if (threadInfo._abstract != null) {
                for (int i2 = 0; i2 < this.huR.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(threadInfo._abstract.get(i2));
                    this.huR[i2] = abs;
                    if (threadInfo._abstract.get(i2).type.intValue() == 0) {
                        sb.append(threadInfo._abstract.get(i2).text);
                    }
                }
            }
            this.huK = sb.toString();
            this.aul = threadInfo.reply_num.intValue();
            this.huM = threadInfo.view_num.intValue();
            if (threadInfo.media != null) {
                this.huS = new MediaData[threadInfo.media.size()];
                for (int i3 = 0; i3 < this.huS.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(threadInfo.media.get(i3));
                    this.huS[i3] = mediaData;
                }
            }
            if (threadInfo.voice_info != null) {
                this.huT = new VoiceData.VoiceModel[threadInfo.voice_info.size()];
                for (int i4 = 0; i4 < this.huT.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(threadInfo.voice_info.get(i4));
                    this.huT[i4] = voiceModel;
                }
            }
            if (threadInfo.multiple_forum_list != null) {
                this.huV = new MultipleForum[threadInfo.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.huV.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i5));
                    this.huV[i5] = multipleForum;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                this.huU.parseProtobuf(threadInfo.twzhibo_info, i);
            }
            this.dXg = new bw();
            this.dXg.a(threadInfo);
            this.dXg.setId(this.threadId);
            this.dXg.setTid(this.threadId);
            this.dXg.setFid(threadInfo.fid.longValue());
            this.dXg.nr(this.aul);
            this.dXg.ns(this.huM);
            this.dXg.cB(this.huJ);
            if (threadInfo.agree != null) {
                this.dXg.nA(threadInfo.agree.agree_type.intValue());
                this.dXg.ny(threadInfo.agree.has_agree.intValue());
                long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                this.dXg.cC(longValue);
                this.dXg.cD(longValue2);
                if (this.dXg.bgY() == 1 && longValue == 0 && longValue2 == 0) {
                    this.dXg.nz(1);
                }
            }
            this.dXg.nw(threadInfo.is_ntitle.intValue());
            this.dXg.egw = true;
            if (this.dXg.bfy() != null && user != null) {
                this.dXg.bfy().parserProtobuf(user);
                this.dXg.bfX();
            }
            this.dXg.zR(threadInfo.article_cover);
            this.dXg.a(this.videoInfo);
            if (this.dXg.bei()) {
                this.dXg.nB(1);
            }
            this.dXg.bgc();
        }
    }

    public void a(User user, PostInfoList postInfoList, int i) {
        if (postInfoList != null) {
            this.forumId = String.valueOf(postInfoList.forum_id);
            this.threadId = String.valueOf(postInfoList.thread_id);
            this.postId = String.valueOf(postInfoList.post_id);
            this.firstPostId = this.postId;
            this.huJ = postInfoList.create_time.intValue();
            long intValue = postInfoList.create_time.intValue() * 1000;
            this.huO = at.getChineseYearBytime(intValue);
            this.huP = at.getChineseMonthBytime(intValue);
            this.huQ = at.getDateBytime(intValue);
            this.forumName = postInfoList.forum_name;
            this.title = postInfoList.title;
            this.rich_title = postInfoList.rich_title;
            this.rich_abstract = postInfoList.rich_abstract;
            this.userName = postInfoList.user_name;
            this.userId = postInfoList.user_id.longValue();
            this.userPortrait = postInfoList.user_portrait;
            this.huL = postInfoList.thread_type.longValue();
            this.huN = postInfoList.is_post_deleted.intValue();
            if (postInfoList.is_remain.intValue() == 0) {
                this.isPrivacy = false;
            } else if (postInfoList.is_remain.intValue() == 1) {
                this.isPrivacy = true;
            }
            StringBuilder sb = new StringBuilder();
            if (postInfoList.abstract_thread != null) {
                this.huR = new Abs[postInfoList.abstract_thread.size()];
                for (int i2 = 0; i2 < this.huR.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                    this.huR[i2] = abs;
                    if (postInfoList.abstract_thread.get(i2).type.intValue() == 0) {
                        sb.append(postInfoList.abstract_thread.get(i2).text);
                    }
                }
            }
            this.huK = sb.toString();
            this.aul = postInfoList.reply_num.intValue();
            this.huM = postInfoList.freq_num.intValue();
            if (postInfoList.media != null) {
                this.huS = new MediaData[postInfoList.media.size()];
                for (int i3 = 0; i3 < this.huS.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(postInfoList.media.get(i3));
                    this.huS[i3] = mediaData;
                }
            }
            if (postInfoList.voice_info != null) {
                this.huT = new VoiceData.VoiceModel[postInfoList.voice_info.size()];
                for (int i4 = 0; i4 < this.huT.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(postInfoList.voice_info.get(i4));
                    this.huT[i4] = voiceModel;
                }
            }
            if (postInfoList.twzhibo_info != null) {
                this.huU.parseProtobuf(postInfoList.twzhibo_info, i);
            }
            if (postInfoList.video_info != null) {
                this.videoInfo = postInfoList.video_info;
            }
            if (postInfoList.multiple_forum_list != null && postInfoList.multiple_forum_list.size() > 0) {
                this.huV = new MultipleForum[postInfoList.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.huV.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i5));
                    this.huV[i5] = multipleForum;
                }
            } else if (!TextUtils.isEmpty(this.forumName) && com.baidu.adp.lib.f.b.toLong(this.forumId, -1L) != -1) {
                this.huV = new MultipleForum[1];
                MultipleForum multipleForum2 = new MultipleForum();
                multipleForum2.forum_id = com.baidu.adp.lib.f.b.toLong(this.forumId, 0L);
                multipleForum2.forum_name = this.forumName;
                this.huV[0] = multipleForum2;
            }
            this.dXg = new bw();
            if (postInfoList.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserProtobuf(postInfoList.ala_info);
                this.dXg.a(alaInfoData);
                this.dXg.setTitle(this.title);
                this.huM = postInfoList.view_num.intValue();
            }
            if (postInfoList.agree != null) {
                this.dXg.nA(postInfoList.agree.agree_type.intValue());
                this.dXg.ny(postInfoList.agree.has_agree.intValue());
                long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
                long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
                this.dXg.cC(longValue);
                this.dXg.cD(longValue2);
                if (this.dXg.bgY() == 1 && longValue == 0 && longValue2 == 0) {
                    this.dXg.nz(1);
                }
                AgreeData bhp = this.dXg.bhp();
                if (bhp != null) {
                    bhp.threadId = this.threadId;
                    bhp.parseProtobuf(postInfoList.agree);
                }
            }
            if (postInfoList.is_share_thread.intValue() == 1) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                originalThreadInfo.a(postInfoList.origin_thread_info);
                this.dXg.efS = originalThreadInfo;
                this.dXg.isShareThread = true;
            }
            this.dXg.cE(postInfoList.share_num.intValue());
            this.dXg.setId(this.threadId);
            this.dXg.setTid(this.threadId);
            this.dXg.setFid(postInfoList.forum_id.longValue());
            this.dXg.zJ(this.forumName);
            this.dXg.nr(this.aul);
            this.dXg.ns(this.huM);
            this.dXg.cB(this.huJ);
            this.dXg.setTitle(this.title);
            this.dXg.aS(this.rich_title);
            this.dXg.aT(this.rich_abstract);
            this.dXg.zM(this.huK);
            this.dXg.setThreadType((int) this.huL);
            this.dXg.aR(postInfoList.first_post_content);
            if (this.huS != null) {
                this.dXg.G(new ArrayList<>(Arrays.asList(this.huS)));
            }
            if (this.huT != null) {
                this.dXg.H(new ArrayList<>(Arrays.asList(this.huT)));
            }
            this.dXg.nw(postInfoList.is_ntitle.intValue());
            this.dXg.egw = true;
            if (this.dXg.bfy() != null && user != null) {
                this.dXg.bfy().parserProtobuf(user);
                this.dXg.bfX();
            }
            this.dXg.zR(postInfoList.article_cover);
            this.dXg.a(this.videoInfo);
            if (this.dXg.bei()) {
                this.dXg.nB(1);
            }
            this.dXg.isPrivacy = this.isPrivacy;
            this.dXg.egz = this.firstPostId;
            if (postInfoList.item != null) {
                this.dXg.a(postInfoList.item);
                ItemData itemData = new ItemData();
                itemData.parseProto(postInfoList.item);
                this.dXg.itemData = itemData;
            }
            if (postInfoList.item_star != null) {
                this.dXg.aU(postInfoList.item_star);
                ItemStarData itemStarData = new ItemStarData();
                itemStarData.parseProto(postInfoList.item_star);
                this.dXg.itemStarData = itemStarData;
            }
            if (postInfoList.poll_info != null) {
                PollData pollData = new PollData();
                pollData.parserProtobuf(postInfoList.poll_info);
                this.dXg.b(pollData);
            }
            if (postInfoList.pb_link_info != null && !y.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList = new ArrayList();
                for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    arrayList.add(pbLinkData);
                }
                this.dXg.aV(arrayList);
            }
            if (postInfoList.pb_goods_info != null && !y.isEmpty(postInfoList.pb_goods_info)) {
                ArrayList arrayList2 = new ArrayList();
                for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    arrayList2.add(pbGoodsData);
                }
                this.dXg.aW(arrayList2);
            }
            if (postInfoList.pb_link_info != null && !y.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList3 = new ArrayList();
                for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData2 = new PbLinkData();
                    pbLinkData2.parseProto(pbLinkInfo2);
                    arrayList3.add(pbLinkData2);
                }
                this.dXg.aV(arrayList3);
            }
            this.dXg.bgc();
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this.dXg;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        return null;
    }

    /* loaded from: classes23.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan != null) {
                this.num = zan.num.intValue();
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public String portrait = "";
        public String name_show = "";
        public long id = 0;

        public void parseProtobuf(User user) {
            if (user != null) {
                this.portrait = user.portrait;
                this.name_show = user.name_show;
                this.id = user.id.longValue();
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class LabelInfo extends OrmObject implements Serializable {
        public int labelHot = 0;
        public String labelName = "";
        public String LabelId = "";

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            if (labelInfo != null) {
                this.labelHot = labelInfo.labelHot.intValue();
                this.labelName = labelInfo.labelContent;
                this.LabelId = labelInfo.labelId;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class MultipleForum extends OrmObject implements Serializable {
        public long forum_id = 0;
        public String forum_name = "";

        public void parseProtobuf(tbclient.MultipleForum multipleForum) {
            if (multipleForum != null) {
                this.forum_id = multipleForum.forum_id.longValue();
                this.forum_name = multipleForum.forum_name;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
        public long post_type = 0;
        public long post_id = 0;

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            if (postInfoContent != null) {
                this.create_time = postInfoContent.create_time.longValue();
                this.post_id = postInfoContent.post_id.longValue();
                this.post_type = postInfoContent.post_type.longValue();
                if (postInfoContent.post_content != null) {
                    this.post_content = new Abs[postInfoContent.post_content.size()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < this.post_content.length) {
                            Abs abs = new Abs();
                            abs.parseProtobuf(postInfoContent.post_content.get(i2));
                            this.post_content[i2] = abs;
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class Abs extends OrmObject implements Serializable {
        public int type = 0;
        public String text = "";
        public String src = "";
        public String un = "";
        public String link = "";

        public void parseProtobuf(Abstract r2) {
            if (r2 != null) {
                this.type = r2.type.intValue();
                this.text = r2.text;
                this.src = r2.src;
                this.un = r2.un;
                this.link = r2.link;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class Quote extends OrmObject implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public String ip = null;
        public String content = "";

        public void parseProtobuf(tbclient.Quote quote) {
            if (quote != null) {
                this.post_id = quote.post_id.longValue();
                this.user_id = quote.user_id.longValue();
                this.user_name = quote.user_name;
                this.ip = quote.ip;
                this.content = quote.content;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class Media extends OrmObject implements Serializable {
        public int type = 0;
        public String small_pic = "";
        public String big_pic = "";
        public String water_pic = "";
        public String dynamic_pic = "";

        public void parseProtobuf(tbclient.Media media) {
            if (media != null) {
                this.type = media.type.intValue();
                this.small_pic = media.small_pic;
                this.big_pic = media.big_pic;
                this.water_pic = media.water_pic;
                this.dynamic_pic = media.dynamic_pic;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class AnchorInfo extends OrmObject implements Serializable {
        public String portrait = "";
        public String name = "";
        public long start_time = 0;
        public int status = 0;
        public long author_id = 0;
        public String author_name = "";
        public int listeners = 0;
        public int likers = 0;
        public long group_id = 0;
        public String intro = "";
        public String publisherPortrait = "";
        public String publisherName = "";
        public long publisherId = 0;

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            if (anchorInfo != null) {
                this.portrait = anchorInfo.portrait;
                this.author_id = anchorInfo.author_id.longValue();
                this.author_name = anchorInfo.author_name;
                this.group_id = anchorInfo.group_id.longValue();
                this.intro = anchorInfo.intro;
                this.likers = anchorInfo.likers.intValue();
                this.listeners = anchorInfo.listeners.intValue();
                this.name = anchorInfo.name;
                this.publisherId = anchorInfo.publisherId.longValue();
                this.publisherName = anchorInfo.publisherName;
                this.publisherPortrait = anchorInfo.publisherPortrait;
                this.start_time = anchorInfo.start_time.intValue();
                this.status = anchorInfo.status.intValue();
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class LbsInfo implements Serializable {
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            if (lbsInfo != null) {
                this.lat = lbsInfo.lat;
                this.lon = lbsInfo.lon;
                this.town = lbsInfo.town;
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class ZhiBoInfoTW extends OrmObject implements Serializable {
        public int post_num = 0;
        public String title = "";
        public long forum_id = 0;
        public String livecover_src_bsize = "";
        public long last_modified_time = 0;
        public String forum_name = "";
        public long thread_id = 0;
        public String content = "";
        public String livecover_src = "";
        public int reply_num = 0;
        public Zan zan = new Zan();
        public UserInfo userInfo = new UserInfo();
        public LabelInfo[] labelList = new LabelInfo[0];
        public int showStyle = -1;
        public boolean isHeadLive = false;
        public ArrayList<Integer> showExpressionViewIndex = new ArrayList<>();

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i) {
            if (zhiBoInfoTW != null) {
                this.post_num = zhiBoInfoTW.post_num.intValue();
                this.title = zhiBoInfoTW.title;
                this.forum_id = zhiBoInfoTW.forum_id.longValue();
                this.livecover_src_bsize = zhiBoInfoTW.livecover_src_bsize;
                this.last_modified_time = zhiBoInfoTW.last_modified_time.longValue();
                this.forum_name = zhiBoInfoTW.forum_name;
                this.thread_id = zhiBoInfoTW.thread_id.longValue();
                this.content = zhiBoInfoTW.content;
                this.livecover_src = zhiBoInfoTW.livecover_src;
                this.reply_num = zhiBoInfoTW.reply_num.intValue();
                this.showStyle = i;
                this.zan.parseProtobuf(zhiBoInfoTW.zan);
                this.isHeadLive = zhiBoInfoTW.is_headline.intValue() == 1;
                this.userInfo.parseProtobuf(zhiBoInfoTW.user);
                if (zhiBoInfoTW.labelInfo != null) {
                    int size = zhiBoInfoTW.labelInfo.size();
                    this.labelList = new LabelInfo[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        if (zhiBoInfoTW.labelInfo.get(i2) != null) {
                            LabelInfo labelInfo = new LabelInfo();
                            labelInfo.labelHot = zhiBoInfoTW.labelInfo.get(i2).labelHot.intValue();
                            labelInfo.LabelId = zhiBoInfoTW.labelInfo.get(i2).labelId;
                            labelInfo.labelName = zhiBoInfoTW.labelInfo.get(i2).labelContent;
                            this.labelList[i2] = labelInfo;
                        }
                    }
                }
                CardPersonDynamicThreadData.a(this.labelList, this.showExpressionViewIndex);
            }
        }
    }

    public static void a(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        if (labelInfoArr != null) {
            int length = labelInfoArr.length;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            while (i < length && i < 3) {
                if (labelInfoArr[i] != null) {
                    int random = getRandom(3, -1);
                    if (random == i2 || random == i3) {
                        random = getNextShowViewIndex(length, i2, i3);
                    }
                    if (i == 0) {
                        i2 = random;
                    }
                    if (i == 1) {
                        i3 = random;
                    }
                    arrayList.add(Integer.valueOf(random));
                }
                i++;
                i2 = i2;
            }
        }
    }

    public static int getRandom(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        if (nextInt == i2) {
            return (nextInt + 1) % i;
        }
        return nextInt;
    }

    private static int getNextShowViewIndex(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }
}
