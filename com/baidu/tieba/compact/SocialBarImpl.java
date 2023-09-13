package com.baidu.tieba.compact;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.c67;
import com.baidu.tieba.f87;
import com.baidu.tieba.h15;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.u97;
import com.baidu.tieba.w97;
import com.baidu.tieba.z77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VideoInfo;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/compact/SocialBarImpl;", "Lcom/baidu/tieba/feed/compat/Resolver$ISocialBar;", "()V", "create", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getShareThreadShowType", "", "threadType", "", "onSkinChange", "", "view", StickerDataChangeType.UPDATE, "agreeView", "state", "Lcom/baidu/tieba/feed/component/uistate/SocialUiState;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialBarImpl implements c67.o {
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

    @Override // com.baidu.tieba.c67.s
    public void a(ViewGroup view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof SocialBarWrapper) {
                ((SocialBarWrapper) view2).onChangeSkinType();
            }
        }
    }

    public final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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

    @Override // com.baidu.tieba.c67.o
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
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

    @Override // com.baidu.tieba.c67.o
    public void update(ViewGroup agreeView, final z77 state) {
        Map<String, String> linkedHashMap;
        ThreadData threadData;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, agreeView, state) == null) {
            Intrinsics.checkNotNullParameter(agreeView, "agreeView");
            Intrinsics.checkNotNullParameter(state, "state");
            u97 h = state.h();
            final SocialBarWrapper socialBarWrapper = (SocialBarWrapper) agreeView;
            f87 f87Var = state.h().l;
            if (f87Var == null || (linkedHashMap = f87Var.a()) == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            Object obj = state.h().k;
            if (obj instanceof ThreadData) {
                threadData = (ThreadData) obj;
            } else {
                threadData = null;
            }
            if (threadData == null) {
                threadData = new ThreadData();
                threadData.setId(h.c);
                threadData.setFid(h.d);
                threadData.setTid(h.c);
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
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(mediaData);
                threadData.setMedias(arrayList);
                if (threadData.isShareThread) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    originalThreadInfo.f = linkedHashMap.get("origin_thread_id");
                    String str = linkedHashMap.get("origin_thread_type");
                    if (str == null) {
                        str = "";
                    }
                    originalThreadInfo.a = b(str);
                    originalThreadInfo.b = linkedHashMap.get("origin_thread_show_text");
                    originalThreadInfo.c = linkedHashMap.get("origin_thread_show_pic");
                    threadData.originalThreadData = originalThreadInfo;
                }
                threadData.isTiebaPlusAdThread = Intrinsics.areEqual(linkedHashMap.get("is_tie_plus_ad_thread"), "1");
                threadData.tiebaPlusOrderId = linkedHashMap.get("tie_plus_order_id");
                threadData.tiebaPlusToken = linkedHashMap.get("tie_plus_token");
                threadData.tiebaPlusExtraParam = linkedHashMap.get("tie_plus_extra_param");
                threadData.statFloor = state.g() + 1;
                state.h().k = threadData;
                AgreeData agreeData = threadData.getAgreeData();
                agreeData.agreeType = h.e;
                agreeData.hasAgree = h.f;
                agreeData.diffAgreeNum = h.h;
                agreeData.disAgreeNum = h.i;
                threadData.setAgreeNum(h.g);
                agreeData.threadId = h.c;
                threadData.setShareNum(h.a);
                threadData.setReply_num((int) h.b);
            }
            socialBarWrapper.setNeedAddReplyIcon(true);
            int i2 = JavaTypesHelper.toInt(linkedHashMap.get("feed_social_source"), 0);
            if (i2 != 0) {
                if (i2 == 1) {
                    socialBarWrapper.setFrom(1);
                    socialBarWrapper.setShareReportFrom(3);
                    h15 h15Var = new h15();
                    h15Var.b = 1;
                    h15Var.c = 1;
                    socialBarWrapper.setAgreeStatisticData(h15Var);
                }
            } else {
                socialBarWrapper.setFrom(9);
                socialBarWrapper.setShareReportFrom(4);
                h15 h15Var2 = new h15();
                h15Var2.b = 9;
                h15Var2.c = 1;
                socialBarWrapper.setAgreeStatisticData(h15Var2);
            }
            socialBarWrapper.setData(threadData);
            socialBarWrapper.setShowFlag(43);
            socialBarWrapper.setOnShareClick(new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z77 $state;

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
                        this.$state.k().invoke(this.$state.h());
                    }
                }
            });
            socialBarWrapper.setOnCommentClick(new Function0<Unit>(state, socialBarWrapper) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z77 $state;
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
                        Function3<Context, u97, List<w97>, Unit> i3 = this.$state.i();
                        Context context = this.$v.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "v.context");
                        i3.invoke(context, this.$state.h(), this.$state.l());
                    }
                }
            });
            socialBarWrapper.setAfterPraiseClick(new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z77 $state;

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
                        this.$state.j().invoke(this.$state.h());
                    }
                }
            });
            socialBarWrapper.setOnAgreeNumUpdateListener(new Function2<Long, Boolean, Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ z77 $state;

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

                public final void invoke(long j, boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z3)}) == null) && this.$state.h().j.f()) {
                        this.$state.h().j.g(j);
                        this.$state.h().j.h(z3);
                    }
                }
            });
            socialBarWrapper.onChangeSkinType();
        }
    }
}
