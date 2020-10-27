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
/* loaded from: classes24.dex */
public class CardPersonDynamicThreadData extends AbsThreadDataSupport {
    public static final BdUniqueId hWa = BdUniqueId.gen();
    public int auV;
    public bw erH;
    public String firstPostId;
    public String forumId;
    public String forumName;
    public int hWb;
    public String hWc;
    public long hWd;
    public int hWe;
    public String hWg;
    public String hWh;
    public String hWi;
    public String hWs;
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
    public boolean hVO = false;
    public boolean fiZ = true;
    public int hWf = 0;
    public int from = 0;
    public Abs[] hWj = new Abs[0];
    public MediaData[] hWk = new MediaData[0];
    public VoiceData.VoiceModel[] hWl = new VoiceData.VoiceModel[0];
    public ZhiBoInfoTW hWm = new ZhiBoInfoTW();
    public MultipleForum[] hWn = new MultipleForum[0];
    public boolean hWo = true;
    public boolean hWp = true;
    public boolean hWq = false;
    public boolean hWr = false;
    public boolean isHost = true;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWa;
    }

    public void a(User user, ThreadInfo threadInfo, int i, long j) {
        if (threadInfo != null) {
            this.forumId = String.valueOf(threadInfo.fid);
            this.threadId = String.valueOf(threadInfo.tid);
            this.postId = String.valueOf(threadInfo.post_id);
            this.firstPostId = this.postId;
            this.hWb = threadInfo.create_time.intValue();
            this.hWg = at.getChineseYearBytime(j * 1000);
            this.hWh = at.getChineseMonthBytime(j * 1000);
            this.hWi = at.getDateBytime(j * 1000);
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
            this.hWd = threadInfo.thread_type.intValue();
            this.hWj = new Abs[threadInfo._abstract.size()];
            StringBuilder sb = new StringBuilder();
            if (threadInfo._abstract != null) {
                for (int i2 = 0; i2 < this.hWj.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(threadInfo._abstract.get(i2));
                    this.hWj[i2] = abs;
                    if (threadInfo._abstract.get(i2).type.intValue() == 0) {
                        sb.append(threadInfo._abstract.get(i2).text);
                    }
                }
            }
            this.hWc = sb.toString();
            this.auV = threadInfo.reply_num.intValue();
            this.hWe = threadInfo.view_num.intValue();
            if (threadInfo.media != null) {
                this.hWk = new MediaData[threadInfo.media.size()];
                for (int i3 = 0; i3 < this.hWk.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(threadInfo.media.get(i3));
                    this.hWk[i3] = mediaData;
                }
            }
            if (threadInfo.voice_info != null) {
                this.hWl = new VoiceData.VoiceModel[threadInfo.voice_info.size()];
                for (int i4 = 0; i4 < this.hWl.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(threadInfo.voice_info.get(i4));
                    this.hWl[i4] = voiceModel;
                }
            }
            if (threadInfo.multiple_forum_list != null) {
                this.hWn = new MultipleForum[threadInfo.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.hWn.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i5));
                    this.hWn[i5] = multipleForum;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                this.hWm.parseProtobuf(threadInfo.twzhibo_info, i);
            }
            this.erH = new bw();
            this.erH.a(threadInfo);
            this.erH.setId(this.threadId);
            this.erH.setTid(this.threadId);
            this.erH.setFid(threadInfo.fid.longValue());
            this.erH.nZ(this.auV);
            this.erH.oa(this.hWe);
            this.erH.cL(this.hWb);
            if (threadInfo.agree != null) {
                this.erH.oi(threadInfo.agree.agree_type.intValue());
                this.erH.og(threadInfo.agree.has_agree.intValue());
                long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                this.erH.cM(longValue);
                this.erH.cN(longValue2);
                if (this.erH.blA() == 1 && longValue == 0 && longValue2 == 0) {
                    this.erH.oh(1);
                }
            }
            this.erH.oe(threadInfo.is_ntitle.intValue());
            this.erH.eBc = true;
            if (this.erH.bka() != null && user != null) {
                this.erH.bka().parserProtobuf(user);
                this.erH.bkz();
            }
            this.erH.AW(threadInfo.article_cover);
            this.erH.a(this.videoInfo);
            if (this.erH.biK()) {
                this.erH.oj(1);
            }
            this.erH.bkE();
        }
    }

    public void a(User user, PostInfoList postInfoList, int i) {
        if (postInfoList != null) {
            this.forumId = String.valueOf(postInfoList.forum_id);
            this.threadId = String.valueOf(postInfoList.thread_id);
            this.postId = String.valueOf(postInfoList.post_id);
            this.firstPostId = this.postId;
            this.hWb = postInfoList.create_time.intValue();
            long intValue = postInfoList.create_time.intValue() * 1000;
            this.hWg = at.getChineseYearBytime(intValue);
            this.hWh = at.getChineseMonthBytime(intValue);
            this.hWi = at.getDateBytime(intValue);
            this.forumName = postInfoList.forum_name;
            this.title = postInfoList.title;
            this.rich_title = postInfoList.rich_title;
            this.rich_abstract = postInfoList.rich_abstract;
            this.userName = postInfoList.user_name;
            this.userId = postInfoList.user_id.longValue();
            this.userPortrait = postInfoList.user_portrait;
            this.hWd = postInfoList.thread_type.longValue();
            this.hWf = postInfoList.is_post_deleted.intValue();
            if (postInfoList.is_remain.intValue() == 0) {
                this.isPrivacy = false;
            } else if (postInfoList.is_remain.intValue() == 1) {
                this.isPrivacy = true;
            }
            StringBuilder sb = new StringBuilder();
            if (postInfoList.abstract_thread != null) {
                this.hWj = new Abs[postInfoList.abstract_thread.size()];
                for (int i2 = 0; i2 < this.hWj.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                    this.hWj[i2] = abs;
                    if (postInfoList.abstract_thread.get(i2).type.intValue() == 0) {
                        sb.append(postInfoList.abstract_thread.get(i2).text);
                    }
                }
            }
            this.hWc = sb.toString();
            this.auV = postInfoList.reply_num.intValue();
            this.hWe = postInfoList.freq_num.intValue();
            if (postInfoList.media != null) {
                this.hWk = new MediaData[postInfoList.media.size()];
                for (int i3 = 0; i3 < this.hWk.length; i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(postInfoList.media.get(i3));
                    this.hWk[i3] = mediaData;
                }
            }
            if (postInfoList.voice_info != null) {
                this.hWl = new VoiceData.VoiceModel[postInfoList.voice_info.size()];
                for (int i4 = 0; i4 < this.hWl.length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    voiceModel.parserProtobuf(postInfoList.voice_info.get(i4));
                    this.hWl[i4] = voiceModel;
                }
            }
            if (postInfoList.twzhibo_info != null) {
                this.hWm.parseProtobuf(postInfoList.twzhibo_info, i);
            }
            if (postInfoList.video_info != null) {
                this.videoInfo = postInfoList.video_info;
            }
            if (postInfoList.multiple_forum_list != null && postInfoList.multiple_forum_list.size() > 0) {
                this.hWn = new MultipleForum[postInfoList.multiple_forum_list.size()];
                for (int i5 = 0; i5 < this.hWn.length; i5++) {
                    MultipleForum multipleForum = new MultipleForum();
                    multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i5));
                    this.hWn[i5] = multipleForum;
                }
            } else if (!TextUtils.isEmpty(this.forumName) && com.baidu.adp.lib.f.b.toLong(this.forumId, -1L) != -1) {
                this.hWn = new MultipleForum[1];
                MultipleForum multipleForum2 = new MultipleForum();
                multipleForum2.forum_id = com.baidu.adp.lib.f.b.toLong(this.forumId, 0L);
                multipleForum2.forum_name = this.forumName;
                this.hWn[0] = multipleForum2;
            }
            this.erH = new bw();
            if (postInfoList.ala_info != null) {
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserProtobuf(postInfoList.ala_info);
                this.erH.a(alaInfoData);
                this.erH.setTitle(this.title);
                this.hWe = postInfoList.view_num.intValue();
            }
            if (postInfoList.agree != null) {
                this.erH.oi(postInfoList.agree.agree_type.intValue());
                this.erH.og(postInfoList.agree.has_agree.intValue());
                long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
                long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
                this.erH.cM(longValue);
                this.erH.cN(longValue2);
                if (this.erH.blA() == 1 && longValue == 0 && longValue2 == 0) {
                    this.erH.oh(1);
                }
                AgreeData blR = this.erH.blR();
                if (blR != null) {
                    blR.threadId = this.threadId;
                    blR.parseProtobuf(postInfoList.agree);
                }
            }
            if (postInfoList.is_share_thread.intValue() == 1) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                originalThreadInfo.a(postInfoList.origin_thread_info);
                this.erH.eAy = originalThreadInfo;
                this.erH.isShareThread = true;
            }
            this.erH.cO(postInfoList.share_num.intValue());
            this.erH.setId(this.threadId);
            this.erH.setTid(this.threadId);
            this.erH.setFid(postInfoList.forum_id.longValue());
            this.erH.AO(this.forumName);
            this.erH.nZ(this.auV);
            this.erH.oa(this.hWe);
            this.erH.cL(this.hWb);
            this.erH.setTitle(this.title);
            this.erH.bf(this.rich_title);
            this.erH.bg(this.rich_abstract);
            this.erH.AR(this.hWc);
            this.erH.setThreadType((int) this.hWd);
            this.erH.be(postInfoList.first_post_content);
            if (this.hWk != null) {
                this.erH.G(new ArrayList<>(Arrays.asList(this.hWk)));
            }
            if (this.hWl != null) {
                this.erH.H(new ArrayList<>(Arrays.asList(this.hWl)));
            }
            this.erH.oe(postInfoList.is_ntitle.intValue());
            this.erH.eBc = true;
            if (this.erH.bka() != null && user != null) {
                this.erH.bka().parserProtobuf(user);
                this.erH.bkz();
            }
            this.erH.AW(postInfoList.article_cover);
            this.erH.a(this.videoInfo);
            if (this.erH.biK()) {
                this.erH.oj(1);
            }
            this.erH.isPrivacy = this.isPrivacy;
            this.erH.eBf = this.firstPostId;
            if (postInfoList.item != null) {
                this.erH.a(postInfoList.item);
                ItemData itemData = new ItemData();
                itemData.parseProto(postInfoList.item);
                this.erH.itemData = itemData;
            }
            if (postInfoList.item_star != null) {
                this.erH.bh(postInfoList.item_star);
                ItemStarData itemStarData = new ItemStarData();
                itemStarData.parseProto(postInfoList.item_star);
                this.erH.itemStarData = itemStarData;
            }
            if (postInfoList.poll_info != null) {
                PollData pollData = new PollData();
                pollData.parserProtobuf(postInfoList.poll_info);
                this.erH.b(pollData);
            }
            if (postInfoList.pb_link_info != null && !y.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList = new ArrayList();
                for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    arrayList.add(pbLinkData);
                }
                this.erH.bi(arrayList);
            }
            if (postInfoList.pb_goods_info != null && !y.isEmpty(postInfoList.pb_goods_info)) {
                ArrayList arrayList2 = new ArrayList();
                for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    arrayList2.add(pbGoodsData);
                }
                this.erH.bj(arrayList2);
            }
            if (postInfoList.pb_link_info != null && !y.isEmpty(postInfoList.pb_link_info)) {
                ArrayList arrayList3 = new ArrayList();
                for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                    PbLinkData pbLinkData2 = new PbLinkData();
                    pbLinkData2.parseProto(pbLinkInfo2);
                    arrayList3.add(pbLinkData2);
                }
                this.erH.bi(arrayList3);
            }
            this.erH.bkE();
        }
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this.erH;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return null;
    }

    /* loaded from: classes24.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan != null) {
                this.num = zan.num.intValue();
            }
        }
    }

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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

    /* loaded from: classes24.dex */
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
