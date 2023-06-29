package com.baidu.tieba.compact;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.d57;
import com.baidu.tieba.i57;
import com.baidu.tieba.l67;
import com.baidu.tieba.m67;
import com.baidu.tieba.r15;
import com.baidu.tieba.s37;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VideoInfo;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/compact/SocialBarImpl;", "Lcom/baidu/tieba/feed/compat/Resolver$ISocialBar;", "()V", "from", "", "getFrom", "()I", "create", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "getShareThreadShowType", "threadType", "", "onSkinChange", "", "view", StickerDataChangeType.UPDATE, "agreeView", "state", "Lcom/baidu/tieba/feed/component/uistate/SocialUiState;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialBarImpl implements s37.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

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

    @Override // com.baidu.tieba.s37.l
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

    @Override // com.baidu.tieba.s37.j
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            SocialBarWrapper socialBarWrapper = new SocialBarWrapper(context);
            socialBarWrapper.setNeedMatchStrategy(true);
            socialBarWrapper.setUseDynamicLikeRes();
            return socialBarWrapper;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s37.j
    public void update(ViewGroup agreeView, final d57 state) {
        ThreadData threadData;
        Map<String, String> map;
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, agreeView, state) == null) {
            Intrinsics.checkNotNullParameter(agreeView, "agreeView");
            Intrinsics.checkNotNullParameter(state, "state");
            l67 a = state.a();
            final SocialBarWrapper socialBarWrapper = (SocialBarWrapper) agreeView;
            Object obj = state.a().k;
            String str10 = null;
            if (obj instanceof ThreadData) {
                threadData = (ThreadData) obj;
            } else {
                threadData = null;
            }
            if (threadData == null) {
                threadData = new ThreadData();
                threadData.setId(a.c);
                threadData.setFid(a.d);
                threadData.setTid(a.c);
                i57 i57Var = state.a().l;
                if (i57Var != null) {
                    map = i57Var.a();
                } else {
                    map = null;
                }
                if (map != null) {
                    str = map.get("thread_type");
                } else {
                    str = null;
                }
                boolean z2 = false;
                int e = vg.e(str, 0);
                threadData.setThreadType(e);
                if (e == 40) {
                    threadData.setVideoInfo(new VideoInfo.Builder().build(true));
                }
                if (map != null) {
                    str2 = map.get(IMUserExtraData.KEY_IS_GOD);
                } else {
                    str2 = null;
                }
                threadData.setIs_good(vg.e(str2, 0));
                if (map != null) {
                    str3 = map.get(VideoPlayActivityConfig.IS_SHARE_THREAD);
                } else {
                    str3 = null;
                }
                if (vg.e(str3, 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                threadData.isShareThread = z;
                if (map != null) {
                    str4 = map.get("has_item");
                } else {
                    str4 = null;
                }
                if (vg.e(str4, 0) == 1) {
                    z2 = true;
                }
                threadData.hasItem = z2;
                if (map != null) {
                    str5 = map.get("title");
                } else {
                    str5 = null;
                }
                threadData.setTitle(str5);
                if (map != null) {
                    str6 = map.get("abstract");
                } else {
                    str6 = null;
                }
                threadData.setAbstract(str6);
                MediaData mediaData = new MediaData();
                if (map != null) {
                    str7 = map.get("thread_show_pic");
                } else {
                    str7 = null;
                }
                mediaData.small_pic_url = str7;
                ArrayList<MediaData> arrayList = new ArrayList<>();
                arrayList.add(mediaData);
                threadData.setMedias(arrayList);
                if (threadData.isShareThread) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    if (map != null) {
                        str8 = map.get("origin_thread_id");
                    } else {
                        str8 = null;
                    }
                    originalThreadInfo.f = str8;
                    originalThreadInfo.a = b((map == null || (r6 = map.get("origin_thread_type")) == null) ? "" : "");
                    if (map != null) {
                        str9 = map.get("origin_thread_show_text");
                    } else {
                        str9 = null;
                    }
                    originalThreadInfo.b = str9;
                    if (map != null) {
                        str10 = map.get("origin_thread_show_pic");
                    }
                    originalThreadInfo.c = str10;
                    threadData.originalThreadData = originalThreadInfo;
                }
                state.a().k = threadData;
                AgreeData agreeData = threadData.getAgreeData();
                agreeData.agreeType = a.e;
                agreeData.hasAgree = a.f;
                agreeData.diffAgreeNum = a.h;
                agreeData.disAgreeNum = a.i;
                threadData.setAgreeNum(a.g);
                agreeData.threadId = a.c;
                threadData.setShareNum(a.a);
                threadData.setReply_num((int) a.b);
            }
            socialBarWrapper.setNeedAddReplyIcon(true);
            if (this.a == 0) {
                socialBarWrapper.setFrom(9);
                socialBarWrapper.setShareReportFrom(4);
                r15 r15Var = new r15();
                r15Var.b = 9;
                r15Var.c = 1;
                socialBarWrapper.setAgreeStatisticData(r15Var);
            }
            socialBarWrapper.setData(threadData);
            socialBarWrapper.setShowFlag(43);
            socialBarWrapper.setOnShareClick(new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d57 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        this.$state.d().invoke(this.$state.a());
                    }
                }
            });
            socialBarWrapper.setOnCommentClick(new Function0<Boolean>(state, socialBarWrapper) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d57 $state;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        Function3<Context, l67, m67, Boolean> b = this.$state.b();
                        Context context = this.$v.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "v.context");
                        return b.invoke(context, this.$state.a(), this.$state.e());
                    }
                    return (Boolean) invokeV.objValue;
                }
            });
            socialBarWrapper.setAfterPraiseClick(new Function0<Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d57 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        this.$state.c().invoke(this.$state.a());
                    }
                }
            });
            socialBarWrapper.setOnAgreeNumUpdateListener(new Function2<Long, Boolean, Unit>(state) { // from class: com.baidu.tieba.compact.SocialBarImpl$update$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d57 $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {state};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z3)}) == null) && this.$state.a().j.d()) {
                        this.$state.a().j.e(j);
                        this.$state.a().j.f(z3);
                    }
                }
            });
            socialBarWrapper.onChangeSkinType();
        }
    }
}
