package com.baidu.tieba.card.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import d.a.p0.s.q.a;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
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
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId K;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoInfo A;
    public VoiceData$VoiceModel[] B;
    public ZhiBoInfoTW C;
    public MultipleForum[] D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public int J;

    /* renamed from: e  reason: collision with root package name */
    public String f14588e;

    /* renamed from: f  reason: collision with root package name */
    public String f14589f;

    /* renamed from: g  reason: collision with root package name */
    public String f14590g;

    /* renamed from: h  reason: collision with root package name */
    public String f14591h;

    /* renamed from: i  reason: collision with root package name */
    public int f14592i;
    public String j;
    public String k;
    public String l;
    public long m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public b2 r;
    public int s;
    public String t;
    public String u;
    public String v;
    public Abs[] w;
    public List<PbContent> x;
    public List<PbContent> y;
    public MediaData[] z;

    /* loaded from: classes4.dex */
    public static class Abs extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String link;
        public String src;
        public String text;
        public int type;
        public String un;

        public Abs() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = 0;
            this.text = "";
            this.src = "";
            this.un = "";
            this.link = "";
        }

        public void parseProtobuf(Abstract r5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || r5 == null) {
                return;
            }
            this.type = r5.type.intValue();
            this.text = r5.text;
            this.src = r5.src;
            this.un = r5.un;
            this.link = r5.link;
        }
    }

    /* loaded from: classes4.dex */
    public static class AnchorInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long author_id;
        public String author_name;
        public long group_id;
        public String intro;
        public int likers;
        public int listeners;
        public String name;
        public String portrait;
        public long publisherId;
        public String publisherName;
        public String publisherPortrait;
        public long start_time;
        public int status;

        public AnchorInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.portrait = "";
            this.name = "";
            this.start_time = 0L;
            this.status = 0;
            this.author_id = 0L;
            this.author_name = "";
            this.listeners = 0;
            this.likers = 0;
            this.group_id = 0L;
            this.intro = "";
            this.publisherPortrait = "";
            this.publisherName = "";
            this.publisherId = 0L;
        }

        public void parseProtobuf(tbclient.AnchorInfo anchorInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, anchorInfo) == null) || anchorInfo == null) {
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String LabelId;
        public int labelHot;
        public String labelName;

        public LabelInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.labelHot = 0;
            this.labelName = "";
            this.LabelId = "";
        }

        public void parseProtobuf(tbclient.LabelInfo labelInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, labelInfo) == null) || labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes4.dex */
    public static class LbsInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String lat;
        public String lon;
        public String town;

        public LbsInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.lat = "";
            this.lon = "";
            this.town = "";
        }

        public void parseProtobuf(tbclient.LbsInfo lbsInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lbsInfo) == null) || lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes4.dex */
    public static class Media extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String big_pic;
        public String dynamic_pic;
        public String small_pic;
        public int type;
        public String water_pic;

        public Media() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = 0;
            this.small_pic = "";
            this.big_pic = "";
            this.water_pic = "";
            this.dynamic_pic = "";
        }

        public void parseProtobuf(tbclient.Media media) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, media) == null) || media == null) {
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long forum_id;
        public String forum_name;

        public MultipleForum() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.forum_id = 0L;
            this.forum_name = "";
        }

        public void parseProtobuf(tbclient.MultipleForum multipleForum) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, multipleForum) == null) || multipleForum == null) {
                return;
            }
            this.forum_id = multipleForum.forum_id.longValue();
            this.forum_name = multipleForum.forum_name;
        }
    }

    /* loaded from: classes4.dex */
    public static class PostInfoContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long create_time;
        public Abs[] post_content;
        public long post_id;
        public long post_type;

        public PostInfoContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_content = new Abs[0];
            this.create_time = 0L;
            this.post_type = 0L;
            this.post_id = 0L;
        }

        public void parseProtobuf(tbclient.PostInfoContent postInfoContent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, postInfoContent) == null) || postInfoContent == null) {
                return;
            }
            this.create_time = postInfoContent.create_time.longValue();
            this.post_id = postInfoContent.post_id.longValue();
            this.post_type = postInfoContent.post_type.longValue();
            List<Abstract> list = postInfoContent.post_content;
            if (list != null) {
                this.post_content = new Abs[list.size()];
                for (int i2 = 0; i2 < this.post_content.length; i2++) {
                    Abs abs = new Abs();
                    abs.parseProtobuf(postInfoContent.post_content.get(i2));
                    this.post_content[i2] = abs;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Quote extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String ip;
        public long post_id;
        public long user_id;
        public String user_name;

        public Quote() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_id = 0L;
            this.user_name = "";
            this.user_id = 0L;
            this.ip = null;
            this.content = "";
        }

        public void parseProtobuf(tbclient.Quote quote) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, quote) == null) || quote == null) {
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long id;
        public String name_show;
        public String portrait;

        public UserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.portrait = "";
            this.name_show = "";
            this.id = 0L;
        }

        public void parseProtobuf(User user) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, user) == null) || user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class Zan extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int num;

        public Zan() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.num = 0;
        }

        public void parseProtobuf(tbclient.Zan zan) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zan) == null) || zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes4.dex */
    public static class ZhiBoInfoTW extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public long forum_id;
        public String forum_name;
        public boolean isHeadLive;
        public LabelInfo[] labelList;
        public long last_modified_time;
        public String livecover_src;
        public String livecover_src_bsize;
        public int post_num;
        public int reply_num;
        public ArrayList<Integer> showExpressionViewIndex;
        public int showStyle;
        public long thread_id;
        public String title;
        public UserInfo userInfo;
        public Zan zan;

        public ZhiBoInfoTW() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.post_num = 0;
            this.title = "";
            this.forum_id = 0L;
            this.livecover_src_bsize = "";
            this.last_modified_time = 0L;
            this.forum_name = "";
            this.thread_id = 0L;
            this.content = "";
            this.livecover_src = "";
            this.reply_num = 0;
            this.zan = new Zan();
            this.userInfo = new UserInfo();
            this.labelList = new LabelInfo[0];
            this.showStyle = -1;
            this.isHeadLive = false;
            this.showExpressionViewIndex = new ArrayList<>();
        }

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, zhiBoInfoTW, i2) == null) || zhiBoInfoTW == null) {
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
            this.showStyle = i2;
            this.zan.parseProtobuf(zhiBoInfoTW.zan);
            this.isHeadLive = zhiBoInfoTW.is_headline.intValue() == 1;
            this.userInfo.parseProtobuf(zhiBoInfoTW.user);
            List<tbclient.LabelInfo> list = zhiBoInfoTW.labelInfo;
            if (list != null) {
                int size = list.size();
                this.labelList = new LabelInfo[size];
                for (int i3 = 0; i3 < size; i3++) {
                    if (zhiBoInfoTW.labelInfo.get(i3) != null) {
                        LabelInfo labelInfo = new LabelInfo();
                        labelInfo.labelHot = zhiBoInfoTW.labelInfo.get(i3).labelHot.intValue();
                        labelInfo.LabelId = zhiBoInfoTW.labelInfo.get(i3).labelId;
                        labelInfo.labelName = zhiBoInfoTW.labelInfo.get(i3).labelContent;
                        this.labelList[i3] = labelInfo;
                    }
                }
            }
            CardPersonDynamicThreadData.j(this.labelList, this.showExpressionViewIndex);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1468382207, "Lcom/baidu/tieba/card/data/CardPersonDynamicThreadData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1468382207, "Lcom/baidu/tieba/card/data/CardPersonDynamicThreadData;");
                return;
            }
        }
        K = BdUniqueId.gen();
    }

    public CardPersonDynamicThreadData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.s = 0;
        this.w = new Abs[0];
        this.z = new MediaData[0];
        this.B = new VoiceData$VoiceModel[0];
        this.C = new ZhiBoInfoTW();
        this.D = new MultipleForum[0];
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
    }

    public static int c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
            for (int i5 = 0; i5 < i2 && i5 < 3; i5++) {
                if (i5 != i3 && i5 != i4) {
                    return i5;
                }
            }
            return -1;
        }
        return invokeIII.intValue;
    }

    public static int d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            int nextInt = new Random().nextInt(i2);
            return nextInt == i3 ? (nextInt + 1) % i2 : nextInt;
        }
        return invokeII.intValue;
    }

    public static void j(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, labelInfoArr, arrayList) == null) || labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length && i4 < 3; i4++) {
            if (labelInfoArr[i4] != null) {
                int d2 = d(3, -1);
                if (d2 == i2 || d2 == i3) {
                    d2 = c(length, i2, i3);
                }
                if (i4 == 0) {
                    i2 = d2;
                }
                if (i4 == 1) {
                    i3 = d2;
                }
                arrayList.add(Integer.valueOf(d2));
            }
        }
    }

    public void e(User user, PostInfoList postInfoList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, user, postInfoList, i2) == null) || postInfoList == null) {
            return;
        }
        this.f14588e = String.valueOf(postInfoList.forum_id);
        this.f14589f = String.valueOf(postInfoList.thread_id);
        String valueOf = String.valueOf(postInfoList.post_id);
        this.f14590g = valueOf;
        this.f14591h = valueOf;
        this.f14592i = postInfoList.create_time.intValue();
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
            for (int i3 = 0; i3 < this.w.length; i3++) {
                Abs abs = new Abs();
                abs.parseProtobuf(postInfoList.abstract_thread.get(i3));
                this.w[i3] = abs;
                if (postInfoList.abstract_thread.get(i3).type.intValue() == 0) {
                    sb.append(postInfoList.abstract_thread.get(i3).text);
                }
            }
        }
        this.l = sb.toString();
        this.n = postInfoList.reply_num.intValue();
        this.o = postInfoList.freq_num.intValue();
        List<tbclient.Media> list2 = postInfoList.media;
        if (list2 != null) {
            this.z = new MediaData[list2.size()];
            for (int i4 = 0; i4 < this.z.length; i4++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(postInfoList.media.get(i4));
                this.z[i4] = mediaData;
            }
        }
        List<Voice> list3 = postInfoList.voice_info;
        if (list3 != null) {
            this.B = new VoiceData$VoiceModel[list3.size()];
            for (int i5 = 0; i5 < this.B.length; i5++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(postInfoList.voice_info.get(i5));
                this.B[i5] = voiceData$VoiceModel;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.C.parseProtobuf(zhiBoInfoTW, i2);
        }
        VideoInfo videoInfo = postInfoList.video_info;
        if (videoInfo != null) {
            this.A = videoInfo;
        }
        List<tbclient.MultipleForum> list4 = postInfoList.multiple_forum_list;
        if (list4 != null && list4.size() > 0) {
            this.D = new MultipleForum[postInfoList.multiple_forum_list.size()];
            for (int i6 = 0; i6 < this.D.length; i6++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i6));
                this.D[i6] = multipleForum;
            }
        } else if (!TextUtils.isEmpty(this.j) && b.f(this.f14588e, -1L) != -1) {
            this.D = new MultipleForum[1];
            MultipleForum multipleForum2 = new MultipleForum();
            multipleForum2.forum_id = b.f(this.f14588e, 0L);
            multipleForum2.forum_name = this.j;
            this.D[0] = multipleForum2;
        }
        this.r = new b2();
        if (postInfoList.ala_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            alaInfoData.parserProtobuf(postInfoList.ala_info);
            this.r.e4(alaInfoData);
            this.r.i4(this.k);
            this.o = postInfoList.view_num.intValue();
        }
        Agree agree = postInfoList.agree;
        if (agree != null) {
            this.r.g3(agree.agree_type.intValue());
            this.r.w3(postInfoList.agree.has_agree.intValue());
            long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
            long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
            this.r.f3(longValue);
            this.r.m3(longValue2);
            if (this.r.b0() == 1 && longValue == 0 && longValue2 == 0) {
                this.r.e3(1);
            }
            AgreeData z = this.r.z();
            if (z != null) {
                z.threadId = this.f14589f;
                z.parseProtobuf(postInfoList.agree);
            }
        }
        if (postInfoList.is_share_thread.intValue() == 1) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.j(postInfoList.origin_thread_info);
            b2 b2Var = this.r;
            b2Var.u1 = originalThreadInfo;
            b2Var.v1 = true;
        }
        this.r.Z3(postInfoList.share_num.intValue());
        this.r.y3(this.f14589f);
        this.r.h4(this.f14589f);
        this.r.o3(postInfoList.forum_id.longValue());
        this.r.s3(this.j);
        this.r.U3(this.n);
        this.r.n4(this.o);
        this.r.K3(this.f14592i);
        this.r.i4(this.k);
        this.r.X3(this.x);
        this.r.W3(this.y);
        this.r.c3(this.l);
        this.r.g4((int) this.m);
        this.r.q3(postInfoList.first_post_content);
        if (this.z != null) {
            this.r.P3(new ArrayList<>(Arrays.asList(this.z)));
        }
        if (this.B != null) {
            this.r.o4(new ArrayList<>(Arrays.asList(this.B)));
        }
        this.r.s4(postInfoList.is_ntitle.intValue());
        b2 b2Var2 = this.r;
        b2Var2.a2 = true;
        if (b2Var2.H() != null && user != null) {
            this.r.H().parserProtobuf(user);
            this.r.Q2();
        }
        this.r.i3(postInfoList.article_cover);
        this.r.m4(this.A);
        if (this.r.r2()) {
            this.r.A3(1);
        }
        b2 b2Var3 = this.r;
        b2Var3.f2 = this.q;
        b2Var3.g2 = this.f14591h;
        Item item = postInfoList.item;
        if (item != null) {
            b2Var3.H3(item);
            ItemData itemData = new ItemData();
            itemData.parseProto(postInfoList.item);
            this.r.v2 = itemData;
        }
        List<HeadItem> list5 = postInfoList.item_star;
        if (list5 != null) {
            this.r.J3(list5);
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(postInfoList.item_star);
            this.r.x2 = itemStarData;
        }
        if (postInfoList.poll_info != null) {
            PollData pollData = new PollData();
            pollData.parserProtobuf(postInfoList.poll_info);
            this.r.R3(pollData);
        }
        List<PbLinkInfo> list6 = postInfoList.pb_link_info;
        if (list6 != null && !ListUtils.isEmpty(list6)) {
            ArrayList arrayList = new ArrayList();
            for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                PbLinkData pbLinkData = new PbLinkData();
                pbLinkData.parseProto(pbLinkInfo);
                arrayList.add(pbLinkData);
            }
            this.r.L3(arrayList);
        }
        List<PbGoodsInfo> list7 = postInfoList.pb_goods_info;
        if (list7 != null && !ListUtils.isEmpty(list7)) {
            ArrayList arrayList2 = new ArrayList();
            for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                PbGoodsData pbGoodsData = new PbGoodsData();
                pbGoodsData.parseProto(pbGoodsInfo);
                arrayList2.add(pbGoodsData);
            }
            this.r.q4(arrayList2);
        }
        int intValue2 = postInfoList.is_author_view.intValue();
        this.J = intValue2;
        this.r.H2 = intValue2;
        List<PbLinkInfo> list8 = postInfoList.pb_link_info;
        if (list8 != null && !ListUtils.isEmpty(list8)) {
            ArrayList arrayList3 = new ArrayList();
            for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                PbLinkData pbLinkData2 = new PbLinkData();
                pbLinkData2.parseProto(pbLinkInfo2);
                arrayList3.add(pbLinkData2);
            }
            this.r.L3(arrayList3);
        }
        this.r.W2();
    }

    @Override // d.a.p0.s.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (w0) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? K : (BdUniqueId) invokeV.objValue;
    }

    public void h(User user, ThreadInfo threadInfo, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{user, threadInfo, Integer.valueOf(i2), Long.valueOf(j)}) == null) || threadInfo == null) {
            return;
        }
        this.f14588e = String.valueOf(threadInfo.fid);
        this.f14589f = String.valueOf(threadInfo.tid);
        String valueOf = String.valueOf(threadInfo.post_id);
        this.f14590g = valueOf;
        this.f14591h = valueOf;
        this.f14592i = threadInfo.create_time.intValue();
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
            for (int i3 = 0; i3 < this.w.length; i3++) {
                Abs abs = new Abs();
                abs.parseProtobuf(threadInfo._abstract.get(i3));
                this.w[i3] = abs;
                if (threadInfo._abstract.get(i3).type.intValue() == 0) {
                    sb.append(threadInfo._abstract.get(i3).text);
                }
            }
        }
        this.l = sb.toString();
        this.n = threadInfo.reply_num.intValue();
        this.o = threadInfo.view_num.intValue();
        List<tbclient.Media> list = threadInfo.media;
        if (list != null) {
            this.z = new MediaData[list.size()];
            for (int i4 = 0; i4 < this.z.length; i4++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(threadInfo.media.get(i4));
                this.z[i4] = mediaData;
            }
        }
        List<Voice> list2 = threadInfo.voice_info;
        if (list2 != null) {
            this.B = new VoiceData$VoiceModel[list2.size()];
            for (int i5 = 0; i5 < this.B.length; i5++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(threadInfo.voice_info.get(i5));
                this.B[i5] = voiceData$VoiceModel;
            }
        }
        List<tbclient.MultipleForum> list3 = threadInfo.multiple_forum_list;
        if (list3 != null) {
            this.D = new MultipleForum[list3.size()];
            for (int i6 = 0; i6 < this.D.length; i6++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i6));
                this.D[i6] = multipleForum;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.C.parseProtobuf(zhiBoInfoTW, i2);
        }
        b2 b2Var = new b2();
        this.r = b2Var;
        b2Var.K2(threadInfo);
        this.r.y3(this.f14589f);
        this.r.h4(this.f14589f);
        this.r.o3(threadInfo.fid.longValue());
        this.r.U3(this.n);
        this.r.n4(this.o);
        this.r.K3(this.f14592i);
        Agree agree = threadInfo.agree;
        if (agree != null) {
            this.r.g3(agree.agree_type.intValue());
            this.r.w3(threadInfo.agree.has_agree.intValue());
            long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
            long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
            this.r.f3(longValue);
            this.r.m3(longValue2);
            if (this.r.b0() == 1 && longValue == 0 && longValue2 == 0) {
                this.r.e3(1);
            }
        }
        this.r.s4(threadInfo.is_ntitle.intValue());
        b2 b2Var2 = this.r;
        b2Var2.a2 = true;
        if (b2Var2.H() != null && user != null) {
            this.r.H().parserProtobuf(user);
            this.r.Q2();
        }
        this.r.i3(threadInfo.article_cover);
        this.r.m4(this.A);
        if (this.r.r2()) {
            this.r.A3(1);
        }
        this.r.W2();
    }
}
