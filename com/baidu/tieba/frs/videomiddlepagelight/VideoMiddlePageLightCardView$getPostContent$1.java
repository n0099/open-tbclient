package com.baidu.tieba.frs.videomiddlepagelight;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.d1.m.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"getAbstractContent", "", "abstractData", "Lcom/baidu/tbadk/core/data/AbstractData;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightCardView$getPostContent$1 extends Lambda implements Function1<AbstractData, String> {
    public static /* synthetic */ Interceptable $ic;
    public static final VideoMiddlePageLightCardView$getPostContent$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1196812949, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView$getPostContent$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1196812949, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView$getPostContent$1;");
                return;
            }
        }
        INSTANCE = new VideoMiddlePageLightCardView$getPostContent$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageLightCardView$getPostContent$1() {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(AbstractData abstractData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractData)) == null) {
            int g2 = e.g(abstractData.type);
            if (g2 != 4) {
                if (g2 == 8) {
                    return "[图片]";
                }
                if (g2 != 17 && g2 != 20) {
                    String str = abstractData.text;
                    if (str == null) {
                        str = "";
                    }
                    return String.valueOf(str);
                }
            }
            return "[表情]";
        }
        return (String) invokeL.objValue;
    }
}
