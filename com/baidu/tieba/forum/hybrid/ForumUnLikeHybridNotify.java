package com.baidu.tieba.forum.hybrid;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.fra;
import com.baidu.tieba.gu4;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
@Service
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/ForumUnLikeHybridNotify;", "Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "()V", "getKey", "", "onNotify", "", "data", "startUnlikeForum", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumUnLikeHybridNotify implements gu4.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-423032708, "Lcom/baidu/tieba/forum/hybrid/ForumUnLikeHybridNotify;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-423032708, "Lcom/baidu/tieba/forum/hybrid/ForumUnLikeHybridNotify;");
        }
    }

    @Override // com.baidu.tieba.gu4.d
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "frsPage.doUnlikeForum" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements fra.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.fra.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        @Override // com.baidu.tieba.fra.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            }
        }

        public a() {
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
    }

    public ForumUnLikeHybridNotify() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.gu4.c
    public void a(String data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    c(data);
                }
            } catch (Exception e) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("NativedoUnlikeForumHybridNotify", "取消关注失败" + e);
            }
        }
    }

    public final void c(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.LongRef longRef = new Ref.LongRef();
            JSONKt.a(str, new Function1<JSONObject, Unit>(longRef, objectRef) { // from class: com.baidu.tieba.forum.hybrid.ForumUnLikeHybridNotify$startUnlikeForum$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Ref.LongRef $forumId;
                public final /* synthetic */ Ref.ObjectRef<String> $forumName;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {longRef, objectRef};
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
                    this.$forumId = longRef;
                    this.$forumName = objectRef;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, java.lang.String] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(JSONObject it) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.$forumId.element = JavaTypesHelper.toLong(it.optString("fid"), 0L);
                        Ref.ObjectRef<String> objectRef2 = this.$forumName;
                        ?? optString = it.optString("fname");
                        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"fname\")");
                        objectRef2.element = optString;
                    }
                }
            });
            CharSequence charSequence = (CharSequence) objectRef.element;
            if (charSequence != null && !StringsKt__StringsJVMKt.isBlank(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (!z && longRef.element != 0) {
                fra fraVar = new fra();
                fraVar.b(new a());
                fraVar.c((String) objectRef.element, longRef.element);
                return;
            }
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.e("NativedoUnlikeForumHybridNotify", "取消关注失败，forumName=" + ((String) objectRef.element) + " forumId=" + longRef.element);
        }
    }
}
