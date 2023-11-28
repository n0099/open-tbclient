package com.baidu.tieba.forum.hybrid.manager;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.forum.hybrid.manager.BizBase$makeWrapListener$1;
import com.baidu.tieba.ki7;
import com.baidu.tieba.lk7;
import com.baidu.tieba.mk7;
import com.baidu.tieba.nj6;
import com.baidu.tieba.ok7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020\u00160\u001aJ\b\u0010'\u001a\u00020\u0016H\u0016J\u0015\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020$H\u0016J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rRA\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u0019\u001a \u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u001a\u0012\u0004\u0012\u00020\u001b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Biz;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "bottomData", "Lcom/baidu/tieba/forum/data/BottomData;", "getBottomData", "()Lcom/baidu/tieba/forum/data/BottomData;", "setBottomData", "(Lcom/baidu/tieba/forum/data/BottomData;)V", "dispatchToH5", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lorg/json/JSONObject;", "r", "", "getDispatchToH5", "()Lkotlin/jvm/functions/Function2;", "makeWrapListener", "Lkotlin/Function1;", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "getMakeWrapListener", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "getWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "makeCodeHandler", "Lcom/baidu/tieba/forum/hybrid/manager/SimpleRequestCodeHandler;", "code", "", "onResult", "Landroid/content/Intent;", "onDataUpdate", "requestCodeHandlers", "", "Lcom/baidu/tieba/forum/hybrid/manager/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/forum/hybrid/manager/ActivityRequestCodeHandler;", PopItemMethodConstant.showToast, "resourceId", "toast", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BizBase implements mk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final TbWebView b;
    public ki7 c;
    public final Function2<String, Function1<? super String, Unit>, WrapListener> d;
    public final Function2<String, JSONObject, Unit> e;

    @Override // com.baidu.tieba.mk7
    public lk7[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (lk7[]) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* JADX DEBUG: Type inference failed for r6v1. Raw type applied. Possible types: kotlin.jvm.functions.Function2<java.lang.String, kotlin.jvm.functions.Function1<? super java.lang.String, ? extends kotlin.Unit>, com.baidu.tieba.forum.hybrid.manager.BizBase$makeWrapListener$1$a>, kotlin.jvm.functions.Function2<java.lang.String, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, com.baidu.tieba.forum.hybrid.manager.WrapListener> */
    public BizBase(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.a = pageContext;
        this.b = webView;
        this.d = new Function2<String, Function1<? super String, ? extends Unit>, BizBase$makeWrapListener$1.a>(this) { // from class: com.baidu.tieba.forum.hybrid.manager.BizBase$makeWrapListener$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BizBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes6.dex */
            public static final class a extends WrapListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1<String, Unit> c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(String str, Function1<? super String, Unit> function1, TbWebView tbWebView) {
                    super(str, tbWebView);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, function1, tbWebView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (TbWebView) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = function1;
                }

                @Override // com.baidu.tieba.iu4.c
                public void a(String data) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        this.c.invoke(data);
                    }
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final a invoke2(String key, Function1<? super String, Unit> notify) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, key, notify)) == null) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(notify, "notify");
                    return new a(key, notify, this.this$0.g());
                }
                return (a) invokeLL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ a invoke(String str, Function1<? super String, ? extends Unit> function1) {
                return invoke2(str, (Function1<? super String, Unit>) function1);
            }
        };
        this.e = new Function2<String, JSONObject, Unit>(this) { // from class: com.baidu.tieba.forum.hybrid.manager.BizBase$dispatchToH5$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BizBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, JSONObject jSONObject) {
                invoke2(str, jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String e, JSONObject r) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e, r) == null) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    Intrinsics.checkNotNullParameter(r, "r");
                    nj6.a().i(this.this$0.g(), e, r);
                }
            }
        };
    }

    public final ki7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ki7) invokeV.objValue;
    }

    public final Function2<String, JSONObject, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<String, Function1<? super String, Unit>, WrapListener> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Function2) invokeV.objValue;
    }

    public final TbPageContext<BaseFragmentActivity> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final TbWebView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final ok7 h(int i, final Function1<? super Intent, Unit> onResult) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, onResult)) == null) {
            Intrinsics.checkNotNullParameter(onResult, "onResult");
            return new ok7(new Integer[]{Integer.valueOf(i)}, new Function2<Integer, Intent, Unit>(onResult) { // from class: com.baidu.tieba.forum.hybrid.manager.BizBase$makeCodeHandler$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1<Intent, Unit> $onResult;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onResult = onResult;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Intent intent) {
                    invoke(num.intValue(), intent);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, intent) == null) {
                        this.$onResult.invoke(intent);
                    }
                }
            });
        }
        return (ok7) invokeIL.objValue;
    }

    public final void j(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ki7Var) == null) {
            this.c = ki7Var;
        }
    }
}
