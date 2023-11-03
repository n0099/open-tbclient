package com.baidu.tieba.compact;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tieba.d57;
import com.baidu.tieba.fz4;
import com.baidu.tieba.hw4;
import com.baidu.tieba.k77;
import com.baidu.tieba.s47;
import com.baidu.tieba.t27;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.wx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VideoInfo;
import tbclient.VoiceRoom;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/compact/SocialBarImpl;", "Lcom/baidu/tieba/feed/compat/Resolver$ISocialBar;", "()V", "create", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getIsPraised", "", "state", "Lcom/baidu/tieba/feed/component/uistate/SocialUiState;", "getShareThreadShowType", "", "threadType", "", "onSkinChange", "", "view", StickerDataChangeType.UPDATE, "agreeView", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialBarImpl implements t27.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SocialBarImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.t27.s
    public void b(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof SocialBarWrapper) {
                ((SocialBarWrapper) view2).onChangeSkinType();
            }
        }
    }

    public final int n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (Intrinsics.areEqual(str, PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK)) {
                return 3;
            }
            if (Intrinsics.areEqual(str, PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK)) {
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.t27.o
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof TbadkCoreApplication) {
                TbadkCoreApplication tbadkCoreApplication = (TbadkCoreApplication) context;
                if ((tbadkCoreApplication.getCurrentActivity() instanceof Context) && (context = tbadkCoreApplication.getCurrentActivity()) == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
                }
            }
            SocialBarWrapper socialBarWrapper = new SocialBarWrapper(context);
            socialBarWrapper.setNeedMatchStrategy(true);
            socialBarWrapper.setUseDynamicLikeRes();
            socialBarWrapper.setJumpToVideoFromOuter(true);
            return socialBarWrapper;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final boolean m(s47 s47Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, s47Var)) == null) {
            if (!(s47Var.m().k instanceof ThreadData)) {
                return false;
            }
            Object obj = s47Var.m().k;
            if (obj != null) {
                AgreeData agreeData = ((ThreadData) obj).getAgreeData();
                if (agreeData == null) {
                    return false;
                }
                return agreeData.hasAgree;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.ThreadData");
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0271, code lost:
        if (r12 == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02d8, code lost:
        if (r12 == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
        if (r14 == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0183, code lost:
        if (r16 == false) goto L136;
     */
    @Override // com.baidu.tieba.t27.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(ViewGroup agreeView, final s47 state) {
        Map<String, String> linkedHashMap;
        ThreadData threadData;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, agreeView, state) == null) {
            Intrinsics.checkNotNullParameter(agreeView, "agreeView");
            Intrinsics.checkNotNullParameter(state, "state");
            k77 m = state.m();
            final SocialBarWrapper socialBarWrapper = (SocialBarWrapper) agreeView;
            d57 d57Var = state.m().l;
            if (d57Var == null || (linkedHashMap = d57Var.a()) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            Object obj = state.m().k;
            if (obj instanceof ThreadData) {
                threadData = (ThreadData) obj;
            } else {
                threadData = null;
            }
            if (threadData == null) {
                threadData = new ThreadData();
                threadData.setId(m.c);
                threadData.setFid(m.d);
                threadData.setTid(m.c);
                int i = JavaTypesHelper.toInt(linkedHashMap.get("thread_type"), 0);
                threadData.setThreadType(i);
                if (i == 40) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.video_url = "video_url";
                    threadData.setVideoInfo(builder.build(true));
                }
                threadData.setIs_good(JavaTypesHelper.toInt(linkedHashMap.get(IMUserExtraData.KEY_IS_GOD), 0));
                if (JavaTypesHelper.toInt(linkedHashMap.get(VideoPlayActivityConfig.IS_SHARE_THREAD), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                threadData.isShareThread = z;
                if (JavaTypesHelper.toInt(linkedHashMap.get("has_item"), 0) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                threadData.hasItem = z2;
                threadData.setTitle(linkedHashMap.get("title"));
                threadData.setAbstract(linkedHashMap.get("abstract"));
                MediaData mediaData = new MediaData();
                mediaData.small_pic_url = linkedHashMap.get("thread_show_pic");
                String str = linkedHashMap.get("media_pic_url");
                String str2 = linkedHashMap.get("media_thumbnails_url");
                if (str != null && str.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    if (str2 != null && str2.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                }
                mediaData.setType(3);
                mediaData.setThumbnails_url(str2);
                mediaData.setPic(str);
                mediaData.small_pic_url = str2;
                mediaData.origin_pic = str;
                mediaData.setOriginalUrl(str);
                mediaData.setSrc_pic(str);
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(mediaData);
                threadData.setMedias(arrayList);
                String str3 = linkedHashMap.get("yy_uid");
                String str4 = linkedHashMap.get("yy_name");
                String str5 = linkedHashMap.get("yy_sid");
                String str6 = linkedHashMap.get("yy_ssid");
                String str7 = linkedHashMap.get("yy_cover");
                if (str3 != null && str3.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    if (str4 != null && str4.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        if (str5 != null && str5.length() != 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z17) {
                            if (str6 != null && str6.length() != 0) {
                                z18 = false;
                            } else {
                                z18 = true;
                            }
                        }
                    }
                }
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.cover = str7;
                AlaUserInfoData alaUserInfoData = new AlaUserInfoData();
                alaUserInfoData.user_name = str4;
                Unit unit = Unit.INSTANCE;
                alaInfoData.user_info = alaUserInfoData;
                YyExtData yyExtData = new YyExtData();
                yyExtData.mYyUid = str3;
                yyExtData.mSid = str5;
                yyExtData.mSsid = str6;
                Unit unit2 = Unit.INSTANCE;
                alaInfoData.mYyExtData = yyExtData;
                threadData.setThreadAlaInfo(alaInfoData);
                String str8 = linkedHashMap.get("voice_room_id");
                if (str8 != null && str8.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    VoiceRoom.Builder builder2 = new VoiceRoom.Builder();
                    builder2.room_id = Long.valueOf(JavaTypesHelper.toLong(str8, 0L));
                    Unit unit3 = Unit.INSTANCE;
                    threadData.setVoiceRoomData(builder2.build(true));
                }
                String str9 = linkedHashMap.get("video_play_count");
                if (str9 != null && str9.length() != 0) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (!z6) {
                    VideoInfo.Builder builder3 = new VideoInfo.Builder();
                    builder3.play_count = Integer.valueOf(JavaTypesHelper.toInt(str9, 0));
                    builder3.video_url = "video_url";
                    Unit unit4 = Unit.INSTANCE;
                    threadData.setVideoInfo(builder3.build(true));
                }
                String str10 = linkedHashMap.get("is_works");
                if (str10 != null && str10.length() != 0) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (!z7) {
                    WorksInfoData worksInfoData = new WorksInfoData();
                    if (JavaTypesHelper.toInt(str10, 0) == 1) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    worksInfoData.isWorks = z15;
                    threadData.worksInfoData = worksInfoData;
                }
                String str11 = linkedHashMap.get("link_title");
                String str12 = linkedHashMap.get("link_abstract");
                String str13 = linkedHashMap.get("link_head_small_pic");
                if (str11 != null && str11.length() != 0) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z8) {
                    if (str12 != null && str12.length() != 0) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (z13) {
                        if (str13 != null && str13.length() != 0) {
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                    }
                }
                wx4 wx4Var = new wx4();
                wx4Var.k(str11);
                wx4Var.i(str12);
                wx4Var.j(str13);
                threadData.setLinkThreadData(wx4Var);
                if (JavaTypesHelper.toInt(linkedHashMap.get("is_link_thread"), 0) == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                threadData.setLinkThread(z9);
                String str14 = linkedHashMap.get("task_start_time");
                String str15 = linkedHashMap.get("task_end_time");
                String str16 = linkedHashMap.get("task_thread_img");
                if (str14 != null && str14.length() != 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    if (str15 != null && str15.length() != 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        if (str16 != null && str16.length() != 0) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                    }
                }
                fz4 fz4Var = new fz4();
                fz4Var.v(JavaTypesHelper.toLong(str14, 0L));
                fz4Var.u(JavaTypesHelper.toLong(str15, 0L));
                fz4Var.w(str16);
                threadData.setTaskInfoData(fz4Var);
                threadData.setForum_name(linkedHashMap.get("forum_name"));
                threadData.setForumAvatar(linkedHashMap.get("forum_avatar"));
                threadData.setIslive(JavaTypesHelper.toInt(linkedHashMap.get("is_livepost"), 0));
                threadData.setView_num(JavaTypesHelper.toInt(linkedHashMap.get("view_num"), 0));
                if (threadData.isShareThread) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    originalThreadInfo.f = linkedHashMap.get("origin_thread_id");
                    String str17 = linkedHashMap.get("origin_thread_type");
                    if (str17 == null) {
                        str17 = "";
                    }
                    originalThreadInfo.a = n(str17);
                    originalThreadInfo.b = linkedHashMap.get("origin_thread_show_text");
                    originalThreadInfo.c = linkedHashMap.get("origin_thread_show_pic");
                    threadData.originalThreadData = originalThreadInfo;
                }
                threadData.isTiebaPlusAdThread = Intrinsics.areEqual(linkedHashMap.get("is_tie_plus_ad_thread"), "1");
                threadData.tiebaPlusOrderId = linkedHashMap.get("tie_plus_order_id");
                threadData.tiebaPlusToken = linkedHashMap.get("tie_plus_token");
                threadData.tiebaPlusExtraParam = linkedHashMap.get("tie_plus_extra_param");
                threadData.statFloor = state.k() + 1;
                state.m().k = threadData;
                AgreeData agreeData = threadData.getAgreeData();
                agreeData.agreeType = m.e;
                agreeData.hasAgree = m.f;
                agreeData.diffAgreeNum = m.h;
                agreeData.disAgreeNum = m.i;
                agreeData.postId = linkedHashMap.get("first_post_id");
                threadData.setAgreeNum(m.g);
                agreeData.threadId = m.c;
                threadData.setShareNum(m.a);
                threadData.setReply_num((int) m.b);
            }
            socialBarWrapper.setNeedAddReplyIcon(true);
            String str18 = linkedHashMap.get("feed_social_source");
            if (str18 != null) {
                switch (str18.hashCode()) {
                    case 48:
                        if (str18.equals("0")) {
                            socialBarWrapper.setFrom(9);
                            socialBarWrapper.setShareReportFrom(4);
                            hw4 hw4Var = new hw4();
                            hw4Var.b = 9;
                            socialBarWrapper.setAgreeStatisticData(hw4Var);
                            break;
                        }
                        break;
                    case 49:
                        if (str18.equals("1")) {
                            socialBarWrapper.setFrom(1);
                            socialBarWrapper.setShareReportFrom(3);
                            hw4 hw4Var2 = new hw4();
                            hw4Var2.b = 1;
                            socialBarWrapper.setAgreeStatisticData(hw4Var2);
                            break;
                        }
                        break;
                    case 50:
                        if (str18.equals("2")) {
                            socialBarWrapper.setFrom(13);
                            socialBarWrapper.setShareReportFrom(15);
                            hw4 hw4Var3 = new hw4();
                            hw4Var3.b = 2;
                            hw4Var3.j = String.valueOf(m.d);
                            socialBarWrapper.setAgreeStatisticData(hw4Var3);
                            break;
                        }
                        break;
                    case 51:
                        if (str18.equals("3")) {
                            socialBarWrapper.setFrom(2);
                            socialBarWrapper.setShareReportFrom(1);
                            hw4 hw4Var4 = new hw4();
                            hw4Var4.b = 2;
                            hw4Var4.j = String.valueOf(m.d);
                            socialBarWrapper.setAgreeStatisticData(hw4Var4);
                            break;
                        }
                        break;
                    case 52:
                        if (str18.equals("4")) {
                            socialBarWrapper.setFrom(19);
                            socialBarWrapper.setShareReportFrom(14);
                            hw4 hw4Var5 = new hw4();
                            hw4Var5.b = 25;
                            hw4Var5.j = String.valueOf(m.d);
                            socialBarWrapper.setAgreeStatisticData(hw4Var5);
                            break;
                        }
                        break;
                    case 53:
                        if (str18.equals("5")) {
                            socialBarWrapper.setFrom(2);
                            socialBarWrapper.setShareReportFrom(1);
                            hw4 hw4Var6 = new hw4();
                            hw4Var6.b = 10;
                            hw4Var6.j = String.valueOf(m.d);
                            socialBarWrapper.setAgreeStatisticData(hw4Var6);
                            break;
                        }
                        break;
                    case 54:
                        if (str18.equals("6")) {
                            socialBarWrapper.setFrom(2);
                            socialBarWrapper.setShareReportFrom(1);
                            hw4 hw4Var7 = new hw4();
                            hw4Var7.b = 2;
                            hw4Var7.j = String.valueOf(m.d);
                            socialBarWrapper.setAgreeStatisticData(hw4Var7);
                            break;
                        }
                        break;
                }
            }
            socialBarWrapper.setData(threadData);
            int i2 = 43;
            if (m.n) {
                i2 = 107;
            } else if (m.a()) {
                i2 = 47;
            }
            socialBarWrapper.setShowFlag(i2);
            socialBarWrapper.setOnShareClick(new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s47 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.$state.q().invoke(this.$state);
                    }
                }
            });
            socialBarWrapper.setOnCommentClick(new Function0<Unit>(state, socialBarWrapper) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s47 $state;
                public final /* synthetic */ SocialBarWrapper $v;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state, socialBarWrapper};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                    this.$v = socialBarWrapper;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Function2<Context, s47, Unit> n = this.$state.n();
                        Context context = this.$v.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "v.context");
                        n.invoke(context, this.$state);
                    }
                }
            });
            socialBarWrapper.setAfterPraiseClick(new Function0<Unit>(state, this) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s47 $state;
                public final /* synthetic */ SocialBarImpl this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state, this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean m2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Function2<s47, Boolean, Unit> p = this.$state.p();
                        s47 s47Var = this.$state;
                        m2 = this.this$0.m(s47Var);
                        p.invoke(s47Var, Boolean.valueOf(m2));
                    }
                }
            });
            socialBarWrapper.setOnAgreeNumUpdateListener(new Function2<Long, Boolean, Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s47 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
                    invoke(l.longValue(), bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j, boolean z20) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z20)}) == null) && this.$state.m().j.f()) {
                        this.$state.m().j.g(j);
                        this.$state.m().j.h(z20);
                    }
                }
            });
            socialBarWrapper.setOnManageClick(new Function0<Boolean>(state, socialBarWrapper) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s47 $state;
                public final /* synthetic */ SocialBarWrapper $v;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state, socialBarWrapper};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$state = state;
                    this.$v = socialBarWrapper;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Function2<Context, k77, Boolean> o = this.$state.o();
                        Context context = this.$v.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "v.context");
                        return o.invoke(context, this.$state.m());
                    }
                    return (Boolean) invokeV.objValue;
                }
            });
            socialBarWrapper.onChangeSkinType();
        }
    }
}
