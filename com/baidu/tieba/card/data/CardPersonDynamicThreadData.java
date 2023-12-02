package com.baidu.tieba.card.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.fw4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class CardPersonDynamicThreadData extends fw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId I;
    public transient /* synthetic */ FieldHolder $fh;
    public ZhiBoInfoTW A;
    public MultipleForum[] B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public String G;
    public int H;
    public String a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public long k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public ThreadData p;
    public int q;
    public String r;
    public String s;
    public String t;
    public Abs[] u;
    public List<PbContent> v;
    public List<PbContent> w;
    public MediaData[] x;
    public VideoInfo y;
    public VoiceData.VoiceModel[] z;

    public static int c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) {
            for (int i4 = 0; i4 < i && i4 < 3; i4++) {
                if (i4 != i2 && i4 != i3) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeIII.intValue;
    }

    @Override // com.baidu.tieba.fw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, r5) != null) || r5 == null) {
                return;
            }
            this.type = r5.type.intValue();
            this.text = r5.text;
            this.src = r5.src;
            this.un = r5.un;
            this.link = r5.link;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, anchorInfo) != null) || anchorInfo == null) {
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

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, labelInfo) != null) || labelInfo == null) {
                return;
            }
            this.labelHot = labelInfo.labelHot.intValue();
            this.labelName = labelInfo.labelContent;
            this.LabelId = labelInfo.labelId;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, lbsInfo) != null) || lbsInfo == null) {
                return;
            }
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, media) != null) || media == null) {
                return;
            }
            this.type = media.type.intValue();
            this.small_pic = media.small_pic;
            this.big_pic = media.big_pic;
            this.water_pic = media.water_pic;
            this.dynamic_pic = media.dynamic_pic;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, multipleForum) != null) || multipleForum == null) {
                return;
            }
            this.forum_id = multipleForum.forum_id.longValue();
            this.forum_name = multipleForum.forum_name;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, postInfoContent) != null) || postInfoContent == null) {
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

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, quote) != null) || quote == null) {
                return;
            }
            this.post_id = quote.post_id.longValue();
            this.user_id = quote.user_id.longValue();
            this.user_name = quote.user_name;
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, user) != null) || user == null) {
                return;
            }
            this.portrait = user.portrait;
            this.name_show = user.name_show;
            this.id = user.id.longValue();
        }
    }

    /* loaded from: classes5.dex */
    public static class Zan extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int num;

        public Zan() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.num = 0;
        }

        public void parseProtobuf(tbclient.Zan zan) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zan) != null) || zan == null) {
                return;
            }
            this.num = zan.num.intValue();
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public void parseProtobuf(tbclient.ZhiBoInfoTW zhiBoInfoTW, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, zhiBoInfoTW, i) != null) || zhiBoInfoTW == null) {
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
            boolean z = true;
            if (zhiBoInfoTW.is_headline.intValue() != 1) {
                z = false;
            }
            this.isHeadLive = z;
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
            CardPersonDynamicThreadData.g(this.labelList, this.showExpressionViewIndex);
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
        I = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.fw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public CardPersonDynamicThreadData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.q = 0;
        this.u = new Abs[0];
        this.x = new MediaData[0];
        this.z = new VoiceData.VoiceModel[0];
        this.A = new ZhiBoInfoTW();
        this.B = new MultipleForum[0];
        this.C = true;
        this.D = true;
        this.E = false;
        this.F = true;
    }

    public static int d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            int nextInt = new Random().nextInt(i);
            if (nextInt == i2) {
                return (nextInt + 1) % i;
            }
            return nextInt;
        }
        return invokeII.intValue;
    }

    public static void g(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, labelInfoArr, arrayList) != null) || labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < length && i3 < 3; i3++) {
            if (labelInfoArr[i3] != null) {
                int d = d(3, -1);
                if (d == i || d == i2) {
                    d = c(length, i, i2);
                }
                if (i3 == 0) {
                    i = d;
                }
                if (i3 == 1) {
                    i2 = d;
                }
                arrayList.add(Integer.valueOf(d));
            }
        }
    }

    public void e(User user, @Nullable MetaData metaData, PostInfoList postInfoList, int i) {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(1048576, this, user, metaData, postInfoList, i) != null) || postInfoList == null) {
            return;
        }
        this.a = String.valueOf(postInfoList.forum_id);
        this.b = String.valueOf(postInfoList.thread_id);
        this.c = postInfoList.is_manager.intValue();
        this.d = postInfoList.is_origin_manager.intValue();
        String valueOf = String.valueOf(postInfoList.post_id);
        this.e = valueOf;
        this.f = valueOf;
        this.g = postInfoList.create_time.intValue();
        long intValue = postInfoList.create_time.intValue() * 1000;
        this.r = StringHelper.getChineseYearBytime(intValue);
        this.s = StringHelper.getChineseMonthBytime(intValue);
        this.t = StringHelper.getDateBytime(intValue);
        this.h = postInfoList.forum_name;
        this.i = postInfoList.title;
        this.v = postInfoList.rich_title;
        this.w = postInfoList.rich_abstract;
        String str = postInfoList.user_name;
        postInfoList.user_id.longValue();
        String str2 = postInfoList.user_portrait;
        this.k = postInfoList.thread_type.longValue();
        this.n = postInfoList.is_post_deleted.intValue();
        if (postInfoList.is_remain.intValue() == 0) {
            this.o = false;
        } else if (postInfoList.is_remain.intValue() == 1) {
            this.o = true;
        }
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = postInfoList.abstract_thread;
        if (list != null) {
            this.u = new Abs[list.size()];
            for (int i2 = 0; i2 < this.u.length; i2++) {
                Abs abs = new Abs();
                abs.parseProtobuf(postInfoList.abstract_thread.get(i2));
                this.u[i2] = abs;
                if (postInfoList.abstract_thread.get(i2).type.intValue() == 0) {
                    sb.append(postInfoList.abstract_thread.get(i2).text);
                }
            }
        }
        this.j = sb.toString();
        this.l = postInfoList.reply_num.intValue();
        this.m = postInfoList.freq_num.intValue();
        List<tbclient.Media> list2 = postInfoList.media;
        if (list2 != null) {
            this.x = new MediaData[list2.size()];
            for (int i3 = 0; i3 < this.x.length; i3++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(postInfoList.media.get(i3));
                this.x[i3] = mediaData;
            }
        }
        List<Voice> list3 = postInfoList.voice_info;
        if (list3 != null) {
            this.z = new VoiceData.VoiceModel[list3.size()];
            for (int i4 = 0; i4 < this.z.length; i4++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(postInfoList.voice_info.get(i4));
                this.z[i4] = voiceModel;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.A.parseProtobuf(zhiBoInfoTW, i);
        }
        VideoInfo videoInfo = postInfoList.video_info;
        if (videoInfo != null) {
            this.y = videoInfo;
        }
        List<tbclient.MultipleForum> list4 = postInfoList.multiple_forum_list;
        if (list4 != null && list4.size() > 0) {
            this.B = new MultipleForum[postInfoList.multiple_forum_list.size()];
            for (int i5 = 0; i5 < this.B.length; i5++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i5));
                this.B[i5] = multipleForum;
            }
        } else if (!TextUtils.isEmpty(this.h) && JavaTypesHelper.toLong(this.a, -1L) != -1) {
            this.B = new MultipleForum[1];
            MultipleForum multipleForum2 = new MultipleForum();
            multipleForum2.forum_id = JavaTypesHelper.toLong(this.a, 0L);
            multipleForum2.forum_name = this.h;
            this.B[0] = multipleForum2;
        }
        this.p = new ThreadData();
        if (postInfoList.ala_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            alaInfoData.parserProtobuf(postInfoList.ala_info);
            this.p.setThreadAlaInfo(alaInfoData);
            this.p.setTitle(this.i);
            this.m = postInfoList.view_num.intValue();
        }
        Agree agree = postInfoList.agree;
        if (agree != null) {
            this.p.setAgreeType(agree.agree_type.intValue());
            this.p.setHasAgree(postInfoList.agree.has_agree.intValue());
            if (postInfoList.agree.agree_num.longValue() > 0) {
                j = postInfoList.agree.agree_num.longValue();
            } else {
                j = 0;
            }
            if (postInfoList.agree.disagree_num.longValue() > 0) {
                j2 = postInfoList.agree.disagree_num.longValue();
            } else {
                j2 = 0;
            }
            this.p.setAgreeNum(j);
            this.p.setDisAgreeNum(j2);
            if (this.p.getHasAgree() == 1 && j == 0 && j2 == 0) {
                this.p.setAgreeNum(1);
            }
            AgreeData agreeData = this.p.getAgreeData();
            if (agreeData != null) {
                agreeData.threadId = this.b;
                agreeData.parseProtobuf(postInfoList.agree);
            }
        }
        if (postInfoList.is_share_thread.intValue() == 1) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.p(postInfoList.origin_thread_info, this.p);
            ThreadData threadData = this.p;
            threadData.originalThreadData = originalThreadInfo;
            threadData.isShareThread = true;
        }
        this.p.setShareNum(postInfoList.share_num.intValue());
        this.p.setId(this.b);
        this.p.setIsManager(this.c);
        this.p.setIsOriginManager(this.d);
        this.p.setTid(this.b);
        this.p.setFid(postInfoList.forum_id.longValue());
        this.p.setForum_name(this.h);
        this.p.setReply_num(this.l);
        this.p.setView_num(this.m);
        this.p.setLast_time_int(this.g);
        this.p.setTitle(this.i);
        this.p.setRichTitleList(this.v);
        this.p.setRichAbstractList(this.w);
        this.p.setAbstract(this.j);
        this.p.setThreadType((int) this.k);
        this.p.setFirstFloorList(postInfoList.first_post_content);
        if (this.x != null) {
            this.p.setMedias(new ArrayList<>(Arrays.asList(this.x)));
        }
        if (this.z != null) {
            this.p.setVoices(new ArrayList<>(Arrays.asList(this.z)));
        }
        this.p.updateIsNotitle(postInfoList.is_ntitle.intValue());
        ThreadData threadData2 = this.p;
        threadData2.isFromPersonPolymeric = true;
        if (threadData2.getAuthor() != null) {
            if (metaData != null) {
                this.p.setAuthor(metaData);
            } else if (user != null) {
                this.p.getAuthor().parserProtobuf(user);
            }
            this.p.praserTimeConsumingInfo();
        }
        this.p.setArticeCover(postInfoList.article_cover);
        this.p.setVideoInfo(this.y);
        this.p.setUserPostPerm(postInfoList.user_post_perm);
        if (this.p.isUgcThreadType()) {
            this.p.setIsBjh(1);
        }
        ThreadData threadData3 = this.p;
        threadData3.isPrivacy = this.o;
        threadData3.person_center_post_id = this.f;
        Item item = postInfoList.item;
        if (item != null) {
            threadData3.setItem(item);
            ItemData itemData = new ItemData();
            itemData.parseProto(postInfoList.item);
            this.p.itemData = itemData;
        }
        List<HeadItem> list5 = postInfoList.item_star;
        if (list5 != null) {
            this.p.setItemStar(list5);
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(postInfoList.item_star);
            this.p.itemStarData = itemStarData;
        }
        if (postInfoList.poll_info != null) {
            PollData pollData = new PollData();
            pollData.parserProtobuf(postInfoList.poll_info);
            this.p.setPollData(pollData);
        }
        List<PbLinkInfo> list6 = postInfoList.pb_link_info;
        if (list6 != null && !ListUtils.isEmpty(list6)) {
            ArrayList arrayList = new ArrayList();
            for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                PbLinkData pbLinkData = new PbLinkData();
                pbLinkData.parseProto(pbLinkInfo);
                arrayList.add(pbLinkData);
            }
            this.p.setLinkDataList(arrayList);
        }
        List<PbGoodsInfo> list7 = postInfoList.pb_goods_info;
        if (list7 != null && !ListUtils.isEmpty(list7)) {
            ArrayList arrayList2 = new ArrayList();
            for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                PbGoodsData pbGoodsData = new PbGoodsData();
                pbGoodsData.parseProto(pbGoodsInfo);
                arrayList2.add(pbGoodsData);
            }
            this.p.setmGoodsDataList(arrayList2);
        }
        int intValue2 = postInfoList.is_author_view.intValue();
        this.H = intValue2;
        this.p.isAuthorView = intValue2;
        List<PbLinkInfo> list8 = postInfoList.pb_link_info;
        if (list8 != null && !ListUtils.isEmpty(list8)) {
            ArrayList arrayList3 = new ArrayList();
            for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                PbLinkData pbLinkData2 = new PbLinkData();
                pbLinkData2.parseProto(pbLinkInfo2);
                arrayList3.add(pbLinkData2);
            }
            this.p.setLinkDataList(arrayList3);
        }
        this.p.processExtensionInfoForPersonCenter();
    }

    public void f(User user, ThreadInfo threadInfo, int i, long j) {
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{user, threadInfo, Integer.valueOf(i), Long.valueOf(j)}) != null) || threadInfo == null) {
            return;
        }
        this.a = String.valueOf(threadInfo.fid);
        this.b = String.valueOf(threadInfo.tid);
        String valueOf = String.valueOf(threadInfo.post_id);
        this.e = valueOf;
        this.f = valueOf;
        this.g = threadInfo.create_time.intValue();
        long j4 = j * 1000;
        this.r = StringHelper.getChineseYearBytime(j4);
        this.s = StringHelper.getChineseMonthBytime(j4);
        this.t = StringHelper.getDateBytime(j4);
        this.h = threadInfo.fname;
        this.y = threadInfo.video_info;
        this.i = threadInfo.title;
        this.v = threadInfo.rich_title;
        this.w = threadInfo.rich_abstract;
        User user2 = threadInfo.author;
        if (user2 != null) {
            String str = user2.name;
            user2.id.longValue();
            String str2 = threadInfo.author.portrait;
        }
        this.k = threadInfo.thread_type.intValue();
        this.u = new Abs[threadInfo._abstract.size()];
        StringBuilder sb = new StringBuilder();
        if (threadInfo._abstract != null) {
            for (int i2 = 0; i2 < this.u.length; i2++) {
                Abs abs = new Abs();
                abs.parseProtobuf(threadInfo._abstract.get(i2));
                this.u[i2] = abs;
                if (threadInfo._abstract.get(i2).type.intValue() == 0) {
                    sb.append(threadInfo._abstract.get(i2).text);
                }
            }
        }
        this.j = sb.toString();
        this.l = threadInfo.reply_num.intValue();
        this.m = threadInfo.view_num.intValue();
        List<tbclient.Media> list = threadInfo.media;
        if (list != null) {
            this.x = new MediaData[list.size()];
            for (int i3 = 0; i3 < this.x.length; i3++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(threadInfo.media.get(i3));
                this.x[i3] = mediaData;
            }
        }
        List<Voice> list2 = threadInfo.voice_info;
        if (list2 != null) {
            this.z = new VoiceData.VoiceModel[list2.size()];
            for (int i4 = 0; i4 < this.z.length; i4++) {
                VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                voiceModel.parserProtobuf(threadInfo.voice_info.get(i4));
                this.z[i4] = voiceModel;
            }
        }
        List<tbclient.MultipleForum> list3 = threadInfo.multiple_forum_list;
        if (list3 != null) {
            this.B = new MultipleForum[list3.size()];
            for (int i5 = 0; i5 < this.B.length; i5++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i5));
                this.B[i5] = multipleForum;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.A.parseProtobuf(zhiBoInfoTW, i);
        }
        ThreadData threadData = new ThreadData();
        this.p = threadData;
        threadData.parserProtobuf(threadInfo);
        this.p.setId(this.b);
        this.p.setTid(this.b);
        this.p.setFid(threadInfo.fid.longValue());
        this.p.setReply_num(this.l);
        this.p.setView_num(this.m);
        this.p.setLast_time_int(this.g);
        Agree agree = threadInfo.agree;
        if (agree != null) {
            this.p.setAgreeType(agree.agree_type.intValue());
            this.p.setHasAgree(threadInfo.agree.has_agree.intValue());
            if (threadInfo.agree.agree_num.longValue() > 0) {
                j2 = threadInfo.agree.agree_num.longValue();
            } else {
                j2 = 0;
            }
            if (threadInfo.agree.disagree_num.longValue() > 0) {
                j3 = threadInfo.agree.disagree_num.longValue();
            } else {
                j3 = 0;
            }
            this.p.setAgreeNum(j2);
            this.p.setDisAgreeNum(j3);
            if (this.p.getHasAgree() == 1 && j2 == 0 && j3 == 0) {
                this.p.setAgreeNum(1);
            }
        }
        this.p.updateIsNotitle(threadInfo.is_ntitle.intValue());
        ThreadData threadData2 = this.p;
        threadData2.isFromPersonPolymeric = true;
        if (threadData2.getAuthor() != null && user != null) {
            this.p.getAuthor().parserProtobuf(user);
            this.p.praserTimeConsumingInfo();
        }
        this.p.setArticeCover(threadInfo.article_cover);
        this.p.setVideoInfo(this.y);
        if (this.p.isUgcThreadType()) {
            this.p.setIsBjh(1);
        }
        this.p.processExtensionInfoForPersonCenter();
    }
}
