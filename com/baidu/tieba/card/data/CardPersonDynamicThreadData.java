package com.baidu.tieba.card.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.q0.s.q.a;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ItemStarData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
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
/* loaded from: classes10.dex */
public class CardPersonDynamicThreadData extends a {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId M;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PbContent> A;
    public MediaData[] B;
    public VideoInfo C;
    public VoiceData$VoiceModel[] D;
    public ZhiBoInfoTW E;
    public MultipleForum[] F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K;
    public int L;

    /* renamed from: e  reason: collision with root package name */
    public String f43286e;

    /* renamed from: f  reason: collision with root package name */
    public String f43287f;

    /* renamed from: g  reason: collision with root package name */
    public int f43288g;

    /* renamed from: h  reason: collision with root package name */
    public int f43289h;

    /* renamed from: i  reason: collision with root package name */
    public String f43290i;

    /* renamed from: j  reason: collision with root package name */
    public String f43291j;

    /* renamed from: k  reason: collision with root package name */
    public int f43292k;
    public String l;
    public String m;
    public String n;
    public long o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public d2 t;
    public int u;
    public String v;
    public String w;
    public String x;
    public Abs[] y;
    public List<PbContent> z;

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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
            CardPersonDynamicThreadData.p(this.labelList, this.showExpressionViewIndex);
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
        M = BdUniqueId.gen();
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
        this.r = 0;
        this.u = 0;
        this.y = new Abs[0];
        this.B = new MediaData[0];
        this.D = new VoiceData$VoiceModel[0];
        this.E = new ZhiBoInfoTW();
        this.F = new MultipleForum[0];
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = true;
    }

    public static int g(int i2, int i3, int i4) {
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

    public static int i(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            int nextInt = new Random().nextInt(i2);
            return nextInt == i3 ? (nextInt + 1) % i2 : nextInt;
        }
        return invokeII.intValue;
    }

    public static void p(LabelInfo[] labelInfoArr, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, labelInfoArr, arrayList) == null) || labelInfoArr == null) {
            return;
        }
        int length = labelInfoArr.length;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < length && i4 < 3; i4++) {
            if (labelInfoArr[i4] != null) {
                int i5 = i(3, -1);
                if (i5 == i2 || i5 == i3) {
                    i5 = g(length, i2, i3);
                }
                if (i4 == 0) {
                    i2 = i5;
                }
                if (i4 == 1) {
                    i3 = i5;
                }
                arrayList.add(Integer.valueOf(i5));
            }
        }
    }

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? M : (BdUniqueId) invokeV.objValue;
    }

    public void k(User user, @Nullable MetaData metaData, PostInfoList postInfoList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, user, metaData, postInfoList, i2) == null) || postInfoList == null) {
            return;
        }
        this.f43286e = String.valueOf(postInfoList.forum_id);
        this.f43287f = String.valueOf(postInfoList.thread_id);
        this.f43288g = postInfoList.is_manager.intValue();
        this.f43289h = postInfoList.is_origin_manager.intValue();
        String valueOf = String.valueOf(postInfoList.post_id);
        this.f43290i = valueOf;
        this.f43291j = valueOf;
        this.f43292k = postInfoList.create_time.intValue();
        long intValue = postInfoList.create_time.intValue() * 1000;
        this.v = StringHelper.getChineseYearBytime(intValue);
        this.w = StringHelper.getChineseMonthBytime(intValue);
        this.x = StringHelper.getDateBytime(intValue);
        this.l = postInfoList.forum_name;
        this.m = postInfoList.title;
        this.z = postInfoList.rich_title;
        this.A = postInfoList.rich_abstract;
        String str = postInfoList.user_name;
        postInfoList.user_id.longValue();
        String str2 = postInfoList.user_portrait;
        this.o = postInfoList.thread_type.longValue();
        this.r = postInfoList.is_post_deleted.intValue();
        if (postInfoList.is_remain.intValue() == 0) {
            this.s = false;
        } else if (postInfoList.is_remain.intValue() == 1) {
            this.s = true;
        }
        StringBuilder sb = new StringBuilder();
        List<Abstract> list = postInfoList.abstract_thread;
        if (list != null) {
            this.y = new Abs[list.size()];
            for (int i3 = 0; i3 < this.y.length; i3++) {
                Abs abs = new Abs();
                abs.parseProtobuf(postInfoList.abstract_thread.get(i3));
                this.y[i3] = abs;
                if (postInfoList.abstract_thread.get(i3).type.intValue() == 0) {
                    sb.append(postInfoList.abstract_thread.get(i3).text);
                }
            }
        }
        this.n = sb.toString();
        this.p = postInfoList.reply_num.intValue();
        this.q = postInfoList.freq_num.intValue();
        List<tbclient.Media> list2 = postInfoList.media;
        if (list2 != null) {
            this.B = new MediaData[list2.size()];
            for (int i4 = 0; i4 < this.B.length; i4++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(postInfoList.media.get(i4));
                this.B[i4] = mediaData;
            }
        }
        List<Voice> list3 = postInfoList.voice_info;
        if (list3 != null) {
            this.D = new VoiceData$VoiceModel[list3.size()];
            for (int i5 = 0; i5 < this.D.length; i5++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(postInfoList.voice_info.get(i5));
                this.D[i5] = voiceData$VoiceModel;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = postInfoList.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.E.parseProtobuf(zhiBoInfoTW, i2);
        }
        VideoInfo videoInfo = postInfoList.video_info;
        if (videoInfo != null) {
            this.C = videoInfo;
        }
        List<tbclient.MultipleForum> list4 = postInfoList.multiple_forum_list;
        if (list4 != null && list4.size() > 0) {
            this.F = new MultipleForum[postInfoList.multiple_forum_list.size()];
            for (int i6 = 0; i6 < this.F.length; i6++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(postInfoList.multiple_forum_list.get(i6));
                this.F[i6] = multipleForum;
            }
        } else if (!TextUtils.isEmpty(this.l) && b.g(this.f43286e, -1L) != -1) {
            this.F = new MultipleForum[1];
            MultipleForum multipleForum2 = new MultipleForum();
            multipleForum2.forum_id = b.g(this.f43286e, 0L);
            multipleForum2.forum_name = this.l;
            this.F[0] = multipleForum2;
        }
        this.t = new d2();
        if (postInfoList.ala_info != null) {
            AlaInfoData alaInfoData = new AlaInfoData();
            alaInfoData.parserProtobuf(postInfoList.ala_info);
            this.t.B4(alaInfoData);
            this.t.F4(this.m);
            this.q = postInfoList.view_num.intValue();
        }
        Agree agree = postInfoList.agree;
        if (agree != null) {
            this.t.y3(agree.agree_type.intValue());
            this.t.Q3(postInfoList.agree.has_agree.intValue());
            long longValue = postInfoList.agree.agree_num.longValue() > 0 ? postInfoList.agree.agree_num.longValue() : 0L;
            long longValue2 = postInfoList.agree.disagree_num.longValue() > 0 ? postInfoList.agree.disagree_num.longValue() : 0L;
            this.t.x3(longValue);
            this.t.E3(longValue2);
            if (this.t.e0() == 1 && longValue == 0 && longValue2 == 0) {
                this.t.w3(1);
            }
            AgreeData B = this.t.B();
            if (B != null) {
                B.threadId = this.f43287f;
                B.parseProtobuf(postInfoList.agree);
            }
        }
        if (postInfoList.is_share_thread.intValue() == 1) {
            OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
            originalThreadInfo.l(postInfoList.origin_thread_info);
            d2 d2Var = this.t;
            d2Var.A1 = originalThreadInfo;
            d2Var.B1 = true;
        }
        this.t.w4(postInfoList.share_num.intValue());
        this.t.S3(this.f43287f);
        this.t.W3(this.f43288g);
        this.t.Y3(this.f43289h);
        this.t.E4(this.f43287f);
        this.t.I3(postInfoList.forum_id.longValue());
        this.t.M3(this.l);
        this.t.r4(this.p);
        this.t.L4(this.q);
        this.t.g4(this.f43292k);
        this.t.F4(this.m);
        this.t.u4(this.z);
        this.t.t4(this.A);
        this.t.t3(this.n);
        this.t.D4((int) this.o);
        this.t.K3(postInfoList.first_post_content);
        if (this.B != null) {
            this.t.m4(new ArrayList<>(Arrays.asList(this.B)));
        }
        if (this.D != null) {
            this.t.M4(new ArrayList<>(Arrays.asList(this.D)));
        }
        this.t.R4(postInfoList.is_ntitle.intValue());
        d2 d2Var2 = this.t;
        d2Var2.f2 = true;
        if (d2Var2.J() != null) {
            if (metaData != null) {
                this.t.B3(metaData);
            } else if (user != null) {
                this.t.J().parserProtobuf(user);
            }
            this.t.i3();
        }
        this.t.A3(postInfoList.article_cover);
        this.t.K4(this.C);
        this.t.J4(postInfoList.user_post_perm);
        if (this.t.G2()) {
            this.t.U3(1);
        }
        d2 d2Var3 = this.t;
        d2Var3.m2 = this.s;
        d2Var3.n2 = this.f43291j;
        Item item = postInfoList.item;
        if (item != null) {
            d2Var3.d4(item);
            ItemData itemData = new ItemData();
            itemData.parseProto(postInfoList.item);
            this.t.C2 = itemData;
        }
        List<HeadItem> list5 = postInfoList.item_star;
        if (list5 != null) {
            this.t.f4(list5);
            ItemStarData itemStarData = new ItemStarData();
            itemStarData.parseProto(postInfoList.item_star);
            this.t.E2 = itemStarData;
        }
        if (postInfoList.poll_info != null) {
            PollData pollData = new PollData();
            pollData.parserProtobuf(postInfoList.poll_info);
            this.t.o4(pollData);
        }
        List<PbLinkInfo> list6 = postInfoList.pb_link_info;
        if (list6 != null && !ListUtils.isEmpty(list6)) {
            ArrayList arrayList = new ArrayList();
            for (PbLinkInfo pbLinkInfo : postInfoList.pb_link_info) {
                PbLinkData pbLinkData = new PbLinkData();
                pbLinkData.parseProto(pbLinkInfo);
                arrayList.add(pbLinkData);
            }
            this.t.h4(arrayList);
        }
        List<PbGoodsInfo> list7 = postInfoList.pb_goods_info;
        if (list7 != null && !ListUtils.isEmpty(list7)) {
            ArrayList arrayList2 = new ArrayList();
            for (PbGoodsInfo pbGoodsInfo : postInfoList.pb_goods_info) {
                PbGoodsData pbGoodsData = new PbGoodsData();
                pbGoodsData.parseProto(pbGoodsInfo);
                arrayList2.add(pbGoodsData);
            }
            this.t.O4(arrayList2);
        }
        int intValue2 = postInfoList.is_author_view.intValue();
        this.L = intValue2;
        this.t.O2 = intValue2;
        List<PbLinkInfo> list8 = postInfoList.pb_link_info;
        if (list8 != null && !ListUtils.isEmpty(list8)) {
            ArrayList arrayList3 = new ArrayList();
            for (PbLinkInfo pbLinkInfo2 : postInfoList.pb_link_info) {
                PbLinkData pbLinkData2 = new PbLinkData();
                pbLinkData2.parseProto(pbLinkInfo2);
                arrayList3.add(pbLinkData2);
            }
            this.t.h4(arrayList3);
        }
        this.t.n3();
    }

    public void o(User user, ThreadInfo threadInfo, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{user, threadInfo, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || threadInfo == null) {
            return;
        }
        this.f43286e = String.valueOf(threadInfo.fid);
        this.f43287f = String.valueOf(threadInfo.tid);
        String valueOf = String.valueOf(threadInfo.post_id);
        this.f43290i = valueOf;
        this.f43291j = valueOf;
        this.f43292k = threadInfo.create_time.intValue();
        long j3 = j2 * 1000;
        this.v = StringHelper.getChineseYearBytime(j3);
        this.w = StringHelper.getChineseMonthBytime(j3);
        this.x = StringHelper.getDateBytime(j3);
        this.l = threadInfo.fname;
        this.C = threadInfo.video_info;
        this.m = threadInfo.title;
        this.z = threadInfo.rich_title;
        this.A = threadInfo.rich_abstract;
        User user2 = threadInfo.author;
        if (user2 != null) {
            String str = user2.name;
            user2.id.longValue();
            String str2 = threadInfo.author.portrait;
        }
        this.o = threadInfo.thread_type.intValue();
        this.y = new Abs[threadInfo._abstract.size()];
        StringBuilder sb = new StringBuilder();
        if (threadInfo._abstract != null) {
            for (int i3 = 0; i3 < this.y.length; i3++) {
                Abs abs = new Abs();
                abs.parseProtobuf(threadInfo._abstract.get(i3));
                this.y[i3] = abs;
                if (threadInfo._abstract.get(i3).type.intValue() == 0) {
                    sb.append(threadInfo._abstract.get(i3).text);
                }
            }
        }
        this.n = sb.toString();
        this.p = threadInfo.reply_num.intValue();
        this.q = threadInfo.view_num.intValue();
        List<tbclient.Media> list = threadInfo.media;
        if (list != null) {
            this.B = new MediaData[list.size()];
            for (int i4 = 0; i4 < this.B.length; i4++) {
                MediaData mediaData = new MediaData();
                mediaData.parserProtobuf(threadInfo.media.get(i4));
                this.B[i4] = mediaData;
            }
        }
        List<Voice> list2 = threadInfo.voice_info;
        if (list2 != null) {
            this.D = new VoiceData$VoiceModel[list2.size()];
            for (int i5 = 0; i5 < this.D.length; i5++) {
                VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
                voiceData$VoiceModel.parserProtobuf(threadInfo.voice_info.get(i5));
                this.D[i5] = voiceData$VoiceModel;
            }
        }
        List<tbclient.MultipleForum> list3 = threadInfo.multiple_forum_list;
        if (list3 != null) {
            this.F = new MultipleForum[list3.size()];
            for (int i6 = 0; i6 < this.F.length; i6++) {
                MultipleForum multipleForum = new MultipleForum();
                multipleForum.parseProtobuf(threadInfo.multiple_forum_list.get(i6));
                this.F[i6] = multipleForum;
            }
        }
        tbclient.ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
        if (zhiBoInfoTW != null) {
            this.E.parseProtobuf(zhiBoInfoTW, i2);
        }
        d2 d2Var = new d2();
        this.t = d2Var;
        d2Var.c3(threadInfo);
        this.t.S3(this.f43287f);
        this.t.E4(this.f43287f);
        this.t.I3(threadInfo.fid.longValue());
        this.t.r4(this.p);
        this.t.L4(this.q);
        this.t.g4(this.f43292k);
        Agree agree = threadInfo.agree;
        if (agree != null) {
            this.t.y3(agree.agree_type.intValue());
            this.t.Q3(threadInfo.agree.has_agree.intValue());
            long longValue = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
            long longValue2 = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
            this.t.x3(longValue);
            this.t.E3(longValue2);
            if (this.t.e0() == 1 && longValue == 0 && longValue2 == 0) {
                this.t.w3(1);
            }
        }
        this.t.R4(threadInfo.is_ntitle.intValue());
        d2 d2Var2 = this.t;
        d2Var2.f2 = true;
        if (d2Var2.J() != null && user != null) {
            this.t.J().parserProtobuf(user);
            this.t.i3();
        }
        this.t.A3(threadInfo.article_cover);
        this.t.K4(this.C);
        if (this.t.G2()) {
            this.t.U3(1);
        }
        this.t.n3();
    }
}
