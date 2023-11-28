package com.baidu.tieba.forum.secondfloor;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.fm7;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.view.BottomWebView;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.tieba.hi7;
import com.baidu.tieba.ii7;
import com.baidu.tieba.iu4;
import com.baidu.tieba.ji7;
import com.baidu.tieba.jm7;
import com.baidu.tieba.ni7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/tieba/forum/secondfloor/AISecondFloorHybridBiz;", "Lcom/baidu/tieba/forum/secondfloor/ISecondFloorBiz;", "Lcom/baidu/tieba/forum/data/AiSecondFloorData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "binding", "Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;", "secondFloorController", "Lcom/baidu/tieba/forum/secondfloor/SecondFloorController;", "(Landroidx/fragment/app/FragmentActivity;Lcom/baidu/tieba/forum/databinding/ActivityForumBinding;Lcom/baidu/tieba/forum/secondfloor/SecondFloorController;)V", "expandSecondFloorHybridListener", "com/baidu/tieba/forum/secondfloor/AISecondFloorHybridBiz$expandSecondFloorHybridListener$1", "Lcom/baidu/tieba/forum/secondfloor/AISecondFloorHybridBiz$expandSecondFloorHybridListener$1;", "onDataAvailable", "", "data", "onViewAttached", "onViewDetached", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AISecondFloorHybridBiz implements fm7<ji7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity a;
    public final ActivityForumBinding b;
    public final jm7<ji7> c;
    public final AISecondFloorHybridBiz$expandSecondFloorHybridListener$1 d;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fm7
    /* renamed from: g */
    public void b(ji7 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.baidu.tieba.forum.secondfloor.AISecondFloorHybridBiz$expandSecondFloorHybridListener$1] */
    public AISecondFloorHybridBiz(FragmentActivity activity, ActivityForumBinding binding, jm7<ji7> secondFloorController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, binding, secondFloorController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(secondFloorController, "secondFloorController");
        this.a = activity;
        this.b = binding;
        this.c = secondFloorController;
        this.d = new iu4.e(this) { // from class: com.baidu.tieba.forum.secondfloor.AISecondFloorHybridBiz$expandSecondFloorHybridListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AISecondFloorHybridBiz a;

            @Override // com.baidu.tieba.iu4.d
            public String getKey() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? "frsPage.expandSecondFloor" : (String) invokeV.objValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.iu4.c
            public void a(String data) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, data) == null) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    final AISecondFloorHybridBiz aISecondFloorHybridBiz = this.a;
                    JSONKt.a(data, new Function1<JSONObject, Unit>(aISecondFloorHybridBiz) { // from class: com.baidu.tieba.forum.secondfloor.AISecondFloorHybridBiz$expandSecondFloorHybridListener$1$onNotify$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AISecondFloorHybridBiz this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {aISecondFloorHybridBiz};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super(((Integer) newInitContext2.callArgs[0]).intValue());
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = aISecondFloorHybridBiz;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                            invoke2(jSONObject);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(JSONObject it) {
                            FragmentActivity fragmentActivity;
                            ii7 a;
                            jm7 jm7Var;
                            jm7 jm7Var2;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                String botUk = it.optString("bot_uk");
                                String optString = it.optString("bot_pa");
                                String optString2 = it.optString("bot_background_url");
                                if (!TextUtils.isEmpty(botUk) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                    fragmentActivity = this.this$0.a;
                                    ni7 value = ((ForumViewModel) new ViewModelProvider(fragmentActivity).get(ForumViewModel.class)).c().getValue();
                                    if (value == null || (a = value.a()) == null) {
                                        return;
                                    }
                                    Intrinsics.checkNotNullExpressionValue(botUk, "botUk");
                                    a.h(new hi7(botUk, JavaTypesHelper.toLong(optString, 0L), "", "", optString2));
                                    ji7 i3 = a.i();
                                    if (i3 != null) {
                                        AISecondFloorHybridBiz aISecondFloorHybridBiz2 = this.this$0;
                                        jm7Var = aISecondFloorHybridBiz2.c;
                                        jm7Var.t(i3);
                                        jm7Var2 = aISecondFloorHybridBiz2.c;
                                        jm7Var2.f();
                                    }
                                }
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.iu4.e
            /* renamed from: c */
            public BottomWebView b() {
                InterceptResult invokeV;
                ActivityForumBinding activityForumBinding;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    activityForumBinding = this.a.b;
                    BottomWebView bottomWebView = activityForumBinding.d;
                    Intrinsics.checkNotNullExpressionValue(bottomWebView, "binding.bottomWeb");
                    return bottomWebView;
                }
                return (BottomWebView) invokeV.objValue;
            }
        };
    }

    @Override // com.baidu.tieba.fm7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            iu4.b.a().e(this.d);
        }
    }

    @Override // com.baidu.tieba.fm7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            iu4.b.a().c(this.d);
        }
    }
}
