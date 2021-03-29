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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.b.e.m.b;
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import tbclient.Abstract;
import tbclient.Agree;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.PostInfoList;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.VideoInfo;
import tbclient.Voice;
/* loaded from: classes4.dex */
public class CardPersonDynamicThreadData extends a {
    public static final BdUniqueId K = BdUniqueId.gen();
    public VideoInfo A;
    public String I;
    public int J;

    /* renamed from: e  reason: collision with root package name */
    public String f15275e;

    /* renamed from: f  reason: collision with root package name */
    public String f15276f;

    /* renamed from: g  reason: collision with root package name */
    public String f15277g;

    /* renamed from: h  reason: collision with root package name */
    public String f15278h;
    public int i;
    public String j;
    public String k;
    public String l;
    public long m;
    public int n;
    public int o;
    public boolean q;
    public a2 r;
    public String t;
    public String u;
    public String v;
    public List<PbContent> x;
    public List<PbContent> y;
    public int p = 0;
    public int s = 0;
    public Abs[] w = new Abs[0];
    public MediaData[] z = new MediaData[0];
    public VoiceData$VoiceModel[] B = new VoiceData$VoiceModel[0];
    public ZhiBoInfoTW C = new ZhiBoInfoTW();
    public MultipleForum[] D = new MultipleForum[0];
    public boolean E = true;
    public boolean F = true;
    public boolean G = false;
    public boolean H = true;

    /* loaded from: classes4.dex */
    public static class Abs extends OrmObject implements Serializable {
        public int type = 0;
        public String text = "";
        public String src = "";
        public String un = "";
        public String link = "";

        public void parseProtobuf(Abstract r2) {
            if (r2 == null) {
                return;
            }
            this.type = r2.type.intValue();
            this.text = r2.text;
            this.src = r2.src;
            this.un = r2.un;
            this.link = r2.link;
        }
    }

    /* loaded from: classes4.dex */
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
            if (anchorInfo == null) {
                return;
            }
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

    /* loaded from: classes4.dex */
    public static class LabelInfo extends OrmObject implements Serializable {
        public int labelHot = 0;
        public String labelName = "";
        public String LabelId = "";

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            if (labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes4.dex */
    public static class LbsInfo implements Serializable {
        public String lat = "";
        public String lon = "";
        public String town = "";

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            if (lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes4.dex */
    public static class Media extends OrmObject implements Serializable {
        public int type = 0;
        public String small_pic = "";
        public String big_pic = "";
        public String water_pic = "";
        public String dynamic_pic = "";

        public void parseProtobuf(tbclient.Media media) {
            if (media == null) {
                return;
            }
            this.type = media.type.intValue();
            this.small_pic = media.small_pic;
            this.big_pic = media.big_pic;
            this.water_pic = media.water_pic;
            this.dynamic_pic = media.dynamic_pic;
        }
    }

    /* loaded from: classes4.dex */
    public static class MultipleForum extends OrmObject implements Serializable {
        public long forum_id = 0;
        public String forum_name = "";

        public void parseProtobuf(tbclient.MultipleForum multipleForum) {
            if (multipleForum == null) {
                return;
            }
            this.forum_id = multipleForum.forum_id.longValue();
            this.forum_name = multipleForum.forum_name;
        }
    }

    /* loaded from: classes4.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public Abs[] post_content = new Abs[0];
        public long create_time = 0;
        public long post_type = 0;
        public long post_id = 0;

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            if (postInfoContent == null) {
                return;
            }
            this.create_time = postInfoContent.create_time.longValue();
            this.post_id = postInfoContent.post_id.longValue();
            this.post_type = postInfoContent.post_type.longValue();
            List<Abstract> list = postInfoContent.post_content;
            if (list != null) {
                this.post_content = new Abs[list.size()];
                for (int i = 0; i < this.post_content.length; i++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoContent.post_content.get(i));
                    this.post_content[i] = abs;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Quote extends OrmObject implements Serializable {
        public long post_id = 0;
        public String user_name = "";
        public long user_id = 0;
        public String ip = null;
        public String content = "";

        public void parseProtobuf(tbclient.Quote quote) {
            if (quote == null) {
                return;
            }
            this.post_id = quote.post_id.longValue();
            this.user_id = quote.user_id.longValue();
            this.user_name = quote.user_name;
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }

    /* loaded from: classes4.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public String portrait = "";
        public String name_show = "";
        public long id = 0;

        public void parseProtobuf(User user) {
            if (user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class Zan extends OrmObject implements Serializable {
        public int num = 0;

        public void parseProtobuf(tbclient.Zan zan) {
            if (zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes4.dex */
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
            if (zhiBoInfoTW == null) {
                return;
            }
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
            List<tbclient.LabelInfo> list = zhiBoInfoTW.labelInfo;
            if (list != null) {
                int size = list.size();
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
            CardPersonDynamicThreadData.D(this.labelList, this.showExpressionViewIndex);
        }
    }

    public static int A(int i, int i2) {
        int nextInt = new Random().nextInt(i);
        return nextInt == i2 ? (nextInt + 1) % i : nextInt;
    }

    public static void D(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        if (labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < length && i3 < 3; i3++) {
            if (labelInfoArr[i3] != null) {
                int A = A(3, -1);
                if (A == i || A == i2) {
                    A = z(length, i, i2);
                }
                if (i3 == 0) {
                    i = A;
                }
                if (i3 == 1) {
                    i2 = A;
                }
                arrayList.add(Integer.valueOf(A));
            }
        }
    }

    public static int z(int i, int i2, int i3) {
        for (int i4 = 0; i4 < i && i4 < 3; i4++) {
            if (i4 != i2 && i4 != i3) {
                return i4;
            }
        }
        return -1;
    }

    public void B(User user, PostInfoList postInfoList, int i) {
        if (postInfoList == null) {
            return;
        }
        this.f15275e = String.valueOf(postInfoList.forum_id);
        this.f15276f = String.valueOf(postInfoList.thread_id);
        String valueOf = String.valueOf(postInfoList.post_id);
        this.f15277g = valueOf;
        this.f15278h = valueOf;
        this.i = postInfoList.create_time.intValue();
        long intValue = postInfoList.create_time.intValue() * 1000;
        this.t = StringHelper.getChineseYearBytime(intValue);
        this.u = StringHelper.getChineseMonthBytime(intValue);
        this.v = StringHelper.getDateBytime(intValue);
        this.j = postInfoList.forum_name;
        this.k = postInfoList.title;
        this.x = postInfoList.rich_title;
        this.y = postInfoList.rich_abstract;
        String str = postInfoList.user_name;
        postInfoList.user_id.longValue();
        String str2 = postInfoList.user_portrait;
        this.m = postInfoList.thread_type.longValue();
        this.p = postInfoList.is_post_deleted.intValue();
        if (postInfoList.is_remain.intValue() == 0) {
            this.q = false;
        } else if (postInfoList.is_remain.intValue() == 1) {
            this.q = true;
        }
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = postInfoList.abstract_thread;
        if (list != null) {
            this.w = new Abs[list.size()];
            for (int i2 = 0; i2 < this.w.length; i2++) {
                Abs abs = new Abs();
                abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                this.w[i2] = abs;
                if (postInfoList.abstract_thread.get(i2).type.intValue() == 0) {
                    sb.append(postInfoList.abstract_thread.get(i2).text);
                }
            }
        }
        this.l = sb.toString();
        this.n = postInfoList.reply_num.intValue();
        this.o = postInfoList.freq_num.intValue();
        List<tbclient.Media> list2 = postInfoList.media;
        if (list2 != null) {
            this.z = new MediaData[list2.size()];
            for (int i3 = 0; i3 < this.z.length; i3++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(postInfoList.media.get(i3));
                this.z[i3] = mediaData;
            }
        }
        List<Voice> list3 = postInfoList.voice_info;
        if (list3 != null) {
            this.B = new VoiceData$VoiceModel[list3.size()];
            for (int i4 = 0; i4 < this.B.length; i4++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(postInfoList.voice_info.get(i4));
                this.B[i4] = voiceData$VoiceModel;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.C.parseProtobuf(zhiBoInfoTW, i);
        }
        VideoInfo videoInfo = postInfoList.video_info;
        if (videoInfo != null) {
            this.A = videoInfo;
        }
        List<tbclient.MultipleForum> list4 = postInfoList.multiple_forum_list;
        if (list4 != null && list4.size() > 0) {
            this.D = new MultipleForum[postInfoList.multiple_forum_list.size()];
            for (int i5 = 0; i5 < this.D.length; i5++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i5));
                this.D[i5] = multipleForum;
            }
        } else if (!TextUtils.isEmpty(this.j) && b.f(this.f15275e, -1L) != -1) {
            this.D = new MultipleForum[1];
            MultipleForum multipleForum2 = new MultipleForum();
            multipleForum2.forum_id = b.f(this.f15275e, 0L);
            multipleForum2.forum_name = this.j;
            this.D[0] = multipleForum2;
        }
        this.r = new a2();
        if (postInfoList.ala_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            alaInfoData.parserProtobuf(postInfoList.ala_info);
            this.r.i4(alaInfoData);
            this.r.m4(this.k);
            this.o = postInfoList.view_num.intValue();
        }
        Agree agree = postInfoList.agree;
        if (agree != null) {
            this.r.m3(agree.agree_type.intValue());
            this.r.B3(postInfoList.agree.has_agree.intValue());
            long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
            long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
            this.r.l3(longValue);
            this.r.s3(longValue2);
            if (this.r.m0() == 1 && longValue == 0 && longValue2 == 0) {
                this.r.k3(1);
            }
            AgreeData L = this.r.L();
            if (L != null) {
                L.threadId = this.f15276f;
                L.parseProtobuf(postInfoList.agree);
            }
        }
        if (postInfoList.is_share_thread.intValue() == 1) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.j(postInfoList.origin_thread_info);
            a2 a2Var = this.r;
            a2Var.r1 = originalThreadInfo;
            a2Var.s1 = true;
        }
        this.r.d4(postInfoList.share_num.intValue());
        this.r.D3(this.f15276f);
        this.r.l4(this.f15276f);
        this.r.t3(postInfoList.forum_id.longValue());
        this.r.x3(this.j);
        this.r.Y3(this.n);
        this.r.r4(this.o);
        this.r.P3(this.i);
        this.r.m4(this.k);
        this.r.b4(this.x);
        this.r.a4(this.y);
        this.r.h3(this.l);
        this.r.k4((int) this.m);
        this.r.v3(postInfoList.first_post_content);
        if (this.z != null) {
            this.r.U3(new ArrayList<>(Arrays.asList(this.z)));
        }
        if (this.B != null) {
            this.r.s4(new ArrayList<>(Arrays.asList(this.B)));
        }
        this.r.w4(postInfoList.is_ntitle.intValue());
        a2 a2Var2 = this.r;
        a2Var2.W1 = true;
        if (a2Var2.T() != null && user != null) {
            this.r.T().parserProtobuf(user);
            this.r.W2();
        }
        this.r.o3(postInfoList.article_cover);
        this.r.q4(this.A);
        if (this.r.x2()) {
            this.r.F3(1);
        }
        a2 a2Var3 = this.r;
        a2Var3.b2 = this.q;
        a2Var3.c2 = this.f15278h;
        Item item = postInfoList.item;
        if (item != null) {
            a2Var3.M3(item);
            ItemData itemData = new ItemData();
            itemData.parseProto(postInfoList.item);
            this.r.r2 = itemData;
        }
        List<HeadItem> list5 = postInfoList.item_star;
        if (list5 != null) {
            this.r.O3(list5);
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(postInfoList.item_star);
            this.r.t2 = itemStarData;
        }
        if (postInfoList.poll_info != null) {
            PollData pollData = new PollData();
            pollData.parserProtobuf(postInfoList.poll_info);
            this.r.W3(pollData);
        }
        List<PbLinkInfo> list6 = postInfoList.pb_link_info;
        if (list6 != null && !ListUtils.isEmpty(list6)) {
            ArrayList arrayList = new ArrayList();
            for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                PbLinkData pbLinkData = new PbLinkData();
                pbLinkData.parseProto(pbLinkInfo);
                arrayList.add(pbLinkData);
            }
            this.r.Q3(arrayList);
        }
        List<PbGoodsInfo> list7 = postInfoList.pb_goods_info;
        if (list7 != null && !ListUtils.isEmpty(list7)) {
            ArrayList arrayList2 = new ArrayList();
            for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                PbGoodsData pbGoodsData = new PbGoodsData();
                pbGoodsData.parseProto(pbGoodsInfo);
                arrayList2.add(pbGoodsData);
            }
            this.r.u4(arrayList2);
        }
        int intValue2 = postInfoList.is_author_view.intValue();
        this.J = intValue2;
        this.r.D2 = intValue2;
        List<PbLinkInfo> list8 = postInfoList.pb_link_info;
        if (list8 != null && !ListUtils.isEmpty(list8)) {
            ArrayList arrayList3 = new ArrayList();
            for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                PbLinkData pbLinkData2 = new PbLinkData();
                pbLinkData2.parseProto(pbLinkInfo2);
                arrayList3.add(pbLinkData2);
            }
            this.r.Q3(arrayList3);
        }
        this.r.b3();
    }

    public void C(User user, ThreadInfo threadInfo, int i, long j) {
        if (threadInfo == null) {
            return;
        }
        this.f15275e = String.valueOf(threadInfo.fid);
        this.f15276f = String.valueOf(threadInfo.tid);
        String valueOf = String.valueOf(threadInfo.post_id);
        this.f15277g = valueOf;
        this.f15278h = valueOf;
        this.i = threadInfo.create_time.intValue();
        long j2 = j * 1000;
        this.t = StringHelper.getChineseYearBytime(j2);
        this.u = StringHelper.getChineseMonthBytime(j2);
        this.v = StringHelper.getDateBytime(j2);
        this.j = threadInfo.fname;
        this.A = threadInfo.video_info;
        this.k = threadInfo.title;
        this.x = threadInfo.rich_title;
        this.y = threadInfo.rich_abstract;
        User user2 = threadInfo.author;
        if (user2 != null) {
            String str = user2.name;
            user2.id.longValue();
            String str2 = threadInfo.author.portrait;
        }
        this.m = threadInfo.thread_type.intValue();
        this.w = new Abs[threadInfo._abstract.size()];
        StringBuilder sb = new StringBuilder();
        if (threadInfo._abstract != null) {
            for (int i2 = 0; i2 < this.w.length; i2++) {
                Abs abs = new Abs();
                abs.parseProtobuf(threadInfo._abstract.get(i2));
                this.w[i2] = abs;
                if (threadInfo._abstract.get(i2).type.intValue() == 0) {
                    sb.append(threadInfo._abstract.get(i2).text);
                }
            }
        }
        this.l = sb.toString();
        this.n = threadInfo.reply_num.intValue();
        this.o = threadInfo.view_num.intValue();
        List<tbclient.Media> list = threadInfo.media;
        if (list != null) {
            this.z = new MediaData[list.size()];
            for (int i3 = 0; i3 < this.z.length; i3++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(threadInfo.media.get(i3));
                this.z[i3] = mediaData;
            }
        }
        List<Voice> list2 = threadInfo.voice_info;
        if (list2 != null) {
            this.B = new VoiceData$VoiceModel[list2.size()];
            for (int i4 = 0; i4 < this.B.length; i4++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(threadInfo.voice_info.get(i4));
                this.B[i4] = voiceData$VoiceModel;
            }
        }
        List<tbclient.MultipleForum> list3 = threadInfo.multiple_forum_list;
        if (list3 != null) {
            this.D = new MultipleForum[list3.size()];
            for (int i5 = 0; i5 < this.D.length; i5++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i5));
                this.D[i5] = multipleForum;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.C.parseProtobuf(zhiBoInfoTW, i);
        }
        a2 a2Var = new a2();
        this.r = a2Var;
        a2Var.Q2(threadInfo);
        this.r.D3(this.f15276f);
        this.r.l4(this.f15276f);
        this.r.t3(threadInfo.fid.longValue());
        this.r.Y3(this.n);
        this.r.r4(this.o);
        this.r.P3(this.i);
        Agree agree = threadInfo.agree;
        if (agree != null) {
            this.r.m3(agree.agree_type.intValue());
            this.r.B3(threadInfo.agree.has_agree.intValue());
            long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
            long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
            this.r.l3(longValue);
            this.r.s3(longValue2);
            if (this.r.m0() == 1 && longValue == 0 && longValue2 == 0) {
                this.r.k3(1);
            }
        }
        this.r.w4(threadInfo.is_ntitle.intValue());
        a2 a2Var2 = this.r;
        a2Var2.W1 = true;
        if (a2Var2.T() != null && user != null) {
            this.r.T().parserProtobuf(user);
            this.r.W2();
        }
        this.r.o3(threadInfo.article_cover);
        this.r.q4(this.A);
        if (this.r.x2()) {
            this.r.F3(1);
        }
        this.r.b3();
    }

    @Override // d.b.h0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return K;
    }

    @Override // d.b.h0.r.q.a
    public a2 n() {
        return this.r;
    }
}
