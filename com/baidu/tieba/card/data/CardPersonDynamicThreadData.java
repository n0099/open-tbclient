package com.baidu.tieba.card.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes7.dex */
public class CardPersonDynamicThreadData extends com.baidu.tbadk.core.data.a {
    public static final BdUniqueId ivy = BdUniqueId.gen();
    public bz eHK;
    public String firstPostId;
    public String forumId;
    public String forumName;
    public boolean isPrivacy;
    public String ivA;
    public long ivB;
    public int ivC;
    public int ivD;
    public String ivF;
    public String ivG;
    public String ivH;
    public String ivR;
    public int ivz;
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
    public boolean ivn = false;
    public boolean fAA = true;
    public int ivE = 0;
    public int from = 0;
    public Abs[] ivI = new Abs[0];
    public MediaData[] ivJ = new MediaData[0];
    public VoiceData.VoiceModel[] ivK = new VoiceData.VoiceModel[0];
    public ZhiBoInfoTW ivL = new ZhiBoInfoTW();
    public MultipleForum[] ivM = new MultipleForum[0];
    public boolean ivN = true;
    public boolean ivO = true;
    public boolean ivP = false;
    public boolean ivQ = false;
    public boolean isHost = true;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ivy;
    }

    public void a(User user, ThreadInfo threadInfo, int i, long j) {
        if (threadInfo != null) {
            this.forumId = String.valueOf(threadInfo.fid);
            this.threadId = String.valueOf(threadInfo.tid);
            this.postId = String.valueOf(threadInfo.post_id);
            this.firstPostId = this.postId;
            this.ivz = threadInfo.create_time.intValue();
            this.ivF = at.getChineseYearBytime(j * 1000);
            this.ivG = at.getChineseMonthBytime(j * 1000);
            this.ivH = at.getDateBytime(j * 1000);
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
            this.ivB = threadInfo.thread_type.intValue();
            this.ivI = new Abs[threadInfo._abstract.size()];
            StringBuilder sb = new StringBuilder();
            if (threadInfo._abstract != null) {
                for (int i2 = 0; i2 < this.ivI.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(threadInfo._abstract.get(i2));
                    this.ivI[i2] = abs;
                    if (threadInfo._abstract.get(i2).type.intValue() == 0) {
                        sb.append(threadInfo._abstract.get(i2).text);
                    }
                }
            }
            this.ivA = sb.toString();
            this.ivC = threadInfo.reply_num.intValue();
            this.ivD = threadInfo.view_num.intValue();
            if (threadInfo.media != null) {
                this.ivJ = new MediaData[threadInfo.media.size()];
                for (int i3 = 0; i3 < this.ivJ.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(threadInfo.media.get(i3));
                    this.ivJ[i3] = mediaData;
                }
            }
            if (threadInfo.voice_info != null) {
                this.ivK = new VoiceData.VoiceModel[threadInfo.voice_info.size()];
                for (int i4 = 0; i4 < this.ivK.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(threadInfo.voice_info.get(i4));
                    this.ivK[i4] = voiceModel;
                }
            }
            if (threadInfo.multiple_forum_list != null) {
                this.ivM = new MultipleForum[threadInfo.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.ivM.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i5));
                    this.ivM[i5] = multipleForum;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                this.ivL.parseProtobuf(threadInfo.twzhibo_info, i);
            }
            this.eHK = new bz();
            this.eHK.a(threadInfo);
            this.eHK.setId(this.threadId);
            this.eHK.setTid(this.threadId);
            this.eHK.setFid(threadInfo.fid.longValue());
            this.eHK.nh(this.ivC);
            this.eHK.ni(this.ivD);
            this.eHK.dG(this.ivz);
            if (threadInfo.agree != null) {
                this.eHK.nq(threadInfo.agree.agree_type.intValue());
                this.eHK.no(threadInfo.agree.has_agree.intValue());
                long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                this.eHK.dH(longValue);
                this.eHK.dI(longValue2);
                if (this.eHK.bpa() == 1 && longValue == 0 && longValue2 == 0) {
                    this.eHK.np(1);
                }
            }
            this.eHK.nm(threadInfo.is_ntitle.intValue());
            this.eHK.eRv = true;
            if (this.eHK.bnx() != null && user != null) {
                this.eHK.bnx().parserProtobuf(user);
                this.eHK.bnV();
            }
            this.eHK.zZ(threadInfo.article_cover);
            this.eHK.a(this.videoInfo);
            if (this.eHK.bmg()) {
                this.eHK.nr(1);
            }
            this.eHK.boa();
        }
    }

    public void a(User user, PostInfoList postInfoList, int i) {
        if (postInfoList != null) {
            this.forumId = String.valueOf(postInfoList.forum_id);
            this.threadId = String.valueOf(postInfoList.thread_id);
            this.postId = String.valueOf(postInfoList.post_id);
            this.firstPostId = this.postId;
            this.ivz = postInfoList.create_time.intValue();
            long intValue = postInfoList.create_time.intValue() * 1000;
            this.ivF = at.getChineseYearBytime(intValue);
            this.ivG = at.getChineseMonthBytime(intValue);
            this.ivH = at.getDateBytime(intValue);
            this.forumName = postInfoList.forum_name;
            this.title = postInfoList.title;
            this.rich_title = postInfoList.rich_title;
            this.rich_abstract = postInfoList.rich_abstract;
            this.userName = postInfoList.user_name;
            this.userId = postInfoList.user_id.longValue();
            this.userPortrait = postInfoList.user_portrait;
            this.ivB = postInfoList.thread_type.longValue();
            this.ivE = postInfoList.is_post_deleted.intValue();
            if (postInfoList.is_remain.intValue() == 0) {
                this.isPrivacy = false;
            } else if (postInfoList.is_remain.intValue() == 1) {
                this.isPrivacy = true;
            }
            StringBuilder sb = new StringBuilder();
            if (postInfoList.abstract_thread != null) {
                this.ivI = new Abs[postInfoList.abstract_thread.size()];
                for (int i2 = 0; i2 < this.ivI.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                    this.ivI[i2] = abs;
                    if (postInfoList.abstract_thread.get(i2).type.intValue() == 0) {
                        sb.append(postInfoList.abstract_thread.get(i2).text);
                    }
                }
            }
            this.ivA = sb.toString();
            this.ivC = postInfoList.reply_num.intValue();
            this.ivD = postInfoList.freq_num.intValue();
            if (postInfoList.media != null) {
                this.ivJ = new MediaData[postInfoList.media.size()];
                for (int i3 = 0; i3 < this.ivJ.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(postInfoList.media.get(i3));
                    this.ivJ[i3] = mediaData;
                }
            }
            if (postInfoList.voice_info != null) {
                this.ivK = new VoiceData.VoiceModel[postInfoList.voice_info.size()];
                for (int i4 = 0; i4 < this.ivK.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(postInfoList.voice_info.get(i4));
                    this.ivK[i4] = voiceModel;
                }
            }
            if (postInfoList.twzhibo_info != null) {
                this.ivL.parseProtobuf(postInfoList.twzhibo_info, i);
            }
            if (postInfoList.video_info != null) {
                this.videoInfo = postInfoList.video_info;
            }
            if (postInfoList.multiple_forum_list != null && postInfoList.multiple_forum_list.size() > 0) {
                this.ivM = new MultipleForum[postInfoList.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.ivM.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i5));
                    this.ivM[i5] = multipleForum;
                }
            } else if (!TextUtils.isEmpty(this.forumName) && com.baidu.adp.lib.f.b.toLong(this.forumId, -1L) != -1) {
                this.ivM = new MultipleForum[1];
                MultipleForum multipleForum2 = new MultipleForum();
                multipleForum2.forum_id = com.baidu.adp.lib.f.b.toLong(this.forumId, 0L);
                multipleForum2.forum_name = this.forumName;
                this.ivM[0] = multipleForum2;
            }
            this.eHK = new bz();
            if (postInfoList.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserProtobuf(postInfoList.ala_info);
                this.eHK.a(alaInfoData);
                this.eHK.setTitle(this.title);
                this.ivD = postInfoList.view_num.intValue();
            }
            if (postInfoList.agree != null) {
                this.eHK.nq(postInfoList.agree.agree_type.intValue());
                this.eHK.no(postInfoList.agree.has_agree.intValue());
                long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
                long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
                this.eHK.dH(longValue);
                this.eHK.dI(longValue2);
                if (this.eHK.bpa() == 1 && longValue == 0 && longValue2 == 0) {
                    this.eHK.np(1);
                }
                AgreeData bpr = this.eHK.bpr();
                if (bpr != null) {
                    bpr.threadId = this.threadId;
                    bpr.parseProtobuf(postInfoList.agree);
                }
            }
            if (postInfoList.is_share_thread.intValue() == 1) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                originalThreadInfo.a(postInfoList.origin_thread_info);
                this.eHK.eQQ = originalThreadInfo;
                this.eHK.isShareThread = true;
            }
            this.eHK.dJ(postInfoList.share_num.intValue());
            this.eHK.setId(this.threadId);
            this.eHK.setTid(this.threadId);
            this.eHK.setFid(postInfoList.forum_id.longValue());
            this.eHK.zR(this.forumName);
            this.eHK.nh(this.ivC);
            this.eHK.ni(this.ivD);
            this.eHK.dG(this.ivz);
            this.eHK.setTitle(this.title);
            this.eHK.bw(this.rich_title);
            this.eHK.bx(this.rich_abstract);
            this.eHK.zU(this.ivA);
            this.eHK.setThreadType((int) this.ivB);
            this.eHK.bv(postInfoList.first_post_content);
            if (this.ivJ != null) {
                this.eHK.B(new ArrayList<>(Arrays.asList(this.ivJ)));
            }
            if (this.ivK != null) {
                this.eHK.C(new ArrayList<>(Arrays.asList(this.ivK)));
            }
            this.eHK.nm(postInfoList.is_ntitle.intValue());
            this.eHK.eRv = true;
            if (this.eHK.bnx() != null && user != null) {
                this.eHK.bnx().parserProtobuf(user);
                this.eHK.bnV();
            }
            this.eHK.zZ(postInfoList.article_cover);
            this.eHK.a(this.videoInfo);
            if (this.eHK.bmg()) {
                this.eHK.nr(1);
            }
            this.eHK.isPrivacy = this.isPrivacy;
            this.eHK.eRy = this.firstPostId;
            if (postInfoList.item != null) {
                this.eHK.a(postInfoList.item);
                ItemData itemData = new ItemData();
                itemData.parseProto(postInfoList.item);
                this.eHK.itemData = itemData;
            }
            if (postInfoList.item_star != null) {
                this.eHK.by(postInfoList.item_star);
                ItemStarData itemStarData = new ItemStarData();
                itemStarData.parseProto(postInfoList.item_star);
                this.eHK.itemStarData = itemStarData;
            }
            if (postInfoList.poll_info != null) {
                PollData pollData = new PollData();
                pollData.parserProtobuf(postInfoList.poll_info);
                this.eHK.b(pollData);
            }
            if (postInfoList.pb_link_info != null && !x.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList = new ArrayList();
                for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    arrayList.add(pbLinkData);
                }
                this.eHK.bz(arrayList);
            }
            if (postInfoList.pb_goods_info != null && !x.isEmpty(postInfoList.pb_goods_info)) {
                ArrayList arrayList2 = new ArrayList();
                for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    arrayList2.add(pbGoodsData);
                }
                this.eHK.bA(arrayList2);
            }
            if (postInfoList.pb_link_info != null && !x.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList3 = new ArrayList();
                for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData2 = new PbLinkData();
                    pbLinkData2.parseProto(pbLinkInfo2);
                    arrayList3.add(pbLinkData2);
                }
                this.eHK.bz(arrayList3);
            }
            this.eHK.boa();
        }
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return this.eHK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public com.baidu.tbadk.core.data.at bkX() {
        return null;
    }

    /* loaded from: classes7.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan != null) {
                this.num = zan.num.intValue();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                    if (random == i3 || random == i2) {
                        random = getNextShowViewIndex(length, i3, i2);
                    }
                    if (i == 0) {
                        i3 = random;
                    }
                    if (i == 1) {
                        i2 = random;
                    }
                    arrayList.add(Integer.valueOf(random));
                }
                i++;
                i3 = i3;
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
